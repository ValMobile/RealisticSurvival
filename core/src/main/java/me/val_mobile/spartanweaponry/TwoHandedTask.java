package me.val_mobile.spartanweaponry;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class TwoHandedTask extends BukkitRunnable {

    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final PotionEffect effect;
    private final UUID id;
    private final String itemName;
    private final Utils util;

    private static HashMap<UUID, String> players = new HashMap<>();

    public TwoHandedTask(RSVModule module, RealisticSurvivalPlugin plugin, Player player, String itemName) {
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.id = player.getUniqueId();
        this.util = new Utils(plugin);
        this.itemName = itemName;
        this.effect = new PotionEffect(PotionEffectType.SLOW_DIGGING, config.getInt("Items." + itemName + ".MiningFatigue.Duration"), config.getInt("Items." + itemName + ".MiningFatigue.Amplifier"));
    }

    @Override
    public void run() {
        Player player = Bukkit.getPlayer(id);
        ItemStack itemMainhand = player.getInventory().getItemInMainHand();

        if (RSVItem.isRSVItem(itemMainhand, util)) {
            if (RSVItem.getNameFromItem(itemMainhand, util).equals(itemName)) {
                player.addPotionEffect(effect);
            }
            else {
                players.remove(id);
                cancel();
            }
        }
        else {
            cancel();
        }
    }

    public void startRunnable() {
        int tickSpeed = config.getInt("Items." + itemName + ".MiningFatigue.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static HashMap<UUID, String> getPlayers() {
        return players;
    }
}
