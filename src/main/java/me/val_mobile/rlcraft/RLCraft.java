/*
    Copyright (C) 2021  Val_Mobile

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
package me.val_mobile.rlcraft;

import me.val_mobile.baubles.BaubleEvents;
import me.val_mobile.commands.Commands;
import me.val_mobile.commands.Tab;
import me.val_mobile.dragons.DragonFightEvents;
import me.val_mobile.dragons.DragonGearEvents;
import me.val_mobile.dragons.DragonWorldGenEvents;
import me.val_mobile.dragons.WitherDrops;
import me.val_mobile.lycanites_mobs.LycanitesMobsEvents;
import me.val_mobile.misc.BStats;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.no_tree_punching.NoTreePunching;
import me.val_mobile.sea_serpents.SeaSerpentDrops;
import me.val_mobile.sea_serpents.SeaSerpentGearEvents;
import me.val_mobile.spartan_weaponry.SpartanWeaponryEvents;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Recipes;
import me.val_mobile.utils.Schematics;
import me.val_mobile.waystones.WaystoneEvents;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RLCraft extends JavaPlugin {

    private final Commands commands = new Commands(this);

    private final CustomConfig customConfig = new CustomConfig(this);
    private final Recipes recipes = new Recipes(this);

    private final BStats bStats = new BStats(this);
    private final Schematics schematics = new Schematics(this);
    private final NoTreePunching noTreePunching = new NoTreePunching();
    private final SpartanWeaponryEvents spartanWeaponry = new SpartanWeaponryEvents();
    private final DragonFightEvents dragonFight = new DragonFightEvents(this);
    private final DragonGearEvents dragonGear = new DragonGearEvents(this);
    private final DragonWorldGenEvents dragonWorldGenEvents = new DragonWorldGenEvents();
    private final SeaSerpentGearEvents seaSerpentGear = new SeaSerpentGearEvents(this);
    private final SeaSerpentDrops seaSerpentDrops = new SeaSerpentDrops();
    private final WitherDrops witherDrops = new WitherDrops(this);
    private final LycanitesMobsEvents lycanitesMobs = new LycanitesMobsEvents();
    private final BaubleEvents bauble = new BaubleEvents(this);
    private final WaystoneEvents waystones = new WaystoneEvents();
    private final UpdateChecker updateChecker = new UpdateChecker(this, 93795);
    
    private final Tab tab = new Tab();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

        customConfig.createResourcesFolder();
        customConfig.createSpartanWeaponryConfig();
        customConfig.createBaubleConfig();
        customConfig.createIceFireGearConfig();
        customConfig.createMobConfig();
        customConfig.createNoTreePunchingConfig();
        customConfig.createLycanitesMobsConfig();
        customConfig.createItemConfig();
        customConfig.createRecipeConfig();

        schematics.createSchematicsFolder();
        schematics.createFireDragonNest();

        recipes.populateSpartanWeaponryRecipes();
        recipes.populateBaubleRecipes();
        recipes.populateDragonRecipes();
        recipes.populateNtrRecipes();
        recipes.populateSeaSerpentRecipes();
        recipes.populateWaystoneRecipes();

        updateChecker.checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();

        if (this.getConfig().getBoolean("NoTreePunching")) {
            for (Recipe r : Recipes.getNtrRecipes()) {
                Bukkit.addRecipe(r);
            }

            pm.registerEvents(noTreePunching, this);
        }

        if (this.getConfig().getBoolean("Dragons")) {
            for (Recipe r : Recipes.getDragonRecipes()) {
                Bukkit.addRecipe(r);
            }


            pm.registerEvents(dragonFight, this);
            pm.registerEvents(dragonGear, this);
            pm.registerEvents(dragonWorldGenEvents, this);
        }
        if (this.getConfig().getBoolean("SeaSerpents")) {
            for (Recipe r : Recipes.getSeaSerpentRecipes()) {
                Bukkit.addRecipe(r);
            }


            pm.registerEvents(seaSerpentDrops, this);
            pm.registerEvents(seaSerpentGear, this);
        }

        if (this.getConfig().getBoolean("Witherbones")) {
            pm.registerEvents(witherDrops, this);
        }

        if (this.getConfig().getBoolean("Baubles")) {
            for (Recipe r : Recipes.getBaubleRecipes()) {
                Bukkit.addRecipe(r);
            }

            pm.registerEvents(bauble, this);
        }

        if (this.getConfig().getBoolean("LycanitesMobs")) {
            pm.registerEvents(lycanitesMobs, this);
        }

        if (this.getConfig().getBoolean("Waystones")) {
            pm.registerEvents(waystones, this);
        }

        if (this.getConfig().getBoolean("SpartanWeaponry")) {
            pm.registerEvents(spartanWeaponry, this);
        }

        if (this.getConfig().getBoolean("BStats")) {
            bStats.recordData();
        }

        this.getCommand("RLCraft").setExecutor(commands);
        this.getCommand("RLCraft").setTabCompleter(tab);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}