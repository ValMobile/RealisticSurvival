/*
    Copyright (C) 2024  Val_Mobile

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

import me.val_mobile.iceandfire.SeaSerpent;
import me.val_mobile.iceandfire.SeaSerpentVariant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.List;

public class SeaSerpent_v1_19_R4 extends ElderGuardian implements SeaSerpent {

    private final SeaSerpentVariant variant;
    
    public SeaSerpent_v1_19_R4(EntityType<? extends ElderGuardian> entitytype, Level world) {
        super(entitytype, world);

        List<SeaSerpentVariant> enabledVariants = SeaSerpentVariant.getEnabledVariants();
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));
        setup();
    }

    public SeaSerpent_v1_19_R4(Location loc) {
        super(EntityType.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        List<SeaSerpentVariant> enabledVariants = SeaSerpentVariant.getEnabledVariants();
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));

        setup();
    }

    public SeaSerpent_v1_19_R4(Location loc, SeaSerpentVariant variant) {
        super(EntityType.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.variant = variant.isEnabled() ? variant : null;

        setup();
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
        super.registerGoals();
    }

    @Override
    public SeaSerpentVariant getVariant() {
        return variant;
    }
}
