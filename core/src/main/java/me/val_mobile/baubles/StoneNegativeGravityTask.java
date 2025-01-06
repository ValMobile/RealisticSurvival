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

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVTask;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StoneNegativeGravityTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, StoneNegativeGravityTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final RSVPlugin plugin;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final FileConfiguration config;
    private final double maxDownwardVelocity;
    private final double maxUpwardVelocity;
    private final boolean wasGravityInitiallyOn;
    private final boolean reenableGravity;

    public StoneNegativeGravityTask(BaubleModule module, RSVPlayer rsvPlayer, RSVPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.plugin = plugin;
        this.wasGravityInitiallyOn = rsvPlayer.getPlayer().hasGravity();
        this.reenableGravity = config.getBoolean("Items.stone_negative_gravity.ReenableGravity");
        this.maxDownwardVelocity = config.getDouble("Items.stone_negative_gravity.Instability.MaxDownwardVelocity");
        this.maxUpwardVelocity = config.getDouble("Items.stone_negative_gravity.Instability.MaxUpwardVelocity");
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (conditionsMet(player)) {
            player.setGravity(false);

            if (RSVItem.isHoldingItemInMainHand("stone_negative_gravity", player))
                player.setVelocity(player.getVelocity().setY(Utils.getRandomNum(maxDownwardVelocity, maxUpwardVelocity)));
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName()) && (rsvPlayer.getBaubleDataModule().hasBauble("stone_negative_gravity") || RSVItem.isHoldingItemInMainHand("stone_negative_gravity", player));
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Items.stone_negative_gravity.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        if (rsvPlayer.getPlayer() != null) {
            if (reenableGravity) {
                rsvPlayer.getPlayer().setGravity(true);
            }
            else {
                rsvPlayer.getPlayer().setGravity(wasGravityInitiallyOn);
            }
        }
        tasks.remove(id);
        cancel();
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }

    public static Map<UUID, StoneNegativeGravityTask> getTasks() {
        return tasks;
    }
}
