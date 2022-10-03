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
package me.val_mobile.spartanandfire;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class SfEvents extends ModuleEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;
    private final SfModule module;
    private final FileConfiguration config;

    public SfEvents(SfModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
    }

    /**
     * Activates dragon weapon abilities if a player attacks with a dragon weapon
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity(); // get the defender
        Entity attacker = event.getDamager(); // get the attacker

        if (!event.isCancelled()) {
            if (shouldEventBeRan(attacker) && shouldEventBeRan(defender)) {
                Utils util = RealisticSurvivalPlugin.getUtil();
                double damage = event.getDamage();

                if (attacker instanceof LivingEntity living) {
                    if (living.getEquipment() != null) {
                        ItemStack itemMainHand = living.getEquipment().getItemInMainHand(); // get the item in the player's main hand

                        // check if the item is real
                        if (RSVItem.isRSVItem(itemMainHand)) {
                            if (RSVItem.getModuleNameFromItem(itemMainHand).equals(SfModule.NAME)) {
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
                }

                else if (attacker instanceof Arrow || attacker instanceof SpectralArrow || attacker instanceof Firework) {
                    Projectile arrow = (Projectile) attacker;
                    if (arrow.getShooter() != null) {
                        Entity shooter = (Entity) arrow.getShooter();

                        if (shooter instanceof LivingEntity living) {
                            if (living.getEquipment() != null) {
                                ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

                                if (RSVItem.isRSVItem(itemMainHand)) {
                                    if (RSVItem.getModuleNameFromItem(itemMainHand).equals(SfModule.NAME)) {
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
    }

}
