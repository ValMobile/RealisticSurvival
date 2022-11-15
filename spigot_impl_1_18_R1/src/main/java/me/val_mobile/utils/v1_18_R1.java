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
package me.val_mobile.utils;

import me.val_mobile.baubles.EndermanAlly;
import me.val_mobile.iceandfire.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.SmithingRecipe;

public class v1_18_R1 extends InternalsProvider {

    @Override
    public EndermanAlly spawnEndermanAlly(Player owner, Location loc) {
        return new EndermanAlly_v1_18_R1(owner, loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc) {
        return new FireDragon_v1_18_R1(loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, int stage) {
        return new FireDragon_v1_18_R1(loc, stage);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant) {
        return new FireDragon_v1_18_R1(loc, variant);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant, int stage) {
        return new FireDragon_v1_18_R1(loc, variant, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc) {
        return new IceDragon_v1_18_R1(loc);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, int stage) {
        return new IceDragon_v1_18_R1(loc, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant) {
        return new IceDragon_v1_18_R1(loc, variant);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant, int stage) {
        return new IceDragon_v1_18_R1(loc, variant, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc) {
        return new LightningDragon_v1_18_R1(loc);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, int stage) {
        return new LightningDragon_v1_18_R1(loc, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant) {
        return new LightningDragon_v1_18_R1(loc, variant);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant, int stage) {
        return new LightningDragon_v1_18_R1(loc, variant, stage);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc) {
        return new SeaSerpent_v1_18_R1(loc);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc, SeaSerpentVariant variant) {
        return new SeaSerpent_v1_18_R1(loc, variant);
    }

    @Override
    public Siren spawnSiren(Location loc) {
        return new Siren_v1_18_R1(loc);
    }

    @Override
    public Tag<Material> getTag(String name) {
        return TagList_v1_18_R1.valueOf(name).getTag();
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

        if (recipe instanceof SmithingRecipe) {
            NamespacedKey key = ((SmithingRecipe) recipe).getKey();

            if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                switch (key.getKey()) {
                    case "netherite_axe_smithing", "netherite_pickaxe_smithing", "netherite_shovel_smithing", "netherite_sword_smithing", "netherite_hoe_smithing", "netherite_helmet_smithing", "netherite_chestplate_smithing", "netherite_leggings_smithing", "netherite_boots_smithing" ->
                            inv.setResult(null);
                    default -> {}
                }
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities_v1_18_R1.registerEntities();
    }

    @Override
    public void setFreezingView(Player player, int ticks) {
        player.setFreezeTicks(ticks);
    }

    @Override
    public void attack(LivingEntity attacker, Entity defender) {
        if (attacker instanceof Player) {
            ((CraftPlayer) attacker).getHandle().attack(((CraftEntity) defender).getHandle());
        }
        else {
            ((CraftLivingEntity) attacker).getHandle().doHurtTarget(((CraftEntity) defender).getHandle());
        }
    }

}
