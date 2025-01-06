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
import org.bukkit.Tag;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class TagUtils {

    private static TagUtils instance;
    private final Map<String, Tag<Material>> map;

    public TagUtils(Class<?> clazz) {
        map = getStaticTagMaterialFields(clazz);
    }

    @Nonnull
    public static Map<String, Tag<Material>> getStaticTagMaterialFields(@Nonnull Class<?> clazz) {
        Map<String, Tag<Material>> tagMaterialMap = new HashMap<>();

        try {
            // Get all public fields of the class
            Field[] fields = clazz.getFields();

            for (Field field : fields) {
                // Check if the field is static
                if ((field.getModifiers() & java.lang.reflect.Modifier.STATIC) != 0) {
                    // Check if the field is of type Tag<Material>
                    if (field.getGenericType() instanceof ParameterizedType parameterizedType) {
                        if (parameterizedType.getRawType().equals(Tag.class) &&
                                parameterizedType.getActualTypeArguments()[0].equals(Material.class)) {
                            // Add the field name and its value to the map
                            Object value = field.get(null); // null because it's a static field
                            if (value instanceof Tag) {
                                tagMaterialMap.put(field.getName(), (Tag<Material>) value);
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {}

        return tagMaterialMap;
    }

    public static Tag<Material> getTag(Class<?> clazz, String name) {
        return getInstance(clazz).map.get(name);
    }

    public static TagUtils getInstance(Class<?> clazz) {
        if (instance == null) {
            instance = new TagUtils(clazz);
        }

        return instance;
    }
}
