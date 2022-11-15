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
package me.val_mobile.iceandfire;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;

public class ExplosiveBreathBlock {

    private final FallingBlock block;

    public ExplosiveBreathBlock(Location loc, Material material) {
        this.block = loc.getWorld().spawnFallingBlock(loc, material.createBlockData());

        // make the ice block purely cosmetic and have no effect on entities
        block.setGravity(false);
        block.setDropItem(false);
        block.setHurtEntities(false);
        block.setCustomNameVisible(false);
    }

    public FallingBlock getBlock() {
        return block;
    }

    public void remove() {
        block.remove();
    }

    public void teleport(Location loc) {
        block.teleport(loc);
    }
}
