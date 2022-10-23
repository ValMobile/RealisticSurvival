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
import me.val_mobile.utils.Utils;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SweatTask extends BukkitRunnable {

    private static final Map<UUID, SweatTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final double chance;
    private final double minTemperature;
    private final int minCount;
    private final int maxCount;
    private final double xOffset;
    private final double yOffset;
    private final double zOffset;
    private final double extra;

    private final Particle particle;
    private Particle.DustOptions dust;


    public SweatTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.chance = config.getDouble("Temperature.Sweating.Chance");
        this.minTemperature = config.getDouble("Temperature.Sweating.MinimumTemperature");
        this.minCount = config.getInt("Temperature.Sweating.MinCount");
        this.maxCount = config.getInt("Temperature.Sweating.MaxCount");
        this.xOffset = config.getDouble("Temperature.Sweating.x-Offset");
        this.yOffset = config.getDouble("Temperature.Sweating.y-Offset");
        this.zOffset = config.getDouble("Temperature.Sweating.z-Offset");
        this.extra = config.getDouble("Temperature.Sweating.Extra");
        this.particle = Particle.valueOf(config.getString("Temperature.Sweating.Particle"));

        if (particle == Particle.REDSTONE) {
            String color = config.getString("Temperature.Sweating.DustOptionColor");
            float size = (float) config.getDouble("Temperature.Sweating.DustOptionSize");

            if (color.contains("|")) {
                int first = color.indexOf("|");
                int second = color.lastIndexOf("|");

                int red = Integer.parseInt(color.substring(0, first));
                int green = Integer.parseInt(color.substring(first + 1, second));
                int blue = Integer.parseInt(color.substring(second + 1));

                dust = new Particle.DustOptions(Color.fromRGB(red, green, blue), size);
            }
            else {
                dust = new Particle.DustOptions(Utils.valueOfColor(color), size);
            }
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
                if (Math.random() <= chance) {
                    Vector dir = player.getLocation().clone().subtract(0, 0.5D, 0).getDirection().normalize().multiply(0.5D);
                    player.spawnParticle(particle, player.getEyeLocation().add(dir), Utils.getRandomNum(minCount, maxCount), xOffset, yOffset, zOffset, extra, dust);
                }

                // if the player's temperature is low enough
                if (temperature < minTemperature) {
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
        int tickSpeed = config.getInt("Temperature.Sweating.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, SweatTask> getTasks() {
        return tasks;
    }
}
