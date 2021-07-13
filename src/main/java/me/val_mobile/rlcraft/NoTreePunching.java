package me.val_mobile.rlcraft;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
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

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        Material material = event.getBlock().getType();

        if (Utils.isWooden(material)) {
            if (!Utils.isHoldingAxe(player)) {
                event.setDropItems(false);
            }
        }
        else if (Utils.isGrass(material)) {
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
                    event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), CustomItems.getPlantFiber());
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

                        if (r.nextDouble() <= CustomConfig.getNoTreePunchingConfig().getDouble("FlintShard.DropChance")) {
                            Player player = event.getPlayer();
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            if (itemMainHand.getAmount() != 1) {
                                itemMainHand.setAmount(itemMainHand.getAmount() - 1);
                            }
                            else {
                                player.getInventory().setItemInMainHand(null);
                            }

                            event.getClickedBlock().getWorld().dropItemNaturally(
                                    event.getClickedBlock().getLocation().add(0.0D, 0.6D, 0.0D), CustomItems.getFlintShard());
                        }
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_STONE_HIT, 1, 1);
                    }
                }
            }
        }

    }
}
