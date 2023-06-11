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
package me.val_mobile.integrations;

import me.casperge.realisticseasons.api.SeasonsAPI;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.tan.TanModule;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class RealisticSeasons extends CompatiblePlugin {

    public static final String NAME = "RealisticSeasons";

    public RealisticSeasons(RealisticSurvivalPlugin plugin) {
        super(plugin, NAME);
    }

    @Override
    public boolean otherLoadOptions() {
        return me.casperge.realisticseasons.RealisticSeasons.getInstance().getTemperatureManager().getTempData().isEnabled() && RSVModule.getModule(TanModule.NAME).isGloballyEnabled();
    }

    public int getTemperature(@Nonnull Player player) {
        int temp = SeasonsAPI.getInstance().getTemperature(player);

        if (me.casperge.realisticseasons.RealisticSeasons.getInstance().getTemperatureManager().hasFahrenheitEnabled(player)) {
            temp = (int) Math.round(5D/9 * (temp - 32));
        }
        return temp;
    }

    public boolean hasTemperatureEnabled(Player player) {
        return me.casperge.realisticseasons.RealisticSeasons.getInstance().getTemperatureManager().hasTemperature(player);
    }

    public double getDefaultTemperature() {
        return intConfig.getDouble(NAME + ".DefaultTemperature");
    }

    public double getColdMultiplier() {
        return intConfig.getDouble(NAME + ".ColdMultiplier");
    }

    public double getHotMultiplier() {
        return intConfig.getDouble(NAME + ".HotMultiplier");
    }

    public boolean disableHypothermiaCompletely() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hypothermia.DisableCompletely");
    }

    public boolean disableHypothermiaDamage() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hypothermia.DisableDamage");
    }

    public boolean disableHypothermiaPotions() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hypothermia.DisablePotionEffects");
    }

    public boolean disableHypothermiaTinting() {
        return isIntegrated && intConfig.getBoolean(NAME + ".VisualEffects.DisableColdScreenTinting");
    }

    public boolean disableHyperthermiaCompletely() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hyperthermia.DisableCompletely");
    }

    public boolean disableHyperthermiaDamage() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hyperthermia.DisableDamage");
    }

    public boolean disableHyperthermiaIgnite() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hyperthermia.DisableIgnite");
    }

    public boolean disableHyperthermiaPotions() {
        return isIntegrated && intConfig.getBoolean(NAME + ".Hyperthermia.DisablePotionEffects");
    }

    public boolean disableHyperthermiaTinting() {
        return isIntegrated && intConfig.getBoolean(NAME + ".VisualEffects.DisableHotScreenTinting");
    }

    public boolean disableColdBreath() {
        return isIntegrated && intConfig.getBoolean(NAME + ".VisualEffects.DisableColdBreath");
    }

    public boolean disableSweating() {
        return isIntegrated && intConfig.getBoolean(NAME + ".VisualEffects.DisableSweating");
    }
}
