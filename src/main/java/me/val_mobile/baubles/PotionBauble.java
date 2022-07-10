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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVFiles;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.potion.PotionEffectType;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public enum PotionBauble {

    POTION_RING_RESISTANCE("potion_ring_resistance"),
    POTION_RING_STRENGTH("potion_ring_strength"),
    POTION_RING_REGENERATION("potion_ring_regeneration"),
    POTION_RING_SPEED("potion_ring_speed"),
    POTION_RING_HASTE("potion_ring_haste"),
    POTION_RING_JUMP_BOOST("potion_ring_jump_boost"),
    DRAGONS_EYE("dragons_eye"),
    SHIELD_HONOR("shield_honor"),
    PHANTOM_PRISM("phantom_prism"),
    MINERS_RING("miners_ring"),
    STONE_SEA("stone_sea");

    private String name;
    private Collection<RSVPotionEffect> effects = new ArrayList<>();

    PotionBauble(String name) {
        this.name = name;

        FileConfiguration config = RSVFiles.getBaubleUserConfig();
        ConfigurationSection section = config.getConfigurationSection("Items." + name + ".Effects");
        Set<String> keys = section.getKeys(false);

        int dur;
        int amp;
        int ampInc;

        for (String key : keys) {
            dur = section.getInt(key + ".Duration");
            amp = section.getInt(key + ".Amplifier");
            ampInc = section.getInt(key + ".AmplifierIncrement");

            effects.add(new RSVPotionEffect(PotionEffectType.getByName(key), dur, amp, ampInc));
        }
    }

    public String getName() {
        return name;
    }

    public Collection<RSVPotionEffect> getEffects() {
        return effects;
    }
}
