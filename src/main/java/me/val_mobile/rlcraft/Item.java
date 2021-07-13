package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Item extends ItemStack {

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


    private static List<String> commandNames = new ArrayList<>();
    private ItemStack nmsItem;
    private String codeName;
    private String commandName;

    public Item(FileConfiguration config, int index)  {
        super(Material.valueOf(config.getString(index + ".Material")), config.getInt(index + ".Amount"));

        String materialPath = index + ".Material";
        String customModelDataPath = index + ".CustomModelData";
        String displayNamePath = index + ".DisplayName";
        String codeNamePath = index + ".CodeName";
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
        codeName = config.getString(codeNamePath);
        commandName = config.getString(commandNamePath);
        commandNames.add(commandName);

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                newLore.add(ChatColor.translateAlternateColorCodes('&', s));
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
                    meta.addEnchant(ench, value, true);
                }
            }
        }

        if (attributes != null) {
            Utils.addGearLore(newLore, material);
            for (String s : attributes.getKeys(true)) {
                Attribute atr = Attribute.valueOf(s);
                String atrName = Utils.getLowercaseAtrName(s);
                double value = Utils.getCorrectAtrAmount(atr, config.getDouble(attributesPath + "." + s));
                AttributeModifier.Operation op = AttributeModifier.Operation.ADD_NUMBER;
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, value, op, slot);
                if (!(atr == null || value <= 0.0 || atrName == null)) {
                    Utils.addGearStats(newLore, atr, value);
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
        String codeNamePath = index + ".CodeName";
        codeName = config.getString(codeNamePath);

        String commandNamePath = index + ".CommandName";
        String lorePath = index + ".Lore";
        String itemFlagsPath = index + ".ItemFlags";
        String enchantmentsPath = index + ".Enchantments";
        String attributesPath = gearType + "." + codeName;
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

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                newLore.add(ChatColor.translateAlternateColorCodes('&', s));
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
                    meta.addEnchant(ench, value, true);
                }
            }
        }

        if (attributes != null) {
            Utils.addGearLore(newLore, material);
            for (String s : attributes.getKeys(true)) {
                String name = Utils.translateInformalAtrName(s);
                Attribute atr = Attribute.valueOf(name);
                String atrName = Utils.getLowercaseAtrName(name);
                double value = Utils.getCorrectAtrAmount(atr, extraConfig.getDouble(attributesPath + "." + s));
                AttributeModifier.Operation op = AttributeModifier.Operation.ADD_NUMBER;
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, value, op, slot);
                if (!(atr == null || value <= 0.0 || atrName == null)) {
                    Utils.addGearStats(newLore, atr, value);
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

    public Item(FileConfiguration config, int index, FileConfiguration extraConfig, String gearType, boolean useLorePreset)  {
        super(Material.valueOf(config.getString(index + ".Material")), config.getInt(index + ".Amount"));

        String materialPath = index + ".Material";
        String customModelDataPath = index + ".CustomModelData";
        String displayNamePath = index + ".DisplayName";
        String codeNamePath = index + ".CodeName";
        codeName = config.getString(codeNamePath);

        String commandNamePath = index + ".CommandName";
        String lorePath = index + ".Lore";
        String itemFlagsPath = index + ".ItemFlags";
        String enchantmentsPath = index + ".Enchantments";
        String attributesPath = gearType + "." + codeName;
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

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                newLore.add(ChatColor.translateAlternateColorCodes('&', s));
            }
        }

        if (useLorePreset) {

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
                    meta.addEnchant(ench, value, true);
                }
            }
        }

        if (attributes != null) {
            Utils.addGearLore(newLore, material);
            for (String s : attributes.getKeys(true)) {
                String name = Utils.translateInformalAtrName(s);
                Attribute atr = Attribute.valueOf(name);
                String atrName = Utils.getLowercaseAtrName(name);
                double value = Utils.getCorrectAtrAmount(atr, extraConfig.getDouble(attributesPath + "." + s));
                AttributeModifier.Operation op = AttributeModifier.Operation.ADD_NUMBER;
                EquipmentSlot slot = Utils.getCorrectEquipmentSlot(atr, material);

                AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, value, op, slot);
                if (!(atr == null || value <= 0.0 || atrName == null)) {
                    Utils.addGearStats(newLore, atr, value);
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

    public String getCodeName() {
        return codeName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static List<String> getCommandNames() {
        return commandNames;
    }

    public static ItemStack getItem(int index) {
        return new Item(CustomConfig.getItemsConfig(), index).getNmsItem();
    }
}
