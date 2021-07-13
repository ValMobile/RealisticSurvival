package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LycanitesMobsEvents implements Listener {

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getItemMeta().equals(CustomItems.getBattleBurrito().getItemMeta())) {
            Player player = event.getPlayer();

            int speedAmplifier = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Speed.Amplifier");
            int speedDuration = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Speed.Duration");

            int regenAmplifier = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Regeneration.Amplifier");
            int regenDuration = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Regeneration.Duration");

            int strengthAmplifier = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Strength.Amplifier");
            int strengthDuration = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Strength.Duration");

            int resAmplifier = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Resistance.Amplifier");
            int resDuration = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Resistance.Duration");

            int absorptionAmplifier = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Absorption.Amplifier");
            int absorptionDuration = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.Absorption.Duration");

            int fireResAmplifier = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.FireResistance.Amplifier");
            int fireResDuration = CustomConfig.getLycanitesMobsConfig().getInt("BattleBurrito.FireResistance.Duration");

            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, speedDuration, speedAmplifier);
            PotionEffect regen = new PotionEffect(PotionEffectType.REGENERATION, regenDuration, regenAmplifier);
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strengthDuration, strengthAmplifier);
            PotionEffect res = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, resDuration, resAmplifier);
            PotionEffect absorption = new PotionEffect(PotionEffectType.ABSORPTION, absorptionDuration, absorptionAmplifier);
            PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResDuration, fireResAmplifier);


            player.addPotionEffect(speed);
            player.addPotionEffect(regen);
            player.addPotionEffect(strength);
            player.addPotionEffect(res);
            player.addPotionEffect(absorption);
            player.addPotionEffect(fireRes);

        }
    }
}
