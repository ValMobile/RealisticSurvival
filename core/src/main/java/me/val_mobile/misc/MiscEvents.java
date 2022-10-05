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
import me.val_mobile.utils.RSVAnvilRecipe;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MiscEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;
    public MiscEvents(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        RSVPlayer rsvplayer = RSVPlayer.getPlayers().containsKey(player.getUniqueId()) ? RSVPlayer.getPlayers().get(player.getUniqueId()) : new RSVPlayer(plugin, player);
        rsvplayer.retrieveData();

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

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RSVPlayer.getPlayers().get(player.getUniqueId()).saveData();
        RSVPlayer.getPlayers().remove(player.getUniqueId());
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        Recipe r = event.getRecipe();

        if (r != null) {
            ItemStack result = r.getResult();

            if (RSVItem.isRSVItem(result)) {
                String moduleName = RSVItem.getModuleNameFromItem(result);
                if (RSVModule.getModule(moduleName).getAllowedWorlds().contains(event.getView().getPlayer().getWorld().getName())) {
                    if (r instanceof ShapedRecipe shaped) {
                        NamespacedKey key = shaped.getKey();

                        if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                            switch (key.getKey()) {
                                case "dark_prismarine", "prismarine", "prismarine_bricks", "sea_lantern" -> event.getInventory().setResult(null);
                                default -> {}
                            }
                        }
                    }
                }
                else {
                    event.getInventory().setResult(null);
                }
            }
        }
    }

    @EventHandler
    public void onSmithing(PrepareSmithingEvent event) {
        SmithingInventory inv = event.getInventory();

        ItemStack baseItem = inv.getItem(0);

        if (RSVItem.isRSVItem(baseItem)) {
            if (Utils.isNetheriteRecipe(inv)) {
                event.setResult(null);
                List<HumanEntity> viewers = event.getViewers();

                for (HumanEntity p : viewers) {
                    ((Player) p).updateInventory();
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDurability(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();

        if (!event.isCancelled()) {
            Utils.changeDurability(item, -event.getDamage(), true);
        }
    }

    /**
     * Adds anvil recipes
     * @param event The event called when a player adds items inside an anvil
     * @see Utils
     */
    @EventHandler
    public void inAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory(); // get the anvil inventory
        String worldName = event.getView().getPlayer().getWorld().getName();
        Collection<String> allowedWorlds;
        Collection<RSVAnvilRecipe> anvilRecipes;

        for (RSVModule module : RSVModule.getModules().values()) {
            allowedWorlds = module.getAllowedWorlds();
            if (allowedWorlds.contains(worldName)) {
                anvilRecipes = module.getModuleRecipes().getAnvilRecipes();
                for (RSVAnvilRecipe recipe : anvilRecipes) {
                    if (recipe.isValidRecipe(inv)) {
                        recipe.useRecipe(event);
                        break;
                    }
                }
            }
        }
    }
}
