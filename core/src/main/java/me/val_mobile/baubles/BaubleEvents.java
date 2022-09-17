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

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.BaubleInventory;
import me.val_mobile.data.baubles.BaubleSlot;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

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
    private final BaubleModule module;

    // constructing the BaubleEvents class
    public BaubleEvents(BaubleModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
        this.module = module;
    }

    /**
     * Updates the amount of baubles in the static hashmaps if a player drops a bauble
     * @param event The event called when a player drops an item
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer(); // get the player

        ItemStack droppedItem = event.getItemDrop().getItemStack();
        ItemStack cornerItem = player.getOpenInventory().getTopInventory().getItem(0);
        if (shouldEventBeRan(player)) {
            if (RSVItem.isRSVItem(cornerItem)) {
                if (Objects.equals(RSVItem.getNameFromItem(cornerItem), "gui_glass")) {
                    if (RSVItem.isRSVItem(droppedItem)) {
                        if (Objects.equals(RSVItem.getNameFromItem(droppedItem), "gui_glass")) {
                            event.setCancelled(true);
                        }
                        if (Objects.equals(RSVItem.getModuleNameFromItem(droppedItem), BaubleModule.NAME)) {
                            Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, droppedItem, BaubleChangeEvent.BaubleChange.REMOVAL));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBaubleChangeEvent(BaubleChangeEvent event) {
        String itemName = event.getBaubleName();
        UUID id = event.getPlayer().getUniqueId();

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

        if (event.getChange() == BaubleChangeEvent.BaubleChange.ADDITION) {
            HashMap<UUID, Collection> baubleMap = TickableBaubleManager.getBaubles();

            TickableBaubleManager manager = TickableBaubleManager.valueOf(itemName.toUpperCase());

            if (manager != null) {
                Tickable bauble = manager.getBauble();
                if (baubleMap.containsKey(id)) {
                    if (!baubleMap.get(id).contains(bauble)) {
                        switch (manager) {
                            case POTION_RING_REGENERATION:
                            case POTION_RING_HASTE:
                            case POTION_RING_SPEED:
                            case POTION_RING_STRENGTH:
                            case POTION_RING_JUMP_BOOST:
                            case POTION_RING_RESISTANCE:
                            case MINERS_RING:
                            case SHIELD_HONOR:
                            case DRAGONS_EYE:
                            case STONE_SEA:
                            case PHANTOM_PRISM: {
                                new PotionBaubleTask((PotionBauble) bauble, rsvPlayer, plugin).startRunnable();
                                break;
                            }
                            case SCARLITE_RING: {
                                new ScarliteRingTask(rsvPlayer, plugin).startRunnable();
                                break;
                            }
                            case POLARIZED_STONE: {
                                new PolarizedStoneTask(rsvPlayer, plugin).startRunnable();
                                break;
                            }
                            case ENDER_QUEENS_CROWN: {
                                new EnderCrownTask(module, rsvPlayer, plugin).startRunnable();
                                break;
                            }
                        }
                    }
                }
                else {
                    switch (manager) {
                        case POTION_RING_REGENERATION:
                        case POTION_RING_HASTE:
                        case POTION_RING_SPEED:
                        case POTION_RING_STRENGTH:
                        case POTION_RING_JUMP_BOOST:
                        case POTION_RING_RESISTANCE:
                        case MINERS_RING:
                        case SHIELD_HONOR:
                        case DRAGONS_EYE:
                        case STONE_SEA:
                        case PHANTOM_PRISM: {
                            new PotionBaubleTask((PotionBauble) bauble, rsvPlayer, plugin).startRunnable();
                            break;
                        }
                        case SCARLITE_RING: {
                            new ScarliteRingTask(rsvPlayer, plugin).startRunnable();
                            break;
                        }
                        case POLARIZED_STONE: {
                            new PolarizedStoneTask(rsvPlayer, plugin).startRunnable();
                            break;
                        }
                        case ENDER_QUEENS_CROWN: {
                            new EnderCrownTask(module, rsvPlayer, plugin).startRunnable();
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
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked(); // get the player

        if (shouldEventBeRan(player)) {
            ItemStack corner = event.getClickedInventory().getItem(0);
            ItemStack cursor = event.getCursor();
            ItemStack current = event.getCurrentItem();

            Utils util = RealisticSurvivalPlugin.getUtil();

            if (RSVItem.isRSVItem(corner)) {
                if (Objects.equals(RSVItem.getNameFromItem(corner), "gui_glass")) {
                    if (cursor == null || !(util.hasNbtTag(cursor, "rsvbaubleslot") && RSVItem.isRSVItem(current))) {
                        event.setCancelled(true);
                    }
                    if (cursor.getAmount() > 1 || current.getAmount() > 1) {
                        event.setCancelled(true);
                    }
                    if (Objects.equals(RSVItem.getNameFromItem(current), "gui_glass")) {
                        event.setCancelled(true);
                    }
                    String cursorTag = util.getNbtTag(cursor, "rsvbaubleslot", PersistentDataType.STRING);
                    BaubleSlot slot = BaubleSlot.valueOf(util.getNbtTag(current, "rsvbaubleslot", PersistentDataType.STRING).toUpperCase());
                    if (cursorTag.equals(slot.getTag()) || cursorTag.equals("Any")) {
                        event.setCurrentItem(null);
                        Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, cursor, BaubleChangeEvent.BaubleChange.ADDITION));
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
            InventoryView view = event.getView();
            // if the bottom half of the inventory view is the player's own inventory
            if (view.getBottomInventory() instanceof PlayerInventory) {
                ItemStack corner = view.getTopInventory().getItem(0);

                if (RSVItem.isRSVItem(corner)) {
                    if (RSVItem.getNameFromItem(corner).equals("gui_glass")) {
                        event.setCancelled(true);
                    }
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
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName(BaubleModule.NAME);
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
                    DataModule module = (DataModule) rsvPlayer.getDataModuleFromName(BaubleModule.NAME);

                    if (module.getBaubleBag().hasBauble("poison_stone")) {
                        ConfigurationSection section = this.module.getUserConfig().getConfig().getConfigurationSection("Items.poison_stone.Effects");
                        Set<String> keys = section.getKeys(false);

                        for (String key : keys) {
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.getByName(key), section.getInt(key + ".Duration"),  section.getInt(key + ".Amplifier")));
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
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        // if the damaged entity is a player
        if (event.getEntity() instanceof Player) {
            EntityDamageEvent.DamageCause cause = event.getCause(); // get the damage cause
            Player player = (Player) event.getEntity(); // get the player

            if (shouldEventBeRan(player)) {
                FileConfiguration config = module.getUserConfig().getConfig();

                PlayerInventory inv = player.getInventory(); // get the player's inventory
                ItemStack itemOffHand = inv.getItemInOffHand(); // get the item in the player's off hand

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName(BaubleModule.NAME);

                BaubleInventory baubleInv = module.getBaubleBag();

                String offHandName = "";

                // if the item exists
                if (RSVItem.isRSVItem(itemOffHand)) {
                    offHandName = RSVItem.getNameFromItem(itemOffHand);
                }

                double damage = event.getDamage();

                boolean cobaltShield = baubleInv.hasBauble("cobalt_shield") || offHandName.equals("cobalt_shield") ? true : false;
                boolean obsShield = baubleInv.hasBauble("obsidian_shield") || offHandName.equals("obsidian_shield") ? true : false;
                boolean ankhShield = baubleInv.hasBauble("ankh_shield") || offHandName.equals("ankh_shield") ? true : false;

                if (cobaltShield || obsShield || ankhShield) {
                    RealisticSurvivalPlugin.getUtil().setZeroKb(player);
                }

                // check the cause of the damage
                switch (cause) {
                    // if the damage is caused by fire
                    case FIRE:
                    case FIRE_TICK: {
                        if (RSVItem.isRSVItem(itemOffHand)) {
                            offHandName = RSVItem.getNameFromItem(itemOffHand);
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

                if (player.getHealth() - event.getFinalDamage() <= 0D) {
                    if (baubleInv.hasBauble("broken_heart")) {
                        player.playEffect(EntityEffect.TOTEM_RESURRECT);
                        Utils.changeDurability(baubleInv.getItem("broken_heart"), 1);
                        event.setCancelled(true);
                    }
                }

                event.setDamage(damage);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onSleep(PlayerBedEnterEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            if (shouldEventBeRan(player)) {
                if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {

                }
            }
        }
    }

    /**
     * Activates the balloon ability if a player jumps
     * @param event The event called when a player moves
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerVelocity(PlayerVelocityEvent event)
    {
        Player player = event.getPlayer(); // get the player

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                FileConfiguration config = module.getUserConfig().getConfig();

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName(BaubleModule.NAME);

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
                            case LADDER, VINE, TWISTING_VINES, TWISTING_VINES_PLANT, WEEPING_VINES, WEEPING_VINES_PLANT -> {
                            }
                            default -> {
                                // check if the player's jump velocity is equal to the player's Y velocity
                                if (Utils.doublesEquals(velocity.getY(), jumpVelocity)) {
                                    // check if the player is not flying or swimming
                                    if (!(player.getLocation().getBlock().isLiquid() || player.isRiptiding() || player.isFlying())) {
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
     * @see Utils
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (shouldEventBeRan(entity)) {
            FileConfiguration config = module.getUserConfig().getConfig();

            Collection<String> drops = Arrays.asList("forbidden_fruit", "vitamins", "ring_overclocking", "shulker_heart", "bezoar", "ender_dragonscale");
            for (String drop : drops) {
                ConfigurationSection section = config.getConfigurationSection("Items." + drop + ".MobDrops");
                Set<String> keys = section.getKeys(false);

                for (String key : keys) {
                    if (entity.getType() == EntityType.valueOf(key)) {
                        Utils.harvestLooting(config.getConfigurationSection("Items." + drop + ".MobDrops." + key), RSVItem.getItem(drop), entity.getKiller().getInventory().getItemInMainHand(), entity.getLocation());
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
                ItemStack helmet = player.getInventory().getHelmet();

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = (DataModule) rsvPlayer.getDataModuleFromName(BaubleModule.NAME);

                BaubleInventory baubleInv = module.getBaubleBag();

                String offHandName = "";
                String helmetName = "";

                // if the item exists
                if (RSVItem.isRSVItem(itemOffHand)) {
                    offHandName = RSVItem.getNameFromItem(itemOffHand);
                }
                if (RSVItem.isRSVItem(helmet)) {
                    helmetName = RSVItem.getNameFromItem(helmet);
                }

                boolean ankhShield = baubleInv.hasBauble("ankh_shield") || offHandName.equals("ankh_shield") ? true : false;
                boolean sunglasses = baubleInv.hasBauble("sunglasses") || helmetName.equals("sunglasses") ? true : false;

                // if the new potion effect exists
                if (newEffect != null) {
                    // check the potion effect
                    switch (newEffect.getType().getName()) {
                        // if the potion effect is hunger
                        case "HUNGER":
                            // if the player has a forbidden fruit or any of its derivatives
                            if (baubleInv.hasBauble("forbidden_fruit") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                        // if the potion effect is hunger
                        case "SLOW":
                            // if the player has a ring of overclocking or any of its derivatives
                            if (baubleInv.hasBauble("ring_overclocking") || baubleInv.hasBauble("ring_free_action") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                        // if the potion effect is poison
                        case "POISON":
                            // if the player has a bezoar or any of its derivatives
                            if (baubleInv.hasBauble("bezoar") || baubleInv.hasBauble("mixed_color_dragonscale") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                        // if the potion effect is wither
                        case "WITHER":
                            // if the player has a black dragon scale or any of its derivatives
                            if (baubleInv.hasBauble("black_dragonscale_bauble") || baubleInv.hasBauble("mixed_color_dragonscale") ||
                                    baubleInv.hasBauble("ankh_charm") || baubleInv.hasBauble("wither_ring") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                        // if the potion effect is mining fatigue
                        case "SLOW_DIGGING":
                            // if the player has vitamins or any of its derivatives
                            if (baubleInv.hasBauble("vitamins") || baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                        // if the potion effect is blindness
                        case "BLINDNESS":
                        case "DARKNESS":
                            // if the player has sunglasses or any of its derivatives
                            if (sunglasses || baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                        // if the potion effect is levitation
                        case "LEVITATION":
                            // if the player has a shulker heart or any of its derivatives
                            if (baubleInv.hasBauble("shulker_heart") || baubleInv.hasBauble("ring_free_action") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                            break;
                    }
                }
            }

        }
    }
}