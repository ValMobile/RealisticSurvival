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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum TickableBaubleManager {

    POTION_RING_RESISTANCE(new PotionBauble("potion_ring_resistance")),
    POTION_RING_STRENGTH(new PotionBauble("potion_ring_strength")),
    POTION_RING_REGENERATION(new PotionBauble("potion_ring_regeneration")),
    POTION_RING_SPEED(new PotionBauble("potion_ring_speed")),
    POTION_RING_HASTE(new PotionBauble("potion_ring_haste")),
    POTION_RING_JUMP_BOOST(new PotionBauble("potion_ring_jump_boost")),
    DRAGONS_EYE(new PotionBauble("dragons_eye")),
    SHIELD_HONOR(new PotionBauble("shield_honor")),
    PHANTOM_PRISM(new PotionBauble("phantom_prism")),
    MINERS_RING(new PotionBauble("miners_ring")),
    STONE_SEA(new PotionBauble("stone_sea")),
    SCARLITE_RING(new TickableBauble("scarlite_ring")),
    POLARIZED_STONE(new TickableBauble("polarized_stone")),
    ENDER_QUEENS_CROWN(new TickableBauble("ender_queens_crown")),
    STONE_NEGATIVE_GRAVITY(new TickableBauble("stone_negative_gravity")),
    STONE_GREATER_INERTIA(new TickableBauble("stone_greater_inertia")),
    GLUTTONY_PENDANT(new PotionBauble("gluttony_pendant")),
    WRATH_PENDANT(new PotionBauble("wrath_pendant")),
    PRIDE_PENDANT(new PotionBauble("pride_pendant"));

    private static final Map<UUID, Collection<TickableBauble>> baubles = new HashMap<>();
    private final TickableBauble bauble;

    TickableBaubleManager(TickableBauble bauble) {
        this.bauble = bauble;
    }

    public String getName() {
        return bauble.getName();
    }

    public Tickable getBauble() {
        return bauble;
    }

    public static Map<UUID, Collection<TickableBauble>> getBaubles() {
        return baubles;
    }

    public static boolean hasTask(UUID id) {
        if (baubles.containsKey(id)) {
            return baubles.get(id) != null;
        }
        return false;
    }
}
