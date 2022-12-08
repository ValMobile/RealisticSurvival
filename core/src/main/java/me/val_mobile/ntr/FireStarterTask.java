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
import me.val_mobile.utils.Utils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class FireStarterTask extends BukkitRunnable {

    private static final Map<UUID, FireStarterTask> tasks = new HashMap<>();
    private final Collection<Item> ingredients;
    private final Player player;
    private final Set<String> allowedWorlds;

    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final Location loc;
    private final int duration;
    private final boolean isSoulCampfire;

    private final double soundChance;
    private final boolean emitSound;
    private final String sound;
    private final float volume;
    private final float pitch;

    private final double particleChance;
    private final boolean emitParticles;
    private final Particle particle;
    private final int minCount;
    private final int maxCount;
    private final double xOffset;
    private final double yOffset;
    private final double zOffset;
    private final double extra;
    private Particle.DustOptions dust;


    private int ticks = 0;

    public FireStarterTask(RealisticSurvivalPlugin plugin, NtrModule module, Player player, Location loc, Collection<Item> ingredients, boolean isSoulCampfire) {
        this.ingredients = ingredients;
        this.loc = loc;
        this.id = player.getUniqueId();
        this.plugin = plugin;
        this.player = player;
        FileConfiguration config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.duration = config.getInt("FireStarter.Time");
        this.isSoulCampfire = isSoulCampfire;
        this.soundChance = config.getDouble("FireStarter.BurningSound.Chance");
        this.emitSound = config.getBoolean("FireStarter.BurningSound.Enabled");
        this.sound = config.getString("FireStarter.BurningSound.Sound");
        this.volume = (float) config.getDouble("FireStarter.BurningSound.Volume");
        this.pitch = (float) config.getDouble("FireStarter.BurningSound.Pitch");

        this.particleChance = config.getDouble("FireStarter.EmitParticles.Chance");
        this.emitParticles = config.getBoolean("FireStarter.EmitParticles.Enabled");
        this.minCount = config.getInt("FireStarter.EmitParticles.MinCount");
        this.maxCount = config.getInt("FireStarter.EmitParticles.MaxCount");

        this.xOffset = config.getDouble("FireStarter.EmitParticles.x-Offset");
        this.yOffset = config.getDouble("FireStarter.EmitParticles.y-Offset");
        this.zOffset = config.getDouble("FireStarter.EmitParticles.z-Offset");

        this.extra = config.getDouble("FireStarter.EmitParticles.Extra");
        this.particle = Particle.valueOf(config.getString("FireStarter.EmitParticles.Particle"));

        if (particle == Particle.REDSTONE) {
            String color = config.getString("FireStarter.EmitParticles.DustOptionColor");
            float size = (float) config.getDouble("FireStarter.EmitParticles.DustOptionSize");

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


        tasks.put(id, this);
    }

    @Override
    public void run() {
        plugin.getLogger().info("a");
        if (player == null) {
            stop();
        }
        else {
            if (player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                ticks++;

                if (ticks > duration) {
                    if (!ingredients.contains(null)) {
                        loc.getWorld().getBlockAt(loc).setType(isSoulCampfire ? Material.SOUL_CAMPFIRE : Material.CAMPFIRE);
                        for (Item drop : ingredients) {
                            drop.remove();
                        }
                    }
                    stop();
                }
                else {
                    if (emitSound)
                        if (Utils.roll(soundChance))
                            Utils.playSound(loc, sound, volume, pitch);

                    if (emitParticles)
                        if (Utils.roll(particleChance))
                            loc.getWorld().spawnParticle(particle, loc, Utils.getRandomNum(minCount, maxCount), xOffset, yOffset, zOffset, extra, dust);
                }
            }
            else
                stop();
        }
    }

    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public void start() {
        runTaskTimer(plugin, 0L, 1);
    }

    public static Map<UUID, FireStarterTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
