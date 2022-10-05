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
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RSVConfig extends FileBuilder {

    private static final Set<RSVConfig> configList = new HashSet<>();
    private boolean renamed;

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
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }

        if (renameOldVersions && !renamed) {
            renameOldConfig();
        }
    }

    private void renameOldConfig() {
        String currentVersion = "";
        String latestVersion = plugin.getDescription().getVersion();
        renamed = true;

        if (config.contains("ConfigId")) {
            currentVersion = config.getString("ConfigId");
        }

        if (currentVersion.compareTo(latestVersion) < 0) {
            int num = 0;

            String newPath = path.replace(".yml", "_Old_Version_" + num + ".yml");

            while(new File(plugin.getDataFolder(), newPath).exists()) {
                num++;
                newPath = newPath.replace("_Old_Version_" + (num - 1), "_Old_Version_" + num);
            }

            file.renameTo(new File(plugin.getDataFolder(), newPath));

            createFile(path);
            createConfig();
        }

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
        setConfig(YamlConfiguration.loadConfiguration(file));
    }

    public static Set<RSVConfig> getConfigList() {
        return configList;
    }
}
