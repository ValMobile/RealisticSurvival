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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;

public enum SeaSerpentVariant {

    BLUE("SeaSerpents.Enabled.Variants.Blue"),
    BRONZE("SeaSerpents.Enabled.Variants.Bronze"),
    DEEPBLUE("SeaSerpents.Enabled.Variants.DeepBlue"),
    GREEN("SeaSerpents.Enabled.Variants.Green"),
    PURPLE("SeaSerpents.Enabled.Variants.Purple"),
    RED("SeaSerpents.Enabled.Variants.Red"),
    TEAL("SeaSerpents.Enabled.Variants.Teal");

    private final boolean enabled;

    SeaSerpentVariant(String configPath) {
        this.enabled = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig().getBoolean(configPath);
    }

    public boolean isEnabled() {
        return enabled;
    }
}
