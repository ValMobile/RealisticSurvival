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
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StoneNegativeGravityTask extends BukkitRunnable {

    private static final Map<UUID, StoneNegativeGravityTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final FileConfiguration config;
    private final double maxDownwardVelocity;
    private final double maxUpwardVelocity;
    private final boolean wasGravityInitiallyOn;
    private final boolean reenableGravity;

    public StoneNegativeGravityTask(BaubleModule module, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
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

        if (player == null) {
            tasks.remove(id);
            cancel();
        }
        else {
            if (player.isOnline() && allowedWorlds.contains(player.getWorld().getName()) && (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE)) {
                if (rsvPlayer.getBaubleDataModule().hasBauble("stone_negative_gravity") || isHoldingStone()) {
                    player.setGravity(false);

                    boolean isUnstable = isHoldingStone();

                    if (isUnstable)
                        player.setVelocity(player.getVelocity().setY(Utils.getRandomNum(maxDownwardVelocity, maxUpwardVelocity)));
                }
                // if the player doesn't have rings of res in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    if (reenableGravity) {
                        player.setGravity(true);
                    }
                    else {
                        player.setGravity(wasGravityInitiallyOn);
                    }
                    tasks.remove(id);
                    cancel();
                }
            }
            else {
                if (reenableGravity) {
                    player.setGravity(true);
                }
                else {
                    player.setGravity(wasGravityInitiallyOn);
                }
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void start() {
        int tickPeriod = config.getInt("Items.stone_negative_gravity.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, StoneNegativeGravityTask> getTasks() {
        return tasks;
    }

    private boolean isHoldingStone() {
        Player player = rsvPlayer.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (RSVItem.isRSVItem(item)) {
            return RSVItem.getNameFromItem(item).equals("stone_negative_gravity");
        }

        return false;
    }
}
