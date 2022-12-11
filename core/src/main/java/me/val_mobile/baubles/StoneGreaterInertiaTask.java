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
import me.val_mobile.utils.RSVTask;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StoneGreaterInertiaTask extends BukkitRunnable implements RSVTask {

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

        if (conditionsMet(player)) {
            player.setWalkSpeed((float) Math.min(initialWalkSpeed * walkSpeedMultiplier, MAX_WALK_SPEED));
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName()) && rsvPlayer.getBaubleDataModule().hasBauble("stone_greater_inertia");
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Items.stone_negative_gravity.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        if (rsvPlayer.getPlayer() != null) {
            rsvPlayer.getPlayer().setWalkSpeed(initialWalkSpeed);
        }
        tasks.remove(id);
        cancel();
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
