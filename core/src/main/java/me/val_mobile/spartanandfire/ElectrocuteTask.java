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
package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ElectrocuteTask extends BukkitRunnable {

    private static Map<UUID, ElectrocuteTask> tasks = new HashMap<>();
    private final Damageable entity;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final double shockDamage;
    private int shockAmount;
    private final int tickSpeed;


    public ElectrocuteTask(RealisticSurvivalPlugin plugin, int stage, Damageable entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
        int stageMultiplier = config.getInt("Dragons.LightningDragon.ElectrocuteAbility.StageMultipliers.Stage" + stage);
        this.shockDamage = config.getDouble("Dragons.LightningDragon.ElectrocuteAbility.ShockDamage") * stageMultiplier;
        this.shockAmount = config.getInt("Dragons.LightningDragon.ElectrocuteAbility.ShockAmount") * stageMultiplier;
        this.tickSpeed = config.getInt("Dragons.LightningDragon.ElectrocuteAbility.TickSpeed");
        tasks.put(entity.getUniqueId(), this);
    }

    public ElectrocuteTask(RealisticSurvivalPlugin plugin, RSVModule module, String itemName, Damageable entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.shockDamage = config.getDouble("Items." + itemName + ".ElectrocuteAbility.ShockDamage");
        this.shockAmount = config.getInt("Items." + itemName + ".ElectrocuteAbility.ShockAmount");
        this.tickSpeed = config.getInt("Items." + itemName + ".ElectrocuteAbility.TickSpeed");
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
        runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static Map<UUID, ElectrocuteTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
