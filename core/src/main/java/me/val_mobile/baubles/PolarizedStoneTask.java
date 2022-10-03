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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class PolarizedStoneTask extends BukkitRunnable {

    private static final HashMap<UUID, PolarizedStoneTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();
    private double maxRadius = config.getDouble("Items.polarized_stone.MaxRadius");
    private double pullForce = config.getDouble("Items.polarized_stone.PullForce");

    public PolarizedStoneTask(RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.allowedWorlds = RSVModule.getModule(BaubleModule.NAME).getAllowedWorlds();
        this.plugin = plugin;
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player p = rsvPlayer.getPlayer();

        if (p == null) {
            tasks.remove(id);
            cancel();
        }
        else {
            if (!p.isDead() && p.isOnline() && allowedWorlds.contains(p.getWorld().getName())) {
                boolean hasBauble = rsvPlayer.getBaubleDataModule().hasBauble("polarized_stone");

                if (hasBauble) {
                    // effect the player with resistance
                    Location loc = p.getLocation();
                    for (Entity e : p.getNearbyEntities(maxRadius, maxRadius, maxRadius)) {
                        if (e.getType() == EntityType.EXPERIENCE_ORB || e.getType() == EntityType.DROPPED_ITEM) {
                            Location eLoc = e.getLocation();
                            double xDif = loc.getX() - eLoc.getX();
                            double yDif = loc.getY() - eLoc.getY();
                            double zDif = loc.getZ() - eLoc.getZ();
                            e.setVelocity((new Vector(xDif, yDif, zDif)).normalize().multiply(pullForce));
                        }
                    }
                }
                // if the player doesn't have rings of res in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    tasks.remove(id);
                    cancel();
                }
            }
            else {
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Items.polarized_stone.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public HashMap<UUID, PolarizedStoneTask> getTasks() {
        return tasks;
    }
}
