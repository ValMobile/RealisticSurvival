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
package me.val_mobile.data.baubles;

import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class BaubleInventory extends GUI {

    public BaubleInventory(Player player) {
        super(player, 54, "Bauble Bag");

        Inventory inv = getInventory();

        BaubleSlot[] values = BaubleSlot.values();

        for (BaubleSlot slot : values) {
            for (int i : slot.getValues()) {
                if (!RSVItem.isRSVItem(inv.getItem(i))) {
                    inv.setItem(i, slot.getItem());
                }
            }
        }

        ItemStack guiGlass = RSVItem.getItem("gui_glass");

        int size = inv.getSize();

        for (int i = 0; i < size; i++) {
            if (!Utils.isItemReal(inv.getItem(i))) {
                inv.setItem(i, guiGlass);
            }
        }
    }

    public Collection<ItemStack> getAllBaubles() {
        Collection<ItemStack> items = new ArrayList<>();
        BaubleSlot[] values = BaubleSlot.values();

        for (BaubleSlot slot: values) {
            for (int i : slot.getValues()) {
                ItemStack item = getInventory().getItem(i);
                if (RSVItem.isRSVItem(item)) {
                    items.add(item);
                }
            }
        }

        return items;
    }

    public void removeAndDropAllBaubles(Location loc) {
        BaubleSlot[] values = BaubleSlot.values();
        World world = loc.getWorld();
        Inventory inv = getInventory();

        for (BaubleSlot slot: values) {
            for (int i : slot.getValues()) {
                ItemStack item = inv.getItem(i);
                if (RSVItem.isRSVItem(item)) {
                    switch (RSVItem.getNameFromItem(item)) {
                        case "gui_glass", "body_slot", "ring_slot", "charm_slot", "belt_slot", "amulet_slot", "head_slot" -> {}
                        default -> {
                            world.dropItemNaturally(loc, item);
                            inv.setItem(i, slot.getItem());
                        }
                    }
                }
            }
        }
    }

    public void removeAllBaubles() {
        BaubleSlot[] values = BaubleSlot.values();
        Inventory inv = getInventory();

        for (BaubleSlot slot: values) {
            for (int i : slot.getValues()) {
                inv.setItem(i, slot.getItem());
            }
        }
    }

    public Collection<String> getAllBaubleNames() {
        Collection<String> items = new ArrayList<>();
        BaubleSlot[] values = BaubleSlot.values();
        Inventory inv = getInventory();

        for (BaubleSlot slot: values) {
            for (int i : slot.getValues()) {
                ItemStack item = inv.getItem(i);
                if (RSVItem.isRSVItem(item)) {
                    items.add(RSVItem.getNameFromItem(item));
                }
            }
        }

        return items;
    }

    public boolean hasBauble(String name) {
        Player player = Bukkit.getPlayer(getId());

        if (player == null) {
            return false;
        }

//        boolean hasBaubleBag = false;
//        for (ItemStack item : player.getInventory().getStorageContents()) {
//            if (RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).equals("bauble_bag")) {
//                hasBaubleBag = true;
//                break;
//            }
//        }
//
//        if (!hasBaubleBag) {
//            return false;
//        }

        Collection<ItemStack> baubleCol = getAllBaubles();

        for (ItemStack bauble : baubleCol) {
            if (RSVItem.isRSVItem(bauble)) {
                if (RSVItem.getNameFromItem(bauble).equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getBaubleAmount(String name) {
        int sum = 0;
        Collection<ItemStack> baubleCol = getAllBaubles();

        for (ItemStack bauble : baubleCol) {
            if (RSVItem.isRSVItem(bauble)) {
                if (RSVItem.getNameFromItem(bauble).equals(name)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public ItemStack getItem(String name) {
        Collection<ItemStack> items = getAllBaubles();
        for (ItemStack item : items) {
            if (RSVItem.isRSVItem(item)) {
                if (RSVItem.getNameFromItem(item).equals(name)) {
                    return item;
                }
            }
        }
        return null;
    }
}
