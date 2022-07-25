package me.val_mobile.baubles;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EnderCrownTask extends BukkitRunnable {

    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final double actRange;
    private final double chance;
    private final double maxHealthPercent;
    private final double waterDamage;

    public EnderCrownTask(BaubleModule module, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.config = module.getUserConfig().getConfig();
        this.plugin = plugin;
        this.actRange = config.getDouble("Items.ender_queens_crown.ActivationRange");
        this.chance = config.getDouble("Items.ender_queens_crown.SummonEndermanAlly.Chance");
        this.maxHealthPercent = config.getDouble("Items.ender_queens_crown.SummonEndermanAlly.MaxHealthPercent");
        this.waterDamage = config.getDouble("Items.ender_queens_crown.WaterContactDamage");
    }

    @Override
    public void run() {
        boolean hasBauble = ((DataModule) rsvPlayer.getDataModuleFromName("Baubles")).hasBauble("ender_queens_crown");

        if (hasBauble) {
            // effect the player with resistance
            Player p = rsvPlayer.getPlayer();
            Location loc = p.getLocation();
            for (Entity e : p.getNearbyEntities(actRange, actRange, actRange)) {
                if (e.getType() == EntityType.ENDERMAN) {
                    // transfrom enderman into ally

                }
            }

            if (p.isInWater()) {
                p.damage(waterDamage);
            }
        }
        // if the player doesn't have rings of res in his/her inventory
        else {
            // update static hashmap values and cancel the runnable
            cancel();
        }
    }

    public void startRunnable() {
        int tickSpeed = config.getInt("Items.ender_queens_crown.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }
}
