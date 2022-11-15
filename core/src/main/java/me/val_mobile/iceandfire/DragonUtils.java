package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import me.val_mobile.spartanandfire.FreezeTask;
import me.val_mobile.utils.LorePresets;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;

public class DragonUtils {

    private static final FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public static void performMeleeAttack(EnderDragon dragon, LivingEntity defender) {
        if (isMob(dragon)) {
            switch (getMob(dragon)) {
                case "fire_dragon" -> performMeleeFireAbility(dragon, defender);
                case "ice_dragon" -> performMeleeIceAbility(dragon, defender);
                case "lightning_dragon" -> performMeleeLightningAbility(dragon, defender);
                default -> {}
            }
        }
    }

    public static void performSpecialAbility(EnderDragon dragon, LivingEntity defender) {
        if (isMob(dragon)) {
            switch (getMob(dragon)) {
                case "fire_dragon" -> performSpecialFireAbility(dragon, defender);
                case "ice_dragon" -> performSpecialIceAbility(dragon, defender);
                case "lightning_dragon" -> performSpecialLightningAbility(dragon, defender);
                default -> {}
            }
        }
    }

    public static void performMeleeFireAbility(EnderDragon dragon, LivingEntity defender) {
        double stageMultiplier = CONFIG.getDouble("Dragons.FireDragon.MeleeAttack.StageMultiplier.Stage" + getStage(dragon));
        defender.damage(CONFIG.getDouble("Dragons.FireDragon.MeleeAttack.BaseDamage") * stageMultiplier, dragon);
    }

    public static void performMeleeIceAbility(EnderDragon dragon, LivingEntity defender) {
        double stageMultiplier = CONFIG.getDouble("Dragons.IceDragon.MeleeAttack.StageMultiplier.Stage" + getStage(dragon));
        defender.damage(CONFIG.getDouble("Dragons.IceDragon.MeleeAttack.BaseDamage") * stageMultiplier, dragon);
    }

    public static void performMeleeLightningAbility(EnderDragon dragon, LivingEntity defender) {
        double stageMultiplier = CONFIG.getDouble("Dragons.LightningDragon.MeleeAttack.StageMultiplier.Stage" + getStage(dragon));
        defender.damage(CONFIG.getDouble("Dragons.LightningDragon.MeleeAttack.BaseDamage") * stageMultiplier, dragon);
    }

    public static void performSpecialFireAbility(EnderDragon dragon, LivingEntity defender) {
        double stageMultiplier = CONFIG.getDouble("Dragons.FireDragon.InfernoAbility.StageMultiplier.Stage" + getStage(dragon));
        if (!BurnTask.hasTask(defender.getUniqueId())) {
            new BurnTask(RealisticSurvivalPlugin.getPlugin(), defender, (int) (CONFIG.getInt("Dragons.FireDragon.InfernoAbility.FireTicks") * stageMultiplier), CONFIG.getInt("Dragons.FireDragon.InfernoAbility.TickPeriod")).start();
        }
    }

    public static void performSpecialIceAbility(EnderDragon dragon, LivingEntity defender) {
        if (!FreezeTask.hasTask(defender.getUniqueId())) {
            new FreezeTask(RealisticSurvivalPlugin.getPlugin(), getStage(dragon), defender).start();
        }
    }

    public static void performSpecialLightningAbility(EnderDragon dragon, LivingEntity defender) {
        Location loc = defender.getLocation();
        if (CONFIG.getBoolean("Dragons.LightningDragon.ElectrocuteAbility.SummonCosmeticLightning")) {
            loc.getWorld().strikeLightningEffect(loc);
        }
        else {
            loc.getWorld().strikeLightning(loc);
        }
        if (!ElectrocuteTask.hasTask(defender.getUniqueId())) {
            new ElectrocuteTask(RealisticSurvivalPlugin.getPlugin(), getStage(dragon), defender).start();
        }
    }

    public static void triggerBreathAttack(EnderDragon dragon, Location target) {
        if (isMob(dragon)) {
            switch (getMob(dragon)) {
                case "fire_dragon" -> triggerBreathFireAttack(dragon, target);
                case "ice_dragon" -> triggerBreathIceAttack(dragon, target);
                case "lightning_dragon" -> triggerBreathLightningAttack(dragon, target);
                default -> {}
            }
        }
    }

    public static void triggerExplosionAttack(EnderDragon dragon, Location target) {
        if (isMob(dragon)) {
            switch (getMob(dragon)) {
                case "fire_dragon" -> triggerExplosionFireAttack(dragon, target);
                case "ice_dragon" -> triggerExplosionIceAttack(dragon, target);
                case "lightning_dragon" -> triggerExplosionLightningAttack(dragon, target);
                default -> {}
            }
        }
    }

    public static void triggerBreathFireAttack(EnderDragon dragon, Location target) {
        new FireBreath(dragon, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    public static void triggerBreathIceAttack(EnderDragon dragon, Location target) {
        new IceBreath(dragon, target, RealisticSurvivalPlugin.getPlugin()).start();
    }


    public static void triggerBreathLightningAttack(EnderDragon dragon, Location target) {
        new LightningBreath(dragon, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    public static void triggerExplosionFireAttack(EnderDragon dragon, Location target) {
        new FireExplosionAttack(dragon, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    public static void triggerExplosionIceAttack(EnderDragon dragon, Location target) {
        new IceExplosionAttack(dragon, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    public static void triggerExplosionLightningAttack(EnderDragon dragon, Location target) {
        new LightningExplosionAttack(dragon, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    public static Collection<ItemStack> generateLoot(EnderDragon dragon) {
        Collection<ItemStack> loot = new ArrayList<>();

        int stage = getStage(dragon);
        DragonBreed breed = getBreed(dragon);
        DragonVariant variant = getVariant(dragon);

        String lowercaseBreed = breed.toString().toLowerCase();
        String capitalizeBreed = StringUtils.capitalize(lowercaseBreed);

        // initialize loot items
        ItemStack heart = RSVItem.getItem("dragon_heart_" + lowercaseBreed);
        ItemStack skull = RSVItem.getItem("dragon_skull_" + lowercaseBreed);
        ItemStack scales;
        ItemStack blood = RSVItem.getItem("dragon_blood_" + lowercaseBreed);
        ItemStack flesh = RSVItem.getItem("dragon_flesh_" + lowercaseBreed);
        ItemStack bones = RSVItem.getItem("dragonbone");

        // initialize the drop amounts of the loot
        int scaleAmount;
        int boneAmount;
        int bloodAmount;
        int fleshAmount;

        scales = RSVItem.getItem("dragonscale_" + variant.toString().toLowerCase());

        /**
         * Scale amount is between the minimum and maximum specified values.
         * Bone amount is calculated by subtracting the scale amount and adding a minimum bone amount.
         * Adding a minimum value ensures that at least 1 bone will drop.
         * Dragon flesh and blood amounts are determined by multiplying the scale amount
         * by a specified multiplier.
         */
        int maxScales = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonscales.Max");
        int minScales = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonscales.Min");
        int maxBones = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonbones.Max");
        int minBones = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonbones.Min");
        int minBlood = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Blood.Min");
        int maxBlood = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Blood.Max");
        int minFlesh = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Flesh.Min");
        int maxFlesh = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Flesh.Max");

        double stageMultiplier = CONFIG.getDouble("Dragons." + capitalizeBreed + "Dragon.Drops.StageMultipliers.Stage" + stage);

        scaleAmount = Utils.getRandomNum(minScales, maxScales);
        boneAmount = Utils.getRandomNum(minBones, maxBones);
        bloodAmount = Math.min((maxScales - scaleAmount + minBlood), maxBlood);
        fleshAmount = Utils.getRandomNum(minFlesh, maxFlesh);

        scaleAmount *= stageMultiplier;
        boneAmount *= stageMultiplier;
        bloodAmount *= stageMultiplier;
        fleshAmount *= stageMultiplier;

        // resize loot
        bones.setAmount(boneAmount);
        blood.setAmount(bloodAmount);
        flesh.setAmount(fleshAmount);
        scales.setAmount(scaleAmount);

        // add a lore to the skull
        LorePresets.addDragonSkullLore(skull, stage, breed.toString());

        // add the loot to the loot table
        loot.add(bones);
        loot.add(heart);
        loot.add(skull);
        loot.add(scales);
        loot.add(blood);
        loot.add(flesh);

        return loot;
    }

    public static boolean isMob(Entity entity) {
        return Utils.hasNbtTag(entity, "rsvmob");
    }

    public static boolean isDragon(Entity entity) {
        if (isMob(entity)) {
            return switch (getMob(entity)) {
                case "fire_dragon", "ice_dragon", "lightning_dragon" -> true;
                default -> false;
            };
        }
        return false;
    }

    public static String getMob(Entity entity) {
        return Utils.getNbtTag(entity, "rsvmob", PersistentDataType.STRING);
    }

    public static int getStage(EnderDragon dragon) {
        return Utils.getNbtTag(dragon, "rsvdragonstage", PersistentDataType.INTEGER);
    }

    public static int getAge(EnderDragon dragon) {
        return Utils.getNbtTag(dragon, "rsvdragonage", PersistentDataType.INTEGER);
    }

    public static DragonVariant getVariant(EnderDragon dragon) {
        return DragonVariant.valueOf(Utils.getNbtTag(dragon, "rsvdragonvariant", PersistentDataType.STRING));
    }

    public static DragonBreed getBreed(EnderDragon dragon) {
        return DragonBreed.valueOf(Utils.getNbtTag(dragon, "rsvdragonbreed", PersistentDataType.STRING));
    }

    public static DragonGender getGender(EnderDragon dragon) {
        return DragonGender.valueOf(Utils.getNbtTag(dragon, "rsvdragongender", PersistentDataType.STRING));
    }
}
