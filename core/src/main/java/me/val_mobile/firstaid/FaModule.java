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
package me.val_mobile.firstaid;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.ModuleRecipes;
import me.val_mobile.data.RSVConfig;
import me.val_mobile.data.RSVModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Map;

public class FaModule extends RSVModule {

    private final RSVPlugin plugin;
    public static final String NAME = "FirstAid";
    private final RSVConfig config;

    private FaEvents events;

    public FaModule(RSVPlugin plugin) {
        super(NAME, plugin, Map.of(), Map.of());
        this.plugin = plugin;
        this.config = new RSVConfig(plugin, "resources/firstaid/playerdata.yml");
    }

    @Override
    public void initialize() {
        setUserConfig(new RSVConfig(plugin, "firstaid.yml"));
        setItemConfig(new RSVConfig(plugin, "resources/firstaid/items.yml"));
        setRecipeConfig(new RSVConfig(plugin, "resources/firstaid/recipes.yml"));

        setModuleItems(new ModuleItems(this));
        setModuleRecipes(new ModuleRecipes(this, plugin));

        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Initialize.Enabled")) {
            String message = Utils.translateMsg(config.getString("Initialize.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }

        events = new FaEvents(this, plugin);

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

    public FaEvents getEvents() {
        return events;
    }

    public RSVConfig getPlayerDataConfig() {
        return config;
    }

}
