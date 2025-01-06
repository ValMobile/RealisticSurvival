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
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import me.val_mobile.spartanandfire.FreezeTask;
import me.val_mobile.utils.LorePresets;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;

public class DragonUtils {

    private static final FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public static void convertToDragon(EnderDragon dragon, DragonBreed breed) {
        int stage = Utils.getRandomNum(1, 5);

        Utils.addNbtTag(dragon, "rsvmob", breed.toString().toLowerCase() + "_dragon", PersistentDataType.STRING);
        Utils.addNbtTag(dragon, "rsvdragonstage", stage, PersistentDataType.INTEGER);
        Utils.addNbtTag(dragon, "rsvdragonage", Utils.getRandomNum(stage * 100, stage * 100 + 99), PersistentDataType.INTEGER);
        Utils.addNbtTag(dragon, "rsvdragonvariant", DragonVariant.getEnabledVariants(breed).get(Utils.getRandomNum(0, DragonVariant.getEnabledVariants(breed).size() - 1)).toString(), PersistentDataType.STRING);
        Utils.addNbtTag(dragon, "rsvdragonbreed", breed.toString(), PersistentDataType.STRING);
        Utils.addNbtTag(dragon, "rsvdragongender", (Utils.getRandomNum(0, 1) == 1 ? DragonGender.MALE : DragonGender.FEMALE).toString(), PersistentDataType.STRING);
    }


    public static void convertToFireDragon(EnderDragon dragon) {
        convertToDragon(dragon, DragonBreed.FIRE);
    }

    public static void convertToIceDragon(EnderDragon dragon) {
        convertToDragon(dragon, DragonBreed.ICE);
    }

    public static void convertToLightningDragon(EnderDragon dragon) {
        convertToDragon(dragon, DragonBreed.LIGHTNING);
    }

    public static void performMeleeAttack(EnderDragon dragon, LivingEntity defender) {
        if (RSVMob.isMob(dragon)) {
            switch (RSVMob.getMob(dragon)) {
                case "fire_dragon" -> performMeleeFireAbility(dragon, defender);
                case "ice_dragon" -> performMeleeIceAbility(dragon, defender);
                case "lightning_dragon" -> performMeleeLightningAbility(dragon, defender);
                default -> {}
            }
        }
    }

    public static void performSpecialAbility(EnderDragon dragon, LivingEntity defender) {
        if (RSVMob.isMob(dragon)) {
            switch (RSVMob.getMob(dragon)) {
                case "fire_dragon" -> performSpecialFireAbility(dragon, defender);
                case "ice_dragon" -> performSpecialIceAbility(dragon, defender);
                case "lightning_dragon" -> performSpecialLightningAbility(dragon, defender);
                default -> {}
            }
        }
    }

    public static void performMeleeFireAbility(EnderDragon dragon, LivingEntity defender) {
        defender.damage(CONFIG.getDouble("Dragon.FireDragon.MeleeAttack.Stage" + getStage(dragon) + ".Damage"), dragon);
    }

    public static void performMeleeIceAbility(EnderDragon dragon, LivingEntity defender) {
        defender.damage(CONFIG.getDouble("Dragon.IceDragon.MeleeAttack.Stage" + getStage(dragon) + ".Damage"), dragon);
    }

    public static void performMeleeLightningAbility(EnderDragon dragon, LivingEntity defender) {
        defender.damage(CONFIG.getDouble("Dragon.LightningDragon.MeleeAttack.Stage" + getStage(dragon) + ".Damage"), dragon);
    }

    public static void performSpecialFireAbility(EnderDragon dragon, LivingEntity defender) {
        if (!BurnTask.hasTask(defender.getUniqueId())) {
            new BurnTask(RSVPlugin.getPlugin(), defender, (CONFIG.getInt("Dragon.FireDragon.InfernoAbility.Stage" + getStage(dragon))), CONFIG.getInt("Dragon.FireDragon.InfernoAbility.TickPeriod")).start();
        }
    }

    public static void performSpecialIceAbility(EnderDragon dragon, LivingEntity defender) {
        if (!FreezeTask.hasTask(defender.getUniqueId())) {
            new FreezeTask(RSVPlugin.getPlugin(), getStage(dragon), defender).start();
        }
    }

    public static void performSpecialLightningAbility(EnderDragon dragon, LivingEntity defender) {
        Location loc = defender.getLocation();
        if (CONFIG.getBoolean("Dragon.LightningDragon.ElectrocuteAbility.SummonCosmeticLightning")) {
            loc.getWorld().strikeLightningEffect(loc);
        }
        else {
            loc.getWorld().strikeLightning(loc);
        }
        if (!ElectrocuteTask.hasTask(defender.getUniqueId())) {
            new ElectrocuteTask(RSVPlugin.getPlugin(), getStage(dragon), defender).start();
        }
    }

    public static void triggerBreathAttack(EnderDragon dragon, Location target) {
        if (RSVMob.isMob(dragon)) {
            switch (RSVMob.getMob(dragon)) {
                case "fire_dragon" -> triggerBreathFireAttack(dragon, target);
                case "ice_dragon" -> triggerBreathIceAttack(dragon, target);
                case "lightning_dragon" -> triggerBreathLightningAttack(dragon, target);
                default -> {}
            }
        }
    }

    public static void triggerExplosionAttack(EnderDragon dragon, Location target) {
        if (RSVMob.isMob(dragon)) {
            switch (RSVMob.getMob(dragon)) {
                case "fire_dragon" -> triggerExplosionFireAttack(dragon, target);
                case "ice_dragon" -> triggerExplosionIceAttack(dragon, target);
                case "lightning_dragon" -> triggerExplosionLightningAttack(dragon, target);
                default -> {}
            }
        }
    }

    public static void triggerBreathFireAttack(EnderDragon dragon, Location target) {
        new FireBreath(dragon, target, RSVPlugin.getPlugin()).start();
    }

    public static void triggerBreathIceAttack(EnderDragon dragon, Location target) {
        new IceBreath(dragon, target, RSVPlugin.getPlugin()).start();
    }


    public static void triggerBreathLightningAttack(EnderDragon dragon, Location target) {
        new LightningBreath(dragon, target, RSVPlugin.getPlugin()).start();
    }

    public static void triggerExplosionFireAttack(EnderDragon dragon, Location target) {
        new FireExplosionAttack(dragon, target, RSVPlugin.getPlugin()).start();
    }

    public static void triggerExplosionIceAttack(EnderDragon dragon, Location target) {
        new IceExplosionAttack(dragon, target, RSVPlugin.getPlugin()).start();
    }

    public static void triggerExplosionLightningAttack(EnderDragon dragon, Location target) {
        new LightningExplosionAttack(dragon, target, RSVPlugin.getPlugin()).start();
    }

    public static Collection<ItemStack> generateLoot(EnderDragon dragon) {
        Collection<ItemStack> loot = new ArrayList<>();

        int stage = getStage(dragon);
        DragonBreed breed = getBreed(dragon);
        DragonVariant variant = getVariant(dragon);

        String lowercaseBreed = breed.toString().toLowerCase();

        // initialize loot items
        ItemStack heart = RSVItem.getItem("dragon_heart_" + lowercaseBreed);
        ItemStack skull = RSVItem.getItem("dragon_skull_" + lowercaseBreed);
        ItemStack scales = RSVItem.getItem("dragonscale_" + variant.toString().toLowerCase());
        ItemStack blood = RSVItem.getItem("dragon_blood_" + lowercaseBreed);
        ItemStack flesh = RSVItem.getItem("dragon_flesh_" + lowercaseBreed);
        ItemStack bones = RSVItem.getItem("dragonbone");

        // add a lore to the skull
        LorePresets.addDragonSkullLore(skull, stage, breed.toString());

        ConfigurationSection section = CONFIG.getConfigurationSection("Dragon.LootTable");
        ItemStack tool = dragon.getKiller() == null ? null : dragon.getKiller().getInventory().getItemInMainHand();
        // add the loot to the loot table
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Dragonscales.Stage" + stage), scales, tool, true));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Heart.Stage" + stage), heart, tool, true));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Skull.Stage" + stage), skull, tool, true));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Dragonbones.Stage" + stage), bones, tool, true));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Blood.Stage" + stage), blood, tool, true));
        loot.add(Utils.getMobLoot(section.getConfigurationSection("Flesh.Stage" + stage), flesh, tool, true));

        return loot;
    }

    public static boolean isDragon(Entity entity) {
        if (RSVMob.isMob(entity)) {
            return switch (RSVMob.getMob(entity)) {
                case "fire_dragon", "ice_dragon", "lightning_dragon" -> true;
                default -> false;
            };
        }
        return false;
    }

    public static int getStage(EnderDragon dragon) {
        return Utils.getNbtTag(dragon, "rsvdragonstage", PersistentDataType.INTEGER);
    }

    public static int getAge(EnderDragon dragon) {
        return Utils.getNbtTag(dragon, "rsvdragonage", PersistentDataType.INTEGER);
    }

    public static DragonVariant getVariant(EnderDragon dragon) {
        return DragonVariant.valueOf(Utils.getNbtTag(dragon, "rsvdragonvariant", PersistentDataType.STRING).toUpperCase());
    }

    public static DragonBreed getBreed(EnderDragon dragon) {
        return DragonBreed.valueOf(Utils.getNbtTag(dragon, "rsvdragonbreed", PersistentDataType.STRING).toUpperCase());
    }

    public static DragonGender getGender(EnderDragon dragon) {
        return DragonGender.valueOf(Utils.getNbtTag(dragon, "rsvdragongender", PersistentDataType.STRING).toUpperCase());
    }
}
