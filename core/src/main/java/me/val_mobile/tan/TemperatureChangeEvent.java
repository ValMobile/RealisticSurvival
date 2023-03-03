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
package me.val_mobile.tan;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class TemperatureChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final UUID id;
    private final double oldTemp;
    private double newTemp;
    private boolean cancelled;

    public TemperatureChangeEvent(Player player, double oldTemp, double newTemp) {
        this.id = player.getUniqueId();
        this.oldTemp = oldTemp;
        this.newTemp = newTemp;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(id);
    }

    public double getNewTemp() {
        return newTemp;
    }

    public double getOldTemp() {
        return oldTemp;
    }

    public void setNewTemp(double newTemp) {
        this.newTemp = newTemp;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
