package me.val_mobile.rlcraft;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BaubleAbilities {

    private final Utils util;
    private final CustomConfig customConfig;
    public BaubleAbilities(RLCraft instance) {
        util = new Utils(instance);
        customConfig = new CustomConfig(instance);
    }

    public void DragonsEyeAbility(Player player) {
        int fireResAmplifier = customConfig.getBaubleConfig().getInt("DragonsEye.FireResistance.Amplifier");
        int fireResDuration = customConfig.getBaubleConfig().getInt("DragonsEye.FireResistance.Duration");
        int nightVisAmplifier = customConfig.getBaubleConfig().getInt("DragonsEye.NightVision.Amplifier");
        int nightVisDuration = customConfig.getBaubleConfig().getInt("DragonsEye.NightVision.Duration");

        PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResDuration, fireResAmplifier);
        util.addOrStackPotionEffect(player, fireRes);

        PotionEffect nightVis = new PotionEffect(PotionEffectType.NIGHT_VISION, nightVisDuration, nightVisAmplifier);
        util.addOrStackPotionEffect(player, nightVis);

    }

    public void RingResistanceAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = customConfig.getBaubleConfig().getInt("PotionRingResistance.Duration");
        if (customConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier") != -1) {
            if (amplifier > customConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier")) {
                amplifier = customConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingHasteAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = customConfig.getBaubleConfig().getInt("PotionRingHaste.Duration");
        if (customConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier") != -1) {
            if (amplifier > customConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier")) {
                amplifier = customConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingRegenerationAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = customConfig.getBaubleConfig().getInt("PotionRingRegeneration.Duration");
        if (customConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier") != -1) {
            if (amplifier > customConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier")) {
                amplifier = customConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier");
            }
        }


        PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingSpeedAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = customConfig.getBaubleConfig().getInt("PotionRingSpeed.Duration");
        if (customConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier") != -1) {
            if (amplifier > customConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier")) {
                amplifier = customConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingJumpBoostAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = customConfig.getBaubleConfig().getInt("PotionRingJumpBoost.Duration");
        if (customConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier") != -1) {
            if (amplifier > customConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier")) {
                amplifier = customConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingStrengthAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = customConfig.getBaubleConfig().getInt("PotionRingStrength.Duration");
        if (customConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier") != -1) {
            if (amplifier > customConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier")) {
                amplifier = customConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier");
            }
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void PoisonStoneAbility(LivingEntity entity) {

        int amplifier = customConfig.getBaubleConfig().getInt("PoisonStone.Amplifier");
        int duration = customConfig.getBaubleConfig().getInt("PoisonStone.Duration");

        PotionEffect effect = new PotionEffect(PotionEffectType.POISON, duration, amplifier);
        util.addOrStackPotionEffect(entity, effect);

    }

    public void ScarliteRingAbility(Player player) {

        double healAmount = customConfig.getBaubleConfig().getDouble("ScarliteRing.HealAmount");

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

    public void MinersRingAbility(Player player) {

        int amplifier = customConfig.getBaubleConfig().getInt("MinersRing.Amplifier");
        int duration = customConfig.getBaubleConfig().getInt("MinersRing.Duration");

        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }
}
