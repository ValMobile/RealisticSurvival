package me.val_mobile.utils;

import net.minecraft.server.v1_16_R1.*;

import java.util.EnumSet;

public class PathfinderGoalPet extends PathfinderGoal {

    private EntityInsentient a; // our pet
    private EntityLiving b; // owner

    private double f; // pet's speed
    private float g; // distance between owner & pet

    private double c; // x
    private double d; // y
    private double e; // z


    public PathfinderGoalPet(EntityInsentient a, double speed, float distance) {
        this.a = a;
        this.f = speed;
        this.g = distance;
        this.a(EnumSet.of(PathfinderGoal.Type.MOVE));
    }

    @Override
    public boolean a() {
        // Will start event if this is true
        // runs every tick
        this.b = this.a.getGoalTarget();
        if (this.b == null) {
            return false;
        }
        else if (this.a.getDisplayName() == null) {
            return false;
        }
        else if (!(this.a.getDisplayName().toString().contains(this.b.getName()))) {
            return false;
        }
        else if (this.b.h(this.a) > (double) (this.g * this.g)) {
            // distance is too far then teleport pet
            a.setPosition(this.b.locX(), this.b.locY(), this.b.locZ());
            return false;
        }
        else {
            // follow owner
            Vec3D vec = RandomPositionGenerator.a((EntityCreature) this.a, 16, 7, this.b.getPositionVector());
            // in air
            if (vec == null)
                return false;
            this.c = this.b.locX(); // x
            this.d = this.b.locY(); // y
            this.e = this.b.locZ(); // z
            return true;
            // call upon c()
        }
    }

    public void c() {
        // runner :)                x      y        z    speed
        this.a.getNavigation().a(this.c, this.d, this.e, this.f);
    }

    public boolean b() {
        // run every tick as long as its true (repeats c)
        return !this.a.getNavigation().m() && this.b.h(this.a) < (double) (this.g * this.g);
    }

    public void d() {
        // runs when done (b is false)
        this.b = null;
    }
}
