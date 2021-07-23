package me.val_mobile.sea_serpents;

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Recipes;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.scheduler.BukkitRunnable;

public class SeaSerpentGearEvents implements Listener {

    private final RLCraft plugin;
    private final Utils util;
    public SeaSerpentGearEvents(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        SeaSerpentGearRunnables.updateTideGuardianArmor(player);
        SeaSerpentGearRunnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.TickTime"));

        for (Recipe r : Recipes.getSeaSerpentRecipes()) {
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
        Player player = event.getEntity();

        Utils.resetBaubleMaps(player);
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!event.isCancelled()) {
            LivingEntity entity = event.getEntity();

            if (entity instanceof Player) {
                Player player = (Player) entity;

                NBTItem item = new NBTItem(event.getItem().getItemStack());
                if (item.hasKey("Tide Guardian Armor")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            SeaSerpentGearRunnables.updateTideGuardianArmor(player);
                            util.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onItemThrow(PlayerDropItemEvent event) {
        if (!event.isCancelled()) {
            NBTItem item = new NBTItem(event.getItemDrop().getItemStack());
            if (item.hasKey("Tide Guardian Armor")) {
                Player player = event.getPlayer();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        SeaSerpentGearRunnables.updateTideGuardianArmor(player);
                        util.startTideGuardianRunnable(player);
                    }
                }.runTaskLater(plugin, 1L);
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        if (!event.isCancelled()) {
            if (Utils.isItemReal(event.getCurrentItem())) {
                NBTItem item = new NBTItem(event.getCurrentItem());
                if (item.hasKey("Tide Guardian Armor")) {
                    Player player = (Player) event.getWhoClicked();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            SeaSerpentGearRunnables.updateTideGuardianArmor(player);
                            util.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
            if (Utils.isItemReal(event.getCursor())) {
                NBTItem item = new NBTItem(event.getCursor());
                if (item.hasKey("Tide Guardian Armor")) {
                    Player player = (Player) event.getWhoClicked();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            SeaSerpentGearRunnables.updateTideGuardianArmor(player);
                            util.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onDragClick(InventoryDragEvent event) {
        if (!event.isCancelled()) {
            if (Utils.isItemReal(event.getCursor())) {
                NBTItem item = new NBTItem(event.getCursor());
                if (item.hasKey("Tide Guardian Armor")) {
                    Player player = (Player) event.getWhoClicked();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            SeaSerpentGearRunnables.updateTideGuardianArmor(player);
                            util.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
        }
    }
}
