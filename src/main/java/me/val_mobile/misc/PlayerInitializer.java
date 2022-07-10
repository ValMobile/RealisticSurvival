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
package me.val_mobile.misc;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Recipe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class PlayerInitializer implements Listener {

    private final RealisticSurvivalPlugin plugin;

    public PlayerInitializer(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        RSVPlayer rsvplayer = new RSVPlayer(plugin, player);

        rsvplayer.retrieveData();
        rsvplayer.updateData();

        Collection<RSVModule> rsvModules = RSVModule.getModules().values();

        for (RSVModule module : rsvModules) {
            if (module.isEnabled()) {
                HashMap<String, Recipe> map = module.getModuleRecipes().getRecipeMap();
                Set<String> keySet = map.keySet();
                FileConfiguration config = module.getUserConfig().getConfig();
                for (String name : keySet) {
                    boolean unlock = config.getBoolean(name + ".Unlock");
                    if (unlock) {
                        Utils.discoverRecipe(player, map.get(name));
                    }
                }
            }
        }

    }

}
