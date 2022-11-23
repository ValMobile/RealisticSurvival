package me.val_mobile.utils;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

public class OwnerHurtTargetGoal_v1_18_R1 extends TargetGoal {
    private final RSVPet pet;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public OwnerHurtTargetGoal_v1_18_R1(RSVPet pet) {
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
