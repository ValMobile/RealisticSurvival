package me.val_mobile.minorities_smp_extras;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class DragonDrops implements Listener {

    private final Main plugin;
    private final Items citem;
    private final Utils util = new Utils();

    public DragonDrops(Main instance) {
        plugin = instance;
        citem = new Items(instance);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntityType().equals(EntityType.ENDER_DRAGON)) {

            // Determining if the dragon is fire or ice-blooded and
            // how many scales, dragonbones, and blood to drop
            // Dragons are fire about 66% of the time
            Random r = new Random();
            int dragonType = (int) Math.round(r.nextDouble() * 9);
            if (dragonType <= plugin.getConfig().getDouble("dragons.recursiveDropRates.fireDragonRate") * 10 - 1) {
                plugin.dragon = "Fire";
            }
            else if (dragonType >= plugin.getConfig().getDouble("dragons.recursiveDropRates.fireDragonRate") * 10 &&
                    dragonType <= ((plugin.getConfig().getDouble("dragons.recursiveDropRates.fireDragonRate") + plugin.getConfig().getDouble("dragons.recursiveDropRates.iceDragonRate")) * 10) - 1) {
                plugin.dragon = "Ice";
            }
            else {
                plugin.dragon = "Lightning";
            }

            int scaleAmount = (int) Math.round(r.nextDouble() *
                    (plugin.getConfig().getInt("dragons.recursiveDropRates.maxScales") - plugin.getConfig().getInt("dragons.recursiveDropRates.minScales") ))
                    + plugin.getConfig().getInt("dragons.recursiveDropRates.minScales");
            int boneAmount = plugin.getConfig().getInt("dragons.recursiveDropRates.maxScales") - scaleAmount + plugin.getConfig().getInt("dragons.recursiveDropRates.minBones");
            int bloodAmount = (int) Math.round(scaleAmount * plugin.getConfig().getDouble("dragons.recursiveDropRates.bloodMultiplier"));
            int meatAmount = (int) Math.round(scaleAmount * plugin.getConfig().getDouble("dragons.recursiveDropRates.meatMultiplier"));
            int stage = (int) Math.round(r.nextDouble() * 2) + 3;

            // Dropping the dragonbones
            if (boneAmount > 0) {
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.resizeItem(citem.getDragonBone(), boneAmount));
            }

            // Fire Dragon
            if (plugin.dragon.equals("Fire")) {

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
                        util.resizeItem(citem.getFireDragonFlesh(), meatAmount));
                // Dropping the fire dragon heart
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        citem.getFireDragonHeart());
                // Dropping the dragon skull
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.addDragonSkullLore(citem.getDragonSkull(), stage, plugin.dragon));
            }
            // Ice Dragon
            else if (plugin.dragon.equals("Ice")) {

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
                        util.resizeItem(citem.getIceDragonFlesh(), meatAmount));
                // Dropping the fire dragon heart
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        citem.getIceDragonHeart());
                // Dropping the dragon skull
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.addDragonSkullLore(citem.getDragonSkull(), stage, plugin.dragon));
            }
            // Lightning Dragon
            else if (plugin.dragon.equals("Lightning")) {

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
                        util.resizeItem(citem.getLightningDragonFlesh(), meatAmount));
                // Dropping the lightning dragon heart
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        citem.getLightningDragonHeart());
                // Dropping the dragon skull
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.addDragonSkullLore(citem.getDragonSkull(), stage, plugin.dragon));
            }

        }

    }

}
