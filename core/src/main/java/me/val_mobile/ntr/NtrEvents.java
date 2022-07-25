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
package me.val_mobile.ntr;

import jdk.jshell.ImportSnippet;
import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class NtrEvents extends ModuleEvents implements Listener {

    private final ModuleItems moduleItems;
    private final Utils util;
    private final RSVModule module;

    public NtrEvents(RSVModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.module = module;
        this.moduleItems = module.getModuleItems();
        util = new Utils(plugin);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            FileConfiguration config = module.getUserConfig().getConfig();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            Block block = event.getBlock();
            Material material = block.getBlockData().getMaterial();

            if (config.getStringList("WoodBlocks").contains(material.toString())) {
                if (!Utils.isHoldingAxe(player)) {
                    event.setDropItems(false);
                }
            }

            if (config.getStringList("PlantFiber.Blocks").contains(material.toString())) {
                if (RSVItem.isRSVItem(itemMainHand, util)) {
                    String name = RSVItem.getNameFromItem(itemMainHand, util);

                    if (name.contains("dagger") || name.contains("knife")) {
                        if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                            if (config.getConfigurationSection("Items.plant_fiber.BlockDrops").getKeys(false).contains(material.toString())) {
                                ItemStack plantFiber = moduleItems.getItems().get("plant_fiber");

                                double chance = config.getDouble("Items.flint_shard.BlockDrops." + material + ".Chance");
                                Utils.DROP_TYPE dropType = Utils.DROP_TYPE.valueOf(config.getString("Items.plant_fiber.BlockDrops." + material + ".Type").toUpperCase());
                                Utils.harvestLooting(chance, plantFiber, dropType, null, block.getLocation().add(0D, 0D, 0D));

                                player.playSound(player.getLocation(), "knapping", 1f, 1f);
                            }

                            if (Utils.decrementDurability(itemMainHand, 1))
                                player.getInventory().setItemInMainHand(null);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            FileConfiguration config = module.getUserConfig().getConfig();

            if (Utils.isItemReal(event.getItem())) {
                if (event.getItem().isSimilar(new ItemStack(Material.FLINT))) {
                    if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        Block block = event.getClickedBlock();
                        Material material = block.getBlockData().getMaterial();

                        if (config.getConfigurationSection("Items.flint_shard.BlockDrops").getKeys(false).contains(material.toString())) {
                            ItemStack flintShard = moduleItems.getItems().get("flint_shard");

                            double chance = config.getDouble("Items.flint_shard.BlockDrops." + material + ".Chance");
                            Utils.DROP_TYPE dropType = Utils.DROP_TYPE.valueOf(config.getString("Items.flint_shard.BlockDrops." + material + ".Type").toUpperCase());
                            Utils.harvestLooting(chance, flintShard, dropType, null, block.getLocation().add(0D, 0D, 0D));

                            player.playSound(player.getLocation(), "knapping", 1f, 1f);
                        }
                    }
                }
            }
        }
    }
}