package me.val_mobile.minorities_smp_extras;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class WitherDrops implements Listener {

    private final Main plugin;
    private final Items citem;
    private final Utils util = new Utils();

    public WitherDrops(Main instance) {
        plugin = instance;
        citem = new Items(instance);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType().equals(EntityType.WITHER)) {

            Random r = new Random();
            int boneAmount = (int) Math.round(r.nextDouble() * (plugin.getConfig().getInt("witherbones.maxBonesWither") -
                    plugin.getConfig().getInt("witherbones.minBonesWither"))) + plugin.getConfig().getInt("witherbones.minBonesWither");
            if (boneAmount > 0) {
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.resizeItem(citem.getWitherbone(), boneAmount));
            }

        }
        else if (event.getEntityType().equals(EntityType.WITHER_SKELETON)) {

            Random r = new Random();
            int boneAmount = (int) Math.round(r.nextDouble() * (plugin.getConfig().getInt("witherbones.maxBonesWitherSkeleton") -
                    plugin.getConfig().getInt("witherbones.minBonesWitherSkeleton"))) + plugin.getConfig().getInt("witherbones.minBonesWitherSkeleton");
            if (boneAmount > 0) {
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                        util.resizeItem(citem.getWitherbone(), boneAmount));
            }

        }
    }
}
