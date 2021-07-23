package me.val_mobile.dragons;

import me.val_mobile.utils.CustomConfig;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DragonGearRunnables {

    public static BukkitRunnable freezeEntity(LivingEntity entity) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                entity.setVelocity(new Vector());
            }
        };
    }

    public static BukkitRunnable removeIceDragonBoneBlocks() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                for (FallingBlock b : DragonGearAbilities.getIceDragonBoneBlocks()) {
                    b.remove();
                }
            }
        };
    }

    public static BukkitRunnable removeIceDragonsteelBlocks() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                for (FallingBlock b : DragonGearAbilities.getIceDragonsteelBlocks()) {
                    b.remove();
                }
            }
        };
    }

    public static BukkitRunnable shockEntity(Entity source, LivingEntity entity) {
        return new BukkitRunnable() {
            int iteration = 1;
            @Override
            public void run() {
                entity.setVelocity(new Vector());
                entity.damage(CustomConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonBone.ShockDamage"), source);
                iteration++;
                if (iteration > CustomConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonBone.ShockAmount")) {
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable electrocuteEntity(Entity source, LivingEntity entity) {
        return new BukkitRunnable() {
            int iteration = 1;
            @Override
            public void run() {
                entity.damage(CustomConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonsteel.ShockDamage"), source);
                entity.setVelocity(new Vector());
                iteration++;
                if (iteration > CustomConfig.getIceFireGearConfig().getInt("Abilities.LightningDragonsteel.ShockAmount")) {
                    cancel();
                }
            }
        };
    }
}
