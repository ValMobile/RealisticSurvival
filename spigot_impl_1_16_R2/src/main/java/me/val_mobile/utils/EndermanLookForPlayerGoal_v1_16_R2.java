package me.val_mobile.utils;

import net.minecraft.server.v1_16_R2.*;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EndermanLookForPlayerGoal_v1_16_R2 extends PathfinderGoalNearestAttackableTarget<EntityPlayer> {
    private final EntityEnderman enderman;
    @Nullable
    private EntityHuman pendingTarget;
    private int aggroTime;
    private int teleportTime;
    private final PathfinderTargetCondition startAggroTargetConditions;
    private final PathfinderTargetCondition continueAggroTargetConditions = PathfinderTargetCondition.a.a();
    public EndermanLookForPlayerGoal_v1_16_R2(EntityEnderman enderman, @Nullable Predicate<EntityLiving> predicate) {
        super(enderman, EntityPlayer.class, 10, false, false, predicate);
        this.enderman = enderman;
        this.startAggroTargetConditions = PathfinderTargetCondition.a.a(k()).a((entityliving) -> v1_16_R2.isLookingAtMe(enderman, (EntityPlayer) entityliving));
    }

    public boolean a() {
        pendingTarget = enderman.world.a(startAggroTargetConditions, enderman);
        return pendingTarget != null;
    }

    public void c() {
        aggroTime = 5;
        teleportTime = 0;
        enderman.eP();
    }

    public void d() {
        pendingTarget = null;
        super.d();
    }

    public boolean b() {
        if (pendingTarget != null) {
            if (v1_16_R2.isLookingAtMe(enderman, pendingTarget)) {
                enderman.a(pendingTarget, 10.0F, 10.0F);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return c != null && continueAggroTargetConditions.a(enderman, c) || super.b();
        }
    }

    public void e() {
        if (enderman.getGoalTarget() == null) {
            super.a((EntityLiving) null);
        }
        if (pendingTarget != null) {
            if (--aggroTime <= 0) {
                c = pendingTarget;
                pendingTarget = null;
                super.e();
            }
        }
        else {
            if (c != null && !enderman.isPassenger()) {
                if (v1_16_R2.isLookingAtMe(enderman, (EntityPlayer) c)) {
                    if (c.h(enderman) < 16.0) {
                        v1_16_R2.teleport(enderman);
                    }
                    teleportTime = 0;
                }
                else if (c.h(enderman) > 256.0 && teleportTime++ >= 30 && v1_16_R2.teleportTowards(enderman, c)) {
                    teleportTime = 0;
                }
            }
            super.e();
        }
    }
}
