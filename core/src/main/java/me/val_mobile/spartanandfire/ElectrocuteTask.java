package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class ElectrocuteTask extends BukkitRunnable {

    private final Damageable entity;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final double shockDamage;
    private int shockAmount;
    private final int tickSpeed;

    private static HashMap<UUID, Boolean> entities = new HashMap<>();

    public ElectrocuteTask(RealisticSurvivalPlugin plugin, RSVModule module, String itemName, Damageable entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.shockDamage = config.getDouble("Items." + itemName + ".ElectrocuteAbility.ShockDamage");
        this.shockAmount = config.getInt("Items." + itemName + ".ElectrocuteAbility.ShockAmount");
        this.tickSpeed = config.getInt("Items." + itemName + ".ElectrocuteAbility.TickSpeed");
    }

    @Override
    public void run() {
        if (shockAmount > 0 || entity.isDead()) {
            entity.damage(shockDamage);
            shockAmount--;
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
