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
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class PlayerInitializer implements Listener {

    private final RealisticSurvivalPlugin plugin;
    private final Utils util;

    public PlayerInitializer(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        this.util = new Utils(plugin);
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
                if (module.getAllowedWorlds().contains(player.getWorld().getName())) {
                    HashMap<String, Recipe> map = module.getModuleRecipes().getRecipeMap();
                    Set<String> keySet = map.keySet();
                    FileConfiguration config = module.getUserConfig().getConfig();
                    for (String name : keySet) {
                        if (config.getBoolean("Recipes." + name + ".Unlock")) {
                            Utils.discoverRecipe(player, map.get(name));
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        Recipe r = event.getRecipe();

        if (r != null) {
            ItemStack result = r.getResult();

            if (RSVItem.isRSVItem(result, util)) {

                String moduleName = RSVItem.getModuleNameFromItem(result, util);
                if (!RSVModule.getModules().get(moduleName).getAllowedWorlds().contains(event.getView().getPlayer().getWorld().getName())) {
                    event.getInventory().setResult(null);
                }
            }
        }
    }

    @EventHandler
    public void onSmithing(PrepareSmithingEvent event) {
        ItemStack result = event.getResult();
        SmithingInventory inv = event.getInventory();

        if (!(inv.getRecipe() == null || result == null)) {
            ItemStack baseItem = inv.getItem(0);

            Material mat = result.getType();
            if (Utils.isNetherite(mat)) {
                if (RSVItem.isRSVItem(baseItem, util)) {
                    if (Utils.isDiamond(baseItem.getType())) {
                        String originalName = RSVItem.getNameFromItem(baseItem, util);
                        String netheriteName = originalName.replaceAll("diamond", "netherite");

                        if (!originalName.equals(netheriteName)) {
                            if (Bukkit.getRecipesFor(RSVItem.getItem(netheriteName)).contains(inv.getRecipe())) {
                                event.setResult(null);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDurability(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();
        if (RSVItem.isRSVItem(item, util)) {
            if (util.hasNbtTag(item, "rsvdurability")) {
                int nbtDurability =
            }
        }
    }
}
