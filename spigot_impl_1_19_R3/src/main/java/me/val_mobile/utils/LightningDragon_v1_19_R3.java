/*
    Copyright (C) 2025  Val_Mobile

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

import me.val_mobile.iceandfire.DragonVariant;
import me.val_mobile.iceandfire.LightningDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;
import org.bukkit.Location;

import static me.val_mobile.iceandfire.DragonBreed.LIGHTNING;

public class LightningDragon_v1_19_R3 extends Dragon_v1_19_R3 implements LightningDragon {

    public LightningDragon_v1_19_R3(EntityType<? extends EnderDragon> entityType, Level world) {
        super(entityType, world, LIGHTNING);
    }

    public LightningDragon_v1_19_R3(Location loc) {
        super(loc, LIGHTNING);
    }

    public LightningDragon_v1_19_R3(Location loc, int stage) {
        super(loc, LIGHTNING, stage);
    }

    public LightningDragon_v1_19_R3(Location loc, DragonVariant variant) {
        super(loc, LIGHTNING, variant);
    }

    public LightningDragon_v1_19_R3(Location loc, DragonVariant variant, int stage) {
        super(loc, LIGHTNING, variant, stage);
    }
}