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

import me.val_mobile.data.iceandfire.ItemConfig;
import me.val_mobile.data.iceandfire.RecipesConfig;
import me.val_mobile.data.iceandfire.UserConfig;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.SchematicBuilder;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;

/**
 * CustomConfig is a class that allows for creation, access, and reloading
 * of yaml files other than the default "config.yml"
 * @author Val_Mobile
 * @version 1.2
 * @since 1.2
 */
public class RSVFiles {

    private static SchematicBuilder fireDragonNest;
    private static SchematicBuilder fireDragonNestUnderground;
    private static SchematicBuilder iceDragonNest;
    private static SchematicBuilder iceDragonNestUnderground;
    private static SchematicBuilder lightningDragonNest;
    private static SchematicBuilder lightningDragonNestUnderground;

    private static me.val_mobile.data.baubles.UserConfig baublesUser;
    private static me.val_mobile.data.baubles.ItemConfig baublesItems;
    private static me.val_mobile.data.baubles.RecipesConfig baublesRecipes;

    private static UserConfig iceFireUser;
    private static ItemConfig iceFireItems;
    private static RecipesConfig iceFireRecipes;

    private static me.val_mobile.data.notreepunching.UserConfig ntrUser;
    private static me.val_mobile.data.notreepunching.ItemConfig ntrItems;
    private static me.val_mobile.data.notreepunching.RecipesConfig ntrRecipes;

    private static me.val_mobile.data.spartanweaponry.UserConfig swUser;
    private static me.val_mobile.data.spartanweaponry.ItemConfig swItems;
    private static me.val_mobile.data.spartanweaponry.RecipesConfig swRecipes;

    private static me.val_mobile.data.spartanandfire.UserConfig sfUser;
    private static me.val_mobile.data.spartanandfire.ItemConfig sfItems;
    private static me.val_mobile.data.spartanandfire.RecipesConfig sfRecipes;

    private static me.val_mobile.data.lycanitesmobs.UserConfig lmUser;
    private static me.val_mobile.data.lycanitesmobs.ItemConfig lmItems;
    private static me.val_mobile.data.lycanitesmobs.RecipesConfig lmRecipes;

    private static me.val_mobile.data.toughasnails.UserConfig tanUser;
    private static me.val_mobile.data.toughasnails.ItemConfig tanItems;
    private static me.val_mobile.data.toughasnails.RecipesConfig tanRecipes;

    private static me.val_mobile.data.MiscItemConfig miscItems;
    private static me.val_mobile.data.MiscRecipeConfig miscRecipes;


    private static RSVConfig playerData;

    // dependency injecting the main class for use
    private final RealisticSurvivalPlugin plugin;

    // constructing the CustomConfig class
    public RSVFiles(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;

        try {
            fireDragonNest = new SchematicBuilder(plugin, "schematics/fire_dragon_nest.schem");
            iceDragonNest = new SchematicBuilder(plugin, "schematics/ice_dragon_nest.schem");
            iceDragonNestUnderground = new SchematicBuilder(plugin, "schematics/ice_dragon_nest_underground.schem");
            lightningDragonNest = new SchematicBuilder(plugin, "schematics/lightning_dragon_nest.schem");
            lightningDragonNestUnderground = new SchematicBuilder(plugin, "schematics/lightning_dragon_nest_underground.schem");
        } catch (IOException e) {
            e.printStackTrace();
        }

        baublesUser = new me.val_mobile.data.baubles.UserConfig(plugin);
        baublesItems = new me.val_mobile.data.baubles.ItemConfig(plugin);
        baublesRecipes = new me.val_mobile.data.baubles.RecipesConfig(plugin);

        iceFireUser = new UserConfig(plugin);
        iceFireItems = new ItemConfig(plugin);
        iceFireRecipes = new RecipesConfig(plugin);

        ntrUser = new me.val_mobile.data.notreepunching.UserConfig(plugin);
        ntrItems = new me.val_mobile.data.notreepunching.ItemConfig(plugin);
        ntrRecipes = new me.val_mobile.data.notreepunching.RecipesConfig(plugin);

        swUser = new me.val_mobile.data.spartanweaponry.UserConfig(plugin);
        swItems = new me.val_mobile.data.spartanweaponry.ItemConfig(plugin);
        swRecipes = new me.val_mobile.data.spartanweaponry.RecipesConfig(plugin);

        sfUser = new me.val_mobile.data.spartanandfire.UserConfig(plugin);
        sfItems = new me.val_mobile.data.spartanandfire.ItemConfig(plugin);
        sfRecipes = new me.val_mobile.data.spartanandfire.RecipesConfig(plugin);

        lmUser = new me.val_mobile.data.lycanitesmobs.UserConfig(plugin);
        lmItems = new me.val_mobile.data.lycanitesmobs.ItemConfig(plugin);
        lmRecipes = new me.val_mobile.data.lycanitesmobs.RecipesConfig(plugin);

        tanUser = new me.val_mobile.data.toughasnails.UserConfig(plugin);
        tanItems = new me.val_mobile.data.toughasnails.ItemConfig(plugin);
        tanRecipes = new me.val_mobile.data.toughasnails.RecipesConfig(plugin);

        miscItems = new MiscItemConfig(plugin);
        miscRecipes = new MiscRecipeConfig(plugin);

        playerData = new PlayerDataConfig(plugin);
    }

    /**
     * Gets the fire dragon nest schematic
     * @return The fire dragon nest schematic
     */
    public static SchematicBuilder getFireDragonNest() {
        return fireDragonNest;
    }

    /**
     * Gets the underground fire dragon nest schematic
     * @return The underground fire dragon nest schematic
     */
    public static SchematicBuilder getUndergroundFireDragonNest() {
        return fireDragonNestUnderground;
    }

    /**
     * Gets the ice dragon nest schematic
     * @return The ice dragon nest schematic
     */
    public static SchematicBuilder getIceDragonNest() {
        return iceDragonNest;
    }

    /**
     * Gets the underground ice dragon nest schematic
     * @return The underground ice dragon nest schematic
     */
    public static SchematicBuilder getUndergroundIceDragonNest() {
        return iceDragonNestUnderground;
    }

    /**
     * Gets the lightning dragon nest schematic
     * @return The lightning dragon nest schematic
     */
    public static SchematicBuilder getLightningDragonNest() {
        return lightningDragonNest;
    }

    /**
     * Gets the underground lightning dragon nest schematic
     * @return The underground lightning dragon nest schematic
     */
    public static SchematicBuilder getUndergroundLightningDragonNest() {
        return lightningDragonNestUnderground;
    }

    /**
     * Gets the bauble config
     * @return The config holding values for the baubles
     */
    public static FileConfiguration getBaubleUserConfig() {
        return baublesUser.getConfig();
    }

    public static FileConfiguration getBaubleItemsConfig() {
        return baublesItems.getConfig();
    }

    public static FileConfiguration getBaubleRecipesConfig() {
        return baublesRecipes.getConfig();
    }
    /**
     * Gets the spartan weaponry config
     * @return The config holding values for the spartan weaponry items
     */
    public static FileConfiguration getSwUserConfig() {
        return sfUser.getConfig();
    }

    public static FileConfiguration getSwItemsConfig() {
        return sfItems.getConfig();
    }

    public static FileConfiguration getSwRecipesConfig() {
        return sfRecipes.getConfig();
    }

    /**
     * Gets the ice and fire config
     * @return The config holding values for the ice and fire module
     */
    public static FileConfiguration getIfUserConfig() {
        return iceFireUser.getConfig();
    }

    public static FileConfiguration getIfItemsConfig() {
        return iceFireItems.getConfig();
    }

    public static FileConfiguration getIfRecipesConfig() {
        return iceFireRecipes.getConfig();
    }

    /**
     * Gets the no tree punching config
     * @return The config holding values for the no tree punching mechanics
     */
    public static FileConfiguration getNtrUserConfig() {
        return ntrUser.getConfig();
    }

    public static FileConfiguration getNtrItemsConfig() {
        return ntrItems.getConfig();
    }

    public static FileConfiguration getNtrRecipesConfig() {
        return ntrRecipes.getConfig();
    }

    /**
     * Gets the lycanite's mobs config
     * @return The config holding values for the lycanite's mobs mechanics
     */
    public static FileConfiguration getLmUserConfig() {
        return lmUser.getConfig();
    }

    public static FileConfiguration getLmItemsConfig() {
        return lmItems.getConfig();
    }

    public static FileConfiguration getLmRecipesConfig() {
        return lmRecipes.getConfig();
    }

    /**
     * Gets the item config
     * @return The config holding information of the custom items' meta
     */
    public static FileConfiguration getMiscItemConfig() {
        return miscItems.getConfig();
    }

    /**
     * Gets the recipe config
     * @return The config holding information of the custom recipes
     */
    public static FileConfiguration getMiscRecipeConfig() {
        return miscRecipes.getConfig();
    }

    /**
     * Gets the toughasnails config
     * @return The config holding toughasnails information
     */
    public static FileConfiguration getTanUserConfig() {
        return tanUser.getConfig();
    }

    public static FileConfiguration getTanItemsConfig() {
        return tanItems.getConfig();
    }

    public static FileConfiguration getTanRecipesConfig() {
        return tanRecipes.getConfig();
    }

    public static FileConfiguration getPlayerDataConfig() {
        return playerData.getConfig();
    }

    public static void reloadConfigs() {
        for (RSVConfig config : RSVConfig.getConfigList()) {
            config.reloadConfig();
        }
    }
}