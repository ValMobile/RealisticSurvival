/*
    Copyright (C) 2024  Val_Mobile

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
package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.rsv.RSVPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ElectrocuteTask extends BukkitRunnable {

    private static final Map<UUID, ElectrocuteTask> tasks = new HashMap<>();
    private final Damageable entity;
    private final RSVPlugin plugin;
    private final FileConfiguration config;
    private final double shockDamage;
    private int shockAmount;
    private final int tickPeriod;


    public ElectrocuteTask(RSVPlugin plugin, int stage, Damageable entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
        this.shockDamage = config.getDouble("Dragon.LightningDragon.ElectrocuteAbility.ShockDamage.Stage" + stage);
        this.shockAmount = config.getInt("Dragon.LightningDragon.ElectrocuteAbility.ShockAmount.Stage" + stage);
        this.tickPeriod = config.getInt("Dragon.LightningDragon.ElectrocuteAbility.TickPeriod");
        tasks.put(entity.getUniqueId(), this);
    }

    public ElectrocuteTask(RSVPlugin plugin, RSVModule module, String itemName, Damageable entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.shockDamage = config.getDouble("Items." + itemName + ".ElectrocuteAbility.ShockDamage");
        this.shockAmount = config.getInt("Items." + itemName + ".ElectrocuteAbility.ShockAmount");
        this.tickPeriod = config.getInt("Items." + itemName + ".ElectrocuteAbility.TickPeriod");
        tasks.put(entity.getUniqueId(), this);
    }

    @Override
    public void run() {
        if (shockAmount > 0 || entity.isDead()) {
            entity.damage(shockDamage);
            shockAmount--;
        }
        else {
            tasks.remove(entity.getUniqueId());
            cancel();
        }
    }

    public void start() {
        runTaskTimer(plugin, 0L, tickPeriod);
    }

    public static Map<UUID, ElectrocuteTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }
}
