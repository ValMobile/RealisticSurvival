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
import org.bukkit.Tag;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;

public class v1_16_R3 extends InternalsProvider {

    @Override
    public EndermanAlly spawnEndermanAlly(Player owner, Location loc) {
        return new EndermanAlly_v1_16_R3(owner, loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc) {
        return new FireDragon_v1_16_R3(loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, int stage) {
        return new FireDragon_v1_16_R3(loc, stage);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant) {
        return new FireDragon_v1_16_R3(loc, variant);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant, int stage) {
        return new FireDragon_v1_16_R3(loc, variant, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc) {
        return new IceDragon_v1_16_R3(loc);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, int stage) {
        return new IceDragon_v1_16_R3(loc, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant) {
        return new IceDragon_v1_16_R3(loc, variant);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant, int stage) {
        return new IceDragon_v1_16_R3(loc, variant, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc) {
        return new LightningDragon_v1_16_R3(loc);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, int stage) {
        return new LightningDragon_v1_16_R3(loc, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant) {
        return new LightningDragon_v1_16_R3(loc, variant);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant, int stage) {
        return new LightningDragon_v1_16_R3(loc, variant, stage);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc) {
        return new SeaSerpent_v1_16_R3(loc);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc, SeaSerpentVariant variant) {
        return new SeaSerpent_v1_16_R3(loc, variant);
    }

    @Override
    public Siren spawnSiren(Location loc) {
        return new Siren_v1_16_R3(loc);
    }

    @Override
    public Tag<Material> getTag(String name) {
        return TagList_v1_16_R3.valueOf(name).getTag();
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
     ItemStack base = inv.getItem(0);
        ItemStack result = inv.getItem(2);
        
        if (!(result == null || base == null)) {
            if (Utils.isNetherite(result.getType()) && Utils.isDiamond(base.getType())) {
                if (RSVItem.isRSVItem(result)) {
                    return RSVItem.getItem(RSVItem.getNameFromItem(result)).getItemMeta().getCustomModelData() != result.getItemMeta().getCustomModelData();
                }
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities_v1_16_R3.registerEntities();
    }

    @Override
    public void setFreezingView(Player player, int ticks) {}

    @Override
    public void attack(LivingEntity attacker, Entity defender) {
        ((CraftLivingEntity) attacker).getHandle().attackEntity(((CraftEntity) defender).getHandle());
    }
 
}
