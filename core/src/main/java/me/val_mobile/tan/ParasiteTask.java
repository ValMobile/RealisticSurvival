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

import me.val_mobile.data.RSVModule;
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

public class ParasiteTask extends BukkitRunnable {

    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final static HashMap<UUID, ParasiteTask> players = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final double damage;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public ParasiteTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.damage = config.getDouble("Thirst.Parasites.Damage");

        ConfigurationSection section = config.getConfigurationSection("Thirst.Parasites.PotionEffects.Effects");
        Set<String> keys = section.getKeys(false);

        int dur;
        int amp;

        for (String key : keys) {
            dur = section.getInt(key + ".Duration");
            amp = section.getInt(key + ".Amplifier");
            potionEffects.add(new PotionEffect(PotionEffectType.getByName(key), dur, amp));
        }
        players.put(player.getPlayer().getUniqueId(), this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        GameMode mode = player.getGameMode(); // get the gamemode

        if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE && player.isOnline()) && allowedWorlds.contains(player.getWorld().getName())) {
            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstdamage")) {
                player.damage(damage);
            }
        }
        // if the player is in creative or spectator
        else {
            // update static hashmap values and cancel the runnable
            players.remove(player.getUniqueId());
            ThirstCalculateTask.getTasks().get(player.getUniqueId()).setParasitesActive(false);
            cancel();
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

        ThirstCalculateTask.getTasks().get(player.getUniqueId()).setParasitesActive(true);

        int tickSpeed = config.getInt("Thirst.Parasites.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static HashMap<UUID, ParasiteTask> getPlayers() {
        return players;
    }

    public static boolean hasTask(UUID id) {
        if (players.containsKey(id)) {
            return players.get(id) != null;
        }
        return false;
    }
}
