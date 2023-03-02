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

import me.val_mobile.data.RSVModule;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.*;

public class RSVItem extends ItemStack {

    private static final String LOREPRESET = "LOREPRESET";

    private static final Map<String, RSVItem> itemMap = new HashMap<>();

    private final String name;
    private final String module;

    public RSVItem(FileConfiguration config, String name) {
        super(Material.valueOf(config.getString(name + ".Material")));

        this.name = name;
        this.module = null;

        String materialPath = name + ".Material";
        String displayNamePath = name + ".DisplayName";
        String customModelDataPath = name + ".CustomModelData";
        String lorePath = name + ".Lore";
        String itemFlagsPath = name + ".ItemFlags";
        String enchantmentsPath = name + ".Enchantments";
        String attributesPath = name + ".Attributes";
        String nbtTagsPath = name + ".NBTTags";

        Material material = Material.valueOf(config.getString(materialPath));
        String displayName = config.getString(displayNamePath);
        int customModelData = config.getInt(customModelDataPath);
        List<String> lore = config.getStringList(lorePath);
        List<String> itemFlags = config.getStringList(itemFlagsPath);
        ConfigurationSection enchantments = config.getConfigurationSection(enchantmentsPath);
        ConfigurationSection attributes = config.getConfigurationSection(attributesPath);
        ConfigurationSection nbtTags = config.getConfigurationSection(nbtTagsPath);

        ItemMeta meta = this.getItemMeta();
        List<String> newLore = new ArrayList<>();

        if (material == Material.POTION) {
            String colorPath = name + ".Color";
            String effectsPath = name + ".PotionType";

            if (config.getString(colorPath) != null) {
                Color color = Utils.valueOfColor(config.getString(colorPath));
                ((PotionMeta) meta).setColor(color);
            }
            if (config.getString(effectsPath) != null) {
                String effect = config.getString(effectsPath);
                PotionType potionType = PotionType.valueOf(effect);

                ((PotionMeta) meta).setBasePotionData(new PotionData(potionType));
            }
        }

        if (displayName != null) {
            meta.setDisplayName(Utils.translateMsg(displayName));
        }

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                newLore.add(Utils.translateMsg(s));
            }
        }
        if (! (itemFlags == null || itemFlags.isEmpty())) {
            for (String s : itemFlags) {
                ItemFlag flag = ItemFlag.valueOf(s);
                meta.addItemFlags(flag);
            }
        }

        if (enchantments != null) {
            Set<String> enchantKeys = enchantments.getKeys(false);
            for (String s : enchantKeys) {
                String mcName = Utils.getMinecraftEnchName(s);
                Enchantment ench = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(mcName));
                int value = config.getInt(enchantmentsPath + "." + s);

                if (!(ench == null || value <= 0)) {
                    meta.addEnchant(ench, value, true);
                }
            }
        }

        if (attributes != null) {
            LorePresets.addGearLore(newLore, material);

            Set<String> keys = config.getConfigurationSection(attributesPath).getKeys(false);

            for (String s : keys) {
                Attribute atr = Utils.translateInformalAttributeName(s);
                String atrName = Utils.toLowercaseAttributeName(atr);
                double displayValue = config.getDouble(attributesPath + "." + s);
                double correctValue = Utils.getCorrectAttributeValue(atr, displayValue);
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                if (!(atrName == null)) {
                    AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, correctValue, AttributeModifier.Operation.ADD_NUMBER, slot);
                    LorePresets.addGearStats(newLore, atr, displayValue);
                    meta.addAttributeModifier(atr, atrMod);
                }
            }
        }

        if (!newLore.isEmpty()) {
            meta.setLore(newLore);
        }
        if (customModelData > 0) {
            meta.setCustomModelData(customModelData);
        }

        this.setItemMeta(meta);

        if (nbtTags != null) {
            for (String s : nbtTags.getKeys(false)) {
                String key = s;
                String value = config.getString(nbtTagsPath + "." + s);
                if (!(key == null || key.isEmpty() || value == null || value.isEmpty())) {
                    if (org.apache.commons.lang.math.NumberUtils.isDigits(value)) {
                        Utils.addNbtTag(this, key, Integer.parseInt(value), PersistentDataType.INTEGER);
                    }
                    else {
                        Utils.addNbtTag(this, key, value, PersistentDataType.STRING);
                    }
                }
            }
        }

        itemMap.put(name, this);
    }

    public RSVItem(RSVModule module, String name)  {
        super(Material.valueOf(module.getItemConfig().getConfig().getString(name + ".Material")));

        FileConfiguration config = module.getItemConfig().getConfig();

        this.name = name;
        this.module = module.getName();

        String materialPath = name + ".Material";
        String displayNamePath = name + ".DisplayName";
        String customModelDataPath = name + ".CustomModelData";
        String lorePath = name + ".Lore";
        String itemFlagsPath = name + ".ItemFlags";
        String enchantmentsPath = name + ".Enchantments";
        String attributesPath = name + ".Attributes";
        String nbtTagsPath = name + ".NBTTags";

        Material material = Material.valueOf(config.getString(materialPath));
        String displayName = config.getString(displayNamePath);
        int customModelData = config.getInt(customModelDataPath);
        List<String> lore = config.getStringList(lorePath);
        List<String> itemFlags = config.getStringList(itemFlagsPath);
        ConfigurationSection enchantments = config.getConfigurationSection(enchantmentsPath);
        ConfigurationSection attributes = config.getConfigurationSection(attributesPath);
        ConfigurationSection nbtTags = config.getConfigurationSection(nbtTagsPath);

        ItemMeta meta = this.getItemMeta();
        List<String> newLore = new ArrayList<>();

        if (material == Material.POTION) {
            String colorPath = name + ".Color";
            String effectsPath = name + ".Effects";

            if (config.getString(colorPath) != null) {
                Color color = Utils.valueOfColor(config.getString(colorPath));
                ((PotionMeta) meta).setColor(color);
            }
            if (config.getString(effectsPath) != null) {
                String effect = config.getString(effectsPath);
                PotionType potionType = PotionType.valueOf(effect);

                ((PotionMeta) meta).setBasePotionData(new PotionData(potionType));
            }
        }

        meta.setDisplayName(Utils.translateMsg(displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                if (s.startsWith(LOREPRESET)) {
                    String key = s.substring(LOREPRESET.length() + 1);
                    LorePresets.useLorePreset(newLore, key, module.getUserConfig().getConfig().getConfigurationSection("Items." + name));
                }
                else {
                    newLore.add(Utils.translateMsg(s));
                }
            }
        }
        if (! (itemFlags == null || itemFlags.isEmpty())) {
            for (String s : itemFlags) {
                ItemFlag flag = ItemFlag.valueOf(s);
                meta.addItemFlags(flag);
            }
        }

        if (enchantments != null) {
            Set<String> enchantKeys = enchantments.getKeys(false);
            for (String s : enchantKeys) {
                String mcName = Utils.getMinecraftEnchName(s);
                Enchantment ench = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(mcName));
                int value = config.getInt(enchantmentsPath + "." + s);

                if (!(ench == null || value <= 0)) {
                    meta.addEnchant(ench, value, true);
                }
            }
        }

        if (attributes != null) {
            boolean useModuleConfig = config.getBoolean(attributesPath + ".UseModuleConfig");
            FileConfiguration atrConfig = useModuleConfig ? module.getUserConfig().getConfig() : config;
            attributesPath = useModuleConfig ? "Items." + name + ".Attributes" : attributesPath;

            LorePresets.addGearLore(newLore, material);

            if (atrConfig.getConfigurationSection(attributesPath) != null) {
                Set<String> keys = atrConfig.getConfigurationSection(attributesPath).getKeys(false);
                keys.remove("UseModuleConfig");

                for (String s : keys) {
                    Attribute atr = Utils.translateInformalAttributeName(s);
                    String atrName = Utils.toLowercaseAttributeName(atr);
                    double displayValue = atrConfig.getDouble(attributesPath + "." + s);
                    double correctValue = Utils.getCorrectAttributeValue(atr, displayValue);
                    EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                    if (!(atrName == null)) {
                        AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, correctValue, AttributeModifier.Operation.ADD_NUMBER, slot);
                        LorePresets.addGearStats(newLore, atr, displayValue);
                        meta.addAttributeModifier(atr, atrMod);
                    }
                }
            }
        }

        meta.setLore(newLore);
        meta.setCustomModelData(customModelData);

        this.setItemMeta(meta);

        if (nbtTags != null) {
            for (String s : nbtTags.getKeys(false)) {
                String key = s;
                String value = config.getString(nbtTagsPath + "." + s);
                if (!(key == null || key.isEmpty() || value == null || value.isEmpty())) {
                    if (org.apache.commons.lang.math.NumberUtils.isDigits(value)) {
                        Utils.addNbtTag(this, key, Integer.parseInt(value), PersistentDataType.INTEGER);
                    }
                    else {
                        Utils.addNbtTag(this, key, value, PersistentDataType.STRING);
                    }
                }
            }
        }
        Utils.addNbtTag(this, "rsvitem", this.name, PersistentDataType.STRING);
        Utils.addNbtTag(this, "rsvmodule", this.module, PersistentDataType.STRING);

        itemMap.put(name, this);
    }

    public RSVItem resize(int amount) {
        this.setAmount(amount);
        return this;
    }

    public static boolean isRSVItem(ItemStack item) {
        if (Utils.isItemReal(item)) {
            return Utils.hasNbtTag(item, "rsvitem");
        }
        return false;
    }

    public static boolean isRSVItem(String name) {
        return itemMap.containsKey(name);
    }

    public static ItemStack convertItemStackToRSVItem(ItemStack item) {
        return isRSVItem(item) ? getItem(getNameFromItem(item)) : item;
    }

    public static <T> void addNbtTag(ItemStack item, String key, T obj, PersistentDataType<T, T> type) {
        Utils.addNbtTag(item, key, obj, type);
    }


    public static String getModuleNameFromItem(ItemStack item) {
        return Utils.getNbtTag(item, "rsvmodule", PersistentDataType.STRING);
    }

    public static String getNameFromItem(ItemStack item) {
        return Utils.getNbtTag(item, "rsvitem", PersistentDataType.STRING);
    }

    public String getModule() {
        return module;
    }

    public String getName() {
        return name;
    }

    public static Map<String, RSVItem> getItemMap() {
        return itemMap;
    }

    public static ItemStack getItem(String name) {
        return itemMap.get(name).clone();
    }
}