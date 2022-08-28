package me.val_mobile.spartanweaponry;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class KbTask extends BukkitRunnable {

    private final Entity entity;
    private final RealisticSurvivalPlugin plugin;
    private final double multiplier;

    public KbTask(RealisticSurvivalPlugin plugin, Entity entity, double multiplier) {
        this.entity = entity;
        this.plugin = plugin;
        this.multiplier = multiplier;
    }

    @Override
    public void run() {
        entity.setVelocity(entity.getVelocity().multiply(multiplier));
    }

    public void start() {
        runTaskLater(plugin, 1);
    }
}
