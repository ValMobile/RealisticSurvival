/*
    Copyright (C) 2021  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.lycanites_mobs;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomItems;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LycanitesMobsEvents implements Listener {

    private final CustomItems customItems;
    private final Utils util;
    public LycanitesMobsEvents(RLCraftPlugin instance) {
        customItems = new CustomItems(instance);
        util = new Utils(instance);
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "LycanitesMobs")) {
            if (!event.isCancelled()) {
                ItemStack item = event.getItem();
                if (item.getItemMeta().equals(customItems.getBattleBurrito().getItemMeta())) {

                    int speedAmplifier = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Speed.Amplifier");
                    int speedDuration = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Speed.Duration");

                    int regenAmplifier = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Regeneration.Amplifier");
                    int regenDuration = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Regeneration.Duration");

                    int strengthAmplifier = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Strength.Amplifier");
                    int strengthDuration = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Strength.Duration");

                    int resAmplifier = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Resistance.Amplifier");
                    int resDuration = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Resistance.Duration");

                    int absorptionAmplifier = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Absorption.Amplifier");
                    int absorptionDuration = CustomConfig.getlMobsConfig().getInt("BattleBurrito.Absorption.Duration");

                    int fireResAmplifier = CustomConfig.getlMobsConfig().getInt("BattleBurrito.FireResistance.Amplifier");
                    int fireResDuration = CustomConfig.getlMobsConfig().getInt("BattleBurrito.FireResistance.Duration");

                    PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, speedDuration, speedAmplifier);
                    PotionEffect regen = new PotionEffect(PotionEffectType.REGENERATION, regenDuration, regenAmplifier);
                    PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strengthDuration, strengthAmplifier);
                    PotionEffect res = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, resDuration, resAmplifier);
                    PotionEffect absorption = new PotionEffect(PotionEffectType.ABSORPTION, absorptionDuration, absorptionAmplifier);
                    PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResDuration, fireResAmplifier);

                    Utils.smartAddPotionEffect(speed, player);
                    Utils.smartAddPotionEffect(regen, player);
                    Utils.smartAddPotionEffect(strength, player);
                    Utils.smartAddPotionEffect(res, player);
                    Utils.smartAddPotionEffect(absorption, player);
                    Utils.smartAddPotionEffect(fireRes, player);
                }
            }
        }
    }
}