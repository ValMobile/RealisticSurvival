package me.val_mobile.integrations;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;

import javax.annotation.Nonnull;

public abstract class ProtectionPlugin extends CompatiblePlugin {

    public ProtectionPlugin(@Nonnull RealisticSurvivalPlugin plugin, @Nonnull String name) {
        super(plugin, name);
    }

    public abstract boolean isPvpAllowed(@Nonnull Location loc);
}
