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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;
import java.util.function.Predicate;

public abstract class GenericBreath extends BukkitRunnable {

    protected final Set<String> immuneBlocks;
    protected final Map<String, String[]> specialBlocks = new HashMap<>();
    protected final EnderDragon dragon;
    protected final Vector velocity;
    protected final World world;
    protected final Location loc;
    protected final Particle particle;
    protected final double radius;
    protected final int decayTicks;
    protected final RealisticSurvivalPlugin plugin;
    protected final FileConfiguration config;
    protected int ticks = 0;

    public GenericBreath(EnderDragon dragon, Location target, RealisticSurvivalPlugin plugin, BreathType type) {
        this.dragon = dragon;
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

        String breed = StringUtils.capitalize(DragonUtils.getBreed(dragon).toString().toLowerCase());
        String prefix = StringUtils.capitalize(type.toString().toLowerCase());

        int stage = DragonUtils.getStage(dragon);
        double magnitude = config.getInt("Dragons." + breed + "Dragon." + prefix + "Attack.Velocity");


        this.plugin = plugin;
        this.loc = dragon.getLocation().clone();
        this.world = loc.getWorld();
        this.velocity = target.toVector().subtract(dragon.getLocation().toVector()).normalize().multiply(magnitude * stage * 1D/20);
        this.radius = config.getInt("Dragons." + breed + "Dragon." + prefix + "Attack.Radius") * stage;
        this.particle = Particle.valueOf(config.getString("Dragons." + breed + "Dragon." + prefix + "Attack.Particle"));
        this.decayTicks = config.getInt("Dragons." + breed + "Dragon." + prefix + "Attack.DespawnTime");

        this.immuneBlocks = Set.copyOf(config.getStringList("Dragons." + breed + "Dragon." + prefix + "Attack.ImmuneBlocks"));
        List<String> specialBlocks = config.getStringList("Dragons." + breed + "Dragon." + prefix + "Attack.SpecialBlocks");

        if (!specialBlocks.isEmpty()) {
            for (String entry : specialBlocks) {
                String[] split = entry.split(":");
                String key = split[0];
                String[] results = split[1].split(",");
                this.specialBlocks.put(key, results);
            }
        }

        String generation = StringUtils.capitalize(DragonGeneration.getGeneration(DragonUtils.getAge(dragon)).toString().toLowerCase());
        ConfigurationSection section = config.getConfigurationSection("Dragons." + breed + "Dragon." + prefix + "Attack.Sound." + generation);

        if (section != null) {
            if (section.getBoolean("Enabled")) {
                Utils.playSound(loc, section.getString("Sound"), (float) section.getDouble("Volume"), (float) section.getDouble("Pitch"));
            }
        }
    }


    public GenericBreath(Dragon dragon, Location target, RealisticSurvivalPlugin plugin, BreathType type) {
        this.dragon = (EnderDragon) dragon.getEntity();
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

        String breed = StringUtils.capitalize(dragon.getBreed().toString().toLowerCase());
        String prefix = StringUtils.capitalize(type.toString().toLowerCase());

        int stage = dragon.getStage();
        double magnitude = config.getInt("Dragons." + breed + "Dragon." + prefix + "Attack.Velocity");

        this.plugin = plugin;
        this.loc = dragon.getEntity().getLocation().clone();
        this.world = loc.getWorld();
        this.velocity = target.toVector().subtract(dragon.getEntity().getLocation().toVector()).normalize().multiply(magnitude * stage * 1D/20);
        this.radius = config.getInt("Dragons." + breed + "Dragon." + prefix + "Attack.Radius") * stage;
        this.particle = Particle.valueOf(config.getString("Dragons." + breed + "Dragon." + prefix + "Attack.Particle"));
        this.decayTicks = config.getInt("Dragons." + breed + "Dragon." + prefix + "Attack.DespawnTime");

        this.immuneBlocks = Set.copyOf(config.getStringList("Dragons." + breed + "Dragon." + prefix + "Attack.ImmuneBlocks"));
        List<String> specialBlocks = config.getStringList("Dragons." + breed + "Dragon." + prefix + "Attack.SpecialBlocks");

        if (!specialBlocks.isEmpty()) {
            for (String entry : specialBlocks) {
                String[] split = entry.split(":");
                String key = split[0];
                String[] results = split[1].split(",");
                this.specialBlocks.put(key, results);
            }
        }

        String generation = StringUtils.capitalize(DragonGeneration.getGeneration(dragon.getAge()).toString().toLowerCase());
        ConfigurationSection section = config.getConfigurationSection("Dragons." + breed + "Dragon." + prefix + "Attack.Sound." + generation);

        if (section != null) {
            if (section.getBoolean("Enabled")) {
                Utils.playSound(loc, section.getString("Sound"), (float) section.getDouble("Volume"), (float) section.getDouble("Pitch"));
            }
        }
    }

    @Override
    public void run() {
        // if the trail intersects a liquid or solid block
        if (!loc.getBlock().isEmpty()) {
            Location newLoc = loc.clone(); // get the trail's location

            // while the block at the location is solid
            while (!newLoc.getBlock().isEmpty()) {
                // iterate 1 block at a time until an air block is reached
                newLoc.setY(newLoc.getY() + 1D);
                if (newLoc.getBlock().isEmpty()) {
                    break;
                }
                if (loc.toVector().distanceSquared(newLoc.toVector()) > radius * radius) {
                    break;
                }

            }
            // iterate over the surrounding area of the impact location
            grief(newLoc, (int) radius);
            // auto-cancel
            stop();
        }
        // iterate ticks
        ticks++;
        // if trail has traveled for too long, cancel
        if (ticks > decayTicks) {
            stop();
        }

        // begin checking for trail-entity collisions
        if (ticks > 10) {
            Predicate<Entity> filter = entity -> !(entity.getUniqueId().equals(dragon.getUniqueId()) || (RSVMob.isMob(entity) && RSVMob.getMob(entity).equals(RSVMob.getMob(dragon))));
            Collection<Entity> collection = world.getNearbyEntities(loc, radius, radius, radius, filter); // get the entities
            // if the flame trail intersects an entity
            if (!collection.isEmpty()) {
                // check every entity
                for (Entity e : collection) {
                    // if the entity can be hurt
                    if (e instanceof LivingEntity living) {
                        DragonUtils.performSpecialAbility(dragon, living);
                    }
                }
            }
        }

        // summon a particle
        world.spawnParticle(particle, loc, 5, 0.1, 0.1, 0.1, 0, null, true);

        // update location values
        loc.add(velocity);
        performSpecialRunnableLogic();
    }

    public void stop() {
        performSpecialCollisionLogic();
        cancel();
    }

    public abstract void grief(Location center, int radius);

    public abstract void performSpecialCollisionLogic();

    public abstract void performSpecialRunnableLogic();


    public void start() {
        this.runTaskTimer(plugin, 0, 1);
    }

    public enum BreathType {
        BREATH, EXPLOSION
    }
}
