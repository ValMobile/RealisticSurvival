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
package me.val_mobile.tan;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Lightable;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class TemperatureEnvironmentTask extends BukkitRunnable {

    private final TemperatureCalculateTask calcTask;
    private final FileConfiguration config;
    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final ConfigurationSection section;
    private double regulate = 0D;
    private double change = 0D;

    public TemperatureEnvironmentTask(TanModule module, RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.allowedWorlds = module.getAllowedWorlds();
        this.calcTask = TemperatureCalculateTask.getTasks().get(player.getPlayer().getUniqueId());
        this.section = config.getConfigurationSection("Temperature.Environment.Blocks");
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        if (calcTask == null) {
            cancel();
        }
        else {
            if (player == null) {
                // update static hashmap values and cancel the runnable
                cancel();
            }
            // if the player is in creative or spectator
            else {
                GameMode mode = player.getGameMode(); // get the gamemode

                if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                    regulate = 0D;
                    change = 0D;
                    Location pLoc = player.getLocation();
                    double px = pLoc.getX();
                    double py = pLoc.getY();
                    double pz = pLoc.getZ();

                    int cubeLength = config.getInt("Temperature.Environment.CubeLength");

                    for (int x = -(cubeLength - 1); x < cubeLength; x++) {
                        for (int y = -(cubeLength - 1); y < cubeLength; y++) {
                            for (int z = -(cubeLength - 1); z < cubeLength; z++) {
                                Location loc = new Location(player.getWorld(), px + x, py + y, pz + z);
                                Block block = loc.getBlock();

                                if (!block.isEmpty()) {
                                    if (willAffectTemperature(block)) {
                                        add("Temperature.Environment.Blocks." + block.getType());
                                    }
                                }
                            }
                        }
                    }
                    calcTask.setChangeEnv(change);
                    calcTask.setRegulateEnv(regulate);
                }
                else {
                    cancel();
                }
            }
        }
    }

    public static boolean willAffectTemperature(Block block, ConfigurationSection section) {
        BlockData data = block.getBlockData();

        String material = data.getMaterial().toString();

        if (data instanceof Lightable lightable) {
            if (section.contains(material + ".Lit")) {
                return section.getBoolean(material + ".Lit") == lightable.isLit();
            }
            else {
                return true;
            }
        }
        else if (data instanceof Levelled levelled) {
            if (block.isLiquid()) {
                if (section.contains(material + ".MaximumLevel")) {
                    return levelled.getLevel() <= section.getInt(material + ".MaximumLevel");
                }
                else {
                    return true;
                }
            }
            else {
                if (section.contains(material + ".MinimumLevel")) {
                    return levelled.getLevel() >= section.getInt(material + ".MinimumLevel");
                }
                else {
                    return true;
                }
            }
        }
        else {
            return true;
        }
    }

    public static boolean isRegulatory(Block block, ConfigurationSection section) {
        return section.getBoolean(block.getType() + ".IsRegulatory");
    }

    public static double getValue(Block block, ConfigurationSection section) {
        return section.getDouble(block.getType() + ".Value");
    }

    public boolean willAffectTemperature(Block block) {
        BlockData data = block.getBlockData();

        String material = data.getMaterial().toString();

        if (data instanceof Lightable lightable) {
            if (section.contains(material + ".Lit")) {
                return section.getBoolean(material + ".Lit") == lightable.isLit();
            }
            else {
                return true;
            }
        }
        else if (data instanceof Levelled levelled) {
            if (block.isLiquid()) {
                if (section.contains(material + ".MaximumLevel")) {
                    return levelled.getLevel() <= section.getInt(material + ".MaximumLevel");
                }
                else {
                    return true;
                }
            }
            else {
                if (section.contains(material + ".MinimumLevel")) {
                    return levelled.getLevel() >= section.getInt(material + ".MinimumLevel");
                }
                else {
                    return true;
                }
            }
        }
        else {
            return true;
        }
    }

    public void add(String configPath) {
        double amount = config.getDouble(configPath + ".Value");

        if (config.contains(configPath + ".Enabled")) {
            if (config.getBoolean(configPath + ".Enabled")) {
                if (config.getBoolean(configPath + ".IsRegulatory")) {
                    regulate += amount;
                }
                else {
                    change += amount;
                }
            }
        }
        else {
            if (config.getBoolean(configPath + ".IsRegulatory")) {
                regulate += amount;
            }
            else {
                change += amount;
            }
        }
    }

    public void start() {
        this.runTaskAsynchronously(plugin);
    }
}
