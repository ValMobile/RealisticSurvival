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

import org.bukkit.GameMode;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public interface RSVTask {

    void start();

    void stop();

    boolean conditionsMet(@Nullable Player player);

    default boolean globalConditionsMet(@Nullable LivingEntity entity) {
        if (entity != null) {
            if (entity instanceof Player player) {
                GameMode mode = player.getGameMode(); // get the gamemode

                return (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && player.isOnline();
            }
            return true;
        }
        return false;
    }
}
