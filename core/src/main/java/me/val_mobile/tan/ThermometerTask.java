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
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import static me.val_mobile.tan.TemperatureCalculateTask.MAXIMUM_TEMPERATURE;
import static me.val_mobile.tan.TemperatureCalculateTask.MINIMUM_TEMPERATURE;

public class ThermometerTask extends BukkitRunnable {

    private final static HashMap<UUID, ThermometerTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final TemperatureCalculateTask task;
    private double equilibriumTemp;


    public ThermometerTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.task = TemperatureCalculateTask.getTasks().get(player.getPlayer().getUniqueId());
        tasks.put(player.getPlayer().getUniqueId(), this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        GameMode mode = player.getGameMode(); // get the gamemode

        if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE || !player.isOnline() && allowedWorlds.contains(player.getWorld().getName()) && isHoldingThermometer()) {
            equilibriumTemp = task.getEquilibriumTemp();

            if (equilibriumTemp > MAXIMUM_TEMPERATURE) {
                equilibriumTemp = MAXIMUM_TEMPERATURE;
            }
            if (equilibriumTemp < MINIMUM_TEMPERATURE) {
                equilibriumTemp = MINIMUM_TEMPERATURE;
            }

            Location loc = player.getLocation();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            CompassMeta meta = (CompassMeta) itemMainHand.getItemMeta();

            double rad = Math.PI * (1D - equilibriumTemp/MAXIMUM_TEMPERATURE);

            double horizontal = Math.cos(rad) * 1000;
            double vertical = Math.sin(rad) * 1000;

            Vector dir = new Vector(horizontal, 0, vertical).rotateAroundX(Math.toRadians(loc.getYaw()) + Math.PI/2);

            meta.setLodestone(loc.add(dir));
            itemMainHand.setItemMeta(meta);
        }
        // if the player is in creative or spectator
        else {
            // update static hashmap values and cancel the runnable
            tasks.remove(player.getUniqueId());
            cancel();
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Items.thermometer.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 1L, tickSpeed);
    }

    private boolean isHoldingThermometer() {
        ItemStack itemMainHand = player.getPlayer().getInventory().getItemInMainHand();

        if (RSVItem.isRSVItem(itemMainHand)) {
            if (RSVItem.getNameFromItem(itemMainHand).equals("thermometer")) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }


    public static HashMap<UUID, ThermometerTask> getTasks() {
        return tasks;
    }
}