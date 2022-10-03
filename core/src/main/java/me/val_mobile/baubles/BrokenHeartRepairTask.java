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
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class BrokenHeartRepairTask extends BukkitRunnable {

    private static HashMap<UUID, BrokenHeartRepairTask> tasks = new HashMap<>();
    private static HashMap<UUID, Long> players = new HashMap<>();

    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final Collection<String> allowedWorlds;
    private final int duration;

    private final long beginningTime;
    private long elapsed = 0;

    public BrokenHeartRepairTask(RealisticSurvivalPlugin plugin, BaubleModule module, RSVPlayer rsvPlayer) {
        this.beginningTime = System.currentTimeMillis();
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.duration = config.getInt("Items.broken_heart.SleepRepair.Duration");

        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (player == null) {
            players.remove(id);
            tasks.remove(id);
            cancel();
        }
        else {
            if (player.isOnline() && !player.isDead() && allowedWorlds.contains(player.getWorld().getName())) {
                elapsed = players.get(id) - beginningTime;

                if (elapsed > duration) {
                    ItemStack brokenHeart = rsvPlayer.getBaubleDataModule().getBaubleBag().getItem("broken_heart");
                    Utils.changeDurability(brokenHeart, config.getInt("Items.broken_heart.SleepRepair.Amount"), false);

                    players.remove(id);
                    tasks.remove(id);
                    cancel();
                }
            }
            else {
                players.remove(id);
                tasks.remove(id);
                cancel();
            }
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
