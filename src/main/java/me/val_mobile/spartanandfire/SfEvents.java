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
import me.val_mobile.data.RSVFiles;
import me.val_mobile.iceandfire.*;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SfEvents extends ModuleEvents implements Listener {

    // Dependency injecting the abilities classes for use
    private final SfAbilities abilities;
    private final RealisticSurvivalPlugin plugin;
    private final Utils util;

    // constructing the DragonGearEvents class
    public SfEvents(SfModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        abilities = new SfAbilities(plugin);
        util = new Utils(plugin);
        this.plugin = plugin;
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
        FileConfiguration config = RSVFiles.getIfUserConfig();

        // find out what entity the attacker is
        switch (attacker.getType()) {
            // if the attacker is a player
            case PLAYER: {
                Player player = (Player) event.getDamager(); // get the player

                if (util.shouldEventBeRan(player, "Dragons")) {
                    ItemStack itemMainHand = player.getInventory().getItemInMainHand(); // get the item in the player's main hand

                    // check if the item is real
                    if (Utils.isItemReal(itemMainHand)) {
                        if (RSVItem.isRSVItem(itemMainHand, util)) {
                            String name = RSVItem.convertItemStackToRSVItem(itemMainHand, plugin).getName();

                        }
                        // check if the item has a material type
                        if (util.hasNbtTag(itemMainHand, "material_type")) {

                            // get the key
                            switch (util.getNbtTag(itemMainHand, "material_type")) {
                                // if the item is a fire dragonbone weapon
                                case "FlamedDragonbone":
                                    // if the attacked entity is a dragon
                                    if (entity instanceof Dragon) {
                                        if (!(entity instanceof FireDragon)) {
                                            event.setDamage(event.getDamage() + config.getDouble("Abilities.FlamedDragonbone.BonusDamage"));
                                        }
                                    }
                                    abilities.FireDragonboneAbility((LivingEntity) entity);
                                    break;
                                case "IcedDragonbone":
                                    if (entity instanceof Dragon) {
                                        if (!(entity instanceof IceDragon)) {
                                            event.setDamage(event.getDamage() + config.getDouble("Abilities.IcedDragonbone.BonusDamage"));
                                        }
                                    }
                                    abilities.IceDragonboneAbility((LivingEntity) entity);
                                    break;
                                case "LightningDragonbone":
                                    if (entity instanceof Dragon) {
                                        if (!(entity instanceof LightningDragon)) {
                                            event.setDamage(event.getDamage() + config.getDouble("Abilities.LightningDragonbone.BonusDamage"));
                                        }
                                    }
                                    abilities.LightningDragonboneAbility((LivingEntity) entity, player);
                                    break;
                                case "FireDragonsteel":
                                    abilities.FireDragonsteelAbility((LivingEntity) entity);
                                    break;
                                case "IceDragonsteel":
                                    abilities.IceDragonsteelAbility((LivingEntity) entity);
                                    break;
                                case "LightningDragonsteel":
                                    abilities.LightningDragonsteelAbility((LivingEntity) entity, player);
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
                                        double multiplier = config.getDouble(configPath);
                                        event.setDamage(event.getDamage() * multiplier);
                                    }

                                    switch (materialType) {
                                        case "FlamedDragonbone":
                                            if (entity instanceof Dragon) {
                                                if (!(entity instanceof FireDragon)) {
                                                    event.setDamage(event.getDamage() + config.getDouble("Abilities.FlamedDragonbone.BonusDamage"));
                                                }
                                            }
                                            abilities.FireDragonboneAbility((LivingEntity) entity);
                                            break;
                                        case "IcedDragonbone":
                                            if (entity instanceof Dragon) {
                                                if (!(entity instanceof IceDragon)) {
                                                    event.setDamage(event.getDamage() + config.getDouble("Abilities.IcedDragonbone.BonusDamage"));
                                                }
                                            }
                                            abilities.IceDragonboneAbility((LivingEntity) entity);
                                            break;
                                        case "LightningDragonbone":
                                            if (entity instanceof Dragon) {
                                                if (!(entity instanceof LightningDragon)) {
                                                    event.setDamage(event.getDamage() + config.getDouble("Abilities.LightningDragonbone.BonusDamage"));
                                                }
                                            }
                                            abilities.LightningDragonboneAbility((LivingEntity) entity, player);
                                            break;
                                        case "FireDragonsteel":
                                            abilities.FireDragonsteelAbility((LivingEntity) entity);
                                            break;
                                        case "IceDragonsteel":
                                            abilities.IceDragonsteelAbility((LivingEntity) entity);
                                            break;
                                        case "LightningDragonsteel":
                                            abilities.LightningDragonsteelAbility((LivingEntity) entity, player);
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
