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

import static me.val_mobile.tan.TemperatureCalculateTask.NEUTRAL_TEMPERATURE;
import static me.val_mobile.tan.ThirstCalculateTask.DEFAULT_SATURATION;
import static me.val_mobile.tan.ThirstCalculateTask.MINIMUM_THIRST;

public class DataModule implements RSVDataModule {

    private final UUID id;
    private final PlayerDataConfig config;
    private final RealisticSurvivalPlugin plugin;
    private double temperature;
    private double thirst;
    private double thirstExhaustion;
    private double thirstSaturation;
    private int thirstTickTimer;

    public DataModule(RealisticSurvivalPlugin plugin, Player player) {
        this.config = ((TanModule) RSVModule.getModule(TanModule.NAME)).getPlayerDataConfig();
        this.plugin = plugin;
        this.id = player.getUniqueId();

        retrieveData();
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
        FileConfiguration config = this.config.getConfig();

        String tempPath = id + ".Temperature";
        String thirstPath = id + ".Thirst";
        String saturationPath = id + ".ThirstSaturation";
        String exhaustionPath = id + ".ThirstExhaustion";
        String tickTimer = id + ".ThirstTickTimer";

        if (!config.getConfigurationSection("").contains(id.toString())) {
            config.createSection(id.toString());
            config.createSection(tempPath);
            config.createSection(thirstPath);
            config.createSection(saturationPath);
            config.createSection(exhaustionPath);
            config.createSection(tickTimer);
            config.set(tempPath, NEUTRAL_TEMPERATURE);
            config.set(thirstPath, MINIMUM_THIRST);
            config.set(saturationPath, DEFAULT_SATURATION);
            config.set(exhaustionPath, 0D);
            config.set(tickTimer, 0);

            saveFile();
        }
        this.temperature = config.getDouble(tempPath);
        this.thirst = config.getDouble(thirstPath);
        this.thirstSaturation = config.getDouble(saturationPath);
        this.thirstExhaustion = config.getDouble(exhaustionPath);
        this.thirstTickTimer = config.getInt(tickTimer);
    }

    @Override
    public void saveData() {
        FileConfiguration config = this.config.getConfig();

        config.set(id + ".Temperature", temperature);
        config.set(id + ".Thirst", thirst);
        config.set(id + ".ThirstSaturation", thirstSaturation);
        config.set(id + ".ThirstExhaustion", thirstExhaustion);
        config.set(id + ".ThirstTickTimer", thirstTickTimer);

        saveFile();
    }

    public void saveFile() {
        try {
            config.getConfig().save(this.config.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
