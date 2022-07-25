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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RSVConfig extends FileBuilder {

    private static Collection<RSVConfig> configList = new ArrayList<>();

    private FileConfiguration config;

    public RSVConfig(RealisticSurvivalPlugin plugin, String path, boolean replace) {
        super(plugin, path, replace);

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
