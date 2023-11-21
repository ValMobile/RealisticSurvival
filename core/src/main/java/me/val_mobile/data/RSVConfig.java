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
package me.val_mobile.data;

import me.val_mobile.rsv.RSVPlugin;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class RSVConfig extends FileBuilder {

    private static final Set<RSVConfig> configList = new HashSet<>();
    private boolean updated;

    private final String path;
    private final RSVPlugin plugin;
    private final boolean updateOldVersions;
    private FileConfiguration config;

    public RSVConfig(RSVPlugin plugin, String path, boolean replace, boolean updateOldVersions) {
        super(plugin, path, replace);
        this.plugin = plugin;
        this.path = path;
        this.updateOldVersions = updateOldVersions;
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

        if (updateOldVersions && !updated) {
            updateConfig();
        }
    }

    private void updateConfig() {
        String currentVersion = "";
        String latestVersion = plugin.getDescription().getVersion();
        updated = true;

        if (config.contains("ConfigId")) {
            currentVersion = config.getString("ConfigId");
        }

        if (currentVersion.compareTo(latestVersion) < 0) {
            int num = 0;

            String newPath = path.replace(".yml", "_Backup_" + num + ".yml");

            while(new File(plugin.getDataFolder(), newPath).exists()) {
                num++;
                newPath = newPath.replace("_Backup_" + (num - 1), "_Backup_" + num);
            }

            FileConfiguration pluginConfig = plugin.getConfig();
            boolean autoUpdate = pluginConfig == null || pluginConfig.getBoolean("AutoUpdateConfig");

            if (autoUpdate) {
                try {
                    Files.copy(Path.of(file.getAbsolutePath()), Path.of(file.getAbsolutePath().replace(".yml", "_Backup_" + num + ".yml")));

                    InputStream stream = plugin.getResource(path);

                    InputStreamReader reader = new InputStreamReader(stream);
                    FileConfiguration embedded = YamlConfiguration.loadConfiguration(reader);

                    Set<String> embeddedKeys = embedded.getKeys(true);
                    Set<String> configKeys = config.getKeys(true);

                    for (String str : embeddedKeys) {
                        if (!configKeys.contains(str)) {
                            config.set(str, embedded.get(str));
                        }
                    }
                    config.set("ConfigId", latestVersion);
                    config.save(file);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                file.renameTo(new File(plugin.getDataFolder(), newPath));

                createFile(path);
                createConfig();
            }
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
