package me.val_mobile.rlcraft;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class SeaSerpentDrops implements Listener {

    private final RLCraft plugin;
    private final Utils util;
    private final Items citem;
    public SeaSerpentDrops(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        citem = new Items(instance);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType().equals(EntityType.ELDER_GUARDIAN)) {

            Random r = new Random();
            int scaleAmount = (int) Math.round(r.nextDouble() * (plugin.getConfig().getInt("seaSerpents.maxSerpentScales") -
                    plugin.getConfig().getInt("seaSerpents.minSerpentScales") )) + plugin.getConfig().getInt("seaSerpents.minSerpentScales");
            int scaleColor = (int) Math.round(r.nextDouble() * 6);
            switch (scaleColor) {
                case 0: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScaleBlue(), scaleAmount));
                    break;
                }
                case 1: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScaleBronze(), scaleAmount));
                    break;
                }
                case 2: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScaleDeepBlue(), scaleAmount));
                    break;
                }
                case 3: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScaleGreen(), scaleAmount));
                    break;
                }
                case 4: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScalePurple(), scaleAmount));
                    break;
                }
                case 5: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScaleRed(), scaleAmount));
                    break;
                }
                case 6: {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            util.resizeItem(citem.getSeaSerpentScaleTeal(), scaleAmount));
                    break;
                }
            }
        }
        else if (event.getEntityType().equals(EntityType.GUARDIAN)) {

            Random r = new Random();
            int scaleAmount = (int) Math.round(r.nextDouble() * (plugin.getConfig().getInt("seaSerpents.maxShinyScales") -
                    plugin.getConfig().getInt("seaSerpents.minShinyScales"))) + plugin.getConfig().getInt("seaSerpents.minShinyScales");
            if (scaleAmount > 0) {
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.resizeItem(citem.getShinyScale(), scaleAmount));
            }
        }
    }

}
