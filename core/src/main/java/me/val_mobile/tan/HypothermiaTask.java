/*
    Copyright (C) 2022  Val_Mobile

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
package me.val_mobile.tan;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVTask;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.*;

public class HypothermiaTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, HypothermiaTask> tasks = new HashMap<>();
    private final TanModule module;
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final boolean damageEnabled;
    private final double damageCutoff;
    private final double damage;
    private final boolean potionEffectsEnabled;
    private final double maxTemperature;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public HypothermiaTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.damageEnabled = config.getBoolean("Temperature.Hypothermia.Damage.Enabled");
        this.damageCutoff = config.getDouble("Temperature.Hypothermia.Damage.Cutoff");
        this.damage = config.getDouble("Temperature.Hypothermia.Damage.Amount");
        this.potionEffectsEnabled = config.getBoolean("Temperature.Hypothermia.PotionEffects.Enabled");
        this.maxTemperature = config.getDouble("Temperature.Hypothermia.Temperature");
        ConfigurationSection section = config.getConfigurationSection("Temperature.Hypothermia.PotionEffects.Effects");
        Set<String> keys = section.getKeys(false);

        int dur;
        int amp;

        for (String key : keys) {
            dur = section.getInt(key + ".Duration");
            amp = section.getInt(key + ".Amplifier");
            potionEffects.add(new PotionEffect(PotionEffectType.getByName(key), dur, amp));
        }
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();

        if (conditionsMet(player)) {
            if (!(player.hasPermission("realisticsurvival.toughasnails.resistance.*") || player.hasPermission("realisticsurvival.toughasnails.resistance.cold"))) {
                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.colddamage")) {
                    if (damageEnabled) {
                        if (player.getHealth() >= damageCutoff) {
                            if (player.getHealth() - damage <= 0) {
                                module.getHypothermiaDeath().add(id);
                            }

                            player.damage(damage);
                        }
                    }
                }

                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.coldpotioneffects")) {
                    if (potionEffectsEnabled) {
                        player.addPotionEffects(potionEffects);
                    }
                }
            }
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && !player.isDead() && allowedWorlds.contains(player.getWorld().getName()) && this.player.getTanDataModule().getTemperature() < maxTemperature;
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Temperature.Hypothermia.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, HypothermiaTask> getTasks() {
        return tasks;
    }
}
