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
package me.val_mobile.tan;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVTask;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Lightable;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class TemperatureEnvironmentTask extends BukkitRunnable implements RSVTask {

    private final TemperatureCalculateTask calcTask;
    private final FileConfiguration config;
    private final RSVPlugin plugin;
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final ConfigurationSection section;
    private double regulate = 0D;
    private double change = 0D;

    public TemperatureEnvironmentTask(TanModule module, RSVPlugin plugin, RSVPlayer player) {
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

        if (conditionsMet(player)) {
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
                                add(block);
                            }
                        }
                    }
                }
            }
            calcTask.setChangeEnv(change);
            calcTask.setRegulateEnv(regulate);
        }
        else {
            stop();
        }
    }

    public static boolean willAffectTemperature(@Nullable BlockData data, @Nonnull ConfigurationSection section) {
        if (data == null) {
            return false;
        }

        String material = data.getMaterial().toString();

        if (!section.contains(material)) {
            return false;
        }

        if (data instanceof Lightable lightable) {
            if (section.contains(material + ".Lit")) {
                return section.getBoolean(material + ".Lit") == lightable.isLit();
            }
        }
        else if (data instanceof Levelled levelled) {
            if (section.contains(material + ".MaximumLevel")) {
                return levelled.getLevel() <= section.getInt(material + ".MaximumLevel");
            }
            else {
                if (section.contains(material + ".MinimumLevel")) {
                    return levelled.getLevel() >= section.getInt(material + ".MinimumLevel");
                }
            }
        }
        return true;
    }

    public static boolean willAffectTemperature(@Nonnull Block block, @Nonnull ConfigurationSection section) {
        return willAffectTemperature(block.getBlockData(), section);
    }

    public static boolean isRegulatory(@Nullable BlockData blockData, @Nonnull ConfigurationSection section) {
        if (blockData == null) {
            return false;
        }
        return section.getBoolean(blockData.getMaterial() + ".IsRegulatory");
    }

    public static boolean isRegulatory(@Nonnull Block block, @Nonnull ConfigurationSection section) {
        return isRegulatory(block.getBlockData(), section);
    }

    public static double getValue(@Nullable BlockData blockData, @Nonnull ConfigurationSection section) {
        if (blockData == null) {
            return 0D;
        }

        if (!section.contains(blockData.getMaterial() + ".Value")) {
            return 0D;
        }

        double val = section.getDouble(blockData.getMaterial() + ".Value");
        String type = blockData.getMaterial().toString();

        if (blockData instanceof Lightable lightable) {
            if (section.contains(type + ".Lit") && section.getBoolean(type + ".Lit")) {
                return lightable.isLit() ? val : 0D;
            }
        }
        if (blockData instanceof Levelled levelled) {
            if (section.contains(type + ".MinimumLevel")) {
                int minLevel = section.getInt(type + ".MinimumLevel");
                return levelled.getLevel() >= minLevel ? val : 0D;
            }
            else if (section.contains(type + ".MaximumLevel")) {
                int maxLevel = section.getInt(type + ".MaximumLevel");
                return levelled.getLevel() <= maxLevel ? val : 0D;
            }
        }
        return val;
    }

    public static double getValue(@Nonnull Block block, @Nonnull ConfigurationSection section) {
        return getValue(block.getBlockData(), section);
    }

    public boolean willAffectTemperature(@Nonnull Block block) {
        return willAffectTemperature(block.getBlockData(), section);
    }

    public void add(@Nonnull BlockData data) {
        String type = data.getMaterial().toString();

        double val = getValue(data, section);

        if (section.getBoolean(type + ".IsRegulatory")) {
            regulate += val;
        }
        else {
            change += val;
        }
    }

    public void add(@Nonnull Block data) {
        String type = data.getType().toString();

        double val = getValue(data, section);

        if (section.getBoolean(type + ".IsRegulatory")) {
            regulate += val;
        }
        else {
            change += val;
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && calcTask != null && allowedWorlds.contains(player.getWorld().getName());
    }

    @Override
    public void start() {
        this.runTaskAsynchronously(plugin);
    }

    @Override
    public void stop() {
        cancel();
    }
}
