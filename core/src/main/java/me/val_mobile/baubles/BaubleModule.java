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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class BaubleModule extends me.val_mobile.data.RSVModule {

    private final RealisticSurvivalPlugin plugin;

    public static final String NAME = "Baubles";

    private me.val_mobile.baubles.BaubleAbilities abilities;
    private me.val_mobile.baubles.BaubleEvents events;

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

        setUserConfig(new me.val_mobile.data.baubles.UserConfig(plugin));
        setItemConfig(new me.val_mobile.data.baubles.ItemConfig(plugin));
        setRecipeConfig(new me.val_mobile.data.baubles.RecipesConfig(plugin));
        setModuleItems(new me.val_mobile.data.ModuleItems(this, plugin));
        setModuleRecipes(new me.val_mobile.data.ModuleRecipes(this, plugin));

        events = new me.val_mobile.baubles.BaubleEvents(this, plugin);

        abilities = new me.val_mobile.baubles.BaubleAbilities();;


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

    public me.val_mobile.baubles.BaubleAbilities getAbilities() {
        return abilities;
    }

    public me.val_mobile.baubles.BaubleEvents getEvents() {
        return events;
    }
}
