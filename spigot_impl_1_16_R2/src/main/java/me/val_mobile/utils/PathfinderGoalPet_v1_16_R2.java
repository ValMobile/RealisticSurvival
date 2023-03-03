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

import net.minecraft.server.v1_16_R2.*;

import java.util.EnumSet;

public class PathfinderGoalPet_v1_16_R2 extends PathfinderGoal {

    private final EntityInsentient pet; // our pet
    private EntityLiving owner; // owner
    private final double speed; // pet's speed
    private final float distance; // distance between owner & pet

    public PathfinderGoalPet_v1_16_R2(EntityInsentient a, double speed, float distance) {
        this.pet = a;
        this.speed = speed;
        this.distance = distance;
        this.a(EnumSet.of(PathfinderGoal.Type.MOVE));
    }

    @Override
    public boolean a() {
        // Will start event if this is true
        // runs every tick
        owner = pet.getGoalTarget();
        if (owner == null) {
            return false;
        }
        else if (pet.getDisplayName() == null) {
            return false;
        }
        else if (!(pet.getDisplayName().toString().contains(owner.getName()))) {
            return false;
        }
        else {
            // follow owner
            Vec3D vec = RandomPositionGenerator.a((EntityCreature) pet, 16, 7, owner.getPositionVector());
            // in air
            return vec != null;
            // call upon c()
        }
    }

    @Override
    public void c() {
        // runner :)               x             y             z        speed
        pet.getNavigation().a(owner.locX(), owner.locY(), owner.locZ(), speed);
    }

    @Override
    public boolean b() {
        // run every tick as long as its true (repeats c)
        return !pet.getNavigation().m() && owner.h(pet) < (double) distance * distance;
    }

    @Override
    public void d() {
        // runs when done (b is false)
        owner = null;
    }
}
