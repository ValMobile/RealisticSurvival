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

import me.val_mobile.baubles.BaubleEvents;
import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.commands.Commands;
import me.val_mobile.commands.Tab;
import me.val_mobile.data.RSVFiles;
import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.*;
import me.val_mobile.lycanitesmobs.LycanitesMobsEvents;
import me.val_mobile.misc.BStats;
import me.val_mobile.misc.PlayerInitializer;
import me.val_mobile.misc.ResourcePackEvents;
import me.val_mobile.misc.UpdateChecker;
import me.val_mobile.ntr.NtrEvents;
import me.val_mobile.ntr.NtrModule;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.spartanweaponry.SwEvents;
import me.val_mobile.spartanweaponry.SwModule;
import me.val_mobile.tan.TanEnchants;
import me.val_mobile.tan.TanEvents;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class RealisticSurvivalPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

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
}