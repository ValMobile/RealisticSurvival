package me.val_mobile.minorities_smp_extras;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Commands implements CommandExecutor {

    private final Main plugin;
    private final Items citem;
    private final Utils util = new Utils();

    public Commands(Main instance) {
        plugin = instance;
        citem = new Items(instance);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("minoritiessmp") || label.equalsIgnoreCase("msmp")
        || label.equalsIgnoreCase("smp")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                return true;
            }
            if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("give")) {
                        if (sender instanceof Player) {
                            Player player = (Player) sender;
                            if (args[1].isEmpty()) {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                                return true;
                            }
                            switch (args[1].toLowerCase()) {
                                case "dragon_scale_amethyst":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleAmethyst());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleAmethyst());
                                    return true;
                                case "dragon_scale_boots_amethyst":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsAmethyst());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsAmethyst());
                                    return true;
                                case "dragon_scale_chestplate_amethyst":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateAmethyst());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateAmethyst());
                                    return true;
                                case "dragon_scale_helmet_amethyst":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetAmethyst());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetAmethyst());
                                    return true;
                                case "dragon_scale_leggings_amethyst":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsAmethyst());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsAmethyst());
                                    return true;
                                case "dragon_scale_black":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBlack());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBlack());
                                    return true;
                                case "dragon_scale_boots_black":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsBlack());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsBlack());
                                    return true;
                                case "dragon_scale_chestplate_black":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateBlack());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateBlack());
                                    return true;
                                case "dragon_scale_helmet_black":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetBlack());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetBlack());
                                    return true;
                                case "dragon_scale_leggings_black":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsBlack());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsBlack());
                                    return true;
                                case "dragon_scale_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBlue());
                                    return true;
                                case "dragon_scale_boots_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsBlue());
                                    return true;
                                case "dragon_scale_chestplate_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateBlue());
                                    return true;
                                case "dragon_scale_helmet_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetBlue());
                                    return true;
                                case "dragon_scale_leggings_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsBlue());
                                    return true;
                                case "sea_serpent_scale_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScaleBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScaleBlue());
                                    return true;
                                case "tide_guardian_boots_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsBlue());
                                    return true;
                                case "tide_guardian_chestplate_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplateBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplateBlue());
                                    return true;
                                case "tide_guardian_helmet_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetBlue());
                                    return true;
                                case "tide_guardian_leggings_blue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsBlue());
                                    return true;
                                case "dragon_scale_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBronze());
                                    return true;
                                case "dragon_scale_boots_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsBronze());
                                    return true;
                                case "dragon_scale_chestplate_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateBronze());
                                    return true;
                                case "dragon_scale_helmet_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetBronze());
                                    return true;
                                case "dragon_scale_leggings_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsBronze());
                                    return true;
                                case "sea_serpent_scale_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScaleBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScaleBronze());
                                    return true;
                                case "tide_guardian_boots_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsBronze());
                                    return true;
                                case "tide_guardian_chestplate_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplateBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplateBronze());
                                    return true;
                                case "tide_guardian_helmet_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetBronze());
                                    return true;
                                case "tide_guardian_leggings_bronze":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsBronze());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsBronze());
                                    return true;
                                case "dragon_scale_copper":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleCopper());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleCopper());
                                    return true;
                                case "dragon_scale_boots_copper":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsCopper());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsCopper());
                                    return true;
                                case "dragon_scale_chestplate_copper":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateCopper());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateCopper());
                                    return true;
                                case "dragon_scale_helmet_copper":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetCopper());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetCopper());
                                    return true;
                                case "dragon_scale_leggings_copper":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsCopper());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsCopper());
                                    return true;
                                case "sea_serpent_scale_deepblue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScaleDeepBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScaleDeepBlue());
                                    return true;
                                case "tide_guardian_boots_deepblue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsDeepBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsDeepBlue());
                                    return true;
                                case "tide_guardian_chestplate_deepblue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplateDeepBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplateDeepBlue());
                                    return true;
                                case "tide_guardian_helmet_deepblue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetDeepBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetDeepBlue());
                                    return true;
                                case "tide_guardian_leggings_deepblue":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsDeepBlue());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsDeepBlue());
                                    return true;
                                case "dragon_bone":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBone());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBone());
                                    return true;
                                case "dragon_bone_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneAxe());
                                    return true;
                                case "dragon_bone_bow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneBow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneBow());
                                    return true;
                                case "dragon_bone_hoe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneHoe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneHoe());
                                    return true;
                                case "dragon_bone_pickaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBonePickaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBonePickaxe());
                                    return true;
                                case "dragon_bone_shovel":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneShovel());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneShovel());
                                    return true;
                                case "dragon_bone_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneSword());
                                    return true;
                                case "dragon_scale_electric":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleElectric());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleElectric());
                                    return true;
                                case "dragon_scale_boots_electric":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsElectric());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsElectric());
                                    return true;
                                case "dragon_scale_chestplate_electric":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateElectric());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateElectric());
                                    return true;
                                case "dragon_scale_helmet_electric":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetElectric());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetElectric());
                                    return true;
                                case "dragon_scale_leggings_electric":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsElectric());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsElectric());
                                    return true;
                                case "fire_dragon_blood":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonBlood());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonBlood());
                                    return true;
                                case "fire_dragon_heart":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonHeart());
                                    return true;
                                case "fire_dragon_flesh":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonFlesh());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonFlesh());
                                    return true;
                                case "fire_dragonsteel_ingot":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelIngot());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelIngot());
                                    return true;
                                case "flamed_dragon_bone_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneSword());
                                    return true;
                                case "dragon_scale_gray":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleGray());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleGray());
                                    return true;
                                case "dragon_scale_boots_gray":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsGray());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsGray());
                                    return true;
                                case "dragon_scale_chestplate_gray":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateGray());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateGray());
                                    return true;
                                case "dragon_scale_helmet_gray":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetGray());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetElectric());
                                    return true;
                                case "dragon_scale_leggings_gray":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsGray());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsGray());
                                    return true;
                                case "dragon_scale_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleGreen());
                                    return true;
                                case "dragon_scale_boots_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsGreen());
                                    return true;
                                case "dragon_scale_chestplate_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateGreen());
                                    return true;
                                case "dragon_scale_helmet_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetElectric());
                                    return true;
                                case "dragon_scale_leggings_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsGreen());
                                    return true;
                                case "sea_serpent_scale_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScaleGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScaleGreen());
                                    return true;
                                case "tide_guardian_boots_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsGreen());
                                    return true;
                                case "tide_guardian_chestplate_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplateGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplateGreen());
                                    return true;
                                case "tide_guardian_helmet_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetGreen());
                                    return true;
                                case "tide_guardian_leggings_green":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsGreen());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsGreen());
                                    return true;
                                case "ice_dragon_blood":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonBlood());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonBlood());
                                    return true;
                                case "ice_dragon_heart":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonHeart());
                                    return true;
                                case "ice_dragon_flesh":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonFlesh());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonFlesh());
                                    return true;
                                case "ice_dragon_bone_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonBoneSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonBoneSword());
                                    return true;
                                case "ice_dragonsteel_ingot":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelIngot());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelIngot());
                                    return true;
                                case "lightning_dragon_blood":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBlood());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBlood());
                                    return true;
                                case "lightning_dragon_heart":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonHeart());
                                    return true;
                                case "lightning_dragon_flesh":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonFlesh());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonFlesh());
                                    return true;
                                case "lightning_dragon_bone_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneSword());
                                    return true;
                                case "lightning_dragonsteel_ingot":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelIngot());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelIngot());
                                    return true;
                                case "sea_serpent_scale_purple":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScalePurple());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScalePurple());
                                    return true;
                                case "tide_guardian_boots_purple":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsPurple());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsPurple());
                                    return true;
                                case "tide_guardian_chestplate_purple":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplatePurple());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplatePurple());
                                    return true;
                                case "tide_guardian_helmet_purple":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetPurple());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetPurple());
                                    return true;
                                case "tide_guardian_leggings_purple":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsPurple());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsPurple());
                                    return true;
                                case "dragon_scale_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleRed());
                                    return true;
                                case "dragon_scale_boots_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsRed());
                                    return true;
                                case "dragon_scale_chestplate_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateRed());
                                    return true;
                                case "dragon_scale_helmet_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetRed());
                                    return true;
                                case "dragon_scale_leggings_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsRed());
                                    return true;
                                case "sea_serpent_scale_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScaleRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScaleRed());
                                    return true;
                                case "tide_guardian_boots_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsRed());
                                    return true;
                                case "tide_guardian_chestplate_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplateRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplateRed());
                                    return true;
                                case "tide_guardian_helmet_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetRed());
                                    return true;
                                case "tide_guardian_leggings_red":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsRed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsRed());
                                    return true;
                                case "dragon_scale_sapphire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleSapphire());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleSapphire());
                                    return true;
                                case "dragon_scale_boots_sapphire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsSapphire());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsSapphire());
                                    return true;
                                case "dragon_scale_chestplate_sapphire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateSapphire());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateSapphire());
                                    return true;
                                case "dragon_scale_helmet_sapphire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetSapphire());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetSapphire());
                                    return true;
                                case "dragon_scale_leggings_sapphire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsSapphire());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsSapphire());
                                    return true;
                                case "shiny_scale":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getShinyScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getShinyScale());
                                    return true;
                                case "dragon_scale_silver":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleSilver());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleSilver());
                                    return true;
                                case "dragon_scale_boots_silver":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsSilver());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsSilver());
                                    return true;
                                case "dragon_scale_chestplate_silver":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateSilver());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateSilver());
                                    return true;
                                case "dragon_scale_helmet_silver":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetSilver());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetSilver());
                                    return true;
                                case "dragon_scale_leggings_silver":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsSilver());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsSilver());
                                    return true;
                                case "sea_serpent_scale_teal":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSeaSerpentScaleTeal());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSeaSerpentScaleTeal());
                                    return true;
                                case "tide_guardian_boots_teal":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianBootsTeal());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianBootsTeal());
                                    return true;
                                case "tide_guardian_chestplate_teal":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianChestplateTeal());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianChestplateTeal());
                                    return true;
                                case "tide_guardian_helmet_teal":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianHelmetTeal());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianHelmetTeal());
                                    return true;
                                case "tide_guardian_leggings_teal":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getTideGuardianLeggingsTeal());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getTideGuardianLeggingsTeal());
                                    return true;
                                case "dragon_scale_white":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleWhite());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleWhite());
                                    return true;
                                case "dragon_scale_boots_white":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleBootsWhite());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleBootsWhite());
                                    return true;
                                case "dragon_scale_chestplate_white":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleChestplateWhite());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleChestplateWhite());
                                    return true;
                                case "dragon_scale_helmet_white":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleHelmetWhite());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleHelmetWhite());
                                    return true;
                                case "dragon_scale_leggings_white":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonScaleLeggingsWhite());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonScaleLeggingsWhite());
                                    return true;
                                case "witherbone":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getWitherbone());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getWitherbone());
                                    return true;
                                case "bauble_potion_ring_resistance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRingResistance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRingResistance());
                                    return true;
                                case "bauble_potion_ring_regeneration":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRingRegeneration());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRingRegeneration());
                                    return true;
                                case "bauble_potion_ring_strength":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRingStrength());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRingStrength());
                                    return true;
                                case "bauble_potion_ring_speed":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRingSpeed());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRingSpeed());
                                    return true;
                                case "bauble_potion_ring_haste":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRingHaste());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRingHaste());
                                    return true;
                                case "bauble_potion_ring_jump_boost":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRingJumpBoost());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRingJumpBoost());
                                    return true;
                                case "bauble_poison_stone":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPoisonStone());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPoisonStone());
                                    return true;
                                case "bauble_ender_queens_crown":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getEnderQueensCrown());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getEnderQueensCrown());
                                    return true;
                                case "bauble_dragons_eye":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonsEye());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonsEye());
                                    return true;
                                case "dragonskull":
                                    Random r = new Random();
                                    int dragonType = (int) Math.round(r.nextDouble() * 9);
                                    String dragon;
                                    if (dragonType <= plugin.getConfig().getDouble("dragons.recursiveDropRates.fireDragonRate") * 10 - 1) {
                                        dragon = "Fire";
                                    }
                                    else if (dragonType >= plugin.getConfig().getDouble("dragons.recursiveDropRates.fireDragonRate") * 10 &&
                                            dragonType <= ((plugin.getConfig().getDouble("dragons.recursiveDropRates.fireDragonRate") + plugin.getConfig().getDouble("dragons.recursiveDropRates.iceDragonRate")) * 10) - 1) {
                                        dragon = "Ice";
                                    }
                                    else {
                                        dragon = "Lightning";
                                    }
                                    int stage = (int) Math.round(r.nextDouble() * 2) + 3;

                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, util.addDragonSkullLore(citem.getDragonSkull(), stage, dragon));
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), util.addDragonSkullLore(citem.getDragonSkull(), stage, dragon));
                                    return true;
                                case "battle_burrito":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getBattleBurrito());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getBattleBurrito());
                                    return true;
                                case "bauble_ankh_charm":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getAnkhCharm());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getAnkhCharm());
                                    return true;
                                case "bauble_ankh_shield":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getAnkhShield());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getAnkhShield());
                                    return true;
                                case "bauble_balloon":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getBalloon());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getBalloon());
                                    return true;
                                case "bauble_bezoar":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getBezoar());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getBezoar());
                                    return true;
                                case "bauble_black_dragon_scale":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getBlackDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getBlackDragonScale());
                                    return true;
                                case "bauble_cobalt_shield":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getCobaltShield());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getCobaltShield());
                                    return true;
                                case "bauble_cracked_black_dragon_scale":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getCrackedBlackDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getCrackedBlackDragonScale());
                                    return true;
                                case "bauble_ender_dragon_scale":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getEnderDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getEnderDragonScale());
                                    return true;
                                case "bauble_forbidden_fruit":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getForbiddenFruit());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getForbiddenFruit());
                                    return true;
                                case "bauble_iron_ring":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIronRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIronRing());
                                    return true;
                                case "bauble_lucky_horseshoe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLuckyHorseshoe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLuckyHorseshoe());
                                    return true;
                                case "bauble_magic_mirror":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getMagicMirror());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getMagicMirror());
                                    return true;
                                case "bauble_mixed_color_dragon_scale":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getMixedColorDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getMixedColorDragonScale());
                                    return true;
                                case "bauble_obsidian_shield":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getObsidianShield());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getObsidianShield());
                                    return true;
                                case "bauble_obsidian_skull":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getObsidianSkull());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getObsidianSkull());
                                    return true;
                                case "bauble_ring_free_action":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getRingofFreeAction());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getRingofFreeAction());
                                    return true;
                                case "bauble_ring_overclocking":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getRingofOverclocking());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getRingofOverclocking());
                                    return true;
                                case "bauble_shulker_heart":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getShulkerHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getShulkerHeart());
                                    return true;
                                case "bauble_vitamins":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getVitamins());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getVitamins());
                                    return true;
                                case "bauble_wormhole_mirror":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getWormholeMirror());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getWormholeMirror());
                                    return true;
                                case "flint_shard":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlintShard());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlintShard());
                                    return true;
                                case "flint_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlintAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlintAxe());
                                    return true;
                                case "flint_pickaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlintPickaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlintPickaxe());
                                    return true;
                                case "flint_shovel":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlintShovel());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlintShovel());
                                    return true;
                                case "flint_hoe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlintHoe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlintHoe());
                                    return true;
                                case "flint_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlintKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlintKnife());
                                    return true;
                                case "plant_fiber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPlantFiber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPlantFiber());
                                    return true;
                                case "plant_string":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPlantString());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPlantString());
                                    return true;
                                case "bauble_scarlite_ring":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getScarliteRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getScarliteRing());
                                    return true;
                                case "bauble_spectral_silt":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSpectralSilt());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSpectralSilt());
                                    return true;
                                case "bauble_disintegration_tablet":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDisintegrationTablet());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDisintegrationTablet());
                                    return true;
                                case "bauble_cross_necklace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getCrossNecklace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getCrossNecklace());
                                    return true;
                                case "bauble_wrath_pendant":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getWrathPendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getWrathPendant());
                                    return true;
                                case "bauble_pride_pendant":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPridePendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPridePendant());
                                    return true;
                                case "bauble_gluttony_pendant":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getGluttonyPendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getGluttonyPendant());
                                    return true;
                                case "bauble_sin_pendant":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSinPendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSinPendant());
                                    return true;
                                case "bauble_flare_gun":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlareGun());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlareGun());
                                    return true;
                                case "bauble_flare":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlare());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlare());
                                    return true;
                                case "bauble_phytoprostasia_amulet":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPhytoprostasiaAmulet());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPhytoprostasiaAmulet());
                                    return true;
                                case "bauble_potion_ring":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPotionRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPotionRing());
                                    return true;
                                case "bauble_emerald_ring":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getEmeraldRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getEmeraldRing());
                                    return true;
                                case "bauble_emerald_amulet":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getEmeraldAmulet());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getEmeraldAmulet());
                                    return true;
                                case "bauble_glowing_ingot":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getGlowingIngot());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getGlowingIngot());
                                    return true;
                                case "bauble_glowing_powder":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getGlowingPowder());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getGlowingPowder());
                                    return true;
                                case "bauble_glowing_gem":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getGlowingGem());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getGlowingGem());
                                    return true;
                                case "bauble_dwarf_stout":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDwarfStout());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDwarfStout());
                                    return true;
                                case "bauble_fairy_dew":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFairyDew());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFairyDew());
                                    return true;
                                case "bauble_stone_negative_gravity":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getStoneNegativeGravity());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getStoneNegativeGravity());
                                    return true;
                                case "bauble_stone_inertia_null":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getStoneInertiaNull());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getStoneInertiaNull());
                                    return true;
                                case "bauble_stone_greater_inertia":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getStoneGreaterInertia());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getStoneGreaterInertia());
                                    return true;
                                case "bauble_ring_enchanted_eyes":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getRingEnchantedEyes());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getRingEnchantedEyes());
                                    return true;
                                case "bauble_stone_sea":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getStoneSea());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getStoneSea());
                                    return true;
                                case "bauble_polarized_stone":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPolarizedStone());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPolarizedStone());
                                    return true;
                                case "bauble_ring_fairies":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getRingFairies());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getRingFairies());
                                    return true;
                                case "bauble_ring_dwarves":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getRingDwarves());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getRingDwarves());
                                    return true;
                                case "bauble_wither_ring":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getWitherRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getWitherRing());
                                    return true;
                                case "bauble_shield_honor":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getShieldHonor());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getShieldHonor());
                                    return true;
                                case "bauble_miners_ring":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getMinersRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getMinersRing());
                                    return true;
                            }
                            return true;
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cConsole cannot use commands!"));
                        return true;
                    }
                    else if (args[0].toLowerCase().equals("reload")) {
                        if (sender instanceof Player) {
                            Player player = (Player) sender;
                            if (player.hasPermission("msmp.use") || player.isOp()) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("reload")));
                                plugin.reloadConfig();
                                return true;
                            }
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nopermission")));
                            return true;
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("reload")));
                        plugin.reloadConfig();
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
}
