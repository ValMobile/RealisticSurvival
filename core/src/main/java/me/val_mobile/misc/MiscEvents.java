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

    private final RealisticSurvivalPlugin plugin;

    public MiscEvents(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

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
                    default -> event.setResult(null);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDurability(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();

        if (!event.isCancelled()) {
            if (RSVItem.isRSVItem(item)) {
                if (RSVItem.hasCustomDurability(item)) {
                    Utils.changeDurability(item, -event.getDamage(), true);
                }
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
        boolean ran = false;

        for (RSVModule module : RSVModule.getModules().values()) {
            allowedWorlds = module.getAllowedWorlds();
            if (allowedWorlds.contains(worldName)) {
                anvilRecipes = module.getModuleRecipes().getAnvilRecipes();
                for (RSVAnvilRecipe recipe : anvilRecipes) {
                    if (recipe.isValidRecipe(inv)) {
                        recipe.useRecipe(event);
                        ran = true;
                        break;
                    }
                }
            }
        }

        if (!ran) {
            anvilRecipes = plugin.getMiscRecipes().getAnvilRecipes();
            for (RSVAnvilRecipe recipe : anvilRecipes) {
                if (recipe.isValidRecipe(inv)) {
                    recipe.useRecipe(event);
                    break;
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBrew(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();

        if (inv instanceof BrewerInventory brewInv) {
            ClickType click = event.getClick();
            if (click == ClickType.LEFT || click == ClickType.RIGHT) {
                ItemStack current = event.getCurrentItem(); // GETS ITEMSTACK THAT IS BEING CLICKED
                ItemStack cursor = event.getCursor(); // GETS CURRENT ITEMSTACK HELD ON MOUSE

                if (!(click == ClickType.RIGHT && current.isSimilar(cursor))) {
                    Player player = (Player) event.getView().getPlayer();

                    boolean compare = current.isSimilar(cursor);
                    ClickType type = event.getClick();

                    int currentAmount = current.getAmount();
                    int cursorAmount = cursor.getAmount();

                    int stack = current.getMaxStackSize();
                    int half = currentAmount / 2;

                    int clickedSlot = event.getSlot();

                    if (type == ClickType.LEFT) {
                        if (!Utils.isItemReal(current)) {
                            player.setItemOnCursor(current);
                            inv.setItem(clickedSlot, cursor);
                        }
                        else if (compare) {
                            int used = stack - currentAmount;
                            if (cursorAmount <= used) {
                                current.setAmount(currentAmount + cursorAmount);
                                player.setItemOnCursor(null);
                            }
                            else {
                                cursor.setAmount(cursorAmount - used);
                                current.setAmount(currentAmount + used);
                                player.setItemOnCursor(cursor);
                            }
                        }
                        else {
                            inv.setItem(clickedSlot, cursor);
                            player.setItemOnCursor(current);
                        }
                    }
                    else {
                        if (!Utils.isItemReal(current)) {
                            player.setItemOnCursor(current);
                            inv.setItem(clickedSlot, cursor);
                        }
                        else if (Utils.isItemReal(current) && !Utils.isItemReal(cursor)) {
                            ItemStack isClone = current.clone();
                            isClone.setAmount(current.getAmount() % 2 == 0 ? currentAmount - half : currentAmount - half - 1);
                            player.setItemOnCursor(isClone);

                            current.setAmount(currentAmount - half);
                        }
                        else if (compare) {
                            if ((currentAmount + 1) <= stack) {
                                cursor.setAmount(cursorAmount - 1);
                                current.setAmount(currentAmount + 1);
                            }
                        }
                        else {
                            inv.setItem(clickedSlot, cursor);
                            player.setItemOnCursor(current);
                        }
                    }

                    if (brewInv.getIngredient() != null) {
                        String worldName = player.getWorld().getName();
                        Set<String> allowedWorlds;
                        Set<RSVBrewingRecipe> brewingRecipes;

                        boolean ran = false;

                        for (RSVModule module : RSVModule.getModules().values()) {
                            allowedWorlds = module.getAllowedWorlds();
                            if (allowedWorlds.contains(worldName)) {
                                brewingRecipes = module.getModuleRecipes().getBrewingRecipes();
                                for (RSVBrewingRecipe recipe : brewingRecipes) {
                                    if (recipe.isValidRecipe(brewInv)) {
                                        recipe.startBrewing(brewInv);
                                        ran = true;
                                        break;
                                    }
                                }
                            }
                        }

                        if (!ran) {
                            brewingRecipes = plugin.getMiscRecipes().getBrewingRecipes();
                            for (RSVBrewingRecipe recipe : brewingRecipes) {
                                if (recipe.isValidRecipe(brewInv)) {
                                    recipe.startBrewing(brewInv);
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
