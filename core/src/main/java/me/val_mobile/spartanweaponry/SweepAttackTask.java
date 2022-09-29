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
package me.val_mobile.spartanweaponry;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.beans.PersistenceDelegate;
import java.util.ArrayList;
import java.util.List;

public class SweepAttackTask extends BukkitRunnable {

    private final RealisticSurvivalPlugin plugin;
    private final List<Entity> nearby;
    private final List<Entity> attacked = new ArrayList<>();
    private final Entity attacker;
    private final Entity defender;
    private final double damage;

    public SweepAttackTask(RealisticSurvivalPlugin plugin, List<Entity> nearby, Entity attacker, Entity defender, double damage) {
        this.plugin = plugin;
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.nearby = nearby;
    }

    @Override
    public void run() {
        Location eLoc;
        Location defLoc = defender.getLocation();
        for (Entity e : nearby) {
            if (!(e.getUniqueId().equals(attacker.getUniqueId()) || e.getUniqueId().equals(defender.getUniqueId()))) {
                if (e instanceof LivingEntity) {
                    eLoc = e.getLocation();
                    if (Math.abs(eLoc.getY() - defLoc.getY()) <= 0.25) {
                        if (Math.hypot(eLoc.getX() - defLoc.getX(), eLoc.getZ() - defLoc.getZ()) <= 1.0) {
                            if (!RealisticSurvivalPlugin.getUtil().hasNbtTag(e, "sweepimmune")) {
                                ((LivingEntity) e).damage(damage, attacker);
                                attacked.add(e);
                                RealisticSurvivalPlugin.getUtil().addNbtTag(e, "sweepimmune", 0, PersistentDataType.INTEGER);
                            }
                        }
                    }
                }
            }
        }
        removeImmunity();
    }

    public void start() {
        runTask(plugin);
    }

    private void removeImmunity() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Entity e : attacked) {
                    e.getPersistentDataContainer().remove(new NamespacedKey(plugin, "sweepimmune"));
                }
            }
        }.runTaskLater(plugin, 1L);
    }
}
