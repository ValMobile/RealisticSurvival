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
package me.val_mobile.spartan_weaponry;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import java.util.List;

import static org.bukkit.Material.ARROW;
import static org.bukkit.Material.SPECTRAL_ARROW;

public class SpartanWeaponryEvents implements Listener {

    private final Utils util;
    private final RealisticSurvivalPlugin plugin;
    public SpartanWeaponryEvents(RealisticSurvivalPlugin instance) {
        util = new Utils(instance);
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();

        if (projectile != null) {
            if (shooter != null) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;

                    if (util.shouldEventBeRan(player, "SpartanWeaponry")) {
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                        if (Utils.isItemReal(itemMainHand)) {

                            if (util.hasNbtTag(itemMainHand, "spartans_weapon") && util.hasNbtTag(itemMainHand, "material_type")) {
                                Vector velocity = projectile.getVelocity();

                                String weaponType = util.getNbtTag(itemMainHand, "spartans_weapon");
                                String materialType = util.getNbtTag(itemMainHand, "material_type");

                                String configPath = weaponType + "." + materialType + "." + "ArrowVelocityMultiplier";

                                switch (weaponType) {
                                    case "Crossbow":
                                    case "Longbow": {
                                        double multiplier = CustomConfig.getSpartanWeaponryConfig().getDouble(configPath);
                                        projectile.setVelocity(velocity.multiply(multiplier));
                                        break;
                                    }
                                    case "Bow": {
                                        double multiplier = CustomConfig.getIceFireGearConfig().getDouble(configPath);
                                        projectile.setVelocity(velocity.multiply(multiplier));
                                        break;
                                    }
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
        Entity entity = event.getEntity();
        Entity attacker = event.getDamager();

        if (attacker.getType().equals(ARROW) || attacker.getType().equals(SPECTRAL_ARROW)) {
            Projectile arrow = (Projectile) event.getDamager();
            if (arrow.getShooter() != null) {
                Entity shooter = (Entity) arrow.getShooter();

                if (shooter instanceof Player) {
                    Player player = (Player) shooter;

                    if (util.shouldEventBeRan(player, "SpartanWeaponry")) {
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                        if (!(itemMainHand == null || itemMainHand.getType() == Material.AIR)) {

                            if (util.hasNbtTag(itemMainHand, "spartans_weapon") && util.hasNbtTag(itemMainHand, "material_type")) {
                                String weaponType = util.getNbtTag(itemMainHand, "spartans_weapon");
                                String materialType = util.getNbtTag(itemMainHand, "material_type");

                                String configPath = weaponType + "." + materialType + "." + "AttackDamageMultiplier";

                                if (weaponType.equals("Crossbow") || weaponType.equals("Longbow")) {
                                    double multiplier = CustomConfig.getSpartanWeaponryConfig().getDouble(configPath);
                                    event.setDamage(event.getDamage() * multiplier);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (attacker.getType().equals(EntityType.PLAYER)) {
            Player player = (Player) attacker;

            if (util.shouldEventBeRan(player, "SpartanWeaponry")) {
                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                if (Utils.isItemReal(itemMainHand)) {

                    if (util.hasNbtTag(itemMainHand, "spartans_weapon")) {
                        switch (util.getNbtTag(itemMainHand, "spartans_weapon")) {
                            case "Rapier":
                                if (!Utils.hasArmor((LivingEntity) entity)) {
                                    event.setDamage(event.getDamage() * 3.0D);
                                }
                                break;
                            case "Katana":
                                if (!Utils.hasChestplate((LivingEntity) entity)) {
                                    event.setDamage(event.getDamage() * 2.0D);
                                }
                                break;
                            case "Glaive":
                            case "Greatsword":
                            case "Halberd":
                            case "Lance":
                            case "Spear":
                                break;
                        }
                    }
                }
            }

        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "SpartanWeaponry")) {
            if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {

                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                if (Utils.isItemReal(itemMainHand)) {
                    if (util.hasNbtTag(itemMainHand, "spartans_weapon")) {
                        switch (util.getNbtTag(itemMainHand, "spartans_weapon")) {
                            case "Glaive":
                            case "Greatsword":
                            case "Halberd":
                            case "Lance":
                            case "Spear": {
                                List<Entity> entities = player.getNearbyEntities(7, 7, 7);

                                if (entities.size() > 1) {
                                    for (Entity e : entities) {
                                        if (e instanceof LivingEntity) {
                                            if (Utils.isInRange(player, (LivingEntity) e, 7)) {
                                                ((LivingEntity) e).damage(Utils.getDamage(itemMainHand), player);
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            case "Pike":
                                List<Entity> entities = player.getNearbyEntities(8, 8, 8);

                                if (entities.size() > 1) {
                                    for (Entity e : entities) {
                                        if (e instanceof LivingEntity) {
                                            if (Utils.isInRange(player, (LivingEntity) e, 8)) {
                                                ((LivingEntity) e).damage(Utils.getDamage(itemMainHand), player);
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSmithing(PrepareSmithingEvent event) {
        if (!(event.getInventory().getRecipe() == null || event.getResult() == null)) {
            if (event.getResult().getType() == Material.NETHERITE_SWORD) {
                if (!util.hasNbtTag(event.getResult(), "spartans_weapon")) {
                    for (ItemStack i : event.getInventory().getContents()) {
                        if (util.hasNbtTag(i, "spartans_weapon")) {
                            event.setResult(null);
                            break;
                        }
                    }
                }
            }
        }
    }
}