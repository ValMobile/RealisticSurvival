/*
    Copyright (C) 2021  Val_Mobile

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

import me.val_mobile.rlcraft.RLCraftPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;

public class SmithingRecipeBuilder extends SmithingRecipe {

    public SmithingRecipeBuilder(FileConfiguration config, int index, RLCraftPlugin instance, boolean addition) {
        super(new NamespacedKey(instance, config.getString(index + ".Key")),
                ItemBuilder.getItem(ItemBuilder.getItemMap().get(config.getString(index + ".Result.Item"))).resize(config.getInt(index + ".Result.Amount")),
                new RecipeChoice.ExactChoice(ItemBuilder.getItem(ItemBuilder.getItemMap().get(config.getString(index + ".Base")))),
                new RecipeChoice.MaterialChoice(Material.valueOf(config.getString(index + ".Addition"))));
    }
}
