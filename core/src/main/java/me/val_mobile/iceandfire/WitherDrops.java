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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
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
    private final Utils util;
    public WitherDrops(RealisticSurvivalPlugin plugin) {
        customItems = new CustomItems(plugin);
        util = new Utils(plugin);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (util.shouldEventBeRan(entity, "Witherbones")) {
            FileConfiguration config = RSVFiles.getIfUserConfig();

            if (event.getEntityType().equals(EntityType.WITHER)) {
                World world = entity.getWorld();
                Location loc = entity.getLocation();

                List<ItemStack> drops = new ArrayList<>();

                Random r = new Random();
                int boneAmount = (int) Math.round(Math.random() * (config.getInt("Witherbones.MaxBonesWither") -
                        config.getInt("Witherbones.MinBonesWither"))) + config.getInt("Witherbones.MinBonesWither");

                ItemStack bone = customItems.getWitherbone();
                bone.setAmount(boneAmount);
                drops.add(bone);

                for (ItemStack item : drops) {
                    world.dropItemNaturally(loc, item);
                }

            }
            else if (event.getEntityType().equals(EntityType.WITHER_SKELETON)) {

                World world = entity.getWorld();
                Location loc = entity.getLocation();

                List<ItemStack> drops = new ArrayList<>();

                Random r = new Random();
                int boneAmount = (int) Math.round(Math.random() * (config.getInt("Witherbones.MaxBonesWitherSkeleton") -
                        config.getInt("Witherbones.MinBonesWitherSkeleton"))) + config.getInt("Witherbones.MinBonesWitherSkeleton");

                ItemStack bone = customItems.getWitherbone();
                bone.setAmount(boneAmount);
                drops.add(bone);

                for (ItemStack item : drops) {
                    world.dropItemNaturally(loc, item);
                }

            }
        }
    }
}