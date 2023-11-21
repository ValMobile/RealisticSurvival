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
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class EndermanFreezeWhenLookedAtGoal_v1_19_R1 extends Goal {
    private final EnderMan enderman;
    @Nullable
    private LivingEntity target;

    public EndermanFreezeWhenLookedAtGoal_v1_19_R1(EnderMan enderman) {
        this.enderman = enderman;
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
    }

    public boolean canUse() {
        target = enderman.getTarget();
        if (!(target instanceof Player)) {
            return false;
        } else {
            double d0 = target.distanceToSqr(enderman);
            return !(d0 > 256.0) && v1_19_R1.isLookingAtMe(enderman, (Player) target);
        }
    }

    public void start() {
        enderman.getNavigation().stop();
    }

    public void tick() {
        this.enderman.getLookControl().setLookAt(target.getX(), target.getEyeY(), target.getZ());
    }
}
