package me.val_mobile.rlcraft;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private final RLCraft plugin;
    private static File baubleConfigFile;
    private static FileConfiguration baubleConfig;

    private static File iceFireGearConfigFile;
    private static FileConfiguration iceFireGearConfig;

    private static File noTreePunchingConfigFile;
    private static FileConfiguration noTreePunchingConfig;

    private static File spartanWeaponryConfigFile;
    private static FileConfiguration spartanWeaponryConfig;

    private static File mobLootConfigFile;
    private static FileConfiguration mobLootConfig;

    public CustomConfig(RLCraft instance) {
        plugin = instance;
    }

    public FileConfiguration getBaubleConfig() {
        return baubleConfig;
    }

    public void setBaubleConfig(FileConfiguration config) {
        baubleConfig = config;
    }

    public File getBaubleFile() {
        return baubleConfigFile;
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

    public FileConfiguration getSpartanWeaponryConfig() {
        return spartanWeaponryConfig;
    }

    public void setSpartanWeaponryConfig(FileConfiguration config) {
        spartanWeaponryConfig = config;
    }

    public File getSpartanWeaponryFile() {
        return spartanWeaponryConfigFile;
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

    public FileConfiguration getIceFireGearConfig() {
        return iceFireGearConfig;
    }

    public void setIceFireGearConfig(FileConfiguration config) {
        iceFireGearConfig = config;
    }

    public File getIceFireGearFile() {
        return iceFireGearConfigFile;
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

    public FileConfiguration getNoTreePunchingConfig() {
        return noTreePunchingConfig;
    }

    public void setNoTreePunchingConfig(FileConfiguration config) {
        noTreePunchingConfig = config;
    }

    public File getNoTreePunchingFile() {
        return noTreePunchingConfigFile;
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

    public FileConfiguration getMobLootConfig() {
        return mobLootConfig;
    }

    public void setMobLootConfig(FileConfiguration config) {
        mobLootConfig = config;
    }

    public File getMobLootFile() {
        return mobLootConfigFile;
    }

    public void createMobLootConfig() {
        mobLootConfigFile = new File(plugin.getDataFolder(), "mobs.yml");
        if (!mobLootConfigFile.exists()) {
            mobLootConfigFile.getParentFile().mkdirs();
            plugin.saveResource("mobs.yml", false);
        }

        mobLootConfig = new YamlConfiguration();
        try {
            mobLootConfig.load(mobLootConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
