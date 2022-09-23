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
package me.val_mobile.data;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public abstract class RSVModule {

    private static final HashMap<String, RSVModule> modules = new HashMap<>();

    private final boolean isEnabled;
    private final String name;

    private ModuleItems moduleItems;
    private ModuleRecipes moduleRecipes;

    private RSVConfig userConfig;
    private RSVConfig itemConfig;
    private RSVConfig recipesConfig;

    private final Collection<String> allowedWorlds = new ArrayList<>();

    public RSVModule(String name, RealisticSurvivalPlugin plugin) {
        FileConfiguration config = plugin.getConfig();
        this.name = name;
        this.isEnabled = config.getBoolean(name + ".Enabled");

        if (isEnabled) {
            ConfigurationSection section = config.getConfigurationSection(name + ".Worlds");
            Set<String> keys = section.getKeys(false);

            List<World> worlds = plugin.getServer().getWorlds();

            for (World world : worlds) {
                String worldName = world.getName();
                if (!keys.contains(worldName)) {
                    config.createSection(name + ".Worlds." + worldName).set(worldName, true);
                }

                if (section.getBoolean(worldName)) {
                    allowedWorlds.add(worldName);
                }
            }
        }
        modules.put(name, this);
    }

    public abstract void initialize();

    public abstract void shutdown();

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getName() {
        return name;
    }

    public Collection<String> getAllowedWorlds() {
        return allowedWorlds;
    }

    public static HashMap<String, RSVModule> getModules() {
        return modules;
    }

    public RSVConfig getUserConfig() {
        return userConfig;
    }

    public void setUserConfig(RSVConfig config) {
        userConfig = config;
    }

    public RSVConfig getItemConfig() {
        return itemConfig;
    }

    public void setItemConfig(RSVConfig config) {
        itemConfig = config;
    }

    public RSVConfig getRecipeConfig() {
        return recipesConfig;
    }

    public void setRecipeConfig(RSVConfig config) {
        recipesConfig = config;
    }

    public void setModuleItems(ModuleItems moduleItems) {
        this.moduleItems = moduleItems;
    }

    public void setModuleRecipes(ModuleRecipes moduleRecipes) {
        this.moduleRecipes = moduleRecipes;
    }

    public ModuleItems getModuleItems() {
        return moduleItems;
    }

    public ModuleRecipes getModuleRecipes() {
        return moduleRecipes;
    }

    public static RSVModule getModule(String name) {
        return modules.get(name);
    }
}