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
package me.val_mobile.data;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Consumer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class RSVConfig extends FileBuilder {

    private static Collection<RSVConfig> configList = new ArrayList<>();

    private final String path;
    private final RealisticSurvivalPlugin plugin;
    private final boolean renameOldVersions;
    private FileConfiguration config;

    public RSVConfig(RealisticSurvivalPlugin plugin, String path, boolean replace, boolean renameOldVersions) {
        super(plugin, path, replace);
        this.plugin = plugin;
        this.path = path;
        this.renameOldVersions = renameOldVersions;
        createConfig();

        configList.add(this);
    }

    public void createConfig() {
        config = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            config.load(getFile());
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }

        if (renameOldVersions) {
            renameOldConfig();
        }
    }

    private void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + 93975).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getLogger().info(ChatColor.translateAlternateColorCodes('&',"&cCannot look for updates: " + exception.getMessage()));
            }
        });
    }

    private void renameOldConfig() {
        getVersion(latestVersion -> {
            double currentVersion = 0D;
            if (config.contains("ConfigId")) {
                currentVersion = Utils.getNumberFromUpdate(config.getString("ConfigId"));
            }

            double version = Utils.getNumberFromUpdate((latestVersion));

            if (!(Utils.doublesEquals(currentVersion, version) || currentVersion > version)) {
                File f = getFile();
                int num = 0;

                String newPath = path.replace(".yml", "_Old_Version_" + num + ".yml");

                while (new File(newPath).exists()) {
                    num++;
                    newPath = newPath.replace("_Old_Version_" + (num - 1), "_Old_Version_" + num);
                }
                f.renameTo(new File(newPath));

                createFile(path);
                createConfig();
            }
        });
    }

    /**
     * Gets the config
     * @return The config
     */
    public FileConfiguration getConfig() {
        return config;
    }

    /**
     * Assigns the current config to a new one
     * @param config The new config which the current config should be set to
     */
    public void setConfig(FileConfiguration config) {
        this.config = config;
    }

    /**
     * Reloads the config to use the most recent values
     */
    public void reloadConfig() {
        setConfig(YamlConfiguration.loadConfiguration(getFile()));
    }

    public static Collection<RSVConfig> getConfigList() {
        return configList;
    }
}
