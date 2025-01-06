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

import me.val_mobile.data.RSVModule;
import me.val_mobile.rsv.RSVPlugin;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class RSVItem extends ItemStack {

    private static final Map<String, RSVItem> itemMap = new HashMap<>();
    private static final String MODEL_CONFIG_DEFAULT_OPTION = "DEFAULT";

    private final Ingredient repairIng;
    private final String name;
    private final String module;
    private final FileConfiguration itemConfig;

    public RSVItem(RSVItem copy) {
        this(RSVModule.getModule(copy.module), copy.itemConfig, copy.name);
    }

    public RSVItem(@Nullable RSVModule module, @Nonnull FileConfiguration itemConfig, @Nonnull String name) {
        super(Material.valueOf(itemConfig.getString(name + ".Material")));

        this.itemConfig = itemConfig;
        this.name = name;
        this.module = module == null ? null : module.getName();

        String materialPath = name + ".Material";
        String displayNamePath = name + ".DisplayName";
        String customModelDataPath = name + ".CustomModelData";
        String itemModelPath = name + ".ItemModel";
        String equippableComponentModelPath = name + ".EquippableComponentModel";
        String lorePath = name + ".Lore";
        String itemFlagsPath = name + ".ItemFlags";
        String enchantmentsPath = name + ".Enchantments";
        String attributesPath = name + ".Attributes";
        String nbtTagsPath = name + ".NBTTags";
        String repairIngPath = name + ".RepairIngredients";

        Material material = Material.valueOf(itemConfig.getString(materialPath));
        String displayName = itemConfig.getString(displayNamePath);
        int customModelData = itemConfig.getInt(customModelDataPath);

        RSVPlugin pluginNamespace = RSVPlugin.getPlugin();
        String itemModelStr = itemConfig.getString(itemModelPath);
        NamespacedKey itemModelKey = null;

        if (itemModelStr != null) {
            // automatically generate item model key if default option is used
            if (itemModelStr.equals(MODEL_CONFIG_DEFAULT_OPTION)) {
                itemModelKey = NamespacedKey.fromString(module.getName().toLowerCase() + "/" + name, pluginNamespace);
            }
            else {
                itemModelKey = NamespacedKey.fromString(itemModelStr, pluginNamespace);
            }
        }

        String ecmStr = itemConfig.getString(equippableComponentModelPath);
        NamespacedKey ecmKey = null;

        if (ecmStr != null) {
            // automatically generate item model key if default option is used
            if (ecmStr.equals(MODEL_CONFIG_DEFAULT_OPTION)) {
                // create a list of different armor slots
                List<String> armorSlots = List.of("helmet", "chestplate", "leggings", "boots", "hood", "jacket", "pants");

                // attempt to find the armor material from the item name
                String armorMaterial = name;
                for (String armorSlot : armorSlots) {
                    if (armorMaterial.contains("_" + armorSlot)) {
                        armorMaterial = armorMaterial.replaceAll("_" + armorSlot, "");
                    }
                }

                ecmKey = NamespacedKey.fromString(module.getName().toLowerCase() + "/" + armorMaterial, pluginNamespace);
            }
            else {
                ecmKey = NamespacedKey.fromString(ecmStr, pluginNamespace);
            }
        }

        List<String> lore = itemConfig.getStringList(lorePath);
        List<String> itemFlags = itemConfig.getStringList(itemFlagsPath);
        ConfigurationSection enchantments = itemConfig.getConfigurationSection(enchantmentsPath);
        ConfigurationSection attributes = itemConfig.getConfigurationSection(attributesPath);
        ConfigurationSection nbtTags = itemConfig.getConfigurationSection(nbtTagsPath);

        ItemMeta meta = this.getItemMeta();
        List<String> newLore = new ArrayList<>();

        if (material == Material.POTION) {
            String colorPath = name + ".Color";
            String effectsPath = name + ".PotionType";

            if (itemConfig.getString(colorPath) != null) {
                Color color = Utils.valueOfColor(itemConfig.getString(colorPath));
                ((PotionMeta) meta).setColor(color);
            }
            if (itemConfig.getString(effectsPath) != null) {
                String effect = itemConfig.getString(effectsPath);
                PotionType potionType = PotionType.valueOf(effect);

                ((PotionMeta) meta).setBasePotionData(new PotionData(potionType));
            }
        }

        if (displayName != null) {
            meta.setDisplayName(Utils.translateMsg(displayName,null, null));
        }

        if (! (lore == null || lore.isEmpty()) ) {
            for (String s : lore) {
                if (s.startsWith("LOREPRESET")) {
                    String key = s.substring(11);
                    LorePresets.useLorePreset(newLore, key, module.getUserConfig().getConfig().getConfigurationSection("Items." + name));
                }
                else {
                    newLore.add(Utils.translateMsg(s, null, null));
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
                int value = itemConfig.getInt(enchantmentsPath + "." + s);

                if (!(ench == null || value <= 0)) {
                    meta.addEnchant(ench, value, true);
                }
            }
        }

        if (attributes != null) {
            boolean useModuleConfig = itemConfig.getBoolean(attributesPath + ".UseModuleConfig");
            FileConfiguration atrConfig = useModuleConfig ? module.getUserConfig().getConfig() : itemConfig;
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

                    if (atrName != null) {
                        AttributeModifier atrMod = new AttributeModifier(UUID.randomUUID(), atrName, correctValue, AttributeModifier.Operation.ADD_NUMBER, slot);
                        LorePresets.addGearStats(newLore, atr, displayValue);
                        meta.addAttributeModifier(atr, atrMod);
                    }
                }
            }
        }

        if (!newLore.isEmpty()) {
            meta.setLore(newLore);
        }
        if (customModelData > 0) {
            meta.setCustomModelData(customModelData);
        }

        if (itemModelKey != null) {
            Utils.setItemModel(meta, itemModelKey);
        }

        if (ecmKey != null) {
            Utils.setEquippableComponentModel(meta, ecmKey, Utils.getEquipmentSlotFromMaterial(material));
        }

        this.setItemMeta(meta);

        if (nbtTags != null) {
            for (String s : nbtTags.getKeys(false)) {
                String key = s;
                String value = itemConfig.getString(nbtTagsPath + "." + s);
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

        if (itemConfig.contains(repairIngPath)) {
            String raw = itemConfig.getString(repairIngPath);

            repairIng = new Ingredient(raw);
        }
        else {
            repairIng = new Ingredient("");
            Set<Material> vanilla = Utils.getVanillaRepairMaterials(this.getType());

            repairIng.add(vanilla);
        }

        if (module != null) {
            Utils.addNbtTag(this, "rsvitem", this.name, PersistentDataType.STRING);
            Utils.addNbtTag(this, "rsvmodule", module.getName(), PersistentDataType.STRING);
        }

        itemMap.put(name, this);
    }

    @Nonnull
    public Ingredient getRepairIng() {
        return repairIng;
    }

    @Nonnull
    public RSVItem resize(@Nonnegative int amount) {
        this.setAmount(amount);
        return this;
    }

    public static boolean isRSVItem(@Nullable ItemStack item) {
        if (Utils.isItemReal(item)) {
            return Utils.hasNbtTag(item, "rsvitem");
        }
        return false;
    }

    public static boolean isRSVItem(@Nonnull String name) {
        return itemMap.containsKey(name);
    }

    @Nullable
    public static ItemStack convertItemStackToRSVItem(@Nullable ItemStack item) {
        return isRSVItem(item) ? getItem(getNameFromItem(item)) : item;
    }

    public static <T> void addNbtTag(ItemStack item, String key, T obj, PersistentDataType<T, T> type) {
        Utils.addNbtTag(item, key, obj, type);
    }

    @Nullable
    public static String getModuleNameFromItem(@Nonnull ItemStack item) {
        return Utils.getNbtTag(item, "rsvmodule", PersistentDataType.STRING);
    }

    @Nullable
    public static String getNameFromItem(@Nonnull ItemStack item) {
        return Utils.getNbtTag(item, "rsvitem", PersistentDataType.STRING);
    }

    @Nullable
    public String getModule() {
        return module;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public static boolean isHoldingItem(@Nonnull String name, @Nonnull Player player) {
        return isHoldingItemInMainHand(name, player) || isHoldingItemInOffHand(name, player);
    }

    public static boolean isHoldingItemInMainHand(@Nonnull String name, @Nonnull Player player) {
        ItemStack mainHand = player.getInventory().getItemInMainHand();

        return RSVItem.isRSVItem(mainHand) && RSVItem.getNameFromItem(mainHand).equals(name);
    }

    public static boolean isHoldingItemInOffHand(@Nonnull String name, @Nonnull Player player) {
        ItemStack offHand = player.getInventory().getItemInOffHand();

        return RSVItem.isRSVItem(offHand) && RSVItem.getNameFromItem(offHand).equals(name);
    }

    public static Map<String, RSVItem> getItemMap() {
        return itemMap;
    }

    @Nullable
    public static RSVItem getItem(@Nullable String name) {
        if (name == null) {
            return null;
        }

        RSVItem item = itemMap.getOrDefault(name, null);

        return item == null ? null : new RSVItem(item);
    }
}