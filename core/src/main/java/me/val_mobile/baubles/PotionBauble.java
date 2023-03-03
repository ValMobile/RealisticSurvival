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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVModule;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class PotionBauble extends TickableBauble {

    private final Collection<PotionBaubleEffect> effects = new ArrayList<>();

    public PotionBauble(String name) {
        super(name);

        FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();
        ConfigurationSection section = config.getConfigurationSection("Items." + name + ".Effects");

        if (section != null) {
            Set<String> keys = section.getKeys(false);

            int dur;
            int amp;
            int ampInc;

            for (String key : keys) {
                dur = section.getInt(key + ".Duration");
                amp = section.getInt(key + ".Amplifier");
                ampInc = section.getInt(key + ".AmplifierIncrement");

                effects.add(new PotionBaubleEffect(PotionEffectType.getByName(key), dur, amp, ampInc));
            }
        }
    }

    public void ability(Player player, int amount) {
        for (PotionBaubleEffect effect : effects) {
            int baseAmp = effect.getAmplifier();
            int inc = effect.getIncrement();
            int amp = baseAmp + (amount - 1) * inc;

            player.addPotionEffect(new PotionEffect(effect.getType(), effect.getDuration(), amp));
        }
    }


    public Collection<PotionBaubleEffect> getEffects() {
        return effects;
    }
}
