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
package me.val_mobile.data.iceandfire;

import me.val_mobile.data.RSVDataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DataModule implements RSVDataModule {

    private Player player;
    private final RealisticSurvivalPlugin plugin;
    private final Utils util;

    private int tideGuardianArmor;
    private double dragonDamageReduction;

    public DataModule(RealisticSurvivalPlugin plugin, Player player) {
        this.plugin = plugin;
        this.util = new Utils(plugin);
        this.player = player;

        retrieveData();
    }

    @Override
    public void retrieveData() {
//        FileConfiguration config = RSVFiles.getPlayerDataConfig();
//
//        String p = player.getUniqueId().toString();
//
//        String icefirePath = p + ".IceAndFire";
//        String tideGuardianPath = icefirePath + ".TideGuardianArmor";
//        String damageReduction = icefirePath + ".DragonDamageReduction";
//
//        if (!config.getConfigurationSection("").contains(p)) {
//            config.createSection(p);
//            config.createSection(icefirePath);
//            config.createSection(tideGuardianPath);
//            config.createSection(damageReduction);
//            config.set(tideGuardianPath, 0);
//            config.set(damageReduction, 0D);
//        }
//        this.tideGuardianArmor = config.getInt(tideGuardianPath);
//        this.dragonDamageReduction = config.getDouble(damageReduction);
    }

    @Override
    public void updateData() {
        ItemStack[] items = player.getInventory().getArmorContents();

        RSVItem rsvItem;
        String name;
        FileConfiguration config = RSVFiles.getIfUserConfig();
        dragonDamageReduction = 0D;
        tideGuardianArmor = 0;

        for (ItemStack item : items) {
            if (RSVItem.isRSVItem(item, util)) {
                rsvItem = RSVItem.convertItemStackToRSVItem(item, plugin);
                name = rsvItem.getName();


                switch (name) {
                    case "dragonscale_helmet_blue": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_blue.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_bronze": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_bronze.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_gray": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_gray.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_green": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_green.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_red": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_red.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_sapphire": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_sapphire.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_silver": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_silver.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_white": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_white.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_amethyst": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_amethyst.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_black": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_black.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_copper": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_copper.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_helmet_electric": {
                        dragonDamageReduction += config.getDouble("dragonscale_helmet_electric.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_fire_helmet": {
                        dragonDamageReduction += config.getDouble("dragonsteel_fire_helmet.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_ice_helmet": {
                        dragonDamageReduction += config.getDouble("dragonsteel_ice_helmet.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_lightning_helmet": {
                        dragonDamageReduction += config.getDouble("dragonsteel_lightning_helmet.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_blue": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_blue.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_bronze": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_bronze.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_gray": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_gray.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_green": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_green.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_red": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_red.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_sapphire": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_sapphire.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_silver": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_silver.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_white": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_white.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_amethyst": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_amethyst.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_black": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_black.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_copper": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_copper.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_chestplate_electric": {
                        dragonDamageReduction += config.getDouble("dragonscale_chestplate_electric.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_fire_chestplate": {
                        dragonDamageReduction += config.getDouble("dragonsteel_fire_chestplate.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_ice_chestplate": {
                        dragonDamageReduction += config.getDouble("dragonsteel_ice_chestplate.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_lightning_chestplate": {
                        dragonDamageReduction += config.getDouble("dragonsteel_lightning_chestplate.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_blue": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_blue.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_bronze": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_bronze.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_gray": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_gray.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_green": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_green.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_red": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_red.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_sapphire": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_sapphire.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_silver": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_silver.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_white": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_white.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_amethyst": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_amethyst.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_black": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_black.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_copper": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_copper.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_leggings_electric": {
                        dragonDamageReduction += config.getDouble("dragonscale_leggings_electric.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_fire_leggings": {
                        dragonDamageReduction += config.getDouble("dragonsteel_fire_leggings.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_ice_leggings": {
                        dragonDamageReduction += config.getDouble("dragonsteel_ice_leggings.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_lightning_leggings": {
                        dragonDamageReduction += config.getDouble("dragonsteel_lightning_leggings.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_blue": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_blue.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_bronze": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_bronze.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_gray": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_gray.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_green": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_green.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_red": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_red.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_sapphire": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_sapphire.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_silver": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_silver.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_white": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_white.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_amethyst": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_amethyst.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_black": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_black.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_copper": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_copper.DragonDamageReduction");
                        break;
                    }
                    case "dragonscale_boots_electric": {
                        dragonDamageReduction += config.getDouble("dragonscale_boots_electric.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_fire_boots": {
                        dragonDamageReduction += config.getDouble("dragonsteel_fire_boots.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_ice_boots": {
                        dragonDamageReduction += config.getDouble("dragonsteel_ice_boots.DragonDamageReduction");
                        break;
                    }
                    case "dragonsteel_lightning_boots": {
                        dragonDamageReduction += config.getDouble("dragonsteel_lightning_boots.DragonDamageReduction");
                        break;
                    }
                    case "tide_guardian_helmet_blue":
                    case "tide_guardian_helmet_bronze":
                    case "tide_guardian_helmet_deepblue":
                    case "tide_guardian_helmet_green":
                    case "tide_guardian_helmet_purple":
                    case "tide_guardian_helmet_red":
                    case "tide_guardian_helmet_teal":
                    case "tide_guardian_chestplate_blue":
                    case "tide_guardian_chestplate_bronze":
                    case "tide_guardian_chestplate_deepblue":
                    case "tide_guardian_chestplate_green":
                    case "tide_guardian_chestplate_purple":
                    case "tide_guardian_chestplate_red":
                    case "tide_guardian_chestplate_teal":
                    case "tide_guardian_leggings_blue":
                    case "tide_guardian_leggings_bronze":
                    case "tide_guardian_leggings_deepblue":
                    case "tide_guardian_leggings_green":
                    case "tide_guardian_leggings_purple":
                    case "tide_guardian_leggings_red":
                    case "tide_guardian_leggings_teal":
                    case "tide_guardian_boots_blue":
                    case "tide_guardian_boots_bronze":
                    case "tide_guardian_boots_deepblue":
                    case "tide_guardian_boots_green":
                    case "tide_guardian_boots_purple":
                    case "tide_guardian_boots_red":
                    case "tide_guardian_boots_teal": {
                        tideGuardianArmor++;
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void saveData() {
//        FileConfiguration config = RSVFiles.getPlayerDataConfig();
//
//        String p = player.getUniqueId().toString();
//
//        String icefirePath = p + ".IceAndFire";
//        String tideGuardianPath = icefirePath + ".TideGuardianArmor";
//        String damageReduction = icefirePath + ".DragonDamageReduction";
//
//        if (!config.getConfigurationSection("").contains(p)) {
//            config.createSection(p);
//            config.createSection(icefirePath);
//            config.createSection(tideGuardianPath);
//            config.createSection(damageReduction);
//        }
//        config.set(tideGuardianPath, tideGuardianArmor);
//        config.set(damageReduction, dragonDamageReduction);
    }
}
