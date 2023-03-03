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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;

import java.util.ArrayList;
import java.util.List;

public enum DragonVariant {

    GRAY("Dragons.FireDragon.Enabled.Variants.Blue"),
    EMERALD("Dragons.FireDragon.Enabled.Variants.Emerald"),
    RED("Dragons.FireDragon.Enabled.Variants.Red"),
    BRONZE("Dragons.FireDragon.Enabled.Variants.Bronze"),
    SAPPHIRE("Dragons.IceDragon.Enabled.Variants.Sapphire"),
    BLUE("Dragons.IceDragon.Enabled.Variants.Blue"),
    SILVER("Dragons.IceDragon.Enabled.Variants.Silver"),
    WHITE("Dragons.IceDragon.Enabled.Variants.White"),
    AMETHYST("Dragons.LightningDragon.Enabled.Variants.Amethyst"),
    BLACK("Dragons.LightningDragon.Enabled.Variants.Black"),
    ELECTRIC_BLUE("Dragons.LightningDragon.Enabled.Variants.ElectricBlue"),
    COPPER("Dragons.LightningDragon.Enabled.Variants.Copper");

    private final boolean enabled;

    DragonVariant(String configPath) {
        enabled = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig().getBoolean(configPath);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static List<DragonVariant> getEnabledVariants(DragonBreed breed) {
        DragonVariant[] variants = breed.getVariants();
        List<DragonVariant> valid = new ArrayList<>();
        for (DragonVariant variant : variants) {
            if (variant.isEnabled()) {
                valid.add(variant);
            }
        }
        return valid;
    }
}
