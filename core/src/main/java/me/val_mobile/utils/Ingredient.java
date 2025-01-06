/*
    Copyright (C) 2025  Val_Mobile

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
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class Ingredient {

    private final List<RSVItem> items = new ArrayList<>();
    private final Set<Material> materials = new HashSet<>();

    public Ingredient(@Nonnull String raw) {
        if (!raw.isEmpty()) {
            if (raw.matches("^\\(([a-zA-Z_,]+)\\)$")) {
                raw = raw.substring(1, raw.length() - 1);
                String[] entries = raw.split( ",");

                for (String s : entries) {
                    IngredientType type = parseIngredientType(s);

                    if (type == null) {
                        throw new IllegalArgumentException("Could not parse string " + s + " valid ingredient.");
                    }
                    else {
                        switch (type) {
                            case ITEM -> items.add(RSVItem.getItem(s));
                            case MATERIAL -> materials.add(Material.valueOf(s));
                            case TAG -> materials.addAll(Utils.getTag(s.substring(4)).getValues());
                            default -> throw new IllegalArgumentException("Could not parse string into valid ingredient.");
                        }
                    }
                }
            }
            else {
                IngredientType type = parseIngredientType(raw);

                if (type == null) {
                    throw new IllegalArgumentException("Could not parse string " + raw + " into valid ingredient.");
                }
                else {
                    switch (type) {
                        case ITEM -> items.add(RSVItem.getItem(raw));
                        case MATERIAL -> materials.add(Material.valueOf(raw));
                        case TAG -> materials.addAll(Utils.getTag(raw.substring(4)).getValues());
                        default -> {}
                    }
                }

            }
        }
    }

    public static boolean isValid(@Nullable String raw) {
        if (raw == null || raw.isEmpty()) {
            return false;
        }

        if (raw.matches("^\\(([a-zA-Z_,]+)\\)$")) {
            raw = raw.substring(1, raw.length() - 1);
            String[] entries = raw.split( ",");

            for (String s : entries) {
                if (s.matches("^Tag\\.([A-Z]+)$")) {
                    if (Utils.getTag(s.substring(4)) == null) {
                        return false;
                    }
                }
                else if (!(Utils.isInEnum(s, Material.class) || RSVItem.isRSVItem(s))) {
                    return false;
                }
            }
            return true;
        }
        else {
            if (raw.matches("^Tag\\.([A-Z]+)$")) {
                return Utils.getTag(raw.substring(4)) != null;
            }
            else return Utils.isInEnum(raw, Material.class) || RSVItem.isRSVItem(raw);
        }
    }

    public List<RSVItem> getItems() {
        return items;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void add(@Nullable Collection<?> col) {
        if (!(col == null || col.isEmpty())) {
            for (Object obj : col) {
                if (obj instanceof Material mat) {
                    this.materials.add(mat);
                }
                else if (obj instanceof ItemStack item) {
                    if (RSVItem.isRSVItem(item)) {
                        this.items.add(RSVItem.getItem(RSVItem.getNameFromItem(item)));
                    }
                }
            }
        }
    }

    public void add(@Nullable Material material) {
        if (material != null) {
            materials.add(material);
        }
    }

    public void add(@Nullable ItemStack item) {
        if (RSVItem.isRSVItem(item)) {
            RSVItem rsvItem = RSVItem.getItem(RSVItem.getNameFromItem(item));
            items.add(rsvItem);
        }
    }

    public final boolean test(@Nullable Material material) {
        return materials.contains(material);
    }

    public final boolean test(@Nullable ItemStack item) {
        if (!Utils.isItemReal(item)) {
            return false;
        }

        if (RSVItem.isRSVItem(item)) {
            for (RSVItem i : items) {
                if (Utils.isItemReal(i) && Objects.equals(RSVItem.getNameFromItem(item), i.getName())) {
                    return true;
                }
            }
            return false;
        }
        return test(item.getType());
    }

    public final boolean test(@Nullable CraftingInventory inv) {
        if (inv == null) {
            return false;
        }

        for (RSVItem i : items) {
            if (Utils.isItemReal(i) && inv.contains(i)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public IngredientType parseIngredientType(@Nullable String raw) {
        if (raw == null || raw.isEmpty()) {
            return null;
        }

        if (raw.matches("^Tag\\.([A-Z]+)$") && Utils.getTag(raw.substring(4)) != null) {
            return IngredientType.TAG;
        }
        else if (Utils.isInEnum(raw, Material.class)) {
            return IngredientType.MATERIAL;
        }
        // text is an item
        else if (RSVItem.isRSVItem(raw)) {
            return IngredientType.ITEM;
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient ing) {
            return Objects.equals(this.getItems(), ing.getItems()) && Objects.equals(this.getMaterials(), ing.getMaterials());
        }
        return false;
    }

    public enum IngredientType {
        ITEM, MATERIAL, TAG
    }
}
