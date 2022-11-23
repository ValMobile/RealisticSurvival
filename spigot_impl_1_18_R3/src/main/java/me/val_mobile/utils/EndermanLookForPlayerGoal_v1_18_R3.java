package me.val_mobile.utils;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EndermanLookForPlayerGoal_v1_18_R3 extends NearestAttackableTargetGoal<Player> {
    private final EnderMan enderman;
    @Nullable
    private Player pendingTarget;
    private int aggroTime;
    private int teleportTime;
    private final TargetingConditions startAggroTargetConditions;
    private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();
    public EndermanLookForPlayerGoal_v1_18_R3(EnderMan enderman, @Nullable Predicate<LivingEntity> predicate) {
        super(enderman, Player.class, 10, false, false, predicate);
        this.enderman = enderman;
        this.startAggroTargetConditions = TargetingConditions.forCombat().range(getFollowDistance()).selector((entityliving) -> v1_18_R3.isLookingAtMe(enderman, (Player) entityliving));
    }

    public boolean canUse() {
        pendingTarget = enderman.level.getNearestPlayer(startAggroTargetConditions, enderman);
        return pendingTarget != null;
    }

    public void start() {
        aggroTime = adjustedTickDelay(5);
        teleportTime = 0;
        enderman.setBeingStaredAt();
    }

    public void stop() {
        pendingTarget = null;
        super.stop();
    }

    public boolean canContinueToUse() {
        if (pendingTarget != null) {
            if (v1_18_R3.isLookingAtMe(enderman, pendingTarget)) {
                enderman.lookAt(pendingTarget, 10.0F, 10.0F);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return target != null && continueAggroTargetConditions.test(enderman, target) || super.canContinueToUse();
        }
    }

    public void tick() {
        if (enderman.getTarget() == null) {
            super.setTarget(null);
        }
        if (pendingTarget != null) {
            if (--aggroTime <= 0) {
                target = pendingTarget;
                pendingTarget = null;
                super.start();
            }
        }
        else {
            if (target != null && !enderman.isPassenger()) {
                if (v1_18_R3.isLookingAtMe(enderman, (Player) target)) {
                    if (target.distanceToSqr(enderman) < 16.0) {
                        v1_18_R3.teleport(enderman);
                    }
                    teleportTime = 0;
                }
                else if (target.distanceToSqr(enderman) > 256.0 && teleportTime++ >= adjustedTickDelay(30) && v1_18_R3.teleportTowards(enderman, target)) {
                    teleportTime = 0;
                }
            }
            super.tick();
        }
    }
}
