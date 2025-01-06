/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.tan;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.ModuleRecipes;
import me.val_mobile.data.RSVConfig;
import me.val_mobile.data.RSVModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TanModule extends RSVModule {

    private final RSVPlugin plugin;

    private final RSVConfig config;
    private TanEvents events;

    public static final String NAME = "ToughAsNails";
    private final Set<UUID> hypothermiaDeath = new HashSet<>();
    private final Set<UUID> hyperthermiaDeath = new HashSet<>();
    private final Set<UUID> dehydrationDeath = new HashSet<>();
    private final Set<UUID> parasiteDeath = new HashSet<>();
    private final TempManager tempManager;
    private ThirstManager thirstManager;
    private boolean tempGloballyEnabled;
    private boolean thirstGloballyEnabled;

    public TanModule(RSVPlugin plugin) {
        super(NAME, plugin, Map.of(), Map.of());
        this.plugin = plugin;
        this.config = new RSVConfig(plugin, "resources/toughasnails/playerdata.yml");
        this.tempManager = new TempManager(this);
    }

    @Override
    public void initialize() {
        setUserConfig(new RSVConfig(plugin, "toughasnails.yml"));
        setItemConfig(new RSVConfig(plugin, "resources/toughasnails/items.yml"));
        setRecipeConfig(new RSVConfig(plugin, "resources/toughasnails/recipes.yml"));
        this.thirstManager = new ThirstManager(this);

        setModuleItems(new ModuleItems(this));
        setModuleRecipes(new ModuleRecipes(this, plugin));

        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Initialize.Enabled")) {
            String message = Utils.translateMsg(config.getString("Initialize.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }

        this.tempGloballyEnabled = config.getBoolean("Temperature.Enabled") && isGloballyEnabled();
        this.thirstGloballyEnabled = config.getBoolean("Thirst.Enabled") && isGloballyEnabled();

        events = new TanEvents(this, plugin);

        getModuleItems().initialize();
        getModuleRecipes().initialize();
        events.initialize();
    }

    @Override
    public void shutdown() {
        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Shutdown.Enabled")) {
            String message = Utils.translateMsg(config.getString("Shutdown.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }
    }

    @Nonnull
    public TempManager getTempManager() {
        return tempManager;
    }

    @Nonnull
    public ThirstManager getThirstManager() {
        return thirstManager;
    }

    @Nonnull
    public RSVConfig getPlayerDataConfig() {
        return config;
    }

    @Nonnull
    public TanEvents getEvents() {
        return events;
    }

    @Nonnull
    public Set<UUID> getDehydrationDeath() {
        return dehydrationDeath;
    }

    @Nonnull
    public Set<UUID> getHyperthermiaDeath() {
        return hyperthermiaDeath;
    }

    @Nonnull

    public Set<UUID> getHypothermiaDeath() {
        return hypothermiaDeath;
    }

    @Nonnull
    public Set<UUID> getParasiteDeath() {
        return parasiteDeath;
    }

    public boolean isTempGloballyEnabled() {
        return tempGloballyEnabled;
    }

    public boolean isThirstGloballyEnabled() {
        return thirstGloballyEnabled;
    }
}
