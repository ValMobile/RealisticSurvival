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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MiscRecipes {

    private HashMap<String, Recipe> recipeMap = new HashMap<>();
    private Collection<RSVAnvilRecipe> anvilRecipes = new ArrayList<>();
    private final RealisticSurvivalPlugin plugin;

    public MiscRecipes(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

    public void initialize() {
        FileConfiguration recipeConfig = RealisticSurvivalPlugin.getMiscRecipesConfig();

        Set<String> keys = recipeConfig.getKeys(false);

        for (String name : keys) {
            Recipe recipe = null;

            if (!name.equals("ConfigId")) {
                String type = recipeConfig.getString(name + ".Type");

                switch (type) {
                    case "Shaped" -> recipe = new RSVShapedRecipe(recipeConfig, name, plugin);
                    case "Shapeless" -> recipe = new RSVShapelessRecipe(recipeConfig, name, plugin);
                    case "Smithing" -> recipe = new RSVSmithingRecipe(recipeConfig, name, plugin);
                    case "Furnace" -> recipe = new RSVFurnaceRecipe(recipeConfig, name, plugin);
                    case "Campfire" -> recipe = new RSVCampfireRecipe(recipeConfig, name, plugin);
                    case "Smoker" -> recipe = new RSVSmokingRecipe(recipeConfig, name, plugin);
                    case "Stonecutting" -> recipe = new RSVStonecuttingRecipe(recipeConfig, name, plugin);
                    case "Anvil" -> {
                        recipe = new RSVAnvilRecipe(recipeConfig, name);
                        anvilRecipes.add((RSVAnvilRecipe) recipe);
                    }
                    default -> {}
                }
                addRecipe(recipe);
                recipeMap.putIfAbsent(name, recipe);
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

    public HashMap<String, Recipe> getRecipeMap() {
        return recipeMap;
    }

    public Collection<RSVAnvilRecipe> getAnvilRecipes() {
        return anvilRecipes;
    }

    public Recipe getRecipe(String name) {
        return recipeMap.get(name);
    }
}
