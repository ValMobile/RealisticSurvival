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

public class ObfuscatedFields_v1_21_R4 {
    // corresponds to net.minecraft.core.MappedRegistry#frozen
    public static final String FROZEN_SYMBOL = "l";
    
    // corresponds to net.minecraft.core.MappedRegistry#unregisteredIntrusiveHolders
    public static final String INTRUSIVE_HOLDER_CACHE_SYMBOL = "m";

    // corresponds to net.minecraft.core.MappedRegistry#allTags
    public static final String ALL_TAGS_SYMBOL = "k";

    // corresponds to net.minecraft.core.MappedRegistry$TagSet
    public static final String TAGSET_SYMBOL_OBFUSCATED = "net.minecraft.core.RegistryMaterials$a";

    // corresponds to net.minecraft.core.MappedRegistry$TagSet
    public static final String TAGSET_SYMBOL_UNOBFUSCATED = "net.minecraft.core.MappedRegistry$TagSet";

    private ObfuscatedFields_v1_21_R4() {};
}
