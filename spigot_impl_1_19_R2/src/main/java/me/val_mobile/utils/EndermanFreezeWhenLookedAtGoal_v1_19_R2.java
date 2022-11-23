package me.val_mobile.utils;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class EndermanFreezeWhenLookedAtGoal_v1_19_R2 extends Goal {
    private final EnderMan enderman;
    @Nullable
    private LivingEntity target;

    public EndermanFreezeWhenLookedAtGoal_v1_19_R2(EnderMan enderman) {
        this.enderman = enderman;
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
    }

    public boolean canUse() {
        target = enderman.getTarget();
        if (!(target instanceof Player)) {
            return false;
        } else {
            double d0 = target.distanceToSqr(enderman);
            return !(d0 > 256.0) && v1_19_R2.isLookingAtMe(enderman, (Player) target);
        }
    }

    public void start() {
        enderman.getNavigation().stop();
    }

    public void tick() {
        this.enderman.getLookControl().setLookAt(target.getX(), target.getEyeY(), target.getZ());
    }
}
