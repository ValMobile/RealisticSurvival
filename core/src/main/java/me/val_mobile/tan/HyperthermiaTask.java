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

public class HyperthermiaTask extends BukkitRunnable {

    private static final Map<UUID, HyperthermiaTask> tasks = new HashMap<>();
    private final TanModule module;
    private final FileConfiguration config;
    private final UUID id;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final double damage;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public HyperthermiaTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.damage = config.getDouble("Temperature.Hyperthermia.Damage.Amount");

        ConfigurationSection section = config.getConfigurationSection("Temperature.Hyperthermia.PotionEffects.Effects");
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
            int temperature = (int) Math.round(this.player.getTanDataModule().getTemperature());
            GameMode mode = player.getGameMode(); // get the gamemode

            if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && !player.isDead() && allowedWorlds.contains(player.getWorld().getName()) && player.isOnline()) {

                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotdamage")) {
                    if (config.getBoolean("Temperature.Hyperthermia.Damage.Enabled")) {
                        if (player.getHealth() >= config.getDouble("Temperature.Hyperthermia.Damage.Cutoff")) {
                            if (player.getHealth() - damage <= 0) {
                                module.getHyperthermiaDeath().add(id);
                            }
                            player.damage(damage);
                        }
                    }
                }

                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotpotioneffects")) {
                    if (config.getBoolean("Temperature.Hyperthermia.PotionEffects.Enabled")) {
                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotpotioneffects")) {
                            player.addPotionEffects(potionEffects);
                        }
                    }
                }

                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotcombustion")) {
                    if (config.getBoolean("Temperature.Hyperthermia.Ignite.Enabled")) {
                        int fireTicks = config.getInt("Temperature.Hyperthermia.Ignite.FireTicks");

                        if (player.getFireTicks() < fireTicks) {
                            player.setFireTicks(fireTicks);
                        }
                    }
                }

                // if the player's temperature is low enough
                if (temperature < config.getDouble("Temperature.Hyperthermia.Temperature")) {
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
        int tickSpeed = config.getInt("Temperature.Hyperthermia.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, HyperthermiaTask> getTasks() {
        return tasks;
    }
}
