package me.val_mobile.ntr;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class FireStarterTask extends BukkitRunnable {

    private final Collection<Item> ingredients;

    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final Location loc;
    private final int duration;
    private final boolean isSoulCampfire;

    private final double soundChance;
    private final boolean emitSound;

    private final double particleChance;
    private final boolean emitParticles;


    private final long beginningTime;
    private long elapsed = 0;

    private static HashMap<UUID, FireStarterTask> tasks = new HashMap<>();
    private static HashMap<UUID, Long> players = new HashMap<>();

    public FireStarterTask(RealisticSurvivalPlugin plugin, NtrModule module, Player player, Location loc, Collection<Item> ingredients, boolean isSoulCampfire) {
        this.ingredients = ingredients;
        this.loc = loc;
        this.beginningTime = System.currentTimeMillis();
        this.id = player.getUniqueId();
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.duration = config.getInt("RemoveVanillaCampfireRecipes.Time");
        this.isSoulCampfire = isSoulCampfire;
        this.soundChance = config.getDouble("RemoveVanillaCampfireRecipes.BurningSound.Chance");
        this.emitSound = config.getBoolean("RemoveVanillaCampfireRecipes.BurningSound.Enabled");

        this.particleChance = config.getDouble("RemoveVanillaCampfireRecipes.EmitParticles.Chance");
        this.emitParticles = config.getBoolean("RemoveVanillaCampfireRecipes.EmitParticles.Enabled");

        tasks.put(id, this);
    }

    @Override
    public void run() {
        if (!players.containsKey(id)) {
            cancel();
        }
        elapsed = players.get(id) - beginningTime;

        if (elapsed > duration) {
            loc.getWorld().getBlockAt(loc).setType((isSoulCampfire) ? Material.SOUL_CAMPFIRE : Material.CAMPFIRE);
            for (Item drop : ingredients) {
                drop.remove();
            }
            stop();
        }

        if (emitSound) {
            if (Math.random() <= soundChance) {
                String soundName = config.getString("RemoveVanillaCampfireRecipes.BurningSound.Sound");
                float volume = (float) config.getDouble("RemoveVanillaCampfireRecipes.BurningSound.Volume");
                float pitch = (float) config.getDouble("RemoveVanillaCampfireRecipes.BurningSound.Pitch");

                Utils.playSound(loc, soundName, volume, pitch);
            }
        }

        if (emitParticles) {
            if (Math.random() <= particleChance) {
                Particle particle = Particle.valueOf(config.getString("RemoveVanillaCampfireRecipes.EmitParticles.Particle"));
                int min = config.getInt("RemoveVanillaCampfireRecipes.EmitParticles.MinCount");
                int max = config.getInt("RemoveVanillaCampfireRecipes.EmitParticles.MaxCount");

                double xOffset = config.getDouble("RemoveVanillaCampfireRecipes.EmitParticles.x-Offset");
                double yOffset = config.getDouble("RemoveVanillaCampfireRecipes.EmitParticles.y-Offset");
                double zOffset = config.getDouble("RemoveVanillaCampfireRecipes.EmitParticles.z-Offset");

                loc.getWorld().spawnParticle(particle, loc, Math.toIntExact(Math.round((Math.random() * max))) + min, xOffset, yOffset, zOffset);
            }
        }
    }

    public void stop() {
        players.remove(id);
        tasks.remove(id);
        cancel();
    }

    public void start() {
        runTaskTimer(plugin, 0L, 1);
    }

    public static HashMap<UUID, Long> getPlayers() {
        return players;
    }

    public static HashMap<UUID, FireStarterTask> getTasks() {
        return tasks;
    }
}
