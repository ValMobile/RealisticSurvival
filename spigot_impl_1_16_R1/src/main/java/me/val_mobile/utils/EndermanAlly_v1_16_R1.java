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
import net.minecraft.server.v1_16_R1.EntityEnderman;
import net.minecraft.server.v1_16_R1.EntityPlayer;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EndermanAlly_v1_16_R1 extends EntityEnderman implements EndermanAlly {

    private final EntityPlayer owner;

    public EndermanAlly_v1_16_R1(EntityTypes<? extends EntityEnderman> entityTypes, World world) {
        super(entityTypes, world);
        this.owner = null;
    }

    public EndermanAlly_v1_16_R1(Player owner, Location loc)
    {
        super(EntityTypes.ENDERMAN, ((CraftWorld)  loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.owner = ((CraftPlayer) owner).getHandle();
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
        super.initPathfinder();
    }

    @Override
    public Player getOwner() {
        return owner.getBukkitEntity();
    }
}
