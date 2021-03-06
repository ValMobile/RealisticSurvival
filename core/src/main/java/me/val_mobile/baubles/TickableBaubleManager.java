package me.val_mobile.baubles;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public enum TickableBaubleManager {

    POTION_RING_RESISTANCE(new PotionBauble("potion_ring_resistance")),
    POTION_RING_STRENGTH(new PotionBauble("potion_ring_strength")),
    POTION_RING_REGENERATION(new PotionBauble("potion_ring_regeneration")),
    POTION_RING_SPEED(new PotionBauble("potion_ring_speed")),
    POTION_RING_HASTE(new PotionBauble("potion_ring_haste")),
    POTION_RING_JUMP_BOOST(new PotionBauble("potion_ring_jump_boost")),
    DRAGONS_EYE(new PotionBauble("potion_ring_dragons_eye")),
    SHIELD_HONOR(new PotionBauble("shield_honor")),
    PHANTOM_PRISM(new PotionBauble("phantom_prism")),
    MINERS_RING(new PotionBauble("miners_ring")),
    STONE_SEA(new PotionBauble("stone_sea")),
    SCARLITE_RING(new TickableBauble("scarlite_ring")),
    POLARIZED_STONE(new TickableBauble("polarized_stone")),
    ENDER_QUEENS_CROWN(new TickableBauble("ender_queens_crown"));

    private static HashMap<UUID, Collection> baubles = new HashMap<>();
    private Tickable bauble;

    TickableBaubleManager(Tickable bauble) {
        this.bauble = bauble;
    }

    public String getName() {
        return bauble.getName();
    }

    public Tickable getBauble() {
        return bauble;
    }

    public static HashMap<UUID, Collection> getBaubles() {
        return baubles;
    }
}
