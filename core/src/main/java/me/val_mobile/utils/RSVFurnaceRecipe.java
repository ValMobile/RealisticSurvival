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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

import java.util.Objects;

public class RSVFurnaceRecipe extends FurnaceRecipe {

    public RSVFurnaceRecipe(FileConfiguration config, String name, RealisticSurvivalPlugin plugin) {
        super(new NamespacedKey(plugin, name),
                Objects.equals(config.getString(name + ".Result.Item"), config.getString(name + ".Result.Item").toUpperCase())
                        ? new ItemStack(Material.valueOf(config.getString(name + ".Result.Item")), config.getInt(name + ".Result.Amount")) :
                        RSVItem.getItem(config.getString(name + ".Result.Item")).resize(config.getInt(name + ".Result.Amount")),
                Objects.equals(config.getString(name + ".Input"), config.getString(name + ".Input").toUpperCase())
                        ? (config.getString(name + ".Input").contains("Tag.") ? new RecipeChoice.MaterialChoice(Utils.getTag(config.getString(name + ".Input"))) : new RecipeChoice.MaterialChoice(Material.valueOf(config.getString(name + ".Input"))))
                        : new RecipeChoice.ExactChoice(RSVItem.getItem(config.getString(name + ".Input"))),
                (float) config.getDouble(name + ".Experience"),
                config.getInt(name + ".CookingTime"));
    }
}
