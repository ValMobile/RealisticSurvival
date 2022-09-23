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
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.potion.PotionEffectType;

public abstract class InternalsProvider {

    public abstract void spawnEndermanAlly(Player owner, Location loc);
    public abstract void spawnFireDragon(Location loc, RealisticSurvivalPlugin plugin);
    public abstract void spawnFireDragon(Location loc, int stage, RealisticSurvivalPlugin plugin);
    public abstract void spawnFireDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin);
    public abstract void spawnFireDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin);

    public abstract void spawnIceDragon(Location loc, RealisticSurvivalPlugin plugin);
    public abstract void spawnIceDragon(Location loc, int stage, RealisticSurvivalPlugin plugin);
    public abstract void spawnIceDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin);
    public abstract void spawnIceDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin);

    public abstract void spawnLightningDragon(Location loc, RealisticSurvivalPlugin plugin);
    public abstract void spawnLightningDragon(Location loc, int stage, RealisticSurvivalPlugin plugin);
    public abstract void spawnLightningDragon(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin);
    public abstract void spawnLightningDragon(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin);

    public abstract void spawnSeaSerpent(Location loc, RealisticSurvivalPlugin plugin);
    public abstract void spawnSeaSerpent(Location loc, SeaSerpentVariant variant, RealisticSurvivalPlugin plugin);

    public abstract void spawnSiren(Location loc, RealisticSurvivalPlugin plugin);

    public abstract Tag getTag(String name);

    public abstract PotionEffectType valueOfPotionEffectType(String potionEffectType);

    public abstract boolean isUndead(Entity entity);

    public abstract boolean isNetheriteRecipe(SmithingInventory inv);

    public abstract void registerEntities();

    public abstract void setFreezingView(Player player, int ticks);
}
