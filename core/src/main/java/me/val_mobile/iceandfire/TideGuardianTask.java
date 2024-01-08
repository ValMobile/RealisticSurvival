/*
    Copyright (C) 2024  Val_Mobile

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
package me.val_mobile.iceandfire;

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TideGuardianTask extends BukkitRunnable {

    private static final Map<UUID, TideGuardianTask> tasks = new HashMap<>();
    private final FileConfiguration config;
    private final Player player;
    private final RSVPlugin plugin;
    private boolean containsTideArmor = false;
    private final Collection<String> allowedWorlds;

    private final int maxStrAmp;
    private final int maxStrDur;

    private final int maxBreathingAmp;
    private final int maxBreathingDur;
    private final boolean strEnabled;
    private final boolean breathingEnabled;
    private final boolean strRequiresWater;
    private final boolean breathingRequiresWater;

    public TideGuardianTask(IceFireModule module, Player player, RSVPlugin plugin) {
        this.player = player;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.strEnabled = config.getBoolean("Abilities.TideGuardian.Strength.Enabled");
        this.strRequiresWater = config.getBoolean("Abilities.TideGuardian.Strength.MustSubmerge");
        this.maxStrAmp = config.getInt("Abilities.TideGuardian.Strength.MaxAmplifier");
        this.maxStrDur = config.getInt("Abilities.TideGuardian.Strength.MaxDuration");

        this.breathingEnabled = config.getBoolean("Abilities.TideGuardian.WaterBreathing.Enabled");
        this.breathingRequiresWater = config.getBoolean("Abilities.TideGuardian.WaterBreathing.MustSubmerge");
        this.maxBreathingAmp = config.getInt("Abilities.TideGuardian.WaterBreathing.MaxAmplifier");
        this.maxBreathingDur = config.getInt("Abilities.TideGuardian.WaterBreathing.MaxDuration");
        tasks.put(player.getUniqueId(), this);
    }

    @Override
    public void run() {
        ItemStack[] items = player.getInventory().getArmorContents();
        int breathingDur = 0;
        int breathingAmp = 0;
        int strDur = 0;
        int strAmp = 0;

        for (ItemStack item : items) {
            if (RSVItem.isRSVItem(item)) {
                String itemName = RSVItem.getNameFromItem(item);
                if (itemName.contains("tide_guardian_")) {
                    containsTideArmor = true;
                    breathingDur += config.getInt("Items." + itemName + ".WaterBreathing.Duration");
                    breathingAmp += config.getInt("Items." + itemName + ".WaterBreathing.Amplifier");
                    strDur += config.getInt("Items." + itemName + ".Strength.Duration");
                    strAmp += config.getInt("Items." + itemName + ".Strength.Amplifier");
                }
            }
        }

        // if the player has rings of res in his/her inventory
        if (containsTideArmor && !player.isDead() && player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
            breathingAmp = Math.min(maxBreathingAmp, breathingAmp);
            breathingDur = Math.min(maxBreathingDur, breathingDur);
            strAmp = Math.min(maxStrAmp, strAmp);
            strDur = Math.min(maxStrDur, breathingDur);

            if (breathingEnabled) {
                if (breathingRequiresWater) {
                    if (player.isInWater()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, breathingDur, breathingAmp));
                    }
                }
                else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, breathingDur, breathingAmp));
                }
            }
            if (breathingEnabled) {
                if (strEnabled) {
                    if (player.isInWater()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strDur, strAmp));
                    }
                }
                else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strDur, strAmp));
                }
            }
        }
        else {
            // update static hashmap values and cancel the runnable
            tasks.remove(player.getUniqueId());
            cancel();
        }

        containsTideArmor = false;
    }

    public void start() {
        int tickPeriod = config.getInt("Abilities.TideGuardian.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }

    public Map<UUID, TideGuardianTask> getTasks() {
        return tasks;
    }
}
