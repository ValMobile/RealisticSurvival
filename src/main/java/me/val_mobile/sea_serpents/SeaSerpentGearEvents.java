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
package me.val_mobile.sea_serpents;

import me.val_mobile.rlcraft.RLCraftPlugin;
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

    private final RLCraftPlugin plugin;
    private final SeaSerpentGearRunnables seaSerpentGearRunnables;
    private final Utils util;
    public SeaSerpentGearEvents(RLCraftPlugin instance) {
        plugin = instance;
        seaSerpentGearRunnables = new SeaSerpentGearRunnables(instance);
        util = new Utils(instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        seaSerpentGearRunnables.updateTideGuardianArmor(player);
        seaSerpentGearRunnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.TickTime"));

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

        seaSerpentGearRunnables.resetArmorMaps(player);
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!event.isCancelled()) {
            LivingEntity entity = event.getEntity();

            if (entity instanceof Player) {
                Player player = (Player) entity;

                if (util.hasNbtTag(event.getItem().getItemStack(),"tide_guardian_armor")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            seaSerpentGearRunnables.updateTideGuardianArmor(player);
                            seaSerpentGearRunnables.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onItemThrow(PlayerDropItemEvent event) {
        if (!event.isCancelled()) {
            if (util.hasNbtTag(event.getItemDrop().getItemStack(),"tide_guardian_armor")) {
                Player player = event.getPlayer();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        seaSerpentGearRunnables.updateTideGuardianArmor(player);
                        seaSerpentGearRunnables.startTideGuardianRunnable(player);
                    }
                }.runTaskLater(plugin, 1L);
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        if (!event.isCancelled()) {
            if (Utils.isItemReal(event.getCurrentItem())) {
                if (util.hasNbtTag(event.getCurrentItem(),"tide_guardian_armor")) {
                    Player player = (Player) event.getWhoClicked();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            seaSerpentGearRunnables.updateTideGuardianArmor(player);
                            seaSerpentGearRunnables.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
            if (Utils.isItemReal(event.getCursor())) {
                if (util.hasNbtTag(event.getCursor(),"tide_guardian_armor")) {
                    Player player = (Player) event.getWhoClicked();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            seaSerpentGearRunnables.updateTideGuardianArmor(player);
                            seaSerpentGearRunnables.startTideGuardianRunnable(player);
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
                if (util.hasNbtTag(event.getCursor(),"tide_guardian_armor")) {
                    Player player = (Player) event.getWhoClicked();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            seaSerpentGearRunnables.updateTideGuardianArmor(player);
                            seaSerpentGearRunnables.startTideGuardianRunnable(player);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
        }
    }
}