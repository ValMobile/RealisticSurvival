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
import me.val_mobile.utils.DisplayTask;
import org.bukkit.GameMode;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class ParasiteTask extends BukkitRunnable {

    private final TanModule module;
    private final FileConfiguration config;
    private final RealisticSurvivalPlugin plugin;
    private static final Map<UUID, ParasiteTask> tasks = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final double damage;
    private final UUID id;
    private final int duration;
    private final int tickSpeed;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();
    private int ticks = 0;


    public ParasiteTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.damage = config.getDouble("Thirst.Parasites.Damage.Amount");
        this.duration = config.getInt("Thirst.Parasites.Duration");
        this.tickSpeed = config.getInt("Thirst.Parasites.TickSpeed");

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
        if (player == null) {
            if (DisplayTask.hasTask(id) && DisplayTask.getTasks().get(id) != null) {
                DisplayTask.getTasks().get(id).setParasitesActive(false);
            }
            tasks.remove(id);
            cancel();
        }
        // if the player is in creative or spectator
        else {
            GameMode mode = player.getGameMode(); // get the gamemode
            ticks += tickSpeed;

            if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && !player.isDead() && player.isOnline() && allowedWorlds.contains(player.getWorld().getName()) && ticks < duration) {
                DisplayTask.getTasks().get(id).setParasitesActive(true);
                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstdamage")) {
                    if (player.getHealth() - damage <= 0) {
                        if (player.getHealth() >= config.getDouble("Thirst.Parasites.Damage.Cutoff")) {
                            if (player.getHealth() - damage <= 0) {
                                module.getParasiteDeath().add(id);
                            }
                            player.damage(damage);
                        }
                    }

                    player.damage(damage);
                }
            }
            else {
                tasks.remove(id);
                ThirstCalculateTask.getTasks().get(id).setParasitesActive(false);
                if (DisplayTask.hasTask(id) && DisplayTask.getTasks().get(id) != null) {
                    DisplayTask.getTasks().get(id).setParasitesActive(false);
                }
                cancel();
            }
        }
    }

    public void startRunnable() {
        Player player = this.player.getPlayer();
        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstpotioneffects")) {
            if (config.getBoolean("Thirst.Parasites.PotionEffects.Enabled")) {
                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstpotioneffects")) {
                    player.addPotionEffects(potionEffects);
                }
            }
        }

        ThirstCalculateTask.getTasks().get(id).setParasitesActive(true);

        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static Map<UUID, ParasiteTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
