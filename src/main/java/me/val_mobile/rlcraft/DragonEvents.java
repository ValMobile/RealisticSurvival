package me.val_mobile.rlcraft;

import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class DragonEvents implements Listener {

    private final RLCraft plugin;
    private final Items citem;
    private final Utils util;
    private final DragonRunnables dragonRunnables;
    public DragonEvents(RLCraft instance) {
        plugin = instance;
        dragonRunnables = new DragonRunnables(instance);
        util = new Utils(instance);
        citem = new Items(instance);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            Entity entity = event.getEntity();
            util.addDragonContainers(entity);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof DragonFireball) {
            Entity acidBall = event.getEntity();
            Entity dragon = (Entity) ((Projectile)acidBall).getShooter();

            Random r = new Random();
            Double random = r.nextDouble();

            if (!util.checkDragonContainers(dragon)) {
                util.addDragonContainers(dragon);
            }
            String dragonType = util.getDragonType(dragon);

            if (!(random <= plugin.getConfig().getDouble("dragons.normalAttackChance"))) {

                if (random <= plugin.getConfig().getDouble("dragons.normalAttackChance") + plugin.getConfig().getDouble("dragons.breathAttackChance")) {
                    if (dragonType.equals("Fire")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                dragonRunnables.getFireDragonBreathRunnable(dragon, acidBall).runTaskTimer(plugin, 0L, 1L);
                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, util.convertSecondsIntoTicks(0.1));
                    }
                    else if (dragonType.equals("Ice")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                dragonRunnables.getIceDragonBreathRunnable(dragon, acidBall).runTaskTimer(plugin, 0L, 1L);
                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, util.convertSecondsIntoTicks(0.1));
                    }
                    else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                dragonRunnables.getLightningDragonBreathRunnable(dragon, acidBall).runTaskTimer(plugin, 0L, 1L);
                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, util.convertSecondsIntoTicks(0.1));
                    }
                }
                else {

                }
            }


        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntity() instanceof EnderDragon) {

            Entity entity = event.getEntity();
            if (!util.checkDragonContainers(entity)) {
                util.addDragonContainers(entity);
            }

            String dragonType = util.getDragonType(entity);
            int stage = util.getDragonStage(entity);

            if (plugin.getConfig().getBoolean("dragons.recursiveDropRates.enabled")) {
                // Determining if the dragon is fire or ice-blooded and
                // how many scales, dragonbones, and blood to drop
                // Dragons are fire about 66% of the time
                Random r = new Random();

                int scaleAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("dragons.recursiveDropRates.maxScales") - plugin.getConfig().getInt("dragons.recursiveDropRates.minScales") ))
                        + plugin.getConfig().getInt("dragons.recursiveDropRates.minScales");
                int boneAmount = plugin.getConfig().getInt("dragons.recursiveDropRates.maxScales") - scaleAmount + plugin.getConfig().getInt("dragons.recursiveDropRates.minBones");
                int bloodAmount = (int) Math.round(scaleAmount * plugin.getConfig().getDouble("dragons.recursiveDropRates.bloodMultiplier"));
                int fleshAmount = (int) Math.round(scaleAmount * plugin.getConfig().getDouble("dragons.recursiveDropRates.fleshMultiplier"));

                // Dropping the dragonbones
                if (boneAmount > 0) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getDragonBone(), boneAmount));
                }

                // Fire Dragon
                if (dragonType.equals("Fire")) {

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleBronze(), scaleAmount));
                            break;
                        }
                        case 1: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleGray(), scaleAmount));
                            break;
                        }
                        case 2: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleGreen(), scaleAmount));
                            break;
                        }
                        case 3: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleRed(), scaleAmount));
                            break;
                        }
                    }

                    // Dropping the fire dragon blood
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getFireDragonBlood(), bloodAmount));
                    // Dropping the fire dragon meat
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getFireDragonFlesh(), fleshAmount));
                    // Dropping the fire dragon heart
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getFireDragonHeart());
                    // Dropping the dragon skull
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.addDragonSkullLore(citem.getFireDragonSkull(), stage, dragonType));
                }
                // Ice Dragon
                else if (dragonType.equals("Ice")) {

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleBlue(), scaleAmount));
                            break;
                        }
                        case 1: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleSapphire(), scaleAmount));
                            break;
                        }
                        case 2: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleSilver(), scaleAmount));
                            break;
                        }
                        case 3: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleWhite(), scaleAmount));
                            break;
                        }
                    }

                    // Dropping the ice dragon blood
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getIceDragonBlood(), bloodAmount));
                    // Dropping the fire dragon meat
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getIceDragonFlesh(), fleshAmount));
                    // Dropping the fire dragon heart
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getIceDragonHeart());
                    // Dropping the dragon skull
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.addDragonSkullLore(citem.getIceDragonSkull(), stage, dragonType));
                }
                // Lightning Dragon
                else if (dragonType.equals("Lightning")) {

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleAmethyst(), scaleAmount));
                            break;
                        }
                        case 1: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleBlack(), scaleAmount));
                            break;
                        }
                        case 2: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleCopper(), scaleAmount));
                            break;
                        }
                        case 3: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleElectric(), scaleAmount));
                            break;
                        }
                    }

                    // Dropping the lightning dragon blood
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getLightningDragonBlood(), bloodAmount));
                    // Dropping the lightning dragon meat
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getLightningDragonFlesh(), fleshAmount));
                    // Dropping the lightning dragon heart
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getLightningDragonHeart());
                    // Dropping the dragon skull
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.addDragonSkullLore(citem.getLightningDragonSkull(), stage, dragonType));
                }
            }
            else {
                Random r = new Random();
                int scaleAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("dragons.specifiedDropRates.maxScales") - plugin.getConfig().getInt("dragons.specifiedDropRates.minScales") ))
                        + plugin.getConfig().getInt("dragons.specifiedDropRates.minScales");
                int boneAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("dragons.specifiedDropRates.maxBones") - plugin.getConfig().getInt("dragons.specifiedDropRates.minBones") ))
                        + plugin.getConfig().getInt("dragons.specifiedDropRates.minBones");
                int bloodAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("dragons.specifiedDropRates.maxBlood") - plugin.getConfig().getInt("dragons.specifiedDropRates.minBlood") ))
                        + plugin.getConfig().getInt("dragons.specifiedDropRates.minBlood");
                int fleshAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("dragons.specifiedDropRates.maxFlesh") - plugin.getConfig().getInt("dragons.specifiedDropRates.minFlesh") ))
                        + plugin.getConfig().getInt("dragons.specifiedDropRates.minFlesh");

                // Dropping the dragonbones
                if (boneAmount > 0) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getDragonBone(), boneAmount));
                }

                // Fire Dragon
                if (dragonType.equals("Fire")) {

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleBronze(), scaleAmount));
                            break;
                        }
                        case 1: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleGray(), scaleAmount));
                            break;
                        }
                        case 2: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleGreen(), scaleAmount));
                            break;
                        }
                        case 3: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleRed(), scaleAmount));
                            break;
                        }
                    }

                    // Dropping the fire dragon blood
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getFireDragonBlood(), bloodAmount));
                    // Dropping the fire dragon meat
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getFireDragonFlesh(), fleshAmount));
                    // Dropping the fire dragon heart
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getFireDragonHeart());
                    // Dropping the dragon skull
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.addDragonSkullLore(citem.getFireDragonSkull(), stage, dragonType));
                }
                // Ice Dragon
                else if (dragonType.equals("Ice")) {

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleBlue(), scaleAmount));
                            break;
                        }
                        case 1: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleSapphire(), scaleAmount));
                            break;
                        }
                        case 2: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleSilver(), scaleAmount));
                            break;
                        }
                        case 3: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleWhite(), scaleAmount));
                            break;
                        }
                    }

                    // Dropping the ice dragon blood
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getIceDragonBlood(), bloodAmount));
                    // Dropping the fire dragon meat
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getIceDragonFlesh(), fleshAmount));
                    // Dropping the fire dragon heart
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getIceDragonHeart());
                    // Dropping the dragon skull
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.addDragonSkullLore(citem.getIceDragonSkull(), stage, dragonType));
                }
                // Lightning Dragon
                else if (dragonType.equals("Lightning")) {

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleAmethyst(), scaleAmount));
                            break;
                        }
                        case 1: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleBlack(), scaleAmount));
                            break;
                        }
                        case 2: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleCopper(), scaleAmount));
                            break;
                        }
                        case 3: {
                            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                                    util.resizeItem(citem.getDragonScaleElectric(), scaleAmount));
                            break;
                        }
                    }

                    // Dropping the lightning dragon blood
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getLightningDragonBlood(), bloodAmount));
                    // Dropping the lightning dragon meat
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getLightningDragonFlesh(), fleshAmount));
                    // Dropping the lightning dragon heart
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getLightningDragonHeart());
                    // Dropping the dragon skull
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.addDragonSkullLore(citem.getLightningDragonSkull(), stage, dragonType));
                }
            }

        }

    }

}
