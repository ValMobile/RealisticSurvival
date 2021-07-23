package me.val_mobile.sea_serpents;

import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SeaSerpentGearAbilities {

    public static void TideGuardianArmorAbility(Player player, int pieces) {

        int waterBreathingAmplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.WaterBreathing.Amplifier");
        int waterBreathingDuration = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.WaterBreathing.Duration");

        int strengthAmplifier = pieces - 1 + CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.Strength.AmplifierPerArmorPiece");
        int strengthDuration = CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.Strength.Duration");

        PotionEffect waterBreathing = new PotionEffect(PotionEffectType.WATER_BREATHING, waterBreathingDuration, waterBreathingAmplifier);
        if (player.isInWater()) {
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strengthDuration, strengthAmplifier);
            Utils.smartAddPotionEffect(strength, player);
        }
        Utils.smartAddPotionEffect(waterBreathing, player);
    }
}
