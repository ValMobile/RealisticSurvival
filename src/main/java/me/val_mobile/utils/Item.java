package me.val_mobile.utils;

import de.tr7zw.nbtapi.NBTItem;
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

public class Item extends ItemStack {

    private static final String LOREPRESET = "LOREPRESET";
    public static final String PICKAXE = "Pickaxe";
    public static final String AXE = "Axe";
    public static final String SHOVEL = "Shovel";
    public static final String HOE = "Hoe";
    public static final String SWORD = "Sword";
    public static final String HELMET = "Helmet";
    public static final String CHESTPLATE = "Chestplate";
    public static final String LEGGINGS = "Leggings";
    public static final String BOOTS = "Boots";

    public static final String KNIFE = "Knife";
    public static final String RAPIER = "Rapier";
    public static final String SABER = "Saber";
    public static final String KATANA = "Katana";
    public static final String GREATSWORD = "Greatsword";
    public static final String LONGSWORD = "Longsword";
    public static final String SPEAR = "Spear";
    public static final String GLAIVE = "Glaive";
    public static final String BOOMERANG = "Boomerang";
    public static final String DAGGER = "Dagger";
    public static final String HALBERD = "Halberd";
    public static final String HAMMER = "Hammer";
    public static final String JAVELIN = "Javelin";
    public static final String LANCE = "Lance";
    public static final String MACE = "Mace";
    public static final String PIKE = "Pike";
    public static final String QUARTERSTAFF = "Quarterstaff";
    public static final String THROWING_AXE = "ThrowingAxe";
    public static final String THROWING_KNIFE = "ThrowingKnife";
    public static final String WARHAMMER = "Warhammer";
    public static final String BATTLEAXE = "Battleaxe";

    private static Collection<String> commandNames = new ArrayList<>();
    private static HashMap<String, Integer> itemMap = new HashMap<>();
    private ItemStack nmsItem;
    private String configName;
    private String commandName;

    public Item(FileConfiguration config, int index)  {
        super(Material.valueOf(config.getString(index + ".Material")), config.getInt(index + ".Amount"));

        String materialPath = index + ".Material";
        String customModelDataPath = index + ".CustomModelData";
        String displayNamePath = index + ".DisplayName";
        String configNamePath = index + ".ConfigName";
        String commandNamePath = index + ".CommandName";
        String lorePath = index + ".Lore";
        String itemFlagsPath = index + ".ItemFlags";
        String enchantmentsPath = index + ".Enchantments";
        String attributesPath = index + ".Attributes";
        String nbtTagsPath = index + ".NBTTags";

        List<String> itemFlags = config.getStringList(itemFlagsPath);
        ConfigurationSection enchantments = config.getConfigurationSection(enchantmentsPath);
        ConfigurationSection attributes = config.getConfigurationSection(attributesPath);
        ConfigurationSection nbtTags = config.getConfigurationSection(nbtTagsPath);

        Material material = Material.valueOf(config.getString(materialPath));
        ItemMeta meta = this.getItemMeta();
        List<String> lore = config.getStringList(lorePath);
        List<String> newLore = new ArrayList<>();

        int customModelData = config.getInt(customModelDataPath);

        String displayName = config.getString(displayNamePath);
        configName = config.getString(configNamePath);
        commandName = config.getString(commandNamePath);
        commandNames.add(commandName);
        itemMap.put(commandName, index);

        if (material.equals(Material.POTION)) {
            String colorPath = index + ".Color";
            String effectsPath = index + ".Effects";

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
                    Utils.useLorePreset(newLore, key);
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
            for (String s : enchantments.getKeys(true)) {
                String mcName = Utils.getMinecraftEnchName(s).toLowerCase();
                Enchantment ench = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(mcName));
                int value = config.getInt(enchantmentsPath + "." + s);
                if (!(ench == null || value <= 0)) {
                    this.addUnsafeEnchantment(ench, value);
                }
            }
        }

        if (attributes != null) {
            Utils.addGearLore(newLore, material);
            for (String s : attributes.getKeys(true)) {
                Attribute atr = Attribute.valueOf(s);
                String atrName = Utils.toLowercaseAttributeName(s);
                double displayValue = config.getDouble(attributesPath + "." + s);
                double correctValue = Utils.getCorrectAttributeValue(atr, displayValue);
                AttributeModifier.Operation op = AttributeModifier.Operation.ADD_NUMBER;
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, correctValue, op, slot);
                if (!(atr == null || atrName == null)) {
                    Utils.addGearStats(newLore, atr, displayValue);
                    meta.addAttributeModifier(atr, atrMod);
                }
            }
        }

        meta.setLore(newLore);
        meta.setCustomModelData(customModelData);

        this.setItemMeta(meta);

        NBTItem nbti = new NBTItem(this);
        if (nbtTags != null) {
            for (String s : nbtTags.getKeys(true)) {
                String key = s;
                String value = config.getString(nbtTagsPath + "." + s);
                if (!(key == null || key.isEmpty() || value.isEmpty() || value == null)) {
                    nbti.setString(key, value);
                }
            }
        }

        nmsItem = nbti.getItem();
    }

    public Item(FileConfiguration config, int index, FileConfiguration extraConfig, String gearType)  {
        super(Material.valueOf(config.getString(index + ".Material")), config.getInt(index + ".Amount"));

        String materialPath = index + ".Material";
        String customModelDataPath = index + ".CustomModelData";
        String displayNamePath = index + ".DisplayName";
        String configNamePath = index + ".ConfigName";
        configName = config.getString(configNamePath);

        String commandNamePath = index + ".CommandName";
        String lorePath = index + ".Lore";
        String itemFlagsPath = index + ".ItemFlags";
        String enchantmentsPath = index + ".Enchantments";
        String attributesPath = gearType + "." + configName;
        String nbtTagsPath = index + ".NBTTags";

        List<String> itemFlags = config.getStringList(itemFlagsPath);
        ConfigurationSection enchantments = config.getConfigurationSection(enchantmentsPath);
        ConfigurationSection attributes = extraConfig.getConfigurationSection(attributesPath);
        ConfigurationSection nbtTags = config.getConfigurationSection(nbtTagsPath);

        Material material = Material.valueOf(config.getString(materialPath));
        ItemMeta meta = this.getItemMeta();
        List<String> lore = config.getStringList(lorePath);
        List<String> newLore = new ArrayList<>();

        int customModelData = config.getInt(customModelDataPath);

        String displayName = config.getString(displayNamePath);
        commandName = config.getString(commandNamePath);
        commandNames.add(commandName);
        itemMap.put(commandName, index);

        if (material.equals(Material.POTION)) {
            String colorPath = index + ".Color";
            String effectsPath = index + ".Effects";

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
                    Utils.useLorePreset(newLore, key);
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
            for (String s : enchantments.getKeys(true)) {
                String mcName = Utils.getMinecraftEnchName(s).toLowerCase();
                Enchantment ench = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(mcName));
                int value = config.getInt(enchantmentsPath + "." + s);
                if (!(ench == null || value <= 0)) {
                    this.addUnsafeEnchantment(ench, value);
                }
            }
        }

        if (attributes != null) {
            Utils.addGearLore(newLore, material);
            for (String s : attributes.getKeys(true)) {
                String name = Utils.translateInformalAttributeName(s);
                Attribute atr = Attribute.valueOf(name);
                String atrName = Utils.toLowercaseAttributeName(name);
                double displayValue = extraConfig.getDouble(attributesPath + "." + s);
                double correctValue = Utils.getCorrectAttributeValue(atr, displayValue);
                AttributeModifier.Operation op = AttributeModifier.Operation.ADD_NUMBER;
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, correctValue, op, slot);
                if (!(atr == null || atrName == null)) {
                    Utils.addGearStats(newLore, atr, displayValue);
                    meta.addAttributeModifier(atr, atrMod);
                }
            }
        }

        meta.setLore(newLore);
        meta.setCustomModelData(customModelData);

        this.setItemMeta(meta);

        NBTItem nbti = new NBTItem(this);
        if (nbtTags != null) {
            for (String s : nbtTags.getKeys(true)) {
                String key = s;
                String value = config.getString(nbtTagsPath + "." + s);
                if (!(key == null || key.isEmpty() || value.isEmpty() || value == null)) {
                    nbti.setString(key, value);
                }
            }
        }

        nmsItem = nbti.getItem();
    }

    public ItemStack getNmsItem() {
        return nmsItem;
    }

    public String getConfigName() {
        return configName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Collection<String> getCommandNames() {
        return commandNames;
    }

    public static HashMap<String, Integer> getItemMap() {
        return itemMap;
    }

    public static ItemStack getItem(int index) {
        return new Item(CustomConfig.getItemConfig(), index).getNmsItem();
    }
}
