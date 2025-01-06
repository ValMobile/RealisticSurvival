/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;

import java.util.ArrayList;
import java.util.List;

public enum SeaSerpentVariant {

    BLUE("SeaSerpent.Enabled.Variants.Blue"),
    BRONZE("SeaSerpent.Enabled.Variants.Bronze"),
    DEEPBLUE("SeaSerpent.Enabled.Variants.DeepBlue"),
    GREEN("SeaSerpent.Enabled.Variants.Green"),
    PURPLE("SeaSerpent.Enabled.Variants.Purple"),
    RED("SeaSerpent.Enabled.Variants.Red"),
    TEAL("SeaSerpent.Enabled.Variants.Teal");

    private final boolean enabled;

    SeaSerpentVariant(String configPath) {
        this.enabled = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig().getBoolean(configPath);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static List<SeaSerpentVariant> getEnabledVariants() {
        SeaSerpentVariant[] variants = values();
        List<SeaSerpentVariant> valid = new ArrayList<>();
        for (SeaSerpentVariant variant : variants) {
            if (variant.isEnabled()) {
                valid.add(variant);
            }
        }
        return valid;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
