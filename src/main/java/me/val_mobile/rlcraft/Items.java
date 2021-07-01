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

public class Items {

    private final Utils util;
    private final RLCraft plugin;
    public Items(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
    }

    public ItemStack getFlintAxe() {

        ItemStack item = new ItemStack(Material.WOODEN_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Axe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FlintAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FlintAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintAxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintKnife() {

        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Knife"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlintKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlintKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlintKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlintKnife.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintPickaxe() {

        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Pickaxe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FlintPickaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FlintPickaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintPickaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintPickaxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintShovel() {

        ItemStack item = new ItemStack(Material.WOODEN_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Shovel"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FlintShovel.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FlintShovel.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintShovel.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintShovel.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintHoe() {

        ItemStack item = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Hoe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FlintHoe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FlintHoe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintHoe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FlintHoe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getCobblestone() {

        return new ItemStack(Material.COBBLESTONE);
    }

    public ItemStack getPlantFiber() {

        ItemStack item = new ItemStack(Material.GRASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPlant Fiber"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getPlantString() {

        ItemStack item = new ItemStack(Material.STRING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPlant String"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getString() {

        return new ItemStack(Material.STRING);
    }

    public ItemStack getFlintShard() {

        ItemStack item = new ItemStack(Material.FLINT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Shard"));
        meta.setCustomModelData(93650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBone() {

        ItemStack item = new ItemStack(Material.BONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getWitherbone() {

        ItemStack item = new ItemStack(Material.BONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWitherbone"));
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleBlue() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83650);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bBlue"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleBronze() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83651);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleGray() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83652);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleGreen() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83653);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleRed() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83654);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleSapphire() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83655);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleSilver() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83656);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleWhite() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83657);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleAmethyst() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83658);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleBlack() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83659);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleCopper() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83660);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleElectric() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scales"));
        meta.setCustomModelData(83661);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScaleBlue() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83662);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScaleBronze() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83663);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScaleDeepBlue() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83664);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScaleGreen() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83665);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScalePurple() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83666);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScaleRed() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83667);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getSeaSerpentScaleTeal() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSea Serpent Scales"));
        meta.setCustomModelData(83668);

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getShinyScale() {

        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fShiny Scale"));
        meta.setCustomModelData(83669);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireDragonBlood() {

        ItemStack item = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragon Blood"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getIceDragonBlood() {

        ItemStack item = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragon Blood"));
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLightningDragonBlood() {

        ItemStack item = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragon Blood"));
        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireDragonHeart() {

        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragon Heart"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getIceDragonHeart() {

        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragon Heart"));
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLightningDragonHeart() {

        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragon Heart"));
        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireDragonSkull() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Skull"));
        meta.setCustomModelData(83658);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getIceDragonSkull() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Skull"));
        meta.setCustomModelData(83659);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLightningDragonSkull() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Skull"));
        meta.setCustomModelData(83660);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireDragonFlesh() {

        ItemStack item = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragon Flesh"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getIceDragonFlesh() {

        ItemStack item = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragon Flesh"));
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLightningDragonFlesh() {

        ItemStack item = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragon Flesh"));
        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireDragonsteelIngot() {

        ItemStack item = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Ingot"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getIceDragonsteelIngot() {

        ItemStack item = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Ingot"));
        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLightningDragonsteelIngot() {

        ItemStack item = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Ingot"));
        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonScaleHelmetBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsGray() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83653);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83653);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83653);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83653);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83654);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83654);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83654);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83654);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83655);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83655);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83655);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsSapphire() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83655);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83656);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83656);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83656);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsSilver() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83656);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83657);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83657);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83657);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsWhite() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83657);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83658);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83658);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83658);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsAmethyst() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83658);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83659);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83659);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83659);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsBlack() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83659);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83660);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83660);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83660);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsCopper() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83660);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleHelmetElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Helmet"));
        meta.setCustomModelData(83661);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleChestplateElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Chestplate"));
        meta.setCustomModelData(83661);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleLeggingsElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Leggings"));
        meta.setCustomModelData(83661);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonScaleBootsElectric() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Scale Boots"));
        meta.setCustomModelData(83661);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.DragonScaleBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.DragonScaleBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Scale Armor", "Dragon Scale Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83662);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplateBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83662);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestlate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83662);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83662);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83663);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplateBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83663);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83663);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsBronze() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83663);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83664);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplateDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83664);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83664);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsDeepBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83664);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83665);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplateGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83665);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83665);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsGreen() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83665);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetPurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83666);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplatePurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83666);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsPurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83666);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsPurple() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83666);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83667);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplateRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83667);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83667);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsRed() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83667);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianHelmetTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83668);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianChestplateTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Chestplate"));
        meta.setCustomModelData(83668);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianLeggingsTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Leggings"));
        meta.setCustomModelData(83668);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getTideGuardianBootsTeal() {

        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Boots"));
        meta.setCustomModelData(83668);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.TideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.TideGuardianBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Tide Guardian Armor", "Tide Guardian Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBonePickaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Pickaxe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.DragonBonePickaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.DragonBonePickaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBonePickaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBonePickaxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Axe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.DragonBoneAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.DragonBoneAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBoneAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBoneAxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneShovel() {

        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Shovel"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.DragonBoneShovel.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.DragonBoneShovel.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBoneShovel.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBoneShovel.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneHoe() {

        ItemStack item = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Hoe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.DragonBoneHoe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.DragonBoneHoe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBoneHoe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.DragonBoneHoe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Sword"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneBow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Bow"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlamedDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragon Bone Sword"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Ice Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragon Bone Sword"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Fire Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragon Bone Sword"));
        meta.setCustomModelData(83653);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+4 damage against Fire Dragons and Ice Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonsEye() {

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
        nbti.setString("Potion Effect Bauble", "Dragon's Eye");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getPoisonStone() {

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

    public ItemStack getPotionRingResistance() {

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
        nbti.setString("Potion Effect Bauble", "Potion Ring of Resistance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getPotionRingRegeneration() {

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
        nbti.setString("Potion Effect Bauble", "Potion Ring of Regeneration");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getPotionRingHaste() {

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
        nbti.setString("Potion Effect Bauble", "Potion Ring of Haste");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getPotionRingStrength() {

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
        nbti.setString("Potion Effect Bauble", "Potion Ring of Strength");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getPotionRingSpeed() {

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
        nbti.setString("Potion Effect Bauble", "Potion Ring of Speed");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getPotionRingJumpBoost() {

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
        nbti.setString("Potion Effect Bauble", "Potion Ring of Jump Boost");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getEnderQueensCrown() {

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

    public ItemStack getSunglasses() {

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

    public ItemStack getBalloon() {

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

    public ItemStack getCobaltShield() {

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

    public ItemStack getObsidianSkull() {

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

    public ItemStack getObsidianShield() {

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

    public ItemStack getForbiddenFruit() {

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

    public ItemStack getVitamins() {

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

    public ItemStack getRingofOverclocking() {

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

    public ItemStack getShulkerHeart() {

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

    public ItemStack getRingofFreeAction() {

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

    public ItemStack getBezoar() {

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

    public ItemStack getEnderDragonScale() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fEnder Dragon Scale"));

        meta.setCustomModelData(83670);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getCrackedBlackDragonScale() {

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

    public ItemStack getBlackDragonScale() {

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

    public ItemStack getMixedColorDragonScale() {

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

    public ItemStack getAnkhCharm() {

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

    public ItemStack getAnkhShield() {

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

    public ItemStack getIronRing() {

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

    public ItemStack getMagicMirror() {

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

    public ItemStack getRecallPotion() {

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

    public ItemStack getWormholeMirror() {

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

    public ItemStack getWormholePotion() {

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

    public ItemStack getLuckyHorseshoe() {

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

    public ItemStack getBattleBurrito() {

        ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBattle Burrito"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Negates fall damage."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aWhy did the horse need this?"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getScarliteRing() {

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
        nbti.setString("Potion Effect Bauble", "Scarlite Ring");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getSpectralSilt() {

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

    public ItemStack getDisintegrationTablet() {

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

    public ItemStack getBrokenHeart() {

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

    public ItemStack getCrossNecklace() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fCross Necklace"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Increases length of invicibility when damaged."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Sleep to regenerate heart containers."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aHow did this happen?"));
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

    public ItemStack getWrathPendant() {

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

    public ItemStack getPridePendant() {

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

    public ItemStack getGoldenCrown() {

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

    public ItemStack getGluttonyPendant() {

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

    public ItemStack getSinPendant() {

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

    public ItemStack getFlareGun() {

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

    public ItemStack getFlare() {

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

    public ItemStack getPhytoprostasiaAmulet() {

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

    public ItemStack getPotionRing() {

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

    public ItemStack getEmeraldRing() {

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

    public ItemStack getEmeraldAmulet() {

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

    public ItemStack getGlowingIngot() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Ingot"));

        meta.setCustomModelData(83693);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getGlowingPowder() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Powder"));

        meta.setCustomModelData(83694);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getGlowingGem() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Gem"));

        meta.setCustomModelData(83695);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDwarfStout() {

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

    public ItemStack getFairyDew() {

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

    public ItemStack getStoneNegativeGravity() {

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

    public ItemStack getStoneInertiaNull() {

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

    public ItemStack getStoneGreaterInertia() {

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

    public ItemStack getRingEnchantedEyes() {

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

    public ItemStack getStoneSea() {

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

    public ItemStack getPolarizedStone() {

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

    public ItemStack getRingFairies() {

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

    public ItemStack getRingDwarves() {

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

    public ItemStack getWitherRing() {

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

    public ItemStack getShieldHonor() {

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

    public ItemStack getMinersRing() {

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

    public ItemStack getWarpedScroll() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWarp Scroll"));

        meta.setCustomModelData(83709);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireResistancePotion() {

        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 0), true);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fPotion of Fire Resistance"));

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFireDragonsteelSword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Sword"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelPickaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Pickaxe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FireDragonsteelPickaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FireDragonsteelPickaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelPickaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelPickaxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Axe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FireDragonsteelAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FireDragonsteelAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelAxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Shovel"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FireDragonsteelShovel.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FireDragonsteelShovel.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelShovel.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelShovel.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Hoe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.FireDragonsteelHoe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.FireDragonsteelHoe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelHoe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.FireDragonsteelHoe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelSword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Sword"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelPickaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Pickaxe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.IceDragonsteelPickaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.IceDragonsteelPickaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelPickaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelPickaxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Axe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.IceDragonsteelAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.IceDragonsteelAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelAxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Shovel"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.IceDragonsteelShovel.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.IceDragonsteelShovel.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelShovel.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelShovel.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Hoe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.IceDragonsteelHoe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.IceDragonsteelHoe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelHoe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.IceDragonsteelHoe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelSword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Sword"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelSword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelSword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelSword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelSword.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelPickaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Pickaxe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.LightningDragonsteelPickaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.LightningDragonsteelPickaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelPickaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelPickaxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Axe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.LightningDragonsteelAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.LightningDragonsteelAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelAxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Shovel"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.LightningDragonsteelShovel.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.LightningDragonsteelShovel.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelShovel.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelShovel.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Hoe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("tools.LightningDragonsteelHoe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("tools.LightningDragonsteelHoe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelHoe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.LightningDragonsteelHoe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelHelmet() {

        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Helmet"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.FireDragonsteelHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.FireDragonsteelHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelChestplate() {

        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Chestplate"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.FireDragonsteelChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.FireDragonsteelChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelLeggings() {

        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Leggings"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.FireDragonsteelLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.FireDragonsteelLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelBoots() {

        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Boots"));
        meta.setCustomModelData(83650);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.FireDragonsteelBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.FireDragonsteelBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.FireDragonsteelBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelHelmet() {

        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Helmet"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.IceDragonsteelHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.IceDragonsteelHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelChestplate() {

        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Chestplate"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.IceDragonsteelChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.IceDragonsteelChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelLeggings() {

        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Leggings"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.IceDragonsteelLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.IceDragonsteelLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelBoots() {

        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Boots"));
        meta.setCustomModelData(83651);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.IceDragonsteelBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.IceDragonsteelBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.IceDragonsteelBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelHelmet() {

        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Helmet"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.LightningDragonsteelHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.LightningDragonsteelHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelHelmet.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Helmet");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelChestplate() {

        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Chestplate"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.LightningDragonsteelChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.LightningDragonsteelChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelChestplate.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Chestplate");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelLeggings() {

        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Leggings"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.LightningDragonsteelLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.LightningDragonsteelLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelLeggings.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Leggings");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelBoots() {

        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Boots"));
        meta.setCustomModelData(83652);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.LightningDragonsteelBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.LightningDragonsteelBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.LightningDragonsteelBoots.toughness") + " Armor Toughness"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragonsteel Armor", "Dragonsteel Boots");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Rapier"));
        meta.setCustomModelData(83654);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Katana"));
        meta.setCustomModelData(83655);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Greatsword"));
        meta.setCustomModelData(83656);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Longsword"));
        meta.setCustomModelData(83657);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Spear"));
        meta.setCustomModelData(83658);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Saber"));
        meta.setCustomModelData(83659);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Boomerang"));
        meta.setCustomModelData(83660);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Dagger"));
        meta.setCustomModelData(83661);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Glaive"));
        meta.setCustomModelData(83662);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Halberd"));
        meta.setCustomModelData(83663);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Hammer"));
        meta.setCustomModelData(83664);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Javelin"));
        meta.setCustomModelData(83665);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Lance"));
        meta.setCustomModelData(83666);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Flanged Mace"));
        meta.setCustomModelData(83667);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Pike"));
        meta.setCustomModelData(83668);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBonePike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBonePike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBonePike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBonePike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Quarterstaff"));
        meta.setCustomModelData(83669);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Throwing Axe"));
        meta.setCustomModelData(83670);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Throwing Knife"));
        meta.setCustomModelData(83671);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Warhammer"));
        meta.setCustomModelData(83672);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone Battleaxe"));
        meta.setCustomModelData(83651);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.DragonBoneBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.DragonBoneBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.DragonBoneBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83651);

        util.addLongbowLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83650);

        util.addCrossbowLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Rapier"));
        meta.setCustomModelData(83673);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Katana"));
        meta.setCustomModelData(83674);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Greatsword"));
        meta.setCustomModelData(83675);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Longsword"));
        meta.setCustomModelData(83676);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Spear"));
        meta.setCustomModelData(83677);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Saber"));
        meta.setCustomModelData(83678);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Boomerang"));
        meta.setCustomModelData(83679);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Dagger"));
        meta.setCustomModelData(83680);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Glaive"));
        meta.setCustomModelData(83681);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Halberd"));
        meta.setCustomModelData(83682);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Hammer"));
        meta.setCustomModelData(83683);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Javelin"));
        meta.setCustomModelData(83684);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Lance"));
        meta.setCustomModelData(83685);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Flanged Mace"));
        meta.setCustomModelData(83686);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Pike"));
        meta.setCustomModelData(83687);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBonePike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBonePike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBonePike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBonePike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Quarterstaff"));
        meta.setCustomModelData(83688);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Throwing Axe"));
        meta.setCustomModelData(83689);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Throwing Knife"));
        meta.setCustomModelData(83690);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Warhammer"));
        meta.setCustomModelData(83691);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone Battleaxe"));
        meta.setCustomModelData(83652);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FlamedDragonBoneBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FlamedDragonBoneBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FlamedDragonBoneBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83652);

        util.addLongbowLore(lore);
        util.addFlamedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlamedDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlamed Dragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83651);

        util.addCrossbowLore(lore);
        util.addFlamedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Rapier"));
        meta.setCustomModelData(83692);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Katana"));
        meta.setCustomModelData(83693);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Greatsword"));
        meta.setCustomModelData(83694);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Longsword"));
        meta.setCustomModelData(83695);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Spear"));
        meta.setCustomModelData(83696);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Saber"));
        meta.setCustomModelData(83697);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Boomerang"));
        meta.setCustomModelData(83698);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Dagger"));
        meta.setCustomModelData(83699);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Glaive"));
        meta.setCustomModelData(83700);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Halberd"));
        meta.setCustomModelData(83701);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Hammer"));
        meta.setCustomModelData(83702);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Javelin"));
        meta.setCustomModelData(83703);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Lance"));
        meta.setCustomModelData(83704);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Flanged Mace"));
        meta.setCustomModelData(83705);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Pike"));
        meta.setCustomModelData(83706);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBonePike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBonePike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBonePike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBonePike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Quarterstaff"));
        meta.setCustomModelData(83707);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Throwing Axe"));
        meta.setCustomModelData(83708);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Throwing Knife"));
        meta.setCustomModelData(83709);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Warhammer"));
        meta.setCustomModelData(83710);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone Battleaxe"));
        meta.setCustomModelData(83653);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IcedDragonBoneBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IcedDragonBoneBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IcedDragonBoneBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83653);

        util.addLongbowLore(lore);
        util.addIcedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIcedDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83652);

        util.addCrossbowLore(lore);
        util.addIcedDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneRapier() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Rapier"));
        meta.setCustomModelData(83711);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneKatana() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Katana"));
        meta.setCustomModelData(83712);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneGreatsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Greatsword"));
        meta.setCustomModelData(83713);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneLongsword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Longsword"));
        meta.setCustomModelData(83714);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneSpear() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Spear"));
        meta.setCustomModelData(83715);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneSaber() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Saber"));
        meta.setCustomModelData(83716);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneBoomerang() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Boomerang"));
        meta.setCustomModelData(83717);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneDagger() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Dagger"));
        meta.setCustomModelData(83718);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneGlaive() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Glaive"));
        meta.setCustomModelData(83719);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneHalberd() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Halberd"));
        meta.setCustomModelData(83720);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneHammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Hammer"));
        meta.setCustomModelData(83721);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneJavelin() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Javelin"));
        meta.setCustomModelData(83722);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneLance() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Lance"));
        meta.setCustomModelData(83723);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneMace() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Flanged Mace"));
        meta.setCustomModelData(83724);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBonePike() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Pike"));
        meta.setCustomModelData(83725);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBonePike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBonePike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBonePike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBonePike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneQuarterstaff() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Quarterstaff"));
        meta.setCustomModelData(83726);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneThrowingAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Throwing Axe"));
        meta.setCustomModelData(83727);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneThrowingKnife() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Throwing Knife"));
        meta.setCustomModelData(83728);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneWarhammer() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Warhammer"));
        meta.setCustomModelData(83729);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneBattleaxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Battleaxe"));
        meta.setCustomModelData(83654);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonBoneBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonBoneBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonBoneBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone-Strengthened Longbow"));
        meta.setCustomModelData(83654);

        util.addLongbowLore(lore);
        util.addLightningDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone-Strengthened Crossbow"));
        meta.setCustomModelData(83653);

        util.addCrossbowLore(lore);
        util.addLightningDragonBoneLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragon Bone");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelRapier() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Rapier"));
        meta.setCustomModelData(83653);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelKatana() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Katana"));
        meta.setCustomModelData(83654);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelGreatsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Greatsword"));
        meta.setCustomModelData(83655);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelLongsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Longsword"));
        meta.setCustomModelData(83656);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelSpear() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Spear"));
        meta.setCustomModelData(83657);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelSaber() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Saber"));
        meta.setCustomModelData(83658);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelBoomerang() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Boomerang"));
        meta.setCustomModelData(83659);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelDagger() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Dagger"));
        meta.setCustomModelData(83660);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelGlaive() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Glaive"));
        meta.setCustomModelData(83661);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelHalberd() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Halberd"));
        meta.setCustomModelData(83662);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelHammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Hammer"));
        meta.setCustomModelData(83663);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelJavelin() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Javelin"));
        meta.setCustomModelData(83664);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelLance() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Lance"));
        meta.setCustomModelData(83665);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelMace() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Flanged Mace"));
        meta.setCustomModelData(83666);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelPike() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Pike"));
        meta.setCustomModelData(83667);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelPike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelPike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelPike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelPike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelQuarterstaff() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Quarterstaff"));
        meta.setCustomModelData(83668);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelThrowingAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Throwing Axe"));
        meta.setCustomModelData(83669);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelThrowingKnife() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Throwing Knife"));
        meta.setCustomModelData(83670);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelWarhammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Warhammer"));
        meta.setCustomModelData(83671);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelBattleaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Battleaxe"));
        meta.setCustomModelData(83653);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.FireDragonsteelBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.FireDragonsteelBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.FireDragonsteelBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel-Strengthened Longbow"));
        meta.setCustomModelData(83655);

        util.addLongbowLore(lore);
        util.addFireDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel-Strengthened Crossbow"));
        meta.setCustomModelData(83654);

        util.addCrossbowLore(lore);
        util.addFireDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelRapier() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Rapier"));
        meta.setCustomModelData(83672);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelKatana() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Katana"));
        meta.setCustomModelData(83673);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelGreatsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Greatsword"));
        meta.setCustomModelData(83674);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelLongsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Longsword"));
        meta.setCustomModelData(83675);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelSpear() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Spear"));
        meta.setCustomModelData(83676);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelSaber() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Saber"));
        meta.setCustomModelData(83677);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelBoomerang() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Boomerang"));
        meta.setCustomModelData(83678);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelDagger() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Dagger"));
        meta.setCustomModelData(83679);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelGlaive() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Glaive"));
        meta.setCustomModelData(83680);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelHalberd() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Halberd"));
        meta.setCustomModelData(83681);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelHammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Hammer"));
        meta.setCustomModelData(83682);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelJavelin() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Javelin"));
        meta.setCustomModelData(83683);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelLance() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Lance"));
        meta.setCustomModelData(83684);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelMace() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Flanged Mace"));
        meta.setCustomModelData(83685);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelPike() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Pike"));
        meta.setCustomModelData(83686);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelPike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelPike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelPike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelPike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelQuarterstaff() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Quarterstaff"));
        meta.setCustomModelData(83687);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelThrowingAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Throwing Axe"));
        meta.setCustomModelData(83688);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelThrowingKnife() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Throwing Knife"));
        meta.setCustomModelData(83689);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelWarhammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Warhammer"));
        meta.setCustomModelData(83690);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelBattleaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Battleaxe"));
        meta.setCustomModelData(83654);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.IceDragonsteelBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.IceDragonsteelBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.IceDragonsteelBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel-Strengthened Longbow"));
        meta.setCustomModelData(83656);

        util.addLongbowLore(lore);
        util.addIceDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel-Strengthened Crossbow"));
        meta.setCustomModelData(83655);

        util.addCrossbowLore(lore);
        util.addIceDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelRapier() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Rapier"));
        meta.setCustomModelData(83691);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelRapier.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelRapier.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelRapier.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelRapier.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Rapier");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelKatana() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Katana"));
        meta.setCustomModelData(83692);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelKatana.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelKatana.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelKatana.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelKatana.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Katana");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelGreatsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Greatsword"));
        meta.setCustomModelData(83693);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelGreatsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelGreatsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelGreatsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelGreatsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Greatsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelLongsword() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Longsword"));
        meta.setCustomModelData(83694);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelLongsword.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelLongsword.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelLongsword.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelLongsword.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longsword");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelSpear() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Spear"));
        meta.setCustomModelData(83695);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelSpear.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelSpear.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelSpear.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelSpear.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Spear");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelSaber() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Saber"));
        meta.setCustomModelData(83696);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelSaber.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelSaber.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelSaber.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelSaber.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Saber");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelBoomerang() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Boomerang"));
        meta.setCustomModelData(83697);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelBoomerang.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelBoomerang.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelBoomerang.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelBoomerang.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Boomerang");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelDagger() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Dagger"));
        meta.setCustomModelData(83698);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelDagger.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelDagger.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelDagger.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelDagger.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelGlaive() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Glaive"));
        meta.setCustomModelData(83699);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelGlaive.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelGlaive.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelGlaive.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelGlaive.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Glaive");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelHalberd() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Halberd"));
        meta.setCustomModelData(83700);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelHalberd.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelHalberd.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelHalberd.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelHalberd.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Halberd");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelHammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Hammer"));
        meta.setCustomModelData(83701);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelHammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelHammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelHammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelHammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Hammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelJavelin() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Javelin"));
        meta.setCustomModelData(83702);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelJavelin.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelJavelin.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelJavelin.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelJavelin.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Javelin");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelLance() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Lance"));
        meta.setCustomModelData(83703);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelLance.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelLance.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelLance.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelLance.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Lance");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelMace() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Flanged Mace"));
        meta.setCustomModelData(83704);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelMace.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelMace.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelMace.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelMace.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Mace");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelPike() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Pike"));
        meta.setCustomModelData(83705);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelPike.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelPike.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelPike.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelPike.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Pike");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelQuarterstaff() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Quarterstaff"));
        meta.setCustomModelData(83706);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelQuarterstaff.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelQuarterstaff.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelQuarterstaff.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelQuarterstaff.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Quarterstaff");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelThrowingAxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Throwing Axe"));
        meta.setCustomModelData(83707);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingAxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingAxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingAxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Axe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelThrowingKnife() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Throwing Knife"));
        meta.setCustomModelData(83708);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingKnife.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingKnife.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelThrowingKnife.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Throwing Knife");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelWarhammer() {

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Warhammer"));
        meta.setCustomModelData(83709);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelWarhammer.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelWarhammer.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelWarhammer.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelWarhammer.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Warhammer");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelBattleaxe() {

        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Battleaxe"));
        meta.setCustomModelData(83655);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", plugin.getConfig().getDouble("weapons.LightningDragonsteelBattleaxe.attackDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -plugin.getConfig().getDouble("weapons.LightningDragonsteelBattleaxe.attackSpeed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelBattleaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("weapons.LightningDragonsteelBattleaxe.attackSpeed") + " Attack Speed"));

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Battleaxe");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelLongbow() {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel-Strengthened Longbow"));
        meta.setCustomModelData(83657);

        util.addLongbowLore(lore);
        util.addLightningDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Longbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelCrossbow() {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel-Strengthened Crossbow"));
        meta.setCustomModelData(83656);

        util.addCrossbowLore(lore);
        util.addLightningDragonsteelLore(lore);

        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        nbti.setString("Spartan's Weapon", "Crossbow");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelBlock() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Block"));

        meta.setCustomModelData(83710);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getIceDragonsteelBlock() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Block"));

        meta.setCustomModelData(83711);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLightningDragonsteelBlock() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Block"));

        meta.setCustomModelData(83712);
        item.setItemMeta(meta);

        return item;
    }
}