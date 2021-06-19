package me.val_mobile.minorities_smp_extras;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.DragonFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DragonFight implements Listener {

    private final Main plugin;
    private final Runnables runnable;
    private final Utils util = new Utils();
    private double[][] coordinates;
    public DragonFight(Main instance) {
        plugin = instance;
        runnable = new Runnables(plugin);
    }


    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof DragonFireball) {

            new BukkitRunnable() {
                @Override
                public void run() {
                    Vector velocity = event.getEntity().getVelocity().multiply(30);
                    Location loc = event.getEntity().getLocation();
                    World world = event.getEntity().getWorld();
                    getDragonBreathRunnable(world, loc, velocity).runTaskTimer(plugin, 0L, 1L);
                    event.getEntity().remove();
                }
            }.runTaskLater(plugin, 2L);

        }
    }

    public BukkitRunnable getDragonBreathRunnable(World world, Location loc, Vector velocity) {
        return new BukkitRunnable() {
            double displacement = 0;
            @Override
            public void run() {
                if (! (loc.getBlock() == null || loc.getBlock().getType() == Material.AIR) ) {
                    Location newLoc = loc.clone();
                    while (!(newLoc.getBlock() == null || newLoc.getBlock().getType() == Material.AIR) ) {
                        newLoc.setY(newLoc.getY() + 1D);
                        if (newLoc.getY() > 256) {
                            break;
                        }
                    }
                    int radius = 7;

                    for (int x = -radius; x < radius; x++) {
                        for (int y = -radius / 2; y < radius / 2; y++) {
                            for (int z = -radius; z < radius; z++) {
                                if (!(Math.hypot(x, z) > radius) ) {
                                    Location blockBelow = util.modifyLocation(newLoc, x, y, z);
                                    Location secondBlockBelow = util.modifyLocation(newLoc, x, y - 1, z);
                                    if (!(blockBelow.getBlock() == null || blockBelow.getBlock().getType() == Material.AIR)) {
                                        world.getBlockAt(newLoc).setType(Material.FIRE);
                                    }
                                    else if ( (blockBelow.getBlock() == null || blockBelow.getBlock().getType() == Material.AIR) &&
                                            !(secondBlockBelow.getBlock() == null || secondBlockBelow.getBlock().getType() == Material.AIR)) {
                                        world.getBlockAt(blockBelow).setType(Material.FIRE);
                                    }
                                }
                            }
                        }
                    }
                    cancel();
                }
                displacement = Math.sqrt(Math.pow(loc.getX(), 2) + Math.pow(loc.getY(), 2) + Math.pow(loc.getZ(), 2));
                if (displacement > 300) {
                    cancel();
                }
                world.spawnParticle(Particle.FLAME, loc, 5, 0.1, 0.1, 0.1, 0, null, true);
                loc.setX(loc.getX() + velocity.getX());
                loc.setY(loc.getY() + velocity.getY());
                loc.setZ(loc.getZ() + velocity.getZ());
            }
        };
    }

}
