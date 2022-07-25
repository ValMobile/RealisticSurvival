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
    private final FileConfiguration config = RSVFiles.getBaubleUserConfig();
    private double actRange = config.getDouble("Items.ender_queens_crown.ActivationRange");
    private double chance = config.getDouble("Items.ender_queens_crown.SummonEndermanAlly.Chance");
    private double maxHealthPercent = config.getDouble("Items.ender_queens_crown.SummonEndermanAlly.MaxHealthPercent");
    private double waterDamage = config.getDouble("Items.ender_queens_crown.WaterContactDamage");

    public EnderCrownTask(RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;
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
        int tickSpeed = RSVFiles.getBaubleUserConfig().getInt("Items.ender_queens_crown.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }
}
