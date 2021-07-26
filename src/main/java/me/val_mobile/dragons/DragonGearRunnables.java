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