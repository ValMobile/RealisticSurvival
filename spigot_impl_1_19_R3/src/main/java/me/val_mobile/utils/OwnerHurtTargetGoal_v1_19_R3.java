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
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

public class OwnerHurtTargetGoal_v1_19_R3 extends TargetGoal {
    private final RSVPet pet;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public OwnerHurtTargetGoal_v1_19_R3(RSVPet pet) {
        super((Mob) ((CraftEntity) pet.getEntity()).getHandle(), false);
        this.pet = pet;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {

        LivingEntity owner = ((CraftPlayer) pet.getOwner()).getHandle();
        if (owner == null) {
            return false;
        } else {
            ownerLastHurt = owner.getLastHurtMob();
            int i = owner.getLastHurtMobTimestamp();
            return i != timestamp && canAttack(ownerLastHurt, TargetingConditions.DEFAULT);
        }
    }

    public void start() {
        mob.setTarget(ownerLastHurt, EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET, true);
        LivingEntity owner = ((CraftPlayer) pet.getOwner()).getHandle();
        if (owner != null) {
            timestamp = owner.getLastHurtMobTimestamp();
        }

        super.start();
    }
}
