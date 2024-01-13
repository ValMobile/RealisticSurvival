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
package me.val_mobile.baubles;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.BaubleInventory;
import me.val_mobile.data.baubles.BaubleSlot;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.misc.PlayerItemAcquireEvent;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.PlayerJumpEvent;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.world.TimeSkipEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * BaubleEvents is a class containing listener methods
 * that activate abilities on entities
 * @author Val_Mobile
 * @version 1.2.8-DEV-0
 * @since 1.0
 */
public class BaubleEvents extends ModuleEvents implements Listener {

    /**
     * Dependency injecting the main and util class for use
     * The util class must be injected because its non-static methods are needed
     */
    private final RSVPlugin plugin;
    private final FileConfiguration config;
    private final BaubleModule module;

    // constructing the BaubleEvents class
    public BaubleEvents(BaubleModule module, RSVPlugin plugin) {
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

        if (!(shouldEventBeRan(player) && RSVItem.isRSVItem(cornerItem) && Objects.equals(RSVItem.getNameFromItem(cornerItem), "gui_glass")))
            return;

        if (RSVItem.isRSVItem(droppedItem)) {
            switch (RSVItem.getNameFromItem(droppedItem)) {
                case "gui_glass", "body_slot", "ring_slot", "charm_slot", "belt_slot", "amulet_slot", "head_slot" ->
                        event.setCancelled(true);
                default -> {
                    if (Objects.equals(RSVItem.getModuleNameFromItem(droppedItem), BaubleModule.NAME)) {
                        Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, droppedItem, BaubleChange.REMOVAL));
                    }
                }
            }
        }
        else if (Utils.isItemReal(droppedItem) && droppedItem.getType() == Material.PLAYER_HEAD) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!shouldEventBeRan(player))
            return;

        if (!module.getInv().containsPlayer(player)) {
            module.getInv().addPlayer(player);
        }

        if (!RSVPlayer.isValidPlayer(player))
            return;

        UUID id = event.getPlayer().getUniqueId();

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

        Collection<ItemStack> baubles = rsvPlayer.getBaubleDataModule().getBaubleBag().getAllBaubles();

        for (ItemStack item : baubles) {
            Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, item, BaubleChange.ADDITION));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && module.getInv().containsPlayer(player)))
            return;

        module.getInv().removePlayer(player);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player) && (event.getNewGameMode() == GameMode.ADVENTURE || event.getNewGameMode() == GameMode.SURVIVAL)))
            return;

        UUID id = event.getPlayer().getUniqueId();
        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

        Collection<ItemStack> baubles = rsvPlayer.getBaubleDataModule().getBaubleBag().getAllBaubles();

        for (ItemStack item : baubles) {
            Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, item, BaubleChange.ADDITION));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            if (!shouldEventBeRan(event.getFrom())) {
                if (!module.getInv().containsPlayer(player)) {
                    module.getInv().addPlayer(player);
                }

                if (!RSVPlayer.isValidPlayer(player))
                    return;

                UUID id = event.getPlayer().getUniqueId();
                RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

                Collection<ItemStack> baubles = rsvPlayer.getBaubleDataModule().getBaubleBag().getAllBaubles();

                for (ItemStack item : baubles) {
                    Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, item, BaubleChange.ADDITION));
                }
            }
        }
        else {
            if (module.getInv().containsPlayer(player)) {
                module.getInv().removePlayer(player);
            }
        }
    }

    @EventHandler
    public void onBaubleChangeEvent(BaubleChangeEvent event) {
        String itemName = event.getBaubleName();
        UUID id = event.getPlayer().getUniqueId();

        if (!RSVPlayer.isValidPlayer(id))
            return;

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

        if (event.getChange() == BaubleChange.ADDITION) {
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
                        case POTION_RING_REGENERATION, POTION_RING_HASTE, POTION_RING_SPEED, POTION_RING_STRENGTH, POTION_RING_JUMP_BOOST, POTION_RING_RESISTANCE, MINERS_RING, SHIELD_HONOR, DRAGONS_EYE, PHANTOM_PRISM, PRIDE_PENDANT -> {
                            if (!PotionBaubleTask.hasTask(id, manager.toString().toLowerCase())) {
                                new PotionBaubleTask(module, (PotionBauble) bauble, rsvPlayer, plugin).start();
                            }
                        }
                        case STONE_SEA -> {
                            if (!StoneSeaTask.hasTask(id)) {
                                new StoneSeaTask(module, rsvPlayer, plugin).start();
                            }

                            if (!PotionBaubleTask.hasTask(id, manager.toString().toLowerCase())) {
                                new PotionBaubleTask(module, (PotionBauble) bauble, rsvPlayer, plugin).start();
                            }
                        }
                        case SCARLITE_RING -> {
                            if (!ScarliteRingTask.hasTask(id)) {
                                new ScarliteRingTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        case POLARIZED_STONE -> {
                            if (!PolarizedStoneTask.hasTask(id)) {
                                new PolarizedStoneTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        case ENDER_QUEENS_CROWN -> {
                            if (!EnderCrownTask.hasTask(id)) {
                                new EnderCrownTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        case STONE_NEGATIVE_GRAVITY -> {
                            if (!StoneNegativeGravityTask.hasTask(id)) {
                                new StoneNegativeGravityTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        case STONE_GREATER_INERTIA -> {
                            if (!StoneGreaterInertiaTask.hasTask(id)) {
                                new StoneGreaterInertiaTask(module, rsvPlayer, plugin).start();
                            }
                        }
                        default -> {}
                    }
                }
            }
            else {
                if (itemName.equals("broken_heart")) {
                    module.getBrokenHeartPlayers().add(id);
                }
            }
        }
        else {
            if (itemName.equals("broken_heart")) {
                module.getBrokenHeartPlayers().remove(id);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (!(shouldEventBeRan(player) && config.getBoolean("DropBaublesUponDeath.Enabled") && RSVPlayer.isValidPlayer(player)))
            return;

        if (player.getWorld().getGameRuleValue(GameRule.KEEP_INVENTORY)) {
            if (config.getBoolean("DropBaublesUponDeath.IgnoreKeepInventoryGamerule")) {
                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().removeAndDropAllBaubles(player.getLocation());
            }
        }
        else {
            RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().removeAndDropAllBaubles(player.getLocation());
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

        if (!(shouldEventBeRan(player) && event.getClickedInventory() != null))
            return;

        ItemStack cursor = event.getCursor();

        ItemStack corner = event.getClickedInventory().getItem(0);
        ItemStack current = event.getCurrentItem();

        if (!(RSVItem.isRSVItem(corner) && RSVItem.getNameFromItem(corner).equals("gui_glass")))
            return;

        // bauble bag gui
        if (RSVItem.isRSVItem(current)) {
            String currentName = RSVItem.getNameFromItem(current);

            if (currentName.equals("gui_glass") || event.getClick() == ClickType.SWAP_OFFHAND)
                event.setCancelled(true);
            else {
                int rawSlot = event.getRawSlot();
                if (RSVItem.isRSVItem(cursor)) {
                    String cursorName = RSVItem.getNameFromItem(cursor);

                    if (!RSVItem.getNameFromItem(cursor).equals("gui_glass") && Utils.hasNbtTag(cursor, "rsvbaubleslot") && Utils.hasNbtTag(current, "rsvbaubleslot") && cursor.getAmount() == 1 && !Objects.equals(RSVItem.getNameFromItem(current), RSVItem.getNameFromItem(cursor)) && event.getClick() != ClickType.DOUBLE_CLICK) {
                        String cursorTag = Utils.getNbtTag(cursor, "rsvbaubleslot", PersistentDataType.STRING);

                        switch (cursorName) {
                            // cursor was a slot
                            case "body_slot", "ring_slot", "charm_slot", "belt_slot", "amulet_slot", "head_slot" ->
                                    event.setCancelled(true);
                            // current was a slot
                            default -> {
                                BaubleSlot currentSlot = null;

                                BaubleSlot[] slots = BaubleSlot.values();

                                outer:
                                for (BaubleSlot s : slots) {
                                    for (int i : s.getValues()) {
                                        if (i == rawSlot) {
                                            currentSlot = s;
                                            break outer;
                                        }
                                    }
                                }

                                if (currentSlot == null) {
                                    event.setCancelled(true);
                                }
                                else {
                                    if (cursorTag.equals(currentSlot.getTag()) || cursorTag.equals("Any")) {
                                        switch (currentName) {
                                            case "body_slot", "ring_slot", "charm_slot", "belt_slot", "amulet_slot", "head_slot" -> event.setCurrentItem(null);
                                            default -> {}
                                        }
                                        Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, cursor, BaubleChange.ADDITION));
                                    } else
                                        event.setCancelled(true);
                                }
                            }
                        }
                    }
                    else
                        event.setCancelled(true);
                }
                else {
                    if (Utils.isItemReal(cursor))
                        event.setCancelled(true);
                    else {
                        switch (currentName) {
                            case "head_slot", "body_slot", "amulet_slot", "ring_slot", "charm_slot", "belt_slot" -> event.setCancelled(true);
                            default -> {
                                if (event.getClick() == ClickType.NUMBER_KEY)
                                    event.setCancelled(true);
                                else {
                                    // taking bauble out
                                    outer:
                                    for (BaubleSlot baubleslot : BaubleSlot.values()) {
                                        for (int i : baubleslot.getValues()) {
                                            if (i == rawSlot) {
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        switch (event.getClick()) {
                                                            case CONTROL_DROP, DROP, SWAP_OFFHAND -> RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(i, baubleslot.getItem());
                                                            case MIDDLE -> {}
                                                            default -> {
                                                                event.getWhoClicked().setItemOnCursor(current);
                                                                RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule().getBaubleBag().getInventory().setItem(i, baubleslot.getItem());
                                                            }
                                                        }
                                                    }
                                                }.runTaskLater(plugin, 1L);
                                                break outer;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            // wormhole inventory gui
            if (Utils.isItemReal(current)) {
                if (current.getType() == Material.PLAYER_HEAD) {
                    UUID id = ((SkullMeta) current.getItemMeta()).getOwningPlayer().getUniqueId();
                    if (!player.getUniqueId().equals(id)) {
                        Player destination = Bukkit.getPlayer(id);

                        if (destination != null) {
                            player.teleport(destination);
                            if (config.getBoolean("WormholeInventory.Sound.Enabled")) {
                                String soundName = config.getString("WormholeInventory.Sound.Sound");
                                float volume = (float) config.getDouble("WormholeInventory.Sound.Volume");
                                float pitch = (float) config.getDouble("WormholeInventory.Sound.Pitch");
                                Utils.playSound(Bukkit.getPlayer(id).getLocation(), soundName, volume, pitch);
                            }
                        }
                    }
                }
            }
            event.setCancelled(true);
        }
    }

    /**
     * Activates the ender queen's crown ability if the player angers an enderman
     * while having the ender queen's crown in his/her inventory
     * @param event The event called when an entity is provoked by another entity
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTarget(EntityTargetEvent event) {
        Entity aggressor = event.getEntity();
        Entity target = event.getTarget();

        // if the attacker is an enderman and the aggressor is a player
        if (!(shouldEventBeRan(aggressor) && shouldEventBeRan(target) && aggressor instanceof Enderman))
            return;

        if (target instanceof Player player && RSVPlayer.isValidPlayer(player)) {
            // if the player has an ender queen's crown in his/her inventory
            RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
            DataModule module = rsvPlayer.getBaubleDataModule();

            if (module.getBaubleBag().hasBauble("ender_queens_crown") && config.getBoolean("Items.ender_queens_crown.PreventEndermenAngering")) {
                event.setCancelled(true);
            }
        }
        if (EndermanAllyUtils.isEndermanAlly(aggressor)) {
            UUID agOwnerId = EndermanAllyUtils.getOwnerId(aggressor);

            if (EndermanAllyUtils.isEndermanAlly(target) && config.getBoolean("Items.ender_queens_crown.PreventFriendlyFireToAllies") && EndermanAllyUtils.getOwnerId(target).equals(agOwnerId)) {
                event.setCancelled(true);
            }
            if (target instanceof Tameable tameable && tameable.getOwner() != null && config.getBoolean("Items.ender_queens_crown.PreventFriendlyFireToPets") && tameable.getOwner().getUniqueId().equals(agOwnerId)) {
                event.setCancelled(true);
            }
        }
    }

    /**
     * Activates various offensive and defensive baubles if a player is attacked
     * while having them in his/her inventory
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        Entity defender = event.getEntity();

        if (!(shouldEventBeRan(attacker) && shouldEventBeRan(defender) && attacker instanceof Player player && defender instanceof LivingEntity living && RSVPlayer.isValidPlayer(player)))
            return;

        double damage = event.getDamage();

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
        DataModule module = rsvPlayer.getBaubleDataModule();
        BaubleInventory inv = module.getBaubleBag();

        if (inv.hasBauble("wrath_pendant") && Utils.areCriticalHitConditionsMet(player, event.getDamage(), event.getFinalDamage()))
            ((PotionBauble) TickableBaubleManager.WRATH_PENDANT.getBauble()).ability(player, inv.getBaubleAmount("wrath_pendant"));

        if (inv.hasBauble("poison_stone")) {
            boolean isAffected = false;
            ConfigurationSection section = config.getConfigurationSection("Items.poison_stone.Effects");
            Set<String> keys = section.getKeys(false);

            for (String key : keys) {
                if (living.hasPotionEffect(PotionEffectType.getByName(key))) {
                    isAffected = true;
                }
                living.addPotionEffect(new PotionEffect(PotionEffectType.getByName(key), section.getInt(key + ".Duration"),  section.getInt(key + ".Amplifier")));
            }

            if (isAffected)
                damage *= config.getDouble("Items.poison_stone.AttackDamageMultiplier");
        }

        event.setDamage(damage);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDamageMonitor(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player player && RSVPlayer.isValidPlayer(player)))
            return;

        UUID id = player.getUniqueId();
        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);
        DataModule module = rsvPlayer.getBaubleDataModule();
        BaubleInventory inv = module.getBaubleBag();

        if (!(inv.hasBauble("ender_queens_crown") && EnderCrownTask.hasTask(id)))
            return;

        EnderCrownTask task = EnderCrownTask.getTasks().get(id);

        if (task.areAlliesEnabled() && task.canSpawnAllies(true))
            task.spawnAllies();
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
        if (!(event.getEntity() instanceof Player player && shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player))) {
            return;
        }

        EntityDamageEvent.DamageCause cause = event.getCause(); // get the damage cause
        PlayerInventory inv = player.getInventory(); // get the player's inventory
        ItemStack itemOffHand = inv.getItemInOffHand(); // get the item in the player's off hand
        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
        DataModule module = rsvPlayer.getBaubleDataModule();
        BaubleInventory baubleInv = module.getBaubleBag();
        String offHandName = "";

        // if the item exists
        if (RSVItem.isRSVItem(itemOffHand))
            offHandName = RSVItem.getNameFromItem(itemOffHand);

        double damage = event.getDamage();

        boolean cobaltShield = baubleInv.hasBauble("cobalt_shield") || offHandName.equals("cobalt_shield");
        boolean obsShield = baubleInv.hasBauble("obsidian_shield") || offHandName.equals("obsidian_shield");
        boolean ankhShield = baubleInv.hasBauble("ankh_shield") || offHandName.equals("ankh_shield");

        double kbMultiplier = -1;

        if (baubleInv.hasBauble("stone_greater_inertia"))
            kbMultiplier = config.getDouble("Items.stone_greater_inertia.KnockbackPercent");

        if (cobaltShield || obsShield || ankhShield || baubleInv.hasBauble("stone_inertia_null"))
            kbMultiplier = 0;

        if (kbMultiplier >= 0)
            Utils.setKbMultiplier(player, kbMultiplier);

        // check the cause of the damage
        switch (cause) {
            // if the damage is caused by fire
            case FIRE, FIRE_TICK -> {
                if (baubleInv.hasBauble("obsidian_skull"))
                    // reduce the damage by a specified amount
                    damage *= config.getDouble("Items.obsidian_skull.HeatDamageMultiplier");

                if (obsShield)
                    damage *= config.getDouble("Items.obsidian_shield.HeatDamageMultiplier");

                if (ankhShield)
                    damage *= config.getDouble("Items.ankh_shield.HeatDamageMultiplier");
            }

            // if the damage is caused by an explosion
            case ENTITY_EXPLOSION, BLOCK_EXPLOSION -> {
                // if the player has a shield of honor
                if (baubleInv.hasBauble("shield_honor"))
                    // reduce the damage by a specified amount
                    damage *= config.getDouble("Items.shield_honor.ExplosionDamageMultiplier");
            }

            // if the damage is caused by falling
            case FALL -> {
                double minFallDistance = 0D;
                double damageMultiplier = 1D;
                if (baubleInv.hasBauble("balloon")) {
                    minFallDistance = config.getDouble("Items.balloon.MinFallDistance");

                    // reduce the damage by a specified amount
                    damageMultiplier *= config.getDouble("Items.balloon.FallDamageMultiplier");

                }

                if (baubleInv.hasBauble("stone_greater_inertia")) {
                    minFallDistance += config.getDouble("Items.stone_greater_inertia.MinFallDistance");
                    damageMultiplier *= config.getDouble("Items.stone_greater_inertia.FallDamageMultiplier");
                }

                damage *= damageMultiplier;

                if (player.getFallDistance() <= minFallDistance)
                    // cancel the event to set the fall damage to 0
                    event.setCancelled(true);

                if (baubleInv.hasBauble("lucky_horseshoe") || baubleInv.hasBauble("stone_inertia_null"))
                    event.setCancelled(true);
            }

            // if the damage is caused by a cactus or berry bush
            case CONTACT -> {
                // if the player has a phytoprostasia amulet
                if (baubleInv.hasBauble(("phytoprostasia_amulet")))
                    event.setCancelled(true);
            }
        }

        if (baubleInv.hasBauble("cross_necklace"))
            player.setNoDamageTicks(config.getInt("Items.cross_necklace.InvFrameLength"));

        if (player.getHealth() - event.getFinalDamage() <= 0D) {
            if (baubleInv.hasBauble("broken_heart")) {
                ItemStack item = baubleInv.getItem("broken_heart");
                if (Utils.getCustomDurability(item) >= 1) {
                    Utils.changeDurability(item, -1, false, false, player);

                    if (config.getBoolean("Items.broken_heart.PlayTotemEffect"))
                        player.playEffect(EntityEffect.TOTEM_RESURRECT);

                    event.setCancelled(true);
                }
            }
        }

        event.setDamage(damage);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK && RSVPlayer.isValidPlayer(player)))
            return;

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());

        DataModule dataModule = rsvPlayer.getBaubleDataModule();

        if (dataModule.getBaubleBag().hasBauble("broken_heart") && !BrokenHeartRepairTask.hasTask(player.getUniqueId())) {
            new BrokenHeartRepairTask(plugin, module, rsvPlayer).start();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onSkip(TimeSkipEvent event) {
        World world = event.getWorld();

        if (!(shouldEventBeRan(world) && event.getSkipReason() == TimeSkipEvent.SkipReason.NIGHT_SKIP && config.getBoolean("Items.broken_heart.SleepRepair.Enabled")))
            return;

        Collection<UUID> ids = module.getBrokenHeartPlayers();

        for (UUID id : ids) {
            if (!RSVPlayer.isValidPlayer(id))
                continue;

            RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);
            DataModule dataModule = rsvPlayer.getBaubleDataModule();

            if (dataModule.getBaubleBag().hasBauble("broken_heart")) {
                Utils.changeDurability(dataModule.getBaubleBag().getItem("broken_heart"), 1, false, false, rsvPlayer.getPlayer());
            }

            if (BrokenHeartRepairTask.hasTask(id)) {
                BrokenHeartRepairTask.getTasks().get(id).stop();
            }
        }
    }

    /**
     * Activates the balloon ability if a player jumps
     * @param event The event called when a player jumps
     */
    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer(); // get the player

        if (!(shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player)))
            return;

        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(player.getUniqueId());
        DataModule module = rsvPlayer.getBaubleDataModule();

        BaubleInventory baubleInv = module.getBaubleBag();

        double jumpVelocity = 0.42; // default jump velocity

        // if the player has the jump boost effect
        if (player.hasPotionEffect(PotionEffectType.JUMP)) {
            PotionEffect jumpBoost = player.getPotionEffect(PotionEffectType.JUMP);  // get the jump boost effect

            // add the jump boost to the velocity to factor in the increased velocity
            jumpVelocity += ((double) jumpBoost.getAmplifier() + 1) * 0.1;
        }

        // if the player has a balloon
        if (baubleInv.hasBauble("balloon"))
            jumpVelocity *= config.getDouble("Items.balloon.JumpVelocityMultiplier");

        if (baubleInv.hasBauble("stone_greater_inertia"))
            jumpVelocity *= config.getDouble("Items.stone_greater_inertia.JumpVelocityMultiplier");

        // set the player's velocity to that velocity
        if (!Utils.doublesEquals(jumpVelocity, 0.42))
            player.setVelocity(player.getVelocity().setY(jumpVelocity));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCraft(CraftItemEvent event) {
        Player player = (Player) event.getView().getPlayer();

        if (!shouldEventBeRan(player))
            return;

        if (event.getRecipe() instanceof ShapelessRecipe shapeless && shapeless.getKey().getNamespace().equals("realisticsurvival")) {
            switch (shapeless.getKey().getKey()) {
                case "spectral_silt_broken_heart", "spectral_silt_balloon", "spectral_silt_cobalt_shield",
                    "spectral_silt_obsidian_shield", "spectral_silt_magic_mirror", "spectral_silt_wormhole_mirror",
                        "spectral_silt_lucky_horseshoe", "spectral_silt_sunglasses", "spectral_silt_cross_necklace",
                        "spectral_silt_sin_pendant", "spectral_silt_flare_gun", "spectral_silt_cracked_black_dragonscale",
                        "spectral_silt_diamond_block", "spectral_silt_emerald_block", "spectral_silt_cross_phantom_prism" -> {
                    CraftingInventory inv = event.getInventory();
                    ItemStack[] matrix = inv.getMatrix();

                    outer:
                    for (ItemStack item : matrix) {
                        if (RSVItem.isRSVItem(item)) {
                            if (RSVItem.getNameFromItem(item).equals("disintegration_tablet")) {
                                ItemStack[] contents = player.getInventory().getContents();

                                for (ItemStack i : contents) {
                                    if (!Utils.isItemReal(i)) {
                                        player.getInventory().addItem(item);
                                        break outer;
                                    }
                                }

                                player.getWorld().dropItemNaturally(player.getLocation(), item);
                                break;
                            }
                        }
                    }
                }
                default -> {}
            }
        }
        if (event.getRecipe() instanceof ShapedRecipe shaped && shaped.getKey().getNamespace().equals("realisticsurvival") && shaped.getKey().getKey().equals("spectral_silt_flare")) {
            CraftingInventory inv = event.getInventory();
            ItemStack[] matrix = inv.getMatrix();

            outer:
            for (ItemStack item : matrix) {
                if (!(RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).equals("disintegration_tablet")))
                    continue;

                ItemStack[] contents = player.getInventory().getContents();

                for (ItemStack i : contents) {
                    if (!Utils.isItemReal(i)) {
                        player.getInventory().addItem(item);
                        break outer;
                    }
                }

                player.getWorld().dropItemNaturally(player.getLocation(), item);
                break;
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
        if (!(event.getEntity() instanceof Player player && shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player)))
            return;

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
        if (newEffect == null)
            return;

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

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player)))
            return;

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();

            if (!RSVItem.isRSVItem(itemMainHand))
                return;

            switch (RSVItem.getNameFromItem(itemMainHand)) {
                case "bauble_bag" -> {
                    DataModule module = RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule();
                    player.openInventory(module.getBaubleBag().getInventory());
                }
                case "magic_mirror" -> {
                    if (!MagicMirrorTask.hasTask(player.getUniqueId())) {
                        player.openInventory(module.getInv().getInventory());

                        Location loc = player.getBedSpawnLocation() == null ? player.getWorld().getSpawnLocation() : player.getBedSpawnLocation();
                        player.teleport(loc);

                        if (config.getBoolean("Items.magic_mirror.Sound.Enabled")) {
                            String soundName = config.getString("Items.magic_mirror.Sound.Sound");
                            float volume = (float) config.getDouble("Items.magic_mirror.Sound.Volume");
                            float pitch = (float) config.getDouble("Items.magic_mirror.Sound.Pitch");
                            Utils.playSound(loc, soundName, volume, pitch);
                        }

                        new MagicMirrorTask(player, plugin).start();
                    }
                }
                case "wormhole_mirror" -> {
                    if (!WormholeMirrorTask.hasTask(player.getUniqueId())) {
                        player.openInventory(module.getInv().getInventory());
                        new WormholeMirrorTask(module, player, plugin).start();
                    }
                }
                default -> {}
            }
        }
        else if (event.getAction() == Action.LEFT_CLICK_AIR) {
            UUID id = player.getUniqueId();
            RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);
            DataModule module = rsvPlayer.getBaubleDataModule();

            if (module.getBaubleBag().hasBauble("stone_negative_gravity")) {
                Vector velocity = player.getVelocity();
                double increment = config.getDouble("Items.stone_negative_gravity.Flight.Increment");
                double temp;

                if (player.isSneaking()) {
                    temp = velocity.getY() - increment;
                    if (temp >= config.getDouble("Items.stone_negative_gravity.Flight.MaxDownwardVelocity")) {
                        player.setVelocity(velocity.setY(velocity.getY() - increment));
                    }
                }
                else {
                    temp = velocity.getY() + increment;
                    if (temp <= config.getDouble("Items.stone_negative_gravity.Flight.MaxUpwardVelocity")) {
                        player.setVelocity(velocity.setY(velocity.getY() + increment));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRegenerate(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof Player player && shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player) && player.getHealth() + event.getAmount() >= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()))
            return;

        UUID id = player.getUniqueId();
        RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(id);
        BaubleInventory inv = rsvplayer.getBaubleDataModule().getBaubleBag();

        if (inv.hasBauble("pride_pendant") && !PotionBaubleTask.hasTask(id, "pride_pendant")) {
            Bukkit.getServer().getPluginManager().callEvent(new BaubleChangeEvent(player, inv.getItem("pride_pendant"), BaubleChange.ADDITION));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player)))
            return;

        ItemStack item = event.getItem();
        if (RSVItem.isRSVItem(item)) {
            if (RSVItem.getNameFromItem(item).equals("recall_potion")) {
                Location loc = player.getBedSpawnLocation() == null ? player.getWorld().getSpawnLocation() : player.getBedSpawnLocation();
                player.teleport(loc);

                if (config.getBoolean("Items.recall_potion.Sound.Enabled")) {
                    String soundName = config.getString("Items.recall_potion.Sound.Sound");
                    float volume = (float) config.getDouble("Items.recall_potion.Sound.Volume");
                    float pitch = (float) config.getDouble("Items.recall_potion.Sound.Pitch");
                    Utils.playSound(loc, soundName, volume, pitch);
                }
            }
            else if (RSVItem.getNameFromItem(item).equals("wormhole_potion"))
                player.openInventory(module.getInv().getInventory());
        }

        UUID id = player.getUniqueId();
        RSVPlayer rsvPlayer = RSVPlayer.getPlayers().get(id);

        BaubleInventory inv = rsvPlayer.getBaubleDataModule().getBaubleBag();

        if (inv.hasBauble("gluttony_pendant"))
            ((PotionBauble) TickableBaubleManager.GLUTTONY_PENDANT.getBauble()).ability(player, inv.getBaubleAmount("gluttony_pendant"));
    }

    @EventHandler
    public void onItemAcquire(PlayerItemAcquireEvent event) {
        ItemStack item = event.getItem();
        EquipmentSlot loc = event.getLocation();

        if (!(RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).equals("stone_negative_gravity") && (loc == EquipmentSlot.HAND || loc == EquipmentSlot.OFF_HAND)))
            return;

        Player player = event.getPlayer();

        if (RSVPlayer.isValidPlayer(player) && player.isOnline() && !StoneNegativeGravityTask.hasTask(player.getUniqueId()))
            new StoneNegativeGravityTask(module, RSVPlayer.getPlayers().get(player.getUniqueId()), plugin).start();
    }
}