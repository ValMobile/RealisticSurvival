/*
    Copyright (C) 2023  Val_Mobile

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
package me.val_mobile.ntp;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Color;
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
    private final int duration;
    private final Set<String> allowedWorlds;
    private final double soundChance;
    private final boolean emitSound;
    private final String sound;
    private final float volume;
    private final float pitch;
    private final double particleChance;
    private final boolean emitParticles;
    private final int minCount;
    private final int maxCount;
    private final double xOffset;
    private final double yOffset;
    private final double zOffset;
    private final double extra;
    private final Particle particle;
    private Particle.DustOptions dust;
    private final boolean shouldPourLava;
    private final boolean shouldOnlyReplacePassableBlocks;

    private int ticks = 0;

    public CeramicBucketMeltTask(RealisticSurvivalPlugin plugin, NtpModule module, Player player) {
        this.player = player;
        this.id = player.getUniqueId();
        this.plugin = plugin;
        FileConfiguration config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.duration = config.getInt("Pottery.CeramicLavaBucketMelting.Time");

        this.soundChance = config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Chance");
        this.emitSound = config.getBoolean("Pottery.CeramicLavaBucketMelting.BurningSound.Enabled");
        this.sound = config.getString("Pottery.CeramicLavaBucketMelting.BurningSound.Sound");
        this.volume = (float) config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Volume");
        this.pitch = (float) config.getDouble("Pottery.CeramicLavaBucketMelting.BurningSound.Pitch");

        this.particleChance = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.Chance");
        this.emitParticles = config.getBoolean("Pottery.CeramicLavaBucketMelting.EmitParticles.Enabled");
        this.minCount = config.getInt("Pottery.CeramicLavaBucketMelting.EmitParticles.MinCount");
        this.maxCount = config.getInt("Pottery.CeramicLavaBucketMelting.EmitParticles.MaxCount");
        this.xOffset = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.x-Offset");
        this.yOffset = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.y-Offset");
        this.zOffset = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.z-Offset");
        this.extra = config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.Extra");
        this.particle = Particle.valueOf(config.getString("Pottery.CeramicLavaBucketMelting.EmitParticles.Particle"));

        if (particle == Particle.REDSTONE) {
            String color = config.getString("Pottery.CeramicLavaBucketMelting.EmitParticles.DustOptionColor");
            float size = (float) config.getDouble("Pottery.CeramicLavaBucketMelting.EmitParticles.DustOptionSize");

            if (color.contains("|")) {
                int first = color.indexOf("|");
                int second = color.lastIndexOf("|");

                int red = Integer.parseInt(color.substring(0, first));
                int green = Integer.parseInt(color.substring(first + 1, second));
                int blue = Integer.parseInt(color.substring(second + 1));

                dust = new Particle.DustOptions(Color.fromRGB(red, green, blue), size);
            }
            else {
                dust = new Particle.DustOptions(Utils.valueOfColor(color), size);
            }
        }

        this.shouldPourLava = config.getBoolean("Pottery.CeramicLavaBucketMelting.PourLava.Enabled");
        this.shouldOnlyReplacePassableBlocks = config.getBoolean("Pottery.CeramicLavaBucketMelting.PourLava.OnlyReplacePassableBlocks");

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
                    if (shouldPourLava) {
                        Block block = player.getLocation().getBlock();
                        if (block.isPassable() && shouldOnlyReplacePassableBlocks)
                            block.setType(Material.LAVA);
                    }
                    player.getInventory().setItemInMainHand(null);
                    stop();
                }
                else {
                    if (emitSound)
                        if (Utils.roll(soundChance))
                            Utils.playSound(player.getLocation(), sound, volume, pitch);

                    if (emitParticles)
                        if (Utils.roll(particleChance))
                            player.spawnParticle(particle, player.getLocation(), Utils.getRandomNum(minCount, maxCount), xOffset, yOffset, zOffset, extra, dust);
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
