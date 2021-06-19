package me.val_mobile.minorities_smp_extras;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class NoTreePunching implements Listener {

    private final Items citem;
    public NoTreePunching(Main instance) {
        citem = new Items(instance);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Material material = event.getBlock().getType();
        if (material == Material.OAK_LOG ||
                material == Material.OAK_WOOD ||
                material == Material.STRIPPED_OAK_LOG ||
                material == Material.STRIPPED_OAK_WOOD ||
                material == Material.BIRCH_LOG ||
                material == Material.BIRCH_WOOD ||
                material == Material.STRIPPED_BIRCH_LOG ||
                material == Material.STRIPPED_BIRCH_WOOD ||
                material == Material.SPRUCE_LOG ||
                material == Material.SPRUCE_WOOD ||
                material == Material.STRIPPED_SPRUCE_LOG ||
                material == Material.STRIPPED_SPRUCE_WOOD ||
                material == Material.DARK_OAK_LOG ||
                material == Material.DARK_OAK_WOOD ||
                material == Material.STRIPPED_DARK_OAK_LOG ||
                material == Material.STRIPPED_DARK_OAK_WOOD ||
                material == Material.ACACIA_LOG ||
                material == Material.ACACIA_WOOD ||
                material == Material.STRIPPED_ACACIA_LOG ||
                material == Material.STRIPPED_ACACIA_WOOD ||
                material == Material.JUNGLE_LOG ||
                material == Material.JUNGLE_WOOD ||
                material == Material.STRIPPED_JUNGLE_LOG ||
                material == Material.STRIPPED_JUNGLE_WOOD ||
                material == Material.CRIMSON_STEM ||
                material == Material.CRIMSON_HYPHAE ||
                material == Material.STRIPPED_CRIMSON_STEM ||
                material == Material.STRIPPED_CRIMSON_HYPHAE ||
                material == Material.WARPED_STEM ||
                material == Material.WARPED_HYPHAE ||
                material == Material.STRIPPED_WARPED_STEM ||
                material == Material.STRIPPED_WARPED_HYPHAE
        ) {
            if (! (event.getPlayer().getInventory().getItemInMainHand() == null ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) ) {
                if (!(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.WOODEN_AXE) ||
                        event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STONE_AXE) ||
                        event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.IRON_AXE) ||
                        event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_AXE) ||
                        event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_AXE) ||
                        event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_AXE))) {
                    event.setDropItems(false);
                }
            }
            else {
                event.setDropItems(false);
            }

        }
        else if (material == Material.TALL_GRASS || material == Material.GRASS) {
            if (! (event.getPlayer().getInventory().getItemInMainHand() == null || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR)) {
                ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();

                if (item.getType() == Material.WOODEN_SWORD || item.getType() == Material.STONE_SWORD || item.getType() == Material.IRON_SWORD
                        || item.getType() == Material.GOLDEN_SWORD || item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.NETHERITE_SWORD) {
                    if (meta.getCustomModelData() == 83650 ||
                            meta.getCustomModelData() == 1200006 ||
                            meta.getCustomModelData() == 1000006 ||
                            meta.getCustomModelData() == 1000016 ||
                            meta.getCustomModelData() == 4000006) {

                        Random r = new Random();
                        Double num = r.nextDouble() * 100;
                        if (num <= 25.0) {
                            event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), citem.getPlantFiber());
                        }

                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (! (event.getItem() == null || event.getItem().getType() == Material.AIR) ) {
            if (event.getItem().getType() == Material.FLINT) {
                if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    if (event.getClickedBlock().getType() == Material.STONE) {

                        Random r = new Random();
                        Double num = r.nextDouble() * 100;

                        if (num <= 30.0) {
                            Player player = event.getPlayer();
                            if (player.getInventory().getItemInMainHand().getAmount() != 1) {
                                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                            }
                            else {
                                player.getInventory().setItemInMainHand(null);
                            }

                            event.getClickedBlock().getWorld().dropItemNaturally(
                                    event.getClickedBlock().getLocation().add(0.0D, 0.6D, 0.0D), citem.getFlintShard());
                        }
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_STONE_HIT, 3, 1);
                    }
                }
            }
        }

    }
}
