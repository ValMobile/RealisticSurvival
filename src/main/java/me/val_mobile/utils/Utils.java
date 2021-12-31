/*
    Copyright (C) 2021  Val_Mobile

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
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Random;

public class Utils {

    public static final double ATTACK_DAMAGE_CONSTANT = -1.0;
    public static final double ATTACK_SPEED_CONSTANT = -4.0;

    private final RealisticSurvivalPlugin plugin;

    public Utils(RealisticSurvivalPlugin instance) {
        plugin = instance;
    }

    public static Location modifyLocation(Location loc, double x, double y, double z) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);
        newLoc.setY(newLoc.getY() + y);
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public static Vector randomizeVelocity(Vector velocity) {
        Vector newVelocity = velocity.clone();
        Random r = new Random();

        newVelocity.setX((newVelocity.getX() * r.nextDouble()) + 0.5);
        newVelocity.setY((newVelocity.getY() * r.nextDouble()) + 0.5);
        newVelocity.setZ((newVelocity.getZ() * r.nextDouble()) + 0.5);

        return newVelocity;
    }

    public static void setOrReplaceEntry(HashMap<String, Double> map, String key, Double value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
        }
        else {
            map.put(key, value);
        }
    }

    public static void setOrReplaceEntry(HashMap<String, Integer> map, String key, Integer value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
        }
        else {
            map.put(key, value);
        }
    }

    public static void setOrReplaceEntry(HashMap<String, Boolean> map, String key, Boolean value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
        }
        else {
            map.put(key, value);
        }
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
        return (material.toString().contains("HELMET"));
    }

    public static boolean isChestplate(Material material) {
        return (material.toString().contains("CHESTPLATE"));
    }

    public static boolean isLeggings(Material material) {
        return (material.toString().contains("LEGGINGS"));
    }

    public static boolean isBoots(Material material) {
        return (material.toString().contains("BOOTS"));
    }
    public static boolean isPickaxe(Material material) {
        return (material.toString().contains("PICKAXE"));
    }

    public static boolean isAxe(Material material) {
        return (material.toString().contains("AXE"));
    }

    public static boolean isShovel(Material material) {
        return (material.toString().contains("SHOVEL"));
    }

    public static boolean isHoe(Material material) {
        return (material.toString().contains("HOE"));
    }

    public static boolean isSword(Material material) {
        return (material.toString().contains("SWORD"));
    }

    public static boolean isChainmail(Material material) {
        return (material.toString().contains("CHAINMAIL"));
    }

    public static boolean isIron(Material material) {
        return (material.toString().contains("IRON"));
    }

    public static boolean isGolden(Material material) {
        return (material.toString().contains("GOLDEN"));
    }

    public static boolean isLeather(Material material) {
        return (material.toString().contains("LEATHER"));
    }

    public static boolean isDiamond(Material material) {
        return (material.toString().contains("DIAMOND"));
    }

    public static boolean isNetherite(Material material) {
        return (material.toString().contains("NETHERITE"));
    }

    public static boolean isStone(Material material) {
        return (material.toString().contains("STONE"));
    }

    public static boolean isWooden(Material material) {
        return (material.toString().contains("WOODEN"));
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
            if (itemMainHand.getType().toString().contains("AXE")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHoldingPickaxe(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (isItemReal(itemMainHand)) {
            if (itemMainHand.getType().toString().contains("PICKAXE")) {
                return true;
            }
        }
        return false;
    }

    public boolean isHoldingKnife(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();

        if (isItemReal(itemMainHand)) {
            if (hasNbtTag(itemMainHand,"spartans_weapon")) {
                if (getNbtTag(itemMainHand,"spartans_weapon").equals("Dagger") || getNbtTag(itemMainHand,"spartans_weapon").equals("Throwing Knife")) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean hasArmor(LivingEntity entity) {
        ItemStack[] armor = entity.getEquipment().getArmorContents();
        for (ItemStack item : armor) {
            if (isItemReal(item)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasChestplate(LivingEntity entity) {
        ItemStack chestplate = entity.getEquipment().getChestplate();
        if (isItemReal(chestplate)) {
            return true;
        }
        return false;
    }

    public boolean isHoldingTwoHandedWeapon(LivingEntity entity) {
        ItemStack item = entity.getEquipment().getItemInMainHand();
        if (isItemReal(item)) {
            if (hasNbtTag(item,"spartans_weapon")) {
                switch (getNbtTag(item,"spartans_weapon")) {
                    case "Katana":
                    case "Glaive":
                    case "Quarterstaff":
                    case "Battleaxe":
                    case "Warhammer":
                    case "Halberd":
                    case "Pike":
                    case "Longsword":
                    case "Greatsword":
                        return true;
                }
                return false;
            }
            return false;

        }
        return false;
    }

    public boolean checkTwoHandedDebuff(LivingEntity entity) {
        if (isHoldingTwoHandedWeapon(entity)) {
            ItemStack item = entity.getEquipment().getItemInOffHand();
            if (isItemReal(item)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void applyTwoHandedDebuff(LivingEntity entity) {
        PotionEffect effect = new PotionEffect(PotionEffectType.SLOW_DIGGING, 30, 0);
    }

    public static void removeColorCodes(String name) {
        name.replaceAll("&0", "");
        name.replaceAll("&1", "");
        name.replaceAll("&2", "");
        name.replaceAll("&3", "");
        name.replaceAll("&4", "");
        name.replaceAll("&5", "");
        name.replaceAll("&6", "");
        name.replaceAll("&7", "");
        name.replaceAll("&8", "");
        name.replaceAll("&9", "");
        name.replaceAll("&a", "");
        name.replaceAll("&b", "");
        name.replaceAll("&c", "");
        name.replaceAll("&d", "");
        name.replaceAll("&e", "");
        name.replaceAll("&f", "");
        name.replaceAll("&k", "");
        name.replaceAll("&m", "");
        name.replaceAll("&o", "");
        name.replaceAll("&l", "");
        name.replaceAll("&n", "");
        name.replaceAll("&r", "");
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
        if (! (item == null || item.getType() == Material.AIR) ) {
            return true;
        }
        return false;
    }

    public static void smartAddPotionEffect(PotionEffect effect, LivingEntity entity) {
        int requestedAmplifier = effect.getAmplifier();
        int requestedDuration = effect.getDuration();
        PotionEffectType type = effect.getType();

        if (entity.hasPotionEffect(type)) {
            int currentAmplifier = entity.getPotionEffect(type).getAmplifier();
            int currentDuration = entity.getPotionEffect(type).getDuration();

            if (currentDuration < requestedDuration) {
                if (currentAmplifier <= requestedAmplifier) {
                    if (currentDuration < requestedDuration / 2) {
                        entity.addPotionEffect(effect);
                    }
                }
            }
        }
        else {
            entity.addPotionEffect(effect);
        }
    }

    public void addNbtTag(ItemStack item, String key, String value) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.getPersistentDataContainer().set(nkey, PersistentDataType.STRING, value);

        item.setItemMeta(itemMeta);
    }

    public String getNbtTag(ItemStack item, String key) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        if(container.has(nkey , PersistentDataType.STRING)) {
            return container.get(nkey, PersistentDataType.STRING);
        }

        return "";
    }

    public boolean hasNbtTag(ItemStack item, String key) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();

        if(itemMeta.getPersistentDataContainer().has(nkey , PersistentDataType.STRING)) {
            return true;
        }

        return false;
    }

    public static HashMap<String, Tag> getTags() {
        HashMap<String, Tag> tags = new HashMap<>();

        tags.put("PLANKS", Tag.PLANKS);
        tags.put("WOOL", Tag.WOOL);
        tags.put("LOGS", Tag.LOGS);
        tags.put("CANDLES", Tag.CANDLES);
        tags.put("CANDLE_CAKES", Tag.CANDLE_CAKES);
        tags.put("FIRE", Tag.FIRE);
        tags.put("SNOW", Tag.SNOW);
        tags.put("FLUIDS_LAVA", Tag.FLUIDS_LAVA);
        tags.put("FLUIDS_WATER", Tag.FLUIDS_WATER);

        return tags;
    }

    public static double getDamage(ItemStack item) {

        double damage = 0D;

        for (AttributeModifier atrMod : item.getItemMeta().getAttributeModifiers().get(Attribute.GENERIC_ATTACK_DAMAGE)) {
            damage += (atrMod.getAmount() - ATTACK_DAMAGE_CONSTANT);
        }

        return damage;
    }

    public static boolean isLookingAt(Player player, LivingEntity entity)
    {
        Location eye = player.getEyeLocation();
        Vector toEntity = entity.getEyeLocation().toVector().subtract(eye.toVector());
        double dot = toEntity.normalize().dot(eye.getDirection());

        return dot > 0.99D;
    }

    public static boolean isInRange(Player player, LivingEntity entity, double maxDistance) {
        if (isLookingAt(player, entity)) {
            double distance = player.getLocation().distance(entity.getLocation());
            if (distance > 3 && distance < maxDistance) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isSourceLiquid(Block block) {
        BlockData blockData = block.getBlockData();

        if (blockData instanceof Levelled)
            if (((Levelled) blockData).getLevel() == 0)
                return true;
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

    public static void addRecipe(Recipe r) {
        if (r instanceof ShapedRecipe) {
            if (Bukkit.getRecipe(((ShapedRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof ShapelessRecipe) {
            if (Bukkit.getRecipe(((ShapelessRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof SmithingRecipe) {
            if (Bukkit.getRecipe(((SmithingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof FurnaceRecipe) {
            if (Bukkit.getRecipe(((FurnaceRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof CampfireRecipe) {
            if (Bukkit.getRecipe(((CampfireRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof BlastingRecipe) {
            if (Bukkit.getRecipe(((BlastingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof SmokingRecipe) {
            if (Bukkit.getRecipe(((SmokingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof StonecuttingRecipe) {
            if (Bukkit.getRecipe(((StonecuttingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
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

    public static void harvestFortune(double chance, ItemStack drop, ItemStack tool, Location loc) {
        Random r = new Random();

        int lvl = 0;

        if (tool != null) {
            ItemMeta meta = tool.getItemMeta();
            lvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }

        double rawAmount = (1D / (lvl + 2D) + (lvl + 1D) / 2D) * chance;
        int actualAmount = (int) Math.floor(rawAmount);
        double dif = rawAmount - actualAmount;

        if (r.nextDouble() <= dif)
            actualAmount++;

        if (actualAmount > 0) {
            drop.setAmount(actualAmount);

            loc.getWorld().dropItemNaturally(loc, drop);
        }
    }

    public static void harvestLooting(double chance, ItemStack drop, boolean rare, ItemStack tool, Location loc) {
        Random r = new Random();

        int lvl = 0;

        if (tool != null) {
            ItemMeta meta = tool.getItemMeta();
            lvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }

        // rare drops
        if (rare) {
            if (r.nextDouble() <= chance + lvl * 0.01) {
                loc.getWorld().dropItemNaturally(loc, drop);
            }
            else {
                if (r.nextDouble() <= (lvl / (lvl + 1D)))
                    loc.getWorld().dropItemNaturally(loc, drop);
            }
        }
        // common drops
        else {
            if (r.nextDouble() <= chance + lvl * 0.01) {
                int maxAmount = lvl + 1;

                double rawAmount = chance * maxAmount;
                int actualAmount = (int) Math.floor(rawAmount);

                double dif = rawAmount - actualAmount;

                if (r.nextDouble() <= dif)
                    actualAmount++;

                if (actualAmount > 0) {
                    drop.setAmount(actualAmount);

                    loc.getWorld().dropItemNaturally(loc, drop);
                }
            }
        }
    }

    public static boolean decrementDurability(ItemStack tool) {
        ItemMeta meta = tool.getItemMeta();
        int lvl = meta.getEnchantLevel(Enchantment.DURABILITY);

        Random r = new Random();

        if (r.nextDouble() <= (1D / (lvl + 1D))) {
            if (((Damageable) meta).getDamage() + 1 >= tool.getType().getMaxDurability()) {
                return true;
            }
            else {
                ((Damageable) meta).setDamage(((Damageable) meta).getDamage() + 1);

                tool.setItemMeta(meta);

                return false;
            }
        }
        return false;
    }

    public boolean shouldEventBeRan(LivingEntity entity, String module) {
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean(module + ".Enabled")) {
            String worldName = entity.getWorld().getName();

            ConfigurationSection allowedWorlds = config.getConfigurationSection(module + ".Worlds");
            if (allowedWorlds.getKeys(true).contains(worldName)) {
                if (allowedWorlds.getBoolean(worldName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean shouldEventBeRan(Entity entity, String module) {
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean(module + ".Enabled")) {
            String worldName = entity.getWorld().getName();

            ConfigurationSection allowedWorlds = config.getConfigurationSection(module + ".Worlds");
            if (allowedWorlds.getKeys(true).contains(worldName)) {
                if (allowedWorlds.getBoolean(worldName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean shouldEventBeRan(ChunkPopulateEvent event, String module) {
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean(module + ".Enabled")) {
            String worldName = event.getWorld().getName();

            ConfigurationSection allowedWorlds = config.getConfigurationSection(module + ".Worlds");
            if (allowedWorlds.getKeys(true).contains(worldName)) {
                if (allowedWorlds.getBoolean(worldName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean shouldEventBeRan(String module) {
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean(module + ".Enabled")) {
            return true;
        }
        return false;
    }
}