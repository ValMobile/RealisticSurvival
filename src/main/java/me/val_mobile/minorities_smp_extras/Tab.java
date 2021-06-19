package me.val_mobile.minorities_smp_extras;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Tab implements TabCompleter
{
    List<String> msmpFirstArgs = new ArrayList<String>();
    List<String> msmpSecondArgs = new ArrayList<String>();

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (label.toLowerCase().equals("msmp") || label.toLowerCase().equals("minoritiessmp") || label.toLowerCase().equals("smp"))
        {
            if (msmpFirstArgs.isEmpty())
            {
                msmpFirstArgs.add("give");
            }
            if (msmpSecondArgs.isEmpty())
            {
                msmpSecondArgs.add("dragon_scale_amethyst");
                msmpSecondArgs.add("dragon_scale_boots_amethyst");
                msmpSecondArgs.add("dragon_scale_chestplate_amethyst");
                msmpSecondArgs.add("dragon_scale_helmet_amethyst");
                msmpSecondArgs.add("dragon_scale_leggings_amethyst");

                msmpSecondArgs.add("dragon_scale_black");
                msmpSecondArgs.add("dragon_scale_boots_black");
                msmpSecondArgs.add("dragon_scale_chestplate_black");
                msmpSecondArgs.add("dragon_scale_helmet_black");
                msmpSecondArgs.add("dragon_scale_leggings_black");

                msmpSecondArgs.add("dragon_scale_blue");
                msmpSecondArgs.add("dragon_scale_boots_blue");
                msmpSecondArgs.add("dragon_scale_chestplate_blue");
                msmpSecondArgs.add("dragon_scale_helmet_blue");
                msmpSecondArgs.add("dragon_scale_leggings_blue");

                msmpSecondArgs.add("sea_serpent_scale_blue");
                msmpSecondArgs.add("tide_guardian_boots_blue");
                msmpSecondArgs.add("tide_guardian_chestplate_blue");
                msmpSecondArgs.add("tide_guardian_helmet_blue");
                msmpSecondArgs.add("tide_guardian_leggings_blue");

                msmpSecondArgs.add("dragon_scale_bronze");
                msmpSecondArgs.add("dragon_scale_boots_bronze");
                msmpSecondArgs.add("dragon_scale_chestplate_bronze");
                msmpSecondArgs.add("dragon_scale_helmet_bronze");
                msmpSecondArgs.add("dragon_scale_leggings_bronze");

                msmpSecondArgs.add("sea_serpent_scale_bronze");
                msmpSecondArgs.add("tide_guardian_boots_bronze");
                msmpSecondArgs.add("tide_guardian_chestplate_bronze");
                msmpSecondArgs.add("tide_guardian_helmet_bronze");
                msmpSecondArgs.add("tide_guardian_leggings_bronze");

                msmpSecondArgs.add("dragon_scale_copper");
                msmpSecondArgs.add("dragon_scale_boots_copper");
                msmpSecondArgs.add("dragon_scale_chestplate_copper");
                msmpSecondArgs.add("dragon_scale_helmet_copper");
                msmpSecondArgs.add("dragon_scale_leggings_copper");

                msmpSecondArgs.add("sea_serpent_scale_deepblue");
                msmpSecondArgs.add("tide_guardian_boots_deepblue");
                msmpSecondArgs.add("tide_guardian_chestplate_deepblue");
                msmpSecondArgs.add("tide_guardian_helmet_deepblue");
                msmpSecondArgs.add("tide_guardian_leggings_deepblue");

                msmpSecondArgs.add("dragon_bone");
                msmpSecondArgs.add("dragon_bone_axe");
                msmpSecondArgs.add("dragon_bone_bow");
                msmpSecondArgs.add("dragon_bone_hoe");
                msmpSecondArgs.add("dragon_bone_pickaxe");
                msmpSecondArgs.add("dragon_bone_shovel");
                msmpSecondArgs.add("dragon_bone_sword");

                msmpSecondArgs.add("dragon_scale_electric");
                msmpSecondArgs.add("dragon_scale_boots_electric");
                msmpSecondArgs.add("dragon_scale_chestplate_electric");
                msmpSecondArgs.add("dragon_scale_helmet_electric");
                msmpSecondArgs.add("dragon_scale_leggings_electric");

                msmpSecondArgs.add("fire_dragon_blood");
                msmpSecondArgs.add("fire_dragon_heart");
                msmpSecondArgs.add("fire_dragon_flesh");
                msmpSecondArgs.add("fire_dragonsteel_ingot");
                msmpSecondArgs.add("flamed_dragon_bone_sword");

                msmpSecondArgs.add("dragon_scale_gray");
                msmpSecondArgs.add("dragon_scale_boots_gray");
                msmpSecondArgs.add("dragon_scale_chestplate_gray");
                msmpSecondArgs.add("dragon_scale_helmet_gray");
                msmpSecondArgs.add("dragon_scale_leggings_gray");

                msmpSecondArgs.add("dragon_scale_green");
                msmpSecondArgs.add("dragon_scale_boots_green");
                msmpSecondArgs.add("dragon_scale_chestplate_green");
                msmpSecondArgs.add("dragon_scale_helmet_green");
                msmpSecondArgs.add("dragon_scale_leggings_green");

                msmpSecondArgs.add("sea_serpent_scale_green");
                msmpSecondArgs.add("tide_guardian_boots_green");
                msmpSecondArgs.add("tide_guardian_chestplate_green");
                msmpSecondArgs.add("tide_guardian_helmet_green");
                msmpSecondArgs.add("tide_guardian_leggings_green");

                msmpSecondArgs.add("ice_dragon_blood");
                msmpSecondArgs.add("ice_dragon_heart");
                msmpSecondArgs.add("ice_dragon_flesh");
                msmpSecondArgs.add("ice_dragon_bone_sword");
                msmpSecondArgs.add("ice_dragonsteel_ingot");

                msmpSecondArgs.add("lightning_dragon_blood");
                msmpSecondArgs.add("lightning_dragon_heart");
                msmpSecondArgs.add("lightning_dragon_meat");
                msmpSecondArgs.add("lightning_dragon_bone_sword");
                msmpSecondArgs.add("lightning_dragonsteel_ingot");

                msmpSecondArgs.add("sea_serpent_scale_purple");
                msmpSecondArgs.add("tide_guardian_boots_purple");
                msmpSecondArgs.add("tide_guardian_chestplate_purple");
                msmpSecondArgs.add("tide_guardian_helmet_purple");
                msmpSecondArgs.add("tide_guardian_leggings_purple");

                msmpSecondArgs.add("dragon_scale_red");
                msmpSecondArgs.add("dragon_scale_boots_red");
                msmpSecondArgs.add("dragon_scale_chestplate_red");
                msmpSecondArgs.add("dragon_scale_helmet_red");
                msmpSecondArgs.add("dragon_scale_leggings_red");

                msmpSecondArgs.add("sea_serpent_scale_red");
                msmpSecondArgs.add("tide_guardian_boots_red");
                msmpSecondArgs.add("tide_guardian_chestplate_red");
                msmpSecondArgs.add("tide_guardian_helmet_red");
                msmpSecondArgs.add("tide_guardian_leggings_red");

                msmpSecondArgs.add("dragon_scale_sapphire");
                msmpSecondArgs.add("dragon_scale_boots_sapphire");
                msmpSecondArgs.add("dragon_scale_chestplate_sapphire");
                msmpSecondArgs.add("dragon_scale_helmet_sapphire");
                msmpSecondArgs.add("dragon_scale_leggings_sapphire");

                msmpSecondArgs.add("shiny_scale");

                msmpSecondArgs.add("dragon_scale_silver");
                msmpSecondArgs.add("dragon_scale_boots_silver");
                msmpSecondArgs.add("dragon_scale_chestplate_silver");
                msmpSecondArgs.add("dragon_scale_helmet_silver");
                msmpSecondArgs.add("dragon_scale_leggings_silver");

                msmpSecondArgs.add("sea_serpent_scale_teal");
                msmpSecondArgs.add("tide_guardian_boots_teal");
                msmpSecondArgs.add("tide_guardian_chestplate_teal");
                msmpSecondArgs.add("tide_guardian_helmet_teal");
                msmpSecondArgs.add("tide_guardian_leggings_teal");

                msmpSecondArgs.add("dragon_scale_white");
                msmpSecondArgs.add("dragon_scale_boots_white");
                msmpSecondArgs.add("dragon_scale_chestplate_white");
                msmpSecondArgs.add("dragon_scale_helmet_white");
                msmpSecondArgs.add("dragon_scale_leggings_white");

                msmpSecondArgs.add("witherbone");

                msmpSecondArgs.add("bauble_potion_ring_resistance");
                msmpSecondArgs.add("bauble_potion_ring_regeneration");
                msmpSecondArgs.add("bauble_potion_ring_strength");
                msmpSecondArgs.add("bauble_potion_ring_haste");
                msmpSecondArgs.add("bauble_potion_ring_speed");
                msmpSecondArgs.add("bauble_potion_ring_jump_boost");
                msmpSecondArgs.add("bauble_dragons_eye");
                msmpSecondArgs.add("dragonskull");
                msmpSecondArgs.add("bauble_ender_queens_crown");
                msmpSecondArgs.add("bauble_poison_stone");
                msmpSecondArgs.add("battle_burrito");
                msmpSecondArgs.add("bauble_ankh_charm");
                msmpSecondArgs.add("bauble_ankh_shield");
                msmpSecondArgs.add("bauble_balloon");
                msmpSecondArgs.add("bauble_bezoar");
                msmpSecondArgs.add("bauble_black_dragon_scale");
                msmpSecondArgs.add("bauble_cobalt_shield");
                msmpSecondArgs.add("bauble_cracked_black_dragon_scale");
                msmpSecondArgs.add("bauble_ender_dragon_scale");
                msmpSecondArgs.add("bauble_forbidden_fruit");
                msmpSecondArgs.add("bauble_iron_ring");
                msmpSecondArgs.add("bauble_lucky_horseshoe");
                msmpSecondArgs.add("bauble_magic_mirror");
                msmpSecondArgs.add("bauble_mixed_color_dragon_scale");
                msmpSecondArgs.add("bauble_obsidian_shield");
                msmpSecondArgs.add("bauble_obsidian_skull");
                msmpSecondArgs.add("bauble_ring_free_action");
                msmpSecondArgs.add("bauble_ring_overclocking");
                msmpSecondArgs.add("bauble_shulker_heart");
                msmpSecondArgs.add("bauble_vitamins");
                msmpSecondArgs.add("bauble_wormhole_mirror");

                msmpSecondArgs.add("flint_shard");
                msmpSecondArgs.add("flint_axe");
                msmpSecondArgs.add("flint_shovel");
                msmpSecondArgs.add("flint_pickaxe");
                msmpSecondArgs.add("flint_hoe");
                msmpSecondArgs.add("flint_knife");
                msmpSecondArgs.add("plant_fiber");
                msmpSecondArgs.add("plant_string");

                msmpSecondArgs.add("bauble_scarlite_ring");
                msmpSecondArgs.add("bauble_spectral_silt");
                msmpSecondArgs.add("bauble_disintegration_tablet");
                msmpSecondArgs.add("bauble_cross_necklace");
                msmpSecondArgs.add("bauble_wrath_pendant");
                msmpSecondArgs.add("bauble_pride_pendant");
                msmpSecondArgs.add("bauble_gluttony_pendant");
                msmpSecondArgs.add("bauble_sin_pendant");
                msmpSecondArgs.add("bauble_flare_gun");
                msmpSecondArgs.add("bauble_flare");
                msmpSecondArgs.add("bauble_phytoprostasia_amulet");
                msmpSecondArgs.add("bauble_potion_ring");
                msmpSecondArgs.add("bauble_emerald_ring");
                msmpSecondArgs.add("bauble_emerald_amulet");
                msmpSecondArgs.add("bauble_glowing_ingot");
                msmpSecondArgs.add("bauble_glowing_powder");
                msmpSecondArgs.add("bauble_glowing_gem");
                msmpSecondArgs.add("bauble_dwarf_stout");
                msmpSecondArgs.add("bauble_fairy_dew");
                msmpSecondArgs.add("bauble_stone_negative_gravity");
                msmpSecondArgs.add("bauble_stone_inertia_null");
                msmpSecondArgs.add("bauble_stone_greater_inertia");
                msmpSecondArgs.add("bauble_ring_enchanted_eyes");
                msmpSecondArgs.add("bauble_stone_sea");
                msmpSecondArgs.add("bauble_polarized_stone");
                msmpSecondArgs.add("bauble_ring_fairies");
                msmpSecondArgs.add("bauble_ring_dwarves");
                msmpSecondArgs.add("bauble_wither_ring");
                msmpSecondArgs.add("bauble_shield_honor");
                msmpSecondArgs.add("bauble_miners_ring");
            }


            List<String> msmpResult = new ArrayList<String>();
            if (args.length == 1)
            {
                for (String a : msmpFirstArgs)
                {
                    if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                        msmpResult.add(a);
                }
                return msmpResult;
            }
            else if (args.length == 2)
            {
                for (String a : msmpSecondArgs)
                {
                    if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                        msmpResult.add(a);
                }
                return msmpResult;
            }
            else if (args.length > 2)
            {
                return msmpResult;
            }
            return null;
        }
        return null;
    }
}
