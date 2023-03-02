package me.val_mobile.integrations;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public abstract class CompatiblePlugin {

    private static final Map<String, CompatiblePlugin> plugins = new HashMap<>();
    protected final FileConfiguration intConfig;
    protected final String name;
    protected final boolean isIntegrated;

    public CompatiblePlugin(@Nonnull RealisticSurvivalPlugin plugin, @Nonnull String name) {
        this.name = name;
        this.intConfig = plugin.getIntegrationsConfig();

        this.isIntegrated = intConfig.getBoolean(name + ".Enabled") && Bukkit.getServer().getPluginManager().isPluginEnabled(name) && otherLoadOptions();

        if (isIntegrated && intConfig.getBoolean("EnableIntegrationMessage")) {
            String message = Utils.translateMsg(plugin.getConfig().getString("Integration"));
            message = message.replaceAll("%PLUGIN%", name);

            plugin.getLogger().info(message);
        }

        plugins.put(name, this);
    }

    @Nonnull
    public final String getName() {
        return name;
    }

    public final boolean isIntegrated() {
        return isIntegrated;
    }

    public abstract boolean otherLoadOptions();

    @Nullable
    public static CompatiblePlugin getPlugin(@Nonnull String name) {
        return plugins.getOrDefault(name, null);
    }

    public static boolean isIntegrated(@Nonnull String name) {
        if (plugins.containsKey(name)) {
            return plugins.get(name) != null && plugins.get(name).isIntegrated();
        }
        return false;
    }
}
