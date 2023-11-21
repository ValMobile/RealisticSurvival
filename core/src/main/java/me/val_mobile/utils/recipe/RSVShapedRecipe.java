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

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.Ingredient;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ShapedRecipe;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RSVShapedRecipe extends ShapedRecipe implements RSVRecipe {

    private static final List<Character> CHARS = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I');

    private final Map<Character, RecipeIngredient> ingredients = new HashMap<>();

    public RSVShapedRecipe(@Nonnull FileConfiguration config, @Nonnull String name, @Nonnull RSVPlugin plugin) {
        super(new NamespacedKey(plugin, name), RSVRecipe.getResult(config, name));

        String ingredientsPath = name + ".Ingredients";

        List<String> ingredients = config.getStringList(ingredientsPath);

        RecipeIngredient[][] grid = new RecipeIngredient[3][3];
        Character[][] chars;

        for (int i = 0; i < ingredients.size(); i++) {
            String raw = ingredients.get(i);
            RecipeIngredient[] items = getItems(raw);

            for (int j = 0; j < items.length; j++) {
                if (items[j] != null) {
                    grid[i][j] = items[j];
                }
            }
        }

        // grid is 3x3
        if (grid[0][2] != null || grid[1][2] != null || grid[2][2] != null
                || grid[2][0] != null || grid[2][1] != null) {
            chars = getChars(grid, 3);

            this.shape(chars[0][0].toString() + chars[0][1] + chars[0][2], chars[1][0].toString() + chars[1][1] + chars[1][2], chars[2][0].toString() + chars[2][1] + chars[2][2]);
        }
        // grid is 2x2
        else if (grid[0][1] != null || grid[1][0] != null || grid[1][1] != null) {
            chars = getChars(grid, 2);

            this.shape(chars[0][0].toString() + chars[0][1], chars[1][0].toString() + chars[1][1]);
        }
        // grid is 1x1
        else {
            chars = getChars(grid, 1);
            this.shape(chars[0][0].toString());
        }

        for (Map.Entry<Character, RecipeIngredient> entry : this.ingredients.entrySet()) {
            this.setIngredient(entry.getKey(), entry.getValue().getRecipeChoice());
        }
    }

    public RecipeIngredient[] getItems(String text) {
        RecipeIngredient[] items = new RecipeIngredient[3];

        int firstIndex = text.indexOf("|");
        int lastIndex = text.lastIndexOf("|");

        // one item
        if (firstIndex == -1) {
            if (Ingredient.isValid(text))
                items[0] = new RecipeIngredient(text);
        }
        else {
            // two items
            if (firstIndex == lastIndex) {
                if (firstIndex != 0) {
                    String firstItem = text.substring(0, firstIndex);

                    if (Ingredient.isValid(firstItem))
                        items[0] = new RecipeIngredient(firstItem);
                }
                String secondItem = text.substring(firstIndex + 1);

                if (Ingredient.isValid(secondItem))
                    items[1] = new RecipeIngredient(secondItem);

            }
            // three items
            else {
                if (firstIndex != 0) {
                    String firstItem = text.substring(0, firstIndex);

                    if (Ingredient.isValid(firstItem))
                        items[0] = new RecipeIngredient(firstItem);
                }
                String secondItem = text.substring(firstIndex + 1, lastIndex);
                String thirdItem = text.substring(lastIndex + 1);

                if (Ingredient.isValid(secondItem))
                    items[1] = new RecipeIngredient(secondItem);

                if (Ingredient.isValid(thirdItem))
                    items[2] = new RecipeIngredient(thirdItem);
            }
        }
        return items;
    }

    public Character[][] getChars(RecipeIngredient[][] items, int len) {
        Character[][] characters = new Character[len][len];

        char buffer = 'A';

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (items[i][j] == null) {
                    characters[i][j] = ' ';
                }
                else {
                    if (ingredients.containsValue(items[i][j])) {
                        for (Map.Entry<Character, RecipeIngredient> entry : ingredients.entrySet()) {
                            if (Objects.equals(entry.getValue(), items[i][j])) {
                                characters[i][j] = entry.getKey();
                                break;
                            }
                        }

                    }
                    else {
                        ingredients.put(buffer, items[i][j]);
                        characters[i][j] = buffer;
                        buffer = CHARS.get(CHARS.indexOf(buffer) + 1);
                    }
                }
            }
        }

        return characters;
    }
}