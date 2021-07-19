package me.val_mobile.rlcraft;

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

    // initializing class variables to store the yaml files
    private static File baubleConfigFile;
    private static FileConfiguration baubleConfig;

    private static File iceFireGearConfigFile;
    private static FileConfiguration iceFireGearConfig;

    private static File noTreePunchingConfigFile;
    private static FileConfiguration noTreePunchingConfig;

    private static File spartanWeaponryConfigFile;
    private static FileConfiguration spartanWeaponryConfig;

    private static File mobConfigFile;
    private static FileConfiguration mobConfig;

    private static File lycanitesMobsConfigFile;
    private static FileConfiguration lycanitesMobsConfig;

    private static File itemsConfigFile;
    private static FileConfiguration itemsConfig;

    // dependency injecting the main class for use
    private final RLCraft plugin;

    // constructing the CustomConfig class
    public CustomConfig(RLCraft instance) {
        plugin = instance;
    }

    /**
     * Creates the bauble config if one doesn't exist already and loads it in
     */
    public void createBaubleConfig() {
        baubleConfigFile = new File(plugin.getDataFolder(), "bauble.yml"); // assign the config file to a new file with the name "bauble.yml"

        // if the file "bauble.yml" doesn't exist in the RLCraft plugins folder
        if (!baubleConfigFile.exists()) {
            // make a new yaml file
            baubleConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("bauble.yml", false);
        }

        baubleConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            baubleConfig.load(baubleConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the spartan weaponry config if one doesn't exist already and loads it in
     */
    public void createSpartanWeaponryConfig() {
        spartanWeaponryConfigFile = new File(plugin.getDataFolder(), "spartanweaponry.yml"); // assign the config file to a new file with the name "spartanweaponry.yml"

        // if the file "spartanweaponry.yml" doesn't exist in the RLCraft plugins folder
        if (!spartanWeaponryConfigFile.exists()) {
            // make a new yaml file
            spartanWeaponryConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("spartanweaponry.yml", false);
        }

        spartanWeaponryConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            spartanWeaponryConfig.load(spartanWeaponryConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the ice and fire gear config if one doesn't exist already and loads it in
     */
    public void createIceFireGearConfig() {
        iceFireGearConfigFile = new File(plugin.getDataFolder(), "icefiregear.yml"); // assign the config file to a new file with the name "icefiregear.yml"

        // if the file "icefiregear.yml" doesn't exist in the RLCraft plugins folder
        if (!iceFireGearConfigFile.exists()) {
            // make a new yaml file
            iceFireGearConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("icefiregear.yml", false);
        }

        iceFireGearConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            iceFireGearConfig.load(iceFireGearConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the no tree punching gear config if one doesn't exist already and loads it in
     */
    public void createNoTreePunchingConfig() {
        noTreePunchingConfigFile = new File(plugin.getDataFolder(), "notreepunching.yml"); // assign the config file to a new file with the name "notreepunching.yml"

        // if the file "notreepunching.yml" doesn't exist in the RLCraft plugins folder
        if (!noTreePunchingConfigFile.exists()) {
            // make a new yaml file
            noTreePunchingConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("notreepunching.yml", false);
        }

        noTreePunchingConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            noTreePunchingConfig.load(noTreePunchingConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the mob config if one doesn't exist already and loads it in
     */
    public void createMobConfig() {
        mobConfigFile = new File(plugin.getDataFolder(), "mobs.yml"); // assign the config file to a new file with the name "mobs.yml"

        // if the file "mobs.yml" doesn't exist in the RLCraft plugins folder
        if (!mobConfigFile.exists()) {
            // make a new yaml file
            mobConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("mobs.yml", false);
        }

        mobConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            mobConfig.load(mobConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the lycanite's mobs config if one doesn't exist already and loads it in
     */
    public void createLycanitesMobsConfig() {
        lycanitesMobsConfigFile = new File(plugin.getDataFolder(), "lycanitesmobs.yml"); // assign the config file to a new file with the name "lycanitesmobs.yml"

        // if the file "lycanitesmobs.yml" doesn't exist in the RLCraft plugins folder
        if (!lycanitesMobsConfigFile.exists()) {
            // make a new yaml file
            lycanitesMobsConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("lycanitesmobs.yml", false);
        }

        lycanitesMobsConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            lycanitesMobsConfig.load(lycanitesMobsConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }
    }

    /**
     * Creates the items config if one doesn't exist already and loads it in
     */
    public void createItemsConfig() {
        itemsConfigFile = new File(plugin.getDataFolder(), "items.yml"); // assign the config file to a new file with the name "items.yml"

        // if the file "items.yml" doesn't exist in the RLCraft plugins folder
        if (!itemsConfigFile.exists()) {
            // make a new yaml file
            itemsConfigFile.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource("items.yml", false);
        }

        itemsConfig = new YamlConfiguration(); // assign the config to an empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            itemsConfig.load(itemsConfigFile);
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
    public static FileConfiguration getNoTreePunchingConfig() {
        return noTreePunchingConfig;
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
    public static FileConfiguration getLycanitesMobsConfig() {
        return lycanitesMobsConfig;
    }

    /**
     * Gets the items config
     * @return The config holding information of the custom items' meta
     */
    public static FileConfiguration getItemsConfig() {
        return itemsConfig;
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
    public void setNoTreePunchingConfig(FileConfiguration config) {
        noTreePunchingConfig = config;
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
    public void setLycanitesMobsConfig(FileConfiguration config) {
        lycanitesMobsConfig = config;
    }

    /**
     * Assigns the current items config to a new one
     * @param config The new config which the current items config should be set to
     */
    public void setItemsConfig(FileConfiguration config) {
        itemsConfig = config;
    }

    /**
     * Reloads the bauble config to use the most recent values
     */
    public void reloadBaubleConfig() {
        setBaubleConfig(YamlConfiguration.loadConfiguration(baubleConfigFile));
    }

    /**
     * Reloads the spartan weaponry config to use the most recent values
     */
    public void reloadSpartanWeaponryConfig() {
        setSpartanWeaponryConfig(YamlConfiguration.loadConfiguration(spartanWeaponryConfigFile));
    }

    /**
     * Reloads the ice and fire config to use the most recent values
     */
    public void reloadIceFireGearConfig() {
        setIceFireGearConfig(YamlConfiguration.loadConfiguration(iceFireGearConfigFile));
    }

    /**
     * Reloads the no tree punching config to use the most recent values
     */
    public void reloadNoTreePunchingConfig() {
        setNoTreePunchingConfig(YamlConfiguration.loadConfiguration(noTreePunchingConfigFile));
    }

    /**
     * Reloads the mob config to use the most recent values
     */
    public void reloadMobConfig() {
        setMobConfig(YamlConfiguration.loadConfiguration(mobConfigFile));
    }

    /**
     * Reloads the lycanite's mobs config to use the most recent values
     */
    public void reloadLycanitesMobsConfig() {
        setLycanitesMobsConfig(YamlConfiguration.loadConfiguration(lycanitesMobsConfigFile));
    }

    /**
     * Reloads the items config to use the most recent values
     */
    public void reloadItemsConfig() {
        setItemsConfig(YamlConfiguration.loadConfiguration(itemsConfigFile));
    }
}
