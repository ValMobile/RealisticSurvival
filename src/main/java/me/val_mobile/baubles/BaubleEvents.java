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
package me.val_mobile.baubles;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.RSVFiles;
import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.BaubleInventory;
import me.val_mobile.data.baubles.BaubleSlot;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.swing.*;
import java.util.*;

/**
 * BaubleEvents is a class containing listener methods
 * that activate abilities on entities
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class BaubleEvents extends ModuleEvents implements Listener {

    /**
     * Dependency injecting the main and util class for use
     * The util class must be injected because its non-static methods are needed
     */
    private final RealisticSurvivalPlugin plugin;
    private final ModuleItems items;
    private final Utils util;
    private final BaubleModule module;

    // constructing the BaubleEvents class
    public BaubleEvents(BaubleModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
        this.module = module;
        items = module.getModuleItems();

        util = new Utils(plugin);
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player drops a bauble
     * @param event The event called when a player drops an item
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer(); // get the player
        UUID id = player.getUniqueId();
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        ItemStack cornerItem = player.getOpenInventory().getTopInventory().getItem(0);
        if (shouldEventBeRan(player)) {
            if (RSVItem.isRSVItem(cornerItem, util)) {
                if (Objects.equals(RSVItem.getNameFromItem(cornerItem, util), "gui_glass")) {
                    if (RSVItem.isRSVItem(droppedItem, util)) {
                        if (Objects.equals(RSVItem.getNameFromItem(droppedItem, util), "gui_glass")) {
                            event.setCancelled(true);
                        }
                        if (Objects.equals(RSVItem.getModuleNameFromItem(droppedItem, util), "Baubles")) {
                            String itemName = RSVItem.getNameFromItem(droppedItem, util);

                            HashMap<UUID, Collection<PotionBauble>> baubleMap = PotionRunnable.getBaubleMap();
                            RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);
                            rsvPlayer.getDataModuleFromName("Baubles").updateData();
                            PotionBaubleManager manager = PotionBaubleManager.valueOf(itemName.toUpperCase());

                            if (manager != null) {
                                PotionBauble potionBauble = manager.getPotionBauble();
                                if (baubleMap.containsKey(id)) {
                                    if (!baubleMap.get(id).contains(potionBauble)) {
                                        new PotionRunnable(potionBauble, rsvPlayer, plugin);
                                    }
                                }
                                else {
                                    new PotionRunnable(potionBauble, rsvPlayer, plugin);
                                }
                            }
                            if (itemName.equals("scarlite_ring")) {
                                ScarliteRing runnable = new ScarliteRing(rsvPlayer, plugin);
                                runnable.startRunnable();
                            }
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
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked(); // get the player

        if (shouldEventBeRan(player)) {
            ItemStack corner = event.getClickedInventory().getItem(0);
            ItemStack cursor = event.getCursor();
            ItemStack current = event.getCurrentItem();

            if (RSVItem.isRSVItem(corner, util)) {
                if (Objects.equals(RSVItem.getNameFromItem(corner, util), "gui_glass")) {
                    if (cursor == null || !(util.hasNbtTag(cursor, "rsvbaubleslot") && RSVItem.isRSVItem(current, util))) {
                        event.setCancelled(true);
                    }
                    if (cursor.getAmount() > 1 || current.getAmount() > 1) {
                        event.setCancelled(true);
                    }
                    if (Objects.equals(RSVItem.getNameFromItem(current, util), "gui_glass")) {
                        event.setCancelled(true);
                    }
                    String cursorTag = util.getNbtTag(cursor, "rsvbaubleslot");
                    BaubleSlot slot = BaubleSlot.valueOf(util.getNbtTag(current, "rsvbaubleslot").toUpperCase());
                    if (cursorTag.equals(slot.getTag()) || cursorTag.equals("Any")) {
                        event.setCurrentItem(null);
                    }
                }
            }
        }
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player drags a bauble
     * in his/her inventory
     * @param event The event called when a player drags an item into an inventory
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDragClick(InventoryDragEvent event) {
        // get the player
        Player player = (Player) event.getWhoClicked();

        if (shouldEventBeRan(player)) {
            // if the bottom half of the inventory view is the player's own inventory
            if (event.getView().getBottomInventory() instanceof PlayerInventory) {

                // if the dragged item exists
                if (Utils.isItemReal(event.getOldCursor())) {
                    ItemStack oldCursor = event.getOldCursor();

                }
            }
        }

    }

    /**
     * Activates the ender queen's crown ability if the player angers an enderman
     * while having the ender queen's crown in his/her inventory
     * @param event The event called when an entity is provoked by another entity
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTarget(EntityTargetEvent event) {
        // if the attacker is an enderman and the aggressor is a player
        if (event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            Player player = (Player) event.getTarget(); // get the player

            if (shouldEventBeRan(player)) {
                // if the player has an ender queen's crown in his/her inventory
                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName("Baubles");
                if (module.getBaubleBag().hasBauble("ender_queens_crown")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    /**
     * Activates various offensive and defensive baubles if a player is attacked
     * while having them in his/her inventory
     * @param event The event called when an entity attacks another entity
     * @see BaubleAbilities
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // if the attacker is a player
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager(); // get the player

            if (shouldEventBeRan(player)) {
                Entity entity = event.getEntity(); // get the attacked entity

                // if the entity is able to receive potion effects
                if (entity instanceof LivingEntity) {
                    RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                    DataModule module = (DataModule) rsvPlayer.getDataModuleFromName("Baubles");

                    if (module.getBaubleBag().hasBauble("poison_stone")) {
                        BaubleAbilities.PoisonStoneAbility((LivingEntity) entity);
                    }
                }
            }

        }
    }

    /**
     * Activates various defensive baubles if a player is attacked
     * by certain causes
     * @param event The event called when an entity is attacked
     * @see RSVFiles
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        // if the damaged entity is a player
        if (event.getEntity() instanceof Player) {
            EntityDamageEvent.DamageCause cause = event.getCause(); // get the damage cause
            Player player = (Player) event.getEntity(); // get the player

            if (shouldEventBeRan(player)) {
                FileConfiguration config = RSVFiles.getBaubleUserConfig();

                PlayerInventory inv = player.getInventory(); // get the player's inventory
                ItemStack itemOffHand = inv.getItemInOffHand(); // get the item in the player's off hand

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName("Baubles");

                BaubleInventory baubleInv = module.getBaubleBag();

                String offHandName = "";

                // if the item exists
                if (RSVItem.isRSVItem(itemOffHand, util)) {
                    offHandName = RSVItem.getNameFromItem(itemOffHand, util);
                }

                double damage = event.getDamage();

                boolean cobaltShield = baubleInv.hasBauble("cobalt_shield") || offHandName.equals("cobalt_shield") ? true : false;
                boolean obsShield = baubleInv.hasBauble("obsidian_shield") || offHandName.equals("obsidian_shield") ? true : false;
                boolean ankhShield = baubleInv.hasBauble("ankh_shield") || offHandName.equals("ankh_shield") ? true : false;

                if (cobaltShield || obsShield || ankhShield) {
                    BaubleAbilities.freezeEntity(player).runTaskLater(plugin, 1L);
                }

                // check the cause of the damage
                switch (cause) {
                    // if the damage is caused by fire
                    case FIRE:
                    case FIRE_TICK: {
                        if (RSVItem.isRSVItem(itemOffHand, util)) {
                            offHandName = RSVItem.getNameFromItem(itemOffHand, util);
                        }

                        if (baubleInv.hasBauble("obsidian_skull")) {
                            // reduce the damage by a specified amount
                            damage *= config.getDouble("Items.obsidian_skull.HeatDamageMultiplier");
                        }

                        if (obsShield) {
                            damage *= config.getDouble("Items.obsidian_shield.HeatDamageMultiplier");
                        }

                        if (ankhShield) {
                            damage *= config.getDouble("Items.ankh_shield.HeatDamageMultiplier");
                        }
                        break;
                    }
                    // if the damage is caused by an explosion
                    case ENTITY_EXPLOSION:
                    case BLOCK_EXPLOSION: {
                        // if the player has a shield of honor
                        if (baubleInv.hasBauble(("shield_honor"))) {
                            // reduce the damage by a specified amount
                            damage *= config.getDouble("Items.shield_honor.ExplosionDamageMultiplier");
                        }
                        break;
                    }
                    // if the damage is caused by falling
                    case FALL: {
                        if (baubleInv.hasBauble(("balloon"))) {
                            if (player.getFallDistance() <= config.getDouble("Items.balloon.MinFallDistance")) {
                                // cancel the event to set the fall damage to 0
                                event.setCancelled(true);
                            }
                            // reduce the damage by a specified amount
                            damage *= config.getDouble("Items.balloon.FallDamageMultiplier");

                        }
                        if (baubleInv.hasBauble(("balloon"))) {
                            event.setCancelled(true);
                        }
                        break;
                    }
                    // if the damage is caused by a cactus or berry bush
                    case CONTACT: {
                        // if the player has a phytoprotostasia amulet
                        if (baubleInv.hasBauble(("phytoprostasia_amulet"))) {
                            event.setCancelled(true);
                        }
                        break;
                    }
                }

                if (baubleInv.hasBauble(("cross_necklace"))) {
                    player.setNoDamageTicks(config.getInt("Items.cross_necklace.InvFrameLength"));
                }

                event.setDamage(damage);
            }
        }
    }

    /**
     * Activates the balloon ability if a player jumps
     * @param event The event called when a player moves
     * @see RSVFiles
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerVelocityEvent event)
    {
        Player player = event.getPlayer(); // get the player

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                FileConfiguration config = RSVFiles.getBaubleUserConfig();

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName("Baubles");

                BaubleInventory baubleInv = module.getBaubleBag();

                // if the player has a balloon
                if (baubleInv.hasBauble("balloon")) {

                    Vector velocity = player.getVelocity(); // get the player's current velocity

                    // check if the player is moving up
                    if (velocity.getY() > 0) {
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
                                    if (!(player.isInWater() || player.isRiptiding() || player.isFlying())) {
                                        // increase the velocity
                                        velocity.setY(jumpVelocity * config.getDouble("Items.balloon.JumpVelocityMultiplier"));

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
     * @see RSVFiles
     * @see Utils
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (shouldEventBeRan(entity)) {
            FileConfiguration config = RSVFiles.getBaubleUserConfig();

            Collection<String> drops = Arrays.asList("forbidden_fruit", "vitamins", "ring_overclocking", "shulker_heart", "bezoar", "ender_dragonscale");
            for (String drop : drops) {
                 ConfigurationSection section = config.getConfigurationSection("Items." + drop + ".MobDrops");
                 Set<String> keys = section.getKeys(false);

                for (String key : keys) {
                    if (entity.getType() == EntityType.valueOf(key)) {
                        Utils.harvestLooting(section.getDouble(key + ".Value"), RSVItem.getItem(drop), Utils.DROP_TYPE.valueOf(section.getString(key + ".DropType")), entity.getKiller().getItemInUse(), entity.getLocation());
                    }
                }
            }
        }
    }

    /**
     * Cancels potion effects if a player has certain defensive baubles
     * @param event The event called when an entity receives a potion effect
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPotionEffect(EntityPotionEffectEvent event) {

        // if the entity affected is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity(); // cast the entity to a player

            if (shouldEventBeRan(player)) {
                PotionEffect newEffect = event.getNewEffect(); // get the new effect
                ItemStack itemOffHand = player.getInventory().getItemInOffHand(); // get the new effect

                // if the new potion effect exists
                if (newEffect != null) {
                    // check the potion effect
                    switch (newEffect.getType().getName()) {
                        // if the potion effect is hunger
                        case "HUNGER":
                            // if the player has a forbidden fruit or any of its derivatives
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("forbidden_fruit"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("ring_overclocking"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ring_free_action"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("bezoar"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("mixed_color_dragonscale"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("black_dragonscale_bauble"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("mixed_color_dragonscale"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("vitamins"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("sunglasses"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
                            if (player.getInventory().containsAtLeast(RSVItem.getItem("shulker_heart"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ring_free_action"), 1) ||
                                    player.getInventory().containsAtLeast(RSVItem.getItem("ankh_charm"), 1)) {
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
     * @see RSVFiles
     * @see Utils
     */
    @EventHandler
    public void inAnvil(PrepareAnvilEvent event) {

        Player player = (Player) event.getView().getPlayer();

        if (shouldEventBeRan(player)) {
            FileConfiguration config = RSVFiles.getBaubleUserConfig();

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
                    if (firstMeta.equals(RSVItem.getItem("cobalt_shield").getItemMeta()) && secondMeta.equals(RSVItem.getItem("obsidian_skull").getItemMeta())) {
                        // set the combined item to an obsidian shield
                        event.setResult(RSVItem.getItem("obsidian_shield"));
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(config.getInt("ObsidianShield.AnvilCost"));
                        inv.setMaximumRepairCost(config.getInt("ObsidianShield.AnvilCost"));
                    }
                    // if the first item is a ring of overclocking and the second item is a shulker heart
                    else if (firstMeta.equals(RSVItem.getItem("ring_overclocking").getItemMeta()) && secondMeta.equals(RSVItem.getItem("shulker_heart").getItemMeta())) {
                        // set the combined item to a ring of free action
                        event.setResult(RSVItem.getItem("ring_free_action"));
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(config.getInt("RingFreeAction.AnvilCost"));
                        inv.setMaximumRepairCost(config.getInt("RingFreeAction.AnvilCost"));
                    }
                    // if the first item is a bezoar and the second item is a black dragon scale
                    else if (firstMeta.equals(RSVItem.getItem("bezoar").getItemMeta()) && secondMeta.equals(RSVItem.getItem("black_dragonscale_bauble").getItemMeta())) {
                        // set the combined item to a mixed color dragon scale
                        event.setResult(RSVItem.getItem("mixed_color_dragonscale"));
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(config.getInt("MixedColorDragonscale.AnvilCost"));
                        inv.setMaximumRepairCost(config.getInt("MixedColorDragonscale.AnvilCost"));
                    }
                    // if the first item is an obsidian shield and the second item is an ankh charm
                    else if (firstMeta.equals(RSVItem.getItem("obsidian_shield").getItemMeta()) && secondMeta.equals(RSVItem.getItem("ankh_charm").getItemMeta())) {
                        // set the combined item to an ankh shield
                        event.setResult(RSVItem.getItem("ankh_shield"));
                        // set the repair and max repair costs to their specified amounts
                        inv.setRepairCost(config.getInt("AnkhShield.AnvilCost"));
                        inv.setMaximumRepairCost(config.getInt("AnkhShield.AnvilCost"));
                    }
                }
            }
        }
    }
}