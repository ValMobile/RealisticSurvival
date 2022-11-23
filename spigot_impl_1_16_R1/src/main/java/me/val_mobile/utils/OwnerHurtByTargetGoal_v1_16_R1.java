package me.val_mobile.utils;

import net.minecraft.server.v1_16_R1.EntityInsentient;
import net.minecraft.server.v1_16_R1.EntityLiving;
import net.minecraft.server.v1_16_R1.PathfinderGoalTarget;
import net.minecraft.server.v1_16_R1.PathfinderTargetCondition;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

public class OwnerHurtByTargetGoal_v1_16_R1 extends PathfinderGoalTarget {
    private final RSVPet pet;
    private EntityLiving ownerLastHurtBy;
    private int timestamp;

    public OwnerHurtByTargetGoal_v1_16_R1(RSVPet pet) {
        super((EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle(), false);
        this.pet = pet;
        this.a(EnumSet.of(Type.TARGET));
    }

    public boolean a() {
        EntityLiving owner = (EntityLiving) ((CraftEntity) pet.getOwner()).getHandle();
        if (owner == null) {
            return false;
        } else {
            this.ownerLastHurtBy = owner.getLastDamager();
            int i = owner.cZ();
            return i != timestamp && a(ownerLastHurtBy, PathfinderTargetCondition.a);
        }
    }

    public void c() {
        e.setGoalTarget(ownerLastHurtBy, EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER, true);
        EntityLiving entityliving = ((CraftPlayer) pet.getOwner()).getHandle();
        if (entityliving != null) {
            timestamp = entityliving.cZ();
        }

        super.c();
    }
}
