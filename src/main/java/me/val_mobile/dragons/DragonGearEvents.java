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
package me.val_mobile.dragons;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
/**
 * DragonGearEvents is a class containing listener methods
 * that activate fire, ice, and lighting dragon weapon abilities
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonGearEvents implements Listener {

    // Dependency injecting the abilities classes for use
    private final DragonGearAbilities dragonGearAbilities;
    private final Utils util;

    // constructing the DragonGearEvents class
    public DragonGearEvents(RealisticSurvivalPlugin instance) {
        dragonGearAbilities = new DragonGearAbilities(instance);
        util = new Utils(instance);
    }

    /**
     * Activates defensive dragon armor abilities if a player is attacked by a dragon breath
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();

        if (util.shouldEventBeRan(entity, "Dragons")) {
            // if a player was attacked
            if (event.getEntity() instanceof Player) {
                Player player = (Player) entity; // get the player
                EntityDamageEvent.DamageCause cause = event.getCause(); // get the cause

                // if a dragon breath caused the damage
                if (cause.equals(EntityDamageEvent.DamageCause.DRAGON_BREATH)) {
                    double dragonProtection = 0; // create a temp variable to store dragon breath protection

                    // check all armor slots
                    for (ItemStack item : player.getInventory().getArmorContents()) {
                        // if a real item is in the armor slot
                        if (Utils.isItemReal(item)) {

                            // if the item has the nbt tag, "dragonscale_armor"
                            if (util.hasNbtTag(item, "dragonscale_armor")) {
                                // add some protection
                                dragonProtection += CustomConfig.getIceFireGearConfig().getDouble("Abilities.Dragonscale.DamageReduction");
                            }
                            // if the item has the nbt tag, "dragonsteel_armor"
                            else if (util.hasNbtTag(item, "dragonsteel_armor")) {
                                // add some protection
                                dragonProtection += CustomConfig.getIceFireGearConfig().getDouble("Abilities.Dragonsteel.DamageReduction");
                            }
                        }
                    }
                    // reduce the damage
                    event.setDamage(event.getDamage() * (1D - dragonProtection));
                }
            }
        }
    }

    /**
     * Activates dragon weapon abilities if a player attacks with a dragon weapon
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity(); // get the entity
        Entity attacker = event.getDamager(); // get the attacker

        // find out what entity the attacker is
        switch (attacker.getType()) {
            // if the attacker is a player
            case PLAYER: {
                Player player = (Player) event.getDamager(); // get the player

                if (util.shouldEventBeRan(player, "Dragons")) {
                    ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the player's main hand

                    // check if the item is real
                    if (Utils.isItemReal(itemMainHand)) {

                        // check if the item has a material type
                        if (util.hasNbtTag(itemMainHand, "material_type")) {

                            // get the key
                            switch (util.getNbtTag(itemMainHand, "material_type")) {
                                // if the item is a fire dragonbone weapon
                                case "FlamedDragonbone":
                                    // if the attacked entity is a dragon
                                    if (entity instanceof Dragon) {
                                        if (!(entity instanceof FireDragon)) {
                                            event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.FlamedDragonbone.BonusDamage"));
                                        }
                                    }
                                    dragonGearAbilities.FireDragonboneAbility((LivingEntity) entity);
                                    break;
                                case "IcedDragonbone":
                                    if (entity instanceof Dragon) {
                                        if (!(entity instanceof IceDragon)) {
                                            event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.IcedDragonbone.BonusDamage"));
                                        }
                                    }
                                    dragonGearAbilities.IceDragonboneAbility((LivingEntity) entity);
                                    break;
                                case "LightningDragonbone":
                                    if (entity instanceof Dragon) {
                                        if (!(entity instanceof LightningDragon)) {
                                            event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.LightningDragonbone.BonusDamage"));
                                        }
                                    }
                                    dragonGearAbilities.LightningDragonboneAbility((LivingEntity) entity, player);
                                    break;
                                case "FireDragonsteel":
                                    dragonGearAbilities.FireDragonsteelAbility((LivingEntity) entity);
                                    break;
                                case "IceDragonsteel":
                                    dragonGearAbilities.IceDragonsteelAbility((LivingEntity) entity);
                                    break;
                                case "LightningDragonsteel":
                                    dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) entity, player);
                                    break;
                            }
                        }
                    }
                }
                break;
            }
            case ARROW:
            case SPECTRAL_ARROW: {
                Projectile arrow = (Projectile) attacker;
                if (arrow.getShooter() != null) {
                    Entity shooter = (Entity) arrow.getShooter();

                    if (shooter instanceof Player) {
                        Player player = (Player) shooter;

                        if (util.shouldEventBeRan(player, "Dragons")) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            if (Utils.isItemReal(itemMainHand)) {

                                if (util.hasNbtTag(itemMainHand, "spartans_weapon") && util.hasNbtTag(itemMainHand, "material_type")) {
                                    String weaponType = util.getNbtTag(itemMainHand, "spartans_weapon");
                                    String materialType = util.getNbtTag(itemMainHand, "material_type");

                                    String configPath = weaponType + "." + materialType + "." + "AttackDamageMultiplier";

                                    if (weaponType.equals("Bow")) {
                                        double multiplier = CustomConfig.getIceFireGearConfig().getDouble(configPath);
                                        event.setDamage(event.getDamage() * multiplier);
                                    }

                                    switch (materialType) {
                                        case "FlamedDragonbone":
                                            if (entity instanceof Dragon) {
                                                if (!(entity instanceof FireDragon)) {
                                                    event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.FlamedDragonbone.BonusDamage"));
                                                }
                                            }
                                            dragonGearAbilities.FireDragonboneAbility((LivingEntity) entity);
                                            break;
                                        case "IcedDragonbone":
                                            if (entity instanceof Dragon) {
                                                if (!(entity instanceof IceDragon)) {
                                                    event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.IcedDragonbone.BonusDamage"));
                                                }
                                            }
                                            dragonGearAbilities.IceDragonboneAbility((LivingEntity) entity);
                                            break;
                                        case "LightningDragonbone":
                                            if (entity instanceof Dragon) {
                                                if (!(entity instanceof LightningDragon)) {
                                                    event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.LightningDragonbone.BonusDamage"));
                                                }
                                            }
                                            dragonGearAbilities.LightningDragonboneAbility((LivingEntity) entity, player);
                                            break;
                                        case "FireDragonsteel":
                                            dragonGearAbilities.FireDragonsteelAbility((LivingEntity) entity);
                                            break;
                                        case "IceDragonsteel":
                                            dragonGearAbilities.IceDragonsteelAbility((LivingEntity) entity);
                                            break;
                                        case "LightningDragonsteel":
                                            dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) entity, player);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            }
            case ENDER_DRAGON: {
                if (event.getEntity() instanceof Player) {
                    Player player = (Player) event.getEntity();

                    if (util.shouldEventBeRan(player, "Dragons")) {
                        double dragonProtection = 0;
                        for (ItemStack item : player.getInventory().getArmorContents()) {
                            if (Utils.isItemReal(item)) {
                                if (util.hasNbtTag(item, "dragonscale_armor")) {
                                    dragonProtection += 0.1;
                                } else if (util.hasNbtTag(item, "dragonsteel_armor")) {
                                    dragonProtection += 0.2;
                                }
                            }
                        }
                        event.setDamage(event.getDamage() * (1D - dragonProtection));
                    }
                }
                break;
            }

        }
    }
}