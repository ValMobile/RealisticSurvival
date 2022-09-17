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
package me.val_mobile.utils;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;

public abstract class Breath extends BukkitRunnable {

    private final Utils util = RealisticSurvivalPlugin.getUtil();
    private final Dragon dragon;
    private final Vector velocity;
    private final World world;
    private Location loc;
    private final Particle particle;
    private final int radius;
    private final int decayTicks;
    protected final RealisticSurvivalPlugin plugin;
    protected final FileConfiguration config;
    private int ticks = 0;

    public Breath(Dragon dragon, Location target, RealisticSurvivalPlugin plugin) {
        CraftEntity e = dragon.getBukkitEntity();
        this.dragon = dragon;
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

        String capitalizeBreed = StringUtils.capitalize(dragon.getBreed().toString().toLowerCase());

        int stage = dragon.getStage();
        double magnitude = config.getInt("Dragons." + capitalizeBreed + "Dragon.BreathAttack.Velocity");

        this.plugin = plugin;
        this.loc = e.getLocation();
        this.world = loc.getWorld();
        this.velocity = loc.toVector().subtract(target.toVector()).normalize().multiply(magnitude * stage);
        this.radius = config.getInt("Dragons." + capitalizeBreed + "Dragon.BreathAttack.Radius") * stage;
        this.particle = Particle.valueOf(config.getString("Dragons." + capitalizeBreed + "Dragon.BreathAttack.Particle"));
        this.decayTicks = config.getInt("Dragons." + capitalizeBreed + "Dragon.BreathAttack.DespawnTime");
    }

    @Override
    public final void run() {
        // if the flame trail intersects a liquid or solid block
        if (!(loc.getBlock().isEmpty())) {
            Location newLoc = loc.clone(); // get the flame trail's location

            // while the block at the location is solid
            while (!(newLoc.getBlock().isEmpty())) {
                // iterate 1 block at a time until an air block is reached
                newLoc.setY(newLoc.getY() + 1D);
                if (newLoc.getBlock().isEmpty()) {
                    break;
                }
                if (loc.toVector().distance(newLoc.toVector()) > radius) {
                    break;
                }

            }
            // iterate over the surrounding area of the impact location
            grief(newLoc, radius);
            // auto-cancel
            cancel();
        }
        // iterate ticks
        ticks++;

        // if flame trail has traveled for too long, cancel
        if (ticks > decayTicks) {
            cancel();
        }

        // begin checking for trail-entity collisions
        if (ticks > 10) {
            Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius, radius, radius); // get the entities
            // if the flame trail intersects an entity
            if (!collection.isEmpty()) {
                // check every entity
                for (Entity e : collection) {
                    // if the entity can be hurt
                    if (e instanceof LivingEntity) {
                        // check if entity is not a dragon
                        if (util.hasNbtTag(e, "rsvmob")) {
                            if (!util.getNbtTag(e, "rsvmob", PersistentDataType.STRING).equals(util.getNbtTag(dragon.getBukkitEntity(), "rsvmob", PersistentDataType.STRING))) {
                                dragon.performMeleeAttack((LivingEntity) e);
                            }
                        }
                        else {
                            dragon.performMeleeAttack((LivingEntity) e);
                        }
                    }
                }
            }
        }

        // summon a flame particle
        world.spawnParticle(particle, loc, 5, 0.1, 0.1, 0.1, 0, null, true);

        // update location values
        loc.setX(loc.getX() + velocity.getX());
        loc.setY(loc.getY() + velocity.getY());
        loc.setZ(loc.getZ() + velocity.getZ());
    }

    public abstract void grief(Location center, int radius);

    public final void start() {
        this.runTaskTimer(plugin, 0, 1);
    }
}
