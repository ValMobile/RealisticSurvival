package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.*;

public class Utils {

    private final RLCraft plugin;
    public Utils(RLCraft instance) {
        plugin = instance;
    }

    public ItemStack resizeItem(ItemStack item, int amount) {

        item.setAmount(amount);

        return item;
    }

    public ItemStack addDragonSkullLore(ItemStack item, int stage, String dragon) {

        ItemMeta meta = item.getItemMeta();
        if (!(meta.getLore() == null || meta.getLore().isEmpty())) {
            List<String> lore = meta.getLore();

            lore.add(ChatColor.translateAlternateColorCodes('&',""));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7" + dragon));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Stage " + stage));

            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7" + dragon));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Stage " + stage));

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack resetDurability(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        ((Damageable)meta).setDamage(0);

        item.setItemMeta(meta);

        return item;
    }

    public Location modifyLocationX(Location loc, double x) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);

        return newLoc;
    }

    public Location modifyLocationY(Location loc, double y) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getY() + y);

        return newLoc;
    }

    public Location modifyLocationZ(Location loc, double z) {

        Location newLoc = loc.clone();
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public Location modifyLocation(Location loc, double x, double y, double z) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);
        newLoc.setY(newLoc.getY() + y);
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public double getDiamondHelmetArmor() {

        return 3.0;
    }

    public double getDiamondHelmetToughness() {

        return 2.0;
    }

    public double getDiamondChestplateArmor() {

        return 8.0;
    }

    public double getDiamondChestplateToughness() {

        return 2.0;
    }

    public double getDiamondLeggingsArmor() {

        return 6.0;
    }

    public double getDiamondLeggingsToughness() {

        return 2.0;
    }

    public double getDiamondBootsArmor() {

        return 3.0;
    }

    public double getDiamondBootsToughness() {

        return 2.0;
    }

    public void addRapierLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Damage Absorption"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &725.0% of damage taken dealt"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7in durability from this weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Unarmoured Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+200% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Armor"));

    }

    public void addSaberLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Damage Absorption"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &725.0% of damage taken dealt"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7in durability from this weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Chest Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Chest Armor"));

    }

    public void addBattleaxeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Versatile"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Can be used as an axe"));

    }

    public void addBoomerangLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));

    }

    public void addCrossbowLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&7High damage & Long-ranged. Requires loading before firing. Uses Bolts."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Quick shots after firing will affect accuracy."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Hold the aim for a pinpoint shot."));

    }

    public void addDaggerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));

    }

    public void addGlaiveLore(List<String> lore) {

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

    public void addGreatswordLore(List<String> lore) {

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

    public void addHalberdLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Shield Breach"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Chance to breach a foe's shield"));
    }


    public void addHammerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Enhanced Knockback"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Foes get knocked back further away"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Nauseous Blow"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Inflicts Nausea II (5.0s) on hit,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7unless the foe is wearing a Helmet"));

    }

    public void addJavelinLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+200% damage when the weapon is thrown"));

    }

    public void addKatanaLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Chest Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Chest Armor"));

    }

    public void addLanceLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Riding Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7while riding a mount or vehicle"));

    }

    public void addLongbowLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Long-range version of the standard bow"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Takes longer to draw fully"));

    }

    public void addLongswordLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));

    }

    public void addMaceLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Undead Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+50% base weapon damage against Undead foes"));

    }

    public void addPikeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));

    }

    public void addSpearLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));

    }

    public void addQuarterstaffLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 50.0% of standard damage"));

    }

    public void addThrowingAxeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% damage when the weapon is thrown"));

    }

    public void addThrowingKnifeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% damage when the weapon is thrown"));

    }

    public void addWarhammerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Armor Piercing"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &750.0% of damage inflicted ignores armor"));

    }

    public void addFlamedDragonBoneLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Ignites and knocks back targets, deals extra damage to ice dragons"));

    }

    public void addIcedDragonBoneLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Slows and knocks back targets, deals extra damage to fire dragons"));

    }

    public void addLightningDragonBoneLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strikes targets with lightning, deals extra damage to fire and ice dragons"));

    }

    public void addFireDragonsteelLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Ignites and knocks back targets"));

    }

    public void addIceDragonsteelLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Slows and knocks back targets"));

    }

    public void addLightningDragonsteelLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strikes targets with lightning"));

    }

    public void subtractDurability(ItemStack item) {

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
        if (temp <= plugin.getConfig().getDouble("dragons.fireDragonRate")) {
            dragonType = "Fire";
        }
        else if (temp > plugin.getConfig().getDouble("dragons.fireDragonRate") &&
                temp <= (plugin.getConfig().getDouble("dragons.fireDragonRate") + plugin.getConfig().getDouble("dragons.iceDragonRate"))) {
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

    public Vector randomizeVelocity(Vector velocity) {
        Vector newVelocity = velocity.clone();
        Random r = new Random();

        newVelocity.setX((newVelocity.getX() * r.nextDouble()) + 0.5);
        newVelocity.setY((newVelocity.getY() * r.nextDouble()) + 0.5);
        newVelocity.setZ((newVelocity.getZ() * r.nextDouble()) + 0.5);

        return newVelocity;
    }

    public void checkBauble(Player player) {
        int prResAmount = 0;
        int prRegenAmount = 0;
        int prStrengthAmount = 0;
        int prSpeedAmount = 0;
        int prJumpAmount = 0;
        int prHasteAmount = 0;
        boolean hasDragonsEye = false;
        boolean hasScarliteRing = false;
        boolean hasMinersRing = false;

        for (ItemStack item : player.getInventory()) {
            if (!(item == null || item.getType() == Material.AIR) ) {
                int amount = item.getAmount();
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Potion Effect Bauble")) {
                    switch (nbti.getString("Potion Effect Bauble")) {
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
                            hasDragonsEye = true;
                            break;
                        case "Scarlite Ring":
                            hasScarliteRing = true;
                            break;
                        case "Miner's Ring":
                            hasMinersRing = true;
                            break;
                    }
                }
            }
        }
        setOrReplaceHashmap(plugin.prRes, player.getUniqueId(), prResAmount);
        setOrReplaceHashmap(plugin.prRegen, player.getUniqueId(), prRegenAmount);
        setOrReplaceHashmap(plugin.prStrength, player.getUniqueId(), prStrengthAmount);
        setOrReplaceHashmap(plugin.prSpeed, player.getUniqueId(), prSpeedAmount);
        setOrReplaceHashmap(plugin.prJump, player.getUniqueId(), prJumpAmount);
        setOrReplaceHashmap(plugin.prHaste, player.getUniqueId(), prHasteAmount);
        setOrReplaceHashmap(plugin.dragonsEye, player.getUniqueId(), hasDragonsEye);
        setOrReplaceHashmap(plugin.scarliteRing, player.getUniqueId(), hasScarliteRing);
        setOrReplaceHashmap(plugin.minersRing, player.getUniqueId(), hasMinersRing);

    }

    public void setOrReplaceHashmap(HashMap<UUID, Integer> map, UUID key, Integer amount) {
        if (map.containsKey(key)) {
            map.replace(key, amount);
        }
        else {
            map.put(key, amount);
        }
    }

    public void setOrReplaceHashmap(HashMap<UUID, Boolean> map, UUID key, Boolean bool) {
        if (map.containsKey(key)) {
            map.replace(key, bool);
        }
        else {
            map.put(key, bool);
        }
    }

    public long convertSecondsIntoTicks(double seconds) {
        return Math.round(seconds * 20);
    }

    public void addOrStackPotionEffect(LivingEntity entity, PotionEffect effect) {
        PotionEffectType type = effect.getType();
        int newAmplifier = effect.getAmplifier();
        int newDuration = effect.getDuration();

        if (!entity.hasPotionEffect(type)) {
            entity.addPotionEffect(effect);
        }
        else {
            PotionEffect currentEffect = entity.getPotionEffect(type);
            int currentAmplifier = currentEffect.getAmplifier();
            int currentDuration = currentEffect.getDuration();
            if (newAmplifier > currentAmplifier) {
                newDuration += currentDuration;
                effect = new PotionEffect(effect.getType(), newAmplifier, newDuration);
                entity.removePotionEffect(type);
                entity.addPotionEffect(effect);
            }
            else {
                if (newDuration > currentDuration) {
                    entity.removePotionEffect(type);
                    entity.addPotionEffect(effect);
                }
            }
        }
    }

    public void addMeleeStatsLore(List<String> lore, Double damage, Double speed) {
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

    public void addWeaponLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
    }

    public void addHelmetLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
    }

    public void addChestplateLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
    }

    public void addLeggingsLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
    }

    public void addBootsLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
    }

    public void addDefenseStatsLore(List<String> lore, Double armor, Double toughness) {
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

    public void addThrowableLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When thrown:"));
    }

    public void addThrowableStatsLore(List<String> lore, Double damage) {
        if (Math.floor(damage) == damage) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage.intValue() + " Attack Damage"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage + " Attack Damage"));
        }
    }
}
