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
import org.bukkit.GameMode;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class DehydrationTask extends BukkitRunnable {

    private static final Map<UUID, DehydrationTask> tasks = new HashMap<>();
    private final UUID id;
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final double damage;
    private final TanModule module;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public DehydrationTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.damage = config.getDouble("Thirst.Dehydration.Damage.Amount");

        ConfigurationSection section = config.getConfigurationSection("Thirst.Dehydration.PotionEffects.Effects");
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
            tasks.remove(id);
            cancel();
        }
        else {
            double thirst = this.player.getTanDataModule().getThirst();
            GameMode mode = player.getGameMode(); // get the gamemode

            if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && player.isOnline() && !player.isDead() && allowedWorlds.contains(player.getWorld().getName())) {

                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstdamage")) {
                    if (config.getBoolean("Thirst.Dehydration.Damage.Enabled")) {
                        if (player.getHealth() >= config.getDouble("Thirst.Dehydration.Damage.Cutoff")) {
                            if (player.getHealth() - damage <= 0) {
                                module.getDehydrationDeath().add(id);
                            }
                            player.damage(damage);
                        }
                    }
                }

                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstpotioneffects")) {
                    if (config.getBoolean("Thirst.Dehydration.PotionEffects.Enabled")) {
                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstpotioneffects")) {
                            player.addPotionEffects(potionEffects);
                        }
                    }
                }

                // if the player's thirst is high enough
                if (thirst > config.getDouble("Thirst.Dehydration.Thirst")) {
                    tasks.remove(id);
                    cancel();
                }

            }
            // if the player is in creative or spectator
            else {
                // update static hashmap values and cancel the runnable
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void start() {
        int tickPeriod = config.getInt("Thirst.Dehydration.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, DehydrationTask> getTasks() {
        return tasks;
    }
}
