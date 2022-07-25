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
package me.val_mobile.realisticsurvival;

import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.commands.Commands;
import me.val_mobile.commands.Tab;
import me.val_mobile.misc.BStats;
import me.val_mobile.misc.PlayerInitializer;
import me.val_mobile.misc.ResourcePackEvents;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.ntr.NtrModule;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.spartanweaponry.SwModule;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RealisticSurvivalPlugin extends JavaPlugin {

    private static Utils util;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        util = new Utils(this);

        BStats bStats = new BStats(this);
        UpdateChecker updateChecker = new UpdateChecker(this, 93795);
        ResourcePackEvents resourcePack = new ResourcePackEvents(this);
        PlayerInitializer playerInitializer = new PlayerInitializer(this);

        updateChecker.checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();
        FileConfiguration config = this.getConfig();

        BaubleModule baubleModule = new BaubleModule(this);
        NtrModule ntrModule = new NtrModule(this);
        SfModule sfModule = new SfModule(this);
        SwModule swModule = new SwModule(this);

        if (config.getBoolean("ResourcePack.Enabled"))
            pm.registerEvents(resourcePack, this);

        if (config.getBoolean("BStats"))
            bStats.recordData();

        pm.registerEvents(playerInitializer, this);

        this.getCommand("RealisticSurvival").setExecutor(new Commands(this));
        this.getCommand("RealisticSurvival").setTabCompleter(new Tab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Utils getUtil() {
        return util;
    }
}