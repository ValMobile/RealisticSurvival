package me.val_mobile.rlcraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Tab implements TabCompleter {
    List<String> msmpFirstArgs = new ArrayList<String>();
    List<String> msmpSecondArgs = new ArrayList<String>();
    List<String> msmpThirdArgs = new ArrayList<String>();

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("rlcraft")) {
            if (msmpFirstArgs.isEmpty()) {
                msmpFirstArgs.add("reload");
                msmpFirstArgs.add("give");
            }
            if (msmpSecondArgs.isEmpty()) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    msmpSecondArgs.add(player.getName());
                }
            }

            if (msmpThirdArgs.isEmpty()) {
                msmpThirdArgs.add("dragon_scale_amethyst");
                msmpThirdArgs.add("dragon_scale_boots_amethyst");
                msmpThirdArgs.add("dragon_scale_chestplate_amethyst");
                msmpThirdArgs.add("dragon_scale_helmet_amethyst");
                msmpThirdArgs.add("dragon_scale_leggings_amethyst");

                msmpThirdArgs.add("dragon_scale_black");
                msmpThirdArgs.add("dragon_scale_boots_black");
                msmpThirdArgs.add("dragon_scale_chestplate_black");
                msmpThirdArgs.add("dragon_scale_helmet_black");
                msmpThirdArgs.add("dragon_scale_leggings_black");

                msmpThirdArgs.add("dragon_scale_blue");
                msmpThirdArgs.add("dragon_scale_boots_blue");
                msmpThirdArgs.add("dragon_scale_chestplate_blue");
                msmpThirdArgs.add("dragon_scale_helmet_blue");
                msmpThirdArgs.add("dragon_scale_leggings_blue");

                msmpThirdArgs.add("sea_serpent_scale_blue");
                msmpThirdArgs.add("tide_guardian_boots_blue");
                msmpThirdArgs.add("tide_guardian_chestplate_blue");
                msmpThirdArgs.add("tide_guardian_helmet_blue");
                msmpThirdArgs.add("tide_guardian_leggings_blue");

                msmpThirdArgs.add("dragon_scale_bronze");
                msmpThirdArgs.add("dragon_scale_boots_bronze");
                msmpThirdArgs.add("dragon_scale_chestplate_bronze");
                msmpThirdArgs.add("dragon_scale_helmet_bronze");
                msmpThirdArgs.add("dragon_scale_leggings_bronze");

                msmpThirdArgs.add("sea_serpent_scale_bronze");
                msmpThirdArgs.add("tide_guardian_boots_bronze");
                msmpThirdArgs.add("tide_guardian_chestplate_bronze");
                msmpThirdArgs.add("tide_guardian_helmet_bronze");
                msmpThirdArgs.add("tide_guardian_leggings_bronze");

                msmpThirdArgs.add("dragon_scale_copper");
                msmpThirdArgs.add("dragon_scale_boots_copper");
                msmpThirdArgs.add("dragon_scale_chestplate_copper");
                msmpThirdArgs.add("dragon_scale_helmet_copper");
                msmpThirdArgs.add("dragon_scale_leggings_copper");

                msmpThirdArgs.add("sea_serpent_scale_deepblue");
                msmpThirdArgs.add("tide_guardian_boots_deepblue");
                msmpThirdArgs.add("tide_guardian_chestplate_deepblue");
                msmpThirdArgs.add("tide_guardian_helmet_deepblue");
                msmpThirdArgs.add("tide_guardian_leggings_deepblue");

                msmpThirdArgs.add("dragon_bone");
                msmpThirdArgs.add("dragon_bone_axe");
                msmpThirdArgs.add("dragon_bone_bow");
                msmpThirdArgs.add("dragon_bone_hoe");
                msmpThirdArgs.add("dragon_bone_pickaxe");
                msmpThirdArgs.add("dragon_bone_shovel");
                msmpThirdArgs.add("dragon_bone_sword");

                msmpThirdArgs.add("dragon_scale_electric");
                msmpThirdArgs.add("dragon_scale_boots_electric");
                msmpThirdArgs.add("dragon_scale_chestplate_electric");
                msmpThirdArgs.add("dragon_scale_helmet_electric");
                msmpThirdArgs.add("dragon_scale_leggings_electric");

                msmpThirdArgs.add("dragon_blood_fire");
                msmpThirdArgs.add("dragon_heart_fire");
                msmpThirdArgs.add("dragon_flesh_fire");
                msmpThirdArgs.add("dragonsteel_fire_ingot");
                msmpThirdArgs.add("dragon_bone_flamed_sword");

                msmpThirdArgs.add("dragon_scale_gray");
                msmpThirdArgs.add("dragon_scale_boots_gray");
                msmpThirdArgs.add("dragon_scale_chestplate_gray");
                msmpThirdArgs.add("dragon_scale_helmet_gray");
                msmpThirdArgs.add("dragon_scale_leggings_gray");

                msmpThirdArgs.add("dragon_scale_green");
                msmpThirdArgs.add("dragon_scale_boots_green");
                msmpThirdArgs.add("dragon_scale_chestplate_green");
                msmpThirdArgs.add("dragon_scale_helmet_green");
                msmpThirdArgs.add("dragon_scale_leggings_green");

                msmpThirdArgs.add("sea_serpent_scale_green");
                msmpThirdArgs.add("tide_guardian_boots_green");
                msmpThirdArgs.add("tide_guardian_chestplate_green");
                msmpThirdArgs.add("tide_guardian_helmet_green");
                msmpThirdArgs.add("tide_guardian_leggings_green");

                msmpThirdArgs.add("dragon_blood_ice");
                msmpThirdArgs.add("dragon_heart_ice");
                msmpThirdArgs.add("dragon_flesh_ice");
                msmpThirdArgs.add("dragon_bone_iced_sword");
                msmpThirdArgs.add("dragonsteel_ice_ingot");

                msmpThirdArgs.add("dragon_blood_lightning");
                msmpThirdArgs.add("dragon_heart_lightning");
                msmpThirdArgs.add("dragon_flesh_lightning");
                msmpThirdArgs.add("dragon_bone_lightning_sword");
                msmpThirdArgs.add("dragonsteel_lightning_ingot");

                msmpThirdArgs.add("sea_serpent_scale_purple");
                msmpThirdArgs.add("tide_guardian_boots_purple");
                msmpThirdArgs.add("tide_guardian_chestplate_purple");
                msmpThirdArgs.add("tide_guardian_helmet_purple");
                msmpThirdArgs.add("tide_guardian_leggings_purple");

                msmpThirdArgs.add("dragon_scale_red");
                msmpThirdArgs.add("dragon_scale_boots_red");
                msmpThirdArgs.add("dragon_scale_chestplate_red");
                msmpThirdArgs.add("dragon_scale_helmet_red");
                msmpThirdArgs.add("dragon_scale_leggings_red");

                msmpThirdArgs.add("sea_serpent_scale_red");
                msmpThirdArgs.add("tide_guardian_boots_red");
                msmpThirdArgs.add("tide_guardian_chestplate_red");
                msmpThirdArgs.add("tide_guardian_helmet_red");
                msmpThirdArgs.add("tide_guardian_leggings_red");

                msmpThirdArgs.add("dragon_scale_sapphire");
                msmpThirdArgs.add("dragon_scale_boots_sapphire");
                msmpThirdArgs.add("dragon_scale_chestplate_sapphire");
                msmpThirdArgs.add("dragon_scale_helmet_sapphire");
                msmpThirdArgs.add("dragon_scale_leggings_sapphire");

                msmpThirdArgs.add("shiny_scale");

                msmpThirdArgs.add("dragon_scale_silver");
                msmpThirdArgs.add("dragon_scale_boots_silver");
                msmpThirdArgs.add("dragon_scale_chestplate_silver");
                msmpThirdArgs.add("dragon_scale_helmet_silver");
                msmpThirdArgs.add("dragon_scale_leggings_silver");

                msmpThirdArgs.add("sea_serpent_scale_teal");
                msmpThirdArgs.add("tide_guardian_boots_teal");
                msmpThirdArgs.add("tide_guardian_chestplate_teal");
                msmpThirdArgs.add("tide_guardian_helmet_teal");
                msmpThirdArgs.add("tide_guardian_leggings_teal");

                msmpThirdArgs.add("dragon_scale_white");
                msmpThirdArgs.add("dragon_scale_boots_white");
                msmpThirdArgs.add("dragon_scale_chestplate_white");
                msmpThirdArgs.add("dragon_scale_helmet_white");
                msmpThirdArgs.add("dragon_scale_leggings_white");

                msmpThirdArgs.add("witherbone");

                msmpThirdArgs.add("bauble_potion_ring_resistance");
                msmpThirdArgs.add("bauble_potion_ring_regeneration");
                msmpThirdArgs.add("bauble_potion_ring_strength");
                msmpThirdArgs.add("bauble_potion_ring_haste");
                msmpThirdArgs.add("bauble_potion_ring_speed");
                msmpThirdArgs.add("bauble_potion_ring_jump_boost");
                msmpThirdArgs.add("bauble_dragons_eye");
                msmpThirdArgs.add("dragon_skull");
                msmpThirdArgs.add("bauble_crown_ender_queens");
                msmpThirdArgs.add("bauble_stone_poison");
                msmpThirdArgs.add("battle_burrito");
                msmpThirdArgs.add("bauble_ankh_charm");
                msmpThirdArgs.add("bauble_shield_ankh");
                msmpThirdArgs.add("bauble_balloon");
                msmpThirdArgs.add("bauble_bezoar");
                msmpThirdArgs.add("bauble_dragon_scale_black");
                msmpThirdArgs.add("bauble_shield_cobalt");
                msmpThirdArgs.add("bauble_dragon_scale_black_cracked");
                msmpThirdArgs.add("bauble_dragon_scale_ender");
                msmpThirdArgs.add("bauble_forbidden_fruit");
                msmpThirdArgs.add("bauble_ring_iron");
                msmpThirdArgs.add("bauble_lucky_horseshoe");
                msmpThirdArgs.add("bauble_mirror_magic");
                msmpThirdArgs.add("bauble_dragon_scale_mixed_color");
                msmpThirdArgs.add("bauble_shield_obsidian");
                msmpThirdArgs.add("bauble_obsidian_skull");
                msmpThirdArgs.add("bauble_ring_free_action");
                msmpThirdArgs.add("bauble_ring_overclocking");
                msmpThirdArgs.add("bauble_shulker_heart");
                msmpThirdArgs.add("bauble_vitamins");
                msmpThirdArgs.add("bauble_mirror_wormhole");

                msmpThirdArgs.add("flint_shard");
                msmpThirdArgs.add("flint_axe");
                msmpThirdArgs.add("flint_shovel");
                msmpThirdArgs.add("flint_pickaxe");
                msmpThirdArgs.add("flint_hoe");
                msmpThirdArgs.add("flint_knife");
                msmpThirdArgs.add("plant_fiber");
                msmpThirdArgs.add("plant_string");

                msmpThirdArgs.add("bauble_ring_scarlite");
                msmpThirdArgs.add("bauble_spectral_silt");
                msmpThirdArgs.add("bauble_disintegration_tablet");
                msmpThirdArgs.add("bauble_cross_necklace");
                msmpThirdArgs.add("bauble_pendant_wrath");
                msmpThirdArgs.add("bauble_pendant_pride");
                msmpThirdArgs.add("bauble_pendant_gluttony");
                msmpThirdArgs.add("bauble_pendant_sin");
                msmpThirdArgs.add("bauble_flare_gun");
                msmpThirdArgs.add("bauble_flare");
                msmpThirdArgs.add("bauble_amulet_phytoprostasia");
                msmpThirdArgs.add("bauble_potion_ring");
                msmpThirdArgs.add("bauble_ring_emerald");
                msmpThirdArgs.add("bauble_amulet_emerald");
                msmpThirdArgs.add("bauble_glowing_ingot");
                msmpThirdArgs.add("bauble_glowing_powder");
                msmpThirdArgs.add("bauble_glowing_gem");
                msmpThirdArgs.add("bauble_dwarf_stout");
                msmpThirdArgs.add("bauble_fairy_dew");
                msmpThirdArgs.add("bauble_stone_negative_gravity");
                msmpThirdArgs.add("bauble_stone_inertia_null");
                msmpThirdArgs.add("bauble_stone_greater_inertia");
                msmpThirdArgs.add("bauble_ring_enchanted_eyes");
                msmpThirdArgs.add("bauble_stone_sea");
                msmpThirdArgs.add("bauble_stone_polarized");
                msmpThirdArgs.add("bauble_ring_fairies");
                msmpThirdArgs.add("bauble_ring_dwarves");
                msmpThirdArgs.add("bauble_ring_wither");
                msmpThirdArgs.add("bauble_shield_honor");
                msmpThirdArgs.add("bauble_ring_miners");

                msmpThirdArgs.add("warped_scroll");
                msmpThirdArgs.add("dragonsteel_fire_sword");
                msmpThirdArgs.add("dragonsteel_fire_pickaxe");
                msmpThirdArgs.add("dragonsteel_fire_axe");
                msmpThirdArgs.add("dragonsteel_fire_shovel");
                msmpThirdArgs.add("dragonsteel_fire_hoe");

                msmpThirdArgs.add("dragonsteel_ice_sword");
                msmpThirdArgs.add("dragonsteel_ice_pickaxe");
                msmpThirdArgs.add("dragonsteel_ice_axe");
                msmpThirdArgs.add("dragonsteel_ice_shovel");
                msmpThirdArgs.add("dragonsteel_ice_hoe");

                msmpThirdArgs.add("dragonsteel_lightning_sword");
                msmpThirdArgs.add("dragonsteel_lightning_pickaxe");
                msmpThirdArgs.add("dragonsteel_lightning_axe");
                msmpThirdArgs.add("dragonsteel_lightning_shovel");
                msmpThirdArgs.add("dragonsteel_lightning_hoe");

                msmpThirdArgs.add("dragonsteel_fire_helmet");
                msmpThirdArgs.add("dragonsteel_fire_chestplate");
                msmpThirdArgs.add("dragonsteel_fire_leggings");
                msmpThirdArgs.add("dragonsteel_fire_boots");

                msmpThirdArgs.add("dragonsteel_ice_helmet");
                msmpThirdArgs.add("dragonsteel_ice_chestplate");
                msmpThirdArgs.add("dragonsteel_ice_leggings");
                msmpThirdArgs.add("dragonsteel_ice_boots");

                msmpThirdArgs.add("dragonsteel_lightning_helmet");
                msmpThirdArgs.add("dragonsteel_lightning_chestplate");
                msmpThirdArgs.add("dragonsteel_lightning_leggings");
                msmpThirdArgs.add("dragonsteel_lightning_boots");

                msmpThirdArgs.add("dragon_bone_rapier");
                msmpThirdArgs.add("dragon_bone_katana");
                msmpThirdArgs.add("dragon_bone_greatsword");
                msmpThirdArgs.add("dragon_bone_longsword");
                msmpThirdArgs.add("dragon_bone_spear");
                msmpThirdArgs.add("dragon_bone_saber");
                msmpThirdArgs.add("dragon_bone_boomerang");
                msmpThirdArgs.add("dragon_bone_dagger");
                msmpThirdArgs.add("dragon_bone_glaive");
                msmpThirdArgs.add("dragon_bone_halberd");
                msmpThirdArgs.add("dragon_bone_hammer");
                msmpThirdArgs.add("dragon_bone_javelin");
                msmpThirdArgs.add("dragon_bone_lance");
                msmpThirdArgs.add("dragon_bone_mace");
                msmpThirdArgs.add("dragon_bone_pike");
                msmpThirdArgs.add("dragon_bone_quarterstaff");
                msmpThirdArgs.add("dragon_bone_throwing_axe");
                msmpThirdArgs.add("dragon_bone_throwing_knife");
                msmpThirdArgs.add("dragon_bone_warhammer");
                msmpThirdArgs.add("dragon_bone_battleaxe");
                msmpThirdArgs.add("dragon_bone_longbow");
                msmpThirdArgs.add("dragon_bone_crossbow");

                msmpThirdArgs.add("dragon_bone_flamed_rapier");
                msmpThirdArgs.add("dragon_bone_flamed_katana");
                msmpThirdArgs.add("dragon_bone_flamed_greatsword");
                msmpThirdArgs.add("dragon_bone_flamed_longsword");
                msmpThirdArgs.add("dragon_bone_flamed_spear");
                msmpThirdArgs.add("dragon_bone_flamed_saber");
                msmpThirdArgs.add("dragon_bone_flamed_boomerang");
                msmpThirdArgs.add("dragon_bone_flamed_dagger");
                msmpThirdArgs.add("dragon_bone_flamed_glaive");
                msmpThirdArgs.add("dragon_bone_flamed_halberd");
                msmpThirdArgs.add("dragon_bone_flamed_hammer");
                msmpThirdArgs.add("dragon_bone_flamed_javelin");
                msmpThirdArgs.add("dragon_bone_flamed_lance");
                msmpThirdArgs.add("dragon_bone_flamed_mace");
                msmpThirdArgs.add("dragon_bone_flamed_pike");
                msmpThirdArgs.add("dragon_bone_flamed_quarterstaff");
                msmpThirdArgs.add("dragon_bone_flamed_throwing_axe");
                msmpThirdArgs.add("dragon_bone_flamed_throwing_knife");
                msmpThirdArgs.add("dragon_bone_flamed_warhammer");
                msmpThirdArgs.add("dragon_bone_flamed_battleaxe");
                msmpThirdArgs.add("dragon_bone_flamed_longbow");
                msmpThirdArgs.add("dragon_bone_flamed_crossbow");

                msmpThirdArgs.add("dragon_bone_iced_rapier");
                msmpThirdArgs.add("dragon_bone_iced_katana");
                msmpThirdArgs.add("dragon_bone_iced_greatsword");
                msmpThirdArgs.add("dragon_bone_iced_longsword");
                msmpThirdArgs.add("dragon_bone_iced_spear");
                msmpThirdArgs.add("dragon_bone_iced_saber");
                msmpThirdArgs.add("dragon_bone_iced_boomerang");
                msmpThirdArgs.add("dragon_bone_iced_dagger");
                msmpThirdArgs.add("dragon_bone_iced_glaive");
                msmpThirdArgs.add("dragon_bone_iced_halberd");
                msmpThirdArgs.add("dragon_bone_iced_hammer");
                msmpThirdArgs.add("dragon_bone_iced_javelin");
                msmpThirdArgs.add("dragon_bone_iced_lance");
                msmpThirdArgs.add("dragon_bone_iced_mace");
                msmpThirdArgs.add("dragon_bone_iced_pike");
                msmpThirdArgs.add("dragon_bone_iced_quarterstaff");
                msmpThirdArgs.add("dragon_bone_iced_throwing_axe");
                msmpThirdArgs.add("dragon_bone_iced_throwing_knife");
                msmpThirdArgs.add("dragon_bone_iced_warhammer");
                msmpThirdArgs.add("dragon_bone_iced_battleaxe");
                msmpThirdArgs.add("dragon_bone_iced_longbow");
                msmpThirdArgs.add("dragon_bone_iced_crossbow");

                msmpThirdArgs.add("dragon_bone_lightning_rapier");
                msmpThirdArgs.add("dragon_bone_lightning_katana");
                msmpThirdArgs.add("dragon_bone_lightning_greatsword");
                msmpThirdArgs.add("dragon_bone_lightning_longsword");
                msmpThirdArgs.add("dragon_bone_lightning_spear");
                msmpThirdArgs.add("dragon_bone_lightning_saber");
                msmpThirdArgs.add("dragon_bone_lightning_boomerang");
                msmpThirdArgs.add("dragon_bone_lightning_dagger");
                msmpThirdArgs.add("dragon_bone_lightning_glaive");
                msmpThirdArgs.add("dragon_bone_lightning_halberd");
                msmpThirdArgs.add("dragon_bone_lightning_hammer");
                msmpThirdArgs.add("dragon_bone_lightning_javelin");
                msmpThirdArgs.add("dragon_bone_lightning_lance");
                msmpThirdArgs.add("dragon_bone_lightning_mace");
                msmpThirdArgs.add("dragon_bone_lightning_pike");
                msmpThirdArgs.add("dragon_bone_lightning_quarterstaff");
                msmpThirdArgs.add("dragon_bone_lightning_throwing_axe");
                msmpThirdArgs.add("dragon_bone_lightning_throwing_knife");
                msmpThirdArgs.add("dragon_bone_lightning_warhammer");
                msmpThirdArgs.add("dragon_bone_lightning_battleaxe");
                msmpThirdArgs.add("dragon_bone_lightning_longbow");
                msmpThirdArgs.add("dragon_bone_lightning_crossbow");

                msmpThirdArgs.add("dragonsteel_fire_rapier");
                msmpThirdArgs.add("dragonsteel_fire_katana");
                msmpThirdArgs.add("dragonsteel_fire_greatsword");
                msmpThirdArgs.add("dragonsteel_fire_longsword");
                msmpThirdArgs.add("dragonsteel_fire_spear");
                msmpThirdArgs.add("dragonsteel_fire_saber");
                msmpThirdArgs.add("dragonsteel_fire_boomerang");
                msmpThirdArgs.add("dragonsteel_fire_dagger");
                msmpThirdArgs.add("dragonsteel_fire_glaive");
                msmpThirdArgs.add("dragonsteel_fire_halberd");
                msmpThirdArgs.add("dragonsteel_fire_hammer");
                msmpThirdArgs.add("dragonsteel_fire_javelin");
                msmpThirdArgs.add("dragonsteel_fire_lance");
                msmpThirdArgs.add("dragonsteel_fire_mace");
                msmpThirdArgs.add("dragonsteel_fire_pike");
                msmpThirdArgs.add("dragonsteel_fire_quarterstaff");
                msmpThirdArgs.add("dragonsteel_fire_throwing_axe");
                msmpThirdArgs.add("dragonsteel_fire_throwing_knife");
                msmpThirdArgs.add("dragonsteel_fire_warhammer");
                msmpThirdArgs.add("dragonsteel_fire_battleaxe");
                msmpThirdArgs.add("dragonsteel_fire_longbow");
                msmpThirdArgs.add("dragonsteel_fire_crossbow");

                msmpThirdArgs.add("dragonsteel_ice_rapier");
                msmpThirdArgs.add("dragonsteel_ice_katana");
                msmpThirdArgs.add("dragonsteel_ice_greatsword");
                msmpThirdArgs.add("dragonsteel_ice_longsword");
                msmpThirdArgs.add("dragonsteel_ice_spear");
                msmpThirdArgs.add("dragonsteel_ice_saber");
                msmpThirdArgs.add("dragonsteel_ice_boomerang");
                msmpThirdArgs.add("dragonsteel_ice_dagger");
                msmpThirdArgs.add("dragonsteel_ice_glaive");
                msmpThirdArgs.add("dragonsteel_ice_halberd");
                msmpThirdArgs.add("dragonsteel_ice_hammer");
                msmpThirdArgs.add("dragonsteel_ice_javelin");
                msmpThirdArgs.add("dragonsteel_ice_lance");
                msmpThirdArgs.add("dragonsteel_ice_mace");
                msmpThirdArgs.add("dragonsteel_ice_pike");
                msmpThirdArgs.add("dragonsteel_ice_quarterstaff");
                msmpThirdArgs.add("dragonsteel_ice_throwing_axe");
                msmpThirdArgs.add("dragonsteel_ice_throwing_knife");
                msmpThirdArgs.add("dragonsteel_ice_warhammer");
                msmpThirdArgs.add("dragonsteel_ice_battleaxe");
                msmpThirdArgs.add("dragonsteel_ice_longbow");
                msmpThirdArgs.add("dragonsteel_ice_crossbow");

                msmpThirdArgs.add("dragonsteel_lightning_rapier");
                msmpThirdArgs.add("dragonsteel_lightning_katana");
                msmpThirdArgs.add("dragonsteel_lightning_greatsword");
                msmpThirdArgs.add("dragonsteel_lightning_longsword");
                msmpThirdArgs.add("dragonsteel_lightning_spear");
                msmpThirdArgs.add("dragonsteel_lightning_saber");
                msmpThirdArgs.add("dragonsteel_lightning_boomerang");
                msmpThirdArgs.add("dragonsteel_lightning_dagger");
                msmpThirdArgs.add("dragonsteel_lightning_glaive");
                msmpThirdArgs.add("dragonsteel_lightning_halberd");
                msmpThirdArgs.add("dragonsteel_lightning_hammer");
                msmpThirdArgs.add("dragonsteel_lightning_javelin");
                msmpThirdArgs.add("dragonsteel_lightning_lance");
                msmpThirdArgs.add("dragonsteel_lightning_mace");
                msmpThirdArgs.add("dragonsteel_lightning_pike");
                msmpThirdArgs.add("dragonsteel_lightning_quarterstaff");
                msmpThirdArgs.add("dragonsteel_lightning_throwing_axe");
                msmpThirdArgs.add("dragonsteel_lightning_throwing_knife");
                msmpThirdArgs.add("dragonsteel_lightning_warhammer");
                msmpThirdArgs.add("dragonsteel_lightning_battleaxe");
                msmpThirdArgs.add("dragonsteel_lightning_longbow");
                msmpThirdArgs.add("dragonsteel_lightning_crossbow");

                msmpThirdArgs.add("bauble_crown_golden");
                msmpThirdArgs.add("bauble_sunglasses");
                msmpThirdArgs.add("bauble_broken_heart");
                msmpThirdArgs.add("dragonsteel_fire_block");
                msmpThirdArgs.add("dragonsteel_ice_block");
                msmpThirdArgs.add("dragonsteel_lightning_block");

            }

            List<String> msmpResult = new ArrayList<String>();
            if (args.length == 1) {
                for (String a : msmpFirstArgs) {
                    if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                        msmpResult.add(a);
                }
                return msmpResult;
            }
            else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("give")) {
                    for (String a : msmpSecondArgs) {
                        if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                            msmpResult.add(a);
                    }
                }
                return msmpResult;
            }
            else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("give")) {
                    for (String a : msmpThirdArgs) {
                        if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                            msmpResult.add(a);
                    }
                }
                return msmpResult;
            }
            else if (args.length > 3) {
                return msmpResult;
            }
            return null;
        }
        return null;
    }
}
