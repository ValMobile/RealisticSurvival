package me.val_mobile.utils;

import net.minecraft.server.v1_16_R3.EntityInsentient;
import net.minecraft.server.v1_16_R3.EntityLiving;
import net.minecraft.server.v1_16_R3.PathfinderGoalTarget;
import net.minecraft.server.v1_16_R3.PathfinderTargetCondition;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

public class OwnerHurtTargetGoal_v1_16_R5 extends PathfinderGoalTarget {
    private final RSVPet pet;
    private EntityLiving ownerLastHurt;
    private int timestamp;

    public OwnerHurtTargetGoal_v1_16_R5(RSVPet pet) {
        super((EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle(), false);
        this.pet = pet;
        this.a(EnumSet.of(Type.TARGET));
    }

    public boolean a() {

        EntityLiving owner = ((CraftPlayer) pet.getOwner()).getHandle();
        if (owner == null) {
            return false;
        } else {
            ownerLastHurt = owner.db();
            int i = owner.dc();
            return i != timestamp && a(ownerLastHurt, PathfinderTargetCondition.a);
        }
    }

    public void c() {
        e.setGoalTarget(ownerLastHurt, EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET, true);
        EntityLiving owner = ((CraftPlayer) pet.getOwner()).getHandle();
        if (owner != null) {
            timestamp = owner.dc();
        }

        super.c();
    }
}
