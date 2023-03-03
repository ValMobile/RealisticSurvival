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

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVTask;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BrokenHeartRepairTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, BrokenHeartRepairTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final Collection<String> allowedWorlds;
    private final boolean sleepRepairEnabled;
    private final int durabilityChange;
    private final int duration;

    private int ticks = 0;

    public BrokenHeartRepairTask(RealisticSurvivalPlugin plugin, BaubleModule module, RSVPlayer rsvPlayer) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.plugin = plugin;
        FileConfiguration config = module.getUserConfig().getConfig();
        this.duration = config.getInt("Items.broken_heart.SleepRepair.Duration");
        this.sleepRepairEnabled = config.getBoolean("Items.broken_heart.SleepRepair.Enabled");
        this.durabilityChange = config.getInt("Items.broken_heart.SleepRepair.Amount");
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (conditionsMet(player)) {
            ticks++;

            if (ticks > duration) {
                ItemStack brokenHeart = rsvPlayer.getBaubleDataModule().getBaubleBag().getItem("broken_heart");
                Utils.changeDurability(brokenHeart, durabilityChange, false);

                stop();
            }
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && rsvPlayer.getBaubleDataModule().hasBauble("broken_heart") && sleepRepairEnabled && player.isSleeping() && allowedWorlds.contains(player.getWorld().getName());
    }

    @Override
    public void start() {
        runTaskTimer(plugin, 0L, 1);
    }

    @Override
    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public static Map<UUID, BrokenHeartRepairTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
