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

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import static org.bukkit.Material.ARROW;
import static org.bukkit.Material.SPECTRAL_ARROW;

public class SpartanWeaponryEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!event.isCancelled()) {
            Projectile projectile = event.getEntity();
            ProjectileSource shooter = projectile.getShooter();
            if (projectile != null) {
                if (shooter != null) {
                    if (shooter instanceof Player) {
                        Player player = (Player) shooter;
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                        if (!(itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
                            NBTItem item = new NBTItem(itemMainHand);
                            if (item.hasKey("Spartan's Weapon") && item.hasKey("Material Type")) {
                                Vector velocity = projectile.getVelocity();

                                String weaponType = item.getString("Spartan's Weapon");
                                String materialType = item.getString("Material Type");

                                String configPath = weaponType + "." + materialType + "." + "VelocityMultiplier";

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
        if (!event.isCancelled()) {

            Entity entity = event.getEntity();
            Entity attacker = event.getDamager();

            if (attacker.getType().equals(ARROW) || attacker.getType().equals(SPECTRAL_ARROW)) {
                Projectile arrow = (Projectile) event.getDamager();
                if (arrow.getShooter() != null) {
                    Entity shooter = (Entity) arrow.getShooter();

                    if (shooter instanceof Player) {
                        Player player = (Player) shooter;
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                        if (!(itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
                            NBTItem item = new NBTItem(itemMainHand);
                            if (item.hasKey("Spartan's Weapon") && item.hasKey("Material Type")) {
                                String weaponType = item.getString("Spartan's Weapon");
                                String materialType = item.getString("Material Type");

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
            if (attacker.getType().equals(EntityType.PLAYER)) {
                Player player = (Player) attacker;

                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                if (!(itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
                    NBTItem item = new NBTItem(itemMainHand);
                    if (item.hasKey("Spartan's Weapon")) {
                        switch (item.getString("Spartan's Weapon")) {
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
                        }
                    }
                }
            }
        }
    }
}