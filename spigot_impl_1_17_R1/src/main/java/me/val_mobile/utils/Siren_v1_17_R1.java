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

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.iceandfire.Siren;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class Siren_v1_17_R1 extends Guardian implements Siren {

    private final FileConfiguration config;

    public Siren_v1_17_R1(EntityType<? extends Guardian> entitytype, Level world) {
        super(entitytype, world);

        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
        addNbtData();
    }

    public Siren_v1_17_R1(Location loc) {
        super(EntityType.GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

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
        net.minecraft.world.entity.Entity nmsEntity = damageSource.getEntity();
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
    protected void registerGoals() {
        super.registerGoals();
    }
}
