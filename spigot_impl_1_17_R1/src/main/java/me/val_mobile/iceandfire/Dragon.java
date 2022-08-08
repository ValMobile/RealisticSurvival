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
package me.val_mobile.iceandfire;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.libs.org.codehaus.plexus.util.StringUtils;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

public abstract class Dragon extends EntityEnderDragon {

    private final RealisticSurvivalPlugin plugin;
    private Breed breed;
    private int stage;
    private int age;
    private Gender gender;
    private Variant variant;
    private final Collection<ItemStack> loot = new ArrayList<>();
    private final UUID uuid;
    private final ModuleItems moduleItems;

    public Dragon(Location loc, Breed breed, RealisticSurvivalPlugin plugin) {
        super(EntityTypes.v, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.plugin = plugin;
        this.uuid = getUniqueID();

        Random r = new Random();

        this.moduleItems = RSVModule.getModule("IceandFire").getModuleItems();;
        this.breed = breed;
        this.stage = (int) Math.round(Math.random() * 4) + 1;
        this.age = this.stage * 100 + (int) Math.round(Math.random() * 99);

        this.gender = ((int) Math.round(Math.random()) == 1) ? Gender.MALE : Gender.FEMALE;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalizeFirstLetter(variant.toString()) + " Dragon"));
        this.setCustomNameVisible(false);
    }

    public Dragon(Location loc, Breed breed, int stage, RealisticSurvivalPlugin plugin) {
        super(EntityTypes.v, NMSUtil.getInternals().getWorld(loc.getWorld()));
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.plugin = plugin;
        this.uuid = getUniqueID();

        Random r = new Random();

        this.moduleItems = RSVModule.getModule("IceandFire").getModuleItems();;
        this.breed = breed;
        this.stage = stage;
        this.age = this.stage * 100 + (int) Math.round(Math.random() * 99);

        this.gender = ((int) Math.round(Math.random()) == 1) ? Gender.MALE : Gender.FEMALE;

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalizeFirstLetter(variant.toString()) + " Dragon"));
        this.setCustomNameVisible(false);
    }

    public ModuleItems getModuleItems() {
        return moduleItems;
    }

    public void spawnEntity() {
        NMSUtil.getInternals().spawnEntity(this);
    }

    public UUID getUuid() {
        return uuid;
    }

    public abstract void ability(LivingEntity entity);

    public abstract void triggerBreathAttack();

    public abstract void triggerExplosionAttack();

    public abstract void generateLoot();

    public Breed getBreed() {
        return breed;
    }

    public Variant getVariant() {
        return variant;
    }

    public int getStage() {
        return stage;
    }

    public int getAge() {
        return age;
    }

    public void getGender(Gender gender) {
        this.gender = gender;
    }

    public Collection<ItemStack> getLoot() {
        return loot;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public enum Breed {
        FIRE,
        ICE,
        LIGHTNING
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    public enum Variant {
        GRAY,
        EMERALD,
        RED,
        BRONZE,
        SAPPHIRE,
        BLUE,
        SILVER,
        WHITE,
        AMETHYST,
        BLACK,
        ELECTRIC_BLUE,
        COPPER
    }
}