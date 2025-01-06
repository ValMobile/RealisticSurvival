/*
    Copyright (C) 2025  Val_Mobile

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
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class SfEvents extends ModuleEvents implements Listener {

    private final RSVPlugin plugin;
    private final SfModule module;
    private final FileConfiguration config;

    public SfEvents(SfModule module, RSVPlugin plugin) {
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
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity(); // get the defender
        Entity attacker = event.getDamager(); // get the attacker

        if (!(shouldEventBeRan(attacker) && shouldEventBeRan(defender)))
            return;

        double damage = event.getDamage();

        if (Utils.hasNbtTag(attacker, "rsvbow")) {
            String name = Utils.getNbtTag(attacker, "rsvbow", PersistentDataType.STRING);

            IceFireModule.applyDragonItemEffect(defender, name, module);
            damage = IceFireModule.applyDragonItemBonusDamage(defender, name, damage, module);
        }
        else if (attacker instanceof LivingEntity living && living.getEquipment() != null) {
            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

            IceFireModule.applyDragonItemEffect(defender, itemMainHand, module);
            damage = IceFireModule.applyDragonItemBonusDamage(defender, itemMainHand, damage, module);
        }

        event.setDamage(damage);
    }

    /**
     * Implements the flamed, iced, and lightning dragonbone weapon recipes.
     * The recipes do not work automatically due to UUID differences in the dragonbone weapon ingredient.
     * @param event The event called when a player places items in a crafting table
     */
    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        Recipe recipe = event.getRecipe();

        if (!shouldEventBeRan(event.getView().getPlayer()))
            return;

        if (recipe == null) {
            // determine if the matrix contains only 2 non-null items
            ItemStack[] matrix = event.getInventory().getMatrix();

            // preprocess matrix to obtain only rsv items
            List<ItemStack> rsvItems = new ArrayList<>();

            for (ItemStack item : matrix) {
                if (RSVItem.isRSVItem(item)) {
                    rsvItems.add(item);
                }
            }

            if (rsvItems.size() == 2) {
                // check if one of the items is a dragon blood
                ItemStack dragonBlood;
                ItemStack dragonboneWeapon;

                switch (RSVItem.getNameFromItem(rsvItems.get(0))) {
                    case "dragon_blood_fire", "dragon_blood_ice", "dragon_blood_lightning" -> {
                        dragonBlood = rsvItems.get(0);
                        dragonboneWeapon = rsvItems.get(1);
                    }
                    // check if item2 is the dragon blood instead
                    default -> {
                        dragonBlood = rsvItems.get(1);
                        dragonboneWeapon = rsvItems.get(0);
                    }
                }

                String dragonBloodName = RSVItem.getNameFromItem(dragonBlood);
                String dragonboneWeaponName = RSVItem.getNameFromItem(dragonboneWeapon);

                // verify there is a dragon blood and dragonbone weapon
                switch (dragonBloodName) {
                    case "dragon_blood_fire", "dragon_blood_ice", "dragon_blood_lightning" -> {}
                    default -> {
                        return;
                    }
                }
                switch (dragonboneWeaponName) {
                    case "dragonbone_longbow", "dragonbone_rapier", "dragonbone_katana",
                         "dragonbone_greatsword", "dragonbone_longsword", "dragonbone_spear",
                         "dragonbone_saber", "dragonbone_boomerang", "dragonbone_dagger",
                         "dragonbone_glaive", "dragonbone_halberd", "dragonbone_hammer",
                         "dragonbone_javelin", "dragonbone_lance", "dragonbone_mace",
                         "dragonbone_pike", "dragonbone_quarterstaff", "dragonbone_tomahawk",
                         "dragonbone_throwing_knife", "dragonbone_warhammer", "dragonbone_battleaxe",
                         "dragonbone_crossbow" -> {}
                    default -> {
                        return;
                    }
                }

                // after verifying, construct the upgraded weapon name
                String specialAbility = switch (dragonBloodName) {
                    case "dragon_blood_fire" -> "flamed";
                    case "dragon_blood_ice" -> "iced";
                    case "dragon_blood_lightning" -> "lightning";
                    default -> null;
                };

                String weaponType = dragonboneWeaponName.substring(dragonboneWeaponName.indexOf("_") + 1);

                String upgradedWeaponName = "dragonbone_" + specialAbility + "_" + weaponType;

                // verify that a recipe for the upgraded item exists
                NamespacedKey recipeKey = NamespacedKey.fromString(upgradedWeaponName, plugin);

                if (Bukkit.getRecipe(recipeKey) != null) {
                    ItemStack upgradedWeapon = RSVItem.getItem(upgradedWeaponName);
                    event.getInventory().setResult(upgradedWeapon);
                }
            }
        }
    }
}
