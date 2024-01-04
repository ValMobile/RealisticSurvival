/*
    Copyright (C) 2023  Val_Mobile

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
package me.val_mobile.utils;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class PathfinderGoalPet_v1_20_R5 extends Goal {

    private final Mob pet; // our pet
    private LivingEntity owner; // owner
    private final double speed; // pet's speed
    private final float distance; // distance between owner & pet

    public PathfinderGoalPet_v1_20_R5(Mob pet, double speed, float distance) {
        this.pet = pet;
        this.speed = speed;
        this.distance = distance;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public void tick() {
        pet.getNavigation().moveTo(owner.getX(), owner.getY(), owner.getZ(), speed);
    }

    @Override
    public boolean canUse() {
        owner = pet.getTarget();
        if (owner == null) {
            return false;
        }
        else if (pet.getDisplayName() == null) {
            return false;
        }
        else if (!pet.getDisplayName().toString().contains(owner.getName().toString())) {
            return false;
        }
        else {
            if (pet.getBukkitEntity().getLocation().getBlock().isEmpty()) {
                return false;
            }
            return !pet.getNavigation().isDone() && owner.distanceToSqr(pet) < (double) distance * distance;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return canUse();
    }
}
