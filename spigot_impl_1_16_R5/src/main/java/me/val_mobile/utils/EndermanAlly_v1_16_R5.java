/*
    Copyright (C) 2022  Val_Mobile

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

import me.val_mobile.baubles.EndermanAlly;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EndermanAlly_v1_16_R5 extends EntityEnderman implements EndermanAlly {

    private final EntityPlayer owner;

    public EndermanAlly_v1_16_R5(EntityTypes<? extends EntityEnderman> entityTypes, World world) {
        super(entityTypes, world);
        this.owner = null;
        addNbtData();
    }

    public EndermanAlly_v1_16_R5(Player owner, Location loc)
    {
        super(EntityTypes.ENDERMAN, ((CraftWorld)  loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.owner = ((CraftPlayer) owner).getHandle();
        addNbtData();
    }

    @Override
    public Entity getEntity() {
        return this.getBukkitEntity();
    }

    @Override
    public void addEntityToWorld(org.bukkit.World world) {
        ((CraftWorld) world).addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    protected void initPathfinder() {
        goalSelector.a(0, new PathfinderGoalFloat(this));
        goalSelector.a(1, new EndermanFreezeWhenLookedAtGoal_v1_16_R5(this));
        goalSelector.a(3, new FollowOwnerGoal_v1_16_R5(this, 1.0, 10.0F, 2.0F, false));
        goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.0, false));
        goalSelector.a(7, new PathfinderGoalRandomStrollLand(this, 1.0, 0.0F));
        goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        goalSelector.a(10, new EndermanLeaveBlockGoal_v1_16_R5(this));
        goalSelector.a(11, new EndermanTakeBlockGoal_v1_16_R5(this));
        targetSelector.a(1, new OwnerHurtByTargetGoal_v1_16_R5(this));
        targetSelector.a(2, new OwnerHurtTargetGoal_v1_16_R5(this));
        targetSelector.a(3, new EndermanLookForPlayerGoal_v1_16_R5(this, this::a_));
        targetSelector.a(4, new PathfinderGoalHurtByTarget(this).a(new Class[0]));
        targetSelector.a(5, new PathfinderGoalNearestAttackableTarget<>(this, EntityEndermite.class, true, false));
        targetSelector.a(6, new PathfinderGoalUniversalAngerReset<>(this, false));
    }

    @Override
    public Player getOwner() {
        return owner.getBukkitEntity();
    }
}
