package me.val_mobile.tan;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class ThirstChangeEvent {

    private static final HandlerList handlers = new HandlerList();
    private UUID id;
    private double oldThirst;
    private double newThirst;
    private boolean cancelled;

    public ThirstChangeEvent(Player player, double oldThirst, double newThirst) {
        this.id = player.getUniqueId();
        this.oldThirst = oldThirst;
        this.newThirst = newThirst;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(id);
    }

    public double getNewThirst() {
        return newThirst;
    }

    public double getOldThirst() {
        return oldThirst;
    }

    public void setNewThirst(double newThirst) {
        this.newThirst = newThirst;
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
