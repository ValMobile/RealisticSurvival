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

import me.val_mobile.iceandfire.DragonVariant;
import me.val_mobile.iceandfire.SeaSerpentVariant;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanweaponry.KbTask;
import me.val_mobile.utils.ToolHandler.Tool;
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

    public String getMinecraftVersion() {
        String s = plugin.getServer().getVersion();

        if (s.contains("1.19.2")) {
            return "1.19.2";
        }
        if (s.contains("1.19.1")) {
            return "1.19.1";
        }
        if (s.contains("1.19")) {
            return "1.19";
        }
        if (s.contains("1.18.2")) {
            return "1.18.2";
        }
        if (s.contains("1.18.1")) {
            return "1.18.1";
        }
        if (s.contains("1.18")) {
            return "1.18";
        }
        if (s.contains("1.17.1")) {
            return "1.17.1";
        }
        if (s.contains("1.17")) {
            return "1.17";
        }
        if (s.contains("1.16.5")) {
            return "1.16.5";
        }
        if (s.contains("1.16.4")) {
            return "1.16.4";
        }
        if (s.contains("1.16.3")) {
            return "1.16.3";
        }
        if (s.contains("1.16.2")) {
            return "1.16.2";
        }
        if (s.contains("1.16.1")) {
            return "1.16.1";
        }
        if (s.contains("1.16")) {
            return "1.16";
        }
        return "";
    }

    public static String toLowercaseAttributeName(Attribute atr) {
        return switch (atr) {
            case GENERIC_ATTACK_DAMAGE -> "generic.attack_damage";
            case GENERIC_ATTACK_SPEED -> "generic.attack_speed";
            case GENERIC_ATTACK_KNOCKBACK -> "generic.attack_knockback";
            case GENERIC_ARMOR -> "generic.armor";
            case GENERIC_ARMOR_TOUGHNESS -> "generic.armor_toughness";
            case GENERIC_FLYING_SPEED -> "generic.flying_speed";
            case GENERIC_FOLLOW_RANGE -> "generic.follow_range";
            case GENERIC_KNOCKBACK_RESISTANCE -> "generic.knockback_resistance";
            case GENERIC_LUCK -> "generic.luck";
            case GENERIC_MAX_HEALTH -> "generic.max_health";
            case GENERIC_MOVEMENT_SPEED -> "generic.movement_speed";
            case HORSE_JUMP_STRENGTH -> "horse.jump_strength";
            case ZOMBIE_SPAWN_REINFORCEMENTS -> "zombie.spawn_reinforcements";
        };
    }

    public static double getCorrectAttributeValue(Attribute attribute, double requestedValue) {
        return switch (attribute) {
            case GENERIC_ATTACK_DAMAGE -> requestedValue + ATTACK_DAMAGE_CONSTANT;
            case GENERIC_ATTACK_SPEED -> requestedValue + ATTACK_SPEED_CONSTANT;
            case GENERIC_ARMOR, GENERIC_ARMOR_TOUGHNESS -> requestedValue;
            default -> 0;
        };
    }

    public static boolean isHelmet(Material material) {
        switch (material) {
            case CHAINMAIL_HELMET, DIAMOND_HELMET, GOLDEN_HELMET, IRON_HELMET, LEATHER_HELMET, NETHERITE_HELMET, TURTLE_HELMET -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static boolean isChestplate(Material material) {
        switch (material) {
            case CHAINMAIL_CHESTPLATE, DIAMOND_CHESTPLATE, GOLDEN_CHESTPLATE, IRON_CHESTPLATE, LEATHER_CHESTPLATE, NETHERITE_CHESTPLATE -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static boolean isLeggings(Material material) {
        switch (material) {
            case CHAINMAIL_LEGGINGS, DIAMOND_LEGGINGS, GOLDEN_LEGGINGS, IRON_LEGGINGS, LEATHER_LEGGINGS, NETHERITE_LEGGINGS -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static boolean isBoots(Material material) {
        switch (material) {
            case CHAINMAIL_BOOTS, DIAMOND_BOOTS, GOLDEN_BOOTS, IRON_BOOTS, LEATHER_BOOTS, NETHERITE_BOOTS -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static boolean isArmor(Material material) {
        return isHelmet(material) || isChestplate(material) || isLeggings(material) || isBoots(material);
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

    public static Attribute translateInformalAttributeName(String name) {
        return switch (name) {
            case "AttackDamage" -> Attribute.GENERIC_ATTACK_DAMAGE;
            case "AttackKnockback" -> Attribute.GENERIC_ATTACK_KNOCKBACK;
            case "AttackSpeed" -> Attribute.GENERIC_ATTACK_SPEED;
            case "Armor" -> Attribute.GENERIC_ARMOR;
            case "Toughness" -> Attribute.GENERIC_ARMOR_TOUGHNESS;
            case "FlyingSpeed" -> Attribute.GENERIC_FLYING_SPEED;
            case "FollowRange" -> Attribute.GENERIC_FOLLOW_RANGE;
            case "KnockbackResistance" -> Attribute.GENERIC_KNOCKBACK_RESISTANCE;
            case "Luck" -> Attribute.GENERIC_LUCK;
            case "MaxHealth" -> Attribute.GENERIC_MAX_HEALTH;
            case "MovementSpeed" -> Attribute.GENERIC_MOVEMENT_SPEED;
            case "HorseJumpStrength" -> Attribute.HORSE_JUMP_STRENGTH;
            case "ZombieSpawnReinforcements" -> Attribute.ZOMBIE_SPAWN_REINFORCEMENTS;
            default -> Attribute.valueOf(name);
        };
    }

    public static String getMinecraftEnchName(String keyName) {
        return switch (keyName) {
            case "ARROW_DAMAGE" -> "Power";
            case "ARROW_FIRE" -> "Flame";
            case "ARROW_INFINITE" -> "Infinity";
            case "ARROW_KNOCKBACK" -> "Punch";
            case "BINDING_CURSE" -> "Curse of Binding";
            case "DAMAGE_ALL" -> "Sharpness";
            case "DAMAGE_ARTHROPODS" -> "Bane of Arthropods";
            case "DAMAGE_UNDEAD" -> "Smite";
            case "DEPTH_STRIDER" -> "Depth Strider";
            case "DIG_SPEED" -> "Efficiency";
            case "DURABILITY" -> "Unbreaking";
            case "FIRE_ASPECT" -> "Fire Aspect";
            case "FROST_WALKER" -> "Frost Walker";
            case "KNOCKBACK" -> "Knockback";
            case "LOOT_BONUS_BLOCKS" -> "Fortune";
            case "LOOT_BONUS_MOBS" -> "Looting";
            case "LUCK" -> "Luck of the Sea";
            case "LURE" -> "Lure";
            case "MENDING" -> "Mending";
            case "OXYGEN" -> "Respiration";
            case "PROTECTION_ENVIRONMENTAL" -> "Protection";
            case "PROTECTION_EXPLOSIONS" -> "Blast Protection";
            case "PROTECTION_FALL" -> "Feather Falling";
            case "PROTECTION_FIRE" -> "Fire Protection";
            case "PROTECTION_PROJECTILE" -> "Projectile Protection";
            case "SILK_TOUCH" -> "Silk Touch";
            case "SWEEPING_EDGE" -> "Sweeping Edge";
            case "THORNS" -> "Thorns";
            case "VANISHING_CURSE" -> "Curse of Vanishing";
            case "WATER_WORKER" -> "Aqua Affinity";
            case "SOUL_SPEED" -> "Soul Speed";
            case "PIERCING" -> "Piercing";
            case "QUICK_CHARGE" -> "Quick Charge";
            case "SWIFT_SNEAK" -> "Swift Sneak";
            case "MULTISHOT" -> "Multishot";
            case "CHANNELING" -> "Channeling";
            case "RIPTIDE" -> "Riptide";
            case "IMPALING" -> "Impaling";
            case "LOYALTY" -> "Loyalty";
            default -> null;
        };
    }

    public static boolean isHoldingAxe(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (isItemReal(itemMainHand)) {
            Material mat = itemMainHand.getType();
            switch (mat) {
                case DIAMOND_AXE, IRON_AXE, WOODEN_AXE, STONE_AXE, GOLDEN_AXE, NETHERITE_AXE -> {
                    return true;
                }
                default -> {
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
                case DIAMOND_PICKAXE, IRON_PICKAXE, WOODEN_PICKAXE, STONE_PICKAXE, GOLDEN_PICKAXE, NETHERITE_PICKAXE -> {
                    return true;
                }
                default -> {
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
        return switch (color) {
            case "AQUA" -> Color.AQUA;
            case "BLACK" -> Color.BLACK;
            case "BLUE" -> Color.BLUE;
            case "FUCHSIA" -> Color.FUCHSIA;
            case "GRAY" -> Color.GRAY;
            case "GREEN" -> Color.GREEN;
            case "LIME" -> Color.LIME;
            case "MAROON" -> Color.MAROON;
            case "NAVY" -> Color.NAVY;
            case "OLIVE" -> Color.OLIVE;
            case "ORANGE" -> Color.ORANGE;
            case "PURPLE" -> Color.PURPLE;
            case "RED" -> Color.RED;
            case "SILVER" -> Color.SILVER;
            case "TEAL" -> Color.TEAL;
            case "WHITE" -> Color.WHITE;
            case "YELLOW" -> Color.YELLOW;
            default -> null;
        };
    }

    public static PotionEffectType valueOfPotionEffectType(String potionEffectType) {
        return internals.valueOfPotionEffectType(potionEffectType);
    }

    public static boolean isItemReal(ItemStack item) {
        return !(item == null || item.getType() == Material.AIR || item.getAmount() < 1);
    }

    public static void setFreezingView(Player player, int ticks) {
        internals.setFreezingView(player, ticks);
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

    public void setKbMultiplier(Entity entity, double multiplier) {
        new KbTask(plugin, entity, multiplier).start();
    }

    public void setZeroKb(Entity entity) {
        setKbMultiplier(entity, 0D);
    }

    public static boolean doublesEquals(double v, double v1) {
        double tolerance = 0.0001;

        return Math.abs(v - v1) <= tolerance;
    }

    public static boolean isUndead(Entity entity) {
        return internals.isUndead(entity);
    }

    public static boolean isNetheriteRecipe(SmithingInventory inv) {
        return internals.isNetheriteRecipe(inv);
    }

    public static boolean isTag(String name) {
        return internals.getTag(name) != null;
    }

    public static int getRandomNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static Tag getTag(String name) {
        return internals.getTag(name);
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
        Location loc = player.getLocation();

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
        return Double.parseDouble(text);
    }

    public static void harvestFortune(ConfigurationSection section, ItemStack drop, ItemStack tool, Location loc) {
        int lvl = 0;

        if (tool != null) {
            ItemMeta meta = tool.getItemMeta();
            lvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }

        switch (DROP_TYPE.valueOf(section.getString("Type").toUpperCase())) {
            case RARE, COMMON -> {
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
            }
            case RANGE -> {
                int min = section.getInt("MinAmount");
                int max = section.getInt("MaxAmount");

                int amount = Math.toIntExact(Math.round(Math.random() * (max - min)) + min);

                drop.setAmount(amount);
                loc.getWorld().dropItemNaturally(loc, drop);
            }
            default -> {
            }
        }
    }

    public enum DROP_TYPE {
        COMMON, RARE, RANGE
    }

    public static boolean harvestLooting(ConfigurationSection section, ItemStack drop, ItemStack tool, Location loc) {
        int lvl = 0;

        if (tool != null) {
            ItemMeta meta = tool.getItemMeta();
            if (meta != null) {
                lvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
            }
        }

        switch (DROP_TYPE.valueOf(section.getString("Type").toUpperCase())) {
            case RARE -> {
                double chance = section.getDouble("Chance");
                // rare drops
                if (Math.random() <= chance + lvl * 0.01) {
                    loc.getWorld().dropItemNaturally(loc, drop);
                    return true;
                }
                else {
                    if (Math.random() <= (lvl / (lvl + 1D))) {
                        loc.getWorld().dropItemNaturally(loc, drop);
                        return true;
                    }
                }
            }
            case COMMON -> {
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
                        return true;
                    }
                }
            }
            case RANGE -> {
                int min = section.getInt("MinAmount");
                int max = section.getInt("MaxAmount");

                int amount = Math.toIntExact(Math.round(Math.random() * (max - min)) + min);

                drop.setAmount(amount);
                loc.getWorld().dropItemNaturally(loc, drop);
                return true;
            }
            default -> {
            }
        }

        return false;
    }

    public static boolean isNetherite(Material material) {
        switch (material) {
            case NETHERITE_AXE, NETHERITE_BOOTS, NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_PICKAXE, NETHERITE_SWORD, NETHERITE_SHOVEL, NETHERITE_HOE -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static boolean isDiamond(Material material) {
        switch (material) {
            case DIAMOND_AXE, DIAMOND_BOOTS, DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_PICKAXE, DIAMOND_SWORD, DIAMOND_SHOVEL, DIAMOND_HOE -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static Material getRespectivePlank(Material wood) {
        String matName = wood.toString();

        int firstIndex = matName.indexOf("_");
        int secondIndex = matName.lastIndexOf("_");

        if (firstIndex != secondIndex) {
            // two underscores
            return Material.valueOf(matName.substring(firstIndex + 1, secondIndex + 1) + "PLANKS");
        }
        else {
            // one underscore
            return Material.valueOf(matName.substring(0, firstIndex + 1) + "PLANKS");
        }
    }

    public static void attack(Player player, Entity entity) {
        internals.attack(player, entity);
    }

    public static boolean changeDurability(ItemStack item, int change, boolean shouldBreak) {
        ItemMeta meta = item.getItemMeta();
        int lvl = meta.getEnchantLevel(Enchantment.DURABILITY);

        boolean hasCustomDurability = RSVItem.hasCustomDurability(item) && RSVItem.hasMaxCustomDurability(item);

        int actualChange = change;

        if (!meta.isUnbreakable()) {
            // if durability should decrease, check for unbreaking enchant
            if (change < 0) {
                if (lvl > 0) {
                    for (int i = 0; i < -change; i++) {
                        if (Math.random() > (1D / (lvl + 1D))) {
                            actualChange++;
                        }
                    }
                }
            }

            int maxMcDurability = item.getType().getMaxDurability();
            int mcDurability;

            if (hasCustomDurability) {
                int rsvDurability = RSVItem.getCustomDurability(item);
                int rsvMaxDurability = RSVItem.getMaxCustomDurability(item);

                rsvDurability += actualChange;

                double rsvRatio = (double)  rsvDurability / rsvMaxDurability;
                RealisticSurvivalPlugin.getUtil().addNbtTag(item, "rsvdurability", rsvDurability, PersistentDataType.INTEGER);
                Utils.updateLore(item, rsvDurability - actualChange, rsvDurability);

                // if vanilla item has durability
                if (maxMcDurability > 0) {
                    mcDurability = (int) Math.ceil(rsvRatio * maxMcDurability);
                    ((Damageable) meta).setDamage(maxMcDurability - mcDurability);
                }

                if (rsvDurability <= 0 && shouldBreak) {
                    item.setAmount(0);
                    item.setType(Material.AIR);
                }
            }
            else {
                mcDurability = maxMcDurability - ((Damageable) meta).getDamage() + actualChange;
                ((Damageable) meta).setDamage(maxMcDurability - mcDurability);

                if (mcDurability <= 0 && shouldBreak) {
                    item.setAmount(0);
                    item.setType(Material.AIR);
                }
            }
            item.setItemMeta(meta);
        }
        return false;
    }

    public static void spawnEndermanAlly(Player owner, Location loc) {
        internals.spawnEndermanAlly(owner, loc);
    }

    public static void spawnFireDragon(Location loc, RealisticSurvivalPlugin plugin) {
        internals.spawnFireDragon(loc, plugin);
    }

    public static void spawnFireDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        internals.spawnFireDragon(loc, stage, plugin);
    }

    public static void spawnFireDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        internals.spawnFireDragon(loc, variant, plugin);
    }

    public static void spawnFireDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        internals.spawnFireDragon(loc, variant, stage, plugin);
    }

    public static void spawnIceDragon(Location loc, RealisticSurvivalPlugin plugin) {
        internals.spawnIceDragon(loc, plugin);
    }

    public static void spawnIceDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        internals.spawnIceDragon(loc, stage, plugin);
    }

    public static void spawnIceDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        internals.spawnIceDragon(loc, variant, plugin);
    }

    public static void spawnIceDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        internals.spawnIceDragon(loc, variant, stage, plugin);
    }

    public static void spawnLightningDragon(Location loc, RealisticSurvivalPlugin plugin) {
        internals.spawnLightningDragon(loc, plugin);
    }

    public static void spawnLightningDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        internals.spawnLightningDragon(loc, stage, plugin);
    }

    public static void spawnLightningDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        internals.spawnLightningDragon(loc, variant, plugin);
    }

    public static void spawnLightningDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        internals.spawnLightningDragon(loc, variant, stage, plugin);
    }

    public static void spawnSeaSerpent(Location loc, RealisticSurvivalPlugin plugin) {
        internals.spawnSeaSerpent(loc, plugin);
    }

    public static void spawnSeaSerpent(Location loc, SeaSerpentVariant variant, RealisticSurvivalPlugin plugin) {
        internals.spawnSeaSerpent(loc, variant, plugin);
    }

    public static void spawnSiren(Location loc, RealisticSurvivalPlugin plugin) {
        internals.spawnSiren(loc, plugin);
    }

    public static Tool getBestTool(Material mat) {
        return RealisticSurvivalPlugin.toolHandler.getBestToolType(mat);
    }

    public static void registerEntities() {
        internals.registerEntities();
    }

    // Armorstand methods for setting euler angles
    public static EulerAngle setRightArmAngle(ArmorStand armorStand, int x, int y, int z){
        double armorStandX = armorStand.getRightArmPose().getX();
        double armorStandY = armorStand.getRightArmPose().getY();
        double armorStandZ = armorStand.getRightArmPose().getZ();

        return new EulerAngle(armorStandX + Math.toRadians(x), armorStandY + Math.toRadians(y), armorStandZ + Math.toRadians(z));
    }

    public static void playSound(Location loc, String soundName, float volume, float pitch) {
        if (soundName.contains("_")) {
            if (StringUtils.isAllUpperCase(soundName.substring(0, soundName.indexOf("_")))) {
                loc.getWorld().playSound(loc, Sound.valueOf(soundName), volume, pitch);
            }
            else {
                loc.getWorld().playSound(loc, soundName, volume, pitch);
            }
        }
    }

    public static void updateLore(ItemStack item, int oldDurability, int newDurability) {
        if (RSVItem.hasMaxCustomDurability(item) && RSVItem.hasCustomDurability(item)) {
            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.getLore();

            boolean changedDurability = false;
            boolean changedJuice = !RealisticSurvivalPlugin.getUtil().hasNbtTag(item, "rsvdrink");

            for (int i = 0; i < lore.size(); i++) {
                if (lore.get(i).contains("Durability: ")) {
                    lore.set(i, lore.get(i).replace(String.valueOf(oldDurability), String.valueOf(newDurability)));
                    changedDurability = true;
                }
                if (lore.get(i).contains("Drink: ")) {
                    if (!changedJuice) {
                        lore.set(i, "Drink: " + RealisticSurvivalPlugin.getUtil().getNbtTag(item, "rsvdrink", PersistentDataType.STRING));
                        changedJuice = true;
                    }
                }
                if (changedDurability && changedJuice) {
                    break;
                }
            }

            meta.setLore(lore);
            item.setItemMeta(meta);
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