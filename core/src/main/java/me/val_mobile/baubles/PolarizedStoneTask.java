package me.val_mobile.baubles;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PolarizedStoneTask extends BukkitRunnable {

    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();
    private double maxRadius = config.getDouble("Items.polarized_stone.MaxRadius");
    private double pullForce = config.getDouble("Items.polarized_stone.PullForce");

    public PolarizedStoneTask(RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        boolean hasBauble = ((DataModule) rsvPlayer.getDataModuleFromName("Baubles")).hasBauble("polarized_stone");

        if (hasBauble) {
            // effect the player with resistance
            Player p = rsvPlayer.getPlayer();
            Location loc = p.getLocation();
            for (Entity e : p.getNearbyEntities(maxRadius, maxRadius, maxRadius)) {
                if (e.getType() == EntityType.EXPERIENCE_ORB || e.getType() == EntityType.DROPPED_ITEM) {
                    Location eLoc = e.getLocation();
                    double xDif = loc.getX() - eLoc.getX();
                    double yDif = loc.getY() - eLoc.getY();
                    double zDif = loc.getZ() - eLoc.getZ();
                    e.setVelocity((new Vector(xDif, yDif, zDif)).normalize().multiply(pullForce));
                }
            }
        }
        // if the player doesn't have rings of res in his/her inventory
        else {
            // update static hashmap values and cancel the runnable
            cancel();
        }
    }

    public void startRunnable() {
        int tickSpeed = config.getInt("Items.polarized_stone.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }
}
