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

public class MiscRecipes {

    private final Map<String, Recipe> recipeMap = new HashMap<>();
    private final Set<RSVAnvilRecipe> anvilRecipes = new HashSet<>();
    private final Set<RSVBrewingRecipe> brewingRecipes = new HashSet<>();
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;

    public MiscRecipes(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getMiscRecipesConfig();
    }

    public void initialize() {

        Set<String> keys = config.getKeys(false);

        for (String name : keys) {
            Recipe recipe;

            if (!name.equals("ConfigId")) {
                String type = config.getString(name + ".Type");

                if (type != null) {
                    recipe = getRecipe(type, name);
                    addRecipe(recipe);
                    recipeMap.putIfAbsent(name, recipe);
                }
            }
        }
    }

    public Recipe getRecipe(String type, String recipeName) {
        switch (type) {
            case "Shaped" -> {
                return new RSVShapedRecipe(config, recipeName, plugin);
            }
            case "Shapeless" -> {
                return new RSVShapelessRecipe(config, recipeName, plugin);
            }
            case "Smithing" -> {
                return new RSVSmithingRecipe(config, recipeName, plugin);
            }
            case "Furnace" -> {
                return new RSVFurnaceRecipe(config, recipeName, plugin);
            }
            case "Campfire" -> {
                return new RSVCampfireRecipe(config, recipeName, plugin);
            }
            case "Smoker" -> {
                return new RSVSmokingRecipe(config, recipeName, plugin);
            }
            case "Stonecutting" -> {
                return new RSVStonecuttingRecipe(config, recipeName, plugin);
            }
            case "Anvil" -> {
                RSVAnvilRecipe recipe = new RSVAnvilRecipe(config, recipeName);
                anvilRecipes.add(recipe);
                return recipe;
            }
            case "Brewing" -> {
                RSVBrewingRecipe recipe = new RSVBrewingRecipe(plugin, config, recipeName);
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
