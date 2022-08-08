package me.val_mobile.data.baubles;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.HashMap;

public class BaubleInventory extends GUI {

    public BaubleInventory(Player player) {
        super(player, 54, "Bauble Bag");
        Inventory inv = getInv();
        int size = inv.getSize();

        inv = Bukkit.createInventory(player, size, "Bauble Bag");

        inv.setItem(BaubleSlot.HEAD.getValue(), RSVItem.getItem("head_slot"));
        inv.setItem(BaubleSlot.AMULET.getValue(), RSVItem.getItem("amulet_slot"));
        inv.setItem(BaubleSlot.BODY.getValue(), RSVItem.getItem("body_slot"));
        inv.setItem(BaubleSlot.FIRST_RING.getValue(), RSVItem.getItem("ring_slot"));
        inv.setItem(BaubleSlot.SECOND_RING.getValue(), RSVItem.getItem("ring_slot"));
        inv.setItem(BaubleSlot.CHARM.getValue(), RSVItem.getItem("charm_slot"));
        inv.setItem(BaubleSlot.BELT.getValue(), RSVItem.getItem("belt_slot"));

        ItemStack guiGlass = RSVItem.getItem("gui_glass");

        for (int i = 0; i < size; i++) {
            if (!Utils.isItemReal(inv.getItem(i))) {
                inv.setItem(i, guiGlass);
            }
        }

        getDisallowedItems().add(RSVItem.getItem("gui_glass"));
    }

    public ItemStack getBauble(BaubleSlot baubleSlot) {
        return getInv().getItem(baubleSlot.getValue());
    }

    public boolean hasBauble(String name) {
        Collection<ItemStack> baubles = getBaubles().values();

        for (ItemStack bauble : baubles) {
            if (RSVItem.getNameFromItem(bauble).equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getBaubleAmount(String name) {
        int sum = 0;
        Collection<ItemStack> baubles = getBaubles().values();

        for (ItemStack bauble : baubles) {
            if (RSVItem.getNameFromItem(bauble).equals(name)) {
                sum++;
            }
        }
        return sum;
    }

    public HashMap<BaubleSlot, ItemStack> getBaubles() {
        HashMap<BaubleSlot, ItemStack> items = new HashMap<>();
        BaubleSlot[] slots = BaubleSlot.values();
        Inventory inv = getInv();
        for (BaubleSlot slot : slots) {
            items.put(slot, inv.getItem(slot.getValue()));
        }

        return items;
    }

    public ItemStack getItem(String name) {
        for (ItemStack item : getBaubles().values()) {
            if (RSVItem.getNameFromItem(item).equals(name)) {
                return item;
            }
        }
        return null;
    }
}
