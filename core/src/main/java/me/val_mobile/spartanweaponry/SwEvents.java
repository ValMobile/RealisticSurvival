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
package me.val_mobile.spartanweaponry;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SwEvents extends ModuleEvents implements Listener {

    private final SwModule module;
    private final RealisticSurvivalPlugin plugin;

    public SwEvents(SwModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.module = module;
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();

        if (!event.isCancelled()) {
            if (!(projectile == null || shooter == null)) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;
                    if (shouldEventBeRan(player) && shouldEventBeRan(projectile)) {
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();

                        if (RSVItem.isRSVItem(itemMainHand)) {
                            String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);
                            if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                                FileConfiguration config = moduleName.equals(SwModule.NAME) ? RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig() : RSVModule.getModule(SfModule.NAME).getUserConfig().getConfig();
                                String name = RSVItem.getNameFromItem(itemMainHand);
                                String type = name.substring(name.lastIndexOf("_") + 1);
                                if (type.equals("longbow") || type.equals("crossbow")) {
                                    double multiplier = config.getDouble("Items." + name + ".ArrowVelocityMultiplier");
                                    projectile.setVelocity(projectile.getVelocity().multiply(multiplier));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity();
        Entity attacker = event.getDamager();

        if (!event.isCancelled()) {
            if (shouldEventBeRan(defender) && shouldEventBeRan(attacker)) {
                double damage = event.getDamage();

                if (attacker instanceof Arrow || attacker instanceof SpectralArrow || attacker instanceof Firework) {
                    Projectile arrow = (Projectile) event.getDamager();
                    if (arrow.getShooter() != null) {
                        Entity shooter = (Entity) arrow.getShooter();

                        if (shooter instanceof Player) {
                            Player player = (Player) shooter;

                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            if (RSVItem.isRSVItem(itemMainHand)) {
                                String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);
                                if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                                    FileConfiguration config = moduleName.equals(SwModule.NAME) ? RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig() : RSVModule.getModule(SfModule.NAME).getUserConfig().getConfig();

                                    String name = RSVItem.getNameFromItem(itemMainHand);
                                    String type = name.substring(name.lastIndexOf("_") + 1);
                                    if (type.equals("longbow") || type.equals("crossbow")) {
                                        double multiplier = config.getDouble("Items." + name + ".AttackDamageMultiplier");
                                        damage *= multiplier;
                                    }
                                }
                            }
                        }
                    }
                }
                else if (attacker instanceof LivingEntity) {

                    ItemStack itemMainHand = ((LivingEntity) attacker).getEquipment().getItemInMainHand();
                    if (RSVItem.isRSVItem(itemMainHand)) {
                        String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);

                        if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                            FileConfiguration config = moduleName.equals(SwModule.NAME) ? RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig() : RSVModule.getModule(SfModule.NAME).getUserConfig().getConfig();

                            String name = RSVItem.getNameFromItem(itemMainHand);
                            String type = name.substring(name.lastIndexOf("_") + 1);

                            switch (type) {
                                case "rapier": {
                                    if (!Utils.hasArmor(defender)) {
                                        damage *= config.getDouble("Items." + name + ".UnarmoredDamageMultiplier");
                                    }
                                    break;
                                }
                                case "katana": {
                                    if (!Utils.hasChestplate(defender)) {
                                        damage *= config.getDouble("Items." + name + ".ChestDamageMultiplier");
                                    }
                                    break;
                                }
                                case "dagger": {
                                    if (defender instanceof LivingEntity) {
                                        if (((LivingEntity) defender).hasLineOfSight(attacker)) {
                                            damage *= config.getDouble("Items." + name + ".BackstabDamageMultiplier");
                                        }
                                    }
                                    break;
                                }
                                case "lance": {
                                    double sweepMultiplier = config.getDouble("Items." + name + ".SweepingDamageMultiplier");

                                    double ridingMultiplier = config.getDouble("Items." + name + ".RidingDamageBonus");

                                    if (attacker.getVehicle() != null) {
                                        damage *= ridingMultiplier;
                                    }

                                    List<Entity> entities = defender.getNearbyEntities(1.0, 0.25, 1.0);

                                    Location eLoc;
                                    Location defLoc = defender.getLocation();
                                    for (Entity e : entities) {
                                        if (e instanceof LivingEntity) {
                                            eLoc = e.getLocation();
                                            if (Math.abs(eLoc.getY() - defLoc.getY()) <= 0.25) {
                                                if (Math.hypot(eLoc.getX() - defLoc.getX(), eLoc.getZ() - defLoc.getZ()) <= 1.0) {
                                                    ((LivingEntity) e).damage(damage * sweepMultiplier, attacker);
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "greatsword":
                                case "longsword":
                                case "saber":
                                case "glaive":
                                case "quarterstaff": {
                                    List<Entity> entities = defender.getNearbyEntities(1.0, 0.25, 1.0);

                                    double multiplier = config.getDouble("Items." + name + ".SweepingDamageMultiplier");
                                    Location eLoc;
                                    Location defLoc = defender.getLocation();
                                    for (Entity e : entities) {
                                        if (!e.getUniqueId().equals(attacker.getUniqueId())) {
                                            if (e instanceof LivingEntity) {
                                                eLoc = e.getLocation();
                                                if (Math.abs(eLoc.getY() - defLoc.getY()) <= 0.25) {
                                                    if (Math.hypot(eLoc.getX() - defLoc.getX(), eLoc.getZ() - defLoc.getZ()) <= 1.0) {
                                                        ((LivingEntity) e).damage(damage * multiplier, attacker);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "hammer": {
                                    if (defender instanceof LivingEntity) {
                                        int duration = config.getInt("Items." + name + ".Nausea.Duration");
                                        int amplifier = config.getInt("Items." + name + ".Nausea.Amplifier");

                                        PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier);

                                        ((LivingEntity) defender).addPotionEffect(nausea);
                                    }

                                    double kbMultiplier = config.getDouble("Items." + name + ".KnockbackMultiplier");
                                    RealisticSurvivalPlugin.getUtil().setZeroKb(defender);
                                    break;
                                }
                                case "warhammer": {
                                    double armorPiercing = config.getDouble("Items." + name + ".ArmorPiercing");
                                    double dif = event.getFinalDamage() - event.getDamage();

                                    damage += dif * armorPiercing;
                                    break;
                                }
                                case "club": {
                                    if (defender instanceof LivingEntity) {
                                        int duration = config.getInt("Items." + name + ".Nausea.Duration");
                                        int amplifier = config.getInt("Items." + name + ".Nausea.Amplifier");

                                        PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier);

                                        ((LivingEntity) defender).addPotionEffect(nausea);
                                    }
                                    break;
                                }
                                case "halberd": {
                                    int shieldCooldown = config.getInt("Items." + name + ".ShieldBreach.Cooldown");
                                    double chance = config.getDouble("Items." + name + ".ShieldBreach.Chance");
                                    if (defender instanceof Player) {
                                        if (((Player) defender).isBlocking()) {
                                            if (new Random().nextDouble() <= chance) {
                                                ((Player) defender).setCooldown(Material.SHIELD, shieldCooldown);
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "mace": {
                                    if (defender instanceof LivingEntity) {
                                        if (Utils.isUndead(defender)) {
                                            damage *= config.getDouble("Items." + name + ".UndeadDamageMultiplier");

                                        }
                                    }
                                }
                                default: {
                                    break;
                                }
                            }

                        }
                    }
                }

                if (defender instanceof Player) {
                    Player player = (Player) defender;

                    ItemStack itemMainHand = player.getInventory().getItemInMainHand();

                    if (RSVItem.isRSVItem(itemMainHand)) {
                        String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);

                        if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                            FileConfiguration config = moduleName.equals(SwModule.NAME) ? RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig() : RSVModule.getModule(SfModule.NAME).getUserConfig().getConfig();
                            String name = RSVItem.getNameFromItem(itemMainHand);
                            String type = name.substring(name.lastIndexOf("_") + 1);
                            if (type.equals("saber") || type.equals("rapier")) {
                                double multiplier = 1D - config.getDouble("Items." + name + ".Protection.PercentAbsorbed");
                                int maxDecrement = config.getInt("Items." + name + ".Protection.DamageDurability");

                                damage *= multiplier;
                                if (Utils.changeDurability(itemMainHand, maxDecrement)) {
                                    player.getInventory().setItemInMainHand(null);
                                }
                            }
                        }
                    }
                }
                event.setDamage(damage);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            if (event.getAction() == Action.LEFT_CLICK_AIR) {
                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                if (RSVItem.isRSVItem(itemMainHand)) {
                    if (RSVItem.getModuleNameFromItem(itemMainHand).equals(SwModule.NAME)) {
                        String name = RSVItem.getNameFromItem(itemMainHand);
                        String type = name.substring(name.lastIndexOf("_") + 1);

                        FileConfiguration config = module.getUserConfig().getConfig();

                        switch (type) {
                            case "greatsword":
                            case "spear":
                            case "halberd":
                            case "pike":
                            case "lance": {
                                double range = config.getDouble("Items." + name + ".Range");

                                List<Entity> entities = player.getNearbyEntities(range, range, range);

                                Location eye = player.getEyeLocation();

                                for (Entity e : entities) {
                                    if (e instanceof LivingEntity) {
                                        Vector toEntity = ((LivingEntity) e).getEyeLocation().toVector().subtract(eye.toVector());
                                        double dot = toEntity.normalize().dot(eye.getDirection());

                                        if (dot > 0.99D) {
                                            player.attack(e);
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case "dagger":
                            case "throwing_knife":
                            case "tomahawk":
                            case "javelin":
                            case "boomerang": {
                                if (!player.isSneaking()) {
                                    boolean rotateWeapon = config.getBoolean("Items." + name + ".ThrowingAttributes.Rotate");
                                    boolean returnWeapon = config.getBoolean("Items." + name + ".ThrowingAttributes.Return");
                                    boolean piercing = config.getBoolean("Items." + name + ".ThrowingAttributes.Piercing");

                                    new ThrowWeaponTask(module, plugin, player, itemMainHand, rotateWeapon, piercing, returnWeapon).run();
                                    player.getInventory().setItemInMainHand(null);
                                }
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            if (shouldEventBeRan(player)) {
                ItemStack item = player.getInventory().getItem(event.getNewSlot());
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getModuleNameFromItem(item).equals(SwModule.NAME)) {
                        String name = RSVItem.getNameFromItem(item);
                        String type = name.substring(name.lastIndexOf("_") + 1);

                        switch (type) {
                            case "longsword":
                            case "katana":
                            case "greatsword":
                            case "warhammer":
                            case "halberd":
                            case "pike": {
                                UUID id = player.getUniqueId();
                                HashMap<UUID, String> players = TwoHandedTask.getPlayers();

                                if (!players.containsKey(id)) {
                                    players.put(id, name);
                                    new TwoHandedTask(module, plugin, player, name).startRunnable();
                                }
                                else {
                                    players.replace(id, players.get(id), name);
                                }
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}