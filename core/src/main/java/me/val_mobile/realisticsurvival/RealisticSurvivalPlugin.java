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
import me.val_mobile.data.PluginConfig;
import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.misc.BStats;
import me.val_mobile.misc.MiscEvents;
import me.val_mobile.misc.ResourcePackEvents;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.ntr.NtrModule;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.spartanweaponry.SwModule;
import me.val_mobile.tan.TanModule;
import me.val_mobile.utils.RSVEnchants;
import me.val_mobile.utils.ToolHandler;
import me.val_mobile.utils.ToolUtils;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Collection;

public class RealisticSurvivalPlugin extends JavaPlugin {

    public static ToolUtils toolUtils;
    public static ToolHandler toolHandler;
    private static Utils util;
    private PluginConfig config;

    @Override
    public void onEnable() {

        this.config = new PluginConfig(this);

        util = new Utils(this);

        BStats bStats = new BStats(this);
        UpdateChecker updateChecker = new UpdateChecker(this, 93795);
        ResourcePackEvents resourcePack = new ResourcePackEvents(this);
        MiscEvents miscEvents = new MiscEvents(this);

        updateChecker.checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();

        toolHandler = new ToolHandler();
        toolUtils = new ToolUtils(this);
        toolUtils.initMap();

        IceFireModule module = new IceFireModule(this);
        module.initialize();

        SwModule swModule = new SwModule(this);
        swModule.initialize();

        BaubleModule baubleModule = new BaubleModule(this);
        baubleModule.initialize();

        NtrModule ntrModule = new NtrModule(this);
        ntrModule.initialize();

        SfModule sfModule = new SfModule(this);
        sfModule.initialize();

        TanModule tanModule = new TanModule(this);
        tanModule.initialize();

        RSVEnchants enchants = new RSVEnchants(this);
        enchants.registerAllEnchants();

        if (config.getConfig().getBoolean("ResourcePack.Enabled"))
            pm.registerEvents(resourcePack, this);

        if (config.getConfig().getBoolean("BStats"))
            bStats.recordData();

        pm.registerEvents(miscEvents, this);

        this.getCommand("RealisticSurvival").setExecutor(new Commands(this));
        this.getCommand("RealisticSurvival").setTabCompleter(new Tab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Collection<RSVPlayer> players = RSVPlayer.getPlayers().values();
        Collection<RSVModule> modules = RSVModule.getModules().values();

        for (RSVPlayer player : players) {
            player.saveData();
        }

        for (RSVModule module : modules) {
            module.shutdown();
        }
    }

    @Override
    public FileConfiguration getConfig() {
        return config.getConfig();
    }

    public File getConfigFile() {
        return config.getFile();
    }

    @Override
    public void onLoad() {
        Utils.registerEntities();
    }

    public static Utils getUtil() {
        return util;
    }
}