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
import me.val_mobile.misc.PlayerInitializer;
import me.val_mobile.misc.ResourcePackEvents;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.ntr.NtrEvents;
import me.val_mobile.sea_serpents.SeaSerpentDrops;
import me.val_mobile.sea_serpents.SeaSerpentGearEvents;
import me.val_mobile.spartan_weaponry.SpartanWeaponryEvents;
import me.val_mobile.tan.TanEnchants;
import me.val_mobile.tan.TanEvents;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomRecipes;
import me.val_mobile.utils.Schematics;
import me.val_mobile.utils.Utils;
import me.val_mobile.waystones.WaystoneEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RLCraftPlugin extends JavaPlugin {

    private Commands commands;

    private CustomConfig customConfig;
    private CustomRecipes recipes;

    private BStats bStats;
    private Schematics schematics;
    private NtrEvents ntrEvents;
    private SpartanWeaponryEvents spartanWeaponry;
    private DragonFightEvents dragonFight;
    private DragonGearEvents dragonGear;
    private ResourcePackEvents resourcePack;
    private DragonWorldGenEvents dragonWorldGenEvents;
    private SeaSerpentGearEvents seaSerpentGear;
    private SeaSerpentDrops seaSerpentDrops;
    private WitherDrops witherDrops;
    private LycanitesMobsEvents lycanitesMobs;
    private BaubleEvents bauble;
    private WaystoneEvents waystones;
    private TanEvents tanEvents;
    private TanEnchants tanEnchants;
    private PlayerInitializer playerInitializer;
    private UpdateChecker updateChecker;
    private Utils util;
    
    private Tab tab;

    @Override
    public void onEnable() {

        // Plugin startup logic
        customConfig = new CustomConfig(this);
//        schematics = new Schematics(this);

        this.saveDefaultConfig();

        customConfig.createResourcesFolder();
        customConfig.createSpartanWeaponryConfig();
        customConfig.createBaubleConfig();
        customConfig.createIceFireGearConfig();
        customConfig.createMobConfig();
        customConfig.createNoTreePunchingConfig();
        customConfig.createLMobsConfig();
        customConfig.createItemConfig();
        customConfig.createRecipeConfig();
        customConfig.createTanConfig();

//        schematics.createSchematicsFolder();
//        schematics.createFireDragonNest();

        commands = new Commands(this);
        recipes = new CustomRecipes(this);
        bStats = new BStats(this);
        ntrEvents = new NtrEvents(this);
        spartanWeaponry = new SpartanWeaponryEvents(this);
        dragonFight = new DragonFightEvents(this);
        dragonGear = new DragonGearEvents(this);
//        dragonWorldGenEvents = new DragonWorldGenEvents(this);
        seaSerpentGear = new SeaSerpentGearEvents(this);
        seaSerpentDrops = new SeaSerpentDrops(this);
        witherDrops = new WitherDrops(this);
        lycanitesMobs = new LycanitesMobsEvents(this);
        bauble = new BaubleEvents(this);
        waystones = new WaystoneEvents();
        tanEnchants = new TanEnchants(this);
        tanEvents = new TanEvents(this);
        updateChecker = new UpdateChecker(this, 93795);
        resourcePack = new ResourcePackEvents(this);
        playerInitializer = new PlayerInitializer(this);
        util = new Utils(this);

        tab = new Tab();

        recipes.populateSpartanWeaponryRecipes();
        recipes.populateBaubleRecipes();
        recipes.populateDragonRecipes();
        recipes.populateNtrRecipes();
        recipes.populateSeaSerpentRecipes();
        recipes.populateWaystoneRecipes();
        recipes.populateTanRecipes();

        tanEnchants.populateEnchants();

        updateChecker.checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();
        FileConfiguration config = this.getConfig();

        if (util.shouldEventBeRan("NoTreePunching")) {
            for (Recipe r : CustomRecipes.getNtrRecipes()) {
                Utils.addRecipe(r);
            }

            pm.registerEvents(ntrEvents, this);
        }

        if (util.shouldEventBeRan("Dragons")) {
            for (Recipe r : CustomRecipes.getDragonRecipes()) {
                Utils.addRecipe(r);
            }


            pm.registerEvents(dragonFight, this);
            pm.registerEvents(dragonGear, this);

            if (Bukkit.getPluginManager().getPlugin("FastAsyncWorldEdit") != null) {
//                pm.registerEvents(dragonWorldGenEvents, this);
            }
        }
        if (util.shouldEventBeRan("SeaSerpents")) {
            for (Recipe r : CustomRecipes.getSeaSerpentRecipes()) {
                Utils.addRecipe(r);
            }


            pm.registerEvents(seaSerpentDrops, this);
            pm.registerEvents(seaSerpentGear, this);
        }

        if (util.shouldEventBeRan("Witherbones"))
            pm.registerEvents(witherDrops, this);

        if (util.shouldEventBeRan("Baubles")) {
            for (Recipe r : CustomRecipes.getBaubleRecipes()) {
                Utils.addRecipe(r);
            }

            pm.registerEvents(bauble, this);
        }

        if (util.shouldEventBeRan("LycanitesMobs"))
            pm.registerEvents(lycanitesMobs, this);

        if (util.shouldEventBeRan("Waystones")) {
            for (Recipe r : CustomRecipes.getWaystoneRecipes()) {
                Utils.addRecipe(r);
            }

            pm.registerEvents(waystones, this);
        }

        if (util.shouldEventBeRan("SpartanWeaponry")) {
            for (Recipe r : CustomRecipes.getSpartanWeaponryRecipes()) {
                Utils.addRecipe(r);
            }

            pm.registerEvents(spartanWeaponry, this);
        }

        if (config.getBoolean("ResourcePack.Enabled"))
            pm.registerEvents(resourcePack, this);

        if (config.getBoolean("BStats"))
            bStats.recordData();

        if (util.shouldEventBeRan("ToughAsNails")) {
            pm.registerEvents(tanEvents, this);

            for (Recipe r : CustomRecipes.getTanRecipes()) {
                Utils.addRecipe(r);
            }

            for (Enchantment e : tanEnchants.getEnchants()) {
                tanEnchants.register(e);
            }
        }

        pm.registerEvents(playerInitializer, this);

        this.getCommand("RLCraft").setExecutor(commands);
        this.getCommand("RLCraft").setTabCompleter(tab);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}