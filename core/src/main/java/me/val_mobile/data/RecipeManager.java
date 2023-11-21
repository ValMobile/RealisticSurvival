/*
    Copyright (C) 2023  Val_Mobile

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

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.Utils;
import me.val_mobile.utils.recipe.*;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.*;

import java.util.HashSet;
import java.util.Set;

public class RecipeManager {

    private final Set<NamespacedKey> recipeKeys = new HashSet<>();
    private final Set<RSVAnvilRecipe> anvilRecipes = new HashSet<>();
    private final Set<RSVBrewingRecipe> brewingRecipes = new HashSet<>();
    private final RSVPlugin plugin;
    private final FileConfiguration recipeConfig;
    private final FileConfiguration userConfig;

    public RecipeManager(RSVPlugin plugin, FileConfiguration recipeConfig, FileConfiguration userConfig) {
        this.plugin = plugin;
        this.recipeConfig = recipeConfig;
        this.userConfig = userConfig;
        initialize();
    }

    public void initialize() {
        Set<String> keys = recipeConfig.getKeys(false);

        for (String name : keys) {
            Recipe recipe;

            String type = recipeConfig.getString(name + ".Type");

            if (type != null) {
                if (userConfig == null) {
                    recipe = getRecipe(type, name);
                    addRecipe(recipe);
                }
                else {
                    if (userConfig.getBoolean("Recipes." + name + ".Enabled.EnableAllVersions")) {
                        recipe = getRecipe(type, name);
                        addRecipe(recipe);
                    }
                    else {
                        if (userConfig.contains("Recipes." + name + ".Enabled.Versions." + Utils.getMinecraftVersion(true))) {
                            if (userConfig.getBoolean("Recipes." + name + ".Enabled.Versions." + Utils.getMinecraftVersion(true))) {
                                recipe = getRecipe(type, name);
                                addRecipe(recipe);
                            }
                        }
                        else {
                            recipe = getRecipe(type, name);
                            addRecipe(recipe);
                        }
                    }
                }
            }
        }
    }

    public Recipe getRecipe(String type, String recipeName) {
        Recipe recipe = null;
        switch (type) {
            case "Shaped" -> {
                try {
                    recipe = new RSVShapedRecipe(recipeConfig, recipeName, plugin);
                    recipeKeys.add(((ShapedRecipe) recipe).getKey());
                } catch (Exception ignored) {}
            }
            case "Shapeless" -> {
                // shapeless recipes do not work properly on spigot
                if (Utils.isServerRunningPaper()) {
                    try {
                        recipe = new RSVShapelessRecipe(recipeConfig, recipeName, plugin);
                        recipeKeys.add(((ShapelessRecipe) recipe).getKey());
                    } catch (Exception ignored) {}
                }
                else {
                    try {
                        recipe = new RSVShapedRecipe(recipeConfig, recipeName, plugin);
                        recipeKeys.add(((ShapedRecipe) recipe).getKey());
                    } catch (Exception ignored) {}
                }
            }
            case "Smithing" -> {
                try {
                    recipe = new RSVSmithingRecipe(recipeConfig, recipeName, plugin);
                    recipeKeys.add(((SmithingRecipe) recipe).getKey());
                } catch (Exception ignored) {}
            }
            case "Furnace" -> {
                try {
                    recipe = new RSVFurnaceRecipe(recipeConfig, recipeName, plugin);
                    recipeKeys.add(((FurnaceRecipe) recipe).getKey());
                } catch (Exception ignored) {}
            }
            case "Campfire" -> {
                try {
                    recipe = new RSVCampfireRecipe(recipeConfig, recipeName, plugin);
                    recipeKeys.add(((CampfireRecipe) recipe).getKey());
                } catch (Exception ignored) {}
            }
            case "Smoker" -> {
                try {
                    recipe = new RSVSmokingRecipe(recipeConfig, recipeName, plugin);
                    recipeKeys.add(((SmokingRecipe) recipe).getKey());
                } catch (Exception ignored) {}
            }
            case "Stonecutting" -> {
                try {
                    recipe = new RSVStonecuttingRecipe(recipeConfig, recipeName, plugin);
                    recipeKeys.add(((StonecuttingRecipe) recipe).getKey());
                } catch (Exception ignored) {}
            }
            case "Anvil" -> {
                try {
                    recipe = new RSVAnvilRecipe(recipeConfig, recipeName);
                    anvilRecipes.add((RSVAnvilRecipe) recipe);
                } catch (Exception ignored) {}
            }
            case "Brewing" -> {
                try {
                    recipe = new RSVBrewingRecipe(recipeConfig, recipeName, plugin);
                    brewingRecipes.add((RSVBrewingRecipe) recipe);
                } catch (Exception ignored) {}
            }
            default -> {
                return null;
            }
        }
        return recipe;
    }

    public void addRecipe(Recipe r) {
        if (r != null && !(r instanceof RSVBrewingRecipe || r instanceof RSVAnvilRecipe)) {
            if (r instanceof Keyed keyed) {
                if (Bukkit.getRecipe(keyed.getKey()) == null) {
                    Bukkit.addRecipe(r);
                }
            }
        }
    }

    public Set<NamespacedKey> getRecipeKeys() {
        return recipeKeys;
    }

    public Set<RSVAnvilRecipe> getAnvilRecipes() {
        return anvilRecipes;
    }

    public Set<RSVBrewingRecipe> getBrewingRecipes() {
        return brewingRecipes;
    }
}
