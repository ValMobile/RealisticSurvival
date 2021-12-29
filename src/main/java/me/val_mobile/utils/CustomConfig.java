/*
    Copyright (C) 2021  Val_Mobile

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
package me.val_mobile.utils;

import me.val_mobile.rlcraft.RLCraftPlugin;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
/**
 * CustomConfig is a class that allows for creation, access, and reloading
 * of yaml files other than the default "config.yml"
 * @author Val_Mobile
 * @version 1.2
 * @since 1.2
 */
public class CustomConfig {

    // initializing class variables to store files and folders
    private static File resourcesFolder;

    private static File baubleFile;
    private static FileConfiguration baubleConfig;

    private static File iceFireGearFile;
    private static FileConfiguration iceFireGearConfig;

    private static File ntrFile;
    private static FileConfiguration ntrConfig;

    private static File spartanWeaponryFile;
    private static FileConfiguration spartanWeaponryConfig;

    private static File mobFile;
    private static FileConfiguration mobConfig;

    private static File lMobsFile;
    private static FileConfiguration lMobsConfig;

    private static File itemFile;
    private static FileConfiguration itemConfig;

    private static File recipeFile;
    private static FileConfiguration recipeConfig;

    private static File tanFile;
    private static FileConfiguration tanConfig;

    // dependency injecting the main class for use
    private final RLCraftPlugin plugin;

    // constructing the CustomConfig class
    public CustomConfig(RLCraftPlugin instance) {
        plugin = instance;
    }

    /**
     * Creates the bauble config if one doesn't exist already and loads it in
     */
    public void createBaubleConfig() {
        baubleFile = new File(plugin.getDataFolder(), "bauble.yml"); // look for a file named "bauble.yml"

        // if the file "bauble.yml" doesn't exist in the RLCraft plugins folder
        if (!baubleFile.exists()) {
            // create a new yaml file
            baubleFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("bauble.yml", false);
        }

        baubleConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            baubleConfig.load(baubleFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the spartan weaponry config if one doesn't exist already and loads it in
     */
    public void createSpartanWeaponryConfig() {
        spartanWeaponryFile = new File(plugin.getDataFolder(), "spartanweaponry.yml"); // look for a file named "spartanweaponry.yml"

        // if the file "spartanweaponry.yml" doesn't exist in the RLCraft plugins folder
        if (!spartanWeaponryFile.exists()) {
            // create a new yaml file
            spartanWeaponryFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("spartanweaponry.yml", false);
        }

        spartanWeaponryConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            spartanWeaponryConfig.load(spartanWeaponryFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the ice and fire gear config if one doesn't exist already and loads it in
     */
    public void createIceFireGearConfig() {
        iceFireGearFile = new File(plugin.getDataFolder(), "icefiregear.yml"); // look for a file named "icefiregear.yml"

        // if the file "spartanweaponry.yml" doesn't exist in the RLCraft plugins folder
        if (!iceFireGearFile.exists()) {
            // create a new yaml file
            iceFireGearFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("icefiregear.yml", false);
        }

        iceFireGearConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            iceFireGearConfig.load(iceFireGearFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the no tree punching gear config if one doesn't exist already and loads it in
     */
    public void createNoTreePunchingConfig() {
        ntrFile = new File(plugin.getDataFolder(), "notreepunching.yml"); // look for a file named "notreepunching.yml"

        // if the file "notreepunching.yml" doesn't exist in the RLCraft plugins folder
        if (!ntrFile.exists()) {
            // create a new yaml file
            ntrFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("notreepunching.yml", false);
        }

        ntrConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            ntrConfig.load(ntrFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the mob config if one doesn't exist already and loads it in
     */
    public void createMobConfig() {
        mobFile = new File(plugin.getDataFolder(), "mobs.yml"); // look for a file named "mobs.yml"

        // if the file "mobs.yml" doesn't exist in the RLCraft plugins folder
        if (!mobFile.exists()) {
            // create a new yaml file
            mobFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("mobs.yml", false);
        }

        mobConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            mobConfig.load(mobFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the lycanite's mobs config if one doesn't exist already and loads it in
     */
    public void createLMobsConfig() {
        lMobsFile = new File(plugin.getDataFolder(), "lycanitesmobs.yml"); // look for a file named "lycanitesmobs.yml"

        // if the file "lycanitesmobs.yml" doesn't exist in the RLCraft plugins folder
        if (!lMobsFile.exists()) {
            // create a new yaml file
            lMobsFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("lycanitesmobs.yml", false);
        }

        lMobsConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            lMobsConfig.load(lMobsFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the resources folder which stores the item and recipe configs
     */
    public void createResourcesFolder() {
        resourcesFolder = new File(plugin.getDataFolder(), "resources"); // look for a folder named "resources"

        // if the folder "resources" doesn't exist in the RLCraft plugins folder
        if (!resourcesFolder.exists()) {
            // create the folder
            resourcesFolder.getParentFile().mkdirs();
        }
    }

    /**
     * Creates the item config if one doesn't exist already and loads it in
     */
    public void createItemConfig() {
        itemFile = new File(plugin.getDataFolder(), "resources/items.yml"); // look for a file named "items.yml" in the resources folder

        // if the file "items.yml" doesn't exist in the resources folder
        if (!itemFile.exists()) {
            // create a new yaml file
            itemFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("resources/items.yml", false);
        }

        itemConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            itemConfig.load(itemFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the recipe config if one doesn't exist already and loads it in
     */
    public void createRecipeConfig() {
        recipeFile = new File(plugin.getDataFolder(), "resources/recipes.yml"); // look for a file named "recipes.yml" in the resources folder

        // if the file "recipes.yml" doesn't exist in the resources folder
        if (!recipeFile.exists()) {
            // create a new yaml file
            recipeFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("resources/recipes.yml", false);
        }

        recipeConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            recipeConfig.load(recipeFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the toughasnails config if one doesn't exist already and loads it in
     */
    public void createTanConfig() {
        tanFile = new File(plugin.getDataFolder(), "toughasnails.yml"); // look for a file named "toughasnails.yml"

        // if the file "toughasnails.yml" doesn't exist in the resources folder
        if (!tanFile.exists()) {
            // create a new yaml file
            tanFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("toughasnails.yml", false);
        }

        tanConfig = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            tanConfig.load(tanFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Gets the bauble config
     * @return The config holding values for the baubles
     */
    public static FileConfiguration getBaubleConfig() {
        return baubleConfig;
    }

    /**
     * Gets the spartan weaponry config
     * @return The config holding values for the spartan weaponry items
     */
    public static FileConfiguration getSpartanWeaponryConfig() {
        return spartanWeaponryConfig;
    }

    /**
     * Gets the ice and fire gear config
     * @return The config holding values for the ice and fire items
     */
    public static FileConfiguration getIceFireGearConfig() {
        return iceFireGearConfig;
    }

    /**
     * Gets the no tree punching config
     * @return The config holding values for the no tree punching mechanics
     */
    public static FileConfiguration getNtrConfig() {
        return ntrConfig;
    }

    /**
     * Gets the mob config
     * @return The config holding values for the mob drop rates
     */
    public static FileConfiguration getMobConfig() {
        return mobConfig;
    }

    /**
     * Gets the lycanite's mobs config
     * @return The config holding values for the lycanite's mobs mechanics
     */
    public static FileConfiguration getlMobsConfig() {
        return lMobsConfig;
    }

    /**
     * Gets the item config
     * @return The config holding information of the custom items' meta
     */
    public static FileConfiguration getItemConfig() {
        return itemConfig;
    }

    /**
     * Gets the recipe config
     * @return The config holding information of the custom recipes
     */
    public static FileConfiguration getRecipeConfig() {
        return recipeConfig;
    }

    /**
     * Gets the toughasnails config
     * @return The config holding toughasnails information
     */
    public static FileConfiguration getTanConfig() {
        return tanConfig;
    }

    /**
     * Assigns the current bauble config to a new one
     * @param config The new config which the current bauble config should be set to
     */
    public void setBaubleConfig(FileConfiguration config) {
        baubleConfig = config;
    }

    /**
     * Assigns the current ice and fire config to a new one
     * @param config The new config which the current ice and fire config should be set to
     */
    public void setIceFireGearConfig(FileConfiguration config) {
        iceFireGearConfig = config;
    }

    /**
     * Assigns the current spartan weaponry config to a new one
     * @param config The new config which the current spartan weaponry config should be set to
     */
    public void setSpartanWeaponryConfig(FileConfiguration config) {
        spartanWeaponryConfig = config;
    }

    /**
     * Assigns the current no tree punching config to a new one
     * @param config The new config which the current no tree punching config should be set to
     */
    public void setNtrConfig(FileConfiguration config) {
        ntrConfig = config;
    }

    /**
     * Assigns the current mob config to a new one
     * @param config The new config which the current mob config should be set to
     */
    public void setMobConfig(FileConfiguration config) {
        mobConfig = config;
    }

    /**
     * Assigns the current lycanite's mobs config to a new one
     * @param config The new config which the current lycanite's mobs config should be set to
     */
    public void setLMobsConfig(FileConfiguration config) {
        lMobsConfig = config;
    }

    /**
     * Assigns the current item config to a new one
     * @param config The new config which the current items config should be set to
     */
    public void setItemConfig(FileConfiguration config) {
        itemConfig = config;
    }

    /**
     * Assigns the current recipe config to a new one
     * @param config The new config which the current recipe config should be set to
     */
    public void setRecipeConfig(FileConfiguration config) {
        recipeConfig = config;
    }

    /**
     * Assigns the current toughasnails config to a new one
     * @param config The new config which the current toughasnails config should be set to
     */
    public void setTanConfig(FileConfiguration config) {
        tanConfig = config;
    }

    /**
     * Reloads the bauble config to use the most recent values
     */
    public void reloadBaubleConfig() {
        setBaubleConfig(YamlConfiguration.loadConfiguration(baubleFile));
    }

    /**
     * Reloads the spartan weaponry config to use the most recent values
     */
    public void reloadSpartanWeaponryConfig() {
        setSpartanWeaponryConfig(YamlConfiguration.loadConfiguration(spartanWeaponryFile));
    }

    /**
     * Reloads the ice and fire config to use the most recent values
     */
    public void reloadIceFireGearConfig() {
        setIceFireGearConfig(YamlConfiguration.loadConfiguration(iceFireGearFile));
    }

    /**
     * Reloads the no tree punching config to use the most recent values
     */
    public void reloadNtrConfig() {
        setNtrConfig(YamlConfiguration.loadConfiguration(ntrFile));
    }

    /**
     * Reloads the mob config to use the most recent values
     */
    public void reloadMobConfig() {
        setMobConfig(YamlConfiguration.loadConfiguration(mobFile));
    }

    /**
     * Reloads the lycanite's mobs config to use the most recent values
     */
    public void reloadLycanitesMobsConfig() {
        setLMobsConfig(YamlConfiguration.loadConfiguration(lMobsFile));
    }

    /**
     * Reloads the items config to use the most recent values
     */
    public void reloadItemConfig() {
        setItemConfig(YamlConfiguration.loadConfiguration(itemFile));
    }

    /**
     * Reloads the recipe config to use the most recent values
     */
    public void reloadRecipeConfig() {
        setItemConfig(YamlConfiguration.loadConfiguration(recipeFile));
    }

    /**
     * Reloads the recipe config to use the most recent values
     */
    public void reloadTanConfig() {
        setItemConfig(YamlConfiguration.loadConfiguration(tanFile));
    }
}