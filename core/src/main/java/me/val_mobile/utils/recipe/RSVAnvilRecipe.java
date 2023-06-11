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
package me.val_mobile.utils.recipe;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RSVAnvilRecipe implements Recipe {

    private final String name;
    private final ItemStack result;
    private final ItemStack leftIng;
    private final ItemStack rightIng;
    private final int repairCost;
    private final int maxRepairCost;

    public RSVAnvilRecipe(FileConfiguration config, String name) {
        this.name = name;

        this.result = RSVRecipe.getResult(config, name);
        leftIng =  RSVRecipe.getItem(config, name + ".LeftIngredient.Item", name + ".LeftIngredient.Amount");
        rightIng = RSVRecipe.getItem(config, name + ".RightIngredient.Item", name + ".RightIngredient.Amount");

        this.repairCost = config.getInt(name + ".RepairCost");
        this.maxRepairCost = config.getInt(name + ".MaximumRepairCost");
    }

    public String getName() {
        return name;
    }

    public ItemStack getResult() {
        return result;
    }

    public ItemStack getLeftIngredient() {
        return leftIng;
    }

    public ItemStack getRightIngredient() {
        return rightIng;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public int getMaxRepairCost() {
        return maxRepairCost;
    }

    public boolean isValidRecipe(AnvilInventory inv) {
        ItemStack firstItem = inv.getItem(0);
        ItemStack secondItem = inv.getItem(1);

        if (firstItem != null && secondItem != null) {
            ItemMeta firstMeta = firstItem.getItemMeta();
            ItemMeta secondMeta = secondItem.getItemMeta();

            if (firstMeta != null && secondMeta != null) {
                return firstMeta.equals(leftIng.getItemMeta()) && secondMeta.equals(rightIng.getItemMeta());
            }
        }
        return false;
    }

    public void useRecipe(PrepareAnvilEvent e) {
        AnvilInventory inv = e.getInventory();

        e.setResult(result);
        inv.setRepairCost(repairCost);
        inv.setMaximumRepairCost(maxRepairCost);
    }
}
