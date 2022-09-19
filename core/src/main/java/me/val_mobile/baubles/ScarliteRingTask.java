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

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class ScarliteRingTask extends BukkitRunnable {

    private static final HashMap<UUID, ScarliteRingTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();
    private double defaultHealAmount = config.getDouble("Items.scarlite_ring.HealAmount");

    public ScarliteRingTask(RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;
        tasks.put(rsvPlayer.getPlayer().getUniqueId(), this);
    }

    @Override
    public void run() {
        boolean hasBauble = ((DataModule) rsvPlayer.getDataModuleFromName("Baubles")).hasBauble("scarlite_ring");

        if (hasBauble) {
            // effect the player with resistance
            Player p = rsvPlayer.getPlayer();
            double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            double currentHealth = p.getHealth();
            double dif =  maxHealth - currentHealth;
            if (dif < defaultHealAmount) {
                p.setHealth(maxHealth);
            }
            else {
                p.setHealth(currentHealth + defaultHealAmount);
            }
        }
        // if the player doesn't have rings of res in his/her inventory
        else {
            // update static hashmap values and cancel the runnable
            tasks.remove(rsvPlayer.getPlayer().getUniqueId());
            cancel();
        }
    }

    public void start() {
        FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();

        int tickSpeed = config.getInt("Items.scarlite_ring.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static HashMap<UUID, ScarliteRingTask> getTasks() {
        return tasks;
    }
}
