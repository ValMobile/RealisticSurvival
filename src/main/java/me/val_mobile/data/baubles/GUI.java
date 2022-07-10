package me.val_mobile.data.baubles;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public abstract class GUI {

    private Inventory inv;
    private Collection<ItemStack> disallowedItems = new ArrayList<>();

    public GUI(Player player, int size, String name) {
        inv = Bukkit.createInventory(player, size, name);
    }

    public ItemStack getBauble(BaubleSlot baubleSlot) {
        return inv.getItem(baubleSlot.getValue());
    }

    public Collection<ItemStack> getDisallowedItems() {
        return disallowedItems;
    }

    public Inventory getInv() {
        return inv;
    }

    public void shouldCancel(InventoryClickEvent event) {

    }
}
