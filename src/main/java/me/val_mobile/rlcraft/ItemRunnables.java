package me.val_mobile.rlcraft;

import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ItemRunnables {

    List<FallingBlock> iceDragonBoneBlocks = new ArrayList<>();
    List<FallingBlock> iceDragonsteelBlocks = new ArrayList<>();

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

    public BukkitRunnable shockEntity(LivingEntity entity) {
        return new BukkitRunnable() {
            int iteration = 0;
            @Override
            public void run() {
                entity.damage(0.1);
                iteration++;
                if (iteration > 9) {
                    cancel();
                }
            }
        };
    }

    public BukkitRunnable electrocuteEntity(LivingEntity entity) {
        return new BukkitRunnable() {
            int iteration = 0;
            @Override
            public void run() {
                entity.damage(0.2);
                iteration++;
                if (iteration > 19) {
                    cancel();
                }
            }
        };
    }
}
