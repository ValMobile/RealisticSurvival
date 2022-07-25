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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public abstract class ModuleEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;
    private RSVModule module;

    public ModuleEvents(RSVModule module, RealisticSurvivalPlugin plugin) {
        this.module = module;
        this.plugin = plugin;
    }

    public void initialize() {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(this, plugin);
    }

    public boolean shouldEventBeRan(Entity e) {
        return module.getAllowedWorlds().contains(e.getWorld().getName());
    }

    public boolean shouldEventBeRan(World world) {
        return module.getAllowedWorlds().contains(world);
    }

    public RSVModule getModule() {
        return module;
    }
}
