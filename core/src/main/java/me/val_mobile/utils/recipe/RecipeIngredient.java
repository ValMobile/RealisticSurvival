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

import me.val_mobile.utils.Ingredient;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecipeIngredient extends Ingredient {

    public RecipeIngredient(@Nonnull String raw) {
        super(raw);
    }

    public @Nonnull RecipeChoice getRecipeChoice() {
        if (!getItems().isEmpty()) {
            List<ItemStack> items = new ArrayList<>(getItems());

            Set<Material> mats = getMaterials();

            mats.forEach(mat -> items.add(new ItemStack(mat)));

            return new RecipeChoice.ExactChoice(items);
        }
        return new RecipeChoice.MaterialChoice(getMaterials().toArray(new Material[0]));
    }
}
