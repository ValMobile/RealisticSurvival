package me.val_mobile.rlcraft;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BaubleAbilities {

    private final Utils util;
    public BaubleAbilities(RLCraft instance) {
        util = new Utils(instance);
    }

    public void DragonsEyeAbility(Player player) {
        int fireResAmplifier = 0;
        int fireResDuration = 220;
        int nightVisAmplifier = 0;
        int nightVisDuration = 220;

        PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResDuration, fireResAmplifier);
        util.addOrStackPotionEffect(player, fireRes);

        PotionEffect nightVis = new PotionEffect(PotionEffectType.NIGHT_VISION, nightVisDuration, nightVisAmplifier);
        util.addOrStackPotionEffect(player, nightVis);

    }

    public void RingResistanceAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        if (amplifier > 2) {
            amplifier = 2;
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingHasteAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = 270;

        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingRegenerationAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        if (amplifier > 2) {
            amplifier = 2;
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingSpeedAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = 270;

        PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingJumpBoostAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;

        PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void RingStrengthAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        if (amplifier > 2) {
            amplifier = 2;
        }

        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }

    public void PoisonStoneAbility(LivingEntity entity) {

        int amplifier = 1;
        int duration = 270;

        PotionEffect effect = new PotionEffect(PotionEffectType.POISON, duration, amplifier);
        util.addOrStackPotionEffect(entity, effect);

    }

    public void ScarliteRingAbility(Player player) {

        double healAmount = 1.0D;

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

        int amplifier = 0;
        int duration = 270;

        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }
}
