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

import me.val_mobile.data.baubles.ItemConfig;
import me.val_mobile.data.baubles.RecipesConfig;
import me.val_mobile.data.baubles.UserConfig;
import me.val_mobile.data.RSVModule;
import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.ModuleRecipes;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;

public class BaubleModule extends RSVModule {

    private final RealisticSurvivalPlugin plugin;

    private BaubleAbilities abilities;
    private BaubleEvents events;

    public BaubleModule(RealisticSurvivalPlugin plugin) {
        super("Baubles", plugin);
        this.plugin = plugin;
    }

    @Override
    public void initialize() {
        plugin.getLogger().info("Initializing " + getName() + " Module");
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
        plugin.getLogger().info("Shutting down " + getName() + " Module");
    }

    public BaubleAbilities getAbilities() {
        return abilities;
    }

    public BaubleEvents getEvents() {
        return events;
    }
}
