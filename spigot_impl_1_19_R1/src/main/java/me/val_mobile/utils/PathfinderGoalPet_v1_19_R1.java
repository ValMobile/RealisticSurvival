/*
    Copyright (C) 2022  Val_Mobile

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

public class PathfinderGoalPet_v1_19_R1 extends Goal {

    private final Mob mob; // our pet
    private LivingEntity owner; // owner
    private final double speed; // pet's speed
    private final float distance; // distance between owner & pet

    public PathfinderGoalPet_v1_19_R1(Mob mob, double speed, float distance) {
        this.mob = mob;
        this.speed = speed;
        this.distance = distance;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public void tick() {
        this.mob.getNavigation().moveTo(owner.getX(), owner.getY(), owner.getZ(), speed);
    }

    @Override
    public boolean canUse() {
        this.owner = this.mob.getTarget();
        if (this.owner == null) {
            return false;
        }
        else if (this.mob.getDisplayName() == null) {
            return false;
        }
        else if (!(this.mob.getDisplayName().toString().contains(owner.getName().toString()))) {
            return false;
        }
        else {
            if (mob.getBukkitEntity().getLocation().getBlock().isEmpty()) {
                return false;
            }
            return !mob.getNavigation().isDone() && owner.distanceToSqr(mob) < (double) distance * distance;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return canUse();
    }
}
