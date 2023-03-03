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
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UnfreezeTask extends BukkitRunnable {

    private static final Map<UUID, UnfreezeTask> tasks = new HashMap<>();
    private final int pause;
    private final Collection<FrozenBlock> blocks;
    private final RealisticSurvivalPlugin plugin;
    private final Entity entity;
    private final boolean wasOriginallyFrozen;

    public UnfreezeTask(RealisticSurvivalPlugin plugin, Entity entity, Collection<FrozenBlock> blocks, int pause, boolean wasOriginallyFrozen) {
        this.blocks = blocks;
        this.plugin = plugin;
        this.pause = pause;
        this.entity = entity;
        this.wasOriginallyFrozen = wasOriginallyFrozen;
        tasks.put(entity.getUniqueId(), this);
    }

    @Override
    public void run() {
        for (FrozenBlock block : blocks) {
            block.getBlock().remove();
        }

        if (entity instanceof LivingEntity && !wasOriginallyFrozen) {
            ((LivingEntity) entity).setAI(true);
        }
        tasks.remove(entity.getUniqueId());
    }

    public void start() {
        runTaskLater(plugin, pause);
    }

    public static Map<UUID, UnfreezeTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
