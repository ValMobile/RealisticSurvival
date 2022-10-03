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
package me.val_mobile.data.toughasnails;

import me.val_mobile.data.RSVDataModule;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.tan.TanModule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class DataModule implements RSVDataModule {

    private final UUID id;
    private final FileConfiguration userConfig;
    private final PlayerDataConfig playerDataConfig;
    private double temperature;
    private double thirst;
    private double thirstExhaustion;
    private double thirstSaturation;
    private int thirstTickTimer;
    private final RealisticSurvivalPlugin plugin;

    public DataModule(RealisticSurvivalPlugin plugin, Player player) {
        TanModule module = (TanModule) RSVModule.getModule(TanModule.NAME);
        this.plugin = plugin;
        this.userConfig = module.getUserConfig().getConfig();
        this.playerDataConfig = module.getPlayerDataConfig();
        this.id = player.getUniqueId();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getThirst() {
        return thirst;
    }

    public double getThirstExhaustion() {
        return thirstExhaustion;
    }

    public double getThirstSaturation() {
        return thirstSaturation;
    }

    public int getThirstTickTimer() {
        return thirstTickTimer;
    }

    public void setThirstExhaustion(double thirstExhaustion) {
        this.thirstExhaustion = thirstExhaustion;
    }

    public void setThirstSaturation(double thirstSaturation) {
        this.thirstSaturation = thirstSaturation;
    }

    public void setThirstTickTimer(int thirstTickTimer) {
        this.thirstTickTimer = thirstTickTimer;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setThirst(double thirst) {
        this.thirst = thirst;
    }

    @Override
    public void retrieveData() {
        FileConfiguration config = playerDataConfig.getConfig();

        String tempPath = id + ".Temperature";
        String thirstPath = id + ".Thirst";
        String saturationPath = id + ".ThirstSaturation";
        String exhaustionPath = id + ".ThirstExhaustion";
        String tickTimerPath = id + ".ThirstTickTimer";

        double defaultTemp = userConfig.getDouble("Temperature.DefaultTemperature");
        double defaultThirst = userConfig.getDouble("Thirst.DefaultThirst");
        double defaultSaturation = userConfig.getDouble("Thirst.DefaultSaturation");
        double defaultExhaustion = userConfig.getDouble("Thirst.DefaultExhaustion");
        double defaultTickTimer = userConfig.getDouble("Thirst.DefaultExhaustionTickTimer");

        if (!config.contains(id.toString()))
            config.createSection(id.toString());
        if (!config.contains(tempPath)) {
            config.createSection(tempPath);
            config.set(tempPath, defaultTemp);
        }
        if (!config.contains(thirstPath)) {
            config.createSection(thirstPath);
            config.set(tempPath, defaultThirst);
        }
        if (!config.contains(saturationPath)) {
            config.createSection(saturationPath);
            config.set(saturationPath, defaultSaturation);
        }
        if (!config.contains(exhaustionPath)) {
            config.createSection(exhaustionPath);
            config.set(exhaustionPath, defaultExhaustion);
        }
        if (!config.contains(tickTimerPath)) {
            config.createSection(tickTimerPath);
            config.set(tickTimerPath, defaultTickTimer);
        }

        temperature = config.getDouble(tempPath);
        thirst = config.getDouble(thirstPath);
        thirstSaturation = config.getDouble(saturationPath);
        thirstExhaustion = config.getDouble(exhaustionPath);
        thirstTickTimer = config.getInt(tickTimerPath);

        saveFile(config);
    }

    @Override
    public void saveData() {
        FileConfiguration config = this.playerDataConfig.getConfig();

        String tempPath = id + ".Temperature";
        String thirstPath = id + ".Thirst";
        String saturationPath = id + ".ThirstSaturation";
        String exhaustionPath = id + ".ThirstExhaustion";
        String tickTimer = id + ".ThirstTickTimer";

        if (!config.contains(id.toString()))
            config.createSection(id.toString());
        if (!config.contains(tempPath)) {
            config.createSection(tempPath);
        }
        if (!config.contains(thirstPath)) {
            config.createSection(thirstPath);
        }
        if (!config.contains(saturationPath)) {
            config.createSection(saturationPath);
        }
        if (!config.contains(exhaustionPath)) {
            config.createSection(exhaustionPath);
        }
        if (!config.contains(tickTimer)) {
            config.createSection(tickTimer);
        }

        config.set(tempPath, temperature);
        config.set(thirstPath, thirst);
        config.set(saturationPath, thirstSaturation);
        config.set(exhaustionPath, thirstExhaustion);
        config.set(tickTimer, thirstTickTimer);

        saveFile(config);
    }

    public void saveFile(FileConfiguration config) {
        try {
            playerDataConfig.setConfig(config);
            playerDataConfig.getConfig().save(playerDataConfig.getFile());
            playerDataConfig.reloadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
