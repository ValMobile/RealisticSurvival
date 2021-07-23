package me.val_mobile.no_tree_punching;

import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomItems;
import me.val_mobile.utils.Recipes;
import me.val_mobile.utils.Utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class NoTreePunching implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (Recipe r : Recipes.getNtrRecipes()) {
            if (r instanceof ShapedRecipe) {
                player.discoverRecipe(((ShapedRecipe) r).getKey());
            }
            else if (r instanceof ShapelessRecipe) {
                player.discoverRecipe(((ShapelessRecipe) r).getKey());
            }
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            Block block = event.getBlock();
            Material material = block.getType();

            if (CustomConfig.getNoTreePunchingConfig().getStringList("WoodBlocks").contains(material.toString())) {
                if (!Utils.isHoldingAxe(player)) {
                    event.setDropItems(false);
                }
            }

            if (CustomConfig.getNoTreePunchingConfig().getStringList("GrassBlocks").contains(material.toString())) {
                if (Utils.isHoldingKnife(player)) {
                    Random r = new Random();
                    double chance = CustomConfig.getNoTreePunchingConfig().getDouble("PlantFiber.DropChance");
                    if (CustomConfig.getNoTreePunchingConfig().getBoolean("PlantFiber.CheckLooting")) {
                        ItemMeta meta = itemMainHand.getItemMeta();
                        if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                            int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                            chance += lootingLvl * 0.01;
                        }
                    }
                    if (r.nextDouble() <= chance) {
                        block.getWorld().dropItemNaturally(block.getLocation(), CustomItems.getPlantFiber());
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (Utils.isItemReal(event.getItem())) {
            if (event.getItem().isSimilar(new ItemStack(Material.FLINT))) {
                if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    if (event.getClickedBlock().getType() == Material.STONE) {

                        Player player = event.getPlayer();
                        Block block = event.getClickedBlock();
                        Random r = new Random();

                        if (r.nextDouble() <= CustomConfig.getNoTreePunchingConfig().getDouble("FlintShard.DropChance")) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            if (itemMainHand.getAmount() != 1) {
                                itemMainHand.setAmount(itemMainHand.getAmount() - 1);
                            }
                            else {
                                player.getInventory().setItemInMainHand(null);
                            }

                            block.getWorld().dropItemNaturally(block.getLocation().add(0.0D, 0.6D, 0.0D), CustomItems.getFlintShard());
                        }
                        player.playSound(player.getLocation(), Sound.BLOCK_STONE_HIT, 1, 1);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemDurabilityDamage(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();
        ItemMeta meta = item.getItemMeta();

        ((Damageable) meta).setDamage(0);

        if (meta.equals(CustomItems.getFlintAxe().getItemMeta()) ||
                meta.equals(CustomItems.getFlintKnife().getItemMeta()) ||
                meta.equals(CustomItems.getFlintHoe().getItemMeta()) ||
                meta.equals(CustomItems.getFlintShovel().getItemMeta())) {
            int newDamage = (int) Math.round(event.getDamage() * CustomConfig.getNoTreePunchingConfig().getDouble("DurabilityDamageMultiplier"));

            event.setDamage(newDamage);
        }
    }
}
