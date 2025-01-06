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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.craftbukkit.v1_21_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftPlayer;
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

public class v1_21_R4 extends InternalsProvider {

    @Override
    public EndermanAlly spawnEndermanAlly(Player owner, Location loc) {
        return new EndermanAlly_v1_21_R4(owner, loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc) {
        return new FireDragon_v1_21_R4(loc);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, int stage) {
        return new FireDragon_v1_21_R4(loc, stage);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant) {
        return new FireDragon_v1_21_R4(loc, variant);
    }

    @Override
    public FireDragon spawnFireDragon(Location loc, DragonVariant variant, int stage) {
        return new FireDragon_v1_21_R4(loc, variant, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc) {
        return new IceDragon_v1_21_R4(loc);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, int stage) {
        return new IceDragon_v1_21_R4(loc, stage);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant) {
        return new IceDragon_v1_21_R4(loc, variant);
    }

    @Override
    public IceDragon spawnIceDragon(Location loc, DragonVariant variant, int stage) {
        return new IceDragon_v1_21_R4(loc, variant, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc) {
        return new LightningDragon_v1_21_R4(loc);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, int stage) {
        return new LightningDragon_v1_21_R4(loc, stage);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant) {
        return new LightningDragon_v1_21_R4(loc, variant);
    }

    @Override
    public LightningDragon spawnLightningDragon(Location loc, DragonVariant variant, int stage) {
        return new LightningDragon_v1_21_R4(loc, variant, stage);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc) {
        return new SeaSerpent_v1_21_R4(loc);
    }

    @Override
    public SeaSerpent spawnSeaSerpent(Location loc, SeaSerpentVariant variant) {
        return new SeaSerpent_v1_21_R4(loc, variant);
    }

    @Override
    public Siren spawnSiren(Location loc) {
        return new Siren_v1_21_R4(loc);
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
        CustomEntities_v1_21_R4.registerEntities();
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
            ((CraftLivingEntity) attacker).getHandle().doHurtTarget(((CraftWorld) defender.getWorld()).getHandle(), ((CraftEntity) defender).getHandle());
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

    public static boolean isLookingAtMe(EnderMan enderman, net.minecraft.world.entity.player.Player entityhuman) {
        ItemStack itemstack = entityhuman.getInventory().armor.get(3);
        if (itemstack.is(Blocks.CARVED_PUMPKIN.asItem())) {
            return false;
        }
        else {
            Vec3 vec3d = entityhuman.getViewVector(1.0F).normalize();
            Vec3 vec3d1 = new Vec3(enderman.getX() - entityhuman.getX(), enderman.getEyeY() - entityhuman.getEyeY(), enderman.getZ() - entityhuman.getZ());
            double d0 = vec3d1.length();
            vec3d1 = vec3d1.normalize();
            double d1 = vec3d.dot(vec3d1);
            return d1 > 1.0 - 0.025 / d0 && entityhuman.hasLineOfSight(enderman);
        }
    }

    public static void teleport(EnderMan enderman) {
        if (!enderman.level().isClientSide() && enderman.isAlive()) {
            RandomSource random = enderman.getRandom();

            double d0 = enderman.getX() + (random.nextDouble() - 0.5) * 64.0;
            double d1 = enderman.getY() + (double)(random.nextInt(64) - 32);
            double d2 = enderman.getZ() + (random.nextDouble() - 0.5) * 64.0;
            teleport(enderman, d0, d1, d2);
        }
    }

    public static boolean teleport(EnderMan enderman, double d0, double d1, double d2) {
        BlockPos.MutableBlockPos blockposition_mutableblockposition = new BlockPos.MutableBlockPos(d0, d1, d2);

        while(blockposition_mutableblockposition.getY() > enderman.level().getMinY() && !enderman.level().getBlockState(blockposition_mutableblockposition).blocksMotion()) {
            blockposition_mutableblockposition.move(Direction.DOWN);
        }

        BlockState iblockdata = enderman.level().getBlockState(blockposition_mutableblockposition);
        boolean flag = iblockdata.blocksMotion();
        boolean flag1 = iblockdata.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            Vec3 vec3d = enderman.position();
            boolean flag2 = enderman.randomTeleport(d0, d1, d2, true);
            if (flag2) {
                enderman.level().gameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Context.of(enderman));
                if (!enderman.isSilent()) {
                    enderman.level().playSound(null, enderman.xo, enderman.yo, enderman.zo, SoundEvents.ENDERMAN_TELEPORT, enderman.getSoundSource(), 1.0F, 1.0F);
                    enderman.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            }

            return flag2;
        } else {
            return false;
        }
    }

    public static boolean teleportTowards(EnderMan enderman, net.minecraft.world.entity.Entity entity) {
        RandomSource random = enderman.getRandom();
        Vec3 vec3d = new Vec3(enderman.getX() - entity.getX(), enderman.getY(0.5) - entity.getEyeY(), enderman.getZ() - entity.getZ());
        vec3d = vec3d.normalize();
        double d1 = enderman.getX() + (random.nextDouble() - 0.5) * 8.0 - vec3d.x * 16.0;
        double d2 = enderman.getY() + (double)(random.nextInt(16) - 8) - vec3d.y * 16.0;
        double d3 = enderman.getZ() + (random.nextDouble() - 0.5) * 8.0 - vec3d.z * 16.0;
        return teleport(enderman, d1, d2, d3);
    }
}
