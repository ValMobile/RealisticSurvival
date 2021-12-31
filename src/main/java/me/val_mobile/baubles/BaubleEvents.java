/*
    Copyright (C) 2021  Val_Mobile

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
package me.val_mobile.baubles;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomItems;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import net.minecraft.world.level.storage.LevelVersion;
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
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
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
    private final RealisticSurvivalPlugin plugin;
    private final BaubleRunnables baubleRunnables;
    private final CustomItems customItems;
    private final Utils util;

    // constructing the BaubleEvents class
    public BaubleEvents(RealisticSurvivalPlugin instance) {
        plugin = instance;
        baubleRunnables = new BaubleRunnables(instance);
        customItems = new CustomItems(instance);
        util = new Utils(instance);
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

                if (util.shouldEventBeRan(player, "Baubles")) {
                    ItemStack item = event.getItem().getItemStack(); // get the item that was picked up

                    // if the item exists
                    if (Utils.isItemReal(item)) {

                        // if the item has an nbt tag called "Bauble"
                        if (util.hasNbtTag(item,"Bauble")) {
                            // check the string value of the tag and update accordingly
                            switch (util.getNbtTag(item,"Bauble")) {
                                case "Potion Ring of Resistance":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrResValues(player);
                                            baubleRunnables.startPrResRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Regeneration":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrRegenValues(player);
                                            baubleRunnables.startPrRegenRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Strength":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrStrengthValues(player);
                                            baubleRunnables.startPrStrengthRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Speed":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrSpeedValues(player);
                                            baubleRunnables.startPrSpeedRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Jump Boost":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrJumpValues(player);
                                            baubleRunnables.startPrJumpRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Haste":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrHasteValues(player);
                                            baubleRunnables.startPrHasteRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Miner's Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateMinersRingValues(player);
                                            baubleRunnables.startMinersRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Scarlite Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateScarliteRingValues(player);
                                            baubleRunnables.startScarliteRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Dragon's Eye":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateDragonsEyeValues(player);
                                            baubleRunnables.startDragonsEyeRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Shield of Honor":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateShieldHonorValues(player);
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

            if (util.shouldEventBeRan(player, "Baubles")) {
                ItemStack item = event.getItemDrop().getItemStack(); // get the item that was dropped

                // if the item exists
                if (Utils.isItemReal(item)) {

                    // if the item has an nbt tag called "Bauble"
                    if (util.hasNbtTag(item,"Bauble")) {
                        // check the string value of the tag and update accordingly
                        switch (util.getNbtTag(item,"Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updatePrResValues(player);
                                        baubleRunnables.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updatePrRegenValues(player);
                                        baubleRunnables.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updatePrStrengthValues(player);
                                        baubleRunnables.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updatePrSpeedValues(player);
                                        baubleRunnables.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updatePrJumpValues(player);
                                        baubleRunnables.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updatePrHasteValues(player);
                                        baubleRunnables.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updateMinersRingValues(player);
                                        baubleRunnables.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updateScarliteRingValues(player);
                                        baubleRunnables.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updateDragonsEyeValues(player);
                                        baubleRunnables.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        baubleRunnables.updateShieldHonorValues(player);
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

            if (util.shouldEventBeRan(player, "Baubles")) {
                // if the bottom half of the inventory view is the player's own inventory
                if (event.getView().getBottomInventory() instanceof PlayerInventory) {
                    ItemStack cursorItem = event.getCursor();
                    ItemStack currentItem = event.getCurrentItem();

                    // if the item on the player's cursor exists
                    if (Utils.isItemReal(cursorItem)) {

                        // if the item has an nbt tag called "Bauble"
                        if (util.hasNbtTag(cursorItem,"Bauble")) {
                            // check the string value of the tag and update accordingly
                            switch (util.getNbtTag(cursorItem,"Bauble")) {
                                case "Potion Ring of Resistance":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrResValues(player);
                                            baubleRunnables.startPrResRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Regeneration":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrRegenValues(player);
                                            baubleRunnables.startPrRegenRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Strength":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrStrengthValues(player);
                                            baubleRunnables.startPrStrengthRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Speed":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrSpeedValues(player);
                                            baubleRunnables.startPrSpeedRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Jump Boost":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrJumpValues(player);
                                            baubleRunnables.startPrJumpRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Haste":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrHasteValues(player);
                                            baubleRunnables.startPrHasteRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Miner's Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateMinersRingValues(player);
                                            baubleRunnables.startMinersRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Scarlite Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateScarliteRingValues(player);
                                            baubleRunnables.startScarliteRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Dragon's Eye":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateDragonsEyeValues(player);
                                            baubleRunnables.startDragonsEyeRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Shield of Honor":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateShieldHonorValues(player);
                                            baubleRunnables.startShieldHonorRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                            }
                        }

                    }
                    // if an item was placed in a slot, check if that item exists
                    if (Utils.isItemReal(currentItem)) {

                        // if the item has an nbt tag called "Bauble"
                        if (util.hasNbtTag(currentItem,"Bauble")) {
                            // check the string value of the tag and update accordingly
                            switch (util.getNbtTag(currentItem,"Bauble")) {
                                case "Potion Ring of Resistance":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrResValues(player);
                                            baubleRunnables.startPrResRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Regeneration":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrRegenValues(player);
                                            baubleRunnables.startPrRegenRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Strength":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrStrengthValues(player);
                                            baubleRunnables.startPrStrengthRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Speed":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrSpeedValues(player);
                                            baubleRunnables.startPrSpeedRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Jump Boost":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrJumpValues(player);
                                            baubleRunnables.startPrJumpRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Haste":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrHasteValues(player);
                                            baubleRunnables.startPrHasteRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Miner's Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateMinersRingValues(player);
                                            baubleRunnables.startMinersRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Scarlite Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateScarliteRingValues(player);
                                            baubleRunnables.startScarliteRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Dragon's Eye":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateDragonsEyeValues(player);
                                            baubleRunnables.startDragonsEyeRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Shield of Honor":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateShieldHonorValues(player);
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

            if (util.shouldEventBeRan(player, "Baubles")) {
                // if the bottom half of the inventory view is the player's own inventory
                if (event.getView().getBottomInventory() instanceof PlayerInventory) {
                    // if the dragged item exists
                    if (Utils.isItemReal(event.getOldCursor())) {
                        ItemStack oldCursor = event.getOldCursor();


                        // if the item has an nbt tag called "Bauble"
                        if (util.hasNbtTag(oldCursor,"Bauble")) {
                            // check the string value of the tag and update accordingly
                            switch (util.getNbtTag(oldCursor,"Bauble")) {
                                case "Potion Ring of Resistance":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrResValues(player);
                                            baubleRunnables.startPrResRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Regeneration":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrRegenValues(player);
                                            baubleRunnables.startPrRegenRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Strength":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrStrengthValues(player);
                                            baubleRunnables.startPrStrengthRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Speed":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrSpeedValues(player);
                                            baubleRunnables.startPrSpeedRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Jump Boost":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrJumpValues(player);
                                            baubleRunnables.startPrJumpRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Potion Ring of Haste":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updatePrHasteValues(player);
                                            baubleRunnables.startPrHasteRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Miner's Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateMinersRingValues(player);
                                            baubleRunnables.startMinersRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Scarlite Ring":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateScarliteRingValues(player);
                                            baubleRunnables.startScarliteRingRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Dragon's Eye":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateDragonsEyeValues(player);
                                            baubleRunnables.startDragonsEyeRunnable(player);
                                        }
                                    }.runTaskLater(plugin, 1L);
                                    break;
                                case "Shield of Honor":
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            baubleRunnables.updateShieldHonorValues(player);
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

            if (util.shouldEventBeRan(player, "Baubles")) {
                // if the player has an ender queen's crown in his/her inventory
                if (player.getInventory().containsAtLeast(customItems.getEnderQueensCrown(), 1))
                    // stop the enderman from being hostile
                    event.setCancelled(true);
            }

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

            if (util.shouldEventBeRan(player, "Baubles")) {
                Entity entity = event.getEntity(); // get the attacked entity

                // if the entity is able to receive potion effects
                if (entity instanceof LivingEntity) {
                    // if the player has a poison stone in his/her inventory
                    if (player.getInventory().containsAtLeast(customItems.getPoisonStone(), 1)) {
                        // effect the entity with poison
                        BaubleAbilities.PoisonStoneAbility((LivingEntity) entity);
                    }
                }
            }

        }
        // if the attacked entity is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity(); // get the player

            if (util.shouldEventBeRan(player, "Baubles")) {
                ItemStack itemOffHand = player.getInventory().getItemInOffHand(); // get the item in the player's off hand

                // if the item exists
                if (Utils.isItemReal(itemOffHand)) {

                    // if the item has an nbt tag called "Bauble"
                    if (util.hasNbtTag(itemOffHand,"Bauble")) {
                        // if the item is a cobalt shield or any of its derivatives
                        switch (util.getNbtTag(itemOffHand,"Bauble")) {
                            case "Cobalt Shield":
                            case "Obsidian Shield":
                            case "Ankh Shield":
                                // set the velocity of the player to 0 to mimic anti-kb
                                baubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
                        }
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

            if (util.shouldEventBeRan(player, "Baubles")) {
                PlayerInventory inv = player.getInventory(); // get the player's inventory
                ItemStack itemOffHand = inv.getItemInOffHand(); // get the item in the player's off hand

                // check the cause of the damage
                switch (cause) {
                    // if the damage is caused by fire
                    case FIRE:
                    case FIRE_TICK: {
                        // if the player has an obsidian skull
                        if (inv.containsAtLeast(customItems.getObsidianSkull(), 1)) {
                            // reduce the damage by a specified amount
                            event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ObsidianSkull.HeatDamageMultiplier"));
                        }
                        // if the off hand item exists
                        else if (Utils.isItemReal(itemOffHand)) {
                            // if the item has an nbt tag called "Bauble"
                            if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                // if the item is a cobalt shield
                                if (util.getNbtTag(itemOffHand,"Bauble").equals("Obsidian Shield"))
                                    // reduce the damage by a specified amount
                                    event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ObsidianShield.HeatDamageMultiplier"));
                                    // if the item is an ankh shield
                                else if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield"))
                                    // reduce the damage by a specified amount
                                    event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("AnkhShield.HeatDamageMultiplier"));
                            }
                        }
                        break;
                    }
                    // if the damage is caused by an explosion
                    case ENTITY_EXPLOSION:
                    case BLOCK_EXPLOSION: {
                        // if the off hand item exists
                        if (Utils.isItemReal(itemOffHand)) {
                            // if the item has an nbt tag called "Bauble"
                            if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                // if the item is a cobalt shield or any of its derivatives
                                switch (util.getNbtTag(itemOffHand,"Bauble")) {
                                    case "Cobalt Shield":
                                    case "Obsidian Shield":
                                    case "Ankh Shield":
                                        // set the velocity of the player to 0 to mimic anti-kb
                                        baubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
                                }
                            }
                        }
                        // if the player has a shield of honor
                        if (player.getInventory().containsAtLeast(customItems.getShieldHonor(), 1)) {
                            // reduce the damage by a specified amount
                            event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ShieldHonor.ExplosionDamageMultiplier"));
                        }
                        break;
                    }
                    // if the damage is caused by falling
                    case FALL: {
                        // if the player has a balloon
                        if (player.getInventory().containsAtLeast(customItems.getBalloon(), 1))
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
                        if (player.getInventory().containsAtLeast(customItems.getLuckyHorseshoe(), 1))
                            // cancel the event to set the fall damage to 0
                            event.setCancelled(true);
                        break;
                    }
                    // if the damage is caused by a cactus or berry bush
                    case CONTACT: {
                        // if the player has a phytoprotostasia amulet
                        if (player.getInventory().containsAtLeast(customItems.getPhytoprostasiaAmulet(), 1))
                            // cancel the event to set the damage to 0
                            event.setCancelled(true);
                        break;
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
                if (inv.containsAtLeast(customItems.getCrossNecklace(), 1)) {
                    // add the player to the static hashmap
                    Utils.setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), player.getName(), true);

                    // remove the i-frames by setting the key of the player to false after a specified amount of time
                    baubleRunnables.removeInvFrames(player).runTaskLater(plugin, CustomConfig.getBaubleConfig().getInt("CrossNecklace.InvFrameLength"));
                }
            }

        }
    }

    /**
     * Activates the balloon ability if a player jumps
     * @param event The event called when a player moves
     * @see CustomItems
     * @see CustomConfig
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer(); // get the player

        if (util.shouldEventBeRan(player, "Baubles")) {
            // if the event is active
            if (!event.isCancelled()) {
                // if the player has a balloon
                if (event.getPlayer().getInventory().containsAtLeast(customItems.getBalloon(), 1)) {

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
        LivingEntity entity = event.getEntity();

        if (util.shouldEventBeRan(entity, "Baubles")) {
            // check what the entity is
            switch (entity.getType()) {
                // if the entity is an ender dragon
                case ENDER_DRAGON: {
                    double chance = CustomConfig.getBaubleConfig().getDouble("EnderDragonscale.DropChance"); // store the chance

                    if (entity.getKiller() != null) {
                        Player player = entity.getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        Utils.harvestLooting(chance, customItems.getEnderDragonscale(), true, itemMainHand, event.getEntity().getLocation());
                    }
                    break;
                }
                // if the entity is a husk
                case HUSK: {
                    double chance = CustomConfig.getBaubleConfig().getDouble("ForbiddenFruit.DropChance"); // store the chance

                    if (entity.getKiller() != null) {
                        Player player = entity.getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        Utils.harvestLooting(chance, customItems.getForbiddenFruit(), true, itemMainHand, event.getEntity().getLocation());
                    }
                    break;
                }
                case STRAY: {
                    double chance = CustomConfig.getBaubleConfig().getDouble("RingOverclocking.DropChance"); // store the chance

                    if (entity.getKiller() != null) {
                        Player player = entity.getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        Utils.harvestLooting(chance, customItems.getRingofOverclocking(), true, itemMainHand, event.getEntity().getLocation());
                    }
                    break;
                }
                // if the entity is an elder guardian
                case ELDER_GUARDIAN: {
                    double chance = CustomConfig.getBaubleConfig().getDouble("Vitamins.DropChance"); // store the chance

                    if (entity != null) {
                        Player player = entity.getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        Utils.harvestLooting(chance, customItems.getVitamins(), true, itemMainHand, event.getEntity().getLocation());
                    }
                    break;
                }
                // if the entity is a cave spider
                case CAVE_SPIDER: {
                    double chance = CustomConfig.getBaubleConfig().getDouble("Bezoar.DropChance"); // store the chance

                    if (entity.getKiller() != null) {
                        Player player = entity.getKiller(); // get the player
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the main hand

                        Utils.harvestLooting(chance, customItems.getBezoar(), true, itemMainHand, event.getEntity().getLocation());
                    }
                    break;
                }
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

            if (util.shouldEventBeRan(player, "Baubles")) {
                PotionEffect newEffect = event.getNewEffect(); // get the new effect
                ItemStack itemOffHand = player.getInventory().getItemInOffHand(); // get the new effect

                // if the new potion effect exists
                if (newEffect != null) {
                    // check the potion effect
                    switch (newEffect.getType().getName()) {
                        // if the potion effect is hunger
                        case "HUNGER":
                            // if the player has a forbidden fruit or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getForbiddenFruit(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
                                        // cancel the event to stop the effect from being added
                                        event.setCancelled(true);
                                    }
                                }
                            }
                            break;
                        // if the potion effect is hunger
                        case "SLOW":
                            // if the player has a ring of overclocking or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getRingofOverclocking(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getRingofFreeAction(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
                                        // cancel the event to stop the effect from being added
                                        event.setCancelled(true);
                                    }
                                }
                            }
                            break;
                        // if the potion effect is poison
                        case "POISON":
                            // if the player has a bezoar or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getBezoar(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getMixedColorDragonscale(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
                                        // cancel the event to stop the effect from being added
                                        event.setCancelled(true);
                                    }
                                }
                            }
                            break;
                        // if the potion effect is wither
                        case "WITHER":
                            // if the player has a black dragon scale or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getBlackDragonscale(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getMixedColorDragonscale(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
                                        // cancel the event to stop the effect from being added
                                        event.setCancelled(true);
                                    }
                                }
                            }
                            break;
                        // if the potion effect is mining fatigue
                        case "SLOW_DIGGING":
                            // if the player has vitamins or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getVitamins(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
                                        // cancel the event to stop the effect from being added
                                        event.setCancelled(true);
                                    }
                                }
                            }
                            break;
                        // if the potion effect is blindness
                        case "BLINDNESS":
                            // if the player has sunglasses or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getSunglasses(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
                                        // cancel the event to stop the effect from being added
                                        event.setCancelled(true);
                                    }
                                }
                            }
                            break;
                        // if the potion effect is levitation
                        case "LEVITATION":
                            // if the player has a shulker heart or any of its derivatives
                            if (player.getInventory().containsAtLeast(customItems.getShulkerHeart(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getRingofFreeAction(), 1) ||
                                    player.getInventory().containsAtLeast(customItems.getAnkhCharm(), 1)) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            // if the off hand item exists
                            if (Utils.isItemReal(itemOffHand)) {
                                // if the item has a key called "Bauble"
                                if (util.hasNbtTag(itemOffHand,"Bauble")) {
                                    // if the item is an ankh shield
                                    if (util.getNbtTag(itemOffHand,"Bauble").equals("Ankh Shield")) {
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

        Player player = (Player) event.getView().getPlayer();

        if (util.shouldEventBeRan(player, "Baubles")) {
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
                    if (firstMeta.equals(customItems.getCobaltShield().getItemMeta()) && secondMeta.equals(customItems.getObsidianSkull().getItemMeta())) {
                        // set the combined item to an obsidian shield
                        event.setResult(customItems.getObsidianShield());
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                        inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                    }
                    // if the first item is a ring of overclocking and the second item is a shulker heart
                    else if (firstMeta.equals(customItems.getRingofOverclocking().getItemMeta()) && secondMeta.equals(customItems.getShulkerHeart().getItemMeta())) {
                        // set the combined item to a ring of free action
                        event.setResult(customItems.getRingofFreeAction());
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                        inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                    }
                    // if the first item is a bezoar and the second item is a black dragon scale
                    else if (firstMeta.equals(customItems.getBezoar().getItemMeta()) && secondMeta.equals(customItems.getBlackDragonscale().getItemMeta())) {
                        // set the combined item to a mixed color dragon scale
                        event.setResult(customItems.getMixedColorDragonscale());
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("MixedColorDragonscale.AnvilCost"));
                        inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("MixedColorDragonscale.AnvilCost"));
                    }
                    // if the first item is an obsidian shield and the second item is an ankh charm
                    else if (firstMeta.equals(customItems.getObsidianShield().getItemMeta()) && secondMeta.equals(customItems.getAnkhCharm().getItemMeta())) {
                        // set the combined item to an ankh shield
                        event.setResult(customItems.getAnkhShield());
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                        inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                    }
                }
            }
        }
    }
}