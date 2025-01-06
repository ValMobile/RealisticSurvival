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
package me.val_mobile.spartanweaponry;

import me.val_mobile.rsv.RSVPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class SweepAttackTask extends BukkitRunnable {

    private static final Collection<UUID> mobs = new ArrayList<>();
    private final RSVPlugin plugin;
    private final List<Entity> nearby;
    private final List<UUID> attacked = new ArrayList<>();
    private final Entity attacker;
    private final Entity defender;
    private final double damage;
    private final boolean checkPet;

    public SweepAttackTask(RSVPlugin plugin, List<Entity> nearby, Entity attacker, Entity defender, double damage, boolean checkPet) {
        this.plugin = plugin;
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.nearby = nearby;
        this.checkPet = checkPet;
    }

    @Override
    public void run() {
        Location eLoc;
        Location defLoc = defender.getLocation();
        for (Entity e : nearby) {
            if (!(e.getUniqueId().equals(attacker.getUniqueId()) || e.getUniqueId().equals(defender.getUniqueId()))) {
                if (e instanceof LivingEntity living) {
                    if (!(isPet(living) && checkPet)) {
                        eLoc = living.getLocation();
                        if (Math.abs(eLoc.getY() - defLoc.getY()) <= 0.25) {
                            if (Math.hypot(eLoc.getX() - defLoc.getX(), eLoc.getZ() - defLoc.getZ()) <= 1.0) {
                                UUID id = living.getUniqueId();
                                if (!mobs.contains(id)) {
                                    living.damage(damage, attacker);
                                    mobs.add(id);
                                    attacked.add(id);
                                }
                            }
                        }
                    }
                }
            }
        }
        removeImmunity();
    }

    private boolean isPet(LivingEntity entity) {
        if (entity instanceof Tameable tameable) {
            Player owner = (Player) tameable.getOwner();

            if (owner != null) {
                return owner.getUniqueId().equals(attacker.getUniqueId());
            }
        }
        return false;
    }

    public void start() {
        runTask(plugin);
    }

    private void removeImmunity() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID id : attacked) {
                    mobs.remove(id);
                }
            }
        }.runTaskLater(plugin, 1L);
    }
}
