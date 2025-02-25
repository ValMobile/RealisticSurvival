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
package me.val_mobile.misc;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerItemAcquireEvent extends EntityItemAcquireEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerItemAcquireEvent(@Nonnull Player player, @Nonnull ItemStack item, @Nonnull ItemAcquireCause cause, @Nonnull EquipmentSlot loc, @Nullable ItemStack origItem) {
        super(player, item, cause, loc, origItem);
    }

    public @Nonnull Player getPlayer() {
        return (Player) entity;
    }

    @Nonnull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}