package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Utils {

    public static final double ATTACK_DAMAGE_CONSTANT = -1.0;
    public static final double ATTACK_SPEED_CONSTANT = -4.0;

    private final RLCraft plugin;
    private final BaubleRunnables baubleRunnables = new BaubleRunnables();
    public Utils(RLCraft instance) {
        plugin = instance;
    }

    public static void resizeItem(ItemStack item, int amount) {

        item.setAmount(amount);

    }

    public static void addDragonSkullLore(ItemStack item, int stage, String dragon) {

        ItemMeta meta = item.getItemMeta();
        if (!(meta.getLore() == null || meta.getLore().isEmpty())) {
            List<String> lore = meta.getLore();

            lore.add(ChatColor.translateAlternateColorCodes('&',""));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7" + dragon));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Stage " + stage));

            meta.setLore(lore);
            item.setItemMeta(meta);

        }
        else {
            List<String> lore = new ArrayList<>();

            lore.add(ChatColor.translateAlternateColorCodes('&',""));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7" + dragon));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Stage " + stage));

            meta.setLore(lore);
            item.setItemMeta(meta);
        }
    }

    public static void resetDurability(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        ((Damageable)meta).setDamage(0);

        item.setItemMeta(meta);

    }

    public static Location modifyLocationX(Location loc, double x) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);

        return newLoc;
    }

    public static Location modifyLocationY(Location loc, double y) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getY() + y);

        return newLoc;
    }

    public static Location modifyLocationZ(Location loc, double z) {

        Location newLoc = loc.clone();
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public static Location modifyLocation(Location loc, double x, double y, double z) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);
        newLoc.setY(newLoc.getY() + y);
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public static double getDiamondHelmetArmor() {

        return 3.0;
    }

    public static double getDiamondHelmetToughness() {

        return 2.0;
    }

    public static double getDiamondChestplateArmor() {

        return 8.0;
    }

    public static double getDiamondChestplateToughness() {

        return 2.0;
    }

    public static double getDiamondLeggingsArmor() {

        return 6.0;
    }

    public static double getDiamondLeggingsToughness() {

        return 2.0;
    }

    public static double getDiamondBootsArmor() {

        return 3.0;
    }

    public static double getDiamondBootsToughness() {

        return 2.0;
    }

    public static void addRapierLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Damage Absorption"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &725.0% of damage taken dealt"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7in durability from this weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Unarmoured Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+200% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Armor"));

    }

    public static void addSaberLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Damage Absorption"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &725.0% of damage taken dealt"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7in durability from this weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Chest Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Chest Armor"));

    }

    public static void addBattleaxeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Versatile"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Can be used as an axe"));

    }

    public static void addBoomerangLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));

    }

    public static void addCrossbowLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&7High damage & Long-ranged. Requires loading before firing. Uses Bolts."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Quick shots after firing will affect accuracy."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Hold the aim for a pinpoint shot."));

    }

    public static void addDaggerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));

    }

    public static void addGlaiveLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 50.0% of standard damage"));

    }

    public static void addGreatswordLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 100.0% of standard damage"));

    }

    public static void addHalberdLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Shield Breach"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Chance to breach a foe's shield"));
    }


    public static void addHammerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Enhanced Knockback"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Foes get knocked back further away"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Nauseous Blow"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Inflicts Nausea II (5.0s) on hit,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7unless the foe is wearing a Helmet"));

    }

    public static void addJavelinLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+200% damage when the weapon is thrown"));

    }

    public static void addKatanaLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Chest Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Chest Armor"));

    }

    public static void addLanceLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Riding Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7while riding a mount or vehicle"));

    }

    public static void addLongbowLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Long-range version of the standard bow"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Takes longer to draw fully"));

    }

    public static void addLongswordLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));

    }

    public static void addMaceLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Undead Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+50% base weapon damage against Undead foes"));

    }

    public static void addPikeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));

    }

    public static void addSpearLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));

    }

    public static void addQuarterstaffLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 50.0% of standard damage"));

    }

    public static void addThrowingAxeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% damage when the weapon is thrown"));

    }

    public static void addThrowingKnifeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% damage when the weapon is thrown"));

    }

    public static void addWarhammerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Armor Piercing"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &750.0% of damage inflicted ignores armor"));

    }

    public static void addFlamedDragonBoneLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Ignites and knocks back targets, deals extra damage to ice dragons"));
    }

    public static void addIcedDragonBoneLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Slows and knocks back targets, deals extra damage to fire dragons"));
    }

    public static void addLightningDragonBoneLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strikes targets with lightning, deals extra damage to fire and ice dragons"));
    }

    public static void addFireDragonsteelLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Ignites and knocks back targets"));
    }

    public static void addIceDragonsteelLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Slows and knocks back targets"));
    }

    public static void addLightningDragonsteelLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strikes targets with lightning"));
    }

    public static void addBlueDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bBlue"));
    }

    public static void addBronzeDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bronze"));
    }

    public static void addGrayDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Gray"));
    }

    public static void addGreenDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2Emerald"));
    }

    public static void addRedDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&4Red"));
    }

    public static void addSapphireDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Sapphire"));
    }

    public static void addSilverDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&8Silver"));
    }

    public static void addWhiteDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&fWhite"));
    }

    public static void addAmethystDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dAmethyst"));
    }

    public static void addBlackDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&8Black"));
    }

    public static void addCopperDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Copper"));
    }

    public static void addElectricDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&1Electric Blue"));
    }

    public static void addBlueSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Blue"));
    }

    public static void addBronzeSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bronze"));
    }

    public static void addDeepBlueSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&1Deep Blue"));
    }

    public static void addGreenSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2Green"));
    }

    public static void addPurpleSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&5Purple"));
    }

    public static void addRedSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&4Red"));
    }

    public static void addTealSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bTeal"));
    }

    public static void addDragonProtectionLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
    }

    public static void addTideGuardianBreathingLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
    }

    public static void addLegendaryWeaponLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
    }

    public static void addFlamedExtraDamageLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Ice Dragons"));
    }

    public static void addFireDragonAbilityLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
    }

    public static void addIceDragonAbilityLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
    }

    public static void addLightningDragonAbilityLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
    }

    public static void addIcedExtraDamageLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Fire Dragons"));
    }

    public static void addLightningExtraDamageLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+4 damage against Fire Dragons and Ice Dragons"));
    }

    public static void subtractDurability(ItemStack item) {

        if (((Damageable)item).getDamage() >= item.getType().getMaxDurability() - 1) {
            item.setAmount(0);
        }
        else {
            ((Damageable) item).setDamage(((Damageable) item).getDamage() + 1);
        }

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

    public static boolean decideStartRunnable(HashMap<String, Integer> values, HashMap<String, Boolean> runnables, Player player) {
        String name = player.getName();
        if (values.get(name) > 0) {
            if (!runnables.get(name)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void startPrResRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingResistance.TickTime");
        BaubleRunnables.getPotionRingResistanceRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrResRunnables(), name, true);
    }

    public void startPrRegenRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.TickTime");
        BaubleRunnables.getPotionRingRegenerationRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRegenRunnables(), name, true);
    }

    public void startPrStrengthRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingStrength.TickTime");
        BaubleRunnables.getPotionRingStrengthRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrStrengthRunnables(), name, true);

    }

    public void startPrSpeedRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.TickTime");
        BaubleRunnables.getPotionRingSpeedRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrSpeedRunnables(), name, true);
    }

    public void startPrJumpRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.TickTime");
        BaubleRunnables.getPotionRingJumpBoostRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrJumpRunnables(), name, true);
    }

    public void startPrHasteRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingHaste.TickTime");
        BaubleRunnables.getPotionRingHasteRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrHasteRunnables(), name, true);
    }

    public void startDragonsEyeRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("DragonsEye.TickTime");
        BaubleRunnables.getDragonsEyeRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getDragonsEyeRunnables(), name, true);

    }

    public void startScarliteRingRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("ScarliteRing.TickTime");
        BaubleRunnables.getScarliteRingRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getScarliteRingRunnables(), name, true);
    }

    public void startMinersRingRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("MinersRing.TickTime");
        BaubleRunnables.getMinersRingRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getMinersRingRunnables(), name, true);
    }

    public void startShieldHonorRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("ShieldHonor.TickTime");
        BaubleRunnables.getShieldHonorRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getShieldHonorRunnables(), name, true);
    }

    public static void updatePrResValues(Player player) {
        String name = player.getName();
        int prResAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Potion Ring of Resistance")) {
                        prResAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrRes(), name, prResAmount);
    }

    public static void updatePrRegenValues(Player player) {
        String name = player.getName();
        int prRegenAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Potion Ring of Regeneration")) {
                        prRegenAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrRegen(), name, prRegenAmount);
    }

    public static void updatePrStrengthValues(Player player) {
        String name = player.getName();
        int prStrengthAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Potion Ring of Strength")) {
                        prStrengthAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrStrength(), name, prStrengthAmount);
    }

    public static void updatePrSpeedValues(Player player) {
        String name = player.getName();
        int prSpeedAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Potion Ring of Speed")) {
                        prSpeedAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrSpeed(), name, prSpeedAmount);
    }

    public static void updatePrJumpValues(Player player) {
        String name = player.getName();
        int prJumpAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Potion Ring of Jump Boost")) {
                        prJumpAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrJump(), name, prJumpAmount);
    }

    public static void updatePrHasteValues(Player player) {
        String name = player.getName();
        int prHasteAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Potion Ring of Haste")) {
                        prHasteAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrHaste(), name, prHasteAmount);
    }

    public static void updateDragonsEyeValues(Player player) {
        String name = player.getName();
        int dragonsEyeAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Dragon's Eye")) {
                        dragonsEyeAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getDragonsEye(), name, dragonsEyeAmount);
    }

    public static void updateMinersRingValues(Player player) {
        String name = player.getName();
        int minersRingAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Miner's Ring")) {
                        minersRingAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getMinersRing(), name, minersRingAmount);
    }

    public static void updateScarliteRingValues(Player player) {
        String name = player.getName();
        int scarliteRingAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Scarlite Ring")) {
                        scarliteRingAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getScarliteRing(), name, scarliteRingAmount);
    }

    public static void updateShieldHonorValues(Player player) {
        String name = player.getName();
        int shieldHonorAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    if (nbti.getString("Bauble").equals("Shield of Honor")) {
                        shieldHonorAmount += amount;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getShieldHonor(), name, shieldHonorAmount);
    }

    public static void updateBaubleValues(Player player) {
        String name = player.getName();
        
        int prResAmount = 0;
        int prRegenAmount = 0;
        int prStrengthAmount = 0;
        int prSpeedAmount = 0;
        int prJumpAmount = 0;
        int prHasteAmount = 0;
        int dragonsEyeAmount = 0;
        int scarliteRingAmount = 0;
        int minersRingAmount = 0;
        int shieldHonorAmount = 0;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Bauble")) {
                    switch (nbti.getString("Bauble")) {
                        case "Potion Ring of Resistance":
                            prResAmount += amount;
                            break;
                        case "Potion Ring of Regeneration":
                            prRegenAmount += amount;
                            break;
                        case "Potion Ring of Strength":
                            prStrengthAmount += amount;
                            break;
                        case "Potion Ring of Speed":
                            prSpeedAmount += amount;
                            break;
                        case "Potion Ring of Jump Boost":
                            prJumpAmount += amount;
                            break;
                        case "Dragon's Eye":
                            dragonsEyeAmount += amount;
                            break;
                        case "Scarlite Ring":
                            scarliteRingAmount += amount;
                            break;
                        case "Miner's Ring":
                            minersRingAmount += amount;
                            break;
                        case "Shield of Honor":
                            shieldHonorAmount += amount;
                            break;
                    }
                }
            }
        }
        setOrReplaceEntry(PlayerRunnable.getPrRes(), name, prResAmount);
        setOrReplaceEntry(PlayerRunnable.getPrRegen(), name, prRegenAmount);
        setOrReplaceEntry(PlayerRunnable.getPrStrength(), name, prStrengthAmount);
        setOrReplaceEntry(PlayerRunnable.getPrSpeed(), name, prSpeedAmount);
        setOrReplaceEntry(PlayerRunnable.getPrJump(), name, prJumpAmount);
        setOrReplaceEntry(PlayerRunnable.getPrHaste(), name, prHasteAmount);
        setOrReplaceEntry(PlayerRunnable.getDragonsEye(), name, dragonsEyeAmount);
        setOrReplaceEntry(PlayerRunnable.getScarliteRing(), name, scarliteRingAmount);
        setOrReplaceEntry(PlayerRunnable.getMinersRing(), name, minersRingAmount);
        setOrReplaceEntry(PlayerRunnable.getShieldHonor(), name, shieldHonorAmount);

    }

    public static void resetBaubleMaps(Player player) {

        setOrReplaceEntry(PlayerRunnable.getPrRes(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getPrStrength(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getPrRegen(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getPrHaste(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getPrJump(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getPrSpeed(), player.getName(), 0);

        setOrReplaceEntry(PlayerRunnable.getDragonsEye(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getScarliteRing(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getShieldHonor(), player.getName(), 0);
        setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), player.getName(), false);

        setOrReplaceEntry(PlayerRunnable.getPrResRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getPrStrengthRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getPrRegenRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getPrHasteRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getPrJumpRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getPrSpeedRunnables(), player.getName(), false);

        setOrReplaceEntry(PlayerRunnable.getDragonsEyeRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getScarliteRingRunnables(), player.getName(), false);
        setOrReplaceEntry(PlayerRunnable.getShieldHonorRunnables(), player.getName(), false);

    }

    public void resetArmorMaps(Player player) {

        setOrReplaceEntry(PlayerRunnable.getTideArmor(), player.getName(), 0);

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

    public static long convertSecondsIntoTicks(double seconds) {
        return Math.round(seconds * 20);
    }

    public static void addWeaponLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
    }

    public static void addHelmetLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
    }

    public static void addChestplateLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
    }

    public static void addLeggingsLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
    }

    public static void addBootsLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
    }

    public static void addDefenseStatsLore(List<String> lore, Double armor, Double toughness) {
        if (Math.floor(armor) == armor) {
            lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + armor.intValue() + " Armor"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + armor + " Armor"));
        }

        if (Math.floor(toughness) == toughness) {
            lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + toughness.intValue() + " Armor Toughness"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + toughness + " Armor Toughness"));
        }
    }

    public static void addThrowableLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When thrown:"));
    }

    public static void addThrowableStatsLore(List<String> lore, Double damage) {
        if (Math.floor(damage) == damage) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage.intValue() + " Attack Damage"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage + " Attack Damage"));
        }
    }

    public static String getLowercaseAtrName(String name) {
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

    public static double getCorrectAtrAmount(Attribute attribute, double requestedValue) {
        switch (attribute) {
            case GENERIC_ATTACK_DAMAGE:
                return requestedValue + Utils.ATTACK_DAMAGE_CONSTANT;
            case GENERIC_ATTACK_SPEED:
                return requestedValue + Utils.ATTACK_SPEED_CONSTANT;
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

    public static String translateInformalAtrName(String name) {
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

    public static boolean isWooden(Material material) {
        switch (material) {
            case OAK_LOG:
            case OAK_WOOD:
            case STRIPPED_OAK_LOG:
            case STRIPPED_OAK_WOOD:
            case BIRCH_LOG:
            case BIRCH_WOOD:
            case STRIPPED_BIRCH_LOG:
            case STRIPPED_BIRCH_WOOD:
            case SPRUCE_LOG:
            case SPRUCE_WOOD:
            case STRIPPED_SPRUCE_LOG:
            case STRIPPED_SPRUCE_WOOD:
            case DARK_OAK_LOG:
            case DARK_OAK_WOOD:
            case STRIPPED_DARK_OAK_LOG:
            case STRIPPED_DARK_OAK_WOOD:
            case ACACIA_LOG:
            case ACACIA_WOOD:
            case STRIPPED_ACACIA_LOG:
            case STRIPPED_ACACIA_WOOD:
            case JUNGLE_LOG:
            case JUNGLE_WOOD:
            case STRIPPED_JUNGLE_LOG:
            case STRIPPED_JUNGLE_WOOD:
            case CRIMSON_STEM:
            case CRIMSON_HYPHAE:
            case STRIPPED_CRIMSON_STEM:
            case STRIPPED_CRIMSON_HYPHAE:
            case WARPED_STEM:
            case WARPED_HYPHAE:
            case STRIPPED_WARPED_STEM:
            case STRIPPED_WARPED_HYPHAE:
                return true;
            default:
                return false;
        }
    }

    public static boolean isHoldingAxe(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (! (itemMainHand == null || itemMainHand.getType().equals(Material.AIR)) ) {
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

    public static boolean isGrass(Material material) {
        switch (material) {
            case TALL_GRASS:
            case GRASS:
                return true;
            default:
                return false;
        }
    }

    public static boolean isHoldingKnife(Player player) {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();

        if (! (itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
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
            if (! (item == null || item.getType() == Material.AIR) ) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasChestplate(LivingEntity entity) {
        ItemStack chestplate = entity.getEquipment().getChestplate();
        if (! (chestplate == null || chestplate.getType() == Material.AIR)) {
            return true;
        }
        return false;
    }

    public static boolean isHoldingTwoHandedWeapon(LivingEntity entity) {
        ItemStack item = entity.getEquipment().getItemInMainHand();
        if (! (item == null || item.getType() == Material.AIR)) {
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
            if (! (item == null || item.getType() == Material.AIR)) {
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

    public static boolean isSword(Material material) {
        switch (material) {
            case WOODEN_SWORD:
            case STONE_SWORD:
            case IRON_SWORD:
            case GOLDEN_SWORD:
            case DIAMOND_SWORD:
            case NETHERITE_SWORD:
                return true;
            default:
                return false;
        }
    }

    public static void addGearLore(List<String> lore, Material material) {
        lore.add("");
        if (isArmor(material)) {
            if (isHelmet(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
            }
            else if (isChestplate(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
            }
            else if (isLeggings(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
            }
            else if (isBoots(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
            }
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        }
    }

    public static void addGearStats(List<String> lore, Attribute atr, Double value) {
        switch (atr) {
            case GENERIC_ATTACK_DAMAGE:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value.intValue() + " Attack Damage"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value + " Attack Damage"));
                }
                break;
            case GENERIC_ATTACK_SPEED:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value.intValue() + " Attack Speed"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value + " Attack Speed"));
                }
                break;
            case GENERIC_ARMOR:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value.intValue() + " Armor"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value + " Armor"));
                }
                break;
            case GENERIC_ARMOR_TOUGHNESS:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value.intValue() + " Armor Toughness"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value + " Armor Toughness"));
                }
                break;
        }
    }

    public static void addMeleeStatsLore(List<String> lore, Double damage, Double speed) {
        if (Math.floor(damage) == damage) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage.intValue() + " Attack Damage"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage + " Attack Damage"));
        }

        if (Math.floor(speed) == speed) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + speed.intValue() + " Attack Speed"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + speed + " Attack Speed"));
        }
    }

    public static void useLorePreset(List<String> lore, String weaponType) {
        switch (weaponType) {
            case "RAPIER":
                addRapierLore(lore);
                break;
            case "SABER":
                addSaberLore(lore);
                break;
            case "KATANA":
                addKatanaLore(lore);
                break;
            case "GREATSWORD":
                addGreatswordLore(lore);
                break;
            case "LONGSWORD":
                addLongswordLore(lore);
                break;
            case "SPEAR":
                addSpearLore(lore);
                break;
            case "GLAIVE":
                addGlaiveLore(lore);
                break;
            case "BOOMERANG":
                addBoomerangLore(lore);
                break;
            case "DAGGER":
                addDaggerLore(lore);
                break;
            case "HALBERD":
                addHalberdLore(lore);
                break;
            case "HAMMER":
                addHammerLore(lore);
                break;
            case "JAVELIN":
                addJavelinLore(lore);
                break;
            case "LANCE":
                addLanceLore(lore);
                break;
            case "MACE":
                addMaceLore(lore);
                break;
            case "PIKE":
                addPikeLore(lore);
                break;
            case "QUARTERSTAFF":
                addQuarterstaffLore(lore);
                break;
            case "THROWING_AXE":
                addThrowingAxeLore(lore);
                break;
            case "THROWING_KNIFE":
                addThrowingKnifeLore(lore);
                break;
            case "WARHAMMER":
                addWarhammerLore(lore);
                break;
            case "BATTLEAXE":
                addBattleaxeLore(lore);
                break;
            case "LONGBOW":
                addLongbowLore(lore);
                break;
            case "CROSSBOW":
                addCrossbowLore(lore);
                break;
            case "FLAMED_DRAGON_BONE":
                addFlamedDragonBoneLore(lore);
                break;
            case "ICED_DRAGON_BONE":
                addIcedDragonBoneLore(lore);
                break;
            case "LIGHTNING_DRAGON_BONE":
                addLightningDragonBoneLore(lore);
                break;
            case "FIRE_DRAGONSTEEL":
                addFireDragonsteelLore(lore);
                break;
            case "ICE_DRAGONSTEEL":
                addIceDragonsteelLore(lore);
                break;
            case "LIGHTNING_DRAGONSTEEL":
                addLightningDragonsteelLore(lore);
                break;
            case "BLUE_DRAGON_SCALE":
                addBlueDragonScaleLore(lore);
                break;
            case "BRONZE_DRAGON_SCALE":
                addBronzeDragonScaleLore(lore);
                break;
            case "GRAY_DRAGON_SCALE":
                addGrayDragonScaleLore(lore);
                break;
            case "GREEN_DRAGON_SCALE":
                addGreenDragonScaleLore(lore);
                break;
            case "RED_DRAGON_SCALE":
                addRedDragonScaleLore(lore);
                break;
            case "SAPPHIRE_DRAGON_SCALE":
                addSapphireDragonScaleLore(lore);
                break;
            case "SILVER_DRAGON_SCALE":
                addSilverDragonScaleLore(lore);
                break;
            case "WHITE_DRAGON_SCALE":
                addWhiteDragonScaleLore(lore);
                break;
            case "AMETHYST_DRAGON_SCALE":
                addAmethystDragonScaleLore(lore);
                break;
            case "BLACK_DRAGON_SCALE":
                addBlackDragonScaleLore(lore);
                break;
            case "COPPER_DRAGON_SCALE":
                addCopperDragonScaleLore(lore);
                break;
            case "ELECTRIC_DRAGON_SCALE":
                addElectricDragonScaleLore(lore);
                break;
            case "BLUE_SEA_SERPENT_SCALE":
                addBlueSeaSerpentScaleLore(lore);
                break;
            case "BRONZE_SEA_SERPENT_SCALE":
                addBronzeSeaSerpentScaleLore(lore);
                break;
            case "DEEPBLUE_SEA_SERPENT_SCALE":
                addDeepBlueSeaSerpentScaleLore(lore);
                break;
            case "GREEN_SEA_SERPENT_SCALE":
                addGreenSeaSerpentScaleLore(lore);
                break;
            case "PURPLE_SEA_SERPENT_SCALE":
                addPurpleSeaSerpentScaleLore(lore);
                break;
            case "RED_SEA_SERPENT_SCALE":
                addRedSeaSerpentScaleLore(lore);
                break;
            case "TEAL_SEA_SERPENT_SCALE":
                addTealSeaSerpentScaleLore(lore);
                break;
            case "DRAGON_PROTECTION":
                addDragonProtectionLore(lore);
                break;
            case "TIDE_GUARDIAN_BREATHING":
                addTideGuardianBreathingLore(lore);
                break;
            case "LEGENDARY_WEAPON":
                addLegendaryWeaponLore(lore);
                break;
            case "FLAMED_EXTRA_DAMAGE":
                addFlamedExtraDamageLore(lore);
                break;
            case "ICED_EXTRA_DAMAGE":
                addIcedExtraDamageLore(lore);
                break;
            case "LIGHTNING_EXTRA_DAMAGE":
                addLightningExtraDamageLore(lore);
                break;
            case "FIRE_DRAGON_ABILITY":
                addFireDragonAbilityLore(lore);
                break;
            case "ICE_DRAGON_ABILITY":
                addIceDragonAbilityLore(lore);
                break;
            case "LIGHTNING_DRAGON_ABILITY":
                addLightningDragonAbilityLore(lore);
                break;
        }
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

}
