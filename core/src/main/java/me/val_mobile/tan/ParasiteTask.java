/*
    Copyright (C) 2025  Val_Mobile

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
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.DisplayTask;
import me.val_mobile.utils.RSVTask;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.*;

public class ParasiteTask extends BukkitRunnable implements RSVTask {

    private final TanModule module;
    private final FileConfiguration config;
    private final RSVPlugin plugin;
    private static final Map<UUID, ParasiteTask> tasks = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final boolean damageEnabled;
    private final double damage;
    private final double damageCutoff;
    private final UUID id;
    private final int duration;
    private final int tickPeriod;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();
    private final boolean potionEffectsEnabled;
    private int ticks = 0;


    public ParasiteTask(TanModule module, RSVPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.damageEnabled = config.getBoolean("Thirst.Parasites.Damage.Enabled");
        this.damage = config.getDouble("Thirst.Parasites.Damage.Amount");
        this.damageCutoff = config.getDouble("Thirst.Parasites.Damage.Cutoff");
        this.duration = config.getInt("Thirst.Parasites.Duration");
        this.tickPeriod = config.getInt("Thirst.Parasites.TickPeriod");
        this.potionEffectsEnabled = config.getBoolean("Thirst.Parasites.PotionEffects.Enabled");
        ConfigurationSection section = config.getConfigurationSection("Thirst.Parasites.PotionEffects.Effects");
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
            ticks += tickPeriod;

            DisplayTask.getTasks().get(id).setParasitesActive(true);

            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.parasite.damage")) {
                if (damageEnabled) {
                    if (player.getHealth() >= damageCutoff) {
                        if (player.getHealth() - damage <= 0) {
                            module.getParasiteDeath().add(id);
                        }
                        player.damage(damage);
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
        return globalConditionsMet(player) && !player.isDead() && allowedWorlds.contains(player.getWorld().getName()) && ticks < duration;
    }

    @Override
    public void start() {
        Player player = this.player.getPlayer();
        ThirstCalculateTask.getTasks().get(id).setParasitesActive(true);

        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.parasite.potioneffects")) {
            if (potionEffectsEnabled) {
                player.addPotionEffects(potionEffects);
            }
        }

        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        if (ThirstCalculateTask.hasTask(id)) {
            ThirstCalculateTask.getTasks().get(id).setParasitesActive(false);
        }
        if (DisplayTask.hasTask(id)) {
            DisplayTask.getTasks().get(id).setParasitesActive(false);
        }
        tasks.remove(id);
        cancel();
    }

    public static Map<UUID, ParasiteTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }
}
