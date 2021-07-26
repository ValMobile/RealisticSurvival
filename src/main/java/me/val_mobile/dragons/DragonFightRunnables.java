/*
    Copyright (C) 2021  Val_Mobile

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
package me.val_mobile.dragons;

import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
/**
 * DragonFightRunnables is a utility class containing methods that
 * execute various runnables to allow for
 * dragons to execute custom attacks
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonFightRunnables {

    // dependency injecting the utils and abilities classes
    private final DragonGearAbilities dragonGearAbilities;
    private final Utils util;

    // constructing the DragonFightRunnables class
    public DragonFightRunnables(RLCraft instance) {
        util = new Utils(instance);
        dragonGearAbilities = new DragonGearAbilities(instance);
    }

    /**
     * Shoots a flame trail out of a dragon and chars blocks where the flame hits
     * @param dragon The dragon breathing fire
     * @param projectile The vanilla dragon fireball
     * @return A runnable creating the flame trial
     * @see DragonGearAbilities
     * @see Utils
     */
    public BukkitRunnable getFireDragonBreathRunnable(Entity dragon, Entity projectile) {
        return new BukkitRunnable() {
            World world = projectile.getWorld(); // get the world
            Location loc = projectile.getLocation(); // get the location

            // create constants used in calculations
            Double velocityMultiplier = CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.BreathAttack.VelocityMultiplier");
            int radiusConstant = CustomConfig.getMobConfig().getInt("Dragons.FireDragon.BreathAttack.RadiusConstant");
            int decayTicks = CustomConfig.getMobConfig().getInt("Dragons.FireDragon.BreathAttack.DecayTicks");

            Vector velocity = projectile.getVelocity().multiply(velocityMultiplier * util.getDragonStage(dragon)); // determine the velocity of the flame trail
            int radius = util.getDragonStage(dragon) + radiusConstant; // determine the radius of charring
            int ticks = 0; // temp variable to store how long the trail has been moving
            @Override
            public void run() {
                if (! (loc.getBlock().isEmpty()) ) {
                    Location newLoc = loc.clone();
                    if (!util.checkDragonContainers(projectile)) {
                        util.addDragonContainers(projectile);
                    }
                    while (!(newLoc.getBlock().isEmpty()) ) {
                        newLoc.setY(newLoc.getY() + 1D);
                        if (newLoc.getBlock().isEmpty()) {
                            break;
                        }
                        if (loc.toVector().distance(newLoc.toVector()) > radius) {
                            break;
                        }

                    }
                    for (int x = -radius; x < radius; x++) {
                        for (int y = -radius; y < radius; y++) {
                            for (int z = -radius; z < radius; z++) {
                                if (!(Math.hypot(Math.hypot(x, y), z) > radius) ) {
                                    Location loc = Utils.modifyLocation(newLoc, x, y, z);
                                    Location secondLoc = Utils.modifyLocation(newLoc, x, y - 1, z);
                                    Block block = loc.getBlock();
                                    Material blockMaterial = block.getType();
                                    Block secondBlock = secondLoc.getBlock();
                                    if (block.isEmpty() || !blockMaterial.isOccluding()) {
                                        if (!block.isLiquid()) {
                                            if (!secondBlock.isEmpty()) {
                                                world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.FireDragon.BreathAttack.LayerBlock")));
                                            }
                                        }
                                    }
                                    else {
                                        if (!CustomConfig.getMobConfig().getStringList("Dragons.FireDragon.BreathAttack.ImmuneBlocks").contains(blockMaterial.toString())) {
                                            if (!block.isLiquid()) {
                                                if (blockMaterial.isFuel()) {
                                                    world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.FireDragon.BreathAttack.BurntBlock")));
                                                }
                                                else {
                                                    world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.FireDragon.BreathAttack.CharredBlock")));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    cancel();
                }
                ticks++;
                if (ticks > decayTicks) {
                    cancel();
                }
                if (ticks > 10) {
                    if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                        Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                        for (Entity e : collection) {
                            if (e instanceof LivingEntity) {
                                if (e instanceof EnderDragon) {
                                    if (!util.getDragonType(e).equals("Fire")) {
                                        dragonGearAbilities.FireDragonsteelAbility((LivingEntity) e);
                                    }
                                }
                                else {
                                    dragonGearAbilities.FireDragonsteelAbility((LivingEntity) e);
                                }
                            }
                        }
                    }
                }

                world.spawnParticle(Particle.FLAME, loc, 5, 0.1, 0.1, 0.1, 0, null, true);
                loc.setX(loc.getX() + velocity.getX());
                loc.setY(loc.getY() + velocity.getY());
                loc.setZ(loc.getZ() + velocity.getZ());

            }
        };
    }

    public BukkitRunnable getIceDragonBreathRunnable(Entity dragon, Entity projectile) {
        return new BukkitRunnable() {
            World world = projectile.getWorld();
            Location loc = projectile.getLocation();

            Double velocityMultiplier = CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.BreathAttack.VelocityMultiplier");
            int radiusConstant = CustomConfig.getMobConfig().getInt("Dragons.IceDragon.BreathAttack.RadiusConstant");
            int decayTicks = CustomConfig.getMobConfig().getInt("Dragons.IceDragon.BreathAttack.DecayTicks");

            Vector velocity = projectile.getVelocity().multiply(velocityMultiplier * util.getDragonStage(dragon));
            int radius = util.getDragonStage(dragon) + radiusConstant;

            int ticks = 0;
            @Override
            public void run() {
                if (! (loc.getBlock().isEmpty()) ) {
                    Location newLoc = loc.clone();
                    while (!(newLoc.getBlock().isEmpty()) ) {
                        newLoc.setY(newLoc.getY() + 1D);
                        if (newLoc.getBlock().isEmpty()) {
                            break;
                        }
                        if (loc.toVector().distance(newLoc.toVector()) > radius) {
                            break;
                        }

                    }
                    for (int x = -radius; x < radius; x++) {
                        for (int y = -radius; y < radius; y++) {
                            for (int z = -radius; z < radius; z++) {
                                if (!(Math.hypot(Math.hypot(x, y), z) > radius) ) {
                                    Location loc = Utils.modifyLocation(newLoc, x, y, z);
                                    Location secondLoc = Utils.modifyLocation(newLoc, x, y - 1, z);
                                    Block block = loc.getBlock();
                                    Material blockMaterial = block.getType();
                                    Block secondBlock = secondLoc.getBlock();
                                    if (block.isEmpty() || !blockMaterial.isOccluding()) {
                                        if (!block.isLiquid()) {
                                            if (!secondBlock.isEmpty()) {
                                                world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.IceDragon.BreathAttack.LayerBlock")));
                                            }
                                        }
                                    }
                                    else {
                                        if (!CustomConfig.getMobConfig().getStringList("Dragons.IceDragon.BreathAttack.ImmuneBlocks").contains(blockMaterial.toString())) {
                                            if (!block.isLiquid()) {
                                                world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.IceDragon.BreathAttack.FrozenBlock")));
                                            }
                                            else if (blockMaterial == Material.WATER) {
                                                world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.IceDragon.BreathAttack.SolidifiedWaterBlock")));
                                            }
                                            else if (blockMaterial == Material.LAVA) {
                                                world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.IceDragon.BreathAttack.SolidifiedLavaBlock")));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                        Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                        for (Entity e : collection) {
                            if (e instanceof LivingEntity) {
                                if (e instanceof EnderDragon) {
                                    if (!util.getDragonType(e).equals("Ice")) {
                                        dragonGearAbilities.IceDragonsteelAbility((LivingEntity) e);
                                    }
                                }
                                else {
                                    dragonGearAbilities.IceDragonsteelAbility((LivingEntity) e);
                                }
                            }
                        }
                    }

                    cancel();
                }
                ticks++;
                if (ticks > decayTicks) {
                    cancel();
                }
                if (ticks > 10) {
                    if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                        Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                        for (Entity e : collection) {
                            if (e instanceof LivingEntity) {
                                if (e instanceof EnderDragon) {
                                    if (!util.getDragonType(e).equals("Ice")) {
                                        dragonGearAbilities.IceDragonsteelAbility((LivingEntity) e);
                                        cancel();
                                    }
                                }
                                else {
                                    dragonGearAbilities.IceDragonsteelAbility((LivingEntity) e);
                                    cancel();
                                }
                            }
                        }
                    }
                }

                world.spawnParticle(Particle.SNOWFLAKE, loc, 5, 0.1, 0.1, 0.1, 0, null, true);
                loc.setX(loc.getX() + velocity.getX());
                loc.setY(loc.getY() + velocity.getY());
                loc.setZ(loc.getZ() + velocity.getZ());

            }
        };
    }

    public BukkitRunnable getLightningDragonBreathRunnable(Entity dragon, Entity projectile) {
        return new BukkitRunnable() {
            World world = projectile.getWorld();
            Location loc = projectile.getLocation();
            Location secondLoc = projectile.getLocation().clone();
            Location thirdLoc = projectile.getLocation().clone();

            Double velocityMultiplier = CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.BreathAttack.VelocityMultiplier");
            int radiusConstant = CustomConfig.getMobConfig().getInt("Dragons.LightningDragon.BreathAttack.RadiusConstant");
            int decayTicks = CustomConfig.getMobConfig().getInt("Dragons.LightningDragon.BreathAttack.DecayTicks");

            Vector velocity = projectile.getVelocity().multiply(velocityMultiplier * util.getDragonStage(dragon));
            Vector secondVelocity = Utils.randomizeVelocity(velocity);
            Vector thirdVelocity = Utils.randomizeVelocity(velocity);
            int radius = util.getDragonStage(dragon) + radiusConstant;
            int ticks = 0;
            @Override
            public void run() {
                if (! (loc.getBlock().isEmpty()) ) {
                    Location newLoc = loc.clone();
                    while (!(newLoc.getBlock().isEmpty()) ) {
                        newLoc.setY(newLoc.getY() + 1D);
                        if (newLoc.getBlock().isEmpty()) {
                            break;
                        }
                        if (loc.toVector().distance(newLoc.toVector()) > radius) {
                            break;
                        }
                    }
                    newLoc.getWorld().strikeLightning(newLoc);

                    cancel();
                }
                else if (! (secondLoc.getBlock().isEmpty()) ) {
                    Location newLoc = secondLoc.clone();
                    while (!(newLoc.getBlock().isEmpty()) ) {
                        newLoc.setY(newLoc.getY() + 1D);
                        if (newLoc.getBlock().isEmpty()) {
                            break;
                        }
                        if (loc.toVector().distance(newLoc.toVector()) > radius) {
                            break;
                        }
                    }
                    newLoc.getWorld().strikeLightning(newLoc);

                    cancel();
                }
                else if (! (thirdLoc.getBlock().isEmpty()) ) {
                    Location newLoc = thirdLoc.clone();
                    while (!(newLoc.getBlock().isEmpty()) ) {
                        newLoc.setY(newLoc.getY() + 1D);
                        if (newLoc.getBlock().isEmpty()) {
                            break;
                        }
                        if (loc.toVector().distance(newLoc.toVector()) > radius) {
                            break;
                        }
                    }
                    newLoc.getWorld().strikeLightning(newLoc);

                    cancel();
                }

                ticks++;
                if (ticks > decayTicks) {
                    cancel();
                }
                if (ticks > 10) {
                    if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                        Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                        for (Entity e : collection) {
                            if (e instanceof LivingEntity) {
                                if (e instanceof EnderDragon) {
                                    if (!util.getDragonType(e).equals("Lightning")) {
                                        dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) e, (LivingEntity) dragon);
                                        cancel();
                                    }
                                }
                                else {
                                    dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) e, (LivingEntity) dragon);
                                    cancel();
                                }
                            }

                        }
                    }
                }



                world.spawnParticle(Particle.ELECTRIC_SPARK, loc, 5, 0.1, 0.1, 0.1, 0, null, true);
                world.spawnParticle(Particle.ELECTRIC_SPARK, secondLoc, 5, 0.1, 0.1, 0.1, 0, null, true);
                world.spawnParticle(Particle.ELECTRIC_SPARK, thirdLoc, 5, 0.1, 0.1, 0.1, 0, null, true);

                loc.setX(loc.getX() + velocity.getX());
                loc.setY(loc.getY() + velocity.getY());
                loc.setZ(loc.getZ() + velocity.getZ());

                secondLoc.setX(secondLoc.getX() + secondVelocity.getX());
                secondLoc.setY(secondLoc.getY() + secondVelocity.getY());
                secondLoc.setZ(secondLoc.getZ() + secondVelocity.getZ());

                thirdLoc.setX(thirdLoc.getX() + thirdVelocity.getX());
                thirdLoc.setY(thirdLoc.getY() + thirdVelocity.getY());
                thirdLoc.setZ(thirdLoc.getZ() + thirdVelocity.getZ());

            }
        };
    }

}