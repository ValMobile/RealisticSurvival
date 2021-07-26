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

import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomItems;
import me.val_mobile.utils.LorePresets;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.World;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
/**
 * DragonFightEvents is a class containing listener methods
 * that activate special dragon attacks based on each dragon's breed
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonFightEvents implements Listener {

    /**
     * Dependency injecting the main, util, and runnable classes for use
     * The util class must be injected because its non-static methods are needed
     */
    private final RLCraft plugin;
    private final Utils util;
    private final DragonFightRunnables dragonFightRunnables;

    // constructing the DragonFightEvents class
    public DragonFightEvents(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        dragonFightRunnables = new DragonFightRunnables(instance);
    }

    /**
     * Adds ice and fire info when a dragon spawns, which includes
     * breed, stage, and age.
     * @param event The event called when an entity spawns
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntitySpawn(EntitySpawnEvent event) {
        // if the event is active
        if (!event.isCancelled()) {
            Entity entity = event.getEntity(); // get the entity

            // if the entity spawned is an ender dragon
            if (entity instanceof EnderDragon) {
                // add ice and fire information to the dragon
                util.addDragonContainers(entity);
            }
        }
    }

    /**
     * Changes the vanilla dragon fireball attack to a special breath
     * or explosion attack
     * @param event The event called when a projectile is launched
     * @see DragonFightRunnables
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        // if the event is active
        if (!event.isCancelled()) {
            // if the projectile launched is a dragon fireball
            if (event.getEntity() instanceof DragonFireball) {
                Entity fireBall = event.getEntity(); // get the fireball
                Entity dragon = (Entity) ((Projectile)fireBall).getShooter(); // get the dragon that shot the fireball

                Random r = new Random(); // create a random variable to perform calculations
                Double random = r.nextDouble(); // generate a double with a random value from 0.0 to 1.0

                // if the dragon does not have ice and fire data
                if (!util.checkDragonContainers(dragon)) {
                    // add ice and fire data to the dragon
                    util.addDragonContainers(dragon);
                }

                String dragonBreed = util.getDragonType(dragon); // get the breed of the dragon

                // if the dragon's breed is fire
                if (dragonBreed.equals("Fire")) {
                    // check if the dragon's fireball attack should be replaced with a special attack
                    if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.NormalAttack.Chance"))) {
                        // check if the dragon's special attack should be a breath attack
                        if (random <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.BreathAttack.Chance")) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    // create the fire breath attack
                                    dragonFightRunnables.getFireDragonBreathRunnable(dragon, fireBall).runTaskTimer(plugin, 0L, 1L);
                                    // remove the original fireball to make it appear like the dragon is breathing fire
                                    fireBall.remove();
                                }
                            }.runTaskLater(plugin, 2);
                        }
                        // if the dragon's special attack should be an explosion attack
                        else {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    // create the fire explosion attack
                                    // remove the original fireball to make it appear like the dragon is breathing fire
                                    fireBall.remove();
                                }
                            }.runTaskLater(plugin, 2);
                        }
                    }

                }
                // if the dragon's breed is ice
                else if (dragonBreed.equals("Ice")) {
                    // check if the dragon's fireball attack should be replaced with a special attack
                    if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.NormalAttack.Chance"))) {

                        // check if the dragon's special attack should be a breath attack
                        if (random <= CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.BreathAttack.Chance")) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    // create the fire breath attack
                                    dragonFightRunnables.getIceDragonBreathRunnable(dragon, fireBall).runTaskTimer(plugin, 0L, 1L);
                                    // remove the original fireball to make it appear like the dragon is breathing ice
                                    fireBall.remove();
                                }
                            }.runTaskLater(plugin, 2);
                        }
                        // if the dragon's special attack should be an explosion attack
                        else {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    // create the ice explosion attack
                                    // remove the original fireball to make it appear like the dragon is breathing ice
                                    fireBall.remove();
                                }
                            }.runTaskLater(plugin, 2);
                        }
                    }
                }
                // if the dragon's breed is lightning
                else {
                    // check if the dragon's fireball attack should be replaced with a special attack
                    if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.NormalAttack.Chance"))) {
                        // check if the dragon's special attack should be a breath attack
                        if (random <= CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.BreathAttack.Chance")) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    // create the lightning breath attack
                                    dragonFightRunnables.getLightningDragonBreathRunnable(dragon, fireBall).runTaskTimer(plugin, 0L, 1L);
                                    // remove the original fireball to make it appear like the dragon is shooting lightning
                                    fireBall.remove();
                                }
                            }.runTaskLater(plugin, 2);
                        }
                        // if the dragon's special attack should be an explosion attack
                        else {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    // create the lightning explosion attack
                                    // remove the original fireball to make it appear like the dragon is shooting lightning
                                    fireBall.remove();
                                }
                            }.runTaskLater(plugin, 2);
                        }
                    }
                }
            }
        }
    }

    /**
     * Drops Ice and Fire loot upon dragon, elder guardian, and wither death
     * @param event The event called when an entity dies
     * @see Utils
     * @see CustomConfig
     * @see CustomItems
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // if the entity that died was a dragon
        if (event.getEntity() instanceof EnderDragon) {

            Collection<ItemStack> drops = new ArrayList<>();  // create a collection to store all the loot to drop

            Entity entity = event.getEntity(); // get the dragon
            World world = entity.getWorld(); // get the world of the dragon
            Location loc = entity.getLocation(); // get the location of the dragon

            // if the dragon does not have ice and fire data
            if (!util.checkDragonContainers(entity)) {
                // add ice and fire data to the dragon
                util.addDragonContainers(entity);
            }


            String dragonBreed = util.getDragonType(entity);  // get the breed of the dragon
            int stage = util.getDragonStage(entity); // get the stage of the dragon

            Random r = new Random(); // create a random variable for calculations

            // initialize loot items
            ItemStack bone = CustomItems.getDragonBone();
            ItemStack heart = null;
            ItemStack blood = null;
            ItemStack flesh = null;
            ItemStack skull = null;
            ItemStack scales = null;

            // initialize the drop amounts of the loot
            int scaleAmount;
            int boneAmount;
            int bloodAmount;
            int fleshAmount;
            int scaleColor = (int) Math.round(r.nextDouble() * 3); // only 4 scale colors for each dragon breed

            /**
             * Check if recursive drop rates are enabled for dragons.
             * Recursive drop rates favor more balanced drop rates. If a lot of scales drop,
             * less bones will drop and vice versa. This drop algorithm is more consistent with what is used
             * in the canonical Ice and Fire mod.
             */
            if (CustomConfig.getMobConfig().getBoolean("Dragons.RecursiveDropRates.Enabled")) {
                /**
                 * Scale amount is between the minimum and maximum specified values.
                 * Bone amount is calculated by subtracting the scale amount and adding a minimum bone amount.
                 * Adding a minimum value ensures that at least 1 bone will drop.
                 * Dragon flesh and blood amounts are determined by multiplying the scale amount
                 * by a specified multiplier.
                 */
                scaleAmount = (int) Math.round(r.nextDouble() *
                        (CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales") ))
                        + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales");
                boneAmount = CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - scaleAmount + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinBones");
                bloodAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.BloodMultiplier"));
                fleshAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.FleshMultiplier"));

                // if the dragon's breed is fire
                if (dragonBreed.equals("Fire")) {

                    // create fire dragon loot, scales are determined later
                    heart = CustomItems.getFireDragonHeart();
                    blood = CustomItems.getFireDragonBlood();
                    flesh = CustomItems.getFireDragonFlesh();
                    skull = CustomItems.getFireDragonSkull();

                    // randomly determine the scale color
                    switch (scaleColor) {
                        case 0: {
                            scales = CustomItems.getDragonScaleBronze(); // bronze scale
                            break;
                        }
                        case 1: {
                            scales = CustomItems.getDragonScaleGray(); // gray scale
                            break;
                        }
                        case 2: {
                            scales = CustomItems.getDragonScaleGreen(); // green scale
                            break;
                        }
                        case 3: {
                            scales = CustomItems.getDragonScaleRed(); // red scale
                            break;
                        }
                    }

                }
                // if the dragon's breed is ice
                else if (dragonBreed.equals("Ice")) {

                    // create ice dragon loot, scales are determined later
                    heart = CustomItems.getIceDragonHeart();
                    blood = CustomItems.getIceDragonBlood();
                    flesh = CustomItems.getIceDragonFlesh();
                    skull = CustomItems.getIceDragonSkull();

                    // randomly determine the scale color
                    switch (scaleColor) {
                        case 0: {
                            scales = CustomItems.getDragonScaleBlue(); // blue scale
                            break;
                        }
                        case 1: {
                            scales = CustomItems.getDragonScaleSapphire(); // sapphire scale
                            break;
                        }
                        case 2: {
                            scales = CustomItems.getDragonScaleSilver(); // silver scale
                            break;
                        }
                        case 3: {
                            scales = CustomItems.getDragonScaleWhite(); // white scale
                            break;
                        }
                    }

                }
                // if the dragon's breed is lightning
                else if (dragonBreed.equals("Lightning")) {

                    // create lightning dragon loot, scales are determined later
                    heart = CustomItems.getLightningDragonHeart();
                    blood = CustomItems.getLightningDragonBlood();
                    flesh = CustomItems.getLightningDragonFlesh();
                    skull = CustomItems.getLightningDragonSkull();

                    // randomly determine the scale color
                    switch (scaleColor) {
                        case 0: {
                            scales = CustomItems.getDragonScaleAmethyst(); // amethyst scale
                            break;
                        }
                        case 1: {
                            scales = CustomItems.getDragonScaleBlack(); // black scale
                            break;
                        }
                        case 2: {
                            scales = CustomItems.getDragonScaleCopper(); // copper scale
                            break;
                        }
                        case 3: {
                            scales = CustomItems.getDragonScaleElectric(); // electric scale
                            break;
                        }
                    }

                }
            }
            // if recursive drop rates are disabled
            else {
                /**
                 * Scale, bone, blood, and flesh amounts are calculated using
                 * their respective minimum and maximum values.
                 */
                scaleAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxScales") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinScales") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinScales");
                boneAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxBones") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBones") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBones");
                bloodAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxBlood") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBlood") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBlood");
                fleshAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxFlesh") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinFlesh") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinFlesh");

                // if the dragon's breed is fire
                if (dragonBreed.equals("Fire")) {

                    // create fire dragon loot, scales are determined later
                    heart = CustomItems.getFireDragonHeart();
                    blood = CustomItems.getFireDragonBlood();
                    flesh = CustomItems.getFireDragonFlesh();
                    skull = CustomItems.getFireDragonSkull();

                    // randomly determine the scale color
                    switch (scaleColor) {
                        case 0: {
                            scales = CustomItems.getDragonScaleBronze(); // bronze scale
                            break;
                        }
                        case 1: {
                            scales = CustomItems.getDragonScaleGray(); // gray scale
                            break;
                        }
                        case 2: {
                            scales = CustomItems.getDragonScaleGreen(); // green scale
                            break;
                        }
                        case 3: {
                            scales = CustomItems.getDragonScaleRed(); // red scale
                            break;
                        }
                    }

                }
                // if the dragon's breed is ice
                else if (dragonBreed.equals("Ice")) {

                    // create ice dragon loot, scales are determined later
                    heart = CustomItems.getIceDragonHeart();
                    blood = CustomItems.getIceDragonBlood();
                    flesh = CustomItems.getIceDragonFlesh();
                    skull = CustomItems.getIceDragonSkull();

                    // randomly determine the scale color
                    switch (scaleColor) {
                        case 0: {
                            scales = CustomItems.getDragonScaleBlue(); // blue scale
                            break;
                        }
                        case 1: {
                            scales = CustomItems.getDragonScaleSapphire(); // sapphire scale
                            break;
                        }
                        case 2: {
                            scales = CustomItems.getDragonScaleSilver(); // silver scale
                            break;
                        }
                        case 3: {
                            scales = CustomItems.getDragonScaleWhite(); // white scale
                            break;
                        }
                    }

                }
                // if the dragon's breed is lightning
                else if (dragonBreed.equals("Lightning")) {

                    // create lightning dragon loot, scales are determined later
                    heart = CustomItems.getLightningDragonHeart();
                    blood = CustomItems.getLightningDragonBlood();
                    flesh = CustomItems.getLightningDragonFlesh();
                    skull = CustomItems.getLightningDragonSkull();

                    // randomly determine the scale color
                    switch (scaleColor) {
                        case 0: {
                            scales = CustomItems.getDragonScaleAmethyst(); // amethyst scale
                            break;
                        }
                        case 1: {
                            scales = CustomItems.getDragonScaleBlack(); // black scale
                            break;
                        }
                        case 2: {
                            scales = CustomItems.getDragonScaleCopper(); // copper scale
                            break;
                        }
                        case 3: {
                            scales = CustomItems.getDragonScaleElectric(); // electric scale
                            break;
                        }
                    }

                }
            }

            // resize loot
            bone.setAmount(boneAmount);
            blood.setAmount(bloodAmount);
            flesh.setAmount(fleshAmount);
            scales.setAmount(scaleAmount);

            // add a lore to the skull
            LorePresets.addDragonSkullLore(skull, stage, dragonBreed);

            // add the loot to the drop collection
            drops.add(bone);
            drops.add(blood);
            drops.add(flesh);
            drops.add(heart);
            drops.add(skull);
            drops.add(scales);

            // for every item in the drop collection
            for (ItemStack item : drops) {
                // drop the item
                world.dropItemNaturally(loc, item);
            }
        }
    }
}