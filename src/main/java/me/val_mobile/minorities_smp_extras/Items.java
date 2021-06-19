package me.val_mobile.minorities_smp_extras;

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

    private final Utils util = new Utils();
    private final Main plugin;
    public Items(Main instance) {
        plugin = instance;
    }

    public ItemStack getFlintAxe() {

        ItemStack item = new ItemStack(Material.WOODEN_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Axe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 4.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.4D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintAxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintAxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintKnife() {

        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Knife"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -1.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintKnife.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintKnife.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintPickaxe() {

        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Pickaxe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.5D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -1.5D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintPickaxe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintPickaxe.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintShovel() {

        ItemStack item = new ItemStack(Material.WOODEN_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Shovel"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 2.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -1.6D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintShovel.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintShovel.attackSpeed") + " Attack Speed"));
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getFlintHoe() {

        ItemStack item = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fFlint Hoe"));
        meta.setCustomModelData(83650);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 0.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -1.4D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintHoe.attackDamage") + " Attack Damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + plugin.getConfig().getDouble("tools.flintHoe.attackSpeed") + " Attack Speed"));
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

    public ItemStack getDragonSkull() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Skull"));
        meta.setCustomModelData(83658);
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

        return item;
    }

    public ItemStack getTideGuardianHelmetBlue() {

        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTide Guardian Helmet"));
        meta.setCustomModelData(83662);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestlate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Bronze"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&1Deep Blue"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&2Green"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Purple"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Red"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianHelmet.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianChestplate.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianLeggings.toughness") + " Armor Toughness"));
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
        AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "generic.armor", plugin.getConfig().getDouble("armor.tideGuardianBoots.armor"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughness);
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bTeal"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7with full set"));
        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.armor") + " Armor"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + plugin.getConfig().getDouble("armor.tideGuardianBoots.toughness") + " Armor Toughness"));
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
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneAxe() {

        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Axe"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneShovel() {

        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Shovel"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneHoe() {

        ItemStack item = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Hoe"));
        meta.setCustomModelData(83650);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fDragon Bone Sword"));
        meta.setCustomModelData(83650);
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
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Ice Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
        meta.setLore(lore);

        meta.setCustomModelData(83651);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Fire Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getIceDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIced Dragon Bone Sword"));
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Fire Dragons"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bSlows and knocks back targets"));
        meta.setLore(lore);

        meta.setCustomModelData(83652);
        item.setItemMeta(meta);

        NBTItem nbti = new NBTItem(item);
        nbti.setString("Dragon Weapon", "Ice Dragon Bone");
        item = nbti.getItem();

        return item;
    }

    public ItemStack getLightningDragonBoneSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fLightning Dragonbone Sword"));
        meta.setCustomModelData(83653);
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

        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bEnder Queen's Crown"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bauble (Head)"));

        meta.setLore(lore);
        meta.setCustomModelData(83650);
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
        meta.setCustomModelData(83651);
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
        meta.setCustomModelData(83659);
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
        meta.setCustomModelData(83660);
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
        meta.setCustomModelData(83661);
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
        meta.setCustomModelData(83662);
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
        meta.setCustomModelData(83663);
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
        meta.setCustomModelData(83664);
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
        meta.setCustomModelData(83665);
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
        meta.setCustomModelData(83666);
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

        meta.setCustomModelData(83667);
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
        meta.setCustomModelData(83668);
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
        meta.setCustomModelData(83669);
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
        meta.setCustomModelData(83670);
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
        meta.setCustomModelData(83671);
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
        meta.setCustomModelData(83672);
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
        meta.setCustomModelData(83673);
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
        meta.setCustomModelData(83674);
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
        meta.setCustomModelData(83675);
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
        meta.setCustomModelData(83676);
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
        meta.setCustomModelData(83677);
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
        meta.setCustomModelData(83678);
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
        meta.setCustomModelData(83679);
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
        meta.setCustomModelData(83680);
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
        meta.setCustomModelData(83681);
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
        meta.setCustomModelData(83682);
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
        meta.setCustomModelData(83683);
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
        meta.setCustomModelData(83684);
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
        meta.setCustomModelData(83685);
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
        meta.setCustomModelData(83686);
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
        meta.setCustomModelData(83687);
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
        meta.setCustomModelData(83688);
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
        meta.setCustomModelData(83689);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getGlowingIngot() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Ingot"));

        meta.setCustomModelData(83690);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getGlowingPowder() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Powder"));

        meta.setCustomModelData(83691);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getGlowingGem() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fGlowing Gem"));

        meta.setCustomModelData(83692);
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
        meta.setCustomModelData(83693);
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
        meta.setCustomModelData(83694);
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
        meta.setCustomModelData(83695);
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
        meta.setCustomModelData(83696);
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
        meta.setCustomModelData(83697);
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
        meta.setCustomModelData(83698);
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
        meta.setCustomModelData(83699);
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
        meta.setCustomModelData(83700);
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
        meta.setCustomModelData(83701);
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
        meta.setCustomModelData(83702);
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
        meta.setCustomModelData(83703);
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
        meta.setCustomModelData(83704);
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
        meta.setCustomModelData(83705);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getWarpedScroll() {

        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWarp Scroll"));

        meta.setCustomModelData(83706);
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
}