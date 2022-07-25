package me.val_mobile.baubles;

import org.bukkit.scheduler.BukkitRunnable;

public class Tickable {

    private String name;

    public Tickable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
