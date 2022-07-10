package me.val_mobile.baubles;

import me.val_mobile.data.RSVFiles;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScarliteRing extends BukkitRunnable {

    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config = RSVFiles.getBaubleUserConfig();
    private double defaultHealAmount = config.getDouble("scarlite_ring.HealAmount");

    public ScarliteRing(RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;

    }

    @Override
    public void run() {
        boolean hasBauble = ((DataModule) rsvPlayer.getDataModuleFromName("Baubles")).getScarliteRing();

        if (hasBauble) {
            // effect the player with resistance
            Player p = rsvPlayer.getPlayer();
            double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            double currentHealth = p.getHealth();
            double dif =  maxHealth - currentHealth;
            if (dif < defaultHealAmount) {
                p.setHealth(maxHealth);
            }
            else {
                p.setHealth(currentHealth + defaultHealAmount);
            }
        }
        // if the player doesn't have rings of res in his/her inventory
        else {
            // update static hashmap values and cancel the runnable
            cancel();
        }
    }

    public void startRunnable() {
        int tickSpeed = RSVFiles.getBaubleUserConfig().getInt("scarlite_ring.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }
}
