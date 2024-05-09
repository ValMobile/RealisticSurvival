/*
    Copyright (C) 2024  Val_Mobile

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
package me.val_mobile.rsv;

import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.commands.Commands;
import me.val_mobile.commands.Tab;
import me.val_mobile.data.*;
import me.val_mobile.firstaid.FaModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.integrations.PAPI;
import me.val_mobile.integrations.RealisticSeasons;
import me.val_mobile.misc.*;
import me.val_mobile.ntp.NtpModule;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.spartanweaponry.SwModule;
import me.val_mobile.tan.TanModule;
import me.val_mobile.utils.ToolHandler;
import me.val_mobile.utils.ToolUtils;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Collection;

public class RSVPlugin extends JavaPlugin {

    public static final String NAME = "RealisticSurvival";

    private static RSVPlugin plugin;
    private static Utils util;
    private ToolUtils toolUtils;
    private ToolHandler toolHandler;
    private PluginConfig config;
    private static RSVConfig lorePresetConfig;
    private RSVConfig miscItemsConfig;
    private RSVConfig miscRecipesConfig;
    private MiscRecipes miscRecipes;
    private MiscItems miscItems;
    private RSVConfig integrationsConfig;
    private RSVConfig commandsConfig;

//    private static RSVConfig langConfig;

    @Override
    public void onEnable() {
        plugin = this;
        this.config = new PluginConfig(this);

        lorePresetConfig = new RSVConfig(this, "lorepresets.yml");
        this.miscItemsConfig = new RSVConfig(this, "resources/misc_items.yml");
        this.miscRecipesConfig = new RSVConfig(this, "resources/misc_recipes.yml");
        this.integrationsConfig = new RSVConfig(this, "integrations.yml");
        this.commandsConfig = new RSVConfig(this, "commands.yml");

        util = new Utils(this);

        new UpdateChecker(this, 93795).checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();

        this.toolHandler = new ToolHandler();
        this.toolUtils = new ToolUtils(this);
        this.toolUtils.initMap();

        this.miscItems = new MiscItems(this);
        this.miscRecipes = new MiscRecipes(this);

        IceFireModule ifModule = new IceFireModule(this);
        if (ifModule.isGloballyEnabled())
            ifModule.initialize();

        SwModule swModule = new SwModule(this);
        if (swModule.isGloballyEnabled())
            swModule.initialize();

        BaubleModule baubleModule = new BaubleModule(this);
        if (baubleModule.isGloballyEnabled()) {
            baubleModule.initialize();
        }

        NtpModule ntpModule = new NtpModule(this);
        if (ntpModule.isGloballyEnabled())
            ntpModule.initialize();

        SfModule sfModule = new SfModule(this);
        if (sfModule.isGloballyEnabled()) {
            sfModule.initialize();
        }

        TanModule tanModule = new TanModule(this);
        if (tanModule.isGloballyEnabled())
            tanModule.initialize();

        FaModule faModule = new FaModule(this);
        if (faModule.isGloballyEnabled())
            faModule.initialize();

//        TODO: Add custom enchantment system
//        RSVEnchants rsvEnchants = new RSVEnchants(this);
//        rsvEnchants.registerAllEnchants();

        new BukkitRunnable() {
            @Override
            public void run() {
                RealisticSeasons rs = new RealisticSeasons(getPlugin());
                PAPI papi = new PAPI(getPlugin());
            }
        }.runTaskLater(this, 1L);

        if (config.getConfig().getBoolean("ResourcePack.Enabled"))
            pm.registerEvents(new ResourcePackEvents(this), this);

        if (config.getConfig().getBoolean("BStats"))
            new BStats(this).recordData();

        pm.registerEvents(new MiscEvents(this), this);
        pm.registerEvents(new ItemAcquireEvents(this), this);

        this.getCommand(NAME).setExecutor(new Commands(this));
        this.getCommand(NAME).setTabCompleter(new Tab(this));
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
            if (module.isGloballyEnabled()) {
                module.shutdown();
            }
        }
    }

    @Override
    public void onLoad() {
        Utils.registerEntities();
    }

    @Override
    public FileConfiguration getConfig() {
        return config == null ? null : config.getConfig();
    }

    @Nonnull
    public static RSVPlugin getPlugin() {
        return plugin;
    }

    @Nonnull
    public static Utils getUtil() {
        return util;
    }

    @Nonnull
    public File getConfigFile() {
        return config.getFile();
    }

    @Nonnull
    public static FileConfiguration getLorePresetConfig() {
        return lorePresetConfig.getConfig();
    }

    @Nonnull
    public FileConfiguration getMiscItemsConfig() {
        return miscItemsConfig.getConfig();
    }

    @Nonnull
    public FileConfiguration getMiscRecipesConfig() {
        return miscRecipesConfig.getConfig();
    }

    @Nonnull
    public FileConfiguration getIntegrationsConfig() {
        return integrationsConfig.getConfig();
    }

    @Nonnull
    public FileConfiguration getCommandsConfig() {
        return commandsConfig.getConfig();
    }

    @Nonnull
    public MiscItems getMiscItems() {
        return miscItems;
    }

    @Nonnull
    public MiscRecipes getMiscRecipes() {
        return miscRecipes;
    }

    @Nonnull
    public ToolHandler getToolHandler() {
        return toolHandler;
    }

    @Nonnull
    public ToolUtils getToolUtils() {
        return toolUtils;
    }

}