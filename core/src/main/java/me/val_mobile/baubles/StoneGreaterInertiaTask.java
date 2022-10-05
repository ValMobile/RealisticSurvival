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

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StoneGreaterInertiaTask extends BukkitRunnable {

    private static final Map<UUID, StoneGreaterInertiaTask> tasks = new HashMap<>();
    private final static float MAX_WALK_SPEED = 1.0f;
    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final FileConfiguration config;
    private final float initialWalkSpeed;
    private final double walkSpeedMultiplier;

    public StoneGreaterInertiaTask(BaubleModule module, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.plugin = plugin;
        this.initialWalkSpeed = rsvPlayer.getPlayer().getWalkSpeed();
        this.walkSpeedMultiplier = config.getDouble("Items.stone_greater_inertia.WalkSpeedMultiplier");
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (player == null) {
            tasks.remove(id);
            cancel();
        }
        else {
            if (player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                if (rsvPlayer.getBaubleDataModule().hasBauble("stone_greater_inertia")) {
                    player.setWalkSpeed((float) Math.min(initialWalkSpeed * walkSpeedMultiplier, MAX_WALK_SPEED));
                }
                // if the player doesn't have rings of res in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    player.setWalkSpeed(initialWalkSpeed);
                    tasks.remove(id);
                    cancel();
                }
            }
            else {
                player.setWalkSpeed(initialWalkSpeed);
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Items.stone_negative_gravity.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, StoneGreaterInertiaTask> getTasks() {
        return tasks;
    }
}
