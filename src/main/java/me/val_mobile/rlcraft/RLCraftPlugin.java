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
import me.val_mobile.dragons.WitherDrops;
import me.val_mobile.lycanites_mobs.LycanitesMobsEvents;
import me.val_mobile.misc.BStats;
import me.val_mobile.misc.ResourcePackEvents;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.no_tree_punching.NoTreePunchingEvents;
import me.val_mobile.sea_serpents.SeaSerpentDrops;
import me.val_mobile.sea_serpents.SeaSerpentGearEvents;
import me.val_mobile.spartan_weaponry.SpartanWeaponryEvents;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomRecipes;
import me.val_mobile.waystones.WaystoneEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RLCraftPlugin extends JavaPlugin {

    private Commands commands;

    private CustomConfig customConfig;
    private CustomRecipes recipes;

    private BStats bStats;
//    private Schematics schematics;
    private NoTreePunchingEvents noTreePunchingEvents;
    private SpartanWeaponryEvents spartanWeaponry;
    private DragonFightEvents dragonFight;
    private DragonGearEvents dragonGear;
    private ResourcePackEvents resourcePack;
//    private DragonWorldGenEvents dragonWorldGenEvents;
    private SeaSerpentGearEvents seaSerpentGear;
    private SeaSerpentDrops seaSerpentDrops;
    private WitherDrops witherDrops;
    private LycanitesMobsEvents lycanitesMobs;
    private BaubleEvents bauble;
    private WaystoneEvents waystones;
    private UpdateChecker updateChecker;
    
    private Tab tab;

    @Override
    public void onEnable() {

        // Plugin startup logic
        customConfig = new CustomConfig(this);
//      schematics = new Schematics(this);

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

//      schematics.createSchematicsFolder();
//      schematics.createFireDragonNest();

        commands = new Commands(this);
        recipes = new CustomRecipes(this);
        bStats = new BStats(this);
        noTreePunchingEvents = new NoTreePunchingEvents(this);
        spartanWeaponry = new SpartanWeaponryEvents(this);
        dragonFight = new DragonFightEvents();
        dragonGear = new DragonGearEvents(this);
//      dragonWorldGenEvents = new DragonWorldGenEvents(this);
        seaSerpentGear = new SeaSerpentGearEvents(this);
        seaSerpentDrops = new SeaSerpentDrops(this);
        witherDrops = new WitherDrops(this);
        lycanitesMobs = new LycanitesMobsEvents(this);
        bauble = new BaubleEvents(this);
        waystones = new WaystoneEvents();
        updateChecker = new UpdateChecker(this, 93795);
        resourcePack = new ResourcePackEvents(this);

        tab = new Tab();

        recipes.populateSpartanWeaponryRecipes();
        recipes.populateBaubleRecipes();
        recipes.populateDragonRecipes();
        recipes.populateNtrRecipes();
        recipes.populateSeaSerpentRecipes();
        recipes.populateWaystoneRecipes();

        updateChecker.checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();
        FileConfiguration config = this.getConfig();

        if (config.getBoolean("NoTreePunching")) {
            for (Recipe r : CustomRecipes.getNtrRecipes()) {
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
            }

            pm.registerEvents(noTreePunchingEvents, this);
        }

        if (config.getBoolean("Dragons")) {
            for (Recipe r : CustomRecipes.getDragonRecipes()) {
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
            }


            pm.registerEvents(dragonFight, this);
            pm.registerEvents(dragonGear, this);
//            pm.registerEvents(dragonWorldGenEvents, this);
        }
        if (config.getBoolean("SeaSerpents")) {
            for (Recipe r : CustomRecipes.getSeaSerpentRecipes()) {
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
            }


            pm.registerEvents(seaSerpentDrops, this);
            pm.registerEvents(seaSerpentGear, this);
        }

        if (config.getBoolean("Witherbones")) {
            pm.registerEvents(witherDrops, this);
        }

        if (config.getBoolean("Baubles")) {
            for (Recipe r : CustomRecipes.getBaubleRecipes()) {
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
            }

            pm.registerEvents(bauble, this);
        }

        if (config.getBoolean("LycanitesMobs")) {
            pm.registerEvents(lycanitesMobs, this);
        }

        if (config.getBoolean("Waystones")) {
            for (Recipe r : CustomRecipes.getWaystoneRecipes()) {
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
            }

            pm.registerEvents(waystones, this);
        }

        if (config.getBoolean("SpartanWeaponry")) {
            for (Recipe r : CustomRecipes.getSpartanWeaponryRecipes()) {
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
            }

            pm.registerEvents(spartanWeaponry, this);
        }

        if (config.getBoolean("ResourcePack.Enabled")) {
            pm.registerEvents(resourcePack, this);
        }

        if (config.getBoolean("BStats")) {
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