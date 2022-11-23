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
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.level.Level;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SeaSerpent_v1_17_R1 extends ElderGuardian implements SeaSerpent {

    private final SeaSerpentVariant variant;
    private final Collection<ItemStack> loot = new ArrayList<>();

    public SeaSerpent_v1_17_R1(EntityType<? extends ElderGuardian> entitytype, Level world) {
        super(entitytype, world);

        List<SeaSerpentVariant> enabledVariants = SeaSerpentVariant.getEnabledVariants();
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));

        this.setCustomName(new TextComponent(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);
        addNbtData();
    }

    public SeaSerpent_v1_17_R1(Location loc) {
        super(EntityType.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        List<SeaSerpentVariant> enabledVariants = SeaSerpentVariant.getEnabledVariants();
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));

        this.setCustomName(new TextComponent(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);
        addNbtData();
    }

    public SeaSerpent_v1_17_R1(Location loc, SeaSerpentVariant variant) {
        super(EntityType.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.variant = variant.isEnabled() ? variant : null;

        this.setCustomName(new TextComponent(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);
        addNbtData();
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
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public SeaSerpentVariant getVariant() {
        return variant;
    }
}
