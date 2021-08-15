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
import org.bukkit.Tag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.*;

public class ShapedRecipeBuilder extends ShapedRecipe {

    private final static List<Character> CHARS = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'));

    private HashMap<Character, Object> ingredients = new HashMap<>();

    public ShapedRecipeBuilder(FileConfiguration config, int index, RLCraftPlugin instance) {
        super(new NamespacedKey(instance, config.getString(index + ".Key")),
                ItemBuilder.getItem(ItemBuilder.getItemMap().get(config.getString(index + ".Result.Item"))).resize(config.getInt(index + ".Result.Amount")));

        String ingredientsPath = index + ".Ingredients";

        List<String> ingredients = config.getStringList(ingredientsPath);

        Object[][] grid = new Object[3][3];
        Character[][] chars;

        for (int i = 0; i < ingredients.size(); i++) {
            String raw = ingredients.get(i);
            Object[] items = getItems(raw);

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
        else {
            // grid is 2x2
            if (grid[0][1] != null || grid[1][0] != null || grid[1][1] != null) {
                chars = getChars(grid, 2);

                this.shape(chars[0][0].toString() + chars[0][1], chars[1][0].toString() + chars[1][1]);
            }
            // grid is 1x1
            else {
                chars = getChars(grid, 1);
                this.shape(chars[0][0].toString());
            }
        }

        for (Map.Entry<Character, Object> entry : this.ingredients.entrySet()) {
            if (entry.getValue() instanceof Material) {
                this.setIngredient(entry.getKey(), (Material) entry.getValue());
            }
            else if (entry.getValue() instanceof Tag) {
                this.setIngredient(entry.getKey(), new RecipeChoice.MaterialChoice((Tag) entry.getValue()));
            }
            else {
                this.setIngredient(entry.getKey(), new RecipeChoice.ExactChoice((ItemStack) entry.getValue()));
            }
        }
    }

    public ShapedRecipeBuilder(FileConfiguration config, int index, RLCraftPlugin instance, boolean result) {
        super(new NamespacedKey(instance, config.getString(index + ".Key")),
                new ItemStack(Material.valueOf(config.getString(index + ".Result.Item")),
                        config.getInt(index + ".Result.Amount")));

        String ingredientsPath = index + ".Ingredients";

        List<String> ingredients = config.getStringList(ingredientsPath);

        Object[][] grid = new Object[3][3];
        Character[][] chars;

        for (int i = 0; i < ingredients.size(); i++) {
            String raw = ingredients.get(i);
            Object[] items = getItems(raw);

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
        else {
            // grid is 2x2
            if (grid[0][1] != null || grid[1][0] != null || grid[1][1] != null) {
                chars = getChars(grid, 2);

                this.shape(chars[0][0].toString() + chars[0][1], chars[1][0].toString() + chars[1][1]);
            }
            // grid is 1x1
            else {
                chars = getChars(grid, 1);
                this.shape(chars[0][0].toString());
            }
        }

        for (Map.Entry<Character, Object> entry : this.ingredients.entrySet()) {
            if (entry.getValue() instanceof Material) {
                this.setIngredient(entry.getKey(), (Material) entry.getValue());
            }
            else if (entry.getValue() instanceof Tag) {
                this.setIngredient(entry.getKey(), new RecipeChoice.MaterialChoice((Tag) entry.getValue()));
            }
            else {
                this.setIngredient(entry.getKey(), new RecipeChoice.ExactChoice((ItemStack) entry.getValue()));
            }
        }
    }

    public Object[] getItems(String text) {
        Object[] items = new Object[3];

        int firstIndex = text.indexOf("|");
        int lastIndex = text.lastIndexOf("|");

        // one item
        if (firstIndex == -1) {
            items[0] = getItem(text);
        }
        else {
            // two items
            if (firstIndex == lastIndex) {
                if (firstIndex != 0) {
                    String firstItem = text.substring(0, firstIndex);

                    items[0] = getItem(firstItem);
                }
                String secondItem = text.substring(firstIndex + 1);

                items[1] = getItem(secondItem);

            }
            // three items
            else {
                if (firstIndex != 0) {
                    String firstItem = text.substring(0, firstIndex);

                    items[0] = getItem(firstItem);
                }
                String secondItem = text.substring(firstIndex + 1, lastIndex);
                String thirdItem = text.substring(lastIndex + 1);

                items[1] = getItem(secondItem);
                items[2] = getItem(thirdItem);
            }
        }
        return items;
    }

    public Character[][] getChars(Object[][] items, int dimension) {
        Character[][] characters = new Character[dimension][dimension];

        char buffer = 'A';

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (items[i][j] != null) {
                    if (!ingredients.containsValue(items[i][j])) {
                        ingredients.put(buffer, items[i][j]);
                        characters[i][j] = buffer;
                        buffer = CHARS.get(CHARS.indexOf(buffer) + 1);
                    }
                    else {
                        for (Map.Entry<Character, Object> entry : ingredients.entrySet()) {
                            if (Objects.equals(entry.getValue(), items[i][j])) {
                                characters[i][j] = entry.getKey();
                                break;
                            }
                        }
                    }
                }
                else {
                    characters[i][j] = ' ';
                }
            }
        }

        return characters;
    }

    public Object getItem(String text) {
        if (text.isEmpty())
            return null;
        // text is a material
        else if (Objects.equals(text, text.toUpperCase())) {
            if (Utils.getTags().containsKey(text))
                return Utils.getTags().get(text);
            return new ItemStack(Material.valueOf(text));
        }
        // text is an item
        if (ItemBuilder.getItemMap().get(text) != null)
            return ItemBuilder.getItem(ItemBuilder.getItemMap().get(text));
        return null;
    }
}