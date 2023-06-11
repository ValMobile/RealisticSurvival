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
package me.val_mobile.data;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import me.val_mobile.utils.recipe.RSVAnvilRecipe;
import me.val_mobile.utils.recipe.RSVBrewingRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.inventory.*;
import org.bukkit.plugin.PluginManager;

import java.io.IOException;
import java.util.Collection;
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

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockDrop(BlockBreakEvent event) {
        if (!event.isCancelled()) {
            Block block = event.getBlock();
            String mat = block.getType().toString();
            if (shouldEventBeRan(block.getWorld())) {
                ItemStack itemMainHand = event.getPlayer().getInventory().getItemInMainHand();

                ConfigurationSection blockDrops = config.getConfigurationSection("BlockDrops");

                if (blockDrops != null) {
                    if (blockDrops.getKeys(false).contains(mat)) {
                        Set<String> drops = blockDrops.getConfigurationSection(mat).getKeys(false);

                        for (String drop : drops) {
                            boolean conditionsMet = true;
                            boolean checkTool = blockDrops.getBoolean(mat + "." + drop + ".RequireRightTool");
                            boolean checkSilkTouch = !blockDrops.getBoolean(mat + "." + drop + ".IgnoreSilkTouchEnchant");

                            if (checkTool || checkSilkTouch) {
                                if (checkTool && checkSilkTouch) {
                                    conditionsMet = Utils.isBestTool(block, itemMainHand) && Utils.hasSilkTouch(itemMainHand);
                                }
                                else if (checkTool) {
                                    conditionsMet = Utils.isBestTool(block, itemMainHand);
                                }
                                else {
                                    conditionsMet = Utils.hasSilkTouch(itemMainHand);
                                }
                            }

                            if (conditionsMet) {
                                if (config.getBoolean("BlockDrops." + mat + "." + drop + ".ReplaceDefaultDrop")) {
                                    event.setDropItems(false);
                                }

                                Utils.dropFortune(config.getConfigurationSection("BlockDrops." + mat + "." + drop), RSVItem.getItem(drop), itemMainHand, block.getLocation());
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onMobDrop(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (shouldEventBeRan(entity)) {
            ConfigurationSection mobDrops = config.getConfigurationSection("MobDrops");

            if (mobDrops != null) {
                Set<String> mobKeys = mobDrops.getKeys(false);

                if (mobKeys.contains(entity.getType().toString())) {
                    if (entity.getType().toString() != null) {
                        ConfigurationSection section = config.getConfigurationSection("MobDrops." + entity.getType());
                        Set<String> itemKeys = section.getKeys(false);

                        ItemStack tool = entity.getKiller() == null ? null : entity.getKiller().getInventory().getItemInMainHand();

                        for (String item : itemKeys) {
                            if (RSVItem.isRSVItem(item))
                                Utils.dropLooting(section.getConfigurationSection(item), RSVItem.getItem(item), tool, entity.getLocation(), true);
                        }
                    }
                }
            }

        }
    }

    @EventHandler
    public void onAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory(); // get the anvil inventory
        Set<RSVAnvilRecipe> anvilRecipes = module.getModuleRecipes().getAnvilRecipes();

        if (shouldEventBeRan(event.getView().getPlayer())) {
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
                    if (shouldEventBeRan(player.getWorld())) {
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
                            Set<RSVBrewingRecipe> brewingRecipes = module.getModuleRecipes().getBrewingRecipes();

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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRecipeCraftCancel(PrepareItemCraftEvent event) {
        Player player = (Player) event.getView().getPlayer();

        if (!shouldEventBeRan(player)) {
            if (event.getRecipe() instanceof Keyed keyed) {
                if (module.getModuleRecipes().getRecipeKeys().contains(keyed.getKey())) {
                    event.getInventory().setResult(null);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRecipeBurn(FurnaceBurnEvent event) {
        if (!shouldEventBeRan(event.getBlock().getWorld())) {
            FurnaceInventory inv = ((Furnace) event.getBlock().getState()).getSnapshotInventory();
            ItemStack smeltedItem = inv.getSmelting();

            if (Utils.isItemReal(smeltedItem)) {

            }
        }
    }



    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRecipeDiscover(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        if (shouldEventBeRan(event.getPlayer())) {
            if (!shouldEventBeRan(event.getFrom())) {
                Collection<NamespacedKey> keys = module.getModuleRecipes().getRecipeKeys();

                for (NamespacedKey key : keys) {
                    if (config.getBoolean("Recipes." + key.getKey() + ".Unlock")) {
                        Utils.discoverRecipe(player, Bukkit.getRecipe(key));
                    }
                }
            }
        }
        else {
            if (shouldEventBeRan(event.getFrom())) {
                player.undiscoverRecipes(module.getModuleRecipes().getRecipeKeys());
            }
        }
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent event) {
        String name = event.getWorld().getName();

        if (!module.getAllowedWorlds().contains(name)) {
            FileConfiguration pluginConfig = plugin.getConfig();
            String path = module.getName() + ".Worlds." + name;

            if (!pluginConfig.contains(path)) {
                pluginConfig.createSection(path);
                pluginConfig.set(path, true);
                module.getAllowedWorlds().add(name);

                try {
                    pluginConfig.save(plugin.getConfigFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        String name = event.getWorld().getName();

        if (!module.getAllowedWorlds().contains(name)) {
            FileConfiguration pluginConfig = plugin.getConfig();
            String path = module.getName() + ".Worlds." + name;

            if (!pluginConfig.contains(path)) {
                pluginConfig.createSection(path);
                pluginConfig.set(path, true);
                module.getAllowedWorlds().add(name);

                try {
                    pluginConfig.save(plugin.getConfigFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void onWorldUnload(WorldUnloadEvent event) {
        String name = event.getWorld().getName();

        if (!module.getAllowedWorlds().contains(name)) {
            FileConfiguration pluginConfig = plugin.getConfig();
            String path = module.getName() + ".Worlds." + name;

            if (!pluginConfig.contains(path)) {
                pluginConfig.createSection(path);
                pluginConfig.set(path, true);
                module.getAllowedWorlds().add(name);

                try {
                    pluginConfig.save(plugin.getConfigFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void onWorldSave(WorldSaveEvent event) {
        String name = event.getWorld().getName();

        if (!module.getAllowedWorlds().contains(name)) {
            FileConfiguration pluginConfig = plugin.getConfig();
            String path = module.getName() + ".Worlds." + name;

            if (!pluginConfig.contains(path)) {
                pluginConfig.createSection(path);
                pluginConfig.set(path, true);
                module.getAllowedWorlds().add(name);

                try {
                    pluginConfig.save(plugin.getConfigFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean shouldEventBeRan(Entity e) {
        if (e == null) {
            return false;
        }
        return module.getAllowedWorlds().contains(e.getWorld().getName());
    }

    public boolean shouldEventBeRan(World world) {
        if (world == null) {
            return false;
        }
        return module.getAllowedWorlds().contains(world.getName());
    }

    public RSVModule getModule() {
        return module;
    }

}
