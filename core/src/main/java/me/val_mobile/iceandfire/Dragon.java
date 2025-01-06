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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.LorePresets;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Dragon extends RSVMob {

    @Override
    default List<String> getRequiredModules() {
        return List.of(IceFireModule.NAME);
    }

    @Override
    default String getParentModule() {
        return IceFireModule.NAME;
    }

    @Override
    default String name() {
        return getBreed().toString().toLowerCase() + "_dragon";
    }

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", name(), PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvdragonstage", getStage(), PersistentDataType.INTEGER);
        Utils.addNbtTag(getEntity(), "rsvdragonage", getAge(), PersistentDataType.INTEGER);
        Utils.addNbtTag(getEntity(), "rsvdragonvariant", getVariant().toString(), PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvdragonbreed", getBreed().toString(), PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvdragongender", getGender().toString(), PersistentDataType.STRING);
    }

    @Override
    @Nonnull
    default List<ItemStack> getLoot(@Nullable ItemStack tool) {
        FileConfiguration config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

        int stage = getStage();

        List<ItemStack> loot = new ArrayList<>();

        String breed = getBreed().toString().toLowerCase();

        ConfigurationSection section = config.getConfigurationSection("Dragon.LootTable");

        // initialize loot items
        ItemStack heart = RSVItem.getItem("dragon_heart_" + breed);
        ItemStack skull = RSVItem.getItem("dragon_skull_" + breed);
        ItemStack scales = RSVItem.getItem("dragonscale_" + getVariant().toString().toLowerCase());
        ItemStack blood = RSVItem.getItem("dragon_blood_" + breed);
        ItemStack flesh = RSVItem.getItem("dragon_flesh_" + breed);
        ItemStack bones = RSVItem.getItem("dragonbone");

        LorePresets.addDragonSkullLore(skull, stage, breed.toString());

        loot.add(Utils.getMobLoot(section.getConfigurationSection("Dragoncales.Stage" + getStage()), scales, tool, false));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Blood.Stage" + getStage()), blood, tool, false));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Dragonbones.Stage" + getStage()), bones, tool, false));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Flesh.Stage" + getStage()), flesh, tool, false));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Skull.Stage" + getStage()), skull, tool, false));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Heart.Stage" + getStage()), heart, tool, false));
        loot.addAll(getConfigurableLoot(tool));

        return loot;
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

    void setStage(int stage);

    void setAge(int age);

    @Override
    default void applyConfigOptions() {
        EnderDragon dragon = (EnderDragon) getEntity();

        ConfigurationSection section = RSVModule.getModule(getParentModule()).getUserConfig().getConfig().getConfigurationSection("Dragon.Info");

        dragon.setCustomName(Utils.translateMsg(section.getString("Name"), dragon, Map.of("VARIANT", getVariant(), "BREED", getBreed(), "GENDER", getGender(), "AGE", getAge(), "STAGE", getStage())));
        dragon.setCustomNameVisible(section.getBoolean("CustomNameVisible"));
        double minHealth = section.getDouble("Health.Stage" + getStage() + ".Min");
        double maxHealth = section.getDouble("Health.Stage" + getStage() + ".Max");

        double health = Utils.getRandomNum(minHealth, maxHealth);

        if (health > dragon.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
            dragon.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        }
        dragon.setHealth(health);
    }

    @Override
    default void setup() {
        RSVMob.super.setup();
        ((EnderDragon) getEntity()).setPhase(EnderDragon.Phase.STRAFING);
    }
}
