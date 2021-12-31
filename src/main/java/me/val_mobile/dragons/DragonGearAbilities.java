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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collection;
/**
 * DragonGearAbilities is a utility class containing methods that
 * execute special abilities of the fire, ice, and lighting dragon weapons
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonGearAbilities {

    // dependency injecting the main class
    private final RealisticSurvivalPlugin plugin;

    // constructing the DragonGearAbilities class
    public DragonGearAbilities(RealisticSurvivalPlugin instance) {
        plugin = instance;
    }

    // collections to hold all the ice blocks
    private static Collection<FallingBlock> iceDragonboneBlocks = new ArrayList<>();
    private static Collection<FallingBlock> iceDragonsteelBlocks = new ArrayList<>();

    /**
     * Gets all the ice blocks created by using ice dragonbone weapons
     * @return A collection containing all the ice blocks created by using ice dragonbone weapons
     */
    public static Collection<FallingBlock> getIceDragonboneBlocks() {
        return iceDragonboneBlocks;
    }

    /**
     * Gets all the ice blocks created by using ice dragonsteel weapons
     * @return A collection containing all the ice blocks created by using ice dragonsteel weapons
     */
    public static Collection<FallingBlock> getIceDragonsteelBlocks() {
        return iceDragonsteelBlocks;
    }

    /**
     * Burns an entity that was hit by a flamed dragonbone weapon
     * @param entity The target entity
     * @see DragonGearAbilities
     */
    public void FireDragonboneAbility(LivingEntity entity) {
        int fireTicks = CustomConfig.getIceFireGearConfig().getInt("Abilities.FlamedDragonbone.FireTicks"); // get the fire ticks

        // if the entity is going to burn for less than the specified fire ticks
        if (entity.getFireTicks() < fireTicks) {
            // set the entity on fire
            entity.setFireTicks(fireTicks);
        }
    }

    /**
     * Burns an entity that was hit by a fire dragonsteel weapon
     * @param entity The target entity
     * @see DragonGearAbilities
     */
    public void FireDragonsteelAbility(LivingEntity entity) {
        int fireTicks = CustomConfig.getIceFireGearConfig().getInt("Abilities.FireDragonsteel.FireTicks"); // get the fire ticks

        // if the entity is going to burn for less than the specified fire ticks
        if (entity.getFireTicks() < fireTicks) {
            // set the entity on fire
            entity.setFireTicks(fireTicks);
        }
    }

    /**
     * Freezes and applies slowness to an entity that was hit by an ice dragonbone weapon
     * @param entity The target entity
     * @see DragonGearAbilities
     * @see DragonGearRunnables
     */
    public void IceDragonboneAbility(LivingEntity entity) {
        // store the duration and amplifier of the slowness effect
        int amplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.IcedDragonbone.Slowness.Amplifier");
        int duration = CustomConfig.getIceFireGearConfig().getInt("Abilities.IcedDragonbone.Slowness.Duration");

        // create the slowness effect using the duration and amplifier variables
        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);

        // add the slowness effect to the target entity
        Utils.smartAddPotionEffect(slowness, entity);

        // freeze the entity
        DragonGearRunnables.freezeEntity(entity).runTaskLater(plugin, 1);

        // encase the entity with ice
        Location loc = entity.getLocation(); // get the location
        Material material = Material.valueOf(CustomConfig.getIceFireGearConfig().getString("Abilities.IcedDragonbone.Block")); // get the material
        FallingBlock block = entity.getWorld().spawnFallingBlock(loc, material.createBlockData()); // create an ice block

        // initialize other temp blocks
        FallingBlock block2;
        FallingBlock block3;

        // make the ice block purely cosmetic and have no effect on entities
        block.setDropItem(false);
        block.setHurtEntities(false);
        block.setGravity(false);
        block.setCustomName("Ice Dragonbone Block");

        // add the ice block to the collection
        getIceDragonboneBlocks().add(block);

        // if the entity is taller than 1 block
        if (entity.getHeight() >= 1.5) {
            // if the entity is taller than 2 blocks
            if (entity.getHeight() >= 2.5) {
                // create two more ice blocks
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());
                loc.setY(loc.getY() + 1.0D);
                block3 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                // make the ice blocks purely cosmetic and have no effect on entities
                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragonbone Block");

                block3.setDropItem(false);
                block3.setHurtEntities(false);
                block3.setGravity(false);
                block3.setCustomName("Ice Dragonbone Block");

                // add the ice blocks to the collection
                getIceDragonboneBlocks().add(block2);
                getIceDragonboneBlocks().add(block3);
            }
            // if the entity is between 1 and 2 blocks tall
            else {
                // create one more ice block
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                // make the ice block purely cosmetic and have no effect on entities
                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragonbone Block");

                // add the ice blocks to the collection
                getIceDragonboneBlocks().add(block2);
            }
        }

        // play the ice break sound effect
        entity.getWorld().playSound(loc, Sound.BLOCK_GLASS_BREAK, 1, 1);

        // remove the ice block after some time
        DragonGearRunnables.removeIceDragonboneBlocks().runTaskLater(plugin, CustomConfig.getIceFireGearConfig().getInt("Abilities.IcedDragonbone.FrozenDuration"));
    }

    /**
     * Freezes and applies slowness to an entity that was hit by an ice dragonsteel weapon
     * @param entity The target entity
     * @see DragonGearAbilities
     * @see DragonGearAbilities
     */
    public void IceDragonsteelAbility(LivingEntity entity) {
        // store the duration and amplifier of the slowness effect
        int amplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.IceDragonsteel.Slowness.Amplifier");
        int duration = CustomConfig.getIceFireGearConfig().getInt("Abilities.IceDragonsteel.Slowness.Duration");

        // create the slowness effect using the duration and amplifier variables
        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);

        // add the slowness effect to the target entity
        Utils.smartAddPotionEffect(slowness, entity);

        // freeze the entity
        DragonGearRunnables.freezeEntity(entity).runTaskLater(plugin, 1);

        // encase the entity with ice
        Location loc = entity.getLocation(); // get the location
        Material material = Material.valueOf(CustomConfig.getIceFireGearConfig().getString("Abilities.IceDragonsteel.Block")); // get the material

        FallingBlock block = entity.getWorld().spawnFallingBlock(loc, material.createBlockData()); // create an ice block

        // initialize other temp blocks
        FallingBlock block2;
        FallingBlock block3;

        // make the ice block purely cosmetic and have no effect on entities
        block.setDropItem(false);
        block.setHurtEntities(false);
        block.setGravity(false);
        block.setCustomName("Ice Dragonsteel Block");

        // add the ice block to the collection
        getIceDragonsteelBlocks().add(block);

        // if the entity is taller than 1 block
        if (entity.getHeight() >= 1.5) {
            // if the entity is taller than 2 blocks
            if (entity.getHeight() >= 2.5) {
                // create two more ice blocks
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());
                loc.setY(loc.getY() + 1.0D);
                block3 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                // make the ice blocks purely cosmetic and have no effect on entities
                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragonsteel Block");

                block3.setDropItem(false);
                block3.setHurtEntities(false);
                block3.setGravity(false);
                block3.setCustomName("Ice Dragonsteel Block");

                // add the ice blocks to the collection
                getIceDragonsteelBlocks().add(block2);
                getIceDragonsteelBlocks().add(block3);
            }
            // if the entity is between 1 and 2 blocks tall
            else {
                // create one more ice block
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                // make the ice block purely cosmetic and have no effect on entities
                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragonsteel Block");

                // add the ice blocks to the collection
                getIceDragonsteelBlocks().add(block2);
            }
        }

        // play the ice break sound effect
        entity.getWorld().playSound(loc, Sound.BLOCK_GLASS_BREAK, 1, 1);

        // remove the ice block after some time
        DragonGearRunnables.removeIceDragonsteelBlocks().runTaskLater(plugin, CustomConfig.getIceFireGearConfig().getInt("Abilities.IceDragonsteel.FrozenDuration"));
    }

    /**
     * Strikes and shocks an entity that was hit by a lightning dragonbone weapon
     * @param entity The target entity
     * @param source The attacker
     * @see DragonGearAbilities
     * @see DragonGearRunnables
     */
    public void LightningDragonboneAbility(LivingEntity entity, LivingEntity source) {
        // strike entity with lightning
        entity.getWorld().strikeLightning(entity.getLocation());

        // shock entity
        DragonGearRunnables.shockEntity(entity, source).runTaskTimer(plugin, 0L, 1);
    }

    /**
     * Strikes and shocks an entity that was hit by a lightning dragonbone weapon
     * @param entity The target entity
     * @param source The attacker
     * @see DragonGearAbilities
     * @see DragonGearRunnables
     */
    public void LightningDragonsteelAbility(LivingEntity entity, LivingEntity source) {
        // strike entity with lightning
        entity.getWorld().strikeLightning(entity.getLocation());

        // shock entity
        DragonGearRunnables.electrocuteEntity(entity, source).runTaskTimer(plugin, 0L, 1);
    }
}