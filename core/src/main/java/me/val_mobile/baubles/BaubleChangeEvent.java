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
        return RSVItem.getModuleNameFromItem(bauble);
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

    public enum BaubleChange {
        ADDITION, REMOVAL
    }
}
