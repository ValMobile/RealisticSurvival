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
package me.val_mobile.sea_serpents;

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

public class SeaSerpentDrops implements Listener {

    private final CustomItems customItems;
    public SeaSerpentDrops(RLCraftPlugin instance) {
        customItems = new CustomItems(instance);
    }
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType().equals(EntityType.ELDER_GUARDIAN)) {

            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();

            List<ItemStack> drops = new ArrayList<>();

            Random r = new Random();
            int scaleAmount = (int) Math.round(r.nextDouble() * (CustomConfig.getMobConfig().getInt("SeaSerpents.MaxSerpentScales") -
                    CustomConfig.getMobConfig().getInt("SeaSerpents.MinSerpentScales") )) + CustomConfig.getMobConfig().getInt("SeaSerpents.MinSerpentScales");
            int scaleColor = (int) Math.round(r.nextDouble() * 6);
            switch (scaleColor) {
                case 0: {
                    ItemStack blueScale = customItems.getSeaSerpentScaleBlue();
                    blueScale.setAmount(scaleAmount);
                    drops.add(blueScale);
                    break;
                }
                case 1: {
                    ItemStack bronzeScale = customItems.getSeaSerpentScaleBronze();
                    bronzeScale.setAmount(scaleAmount);
                    drops.add(bronzeScale);
                    break;
                }
                case 2: {
                    ItemStack deepBlueScale = customItems.getSeaSerpentScaleDeepblue();
                    deepBlueScale.setAmount(scaleAmount);
                    drops.add(deepBlueScale);
                    break;
                }
                case 3: {
                    ItemStack greenScale = customItems.getSeaSerpentScaleGreen();
                    greenScale.setAmount(scaleAmount);
                    drops.add(greenScale);
                    break;
                }
                case 4: {
                    ItemStack purpleScale = customItems.getSeaSerpentScalePurple();
                    purpleScale.setAmount(scaleAmount);
                    drops.add(purpleScale);
                    break;
                }
                case 5: {
                    ItemStack redScale = customItems.getSeaSerpentScaleRed();
                    redScale.setAmount(scaleAmount);
                    drops.add(redScale);
                    break;
                }
                case 6: {
                    ItemStack tealScale = customItems.getSeaSerpentScaleTeal();
                    tealScale.setAmount(scaleAmount);
                    drops.add(tealScale);
                    break;
                }
            }

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }
        }
        else if (event.getEntityType().equals(EntityType.GUARDIAN)) {

            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();

            List<ItemStack> drops = new ArrayList<>();

            Random r = new Random();
            int scaleAmount = (int) Math.round(r.nextDouble() * (CustomConfig.getMobConfig().getInt("SeaSerpents.MaxShinyScales") -
                    CustomConfig.getMobConfig().getInt("SeaSerpents.MinShinyScales"))) + CustomConfig.getMobConfig().getInt("SeaSerpents.MinShinyScales");

            ItemStack shinyScale = customItems.getShinyScale();
            shinyScale.setAmount(scaleAmount);
            drops.add(shinyScale);

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }
        }
    }
}