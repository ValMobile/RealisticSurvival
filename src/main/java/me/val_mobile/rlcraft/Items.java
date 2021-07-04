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
    private final CustomConfig customConfig;
    public Items(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        customConfig = new CustomConfig(instance);
    }

    public ItemStack getFlintAxe() {

        ItemStack item = new ItemStack(Material.WOODEN_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Axe"));
        meta.setCustomModelData(83650);

        Double baseDamage = customConfig.getNoTreePunchingConfig().getDouble("Axe.Flint.AttackDamage");
        Double baseSpeed = customConfig.getNoTreePunchingConfig().getDouble("Axe.Flint.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Spartan's Weapon", "Dagger");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFlintKnife() {

        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Knife"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getNoTreePunchingConfig().getDouble("Knife.Flint.AttackDamage");
        Double baseSpeed = customConfig.getNoTreePunchingConfig().getDouble("Knife.Flint.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintPickaxe() {

        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Pickaxe"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getNoTreePunchingConfig().getDouble("Pickaxe.Flint.AttackDamage");
        Double baseSpeed = customConfig.getNoTreePunchingConfig().getDouble("Pickaxe.Flint.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintShovel() {

        ItemStack item = new ItemStack(Material.WOODEN_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Shovel"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getNoTreePunchingConfig().getDouble("Shovel.Flint.AttackDamage");
        Double baseSpeed = customConfig.getNoTreePunchingConfig().getDouble("Shovel.Flint.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintHoe() {

        ItemStack item = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Hoe"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getNoTreePunchingConfig().getDouble("Hoe.Flint.AttackDamage");
        Double baseSpeed = customConfig.getNoTreePunchingConfig().getDouble("Hoe.Flint.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Gray"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Emerald"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness",baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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


        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Sapphire"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Silver"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&fWhite"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&dAmethyst"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&8Black"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Copper"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.DragonScale.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Electric Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.TideGuardian.Toughness");

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
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.TideGuardian.Toughness");

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
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.TideGuardian.Toughness");

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
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.TideGuardian.Toughness");

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
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);
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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Pickaxe.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Pickaxe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Axe"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Axe.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Axe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneShovel() {

        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Shovel"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Shovel.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Shovel.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneHoe() {

        ItemStack item = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Hoe"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Hoe.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Hoe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Sword"));
        meta.setCustomModelData(83650);
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Dragon Bone");
        nbti.setString("Spartan's Weapon", "Bow");
        item = nbti.getItem();

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aA powerful fusion of many tasty meats!"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aApplies: Strength, Resistance,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&aAbsorption, Health Boost, and Heals!"));

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Pickaxe.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Pickaxe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Axe.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Axe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Shovel"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Shovel.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Shovel.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getFireDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFire Dragonsteel Hoe"));
        meta.setCustomModelData(83650);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Hoe.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Hoe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Pickaxe.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Pickaxe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Axe.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Axe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Shovel"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Shovel.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Shovel.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIce Dragonsteel Hoe"));
        meta.setCustomModelData(83651);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Hoe.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Hoe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Sword.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Pickaxe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Pickaxe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Axe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Axe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelShovel() {

        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Shovel"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Shovel.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Shovel.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

        meta.setLore(lore);

        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Lightning Dragonsteel");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonsteelHoe() {

        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonsteel Hoe"));
        meta.setCustomModelData(83652);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
        Double baseDamage = customConfig.getIceFireGearConfig().getDouble("Hoe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getIceFireGearConfig().getDouble("Hoe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.FireDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.FireDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.FireDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.FireDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.FireDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.IceDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.IceDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.IceDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.IceDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.IceDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Helmet.LightningDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Helmet.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addHelmetLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Chestplate.LightningDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Chestplate.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addChestplateLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Leggings.LightningDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Leggings.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addLeggingsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseArmor = customConfig.getIceFireGearConfig().getDouble("Boots.LightningDragonsteel.Armor");
        Double baseToughness = customConfig.getIceFireGearConfig().getDouble("Boots.LightningDragonsteel.Toughness");

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", baseArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", baseToughness, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        util.addBootsLore(lore);
        util.addDefenseStatsLore(lore, baseArmor, baseToughness);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.DragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.DragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.DragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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
        nbti.setString("Dragon Weapon", "Dragon Bone");
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
        nbti.setString("Dragon Weapon", "Dragon Bone");
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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.FlamedDragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FlamedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FlamedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addFlamedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.IcedDragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IcedDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IcedDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addIcedDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.LightningDragonBone.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonBone.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonBone.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addLightningDragonBoneLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.FireDragonsteel.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FireDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.FireDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addFireDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.IceDragonsteel.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IceDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.IceDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addIceDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Rapier.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addRapierLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Katana.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addKatanaLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Greatsword.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGreatswordLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);



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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Longsword.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLongswordLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Spear.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSpearLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Saber.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addSaberLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Boomerang.LightningDragonsteel.AttackDamage");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBoomerangLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addThrowableLore(lore);
        util.addThrowableStatsLore(lore, baseDamage);

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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Dagger.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addDaggerLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Glaive.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addGlaiveLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Halberd.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHalberdLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Hammer.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addHammerLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Javelin.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addJavelinLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Lance.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addLanceLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Mace.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addMaceLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore,baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Pike.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addPikeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Quarterstaff.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addQuarterstaffLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingAxe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingAxeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("ThrowingKnife.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addThrowingKnifeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Warhammer.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addWarhammerLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);


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

        Double baseDamage = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonsteel.AttackDamage");
        Double baseSpeed = customConfig.getSpartanWeaponryConfig().getDouble("Battleaxe.LightningDragonsteel.AttackSpeed");

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1D + baseDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4D + baseSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        util.addBattleaxeLore(lore);
        util.addLightningDragonsteelLore(lore);

        lore.add("");
        util.addWeaponLore(lore);
        util.addMeleeStatsLore(lore, baseDamage, baseSpeed);

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