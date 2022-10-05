/*
    Copyright (C) 2022  Val_Mobile

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

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.scheduler.BukkitRunnable;

public class RSVBrewingRecipe implements Recipe {

    protected final ItemStack result;
    protected final ItemStack potion;
    protected final ItemStack ingredient;
    protected final ItemStack fuel;

    protected final int fuelPower;
    protected final int fuelCharge;

    protected final String name;
    protected final boolean perfect;
    protected BrewClock clock;
    protected final int duration;

    public RSVBrewingRecipe(FileConfiguration config, String name) {
        this.name = name;

        String resultName = config.getString(name + ".Result.Item");
        int resultAmount = config.getInt(name + ".Result.Amount");

        String potionPath = config.getString(name + ".Potion");
        String ingPath = config.getString(name + ".Ingredient");
        String fuelPath = config.getString(name + ".Fuel");

        this.fuelPower = config.getInt(name + ".FuelPower");
        this.fuelCharge = config.getInt(name + ".FuelCharge");
        this.perfect = config.getBoolean(name + ".Perfect");

        this.ingredient = RSVItem.isRSVItem(ingPath) ? RSVItem.getItem(ingPath) : new ItemStack(Material.valueOf(ingPath));
        this.fuel = RSVItem.isRSVItem(fuelPath) ? RSVItem.getItem(fuelPath) : new ItemStack(Material.valueOf(fuelPath));
        this.potion = RSVItem.isRSVItem(potionPath) ? RSVItem.getItem(potionPath) : new ItemStack(Material.valueOf(potionPath));
        this.result = RSVItem.isRSVItem(resultName) ? RSVItem.getItem(resultName).resize(resultAmount) : new ItemStack(Material.valueOf(resultName), resultAmount);

        this.duration = config.getInt(name + ".Duration");
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

    public boolean isPerfect() {
        return perfect;
    }

    public boolean isValidRecipe(BrewerInventory inv) {
        ItemStack invFuel = inv.getFuel();
        ItemStack invIng = inv.getIngredient();

        if (Utils.isItemReal(invFuel)) {
            if (!perfect && ingredient.getType() == invIng.getType()) {
                return true;
            }
            return perfect && ingredient.isSimilar(invIng);
        }
        else {
            if (!perfect && ingredient.getType() == invIng.getType() &&
                    fuel.getType() == invFuel.getType()) {
                return true;
            }
            return perfect && ingredient.isSimilar(invIng) && fuel.isSimilar(invFuel);
        }
    }

    public void startBrewing(BrewerInventory inventory) {
        clock = new BrewClock(this, inventory, duration);
    }

    public int getFuelPower() {
        return fuelPower;
    }

    public int getFuelCharge() {
        return fuelCharge;
    }

    @Override
    public ItemStack getResult() {
        return result;
    }

    public class BrewClock extends BukkitRunnable {

        public BrewClock(RSVBrewingRecipe recipe, BrewerInventory inventory, int time) {}

        @Override
        public void run() {}
    }
}
