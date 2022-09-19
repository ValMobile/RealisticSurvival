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
package me.val_mobile.iceandfire;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class InfernoTask extends BukkitRunnable {

    private final RealisticSurvivalPlugin plugin;
    private final Entity entity;
    private int ticks;

    public InfernoTask(Entity entity, int ticks, RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        this.entity = entity;
        this.ticks = ticks;
    }

    @Override
    public void run() {
        if (entity.getFireTicks() < ticks) {
            entity.setFireTicks(ticks);
        }
        ticks--;
        if (ticks < 0 || entity.isDead()) {
            cancel();
        }
    }

    public void start() {
        this.runTaskTimer(plugin, 0, 1);
    }
}
