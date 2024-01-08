/*
    Copyright (C) 2024  Val_Mobile

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
package me.val_mobile.tan;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.toughasnails.DataModule;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class TempManager {

    private final TanModule module;

    public TempManager(TanModule module) {
        this.module = module;
    }

    public boolean isTempEnabled(@Nullable Player player) {
        return module.isTempGloballyEnabled() && RSVPlayer.isValidPlayer(player) && module.isEnabled(player) && RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule() != null;
    }

    public double getTemperature(@Nullable Player player) {
        if (isTempEnabled(player)) {
            if (TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                return TemperatureCalculateTask.getTasks().get(player.getUniqueId()).getTemp();
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                return module.getTemperature();
            }
        }
        return TemperatureCalculateTask.MINIMUM_TEMPERATURE;
    }

    public void setTemperature(@Nullable Player player, double temperature) {
        if (isTempEnabled(player)) {
            temperature = Utils.clamp(temperature, TemperatureCalculateTask.MINIMUM_TEMPERATURE, TemperatureCalculateTask.MAXIMUM_TEMPERATURE);
            if (TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                TemperatureCalculateTask.getTasks().get(player.getUniqueId()).setTemp(temperature);
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                module.setTemperature(temperature);
            }
        }
    }

    public void addTemperature(@Nullable Player player, double addition) {
        if (isTempEnabled(player)) {
            double temperature = Utils.clamp(getTemperature(player) + addition, TemperatureCalculateTask.MINIMUM_TEMPERATURE, TemperatureCalculateTask.MAXIMUM_TEMPERATURE);
            if (TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                TemperatureCalculateTask.getTasks().get(player.getUniqueId()).setTemp(temperature);
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                module.setTemperature(temperature);
            }
        }
    }
}
