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

public class HyperthermiaTask extends BukkitRunnable {

    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final static HashMap<UUID, Boolean> players = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final double damage;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public HyperthermiaTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.damage = config.getDouble("Temperature.Hyperthermia.Damage.Amount");

        ConfigurationSection section = config.getConfigurationSection("Temperature.Hyperthermia.PotionEffects.Effects");
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

            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotdamage")) {
                if (config.getBoolean("Temperature.Hyperthermia.Damage.Enabled")) {
                    if (player.getHealth() >= config.getDouble("Temperature.Hyperthermia.Damage.Cutoff")) {
                        player.damage(damage);
                    }
                }
            }

            // if the player's temperature is low enough
            if (temperature < config.getDouble("Temperature.Hyperthermia.Temperature")) {
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

        int tickSpeed = config.getInt("Temperature.Hyperthermia.TickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);


        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotpotioneffects")) {
            if (config.getBoolean("Temperature.Hyperthermia.PotionEffects.Enabled")) {
                if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotpotioneffects")) {
                    player.addPotionEffects(potionEffects);
                }
            }
        }

        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotcombustion")) {
            if (config.getBoolean("Temperature.Hyperthermia.Ignite.Enabled")) {
                int fireTicks = config.getInt("Temperature.Hyperthermia.Ignite.FireTicks");

                if (player.getFireTicks() < fireTicks) {
                    player.setFireTicks(fireTicks);
                }
            }
        }

        players.put(player.getUniqueId(), true);
    }

    public static HashMap<UUID, Boolean> getPlayers() {
        return players;
    }
}
