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
import me.val_mobile.utils.RSVTask;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static me.val_mobile.tan.TemperatureCalculateTask.MAXIMUM_TEMPERATURE;
import static me.val_mobile.tan.TemperatureCalculateTask.MINIMUM_TEMPERATURE;

public class ThermometerTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, ThermometerTask> tasks = new HashMap<>();
    private final FileConfiguration config;
    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final TemperatureCalculateTask task;
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

        if (conditionsMet(player)) {
            double equilibriumTemp = task.getEquilibriumTemp();

            if (equilibriumTemp > MAXIMUM_TEMPERATURE) {
                equilibriumTemp = MAXIMUM_TEMPERATURE;
            }
            if (equilibriumTemp < MINIMUM_TEMPERATURE) {
                equilibriumTemp = MINIMUM_TEMPERATURE;
            }

            Location loc = player.getEyeLocation();

            double rad = Math.PI * ((MAXIMUM_TEMPERATURE / 2D) - equilibriumTemp) / MAXIMUM_TEMPERATURE;

            Vector dir = loc.getDirection().normalize();
            dir.rotateAroundY(rad).multiply(1000);
            loc.add(dir);
            player.setCompassTarget(loc);
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName()) && task != null && isHoldingThermometer(player);
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Items.thermometer.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 1L, tickPeriod);
    }

    @Override
    public void stop() {
        if (player.getPlayer() != null) {
            player.getPlayer().setCompassTarget(originalCompassTarget);
        }

        tasks.remove(id);
        cancel();
    }

    public static boolean isHoldingThermometer(Player player) {
        PlayerInventory inv = player.getPlayer().getInventory();
        ItemStack itemMainHand = inv.getItemInMainHand();
        ItemStack itemOffHand = inv.getItemInOffHand();
        boolean isHolding = false;

        if (RSVItem.isRSVItem(itemMainHand)) {
            isHolding = RSVItem.getNameFromItem(itemMainHand).equals("thermometer");
        }

        if (RSVItem.isRSVItem(itemOffHand)) {
            isHolding = isHolding || RSVItem.getNameFromItem(itemOffHand).equals("thermometer");
        }

        return isHolding;
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
