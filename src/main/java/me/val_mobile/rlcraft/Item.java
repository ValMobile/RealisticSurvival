package me.val_mobile.rlcraft;

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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class Item extends ItemStack {

    private static final String LOREADDER = "LOREADDER";
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
        itemMap.put(commandName, index);

        if (material.equals(Material.POTION)) {
            String colorPath = index + ".Color";
            String effectsPath = index + ".Effects";

            Color color = Utils.valueOfColor(config.getString(colorPath));
            List<String> effects = config.getStringList(effectsPath);

            if (color != null) {
                ((PotionMeta) meta).setColor(color);
            }
            if (! (effects == null || effects.isEmpty()) ) {
                for (String effectName : effects) {
                    PotionEffectType potionEffectType = Utils.valueOfPotionEffectType(effectName);
                    String amplifierPath = effectsPath + "." + effectName + ".Amplifier";
                    String durationPath = effectsPath + "." + effectName + ".Duration";

                    int amplifier = config.getInt(amplifierPath);
                    int duration = config.getInt(durationPath);

                    PotionEffect effect = new PotionEffect(potionEffectType, amplifier, duration);
                    ((PotionMeta) meta).addCustomEffect(effect, true);
                }
            }
        }

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                if (s.startsWith(LOREADDER)) {
                    String key = s.substring(LOREADDER.length() + 1);
                    Utils.useLoreAdder(newLore, key);
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
        itemMap.put(commandName, index);

        if (material.equals(Material.POTION)) {
            String colorPath = index + ".Color";
            String effectsPath = index + ".Effects";

            Color color = Utils.valueOfColor(config.getString(colorPath));
            List<String> effects = config.getStringList(effectsPath);

            if (color != null) {
                ((PotionMeta) meta).setColor(color);
            }
            if (! (effects == null || effects.isEmpty()) ) {
                for (String effectName : effects) {
                    PotionEffectType potionEffectType = Utils.valueOfPotionEffectType(effectName);
                    String amplifierPath = effectsPath + "." + effectName + ".Amplifier";
                    String durationPath = effectsPath + "." + effectName + ".Duration";

                    int amplifier = config.getInt(amplifierPath);
                    int duration = config.getInt(durationPath);

                    PotionEffect effect = new PotionEffect(potionEffectType, amplifier, duration);
                    ((PotionMeta) meta).addCustomEffect(effect, true);
                }
            }
        }

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                if (s.startsWith(LOREADDER)) {
                    String key = s.substring(LOREADDER.length() + 1);
                    Utils.useLoreAdder(newLore, key);
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

    public static Collection<String> getCommandNames() {
        return commandNames;
    }

    public static HashMap<String, Integer> getItemMap() {
        return itemMap;
    }

    public static ItemStack getItem(int index) {
        return new Item(CustomConfig.getItemsConfig(), index).getNmsItem();
    }
}
