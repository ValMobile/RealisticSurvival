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
package me.val_mobile.spartanweaponry;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.misc.EntityItemAcquireEvent;
import me.val_mobile.misc.PlayerItemAcquireEvent;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class SwEvents extends ModuleEvents implements Listener {


    private final RSVPlugin plugin;

    public SwEvents(SwModule module, RSVPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityItemAcquire(EntityItemAcquireEvent event) {
        ItemStack item = event.getItem();
        EquipmentSlot loc = event.getLocation();
        LivingEntity entity = event.getEntity();

        if (entity.getEquipment() == null)
            return;

        if (!(RSVItem.isRSVItem(item) && (loc == EquipmentSlot.HAND || loc == EquipmentSlot.OFF_HAND)))
            return;

        if (loc == EquipmentSlot.HAND && !Utils.isItemReal(entity.getEquipment().getItemInOffHand()))
            return;

        if (loc == EquipmentSlot.OFF_HAND && !Utils.isItemReal(entity.getEquipment().getItemInMainHand()))
            return;

        String name = RSVItem.getNameFromItem(item);

        if (!name.contains("_"))
            return;

        String type = name.substring(name.lastIndexOf("_") + 1);
        RSVModule module = RSVModule.getModule(RSVItem.getModuleNameFromItem(item));

        UUID id = entity.getUniqueId();

        boolean isThrowing;

        switch (type) {
            case "longsword", "katana", "warhammer", "battleaxe", "glaive" -> {
                if (!TwoHandedTask.hasTask(id)) {
                    new TwoHandedTask(module, plugin, entity, name).start();
                }
                isThrowing = false;
            }
            case "greatsword", "halberd", "pike" -> {
                if (!TwoHandedTask.hasTask(id)) {
                    new TwoHandedTask(module, plugin, entity, name).start();
                }

                if (!EntityLongAttackTask.hasTask(id) && loc == EquipmentSlot.HAND) {
                    new EntityLongAttackTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(item)), plugin, entity, item, null).start();
                }
                isThrowing = false;
            }
            case "spear", "lance" -> {
                if (!EntityLongAttackTask.hasTask(id) && loc == EquipmentSlot.HAND) {
                    new EntityLongAttackTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(item)), plugin, entity, item, null).start();
                }
                isThrowing = false;
            }
            case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = true;
            default -> isThrowing = name.endsWith("throwing_knife");
        }

        if (isThrowing && !EntityPrepareThrowTask.hasTask(id)) {
            new EntityPrepareThrowTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(item)), plugin, entity, item).start();
        }
    }

    @EventHandler
    public void onPlayerItemAcquire(PlayerItemAcquireEvent event) {
        ItemStack item = event.getItem();
        EquipmentSlot loc = event.getLocation();
        Player player = event.getPlayer();

        if (!(RSVItem.isRSVItem(item) && (loc == EquipmentSlot.HAND || loc == EquipmentSlot.OFF_HAND)))
            return;

        if (loc == EquipmentSlot.HAND && !Utils.isItemReal(player.getInventory().getItemInOffHand()))
            return;

        if (loc == EquipmentSlot.OFF_HAND && !Utils.isItemReal(player.getInventory().getItemInMainHand()))
            return;

        String name = RSVItem.getNameFromItem(item);
        String type = name.substring(name.lastIndexOf("_") + 1);
        RSVModule module = RSVModule.getModule(RSVItem.getModuleNameFromItem(item));

        switch (type) {
            case "longsword", "katana", "greatsword", "warhammer", "halberd", "pike", "battleaxe", "glaive" -> {
                UUID id = player.getUniqueId();
                if (!TwoHandedTask.hasTask(id)) {
                    new TwoHandedTask(module, plugin, player, name).start();
                }
            }
            default -> {}
        }
    }


    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onShootBow(EntityShootBowEvent event) {
        ItemStack bow = event.getBow();

        if (!(shouldEventBeRan(event.getEntity()) && RSVItem.isRSVItem(bow)))
            return;

        Entity proj = event.getProjectile();
        String moduleName = RSVItem.getModuleNameFromItem(bow);

        if (!(moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)))
            return;

        FileConfiguration config = moduleName.equals(SwModule.NAME) ? RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig() : RSVModule.getModule(SfModule.NAME).getUserConfig().getConfig();
        String name = RSVItem.getNameFromItem(bow);

        if (!name.contains("_") || name.endsWith("_") || name.startsWith("_"))
            return;

        String type = name.substring(name.lastIndexOf("_") + 1);

        if (type.equals("longbow") || type.equals("crossbow")) {
            double multiplier = config.getDouble("Items." + name + ".ArrowVelocityMultiplier");
            proj.setVelocity(proj.getVelocity().multiply(multiplier));
            Utils.addNbtTag(proj, "rsvbow", name, PersistentDataType.STRING); // used to identify projectile if it hits a mob
            event.setProjectile(proj);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity();
        Entity attacker = event.getDamager();

        if (!(shouldEventBeRan(defender) && shouldEventBeRan(attacker)))
            return;

        double damage = event.getDamage();

        if (attacker instanceof AbstractArrow || attacker instanceof Firework) {
            Projectile arrow = (Projectile) event.getDamager();
            if (arrow.getShooter() != null && arrow.getShooter() instanceof LivingEntity living && living.getEquipment() != null) {
                ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

                if (RSVItem.isRSVItem(itemMainHand)) {
                    FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)).getUserConfig().getConfig();

                    String name = RSVItem.getNameFromItem(itemMainHand);
                    String type = name.substring(name.lastIndexOf("_") + 1);
                    if (type.equals("longbow") || type.equals("crossbow")) {
                        double multiplier = config.getDouble("Items." + name + ".AttackDamageMultiplier");
                        damage *= multiplier;
                    }
                }
            }
        }
        else if (attacker instanceof LivingEntity livingAttacker && livingAttacker.getEquipment() != null) {
            ItemStack itemMainHand = livingAttacker.getEquipment().getItemInMainHand();
            if (RSVItem.isRSVItem(itemMainHand)) {
                String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);

                if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                    FileConfiguration config = RSVModule.getModule(moduleName).getUserConfig().getConfig();

                    String name = RSVItem.getNameFromItem(itemMainHand);
                    String type = name.substring(name.lastIndexOf("_") + 1);

                    switch (type) {
                        case "rapier" -> {
                            if (!Utils.hasArmor(defender)) {
                                damage *= config.getDouble("Items." + name + ".UnarmoredDamageMultiplier");
                            }
                        }
                        case "katana" -> {
                            if (!Utils.hasChestplate(defender)) {
                                damage *= config.getDouble("Items." + name + ".ChestDamageMultiplier");
                            }
                        }
                        case "dagger" -> {
                            if (Utils.wasBackstabbed(attacker, defender)) {
                                damage *= config.getDouble("Items." + name + ".BackstabDamageMultiplier");
                            }
                        }
                        case "lance" -> {
                            double sweepMultiplier = config.getDouble("Items." + name + ".SweepingDamageMultiplier");

                            double ridingMultiplier = config.getDouble("Items." + name + ".RidingDamageBonus");

                            if (attacker.getVehicle() != null) {
                                damage *= ridingMultiplier;
                            }

                            List<Entity> entities = defender.getNearbyEntities(1.0, 0.25, 1.0);

                            if (config.getBoolean("Items." + name + ".Sweep")) {
                                new SweepAttackTask(plugin, entities, attacker, defender, damage * sweepMultiplier, config.getBoolean("PreventSweepAttackingPets")).start();
                            }
                        }
                        case "greatsword", "longsword", "saber", "glaive", "quarterstaff" -> {
                            List<Entity> entities = defender.getNearbyEntities(1.0, 0.25, 1.0);

                            double multiplier = config.getDouble("Items." + name + ".SweepingDamageMultiplier");
                            if (config.getBoolean("Items." + name + ".Sweep")) {
                                new SweepAttackTask(plugin, entities, attacker, defender, damage * multiplier, config.getBoolean("PreventSweepAttackingPets")).start();
                            }
                        }
                        case "hammer" -> {
                            if (defender instanceof LivingEntity living) {
                                int duration = config.getInt("Items." + name + ".Nausea.Duration");
                                int amplifier = config.getInt("Items." + name + ".Nausea.Amplifier");

                                PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier);
                                if (living.getEquipment() != null) {
                                    if (!Utils.isItemReal(living.getEquipment().getHelmet())) {
                                        living.addPotionEffect(nausea);
                                    }
                                }
                                else {
                                    living.addPotionEffect(nausea);
                                }
                            }

                            double kbMultiplier = config.getDouble("Items." + name + ".KnockbackMultiplier");
                            Utils.setKbMultiplier(defender, kbMultiplier);
                        }
                        case "warhammer" -> {
                            double armorPiercing = config.getDouble("Items." + name + ".ArmorPiercing");
                            double dif = event.getFinalDamage() - event.getDamage();

                            damage += dif * armorPiercing;
                        }
                        case "club" -> {
                            if (defender instanceof LivingEntity living) {
                                int duration = config.getInt("Items." + name + ".Nausea.Duration");
                                int amplifier = config.getInt("Items." + name + ".Nausea.Amplifier");

                                PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier);
                                if (living.getEquipment() != null) {
                                    if (!Utils.isItemReal(living.getEquipment().getHelmet())) {
                                        living.addPotionEffect(nausea);
                                    }
                                }
                                else {
                                    living.addPotionEffect(nausea);
                                }
                            }
                        }
                        case "halberd" -> {
                            int shieldCooldown = config.getInt("Items." + name + ".ShieldBreach.Cooldown");
                            double chance = config.getDouble("Items." + name + ".ShieldBreach.Chance");
                            if (defender instanceof Player player)
                                if (player.isBlocking())
                                    if (Utils.roll(chance)) {
                                        player.setCooldown(Material.SHIELD, shieldCooldown);
                                    }
                        }
                        case "mace" -> {
                            if (defender instanceof LivingEntity)
                                if (Utils.isUndead(defender))
                                    damage *= config.getDouble("Items." + name + ".UndeadDamageMultiplier");
                        }
                        default -> {}
                    }

                    if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK && !config.getBoolean("Items." + name + ".Sweep")) {
                        event.setCancelled(true);
                    }
                }
            }
        }

        if (defender instanceof LivingEntity living && living.getEquipment() != null) {
            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

            if (RSVItem.isRSVItem(itemMainHand)) {
                FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)).getUserConfig().getConfig();
                String name = RSVItem.getNameFromItem(itemMainHand);
                String type = name.substring(name.lastIndexOf("_") + 1);
                if (type.equals("saber") || type.equals("rapier")) {
                    double multiplier = 1D - config.getDouble("Items." + name + ".Protection.PercentAbsorbed");
                    int decrement = config.getInt("Items." + name + ".Protection.DamageDurability");

                    damage *= multiplier;
                    Utils.changeDurability(itemMainHand, -decrement, true, true, defender);
                }
            }
        }
        event.setDamage(damage);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onTarget(EntityTargetEvent event) {
        Entity entity = event.getEntity();
        Entity target = event.getTarget();

        if (!(target != null && shouldEventBeRan(entity) && shouldEventBeRan(target) && entity instanceof LivingEntity living && !(entity instanceof Player) && living.getEquipment() != null))
            return;

        ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

        if (!RSVItem.isRSVItem(itemMainHand))
            return;

        String name = RSVItem.getNameFromItem(itemMainHand);

        if (!name.contains("_"))
            return;

        String type = name.substring(name.lastIndexOf("_") + 1);

        boolean isThrowing;
        switch (type) {
            case "greatsword", "spear", "halberd", "pike", "lance" -> {
                if (!EntityLongAttackTask.hasTask(living.getUniqueId())) {
                    new EntityLongAttackTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)), plugin, living, itemMainHand, target).start();
                }
                isThrowing = false;
            }
            case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = true;
            default -> isThrowing = name.endsWith("throwing_knife");
        }

        if (isThrowing && !EntityPrepareThrowTask.hasTask(living.getUniqueId())) {
            new EntityPrepareThrowTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)), plugin, living, itemMainHand).start();
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && event.getAction() == Action.LEFT_CLICK_AIR))
            return;

        ItemStack itemMainHand = player.getInventory().getItemInMainHand();

        if (!RSVItem.isRSVItem(itemMainHand))
            return;

        String name = RSVItem.getNameFromItem(itemMainHand);

        if (!name.contains("_"))
            return;

        String type = name.substring(name.lastIndexOf("_") + 1);

        RSVModule module = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand));

        if (module.getUserConfig() == null)
            return;

        FileConfiguration config = module.getUserConfig().getConfig();

        boolean isThrowing = false;
        switch (type) {
            case "greatsword", "spear", "halberd", "pike", "lance" -> {
                double range = config.getDouble("Items." + name + ".Reach");

                Location eye = player.getEyeLocation();
                Predicate<Entity> filter = entity -> !entity.getUniqueId().equals(player.getUniqueId());
                RayTraceResult result = player.getWorld().rayTrace(eye, eye.getDirection(), range, FluidCollisionMode.NEVER, false, 0, filter);

                if (result != null) {
                    Entity defender = result.getHitEntity();
                    if (defender != null) {
                        Utils.attack(player, defender);
                    }
                }
            }
            case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = !player.isSneaking();
            default -> isThrowing = name.endsWith("throwing_knife") && !player.isSneaking();
        }

        if (!isThrowing)
            return;

        boolean rotateWeapon = config.getBoolean("Items." + name + ".ThrownAttributes.Rotate");
        boolean returnWeaponCollideBlocks = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterHittingBlock");
        boolean returnWeaponCollideEntities = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterHittingEntity");
        boolean returnWeaponTooFar = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterTravelingMaxDistance");
        boolean piercing = config.getBoolean("Items." + name + ".ThrownAttributes.Piercing");
        double maxDistance = config.getDouble("Items." + name + ".ThrownAttributes.MaxDistance");
        Location loc = player.getEyeLocation().add(player.getLocation().getDirection());

        Vector velocity = loc.getDirection().normalize().multiply(config.getDouble("Items." + name + ".ThrownAttributes.Velocity"));

        Utils.changeDurability(itemMainHand, -1, true, true, player);

        new ThrowWeaponTask(module, plugin, player, itemMainHand, maxDistance, rotateWeapon, piercing, returnWeaponCollideBlocks, returnWeaponCollideEntities, returnWeaponTooFar, velocity).start();
        player.getInventory().setItemInMainHand(null);
    }
}