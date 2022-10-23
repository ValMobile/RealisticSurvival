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

import me.val_mobile.iceandfire.DragonVariant;
import me.val_mobile.iceandfire.SeaSerpentVariant;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.SmithingRecipe;

public class v1_19_R2 extends InternalsProvider {

    public void spawnEndermanAlly(Player owner, Location loc) {
//        new EndermanAlly(owner, loc);
    }

    @Override
    public void spawnFireDragon(Location loc, RealisticSurvivalPlugin plugin) {
//        new FireDragon(loc, plugin);
    }

    @Override
    public void spawnFireDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
//        new FireDragon(loc, stage, plugin);
    }

    @Override
    public void spawnFireDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
//        new FireDragon(loc, variant, plugin);
    }

    @Override
    public void spawnFireDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
//        new FireDragon(loc, variant, stage, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, RealisticSurvivalPlugin plugin) {
//        new IceDragon(loc, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
//        new IceDragon(loc, stage, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
//        new IceDragon(loc, variant, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
//        new IceDragon(loc, variant, stage, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, RealisticSurvivalPlugin plugin) {
//        new LightningDragon(loc, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
//        new LightningDragon(loc, stage, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
//        new LightningDragon(loc, variant, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
//        new LightningDragon(loc, variant, plugin);
    }

    @Override
    public void spawnSeaSerpent(Location loc, RealisticSurvivalPlugin plugin) {
//        new SeaSerpent(loc, plugin);
    }

    @Override
    public void spawnSeaSerpent(Location loc, SeaSerpentVariant variant, RealisticSurvivalPlugin plugin) {
//        new SeaSerpent(loc, variant, plugin);
    }

    @Override
    public void spawnSiren(Location loc, RealisticSurvivalPlugin plugin) {
//        new Siren(loc, plugin);
    }

    @Override
    public Tag<Material> getTag(String name) {
        return TagList_v1_19_R2.valueOf(name).getTag();
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
                    case "netherite_axe_smithing", "netherite_pickaxe_smithing", "netherite_shovel_smithing", "netherite_sword_smithing", "netherite_hoe_smithing", "netherite_helmet_smithing", "netherite_chestplate_smithing", "netherite_leggings_smithing", "netherite_boots_smithing" -> {
                        return true;
                    }
                    default -> {}
                }
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities_v1_19_R2.registerEntities();
    }

    @Override
    public void setFreezingView(Player player, int ticks) {
        player.setFreezeTicks(ticks);
    }

    @Override
    public void attack(Player player, Entity entity) {
        ((CraftPlayer) player).getHandle().attack(((CraftEntity) entity).getHandle());
    }

}
