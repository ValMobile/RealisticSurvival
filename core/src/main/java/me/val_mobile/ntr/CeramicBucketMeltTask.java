package me.val_mobile.ntr;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class CeramicBucketMeltTask extends BukkitRunnable {

    private final Player player;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final int duration;

    private final double soundChance;
    private final boolean emitSound;

    private final double particleChance;
    private final boolean emitParticles;

    private final long beginningTime;
    private long elapsed = 0;

    private static HashMap<UUID, CeramicBucketMeltTask> tasks = new HashMap<>();
    private static HashMap<UUID, Long> players = new HashMap<>();

    public CeramicBucketMeltTask(RealisticSurvivalPlugin plugin, NtrModule module, Player player) {
        this.beginningTime = System.currentTimeMillis();
        this.player = player;
        this.id = player.getUniqueId();
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.duration = config.getInt("Pottery.CeramicLavaBucketMelting.Time");
        this.soundChance = config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Chance");
        this.emitSound = config.getBoolean("Pottery.CeramicLavaBucketMelting.BurningSound.Enabled");

        this.particleChance = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.Chance");
        this.emitParticles = config.getBoolean("Pottery.CeramicLavaBucketMelting.EmitParticles.Enabled");

        tasks.put(id, this);
    }

    @Override
    public void run() {

        if (!players.containsKey(id)) {
            cancel();
        }
        elapsed = players.get(id) - beginningTime;

        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (RSVItem.isRSVItem(itemMainHand)) {
            stop();
        }

        String name = RSVItem.getNameFromItem(itemMainHand);

        if (!((name.equals("ceramic_bucket") || name.equals("ceramic_lava_bucket")) && itemMainHand.getType() == Material.LAVA_BUCKET)) {
            stop();
        }

        if (elapsed > duration) {
            player.getInventory().setItemInMainHand(null);
            stop();
        }

        if (emitSound) {
            if (Math.random() <= soundChance) {
                String soundName = config.getString("Pottery.CeramicLavaBucketMelting.BurningSound.Sound");
                float volume = (float) config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Volume");
                float pitch = (float) config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Pitch");

                Utils.playSound(player.getLocation(), soundName, volume, pitch);
            }
        }

        if (emitParticles) {
            if (Math.random() <= particleChance) {
                Particle particle = Particle.valueOf(config.getString("Pottery.CeramicLavaBucketMelting.EmitParticles.Particle"));
                int min = config.getInt("Pottery.CeramicLavaBucketMelting.EmitParticles.MinCount");
                int max = config.getInt("Pottery.CeramicLavaBucketMelting.EmitParticles.MaxCount");

                double xOffset = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.x-Offset");
                double yOffset = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.y-Offset");
                double zOffset = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.z-Offset");

                player.getWorld().spawnParticle(particle, player.getLocation(), Math.toIntExact(Math.round((Math.random() * max))) + min, xOffset, yOffset, zOffset);
            }
        }
    }

    public void start() {
        runTaskTimer(plugin, 0L, 1);
    }

    public void stop() {
        players.remove(id);
        tasks.remove(id);
        cancel();
    }

    public static HashMap<UUID, Long> getPlayers() {
        return players;
    }

    public static HashMap<UUID, CeramicBucketMeltTask> getTasks() {
        return tasks;
    }
}
