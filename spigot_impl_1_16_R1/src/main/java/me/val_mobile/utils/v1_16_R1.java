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
import net.minecraft.server.v1_16_R1.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;

import javax.annotation.Nonnull;
import java.util.Random;

public class v1_16_R1 extends InternalsProvider {

    @Override
    public EndermanAlly spawnEndermanAlly(Player owner, Location loc) {
        return new EndermanAlly_v1_16_R1(owner, loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc) {
        return new FireDragon_v1_16_R1(loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, int stage) {
        return new FireDragon_v1_16_R1(loc, stage);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant) {
        return new FireDragon_v1_16_R1(loc, variant);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant, int stage) {
        return new FireDragon_v1_16_R1(loc, variant, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc) {
        return new IceDragon_v1_16_R1(loc);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, int stage) {
        return new IceDragon_v1_16_R1(loc, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant) {
        return new IceDragon_v1_16_R1(loc, variant);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant, int stage) {
        return new IceDragon_v1_16_R1(loc, variant, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc) {
        return new LightningDragon_v1_16_R1(loc);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, int stage) {
        return new LightningDragon_v1_16_R1(loc, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant) {
        return new LightningDragon_v1_16_R1(loc, variant);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant, int stage) {
        return new LightningDragon_v1_16_R1(loc, variant, stage);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc) {
        return new SeaSerpent_v1_16_R1(loc);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc, SeaSerpentVariant variant) {
        return new SeaSerpent_v1_16_R1(loc, variant);
    }

    @Override
    public Siren spawnSiren(Location loc) {
        return new Siren_v1_16_R1(loc);
    }

    @Override
    public Tag<Material> getTag(String name) {
        return TagList_v1_16_R1.valueOf(name).getTag();
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
                if (RSVItem.isRSVItem(result)) {
                    return RSVItem.getItem(RSVItem.getNameFromItem(result)).getItemMeta().getCustomModelData() != result.getItemMeta().getCustomModelData();
                }
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities_v1_16_R1.registerEntities();
    }

    @Override
    public void setFreezingView(Player player, int ticks) {}

    @Override
    public void attack(LivingEntity attacker, Entity defender) {
        ((CraftLivingEntity) attacker).getHandle().attackEntity(((CraftEntity) defender).getHandle());
    }

    @Override
    public boolean isInWater(@Nonnull Entity entity) {
        return entity.getLocation().getBlock().getType() == Material.WATER;
    }

    public static boolean isLookingAtMe(EntityEnderman enderman, EntityHuman entityhuman) {
        net.minecraft.server.v1_16_R1.ItemStack itemstack = entityhuman.inventory.armor.get(3);
        if (itemstack.getItem() == Blocks.CARVED_PUMPKIN.getItem()) {
            return false;
        } else {
            Vec3D vec3d = entityhuman.f(1.0F).d();
            Vec3D vec3d1 = new Vec3D(enderman.locX() - entityhuman.locX(), enderman.getHeadY() - entityhuman.getHeadY(), enderman.locZ() - entityhuman.locZ());
            double d0 = vec3d1.f();
            vec3d1 = vec3d1.d();
            double d1 = vec3d.b(vec3d1);
            return d1 > 1.0 - 0.025 / d0 && entityhuman.hasLineOfSight(enderman);
        }
    }

    public static boolean teleport(EntityEnderman enderman) {
        if (!enderman.world.s_() && enderman.isAlive()) {
            Random random = enderman.getRandom();
            double d0 = enderman.locX() + (random.nextDouble() - 0.5) * 64.0;
            double d1 = enderman.locY() + (double)(random.nextInt(64) - 32);
            double d2 = enderman.locZ() + (random.nextDouble() - 0.5) * 64.0;
            return teleport(enderman, d0, d1, d2);
        } else {
            return false;
        }
    }

    public static boolean teleport(EntityEnderman enderman, double d0, double d1, double d2) {
        BlockPosition.MutableBlockPosition blockposition_mutableblockposition = new BlockPosition.MutableBlockPosition(d0, d1, d2);

        while(blockposition_mutableblockposition.getY() > 0 && !enderman.world.getType(blockposition_mutableblockposition).getMaterial().isSolid()) {
            blockposition_mutableblockposition.c(EnumDirection.DOWN);
        }

        IBlockData iblockdata = enderman.world.getType(blockposition_mutableblockposition);
        boolean flag = iblockdata.getMaterial().isSolid();
        boolean flag1 = iblockdata.getFluid().a(TagsFluid.WATER);
        if (flag && !flag1) {
            boolean flag2 = enderman.a(d0, d1, d2, true);
            if (flag2 && !enderman.isSilent()) {
                enderman.world.playSound(null, enderman.lastX, enderman.lastY, enderman.lastZ, SoundEffects.ENTITY_ENDERMAN_TELEPORT, enderman.getSoundCategory(), 1.0F, 1.0F);
                enderman.playSound(SoundEffects.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag2;
        } else {
            return false;
        }
    }

    public static boolean teleportTowards(EntityEnderman enderman, net.minecraft.server.v1_16_R1.Entity entity) {
        Vec3D vec3d = new Vec3D(enderman.locX() - entity.locX(), enderman.e(0.5) - entity.getHeadY(), enderman.locZ() - entity.locZ());
        vec3d = vec3d.d();
        Random random = enderman.getRandom();

        double d1 = enderman.locX() + (random.nextDouble() - 0.5) * 8.0 - vec3d.x * 16.0;
        double d2 = enderman.locY() + (double)(random.nextInt(16) - 8) - vec3d.y * 16.0;
        double d3 = enderman.locZ() + (random.nextDouble() - 0.5) * 8.0 - vec3d.z * 16.0;
        return teleport(enderman, d1, d2, d3);
    }
}
