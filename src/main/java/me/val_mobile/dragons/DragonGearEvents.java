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

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.Recipes;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class DragonGearEvents implements Listener {

    private final Utils util;
    private final DragonGearAbilities dragonGearAbilities;
    public DragonGearEvents(RLCraft instance) {
        util = new Utils(instance);
        dragonGearAbilities = new DragonGearAbilities(instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (Recipe r : Recipes.getDragonRecipes()) {
            if (r instanceof ShapedRecipe) {
                player.discoverRecipe(((ShapedRecipe) r).getKey());
            }
            else if (r instanceof ShapelessRecipe) {
                player.discoverRecipe(((ShapelessRecipe) r).getKey());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        if (!event.isCancelled()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                EntityDamageEvent.DamageCause cause = event.getCause();
                if (cause.equals(EntityDamageEvent.DamageCause.DRAGON_BREATH)) {
                    double dragonProtection = 0;
                    for (ItemStack item : player.getInventory().getArmorContents()) {
                        if (Utils.isItemReal(item)) {
                            NBTItem nbti = new NBTItem(item);
                            if (nbti.hasKey("Dragon Scale Armor")) {
                                dragonProtection += CustomConfig.getIceFireGearConfig().getDouble("Abilities.DragonScale.DamageReduction");
                            }
                            else if (nbti.hasKey("Dragonsteel Armor")) {
                                dragonProtection += CustomConfig.getIceFireGearConfig().getDouble("Abilities.Dragonsteel.DamageReduction");
                            }
                        }
                    }
                    event.setDamage(event.getDamage() * (1D - dragonProtection));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!event.isCancelled()) {
            Entity entity = event.getEntity();
            Entity attacker = event.getDamager();
            switch (attacker.getType()) {
                case PLAYER: {
                    Player player = (Player) event.getDamager();
                    ItemStack itemMainHand = player.getInventory().getItemInMainHand();

                    if (Utils.isItemReal(itemMainHand)) {
                        NBTItem item = new NBTItem(itemMainHand);
                        if (item.hasKey("Material Type")) {
                            switch (item.getString("Material Type")) {
                                case "Fire Dragon Bone":
                                    if (entity instanceof EnderDragon) {
                                        if (!util.checkDragonContainers(entity)) {
                                            util.addDragonContainers(entity);
                                        }
                                        String dragonType = util.getDragonType(entity);

                                        if (dragonType.equals("Ice")) {
                                            event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.FlamedDragonBone.BonusDamage"));
                                        }
                                    }
                                    dragonGearAbilities.FireDragonBoneAbility((LivingEntity) entity);
                                    break;
                                case "Ice Dragon Bone":
                                    if (entity instanceof EnderDragon) {
                                        if (!util.checkDragonContainers(entity)) {
                                            util.addDragonContainers(entity);
                                        }
                                        String dragonType = util.getDragonType(entity);

                                        if (dragonType.equals("Fire")) {
                                            event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.IcedDragonBone.BonusDamage"));
                                        }
                                    }
                                    dragonGearAbilities.IceDragonBoneAbility((LivingEntity) entity);
                                    break;
                                case "Lightning Dragon Bone":
                                    if (entity instanceof EnderDragon) {
                                        if (!util.checkDragonContainers(entity)) {
                                            util.addDragonContainers(entity);
                                        }
                                        String dragonType = util.getDragonType(entity);

                                        if (dragonType.equals("Ice") || dragonType.equals("Fire")) {
                                            event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.LightningDragonBone.BonusDamage"));
                                        }
                                    }
                                    dragonGearAbilities.LightningDragonBoneAbility((LivingEntity) entity, player);
                                    break;
                                case "Fire Dragonsteel":
                                    dragonGearAbilities.FireDragonsteelAbility((LivingEntity) entity);
                                    break;
                                case "Ice Dragonsteel":
                                    dragonGearAbilities.IceDragonsteelAbility((LivingEntity) entity);
                                    break;
                                case "Lightning Dragonsteel":
                                    dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) entity, player);
                                    break;
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
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            if (Utils.isItemReal(itemMainHand)) {
                                NBTItem item = new NBTItem(itemMainHand);
                                if (item.hasKey("Spartan's Weapon") && item.hasKey("Material Type")) {
                                    String weaponType = item.getString("Spartan's Weapon");
                                    String materialType = item.getString("Material Type");

                                    String configPath = weaponType + "." + materialType + "." + "AttackDamageMultiplier";

                                    if (weaponType.equals("Bow")) {
                                        double multiplier = CustomConfig.getIceFireGearConfig().getDouble(configPath);
                                        event.setDamage(event.getDamage() * multiplier);
                                    }

                                    switch (materialType) {
                                        case "Fire Dragon Bone":
                                            if (entity instanceof EnderDragon) {
                                                if (!util.checkDragonContainers(entity)) {
                                                    util.addDragonContainers(entity);
                                                }
                                                String dragonType = util.getDragonType(entity);

                                                if (dragonType.equals("Ice")) {
                                                    event.setDamage(event.getDamage() + 8.0D);
                                                }
                                            }
                                            dragonGearAbilities.FireDragonBoneAbility((LivingEntity) entity);
                                            break;
                                        case "Ice Dragon Bone":
                                            if (entity instanceof EnderDragon) {
                                                if (!util.checkDragonContainers(entity)) {
                                                    util.addDragonContainers(entity);
                                                }
                                                String dragonType = util.getDragonType(entity);

                                                if (dragonType.equals("Fire")) {
                                                    event.setDamage(event.getDamage() + 8.0D);
                                                }
                                            }
                                            dragonGearAbilities.IceDragonBoneAbility((LivingEntity) entity);
                                            break;
                                        case "Lightning Dragon Bone":
                                            if (entity instanceof EnderDragon) {
                                                if (!util.checkDragonContainers(entity)) {
                                                    util.addDragonContainers(entity);
                                                }
                                                String dragonType = util.getDragonType(entity);

                                                if (dragonType.equals("Ice") || dragonType.equals("Fire")) {
                                                    event.setDamage(event.getDamage() + 4.0D);
                                                }
                                            }
                                            dragonGearAbilities.LightningDragonBoneAbility((LivingEntity) entity, player);
                                            break;
                                        case "Fire Dragonsteel":
                                            dragonGearAbilities.FireDragonsteelAbility((LivingEntity) entity);
                                            break;
                                        case "Ice Dragonsteel":
                                            dragonGearAbilities.IceDragonsteelAbility((LivingEntity) entity);
                                            break;
                                        case "Lightning Dragonsteel":
                                            dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) entity, player);
                                            break;
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
                        double dragonProtection = 0;
                        for (ItemStack item : player.getInventory().getArmorContents()) {
                            if (Utils.isItemReal(item)) {
                                NBTItem nbti = new NBTItem(item);
                                if (nbti.hasKey("Dragon Scale Armor")) {
                                    dragonProtection += 0.1;
                                } else if (nbti.hasKey("Dragonsteel Armor")) {
                                    dragonProtection += 0.2;
                                }
                            }
                        }
                        event.setDamage(event.getDamage() * (1D - dragonProtection));
                    }
                    break;
                }

            }
        }
    }
}