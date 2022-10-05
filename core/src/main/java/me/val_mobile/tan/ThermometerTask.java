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
package me.val_mobile.tan;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static me.val_mobile.tan.TemperatureCalculateTask.MAXIMUM_TEMPERATURE;
import static me.val_mobile.tan.TemperatureCalculateTask.MINIMUM_TEMPERATURE;

public class ThermometerTask extends BukkitRunnable {

    private static final Map<UUID, ThermometerTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final TemperatureCalculateTask task;
    private double equilibriumTemp;
    private final Location originalCompassTarget;


    public ThermometerTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.task = TemperatureCalculateTask.getTasks().get(id);
        this.originalCompassTarget = player.getPlayer().getCompassTarget();
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        if (player == null) {
            // update static hashmap values and cancel the runnable
            tasks.remove(id);
            cancel();
        }
        // if the player is in creative or spectator
        else {
            GameMode mode = player.getGameMode(); // get the gamemode

            if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && player.isOnline() && allowedWorlds.contains(player.getWorld().getName()) && task != null) {
                equilibriumTemp = task.getEquilibriumTemp();

                if (equilibriumTemp > MAXIMUM_TEMPERATURE) {
                    equilibriumTemp = MAXIMUM_TEMPERATURE;
                }
                if (equilibriumTemp < MINIMUM_TEMPERATURE) {
                    equilibriumTemp = MINIMUM_TEMPERATURE;
                }

                Location loc = player.getEyeLocation();

                double rad = Math.PI * (1D - equilibriumTemp/MAXIMUM_TEMPERATURE);

                double horizontal = Math.cos(rad) * 1000;
                double vertical = Math.sin(rad) * 1000;

                Vector dir = new Vector(horizontal, loc.getY(), vertical).rotateAroundY(Math.toRadians(loc.getYaw()));
                loc.add(dir);
                player.setCompassTarget(loc);
            }
            // if the player is in creative or spectator
            else {
                // update static hashmap values and cancel the runnable
                tasks.remove(id);
                player.setCompassTarget(originalCompassTarget);
                cancel();
            }
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Items.thermometer.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 1L, tickSpeed);
    }

    private boolean isHoldingThermometer() {
        ItemStack itemMainHand = player.getPlayer().getInventory().getItemInMainHand();

        if (RSVItem.isRSVItem(itemMainHand)) {
            return RSVItem.getNameFromItem(itemMainHand).equals("thermometer");
        }

        return false;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }


    public static Map<UUID, ThermometerTask> getTasks() {
        return tasks;
    }
}
