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
package me.val_mobile.baubles;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.ModuleRecipes;
import me.val_mobile.data.baubles.ItemConfig;
import me.val_mobile.data.baubles.RecipesConfig;
import me.val_mobile.data.baubles.UserConfig;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class BaubleModule extends me.val_mobile.data.RSVModule {

    private final RealisticSurvivalPlugin plugin;

    public static final String NAME = "Baubles";

    private BaubleAbilities abilities;
    private BaubleEvents events;

    public BaubleModule(RealisticSurvivalPlugin plugin) {
        super(NAME, plugin);
        this.plugin = plugin;
    }

    @Override
    public void initialize() {
        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Shutdown.Enabled")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("Shutdown.Message"));
            message = message.replaceAll("%NAME%", NAME);

            plugin.getLogger().info(message);
        }

        setUserConfig(new UserConfig(plugin));
        setItemConfig(new ItemConfig(plugin));
        setRecipeConfig(new RecipesConfig(plugin));
        setModuleItems(new ModuleItems(this, plugin));
        setModuleRecipes(new ModuleRecipes(this, plugin));

        events = new BaubleEvents(this, plugin);

        abilities = new BaubleAbilities();;


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

    public BaubleAbilities getAbilities() {
        return abilities;
    }

    public BaubleEvents getEvents() {
        return events;
    }
}
