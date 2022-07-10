package me.val_mobile.baubles;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;

public enum PotionBaubleManager {

    POTION_RING_RESISTANCE(PotionBauble.POTION_RING_RESISTANCE),
    POTION_RING_STRENGTH(PotionBauble.POTION_RING_STRENGTH),
    POTION_RING_REGENERATION(PotionBauble.POTION_RING_REGENERATION),
    POTION_RING_SPEED(PotionBauble.POTION_RING_SPEED),
    POTION_RING_HASTE(PotionBauble.POTION_RING_HASTE),
    POTION_RING_JUMP_BOOST(PotionBauble.POTION_RING_JUMP_BOOST),
    DRAGONS_EYE(PotionBauble.DRAGONS_EYE),
    SHIELD_HONOR(PotionBauble.SHIELD_HONOR),
    PHANTOM_PRISM(PotionBauble.PHANTOM_PRISM),
    MINERS_RING(PotionBauble.MINERS_RING),
    STONE_SEA(PotionBauble.STONE_SEA);

    private PotionBauble potionBauble;
    private String name;

    PotionBaubleManager(PotionBauble potionBauble) {
        this.potionBauble = potionBauble;
        this.name = potionBauble.getName();
    }

    public String getName() {
        return name;
    }

    public PotionBauble getPotionBauble() {
        return potionBauble;
    }
}
