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
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class RSVAnvilRecipe implements Recipe {

    private String name;
    private ItemStack result;
    private ItemStack leftIng;
    private ItemStack rightIng;
    private int repairCost;
    private int maxRepairCost;

    public RSVAnvilRecipe(FileConfiguration config, String name) {
        this.name = name;

        String resultName = config.getString(name + ".Result.Item");
        int resultAmount = config.getInt(name + ".Result.Amount");

        String leftName = config.getString(name + ".LeftIngredient.Item");
        int leftAmount = config.getInt(name + ".LeftIngredient.Amount");

        String rightName = config.getString(name + ".RightIngredient.Item");
        int rightAmount = config.getInt(name + ".RightIngredient.Amount");

        result = RSVItem.isRSVItem(name) ? RSVItem.getItem(resultName).resize(resultAmount) : new ItemStack(Material.valueOf(resultName), resultAmount);
        leftIng =  RSVItem.isRSVItem(name) ? RSVItem.getItem(leftName).resize(leftAmount) : new ItemStack(Material.valueOf(leftName), leftAmount);
        rightIng =  RSVItem.isRSVItem(name) ? RSVItem.getItem(rightName).resize(rightAmount) : new ItemStack(Material.valueOf(rightName), rightAmount);

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
                if (firstMeta.equals(leftIng.getItemMeta()) && secondMeta.equals(rightIng.getItemMeta())) {
                    return true;
                }
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
