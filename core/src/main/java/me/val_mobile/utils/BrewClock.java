/*
    Copyright (C) 2023  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.utils;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Material;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class BrewClock extends BukkitRunnable {
    private final BrewerInventory inventory;
    private final RSVBrewingRecipe recipe;
    private final ItemStack[] before;
    private final BrewingStand stand;
    private int current;

    public BrewClock(RealisticSurvivalPlugin plugin, RSVBrewingRecipe recipe, BrewerInventory inventory, int time) {
        this.recipe = recipe;
        this.inventory = inventory;
        this.stand = inventory.getHolder();
        this.before = inventory.getContents();
        this.current = time;
        runTaskTimer(plugin, 0L, 1L);
    }

    @Override
    public void run() {
        if (current == 0) {
            // Set ingredient to 1 less than the current. Otherwise set to air
            if (inventory.getIngredient().getAmount() > 1) {
                ItemStack is = inventory.getIngredient();
                is.setAmount(inventory.getIngredient().getAmount() - 1);
                inventory.setIngredient(is);
            } else {
                inventory.setIngredient(new ItemStack(Material.AIR));
            }
            // Check the fuel in the recipe is more than 0, and exists
            ItemStack newFuel = recipe.getFuel();
            if (recipe.getFuel() != null && recipe.getFuel().getType() != Material.AIR &&
                    recipe.getFuel().getAmount() > 0) {
                /*
                 * We count how much fuel should be taken away in order to fill
                 * the whole fuel bar
                 */
                int count = 0;
                while (inventory.getFuel().getAmount() > 0 && stand.getFuelLevel() + recipe.fuelCharge < 100) {
                    stand.setFuelLevel(stand.getFuelLevel() + recipe.fuelPower);
                    count++;
                }
                // If the fuel in the inventory is 0, set it to air.
                if (inventory.getFuel().getAmount() == 0) {
                    newFuel = new ItemStack(Material.AIR);
                } else {
                    /* Otherwise, set the percent of fuel level to 100 and update the
                     *  count of the fuel
                     */
                    stand.setFuelLevel(100);
                    newFuel.setAmount(inventory.getFuel().getAmount() - count);
                }
            } else {
                newFuel = new ItemStack(Material.AIR);
            }
            inventory.setFuel(newFuel);
            // Brew recipe for each item put in
            for (int i = 0; i < 3; i++) {
                if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                    continue;
                }
                inventory.setItem(i, recipe.result);
            }
            // Set the fuel level
            stand.setFuelLevel(stand.getFuelLevel() - recipe.fuelCharge);
            cancel();
            return;
        }
        // If a player drags an item, fuel, or any contents, reset it
        if (searchChanged(before, inventory.getContents(), recipe.perfect)) {
            cancel();
            return;
        }
        // Decrement, set the brewing time, and update the stand
        current--;
        stand.setBrewingTime(current);
        stand.update(true);
    }

    // Check if any slots were changed
    public boolean searchChanged(ItemStack[] before, ItemStack[] after, boolean mode) {
        for (int i = 0; i < before.length; i++) {
            if ((before[i] != null && after[i] == null) || (before[i] == null && after[i] != null)) {
                return false;
            } else {
                if (mode && !before[i].isSimilar(after[i])) {
                    return false;
                } else if (!mode && !(before[i].getType() == after[i].getType())) {
                    return false;
                }
            }
        }
        return true;
    }
}
