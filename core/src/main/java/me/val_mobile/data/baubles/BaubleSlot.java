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
package me.val_mobile.data.baubles;

import me.val_mobile.utils.RSVItem;
import org.bukkit.inventory.ItemStack;

public enum BaubleSlot {

    HEAD("Head", RSVItem.getItem("head_slot"), 12),
    AMULET("Amulet", RSVItem.getItem("amulet_slot"), 21),
    BODY("Body", RSVItem.getItem("body_slot"), 30),
    RING("Ring", RSVItem.getItem("ring_slot"), 14, 23),
    CHARM("Charm", RSVItem.getItem("charm_slot"), 32),
    BELT("Belt", RSVItem.getItem("belt_slot"), 31);

    private final int[] vals;
    private final String tag;
    private final ItemStack item;

    BaubleSlot(String tag, ItemStack item, int... vals) {
        this.vals = vals;
        this.tag = tag;
        this.item = item;
    }

    public int[] getValues() {
        return vals;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getTag() {
        return tag;
    }
}
