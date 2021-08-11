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

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomItems;
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

    private final CustomItems customItems;
    public WitherDrops(RLCraftPlugin instance) {
        customItems = new CustomItems(instance);
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

            ItemStack bone = customItems.getWitherbone();
            bone.setAmount(boneAmount);
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

            ItemStack bone = customItems.getWitherbone();
            bone.setAmount(boneAmount);
            drops.add(bone);

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }

        }
    }
}