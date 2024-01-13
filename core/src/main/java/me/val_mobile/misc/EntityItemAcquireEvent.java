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
package me.val_mobile.misc;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public class EntityItemAcquireEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    protected final LivingEntity entity;
    private final ItemStack item;
    private final ItemAcquireCause cause;

    private final EquipmentSlot loc;
    private final ItemStack origItem;

    public EntityItemAcquireEvent(@Nonnull LivingEntity entity, @Nonnull ItemStack item, @Nonnull ItemAcquireCause cause, @Nonnull EquipmentSlot loc, @Nullable ItemStack origItem) {
        this.entity = entity;
        this.item = item;
        this.cause = cause;
        this.loc = loc;
        this.origItem = origItem;
    }

    public @Nonnull LivingEntity getEntity() {
        return entity;
    }

    public @Nonnull ItemStack getItem() {
        return item;
    }

    public @Nonnull ItemAcquireCause getCause() {
        return cause;
    }

    public @Nonnull EquipmentSlot getLocation() {
        return loc;
    }

    public @Nullable ItemStack getOriginalItem() {
        return origItem;
    }

    public enum ItemAcquireCause {
        SHULKER_BOX_WASH, BANNER_WASH, LEATHER_ARMOR_WASH, ARMOR_STAND, ARMOR_DISPENSE, ARMOR_RIGHT_CLICK, PLAYER_JOIN, PLAYER_RESPAWN, ENTITY_SPAWN, ITEM_HELD, GIVE_COMMAND, SWAP_HANDS, ITEM_PICKUP, INVENTORY_CLICK, DRAG_CLICK, BOTTLE_EMPTY, BOTTLE_FILL, BUCKET_EMPTY, BUCKET_FILL_MOB, BUCKET_FILL_LIQUID, FOOD_CONSUME
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