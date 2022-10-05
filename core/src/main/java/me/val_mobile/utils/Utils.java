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

import me.val_mobile.data.RSVModule;
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
import org.bukkit.configuration.file.FileConfiguration;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class Utils {

    public static final double ATTACK_DAMAGE_CONSTANT = -1.0;
    public static final double ATTACK_SPEED_CONSTANT = -4.0;

    private final RealisticSurvivalPlugin plugin;

    private static InternalsProvider internals;

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

    public static void damagePlayer(org.bukkit.entity.Damageable entity, double damage) {
        double points = 0;
        double toughness = 0;
        int resistance = 0;
        int epf = 0;

        if (entity instanceof LivingEntity living) {
            points = living.getAttribute(Attribute.GENERIC_ARMOR).getValue();
            toughness = living.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
            PotionEffect effect = living.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            resistance = effect == null ? 0 : effect.getAmplifier();
            epf = getEPF(living.getEquipment());
        }
        entity.damage(calculateDamageApplied(damage, points, toughness, resistance, epf));
    }

    public static double calculateDamageApplied(double damage, double points, double toughness, int resistance, int epf) {
        double withArmorAndToughness = damage * (1 - Math.min(20, Math.max(points / 5, points - damage / (2 + toughness / 4))) / 25);
        double withResistance = withArmorAndToughness * (1 - (resistance * 0.2));
        double withEnchants = withResistance * (1 - (Math.min(20.0, epf) / 25));
        return withEnchants;
    }

    public static int getEPF(EntityEquipment inv) {
        ItemStack helm = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack legs = inv.getLeggings();
        ItemStack boot = inv.getBoots();

        return (helm != null ? helm.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0) +
                (chest != null ? chest.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0) +
                (legs != null ? legs.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0) +
                (boot != null ? boot.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0);
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

        if(container.getKeys().contains(nkey)) {
            return container.get(nkey, type);
        }

        return null;
    }

    public <T> T getNbtTag(ItemStack item, String key, PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();

        if(container.getKeys().contains(nkey)) {
            return container.get(nkey, type);
        }

        return null;
    }

    public boolean hasNbtTag(Entity entity, String key) {
        NamespacedKey nkey = new NamespacedKey(plugin, key);

        return entity.getPersistentDataContainer().getKeys().contains(nkey);
    }

    public boolean hasNbtTag(ItemStack item, String key) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();

        return itemMeta.getPersistentDataContainer().getKeys().contains(nkey);
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

    public static double getRandomNum(double min, double max) {
        return Math.random() * (max - min + 1D) + min;
    }

    public static boolean areCriticalHitConditionsMet(Player player, double baseDamage, double finalDamage) {
        return player.getFallDistance() > 0 && ((Entity) (player)).isOnGround() && !player.getLocation().getBlock().isLiquid()
        && !Tag.CLIMBABLE.isTagged(player.getLocation().getBlock().getType()) && !player.hasPotionEffect(PotionEffectType.BLINDNESS)
                && player.getVehicle() == null && !player.isSprinting() && finalDamage > 0.848D * baseDamage;
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
        switch (wood.toString()) {
            case "OAK_WOOD", "OAK_LOG", "STRIPPED_OAK_LOG", "STRIPPED_OAK_WOOD" -> {
                return Material.OAK_PLANKS;
            }
            case "BIRCH_WOOD", "BIRCH_LOG", "STRIPPED_BIRCH_LOG", "STRIPPED_BIRCH_WOOD" -> {
                return Material.BIRCH_PLANKS;
            }
            case "SPRUCE_WOOD", "SPRUCE_LOG", "STRIPPED_SPRUCE_LOG", "STRIPPED_SPRUCE_WOOD" -> {
                return Material.SPRUCE_PLANKS;
            }
            case "ACACIA_WOOD", "ACACIA_LOG", "STRIPPED_ACACIA_LOG", "STRIPPED_ACACIA_WOOD" -> {
                return Material.ACACIA_PLANKS;
            }
            case "JUNGLE_WOOD", "JUNGLE_LOG", "STRIPPED_JUNGLE_LOG", "STRIPPED_JUNGLE_WOOD" -> {
                return Material.JUNGLE_PLANKS;
            }
            case "CRIMSON_STEM", "CRIMSON_HYPHAE", "STRIPPED_CRIMSON_HYPHAE", "STRIPPED_CRIMSON_STEM" -> {
                return Material.CRIMSON_PLANKS;
            }
            case "WARPED_STEM", "WARPED_HYPHAE", "STRIPPED_WARPED_HYPHAE", "STRIPPED_WARPED_STEM" -> {
                return Material.WARPED_PLANKS;
            }
            case "DARK_OAK_WOOD", "DARK_OAK_LOG", "STRIPPED_DARK_OAK_LOG", "STRIPPED_DARK_OAK_WOOD" -> {
                return Material.DARK_OAK_PLANKS;
            }
            case "MANGROVE_WOOD", "MANGROVE_LOG", "STRIPPED_MANGROVE_LOG", "STRIPPED_MANGROVE_WOOD" -> {
                return Material.valueOf("MANGROVE_PLANKS");
            }
            default -> {
                return null;
            }
        }
    }

    public static void attack(Player player, Entity entity) {
        internals.attack(player, entity);
    }

    public static void changeDurability(ItemStack item, int change, boolean shouldBreak) {
        ItemMeta meta = item.getItemMeta();
        int lvl = meta.getEnchantLevel(Enchantment.DURABILITY);

        boolean hasCustomDurability = RSVItem.hasCustomDurability(item) && RSVItem.hasMaxCustomDurability(item);

        int actualChange = change;

        if (hasCustomDurability) {
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

            int rsvDurability = RSVItem.getCustomDurability(item);
            int rsvMaxDurability = RSVItem.getMaxCustomDurability(item);

            rsvDurability += actualChange;

            // if vanilla item has durability
            if (maxMcDurability > 0) {
                mcDurability = (int) Math.ceil((double) rsvDurability / rsvMaxDurability * maxMcDurability);
                ((Damageable) meta).setDamage(maxMcDurability - mcDurability);
            }

            if (rsvDurability <= 0 && shouldBreak) {
                item.setAmount(0);
                item.setType(Material.AIR);
            }
            else {
                item.setItemMeta(meta);
                RealisticSurvivalPlugin.getUtil().addNbtTag(item, "rsvdurability", Math.min(rsvDurability, rsvMaxDurability), PersistentDataType.INTEGER);
                updateLore(item, rsvDurability - actualChange, rsvDurability);
            }
        }
        else {
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


            // if vanilla item has durability
            if (maxMcDurability > 0) {
                mcDurability = maxMcDurability - ((Damageable) meta).getDamage();
                mcDurability += actualChange;
                ((Damageable) meta).setDamage(maxMcDurability - mcDurability);

                if (mcDurability <= 0 && shouldBreak) {
                    item.setAmount(0);
                    item.setType(Material.AIR);
                }

                item.setItemMeta(meta);
            }
        }
    }

    public void updateItem(ItemStack item) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("UpdateItems.Enabled")) {
            if (RSVItem.isRSVItem(item)) {
                RSVItem rsvItem = RSVItem.getItem(RSVItem.getNameFromItem(item));
                ItemMeta rsvMeta = rsvItem.getItemMeta();

                if (config.getBoolean("UpdateItems.UpdateMaterial"))
                    item.setType(rsvItem.getType());

                if (config.getBoolean("UpdateItems.UpdateMaterialData"))
                    item.setData(rsvItem.getData());

                ItemMeta meta = item.getItemMeta();

                if (config.getBoolean("UpdateItems.UpdateDisplayName")) {
                    if (rsvMeta.hasDisplayName())
                        meta.setDisplayName(rsvMeta.getDisplayName());
                }

                if (config.getBoolean("UpdateItems.UpdateLore")) {
                    if (rsvMeta.hasLore())
                        meta.setLore(rsvMeta.getLore());
                }

                if (config.getBoolean("UpdateItems.UpdateUnbreakability"))
                    meta.setUnbreakable(rsvMeta.isUnbreakable());

                if (config.getBoolean("UpdateItems.UpdateAttributeModifiers")) {
                    if (rsvMeta.hasAttributeModifiers())
                        meta.setAttributeModifiers(rsvMeta.getAttributeModifiers());
                }

                if (config.getBoolean("UpdateItems.UpdateAttributeModifiers")) {
                    if (rsvMeta.hasLocalizedName())
                        meta.setLocalizedName(rsvMeta.getLocalizedName());
                }

                if (config.getBoolean("UpdateItems.UpdateCustomModelData")) {
                    if (rsvMeta.hasCustomModelData()) {
                        meta.setCustomModelData(rsvMeta.getCustomModelData());
                    }
                }

                if (config.getBoolean("UpdateItems.UpdateEnchants.Enabled")) {
                    Map<Enchantment, Integer> map = meta.getEnchants();

                    if (!config.getBoolean("UpdateItems.UpdateEnchants.PreserveExistingEnchants")) {
                        Set<Enchantment> enchants = map.keySet();

                        for (Enchantment ench : enchants) {
                            meta.removeEnchant(ench);
                        }
                    }

                    if (rsvMeta.hasEnchants()) {
                        Map<Enchantment, Integer> rsvMap = rsvMeta.getEnchants();
                        Set<Map.Entry<Enchantment, Integer>> entries = rsvMap.entrySet();

                        for (Map.Entry<Enchantment, Integer> entry : entries) {
                            meta.addEnchant(entry.getKey(), entry.getValue(), true);
                        }
                    }
                }

                if (config.getBoolean("UpdateItems.UpdateItemFlags.Enabled")) {
                    Set<ItemFlag> flags = meta.getItemFlags();
                    Set<ItemFlag> rsvFlags = rsvMeta.getItemFlags();

                    if (!config.getBoolean("UpdateItems.UpdateItemFlags.PreserveExistingItemFlags")) {
                        for (ItemFlag flag : flags) {
                            if (flag != null) {
                                meta.removeItemFlags(flag);
                            }
                        }
                    }
                    
                    for (ItemFlag flag : rsvFlags) {
                        if (flag != null) {
                            meta.addItemFlags(flag);
                        }
                    }
                }

                if (config.getBoolean("UpdateItems.UpdateVanillaDurability")) {
                    if (rsvItem.getType().getMaxDurability() > 0) {
                        ((Damageable) meta).setDamage(((Damageable) rsvMeta).getDamage());
                    }
                }

                item.setItemMeta(meta);

                if (config.getBoolean("UpdateItems.UpdateNbtTags.Enabled")) {
                    if (config.getBoolean("UpdateItems.UpdateNbtTags.UpdateModule"))
                        addNbtTag(item, "rsvmodule", RSVItem.getModuleNameFromItem(rsvItem), PersistentDataType.STRING);

                    if (config.getBoolean("UpdateItems.UpdateNbtTags.UpdateCustomDurability"))
                        if (RSVItem.hasCustomDurability(rsvItem))
                            addNbtTag(item, "rsvdurability", RSVItem.getCustomDurability(rsvItem), PersistentDataType.INTEGER);

                    if (config.getBoolean("UpdateItems.UpdateNbtTags.UpdateCustomMaxDurability"))
                        if (RSVItem.hasMaxCustomDurability(rsvItem))
                            addNbtTag(item, "rsvmaxdurability", RSVItem.getMaxCustomDurability(rsvItem), PersistentDataType.INTEGER);
                }
            }
        }
    }

    public ItemStack getNetheriteRSVWeapon(ItemStack item) {
        ItemStack clone = item.clone();
        FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(clone)).getUserConfig().getConfig();
        if (config.getBoolean("UpdateNetheriteItems.Enabled")) {
            if (RSVItem.isRSVItem(clone)) {
                RSVItem rsvItem = RSVItem.getItem(RSVItem.getNameFromItem(clone).replace("diamond", "netherite"));
                ItemMeta rsvMeta = rsvItem.getItemMeta();

                if (config.getBoolean("UpdateNetheriteItems.UpdateMaterial"))
                    clone.setType(rsvItem.getType());

                if (config.getBoolean("UpdateNetheriteItems.UpdateMaterialData"))
                    clone.setData(rsvItem.getData());

                ItemMeta meta = clone.getItemMeta();

                if (config.getBoolean("UpdateNetheriteItems.UpdateDisplayName")) {
                    if (rsvMeta.hasDisplayName())
                        meta.setDisplayName(rsvMeta.getDisplayName());
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateLore")) {
                    if (rsvMeta.hasLore())
                        meta.setLore(rsvMeta.getLore());
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateUnbreakability"))
                    meta.setUnbreakable(rsvMeta.isUnbreakable());

                if (config.getBoolean("UpdateNetheriteItems.UpdateAttributeModifiers")) {
                    if (rsvMeta.hasAttributeModifiers())
                        meta.setAttributeModifiers(rsvMeta.getAttributeModifiers());
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateAttributeModifiers")) {
                    if (rsvMeta.hasLocalizedName())
                        meta.setLocalizedName(rsvMeta.getLocalizedName());
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateCustomModelData")) {
                    if (rsvMeta.hasCustomModelData()) {
                        meta.setCustomModelData(rsvMeta.getCustomModelData());
                    }
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateEnchants.Enabled")) {
                    Map<Enchantment, Integer> map = meta.getEnchants();

                    if (!config.getBoolean("UpdateNetheriteItems.UpdateEnchants.PreserveExistingEnchants")) {
                        Set<Enchantment> enchants = map.keySet();

                        for (Enchantment ench : enchants) {
                            meta.removeEnchant(ench);
                        }
                    }

                    if (rsvMeta.hasEnchants()) {
                        Map<Enchantment, Integer> rsvMap = rsvMeta.getEnchants();
                        Set<Map.Entry<Enchantment, Integer>> entries = rsvMap.entrySet();

                        for (Map.Entry<Enchantment, Integer> entry : entries) {
                            meta.addEnchant(entry.getKey(), entry.getValue(), true);
                        }
                    }
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateItemFlags.Enabled")) {
                    Set<ItemFlag> flags = meta.getItemFlags();
                    Set<ItemFlag> rsvFlags = rsvMeta.getItemFlags();

                    if (!config.getBoolean("UpdateNetheriteItems.UpdateItemFlags.PreserveExistingItemFlags")) {
                        for (ItemFlag flag : flags) {
                            if (flag != null) {
                                meta.removeItemFlags(flag);
                            }
                        }
                    }

                    for (ItemFlag flag : rsvFlags) {
                        if (flag != null) {
                            meta.addItemFlags(flag);
                        }
                    }
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateVanillaDurability")) {
                    if (rsvItem.getType().getMaxDurability() > 0) {
                        ((Damageable) meta).setDamage(((Damageable) rsvMeta).getDamage());
                    }
                }

                clone.setItemMeta(meta);

                if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.Enabled")) {
                    if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.UpdateModule"))
                        addNbtTag(clone, "rsvmodule", RSVItem.getModuleNameFromItem(rsvItem), PersistentDataType.STRING);

                    if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.UpdateCustomDurability"))
                        if (RSVItem.hasCustomDurability(rsvItem))
                            addNbtTag(clone, "rsvdurability", RSVItem.getCustomDurability(rsvItem), PersistentDataType.INTEGER);

                    if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.UpdateCustomMaxDurability"))
                        if (RSVItem.hasMaxCustomDurability(rsvItem))
                            addNbtTag(clone, "rsvmaxdurability", RSVItem.getMaxCustomDurability(rsvItem), PersistentDataType.INTEGER);
                }
            }
        }
        return clone;
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
        else {
            if (StringUtils.isAllUpperCase(soundName)) {
                loc.getWorld().playSound(loc, Sound.valueOf(soundName), volume, pitch);
            }
            else {
                loc.getWorld().playSound(loc, soundName, volume, pitch);
            }
        }
    }

    public static ItemStack updateLore(ItemStack item, int oldDurability, int newDurability) {
        if (RSVItem.hasMaxCustomDurability(item) && RSVItem.hasCustomDurability(item)) {
            ItemMeta meta = item.getItemMeta();

            if (meta.hasLore()) {
                List<String> lore = meta.getLore();

                int maxDurability = RSVItem.getMaxCustomDurability(item);

                boolean changedDurability = false;
                boolean isJuice = RealisticSurvivalPlugin.getUtil().hasNbtTag(item, "rsvdrink");
                boolean changedJuice = false;

                for (int i = 0; i < lore.size(); i++) {
                    if (lore.get(i).contains("Durability:")) {
                        lore.set(i, lore.get(i).replace(oldDurability + "/" + maxDurability, newDurability + "/" + maxDurability));
                        changedDurability = true;
                    }
                    if (isJuice) {
                        if (lore.get(i).contains("Drink: ")) {
                            lore.set(i, "Drink: " + RealisticSurvivalPlugin.getUtil().getNbtTag(item, "rsvdrink", PersistentDataType.STRING));
                            changedJuice = true;
                        }
                    }

                    if (changedDurability) {
                        break;
                    }
                    if (isJuice && changedJuice) {
                        break;
                    }
                }

                meta.setLore(lore);
                item.setItemMeta(meta);
            }
        }
        return item;
    }

    public static String toRomanNumeral(int num)
    {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++)
        {
            while (num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }

    public static boolean wasBackstabbed(Entity attacker, Entity defender) {
        Location attackerLoc = attacker.getLocation();
        Location defenderLoc = defender.getLocation();

        Vector attackerDirection = attackerLoc.getDirection();
        Vector victimDirection = defenderLoc.getDirection();
        //determine if the dot product between the vectors is greater than 0
        return attackerDirection.dot(victimDirection) > 0;
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

    public enum Hand {
        MAIN_HAND, OFF_HAND
    }
}