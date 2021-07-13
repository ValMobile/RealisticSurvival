package me.val_mobile.rlcraft;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WitherDrops implements Listener {

    private final RLCraft plugin;
    public WitherDrops(RLCraft instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType().equals(EntityType.WITHER)) {

            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();

            List<ItemStack> drops = new ArrayList<>();

            Random r = new Random();
            int boneAmount = (int) Math.round(r.nextDouble() * (CustomConfig.getMobConfig().getInt("Witherbones.MaxBonesWither") -
                    CustomConfig.getMobConfig().getInt("Witherbones.MinBonesWither"))) + CustomConfig.getMobConfig().getInt("Witherbones.MinBonesWither");

            ItemStack bone = CustomItems.getWitherbone();
            Utils.resizeItem(bone, boneAmount);
            drops.add(bone);

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }

        }
        else if (event.getEntityType().equals(EntityType.WITHER_SKELETON)) {

            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();

            List<ItemStack> drops = new ArrayList<>();

            Random r = new Random();
            int boneAmount = (int) Math.round(r.nextDouble() * (CustomConfig.getMobConfig().getInt("Witherbones.MaxBonesWitherSkeleton") -
                    CustomConfig.getMobConfig().getInt("Witherbones.MinBonesWitherSkeleton"))) + CustomConfig.getMobConfig().getInt("Witherbones.MinBonesWitherSkeleton");

            ItemStack bone = CustomItems.getWitherbone();
            Utils.resizeItem(bone, boneAmount);
            drops.add(bone);

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }

        }
    }
}
