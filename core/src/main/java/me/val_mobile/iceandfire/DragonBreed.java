package me.val_mobile.iceandfire;

import static me.val_mobile.iceandfire.DragonBreed.Variant.*;

public enum DragonBreed {

    FIRE(GRAY, EMERALD, RED, BRONZE),
    ICE(SAPPHIRE, BLUE, SILVER, WHITE),
    LIGHTNING(AMETHYST, BLACK, ELECTRIC_BLUE, COPPER);

    private final Variant[] variants;

    DragonBreed(Variant... variants) {
        this.variants = variants;
    }

    public Variant[] getVariants() {
        return variants;
    }

    public enum Variant {
        GRAY, EMERALD, RED, BRONZE, SAPPHIRE, BLUE, SILVER, WHITE, AMETHYST, BLACK, ELECTRIC_BLUE, COPPER
    }
}
