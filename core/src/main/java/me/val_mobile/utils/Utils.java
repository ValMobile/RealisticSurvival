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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanweaponry.KbTask;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class Utils {

    public static final double ATTACK_DAMAGE_CONSTANT = -1.0;
    public static final double ATTACK_SPEED_CONSTANT = -4.0;

    private final RealisticSurvivalPlugin plugin;

    static InternalsProvider internals;

    static {
        try {
            String packageName = Utils.class.getPackage().getName();
            String internalsName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            internals = (InternalsProvider) Class.forName(packageName + "." + internalsName).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException | NoSuchMethodException | InvocationTargetException exception) {
            Bukkit.getLogger().log(Level.SEVERE, "NMS Util could not find a valid implementation for this server version.");
        }
    }

    public Utils(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

    public static Vector randomizeVelocity(Vector velocity) {
        Vector newVelocity = velocity.clone();
        Random r = new Random();

        newVelocity.setX((newVelocity.getX() * Math.random()) + 0.5);
        newVelocity.setY((newVelocity.getY() * Math.random()) + 0.5);
        newVelocity.setZ((newVelocity.getZ() * Math.random()) + 0.5);

        return newVelocity;
    }

    public static String toLowercaseAttributeName(String name) {
        switch (name) {
            case "GENERIC_ATTACK_DAMAGE":
                return "generic.attackDamage";
            case "GENERIC_ATTACK_SPEED":
                return "generic.attackSpeed";
            case "GENERIC_ARMOR":
                return "generic.armor";
            case "GENERIC_ARMOR_TOUGHNESS":
                return "generic.armorToughness";
            default:
                return null;
        }
    }

    public static double getCorrectAttributeValue(Attribute attribute, double requestedValue) {
        switch (attribute) {
            case GENERIC_ATTACK_DAMAGE:
                return requestedValue + ATTACK_DAMAGE_CONSTANT;
            case GENERIC_ATTACK_SPEED:
                return requestedValue + ATTACK_SPEED_CONSTANT;
            case GENERIC_ARMOR:
            case GENERIC_ARMOR_TOUGHNESS:
                return requestedValue;
            default:
                return Double.parseDouble(null);
        }
    }

    public static boolean isHelmet(Material material) {
        switch (material) {
            case CHAINMAIL_HELMET:
            case DIAMOND_HELMET:
            case GOLDEN_HELMET:
            case IRON_HELMET:
            case LEATHER_HELMET:
            case NETHERITE_HELMET:
            case TURTLE_HELMET: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isChestplate(Material material) {
        switch (material) {
            case CHAINMAIL_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case IRON_CHESTPLATE:
            case LEATHER_CHESTPLATE:
            case NETHERITE_CHESTPLATE: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isLeggings(Material material) {
        switch (material) {
            case CHAINMAIL_LEGGINGS:
            case DIAMOND_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case IRON_LEGGINGS:
            case LEATHER_LEGGINGS:
            case NETHERITE_LEGGINGS: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isBoots(Material material) {
        switch (material) {
            case CHAINMAIL_BOOTS:
            case DIAMOND_BOOTS:
            case GOLDEN_BOOTS:
            case IRON_BOOTS:
            case LEATHER_BOOTS:
            case NETHERITE_BOOTS: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isArmor(Material material) {
        return (material.toString().contains("HELMET") ||
                material.toString().contains("CHESTPLATE") ||
                material.toString().contains("LEGGINGS") ||
                material.toString().contains("BOOTS"));
    }

    public static EquipmentSlot getCorrectEquipmentSlot(Attribute attribute, Material material) {
        switch (attribute) {
            case GENERIC_ATTACK_DAMAGE:
            case GENERIC_ATTACK_SPEED:
                return EquipmentSlot.HAND;
            case GENERIC_ARMOR:
            case GENERIC_ARMOR_TOUGHNESS:
                if (isHelmet(material)) {
                    return EquipmentSlot.HEAD;
                }
                else if (isChestplate(material)) {
                    return EquipmentSlot.CHEST;
                }
                else if (isLeggings(material)) {
                    return EquipmentSlot.LEGS;
                }
                else if (isBoots(material)) {
                    return EquipmentSlot.FEET;
                }
                return null;
            default:
                return null;
        }
    }

    public static String translateInformalAttributeName(String name) {
        switch (name) {
            case "AttackDamage":
                return "GENERIC_ATTACK_DAMAGE";
            case "AttackSpeed":
                return "GENERIC_ATTACK_SPEED";
            case "Armor":
                return "GENERIC_ARMOR";
            case "Toughness":
                return "GENERIC_ARMOR_TOUGHNESS";
            default:
                return null;
        }
    }

    public static String getMinecraftEnchName(String keyName) {
        switch (keyName) {
            case "ARROW_DAMAGE":
                return "Power";
            case "ARROW_FIRE":
                return "Flame";
            case "ARROW_INFINITE":
                return "Infinity";
            case "ARROW_KNOCKBACK":
                return "Punch";
            case "BINDING_CURSE":
                return "Curse of Binding";
            case "DAMAGE_ALL":
                return "Sharpness";
            case "DAMAGE_ARTHROPODS":
                return "Bane of Arthropods";
            case "DAMAGE_UNDEAD":
                return "Smite";
            case "DEPTH_STRIDER":
                return "Depth Strider";
            case "DIG_SPEED":
                return "Efficiency";
            case "DURABILITY":
                return "Unbreaking";
            case "FIRE_ASPECT":
                return "Fire Aspect";
            case "FROST_WALKER":
                return "Frost Walker";
            case "KNOCKBACK":
                return "Knockback";
            case "LOOT_BONUS_BLOCKS":
                return "Fortune";
            case "LOOT_BONUS_MOBS":
                return "Looting";
            case "LUCK":
                return "Luck of the Sea";
            case "LURE":
                return "Lure";
            case "MENDING":
                return "Mending";
            case "OXYGEN":
                return "Respiration";
            case "PROTECTION_ENVIRONMENTAL":
                return "Protection";
            case "PROTECTION_EXPLOSIONS":
                return "Blast Protection";
            case "PROTECTION_FALL":
                return "Feather Falling";
            case "PROTECTION_FIRE":
                return "Fire Protection";
            case "PROTECTION_PROJECTILE":
                return "Projectile Protection";
            case "SILK_TOUCH":
                return "Silk Touch";
            case "SWEEPING_EDGE":
                return "Sweeping Edge";
            case "THORNS":
                return "Thorns";
            case "VANISHING_CURSE":
                return "Curse of Vanishing";
            case "WATER_WORKER":
                return "Aqua Affinity";
            case "SOUL_SPEED":
                return "Soul Speed";
            case "PIERCING":
                return "Piercing";
            case "QUICK_CHARGE":
                return "Quick Charge";
            case "MULTISHOT":
                return "Multishot";
            case "CHANNELING":
                return "Channeling";
            case "RIPTIDE":
                return "Riptide";
            case "IMPALING":
                return "Impaling";
            case "LOYALTY":
                return "Loyalty";
            default:
                return null;
        }
    }

    public static boolean isHoldingAxe(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (isItemReal(itemMainHand)) {
            Material mat = itemMainHand.getType();
            switch (mat) {
                case DIAMOND_AXE:
                case IRON_AXE:
                case WOODEN_AXE:
                case STONE_AXE:
                case GOLDEN_AXE:
                case NETHERITE_AXE: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean isHoldingPickaxe(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (isItemReal(itemMainHand)) {
            Material mat = itemMainHand.getType();
            switch (mat) {
                case DIAMOND_PICKAXE:
                case IRON_PICKAXE:
                case WOODEN_PICKAXE:
                case STONE_PICKAXE:
                case GOLDEN_PICKAXE:
                case NETHERITE_PICKAXE: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean hasArmor(Entity entity) {
        if (entity instanceof LivingEntity) {
            ItemStack[] armor = ((LivingEntity) entity).getEquipment().getArmorContents();
            for (ItemStack item : armor) {
                if (isItemReal(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasChestplate(Entity entity) {
        if (entity instanceof LivingEntity) {
            ItemStack chestplate = ((LivingEntity) entity).getEquipment().getChestplate();
            return isItemReal(chestplate);
        }
        return false;
    }

    public static Color valueOfColor(String color) {
        switch (color) {
            case "AQUA":
                return Color.AQUA;
            case "BLACK":
                return Color.BLACK;
            case "BLUE":
                return Color.BLUE;
            case "FUCHSIA":
                return Color.FUCHSIA;
            case "GRAY":
                return Color.GRAY;
            case "GREEN":
                return Color.GREEN;
            case "LIME":
                return Color.LIME;
            case "MAROON":
                return Color.MAROON;
            case "NAVY":
                return Color.NAVY;
            case "OLIVE":
                return Color.OLIVE;
            case "ORANGE":
                return Color.ORANGE;
            case "PURPLE":
                return Color.PURPLE;
            case "RED":
                return Color.RED;
            case "SILVER":
                return Color.SILVER;
            case "TEAL":
                return Color.TEAL;
            case "WHITE":
                return Color.WHITE;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return null;
        }
    }

    public static PotionEffectType valueOfPotionEffectType(String potionEffectType) {
        switch (potionEffectType) {
            case "ABSORPTION":
                return PotionEffectType.ABSORPTION;
            case "BAD_OMEN":
                return PotionEffectType.BAD_OMEN;
            case "BLINDNESS":
                return PotionEffectType.BLINDNESS;
            case "CONDUIT_POWER":
                return PotionEffectType.CONDUIT_POWER;
            case "CONFUSION":
                return PotionEffectType.CONFUSION;
            case "DAMAGE_RESISTANCE":
                return PotionEffectType.DAMAGE_RESISTANCE;
            case "DOLPHINS_GRACE":
                return PotionEffectType.DOLPHINS_GRACE;
            case "FAST_DIGGING":
                return PotionEffectType.FAST_DIGGING;
            case "FIRE_RESISTANCE":
                return PotionEffectType.FIRE_RESISTANCE;
            case "GLOWING":
                return PotionEffectType.GLOWING;
            case "HARM":
                return PotionEffectType.HARM;
            case "HEAL":
                return PotionEffectType.HEAL;
            case "HEALTH_BOOST":
                return PotionEffectType.HEALTH_BOOST;
            case "HERO_OF_THE_VILLAGE":
                return PotionEffectType.HERO_OF_THE_VILLAGE;
            case "HUNGER":
                return PotionEffectType.HUNGER;
            case "INCREASE_DAMAGE":
                return PotionEffectType.INCREASE_DAMAGE;
            case "INVISIBILITY":
                return PotionEffectType.INVISIBILITY;
            case "JUMP":
                return PotionEffectType.JUMP;
            case "LEVITATION":
                return PotionEffectType.LEVITATION;
            case "LUCK":
                return PotionEffectType.LUCK;
            case "NIGHT_VISION":
                return PotionEffectType.NIGHT_VISION;
            case "POISON":
                return PotionEffectType.POISON;
            case "REGENERATION":
                return PotionEffectType.REGENERATION;
            case "SATURATION":
                return PotionEffectType.SATURATION;
            case "SLOW":
                return PotionEffectType.SLOW;
            case "SLOW_DIGGING":
                return PotionEffectType.SLOW_DIGGING;
            case "SPEED":
                return PotionEffectType.SPEED;
            case "UNLUCK":
                return PotionEffectType.UNLUCK;
            case "WATER_BREATHING":
                return PotionEffectType.WATER_BREATHING;
            case "WEAKNESS":
                return PotionEffectType.WEAKNESS;
            case "WITHER":
                return PotionEffectType.WITHER;
            default:
                return null;
        }
    }

    public static boolean isItemReal(ItemStack item) {
        return !(item == null || item.getType() == Material.AIR);
    }

    public <T> void addNbtTag(Entity entity, String key, T value, PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        entity.getPersistentDataContainer().set(nkey, type, value);
    }

    public <T> void addNbtTag(ItemStack item, String key, T value, PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.getPersistentDataContainer().set(nkey, type, value);

        item.setItemMeta(itemMeta);
    }

    public <T> T getNbtTag(Entity entity, String key, PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = entity.getPersistentDataContainer();

        if(container.has(nkey, PersistentDataType.STRING)) {
            return container.get(nkey, type);
        }

        return null;
    }

    public <T> T getNbtTag(ItemStack item, String key, PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();

        if(container.has(nkey, PersistentDataType.STRING)) {
            return container.get(nkey, type);
        }

        return null;
    }

    public boolean hasNbtTag(Entity entity, String key) {
        NamespacedKey nkey = new NamespacedKey(plugin, key);

        return entity.getPersistentDataContainer().has(nkey, PersistentDataType.STRING);
    }

    public boolean hasNbtTag(ItemStack item, String key) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();

        return itemMeta.getPersistentDataContainer().has(nkey, PersistentDataType.STRING);
    }

    public void freezeEntity(Entity entity) {
        new KbTask(plugin, entity, 0D).start();
    }

    public static boolean doublesEquals(double v, double v1) {
        double tolerance = 0.001;

        return Math.abs(v - v1) <= tolerance;
    }

    public static HashMap<String, Tag> getTags() {
        return internals.getTags();
    }

    public static boolean isSourceLiquid(Block block) {
        BlockData blockData = block.getBlockData();

        if (blockData instanceof Levelled)
            return ((Levelled) blockData).getLevel() == 0;
        return false;
    }

    public static double getDayMultiplier(World world) {
        return (world.getEnvironment() == World.Environment.NORMAL ? Math.sin(2 * Math.PI / 24000 * world.getTime() - 3500) : 1D);
    }

    public static boolean isExposedToSky(Player player) {
        Location loc = player.getLocation().clone();

        int highestY = loc.getWorld().getHighestBlockYAt(loc);

        return loc.getY() > highestY;
    }

    public static void discoverRecipe(Player p, Recipe r) {
        if (r instanceof ShapedRecipe) {
            if (!p.hasDiscoveredRecipe(((ShapedRecipe) r).getKey()))
                p.discoverRecipe(((ShapedRecipe) r).getKey());
        }
        else if (r instanceof ShapelessRecipe) {
            if (!p.hasDiscoveredRecipe(((ShapelessRecipe) r).getKey()))
                p.discoverRecipe(((ShapelessRecipe) r).getKey());
        }
        else if (r instanceof SmithingRecipe) {
            if (!p.hasDiscoveredRecipe(((SmithingRecipe) r).getKey()))
                p.discoverRecipe(((SmithingRecipe) r).getKey());
        }
        else if (r instanceof FurnaceRecipe) {
            if (!p.hasDiscoveredRecipe(((FurnaceRecipe) r).getKey()))
                p.discoverRecipe(((FurnaceRecipe) r).getKey());
        }
        else if (r instanceof CampfireRecipe) {
            if (!p.hasDiscoveredRecipe(((CampfireRecipe) r).getKey()))
                p.discoverRecipe(((CampfireRecipe) r).getKey());
        }
        else if (r instanceof BlastingRecipe) {
            if (!p.hasDiscoveredRecipe(((BlastingRecipe) r).getKey()))
                p.discoverRecipe(((BlastingRecipe) r).getKey());
        }
        else if (r instanceof SmokingRecipe) {
            if (!p.hasDiscoveredRecipe(((SmokingRecipe) r).getKey()))
                p.discoverRecipe(((SmokingRecipe) r).getKey());
        }
        else if (r instanceof StonecuttingRecipe) {
            if (!p.hasDiscoveredRecipe(((StonecuttingRecipe) r).getKey()))
                p.discoverRecipe(((StonecuttingRecipe) r).getKey());
        }
    }

    public static double getNumberFromUpdate(String text) {
        while (text.indexOf(".") != text.lastIndexOf(".")) {
            text = text.substring(0, text.lastIndexOf(".")) + text.substring(text.lastIndexOf(".") + 1);
        }
        return Double.valueOf(text);
    }

    public static void harvestFortune(ConfigurationSection section, ItemStack drop, ItemStack tool, Location loc) {
        Random r = new Random();

        int lvl = 0;

        if (tool != null) {
            ItemMeta meta = tool.getItemMeta();
            lvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }

        switch (DROP_TYPE.valueOf(section.getString("Type").toUpperCase())) {
            case RARE:
            case COMMON: {
                double chance = section.getDouble("Chance");
                double rawAmount = (1D / (lvl + 2D) + (lvl + 1D) / 2D) * chance;
                int actualAmount = (int) Math.floor(rawAmount);
                double dif = rawAmount - actualAmount;

                if (Math.random() <= dif)
                    actualAmount++;

                if (actualAmount > 0) {
                    drop.setAmount(actualAmount);

                    loc.getWorld().dropItemNaturally(loc, drop);
                }
                break;
            }
            case RANGE: {
                int min = section.getInt("MinAmount");
                int max = section.getInt("MaxAmount");

                int amount = Math.toIntExact(Math.round(Math.random() * (max - min)) + min);

                drop.setAmount(amount);
                loc.getWorld().dropItemNaturally(loc, drop);
                break;
            }
            default: {
                break;
            }
        }
    }

    public enum DROP_TYPE {
        COMMON, RARE, RANGE
    }

    public static void harvestLooting(ConfigurationSection section, ItemStack drop, ItemStack tool, Location loc) {
        Random r = new Random();

        int lvl = 0;

        if (tool != null) {
            ItemMeta meta = tool.getItemMeta();
            if (meta != null) {
                lvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
            }
        }

        switch (DROP_TYPE.valueOf(section.getString("Type").toUpperCase())) {
            case RARE: {
                double chance = section.getDouble("Chance");
                // rare drops
                if (Math.random() <= chance + lvl * 0.01) {
                    loc.getWorld().dropItemNaturally(loc, drop);
                }
                else {
                    if (Math.random() <= (lvl / (lvl + 1D)))
                        loc.getWorld().dropItemNaturally(loc, drop);
                }
                break;
            }
            case COMMON: {
                double chance = section.getDouble("Chance");

                if (Math.random() <= chance + lvl * 0.01) {
                    int maxAmount = lvl + 1;

                    double rawAmount = chance * maxAmount;
                    int actualAmount = (int) Math.floor(rawAmount);

                    double dif = rawAmount - actualAmount;

                    if (Math.random() <= dif)
                        actualAmount++;

                    if (actualAmount > 0) {
                        drop.setAmount(actualAmount);

                        loc.getWorld().dropItemNaturally(loc, drop);
                    }
                }
                break;
            }
            case RANGE: {
                int min = section.getInt("MinAmount");
                int max = section.getInt("MaxAmount");

                int amount = Math.toIntExact(Math.round(Math.random() * (max - min)) + min);

                drop.setAmount(amount);
                loc.getWorld().dropItemNaturally(loc, drop);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static boolean isNetherite(Material material) {
        switch (material) {
            case NETHERITE_AXE:
            case NETHERITE_BOOTS:
            case NETHERITE_HELMET:
            case NETHERITE_CHESTPLATE:
            case NETHERITE_LEGGINGS:
            case NETHERITE_PICKAXE:
            case NETHERITE_SWORD:
            case NETHERITE_SHOVEL:
            case NETHERITE_HOE: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isDiamond(Material material) {
        switch (material) {
            case DIAMOND_AXE:
            case DIAMOND_BOOTS:
            case DIAMOND_HELMET:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_LEGGINGS:
            case DIAMOND_PICKAXE:
            case DIAMOND_SWORD:
            case DIAMOND_SHOVEL:
            case DIAMOND_HOE: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean changeDurability(ItemStack item, int change) {
        ItemMeta meta = item.getItemMeta();
        int lvl = meta.getEnchantLevel(Enchantment.DURABILITY);

        boolean hasCustomDurability = RSVItem.hasCustomDurability(item) && RSVItem.hasMaxCustomDurability(item);
        
        int rsvDurability = RSVItem.getCustomDurability(item);
        int rsvMaxDurability = RSVItem.getMaxCustomDurability(item);

        int maxMcDurability = item.getType().getMaxDurability();
        int mcDurability = maxMcDurability - ((Damageable) meta).getDamage();

        int actualChange = 0;

        if (change < 0) {
            change *= -1;

            for (int i = 0; i < change; i++) {
                if (Math.random() <= (1D / (lvl + 1D))) {
                    actualChange++;
                }
            }

            // actual damageable item in vanilla
            if (maxMcDurability > 0) {
                if (hasCustomDurability) {
                    double mcRatio = (double) mcDurability / maxMcDurability;
                    double rsvRatio = (double) rsvDurability / rsvMaxDurability;

                    if (!Utils.doublesEquals(mcRatio, rsvRatio)) {
                        mcDurability = (int) Math.ceil(rsvRatio * maxMcDurability);
                    }

                    actualChange = maxMcDurability - mcDurability;

                    ((Damageable) meta).setDamage(actualChange);
                }
                else {
                    ((Damageable) meta).setDamage(((Damageable) meta).getDamage() + actualChange);

                    item.setItemMeta(meta);
                }
                return ((Damageable) meta).getDamage() + actualChange >= item.getType().getMaxDurability();
            }
            if (hasCustomDurability) {
                int newDurability = rsvDurability - actualChange;

                RealisticSurvivalPlugin.getUtil().addNbtTag(item, "rsvdurability", newDurability, PersistentDataType.INTEGER);
                updateLore(item, rsvDurability, newDurability);
                return (newDurability < 1);
            }
        }
        else if (change > 0) {
            actualChange = change;

            if (maxMcDurability > 0) {
                if (hasCustomDurability) {
                    double mcRatio = (double) mcDurability / maxMcDurability;
                    double rsvRatio = (double) rsvDurability / rsvMaxDurability;

                    if (!Utils.doublesEquals(mcRatio, rsvRatio)) {
                        mcDurability = (int) Math.ceil(rsvRatio * maxMcDurability);
                    }

                    actualChange = maxMcDurability - mcDurability;

                    ((Damageable) meta).setDamage(actualChange);
                }
            }
            if (hasCustomDurability) {

            }
        }
        return false;
    }

    public static void incrementDurability(ItemStack item, int amount) {
        ItemMeta meta = item.getItemMeta();

        boolean hasCustomDurability = RSVItem.hasCustomDurability(item);
        boolean hasMaxCustomDurability = RSVItem.hasMaxCustomDurability(item);

        int rsvDurability = RSVItem.getCustomDurability(item);
        int rsvMaxDurability = RSVItem.getMaxCustomDurability(item);

        int maxMcDurability = item.getType().getMaxDurability();
        int mcDurability = maxMcDurability - ((Damageable) meta).getDamage();
    }


    public static InternalsProvider getInternals() {
        return internals;
    }

    // Armorstand methods for setting euler angles
    public static EulerAngle setRightArmAngle(ArmorStand armorStand, int x, int y, int z){
        double armorStandX = armorStand.getRightArmPose().getX();
        double armorStandY = armorStand.getRightArmPose().getY();
        double armorStandZ = armorStand.getRightArmPose().getZ();

        return new EulerAngle(armorStandX + Math.toRadians(x), armorStandY + Math.toRadians(y), armorStandZ + Math.toRadians(z));
    }

    public static void playSound(Location loc, String soundName, float volume, float pitch) {
        if (StringUtils.isAllLowerCase(soundName)) {
            loc.getWorld().playSound(loc, soundName, volume, pitch);
        }
        else {
            loc.getWorld().playSound(loc, Sound.valueOf(soundName), volume, pitch);
        }
    }

    public static void updateLore(ItemStack item, int oldDurability, int newDurability) {
        if (RSVItem.hasMaxCustomDurability(item) && RSVItem.hasCustomDurability(item)) {
            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.getLore();

            for (int i = 0; i < lore.size(); i++) {
                if (lore.get(i).contains("Durability: ")) {
                    lore.set(i, lore.get(i).replace(String.valueOf(oldDurability), String.valueOf(newDurability)));
                    break;
                }
            }
        }
    }

    /**
     * Gets the BlockFace of the block the entity is currently targeting.
     *
     * @param entity the entity whose targeted blocks' BlockFace is to be checked.
     * @return the BlockFace of the targeted block, or null if the targeted block is non-occluding.
     */
    public static BlockFace getBlockFace(LivingEntity entity) {
        List<Block> lastTwoTargetBlocks = entity.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !lastTwoTargetBlocks.get(1).getType().isOccluding()) return null;
        Block targetBlock = lastTwoTargetBlocks.get(1);
        Block adjacentBlock = lastTwoTargetBlocks.get(0);
        return targetBlock.getFace(adjacentBlock);
    }
}