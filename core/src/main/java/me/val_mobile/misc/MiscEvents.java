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
import me.val_mobile.utils.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.inventory.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MiscEvents implements Listener {

    public MiscEvents() {}

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!RSVPlayer.getPlayers().containsKey(player.getUniqueId())) {
            RSVPlayer rsvplayer = new RSVPlayer(player);
            rsvplayer.retrieveData();
        }

        Collection<RSVModule> rsvModules = RSVModule.getModules().values();

        for (RSVModule module : rsvModules) {
            if (module.isEnabled()) {
                if (module.getAllowedWorlds().contains(player.getWorld().getName())) {
                    Map<String, Recipe> map = module.getModuleRecipes().getRecipeMap();
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
            if (r instanceof ShapedRecipe shaped) {
                NamespacedKey key = shaped.getKey();

                if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                    switch (key.getKey()) {
                        case "dark_prismarine", "prismarine", "prismarine_bricks", "sea_lantern" -> {
                            ItemStack[] matrix = event.getInventory().getMatrix();

                            for (ItemStack item : matrix) {
                                if (RSVItem.isRSVItem(item)) {
                                    event.getInventory().setResult(null);
                                    break;
                                }
                            }
                        }
                        default -> {}
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSmithing(PrepareSmithingEvent event) {
        SmithingInventory inv = event.getInventory();

        if (Utils.isNetheriteRecipe(inv)) {
            ItemStack base = inv.getItem(0);

            if (RSVItem.isRSVItem(base)) {
                String rsvName = RSVItem.getNameFromItem(base);
                switch (rsvName) {
                    case "diamond_rapier", "diamond_greatsword", "diamond_longsword", "diamond_spear"
                            , "diamond_saber", "diamond_boomerang", "diamond_dagger", "diamond_glaive", "diamond_halberd"
                            , "diamond_hammer", "diamond_javelin", "diamond_lance", "diamond_mace", "diamond_pike"
                            , "diamond_quarterstaff", "diamond_tomahawk", "diamond_throwing_knife", "diamond_warhammer"
                            , "diamond_battleaxe", "diamond_longbow", "diamond_crossbow", "diamond_knife", "diamond_saw", "diamond_mattock" -> {
                        FileConfiguration userConfig = RSVModule.getModule(RSVItem.getModuleNameFromItem(base)).getUserConfig().getConfig();

                        if (userConfig.getBoolean("Recipes." + rsvName + ".Enabled.EnableAllVersions"))
                            event.setResult(RealisticSurvivalPlugin.getUtil().getNetheriteRSVWeapon(base));
                        else {
                            if (userConfig.contains("Recipes." + rsvName + ".Enabled.Versions." + RealisticSurvivalPlugin.getUtil().getMinecraftVersion())) {
                                if (userConfig.getBoolean("Recipes." + rsvName + ".Enabled.Versions." + RealisticSurvivalPlugin.getUtil().getMinecraftVersion()))
                                    event.setResult(RealisticSurvivalPlugin.getUtil().getNetheriteRSVWeapon(base));
                                else
                                    event.setResult(null);
                            }
                            else
                                event.setResult(null);
                        }
                    }
                    default -> {
                        event.setResult(null);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDurability(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();

        if (!event.isCancelled()) {
            if (RSVItem.isRSVItem(item)) {
                Utils.changeDurability(item, -event.getDamage(), true);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onIncrementStatistics(PlayerStatisticIncrementEvent event) {
        if (!event.isCancelled()) {
            if (event.getStatistic() == Statistic.JUMP) {
                Player player = event.getPlayer();
                Location loc = player.getLocation(); // get the player's location
                Block block = loc.getBlock(); // get the block at that location

                Material blockMaterial = block.getType(); // get the material of the block
                if (!Tag.CLIMBABLE.isTagged(blockMaterial)) {
                    if (!(block.isLiquid() || player.isRiptiding() || player.isFlying() || player.isSwimming())) {
                        Bukkit.getServer().getPluginManager().callEvent(new PlayerJumpEvent(event.getPlayer()));
                    }
                }
            }
        }
    }

    /**
     * Adds anvil recipes
     * @param event The event called when a player adds items inside an anvil
     * @see Utils
     */
    @EventHandler
    public void onAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory(); // get the anvil inventory
        String worldName = event.getView().getPlayer().getWorld().getName();
        Set<String> allowedWorlds;
        Set<RSVAnvilRecipe> anvilRecipes;

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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBrew(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();

        if (!(inv == null || inv.getType() != InventoryType.BREWING)) {
            if ((event.getClick() == ClickType.LEFT || event.getClick() == ClickType.RIGHT)) {
                ItemStack is = event.getCurrentItem(); // GETS ITEMSTACK THAT IS BEING CLICKED
                ItemStack is2 = event.getCursor(); // GETS CURRENT ITEMSTACK HELD ON MOUSE

                if (event.getClick() == ClickType.RIGHT && is.isSimilar(is2)) {
                    return;
                }

                event.setCancelled(true);

                Player p = (Player)(event.getView().getPlayer());

                boolean compare = is.isSimilar(is2);
                ClickType type = event.getClick();

                int firstAmount = is.getAmount();
                int secondAmount = is2.getAmount();

                int stack = is.getMaxStackSize();
                int half = firstAmount / 2;

                int clickedSlot = event.getSlot();

                if (type == ClickType.LEFT) {

                    if (is == null || (is != null && is.getType() == Material.AIR)) {

                        p.setItemOnCursor(is);
                        inv.setItem(clickedSlot, is2);

                    } else if (compare) {

                        int used = stack - firstAmount;
                        if (secondAmount <= used) {

                            is.setAmount(firstAmount + secondAmount);
                            p.setItemOnCursor(null);

                        } else {

                            is2.setAmount(secondAmount - used);
                            is.setAmount(firstAmount + used);
                            p.setItemOnCursor(is2);

                        }

                    } else if (!compare) {

                        inv.setItem(clickedSlot, is2);
                        p.setItemOnCursor(is);

                    }

                } else if (type == ClickType.RIGHT) {

                    if (is == null || (is != null && is.getType() == Material.AIR)) {

                        p.setItemOnCursor(is);
                        inv.setItem(clickedSlot, is2);

                    } else if ((is != null && is.getType() != Material.AIR) &&
                            (is2 == null || (is2 != null && is2.getType() == Material.AIR))) {

                        ItemStack isClone = is.clone();
                        isClone.setAmount(is.getAmount() % 2 == 0 ? firstAmount - half : firstAmount - half - 1);
                        p.setItemOnCursor(isClone);

                        is.setAmount(firstAmount - half);

                    } else if (compare) {

                        if ((firstAmount + 1) <= stack) {

                            is2.setAmount(secondAmount - 1);
                            is.setAmount(firstAmount + 1);

                        }

                    } else if (!compare) {

                        inv.setItem(clickedSlot, is2);
                        p.setItemOnCursor(is);
                    }

                }

                if (((BrewerInventory) inv).getIngredient() != null) {
                    String worldName = event.getView().getPlayer().getWorld().getName();
                    Set<String> allowedWorlds;
                    Set<RSVBrewingRecipe> brewingRecipes;

                    for (RSVModule module : RSVModule.getModules().values()) {
                        allowedWorlds = module.getAllowedWorlds();
                        if (allowedWorlds.contains(worldName)) {
                            brewingRecipes = module.getModuleRecipes().getBrewingRecipes();
                            for (RSVBrewingRecipe recipe : brewingRecipes) {
                                if (recipe.isValidRecipe((BrewerInventory) inv)) {
                                    recipe.startBrewing((BrewerInventory) inv);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
