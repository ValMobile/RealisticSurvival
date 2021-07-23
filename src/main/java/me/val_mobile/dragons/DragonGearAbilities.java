package me.val_mobile.dragons;

import me.val_mobile.rlcraft.RLCraft;
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
import java.util.List;

public class DragonGearAbilities {

    private final RLCraft plugin;
    public DragonGearAbilities(RLCraft instance) {
        plugin = instance;
    }

    private static List<FallingBlock> iceDragonBoneBlocks = new ArrayList<>();
    private static List<FallingBlock> iceDragonsteelBlocks = new ArrayList<>();

    public static List<FallingBlock> getIceDragonBoneBlocks() {
        return iceDragonBoneBlocks;
    }

    public static List<FallingBlock> getIceDragonsteelBlocks() {
        return iceDragonsteelBlocks;
    }

    public void FireDragonBoneAbility(LivingEntity entity) {

        int fireTicks = CustomConfig.getIceFireGearConfig().getInt("Abilities.FlamedDragonBone.FireTicks");

        if (entity.getFireTicks() < fireTicks) {
            entity.setFireTicks(fireTicks);
        }

    }

    public void FireDragonsteelAbility(LivingEntity entity) {

        int fireTicks = CustomConfig.getIceFireGearConfig().getInt("Abilities.FireDragonsteel.FireTicks");

        if (entity.getFireTicks() < fireTicks) {
            entity.setFireTicks(fireTicks);
        }

    }

    public void IceDragonBoneAbility(LivingEntity entity) {

        int amplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.IcedDragonBone.Slowness.Amplifier");
        int duration = CustomConfig.getIceFireGearConfig().getInt("Abilities.IcedDragonBone.Slowness.Duration");
        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);
        Utils.smartAddPotionEffect(slowness, entity);

        DragonGearRunnables.freezeEntity(entity).runTaskLater(plugin, 1);

        Location loc = entity.getLocation();
        Material material = Material.valueOf(CustomConfig.getIceFireGearConfig().getString("Abilities.IcedDragonBone.Block"));
        FallingBlock block = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());
        FallingBlock block2;
        FallingBlock block3;

        block.setDropItem(false);
        block.setHurtEntities(false);
        block.setGravity(false);
        block.setCustomName("Ice Dragon Bone Block");

        getIceDragonBoneBlocks().add(block);

        if (entity.getHeight() >= 1.5) {
            if (entity.getHeight() >= 2.5) {
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());
                loc.setY(loc.getY() + 1.0D);
                block3 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragon Bone Block");

                block3.setDropItem(false);
                block3.setHurtEntities(false);
                block3.setGravity(false);
                block3.setCustomName("Ice Dragon Bone Block");

                getIceDragonBoneBlocks().add(block2);
                getIceDragonBoneBlocks().add(block3);
            }
            else {
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragon Bone Block");

                getIceDragonBoneBlocks().add(block2);
            }
        }

        entity.getWorld().playSound(loc, Sound.BLOCK_GLASS_BREAK, 1, 1);
        DragonGearRunnables.removeIceDragonBoneBlocks().runTaskLater(plugin, CustomConfig.getIceFireGearConfig().getInt("Abilities.IcedDragonBone.FrozenDuration"));

    }

    public void IceDragonsteelAbility(LivingEntity entity) {

        int amplifier = CustomConfig.getIceFireGearConfig().getInt("Abilities.IceDragonsteel.Slowness.Amplifier");
        int duration = CustomConfig.getIceFireGearConfig().getInt("Abilities.IceDragonsteel.Slowness.Duration");

        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);
        Utils.smartAddPotionEffect(slowness, entity);

        DragonGearRunnables.freezeEntity(entity).runTaskLater(plugin, 1);

        Location loc = entity.getLocation();
        Material material = Material.valueOf(CustomConfig.getIceFireGearConfig().getString("Abilities.IceDragonsteel.Block"));

        FallingBlock block = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());
        FallingBlock block2;
        FallingBlock block3;

        block.setDropItem(false);
        block.setHurtEntities(false);
        block.setGravity(false);
        block.setCustomName("Ice Dragonsteel Block");

        getIceDragonsteelBlocks().add(block);

        if (entity.getHeight() >= 1.5) {
            if (entity.getHeight() >= 2.5) {
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());
                loc.setY(loc.getY() + 1.0D);
                block3 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragonsteel Block");

                block3.setDropItem(false);
                block3.setHurtEntities(false);
                block3.setGravity(false);
                block3.setCustomName("Ice Dragonsteel Block");

                getIceDragonsteelBlocks().add(block2);
                getIceDragonsteelBlocks().add(block3);
            }
            else {
                loc.setY(loc.getY() + 1.0D);
                block2 = entity.getWorld().spawnFallingBlock(loc, material.createBlockData());

                block2.setDropItem(false);
                block2.setHurtEntities(false);
                block2.setGravity(false);
                block2.setCustomName("Ice Dragonsteel Block");

                getIceDragonsteelBlocks().add(block2);
            }
        }
        entity.getWorld().playSound(loc, Sound.BLOCK_GLASS_BREAK, 1, 1);
        DragonGearRunnables.removeIceDragonsteelBlocks().runTaskLater(plugin, CustomConfig.getIceFireGearConfig().getInt("Abilities.IceDragonsteel.FrozenDuration"));

    }

    public void LightningDragonBoneAbility(LivingEntity entity, LivingEntity source) {
        entity.getWorld().strikeLightning(entity.getLocation());
        DragonGearRunnables.shockEntity(entity, source).runTaskTimer(plugin, 0L, 1);
    }

    public void LightningDragonsteelAbility(LivingEntity entity, LivingEntity source) {
        entity.getWorld().strikeLightning(entity.getLocation());
        DragonGearRunnables.electrocuteEntity(entity, source).runTaskTimer(plugin, 0L, 1);
    }
}
