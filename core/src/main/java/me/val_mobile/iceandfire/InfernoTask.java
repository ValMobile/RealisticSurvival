package me.val_mobile.iceandfire;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class InfernoTask extends BukkitRunnable {

    private final RealisticSurvivalPlugin plugin;
    private final Entity entity;
    private int ticks;

    public InfernoTask(Entity entity, int ticks, RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        this.entity = entity;
        this.ticks = ticks;
    }

    @Override
    public void run() {
        if (entity.getFireTicks() < ticks) {
            entity.setFireTicks(ticks);
        }
        ticks--;
        if (ticks < 0 || entity.isDead()) {
            cancel();
        }
    }

    public void start() {
        this.runTaskTimer(plugin, 0, 1);
    }
}
