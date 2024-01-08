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
package me.val_mobile.utils;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.tan.TanModule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public class CharacterValues {

    private final FileConfiguration tanConfig;
    private final FileConfiguration ifConfig;

    public CharacterValues() {
        RSVModule tanModule = RSVModule.getModule(TanModule.NAME);
        RSVModule ifModule = RSVModule.getModule(IceFireModule.NAME);

        this.tanConfig = tanModule.isGloballyEnabled() ? tanModule.getUserConfig().getConfig() : null;
        this.ifConfig = ifModule.isGloballyEnabled() ? ifModule.getUserConfig().getConfig() : null;
    }

    @Nonnull
    public String getTemperatureOnlyActionbar(@Nullable Player player, @Nonnegative int temperature) {
        String s = tanConfig.getString("CharacterOverrides.TemperatureActionbar");
        return Utils.translateMsg(s, player, Map.of("TEMP", getTemperature(player, temperature)));
    }

    @Nonnull
    public String getThirstOnlyActionbar(@Nullable Player player, @Nonnegative int thirst, boolean isUnderwater, boolean parasitesActive) {
        String s = tanConfig.getString("CharacterOverrides.ThirstActionbar");
        return Utils.translateMsg(s, player, Map.of("THIRST", getThirst(player, thirst, isUnderwater, parasitesActive)));
    }

    @Nonnull
    public String getTemperatureThirstActionbar(@Nullable Player player, @Nonnegative int temperature, @Nonnegative int thirst, boolean isUnderwater, boolean parasitesActive) {
        String s = tanConfig.getString("CharacterOverrides.TemperatureThirstActionbar");
        return Utils.translateMsg(s, player, Map.of("TEMP", getTemperature(player, temperature), "THIRST", getThirst(player, thirst, isUnderwater, parasitesActive)));
    }

    @Nonnull
    public String getThirst(@Nullable Player player, @Nonnegative int thirst, boolean isUnderwater, boolean parasitesActive) {

        final String EMPTY_THIRST_DROP = Utils.translateMsg(isUnderwater ? tanConfig.getString("CharacterOverrides.UnderwaterEmptyThirstDrop") : tanConfig.getString("CharacterOverrides.AboveWaterEmptyThirstDrop"), player, null);
        final String HALF_THIRST_DROP;
        final String FULL_THIRST_DROP;
        if (parasitesActive) {
            HALF_THIRST_DROP = Utils.translateMsg(isUnderwater ? tanConfig.getString("CharacterOverrides.ParasitesUnderwaterHalfThirstDrop") : tanConfig.getString("CharacterOverrides.ParasitesAboveWaterHalfThirstDrop"), player, null);
            FULL_THIRST_DROP =  Utils.translateMsg(isUnderwater ? tanConfig.getString("CharacterOverrides.ParasitesUnderwaterFullThirstDrop"): tanConfig.getString("CharacterOverrides.ParasitesAboveWaterFullThirstDrop"), player, null);
        }
        else {
            HALF_THIRST_DROP = Utils.translateMsg(isUnderwater ? tanConfig.getString("CharacterOverrides.UnderwaterHalfThirstDrop") : tanConfig.getString("CharacterOverrides.AboveWaterHalfThirstDrop"), player, null);
            FULL_THIRST_DROP = Utils.translateMsg(isUnderwater ? tanConfig.getString("CharacterOverrides.UnderwaterFullThirstDrop") : tanConfig.getString("CharacterOverrides.AboveWaterFullThirstDrop"), player, null);
        }


        thirst = (thirst < 0) ? 0 : Math.min(thirst, 20);

        StringBuilder s = new StringBuilder();

        int numHalf;
        int numEmpty;

        if (thirst % 2 == 0) {
            numHalf = 0;
            numEmpty = (20 - thirst) / 2;
        }
        else {
            numHalf = 1;
            numEmpty = (19 - thirst) / 2;
        }

        s.append(FULL_THIRST_DROP.repeat((20 - numHalf - numEmpty * 2) / 2));

        if (numHalf == 1) {
            s.insert(0, HALF_THIRST_DROP);
        }

        for (int i = 0; i < numEmpty; i++) {
            s.insert(0, EMPTY_THIRST_DROP);
        }

        return s.toString();
    }

    @Nonnull
    public String getThirstDrop(@Nullable Player player, int i) {
        return switch (i) {
            case 0 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.AboveWaterEmptyThirstDrop"), player, null);
            case 1 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.AboveWaterHalfThirstDrop"), player, null);
            case 2 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.AboveWaterFullThirstDrop"), player, null);
            default -> "";
        };
    }

    @Nonnull
    public String getIceVignette(@Nullable Player player, int temperature) {
        return switch (temperature) {
            case 0 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.FreezingView"), player, null);
            case 1 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.IceVignette5"), player, null);
            case 2 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.IceVignette4"), player, null);
            case 3 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.IceVignette3"), player, null);
            case 4 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.IceVignette2"), player, null);
            case 5 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.IceVignette1"), player, null);
            default -> "";
        };
    }

    @Nonnull
    public String getFireVignette(@Nullable Player player, int temperature) {
        return switch (temperature) {
            case 20 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.FireVignette1"), player, null);
            case 21 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.FireVignette2"), player, null);
            case 22 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.FireVignette3"), player, null);
            case 23 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.FireVignette4"), player, null);
            case 24 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.FireVignette5"), player, null);
            case 25 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.BurningView"), player, null);
            default -> "";
        };
    }

    @Nonnull
    public String getThirstVignette(@Nullable Player player, int thirst) {
        return switch (thirst) {
            case 0 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.DehydratedView"), player, null);
            case 1 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.ThirstVignette5"), player, null);
            case 2 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.ThirstVignette4"), player, null);
            case 3 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.ThirstVignette3"), player, null);
            case 4 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.ThirstVignette2"), player, null);
            case 5 -> Utils.translateMsg(tanConfig.getString("CharacterOverrides.ThirstVignette1"), player, null);
            default -> "";
        };
    }

    @Nonnull
    public String getTemperature(@Nullable Player player, int i) {
        if (i < 0 || i > 25) {
            return "";
        }
        return Utils.translateMsg(tanConfig.getString("CharacterOverrides.Temperature" + i), player, null);
    }

    @Nonnull
    public String getSirenView(@Nullable Player player) {
        return Utils.translateMsg(ifConfig.getString("Siren.ChangeScreen.Character"), player, null);
    }
}
