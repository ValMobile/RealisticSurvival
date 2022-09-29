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
import org.bukkit.Tag;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.potion.PotionEffectType;

public class v1_16_R1 extends InternalsProvider {

    @Override
    public void spawnEndermanAlly(Player owner, Location loc) {
        new EndermanAlly(owner, loc);
    }

    @Override
    public void spawnFireDragon(Location loc, RealisticSurvivalPlugin plugin) {
        new FireDragon(loc, plugin);
    }

    @Override
    public void spawnFireDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        new FireDragon(loc, stage, plugin);
    }

    @Override
    public void spawnFireDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        new FireDragon(loc, variant, plugin);
    }

    @Override
    public void spawnFireDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        new FireDragon(loc, variant, stage, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, RealisticSurvivalPlugin plugin) {
        new IceDragon(loc, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        new IceDragon(loc, stage, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        new IceDragon(loc, variant, plugin);
    }

    @Override
    public void spawnIceDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        new IceDragon(loc, variant, stage, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, RealisticSurvivalPlugin plugin) {
        new LightningDragon(loc, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        new LightningDragon(loc, stage, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        new LightningDragon(loc, variant, plugin);
    }

    @Override
    public void spawnLightningDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        new LightningDragon(loc, variant, plugin);
    }

    @Override
    public void spawnSeaSerpent(Location loc, RealisticSurvivalPlugin plugin) {
        new SeaSerpent(loc, plugin);
    }

    @Override
    public void spawnSeaSerpent(Location loc, SeaSerpentVariant variant, RealisticSurvivalPlugin plugin) {
        new SeaSerpent(loc, variant, plugin);
    }

    @Override
    public void spawnSiren(Location loc, RealisticSurvivalPlugin plugin) {
        new Siren(loc, plugin);
    }

    @Override
    public Tag getTag(String name) {
        return TagList.valueOf(name).getTag();
    }

    @Override
    public PotionEffectType valueOfPotionEffectType(String type) {
        return PotionEffectTypeList.valueOf(type).getType();
    }

    @Override
    public boolean isUndead(Entity entity) {
        switch (entity.getType()) {
            case ZOMBIE, ZOMBIE_HORSE, ZOMBIE_VILLAGER, DROWNED, HUSK, PHANTOM, SKELETON, SKELETON_HORSE, WITHER_SKELETON, WITHER, ZOGLIN, ZOMBIFIED_PIGLIN, STRAY -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean isNetheriteRecipe(SmithingInventory inv) {
        ItemStack base = inv.getItem(0);
        ItemStack result = inv.getItem(2);

        if (!(result == null || base == null)) {
            if (Utils.isNetherite(result.getType()) && Utils.isDiamond(base.getType())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities.registerEntities();
    }

    @Override
    public void setFreezingView(Player player, int ticks) {}

    @Override
    public void attack(Player player, Entity entity) {
        ((CraftPlayer) player).getHandle().attack(((CraftEntity) entity).getHandle());
    }

}
