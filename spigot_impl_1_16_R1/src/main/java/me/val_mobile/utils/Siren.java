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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.server.v1_16_R1.EntityGuardian;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.persistence.PersistentDataType;

public class Siren extends EntityGuardian implements RSVMob {

    public Siren(Location loc) {
        super(EntityTypes.GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
    }

    public Siren(EntityTypes<? extends EntityGuardian> entitytypes, World world) {
        super(entitytypes, world);
    }

    @Override
    public void addNbtData() {
        Utils util = RealisticSurvivalPlugin.getUtil();
        CraftEntity entity = this.getBukkitEntity();
        util.addNbtTag(entity, "rsvmob", "siren", PersistentDataType.STRING);
    }
}
