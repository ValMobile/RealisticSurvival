package me.val_mobile.utils;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

public class OwnerHurtByTargetGoal extends TargetGoal {
    private final RSVPet pet;
    private LivingEntity ownerLastHurtBy;
    private int timestamp;

    public OwnerHurtByTargetGoal(RSVPet pet) {
        super((Mob) ((CraftEntity) pet.getEntity()).getHandle(), false);
        this.pet = pet;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    public boolean canUse() {
        LivingEntity owner = ((CraftPlayer) pet.getOwner()).getHandle();
        if (owner == null) {
            return false;
        } else {
            this.ownerLastHurtBy = owner.getLastHurtByMob();
            int i = owner.getLastHurtByMobTimestamp();
            return i != timestamp && canAttack(ownerLastHurtBy, TargetingConditions.DEFAULT);
        }
    }

    public void start() {
        mob.setTarget(ownerLastHurtBy, EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER, true);
        LivingEntity entityliving = ((CraftPlayer) pet.getOwner()).getHandle();
        if (entityliving != null) {
            timestamp = entityliving.getLastHurtByMobTimestamp();
        }

        super.start();
    }
}
