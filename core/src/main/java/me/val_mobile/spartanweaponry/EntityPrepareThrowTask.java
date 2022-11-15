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

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EntityPrepareThrowTask extends BukkitRunnable {

    private final FileConfiguration config;
    private final LivingEntity entity;
    private final RealisticSurvivalPlugin plugin;
    private final RSVModule module;
    private final double chance;
    private final boolean rotateWeapon;
    private final boolean piercing;
    private final boolean returnWeaponCollideBlocks;
    private final boolean returnWeaponCollideEntities;
    private final boolean returnWeaponTooFar;
    private final double maxDistance;
    private final List<String> blacklistedMobs;
    private final List<String> blacklistedItems;
    private static final Map<UUID, EntityPrepareThrowTask> tasks = new HashMap<>();

    public EntityPrepareThrowTask(RSVModule module, RealisticSurvivalPlugin plugin, LivingEntity entity, ItemStack item) {
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        FileConfiguration swConfig = RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig();
        String name = RSVItem.getNameFromItem(item);
        this.plugin = plugin;
        this.entity = entity;
        this.chance = swConfig.getDouble("MobAbilities.UseThrowingWeapons.Chance");

        this.rotateWeapon = config.getBoolean("Items." + name + ".ThrownAttributes.Rotate");
        this.piercing = config.getBoolean("Items." + name + ".ThrownAttributes.Piercing");
        this.returnWeaponCollideBlocks = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterHittingBlock");
        this.returnWeaponCollideEntities = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterHittingEntity");
        this.returnWeaponTooFar = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterTravelingMaxDistance");
        this.maxDistance = config.getDouble("Items." + name + ".ThrownAttributes.MaxDistance");
        this.blacklistedMobs = swConfig.getStringList("MobAbilities.UseThrowingWeapons.MobBlacklist");
        this.blacklistedItems = swConfig.getStringList("MobAbilities.UseThrowingWeapons.WeaponBlacklist");

        tasks.put(entity.getUniqueId(), this);
    }

    @Override
    public void run() {
        if (entity == null) {
            stop();
        }
        else {
            if (blacklistedMobs.contains(entity.getType().toString())) {
                stop();
            }
            else {
                if (entity.getEquipment() == null) {
                    stop();
                }
                else {
                    ItemStack itemMainHand = entity.getEquipment().getItemInMainHand();

                    if (Utils.isItemReal(itemMainHand)) {
                        if (RSVItem.isRSVItem(itemMainHand)) {
                            String name = RSVItem.getNameFromItem(itemMainHand);

                            if (blacklistedItems.contains(name)) {
                                stop();
                            }
                            else {
                                if (name.contains("_")) {
                                    String type = name.substring(name.lastIndexOf("_") + 1);

                                    boolean isThrowing;
                                    switch (type) {
                                        case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = true;
                                        default -> isThrowing = name.endsWith("throwing_knife");
                                    }

                                    if (isThrowing) {
                                        if (Math.random() <= chance) {
                                            Location loc = entity.getLocation();
                                            Vector velocity = loc.getDirection().normalize().multiply(config.getDouble("Items." + name + ".ThrownAttributes.Velocity"));
                                            if (!ThrowWeaponTask.hasTask(entity.getUniqueId())) {
                                                new ThrowWeaponTask(module, plugin, entity, itemMainHand, maxDistance, rotateWeapon, piercing, returnWeaponCollideBlocks, returnWeaponCollideEntities, returnWeaponTooFar, velocity).start();
                                                entity.getEquipment().setItemInMainHand(null);
                                            }
                                        }
                                    }
                                }
                                else {
                                    stop();
                                }
                            }
                        }
                        else {
                            stop();
                        }
                    }
                }
            }
        }
    }

    public void stop() {
        tasks.remove(entity.getUniqueId());
        cancel();
    }


    public void start() {
        FileConfiguration swConfig = RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig();

        runTaskTimer(plugin, 0, swConfig.getInt("MobAbilities.UseThrowingWeapons.TickPeriod"));
    }


    public LivingEntity getEntity() {
        return entity;
    }

    public static Map<UUID, EntityPrepareThrowTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
