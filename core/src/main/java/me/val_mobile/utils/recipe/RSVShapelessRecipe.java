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
import me.val_mobile.utils.Ingredient;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ShapelessRecipe;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;

public class RSVShapelessRecipe extends ShapelessRecipe implements RSVRecipe {

    public RSVShapelessRecipe(@Nonnull FileConfiguration config, @Nonnull String name, @Nonnull RealisticSurvivalPlugin plugin) {
        super(new NamespacedKey(plugin, name), RSVRecipe.getResult(config, name));

        String ingredientsPath = name + ".Ingredients";

        Collection<RecipeIngredient> ingredients = new ArrayList<>();

        for (String text : config.getStringList(ingredientsPath)) {
            if (Ingredient.isValid(text)) {
                ingredients.add(new RecipeIngredient(text));
            }
        }

        ingredients.forEach(ing -> this.addIngredient(ing.getRecipeChoice()));
    }
}
