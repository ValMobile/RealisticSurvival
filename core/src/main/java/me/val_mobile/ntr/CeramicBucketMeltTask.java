/*
    Copyright (C) 2022  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.ntr;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CeramicBucketMeltTask extends BukkitRunnable {

    private static final Map<UUID, CeramicBucketMeltTask> tasks = new HashMap<>();
    private final Player player;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final int duration;
    private final Set<String> allowedWorlds;

    private final double soundChance;
    private final boolean emitSound;

    private final double particleChance;
    private final boolean emitParticles;

    private int ticks = 0;

    public CeramicBucketMeltTask(RealisticSurvivalPlugin plugin, NtrModule module, Player player) {
        this.player = player;
        this.id = player.getUniqueId();
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.duration = config.getInt("Pottery.CeramicLavaBucketMelting.Time");
        this.soundChance = config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Chance");
        this.emitSound = config.getBoolean("Pottery.CeramicLavaBucketMelting.BurningSound.Enabled");
        this.allowedWorlds = module.getAllowedWorlds();
        this.particleChance = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.Chance");
        this.emitParticles = config.getBoolean("Pottery.CeramicLavaBucketMelting.EmitParticles.Enabled");

        tasks.put(id, this);
    }

    @Override
    public void run() {
        if (player == null) {
            stop();
        }
        else {
            if (player.isOnline() && allowedWorlds.contains(player.getWorld().getName()) && isHoldingCeramicLavaBucket()) {
                ticks++;

                if (ticks > duration) {
                    if (config.getBoolean("Pottery.CeramicLavaBucketMelting.PourLava.Enabled")) {
                        Block block = player.getLocation().getBlock();
                        if (block.isPassable() && config.getBoolean("Pottery.CeramicLavaBucketMelting.PourLava.OnlyReplacePassableBlocks")) {
                            block.setType(Material.LAVA);
                        }
                    }
                    player.getInventory().setItemInMainHand(null);
                    stop();
                }
                else {
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
            }
            else {
                stop();
            }
        }
    }

    public void start() {
        runTaskTimer(plugin, 0L, 1);
    }

    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public static Map<UUID, CeramicBucketMeltTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    private boolean isHoldingCeramicLavaBucket() {
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();

        if (RSVItem.isRSVItem(itemMainHand)) {
            return RSVItem.getNameFromItem(itemMainHand).equals("ceramic_lava_bucket");
        }
        return false;
    }
}
