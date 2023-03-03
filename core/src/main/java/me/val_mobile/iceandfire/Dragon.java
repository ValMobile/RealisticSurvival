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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.LorePresets;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;

public interface Dragon extends RSVMob {

    FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", getBreed().toString().toLowerCase() + "_dragon", PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvdragonstage", getStage(), PersistentDataType.INTEGER);
        Utils.addNbtTag(getEntity(), "rsvdragonage", getAge(), PersistentDataType.INTEGER);
        Utils.addNbtTag(getEntity(), "rsvdragonvariant", getVariant().toString(), PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvdragonbreed", getBreed().toString(), PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvdragongender", getGender().toString(), PersistentDataType.STRING);
    }

    default void generateLoot(Collection<ItemStack> loot) {
        loot.clear();

        int stage = getStage();
        DragonBreed breed = getBreed();
        DragonVariant variant = getVariant();

        String lowercaseBreed = breed.toString().toLowerCase();
        String capitalizeBreed = StringUtils.capitalize(lowercaseBreed);

        // initialize loot items
        ItemStack heart = RSVItem.getItem("dragon_heart_" + lowercaseBreed);
        ItemStack skull = RSVItem.getItem("dragon_skull_" + lowercaseBreed);
        ItemStack scales;
        ItemStack blood = RSVItem.getItem("dragon_blood_" + lowercaseBreed);
        ItemStack flesh = RSVItem.getItem("dragon_flesh_" + lowercaseBreed);
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
        int maxScales = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonscales.Max");
        int minScales = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonscales.Min");
        int maxBones = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonbones.Max");
        int minBones = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Dragonbones.Min");
        int minBlood = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Blood.Min");
        int maxBlood = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Blood.Max");
        int minFlesh = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Flesh.Min");
        int maxFlesh = CONFIG.getInt("Dragons." + capitalizeBreed + "Dragon.Drops.Flesh.Max");

        double stageMultiplier = CONFIG.getDouble("Dragons." + capitalizeBreed + "Dragon.Drops.StageMultipliers.Stage" + stage);

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

    void performMeleeAttack(LivingEntity entity);

    void performSpecialAbility(LivingEntity entity);

    void triggerBreathAttack(Location target);

    void triggerExplosionAttack(Location target);

    DragonBreed getBreed();

    DragonVariant getVariant();

    int getStage();

    int getAge();

    DragonGender getGender();

    Collection<ItemStack> getLoot();

    void setStage(int stage);

    void setAge(int age);
}
