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
            String message = Utils.translateMsg(plugin.getConfig().getString("Integration"), null, Map.of("PLUGIN", name));

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
