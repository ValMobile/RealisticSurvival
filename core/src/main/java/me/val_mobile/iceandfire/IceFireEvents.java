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
package me.val_mobile.iceandfire;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import me.val_mobile.spartanandfire.FreezeTask;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

/**
 * IceFireEvents is a class containing listener methods
 * that activate fire, ice, and lighting dragon weapon abilities
 * @author Val_Mobile
 * @version 1.2.3-DEV-0
 * @since 1.0
 */
public class IceFireEvents extends ModuleEvents implements Listener {

    private final IceFireModule module;
    private final FileConfiguration config;
    private final RealisticSurvivalPlugin plugin;

    // constructing the IceFireEvents class
    public IceFireEvents(IceFireModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.config = module.getUserConfig().getConfig();
        this.plugin = plugin;
        this.module = module;
    }

    /**
     * Activates dragon weapon abilities if a player attacks with a dragon weapon
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity(); // get the entity
        Entity attacker = event.getDamager(); // get the attacker

        if (shouldEventBeRan(defender) && shouldEventBeRan(attacker)) {
            Utils util = RealisticSurvivalPlugin.getUtil();
            double damage = event.getDamage();

            if (attacker instanceof LivingEntity living) {
                if (living.getEquipment() != null) {
                    ItemStack itemMainHand = living.getEquipment().getItemInMainHand(); // get the item in the player's main hand

                    // check if the item is real
                    if (RSVItem.isRSVItem(itemMainHand)) {
                        if (RSVItem.getModuleNameFromItem(itemMainHand).equals(IceFireModule.NAME)) {
                            String name = RSVItem.getNameFromItem(itemMainHand);
                            String type = name.substring(0, name.lastIndexOf("_"));

                            switch (type) {
                                case "dragonbone_flamed" -> {
                                    if (util.hasNbtTag(defender, "rsvmob")) {
                                        if (!util.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("fire_dragon")) {
                                            damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                        }
                                    }

                                    if (!BurnTask.hasTask(defender.getUniqueId())) {
                                        int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                        int tickSpeed = config.getInt("Items." + name + ".InfernoAbility.TickSpeed");

                                        new BurnTask(plugin, defender, fireTicks, tickSpeed).start();
                                    }
                                }
                                case "dragonbone_iced" -> {
                                    if (util.hasNbtTag(defender, "rsvmob")) {
                                        if (!util.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("ice_dragon")) {
                                            damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                        }
                                    }
                                    new FreezeTask(plugin, module, name, defender).start();
                                }
                                case "dragonbone_lightning" -> {
                                    if (util.hasNbtTag(defender, "rsvmob")) {
                                        if (!util.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("lightning_dragon")) {
                                            damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                        }
                                    }

                                    if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                                        Location loc = defender.getLocation();
                                        if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                                            loc.getWorld().strikeLightningEffect(loc);
                                        } else {
                                            loc.getWorld().strikeLightning(loc);
                                        }
                                    }

                                    if (defender instanceof Damageable) {
                                        if (!ElectrocuteTask.hasTask(defender.getUniqueId())) {
                                            new ElectrocuteTask(plugin, module, name, (Damageable) defender).start();
                                        }
                                    }
                                }
                                case "dragonsteel_fire" -> {
                                    if (!BurnTask.hasTask(defender.getUniqueId())) {
                                        int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                        int tickSpeed = config.getInt("Items." + name + ".InfernoAbility.TickSpeed");

                                        new BurnTask(plugin, defender, fireTicks, tickSpeed).start();
                                    }
                                }
                                case "dragonsteel_ice" -> {
                                    new FreezeTask(plugin, module, name, defender).start();
                                }
                                case "dragonsteel_lightning" -> {
                                    if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                                        Location loc = defender.getLocation();
                                        if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                                            loc.getWorld().strikeLightningEffect(loc);
                                        } else {
                                            loc.getWorld().strikeLightning(loc);
                                        }
                                    }

                                    if (defender instanceof Damageable) {
                                        if (!ElectrocuteTask.hasTask(defender.getUniqueId())) {
                                            new ElectrocuteTask(plugin, module, name, (Damageable) defender).start();
                                        }
                                    }
                                }
                                default -> {}
                            }
                        }
                    }
                }

                if (attacker instanceof EnderDragon) {
                    if (defender instanceof LivingEntity def) {
                        if (def.getEquipment() != null) {
                            ItemStack[] items = def.getEquipment().getArmorContents();
                            double dragonProtection = 0;

                            for (ItemStack item : items) {
                                // if a real item is in the armor slot
                                if (RSVItem.isRSVItem(item)) {
                                    String name = RSVItem.getNameFromItem(item);
                                    if (name.startsWith("dragonscale") || name.startsWith("dragonsteel")) {
                                        dragonProtection += config.getDouble("Items." + name + ".DragonDamageReduction");
                                    }
                                }
                            }

                            damage *= (1D - dragonProtection);
                        }
                    }
                }
            }

            else if (attacker instanceof Arrow || attacker instanceof SpectralArrow || attacker instanceof Firework) {
                Projectile arrow = (Projectile) attacker;
                if (arrow.getShooter() != null) {
                    Entity shooter = (Entity) arrow.getShooter();

                    if (shooter instanceof LivingEntity living) {
                        if (living.getEquipment() != null) {
                            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

                            if (RSVItem.isRSVItem(itemMainHand)) {
                                if (RSVItem.getModuleNameFromItem(itemMainHand).equals(IceFireModule.NAME)) {
                                    String name = RSVItem.getNameFromItem(itemMainHand);
                                    String materialType = name.substring(0, name.lastIndexOf("_"));

                                    String weaponType = name.substring(name.lastIndexOf("_") + 1);

                                    if (weaponType.equals("bow") || weaponType.equals("crossbow")) {
                                        damage *= config.getDouble("Items." + name + ".AttackDamageMultiplier");
                                        switch (materialType) {
                                            case "dragonbone_flamed" -> {
                                                if (util.hasNbtTag(defender, "rsvmob")) {
                                                    if (!util.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("fire_dragon")) {
                                                        damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                                    }
                                                }

                                                if (!BurnTask.hasTask(defender.getUniqueId())) {
                                                    int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                                    int tickSpeed = config.getInt("Items." + name + ".InfernoAbility.TickSpeed");

                                                    new BurnTask(plugin, defender, fireTicks, tickSpeed).start();
                                                }
                                            }
                                            case "dragonbone_iced" -> {
                                                if (util.hasNbtTag(defender, "rsvmob")) {
                                                    if (!util.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("ice_dragon")) {
                                                        damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                                    }
                                                }
                                                new FreezeTask(plugin, module, name, defender).start();
                                            }
                                            case "dragonbone_lightning" -> {
                                                if (util.hasNbtTag(defender, "rsvmob")) {
                                                    if (!util.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("llightning_dragon")) {
                                                        damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                                    }
                                                }

                                                if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                                                    Location loc = defender.getLocation();

                                                    if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                                                        loc.getWorld().strikeLightningEffect(loc);
                                                    } else {
                                                        loc.getWorld().strikeLightning(loc);
                                                    }
                                                }

                                                if (defender instanceof Damageable) {
                                                    if (!ElectrocuteTask.hasTask(defender.getUniqueId())) {
                                                        new ElectrocuteTask(plugin, module, name, (Damageable) defender).start();
                                                    }
                                                }
                                            }
                                            case "dragonsteel_fire" -> {
                                                if (!BurnTask.hasTask(defender.getUniqueId())) {
                                                    int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                                    int tickSpeed = config.getInt("Items." + name + ".InfernoAbility.TickSpeed");

                                                    new BurnTask(plugin, defender, fireTicks, tickSpeed).start();
                                                }
                                            }
                                            case "dragonsteel_ice" -> {
                                                new FreezeTask(plugin, module, name, defender).start();
                                            }
                                            case "dragonsteel_lightning" -> {
                                                if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                                                    Location loc = defender.getLocation();

                                                    if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                                                        loc.getWorld().strikeLightningEffect(loc);
                                                    } else {
                                                        loc.getWorld().strikeLightning(loc);
                                                    }
                                                }

                                                if (defender instanceof Damageable) {
                                                    if (!ElectrocuteTask.hasTask(defender.getUniqueId())) {
                                                        new ElectrocuteTask(plugin, module, name, (Damageable) defender).start();
                                                    }
                                                }
                                            }
                                            default -> {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            event.setDamage(damage);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity e = event.getEntity();

        if (shouldEventBeRan(e)) {
            ConfigurationSection section = config.getConfigurationSection("Items.witherbone.MobDrops");
            Set<String> keys = section.getKeys(false);
            String type = e.getType().toString();

            Player killer = e.getKiller();
            if (killer != null) {
                if (keys.contains(type)) {
                    section = section.getConfigurationSection(type);

                    Utils.harvestLooting(section, RSVItem.getItem("witherbone"), killer.getInventory().getItemInMainHand(), e.getLocation());
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onItemThrow(PlayerDropItemEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            if (shouldEventBeRan(player)) {
                ItemStack item = event.getItemDrop().getItemStack();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).contains("tide_guardian_")) {
                        if (!TideGuardianTask.hasTask(player.getUniqueId())) {
                            new TideGuardianTask(module, player, plugin).start();
                        }
                    }
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                ItemStack item;
                if (RSVItem.isRSVItem(event.getCurrentItem())) {
                    item = event.getCurrentItem();

                    if (RSVItem.isRSVItem(item)) {
                        if (RSVItem.getNameFromItem(item).contains("tide_guardian_")) {
                            if (!TideGuardianTask.hasTask(player.getUniqueId())) {
                                new TideGuardianTask(module, player, plugin).start();
                            }
                        }
                    }
                }
                if (RSVItem.isRSVItem(event.getCursor())) {
                    item = event.getCursor();
                    if (RSVItem.isRSVItem(item)) {
                        if (RSVItem.getNameFromItem(item).contains("tide_guardian_")) {
                            if (!TideGuardianTask.hasTask(player.getUniqueId())) {
                                new TideGuardianTask(module, player, plugin).start();
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onDragClick(InventoryDragEvent event) {
        if (!event.isCancelled()) {
            Player player = (Player) event.getWhoClicked();

            if (shouldEventBeRan(player)) {
                ItemStack item = event.getCursor();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).contains("tide_guardian_")) {
                        if (!TideGuardianTask.hasTask(player.getUniqueId())) {
                            new TideGuardianTask(module, player, plugin).start();
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Entity e = event.getEntity();
        if (shouldEventBeRan(e)) {
            if (e instanceof Squid) {
                if (config.getBoolean("SeaSerpents.Enabled.Enabled")) {
                    if (Math.random() <= config.getDouble("SeaSerpents.SpawnChance")) {
                        Utils.spawnSeaSerpent(e.getLocation(), plugin);
                        event.setCancelled(true);
                    }
                }
                else if (config.getBoolean("Sirens.Enabled")) {
                    if (Math.random() <= config.getDouble("Sirens.SpawnChance")) {
                        Utils.spawnSiren(e.getLocation(), plugin);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}