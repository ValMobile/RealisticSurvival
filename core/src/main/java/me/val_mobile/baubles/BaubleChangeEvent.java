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
package me.val_mobile.baubles;

import me.val_mobile.utils.RSVItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class BaubleChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final UUID id;
    private final ItemStack bauble;
    private final BaubleChange change;

    public BaubleChangeEvent(Player player, ItemStack bauble, BaubleChange change) {
        this.id = player.getUniqueId();
        this.bauble = bauble;
        this.change = change;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(id);
    }

    public ItemStack getBauble() {
        return bauble;
    }

    public String getBaubleName() {
        return RSVItem.getNameFromItem(bauble);
    }

    public BaubleChange getChange() {
        return change;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
