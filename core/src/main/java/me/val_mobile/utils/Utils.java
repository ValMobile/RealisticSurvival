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

import me.clip.placeholderapi.PlaceholderAPI;
import me.val_mobile.baubles.EndermanAlly;
import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.*;
import me.val_mobile.integrations.CompatiblePlugin;
import me.val_mobile.integrations.PAPI;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanweaponry.KbTask;
import me.val_mobile.utils.ToolHandler.Tool;
import me.val_mobile.utils.recipe.RSVRecipe;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.command.CommandSender;
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

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static final double ATTACK_DAMAGE_CONSTANT = -1.0;
    public static final double ATTACK_SPEED_CONSTANT = -4.0;
    private static final Pattern VERSION_PATTERN = Pattern.compile("([1-9])\\.([1-9][0-9]|[1-9])(\\.([0-9]))?");

    private final RSVPlugin plugin;

    private static InternalsProvider internals;

    static {
        try {
            String packageName = Utils.class.getPackage().getName();
//            String internalsName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            internals = (InternalsProvider) Class.forName(packageName + "." + getMinecraftVersion(true)).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException | NoSuchMethodException | InvocationTargetException exception) {
            Bukkit.getLogger().log(Level.SEVERE, "NMS Util could not find a valid implementation for this server version.");
        }
    }

    public Utils(RSVPlugin plugin) {
        this.plugin = plugin;
    }

    @Nonnull
    private static String format(@Nonnull String text, @Nonnull Map<String, Object> placeholders) {
        StringBuilder newTemplate = new StringBuilder(text);
        List<Object> valueList = new ArrayList<>();

        Matcher matcher = Pattern.compile("%(\\w+)%").matcher(text);

        while (matcher.find()) {
            String key = matcher.group(1);

            String paramName = "%" + key + "%";
            int index = newTemplate.indexOf(paramName);
            if (index != -1) {
                newTemplate.replace(index, index + paramName.length(), "%s");
                valueList.add(placeholders.get(key));
            }
        }

        return String.format(newTemplate.toString(), valueList.toArray());
    }

    @Nonnull
    public static String translateMsg(@Nonnull String text, @Nullable CommandSender sender, @Nullable Map<String, Object> placeholders) {
        String translatedText = text;

        if (CompatiblePlugin.isIntegrated(PAPI.NAME)) {
            translatedText = PlaceholderAPI.setPlaceholders(sender instanceof Player ? (Player) sender : (sender instanceof OfflinePlayer ? (OfflinePlayer) sender : null), translatedText);
        }

        if (placeholders != null) {
            translatedText = format(translatedText, placeholders);
        }

        return ChatColor.translateAlternateColorCodes('&', translatedText);
    }

    @Nonnull
    public static List<String> translateMsgs(@Nonnull List<String> texts, @Nullable CommandSender sender, @Nullable Map<String, Object> placeholders) {
        List<String> translated = new ArrayList<>(texts);

        String temp;

        if (CompatiblePlugin.isIntegrated(PAPI.NAME)) {
            translated = PlaceholderAPI.setPlaceholders(sender instanceof Player ? (Player) sender : (sender instanceof OfflinePlayer ? (OfflinePlayer) sender : null), translated);
        }

        for (int i = 0; i < translated.size(); i++) {
            temp = translated.get(i);

            if (placeholders != null) {
                temp = format(temp, placeholders);
            }

            temp = ChatColor.translateAlternateColorCodes('&', temp);

            translated.set(i, temp);
        }

        return translated;
    }

    public static double round(double value, @Nonnegative int places) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    @Nonnull
    public static String getMinecraftVersion(boolean impl) {
        Matcher m = VERSION_PATTERN.matcher(Bukkit.getVersion());

        if (m.find()) {
            String prefix = m.group(1);
            String major = m.group(2);
            String minor = m.group(4) == null ? "0" : m.group(4);
            return impl ? "v" + prefix + "_" + major + "_R" + (Integer.parseInt(minor) + 1) : prefix + "." + major + (minor.equals("0") ? "" : "." + minor);
        }
        return "";
    }

    public static boolean isServerRunningPaper() {
        try {
            Class.forName("com.destroystokyo.paper.ParticleBuilder");
            return true;
        } catch (ClassNotFoundException ignored) {}
        return false;
    }

    @Nonnull
    public static List<String> getAllWorldNames() {
        List<String> worldNames = new ArrayList<>();

        for (File file: Bukkit.getServer().getWorldContainer().listFiles()){
            if (file.isDirectory() && Arrays.asList(file.list()).contains("level.dat")) {
                worldNames.add(file.getName());
            }
        }
        return worldNames;
    }

    @Nonnull
    public static List<Material> getMaterialsFromList(@Nonnull List<String> list) {
        List<Material> mats = new ArrayList<>();

        for (String s : list) {
            if (!(s == null || s.isEmpty())) {
                if (s.contains("Tag.")) {
                    mats.addAll(getTag(s.substring(4)).getValues());
                }
                else if (isTag(s)) {
                    mats.addAll(getTag(s).getValues());
                }
                else {
                    mats.add(Material.valueOf(s));
                }
            }
        }
        return mats;
    }

    public static void randomTpSafely(@Nonnull Entity entity, @Nonnegative double radius) {
        World world = entity.getWorld();
        Location loc = entity.getLocation().clone();

        int x;
        int y;
        int z;
        Block below;
        Block block;
        Block highestBlock;
        Block aboveBlock;
        Block thirdBlock; // used only for entities that are 3 blocks tall

        boolean isShort = entity.getHeight() <= 2;

        for (int i = 0; i < 16; i++) {
            x = (int) getRandomNum(-1 * radius, radius);
            y = (int) getRandomNum(-1 * radius, radius);
            z = (int) getRandomNum(-1 * radius, radius);

            double actualX = loc.getX() + x;
            actualX = Math.floor(actualX) + clamp(actualX - (int) actualX, 0.45, 0.55);

            double actualZ = loc.getZ() + z;
            actualZ = Math.floor(actualZ) + clamp(actualZ - (int) actualZ, 0.45, 0.55);

            double actualY = clamp(loc.getY() + y, world.getMinHeight(), world.getMaxHeight());
            block = world.getBlockAt((int) Math.round(actualX), (int) Math.round(actualY), (int) Math.round(actualZ));
            below = world.getBlockAt(block.getX(), block.getY() - 1, block.getZ());
            highestBlock = world.getHighestBlockAt(block.getX(), block.getZ());
            aboveBlock = world.getBlockAt(block.getX(), block.getY() + 1, block.getZ());
            thirdBlock = world.getBlockAt(block.getX(), block.getY() + 1, block.getZ());

            if (!below.isPassable() && block.isPassable() && aboveBlock.isPassable() && !highestBlock.isEmpty() && !(block.isLiquid() || aboveBlock.isLiquid() || highestBlock.isLiquid())) {
                if ((thirdBlock.isPassable() && !thirdBlock.isLiquid()) || isShort) {
                    loc.setX(actualX);
                    loc.setY(highestBlock.getY() + 1D);
                    loc.setZ(actualZ);
                    entity.teleport(loc);
                    break;
                }
            }
        }
    }

    @Nonnull
    public static String toLowercaseAttributeName(@Nonnull Attribute atr) {
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

    public static double getCorrectAttributeValue(@Nonnull Attribute attribute, double requestedValue) {
        return switch (attribute) {
            case GENERIC_ATTACK_DAMAGE -> requestedValue + ATTACK_DAMAGE_CONSTANT;
            case GENERIC_ATTACK_SPEED -> requestedValue + ATTACK_SPEED_CONSTANT;
            case GENERIC_ARMOR, GENERIC_ARMOR_TOUGHNESS -> requestedValue;
            default -> 0;
        };
    }

    public static boolean isHelmet(@Nonnull Material material) {
        return switch (material) {
            case CHAINMAIL_HELMET, DIAMOND_HELMET, GOLDEN_HELMET, IRON_HELMET, LEATHER_HELMET, NETHERITE_HELMET, TURTLE_HELMET -> true;
            default -> false;
        };
    }

    public static boolean isChestplate(@Nonnull Material material) {
        return switch (material) {
            case CHAINMAIL_CHESTPLATE, DIAMOND_CHESTPLATE, GOLDEN_CHESTPLATE, IRON_CHESTPLATE, LEATHER_CHESTPLATE, NETHERITE_CHESTPLATE -> true;
            default -> false;
        };
    }

    public static boolean isLeggings(@Nonnull Material material) {
        return switch (material) {
            case CHAINMAIL_LEGGINGS, DIAMOND_LEGGINGS, GOLDEN_LEGGINGS, IRON_LEGGINGS, LEATHER_LEGGINGS, NETHERITE_LEGGINGS -> true;
            default -> false;
        };
    }

    public static boolean isBoots(@Nonnull Material material) {
        return switch (material) {
            case CHAINMAIL_BOOTS, DIAMOND_BOOTS, GOLDEN_BOOTS, IRON_BOOTS, LEATHER_BOOTS, NETHERITE_BOOTS -> true;
            default -> false;
        };
    }

    public static EquipmentSlot getEquipmentSlotFromMaterial(@Nonnull Material material) {
        if (isHelmet(material)) {
            return EquipmentSlot.HEAD;
        }

        if (isChestplate(material)) {
            return EquipmentSlot.CHEST;
        }

        if (isLeggings(material)) {
            return EquipmentSlot.LEGS;
        }

        if (isBoots(material)) {
            return EquipmentSlot.FEET;
        }
        return EquipmentSlot.HAND;
    }

    public static boolean isArmor(@Nonnull Material material) {
        return isHelmet(material) || isChestplate(material) || isLeggings(material) || isBoots(material);
    }

    public static void updateDamageLore(@Nonnull ItemStack item, @Nullable Set<Map.Entry<Enchantment, Integer>> entrySet) {
        if (RSVItem.isRSVItem(item)) {
            ItemMeta meta = item.getItemMeta();

            if (meta != null) {
                if (meta.hasAttributeModifiers() && meta.hasLore()) {
                    List<String> lore = meta.getLore();
                    Collection<AttributeModifier> modifiers = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE);

                    if (!(modifiers == null || modifiers.isEmpty() || lore == null)) {
                        int lvl = 0;

                        if (entrySet != null) {
                            if (!entrySet.isEmpty()) {
                                for (Map.Entry<Enchantment, Integer> entry : entrySet) {
                                    if (entry.getKey().equals(Enchantment.DAMAGE_ALL)) {
                                        lvl = Math.max(lvl, entry.getValue());
                                    }
                                }
                            }
                        }

                        double baseDmg = 0;
                        for (AttributeModifier modifier : modifiers) {
                            if (modifier.getSlot() == EquipmentSlot.HAND) {
                                baseDmg += modifier.getAmount() - ATTACK_DAMAGE_CONSTANT;
                            }
                        }

                        double extraDmg = 0.5 * Math.max(0, lvl - 1) + 1.0;
                        double newDmg = baseDmg + extraDmg;

                        int len = lore.size();
                        int index = -1;

                        for (int i = 0 ; i < len; i++) {
                            if (lore.get(i).contains("Attack Damage")) {
                                index = i;
                                break;
                            }
                        }

                        if (index != -1) {
                            List<String> before = new ArrayList<>(lore.subList(0, index));
                            LorePresets.addGearStats(before, Attribute.GENERIC_ATTACK_DAMAGE, newDmg);

                            if (index + 1 < len) {
                                before.addAll(lore.subList(index + 1, lore.size()));
                            }

                            meta.setLore(before);
                            item.setItemMeta(meta);
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static EquipmentSlot getCorrectEquipmentSlot(@Nonnull Attribute attribute, @Nonnull Material material) {
        switch (attribute) {
            case GENERIC_ATTACK_DAMAGE, GENERIC_ATTACK_SPEED -> {
                return EquipmentSlot.HAND;
            }
            case GENERIC_ARMOR, GENERIC_ARMOR_TOUGHNESS -> {
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
            }
            default -> {}
        }
        return null;
    }

    @Nonnull
    public static Attribute translateInformalAttributeName(@Nonnull String name) {
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

    @Nullable
    public static String getMinecraftEnchName(@Nonnull String keyName) {
        return switch (keyName) {
            case "ARROW_DAMAGE" -> "power";
            case "ARROW_FIRE" -> "flame";
            case "ARROW_INFINITE" -> "infinity";
            case "ARROW_KNOCKBACK" -> "punch";
            case "BINDING_CURSE" -> "binding_curse";
            case "DAMAGE_ALL" -> "sharpness";
            case "DAMAGE_ARTHROPODS" -> "bane_of_arthropods";
            case "DAMAGE_UNDEAD" -> "smite";
            case "DEPTH_STRIDER" -> "depth_strider";
            case "DIG_SPEED" -> "efficiency";
            case "DURABILITY" -> "unbreaking";
            case "FIRE_ASPECT" -> "fire_aspect";
            case "FROST_WALKER" -> "frost_walker";
            case "KNOCKBACK" -> "knockback";
            case "LOOT_BONUS_BLOCKS" -> "fortune";
            case "LOOT_BONUS_MOBS" -> "looting";
            case "LUCK" -> "luck_of_the_sea";
            case "LURE" -> "lure";
            case "MENDING" -> "mending";
            case "OXYGEN" -> "respiration";
            case "PROTECTION_ENVIRONMENTAL" -> "protection";
            case "PROTECTION_EXPLOSIONS" -> "blast_protection";
            case "PROTECTION_FALL" -> "feather_falling";
            case "PROTECTION_FIRE" -> "fire_protection";
            case "PROTECTION_PROJECTILE" -> "projectile_protection";
            case "SILK_TOUCH" -> "silk_touch";
            case "SWEEPING_EDGE" -> "sweeping_edge";
            case "THORNS" -> "thorns";
            case "VANISHING_CURSE" -> "vanishing_cursh";
            case "WATER_WORKER" -> "aqua_affinity";
            case "SOUL_SPEED" -> "soul_speed";
            case "PIERCING" -> "piercing";
            case "QUICK_CHARGE" -> "quick_charge";
            case "SWIFT_SNEAK" -> "swift_sneak";
            case "MULTISHOT" -> "multishot";
            case "CHANNELING" -> "channeling";
            case "RIPTIDE" -> "riptide";
            case "IMPALING" -> "impaling";
            case "LOYALTY" -> "loyalty";
            default -> null;
        };
    }

    public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if(e.name().equals(value)) { return true; }
        }
        return false;
    }

    public static boolean isHoldingAxe(@Nonnull Player player) {
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

    public static boolean hasArmor(@Nonnull Entity entity) {
        if (entity instanceof LivingEntity living) {
            EntityEquipment equipment = living.getEquipment();

            if (equipment != null) {
                ItemStack[] armor = equipment.getArmorContents();

                for (ItemStack item : armor) {
                    if (isItemReal(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasChestplate(@Nonnull Entity entity) {
        if (entity instanceof LivingEntity living) {
            EntityEquipment equipment = living.getEquipment();

            if (equipment != null) {
                ItemStack chestplate = equipment.getChestplate();
                return isItemReal(chestplate);
            }
        }
        return false;
    }

    @Nullable
    public static Color valueOfColor(@Nonnull String color) {
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

    public static boolean isItemReal(@Nullable ItemStack item) {
        return !(item == null || item.getType() == Material.AIR || item.getAmount() < 1);
    }

    public static void damageEntity(@Nonnull org.bukkit.entity.Damageable entity, double damage, @Nullable Entity attacker) {
        double points = 0;
        double toughness = 0;
        int resistance = 0;
        int epf = 0;

        if (entity instanceof LivingEntity living) {
            AttributeInstance armor = living.getAttribute(Attribute.GENERIC_ARMOR);
            AttributeInstance armorToughness = living.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS);
            EntityEquipment equipment = living.getEquipment();

            if (armor != null) {
                points = armor.getValue();
            }

            if (armorToughness != null) {
                toughness = armorToughness.getValue();
            }

            PotionEffect effect = living.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            resistance = effect == null ? 0 : effect.getAmplifier();

            if (equipment != null) {
                epf = getEPF(equipment);
            }
        }
        entity.damage(calculateDamageApplied(damage, points, toughness, resistance, epf), attacker);
    }

    public static double calculateDamageApplied(double damage, double points, double toughness, int resistance, int epf) {
        double withArmorAndToughness = damage * (1 - Math.min(20, Math.max(points / 5, points - damage / (2 + toughness / 4))) / 25);
        double withResistance = withArmorAndToughness * (1 - (resistance * 0.2));
        return withResistance * (1 - (Math.min(20.0, epf) / 25));
    }

    public static int getEPF(@Nonnull EntityEquipment inv) {
        ItemStack helm = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack legs = inv.getLeggings();
        ItemStack boot = inv.getBoots();

        return (helm != null ? helm.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0) +
                (chest != null ? chest.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0) +
                (legs != null ? legs.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0) +
                (boot != null ? boot.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) : 0);
    }

    public static void setFreezingView(@Nonnull Player player, int ticks) {
        internals.setFreezingView(player, ticks);
    }

    public static <T> void addNbtTag(@Nonnull Entity entity, @Nonnull String key, @Nonnull T value, @Nonnull PersistentDataType<T,T> type) {
        RSVPlugin.getUtil().addInternalNbtTag(entity, key, value, type);
    }

    public static <T> void addNbtTag(@Nonnull ItemStack item, @Nonnull String key, @Nonnull T value, @Nonnull PersistentDataType<T,T> type) {
        RSVPlugin.getUtil().addInternalNbtTag(item, key, value, type);
    }

    @Nullable
    public static <T> T getNbtTag(@Nonnull Entity entity, @Nonnull String key, @Nonnull PersistentDataType<T,T> type) {
        return RSVPlugin.getUtil().getInternalNbtTag(entity, key, type);
    }


    @Nullable
    public static <T> T getNbtTag(@Nonnull ItemStack item, @Nonnull String key, @Nonnull PersistentDataType<T,T> type) {
        return RSVPlugin.getUtil().getInternalNbtTag(item, key, type);
    }

    public static boolean hasNbtTag(@Nonnull Entity entity, @Nonnull String key) {
        return RSVPlugin.getUtil().hasInternalNbtTag(entity, key);
    }

    public static boolean hasNbtTag(@Nonnull ItemStack item, @Nonnull String key) {
        return RSVPlugin.getUtil().hasInternalNbtTag(item, key);
    }

    public static int getMaxDurability(@Nonnull ItemStack item) {
        return hasCustomDurability(item) ? getMaxCustomDurability(item) : getMaxVanillaDurability(item);
    }

    public static int getMaxCustomDurability(@Nonnull ItemStack item) {
        return getNbtTag(item, "rsvmaxdurability", PersistentDataType.INTEGER);
    }

    public static int getMaxVanillaDurability(@Nonnull ItemStack item) {
        return item.getType().getMaxDurability();
    }

    public static int getDurability(@Nonnull ItemStack item) {
        return hasCustomDurability(item) ? getCustomDurability(item) : getVanillaDurability(item);
    }

    public static int getVanillaDurability(@Nonnull ItemStack item) {
        return getMaxVanillaDurability(item) - ((Damageable) item.getItemMeta()).getDamage();
    }

    public static int getCustomDurability(@Nonnull ItemStack item) {
        return getNbtTag(item, "rsvdurability", PersistentDataType.INTEGER);
    }

    public static boolean hasCustomDurability(@Nonnull ItemStack item) {
        return hasNbtTag(item, "rsvdurability") && hasNbtTag(item, "rsvmaxdurability");
    }

    public static void setKbMultiplier(@Nonnull Entity entity, double multiplier) {
        RSVPlugin.getUtil().setInternalKbMultiplier(entity, multiplier);
    }

    public static void setZeroKb(@Nonnull Entity entity) {
        RSVPlugin.getUtil().setInternalZeroKb(entity);
    }

    public static boolean doublesEquals(double v, double v1) {
        double tolerance = 0.0001;

        return Math.abs(v - v1) <= tolerance;
    }

    public static boolean doublesEquals(double v, double v1, @Nonnegative double tolerance) {
        return Math.abs(v - v1) <= tolerance;
    }

    public static boolean isUndead(@Nonnull Entity entity) {
        return internals.isUndead(entity);
    }

    public static boolean isNetheriteRecipe(@Nonnull SmithingInventory inv) {
        return internals.isNetheriteRecipe(inv);
    }

    public static boolean isTag(@Nonnull String name) {
        try {
            internals.getTag(name);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static int getRandomNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static double getRandomNum(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public static boolean roll(double chance) {
        return Math.random() <= chance;
    }

    public static boolean areCriticalHitConditionsMet(@Nonnull Player player, double baseDamage, double finalDamage) {
        return player.getFallDistance() > 0 && ((Entity) (player)).isOnGround() && !player.getLocation().getBlock().isLiquid()
        && !Tag.CLIMBABLE.isTagged(player.getLocation().getBlock().getType()) && !player.hasPotionEffect(PotionEffectType.BLINDNESS)
                && player.getVehicle() == null && !player.isSprinting() && finalDamage > 0.848D * baseDamage;
    }

    @Nullable
    public static Tag<Material> getTag(@Nonnull String name) {
        return internals.getTag(name);
    }

    public static boolean isSourceLiquid(@Nonnull Block block) {
        BlockData blockData = block.getBlockData();

        if (blockData instanceof Levelled)
            return ((Levelled) blockData).getLevel() == 0;
        return false;
    }

    public static boolean isExposedToSky(@Nonnull Player player) {
        Location loc = player.getLocation();

        int highestY = loc.getWorld().getHighestBlockYAt(loc);

        return loc.getY() >= highestY;
    }

    public static void discoverRecipe(@Nonnull Player player, @Nonnull Recipe recipe) {
        NamespacedKey key;

        if (recipe instanceof Keyed keyed) {
            key = keyed.getKey();
            if (!player.hasDiscoveredRecipe(key)) {
                player.discoverRecipe(key);
            }
        }
    }

    public static boolean dropFortune(@Nonnull ConfigurationSection section, @Nonnull ItemStack drop, @Nullable ItemStack tool, @Nonnull Location loc) {
        int lvl = 0;

        if (isItemReal(tool)) {
            lvl = tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }

        switch (section.getString("Type").toUpperCase()) {
            case "RARE", "COMMON" -> {
                double chance = section.getDouble("Chance");
                double rawAmount = (1D / (lvl + 2D) + (lvl + 1D) / 2D) * chance;
                int actualAmount = (int) Math.floor(rawAmount);
                double dif = rawAmount - actualAmount;

                if (roll(dif))
                    actualAmount++;

                if (actualAmount > 0) {
                    drop.setAmount(actualAmount);
                    loc.getWorld().dropItemNaturally(loc, drop);
                    return true;
                }
            }
            case "RANGE" -> {
                int min = section.getInt("MinAmount");
                int max = section.getInt("MaxAmount");

                int amount = getRandomNum(min, max);

                if (amount > 0) {
                    drop.setAmount(amount);
                    loc.getWorld().dropItemNaturally(loc, drop);
                    return true;
                }
            }
            default -> {}
        }
        return false;
    }

    @Nullable
    public static EquipmentSlot getSlotContainingRsvItem(@Nonnull Player player, @Nonnull String rsvName) {
        PlayerInventory inv = player.getInventory();

        ItemStack helmet = inv.getHelmet();
        ItemStack chestplate = inv.getChestplate();
        ItemStack leggings = inv.getLeggings();
        ItemStack boots = inv.getBoots();
        ItemStack mainHand = inv.getItemInMainHand();
        ItemStack offHand = inv.getItemInOffHand();

        if (RSVItem.isRSVItem(mainHand)) {
            if (RSVItem.getNameFromItem(mainHand).equals(rsvName)) {
                return EquipmentSlot.HAND;
            }
        }
        if (RSVItem.isRSVItem(offHand)) {
            if (RSVItem.getNameFromItem(offHand).equals(rsvName)) {
                return EquipmentSlot.OFF_HAND;
            }
        }
        if (RSVItem.isRSVItem(helmet)) {
            if (RSVItem.getNameFromItem(helmet).equals(rsvName)) {
                return EquipmentSlot.HEAD;
            }
        }
        if (RSVItem.isRSVItem(chestplate)) {
            if (RSVItem.getNameFromItem(chestplate).equals(rsvName)) {
                return EquipmentSlot.CHEST;
            }
        }
        if (RSVItem.isRSVItem(leggings)) {
            if (RSVItem.getNameFromItem(leggings).equals(rsvName)) {
                return EquipmentSlot.LEGS;
            }
        }
        if (RSVItem.isRSVItem(boots)) {
            if (RSVItem.getNameFromItem(boots).equals(rsvName)) {
                return EquipmentSlot.FEET;
            }
        }
        return null;
    }

    @Nullable
    public static ItemStack getMobLoot(@Nonnull ConfigurationSection section, @Nonnull ItemStack drop, @Nullable ItemStack tool, boolean checkLooting) {
        int lvl = 0;

        if (isItemReal(tool) && checkLooting) {
            lvl = tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
        }

        switch (section.getString("Type").toUpperCase()) {
            case "RARE" -> {
                double chance = section.getDouble("Chance") + lvl * 0.01;
                // rare drops
                if (roll(chance)) {
                    return drop;
                }
                else {
                    if (roll((lvl / (lvl + 1D))/100D))
                        return drop;
                }
            }
            case "COMMON" -> {
                double chance = section.getDouble("Chance");

                if (roll(chance + lvl * 0.01)) {
                    int maxAmount = lvl + 1;

                    double rawAmount = chance * maxAmount;
                    int actualAmount = (int) Math.floor(rawAmount);

                    double dif = rawAmount - actualAmount;

                    if (roll(dif))
                        actualAmount++;

                    if (actualAmount > 0) {
                        drop.setAmount(actualAmount);
                        return drop;
                    }
                }
            }
            case "RANGE" -> {
                int min = section.getInt("MinAmount");
                int max = section.getInt("MaxAmount");

                int amount = getRandomNum(min, max);

                if (amount > 0) {
                    drop.setAmount(amount);
                    return drop;
                }
            }
            default -> {}
        }

        return null;
    }

    public static boolean dropLooting(@Nonnull ConfigurationSection section, @Nonnull ItemStack drop, @Nullable ItemStack tool, @Nonnull Location loc, boolean checkLooting) {
        ItemStack item = getMobLoot(section, drop, tool, checkLooting);

        if (Utils.isItemReal(item)) {
            loc.getWorld().dropItemNaturally(loc, item);
            return true;
        }
        return false;

    }

    @Nullable
    public static Set<Material> getVanillaRepairMaterials(@Nonnull Material material) {
        return switch (material) {
            case NETHERITE_AXE, NETHERITE_BOOTS, NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_PICKAXE, NETHERITE_SWORD, NETHERITE_SHOVEL, NETHERITE_HOE ->
                    Set.of(Material.NETHERITE_INGOT);
            case DIAMOND_AXE, DIAMOND_BOOTS, DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_PICKAXE, DIAMOND_SWORD, DIAMOND_SHOVEL, DIAMOND_HOE ->
                    Set.of(Material.DIAMOND);
            case IRON_AXE, IRON_BOOTS, IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_PICKAXE, IRON_SWORD, IRON_SHOVEL, IRON_HOE, CHAINMAIL_BOOTS, CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS ->
                    Set.of(Material.IRON_INGOT);
            case GOLDEN_AXE, GOLDEN_BOOTS, GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_PICKAXE, GOLDEN_SWORD, GOLDEN_SHOVEL, GOLDEN_HOE ->
                    Set.of(Material.GOLD_INGOT);
            case STONE_AXE, STONE_PICKAXE, STONE_SWORD, STONE_SHOVEL, STONE_HOE -> Set.of(Material.COBBLESTONE, Material.BLACKSTONE);
            case WOODEN_AXE, WOODEN_PICKAXE, WOODEN_SWORD, WOODEN_SHOVEL, WOODEN_HOE, SHIELD -> Tag.PLANKS.getValues();
            case LEATHER_BOOTS, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_HELMET -> Set.of(Material.LEATHER);
            case TURTLE_HELMET -> Set.of(Material.SCUTE);
            default -> null;
        };
    }

    public static boolean isNetherite(@Nonnull Material material) {
        return switch (material) {
            case NETHERITE_AXE, NETHERITE_BOOTS, NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_PICKAXE, NETHERITE_SWORD, NETHERITE_SHOVEL, NETHERITE_HOE -> true;
            default -> false;
        };
    }

    public static boolean isDiamond(@Nonnull Material material) {
        return switch (material) {
            case DIAMOND_AXE, DIAMOND_BOOTS, DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_PICKAXE, DIAMOND_SWORD, DIAMOND_SHOVEL, DIAMOND_HOE -> true;
            default -> false;
        };
    }

    @Nullable
    public static Material getRespectivePlank(@Nonnull Material wood) {
        return switch (wood.toString()) {
            case "OAK_WOOD", "OAK_LOG", "STRIPPED_OAK_LOG", "STRIPPED_OAK_WOOD" -> Material.OAK_PLANKS;
            case "BIRCH_WOOD", "BIRCH_LOG", "STRIPPED_BIRCH_LOG", "STRIPPED_BIRCH_WOOD" -> Material.BIRCH_PLANKS;
            case "SPRUCE_WOOD", "SPRUCE_LOG", "STRIPPED_SPRUCE_LOG", "STRIPPED_SPRUCE_WOOD" -> Material.SPRUCE_PLANKS;
            case "ACACIA_WOOD", "ACACIA_LOG", "STRIPPED_ACACIA_LOG", "STRIPPED_ACACIA_WOOD" -> Material.ACACIA_PLANKS;
            case "JUNGLE_WOOD", "JUNGLE_LOG", "STRIPPED_JUNGLE_LOG", "STRIPPED_JUNGLE_WOOD" -> Material.JUNGLE_PLANKS;
            case "CRIMSON_STEM", "CRIMSON_HYPHAE", "STRIPPED_CRIMSON_HYPHAE", "STRIPPED_CRIMSON_STEM" -> Material.CRIMSON_PLANKS;
            case "WARPED_STEM", "WARPED_HYPHAE", "STRIPPED_WARPED_HYPHAE", "STRIPPED_WARPED_STEM" -> Material.WARPED_PLANKS;
            case "DARK_OAK_WOOD", "DARK_OAK_LOG", "STRIPPED_DARK_OAK_LOG", "STRIPPED_DARK_OAK_WOOD" -> Material.DARK_OAK_PLANKS;
            case "MANGROVE_WOOD", "MANGROVE_LOG", "STRIPPED_MANGROVE_LOG", "STRIPPED_MANGROVE_WOOD" -> Material.valueOf("MANGROVE_PLANKS");
            case "BAMBOO_BLOCK", "STRIPPED_BAMBOO_BLOCK" -> Material.valueOf("BAMBOO_PLANKS");
            case "CHERRY_WOOD", "CHERRY_LOG", "STRIPPED_CHERRY_WOOD", "STRIPPED_CHERRY_LOG" -> Material.valueOf("CHERRY_PLANKS");
            case "PALE_OAK_WOOD", "PALE_OAK_LOG", "STRIPPED_PALE_OAK_WOOD", "STRIPPED_PALE_OAK_LOG" -> Material.valueOf("PALE_OAK_PLANKS");
            default -> null;
        };
    }

    // checks if a material matches a string that represents a string or tag
    public static boolean matchMaterial(@Nullable Material mat, @Nullable String key, boolean ignoreTags) {
        if (mat == null || key == null) {
            return false;
        }

        if (ignoreTags) {
            return mat.toString().equals(key);
        }

        RecipeChoice choice = RSVRecipe.getRecipeChoice(key);

        return choice != null && choice.test(new ItemStack(mat));
    }

    // checks if a material matches a list of strings and/or tags
    public static boolean matchMaterial(@Nullable Material mat, @Nullable Collection<String> keys, boolean ignoreTags) {
        if (mat == null || keys == null) {
            return false;
        }

        // only check materials
        if (ignoreTags) {
            for (String key : keys) {
                if (mat.toString().equals(key)) {
                    return true;
                }
            }
            return false;
        }

        ItemStack item = null;

        // if an item cannot be created from the material
        try {
            item = new ItemStack(mat);
        } catch (IllegalArgumentException ignored) {
            return false;
        }

        for (String key : keys) {
            RecipeChoice choice = RSVRecipe.getRecipeChoice(key);

            if (choice != null && choice.test(item)) {
                return true;
            }
        }

        return false;
    }

    public static void attack(@Nonnull LivingEntity attacker, @Nonnull Entity defender) {
        internals.attack(attacker, defender);
    }

    public static void changeDurability(@Nonnull ItemStack item, int change, boolean shouldBreak, boolean playBreakSound, @Nullable Entity user) {
        ItemMeta meta = item.getItemMeta();

        // durability should not decrease if user is in creative mode
        if (user instanceof Player player && player.getGameMode() == GameMode.CREATIVE && change < 0) {
            return;
        }

        int lvl = meta.hasEnchant(Enchantment.DURABILITY) ? meta.getEnchantLevel(Enchantment.DURABILITY) : 0;

        boolean hasCustomDurability = hasCustomDurability(item);

        int actualChange = change;

        // if durability should decrease, check for unbreaking enchant
        if (change < 0 && lvl > 0) {
            for (int i = 0; i < -change; i++) {
                if (roll((1D / (lvl + 1D)))) {
                    actualChange++;
                }
            }
        }

        int maxMcDurability = item.getType().getMaxDurability();

        if (hasCustomDurability) {
            int mcDurability;

            int rsvDurability = getCustomDurability(item);
            int rsvMaxDurability = getMaxCustomDurability(item);

            rsvDurability += actualChange;

            // if vanilla item has durability
            if (maxMcDurability > 0) {
                mcDurability = (int) Math.ceil((double) rsvDurability / rsvMaxDurability * maxMcDurability);
                ((Damageable) meta).setDamage(maxMcDurability - mcDurability);
            }

            if (rsvDurability < 0 && shouldBreak) {
                item.setAmount(0);
                item.setType(Material.AIR);

                if (playBreakSound && user != null) {
                    Utils.playSound(user.getLocation(), Sound.ENTITY_ITEM_BREAK.toString(), 1.0f, 1.0f);
                }
            }
            else {
                item.setItemMeta(meta);
                addNbtTag(item, "rsvdurability", Math.min(rsvDurability, rsvMaxDurability), PersistentDataType.INTEGER);
                updateLore(item, Math.min(rsvDurability, rsvMaxDurability));
            }
        }
        else {
            int mcDurability;

            // if vanilla item has durability
            if (maxMcDurability > 0) {
                mcDurability = maxMcDurability - ((Damageable) meta).getDamage();
                mcDurability += actualChange;
                ((Damageable) meta).setDamage(maxMcDurability - mcDurability);

                if (mcDurability < 0 && shouldBreak) {
                    item.setAmount(0);
                    item.setType(Material.AIR);

                    if (playBreakSound && user != null) {
                        Utils.playSound(user.getLocation(), Sound.ENTITY_ITEM_BREAK.toString(), 1.0f, 1.0f);
                    }
                }

                item.setItemMeta(meta);
            }
        }
    }

    public static boolean canRain(@Nonnull Location loc) {
        double biomeTemp = loc.getWorld().getTemperature((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
        return biomeTemp >= 0.15 && biomeTemp <= 0.95 && loc.getWorld().getEnvironment() == World.Environment.NORMAL;
    }

    public static boolean isInLava(@Nonnull Entity entity) {
        return entity.getLocation().getBlock().getType() == Material.LAVA;
    }

    public static void updateItem(@Nonnull ItemStack item) {
        RSVPlugin.getUtil().updateInternalItem(item);
    }

    @Nonnull
    public static ItemStack getNetheriteRSVWeapon(@Nonnull ItemStack item) {
        return RSVPlugin.getUtil().getInternalNetheriteRSVWeapon(item);
    }

    @Nonnull
    public static EndermanAlly spawnEndermanAlly(@Nonnull Player owner, @Nonnull Location loc) {
        return internals.spawnEndermanAlly(owner, loc);
    }

    @Nonnull
    public static FireDragon spawnFireDragon(@Nonnull Location loc) {
        return internals.spawnFireDragon(loc);
    }

    @Nonnull
    public static FireDragon spawnFireDragon(@Nonnull Location loc, int stage) {
        return internals.spawnFireDragon(loc, stage);
    }

    @Nonnull
    public static FireDragon spawnFireDragon(@Nonnull Location loc, @Nonnull DragonVariant variant) {
        return internals.spawnFireDragon(loc, variant);
    }

    public static FireDragon spawnFireDragon(@Nonnull Location loc, @Nonnull DragonVariant variant, int stage) {
        return internals.spawnFireDragon(loc, variant, stage);
    }

    @Nonnull
    public static IceDragon spawnIceDragon(@Nonnull Location loc) {
        return internals.spawnIceDragon(loc);
    }

    @Nonnull
    public static IceDragon spawnIceDragon(@Nonnull Location loc, int stage) {
        return internals.spawnIceDragon(loc, stage);
    }

    @Nonnull
    public static IceDragon spawnIceDragon(@Nonnull Location loc, @Nonnull DragonVariant variant) {
        return internals.spawnIceDragon(loc, variant);
    }

    @Nonnull
    public static IceDragon spawnIceDragon(@Nonnull Location loc, @Nonnull DragonVariant variant, int stage) {
        return internals.spawnIceDragon(loc, variant, stage);
    }

    @Nonnull
    public static LightningDragon spawnLightningDragon(@Nonnull Location loc) {
        return internals.spawnLightningDragon(loc);
    }

    @Nonnull
    public static LightningDragon spawnLightningDragon(@Nonnull Location loc, int stage) {
        return internals.spawnLightningDragon(loc, stage);
    }

    @Nonnull
    public static LightningDragon spawnLightningDragon(@Nonnull Location loc, @Nonnull DragonVariant variant) {
        return internals.spawnLightningDragon(loc, variant);
    }

    @Nonnull
    public static LightningDragon spawnLightningDragon(@Nonnull Location loc, @Nonnull DragonVariant variant, int stage) {
        return internals.spawnLightningDragon(loc, variant, stage);
    }

    @Nonnull
    public static SeaSerpent spawnSeaSerpent(@Nonnull Location loc) {
        return internals.spawnSeaSerpent(loc);
    }

    @Nonnull
    public static SeaSerpent spawnSeaSerpent(@Nonnull Location loc, @Nonnull SeaSerpentVariant variant) {
        return internals.spawnSeaSerpent(loc, variant);
    }

    @Nonnull
    public static Siren spawnSiren(@Nonnull Location loc) {
        return internals.spawnSiren(loc);
    }

    public static boolean hasItemModel(@Nonnull ItemMeta meta) {
        return internals.hasItemModel(meta);
    }

    public static NamespacedKey getItemModel(@Nonnull ItemMeta meta) {
        return internals.getItemModel(meta);
    }

    public static void setItemModel(@Nonnull ItemMeta meta, @Nullable NamespacedKey key) {
        internals.setItemModel(meta, key);
    }

    public static boolean hasEquippableComponentModel(@Nonnull ItemMeta meta) {
        return internals.hasEquippableComponentModel(meta);
    }

    public static NamespacedKey getEquippableComponentModel(@Nonnull ItemMeta meta) {
        return internals.getEquippableComponentModel(meta);
    }

    public static void setEquippableComponentModel(@Nonnull ItemMeta meta, @Nullable NamespacedKey key, @Nonnull EquipmentSlot slot) {
        internals.setEquippableComponentModel(meta, key, slot);
    }

    public static boolean isBestTool(@Nonnull Block block, @Nullable ItemStack tool) {
        Tool bestTool = getBestTool(block.getType());

        if (isItemReal(tool)) {
            return tool.getType().toString().contains(bestTool.toString()) || bestTool == Tool.NONE;
        }
        return bestTool == Tool.NONE;
    }

    public static boolean hasSilkTouch(@Nonnull ItemStack item) {
        if (isItemReal(item)) {
            return !item.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH);
        }
        return true;
    }

    @Nonnull
    public static Tool getBestTool(@Nonnull Material mat) {
        return RSVPlugin.getUtil().getInternalBestTool(mat);
    }

    public static void registerEntities() {
        internals.registerEntities();
    }

    // Armorstand methods for setting euler angles
    @Nonnull
    public static EulerAngle setRightArmAngle(@Nonnull ArmorStand armorStand, int x, int y, int z) {
        double armorStandX = armorStand.getRightArmPose().getX();
        double armorStandY = armorStand.getRightArmPose().getY();
        double armorStandZ = armorStand.getRightArmPose().getZ();

        return new EulerAngle(armorStandX + Math.toRadians(x), armorStandY + Math.toRadians(y), armorStandZ + Math.toRadians(z));
    }

    public static void playSound(@Nonnull Location loc, @Nonnull String soundName, float volume, float pitch) {
        if (soundName.contains("_")) {
            if (StringUtils.isAllUpperCase(soundName.substring(0, soundName.indexOf("_")))) {
                loc.getWorld().playSound(loc, Sound.valueOf(soundName), volume, pitch);
            }
            else {
                loc.getWorld().playSound(loc, soundName, volume, pitch);
            }
        }
        else {
            if (soundName.equals(soundName.toUpperCase())) {
                loc.getWorld().playSound(loc, Sound.valueOf(soundName), volume, pitch);
            }
            else {
                loc.getWorld().playSound(loc, soundName, volume, pitch);
            }
        }
    }

    @Nonnull
    public static ItemStack updateLore(@Nonnull ItemStack item, int newDurability) {
        if (hasCustomDurability(item)) {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.getLore();

            if (!(lore == null || lore.isEmpty())) {
                int maxDurability = getMaxCustomDurability(item);

                boolean changedDurability = false;
                boolean isJuice = hasNbtTag(item, "rsvdrink");
                boolean changedJuice = false;

                for (int i = 0; i < lore.size(); i++) {
                    if (lore.get(i).contains("Durability:")) {
                        lore.set(i, ChatColor.GRAY + "Durability: " + newDurability + "/" + maxDurability);
                        changedDurability = true;
                    }
                    if (isJuice) {
                        if (lore.get(i).contains("Drink: ")) {
                            lore.set(i, ChatColor.GRAY + "Drink: " + getNbtTag(item, "rsvdrink", PersistentDataType.STRING));
                            changedJuice = true;
                        }
                    }

                    if (isJuice) {
                        if (changedJuice && changedDurability) {
                            break;
                        }
                    }
                    else {
                        if (changedDurability) {
                            break;
                        }
                    }

                }

                meta.setLore(lore);
                item.setItemMeta(meta);
            }
        }
        return item;
    }

    /*
    @return Integer
     */
    @Nonnegative
    public static int addItemToInventory(@Nonnull Inventory inv, @Nonnull ItemStack item, @Nonnegative int amount) {
        item = item.clone();
        int maxStackSize = item.getMaxStackSize();
        int leftover = 0;

        while (amount >= maxStackSize) {
            if (inv.firstEmpty() == -1) {
                leftover += amount;
                return leftover;
            }
            else {
                item.setAmount(maxStackSize);
                int excess = inv.addItem(item).keySet().stream().mapToInt(Integer::intValue).sum();
                amount += excess;
            }

            amount -= maxStackSize;
        }

        int remainder = amount % maxStackSize;

        if (remainder > 0) {
            if (inv.firstEmpty() == -1) {
                leftover += remainder;
            }
            else {
                item.setAmount(remainder);
                inv.addItem(item);
            }
        }

        return leftover;
    }

    /*
    @return
     */
    public static void addItemToInventory(@Nonnull Inventory inv, @Nonnull ItemStack item, @Nonnegative int amount, @Nonnull Location loc) {
        item = item.clone();
        int leftover = addItemToInventory(inv, item, amount);

        int maxStackSize = item.getMaxStackSize();
        int remainder = leftover % maxStackSize;

        while (leftover > maxStackSize) {
            item.setAmount(maxStackSize);
            loc.getWorld().dropItemNaturally(loc, item);

            leftover -= maxStackSize;
        }

        if (remainder > 0) {
            item.setAmount(remainder);
            loc.getWorld().dropItemNaturally(loc, item);
        }
    }

    @Nonnull
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

    public static boolean wasBackstabbed(@Nonnull Entity attacker, @Nonnull Entity defender) {
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
    @Nullable
    public static BlockFace getBlockFace(@Nonnull LivingEntity entity) {
        List<Block> lastTwoTargetBlocks = entity.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !lastTwoTargetBlocks.get(1).getType().isOccluding()) return null;
        Block targetBlock = lastTwoTargetBlocks.get(1);
        Block adjacentBlock = lastTwoTargetBlocks.get(0);
        return targetBlock.getFace(adjacentBlock);
    }

    public <T> void addInternalNbtTag(@Nonnull Entity entity, @Nonnull String key, @Nonnull T value, @Nonnull PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        entity.getPersistentDataContainer().set(nkey, type, value);
    }

    public <T> void addInternalNbtTag(@Nonnull ItemStack item, @Nonnull String key, @Nonnull T value, @Nonnull PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.getPersistentDataContainer().set(nkey, type, value);

        item.setItemMeta(itemMeta);
    }

    @Nullable
    public <T> T getInternalNbtTag(@Nonnull Entity entity, @Nonnull String key, @Nonnull PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = entity.getPersistentDataContainer();

        if(container.getKeys().contains(nkey)) {
            return container.get(nkey, type);
        }

        return null;
    }

    @Nullable
    public <T> T getInternalNbtTag(@Nonnull ItemStack item, @Nonnull String key, @Nonnull PersistentDataType<T,T> type) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();

        if(container.getKeys().contains(nkey)) {
            return container.get(nkey, type);
        }

        return null;
    }

    public boolean hasInternalNbtTag(@Nonnull Entity entity, @Nonnull String key) {
        NamespacedKey nkey = new NamespacedKey(plugin, key);

        return entity.getPersistentDataContainer().getKeys().contains(nkey);
    }

    public boolean hasInternalNbtTag(@Nonnull ItemStack item, @Nonnull String key) {

        NamespacedKey nkey = new NamespacedKey(plugin, key);
        ItemMeta itemMeta = item.getItemMeta();

        return itemMeta.getPersistentDataContainer().getKeys().contains(nkey);
    }

    public void setInternalKbMultiplier(@Nonnull Entity entity, double multiplier) {
        new KbTask(plugin, entity, multiplier).start();
    }

    public void setInternalZeroKb(@Nonnull Entity entity) {
        setKbMultiplier(entity, 0D);
    }

    public void updateInternalItem(@Nonnull ItemStack item) {
        FileConfiguration config = plugin.getCommandsConfig();

        if (RSVItem.isRSVItem(item)) {
            ItemStack rsvItem = RSVItem.getItem(RSVItem.getNameFromItem(item));
            ItemMeta rsvMeta = rsvItem.getItemMeta();

            if (config.getBoolean("UpdateItem.Material"))
                item.setType(rsvItem.getType());

            if (config.getBoolean("UpdateItem.MaterialData"))
                item.setData(rsvItem.getData());

            ItemMeta meta = item.getItemMeta();

            if (config.getBoolean("UpdateItem.DisplayName")) {
                if (rsvMeta.hasDisplayName())
                    meta.setDisplayName(rsvMeta.getDisplayName());
            }

            if (config.getBoolean("UpdateItem.Lore")) {
                if (rsvMeta.hasLore())
                    meta.setLore(rsvMeta.getLore());
            }

            if (config.getBoolean("UpdateItem.Unbreakability"))
                meta.setUnbreakable(rsvMeta.isUnbreakable());

            if (config.getBoolean("UpdateItem.AttributeModifiers")) {
                if (rsvMeta.hasAttributeModifiers())
                    meta.setAttributeModifiers(rsvMeta.getAttributeModifiers());
            }

            if (config.getBoolean("UpdateItem.AttributeModifiers")) {
                if (rsvMeta.hasLocalizedName())
                    meta.setLocalizedName(rsvMeta.getLocalizedName());
            }

            if (config.getBoolean("UpdateItem.CustomModelData")) {
                if (rsvMeta.hasCustomModelData()) {
                    meta.setCustomModelData(Integer.valueOf(rsvMeta.getCustomModelData()));
                }
            }

            if (config.getBoolean("UpdateItem.ItemModel")) {
                if (internals.hasItemModel(rsvMeta)) {
                    internals.setItemModel(meta, internals.getItemModel(rsvMeta));
                }
            }

            if (config.getBoolean("UpdateItem.EquippableComponent")) {
                if (internals.hasEquippableComponentModel(rsvMeta)) {
                    internals.setEquippableComponentModel(meta, internals.getEquippableComponentModel(rsvMeta), getEquipmentSlotFromMaterial(item.getType()));
                }
            }

            if (config.getBoolean("UpdateItem.Enchants.Enabled")) {
                Map<Enchantment, Integer> map = meta.getEnchants();

                if (!config.getBoolean("UpdateItem.Enchants.PreserveExistingEnchants")) {
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

            if (config.getBoolean("UpdateItem.ItemFlags.Enabled")) {
                Set<ItemFlag> flags = meta.getItemFlags();
                Set<ItemFlag> rsvFlags = rsvMeta.getItemFlags();

                if (!config.getBoolean("UpdateItem.ItemFlags.PreserveExistingItemFlags")) {
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

            if (config.getBoolean("UpdateItem.VanillaDurability")) {
                if (rsvItem.getType().getMaxDurability() > 0) {
                    ((Damageable) meta).setDamage(((Damageable) rsvMeta).getDamage());
                }
            }

            item.setItemMeta(meta);
            updateDamageLore(item, meta.getEnchants().entrySet());

            if (config.getBoolean("UpdateItem.NbtTags.Enabled")) {
                if (config.getBoolean("UpdateItem.NbtTags.Module"))
                    addNbtTag(item, "rsvmodule", RSVItem.getModuleNameFromItem(rsvItem), PersistentDataType.STRING);

                if (config.getBoolean("UpdateItem.NbtTags.CustomDurability"))
                    if (hasCustomDurability(rsvItem)) {
                        addNbtTag(item, "rsvdurability", getCustomDurability(rsvItem), PersistentDataType.INTEGER);
                        addNbtTag(item, "rsvmaxdurability", getMaxCustomDurability(rsvItem), PersistentDataType.INTEGER);
                    }
            }
        }
    }

    @Nonnull
    public ItemStack getInternalNetheriteRSVWeapon(@Nonnull ItemStack item) {
        ItemStack clone = item.clone();
        FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(clone)).getUserConfig().getConfig();
        if (config.getBoolean("UpdateNetheriteItems.Enabled")) {
            if (RSVItem.isRSVItem(clone)) {
                ItemStack rsvItem = RSVItem.getItem(RSVItem.getNameFromItem(clone).replace("diamond", "netherite"));
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
                        meta.setCustomModelData(Integer.valueOf(rsvMeta.getCustomModelData()));
                    }
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateItemModel")) {
                    if (internals.hasItemModel(rsvMeta)) {
                        internals.setItemModel(meta, internals.getItemModel(rsvMeta));
                    }
                }

                if (config.getBoolean("UpdateNetheriteItems.UpdateEquippableComponent")) {
                    if (internals.hasEquippableComponentModel(rsvMeta)) {
                        internals.setEquippableComponentModel(meta, internals.getEquippableComponentModel(rsvMeta), getEquipmentSlotFromMaterial(item.getType()));
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

                updateDamageLore(item, meta.getEnchants().entrySet());

                addNbtTag(clone, "rsvitem", RSVItem.getNameFromItem(rsvItem), PersistentDataType.STRING);

                if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.Enabled")) {
                    if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.UpdateModule"))
                        addNbtTag(clone, "rsvmodule", RSVItem.getModuleNameFromItem(rsvItem), PersistentDataType.STRING);

                    if (config.getBoolean("UpdateNetheriteItems.UpdateNbtTags.UpdateCustomDurability")) {
                        if (hasCustomDurability(rsvItem)) {
                            addNbtTag(clone, "rsvdurability", getCustomDurability(rsvItem), PersistentDataType.INTEGER);
                            addNbtTag(clone, "rsvmaxdurability", getMaxCustomDurability(rsvItem), PersistentDataType.INTEGER);
                        }
                    }
                }
            }
        }
        return clone;
    }

    @Nonnull
    public Tool getInternalBestTool(@Nonnull Material mat) {
        return plugin.getToolHandler().getBestToolType(mat);
    }
}