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

import org.bukkit.potion.PotionEffectType;

public enum PotionEffectTypeList {

    ABSORPTION(PotionEffectType.ABSORPTION),
    BAD_OMEN(PotionEffectType.BAD_OMEN),
    BLINDNESS(PotionEffectType.BLINDNESS),
    CONDUIT(PotionEffectType.CONDUIT_POWER),
    CONFUSION(PotionEffectType.CONFUSION),
    DAMAGE_RESISTANCE(PotionEffectType.DAMAGE_RESISTANCE),
    DARKNESS(PotionEffectType.DARKNESS),
    DOLPHINS_GRACE(PotionEffectType.DOLPHINS_GRACE),
    FAST_DIGGING(PotionEffectType.FAST_DIGGING),
    FIRE_RESISTANCE(PotionEffectType.FIRE_RESISTANCE),
    GLOWING(PotionEffectType.GLOWING),
    HARM(PotionEffectType.HARM),
    HEAL(PotionEffectType.HEAL),
    HEALTH_BOOST(PotionEffectType.HEALTH_BOOST),
    HERO_OF_THE_VILLAGE(PotionEffectType.HERO_OF_THE_VILLAGE),
    HUNGER(PotionEffectType.HUNGER),
    INCREASE_DAMAGE(PotionEffectType.INCREASE_DAMAGE),
    INVISIBILITY(PotionEffectType.INVISIBILITY),
    JUMP(PotionEffectType.JUMP),
    LEVITATION(PotionEffectType.LEVITATION),
    LUCK(PotionEffectType.LUCK),
    NIGHT_VISION(PotionEffectType.NIGHT_VISION),
    POISON(PotionEffectType.POISON),
    REGENERATION(PotionEffectType.REGENERATION),
    SATURATION(PotionEffectType.SATURATION),
    SLOW(PotionEffectType.SLOW),
    SLOW_DIGGING(PotionEffectType.SLOW_DIGGING),
    SPEED(PotionEffectType.SPEED),
    UNLUCK(PotionEffectType.UNLUCK),
    WATER_BREATHING(PotionEffectType.WATER_BREATHING),
    WEAKNESS(PotionEffectType.WEAKNESS),
    WITHER(PotionEffectType.WITHER);
    private final PotionEffectType type;

    PotionEffectTypeList(PotionEffectType type) {
        this.type = type;
    }

    public PotionEffectType getType() {
        return type;
    }
}
