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

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.iceandfire.Siren;
import net.minecraft.server.v1_16_R3.DamageSource;
import net.minecraft.server.v1_16_R3.EntityGuardian;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class Siren_v1_16_R5 extends EntityGuardian implements Siren {

    private final FileConfiguration config;

    public Siren_v1_16_R5(EntityTypes<? extends EntityGuardian> entitytypes, World world) {
        super(entitytypes, world);

        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
        addNbtData();
    }

    public Siren_v1_16_R5(Location loc) {
        super(EntityTypes.GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
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
    public void die(DamageSource damageSource) {
        super.die(damageSource);
        Location loc = this.getBukkitEntity().getLocation();

        ItemStack item = null;
        net.minecraft.server.v1_16_R3.Entity nmsEntity = damageSource.getEntity();
        if (nmsEntity != null) {
            Entity e = nmsEntity.getBukkitEntity();

            if (e != null) {
                if (e instanceof LivingEntity) {
                    item = ((LivingEntity) e).getEquipment().getItemInMainHand();
                }
            }
        }

        Utils.dropLooting(config.getConfigurationSection("Sirens.Drops.ShinyScales"), RSVItem.getItem("shiny_scale"), item, loc);
    }

    @Override
    protected void initPathfinder() {
        super.initPathfinder();
    }
}
