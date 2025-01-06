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

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVTask;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WormholeMirrorTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, WormholeMirrorTask> tasks = new HashMap<>();
    private final RSVPlugin plugin;
    private final UUID id;
    private int ticks;
    private final int duration;
    private final int tickPeriod;

    public WormholeMirrorTask(BaubleModule module, Player player, RSVPlugin plugin) {
        this.id = player.getUniqueId();
        this.plugin = plugin;
        FileConfiguration config = module.getUserConfig().getConfig();
        this.duration = config.getInt("Items.wormhole_mirror.Cooldown");
        this.tickPeriod = config.getInt("Items.wormhole_mirror.TickPeriod"); // get the tick period
        tasks.put(id, this);
    }

    @Override
    public void run() {
        if (conditionsMet(Bukkit.getPlayer(id))) {
            ticks += tickPeriod;
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return player != null && ticks < duration;
    }

    @Override
    public void start() {
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

    public static Map<UUID, WormholeMirrorTask> getTasks() {
        return tasks;
    }
}
