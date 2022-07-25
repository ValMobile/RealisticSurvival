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
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.ChatColor;
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
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.*;

public class RSVItem extends ItemStack {

    private static final String LOREPRESET = "LOREPRESET";

    private static HashMap<String, RSVItem> itemMap = new HashMap<>();

    private final String name;
    private final String module;

    private final Utils util;

    public RSVItem(RSVModule module, String name, RealisticSurvivalPlugin plugin)  {
        super(Material.valueOf(module.getItemConfig().getConfig().getString(name + ".Material")));

        FileConfiguration config = module.getItemConfig().getConfig();
        util = new Utils(plugin);

        this.name = name;

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

        this.module = module.getName();

        ItemMeta meta = this.getItemMeta();
        List<String> newLore = new ArrayList<>();

        if (material.equals(Material.POTION)) {
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

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                if (s.startsWith(LOREPRESET)) {
                    String key = s.substring(LOREPRESET.length() + 1);
                    LorePresets.useLorePreset(newLore, key);
                }
                else {
                    newLore.add(ChatColor.translateAlternateColorCodes('&', s));
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
            for (String s : enchantments.getKeys(false)) {
                String mcName = Utils.getMinecraftEnchName(s).toLowerCase();
                Enchantment ench = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(mcName));
                int value = config.getInt(enchantmentsPath + "." + s);
                if (!(ench == null || value <= 0)) {
                    this.addUnsafeEnchantment(ench, value);
                }
            }
        }

        if (attributes != null) {
            boolean useModuleConfig = config.getBoolean(attributesPath + ".UseModuleConfig");
            FileConfiguration atrConfig = useModuleConfig ? module.getUserConfig().getConfig() : config;
            attributesPath = useModuleConfig ? "Items." + attributesPath : attributesPath;

            LorePresets.addGearLore(newLore, material);

            Set<String> keys = atrConfig.getConfigurationSection(attributesPath).getKeys(false);
            keys.remove("UseModuleConfig");

            for (String s : keys) {
                Attribute atr = Attribute.valueOf(s);
                String atrName = Utils.toLowercaseAttributeName(s);
                double displayValue = atrConfig.getDouble(attributesPath + "." + s);
                double correctValue = Utils.getCorrectAttributeValue(atr, displayValue);
                AttributeModifier.Operation op = AttributeModifier.Operation.ADD_NUMBER;
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, correctValue, op, slot);
                if (!(atr == null || atrName == null)) {
                    LorePresets.addGearStats(newLore, atr, displayValue);
                    meta.addAttributeModifier(atr, atrMod);
                }
            }
        }

        meta.setLore(newLore);
        meta.setCustomModelData(customModelData);

        if (nbtTags != null) {
            for (String s : nbtTags.getKeys(false)) {
                String key = s;
                String value = config.getString(nbtTagsPath + "." + s);
                if (!(key == null || key.isEmpty() || value == null || value.isEmpty())) {
                    util.addNbtTag(this, key, value);
                }
            }
        }
        util.addNbtTag(this, "rsvitem", this.name);
        util.addNbtTag(this, "rsvmodule", this.module);

        this.setItemMeta(meta);
    }

    public RSVItem resize(int amount) {
        this.setAmount(amount);
        return this;
    }

    public static boolean isRSVItem(ItemStack item, Utils util) {
        return util.hasNbtTag(item, "rsvitem");
    }

    public static RSVItem convertItemStackToRSVItem(ItemStack item, RealisticSurvivalPlugin plugin) {
        Utils util = new Utils(plugin);
        RSVItem rsvItem = null;

        if (isRSVItem(item, util)) {
            String name = util.getNbtTag(item, "rsvmodule");

            Collection<RSVModule> mod = RSVModule.getModules().values();

            for (RSVModule m : mod) {
                if (Objects.equals(name, m.getName())) {
                    rsvItem = new RSVItem(m, util.getNbtTag(item, "rsvitem"), plugin);
                    break;
                }
            }

            rsvItem.setItemMeta(item.getItemMeta());
        }
        return rsvItem;
    }

    public static String getModuleNameFromItem(ItemStack item, Utils util) {
        return util.getNbtTag(item, "rsvmodule");
    }

    public static String getNameFromItem(ItemStack item, Utils util) {
        return util.getNbtTag(item, "rsvitem");
    }

    public String getModule() {
        return module;
    }

    public String getName() {
        return name;
    }

    public static HashMap<String, RSVItem> getItemMap() {
        return itemMap;
    }

    public static RSVItem getItem(String name) {
        return itemMap.get(name);
    }

}