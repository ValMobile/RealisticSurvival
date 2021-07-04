package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
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
    private final CustomConfig customConfig;
    public NoTreePunching(RLCraft instance) {
        citem = new Items(instance);
        customConfig = new CustomConfig(instance);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        Material material = event.getBlock().getType();
        switch (material) {
            case OAK_LOG:
            case OAK_WOOD:
            case STRIPPED_OAK_LOG:
            case STRIPPED_OAK_WOOD:
            case BIRCH_LOG:
            case BIRCH_WOOD:
            case STRIPPED_BIRCH_LOG:
            case STRIPPED_BIRCH_WOOD:
            case SPRUCE_LOG:
            case SPRUCE_WOOD:
            case STRIPPED_SPRUCE_LOG:
            case STRIPPED_SPRUCE_WOOD:
            case DARK_OAK_LOG:
            case DARK_OAK_WOOD:
            case STRIPPED_DARK_OAK_LOG:
            case STRIPPED_DARK_OAK_WOOD:
            case ACACIA_LOG:
            case ACACIA_WOOD:
            case STRIPPED_ACACIA_LOG:
            case STRIPPED_ACACIA_WOOD:
            case JUNGLE_LOG:
            case JUNGLE_WOOD:
            case STRIPPED_JUNGLE_LOG:
            case STRIPPED_JUNGLE_WOOD:
            case CRIMSON_STEM:
            case CRIMSON_HYPHAE:
            case STRIPPED_CRIMSON_STEM:
            case STRIPPED_CRIMSON_HYPHAE:
            case WARPED_STEM:
            case WARPED_HYPHAE:
            case STRIPPED_WARPED_STEM:
            case STRIPPED_WARPED_HYPHAE: {
                if (! (itemMainHand == null || itemMainHand.getType().equals(Material.AIR)) ) {
                    switch (itemMainHand.getType()) {
                        case WOODEN_AXE:
                        case STONE_AXE:
                        case IRON_AXE:
                        case GOLDEN_AXE:
                        case DIAMOND_AXE:
                        case NETHERITE_AXE: {
                            event.setDropItems(false);
                        }
                    }
                }
                else {
                    event.setDropItems(false);
                }
            }
            case TALL_GRASS:
            case GRASS: {
                if (! (itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
                    NBTItem nbti = new NBTItem(itemMainHand);
                    if (nbti.hasKey("Spartan's Weapon")) {
                        if (nbti.getString("Spartan's Weapon").equals("Dagger") ||  nbti.getString("Spartan's Weapon").equals("Throwing Knife")) {
                            Random r = new Random();
                            double chance = customConfig.getNoTreePunchingConfig().getDouble("PlantFiber.DropChance");
                            if (customConfig.getNoTreePunchingConfig().getBoolean("PlantFiber.checkLooting")) {
                                ItemMeta meta = itemMainHand.getItemMeta();
                                if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                    int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                    chance += lootingLvl * 0.01;
                                }
                            }
                            if (r.nextDouble() <= chance) {
                                event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), citem.getPlantFiber());
                            }
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

                        if (r.nextDouble() <= customConfig.getNoTreePunchingConfig().getDouble("FlintShard.DropChance")) {
                            Player player = event.getPlayer();
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            if (itemMainHand.getAmount() != 1) {
                                itemMainHand.setAmount(itemMainHand.getAmount() - 1);
                            }
                            else {
                                player.getInventory().setItemInMainHand(null);
                            }

                            event.getClickedBlock().getWorld().dropItemNaturally(
                                    event.getClickedBlock().getLocation().add(0.0D, 0.6D, 0.0D), citem.getFlintShard());
                        }
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_STONE_HIT, 1, 1);
                    }
                }
            }
        }

    }
}
