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
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScarliteRingTask extends BukkitRunnable {

    private static final Map<UUID, ScarliteRingTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final double defaultHealAmount;

    public ScarliteRingTask(BaubleModule module, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.plugin = plugin;
        this.defaultHealAmount = config.getDouble("Items.scarlite_ring.HealAmount");
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
            if (player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                if (rsvPlayer.getBaubleDataModule().hasBauble("scarlite_ring")) {
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
                    tasks.remove(id);
                    cancel();
                }
            }
            else {
                tasks.remove(id);
                cancel();
            }
        }

    }

    public void start() {
        int tickPeriod = config.getInt("Items.scarlite_ring.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, ScarliteRingTask> getTasks() {
        return tasks;
    }
}
