package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
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
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class BaubleEvents implements Listener {

    private final RLCraft plugin;
    private final BaubleRunnables baubleRunnables = new BaubleRunnables();
    private final BaubleAbilities baubleAbilities = new BaubleAbilities();
    private final Utils util;
    public BaubleEvents(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Utils.resetBaubleMaps(player);
        Utils.updateBaubleValues(player);

        util.startPrResRunnable(player);
        util.startPrStrengthRunnable(player);
        util.startPrSpeedRunnable(player);
        util.startPrJumpRunnable(player);
        util.startPrHasteRunnable(player);
        util.startPrRegenRunnable(player);

        util.startScarliteRingRunnable(player);
        util.startDragonsEyeRunnable(player);
        util.startMinersRingRunnable(player);
        util.startShieldHonorRunnable(player);

        for (Recipe r : Recipes.getBaubleRecipes()) {
            if (r instanceof ShapedRecipe) {
                player.discoverRecipe(((ShapedRecipe) r).getKey());
            }
            else if (r instanceof ShapelessRecipe) {
                player.discoverRecipe(((ShapelessRecipe) r).getKey());
            }
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Utils.resetBaubleMaps(event.getEntity());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Utils.resetBaubleMaps(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!event.isCancelled()) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player) {
                Player player = (Player) entity;
                ItemStack item = event.getItem().getItemStack();
                if (! (item == null || item.getType() == Material.AIR) ) {
                    NBTItem nbti = new NBTItem(item);
                    if (nbti.hasKey("Bauble")) {
                        switch (nbti.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrResValues(player);
                                        util.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrRegenValues(player);
                                        util.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrStrengthValues(player);
                                        util.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrSpeedValues(player);
                                        util.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrJumpValues(player);
                                        util.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrHasteValues(player);
                                        util.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateMinersRingValues(player);
                                        util.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateScarliteRingValues(player);
                                        util.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateDragonsEyeValues(player);
                                        util.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateShieldHonorValues(player);
                                        util.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemThrow(PlayerDropItemEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            NBTItem item = new NBTItem(event.getItemDrop().getItemStack());
            if (item.hasKey("Bauble")) {
                switch (item.getString("Bauble")) {
                    case "Potion Ring of Resistance":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updatePrResValues(player);
                                util.startPrResRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Potion Ring of Regeneration":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updatePrRegenValues(player);
                                util.startPrRegenRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Potion Ring of Strength":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updatePrStrengthValues(player);
                                util.startPrStrengthRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Potion Ring of Speed":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updatePrSpeedValues(player);
                                util.startPrSpeedRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Potion Ring of Jump Boost":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updatePrJumpValues(player);
                                util.startPrJumpRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Potion Ring of Haste":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updatePrHasteValues(player);
                                util.startPrHasteRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Miner's Ring":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updateMinersRingValues(player);
                                util.startMinersRingRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Scarlite Ring":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updateScarliteRingValues(player);
                                util.startScarliteRingRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Dragon's Eye":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updateDragonsEyeValues(player);
                                util.startDragonsEyeRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                    case "Shield of Honor":
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Utils.updateShieldHonorValues(player);
                                util.startShieldHonorRunnable(player);
                            }
                        }.runTaskLater(plugin, 1L);
                        break;
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        if (!event.isCancelled()) {
            Player player = (Player) event.getWhoClicked();
            if (event.getView().getBottomInventory() instanceof PlayerInventory) {
                if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
                    NBTItem item = new NBTItem(event.getCursor());
                    if (item.hasKey("Bauble")) {
                        switch (item.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrResValues(player);
                                        util.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrRegenValues(player);
                                        util.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrStrengthValues(player);
                                        util.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrSpeedValues(player);
                                        util.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrJumpValues(player);
                                        util.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrHasteValues(player);
                                        util.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateMinersRingValues(player);
                                        util.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateScarliteRingValues(player);
                                        util.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateDragonsEyeValues(player);
                                        util.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateShieldHonorValues(player);
                                        util.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }

                }
                if (! (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) ) {
                    NBTItem item = new NBTItem(event.getCurrentItem());
                    if (item.hasKey("Bauble")) {
                        switch (item.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrResValues(player);
                                        util.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrRegenValues(player);
                                        util.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrStrengthValues(player);
                                        util.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrSpeedValues(player);
                                        util.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrJumpValues(player);
                                        util.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrHasteValues(player);
                                        util.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateMinersRingValues(player);
                                        util.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateScarliteRingValues(player);
                                        util.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateDragonsEyeValues(player);
                                        util.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateShieldHonorValues(player);
                                        util.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }
                }
            }

        }

    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDragClick(InventoryDragEvent event) {
        if (!event.isCancelled()) {
            Player player = (Player) event.getWhoClicked();
            if (event.getView().getBottomInventory() instanceof PlayerInventory) {
                if (! (event.getOldCursor() == null || event.getOldCursor().getType() == Material.AIR) ) {
                    NBTItem item = new NBTItem(event.getOldCursor());
                    if (item.hasKey("Bauble")) {
                        switch (item.getString("Bauble")) {
                            case "Potion Ring of Resistance":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrResValues(player);
                                        util.startPrResRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Regeneration":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrRegenValues(player);
                                        util.startPrRegenRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Strength":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrStrengthValues(player);
                                        util.startPrStrengthRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Speed":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrSpeedValues(player);
                                        util.startPrSpeedRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Jump Boost":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrJumpValues(player);
                                        util.startPrJumpRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Potion Ring of Haste":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updatePrHasteValues(player);
                                        util.startPrHasteRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Miner's Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateMinersRingValues(player);
                                        util.startMinersRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Scarlite Ring":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateScarliteRingValues(player);
                                        util.startScarliteRingRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Dragon's Eye":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateDragonsEyeValues(player);
                                        util.startDragonsEyeRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                            case "Shield of Honor":
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Utils.updateShieldHonorValues(player);
                                        util.startShieldHonorRunnable(player);
                                    }
                                }.runTaskLater(plugin, 1L);
                                break;
                        }
                    }

                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTarget(EntityTargetEvent event) {
        if (event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            Player player = (Player) event.getTarget();
            if (player.getInventory().containsAtLeast(CustomItems.getEnderQueensCrown(), 1))
                event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!event.isCancelled()) {
            if (event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                Entity entity = event.getEntity();
                if (player.getInventory().containsAtLeast(CustomItems.getPoisonStone(), 1)) {
                    baubleAbilities.PoisonStoneAbility((LivingEntity) entity);
                }

            }
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                NBTItem itemOffHand = null;
                if (! (player.getInventory().getItemInOffHand() == null || player.getInventory().getItemInOffHand().getType() == Material.AIR) ) {
                    itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                }
                if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                    itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                    if (itemOffHand.hasKey("Bauble")) {
                        switch (itemOffHand.getString("Bauble")) {
                            case "Cobalt Shield":
                            case "Obsidian Shield":
                            case "Ankh Shield":
                                baubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            EntityDamageEvent.DamageCause cause = event.getCause();
            Player player = (Player) event.getEntity();
            PlayerInventory inv = player.getInventory();
            NBTItem itemOffHand = null;
            if (! (player.getInventory().getItemInOffHand() == null || player.getInventory().getItemInOffHand().getType() == Material.AIR) ) {
                itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
            }

            switch (cause) {
                case FIRE:
                case FIRE_TICK:
                case LAVA:
                case HOT_FLOOR: {
                    if (inv.containsAtLeast(CustomItems.getObsidianSkull(), 1)) {
                        event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ObsidianSkull.HeatDamageMultiplier"));
                    }
                    else if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                        if (itemOffHand.hasKey("Bauble")) {
                            if (itemOffHand.getString("Bauble").equals("Obsidian Shield"))
                                event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ObsidianShield.HeatDamageMultiplier"));
                            else if (itemOffHand.getString("Bauble").equals("Ankh Shield"))
                                event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("AnkhShield.HeatDamageMultiplier"));
                        }
                    }
                }
                case ENTITY_EXPLOSION:
                case BLOCK_EXPLOSION: {
                    if (! (itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR) ) {
                        if (itemOffHand.hasKey("Bauble")) {
                            switch (itemOffHand.getString("Bauble")) {
                                case "Cobalt Shield":
                                case "Obsidian Shield":
                                case "Ankh Shield":
                                    baubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
                            }
                        }
                    }
                    if (player.getInventory().containsAtLeast(CustomItems.getShieldHonor(), 1)) {
                        event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("ShieldHonor.ExplosionDamageMultiplier"));
                    }
                }
                case FALL: {
                    if (player.getInventory().containsAtLeast(CustomItems.getBalloon(), 1))
                        if (player.getFallDistance() <= CustomConfig.getBaubleConfig().getDouble("Balloon.MinFallDistance")) {
                            event.setCancelled(true);
                        }
                        else {
                            event.setDamage(event.getDamage() * CustomConfig.getBaubleConfig().getDouble("Balloon.FallDamageMultiplier"));
                        }
                    if (player.getInventory().containsAtLeast(CustomItems.getLuckyHorseshoe(), 1))
                        event.setCancelled(true);
                }
                case CONTACT: {
                    if (player.getInventory().containsAtLeast(CustomItems.getPhytoprostasiaAmulet(), 1))
                        event.setCancelled(true);
                }
            }

            if (PlayerRunnable.getCrossNecklace().containsKey(player.getName())) {
                if (PlayerRunnable.getCrossNecklace().get(player.getName())) {
                    event.setCancelled(true);
                }
            }

            if (player.getInventory().containsAtLeast(CustomItems.getCrossNecklace(), 1)) {
                Utils.setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), player.getName(), true);
                baubleRunnables.removeInvFrames(player).runTaskLater(plugin, CustomConfig.getBaubleConfig().getInt("CrossNecklace.InvFrameLength"));
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        if (!event.isCancelled()) {
            if (event.getPlayer().getInventory().containsAtLeast(CustomItems.getBalloon(), 1)) {
                Player player = event.getPlayer();
                Vector velocity = player.getVelocity();
                // Check if the player is moving "up"
                if (velocity.getY() > 0)
                {
                    // Default jump velocity
                    double jumpVelocity = 0.42D; // Default jump velocity
                    if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                        PotionEffect jumpPotion = player.getPotionEffect(PotionEffectType.JUMP);
                        // If player has jump potion add it to jump velocity
                        jumpVelocity += ((double) jumpPotion.getAmplifier() + 1) * 0.1D;

                    }
                    // Check if player is not on ladder and if jump velocity calculated is equals to player Y velocity
                    if (player.getLocation().getBlock().getType() != Material.LADDER &&
                            player.getLocation().getBlock().getType() != Material.VINE &&
                            player.getLocation().getBlock().getType() != Material.TWISTING_VINES &&
                            player.getLocation().getBlock().getType() != Material.WEEPING_VINES
                            && Math.abs(velocity.getY() - jumpVelocity) <= 0.01)
                    {
                        if ( !(player.isInWater() || player.isRiptiding() || player.isFlying()) ) {
                            velocity.setY(jumpVelocity * CustomConfig.getBaubleConfig().getDouble("Balloon.JumpVelocityMultiplier"));
                            player.setVelocity(velocity);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        switch (event.getEntity().getType()) {
            case ENDER_DRAGON: {
                Random r = new Random();
                double chance = CustomConfig.getBaubleConfig().getDouble("EnderDragonScale.DropChance");
                if (CustomConfig.getBaubleConfig().getBoolean("EnderDragonScale.CheckLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (!(player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR)) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            CustomItems.getEnderDragonScale());
                }
                break;
            }
            case HUSK: {
                Random r = new Random();
                double chance = CustomConfig.getBaubleConfig().getDouble("ForbiddenFruit.DropChance");
                if (CustomConfig.getBaubleConfig().getBoolean("ForbiddenFruit.CheckLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (!(player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR)) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            CustomItems.getForbiddenFruit());
                }
                break;
            }
            case STRAY: {
                Random r = new Random();
                double chance = CustomConfig.getBaubleConfig().getDouble("RingOverclocking.DropChance");
                if (CustomConfig.getBaubleConfig().getBoolean("RingOverclocking.CheckLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            CustomItems.getRingofOverclocking());
                }
                break;
            }
            case ELDER_GUARDIAN: {
                Random r = new Random();
                double chance = CustomConfig.getBaubleConfig().getDouble("Vitamins.DropChance");
                if (CustomConfig.getBaubleConfig().getBoolean("Vitamins.CheckLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            CustomItems.getVitamins());
                }
                break;
            }
            case CAVE_SPIDER: {
                Random r = new Random();
                double chance = CustomConfig.getBaubleConfig().getDouble("Bezoar.DropChance");
                if (CustomConfig.getBaubleConfig().getBoolean("Bezoar.CheckLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            CustomItems.getBezoar());
                }
                break;
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            PotionEffect newEffect = event.getNewEffect();
            NBTItem itemOffHand = null;
            if (! (player.getInventory().getItemInOffHand() == null || player.getInventory().getItemInOffHand().getType() == Material.AIR) ) {
                itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
            }
            if (newEffect != null) {
                switch (newEffect.getType().getName()) {
                    case "HUNGER":
                        if (player.getInventory().containsAtLeast(CustomItems.getForbiddenFruit(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "SLOW":
                        if (player.getInventory().containsAtLeast(CustomItems.getRingofOverclocking(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getRingofFreeAction(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "POISON":
                        if (player.getInventory().containsAtLeast(CustomItems.getBezoar(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getMixedColorDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "WITHER":
                        if (player.getInventory().containsAtLeast(CustomItems.getBlackDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getMixedColorDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "SLOW_DIGGING":
                        if (player.getInventory().containsAtLeast(CustomItems.getVitamins(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "BLINDNESS":
                        if (player.getInventory().containsAtLeast(CustomItems.getSunglasses(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "LEVITATION":
                        if (player.getInventory().containsAtLeast(CustomItems.getShulkerHeart(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getRingofFreeAction(), 1) ||
                                player.getInventory().containsAtLeast(CustomItems.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    @EventHandler
    public void inAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory();
        if (! (inv.getItem(0) == null || inv.getItem(0).getType() == Material.AIR) ) {
            if (! (inv.getItem(1) == null || inv.getItem(1).getType() == Material.AIR) ) {
                ItemStack firstItem = inv.getItem(0);
                ItemStack secondItem = inv.getItem(1);

                ItemMeta firstMeta = firstItem.getItemMeta();
                ItemMeta secondMeta = secondItem.getItemMeta();

                if (((Damageable) firstMeta).hasDamage()) {
                    ((Damageable) firstMeta).setDamage(0);
                }
                if (((Damageable) secondMeta).hasDamage()) {
                    ((Damageable) secondMeta).setDamage(0);
                }

                if (firstMeta.equals(CustomItems.getCobaltShield().getItemMeta()) && secondMeta.equals(CustomItems.getObsidianSkull().getItemMeta())) {
                    event.setResult(CustomItems.getObsidianShield());
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                }
                else if (firstMeta.equals(CustomItems.getRingofOverclocking().getItemMeta()) && secondMeta.equals(CustomItems.getShulkerHeart().getItemMeta())) {
                    event.setResult(CustomItems.getRingofFreeAction());
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                }
                else if (firstMeta.equals(CustomItems.getBezoar().getItemMeta()) && secondMeta.equals(CustomItems.getBlackDragonScale().getItemMeta())) {
                    event.setResult(CustomItems.getMixedColorDragonScale());
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("MixedColorDragonScale.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("MixedColorDragonScale.AnvilCost"));
                }
                else if (firstMeta.equals(CustomItems.getObsidianShield().getItemMeta()) && secondMeta.equals(CustomItems.getAnkhCharm().getItemMeta())) {
                    event.setResult(CustomItems.getAnkhShield());
                    inv.setRepairCost(CustomConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                    inv.setMaximumRepairCost(CustomConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                }
            }
        }

    }

}
