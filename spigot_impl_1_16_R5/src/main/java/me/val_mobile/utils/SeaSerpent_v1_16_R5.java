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

import me.val_mobile.iceandfire.SeaSerpent;
import me.val_mobile.iceandfire.SeaSerpentVariant;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.DamageSource;
import net.minecraft.server.v1_16_R3.EntityGuardianElder;
import net.minecraft.server.v1_16_R3.EntityTypes;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class SeaSerpent_v1_16_R5 extends EntityGuardianElder implements SeaSerpent {

    private SeaSerpentVariant variant;
    private final Collection<ItemStack> loot = new ArrayList<>();

    public SeaSerpent_v1_16_R5(EntityTypes<? extends EntityGuardianElder> entitytypes, net.minecraft.server.v1_16_R3.World world) {
        super(entitytypes, world);

        SeaSerpentVariant[] allVariants = SeaSerpentVariant.values();

        do {
            variant = allVariants[Utils.getRandomNum(0, allVariants.length - 1)];
        } while(!variant.isEnabled());

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);
    }

    public SeaSerpent_v1_16_R5(Location loc) {
        super(EntityTypes.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());

        SeaSerpentVariant[] allVariants = SeaSerpentVariant.values();

        do {
            variant = allVariants[Utils.getRandomNum(0, allVariants.length - 1)];
        } while(!variant.isEnabled());

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);
    }

    public SeaSerpent_v1_16_R5(Location loc, SeaSerpentVariant variant) {
        super(EntityTypes.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());

        this.variant = variant.isEnabled() ? variant : null;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);
    }

    @Override
    public Entity getEntity() {
        return this.getBukkitEntity();
    }

    @Override
    public void addEntityToWorld(org.bukkit.World world) {
        ((CraftWorld) world).addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public void die(DamageSource damageSource) {
        super.die(damageSource);

        Location loc = this.getBukkitEntity().getLocation();
        World world = loc.getWorld();
        generateLoot(loot);
        for (ItemStack item : loot) {
            if (item != null) {
                world.dropItemNaturally(loc, item);
            }
        }
    }

    @Override
    protected void initPathfinder() {
        super.initPathfinder();
    }

    @Override
    public SeaSerpentVariant getVariant() {
        return variant;
    }
}
