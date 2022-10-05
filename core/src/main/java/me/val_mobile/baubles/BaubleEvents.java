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
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

/**
 * BaubleEvents is a class containing listener methods
 * that activate abilities on entities
 * @author Val_Mobile
 * @version 1.2.3
 * @since 1.0
 */
public class BaubleEvents extends ModuleEvents implements Listener {

    /**
     * Dependency injecting the main and util class for use
     * The util class must be injected because its non-static methods are needed
     */
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final BaubleModule module;

    // constructing the BaubleEvents class
    public BaubleEvents(BaubleModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
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
                        switch (RSVItem.getNameFromItem(droppedItem)) {
                            case "gui_glass", "body_slot", "ring_slot", "charm_slot", "belt_slot", "amulet_slot", "head_slot" -> {
                                event.setCancelled(true);
                            }
                            default -> {
                                if (Objects.equals(RSVItem.getModuleNameFromItem(droppedItem), BaubleModule.NAME)) {
                                    Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, droppedItem, BaubleChangeEvent.BaubleChange.REMOVAL));
                                }
                            }
                        }
                    }
                    else {
                        if (Utils.isItemReal(droppedItem)) {
                            if (droppedItem.getType() == Material.PLAYER_HEAD) {
                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (shouldEventBeRan(p)) {
            if (!module.getInv().containsPlayer(p)) {
                module.getInv().addPlayer(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        if (shouldEventBeRan(p)) {
            if (module.getInv().containsPlayer(p)) {
                module.getInv().removePlayer(p);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        if (shouldEventBeRan(p)) {
            if (!shouldEventBeRan(event.getFrom())) {
                if (!module.getInv().containsPlayer(p)) {
                    module.getInv().addPlayer(p);
                }
            }
        }
        else {
            if (module.getInv().containsPlayer(p)) {
                module.getInv().removePlayer(p);
            }
        }
    }

    @EventHandler
    public void onBaubleChangeEvent(BaubleChangeEvent event) {
        String itemName = event.getBaubleName();
        UUID id = event.getPlayer().getUniqueId();

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

        if (event.getChange() == BaubleChangeEvent.BaubleChange.ADDITION) {
            boolean isValid = true;
            TickableBaubleManager manager = null;
            try {
                manager = TickableBaubleManager.valueOf(itemName.toUpperCase());
            }
            catch (IllegalArgumentException e) {
                // ignored
                isValid = false;
            }

            if (isValid) {
                Tickable bauble = manager.getBauble();
                if (bauble != null) {
                    switch (manager) {
                        case POTION_RING_REGENERATION, POTION_RING_HASTE, POTION_RING_SPEED, POTION_RING_STRENGTH, POTION_RING_JUMP_BOOST, POTION_RING_RESISTANCE, MINERS_RING, SHIELD_HONOR, DRAGONS_EYE, PHANTOM_PRISM -> {
                            if (!PotionBaubleTask.hasTask(id, manager.toString().toLowerCase())) {
                                new PotionBaubleTask((PotionBauble) bauble, rsvPlayer, plugin).start();
                            }
                        }
                        case STONE_SEA -> {
                            if (!PotionBaubleTask.hasTask(id, manager.toString().toLowerCase())) {
                                new PotionBaubleTask((PotionBauble) bauble, rsvPlayer, plugin).start();
                            }

                            if (!StoneSeaTask.hasTask(id)) {
                                new StoneSeaTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        case SCARLITE_RING -> {
                            if (!ScarliteRingTask.hasTask(id)) {
                                new ScarliteRingTask(rsvPlayer, plugin).start();
                            }
                        }
                        case POLARIZED_STONE -> {
                            if (!PolarizedStoneTask.hasTask(id)) {
                                new PolarizedStoneTask(rsvPlayer, plugin).start();
                            }
                        }
                        case ENDER_QUEENS_CROWN -> {
                            if (!EnderCrownTask.hasTask(id)) {
                                new EnderCrownTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        default -> {}
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
            if (event.getClickedInventory() != null) {
                ItemStack corner = event.getClickedInventory().getItem(0);
                ItemStack cursor = event.getCursor();
                ItemStack current = event.getCurrentItem();

                Utils util = RealisticSurvivalPlugin.getUtil();

                if (RSVItem.isRSVItem(corner)) {
                    if (RSVItem.getNameFromItem(corner).equals("gui_glass")) {
                        if (RSVItem.isRSVItem(current)) {
                            String currentName = RSVItem.getNameFromItem(current);
                            // if player clicks a gui glass
                            if (currentName.equals("gui_glass"))
                                event.setCancelled(true);
                            else {
                                if (RSVItem.isRSVItem(cursor)) {
                                    String cursorName = RSVItem.getNameFromItem(cursor);
                                    if (RSVItem.getNameFromItem(cursor).equals("gui_glass"))
                                        event.setCancelled(true);
                                    if (util.hasNbtTag(cursor, "rsvbaubleslot") && util.hasNbtTag(current, "rsvbaubleslot")) {
                                        String cursorTag = util.getNbtTag(cursor, "rsvbaubleslot", PersistentDataType.STRING);

                                        switch (cursorName) {
                                            // cursor was a slot
                                            case "body_slot", "ring_slot", "charm_slot", "belt_slot", "amulet_slot", "head_slot" -> {
                                                event.setCancelled(true);
                                            }
                                            // current was a slot
                                            default -> {
                                                if (currentName.equals(cursorName)) {
                                                    event.setCancelled(true);
                                                }
                                                else {
                                                    String currentSlot = util.getNbtTag(current, "rsvbaubleslot", PersistentDataType.STRING).toUpperCase();

                                                    if (currentSlot.equals("RING")) {
                                                        currentSlot = event.getSlot() == BaubleSlot.FIRST_RING.getValue() ? BaubleSlot.FIRST_RING.toString() : BaubleSlot.SECOND_RING.toString();
                                                    }
                                                    BaubleSlot slot = BaubleSlot.valueOf(currentSlot);
                                                    if (cursorTag.equals(slot.getTag()) || cursorTag.equals("Any")) {
                                                        event.setCurrentItem(null);
                                                        Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, cursor, BaubleChangeEvent.BaubleChange.ADDITION));
                                                    } else if (cursorTag.contains("Ring") && slot.getTag().contains("Ring")) {
                                                        event.setCurrentItem(null);
                                                        Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, cursor, BaubleChangeEvent.BaubleChange.ADDITION));
                                                    } else
                                                        event.setCancelled(true);
                                                }
                                            }
                                        }
                                    } else
                                        event.setCancelled(true);
                                }
                                else {
                                    if (Utils.isItemReal(cursor)) {
                                        event.setCancelled(true);
                                    }
                                    else {
                                        switch (currentName) {
                                            case "head_slot", "body_slot", "amulet_slot", "ring_slot", "charm_slot", "belt_slot" -> {event.setCancelled(true);}
                                            default -> {
                                                // taking bauble out
                                                switch (event.getRawSlot()) {
                                                    case 12 -> {
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                event.getWhoClicked().setItemOnCursor(current.clone());
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(12, RSVItem.getItem("head_slot"));
                                                            }
                                                        }.runTaskLater(plugin, 1L);
                                                    }
                                                    case 21 -> {
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                event.getWhoClicked().setItemOnCursor(current.clone());
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(21, RSVItem.getItem("amulet_slot"));
                                                            }
                                                        }.runTaskLater(plugin, 1L);
                                                    }
                                                    case 30 -> {
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                event.getWhoClicked().setItemOnCursor(current.clone());
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(30, RSVItem.getItem("body_slot"));
                                                            }
                                                        }.runTaskLater(plugin, 1L);
                                                    }
                                                    case 14, 23 -> {
                                                        int slot = event.getSlot();
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                event.getWhoClicked().setItemOnCursor(current.clone());
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(slot, RSVItem.getItem("ring_slot"));
                                                            }
                                                        }.runTaskLater(plugin, 1L);

                                                    }
                                                    case 32 -> {
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                event.getWhoClicked().setItemOnCursor(current.clone());
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(32, RSVItem.getItem("charm_slot"));
                                                            }
                                                        }.runTaskLater(plugin, 1L);

                                                    }
                                                    case 31 -> {
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                event.getWhoClicked().setItemOnCursor(current.clone());
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(31, RSVItem.getItem("belt_slot"));
                                                            }
                                                        }.runTaskLater(plugin, 1L);
                                                    }
                                                    default -> {}
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            if (Utils.isItemReal(current)) {
                                if (current.getType() == Material.PLAYER_HEAD) {
                                    UUID id = ((SkullMeta) current.getItemMeta()).getOwningPlayer().getUniqueId();
                                    player.teleport(Bukkit.getPlayer(id));
                                    if (config.getBoolean("WormholeInventory.Sound.Enabled")) {
                                        String soundName = config.getString("WormholeInventory.Sound.Sound");
                                        float volume = (float) config.getDouble("WormholeInventory.Sound.Volume");
                                        float pitch = (float) config.getDouble("WormholeInventory.Sound.Pitch");
                                        Utils.playSound(Bukkit.getPlayer(id).getLocation(), soundName, volume, pitch);
                                    }
                                    event.setCancelled(true);
                                }
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
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTarget(EntityTargetEvent event) {
        // if the attacker is an enderman and the aggressor is a player
        if (event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            Player player = (Player) event.getTarget(); // get the player

            if (shouldEventBeRan(player)) {
                // if the player has an ender queen's crown in his/her inventory
                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = rsvPlayer.getBaubleDataModule();
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
                    DataModule module = rsvPlayer.getBaubleDataModule();

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
                PlayerInventory inv = player.getInventory(); // get the player's inventory
                ItemStack itemOffHand = inv.getItemInOffHand(); // get the item in the player's off hand

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = rsvPlayer.getBaubleDataModule();

                BaubleInventory baubleInv = module.getBaubleBag();

                String offHandName = "";

                // if the item exists
                if (RSVItem.isRSVItem(itemOffHand)) {
                    offHandName = RSVItem.getNameFromItem(itemOffHand);
                }

                double damage = event.getDamage();

                boolean cobaltShield = baubleInv.hasBauble("cobalt_shield") || offHandName.equals("cobalt_shield");
                boolean obsShield = baubleInv.hasBauble("obsidian_shield") || offHandName.equals("obsidian_shield");
                boolean ankhShield = baubleInv.hasBauble("ankh_shield") || offHandName.equals("ankh_shield");

                if (cobaltShield || obsShield || ankhShield) {
                    RealisticSurvivalPlugin.getUtil().setZeroKb(player);
                }

                // check the cause of the damage
                switch (cause) {
                    // if the damage is caused by fire
                    case FIRE, FIRE_TICK -> {
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
                    }

                    // if the damage is caused by an explosion
                    case ENTITY_EXPLOSION, BLOCK_EXPLOSION -> {
                        // if the player has a shield of honor
                        if (baubleInv.hasBauble(("shield_honor"))) {
                            // reduce the damage by a specified amount
                            damage *= config.getDouble("Items.shield_honor.ExplosionDamageMultiplier");
                        }
                    }

                    // if the damage is caused by falling
                    case FALL -> {
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
                    }

                    // if the damage is caused by a cactus or berry bush
                    case CONTACT -> {
                        // if the player has a phytoprostasia amulet
                        if (baubleInv.hasBauble(("phytoprostasia_amulet"))) {
                            event.setCancelled(true);
                        }
                    }
                }

                if (baubleInv.hasBauble(("cross_necklace"))) {
                    player.setNoDamageTicks(config.getInt("Items.cross_necklace.InvFrameLength"));
                }

                if (player.getHealth() - event.getFinalDamage() <= 0D) {
                    if (baubleInv.hasBauble("broken_heart")) {
                        ItemStack item = baubleInv.getItem("broken_heart");
                        if (RSVItem.hasCustomDurability(item)) {
                            if (RSVItem.getCustomDurability(item) >= 1) {
                                Utils.changeDurability(item, -1, false);
                                player.playEffect(EntityEffect.TOTEM_RESURRECT);
                                event.setCancelled(true);
                            }
                        }
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
                    RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());

                    DataModule dataModule = rsvPlayer.getBaubleDataModule();

                    if (dataModule.getBaubleBag().hasBauble("broken_heart")) {
                        if (!BrokenHeartRepairTask.hasTask(player.getUniqueId())) {
                            new BrokenHeartRepairTask(plugin, module, rsvPlayer).start();
                        }
                    }
                }
            }
        }
    }



    /**
     * Activates the balloon ability if a player jumps
     * @param event The event called when a player moves
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerVelocity(PlayerMoveEvent event)
    {
        Player player = event.getPlayer(); // get the player

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = rsvPlayer.getBaubleDataModule();

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
                            case LADDER, VINE, TWISTING_VINES, TWISTING_VINES_PLANT, WEEPING_VINES, WEEPING_VINES_PLANT -> {}
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
            Collection<String> drops = List.of("forbidden_fruit", "vitamins", "ring_overclocking", "shulker_heart", "bezoar", "ender_dragonscale");
            for (String drop : drops) {
                ConfigurationSection section = config.getConfigurationSection("Items." + drop + ".MobDrops");
                Set<String> keys = section.getKeys(false);

                for (String key : keys) {
                    if (entity.getType() == EntityType.valueOf(key)) {
                        if (entity.getKiller() != null) {
                            Utils.harvestLooting(config.getConfigurationSection("Items." + drop + ".MobDrops." + key), RSVItem.getItem(drop), entity.getKiller().getInventory().getItemInMainHand(), entity.getLocation());
                        }
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
        if (event.getEntity() instanceof Player player) {
            if (shouldEventBeRan(player)) {
                PotionEffect newEffect = event.getNewEffect(); // get the new effect
                ItemStack itemOffHand = player.getInventory().getItemInOffHand(); // get the new effect
                ItemStack helmet = player.getInventory().getHelmet();

                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                DataModule module = rsvPlayer.getBaubleDataModule();

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

                boolean ankhShield = baubleInv.hasBauble("ankh_shield") || offHandName.equals("ankh_shield");
                boolean sunglasses = baubleInv.hasBauble("sunglasses") || helmetName.equals("sunglasses");

                // if the new potion effect exists
                if (newEffect != null) {
                    // check the potion effect
                    switch (newEffect.getType().getName()) {
                        // if the potion effect is hunger
                        case "HUNGER" -> {
                            // if the player has a forbidden fruit or any of its derivatives
                            if (baubleInv.hasBauble("forbidden_fruit") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }

                        // if the potion effect is slowness
                        case "SLOW" -> {
                            // if the player has a ring of overclocking or any of its derivatives
                            if (baubleInv.hasBauble("ring_overclocking") || baubleInv.hasBauble("ring_free_action") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }

                        // if the potion effect is poison
                        case "POISON" -> {
                            // if the player has a bezoar or any of its derivatives
                            if (baubleInv.hasBauble("bezoar") || baubleInv.hasBauble("mixed_color_dragonscale") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }

                        // if the potion effect is wither
                        case "WITHER" -> {
                            // if the player has a black dragon scale or any of its derivatives
                            if (baubleInv.hasBauble("black_dragonscale_bauble") || baubleInv.hasBauble("mixed_color_dragonscale") ||
                                    baubleInv.hasBauble("ankh_charm") || baubleInv.hasBauble("wither_ring") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }

                        // if the potion effect is mining fatigue
                        case "SLOW_DIGGING" -> {
                            // if the player has vitamins or any of its derivatives
                            if (baubleInv.hasBauble("vitamins") || baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }

                        // if the potion effect is blindness
                        case "BLINDNESS", "DARKNESS" -> {
                            // if the player has sunglasses or any of its derivatives
                            if (sunglasses || baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }

                        // if the potion effect is levitation
                        case "LEVITATION" -> {
                            // if the player has a shulker heart or any of its derivatives
                            if (baubleInv.hasBauble("shulker_heart") || baubleInv.hasBauble("ring_free_action") ||
                                    baubleInv.hasBauble("ankh_charm") || ankhShield) {
                                // cancel the event to stop the effect from being added
                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }

        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (shouldEventBeRan(p)) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                ItemStack itemMainHand = p.getInventory().getItemInMainHand();

                if (RSVItem.isRSVItem(itemMainHand)) {
                    switch (RSVItem.getNameFromItem(itemMainHand)) {
                        case "bauble_bag" -> {
                            DataModule module = RSVPlayer.getPlayers().get(p.getUniqueId()).getBaubleDataModule();
                            p.openInventory(module.getBaubleBag().getInventory());
                        }
                        case "magic_mirror" -> {
                            Location loc = p.getBedSpawnLocation() == null ? p.getWorld().getSpawnLocation() : p.getBedSpawnLocation();
                            p.teleport(loc);

                            if (config.getBoolean("Items.magic_mirror.Sound.Enabled")) {
                                String soundName = config.getString("Items.magic_mirror.Sound.Sound");
                                float volume = (float) config.getDouble("Items.magic_mirror.Sound.Volume");
                                float pitch = (float) config.getDouble("Items.magic_mirror.Sound.Pitch");
                                Utils.playSound(loc, soundName, volume, pitch);
                            }
                        }
                        case "wormhole_mirror" -> p.openInventory(module.getInv().getInventory());
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onConsume(PlayerItemConsumeEvent event) {
        if (!event.isCancelled()) {
            Player p =event.getPlayer();
            if (shouldEventBeRan(p)) {

                ItemStack item = event.getItem();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).equals("recall_potion")) {
                        Location loc = p.getBedSpawnLocation() == null ? p.getWorld().getSpawnLocation() : p.getBedSpawnLocation();
                        p.teleport(loc);

                        if (config.getBoolean("Items.recall_potion.Sound.Enabled")) {
                            String soundName = config.getString("Items.recall_potion.Sound.Sound");
                            float volume = (float) config.getDouble("Items.recall_potion.Sound.Volume");
                            float pitch = (float) config.getDouble("Items.recall_potion.Sound.Pitch");
                            Utils.playSound(loc, soundName, volume, pitch);
                        }
                    }
                    else if (RSVItem.getNameFromItem(item).equals("wormhole_potion"))
                        p.openInventory(module.getInv().getInventory());
                }
            }
        }
    }
}