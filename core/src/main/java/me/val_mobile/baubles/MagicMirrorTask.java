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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVModule;
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

public class MagicMirrorTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, MagicMirrorTask> tasks = new HashMap<>();
    private final RSVPlugin plugin;
    private final UUID id;
    private int ticks = 0;
    private final int duration;
    private final int tickPeriod;

    public MagicMirrorTask(Player player, RSVPlugin plugin) {
        this.id = player.getUniqueId();
        this.plugin = plugin;
        FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();
        this.duration = config.getInt("Items.magic_mirror.Cooldown");
        this.tickPeriod = config.getInt("Items.magic_mirror.TickPeriod"); // get the tick period
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

    public static Map<UUID, MagicMirrorTask> getTasks() {
        return tasks;
    }
}
