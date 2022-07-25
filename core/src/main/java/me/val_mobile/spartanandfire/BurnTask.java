package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class BurnTask extends BukkitRunnable {

    private final Entity entity;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private int fireTicks;
    private final int tickSpeed;

    private static HashMap<UUID, Boolean> entities = new HashMap<>();

    public BurnTask(RealisticSurvivalPlugin plugin, RSVModule module, String itemName, Entity entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.fireTicks = config.getInt("Items." + itemName + ".InfernoAbility.FireTicks");
        this.tickSpeed = config.getInt("Items." + itemName + ".InfernoAbility.TickSpeed");
    }

    @Override
    public void run() {
        if (fireTicks > 0 || entity.isDead()) {
            // if the entity is going to burn for less than the specified fire ticks
            if (entity.getFireTicks() < fireTicks) {
                // set the entity on fire
                entity.setFireTicks(fireTicks);
                fireTicks -= tickSpeed;
            }
        }
        else {
            entities.replace(entity.getUniqueId(), true, false);
            cancel();
        }
    }

    public void start() {
        runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static HashMap<UUID, Boolean> getEntities() {
        return entities;
    }
}
