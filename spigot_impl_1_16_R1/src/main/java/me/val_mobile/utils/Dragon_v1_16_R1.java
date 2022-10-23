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

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.DragonBreed;
import me.val_mobile.iceandfire.DragonVariant;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.server.v1_16_R1.*;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public abstract class Dragon_v1_16_R1 extends EntityEnderDragon implements RSVMob {

    private final DragonBreed breed;
    private int stage;
    private int age;
    private final Gender gender;
    private DragonVariant variant;
    private final Collection<ItemStack> loot = new ArrayList<>();
    private final UUID uuid;
    protected final RSVModule module;

    public Dragon_v1_16_R1(Location loc, DragonBreed breed) {
        super(EntityTypes.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.uuid = getUniqueID();

        this.module = RSVModule.getModule(IceFireModule.NAME);
        this.variant = breed.getVariants()[Utils.getRandomNum(0, breed.getVariants().length - 1)];
        this.breed = breed;
        this.stage = Utils.getRandomNum(1, 5);
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? Gender.MALE : Gender.FEMALE;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Dragon")));
        this.setCustomNameVisible(false);

        addNbtData();
    }

    public Dragon_v1_16_R1(Location loc, DragonBreed breed, DragonVariant variant) {
        super(EntityTypes.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.uuid = getUniqueID();

        this.module = RSVModule.getModule(IceFireModule.NAME);
        this.variant = variant.isEnabled() ? variant : null;
        this.breed = breed;
        this.stage = Utils.getRandomNum(1, 5);
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? Gender.MALE : Gender.FEMALE;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Dragon")));
        this.setCustomNameVisible(false);

        addNbtData();
    }

    public Dragon_v1_16_R1(Location loc, DragonBreed breed, int stage) {
        super(EntityTypes.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.uuid = getUniqueID();

        this.module = RSVModule.getModule(IceFireModule.NAME);

        DragonVariant[] allVariants = breed.getVariants();

        do {
            variant = allVariants[Utils.getRandomNum(0, allVariants.length)];
        } while(!variant.isEnabled());

        this.breed = breed;
        this.stage = stage;
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? Gender.MALE : Gender.FEMALE;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Dragon")));
        this.setCustomNameVisible(false);

        addNbtData();
    }

    public Dragon_v1_16_R1(Location loc, DragonBreed breed, DragonVariant variant, int stage) {
        super(EntityTypes.ENDER_DRAGON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.uuid = getUniqueID();

        this.module = RSVModule.getModule(IceFireModule.NAME);
        this.variant = variant.isEnabled() ? variant : null;;
        this.breed = breed;
        this.stage = stage;
        this.age = Utils.getRandomNum(stage * 100, stage * 100 + 99);

        this.gender = Utils.getRandomNum(0, 1) == 1 ? Gender.MALE : Gender.FEMALE;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Dragon")));
        this.setCustomNameVisible(false);

        addNbtData();
    }

    @Override
    public void addNbtData() {
        Utils util = RealisticSurvivalPlugin.getUtil();
        CraftEntity entity = this.getBukkitEntity();
        util.addNbtTag(entity, "rsvmob", breed.toString().toLowerCase() + "_dragon", PersistentDataType.STRING);
    }

    @Override
    public void die(DamageSource damageSource) {
        super.die(damageSource);
        generateLoot();
        Location loc = this.getBukkitEntity().getLocation();
        World world = loc.getWorld();

        Location center = world.getHighestBlockAt(loc).isEmpty() ? new Location(world, 0, 64, 256) : loc;

        for (ItemStack item : loot) {
            world.dropItemNaturally(center, item);
        }
    }

    @Override
    protected void initPathfinder()
    {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));

        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(1, new PathfinderGoalPet_v1_16_R1(this, 1.0, 25));
    }

    public final ModuleItems getModuleItems() {
        return module.getModuleItems();
    }

    public final UUID getUuid() {
        return uuid;
    }

    public abstract void performMeleeAttack(LivingEntity entity);

    public abstract void performSpecialAbility(LivingEntity entity);

    public abstract void triggerBreathAttack(Location target);

    public abstract void triggerExplosionAttack(Location target);

    public final void generateLoot() {
        // empty current loot table
        FileConfiguration config = module.getUserConfig().getConfig();
        loot.clear();

        String lowercaseBreed = breed.toString().toLowerCase();
        String capitalizeBreed = StringUtils.capitalize(lowercaseBreed);

        // initialize loot items
        ItemStack heart = RSVItem.getItem(lowercaseBreed + "_dragon_heart");
        ItemStack skull = RSVItem.getItem(lowercaseBreed + "_dragon_skull");
        ItemStack scales;
        ItemStack blood = RSVItem.getItem(lowercaseBreed + "_dragon_blood");
        ItemStack flesh = RSVItem.getItem(lowercaseBreed + "_dragon_flesh");
        ItemStack bones = RSVItem.getItem("dragonbone");

        // initialize the drop amounts of the loot
        int scaleAmount;
        int boneAmount;
        int bloodAmount;
        int fleshAmount;

        scales = RSVItem.getItem("dragonscale_" + variant.toString().toLowerCase());

        /**
         * Scale amount is between the minimum and maximum specified values.
         * Bone amount is calculated by subtracting the scale amount and adding a minimum bone amount.
         * Adding a minimum value ensures that at least 1 bone will drop.
         * Dragon flesh and blood amounts are determined by multiplying the scale amount
         * by a specified multiplier.
         */
        int maxScales = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonscales.Max");
        int minScales = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonscales.Min");
        int maxBones = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonbones.Max");
        int minBones = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonbones.Min");
        int minBlood = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Blood.Min");
        int maxBlood = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Blood.Max");
        int minFlesh = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Flesh.Min");
        int maxFlesh = config.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Flesh.Max");

        double stageMultiplier = config.getDouble("Dragons." + capitalizeBreed + "Dragon.Drops.StageMultipliers.Stage" + stage);

        scaleAmount = Utils.getRandomNum(minScales, maxScales);
        boneAmount = Utils.getRandomNum(minBones, maxBones);
        bloodAmount = Math.min((maxScales - scaleAmount + minBlood), maxBlood);
        fleshAmount = Utils.getRandomNum(minFlesh, maxFlesh);

        scaleAmount *= stageMultiplier;
        boneAmount *= stageMultiplier;
        bloodAmount *= stageMultiplier;
        fleshAmount *= stageMultiplier;

        // resize loot
        bones.setAmount(boneAmount);
        blood.setAmount(bloodAmount);
        flesh.setAmount(fleshAmount);
        scales.setAmount(scaleAmount);

        // add a lore to the skull
        LorePresets.addDragonSkullLore(skull, stage, breed.toString());

        // add the loot to the loot table
        loot.add(bones);
        loot.add(heart);
        loot.add(skull);
        loot.add(scales);
        loot.add(blood);
        loot.add(flesh);
    }


    public final DragonBreed getBreed() {
        return breed;
    }

    public final DragonVariant getVariant() {
        return variant;
    }

    public final int getStage() {
        return stage;
    }

    public final int getAge() {
        return age;
    }

    public final Gender getGender() {
        return gender;
    }

    public final Collection<ItemStack> getLoot() {
        return loot;
    }

    public final void setStage(int stage) {
        this.stage = stage;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}