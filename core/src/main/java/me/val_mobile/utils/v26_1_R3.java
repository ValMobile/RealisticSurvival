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
package me.val_mobile.utils;

import me.val_mobile.baubles.EndermanAlly;
import me.val_mobile.iceandfire.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;

import java.lang.reflect.Method;

public class v26_1_R3 extends InternalsProvider {

    private static UnsupportedOperationException unsupportedCustomEntities() {
        return new UnsupportedOperationException("RealisticSurvival custom NMS entities are not ported to Purpur 26 yet.");
    }

    @Override
    public EndermanAlly spawnEndermanAlly(Player owner, Location loc) {
        throw unsupportedCustomEntities();
    }

    @Override
    public FireDragon spawnFireDragon(Location loc) {
        throw unsupportedCustomEntities();
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, int stage) {
        throw unsupportedCustomEntities();
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant) {
        throw unsupportedCustomEntities();
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant, int stage) {
        throw unsupportedCustomEntities();
    }

    @Override
    public IceDragon spawnIceDragon(Location loc) {
        throw unsupportedCustomEntities();
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, int stage) {
        throw unsupportedCustomEntities();
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant) {
        throw unsupportedCustomEntities();
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant, int stage) {
        throw unsupportedCustomEntities();
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc) {
        throw unsupportedCustomEntities();
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, int stage) {
        throw unsupportedCustomEntities();
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant) {
        throw unsupportedCustomEntities();
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant, int stage) {
        throw unsupportedCustomEntities();
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc) {
        throw unsupportedCustomEntities();
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc, SeaSerpentVariant variant) {
        throw unsupportedCustomEntities();
    }

    @Override
    public Siren spawnSiren(Location loc) {
        throw unsupportedCustomEntities();
    }

    @Override
    public Tag<Material> getTag(String name) {
        return TagUtils.getTag(Tag.class, name);
    }

    @Override
    public boolean isUndead(Entity entity) {
        if (entity instanceof LivingEntity living) {
            return living.getCategory() == EntityCategory.UNDEAD;
        }
        return false;
    }

    @Override
    public boolean isNetheriteRecipe(SmithingInventory inv) {
        Recipe recipe = inv.getRecipe();

        if (recipe instanceof SmithingRecipe smithingRecipe) {
            NamespacedKey key = smithingRecipe.getKey();

            if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                return switch (key.getKey()) {
                    case "netherite_axe_smithing", "netherite_pickaxe_smithing", "netherite_shovel_smithing",
                            "netherite_sword_smithing", "netherite_hoe_smithing", "netherite_helmet_smithing",
                            "netherite_chestplate_smithing", "netherite_leggings_smithing",
                            "netherite_boots_smithing" -> true;
                    default -> false;
                };
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
    }

    @Override
    public void setFreezingView(Player player, int ticks) {
        player.setFreezeTicks(ticks);
    }

    @Override
    public void attack(LivingEntity attacker, Entity defender) {
        try {
            Method attack = attacker.getClass().getMethod("attack", Entity.class);
            attack.invoke(attacker, defender);
        } catch (ReflectiveOperationException ignored) {
            if (defender instanceof Damageable damageable) {
                damageable.damage(1.0, attacker);
            }
        }
    }

    @Override
    public boolean hasItemModel(ItemMeta meta) {
        return meta.hasItemModel();
    }

    @Override
    public NamespacedKey getItemModel(ItemMeta meta) {
        return meta.getItemModel();
    }

    @Override
    public void setItemModel(ItemMeta meta, NamespacedKey key) {
        meta.setItemModel(key);
    }

    @Override
    public boolean hasEquippableComponentModel(ItemMeta meta) {
        return meta.hasEquippable();
    }

    @Override
    public NamespacedKey getEquippableComponentModel(ItemMeta meta) {
        return meta.getEquippable().getModel();
    }

    @Override
    public void setEquippableComponentModel(ItemMeta meta, NamespacedKey key, EquipmentSlot slot) {
        EquippableComponent component = meta.getEquippable();
        component.setSlot(slot);
        component.setModel(key);
        meta.setEquippable(component);
    }
}
