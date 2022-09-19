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
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class BrokenHeartRepairTask extends BukkitRunnable {

    private static HashMap<UUID, BrokenHeartRepairTask> tasks = new HashMap<>();
    private static HashMap<UUID, Long> players = new HashMap<>();

    private final RSVPlayer player;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final int duration;

    private final long beginningTime;
    private long elapsed = 0;

    public BrokenHeartRepairTask(RealisticSurvivalPlugin plugin, BaubleModule module, RSVPlayer player) {
        this.beginningTime = System.currentTimeMillis();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.duration = config.getInt("Items.broken_heart.SleepRepair.Duration");

        tasks.put(player.getPlayer().getUniqueId(), this);
    }

    @Override
    public void run() {
        if (!players.containsKey(id)) {
            cancel();
        }
        elapsed = players.get(id) - beginningTime;

        if (elapsed > duration) {
            ItemStack brokenHeart = ((DataModule) player.getDataModuleFromName(BaubleModule.NAME)).getBaubleBag().getItem("broken_heart");
            Utils.changeDurability(brokenHeart, config.getInt("Items.broken_heart.SleepRepair.Amount"));

            players.remove(id);
            tasks.remove(id);
            cancel();
        }
    }

    public void start() {
        runTaskTimer(plugin, 0L, 1);
    }

    public static HashMap<UUID, Long> getPlayers() {
        return players;
    }

    public static HashMap<UUID, BrokenHeartRepairTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
