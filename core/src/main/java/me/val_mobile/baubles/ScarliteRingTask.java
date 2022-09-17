package me.val_mobile.baubles;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class ScarliteRingTask extends BukkitRunnable {

    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();
    private double defaultHealAmount = config.getDouble("Items.scarlite_ring.HealAmount");

    private static final HashMap<UUID, Boolean> players = new HashMap<>();

    public ScarliteRingTask(RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        boolean hasBauble = ((DataModule) rsvPlayer.getDataModuleFromName("Baubles")).hasBauble("scarlite_ring");

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
            players.put(rsvPlayer.getPlayer().getUniqueId(), false);
            cancel();
        }
    }

    public void startRunnable() {
        FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();

        int tickSpeed = config.getInt("Items.scarlite_ring.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
        players.put(rsvPlayer.getPlayer().getUniqueId(), true);
    }

    public static HashMap<UUID, Boolean> getPlayers() {
        return players;
    }
}
