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
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * IceFireEvents is a class containing listener methods
 * that activate fire, ice, and lighting dragon weapon abilities
 * @author Val_Mobile
 * @version 1.2.4-RELEASE
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
                                    if (RSVMob.isMob(defender)) {
                                        if (!RSVMob.getMob(defender).equals("fire_dragon")) {
                                            damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                        }
                                    }

                                    if (!BurnTask.hasTask(defender.getUniqueId())) {
                                        int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                        int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                                        new BurnTask(plugin, defender, fireTicks, tickPeriod).start();
                                    }
                                }
                                case "dragonbone_iced" -> {
                                    if (RSVMob.isMob(defender)) {
                                        if (!RSVMob.getMob(defender).equals("ice_dragon")) {
                                            damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                        }
                                    }
                                    if (!FreezeTask.hasTask(defender.getUniqueId())) {
                                        new FreezeTask(plugin, module, name, defender).start();
                                    }
                                }
                                case "dragonbone_lightning" -> {
                                    if (RSVMob.isMob(defender)) {
                                        if (!RSVMob.getMob(defender).equals("lightning_dragon")) {
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
                                        int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                                        new BurnTask(plugin, defender, fireTicks, tickPeriod).start();
                                    }
                                }
                                case "dragonsteel_ice" -> {
                                    if (!FreezeTask.hasTask(defender.getUniqueId())) {
                                        new FreezeTask(plugin, module, name, defender).start();
                                    }
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
                                                if (RSVMob.isMob(defender)) {
                                                    if (!RSVMob.getMob(defender).equals("fire_dragon")) {
                                                        damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                                    }
                                                }

                                                if (!BurnTask.hasTask(defender.getUniqueId())) {
                                                    int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                                    int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                                                    new BurnTask(plugin, defender, fireTicks, tickPeriod).start();
                                                }
                                            }
                                            case "dragonbone_iced" -> {
                                                if (RSVMob.isMob(defender)) {
                                                    if (!RSVMob.getMob(defender).equals("ice_dragon")) {
                                                        damage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                                    }
                                                }
                                                if (!FreezeTask.hasTask(defender.getUniqueId())) {
                                                    new FreezeTask(plugin, module, name, defender).start();
                                                }
                                            }
                                            case "dragonbone_lightning" -> {
                                                if (RSVMob.isMob(defender)) {
                                                    if (!RSVMob.getMob(defender).equals("llightning_dragon")) {
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
                                                    int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                                                    new BurnTask(plugin, defender, fireTicks, tickPeriod).start();
                                                }
                                            }
                                            case "dragonsteel_ice" -> {
                                                if (!FreezeTask.hasTask(defender.getUniqueId())) {
                                                    new FreezeTask(plugin, module, name, defender).start();
                                                }
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
                        }
                    }
                }
            }

            event.setDamage(damage);
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
                    if (Utils.roll(config.getDouble("SeaSerpents.SpawnChance"))) {
                        Utils.spawnSeaSerpent(e.getLocation()).addEntityToWorld(e.getWorld());
                        event.setCancelled(true);
                    }
                }
                else if (config.getBoolean("Sirens.Enabled")) {
                    if (Utils.roll(config.getDouble("Sirens.SpawnChance"))) {
                        Utils.spawnSiren(e.getLocation()).addEntityToWorld(e.getWorld());
                        event.setCancelled(true);
                    }
                }
            }
            if (e instanceof EnderDragon dragon && !(DragonUtils.isDragon(dragon))) {
                if (config.getBoolean("Dragons.Enabled")) {
                    if (Utils.roll(config.getDouble("Dragons.SpawnChance"))) {
                        double val = Math.random();
                        double fireChance = config.getDouble("Dragons.FireDragon.Enabled.Chance");
                        double iceChance = config.getDouble("Dragons.IceDragon.Enabled.Chance");

                        if (val <= fireChance) {
                            DragonUtils.convertToFireDragon(dragon);
                        }
                        else if (val <= fireChance + iceChance) {
                            DragonUtils.convertToIceDragon(dragon);
                        }
                        else {
                            DragonUtils.convertToLightningDragon(dragon);
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLaunch(ProjectileLaunchEvent event) {
        Projectile proj = event.getEntity();
        if (shouldEventBeRan(proj)) {
            if (proj instanceof DragonFireball) {
                ProjectileSource shooter = proj.getShooter();

                if (shooter instanceof EnderDragon dragon) {
                    if (DragonUtils.isDragon(dragon)) {
                        DragonBreed breed = DragonUtils.getBreed(dragon);

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Location target = dragon.getEyeLocation().add(proj.getVelocity().normalize().multiply(100));

                                switch (breed) {
                                    case FIRE -> {
                                        if (Utils.roll(config.getDouble("Dragons.FireDragon.BreathAttack.Chance"))) {
                                            DragonUtils.triggerBreathFireAttack(dragon, target);
                                        }
                                        else {
                                            DragonUtils.triggerExplosionFireAttack(dragon, target);
                                        }
                                    }
                                    case ICE -> {
                                        if (Utils.roll(config.getDouble("Dragons.IceDragon.BreathAttack.Chance"))) {
                                            DragonUtils.triggerBreathIceAttack(dragon, target);
                                        }
                                        else {
                                            DragonUtils.triggerExplosionIceAttack(dragon, target);
                                        }
                                    }
                                    case LIGHTNING -> {
                                        if (Utils.roll(config.getDouble("Dragons.LightningDragon.BreathAttack.Chance"))) {
                                            DragonUtils.triggerBreathLightningAttack(dragon, target);
                                        }
                                        else {
                                            DragonUtils.triggerExplosionLightningAttack(dragon, target);
                                        }
                                    }
                                    default -> {}
                                }
                                proj.remove();
                            }
                        }.runTaskLater(plugin, 2L);

                    }
                }
            }
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity e = event.getEntity();
        if (shouldEventBeRan(e)) {
            Location loc = e.getLocation();
            World world = loc.getWorld();
            Collection<ItemStack> loots = new ArrayList<>();

            if (RSVMob.isMob(e)) {
                switch (RSVMob.getMob(e)) {
                    case "fire_dragon", "ice_dragon", "lightning_dragon" -> {
                        if (!(e instanceof Dragon)) {
                            loots = DragonUtils.generateLoot((EnderDragon) e);
                        }
                    }
                    case "sea_serpent" -> {
                        if (!(e instanceof SeaSerpent)) {
                            loots = SeaSerpentUtils.generateLoot((ElderGuardian) e);
                        }
                    }
                    case "siren" -> {
                        if (!(e instanceof Siren)) {
                            Utils.dropLooting(config.getConfigurationSection("Sirens.Drops.ShinyScales"), RSVItem.getItem("shiny_scale"), e.getKiller() == null ? null : e.getKiller().getInventory().getItemInMainHand(), loc);
                        }
                    }
                    default -> {}
                }

                if (!loots.isEmpty()) {
                    for (ItemStack loot : loots) {
                        world.dropItemNaturally(loc, loot);
                    }
                }
            }
        }
    }
}