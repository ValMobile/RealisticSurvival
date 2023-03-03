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

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public interface RSVMob {

    static boolean isMob(Entity entity) {
        return Utils.hasNbtTag(entity, "rsvmob");
    }

    static String getMob(Entity entity) {
        return Utils.getNbtTag(entity, "rsvmob", PersistentDataType.STRING);
    }

    void addNbtData();

    Entity getEntity();

    void addEntityToWorld(World world);
}
