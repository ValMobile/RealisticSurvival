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
import me.val_mobile.utils.Utils;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ColdBreathTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, ColdBreathTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final double chance;
    private final double maxTemperature;

    private final int minCount;
    private final int maxCount;
    private final double xOffset;
    private final double yOffset;
    private final double zOffset;
    private final double extra;

    private final Particle particle;
    private Particle.DustOptions dust;


    public ColdBreathTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.chance = config.getDouble("Temperature.ColdBreath.Chance");
        this.maxTemperature = config.getDouble("Temperature.ColdBreath.MaximumTemperature");

        this.minCount = config.getInt("Temperature.ColdBreath.MinCount");
        this.maxCount = config.getInt("Temperature.ColdBreath.MaxCount");
        this.xOffset = config.getDouble("Temperature.ColdBreath.x-Offset");
        this.yOffset = config.getDouble("Temperature.ColdBreath.y-Offset");
        this.zOffset = config.getDouble("Temperature.ColdBreath.z-Offset");
        this.extra = config.getDouble("Temperature.ColdBreath.Extra");
        this.particle = Particle.valueOf(config.getString("Temperature.ColdBreath.Particle"));

        if (particle == Particle.REDSTONE) {
            String color = config.getString("Temperature.ColdBreath.DustOptionColor");
            float size = (float) config.getDouble("Temperature.ColdBreath.DustOptionSize");

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

        if (conditionsMet(player)) {
            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.cold.breath")) {
                if (Utils.roll(chance)) {
                    Vector dir = player.getLocation().clone().subtract(0, 0.5D, 0).getDirection().normalize().multiply(0.5D);
                    player.spawnParticle(particle, player.getEyeLocation().add(dir), Utils.getRandomNum(minCount, maxCount), xOffset, yOffset, zOffset, extra, dust);
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
        int tickPeriod = config.getInt("Temperature.ColdBreath.TickPeriod"); // get the tick period
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

    public static Map<UUID, ColdBreathTask> getTasks() {
        return tasks;
    }
}
