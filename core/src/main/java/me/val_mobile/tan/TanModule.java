/*
    Copyright (C) 2022  Val_Mobile

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
import me.val_mobile.data.RSVModule;
import me.val_mobile.data.toughasnails.ItemConfig;
import me.val_mobile.data.toughasnails.RecipesConfig;
import me.val_mobile.data.toughasnails.UserConfig;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.SfEvents;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class TanModule extends RSVModule {

    private final RealisticSurvivalPlugin plugin;

    private TanEvents events;

    public static final String NAME = "ToughAsNails";

    public TanModule(RealisticSurvivalPlugin plugin) {
        super(NAME, plugin);
        this.plugin = plugin;
    }

    @Override
    public void initialize() {
        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Initialize.Enabled")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("Initialize.Message"));
            message = message.replaceAll("%NAME%", NAME);

            plugin.getLogger().info(message);
        }

        setUserConfig(new UserConfig(plugin));
        setItemConfig(new ItemConfig(plugin));
        setRecipeConfig(new RecipesConfig(plugin));

        setModuleItems(new ModuleItems(this, plugin));
        setModuleRecipes(new ModuleRecipes(this, plugin));
        events = new TanEvents(this, plugin);

        getModuleItems().initialize();
        getModuleRecipes().initialize();
        events.initialize();
    }

    @Override
    public void shutdown() {
        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Shutdown.Enabled")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("Shutdown.Message"));
            message = message.replaceAll("%NAME%", NAME);

            plugin.getLogger().info(message);
        }
    }

    public TanEvents getEvents() {
        return events;
    }

}
