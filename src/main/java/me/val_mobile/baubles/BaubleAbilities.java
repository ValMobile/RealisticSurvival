package me.val_mobile.baubles;

import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
/**
 * BaubleAbilities is a utility class containing methods that
 * execute various abilities of the bauble items
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class BaubleAbilities {

    /**
     * Effects the player with fire resistance and night vision
     * @param player The target player
     * @see BaubleEvents
     * @see Utils
     */
    public static void DragonsEyeAbility(Player player) {
        // store the duration and amplifier of both effects
        int fireResAmplifier = CustomConfig.getBaubleConfig().getInt("DragonsEye.FireResistance.Amplifier");
        int fireResDuration = CustomConfig.getBaubleConfig().getInt("DragonsEye.FireResistance.Duration");
        int nightVisAmplifier = CustomConfig.getBaubleConfig().getInt("DragonsEye.NightVision.Amplifier");
        int nightVisDuration = CustomConfig.getBaubleConfig().getInt("DragonsEye.NightVision.Duration");

        // create the effects using the duration and amplifier variables
        PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResDuration, fireResAmplifier);
        PotionEffect nightVis = new PotionEffect(PotionEffectType.NIGHT_VISION, nightVisDuration, nightVisAmplifier);

        // add the effects to the target player
        Utils.smartAddPotionEffect(fireRes, player);
        Utils.smartAddPotionEffect(nightVis, player);
    }

    /**
     * Effects the player with resistance. The amplifier is calculated based off
     * the amount of potion rings in the player's inventory
     * @param player The target player
     * @param amount The amount of potion rings of resistance in the player's inventory
     * @see BaubleEvents
     * @see Utils
     */
    public static void RingResistanceAbility(Player player, int amount) {
        // store the duration and amplifier of the resistance effect
        // the amplifier is 1 less than the amount because amplifiers count up from 0
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingResistance.Duration");
        
        // if the amount is not 0
        if (CustomConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier") != -1) {
            // set the amplifier to a lower value if it above the specified max amplifier
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingResistance.MaxAmplifier");
            }
        }

        // create the resistance effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier);

        // add the resistance effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the player with haste. The amplifier is calculated based off
     * the amount of potion rings in the player's inventory
     * @param player The target player
     * @param amount The amount of potion rings of haste in the player's inventory
     * @see BaubleEvents
     * @see Utils
     */
    public static void RingHasteAbility(Player player, int amount) {
        // store the duration and amplifier of the haste effect
        // the amplifier is 1 less than the amount because amplifiers count up from 0
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingHaste.Duration");

        // if the amount is not 0
        if (CustomConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier") != -1) {
            // set the amplifier to a lower value if it above the specified max amplifier
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingHaste.MaxAmplifier");
            }
        }
        
        // create the haste effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);
        
        // add the haste effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the player with regeneration. The amplifier is calculated based off
     * the amount of potion rings in the player's inventory
     * @param player The target player
     * @param amount The amount of potion rings of regeneration in the player's inventory
     * @see BaubleEvents
     * @see Utils
     */
    public static void RingRegenerationAbility(Player player, int amount) {
        // store the duration and amplifier of the regeneration effect
        // the amplifier is 1 less than the amount because amplifiers count up from 0
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.Duration");

        // if the amount is not 0
        if (CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier") != -1) {
            // set the amplifier to a lower value if it above the specified max amplifier
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.MaxAmplifier");
            }
        }

        // create the regeneration effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, duration, amplifier);
        
        // add the regeneration effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the player with speed. The amplifier is calculated based off
     * the amount of potion rings in the player's inventory
     * @param player The target player
     * @param amount The amount of potion rings of speed in the player's inventory
     * @see BaubleEvents
     * @see Utils
     */
    public static void RingSpeedAbility(Player player, int amount) {
        // store the duration and amplifier of the speed effect
        // the amplifier is 1 less than the amount because amplifiers count up from 0
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.Duration");

        // if the amount is not 0
        if (CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier") != -1) {
            // set the amplifier to a lower value if it above the specified max amplifier
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.MaxAmplifier");
            }
        }

        // create the speed effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, duration, amplifier);

        // add the speed effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the player with jump. The amplifier is calculated based off
     * the amount of potion rings in the player's inventory
     * @param player The target player
     * @param amount The amount of potion rings of jump boost in the player's inventory
     * @see BaubleEvents
     * @see Utils
     */
    public static void RingJumpBoostAbility(Player player, int amount) {
        // store the duration and amplifier of the jump boost effect
        // the amplifier is 1 less than the amount because amplifiers count up from 0
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.Duration");

        // if the amount is not 0
        if (CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier") != -1) {
            // set the amplifier to a lower value if it above the specified max amplifier
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.MaxAmplifier");
            }
        }

        // create the jump boost effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, duration, amplifier);

        // add the jump boost effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the player with strength. The amplifier is calculated based off
     * the amount of potion rings in the player's inventory
     * @param player The target player
     * @param amount The amount of potion rings of strength in the player's inventory
     * @see BaubleEvents
     * @see Utils
     */
    public static void RingStrengthAbility(Player player, int amount) {
        // store the duration and amplifier of the strength effect
        // the amplifier is 1 less than the amount because amplifiers count up from 0
        int amplifier = amount - 1;
        int duration = CustomConfig.getBaubleConfig().getInt("PotionRingStrength.Duration");

        // iif the amount is not 0
        if (CustomConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier") != -1) {
            // set the amplifier to a lower value if it above the specified max amplifier
            if (amplifier > CustomConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier")) {
                amplifier = CustomConfig.getBaubleConfig().getInt("PotionRingStrength.MaxAmplifier");
            }
        }

        // create the strength effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amplifier);

        // add the strength effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the entity with poison
     * @param entity The target entity
     * @see BaubleEvents
     * @see Utils
     */
    public static void PoisonStoneAbility(LivingEntity entity) {
        // store the duration and amplifier of the poison effect
        int amplifier = CustomConfig.getBaubleConfig().getInt("PoisonStone.Amplifier");
        int duration = CustomConfig.getBaubleConfig().getInt("PoisonStone.Duration");

        // create the poison effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.POISON, duration, amplifier);

        // add the poison effect to the target entity
        Utils.smartAddPotionEffect(effect, entity);
    }

    /**
     * Heals the player a predefined amount every few seconds
     * @param player The target player
     * @see BaubleEvents
     */
    public static void ScarliteRingAbility(Player player) {
        // store the amount of health to heal the player
        double healAmount = CustomConfig.getBaubleConfig().getDouble("ScarliteRing.HealAmount");

        // if the player's health is less than their maximum health
        if (player.getHealth() < player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
            // store the difference between the player's current and maximum health in a variable
            double difference = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - player.getHealth();

            // if the difference is less than the specified heal amount
            if (difference < healAmount) {
                // add only the difference to avoid setting the player's health too high
                player.setHealth(player.getHealth() + difference);
            }
            // if the difference is greater
            else {
                // add the specified heal amount
                player.setHealth(player.getHealth() + healAmount);
            }
        }
    }

    /**
     * Effects the player with haste
     * @param player The target player
     * @see BaubleEvents
     * @see Utils
     */
    public static void MinersRingAbility(Player player) {
        // store the duration and amplifier of the haste effect
        int amplifier = CustomConfig.getBaubleConfig().getInt("MinersRing.Amplifier");
        int duration = CustomConfig.getBaubleConfig().getInt("MinersRing.Duration");

        // create the haste effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier);

        // add the haste effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }

    /**
     * Effects the player with resistance
     * @param player The target player
     * @see BaubleEvents
     * @see Utils
     */
    public static void ShieldHonorAbility(Player player) {
        // store the duration and amplifier of the resistance effect
        int amplifier = CustomConfig.getBaubleConfig().getInt("ShieldHonor.Amplifier");
        int duration = CustomConfig.getBaubleConfig().getInt("ShieldHonor.Duration");

        // create the resistance effect using the duration and amplifier variables
        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier);

        // add the resistance effect to the target player
        Utils.smartAddPotionEffect(effect, player);
    }
}
