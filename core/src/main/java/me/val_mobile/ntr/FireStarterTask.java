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
    private final FileConfiguration config;
    private final Location loc;
    private final int duration;
    private final boolean isSoulCampfire;

    private final double soundChance;
    private final boolean emitSound;

    private final double particleChance;
    private final boolean emitParticles;
    private int ticks = 0;

    public FireStarterTask(RealisticSurvivalPlugin plugin, NtrModule module, Player player, Location loc, Collection<Item> ingredients, boolean isSoulCampfire) {
        this.ingredients = ingredients;
        this.loc = loc;
        this.id = player.getUniqueId();
        this.plugin = plugin;
        this.player = player;
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
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
        if (player == null) {
            stop();
        }
        else {
            if (player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                ticks++;

                if (ticks > duration) {
                    loc.getWorld().getBlockAt(loc).setType((isSoulCampfire) ? Material.SOUL_CAMPFIRE : Material.CAMPFIRE);
                    for (Item drop : ingredients) {
                        if (drop != null) {
                            drop.remove();
                        }
                    }
                    stop();
                }
                else {
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
            }
            else {
                stop();
            }
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
