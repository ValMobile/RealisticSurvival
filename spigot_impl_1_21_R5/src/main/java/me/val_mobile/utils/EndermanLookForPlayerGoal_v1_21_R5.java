/*
    Copyright (C) 2025  Val_Mobile

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

import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public class EndermanLookForPlayerGoal_v1_21_R5 extends NearestAttackableTargetGoal<Player> {
    private final EnderMan enderman;
    @Nullable
    private Player pendingTarget;
    private int aggroTime;
    private int teleportTime;
    private final TargetingConditions startAggroTargetConditions;
    private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();
    private final TargetingConditions.Selector isAngerInducing;

    public EndermanLookForPlayerGoal_v1_21_R5(EnderMan enderman, @Nullable TargetingConditions.Selector pathfindertargetcondition_a) {
        super(enderman, Player.class, 10, false, false, pathfindertargetcondition_a);
        this.enderman = enderman;
        this.isAngerInducing = (entityliving, worldserver) -> (v1_21_R5.isLookingAtMe(enderman, (Player) entityliving) || enderman.isAngryAt(entityliving, worldserver)) && !enderman.hasIndirectPassenger(entityliving);
        this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector(this.isAngerInducing);
    }

    public boolean canUse() {
        this.pendingTarget = getServerLevel(this.enderman).getNearestPlayer(this.startAggroTargetConditions.range(this.getFollowDistance()), this.enderman);
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
            if (v1_21_R5.isLookingAtMe(enderman, pendingTarget)) {
                enderman.lookAt(pendingTarget, 10.0F, 10.0F);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return target != null && continueAggroTargetConditions.test(getServerLevel(this.enderman), enderman, target) || super.canContinueToUse();
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
                if (v1_21_R5.isLookingAtMe(enderman, (Player) target)) {
                    if (target.distanceToSqr(enderman) < 16.0) {
                        enderman.teleport();
                    }
                    teleportTime = 0;
                }
                else if (target.distanceToSqr(enderman) > 256.0 && teleportTime++ >= adjustedTickDelay(30) && v1_21_R5.teleportTowards(enderman, target)) {
                    teleportTime = 0;
                }
            }
            super.tick();
        }
    }
}
