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
import me.val_mobile.utils.LorePresets;
import me.val_mobile.utils.Utils;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;
import net.minecraft.world.level.World;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Random;

public class FireDragon extends Dragon {

    private final RLCraftPlugin plugin;
    private final DragonGearAbilities dragonGearAbilities;
    private final CustomItems customItems;

    public FireDragon(EntityTypes<? extends EntityEnderDragon> entitytypes, World world, Random random, RLCraftPlugin instance) {
        super(entitytypes, world, random, me.val_mobile.enums.Dragon.Breed.FIRE);

        plugin = instance;
        dragonGearAbilities = new DragonGearAbilities(instance);
        customItems = new CustomItems(instance);
    }

    public FireDragon(EntityTypes<? extends EntityEnderDragon> entitytypes, World world, Random random, int stage, RLCraftPlugin instance) {
        super(entitytypes, world, random, me.val_mobile.enums.Dragon.Breed.FIRE, stage);

        plugin = instance;
        dragonGearAbilities = new DragonGearAbilities(instance);
        customItems = new CustomItems(instance);
    }

    @Override
    public void generateLoot() {
        // empty current loot table
        Collection<ItemStack> loot = getLoot();
        loot.clear();

        Random r = new Random(); // create a random variable for calculations

        // initialize loot items
        ItemStack heart = customItems.getFireDragonHeart();
        ItemStack skull = customItems.getFireDragonSkull();
        ItemStack scales;
        ItemStack blood = customItems.getFireDragonBlood();
        ItemStack flesh = customItems.getFireDragonFlesh();
        ItemStack bones = customItems.getDragonbone();

        // initialize the drop amounts of the loot
        int scaleAmount;
        int boneAmount;
        int bloodAmount;
        int fleshAmount;

        // get the correct scale color
        switch (getVariant()) {
            case RED:
                scales = customItems.getDragonscaleRed(); // red
            case EMERALD:
                scales = customItems.getDragonscaleGreen(); // green
            case GRAY:
                scales = customItems.getDragonscaleGray(); // gray
            default:
                scales = customItems.getDragonscaleBronze(); // bronze
        }

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
                    (CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales")))
                    + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales");
            boneAmount = CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - scaleAmount + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinBones");
            bloodAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.BloodMultiplier"));
            fleshAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.FleshMultiplier"));
        }
        // if recursive drop rates are disabled
        else {
            /**
             * Scale, bone, blood, and flesh amounts are calculated using
             * their respective minimum and maximum values.
             */
            scaleAmount = (int) Math.round(r.nextDouble() *
                    (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxScales") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinScales")))
                    + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinScales");
            boneAmount = (int) Math.round(r.nextDouble() *
                    (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxBones") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBones")))
                    + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBones");
            bloodAmount = (int) Math.round(r.nextDouble() *
                    (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxBlood") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBlood")))
                    + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBlood");
            fleshAmount = (int) Math.round(r.nextDouble() *
                    (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxFlesh") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinFlesh")))
                    + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinFlesh");
        }

        // resize loot
        bones.setAmount(boneAmount);
        blood.setAmount(bloodAmount);
        flesh.setAmount(fleshAmount);
        scales.setAmount(scaleAmount);

        // add a lore to the skull
        LorePresets.addDragonSkullLore(skull, getStage(), getBreed());

        // add the loot to the loot table
        loot.add(bones);
        loot.add(heart);
        loot.add(skull);
        loot.add(scales);
        loot.add(blood);
        loot.add(flesh);
    }

    @Override
    public void ability(LivingEntity entity) {
        dragonGearAbilities.FireDragonsteelAbility(entity);
    }

    /**
     * Shoots a flame trail and chars blocks where the flame hits
     * @return A runnable creating the flame trial
     * @see DragonGearAbilities
     */
    @Override
    public void triggerBreathAttack() {
        if (this instanceof LivingEntity) {
            Projectile projectile = ((LivingEntity) this).launchProjectile(DragonFireball.class);
            new BukkitRunnable() {
                org.bukkit.World world = projectile.getWorld(); // get the world
                Location loc = projectile.getLocation(); // get the location

                // create constants used in calculations
                final double velocityMultiplier = CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.BreathAttack.VelocityMultiplier");
                final int radiusConstant = CustomConfig.getMobConfig().getInt("Dragons.FireDragon.BreathAttack.RadiusConstant");
                final int decayTicks = CustomConfig.getMobConfig().getInt("Dragons.FireDragon.BreathAttack.DecayTicks");

                final Vector velocity = projectile.getVelocity().multiply(velocityMultiplier * getStage()); // determine the velocity of the flame trail
                final int radius = getStage() + radiusConstant; // determine the radius of charring
                int ticks = 0; // temp variable to store how long the trail has been moving

                @Override
                public void run() {
                    // if the flame trail intersects a liquid or solid block
                    if (! (loc.getBlock().isEmpty()) ) {
                        Location newLoc = loc.clone(); // get the flame trail's location

                        // while the block at the location is solid
                        while (!(newLoc.getBlock().isEmpty()) ) {
                            // iterate 1 block at a time until an air block is reached
                            newLoc.setY(newLoc.getY() + 1D);
                            if (newLoc.getBlock().isEmpty()) {
                                break;
                            }
                            if (loc.toVector().distance(newLoc.toVector()) > radius) {
                                break;
                            }

                        }
                        // iterate over the surrounding area of the impact location
                        for (int x = -radius; x < radius; x++) {
                            for (int y = -radius; y < radius; y++) {
                                for (int z = -radius; z < radius; z++) {

                                    // if the location is within the specified radius
                                    if (!(Math.hypot(Math.hypot(x, y), z) > radius) ) {

                                        // store the upper and lower block info
                                        Location loc = Utils.modifyLocation(newLoc, x, y, z);
                                        Location secondLoc = Utils.modifyLocation(newLoc, x, y - 1, z);
                                        Block block = loc.getBlock();
                                        Material blockMaterial = block.getType();
                                        Block secondBlock = secondLoc.getBlock();

                                        // if the upper block is air or translucent like grass
                                        if (block.isEmpty() || !blockMaterial.isOccluding()) {
                                            // if the upper block is not liquid
                                            if (!block.isLiquid()) {
                                                // if the lower block is solid
                                                if (!secondBlock.isEmpty()) {
                                                    // set the upper block on fire
                                                    world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.FireDragon.BreathAttack.LayerBlock")));
                                                }
                                            }
                                        }
                                        // if the upper block is solid
                                        else {
                                            // check if the upper block is immune to fire breath attacks
                                            if (!CustomConfig.getMobConfig().getStringList("Dragons.FireDragon.BreathAttack.ImmuneBlocks").contains(blockMaterial.toString())) {
                                                // if the upper block is solid
                                                if (!block.isLiquid()) {
                                                    // if the upper block is burnable like wood
                                                    if (blockMaterial.isFuel()) {
                                                        // set the upper block to a burnt block
                                                        world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.FireDragon.BreathAttack.BurntBlock")));
                                                    }
                                                    // if the upper block is not burnable
                                                    else {
                                                        // set the upper block to a charred block
                                                        world.getBlockAt(loc).setType(Material.valueOf(CustomConfig.getMobConfig().getString("Dragons.FireDragon.BreathAttack.CharredBlock")));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        // auto-cancel
                        cancel();
                    }
                    // iterate ticks
                    ticks++;

                    // if flame trail has traveled for too long, cancel
                    if (ticks > decayTicks) {
                        cancel();
                    }

                    // begin checking for trail-entity collisions
                    if (ticks > 10) {
                        // if the flame trail intersects an entity
                        if (!loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2).isEmpty()) {
                            Collection<Entity> collection = loc.getWorld().getNearbyEntities(loc, radius - 2, radius - 2, radius - 2); // get the entities

                            // check every entity
                            for (Entity e : collection) {
                                // if the entity can be hurt
                                if (e instanceof LivingEntity) {
                                    // check if entity is not a fire dragon
                                    if (!(e instanceof FireDragon)) {
                                        // set entity on fire
                                        ability((LivingEntity) e);
                                    }
                                }
                            }
                        }
                    }

                    // summon a flame particle
                    world.spawnParticle(Particle.FLAME, loc, 5, 0.1, 0.1, 0.1, 0, null, true);

                    // update location values
                    loc.setX(loc.getX() + velocity.getX());
                    loc.setY(loc.getY() + velocity.getY());
                    loc.setZ(loc.getZ() + velocity.getZ());
                }
            }.runTaskTimer(plugin, 0, 1);

            projectile.remove();
        }
    }

    @Override
    public void triggerExplosionAttack() {

    }
}