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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVTask;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PolarizedStoneTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, PolarizedStoneTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final RSVPlugin plugin;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final FileConfiguration config;
    private final double maxRadius;
    private final double pullForce;

    public PolarizedStoneTask(BaubleModule module, RSVPlayer rsvPlayer, RSVPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.config = module.getUserConfig().getConfig();
        this.plugin = plugin;
        this.maxRadius = config.getDouble("Items.polarized_stone.MaxRadius");
        this.pullForce = config.getDouble("Items.polarized_stone.PullForce");
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (conditionsMet(player)) {
            Location pLoc = player.getLocation();
            Vector pVector = pLoc.toVector();
            for (Entity entity : player.getNearbyEntities(maxRadius, maxRadius, maxRadius)) {
                if (entity.getType() == EntityType.EXPERIENCE_ORB || entity.getType() == EntityType.DROPPED_ITEM) {
                    if (entity.getLocation().distanceSquared(pLoc) > 0.25) {
                        entity.setVelocity(pVector.subtract(entity.getLocation().toVector()).normalize().multiply(pullForce));
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
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName()) && rsvPlayer.getBaubleDataModule().hasBauble("polarized_stone");
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Items.polarized_stone.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }

    public static Map<UUID, PolarizedStoneTask> getTasks() {
        return tasks;
    }
}
