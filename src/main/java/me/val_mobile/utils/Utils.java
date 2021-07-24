package me.val_mobile.utils;

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.rlcraft.RLCraft;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
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

    private final RLCraft plugin;
    public Utils(RLCraft instance) {
        plugin = instance;
    }

    public static Location modifyLocation(Location loc, double x, double y, double z) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);
        newLoc.setY(newLoc.getY() + y);
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public boolean checkDragonContainers(Entity dragon) {

        PersistentDataContainer container = dragon.getPersistentDataContainer();

        NamespacedKey dragonKey = new NamespacedKey(plugin, "Dragon");
        NamespacedKey stageKey = new NamespacedKey(plugin, "Stage");
        NamespacedKey ageKey = new NamespacedKey(plugin, "Age");

        if (container.has(dragonKey, PersistentDataType.STRING) &&
                container.has(stageKey, PersistentDataType.INTEGER) &&
                container.has(ageKey, PersistentDataType.INTEGER)) {
            return true;
        }
        return false;
    }

    public void addDragonContainers(Entity dragon) {

        PersistentDataContainer container = dragon.getPersistentDataContainer();

        NamespacedKey dragonKey = new NamespacedKey(plugin, "Dragon");
        NamespacedKey stageKey = new NamespacedKey(plugin, "Stage");
        NamespacedKey ageKey = new NamespacedKey(plugin, "Age");

        Random r = new Random();
        String dragonType;
        int stage = (int) Math.round(r.nextDouble() * 4) + 1;
        int age = stage * 100 + (int) Math.round(r.nextDouble() * 99);
        double temp = r.nextDouble();
        if (temp <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.Chance")) {
            dragonType = "Fire";
        }
        else if (temp > CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.Chance") &&
                temp <= (CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.Chance"))) {
            dragonType = "Ice";
        }
        else {
            dragonType = "Lightning";
        }

        container.set(dragonKey, PersistentDataType.STRING, dragonType);
        container.set(stageKey, PersistentDataType.INTEGER, stage);
        container.set(ageKey, PersistentDataType.INTEGER, age);
    }

    public String getDragonType(Entity dragon) {
        PersistentDataContainer container = dragon.getPersistentDataContainer();

        NamespacedKey dragonKey = new NamespacedKey(plugin, "Dragon");

        return container.get(dragonKey, PersistentDataType.STRING);
    }

    public int getDragonStage(Entity dragon) {
        PersistentDataContainer container = dragon.getPersistentDataContainer();

        NamespacedKey stageKey = new NamespacedKey(plugin, "Stage");

        return container.get(stageKey, PersistentDataType.INTEGER);
    }

    public int getDragonAge(Entity dragon) {
        PersistentDataContainer container = dragon.getPersistentDataContainer();

        NamespacedKey ageKey = new NamespacedKey(plugin, "Age");

        return container.get(ageKey, PersistentDataType.INTEGER);
    }

    public static Vector randomizeVelocity(Vector velocity) {
        Vector newVelocity = velocity.clone();
        Random r = new Random();

        newVelocity.setX((newVelocity.getX() * r.nextDouble()) + 0.5);
        newVelocity.setY((newVelocity.getY() * r.nextDouble()) + 0.5);
        newVelocity.setZ((newVelocity.getZ() * r.nextDouble()) + 0.5);

        return newVelocity;
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
        switch (material) {
            case LEATHER_HELMET:
            case CHAINMAIL_HELMET:
            case IRON_HELMET:
            case GOLDEN_HELMET:
            case DIAMOND_HELMET:
            case NETHERITE_HELMET:
            case TURTLE_HELMET:
                return true;
            default:
                return false;
        }
    }

    public static boolean isChestplate(Material material) {
        switch (material) {
            case LEATHER_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case IRON_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
            case NETHERITE_CHESTPLATE:
                return true;
            default:
                return false;
        }
    }

    public static boolean isLeggings(Material material) {
        switch (material) {
            case LEATHER_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case IRON_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case DIAMOND_LEGGINGS:
            case NETHERITE_LEGGINGS:
                return true;
            default:
                return false;
        }
    }

    public static boolean isBoots(Material material) {
        switch (material) {
            case LEATHER_BOOTS:
            case CHAINMAIL_BOOTS:
            case IRON_BOOTS:
            case GOLDEN_BOOTS:
            case DIAMOND_BOOTS:
            case NETHERITE_BOOTS:
                return true;
            default:
                return false;
        }
    }

    public static boolean isArmor(Material material) {
        switch (material) {
            case LEATHER_HELMET:
            case CHAINMAIL_HELMET:
            case IRON_HELMET:
            case GOLDEN_HELMET:
            case DIAMOND_HELMET:
            case NETHERITE_HELMET:
            case TURTLE_HELMET:
            case LEATHER_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case IRON_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
            case NETHERITE_CHESTPLATE:
            case LEATHER_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case IRON_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case DIAMOND_LEGGINGS:
            case NETHERITE_LEGGINGS:
            case LEATHER_BOOTS:
            case CHAINMAIL_BOOTS:
            case IRON_BOOTS:
            case GOLDEN_BOOTS:
            case DIAMOND_BOOTS:
            case NETHERITE_BOOTS:
                return true;
            default:
                return false;
        }
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
            switch (itemMainHand.getType()) {
                case WOODEN_AXE:
                case STONE_AXE:
                case IRON_AXE:
                case GOLDEN_AXE:
                case DIAMOND_AXE:
                case NETHERITE_AXE:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean isHoldingKnife(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();

        if (isItemReal(itemMainHand)) {
            NBTItem nbti = new NBTItem(itemMainHand);
            if (nbti.hasKey("Spartan's Weapon")) {
                if (nbti.getString("Spartan's Weapon").equals("Dagger") ||  nbti.getString("Spartan's Weapon").equals("Throwing Knife")) {
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

    public static boolean isHoldingTwoHandedWeapon(LivingEntity entity) {
        ItemStack item = entity.getEquipment().getItemInMainHand();
        if (isItemReal(item)) {
            NBTItem nbti = new NBTItem(item);
            if (nbti.hasKey("Spartan's Weapon")) {
                switch (nbti.getString("Spartan's Weapon")) {
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

    public static boolean checkTwoHandedDebuff(LivingEntity entity) {
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

    public static void getNextChar(Character character) {
        switch (character) {
            case 'A':
                character = 'B';
            case 'B':
                character = 'C';
            case 'C':
                character = 'D';
            case 'D':
                character = 'E';
            case 'E':
                character = 'F';
            case 'F':
                character = 'G';
            case 'G':
                character = 'H';
            case 'H':
                character = 'I';
            case 'I':
                character = 'J';
            case 'J':
                character = 'K';
            case 'K':
                character = 'L';
            case 'L':
                character = 'M';
            case 'M':
                character = 'N';
            case 'N':
                character = 'O';
            case 'O':
                character = 'P';
            case 'P':
                character = 'Q';
            case 'Q':
                character = 'R';
            case 'R':
                character = 'S';
            case 'S':
                character = 'T';
            case 'T':
                character = 'U';
            case 'U':
                character = 'V';
            case 'V':
                character = 'W';
            case 'W':
                character = 'X';
            case 'X':
                character = 'Y';
            case 'Y':
                character = 'Z';
            case 'Z':
                character = 'A';
            case 'a':
                character = 'b';
            case 'b':
                character = 'c';
            case 'c':
                character = 'd';
            case 'd':
                character = 'e';
            case 'e':
                character = 'f';
            case 'f':
                character = 'g';
            case 'g':
                character = 'h';
            case 'h':
                character = 'i';
            case 'i':
                character = 'j';
            case 'j':
                character = 'k';
            case 'k':
                character = 'l';
            case 'l':
                character = 'm';
            case 'm':
                character = 'n';
            case 'n':
                character = 'o';
            case 'o':
                character = 'p';
            case 'p':
                character = 'q';
            case 'q':
                character = 'r';
            case 'r':
                character = 's';
            case 's':
                character = 't';
            case 't':
                character = 'u';
            case 'u':
                character = 'v';
            case 'v':
                character = 'w';
            case 'w':
                character = 'x';
            case 'x':
                character = 'y';
            case 'y':
                character = 'z';
            case 'z':
                character = 'a';
        }
    }

    public static ItemStack[] getItemsFromString(String raw) {
        ItemStack[] items = new ItemStack[3];

        int firstIndex;
        int lastIndex;

        firstIndex = raw.indexOf("|");
        lastIndex = raw.lastIndexOf("|");

        if (firstIndex != -1) {
            String name = raw.substring(0, firstIndex);
            if (firstIndex == lastIndex) {
                ItemStack item;
                if (Item.getItemMap().containsKey(name)) {
                    item = Item.getItem(Item.getItemMap().get(name));
                }
                else {
                    item = new ItemStack(Material.valueOf(name));
                }
                items[0] = item;

                name = raw.substring(firstIndex + 1);
                if (Item.getItemMap().containsKey(name)) {
                    item = Item.getItem(Item.getItemMap().get(name));
                }
                else {
                    item = new ItemStack(Material.valueOf(name));
                }
                items[1] = item;
            }
            else {
                ItemStack item;
                if (Item.getItemMap().containsKey(name)) {
                    item = Item.getItem(Item.getItemMap().get(name));
                }
                else {
                    item = new ItemStack(Material.valueOf(name));
                }
                items[0] = item;

                name = raw.substring(firstIndex + 1, lastIndex);
                if (Item.getItemMap().containsKey(name)) {
                    item = Item.getItem(Item.getItemMap().get(name));
                }
                else {
                    item = new ItemStack(Material.valueOf(name));
                }
                items[1] = item;

                name = raw.substring(lastIndex + 1);
                if (Item.getItemMap().containsKey(name)) {
                    item = Item.getItem(Item.getItemMap().get(name));
                }
                else {
                    item = new ItemStack(Material.valueOf(name));
                }
                items[2] = item;
            }
        }
        else {
            String name = raw;
            ItemStack item;
            if (Item.getItemMap().containsKey(name)) {
                item = Item.getItem(Item.getItemMap().get(name));
            }
            else {
                item = new ItemStack(Material.valueOf(name));
            }
            items[0] = item;
        }

        return items;
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
}
