package me.val_mobile.rlcraft;

import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ItemRunnables {

    static List<FallingBlock> iceDragonBoneBlocks = new ArrayList<>();
    static List<FallingBlock> iceDragonsteelBlocks = new ArrayList<>();

    private final RLCraft plugin;
    private final CustomConfig customConfig;
    public ItemRunnables(RLCraft instance) {
        plugin = instance;
        customConfig = new CustomConfig(instance);
    }

    public BukkitRunnable freezeEntity(LivingEntity entity) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                entity.setVelocity(new Vector());
            }
        };
    }

    public BukkitRunnable removeIceDragonBoneBlocks() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                for (FallingBlock b : iceDragonBoneBlocks) {
                    b.remove();
                }
            }
        };
    }

    public BukkitRunnable removeIceDragonsteelBlocks() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                for (FallingBlock b : iceDragonsteelBlocks) {
                    b.remove();
                }
            }
        };
    }

    public BukkitRunnable shockEntity(Entity source, LivingEntity entity) {
        return new BukkitRunnable() {
            int iteration = 1;
            @Override
            public void run() {
                entity.setVelocity(new Vector());
                entity.damage(customConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonBone.ShockDamage"), source);
                iteration++;
                if (iteration > customConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonBone.ShockAmount")) {
                    cancel();
                }
            }
        };
    }

    public BukkitRunnable electrocuteEntity(Entity source, LivingEntity entity) {
        return new BukkitRunnable() {
            int iteration = 1;
            @Override
            public void run() {
                entity.damage(customConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonsteel.ShockDamage"), source);
                entity.setVelocity(new Vector());
                iteration++;
                if (iteration > customConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonsteel.ShockAmount")) {
                    cancel();
                }
            }
        };
    }
}
