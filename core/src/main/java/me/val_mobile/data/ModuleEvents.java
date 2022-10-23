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
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.PluginManager;

import java.util.Set;

public abstract class ModuleEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;
    private final RSVModule module;
    private final FileConfiguration config;

    public ModuleEvents(RSVModule module, RealisticSurvivalPlugin plugin) {
        this.module = module;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
    }

    public void initialize() {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(this, plugin);
    }

    @EventHandler
    public void onMobDrop(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (shouldEventBeRan(entity)) {
            String eName = entity.getType().toString();
            Set<String> entityKeys = config.getConfigurationSection("MobDrops").getKeys(false);
            if (entityKeys.contains(eName)) {
                Set<String> itemKeys = config.getConfigurationSection("MobDrops." + eName).getKeys(false);

                for (String item : itemKeys) {
                    if (RSVItem.isRSVItem(item)) {
                        if (entity.getKiller() == null) {
                            Utils.harvestLooting(config.getConfigurationSection("MobDrops." + eName + "." + item), RSVItem.getItem(item), null, entity.getLocation());
                        }
                        else {
                            Utils.harvestLooting(config.getConfigurationSection("MobDrops." + eName + "." + item), RSVItem.getItem(item), entity.getKiller().getInventory().getItemInMainHand(), entity.getLocation());
                        }
                    }
                }
            }
        }
    }

    public boolean shouldEventBeRan(Entity e) {
        return module.getAllowedWorlds().contains(e.getWorld().getName());
    }

    public boolean shouldEventBeRan(World world) {
        return module.getAllowedWorlds().contains(world.getName());
    }

    public RSVModule getModule() {
        return module;
    }

}
