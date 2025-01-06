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

import me.val_mobile.iceandfire.Dragon;
import me.val_mobile.iceandfire.DragonBreed;
import me.val_mobile.iceandfire.DragonGender;
import me.val_mobile.iceandfire.DragonVariant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Arrays;
import java.util.List;

public abstract class Dragon_v1_17_R1 extends EnderDragon implements Dragon {

    private final DragonBreed breed;
    private int stage;
    private int age;
    private final DragonGender gender;
    private final DragonVariant variant;
    
    public Dragon_v1_17_R1(EntityType<? extends EnderDragon> entityType, Level world, DragonBreed breed) {
        super(entityType, world);

        List<DragonVariant> enabledVariants = DragonVariant.getEnabledVariants(breed);
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));
        this.breed = breed;
        this.stage = Utils.getRandomNum(1, 5);
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? DragonGender.MALE : DragonGender.FEMALE;

        setup();
    }

    public Dragon_v1_17_R1(Location loc, DragonBreed breed) {
        super(EntityType.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        List<DragonVariant> enabledVariants = DragonVariant.getEnabledVariants(breed);
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));
        this.breed = breed;
        this.stage = Utils.getRandomNum(1, 5);
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? DragonGender.MALE : DragonGender.FEMALE;

        setup();
    }

    public Dragon_v1_17_R1(Location loc, DragonBreed breed, DragonVariant variant) {
        super(EntityType.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.variant = variant.isEnabled() && Arrays.asList(breed.getVariants()).contains(variant) ? variant : null;
        this.breed = breed;
        this.stage = Utils.getRandomNum(1, 5);
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? DragonGender.MALE : DragonGender.FEMALE;

        setup();
    }

    public Dragon_v1_17_R1(Location loc, DragonBreed breed, int stage) {
        super(EntityType.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        List<DragonVariant> enabledVariants = DragonVariant.getEnabledVariants(breed);
        this.variant = enabledVariants.get(Utils.getRandomNum(0, enabledVariants.size() - 1));

        this.breed = breed;
        this.stage = stage;
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? DragonGender.MALE : DragonGender.FEMALE;

        setup();
    }

    public Dragon_v1_17_R1(Location loc, DragonBreed breed, DragonVariant variant, int stage) {
        super(EntityType.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.variant = variant.isEnabled() && Arrays.asList(breed.getVariants()).contains(variant) ? variant : null;
        this.breed = breed;
        this.stage = stage;
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? DragonGender.MALE : DragonGender.FEMALE;

        setup();
    }

    @Override
    public void addEntityToWorld(org.bukkit.World world) {
        ((CraftWorld) world).addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public Entity getEntity() {
        return this.getBukkitEntity();
    }

    @Override
    public DragonBreed getBreed() {
        return breed;
    }

    @Override
    public DragonVariant getVariant() {
        return variant;
    }

    @Override
    public int getStage() {
        return stage;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public DragonGender getGender() {
        return gender;
    }

    @Override
    public void setStage(int stage) {
        this.stage = stage;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}