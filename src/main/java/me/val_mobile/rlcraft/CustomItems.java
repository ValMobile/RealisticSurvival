package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomItems {

    private static ItemStack flintAxe = new Item(CustomConfig.getItemsConfig(), 0, CustomConfig.getNoTreePunchingConfig(), Item.AXE).getNmsItem();
    private static ItemStack flintKnife = new Item(CustomConfig.getItemsConfig(), 1, CustomConfig.getNoTreePunchingConfig(), Item.KNIFE).getNmsItem();
    private static ItemStack flintPickaxe = new Item(CustomConfig.getItemsConfig(), 2, CustomConfig.getNoTreePunchingConfig(), Item.PICKAXE).getNmsItem();
    private static ItemStack flintShovel = new Item(CustomConfig.getItemsConfig(), 3, CustomConfig.getNoTreePunchingConfig(), Item.SHOVEL).getNmsItem();
    private static ItemStack flintHoe = new Item(CustomConfig.getItemsConfig(), 4, CustomConfig.getNoTreePunchingConfig(), Item.HOE).getNmsItem();
    private static ItemStack plantFiber = new Item(CustomConfig.getItemsConfig(), 5).getNmsItem();
    private static ItemStack plantString = new Item(CustomConfig.getItemsConfig(), 6).getNmsItem();
    private static ItemStack flintShard = new Item(CustomConfig.getItemsConfig(), 7).getNmsItem();
    private static ItemStack dragonBone = new Item(CustomConfig.getItemsConfig(), 8).getNmsItem();
    private static ItemStack witherbone = new Item(CustomConfig.getItemsConfig(), 9).getNmsItem();
    private static ItemStack blueDragonScales = new Item(CustomConfig.getItemsConfig(), 10).getNmsItem();
    private static ItemStack bronzeDragonScales = new Item(CustomConfig.getItemsConfig(), 11).getNmsItem();
    private static ItemStack grayDragonScales = new Item(CustomConfig.getItemsConfig(), 12).getNmsItem();
    private static ItemStack greenDragonScales = new Item(CustomConfig.getItemsConfig(), 13).getNmsItem();
    private static ItemStack redDragonScales = new Item(CustomConfig.getItemsConfig(), 14).getNmsItem();
    private static ItemStack sapphireDragonScales = new Item(CustomConfig.getItemsConfig(), 15).getNmsItem();
    private static ItemStack silverDragonScales = new Item(CustomConfig.getItemsConfig(), 16).getNmsItem();
    private static ItemStack whiteDragonScales = new Item(CustomConfig.getItemsConfig(), 17).getNmsItem();
    private static ItemStack amethystDragonScales = new Item(CustomConfig.getItemsConfig(), 18).getNmsItem();
    private static ItemStack blackDragonScales = new Item(CustomConfig.getItemsConfig(), 19).getNmsItem();
    private static ItemStack copperDragonScales = new Item(CustomConfig.getItemsConfig(), 20).getNmsItem();
    private static ItemStack electricDragonScales = new Item(CustomConfig.getItemsConfig(), 21).getNmsItem();
    private static ItemStack blueSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 22).getNmsItem();
    private static ItemStack bronzeSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 23).getNmsItem();
    private static ItemStack deepBlueSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 24).getNmsItem();
    private static ItemStack greenSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 25).getNmsItem();
    private static ItemStack purpleSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 26).getNmsItem();
    private static ItemStack redSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 27).getNmsItem();
    private static ItemStack tealSeaSerpentScales = new Item(CustomConfig.getItemsConfig(), 28).getNmsItem();
    private static ItemStack shinyScales = new Item(CustomConfig.getItemsConfig(), 29).getNmsItem();
    private static ItemStack fireDragonBlood = new Item(CustomConfig.getItemsConfig(), 30).getNmsItem();
    private static ItemStack iceDragonBlood = new Item(CustomConfig.getItemsConfig(), 31).getNmsItem();
    private static ItemStack lightningDragonBlood = new Item(CustomConfig.getItemsConfig(), 32).getNmsItem();
    private static ItemStack fireDragonHeart = new Item(CustomConfig.getItemsConfig(), 33).getNmsItem();
    private static ItemStack iceDragonHeart = new Item(CustomConfig.getItemsConfig(), 34).getNmsItem();
    private static ItemStack lightningDragonHeart = new Item(CustomConfig.getItemsConfig(), 35).getNmsItem();
    private static ItemStack fireDragonSkull = new Item(CustomConfig.getItemsConfig(), 36).getNmsItem();
    private static ItemStack iceDragonSkull = new Item(CustomConfig.getItemsConfig(), 37).getNmsItem();
    private static ItemStack lightningDragonSkull = new Item(CustomConfig.getItemsConfig(), 38).getNmsItem();
    private static ItemStack fireDragonFlesh = new Item(CustomConfig.getItemsConfig(), 39).getNmsItem();
    private static ItemStack iceDragonFlesh = new Item(CustomConfig.getItemsConfig(), 40).getNmsItem();
    private static ItemStack lightningDragonFlesh = new Item(CustomConfig.getItemsConfig(), 41).getNmsItem();
    private static ItemStack fireDragonsteelIngot = new Item(CustomConfig.getItemsConfig(), 42).getNmsItem();
    private static ItemStack iceDragonsteelIngot = new Item(CustomConfig.getItemsConfig(), 43).getNmsItem();
    private static ItemStack lightningDragonsteelIngot = new Item(CustomConfig.getItemsConfig(), 44).getNmsItem();


    public static ItemStack getFlintAxe() {
        return flintAxe;
    }

    public static ItemStack getFlintKnife() {
        return flintKnife;
    }

    public static ItemStack getFlintPickaxe() {
        return flintPickaxe;
    }

    public static ItemStack getFlintShovel() {
        return flintShovel;
    }

    public static ItemStack getFlintHoe() {
        return flintHoe;
    }

    public static ItemStack getCobblestone() {
        return new ItemStack(Material.COBBLESTONE);
    }

    public static ItemStack getPlantFiber() {
        return plantFiber;
    }

    public static ItemStack getPlantString() {
        return plantString;
    }

    public static ItemStack getString() {
        return new ItemStack(Material.STRING);
    }

    public static ItemStack getFlintShard() {
        return flintShard;
    }

    public static ItemStack getDragonBone() {
        return dragonBone;
    }

    public static ItemStack getWitherbone() {
        return witherbone;
    }

    public static ItemStack getDragonScaleBlue() {
        return blueDragonScales;
    }

    public static ItemStack getDragonScaleBronze() {
        return bronzeDragonScales;
    }

    public static ItemStack getDragonScaleGray() {
        return grayDragonScales;
    }

    public static ItemStack getDragonScaleGreen() {
        return greenDragonScales;
    }

    public static ItemStack getDragonScaleRed() {
        return redDragonScales;
    }

    public static ItemStack getDragonScaleSapphire() {
        return sapphireDragonScales;
    }

    public static ItemStack getDragonScaleSilver() {
        return silverDragonScales;
    }

    public static ItemStack getDragonScaleWhite() {
        return whiteDragonScales;
    }

    public static ItemStack getDragonScaleAmethyst() {
        return amethystDragonScales;
    }

    public static ItemStack getDragonScaleBlack() {
        return blackDragonScales;
    }

    public static ItemStack getDragonScaleCopper() {
        return copperDragonScales;
    }

    public static ItemStack getDragonScaleElectric() {
        return electricDragonScales;
    }

    public static ItemStack getSeaSerpentScaleBlue() {
        return blueSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleBronze() {
        return bronzeSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleDeepBlue() {
        return deepBlueSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleGreen() {
        return greenSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScalePurple() {
        return purpleSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleRed() {
        return redSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleTeal() {
        return tealSeaSerpentScales;
    }

    public static ItemStack getShinyScale() {
        return shinyScales;
    }

    public static ItemStack getFireDragonBlood() {
        return fireDragonBlood;
    }

    public static ItemStack getIceDragonBlood() {
        return iceDragonBlood;
    }

    public static ItemStack getLightningDragonBlood() {
        return lightningDragonBlood;
    }

    public static ItemStack getFireDragonHeart() {
        return fireDragonHeart;
    }

    public static ItemStack getIceDragonHeart() {
        return iceDragonHeart;
    }

    public static ItemStack getLightningDragonHeart() {
        return lightningDragonHeart;
    }

    public static ItemStack getFireDragonSkull() {
        return fireDragonSkull;
    }

    public static ItemStack getIceDragonSkull() {
        return iceDragonSkull;
    }

    public static ItemStack getLightningDragonSkull() {
        return lightningDragonSkull;
    }

    public static ItemStack getFireDragonFlesh() {
        return fireDragonFlesh;
    }

    public static ItemStack getIceDragonFlesh() {
        return iceDragonFlesh;
    }

    public static ItemStack getLightningDragonFlesh() {
        return lightningDragonFlesh;
    }

    public static ItemStack getFireDragonsteelIngot() {
        return fireDragonsteelIngot;
    }

    public static ItemStack getIceDragonsteelIngot() {
        return iceDragonsteelIngot;

    }

    public static ItemStack getLightningDragonsteelIngot() {
        return lightningDragonsteelIngot;
    }

    public static ItemStack getDragonScaleHelmetBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83653);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83653);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83653);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83653);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83654);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83654);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83654);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83654);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness",baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83655);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83655);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83655);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));


        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83656);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83656);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83656);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83656);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83657);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83657);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83657);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83657);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83658);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83658);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83658);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83658);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83659);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83659);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83659);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83659);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83660);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83660);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83660);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83660);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleHelmetElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83661);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleChestplateElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83661);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleLeggingsElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83661);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonScaleBootsElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83661);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83662);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplateBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83662);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83662);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83662);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83663);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplateBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83663);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83663);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83663);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83664);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplateDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83664);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83664);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83664);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83665);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplateGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83665);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83665);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83665);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetPurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83666);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplatePurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83666);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsPurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83666);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsPurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83666);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83667);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplateRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83667);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83667);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83667);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianHelmetTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83668);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianChestplateTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83668);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianLeggingsTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83668);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getTideGuardianBootsTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83668);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBonePickaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Pickaxe"));
        meta.setCustomModelData(83650);
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDragonBoneAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Axe"));
        meta.setCustomModelData(83650);
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Axe.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Axe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDragonBoneShovel() {

        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Shovel"));
        meta.setCustomModelData(83650);
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Shovel.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Shovel.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDragonBoneHoe() {

        ItemStack item = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Hoe"));
        meta.setCustomModelData(83650);
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Hoe.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Hoe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Sword"));
        meta.setCustomModelData(83650);
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDragonBoneBow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Bow"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Dragon Bone");
        nbti.setString("Spartan's Weapon", "Bow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragon Bone Sword"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Ice Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragon Bone Sword"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Fire Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragon Bone Sword"));
        meta.setCustomModelData(83653);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+4 damage against Fire Dragons and Ice Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonsEye() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragons Eye"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Night Vision On"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Current Target: None"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Head)"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Dragon's Eye");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPoisonStone() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bPoison Stone"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83651);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Poison Stone");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPotionRingResistance() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring of Resistance"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));



        meta.setLore(lore);
        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring of Resistance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPotionRingRegeneration() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring of Regeneration"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83653);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring of Regeneration");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPotionRingHaste() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring of Haste"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83654);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring of Haste");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPotionRingStrength() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring of Strength"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83655);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring of Strength");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPotionRingSpeed() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring of Speed"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83656);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring of Speed");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPotionRingJumpBoost() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring of Jump Boost"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83657);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring of Jump Boost");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getEnderQueensCrown() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bEnder Queen's Crown"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Head)"));

        meta.setLore(lore);
        meta.setCustomModelData(83661);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ender Queen's Crown");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getSunglasses() {

        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSunglasses"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to blindness."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aCool guys don't look at explosions."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Head)"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Sunglasses");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getBalloon() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBalloon"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Increases jump height and negates some fall damage."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83662);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Balloon");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getCobaltShield() {

        ItemStack item = new ItemStack(Material.SHIELD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fCobalt Shield"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to knockback when held or equipped in bauble slot."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Cobalt Shield");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getObsidianSkull() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fObsidian Skull"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to burning and 50% resistance to fire damage. (Does not."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9protect against lava)"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aHolding this makes you feel vaguely nervous."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83663);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Obsidian Skull");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getObsidianShield() {

        ItemStack item = new ItemStack(Material.SHIELD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fObsidian Shield"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants partial fire resistance and immunity to knockback when held or equipped"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9in bauble slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Obsidian Shield");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getForbiddenFruit() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fForbidden Fruit"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to hunger status effect, and nausea."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83664);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Forbidden Fruit");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getVitamins() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fVitamins"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to weakness and mining fatigue."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83665);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Vitamins");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getRingofOverclocking() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fRing of Overclocking"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to slowness and +7% move speed."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aEveryone knows that blue LEDs make your PC run faster."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83666);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ring of Overclocking");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getShulkerHeart() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fShulker Heart"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to levitation"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aIt's squishy..."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83667);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Shulker Heart");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getRingofFreeAction() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fRing of Free Action"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to slowness and levitation and allows free movement through"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9cobwebs"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83668);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ring of Free Action");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getBezoar() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBezoar"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to poison."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83669);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Bezoar");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getEnderDragonScale() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fEnder Dragon Scale"));

        meta.setCustomModelData(83670);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getCrackedBlackDragonScale() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fCracked Black Dragon Scale"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aBlack dragon scales are said to protect against withering. Perhaps this broken one"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&acould be repaired?"));

        meta.setLore(lore);
        meta.setCustomModelData(83671);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getBlackDragonScale() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBlack Dragon Scale"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to withering."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83672);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Black Dragon Scale");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getMixedColorDragonScale() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fMixed Color Dragon Scale"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to poison and withering."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aInterestingly, the bezoar has fused with the scale and made it appear to"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&abe two different colors."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83673);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Mixed Color Dragon Scale");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getAnkhCharm() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fAnkh Charm"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants immunity to most negative status effects."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83674);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ankh Charm");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getAnkhShield() {

        ItemStack item = new ItemStack(Material.SHIELD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fAnkh Shield"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants partial fire resistance and immunity to knockback and most negative"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9status effects when held or equipped in bauble slot."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ankh Shield");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIronRing() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIron Ring"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Crafting component"));

        meta.setLore(lore);
        meta.setCustomModelData(83675);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getMagicMirror() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fMagic Mirror"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Teleports you to your spawn point."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aIt may bend space at will, but it can't make ugly things beautiful,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aunfortunately for you."));

        meta.setLore(lore);
        meta.setCustomModelData(83676);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getRecallPotion() {

        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fRecall Potion"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Teleports you to your spawn point."));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getWormholeMirror() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWormhole Mirror"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Right click to teleport to your spawn point."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Right click while sneaking to teleport to another player."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aYou can feel the void staring back at you."));

        meta.setLore(lore);
        meta.setCustomModelData(83677);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getWormholePotion() {

        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWormhole Potion"));
        meta.setColor(Color.BLUE);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Teleports you to other players."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aYou suddenly feel very alone."));

        meta.setLore(lore);
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getLuckyHorseshoe() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLucky Horseshoe"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Negates fall damage."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aWhy did the horse need this?"));

        meta.setLore(lore);
        meta.setCustomModelData(83678);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getBattleBurrito() {

        ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBattle Burrito"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aA powerful fusion of many tasty meats!"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aApplies: Strength, Resistance,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aAbsorption, Health Boost, and Heals!"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getScarliteRing() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fScarlite Ring"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Slowly restores health"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        meta.setLore(lore);
        meta.setCustomModelData(83679);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Scarlite Ring");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getSpectralSilt() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSpectral Silt"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Crafting component"));

        meta.setLore(lore);
        meta.setCustomModelData(83680);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDisintegrationTablet() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDisintegration Tablet"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Craft with dungeon loot to convert it into spectral silt"));

        meta.setLore(lore);
        meta.setCustomModelData(83681);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getBrokenHeart() {

        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBroken Heart"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Lethal damage destroys empty heart containers instead."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Sleep to regenerate heart containers."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aHow did this happen?"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Broken Heart");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getCrossNecklace() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fCross Necklace"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Increases length of invicibility when damaged."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Sleep to regenerate heart containers."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        meta.setLore(lore);
        meta.setCustomModelData(83682);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Cross Necklace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getWrathPendant() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWrath Pendant"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Gives +2 damage."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Grants sinful buff (+damage, +armor) after you deal a critical hit."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        meta.setLore(lore);
        meta.setCustomModelData(83683);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Wrath Pendant");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getPridePendant() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPride Pendant"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Gives sinful buff (+damage, +armor) while at full health."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        meta.setLore(lore);
        meta.setCustomModelData(83684);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Pride Pendant");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getGoldenCrown() {

        ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGolden Crown"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When on head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9+13 Armor"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getGluttonyPendant() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGluttony Pendant"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Eat faster."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Gives sinful buff (+damage, +armor) while you eat."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        meta.setLore(lore);
        meta.setCustomModelData(83685);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Gluttony Pendant");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getSinPendant() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSin Pendant"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Crafting Component."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        meta.setLore(lore);
        meta.setCustomModelData(83686);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Sin Pendant");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlareGun() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlare Gun"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Exactly what it sounds like"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aShine a light on the situation!"));

        meta.setLore(lore);
        meta.setCustomModelData(83687);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getFlare() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlare"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Ammo for the Flare Gun."));

        meta.setLore(lore);
        meta.setCustomModelData(83688);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getPhytoprostasiaAmulet() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPhytoprostasia Amulet"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Protects from cactus and berry bush damage"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Phytoprotasia Amulet");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83689);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getPotionRing() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion Ring"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Potion Ring");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83690);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getEmeraldRing() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fEmerald Ring"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Emerald Ring");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83691);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getEmeraldAmulet() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fEmerald Amulet"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Emerald Amulet");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83692);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getGlowingIngot() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Ingot"));

        meta.setCustomModelData(83693);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getGlowingPowder() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Powder"));

        meta.setCustomModelData(83694);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getGlowingGem() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Gem"));

        meta.setCustomModelData(83695);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getDwarfStout() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDwarf Stout"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7I might be able to remove the effects"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7by drinking some sort of potion"));

        meta.setLore(lore);
        meta.setCustomModelData(83696);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getFairyDew() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFairy Dew"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7I might be able to remove the effects"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7by drinking some sort of potion"));

        meta.setLore(lore);
        meta.setCustomModelData(83697);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getStoneNegativeGravity() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bStone of Negative Gravity"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Stone of Negative Gravity");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83698);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getStoneInertiaNull() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bStone of Inertia Null"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Stone of Inertia Null");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83699);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getStoneGreaterInertia() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bStone of Greater Inertia"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Stone of Greater Inertia");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83700);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getRingEnchantedEyes() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bRing of Enchanted Eyes"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Any)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ring of Enchanted Eyes");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83701);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getStoneSea() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bStone of the Sea"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Amulet)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Stone of the Sea");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83702);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getPolarizedStone() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bPolarized Stone"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Magnetization On"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Repell Off"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Polarized Stone");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83703);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getRingFairies() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bRing of the Fairies"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ring of the Fairies");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83704);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getRingDwarves() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bRing of the Dwarves"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Ring of the Dwarves");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83705);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getWitherRing() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bWither Ring"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Wither Ring");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83706);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getShieldHonor() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bShield of Honor"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Body)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Shield of Honor");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83707);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getMinersRing() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bMiner's Ring"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Ring)"));

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Bauble", "Miner's Ring");
        item = nbti.getItem();

        meta.setLore(lore);
        meta.setCustomModelData(83708);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getWarpedScroll() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWarp Scroll"));

        meta.setCustomModelData(83709);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getFireResistancePotion() {

        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 0), true);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion of Fire Resistance"));

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getFireDragonsteelSword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Sword"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelPickaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Pickaxe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Axe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Axe.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Axe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Shovel"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Shovel.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Shovel.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Hoe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Hoe.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Hoe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelSword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Sword"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelPickaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Pickaxe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Axe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Axe.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Axe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Shovel"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Shovel.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Shovel.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Hoe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Hoe.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Hoe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelSword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Sword"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelPickaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Pickaxe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Pickaxe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Axe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Axe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Axe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Shovel"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Shovel.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Shovel.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Hoe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = CustomConfig.getIceFireGearConfig().getDouble("Hoe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getIceFireGearConfig().getDouble("Hoe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelHelmet() {

        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Helmet"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.FireDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelChestplate() {

        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Chestplate"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.FireDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelLeggings() {

        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Leggings"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.FireDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelBoots() {

        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Boots"));
        meta.setCustomModelData(83650);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.FireDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelHelmet() {

        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Helmet"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.IceDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelChestplate() {

        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Chestplate"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.IceDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelLeggings() {

        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Leggings"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.IceDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelBoots() {

        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Boots"));
        meta.setCustomModelData(83651);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.IceDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelHelmet() {

        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Helmet"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Helmet.LightningDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Helmet.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addHelmetLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Helmet");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelChestplate() {

        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Chestplate"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.LightningDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Chestplate.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addChestplateLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Chestplate");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelLeggings() {

        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Leggings"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Leggings.LightningDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Leggings.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addLeggingsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Leggings");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelBoots() {

        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Boots"));
        meta.setCustomModelData(83652);

        Double baseArmor = CustomConfig.getIceFireGearConfig().getDouble("Boots.LightningDragonsteel.Armor");
        Double baseToughness = CustomConfig.getIceFireGearConfig().getDouble("Boots.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        Utils.addBootsLore(lore);
        Utils.addDefenseStatsLore(lore, baseArmor, baseToughness);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Boots");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Rapier"));
        meta.setCustomModelData(83654);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Katana"));
        meta.setCustomModelData(83655);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Greatsword"));
        meta.setCustomModelData(83656);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Longsword"));
        meta.setCustomModelData(83657);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Spear"));
        meta.setCustomModelData(83658);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Saber"));
        meta.setCustomModelData(83659);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Boomerang"));
        meta.setCustomModelData(83660);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.DragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Dagger"));
        meta.setCustomModelData(83661);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Glaive"));
        meta.setCustomModelData(83662);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Halberd"));
        meta.setCustomModelData(83663);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Hammer"));
        meta.setCustomModelData(83664);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Javelin"));
        meta.setCustomModelData(83665);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Lance"));
        meta.setCustomModelData(83666);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Flanged Mace"));
        meta.setCustomModelData(83667);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Pike"));
        meta.setCustomModelData(83668);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Quarterstaff"));
        meta.setCustomModelData(83669);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Throwing Axe"));
        meta.setCustomModelData(83670);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Throwing Knife"));
        meta.setCustomModelData(83671);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Warhammer"));
        meta.setCustomModelData(83672);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Battleaxe"));
        meta.setCustomModelData(83651);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.DragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83651);

        Utils.addLongbowLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83650);

        Utils.addCrossbowLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Rapier"));
        meta.setCustomModelData(83673);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Katana"));
        meta.setCustomModelData(83674);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Greatsword"));
        meta.setCustomModelData(83675);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Longsword"));
        meta.setCustomModelData(83676);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Spear"));
        meta.setCustomModelData(83677);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Saber"));
        meta.setCustomModelData(83678);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Boomerang"));
        meta.setCustomModelData(83679);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.FlamedDragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Dagger"));
        meta.setCustomModelData(83680);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Glaive"));
        meta.setCustomModelData(83681);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Halberd"));
        meta.setCustomModelData(83682);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Hammer"));
        meta.setCustomModelData(83683);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Javelin"));
        meta.setCustomModelData(83684);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Lance"));
        meta.setCustomModelData(83685);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Flanged Mace"));
        meta.setCustomModelData(83686);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Pike"));
        meta.setCustomModelData(83687);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Quarterstaff"));
        meta.setCustomModelData(83688);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Throwing Axe"));
        meta.setCustomModelData(83689);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Throwing Knife"));
        meta.setCustomModelData(83690);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Warhammer"));
        meta.setCustomModelData(83691);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Battleaxe"));
        meta.setCustomModelData(83652);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FlamedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83652);

        Utils.addLongbowLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFlamedDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83651);

        Utils.addCrossbowLore(lore);
        Utils.addFlamedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Rapier"));
        meta.setCustomModelData(83692);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Katana"));
        meta.setCustomModelData(83693);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Greatsword"));
        meta.setCustomModelData(83694);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Longsword"));
        meta.setCustomModelData(83695);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Spear"));
        meta.setCustomModelData(83696);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Saber"));
        meta.setCustomModelData(83697);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Boomerang"));
        meta.setCustomModelData(83698);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.IcedDragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Dagger"));
        meta.setCustomModelData(83699);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Glaive"));
        meta.setCustomModelData(83700);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Halberd"));
        meta.setCustomModelData(83701);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Hammer"));
        meta.setCustomModelData(83702);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Javelin"));
        meta.setCustomModelData(83703);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Lance"));
        meta.setCustomModelData(83704);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Flanged Mace"));
        meta.setCustomModelData(83705);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Pike"));
        meta.setCustomModelData(83706);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Quarterstaff"));
        meta.setCustomModelData(83707);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Throwing Axe"));
        meta.setCustomModelData(83708);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Throwing Knife"));
        meta.setCustomModelData(83709);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Warhammer"));
        meta.setCustomModelData(83710);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Battleaxe"));
        meta.setCustomModelData(83653);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IcedDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83653);

        Utils.addLongbowLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIcedDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83652);

        Utils.addCrossbowLore(lore);
        Utils.addIcedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Rapier"));
        meta.setCustomModelData(83711);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Katana"));
        meta.setCustomModelData(83712);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Greatsword"));
        meta.setCustomModelData(83713);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Longsword"));
        meta.setCustomModelData(83714);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Spear"));
        meta.setCustomModelData(83715);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Saber"));
        meta.setCustomModelData(83716);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Boomerang"));
        meta.setCustomModelData(83717);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.LightningDragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Dagger"));
        meta.setCustomModelData(83718);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Glaive"));
        meta.setCustomModelData(83719);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Halberd"));
        meta.setCustomModelData(83720);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Hammer"));
        meta.setCustomModelData(83721);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Javelin"));
        meta.setCustomModelData(83722);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Lance"));
        meta.setCustomModelData(83723);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Flanged Mace"));
        meta.setCustomModelData(83724);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Pike"));
        meta.setCustomModelData(83725);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Quarterstaff"));
        meta.setCustomModelData(83726);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Throwing Axe"));
        meta.setCustomModelData(83727);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Throwing Knife"));
        meta.setCustomModelData(83728);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Warhammer"));
        meta.setCustomModelData(83729);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Battleaxe"));
        meta.setCustomModelData(83654);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonBone.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83654);

        Utils.addLongbowLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83653);

        Utils.addCrossbowLore(lore);
        Utils.addLightningDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelRapier() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Rapier"));
        meta.setCustomModelData(83653);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelKatana() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Katana"));
        meta.setCustomModelData(83654);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelGreatsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Greatsword"));
        meta.setCustomModelData(83655);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelLongsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Longsword"));
        meta.setCustomModelData(83656);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelSpear() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Spear"));
        meta.setCustomModelData(83657);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelSaber() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Saber"));
        meta.setCustomModelData(83658);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelBoomerang() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Boomerang"));
        meta.setCustomModelData(83659);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.FireDragonsteel.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelDagger() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Dagger"));
        meta.setCustomModelData(83660);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelGlaive() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Glaive"));
        meta.setCustomModelData(83661);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelHalberd() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Halberd"));
        meta.setCustomModelData(83662);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelHammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Hammer"));
        meta.setCustomModelData(83663);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelJavelin() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Javelin"));
        meta.setCustomModelData(83664);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelLance() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Lance"));
        meta.setCustomModelData(83665);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelMace() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Flanged Mace"));
        meta.setCustomModelData(83666);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelPike() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Pike"));
        meta.setCustomModelData(83667);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelQuarterstaff() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Quarterstaff"));
        meta.setCustomModelData(83668);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelThrowingAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Throwing Axe"));
        meta.setCustomModelData(83669);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelThrowingKnife() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Throwing Knife"));
        meta.setCustomModelData(83670);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelWarhammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Warhammer"));
        meta.setCustomModelData(83671);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelBattleaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Battleaxe"));
        meta.setCustomModelData(83653);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FireDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);
        Utils.addFireDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel-Strengthened Longbow"));
        meta.setCustomModelData(83655);

        Utils.addLongbowLore(lore);
        Utils.addFireDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel-Strengthened Crossbow"));
        meta.setCustomModelData(83654);

        Utils.addCrossbowLore(lore);
        Utils.addFireDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelRapier() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Rapier"));
        meta.setCustomModelData(83672);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelKatana() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Katana"));
        meta.setCustomModelData(83673);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelGreatsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Greatsword"));
        meta.setCustomModelData(83674);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelLongsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Longsword"));
        meta.setCustomModelData(83675);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelSpear() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Spear"));
        meta.setCustomModelData(83676);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelSaber() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Saber"));
        meta.setCustomModelData(83677);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelBoomerang() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Boomerang"));
        meta.setCustomModelData(83678);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.IceDragonsteel.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelDagger() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Dagger"));
        meta.setCustomModelData(83679);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelGlaive() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Glaive"));
        meta.setCustomModelData(83680);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelHalberd() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Halberd"));
        meta.setCustomModelData(83681);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelHammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Hammer"));
        meta.setCustomModelData(83682);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelJavelin() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Javelin"));
        meta.setCustomModelData(83683);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelLance() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Lance"));
        meta.setCustomModelData(83684);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelMace() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Flanged Mace"));
        meta.setCustomModelData(83685);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelPike() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Pike"));
        meta.setCustomModelData(83686);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelQuarterstaff() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Quarterstaff"));
        meta.setCustomModelData(83687);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelThrowingAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Throwing Axe"));
        meta.setCustomModelData(83688);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelThrowingKnife() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Throwing Knife"));
        meta.setCustomModelData(83689);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelWarhammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Warhammer"));
        meta.setCustomModelData(83690);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelBattleaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Battleaxe"));
        meta.setCustomModelData(83654);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IceDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);
        Utils.addIceDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel-Strengthened Longbow"));
        meta.setCustomModelData(83656);

        Utils.addLongbowLore(lore);
        Utils.addIceDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getIceDragonsteelCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel-Strengthened Crossbow"));
        meta.setCustomModelData(83655);

        Utils.addCrossbowLore(lore);
        Utils.addIceDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelRapier() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Rapier"));
        meta.setCustomModelData(83691);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addRapierLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelKatana() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Katana"));
        meta.setCustomModelData(83692);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addKatanaLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelGreatsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Greatsword"));
        meta.setCustomModelData(83693);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGreatswordLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);



        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelLongsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Longsword"));
        meta.setCustomModelData(83694);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLongswordLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelSpear() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Spear"));
        meta.setCustomModelData(83695);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSpearLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelSaber() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Saber"));
        meta.setCustomModelData(83696);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addSaberLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelBoomerang() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Boomerang"));
        meta.setCustomModelData(83697);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Boomerang.LightningDragonsteel.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBoomerangLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addThrowableLore(lore);
        Utils.addThrowableStatsLore(lore, baseDamage);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelDagger() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Dagger"));
        meta.setCustomModelData(83698);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addDaggerLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelGlaive() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Glaive"));
        meta.setCustomModelData(83699);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addGlaiveLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelHalberd() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Halberd"));
        meta.setCustomModelData(83700);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHalberdLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelHammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Hammer"));
        meta.setCustomModelData(83701);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addHammerLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelJavelin() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Javelin"));
        meta.setCustomModelData(83702);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addJavelinLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelLance() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Lance"));
        meta.setCustomModelData(83703);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addLanceLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelMace() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Flanged Mace"));
        meta.setCustomModelData(83704);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addMaceLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore,baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelPike() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Pike"));
        meta.setCustomModelData(83705);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addPikeLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelQuarterstaff() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Quarterstaff"));
        meta.setCustomModelData(83706);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addQuarterstaffLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelThrowingAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Throwing Axe"));
        meta.setCustomModelData(83707);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingAxeLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelThrowingKnife() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Throwing Knife"));
        meta.setCustomModelData(83708);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addThrowingKnifeLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelWarhammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Warhammer"));
        meta.setCustomModelData(83709);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addWarhammerLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelBattleaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Battleaxe"));
        meta.setCustomModelData(83655);

        Double baseDamage = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = CustomConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Utils.addBattleaxeLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        lore.add("");
        Utils.addWeaponLore(lore);
        Utils.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel-Strengthened Longbow"));
        meta.setCustomModelData(83657);

        Utils.addLongbowLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getLightningDragonsteelCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel-Strengthened Crossbow"));
        meta.setCustomModelData(83656);

        Utils.addCrossbowLore(lore);
        Utils.addLightningDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public static ItemStack getFireDragonsteelBlock() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Block"));

        meta.setCustomModelData(83710);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getIceDragonsteelBlock() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Block"));

        meta.setCustomModelData(83711);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getLightningDragonsteelBlock() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Block"));

        meta.setCustomModelData(83712);
        item.setItemMeta(meta);

        return item;
    }
}