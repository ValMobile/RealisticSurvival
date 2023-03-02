package me.val_mobile.integrations;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;

import javax.annotation.Nonnull;

public class PAPI extends CompatiblePlugin {

    public static final String NAME = "PlaceholderAPI";

    public PAPI(@Nonnull RealisticSurvivalPlugin plugin) {
        super(plugin, NAME);

        if (isIntegrated) {
            new TemperatureThirstBarExpansion().register();
            new TemperatureBarExpansion().register();
            new TemperatureNumericExpansion().register();
            new TemperatureVignetteExpansion().register();
            new ThirstBarExpansion().register();
            new ThirstNumericExpansion().register();
            new ThirstVignetteExpansion().register();
        }
    }

    @Override
    public boolean otherLoadOptions() {
        return true;
    }
}
