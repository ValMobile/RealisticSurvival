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

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionBaubleEffect extends PotionEffect {

    private final int increment;

    public PotionBaubleEffect(PotionEffectType type, int duration, int amplifier, int increment) {
        super(type, duration, amplifier);
        this.increment = increment;
    }

    public PotionBaubleEffect(PotionEffectType type, int duration, int amplifier, boolean ambient, int increment) {
        super(type, duration, amplifier, ambient);
        this.increment = increment;
    }

    public PotionBaubleEffect(PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles, int increment) {
        super(type, duration, amplifier, ambient, particles);
        this.increment = increment;
    }

    public PotionBaubleEffect(PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles, boolean icon, int increment) {
        super(type, duration, amplifier, ambient, particles, icon);
        this.increment = increment;
    }

    public int getIncrement() {
        return increment;
    }
}
