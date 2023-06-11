/*
    Copyright (C) 2023  Val_Mobile

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
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.SmithingInventory;

public abstract class InternalsProvider {

    public abstract EndermanAlly spawnEndermanAlly(Player owner, Location loc);
    public abstract FireDragon spawnFireDragon(Location loc);
    public abstract FireDragon spawnFireDragon(Location loc, int stage);
    public abstract FireDragon spawnFireDragon(Location loc, DragonVariant variant);
    public abstract FireDragon spawnFireDragon(Location loc, DragonVariant variant, int stage);

    public abstract IceDragon spawnIceDragon(Location loc);
    public abstract IceDragon spawnIceDragon(Location loc, int stage);
    public abstract IceDragon spawnIceDragon(Location loc, DragonVariant variant);
    public abstract IceDragon spawnIceDragon(Location loc, DragonVariant variant, int stage);

    public abstract LightningDragon spawnLightningDragon(Location loc);
    public abstract LightningDragon spawnLightningDragon(Location loc, int stage);
    public abstract LightningDragon spawnLightningDragon(Location loc, DragonVariant variant);
    public abstract LightningDragon spawnLightningDragon(Location loc, DragonVariant variant, int stage);

    public abstract SeaSerpent spawnSeaSerpent(Location loc);
    public abstract SeaSerpent spawnSeaSerpent(Location loc, SeaSerpentVariant variant);

    public abstract Siren spawnSiren(Location loc);

    public abstract Tag<Material> getTag(String name);

    public abstract boolean isUndead(Entity entity);

    public abstract boolean isNetheriteRecipe(SmithingInventory inv);

    public abstract void registerEntities();

    public abstract void setFreezingView(Player player, int ticks);

    public abstract void attack(LivingEntity attacker, Entity defender);

}
