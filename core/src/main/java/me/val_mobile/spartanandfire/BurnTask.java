/*
    Copyright (C) 2023  Val_Mobile

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
package me.val_mobile.spartanandfire;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BurnTask extends BukkitRunnable {

    private static final Map<UUID, BurnTask> tasks = new HashMap<>();
    private final Entity entity;
    private final RealisticSurvivalPlugin plugin;
    private int fireTicks;
    private final int tickPeriod;


    public BurnTask(RealisticSurvivalPlugin plugin, Entity entity, int fireTicks, int tickPeriod) {
        this.entity = entity;
        this.plugin = plugin;
        this.fireTicks = fireTicks;
        this.tickPeriod = tickPeriod;
        tasks.put(entity.getUniqueId(), this);
    }

    @Override
    public void run() {
        if (fireTicks > 0 || entity.isDead()) {
            // if the entity is going to burn for less than the specified fire ticks
            if (entity.getFireTicks() < fireTicks) {
                // set the entity on fire
                entity.setFireTicks(fireTicks);
                fireTicks -= tickPeriod;
            }
        }
        else {
            tasks.remove(entity.getUniqueId());
            cancel();
        }
    }

    public void start() {
        runTaskTimer(plugin, 0L, tickPeriod);
    }

    public static Map<UUID, BurnTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
