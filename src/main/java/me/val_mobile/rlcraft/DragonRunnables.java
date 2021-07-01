package me.val_mobile.rlcraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;

public class DragonRunnables {

    private final RLCraft plugin;
    private final ItemAbilities itemAbilities;
    private final Utils util;
    public DragonRunnables(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        itemAbilities = new ItemAbilities(instance);
    }

    public BukkitRunnable getFireDragonBreathRunnable(Entity dragon, Entity projectile) {
        return new BukkitRunnable() {
            World world = projectile.getWorld();
            Location loc = projectile.getLocation();
            Vector velocity = projectile.getVelocity().multiply(30 * util.getDragonStage(dragon));
            int radius = util.getDragonStage(dragon) + 2;
            int ticks = 0;
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
                                    Location loc = util.modifyLocation(newLoc, x, y, z);
                                    Location secondLoc = util.modifyLocation(newLoc, x, y - 1, z);
                                    Block block = loc.getBlock();
                                    Material blockMaterial = block.getType();
                                    Block secondBlock = secondLoc.getBlock();
                                    if (block.isEmpty() || !blockMaterial.isOccluding()) {
                                        if (!secondBlock.isEmpty()) {
                                            world.getBlockAt(loc).setType(Material.FIRE);
                                        }
                                    }
                                    else {
                                        if (! (blockMaterial == Material.BEDROCK || loc.getWorld().getEnvironment().equals(World.Environment.THE_END)) ) {
                                            if (blockMaterial.isFuel()) {
                                                world.getBlockAt(loc).setType(Material.BLACKSTONE);
                                            }
                                            else {
                                                world.getBlockAt(loc).setType(Material.SMOOTH_BASALT);
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
                if (ticks >= 200) {
                    cancel();
                }

                if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                    Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                    for (Entity e : collection) {
                        itemAbilities.FireDragonsteelAbility((LivingEntity) e);
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
            Vector velocity = projectile.getVelocity().multiply(30 * util.getDragonStage(dragon));
            int radius = util.getDragonStage(dragon) + 2;

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
                                    Location loc = util.modifyLocation(newLoc, x, y, z);
                                    Location secondLoc = util.modifyLocation(newLoc, x, y - 1, z);
                                    Block block = loc.getBlock();
                                    Material blockMaterial = block.getType();
                                    Block secondBlock = secondLoc.getBlock();
                                    if (block.isEmpty() || !blockMaterial.isOccluding()) {
                                        if (!secondBlock.isEmpty()) {
                                            world.getBlockAt(loc).setType(Material.SNOW);
                                        }
                                    }
                                    else {
                                        if (! (blockMaterial == Material.BEDROCK || loc.getWorld().getEnvironment().equals(World.Environment.THE_END)) ) {
                                            world.getBlockAt(loc).setType(Material.PACKED_ICE);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                        Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                        for (Entity e : collection) {
                            itemAbilities.IceDragonsteelAbility((LivingEntity) e);
                        }
                    }

                    cancel();
                }
                ticks++;
                if (ticks >= 200) {
                    cancel();
                }

                if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                    Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                    for (Entity e : collection) {
                        itemAbilities.IceDragonsteelAbility((LivingEntity) e);
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
            Vector velocity = projectile.getVelocity().multiply(30 * util.getDragonStage(dragon));
            Vector secondVelocity = util.randomizeVelocity(velocity);
            Vector thirdVelocity = util.randomizeVelocity(velocity);
            int radius = util.getDragonStage(dragon) + 2;
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
                if (ticks >= 200) {
                    cancel();
                }

                if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                    Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2);
                    for (Entity e : collection) {
                        loc.getWorld().strikeLightning(e.getLocation());
                        cancel();
                        break;
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
