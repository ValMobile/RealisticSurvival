package me.val_mobile.rlcraft;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private final RLCraft plugin;
    public CustomConfig(RLCraft instance) {
        plugin = instance;
    }

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

    public static FileConfiguration getBaubleConfig() {
        return baubleConfig;
    }

    public void setBaubleConfig(FileConfiguration config) {
        baubleConfig = config;
    }

    public void createBaubleConfig() {
        baubleConfigFile = new File(plugin.getDataFolder(), "bauble.yml");
        if (!baubleConfigFile.exists()) {
            baubleConfigFile.getParentFile().mkdirs();
            plugin.saveResource("bauble.yml", false);
        }

        baubleConfig = new YamlConfiguration();
        try {
            baubleConfig.load(baubleConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadBaubleConfig() {
        setBaubleConfig(YamlConfiguration.loadConfiguration(baubleConfigFile));
    }

    public static FileConfiguration getSpartanWeaponryConfig() {
        return spartanWeaponryConfig;
    }

    public void setSpartanWeaponryConfig(FileConfiguration config) {
        spartanWeaponryConfig = config;
    }

    public void createSpartanWeaponryConfig() {
        spartanWeaponryConfigFile = new File(plugin.getDataFolder(), "spartanweaponry.yml");
        if (!spartanWeaponryConfigFile.exists()) {
            spartanWeaponryConfigFile.getParentFile().mkdirs();
            plugin.saveResource("spartanweaponry.yml", false);
        }

        spartanWeaponryConfig = new YamlConfiguration();
        try {
            spartanWeaponryConfig.load(spartanWeaponryConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadSpartanWeaponryConfig() {
        setSpartanWeaponryConfig(YamlConfiguration.loadConfiguration(spartanWeaponryConfigFile));
    }

    public static FileConfiguration getIceFireGearConfig() {
        return iceFireGearConfig;
    }

    public void setIceFireGearConfig(FileConfiguration config) {
        iceFireGearConfig = config;
    }

    public void createIceFireGearConfig() {
        iceFireGearConfigFile = new File(plugin.getDataFolder(), "icefiregear.yml");
        if (!iceFireGearConfigFile.exists()) {
            iceFireGearConfigFile.getParentFile().mkdirs();
            plugin.saveResource("icefiregear.yml", false);
        }

        iceFireGearConfig = new YamlConfiguration();
        try {
            iceFireGearConfig.load(iceFireGearConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadIceFireGearConfig() {
        setIceFireGearConfig(YamlConfiguration.loadConfiguration(iceFireGearConfigFile));
    }

    public static FileConfiguration getNoTreePunchingConfig() {
        return noTreePunchingConfig;
    }

    public void setNoTreePunchingConfig(FileConfiguration config) {
        noTreePunchingConfig = config;
    }

    public void createNoTreePunchingConfig() {
        noTreePunchingConfigFile = new File(plugin.getDataFolder(), "notreepunching.yml");
        if (!noTreePunchingConfigFile.exists()) {
            noTreePunchingConfigFile.getParentFile().mkdirs();
            plugin.saveResource("notreepunching.yml", false);
        }

        noTreePunchingConfig = new YamlConfiguration();
        try {
            noTreePunchingConfig.load(noTreePunchingConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadNoTreePunchingConfig() {
        setNoTreePunchingConfig(YamlConfiguration.loadConfiguration(noTreePunchingConfigFile));
    }

    public static FileConfiguration getMobConfig() {
        return mobConfig;
    }

    public void setMobConfig(FileConfiguration config) {
        mobConfig = config;
    }

    public void createMobConfig() {
        mobConfigFile = new File(plugin.getDataFolder(), "mobs.yml");
        if (!mobConfigFile.exists()) {
            mobConfigFile.getParentFile().mkdirs();
            plugin.saveResource("mobs.yml", false);
        }

        mobConfig = new YamlConfiguration();
        try {
            mobConfig.load(mobConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadMobConfig() {
        setMobConfig(YamlConfiguration.loadConfiguration(mobConfigFile));
    }

    public static FileConfiguration getLycanitesMobsConfig() {
        return lycanitesMobsConfig;
    }

    public void setLycanitesMobsConfig(FileConfiguration config) {
        lycanitesMobsConfig = config;
    }

    public void createLycanitesMobsConfig() {
        lycanitesMobsConfigFile = new File(plugin.getDataFolder(), "lycanitesmobs.yml");
        if (!lycanitesMobsConfigFile.exists()) {
            lycanitesMobsConfigFile.getParentFile().mkdirs();
            plugin.saveResource("lycanitesmobs.yml", false);
        }

        lycanitesMobsConfig = new YamlConfiguration();
        try {
            lycanitesMobsConfig.load(lycanitesMobsConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadLycanitesMobsConfig() {
        setLycanitesMobsConfig(YamlConfiguration.loadConfiguration(lycanitesMobsConfigFile));
    }

    public static FileConfiguration getItemsConfig() {
        return itemsConfig;
    }

    public void setItemsConfig(FileConfiguration config) {
        itemsConfig = config;
    }

    public void createItemsConfig() {
        itemsConfigFile = new File(plugin.getDataFolder(), "items.yml");
        if (!itemsConfigFile.exists()) {
            itemsConfigFile.getParentFile().mkdirs();
            plugin.saveResource("items.yml", false);
        }

        itemsConfig = new YamlConfiguration();
        try {
            itemsConfig.load(itemsConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadItemsConfig() {
        setItemsConfig(YamlConfiguration.loadConfiguration(itemsConfigFile));
    }
}
