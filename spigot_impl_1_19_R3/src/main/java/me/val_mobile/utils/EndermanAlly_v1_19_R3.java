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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EndermanAlly_v1_19_R3 extends EnderMan implements EndermanAlly {

    private final net.minecraft.world.entity.player.Player owner;

    public EndermanAlly_v1_19_R3(EntityType<? extends EnderMan> entityTypes, Level world) {
        super(entityTypes, world);
        this.owner = null;
        addNbtData();
    }

    public EndermanAlly_v1_19_R3(Player owner, Location loc) {
        super(EntityType.ENDERMAN, ((CraftWorld)  loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        this.owner = ((CraftPlayer) owner).getHandle();
        addNbtData();
    }

    @Override
    public Entity getEntity() {
        return this.getBukkitEntity();
    }

    @Override
    public void addEntityToWorld(World world) {
        ((CraftWorld) world).addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new EndermanFreezeWhenLookedAtGoal_v1_19_R3(this));
        goalSelector.addGoal(3, new FollowOwnerGoal_v1_19_R3(this, 1.0, 10.0F, 2.0F, false));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0, 0.0F));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, net.minecraft.world.entity.player.Player.class, 8.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        goalSelector.addGoal(10, new EndermanLeaveBlockGoal_v1_19_R3(this));
        goalSelector.addGoal(11, new EndermanTakeBlockGoal_v1_19_R3(this));
        targetSelector.addGoal(1, new OwnerHurtByTargetGoal_v1_19_R3(this));
        targetSelector.addGoal(2, new OwnerHurtTargetGoal_v1_19_R3(this));
        targetSelector.addGoal(3, new EndermanLookForPlayerGoal_v1_19_R3(this, this::isAngryAt));
        targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers());
        targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Endermite.class, true, false));
        targetSelector.addGoal(6, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    @Override
    public Player getOwner() {
        return (Player) owner.getBukkitEntity();
    }
}
