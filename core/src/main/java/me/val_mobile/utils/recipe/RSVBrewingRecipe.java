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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

public class RSVBrewingRecipe implements Recipe {

    private final RealisticSurvivalPlugin plugin;
    protected final ItemStack result;
    protected final ItemStack potion;
    protected final ItemStack ingredient;
    protected final ItemStack fuel;

    protected final int fuelPower;
    protected final int fuelCharge;

    protected final String name;
    protected BrewClock clock;
    protected final int duration;
    protected final boolean perfect;

    public RSVBrewingRecipe(RealisticSurvivalPlugin plugin, FileConfiguration config, String name) {
        this.name = name;

        this.fuelPower = config.getInt(name + ".FuelPower");
        this.fuelCharge = config.getInt(name + ".FuelCharge");
        this.perfect = config.getBoolean(name + ".Perfect");

        this.ingredient = RSVRecipe.getItem(config, name + ".Ingredient");
        this.fuel = RSVRecipe.getItem(config, name + ".Fuel");
        this.potion = RSVRecipe.getItem(config,name + ".Potion");
        this.result = RSVRecipe.getResult(config, name);

        this.duration = config.getInt(name + ".Duration");
        this.plugin = plugin;
    }

    public ItemStack getIngredient() {
        return ingredient;
    }

    public ItemStack getPotion() {
        return potion;
    }

    public ItemStack getFuel() {
        return fuel;
    }

    public String getName() {
        return name;
    }

    public BrewClock getClock() {
        return clock;
    }

    public int getDuration() {
        return duration;
    }

    public void setClock(BrewClock clock) {
        this.clock = clock;
    }


    public boolean isValidRecipe(BrewerInventory inv) {
        ItemStack invFuel = inv.getFuel();
        ItemStack invIng = inv.getIngredient();

        if (Utils.isItemReal(invFuel) && Utils.isItemReal(invIng)) {
            return invFuel.isSimilar(fuel) && invIng.isSimilar(ingredient);
        }
        return false;
    }

    public void startBrewing(BrewerInventory inventory) {
        clock = new BrewClock(plugin, this, inventory, duration);
    }

    public int getFuelPower() {
        return fuelPower;
    }

    public int getFuelCharge() {
        return fuelCharge;
    }

    @Override
    public @NotNull ItemStack getResult() {
        return result;
    }
}
