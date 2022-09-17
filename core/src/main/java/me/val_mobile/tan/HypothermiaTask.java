package me.val_mobile.tan;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.toughasnails.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.GameMode;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class HypothermiaTask extends BukkitRunnable {

    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final static HashMap<UUID, Boolean> players = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final double damage;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public HypothermiaTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.damage = config.getDouble("Temperature.Hypothermia.Damage.Amount");

        ConfigurationSection section = config.getConfigurationSection("Temperature.Hypothermia.PotionEffects.Effects");
        Set<String> keys = section.getKeys(false);

        int dur;
        int amp;

        for (String key : keys) {
            dur = section.getInt(key + ".Duration");
            amp = section.getInt(key + ".Amplifier");
            potionEffects.add(new PotionEffect(PotionEffectType.getByName(key), dur, amp));
        }
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        DataModule module = ((DataModule) this.player.getDataModuleFromName(TanModule.NAME));
        int temperature = (int) Math.round(module.getTemperature());
        GameMode mode = player.getGameMode(); // get the gamemode

        if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE && allowedWorlds.contains(player.getWorld().toString())) {

            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.colddamage")) {
                if (config.getBoolean("Temperature.Hypothermia.Damage.Enabled")) {
                    if (player.getHealth() >= config.getDouble("Temperature.Hypothermia.Damage.Cutoff")) {
                        player.damage(damage);
                    }
                }
            }

            // if the player's temperature is high enough
            if (temperature > config.getDouble("Temperature.Hypothermia.Temperature")) {
                players.put(player.getUniqueId(), false);
                cancel();
            }

        }
        // if the player is in creative or spectator
        else {
            // update static hashmap values and cancel the runnable
            players.put(player.getUniqueId(), false);
            cancel();
        }
    }

    public void startRunnable() {
        Player player = this.player.getPlayer();
        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.coldpotioneffects")) {
            if (config.getBoolean("Temperature.Hypothermia.PotionEffects.Enabled")) {
                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.coldpotioneffects")) {
                    player.addPotionEffects(potionEffects);
                }
            }
        }

        int tickSpeed = config.getInt("Temperature.Hypothermia.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
        players.put(player.getUniqueId(), true);
    }

    public static HashMap<UUID, Boolean> getPlayers() {
        return players;
    }
}
