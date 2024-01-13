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
package me.val_mobile.iceandfire;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.misc.PlayerItemAcquireEvent;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import me.val_mobile.spartanandfire.FreezeTask;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.spartanweaponry.SwModule;
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
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * IceFireEvents is a class containing listener methods
 * that activate fire, ice, and lighting dragon weapon abilities
 * @author Val_Mobile
 * @version 1.2.8-RELEASE
 * @since 1.0
 */
public class IceFireEvents extends ModuleEvents implements Listener {

    private final IceFireModule module;
    private final FileConfiguration config;
    private final RSVPlugin plugin;

    // constructing the IceFireEvents class
    public IceFireEvents(IceFireModule module, RSVPlugin plugin) {
        super(module, plugin);
        this.config = module.getUserConfig().getConfig();
        this.plugin = plugin;
        this.module = module;
    }

    private double applyDragonItemEffect(@Nullable Entity defender, @Nullable ItemStack item, double origDamage) {
        if (!(RSVItem.isRSVItem(item) && RSVItem.getModuleNameFromItem(item).equals(module.getName())))
            return origDamage;

        return applyDragonItemEffect(defender, RSVItem.getNameFromItem(item), origDamage);
    }

    private double applyDragonItemEffect(@Nullable Entity defender, @Nullable String name, double origDamage) {
        if (module.getUserConfig() == null || defender == null || name == null || name.isEmpty() || name.startsWith("_") || name.endsWith("_"))
            return origDamage;

        String type = name.substring(0, name.lastIndexOf("_"));
        String weaponType = name.substring(name.lastIndexOf("_") + 1);

        if (weaponType.equals("longbow") || weaponType.equals("crossbow")) {
            origDamage *= config.getDouble("Items." + name + ".AttackDamageMultiplier");
        }

        switch (type) {
            case "dragonbone_flamed" -> {
                if (Utils.hasNbtTag(defender, "rsvmob") && !Utils.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("fire_dragon")) {
                    origDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
                }

                if (!BurnTask.hasTask(defender.getUniqueId())) {
                    int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                    int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                    new BurnTask(plugin, defender, fireTicks, tickPeriod).start();
                }
            }
            case "dragonbone_iced" -> {
                if (Utils.hasNbtTag(defender, "rsvmob") && !Utils.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("ice_dragon")) {
                    origDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
                }

                if (!FreezeTask.hasTask(defender.getUniqueId())) {
                    new FreezeTask(plugin, module, name, defender).start();
                }

            }
            case "dragonbone_lightning" -> {
                if (Utils.hasNbtTag(defender, "rsvmob") && !Utils.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals("lightning_dragon")) {
                    origDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
                }

                if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                    Location loc = defender.getLocation();
                    if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                        loc.getWorld().strikeLightningEffect(loc);
                    } else {
                        loc.getWorld().strikeLightning(loc);
                    }
                }

                if (defender instanceof Damageable damageable && !ElectrocuteTask.hasTask(defender.getUniqueId())) {
                    new ElectrocuteTask(plugin, module, name, damageable).start();
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

                if (defender instanceof Damageable damageable && !ElectrocuteTask.hasTask(defender.getUniqueId())) {
                    new ElectrocuteTask(plugin, module, name, damageable).start();
                }
            }
            default -> {}
        }

        return origDamage;
    }

    /**
     * Activates dragon weapon abilities if an entity successfully attacks with a dragon weapon
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDamageByEntityMonitor(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity(); // get the entity
        Entity attacker = event.getDamager(); // get the attacker

        if (!(shouldEventBeRan(defender) && shouldEventBeRan(attacker)))
            return;

        if (Utils.hasNbtTag(attacker, "rsvbow")) {
            String name = Utils.getNbtTag(attacker, "rsvbow", PersistentDataType.STRING);

            IceFireModule.applyDragonItemEffect(defender, name, module);
        }
        else if (attacker instanceof LivingEntity living && living.getEquipment() != null) {
            ItemStack itemMainHand = living.getEquipment().getItemInMainHand(); // get the item in the player's main hand

            IceFireModule.applyDragonItemEffect(defender, itemMainHand, module);
        }
    }

    /**
     * Increases raw damage if an entity attacks a dragon with a dragon weapon
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity(); // get the entity
        Entity attacker = event.getDamager(); // get the attacker

        if (!(shouldEventBeRan(defender) && shouldEventBeRan(attacker)))
            return;

        double damage = event.getDamage();

        if (Utils.hasNbtTag(attacker, "rsvbow")) {
            String name = Utils.getNbtTag(attacker, "rsvbow", PersistentDataType.STRING);

            damage = IceFireModule.applyDragonItemBonusDamage(defender, name, damage, module);
        }
        else if (attacker instanceof LivingEntity living && living.getEquipment() != null) {
            ItemStack itemMainHand = living.getEquipment().getItemInMainHand(); // get the item in the player's main hand

            damage = IceFireModule.applyDragonItemBonusDamage(defender, itemMainHand, damage, module);
        }

        event.setDamage(damage);
    }

    @EventHandler
    public void onArmorAcquire(PlayerItemAcquireEvent event) {
        ItemStack item = event.getItem();

        if (!(RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).contains("tide_guardian_")))
            return;

        EquipmentSlot loc = event.getLocation();

        switch (loc) {
            case HEAD, CHEST, LEGS, FEET -> {}
            default -> {
                return;
            }
        }

        Player player = event.getPlayer();

        if (!TideGuardianTask.hasTask(player.getUniqueId())) {
            new TideGuardianTask(module, player, plugin).start();
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();

        if (!shouldEventBeRan(entity))
            return;

        if (entity instanceof Squid) {
            boolean spawned = false;

            if (config.getBoolean("SeaSerpent.Enabled.Enabled") && Utils.roll(config.getDouble("SeaSerpent.SpawnChance"))) {
                Utils.spawnSeaSerpent(entity.getLocation()).addEntityToWorld(entity.getWorld());
                spawned = true;
                event.setCancelled(true);
            }

            if (!spawned && config.getBoolean("Siren.Enabled") && Utils.roll(config.getDouble("Siren.SpawnChance"))) {
                Utils.spawnSiren(entity.getLocation()).addEntityToWorld(entity.getWorld());
                event.setCancelled(true);
            }
        }

        if (entity instanceof EnderDragon dragon && !(DragonUtils.isDragon(dragon)) && config.getBoolean("Dragon.Enabled") && Utils.roll(config.getDouble("Dragon.SpawnChance"))) {
            double val = Math.random();
            double fireChance = config.getDouble("Dragon.FireDragon.Enabled.Chance");
            double iceChance = config.getDouble("Dragon.IceDragon.Enabled.Chance");

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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLaunch(ProjectileLaunchEvent event) {
        Projectile proj = event.getEntity();

        if (!(shouldEventBeRan(proj) && proj instanceof DragonFireball && proj.getShooter() instanceof EnderDragon dragon && DragonUtils.isDragon(dragon)))
            return;

        DragonBreed breed = DragonUtils.getBreed(dragon);

        new BukkitRunnable() {
            @Override
            public void run() {
                Location target = dragon.getEyeLocation().add(proj.getVelocity().normalize().multiply(100));

                switch (breed) {
                    case FIRE -> {
                        if (Utils.roll(config.getDouble("Dragon.FireDragon.BreathAttack.Chance"))) {
                            DragonUtils.triggerBreathFireAttack(dragon, target);
                        }
                        else {
                            DragonUtils.triggerExplosionFireAttack(dragon, target);
                        }
                    }
                    case ICE -> {
                        if (Utils.roll(config.getDouble("Dragon.IceDragon.BreathAttack.Chance"))) {
                            DragonUtils.triggerBreathIceAttack(dragon, target);
                        }
                        else {
                            DragonUtils.triggerExplosionIceAttack(dragon, target);
                        }
                    }
                    case LIGHTNING -> {
                        if (Utils.roll(config.getDouble("Dragon.LightningDragon.BreathAttack.Chance"))) {
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

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (!(shouldEventBeRan(entity) && RSVMob.isMob(entity)))
            return;

        Location loc = entity.getLocation();
        World world = loc.getWorld();
        Collection<ItemStack> loots = new ArrayList<>();

        switch (RSVMob.getMob(entity)) {
            case "fire_dragon", "ice_dragon", "lightning_dragon" -> {
                if (!(entity instanceof Dragon)) {
                    loots = DragonUtils.generateLoot((EnderDragon) entity);
                }
            }
            case "sea_serpent" -> {
                if (!(entity instanceof SeaSerpent)) {
                    loots = SeaSerpentUtils.generateLoot((ElderGuardian) entity);
                }
            }
            case "siren" -> {
                if (!(entity instanceof Siren)) {
                    loots = SirenUtils.generateLoot((Guardian) entity);
                }
            }
            default -> {}
        }

        for (ItemStack loot : loots) {
            if (Utils.isItemReal(loot)) {
                world.dropItemNaturally(loc, loot);
            }
        }
    }
}