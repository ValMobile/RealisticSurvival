package me.val_mobile.rlcraft;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BaubleAbilities {

    public static void DragonsEyeAbility(Player player) {
        int fireResAmplifier = CustomConfig.getBaubleConfig().getInt("DragonsEye.FireResistance.Amplifier");
        int fireResDuration = CustomConfig.getBaubleConfig().getInt("DragonsEye.FireResistance.Duration");
        int nightVisAmplifier = CustomConfig.getBaubleConfig().getInt("DragonsEye.NightVision.Amplifier");
        int nightVisDuration = CustomConfig.getBaubleConfig().getInt("DragonsEye.NightVision.Duration");

        PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResDuration, fireResAmplifier);
        player.addPotionEffect(fireRes);

        PotionEffect nightVis = new PotionEffect(PotionEffectType.NIGHT_VISION, nightVisDuration, nightVisAmplifier);
        player.addPotionEffect(nightVis);

    }

    public static void RingResistanceAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingResistance.Duration");
        if (CustomConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier") != -1) {
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void RingHasteAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingHaste.Duration");
        if (CustomConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier") != -1) {
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void RingRegenerationAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.Duration");
        if (CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier") != -1) {
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier");
            }
        }


        PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void RingSpeedAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.Duration");
        if (CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier") != -1) {
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void RingJumpBoostAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.Duration");
        if (CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier") != -1) {
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void RingStrengthAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingStrength.Duration");
        if (CustomConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier") != -1) {
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void PoisonStoneAbility(LivingEntity entity) {

        int amplifier = CustomConfig.getBaubleConfig().getInt("PoisonStone.Amplifier");
        int duration = CustomConfig.getBaubleConfig().getInt("PoisonStone.Duration");

        PotionEffect effect = new PotionEffect(PotionEffectType.POISON, duration, amplifier);
        entity.addPotionEffect(effect);

    }

    public static void ScarliteRingAbility(Player player) {

        double healAmount = CustomConfig.getBaubleConfig().getDouble("ScarliteRing.HealAmount");

        if (player.getHealth() < player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
            double difference = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - player.getHealth();
            if (difference < healAmount) {
                player.setHealth(player.getHealth() + difference);
            }
            else {
                player.setHealth(player.getHealth() + healAmount);
            }
        }
    }

    public static void MinersRingAbility(Player player) {

        int amplifier = CustomConfig.getBaubleConfig().getInt("MinersRing.Amplifier");
        int duration = CustomConfig.getBaubleConfig().getInt("MinersRing.Duration");

        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static void ShieldHonorAbility(Player player) {

        int amplifier = CustomConfig.getBaubleConfig().getInt("ShieldHonor.Amplifier");
        int duration = CustomConfig.getBaubleConfig().getInt("ShieldHonor.Duration");

        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier);
        player.addPotionEffect(effect);
    }
}
