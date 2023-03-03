/*
    Copyright (C) 2023  Val_Mobile

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

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import me.val_mobile.spartanandfire.FreezeTask;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.*;

public class ThrowWeaponTask extends BukkitRunnable {

    private final double maxDistanceSquared;
    private final FileConfiguration config;
    private final String name;
    private final ArmorStand armorStand;
    private final LivingEntity entity;
    private final ItemStack item;
    private final boolean rotateWeapon;
    private final boolean piercing;
    private final boolean returnWeaponCollideBlocks;
    private final boolean returnWeaponCollideEntities;
    private final boolean returnWeaponTooFar;
    private final RSVModule module;
    private final RealisticSurvivalPlugin plugin;
    private final Location started;

    private final Vector vector;
    private static final Map<UUID, ThrowWeaponTask> tasks = new HashMap<>();

    public ThrowWeaponTask(RSVModule module, RealisticSurvivalPlugin plugin, LivingEntity entity, ItemStack item, double maxDistance, boolean rotateWeapon, boolean piercing, boolean returnWeaponCollideBlocks, boolean returnWeaponCollideEntities, boolean returnWeaponTooFar, Vector velocity) {
        this.config = module.getUserConfig().getConfig();
        this.module = module;
        this.name = RSVItem.getNameFromItem(item);
        this.maxDistanceSquared = maxDistance * maxDistance;
        this.plugin = plugin;
        this.entity = entity;
        this.item = item;
        this.rotateWeapon = rotateWeapon;
        this.piercing = piercing;
        this.returnWeaponCollideBlocks = returnWeaponCollideBlocks;
        this.returnWeaponCollideEntities = returnWeaponCollideEntities;
        this.returnWeaponTooFar = returnWeaponTooFar;
        this.vector = velocity.multiply(1/20D);
        this.started = entity.getLocation().add(0, 0.9, 0);
        this.armorStand = spawnArmorstand(entity, item);
        tasks.put(entity.getUniqueId(), this);
    }

    public ArmorStand spawnArmorstand(LivingEntity thrower, ItemStack itemStack) {
        return thrower.getWorld().spawn(started.clone(), ArmorStand.class, armorStand -> {
            armorStand.setArms(true);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            armorStand.setSmall(true);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            armorStand.setPersistent(false);

            if (config.getBoolean("Items." + name + ".ThrownAttributes.ThrownSound.Enabled")) {
                String soundName = config.getString("Items." + name + ".ThrownAttributes.ThrownSound.Sound");
                float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.ThrownSound.Volume");
                float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.ThrownSound.Pitch");
                Utils.playSound(thrower.getLocation(), soundName, volume, pitch);
            }

            // sets armor stand arm item and body angle
            armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 270, 0, 0));

            Objects.requireNonNull(armorStand.getEquipment()).setItemInMainHand(itemStack.clone());
        });
    }

    @Override
    public void run() {
        if (entity == null) {
            dropWeaponTask(armorStand, item);
        }
        else {
            if (entity instanceof Player player && !player.isOnline()) {
                dropWeaponTask(armorStand, item);
            }
            else {
                if (entity.getEquipment() != null) {
                    Location loc = armorStand.getLocation().add(vector);
                    armorStand.teleport(loc);

                    // rotate floating item by 45 degrees per tick
                    if (rotateWeapon) {
                        armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 45, 0, 0));
                    }

                    RayTraceResult result = armorStand.rayTraceBlocks(0.109);
                    List<Entity> entityList = armorStand.getNearbyEntities(0.3, 0.3, 0.3);

                    // check if the raytrace result has a block within the max distance
                    // if it hits a block, the weapon is either returned or dropped
                    if (result != null) {
                        if (result.getHitBlock() != null && !result.getHitBlock().isPassable()) {
                            if (returnWeaponCollideBlocks) {
                                returnWeapon();
                            }
                            else {
                                dropWeaponTask(armorStand, entity, item.clone());
                            }

                            if (config.getBoolean("Items." + name + ".ThrownAttributes.HitGroundSound.Enabled")) {
                                String soundName = config.getString("Items." + name + ".ThrownAttributes.HitGroundSound.Sound");
                                float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitGroundSound.Volume");
                                float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitGroundSound.Pitch");
                                Utils.playSound(armorStand.getLocation(), soundName, volume, pitch);
                            }
                        }
                    }

                    // check if there are nearby entities around the given bounding box
                    // piercing can hit through multiple entities without returning
                    if (!entityList.isEmpty() && !entityList.contains(entity)) {
                        double attackDamage = config.getDouble("Items." + name + ".ThrownAttributes.AttackDamage");

                        for (Entity e : entityList) {
                            if (e instanceof Damageable damageable && e.getUniqueId() != entity.getUniqueId()) {
                                String name = RSVItem.getNameFromItem(item);
                                String type = name.substring(0, name.lastIndexOf("_"));

                                boolean shouldBurn = false;
                                boolean shouldFreeze = false;
                                boolean shouldStrikeLightning = false;
                                boolean shouldElectrocute = false;

                                switch (type) {
                                    case "dragonbone_flamed" -> {
                                        if (Utils.hasNbtTag(damageable, "rsvmob")) {
                                            if (!Utils.getNbtTag(damageable, "rsvmob", PersistentDataType.STRING).equals("fire_dragon")) {
                                                attackDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                            }
                                        }

                                        if (!BurnTask.hasTask(damageable.getUniqueId())) {
                                            shouldBurn = true;
                                        }
                                    }
                                    case "dragonbone_iced" -> {
                                        if (Utils.hasNbtTag(damageable, "rsvmob")) {
                                            if (!Utils.getNbtTag(damageable, "rsvmob", PersistentDataType.STRING).equals("ice_dragon")) {
                                                attackDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                            }
                                        }
                                        if (!FreezeTask.hasTask(damageable.getUniqueId())) {
                                            shouldFreeze = true;
                                        }
                                    }
                                    case "dragonbone_lightning" -> {
                                        if (Utils.hasNbtTag(damageable, "rsvmob")) {
                                            if (!Utils.getNbtTag(damageable, "rsvmob", PersistentDataType.STRING).equals("lightning_dragon")) {
                                                attackDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
                                            }
                                        }
                                        shouldStrikeLightning = true;

                                        if (!ElectrocuteTask.hasTask(damageable.getUniqueId())) {
                                            shouldElectrocute = true;
                                        }
                                    }
                                    case "dragonsteel_fire" -> {
                                        if (!BurnTask.hasTask(damageable.getUniqueId())) {
                                            shouldBurn = true;
                                        }
                                    }
                                    case "dragonsteel_ice" -> {
                                        if (!FreezeTask.hasTask(damageable.getUniqueId())) {
                                            shouldFreeze = true;
                                        }
                                    }
                                    case "dragonsteel_lightning" -> {
                                        shouldStrikeLightning = true;

                                        if (!ElectrocuteTask.hasTask(damageable.getUniqueId())) {
                                            shouldElectrocute = true;
                                        }
                                    }
                                    default -> {}
                                }

                                if (name.contains("dagger")) {
                                    if (Utils.wasBackstabbed(entity, damageable)) {
                                        attackDamage *= config.getDouble("Items." + name + ".BackstabDamageMultiplier");
                                    }
                                }

                                if (isAttackable(damageable)) {
                                    if (shouldBurn) {
                                        int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                                        int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                                        new BurnTask(plugin, damageable, fireTicks, tickPeriod).start();
                                    }

                                    if (shouldFreeze) {
                                        new FreezeTask(plugin, module, name, damageable).start();
                                    }

                                    if (shouldStrikeLightning) {
                                        if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                                            Location eLoc = damageable.getLocation();
                                            if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                                                eLoc.getWorld().strikeLightningEffect(loc);
                                            } else {
                                                eLoc.getWorld().strikeLightning(loc);
                                            }
                                        }
                                    }

                                    if (shouldElectrocute) {
                                        new ElectrocuteTask(plugin, module, name, damageable).start();
                                    }

                                    Utils.damageEntity(damageable, attackDamage);
                                }
                            }
                        }

                        if (config.getBoolean("Items." + name + ".ThrownAttributes.HitMobSound.Enabled")) {
                            String soundName = config.getString("Items." + name + ".ThrownAttributes.HitMobSound.Sound");
                            float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitMobSound.Volume");
                            float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitMobSound.Pitch");
                            Utils.playSound(armorStand.getLocation(), soundName, volume, pitch);
                        }

                        if (returnWeaponCollideEntities && !piercing) {
                            returnWeapon();
                        }

                        if (!piercing) {
                            dropWeaponTask(armorStand, entity, item.clone());
                        }
                    }


                    if (armorStand.getWorld().getName().equals(entity.getWorld().getName())) {
                        // drop the weapon if the distance is greater 60 blocks
                        if (armorStand.getLocation().distanceSquared(started) > maxDistanceSquared) {
                            if (returnWeaponTooFar) {
                                returnWeapon();
                            }
                            else {
                                if (config.getBoolean("MaxDistanceReached.Enabled")) {
                                    String message = Utils.translateMsg(entity, config.getString("MaxDistanceReached.Message"));
                                    message = message.replaceAll("%MAX_DISTANCE%", String.valueOf(Math.round(Math.sqrt(maxDistanceSquared))));
                                    entity.sendMessage(message);
                                }
                                dropWeaponTask(armorStand, entity, item.clone());
                            }
                        }
                    }
                    // distance can't be calculated across different worlds, therefore item must be dropped
                    else {
                        dropWeaponTask(armorStand, entity, item.clone());
                    }
                }
                else {
                    dropWeaponTask(armorStand, item);
                }
            }
        }
    }

    public void dropWeaponTask(ArmorStand as, ItemStack itemStack) {
        Item droppedItem = as.getWorld().dropItem(as.getLocation(), itemStack.clone());

        droppedItem.setGlowing(true);

        as.remove();

        tasks.remove(entity.getUniqueId());
        cancel();
    }

    public void dropWeaponTask(ArmorStand as, LivingEntity entity, ItemStack itemStack) {
        Item droppedItem = as.getWorld().dropItem(as.getLocation(), itemStack.clone());
        Location loc = droppedItem.getLocation();

        droppedItem.setGlowing(true);

        as.remove();

        if (config.getBoolean("WeaponDropped.Enabled")) {
            String message = Utils.translateMsg(this.entity, config.getString("WeaponDropped.Message"));
            message = message.replaceAll("%X-COORD%", String.valueOf((int) loc.getX()));
            message = message.replaceAll("%Y-COORD%", String.valueOf((int) loc.getY()));
            message = message.replaceAll("%Z-COORD%", String.valueOf((int) loc.getZ()));

            entity.sendMessage(message);
        }

        tasks.remove(entity.getUniqueId());
        cancel();
    }

    public void returnWeapon() {
        new ReturnWeaponTask(module, item, armorStand, entity, rotateWeapon).runTaskTimer(plugin, 4L, 1L);

        cancel();
        tasks.remove(entity.getUniqueId());
    }

    public void start() {
        runTaskTimer(plugin, 0, 1);
    }

    public void centeredThrow(){
        armorStand.teleport(entity.getLocation().add(0,0.9, 0));
    }

    public void resetArmorstandArmPos(){
        armorStand.setRightArmPose(new EulerAngle(0, 0, 0));
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public static Map<UUID, ThrowWeaponTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public boolean isAttackable(Damageable damageable) {
        if (damageable instanceof Player p) {
            return !p.isBlocking() || Utils.wasBackstabbed(entity, p);
        }
        return true;
    }
}
