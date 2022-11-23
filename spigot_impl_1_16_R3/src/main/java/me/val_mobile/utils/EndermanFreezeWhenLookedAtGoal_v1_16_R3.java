package me.val_mobile.utils;

import net.minecraft.server.v1_16_R2.EntityEnderman;
import net.minecraft.server.v1_16_R2.EntityLiving;
import net.minecraft.server.v1_16_R2.EntityPlayer;
import net.minecraft.server.v1_16_R2.PathfinderGoal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class EndermanFreezeWhenLookedAtGoal_v1_16_R3 extends PathfinderGoal {
    private final EntityEnderman enderman;
    @Nullable
    private EntityLiving target;

    public EndermanFreezeWhenLookedAtGoal_v1_16_R3(EntityEnderman enderman) {
        this.enderman = enderman;
        this.a(EnumSet.of(Type.JUMP, Type.MOVE));
    }

    public boolean a() {
        target = enderman.getGoalTarget();
        if (!(target instanceof EntityPlayer)) {
            return false;
        } else {
            double d0 = target.h(enderman);
            return !(d0 > 256.0) && v1_16_R3.isLookingAtMe(enderman, (EntityPlayer) target);
        }
    }

    public void c() {
        enderman.getNavigation().o();
    }

    public void e() {
        this.enderman.getControllerLook().a(target.locX(), target.getHeadY(), target.locZ());
    }
}
