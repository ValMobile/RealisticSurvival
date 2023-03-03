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
package me.val_mobile.realisticsurvival;

import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.commands.Commands;
import me.val_mobile.commands.Tab;
import me.val_mobile.data.*;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.integrations.PAPI;
import me.val_mobile.integrations.RealisticSeasons;
import me.val_mobile.misc.BStats;
import me.val_mobile.misc.MiscEvents;
import me.val_mobile.misc.ResourcePackEvents;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.ntp.NtpModule;
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
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collection;

public class RealisticSurvivalPlugin extends JavaPlugin {

    public static final String NAME = "RealisticSurvival";

    private static RealisticSurvivalPlugin plugin;
    private static Utils util;
    private ToolUtils toolUtils;
    private ToolHandler toolHandler;
    private PluginConfig config;
    private static LorePresetConfig lorePresetConfig;
    private MiscItemsConfig miscItemsConfig;
    private MiscRecipesConfig miscRecipesConfig;
    private MiscRecipes miscRecipes;
    private MiscItems miscItems;
    private IntegrationsConfig integrationsConfig;

//    private static RSVConfig langConfig;

    @Override
    public void onEnable() {
        plugin = this;
        this.config = new PluginConfig(this);

        lorePresetConfig = new LorePresetConfig(this);
        this.miscItemsConfig = new MiscItemsConfig(this);
        this.miscRecipesConfig = new MiscRecipesConfig(this);
        this.integrationsConfig = new IntegrationsConfig(this);

//        String lang = config.getConfig().getString("Language");
//
//        Locale.setDefault(new Locale(lang.substring(0, lang.indexOf("-")), lang.substring(lang.indexOf("-") + 1)));
//        ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

        util = new Utils(this);

        new UpdateChecker(this, 93795).checkUpdate();

        PluginManager pm = this.getServer().getPluginManager();

        this.toolHandler = new ToolHandler();
        this.toolUtils = new ToolUtils(this);
        this.toolUtils.initMap();

        this.miscItems = new MiscItems(this);
        this.miscRecipes = new MiscRecipes(this);

        IceFireModule ifModule = new IceFireModule(this);
        if (ifModule.isEnabled())
            ifModule.initialize();

        SwModule swModule = new SwModule(this);
        if (swModule.isEnabled())
            swModule.initialize();

        BaubleModule baubleModule = new BaubleModule(this);
        if (baubleModule.isEnabled())
            baubleModule.initialize();

        NtpModule ntpModule = new NtpModule(this);
        if (ntpModule.isEnabled())
            ntpModule.initialize();

        SfModule sfModule = new SfModule(this);
        if (sfModule.isEnabled())
            sfModule.initialize();

        TanModule tanModule = new TanModule(this);
        if (tanModule.isEnabled())
            tanModule.initialize();

        RSVEnchants rsvEnchants = new RSVEnchants(this);
        rsvEnchants.registerAllEnchants();

        new BukkitRunnable() {
            @Override
            public void run() {
                RealisticSeasons rs = new RealisticSeasons(getPlugin());
            }
        }.runTaskLater(this, 1L);
        PAPI papi = new PAPI(this);

        if (config.getConfig().getBoolean("ResourcePack.Enabled"))
            pm.registerEvents(new ResourcePackEvents(this), this);

        if (config.getConfig().getBoolean("BStats"))
            new BStats(this).recordData();

        pm.registerEvents(new MiscEvents(this), this);

        this.getCommand(NAME).setExecutor(new Commands(this));
        this.getCommand(NAME).setTabCompleter(new Tab());
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
            if (module.isEnabled()) {
                module.shutdown();
            }
        }
    }

    @Override
    public void onLoad() {
        Utils.registerEntities();
    }

    @Override
    @Nullable
    public FileConfiguration getConfig() {
        return config == null ? null : config.getConfig();
    }

    public static RealisticSurvivalPlugin getPlugin() {
        return plugin;
    }
    public static Utils getUtil() {
        return util;
    }

    public File getConfigFile() {
        return config.getFile();
    }

    public static FileConfiguration getLorePresetConfig() {
        return lorePresetConfig.getConfig();
    }

    public FileConfiguration getMiscItemsConfig() {
        return miscItemsConfig.getConfig();
    }

    public FileConfiguration getMiscRecipesConfig() {
        return miscRecipesConfig.getConfig();
    }

    public FileConfiguration getIntegrationsConfig() {
        return integrationsConfig.getConfig();
    }

    public MiscItems getMiscItems() {
        return miscItems;
    }

    public MiscRecipes getMiscRecipes() {
        return miscRecipes;
    }

    public ToolHandler getToolHandler() {
        return toolHandler;
    }

    public ToolUtils getToolUtils() {
        return toolUtils;
    }

    //    private String translate(final String string) {
//        try {
//            try {
//                return customBundle.getString(string);
//            } catch (final MissingResourceException ex) {
//                return localeBundle.getString(string);
//            }
//        } catch (final MissingResourceException ex) {
//            if (ess == null || ess.getSettings().isDebug()) {
//                ess.getLogger().log(Level.WARNING, String.format("Missing translation key \"%s\" in translation file %s", ex.getKey(), localeBundle.getLocale().toString()), ex);
//            }
//            return defaultBundle.getString(string);
//        }
//    }
}