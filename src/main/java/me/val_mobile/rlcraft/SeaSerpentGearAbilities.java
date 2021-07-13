package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SeaSerpentGearAbilities {

    public void TideGuardianArmorAbility(Player player, int pieces) {

        int waterBreathingAmplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.WaterBreathing.Amplifier");
        int waterBreathingDuration = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.WaterBreathing.Duration");

        int strengthAmplifier = pieces * CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.Strength.AmplifierPerArmorPiece");
        int strengthDuration = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.Strength.Duration");

        PotionEffect waterBreathing = new PotionEffect(PotionEffectType.WATER_BREATHING, waterBreathingDuration, waterBreathingAmplifier);
        if (player.isInWater()) {
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strengthDuration, strengthAmplifier);
            player.addPotionEffect(strength);
        }
        player.addPotionEffect(waterBreathing);
    }
}
