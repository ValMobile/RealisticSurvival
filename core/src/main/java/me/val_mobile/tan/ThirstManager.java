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
package me.val_mobile.tan;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.toughasnails.DataModule;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class ThirstManager {

    private final TanModule module;
    private final FileConfiguration config;

    public ThirstManager(TanModule module) {
        this.module = module;
        this.config = module.getUserConfig().getConfig();
    }

    public boolean isThirstEnabled(@Nullable Player player) {
        return module.isThirstGloballyEnabled() && RSVPlayer.isValidPlayer(player) && module.isEnabled(player) && RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule() != null;
    }

    public boolean hasParasites(@Nullable Player player) {
        if (isThirstEnabled(player)) {
            return ParasiteTask.hasTask(player.getUniqueId());
        }
        return false;
    }

    public int getThirst(@Nullable Player player) {
        if (isThirstEnabled(player)) {
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                return ThirstCalculateTask.getTasks().get(player.getUniqueId()).getThirstLvl();
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                return module.getThirst();
            }
        }
        return ThirstCalculateTask.MINIMUM_THIRST;
    }

    public int getSaturation(@Nullable Player player) {
        if (isThirstEnabled(player)) {
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                return ThirstCalculateTask.getTasks().get(player.getUniqueId()).getSaturationLvl();
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                return module.getThirstSaturation();
            }
        }
        return 0;
    }

    public double getExhaustion(@Nullable Player player) {
        if (isThirstEnabled(player)) {
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                return ThirstCalculateTask.getTasks().get(player.getUniqueId()).getExhaustionLvl();
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                return module.getThirstExhaustion();
            }
        }
        return 0;
    }

    public int getTickTimer(@Nullable Player player) {
        if (isThirstEnabled(player)) {
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                return ThirstCalculateTask.getTasks().get(player.getUniqueId()).getTickTimer();
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                return module.getThirstTickTimer();
            }
        }
        return 0;
    }

    public void setSaturation(@Nullable Player player, int saturation) {
        if (isThirstEnabled(player)) {
            saturation = Utils.clamp(saturation, 0, getThirst(player));
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                ThirstCalculateTask.getTasks().get(player.getUniqueId()).setSaturationLvl(saturation);
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                module.setThirstSaturation(saturation);
            }
        }
    }

    public void addSaturation(@Nullable Player player, int saturation) {
        setSaturation(player, getSaturation(player) + saturation);
    }

    public void setExhaustion(@Nullable Player player, double exhaustion) {
        if (isThirstEnabled(player)) {
            exhaustion = Utils.clamp(exhaustion, 0, Integer.MAX_VALUE);
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                ThirstCalculateTask.getTasks().get(player.getUniqueId()).setExhaustionLvl(exhaustion);
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                module.setThirstExhaustion(exhaustion);
            }
        }
    }

    public void addExhaustion(@Nullable Player player, double exhaustion) {
        boolean hasParasites = hasParasites(player) && config.getBoolean("Thirst.Parasites.MultiplyExhaustionRates.Enabled");
        exhaustion *= hasParasites ? config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value") : 1;
        setExhaustion(player, getExhaustion(player) + exhaustion);
    }

    public void setTickTimer(@Nullable Player player, int tickTimer) {
        if (isThirstEnabled(player)) {
            tickTimer = Utils.clamp(tickTimer, 0, 80);
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                ThirstCalculateTask.getTasks().get(player.getUniqueId()).setTickTimer(tickTimer);
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                module.setThirstTickTimer(tickTimer);
            }
        }
    }

    public void addTickTimer(@Nullable Player player, int tickTimer) {
        setTickTimer(player, getTickTimer(player) + tickTimer);
    }

    public void setThirst(@Nullable Player player, int thirst) {
        if (isThirstEnabled(player)) {
            thirst = Utils.clamp(thirst, ThirstCalculateTask.MINIMUM_THIRST, ThirstCalculateTask.MAXIMUM_THIRST);
            int saturation = Utils.clamp(getSaturation(player), 0, thirst);

            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                ThirstCalculateTask.getTasks().get(player.getUniqueId()).setThirstLvl(thirst);
                ThirstCalculateTask.getTasks().get(player.getUniqueId()).setSaturationLvl(saturation);
            }

            DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getTanDataModule();

            if (module != null) {
                module.setThirst(thirst);
                module.setThirstSaturation(saturation);
            }
        }
    }

    public void addThirst(@Nullable Player player, int thirst) {
        setThirst(player, getThirst(player) + thirst);
    }
}
