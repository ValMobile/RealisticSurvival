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
package me.val_mobile.utils;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.tan.TanModule;
import org.bukkit.configuration.file.FileConfiguration;

public class CharacterValues {


    private final char TEMPERATURE0;
    private final char TEMPERATURE1;
    private final char TEMPERATURE2;
    private final char TEMPERATURE3;
    private final char TEMPERATURE4;
    private final char TEMPERATURE5;
    private final char TEMPERATURE6;
    private final char TEMPERATURE7;
    private final char TEMPERATURE8;
    private final char TEMPERATURE9;
    private final char TEMPERATURE10;
    private final char TEMPERATURE11;
    private final char TEMPERATURE12;
    private final char TEMPERATURE13;
    private final char TEMPERATURE14;
    private final char TEMPERATURE15;
    private final char TEMPERATURE16;
    private final char TEMPERATURE17;
    private final char TEMPERATURE18;
    private final char TEMPERATURE19;
    private final char TEMPERATURE20;
    private final char TEMPERATURE21;
    private final char TEMPERATURE22;
    private final char TEMPERATURE23;
    private final char TEMPERATURE24;
    private final char TEMPERATURE25;
    private final char PARASITES_ABOVE_WATER_FULL_THIRST_DROP;
    private final char PARASITES_ABOVE_WATER_HALF_THIRST_DROP;
    private final char PARASITES_UNDERWATER_FULL_THIRST_DROP;
    private final char PARASITES_UNDERWATER_HALF_THIRST_DROP;
    private final char ABOVE_WATER_FULL_THIRST_DROP;
    private final char ABOVE_WATER_HALF_THIRST_DROP;
    private final char ABOVE_WATER_EMPTY_THIRST_DROP;
    private final char UNDERWATER_FULL_THIRST_DROP;
    private final char UNDERWATER_HALF_THIRST_DROP;
    private final char UNDERWATER_EMPTY_THIRST_DROP;
    private final char FREEZING_VIEW;
    private final char ICE_VIGNETTE1;
    private final char ICE_VIGNETTE2;
    private final char ICE_VIGNETTE3;
    private final char ICE_VIGNETTE4;
    private final char ICE_VIGNETTE5;
    private final char FIRE_VIGNETTE1;
    private final char FIRE_VIGNETTE2;
    private final char FIRE_VIGNETTE3;
    private final char FIRE_VIGNETTE4;
    private final char FIRE_VIGNETTE5;
    private final char BURNING_VIEW;
    private final char DEHYDRATED_VIEW;
    private final char THIRST_VIGNETTE1;
    private final char THIRST_VIGNETTE2;
    private final char THIRST_VIGNETTE3;
    private final char THIRST_VIGNETTE4;
    private final char THIRST_VIGNETTE5;
    private final char SIREN_VIEW;

    private final FileConfiguration config;

    public CharacterValues() {
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        
        TEMPERATURE0 = config.getString("CharacterOverrides.Temperature0").toCharArray()[0];
        TEMPERATURE1 = config.getString("CharacterOverrides.Temperature1").toCharArray()[0];
        TEMPERATURE2 = config.getString("CharacterOverrides.Temperature2").toCharArray()[0];
        TEMPERATURE3 = config.getString("CharacterOverrides.Temperature3").toCharArray()[0];
        TEMPERATURE4 = config.getString("CharacterOverrides.Temperature4").toCharArray()[0];
        TEMPERATURE5 = config.getString("CharacterOverrides.Temperature5").toCharArray()[0];
        TEMPERATURE6 = config.getString("CharacterOverrides.Temperature6").toCharArray()[0];
        TEMPERATURE7 = config.getString("CharacterOverrides.Temperature7").toCharArray()[0];
        TEMPERATURE8 = config.getString("CharacterOverrides.Temperature8").toCharArray()[0];
        TEMPERATURE9 = config.getString("CharacterOverrides.Temperature9").toCharArray()[0];
        TEMPERATURE10 = config.getString("CharacterOverrides.Temperature10").toCharArray()[0];
        TEMPERATURE11 = config.getString("CharacterOverrides.Temperature11").toCharArray()[0];
        TEMPERATURE12 = config.getString("CharacterOverrides.Temperature12").toCharArray()[0];
        TEMPERATURE13 = config.getString("CharacterOverrides.Temperature13").toCharArray()[0];
        TEMPERATURE14 = config.getString("CharacterOverrides.Temperature14").toCharArray()[0];
        TEMPERATURE15 = config.getString("CharacterOverrides.Temperature15").toCharArray()[0];
        TEMPERATURE16 = config.getString("CharacterOverrides.Temperature16").toCharArray()[0];
        TEMPERATURE17 = config.getString("CharacterOverrides.Temperature17").toCharArray()[0];
        TEMPERATURE18 = config.getString("CharacterOverrides.Temperature18").toCharArray()[0];
        TEMPERATURE19 = config.getString("CharacterOverrides.Temperature19").toCharArray()[0];
        TEMPERATURE20 = config.getString("CharacterOverrides.Temperature20").toCharArray()[0];
        TEMPERATURE21 = config.getString("CharacterOverrides.Temperature21").toCharArray()[0];
        TEMPERATURE22 = config.getString("CharacterOverrides.Temperature22").toCharArray()[0];
        TEMPERATURE23 = config.getString("CharacterOverrides.Temperature23").toCharArray()[0];
        TEMPERATURE24 = config.getString("CharacterOverrides.Temperature24").toCharArray()[0];
        TEMPERATURE25 = config.getString("CharacterOverrides.Temperature25").toCharArray()[0];
        ABOVE_WATER_FULL_THIRST_DROP = config.getString("CharacterOverrides.AboveWaterFullThirstDrop").toCharArray()[0];
        ABOVE_WATER_HALF_THIRST_DROP = config.getString("CharacterOverrides.AboveWaterHalfThirstDrop").toCharArray()[0];
        ABOVE_WATER_EMPTY_THIRST_DROP = config.getString("CharacterOverrides.AboveWaterEmptyThirstDrop").toCharArray()[0];
        UNDERWATER_FULL_THIRST_DROP = config.getString("CharacterOverrides.UnderwaterFullThirstDrop").toCharArray()[0];
        UNDERWATER_HALF_THIRST_DROP = config.getString("CharacterOverrides.UnderwaterHalfThirstDrop").toCharArray()[0];
        UNDERWATER_EMPTY_THIRST_DROP = config.getString("CharacterOverrides.UnderwaterEmptyThirstDrop").toCharArray()[0];
        PARASITES_ABOVE_WATER_FULL_THIRST_DROP = config.getString("CharacterOverrides.ParasitesAboveWaterFullThirstDrop").toCharArray()[0];
        PARASITES_ABOVE_WATER_HALF_THIRST_DROP = config.getString("CharacterOverrides.ParasitesAboveWaterHalfThirstDrop").toCharArray()[0];
        PARASITES_UNDERWATER_FULL_THIRST_DROP = config.getString("CharacterOverrides.ParasitesUnderwaterFullThirstDrop").toCharArray()[0];
        PARASITES_UNDERWATER_HALF_THIRST_DROP = config.getString("CharacterOverrides.ParasitesUnderwaterHalfThirstDrop").toCharArray()[0];
        FREEZING_VIEW = config.getString("CharacterOverrides.FreezingView").toCharArray()[0];
        ICE_VIGNETTE1 = config.getString("CharacterOverrides.IceVignette1").toCharArray()[0];
        ICE_VIGNETTE2 = config.getString("CharacterOverrides.IceVignette2").toCharArray()[0];
        ICE_VIGNETTE3 = config.getString("CharacterOverrides.IceVignette3").toCharArray()[0];
        ICE_VIGNETTE4 = config.getString("CharacterOverrides.IceVignette4").toCharArray()[0];
        ICE_VIGNETTE5 = config.getString("CharacterOverrides.IceVignette5").toCharArray()[0];
        FIRE_VIGNETTE1 = config.getString("CharacterOverrides.FireVignette1").toCharArray()[0];
        FIRE_VIGNETTE2 = config.getString("CharacterOverrides.FireVignette2").toCharArray()[0];
        FIRE_VIGNETTE3 = config.getString("CharacterOverrides.FireVignette3").toCharArray()[0];
        FIRE_VIGNETTE4 = config.getString("CharacterOverrides.FireVignette4").toCharArray()[0];
        FIRE_VIGNETTE5 = config.getString("CharacterOverrides.FireVignette5").toCharArray()[0];
        BURNING_VIEW = config.getString("CharacterOverrides.BurningView").toCharArray()[0];
        DEHYDRATED_VIEW = config.getString("CharacterOverrides.DehydratedView").toCharArray()[0];
        THIRST_VIGNETTE1 = config.getString("CharacterOverrides.ThirstVignette1").toCharArray()[0];
        THIRST_VIGNETTE2 = config.getString("CharacterOverrides.ThirstVignette2").toCharArray()[0];
        THIRST_VIGNETTE3 = config.getString("CharacterOverrides.ThirstVignette3").toCharArray()[0];
        THIRST_VIGNETTE4 = config.getString("CharacterOverrides.ThirstVignette4").toCharArray()[0];
        THIRST_VIGNETTE5 = config.getString("CharacterOverrides.ThirstVignette5").toCharArray()[0];
        SIREN_VIEW = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig().getString("Sirens.ChangeScreen.Character").toCharArray()[0];
    }

    public String getTemperatureOnlyActionbar(int temperature) {
        String s = config.getString("CharacterOverrides.TemperatureActionbar");
        s = s.replaceAll("%TEMP%", String.valueOf(getTemperature(temperature)));
        return s;
    }

    public String getThirstOnlyActionbar(int thirst, boolean isUnderwater, boolean parasitesActive) {
        String s = config.getString("CharacterOverrides.ThirstActionbar");
        s = s.replaceAll("%THIRST%", String.valueOf(getThirst(thirst, isUnderwater, parasitesActive)));
        return s;
    }

    public String getTemperatureThirstActionbar(int temperature, int thirst, boolean isUnderwater, boolean parasitesActive) {
        String s = config.getString("CharacterOverrides.TemperatureThirstActionbar");
        s = s.replaceAll("%TEMP%", String.valueOf(getTemperature(temperature)));
        s = s.replaceAll("%THIRST%", String.valueOf(getThirst(thirst, isUnderwater, parasitesActive)));
        return s;
    }
    
    public String getThirst(int thirst, boolean isUnderwater, boolean parasitesActive) {

        final char EMPTY_THIRST_DROP = isUnderwater ? UNDERWATER_EMPTY_THIRST_DROP : ABOVE_WATER_EMPTY_THIRST_DROP;
        final char HALF_THIRST_DROP;
        final char FULL_THIRST_DROP;
        if (parasitesActive) {
            HALF_THIRST_DROP = isUnderwater ? PARASITES_UNDERWATER_HALF_THIRST_DROP : PARASITES_ABOVE_WATER_HALF_THIRST_DROP;
            FULL_THIRST_DROP =  isUnderwater ? PARASITES_UNDERWATER_FULL_THIRST_DROP: PARASITES_ABOVE_WATER_FULL_THIRST_DROP;
        }
        else {
            HALF_THIRST_DROP = isUnderwater ? UNDERWATER_HALF_THIRST_DROP : ABOVE_WATER_HALF_THIRST_DROP;
            FULL_THIRST_DROP =  isUnderwater ? UNDERWATER_FULL_THIRST_DROP : ABOVE_WATER_FULL_THIRST_DROP;
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

        s.append(String.valueOf(FULL_THIRST_DROP).repeat((20 - numHalf - numEmpty * 2) / 2));

        if (numHalf == 1) {
            s.insert(0, HALF_THIRST_DROP);
        }

        for (int i = 0; i < numEmpty; i++) {
            s.insert(0, EMPTY_THIRST_DROP);
        }

        return s.toString();
    }

    public char getBurningView() {
        return BURNING_VIEW;
    }

    public char getFreezingView() {
        return FREEZING_VIEW;
    }

    public char getThirstDrop(int i) {
        switch (i) {
            case 0 -> {
                return ABOVE_WATER_EMPTY_THIRST_DROP;
            }
            case 1 -> {
                return ABOVE_WATER_HALF_THIRST_DROP;
            }
            case 2 -> {
                return ABOVE_WATER_FULL_THIRST_DROP;
            }
            default -> {
                if (i < 0) {
                    return ABOVE_WATER_EMPTY_THIRST_DROP;
                }
                return ABOVE_WATER_FULL_THIRST_DROP;
            }
        }
    }

    public char getIceVignette(int temperature) {
        switch (temperature) {
            case 0 -> {
                return FREEZING_VIEW;
            }
            case 1 -> {
                return ICE_VIGNETTE5;
            }
            case 2 -> {
                return ICE_VIGNETTE4;
            }
            case 3 -> {
                return ICE_VIGNETTE3;
            }
            case 4 -> {
                return ICE_VIGNETTE2;
            }
            case 5 -> {
                return ICE_VIGNETTE1;
            }
            default -> {
                if (temperature < 0) {
                    return FREEZING_VIEW;
                }
                return ' ';
            }
        }
    }

    public char getFireVignette(int temperature) {
        switch (temperature) {
            case 20 -> {
                return FIRE_VIGNETTE1;
            }
            case 21 -> {
                return FIRE_VIGNETTE2;
            }
            case 22 -> {
                return FIRE_VIGNETTE3;
            }
            case 23 -> {
                return FIRE_VIGNETTE4;
            }
            case 24 -> {
                return FIRE_VIGNETTE5;
            }
            case 25 -> {
                return BURNING_VIEW;
            }
            default -> {
                if (temperature > 25) {
                    return BURNING_VIEW;
                }
                return ' ';
            }
        }
    }

    public char getThirstVignette(int thirst) {
        switch (thirst) {
            case 0 -> {
                return DEHYDRATED_VIEW;
            }
            case 1 -> {
                return THIRST_VIGNETTE5;
            }
            case 2 -> {
                return THIRST_VIGNETTE4;
            }
            case 3 -> {
                return THIRST_VIGNETTE3;
            }
            case 4 -> {
                return THIRST_VIGNETTE2;
            }
            case 25 -> {
                return THIRST_VIGNETTE1;
            }
            default -> {
                if (thirst < 0) {
                    return DEHYDRATED_VIEW;
                }
                return ' ';
            }
        }
    }
    
    public char getTemperature(int i) {
        switch (i) {
            case 0 -> {
                return TEMPERATURE0;
            }
            case 1 -> {
                return TEMPERATURE1;
            }
            case 2 -> {
                return TEMPERATURE2;
            }
            case 3 -> {
                return TEMPERATURE3;
            }
            case 4 -> {
                return TEMPERATURE4;
            }
            case 5 -> {
                return TEMPERATURE5;
            }
            case 6 -> {
                return TEMPERATURE6;
            }
            case 7 -> {
                return TEMPERATURE7;
            }
            case 8 -> {
                return TEMPERATURE8;
            }
            case 9 -> {
                return TEMPERATURE9;
            }
            case 10 -> {
                return TEMPERATURE10;
            }
            case 11 -> {
                return TEMPERATURE11;
            }
            case 12 -> {
                return TEMPERATURE12;
            }
            case 13 -> {
                return TEMPERATURE13;
            }
            case 14 -> {
                return TEMPERATURE14;
            }
            case 15 -> {
                return TEMPERATURE15;
            }
            case 16 -> {
                return TEMPERATURE16;
            }
            case 17 -> {
                return TEMPERATURE17;
            }
            case 18 -> {
                return TEMPERATURE18;
            }
            case 19 -> {
                return TEMPERATURE19;
            }
            case 20 -> {
                return TEMPERATURE20;
            }
            case 21 -> {
                return TEMPERATURE21;
            }
            case 22 -> {
                return TEMPERATURE22;
            }
            case 23 -> {
                return TEMPERATURE23;
            }
            case 24 -> {
                return TEMPERATURE24;
            }
            case 25 -> {
                return TEMPERATURE25;
            }
            default -> {
                if (i < 0) {
                    return TEMPERATURE0;
                }
                return TEMPERATURE25;
            }
        }
    }

    public char getSirenView() {
        return SIREN_VIEW;
    }
}
