package me.val_mobile.tan;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class TemperatureChangeEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private UUID id;
    private double oldTemp;
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
