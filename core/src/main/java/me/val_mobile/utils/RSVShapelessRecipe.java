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

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RSVShapelessRecipe extends ShapelessRecipe implements RSVRecipe {

    public RSVShapelessRecipe(@Nonnull FileConfiguration config, @Nonnull String name, @Nonnull RealisticSurvivalPlugin plugin) {
        super(new NamespacedKey(plugin, name), RSVRecipe.getResult(config, name));

        String ingredientsPath = name + ".Ingredients";

        List<String> ingredients = config.getStringList(ingredientsPath);

        Collection<Object> ingredients1 = new ArrayList<>();
        for (String text : ingredients) {
            ingredients1.add(parseIngredient(text));
        }

        for (Object item : ingredients1) {
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
}
