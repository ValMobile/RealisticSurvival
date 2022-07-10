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

import me.val_mobile.data.RSVFiles;
import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Attack;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.function.Predicate;

import static org.bukkit.Material.ARROW;
import static org.bukkit.Material.SPECTRAL_ARROW;

public class SwEvents extends ModuleEvents implements Listener {

    private final Utils util;
    private final RSVModule module;
    public SwEvents(RSVModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.module = module;
        util = new Utils(plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();

        if (projectile != null) {
            if (shooter != null) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;
                    if (shouldEventBeRan(player)) {
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                        if (RSVItem.isRSVItem(itemMainHand, util)) {
                            if (util.getNbtTag(itemMainHand, "rsvmodule").equals("spartanweaponry")) {
                                String name = util.getNbtTag(itemMainHand, "rsvitem");
                                if (name.endsWith("longbow") || name.endsWith("crossbow")) {
                                    double multiplier = RSVFiles.getSwUserConfig().getDouble(name + ".ArrowVelocityMultiplier");
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
        Entity entity = event.getEntity();
        Entity attacker = event.getDamager();

        if (attacker.getType() == EntityType.ARROW || attacker.getType() == EntityType.SPECTRAL_ARROW) {
            Projectile arrow = (Projectile) event.getDamager();
            if (arrow.getShooter() != null) {
                Entity shooter = (Entity) arrow.getShooter();

                if (shooter instanceof Player) {
                    Player player = (Player) shooter;

                    if (shouldEventBeRan(player)) {
                        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                        if (RSVItem.isRSVItem(itemMainHand, util)) {
                            if (util.getNbtTag(itemMainHand, "rsvmodule").equals("spartanweaponry")) {
                                String name = util.getNbtTag(itemMainHand, "rsvitem");
                                if (name.endsWith("longbow") || name.endsWith("crossbow")) {
                                    double multiplier = RSVFiles.getSwUserConfig().getDouble(name + ".AttackDamageMultiplier");
                                    event.setDamage(event.getDamage() * multiplier);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (attacker.getType() == EntityType.PLAYER) {
            Player player = (Player) attacker;

            if (shouldEventBeRan(player)) {
                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                if (RSVItem.isRSVItem(itemMainHand, util)) {
                    if (util.getNbtTag(itemMainHand, "rsvmodule").equals("spartanweaponry")) {
                        String name = util.getNbtTag(itemMainHand, "rsvitem");
                        if (name.endsWith("rapier")) {
                            if (!Utils.hasArmor((LivingEntity) entity)) {
                                event.setDamage(event.getDamage() * RSVFiles.getSwUserConfig().getDouble(name + "UnarmoredDamageMultiplier"));
                            }
                        }
                        else if (name.endsWith("katana")) {
                            if (!Utils.hasChestplate((LivingEntity) entity)) {
                                event.setDamage(event.getDamage() * RSVFiles.getSwUserConfig().getDouble(name + "ChestDamageMultiplier"));
                            }
                        }
                        else if (name.endsWith("greatsword")) {
                            List<Entity> entities = entity.getNearbyEntities(1, 1, 1);

                            double multiplier = RSVFiles.getSwUserConfig().getDouble(name + "SweepingDamageMultiplier");
                            double damage = event.getDamage();
                            for (Entity e : entities) {
                                if (e instanceof LivingEntity) {
                                    Location eLoc = e.getLocation();
                                    Location pLoc = player.getLocation();
                                    if (Math.abs(eLoc.getY() - pLoc.getY()) <= 0.25) {
                                        if (Math.hypot(eLoc.getX() - pLoc.getX(), eLoc.getZ() - pLoc.getZ()) <= 1.0) {
                                            ((LivingEntity) e).damage(damage * multiplier, player);
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }

        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            if (RSVItem.isRSVItem(itemMainHand, util)) {
                if (util.getNbtTag(itemMainHand, "rsvmodule").equals("spartanweaponry")) {
                    String name = util.getNbtTag(itemMainHand, "rsvitem");
                    if (name.endsWith("greatsword")) {
                        double maxReach = module.getUserConfig().getConfig().getDouble(name + ".Reach");
                        if (this.throwExclude.contains(e.getPlayer().getUniqueId())) {
                            this.throwExclude.remove(e.getPlayer().getUniqueId());
                            return;
                        }
                        if (!hasReach(player.getUniqueId()) && this.defaultReach == null)
                            return;
                        Location eyeLocation = player.getEyeLocation();
                        Vector direction = eyeLocation.getDirection();
                        Predicate<Entity> filter = entity -> !entity.equals(player);
                        RayTraceResult result = player.getWorld().rayTrace(eyeLocation, direction, maxReach, FluidCollisionMode.NEVER, false, 0.0D, filter);
                        if (result == null)
                            return;
                        Entity entity = result.getHitEntity();
                        if (entity == null)
                            return;
                        if (this.exclude.contains(entity)) {
                            this.exclude.remove(entity);
                            return;
                        }
                        if (entity.getPassengers().contains(player))
                            return;
                        Attack.attack(player, entity);
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