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
import me.val_mobile.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModuleRecipes {

    private final Map<String, Recipe> recipeMap = new HashMap<>();
    private final Set<RSVAnvilRecipe> anvilRecipes = new HashSet<>();
    private final Set<RSVBrewingRecipe> brewingRecipes = new HashSet<>();
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration recipeConfig;
    private final FileConfiguration userConfig;

    public ModuleRecipes(RSVModule module, RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        this.recipeConfig = module.getRecipeConfig().getConfig();
        this.userConfig = module.getUserConfig().getConfig();
    }

    public void initialize() {
        Set<String> keys = recipeConfig.getKeys(false);

        for (String name : keys) {
            Recipe recipe;

            String type = recipeConfig.getString(name + ".Type");

            if (type != null) {
                if (userConfig.getBoolean("Recipes." + name + ".Enabled.EnableAllVersions")) {
                    recipe = getRecipe(type, name);
                    addRecipe(recipe);
                    recipeMap.putIfAbsent(name, recipe);
                }
                else {
                    if (userConfig.contains("Recipes." + name + ".Enabled.Versions." + RealisticSurvivalPlugin.getUtil().getMinecraftVersion())) {
                        if (userConfig.getBoolean("Recipes." + name + ".Enabled.Versions." + RealisticSurvivalPlugin.getUtil().getMinecraftVersion())) {
                            recipe = getRecipe(type, name);
                            addRecipe(recipe);
                            recipeMap.putIfAbsent(name, recipe);
                        }
                    }
                }
            }
        }
    }

    public Recipe getRecipe(String type, String recipeName) {
        switch (type) {
            case "Shaped" -> {
                return new RSVShapedRecipe(recipeConfig, recipeName, plugin);
            }
            case "Shapeless" -> {
                return new RSVShapelessRecipe(recipeConfig, recipeName, plugin);
            }
            case "Smithing" -> {
                return new RSVSmithingRecipe(recipeConfig, recipeName, plugin);
            }
            case "Furnace" -> {
                return new RSVFurnaceRecipe(recipeConfig, recipeName, plugin);
            }
            case "Campfire" -> {
                return new RSVCampfireRecipe(recipeConfig, recipeName, plugin);
            }
            case "Smoker" -> {
                return new RSVSmokingRecipe(recipeConfig, recipeName, plugin);
            }
            case "Stonecutting" -> {
                return new RSVStonecuttingRecipe(recipeConfig, recipeName, plugin);
            }
            case "Anvil" -> {
                RSVAnvilRecipe recipe = new RSVAnvilRecipe(recipeConfig, recipeName);
                anvilRecipes.add(recipe);
                return recipe;
            }
            case "Brewing" -> {
                RSVBrewingRecipe recipe = new RSVBrewingRecipe(recipeConfig, recipeName);
                brewingRecipes.add(recipe);
                return recipe;
            }
            default -> {
                return null;
            }
        }
    }

    public void addRecipe(Recipe r) {
        if (r instanceof ShapedRecipe) {
            if (Bukkit.getRecipe(((ShapedRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof ShapelessRecipe) {
            if (Bukkit.getRecipe(((ShapelessRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof SmithingRecipe) {
            if (Bukkit.getRecipe(((SmithingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof FurnaceRecipe) {
            if (Bukkit.getRecipe(((FurnaceRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof CampfireRecipe) {
            if (Bukkit.getRecipe(((CampfireRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof BlastingRecipe) {
            if (Bukkit.getRecipe(((BlastingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof SmokingRecipe) {
            if (Bukkit.getRecipe(((SmokingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
        else if (r instanceof StonecuttingRecipe) {
            if (Bukkit.getRecipe(((StonecuttingRecipe) r).getKey()) == null) {
                Bukkit.addRecipe(r);
            }
        }
    }

    public Map<String, Recipe> getRecipeMap() {
        return recipeMap;
    }

    public Set<RSVAnvilRecipe> getAnvilRecipes() {
        return anvilRecipes;
    }

    public Set<RSVBrewingRecipe> getBrewingRecipes() {
        return brewingRecipes;
    }

    public Recipe getRecipe(String name) {
        return recipeMap.get(name);
    }
}
