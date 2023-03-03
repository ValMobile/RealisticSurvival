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
package me.val_mobile.utils;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface RSVRecipe {

    @Nullable
    static ItemStack getItem(@Nonnull FileConfiguration config, @Nonnull String namePath) {
        String itemName = config.getString(namePath);

        if (itemName.equals(itemName.toUpperCase())) {
            // material
            return new ItemStack(Material.valueOf(itemName));
        }
        else if (RSVItem.isRSVItem(itemName)) {
            // rsv item
            return RSVItem.getItem(itemName);
        }
        return null;
    }

    @Nullable
    static ItemStack getItem(@Nonnull FileConfiguration config, @Nonnull String namePath, @Nonnull String amountPath) {
        ItemStack item = getItem(config, namePath);

        if (item != null) {
            item.setAmount(config.getInt(amountPath));
            return item;
        }
        return null;
    }

    @Nullable
    static ItemStack getResult(@Nonnull FileConfiguration config, @Nonnull String name) {
        return getItem(config, name + ".Result.Item", name + ".Result.Amount");
    }

    @Nullable
    static RecipeChoice getRecipeChoice(@Nonnull String text) {
        Object obj = parseIng(text);

        if (obj != null) {
            return parseRecChoice(obj);
        }
        return null;
    }

    @Nullable
    private static Object parseIng(@Nonnull String text) {
        if (text.isEmpty())
            return null;
        if (text.contains("(") && text.contains(")")) {
            text = text.substring(1, text.indexOf(")"));
            String[] entries = text.split( ",");
            List<Object> items = new ArrayList<>();

            for (String s : entries) {
                if (s.contains("Tag.")) {
                    items.addAll(Utils.getTag(s.substring(4)).getValues());
                }
                else if (Objects.equals(s, s.toUpperCase())) {
                    items.add(Material.valueOf(s));
                }
                // text is an item
                else if (RSVItem.getItemMap().containsKey(s))
                    items.add(RSVItem.getItem(s));
            }
            return items;
        }
        else {
            if (text.contains("Tag.")) {
                return Utils.getTag(text.substring(4));
            }
            else if (Objects.equals(text, text.toUpperCase())) {
                return Material.valueOf(text);
            }
            // text is an item
            else if (RSVItem.getItemMap().containsKey(text))
                return RSVItem.getItem(text);
        }
        return null;
    }

    @Nullable
    static RecipeChoice parseRecChoice(@Nonnull Object obj) {
        if (obj instanceof List<?> list) {
            if (list.get(0) instanceof Material) {
                return new RecipeChoice.MaterialChoice((List<Material>) list);
            }
            else if (list.get(0) instanceof ItemStack) {
                return new RecipeChoice.ExactChoice((List<ItemStack>) list);
            }
        }
        else if (obj instanceof Material) {
            return new RecipeChoice.MaterialChoice((Material) obj);
        }
        else if (obj instanceof Tag) {
            return new RecipeChoice.MaterialChoice((Tag<Material>) obj);
        }
        else if (obj instanceof ItemStack) {
            return new RecipeChoice.ExactChoice((ItemStack) obj);
        }
        return null;
    }

    @Nullable
    default RecipeChoice parseRecipeChoice(@Nonnull Object obj) {
        return parseRecChoice(obj);
    }

    @Nullable
    default Object parseIngredient(@Nonnull String text) {
        return parseIng(text);
    }
}
