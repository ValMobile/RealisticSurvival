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
import org.bukkit.Tag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RSVShapelessRecipe extends ShapelessRecipe {

    private final Collection<Object> ingredients = new ArrayList<>();

    public RSVShapelessRecipe(FileConfiguration config, String name, RealisticSurvivalPlugin plugin) {
        super(new NamespacedKey(plugin, name),
                Objects.equals(config.getString(name + ".Result.Item"), config.getString(name + ".Result.Item").toUpperCase())
                        ? new ItemStack(Material.valueOf(config.getString(name + ".Result.Item")), config.getInt(name + ".Result.Amount")) :
                        RSVItem.getItem(config.getString(name + ".Result.Item")).resize(config.getInt(name + ".Result.Amount")));

        String ingredientsPath = name + ".Ingredients";

        List<String> ingredients = config.getStringList(ingredientsPath);

        for (String text : ingredients) {
            this.ingredients.add(getItem(text));
        }

        for (Object item : this.ingredients) {
            if (item instanceof Material) {
                this.addIngredient((Material) item);
            }
            else if (item instanceof Tag) {
                this.addIngredient(new RecipeChoice.MaterialChoice((Tag) item));
            }
            else {
                this.addIngredient(new RecipeChoice.ExactChoice((ItemStack) item));
            }
        }
    }

    public Object getItem(String text) {
        if (text.isEmpty())
            return null;
        // text is a material
        if (text.contains("Tag.")) {
            return Utils.getTag(text.substring(4));
        }
        else if (Objects.equals(text, text.toUpperCase())) {
            return new ItemStack(Material.valueOf(text));
        }
        // text is an item
        if (RSVItem.getItemMap().containsKey(text))
            return RSVItem.getItem(text);
        return null;
    }
}
