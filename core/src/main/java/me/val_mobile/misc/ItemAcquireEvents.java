/*
    Copyright (C) 2024  Val_Mobile

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

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import net.minecraft.world.entity.item.EntityItem;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.maven.model.PluginManagement;
import org.bukkit.craftbukkit.v1_17_R1.block.impl.CraftFence;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ItemAcquireEvents implements Listener {

    private final RSVPlugin plugin;
    private final PluginManager pm;

    public ItemAcquireEvents(RSVPlugin plugin) {
        this.plugin = plugin;
        this.pm = Bukkit.getServer().getPluginManager();
    }

    @EventHandler
    public void onEntityAcquireItem(EntityItemAcquireEvent event) {
        String name = ChatColor.stripColor(event.getItem().getItemMeta().getDisplayName());

        String label = name.isEmpty() ? event.getItem().getType().toString() : name;
//        plugin.getLogger().info("Entity: " + event.getEntity().getType() + " " + label + " " + event.getLocation().toString() + " " + event.getCause().toString());
    }

    @EventHandler
    public void onPlayerAcquireItem(PlayerItemAcquireEvent event) {
        String name = ChatColor.stripColor(event.getItem().getItemMeta().getDisplayName());

        String label = name.isEmpty() ? event.getItem().getType().toString() : name;
        plugin.getLogger().info("Player: " + event.getPlayer().getDisplayName() + " " + label + " " + event.getLocation().toString() + " " + event.getCause().toString());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.isOnline())
            return;

        PlayerInventory inv = player.getInventory();

        ItemStack mainHand = inv.getItemInMainHand();
        ItemStack offHand = inv.getItemInOffHand();
        ItemStack helmet = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack legs = inv.getLeggings();
        ItemStack boots = inv.getBoots();

        if (Utils.isItemReal(mainHand))
            pm.callEvent(new PlayerItemAcquireEvent(player, mainHand, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_JOIN, EquipmentSlot.HAND));

        if (Utils.isItemReal(offHand))
            pm.callEvent(new PlayerItemAcquireEvent(player, offHand, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_JOIN, EquipmentSlot.OFF_HAND));

        if (Utils.isItemReal(helmet))
            pm.callEvent(new PlayerItemAcquireEvent(player, helmet, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_JOIN, EquipmentSlot.HEAD));

        if (Utils.isItemReal(chest))
            pm.callEvent(new PlayerItemAcquireEvent(player, chest, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_JOIN, EquipmentSlot.CHEST));

        if (Utils.isItemReal(legs))
            pm.callEvent(new PlayerItemAcquireEvent(player, legs, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_JOIN, EquipmentSlot.LEGS));

        if (Utils.isItemReal(boots))
            pm.callEvent(new PlayerItemAcquireEvent(player, boots, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_JOIN, EquipmentSlot.FEET));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (!player.isOnline())
            return;

        PlayerInventory inv = player.getInventory();

        ItemStack mainHand = inv.getItemInMainHand();
        ItemStack offHand = inv.getItemInOffHand();
        ItemStack helmet = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack legs = inv.getLeggings();
        ItemStack boots = inv.getBoots();

        if (Utils.isItemReal(mainHand))
            pm.callEvent(new PlayerItemAcquireEvent(player, mainHand, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_RESPAWN, EquipmentSlot.HAND));

        if (Utils.isItemReal(offHand))
            pm.callEvent(new PlayerItemAcquireEvent(player, offHand, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_RESPAWN, EquipmentSlot.OFF_HAND));

        if (Utils.isItemReal(helmet))
            pm.callEvent(new PlayerItemAcquireEvent(player, helmet, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_RESPAWN, EquipmentSlot.HEAD));

        if (Utils.isItemReal(chest))
            pm.callEvent(new PlayerItemAcquireEvent(player, chest, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_RESPAWN, EquipmentSlot.CHEST));

        if (Utils.isItemReal(legs))
            pm.callEvent(new PlayerItemAcquireEvent(player, legs, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_RESPAWN, EquipmentSlot.LEGS));

        if (Utils.isItemReal(boots))
            pm.callEvent(new PlayerItemAcquireEvent(player, boots, EntityItemAcquireEvent.ItemAcquireCause.PLAYER_RESPAWN, EquipmentSlot.FEET));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof LivingEntity entity) || entity.getEquipment() == null) {
            return;
        }

        EntityEquipment inv = entity.getEquipment();

        ItemStack mainHand = inv.getItemInMainHand();
        ItemStack offHand = inv.getItemInOffHand();
        ItemStack helmet = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack legs = inv.getLeggings();
        ItemStack boots = inv.getBoots();

        if (Utils.isItemReal(mainHand))
            pm.callEvent(new EntityItemAcquireEvent(entity, mainHand, EntityItemAcquireEvent.ItemAcquireCause.ENTITY_SPAWN, EquipmentSlot.HAND));

        if (Utils.isItemReal(offHand))
            pm.callEvent(new EntityItemAcquireEvent(entity, offHand, EntityItemAcquireEvent.ItemAcquireCause.ENTITY_SPAWN, EquipmentSlot.OFF_HAND));

        if (Utils.isItemReal(helmet))
            pm.callEvent(new EntityItemAcquireEvent(entity, helmet, EntityItemAcquireEvent.ItemAcquireCause.ENTITY_SPAWN, EquipmentSlot.HEAD));

        if (Utils.isItemReal(chest))
            pm.callEvent(new EntityItemAcquireEvent(entity, chest, EntityItemAcquireEvent.ItemAcquireCause.ENTITY_SPAWN, EquipmentSlot.CHEST));

        if (Utils.isItemReal(legs))
            pm.callEvent(new EntityItemAcquireEvent(entity, legs, EntityItemAcquireEvent.ItemAcquireCause.ENTITY_SPAWN, EquipmentSlot.LEGS));

        if (Utils.isItemReal(boots))
            pm.callEvent(new EntityItemAcquireEvent(entity, boots, EntityItemAcquireEvent.ItemAcquireCause.ENTITY_SPAWN, EquipmentSlot.FEET));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItem(event.getNewSlot());

        if (Utils.isItemReal(item)) {
            pm.callEvent(new PlayerItemAcquireEvent(player, item, EntityItemAcquireEvent.ItemAcquireCause.ITEM_HELD, EquipmentSlot.HAND));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onItemSwap(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHand = event.getMainHandItem();
        ItemStack offHand = event.getOffHandItem();

        if (Utils.isItemReal(mainHand)) {
            pm.callEvent(new PlayerItemAcquireEvent(player, mainHand, EntityItemAcquireEvent.ItemAcquireCause.SWAP_HANDS, EquipmentSlot.HAND));
        }

        if (Utils.isItemReal(offHand)) {
            pm.callEvent(new PlayerItemAcquireEvent(player, offHand, EntityItemAcquireEvent.ItemAcquireCause.SWAP_HANDS, EquipmentSlot.OFF_HAND));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onItemPickup(EntityPickupItemEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack item = event.getItem().getItemStack();

        if (entity instanceof Player player) {
            PlayerInventory inv = player.getInventory();
            int slot = inv.getHeldItemSlot();

            boolean acquireMainHand = false;

            // iterate through hotbar slot ids
            for (int i = 0; i <= 9; i++) {
                if (!Utils.isItemReal(inv.getItem(i))) {
                    if (slot == i) {
                        acquireMainHand = true;
                    }
                    break;
                }
            }

            if (acquireMainHand) {
                pm.callEvent(new PlayerItemAcquireEvent(player, item, EntityItemAcquireEvent.ItemAcquireCause.ITEM_PICKUP, EquipmentSlot.HAND));
            }
        }
        else {
            pm.callEvent(new EntityItemAcquireEvent(entity, item, EntityItemAcquireEvent.ItemAcquireCause.ITEM_PICKUP, getLocFromMaterial(item.getType())));
        }
    }

    @Nonnull
    private EquipmentSlot getLocFromMaterial(@Nonnull Material mat) {
        if (mat == Material.SHIELD)
            return EquipmentSlot.OFF_HAND;
        else if (Utils.isHelmet(mat))
            return EquipmentSlot.HEAD;
        else if (Utils.isChestplate(mat))
            return EquipmentSlot.CHEST;
        else if (Utils.isLeggings(mat))
            return EquipmentSlot.LEGS;
        else if (Utils.isBoots(mat))
            return EquipmentSlot.FEET;
        else
            return EquipmentSlot.HAND;
    }

    @Nullable
    private EquipmentSlot getLocFromRawSlot(@Nonnegative int rawSlot, @Nullable Inventory topInv) {
        if (topInv != null && !(topInv instanceof CraftingInventory)) {
            return null;
        }

        return switch (rawSlot) {
            case 45 -> EquipmentSlot.OFF_HAND;
            case 5 -> EquipmentSlot.HEAD;
            case 6 -> EquipmentSlot.CHEST;
            case 7 -> EquipmentSlot.LEGS;
            case 8 -> EquipmentSlot.FEET;
            default -> null;
        };
    }

    private boolean compareLocs(@Nullable ItemStack item, @Nullable EquipmentSlot slot) {
        if (!Utils.isItemReal(item))
            return false;

        return getLocFromMaterial(item.getType()) == slot;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClick(InventoryClickEvent event) {
//        plugin.getLogger().info("InvClickEvent fired" + " " + "ClickAction: " + event.getAction());
//        plugin.getLogger().info("Top Inventory Type: " + event.getView().getTopInventory().getType() + " Inventory Type: " + event.getInventory().getType());

        Inventory top = event.getView().getTopInventory();
        Inventory bottom = event.getView().getBottomInventory();

        if (!(bottom instanceof PlayerInventory inv))
            return;

        Player player = (Player) event.getWhoClicked();
        int rawSlot = event.getRawSlot();

        switch (event.getAction()) {
            case PLACE_ALL, PLACE_ONE, PLACE_SOME, SWAP_WITH_CURSOR -> {
                ItemStack cursor = event.getCursor();

                if (Utils.isItemReal(cursor)) {
                    if (inv.getHeldItemSlot() == event.getSlot()) {
                        pm.callEvent(new PlayerItemAcquireEvent(player, cursor, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.HAND));
                    }
                    else {
                        EquipmentSlot slot = getLocFromRawSlot(rawSlot, top);

                        if (slot != null) {
                            pm.callEvent(new PlayerItemAcquireEvent(player, cursor, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, slot));
                        }
                    }
                }
            }
            case HOTBAR_SWAP, HOTBAR_MOVE_AND_READD -> {
                ItemStack current = event.getCurrentItem();

                if (!Utils.isItemReal(current) && rawSlot >= 1 && rawSlot <= 4) {
                    return;
                }

                // user presses "F" while inventory is open
                if (event.getHotbarButton() == -1 && top instanceof CraftingInventory) {
                    ItemStack offHand = inv.getItemInOffHand();
                    EquipmentSlot offHandSlot = getLocFromMaterial(offHand.getType());

                    // current item will move into off-hand slot
                    if (Utils.isItemReal(current) && rawSlot != 45) {
                        if (rawSlot >= 5 && rawSlot <= 8) {
                            if (compareLocs(offHand, getLocFromRawSlot(rawSlot, top))) {
                                pm.callEvent(new PlayerItemAcquireEvent(player, current, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.OFF_HAND));
                            }
                        }
                        else {
                            pm.callEvent(new PlayerItemAcquireEvent(player, current, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.OFF_HAND));
                        }
                    }

                    if (Utils.isItemReal(offHand)) {
                        // check for armor swap
                        if (rawSlot >= 5 && rawSlot <= 8 && Utils.isArmor(offHand.getType()) && compareLocs(offHand, getLocFromRawSlot(rawSlot, top))) {
                            pm.callEvent(new PlayerItemAcquireEvent(player, offHand, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, offHandSlot));
                        }

                        // off-hand item will move into the raw slot
                        // check if off-hand item moves into held slot
                        if (event.getSlot() == inv.getHeldItemSlot()) {
                            pm.callEvent(new PlayerItemAcquireEvent(player, offHand, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.HAND));
                        }
                    }
                    return;
                }

                ItemStack hotbarItem = inv.getItem(event.getHotbarButton());

                if (Utils.isItemReal(current)) {
                    if (inv.getHeldItemSlot() == event.getHotbarButton()) {
                        pm.callEvent(new PlayerItemAcquireEvent(player, current, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.HAND));
                    }
                }

                // swap two items
                if (Utils.isItemReal(hotbarItem) && event.getSlot() < 9 && event.getSlot() != event.getHotbarButton()) {
                    pm.callEvent(new PlayerItemAcquireEvent(player, hotbarItem, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.HAND));
                }

                if (Utils.isItemReal(hotbarItem)) {
                    EquipmentSlot slot = getLocFromRawSlot(event.getRawSlot(), top);

                    if (slot != null) {
                        pm.callEvent(new PlayerItemAcquireEvent(player, hotbarItem, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, slot));
                    }
                }
            }
            case MOVE_TO_OTHER_INVENTORY -> {
                ItemStack current = event.getCurrentItem();

                if (Utils.isItemReal(current)) {
                    if (top instanceof CraftingInventory) {
                        EquipmentSlot slot = getLocFromMaterial(current.getType());

                        if (player.getEquipment() == null) {
                            slot = null;
                        }
                        else {
                            switch (slot) {
                                case HEAD -> {
                                    if (Utils.isItemReal(player.getEquipment().getHelmet()))
                                        slot = null;
                                }
                                case CHEST -> {
                                    if (Utils.isItemReal(player.getEquipment().getChestplate()))
                                        slot = null;
                                }
                                case LEGS -> {
                                    if (Utils.isItemReal(player.getEquipment().getLeggings()))
                                        slot = null;
                                }
                                case FEET -> {
                                    if (Utils.isItemReal(player.getEquipment().getBoots()))
                                        slot = null;
                                }
                                case OFF_HAND -> {
                                    if (Utils.isItemReal(player.getEquipment().getItemInOffHand()))
                                        slot = null;
                                }
                                default -> slot = null;
                            }
                        }

                        // armor or shield equip
                        if (slot != null) {
                            pm.callEvent(new PlayerItemAcquireEvent(player, current, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, slot));
                        }
                        // item movement across player inventory, not originating from hotbar slots
                        else if (inv.getHeldItemSlot() == getFirstEmptyHotbarSlot(inv) && (rawSlot < 36 || rawSlot > 44)) {
                            boolean nonHotbarFilled = isNonHotbarFilled(event.getView());

                            if ((nonHotbarFilled && (rawSlot <= 8 || rawSlot == 45)) || (!nonHotbarFilled && rawSlot > 8 && rawSlot != 45))
                                pm.callEvent(new PlayerItemAcquireEvent(player, current, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.HAND));
                        }
                    }
                    // item moved from chest/dispenser/etc to player inventory
                    else if (!(event.getClickedInventory() instanceof PlayerInventory) && inv.getHeldItemSlot() == getLastEmptyHotbarSlot(inv)) {
                        pm.callEvent(new PlayerItemAcquireEvent(player, current, EntityItemAcquireEvent.ItemAcquireCause.INVENTORY_CLICK, EquipmentSlot.HAND));
                    }
                }
            }
            default -> {}
        }
    }

    public boolean isNonHotbarFilled(@Nonnull InventoryView view) {
        for (int i = 9; i <= 35; i++) {
            if (!Utils.isItemReal(view.getItem(i))) {
                return false;
            }
        }
        return true;
    }

    public int getFirstEmptyHotbarSlot(@Nonnull PlayerInventory inv) {
        for (int i = 0; i <= 8; i++) {
            if (!Utils.isItemReal(inv.getItem(i))) {
                return i;
            }
        }
        return -1;
    }

    public int getLastEmptyHotbarSlot(@Nonnull PlayerInventory inv) {
        for (int i = 8; i >= 0; i--) {
            if (!Utils.isItemReal(inv.getItem(i))) {
                return i;
            }
        }
        return -1;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onDrag(InventoryDragEvent event) {
//        plugin.getLogger().info("InvDragEvent fired");
//        plugin.getLogger().info("Top Inventory Type: " + event.getView().getTopInventory().getType() + " Inventory Type: " + event.getInventory().getType());

        if (!(event.getView().getBottomInventory() instanceof PlayerInventory bottom))
            return;

        Player player = (Player) event.getWhoClicked();

        Map<Integer, ItemStack> slotMap = event.getNewItems().entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> event.getView().convertSlot(entry.getKey()), Map.Entry::getValue));

        ItemStack changedHeldItem = slotMap.get(bottom.getHeldItemSlot());

        if (Utils.isItemReal(changedHeldItem)) {
            pm.callEvent(new PlayerItemAcquireEvent(player, changedHeldItem, EntityItemAcquireEvent.ItemAcquireCause.DRAG_CLICK, EquipmentSlot.HAND));
        }

        for (Map.Entry<Integer, ItemStack> entry : event.getNewItems().entrySet()) {
            EquipmentSlot slot = getLocFromRawSlot(entry.getKey(), event.getView().getTopInventory());

            if (slot != null) {
                pm.callEvent(new PlayerItemAcquireEvent(player, entry.getValue(), EntityItemAcquireEvent.ItemAcquireCause.DRAG_CLICK, slot));
            }
        }
    }

    private boolean isFilledBucket(@Nonnull Material mat) {
        return mat.toString().contains("BUCKET") && !mat.toString().equals("BUCKET");
    }

    private boolean isPotionMilkBucket(@Nonnull Material mat) {
        return mat == Material.MILK_BUCKET || mat == Material.POTION;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onConsume(PlayerItemConsumeEvent event) {
        if (!isPotionMilkBucket(event.getItem().getType()))
            return;

        Player player = event.getPlayer();

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EquipmentSlot slot = (Utils.isItemReal(mainHand) && isPotionMilkBucket(mainHand.getType())) ? EquipmentSlot.HAND : EquipmentSlot.OFF_HAND;

        ItemStack item = event.getItem();
        ItemStack result = item.getType() == Material.MILK_BUCKET ? new ItemStack(Material.BUCKET) : new ItemStack(Material.GLASS_BOTTLE);

        pm.callEvent(new PlayerItemAcquireEvent(player, result, EntityItemAcquireEvent.ItemAcquireCause.FOOD_CONSUME, slot));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EquipmentSlot slot = (Utils.isItemReal(mainHand) && (isFilledBucket(mainHand.getType()))) ? EquipmentSlot.HAND : EquipmentSlot.OFF_HAND;

        if (Utils.isItemReal(event.getItemStack())) {
            pm.callEvent(new PlayerItemAcquireEvent(player, event.getItemStack(), EntityItemAcquireEvent.ItemAcquireCause.BUCKET_EMPTY, slot));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBucketFill(PlayerBucketFillEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EquipmentSlot slot = (Utils.isItemReal(mainHand) && mainHand.getType() == Material.BUCKET) ? EquipmentSlot.HAND : EquipmentSlot.OFF_HAND;

        if (Utils.isItemReal(event.getItemStack())) {
            pm.callEvent(new PlayerItemAcquireEvent(player, event.getItemStack(), EntityItemAcquireEvent.ItemAcquireCause.BUCKET_FILL_LIQUID, slot));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBucketEntityFill(PlayerBucketEntityEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EquipmentSlot slot = (Utils.isItemReal(mainHand) && mainHand.getType() == Material.WATER_BUCKET) ? EquipmentSlot.HAND : EquipmentSlot.OFF_HAND;

        pm.callEvent(new PlayerItemAcquireEvent(player, event.getEntityBucket(), EntityItemAcquireEvent.ItemAcquireCause.BUCKET_FILL_MOB, slot));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onArmorEquip(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        if (Utils.isItemReal(item) && Utils.isArmor(item.getType()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getOpenInventory().getTopInventory() instanceof CraftingInventory) {
            pm.callEvent(new PlayerItemAcquireEvent(event.getPlayer(), item, EntityItemAcquireEvent.ItemAcquireCause.ARMOR_RIGHT_CLICK, getLocFromMaterial(item.getType())));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onDispenseArmor(BlockDispenseArmorEvent event) {
        ItemStack item = event.getItem();

        if (!Utils.isArmor(event.getItem().getType()))
            return;

        EntityItemAcquireEvent thrown;

        if (event.getTargetEntity() instanceof Player player) {
            thrown = new PlayerItemAcquireEvent(player, item, EntityItemAcquireEvent.ItemAcquireCause.ARMOR_DISPENSE, getLocFromMaterial(item.getType()));
        }
        else {
            thrown = new EntityItemAcquireEvent(event.getTargetEntity(), item, EntityItemAcquireEvent.ItemAcquireCause.ARMOR_DISPENSE, getLocFromMaterial(item.getType()));
        }

        pm.callEvent(thrown);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onArmorStandInteract(PlayerArmorStandManipulateEvent event) {
        ItemStack playerItem = event.getPlayerItem();
        ItemStack asItem = event.getArmorStandItem();

        if (Utils.isItemReal(asItem))
            pm.callEvent(new PlayerItemAcquireEvent(event.getPlayer(), asItem, EntityItemAcquireEvent.ItemAcquireCause.ARMOR_STAND, event.getSlot()));

        if (Utils.isItemReal(playerItem))
            pm.callEvent(new EntityItemAcquireEvent(event.getRightClicked(), playerItem, EntityItemAcquireEvent.ItemAcquireCause.ARMOR_STAND, event.getSlot()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        String message = event.getMessage();
        String[] args = message.substring(1).split(" ");

        if (args.length < 3)
            return;

        boolean isVanillaGive = args[0].equalsIgnoreCase("give");

        if (!(isVanillaGive || args[0].equalsIgnoreCase("rsv")))
            return;

        String givePerm = "minecraft.command.give";
        String rsvPerm = "realisticsurvival.command.give";

        if (!(player.isOp() || ((isVanillaGive && player.hasPermission(givePerm)) || (!isVanillaGive && player.hasPermission(rsvPerm))))) {
            return;
        }

        if (!isVanillaGive && (args.length == 3 || !args[1].equalsIgnoreCase("give"))) {
            return;
        }

        Set<Player> affected = Bukkit.selectEntities(player, isVanillaGive ? args[1] : args[2]).stream().filter(Player.class::isInstance).map(Player.class::cast).collect(Collectors.toSet());

        if (affected.isEmpty())
            return;

        Matcher matcher = Pattern.compile(isVanillaGive ? "(?:minecraft:)?([a-z_]+)" : "([a-zA-Z_]*)").matcher(isVanillaGive ? args[2] : args[3]);

        if (!matcher.find())
            return;

        String itemName = matcher.group(1);

        if (!(Utils.isInEnum(itemName.toUpperCase(), Material.class) || RSVItem.isRSVItem(itemName.toLowerCase())))
            return;

        int amount = 1;

        if ((isVanillaGive && args.length > 3 && StringUtils.isNumeric(args[3])) ||
                (!isVanillaGive && args.length > 4 && StringUtils.isNumeric(args[4]))) {
            amount = isVanillaGive ? Integer.parseInt(args[3]) : Integer.parseInt(args[4]);
        }

        ItemStack totalAdded = isVanillaGive ? new ItemStack(Material.valueOf(itemName.toUpperCase()))
                : RSVItem.getItem(itemName.toLowerCase());

        for (Player p : affected) {
            if (!Utils.isItemReal(p.getInventory().getItemInMainHand())) {
                Inventory simulate = Bukkit.createInventory(null, InventoryType.PLAYER);
                simulate.setContents(p.getInventory().getContents());

                Utils.addItemToInventory(simulate, totalAdded, amount);

                ItemStack added = simulate.getItem(p.getInventory().getHeldItemSlot());

//                for (int i = 0; i < simulate.getSize(); i++) {
//                    ItemStack ia = simulate.getItem(i);
//                    if (Utils.isItemReal(ia)) {
//                        if (ChatColor.stripColor(ia.getItemMeta().getDisplayName()).isEmpty()) {
//                            plugin.getLogger().info("Index: " + i + " Type: " + ia.getType());
//                        }
//                        else {
//                            plugin.getLogger().info("Index: " + i + " Name: " + ia.getItemMeta().getDisplayName());
//                        }
//                    }
//                }

                if (Utils.isItemReal(added)) {
                    pm.callEvent(new PlayerItemAcquireEvent(p, added, EntityItemAcquireEvent.ItemAcquireCause.GIVE_COMMAND, EquipmentSlot.HAND));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onServerCommand(ServerCommandEvent event) {
        CommandSender sender = event.getSender();

        String message = event.getCommand();
        String[] args = message.substring(1).split(" ");

        if (args.length < 3)
            return;

        boolean isVanillaGive = args[0].equalsIgnoreCase("give");

        if (!(isVanillaGive || args[0].equalsIgnoreCase("rsv")))
            return;

        String givePerm = "minecraft.command.give";
        String rsvPerm = "realisticsurvival.command.give";

        if (!(sender.isOp() || ((isVanillaGive && sender.hasPermission(givePerm)) || (!isVanillaGive && sender.hasPermission(rsvPerm))))) {
            return;
        }

        if (!isVanillaGive && (args.length == 3 || !args[1].equalsIgnoreCase("give"))) {
            return;
        }

        Set<Player> affected = Bukkit.selectEntities(sender, isVanillaGive ? args[1] : args[2]).stream().filter(Player.class::isInstance).map(Player.class::cast).collect(Collectors.toSet());

        if (affected.isEmpty())
            return;

        Matcher matcher = Pattern.compile(isVanillaGive ? "(?:minecraft:)?([a-z_]+)" : "([a-zA-Z_]*)").matcher(isVanillaGive ? args[2] : args[3]);

        if (!matcher.find())
            return;

        String itemName = matcher.group(1);

        if (!(Utils.isInEnum(itemName.toUpperCase(), Material.class) || RSVItem.isRSVItem(itemName.toLowerCase())))
            return;

        int amount = 1;

        if ((isVanillaGive && args.length > 3 && StringUtils.isNumeric(args[3])) ||
                (!isVanillaGive && args.length > 4 && StringUtils.isNumeric(args[4]))) {
            amount = isVanillaGive ? Integer.parseInt(args[3]) : Integer.parseInt(args[4]);
        }

        plugin.getLogger().info("Amount: " + amount);

        ItemStack totalAdded = isVanillaGive ? new ItemStack(Material.valueOf(itemName.toUpperCase()))
                : RSVItem.getItem(itemName.toLowerCase());

        totalAdded.setAmount(amount);

        for (Player p : affected) {
            if (!Utils.isItemReal(p.getInventory().getItemInMainHand())) {
                Inventory simulate = Bukkit.createInventory(null, InventoryType.PLAYER);
                simulate.setContents(p.getInventory().getContents());

                Utils.addItemToInventory(simulate, totalAdded, amount);

                ItemStack added = simulate.getItem(p.getInventory().getHeldItemSlot());

                for (int i = 0; i < 9; i++) {
                    ItemStack ia = simulate.getItem(i);
                    if (Utils.isItemReal(ia)) {
                        if (ChatColor.stripColor(ia.getItemMeta().getDisplayName()).isEmpty()) {
                            plugin.getLogger().info("Index: " + i + " Type: " + ia.getType());
                        }
                        else {
                            plugin.getLogger().info("Index: " + i + " Name: " + ia.getItemMeta().getDisplayName());
                        }
                    }
                }

                if (Utils.isItemReal(added)) {
                    pm.callEvent(new PlayerItemAcquireEvent(p, added, EntityItemAcquireEvent.ItemAcquireCause.GIVE_COMMAND, EquipmentSlot.HAND));
                }
            }
        }
    }
}
