package me.val_mobile.baubles;

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;
/**
 * BaubleEvents is a class containing listener methods
 * that activate abilities on entities
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class BaubleEvents implements Listener {

    /**
     * Dependency injecting the main and util class for use
     * The util class must be injected because its non-static methods are needed
     */
    private final RLCraft plugin;
    private final BaubleRunnables baubleRunnables;

    // constructing the BaubleEvents class
    public BaubleEvents(RLCraft instance) {
        plugin = instance;
        baubleRunnables = new BaubleRunnables(instance);
    }

    /**
     * Inputs data into static fields and gives players the recipes to craft baubles
     * @param event The event called when a player joins the server
     * @see PlayerRunnable
     * @see Utils
     * @see Recipes
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer(); // get the player

        // create new values in the static hashmaps
        BaubleRunnables.resetBaubleMaps(player);
        BaubleRunnables.updateBaubleValues(player);

        // start every bauble runnable
        baubleRunnables.startPrResRunnable(player);
        baubleRunnables.startPrStrengthRunnable(player);
        baubleRunnables.startPrSpeedRunnable(player);
        baubleRunnables.startPrJumpRunnable(player);
        baubleRunnables.startPrHasteRunnable(player);
        baubleRunnables.startPrRegenRunnable(player);

        baubleRunnables.startScarliteRingRunnable(player);
        baubleRunnables.startDragonsEyeRunnable(player);
        baubleRunnables.startMinersRingRunnable(player);
        baubleRunnables.startShieldHonorRunnable(player);

        // give the player every bauble recipe
        for (Recipe r : Recipes.getBaubleRecipes()) {
            // if the recipe has a pre-defined shape
            if (r instanceof ShapedRecipe) {
                // cast the recipe to a ShapedRecipe and let the player discover it
                player.discoverRecipe(((ShapedRecipe) r).getKey());
            }
            // if the recipe has no shape
            else if (r instanceof ShapelessRecipe) {
                // cast the recipe to a ShapelessRecipe and let the player discover it
                player.discoverRecipe(((ShapelessRecipe) r).getKey());
            }
        }
    }

    /**
     * Sets the amount of baubles in the static hashmaps to 0 when he/she dies
     * @param event The event called when a player dies
     * @see PlayerRunnable
     * @see Utils
     */
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        // set all the bauble values of the target player to 0
        BaubleRunnables.resetBaubleMaps(event.getEntity());
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player picks up a bauble
     * @param event The event called when a player picks up an item
     * @see PlayerRunnable
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        // if the event is active
        if (!event.isCancelled()) {
            LivingEntity entity = event.getEntity(); // get the entity that picked up the item

            // if the entity is a player
            if (entity instanceof Player) {
                Player player = (Player) entity; // cast the entity to a player
                ItemStack item = event.getItem().getItemStack(); // get the item that was picked up

                // if the item exists
                if (Utils.isItemReal(item)) {
                    NBTItem nbtItem = new NBTItem(item); // get the nbt version of the item to check for nbt tags

                    // if the item has an nbt tag called "Bauble"
                    if (nbtItem.hasKey("Bauble")) {
                        // check the string value of the tag and update accordingly
                        switch (nbtItem.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrResValues(player);
                                        baubleRunnables.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrRegenValues(player);
                                        baubleRunnables.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrStrengthValues(player);
                                        baubleRunnables.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrSpeedValues(player);
                                        baubleRunnables.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrJumpValues(player);
                                        baubleRunnables.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrHasteValues(player);
                                        baubleRunnables.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateMinersRingValues(player);
                                        baubleRunnables.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateScarliteRingValues(player);
                                        baubleRunnables.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateDragonsEyeValues(player);
                                        baubleRunnables.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateShieldHonorValues(player);
                                        baubleRunnables.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player drops a bauble
     * @param event The event called when a player drops an item
     * @see PlayerRunnable
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemDrop(PlayerDropItemEvent event) {
        // if the event is active
        if (!event.isCancelled()) {
            Player player = event.getPlayer(); // get the player
            ItemStack item = event.getItemDrop().getItemStack(); // get the item that was dropped

            // if the item exists
            if (Utils.isItemReal(item)) {
                NBTItem nbtItem = new NBTItem(event.getItemDrop().getItemStack()); // get the nbt version of the item

                // if the item has an nbt tag called "Bauble"
                if (nbtItem.hasKey("Bauble")) {
                    // check the string value of the tag and update accordingly
                    switch (nbtItem.getString("Bauble")) {
                        case "Potion Ring of Resistance":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updatePrResValues(player);
                                    baubleRunnables.startPrResRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Potion Ring of Regeneration":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updatePrRegenValues(player);
                                    baubleRunnables.startPrRegenRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Potion Ring of Strength":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updatePrStrengthValues(player);
                                    baubleRunnables.startPrStrengthRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Potion Ring of Speed":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updatePrSpeedValues(player);
                                    baubleRunnables.startPrSpeedRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Potion Ring of Jump Boost":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updatePrJumpValues(player);
                                    baubleRunnables.startPrJumpRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Potion Ring of Haste":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updatePrHasteValues(player);
                                    baubleRunnables.startPrHasteRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Miner's Ring":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updateMinersRingValues(player);
                                    baubleRunnables.startMinersRingRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Scarlite Ring":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updateScarliteRingValues(player);
                                    baubleRunnables.startScarliteRingRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Dragon's Eye":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updateDragonsEyeValues(player);
                                    baubleRunnables.startDragonsEyeRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                        case "Shield of Honor":
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    BaubleRunnables.updateShieldHonorValues(player);
                                    baubleRunnables.startShieldHonorRunnable(player);
                                }
                            }.runTaskLater(plugin, 1L);
                            break;
                    }
                }
            }
        }
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player puts a bauble
     * in his/her inventory through clicking
     * @param event The event called when a player clicks in an inventory
     * @see PlayerRunnable
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        // if the event is active
        if (!event.isCancelled()) {
            Player player = (Player) event.getWhoClicked(); // get the player

            // if the bottom half of the inventory view is the player's own inventory
            if (event.getView().getBottomInventory() instanceof PlayerInventory) {
                // if the item on the player's cursor exists
                if (Utils.isItemReal(event.getCursor())) {
                    NBTItem item = new NBTItem(event.getCursor()); // get the nbt version of the item

                    // if the item has an nbt tag called "Bauble"
                    if (item.hasKey("Bauble")) {
                        // check the string value of the tag and update accordingly
                        switch (item.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrResValues(player);
                                        baubleRunnables.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrRegenValues(player);
                                        baubleRunnables.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrStrengthValues(player);
                                        baubleRunnables.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrSpeedValues(player);
                                        baubleRunnables.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrJumpValues(player);
                                        baubleRunnables.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrHasteValues(player);
                                        baubleRunnables.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateMinersRingValues(player);
                                        baubleRunnables.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateScarliteRingValues(player);
                                        baubleRunnables.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateDragonsEyeValues(player);
                                        baubleRunnables.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateShieldHonorValues(player);
                                        baubleRunnables.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }

                }
                // if an item was placed in a slot, check if that item exists
                if (Utils.isItemReal(event.getCurrentItem())) {
                    NBTItem item = new NBTItem(event.getCurrentItem()); // get the nbt version of the item

                    // if the item has an nbt tag called "Bauble"
                    if (item.hasKey("Bauble")) {
                        // check the string value of the tag and update accordingly
                        switch (item.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrResValues(player);
                                        baubleRunnables.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrRegenValues(player);
                                        baubleRunnables.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrStrengthValues(player);
                                        baubleRunnables.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrSpeedValues(player);
                                        baubleRunnables.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrJumpValues(player);
                                        baubleRunnables.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrHasteValues(player);
                                        baubleRunnables.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateMinersRingValues(player);
                                        baubleRunnables.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateScarliteRingValues(player);
                                        baubleRunnables.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateDragonsEyeValues(player);
                                        baubleRunnables.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateShieldHonorValues(player);
                                        baubleRunnables.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player drags a bauble
     * in his/her inventory
     * @param event The event called when a player drags an item into an inventory
     * @see PlayerRunnable
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onDragClick(InventoryDragEvent event) {
        // if the event is active
        if (!event.isCancelled()) {
            // get the player
            Player player = (Player) event.getWhoClicked();

            // if the bottom half of the inventory view is the player's own inventory
            if (event.getView().getBottomInventory() instanceof PlayerInventory) {
                // if the dragged item exists
                if (Utils.isItemReal(event.getOldCursor())) {
                    NBTItem item = new NBTItem(event.getOldCursor()); // get the nbt version of the item

                    // if the item has an nbt tag called "Bauble"
                    if (item.hasKey("Bauble")) {
                        // check the string value of the tag and update accordingly
                        switch (item.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrResValues(player);
                                        baubleRunnables.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrRegenValues(player);
                                        baubleRunnables.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrStrengthValues(player);
                                        baubleRunnables.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrSpeedValues(player);
                                        baubleRunnables.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrJumpValues(player);
                                        baubleRunnables.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updatePrHasteValues(player);
                                        baubleRunnables.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateMinersRingValues(player);
                                        baubleRunnables.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateScarliteRingValues(player);
                                        baubleRunnables.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateDragonsEyeValues(player);
                                        baubleRunnables.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        BaubleRunnables.updateShieldHonorValues(player);
                                        baubleRunnables.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Activates the ender queen's crown ability if the player angers an enderman
     * while having the ender queen's crown in his/her inventory
     * @param event The event called when an entity is provoked by another entity
     * @see CustomItems
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTarget(EntityTargetEvent event) {
        // if the attacker is an enderman and the aggressor is a player
        if (event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            Player player = (Player) event.getTarget(); // get the player

            // if the player has an ender queen's crown in his/her inventory
            if (player.getInventory().containsAtLeast(CustomItems.getEnderQueensCrown(), 1))
                // stop the enderman from being hostile
                event.setCancelled(true);
        }
    }

    /**
     * Activates various offensive and defensive baubles if a player is attacked
     * while having them in his/her inventory
     * @param event The event called when an entity attacks another entity
     * @see BaubleAbilities
     * @see BaubleRunnables
     * @see CustomItems
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // if the attacker is a player
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager(); // get the player
            Entity entity = event.getEntity(); // get the attacked entity

            // if the entity is able to receive potion effects
            if (entity instanceof LivingEntity) {
                // if the player has a poison stone in his/her inventory
                if (player.getInventory().containsAtLeast(CustomItems.getPoisonStone(), 1)) {
                    // effect the entity with poison
                    BaubleAbilities.PoisonStoneAbility((LivingEntity) entity);
                }
            }

        }
        // if the attacked entity is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity(); // get the player
            ItemStack itemOffHand = player.getInventory().getItemInOffHand(); // get the item in the player's off hand

            // if the item exists
            if (Utils.isItemReal(itemOffHand)) {
                NBTItem nbtItem = new NBTItem(itemOffHand); // get the nbt version of the item

                // if the item has an nbt tag called "Bauble"
                if (nbtItem.hasKey("Bauble")) {
                    // if the item is a cobalt shield or any of its derivatives
                    switch (nbtItem.getString("Bauble")) {
                        case "Cobalt Shield":
                        case "Obsidian Shield":
                        case "Ankh Shield":
                            // set the velocity of the player to 0 to mimic anti-kb
                            BaubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
                    }
                }
            }
        }
    }

    /**
     * Activates various defensive baubles if a player is attacked
     * by certain causes
     * @param event The event called when an entity is attacked
     * @see BaubleRunnables
     * @see CustomItems
     * @see CustomConfig
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        // if the damaged entity is a player
        if (event.getEntity() instanceof Player) {
            EntityDamageEvent.DamageCause cause = event.getCause(); // get the damage cause
            Player player = (Player) event.getEntity(); // get the player
            PlayerInventory inv = player.getInventory(); // get the player's inventory
            ItemStack itemOffHand = inv.getItemInOffHand(); // get the item in the player's off hand

            NBTItem nbtItem = null; // temporarily create an nbt version of the off hand item

            // if the player has a real item in his/her off hand
            if (Utils.isItemReal(itemOffHand)) {
                // assign the off hand item to the nbt item
                nbtItem = new NBTItem(itemOffHand);
            }

            // check the cause of the damage
            switch (cause) {
                // if the damage is caused by fire
                case FIRE:
                case FIRE_TICK: {
                    // if the player has an obsidian skull
                    if (inv.containsAtLeast(CustomItems.getObsidianSkull(), 1)) {
                        // reduce the damage by a specified amount
                        event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ObsidianSkull.HeatDamageMultiplier"));
                    }
                    // if the off hand item exists
                    else if (Utils.isItemReal(itemOffHand)) {
                        // if the item has an nbt tag called "Bauble"
                        if (nbtItem.hasKey("Bauble")) {
                            // if the item is a cobalt shield
                            if (nbtItem.getString("Bauble").equals("Obsidian Shield"))
                                // reduce the damage by a specified amount
                                event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ObsidianShield.HeatDamageMultiplier"));
                            // if the item is an ankh shield
                            else if (nbtItem.getString("Bauble").equals("Ankh Shield"))
                                // reduce the damage by a specified amount
                                event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("AnkhShield.HeatDamageMultiplier"));
                        }
                    }
                }
                // if the damage is caused by an explosion
                case ENTITY_EXPLOSION:
                case BLOCK_EXPLOSION: {
                    // if the off hand item exists
                    if (Utils.isItemReal(itemOffHand)) {
                        // if the item has an nbt tag called "Bauble"
                        if (nbtItem.hasKey("Bauble")) {
                            // if the item is a cobalt shield or any of its derivatives
                            switch (nbtItem.getString("Bauble")) {
                                case "Cobalt Shield":
                                case "Obsidian Shield":
                                case "Ankh Shield":
                                    // set the velocity of the player to 0 to mimic anti-kb
                                    BaubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
                            }
                        }
                    }
                    // if the player has a shield of honor
                    if (player.getInventory().containsAtLeast(CustomItems.getShieldHonor(), 1)) {
                        // reduce the damage by a specified amount
                        event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ShieldHonor.ExplosionDamageMultiplier"));
                    }
                }
                // if the damage is caused by falling
                case FALL: {
                    // if the player has a balloon
                    if (player.getInventory().containsAtLeast(CustomItems.getBalloon(), 1))
                        // if the fall distance is less than the specified minimum fall distance
                        if (player.getFallDistance() <= CustomConfig.getBaubleConfig().getDouble("Balloon.MinFallDistance")) {
                            // cancel the event to set the fall damage to 0
                            event.setCancelled(true);
                        }
                        // if the fall distance is greater than the specified minimum fall distance
                        else {
                            // reduce the damage by a specified amount
                            event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("Balloon.FallDamageMultiplier"));
                        }
                    // if the player's inventory has a lucky horseshoe
                    if (player.getInventory().containsAtLeast(CustomItems.getLuckyHorseshoe(), 1))
                        // cancel the event to set the fall damage to 0
                        event.setCancelled(true);
                }
                // if the damage is caused by a cactus or berry bush
                case CONTACT: {
                    // if the player has a phytoprotostasia amulet
                    if (player.getInventory().containsAtLeast(CustomItems.getPhytoprostasiaAmulet(), 1))
                        // cancel the event to set the damage to 0
                        event.setCancelled(true);
                }
            }

            // if the static hashmap for the cross necklace contains the player as a key
            if (PlayerRunnable.getCrossNecklace().containsKey(player.getName())) {
                // if the player currently has extended i-frames due to having a cross necklace
                if (PlayerRunnable.getCrossNecklace().get(player.getName())) {
                    // cancel the event to set the damage to 0
                    event.setCancelled(true);
                }
            }

            // if the player has a cross necklace
            if (inv.containsAtLeast(CustomItems.getCrossNecklace(), 1)) {
                // add the player to the static hashmap
                Utils.setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), player.getName(), true);

                // remove the i-frames by setting the key of the player to false after a specified amount of time
                BaubleRunnables.removeInvFrames(player).runTaskLater(plugin, CustomConfig.getBaubleConfig().getInt("CrossNecklace.InvFrameLength"));
            }
        }
    }

    /**
     * Activates the balloon ability if a player jumps
     * @param event The event called when a player moves
     * @see CustomItems
     * @see CustomConfig
     */
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        // if the event is active
        if (!event.isCancelled()) {
            // if the player has a balloon
            if (event.getPlayer().getInventory().containsAtLeast(CustomItems.getBalloon(), 1)) {
                Player player = event.getPlayer(); // get the player
                Vector velocity = player.getVelocity(); // get the player's current velocity

                // check if the player is moving up
                if (velocity.getY() > 0)
                {
                    double jumpVelocity = 0.42; // default jump velocity

                    // if the player has the jump boost effect
                    if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                        PotionEffect jumpBoost = player.getPotionEffect(PotionEffectType.JUMP);  // get the jump boost effect

                        // add the jump boost to the velocity to factor in the increased velocity
                        jumpVelocity += ((double) jumpBoost.getAmplifier() + 1) * 0.1;
                    }

                    Location loc = player.getLocation(); // get the player's location
                    Block block = loc.getBlock(); // get the block at that location
                    Material blockMaterial = block.getType(); // get the material of the block

                    // check if the player is not climbing
                    switch (blockMaterial) {
                        case LADDER:
                        case VINE:
                        case TWISTING_VINES:
                        case TWISTING_VINES_PLANT:
                        case WEEPING_VINES:
                        case WEEPING_VINES_PLANT: {

                        }
                        default: {
                            // check if the player's jump velocity is equal to the player's Y velocity
                            if (Math.abs(velocity.getY() - jumpVelocity) <= 0.01) {
                                // check if the player is not flying or swimming
                                if ( !(player.isInWater() || player.isRiptiding() || player.isFlying()) ) {
                                    // increase the velocity
                                    velocity.setY(jumpVelocity * CustomConfig.getBaubleConfig().getDouble("Balloon.JumpVelocityMultiplier"));

                                    // set the player's velocity to that velocity
                                    player.setVelocity(velocity);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Drops bauble items if certain entities die
     * @param event The event called when an entity dies
     * @see CustomItems
     * @see CustomConfig
     * @see Utils
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // check what the entity is
        switch (event.getEntity().getType()) {
            // if the entity is an ender dragon
            case ENDER_DRAGON: {
                Random r = new Random(); // create a random variable to perform calculations
                double chance = CustomConfig.getBaubleConfig().getDouble("EnderDragonScale.DropChance"); // store the chance

                // if looting is enabled
                if (CustomConfig.getBaubleConfig().getBoolean("EnderDragonScale.CheckLooting")) {
                    // check if the killer exists
                    if (event.getEntity().getKiller() != null) {
                        Player player = event.getEntity().getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        // check if the item exists
                        if (Utils.isItemReal(itemMainHand)) {
                            ItemMeta meta = itemMainHand.getItemMeta(); // get the item meta

                            // check if the item has the looting enchant
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS); // get the level of the looting

                                // add the looting level to the chance to increase probability of dropping
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }

                // if the ender dragon scale should drop
                if (r.nextDouble() <= chance)
                    // drop the ender dragon scale
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), CustomItems.getEnderDragonScale());
                break;
            }
            // if the entity is a husk
            case HUSK: {
                Random r = new Random(); // create a random variable to perform calculations
                double chance = CustomConfig.getBaubleConfig().getDouble("ForbiddenFruit.DropChance"); // store the chance

                // if looting is enabled
                if (CustomConfig.getBaubleConfig().getBoolean("ForbiddenFruit.CheckLooting")) {
                    // check if the killer exists
                    if (event.getEntity().getKiller() != null) {
                        Player player = event.getEntity().getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        // check if the item exists
                        if (Utils.isItemReal(itemMainHand)) {
                            ItemMeta meta = itemMainHand.getItemMeta(); // get the item meta

                            // check if the item has the looting enchant
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS); // get the level of the looting

                                // add the looting level to the chance to increase probability of dropping
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }

                // if the forbidden fruit should drop
                if (r.nextDouble() <= chance)
                    // drop the forbidden fruit
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), CustomItems.getForbiddenFruit());
                break;
            }
            case STRAY: {
                Random r = new Random(); // create a random variable to perform calculations
                double chance = CustomConfig.getBaubleConfig().getDouble("RingOverclocking.DropChance"); // store the chance

                // if looting is enabled
                if (CustomConfig.getBaubleConfig().getBoolean("RingOverclocking.CheckLooting")) {
                    // check if the killer exists
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        // check if the item exists
                        if (Utils.isItemReal(itemMainHand)) {
                            ItemMeta meta = itemMainHand.getItemMeta(); // get the item meta

                            // check if the item has the looting enchant
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS); // get the level of the looting

                                // add the looting level to the chance to increase probability of dropping
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }

                // if the ring of overclocking should drop
                if (r.nextDouble() <= chance)
                    // drop the ring of overclocking
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), CustomItems.getRingofOverclocking());
                break;
            }
            // if the entity is an elder guardian
            case ELDER_GUARDIAN: {
                Random r = new Random(); // create a random variable to perform calculations
                double chance = CustomConfig.getBaubleConfig().getDouble("Vitamins.DropChance"); // store the chance

                // if looting is enabled
                if (CustomConfig.getBaubleConfig().getBoolean("Vitamins.CheckLooting")) {
                    // check if the killer exists
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        // check if the item exists
                        if (Utils.isItemReal(itemMainHand)) {
                            ItemMeta meta = itemMainHand.getItemMeta(); // get the item meta

                            // check if the item has the looting enchant
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS); // get the level of the looting

                                // add the looting level to the chance to increase probability of dropping
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }

                // if the vitamins should drop
                if (r.nextDouble() <= chance)
                    // drop the vitamins
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), CustomItems.getVitamins());
                break;
            }
            // if the entity is a cave spider
            case CAVE_SPIDER: {
                Random r = new Random(); // create a random variable to perform calculations
                double chance = CustomConfig.getBaubleConfig().getDouble("Bezoar.DropChance"); // store the chance

                // if looting is enabled
                if (CustomConfig.getBaubleConfig().getBoolean("Bezoar.CheckLooting")) {
                    // check if the killer exists
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        // check if the item exists
                        if (Utils.isItemReal(itemMainHand)) {
                            ItemMeta meta = itemMainHand.getItemMeta(); // get the item meta

                            // check if the item has the looting enchant
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS); // get the level of the looting

                                // add the looting level to the chance to increase probability of dropping
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }

                // if the bezoar should drop
                if (r.nextDouble() <= chance)
                    // drop the bezoar
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), CustomItems.getBezoar());
                break;
            }
        }
    }

    /**
     * Cancels potion effects if a player has certain defensive baubles
     * @param event The event called when an entity receives a potion effect
     * @see CustomItems
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPotionEffect(EntityPotionEffectEvent event) {
        // if the entity affected is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity(); // cast the entity to a player
            PotionEffect newEffect = event.getNewEffect(); // get the new effect
            ItemStack itemOffHand = player.getInventory().getItemInOffHand(); // get the new effect

            NBTItem nbtItem = null; // temporarily create an nbt item

            // if the off hand item exists
            if (Utils.isItemReal(itemOffHand)) {
                // assign the off hand item to the nbt item
                nbtItem = new NBTItem(player.getInventory().getItemInOffHand());
            }

            // if the new potion effect exists
            if (newEffect != null) {
                // check the potion effect
                switch (newEffect.getType().getName()) {
                    // if the potion effect is hunger
                    case "HUNGER":
                        // if the player has a forbidden fruit or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getForbiddenFruit(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    // if the potion effect is hunger
                    case "SLOW":
                        // if the player has a ring of overclocking or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getRingofOverclocking(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getRingofFreeAction(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    // if the potion effect is poison
                    case "POISON":
                        // if the player has a bezoar or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getBezoar(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getMixedColorDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    // if the potion effect is wither
                    case "WITHER":
                        // if the player has a black dragon scale or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getBlackDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getMixedColorDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    // if the potion effect is mining fatigue
                    case "SLOW_DIGGING":
                        // if the player has vitamins or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getVitamins(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    // if the potion effect is blindness
                    case "BLINDNESS":
                        // if the player has sunglasses or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getSunglasses(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    // if the potion effect is levitation
                    case "LEVITATION":
                        // if the player has a shulker heart or any of its derivatives
                        if (player.getInventory().containsAtLeast(CustomItems.getShulkerHeart(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getRingofFreeAction(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            // cancel the event to stop the effect from being added
                            event.setCancelled(true);
                        }
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has a key called "Bauble"
                            if (nbtItem.hasKey("Bauble")) {
                                // if the item is an ankh shield
                                if (nbtItem.getString("Bauble").equals("Ankh Shield")) {
                                    // cancel the event to stop the effect from being added
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    /**
     * Adds anvil recipes to craft complex baubles
     * @param event The event called when a player adds items inside an anvil
     * @see CustomItems
     * @see CustomConfig
     * @see Utils
     */
    @EventHandler
    public void inAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory(); // get the anvil inventory
        // if the first and second items in the anvils exist
        if (Utils.isItemReal(inv.getItem(0))) {
            if (Utils.isItemReal(inv.getItem(1))) {
                ItemStack firstItem = inv.getItem(0); // get the first item
                ItemStack secondItem = inv.getItem(1); // get the second item

                ItemMeta firstMeta = firstItem.getItemMeta(); // get the meta of the first item
                ItemMeta secondMeta = secondItem.getItemMeta(); // get the meta of the second item

                // if the first item has durability
                if (((Damageable) firstMeta).hasDamage())
                    // reset the durability to allow for correct checking
                    ((Damageable) firstMeta).setDamage(0);

                // if the second item has durability
                if (((Damageable) secondMeta).hasDamage())
                    // reset the durability to allow for correct checking
                    ((Damageable) secondMeta).setDamage(0);

                // if the first item is a cobalt shield and the second item is an obsidian skull
                if (firstMeta.equals(CustomItems.getCobaltShield().getItemMeta()) && secondMeta.equals(CustomItems.getObsidianSkull().getItemMeta())) {
                    // set the combined item to an obsidian shield
                    event.setResult(CustomItems.getObsidianShield());
                    // set the repair and max repair costs to their specified amounts
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                }
                // if the first item is a ring of overclocking and the second item is a shulker heart
                else if (firstMeta.equals(CustomItems.getRingofOverclocking().getItemMeta()) && secondMeta.equals(CustomItems.getShulkerHeart().getItemMeta())) {
                    // set the combined item to a ring of free action
                    event.setResult(CustomItems.getRingofFreeAction());
                    // set the repair and max repair costs to their specified amounts
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                }
                // if the first item is a bezoar and the second item is a black dragon scale
                else if (firstMeta.equals(CustomItems.getBezoar().getItemMeta()) && secondMeta.equals(CustomItems.getBlackDragonScale().getItemMeta())) {
                    // set the combined item to a mixed color dragon scale
                    event.setResult(CustomItems.getMixedColorDragonScale());
                    // set the repair and max repair costs to their specified amounts
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("MixedColorDragonScale.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("MixedColorDragonScale.AnvilCost"));
                }
                // if the first item is an obsidian shield and the second item is an ankh charm
                else if (firstMeta.equals(CustomItems.getObsidianShield().getItemMeta()) && secondMeta.equals(CustomItems.getAnkhCharm().getItemMeta())) {
                    // set the combined item to an ankh shield
                    event.setResult(CustomItems.getAnkhShield());
                    // set the repair and max repair costs to their specified amounts
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                }
            }
        }
    }
}
