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

import me.val_mobile.data.RSVModule;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nullable;

public enum DragonGeneration {
    ADULT,
    TEENAGER,
    CHILD;

    @Nullable
    public static DragonGeneration getGeneration(int age) {
        FileConfiguration config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

        if (age >= config.getInt("Dragons.AdultStage")) {
            return ADULT;
        }
        else if (age >= config.getInt("Dragons.TeenagerStage")) {
            return TEENAGER;
        }
        else if (age >= config.getInt("Dragons.ChildStage")) {
            return CHILD;
        }
        return null;
    }
}
