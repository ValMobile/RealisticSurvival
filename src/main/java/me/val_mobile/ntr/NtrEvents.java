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

import me.val_mobile.data.RSVFiles;
import me.val_mobile.data.ModuleEvents;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
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

import java.util.SplittableRandom;

public class NtrEvents extends ModuleEvents implements Listener {

    private final CustomItems customItems;
    private final RealisticSurvivalPlugin plugin;
    private final Utils util;
    public NtrEvents(RealisticSurvivalPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
        customItems = new CustomItems(plugin);
        util = new Utils(plugin);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "NoTreePunching")) {
            FileConfiguration config = RSVFiles.getNtrUserConfig();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            Block block = event.getBlock();
            Material material = block.getBlockData().getMaterial();

            if (config.getStringList("WoodBlocks").contains(material.toString())) {
                if (!Utils.isHoldingAxe(player)) {
                    event.setDropItems(false);
                }
            }

            if (config.getStringList("PlantFiber.Blocks").contains(material.toString())) {
                if (util.isHoldingKnife(player)) {
                    if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                        double chance = config.getDouble("PlantFiber.DropChance");
                        Utils.harvestLooting(chance, customItems.getPlantFiber(), false, itemMainHand, block.getLocation());

                        if (Utils.decrementDurability(itemMainHand))
                            player.getInventory().setItemInMainHand(null);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "NoTreePunching")) {
            FileConfiguration config = RSVFiles.getNtrUserConfig();

            if (Utils.isItemReal(event.getItem())) {
                if (event.getItem().isSimilar(new ItemStack(Material.FLINT))) {
                    if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        if (event.getClickedBlock().getBlockData().getMaterial() == Material.STONE) {

                            Block block = event.getClickedBlock();
                            SplittableRandom r = new SplittableRandom();

                            if (r.nextDouble() <= config.getDouble("FlintShard.DropChance")) {
                                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                                if (itemMainHand.getAmount() != 1) {
                                    itemMainHand.setAmount(itemMainHand.getAmount() - 1);
                                } else {
                                    player.getInventory().setItemInMainHand(null);
                                }

                                block.getWorld().dropItemNaturally(block.getLocation().add(0.0D, 0.6D, 0.0D), customItems.getFlintShard());
                            }
                            player.playSound(player.getLocation(), Sound.BLOCK_STONE_HIT, 1, 1);
                        }
                    }
                }
            }
        }
    }
}