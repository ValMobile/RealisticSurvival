package me.val_mobile.sea_serpents;

import me.val_mobile.rlcraft.RLCraft;
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

    private final RLCraft plugin;
    public SeaSerpentDrops(RLCraft instance) {
        plugin = instance;
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
                    ItemStack blueScale = CustomItems.getSeaSerpentScaleBlue();
                    blueScale.setAmount(scaleAmount);
                    drops.add(blueScale);
                    break;
                }
                case 1: {
                    ItemStack bronzeScale = CustomItems.getSeaSerpentScaleBronze();
                    bronzeScale.setAmount(scaleAmount);
                    drops.add(bronzeScale);
                    break;
                }
                case 2: {
                    ItemStack deepBlueScale = CustomItems.getSeaSerpentScaleDeepBlue();
                    deepBlueScale.setAmount(scaleAmount);
                    drops.add(deepBlueScale);
                    break;
                }
                case 3: {
                    ItemStack greenScale = CustomItems.getSeaSerpentScaleGreen();
                    greenScale.setAmount(scaleAmount);
                    drops.add(greenScale);
                    break;
                }
                case 4: {
                    ItemStack purpleScale = CustomItems.getSeaSerpentScalePurple();
                    purpleScale.setAmount(scaleAmount);
                    drops.add(purpleScale);
                    break;
                }
                case 5: {
                    ItemStack redScale = CustomItems.getSeaSerpentScaleRed();
                    redScale.setAmount(scaleAmount);
                    drops.add(redScale);
                    break;
                }
                case 6: {
                    ItemStack tealScale = CustomItems.getSeaSerpentScaleTeal();
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

            ItemStack shinyScale = CustomItems.getShinyScale();
            shinyScale.setAmount(scaleAmount);
            drops.add(shinyScale);

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }
        }
    }

}
