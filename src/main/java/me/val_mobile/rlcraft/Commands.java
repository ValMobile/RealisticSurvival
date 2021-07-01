package me.val_mobile.rlcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Commands implements CommandExecutor {

    private final RLCraft plugin;
    private final Items citem;
    private final Utils util;

    public Commands(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        citem = new Items(instance);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("minoritiessmp") || label.equalsIgnoreCase("msmp")
        || label.equalsIgnoreCase("smp")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                return true;
            }
            else if (args.length > 0) {
                if (args[0].isEmpty()) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                    return true;
                }
                if (args[0].equalsIgnoreCase("give")) {
                    if (sender instanceof Player) {
                        if (! (sender.hasPermission("rlcraft.command.give") || sender.isOp())) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nopermission")));
                            return true;
                        }
                    }
                    if (args[1] == null || args[1].isEmpty()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                        return true;
                    }
                    if (args[2] == null || args[2].isEmpty()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                        return true;
                    }
                    if (!(Bukkit.getPlayer(args[1]) == null)) {
                        if (Bukkit.getPlayer(args[1]).isOnline()) {
                            Player player = Bukkit.getPlayer(args[1]);
                            switch (args[2].toLowerCase()) {
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
                                case "dragon_blood_fire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonBlood());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonBlood());
                                    return true;
                                case "dragon_heart_fire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonHeart());
                                    return true;
                                case "dragon_flesh_fire":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonFlesh());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonFlesh());
                                    return true;
                                case "dragonsteel_fire_ingot":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelIngot());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelIngot());
                                    return true;
                                case "dragon_bone_flamed_sword":
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
                                case "dragon_blood_ice":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonBlood());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonBlood());
                                    return true;
                                case "dragon_heart_ice":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonHeart());
                                    return true;
                                case "dragon_flesh_ice":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonFlesh());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonFlesh());
                                    return true;
                                case "dragon_bone_iced_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneSword());
                                    return true;
                                case "dragonsteel_ice_ingot":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelIngot());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelIngot());
                                    return true;
                                case "dragon_blood_lightning":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBlood());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBlood());
                                    return true;
                                case "dragon_heart_lightning":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonHeart());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonHeart());
                                    return true;
                                case "dragon_flesh_lightning":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonFlesh());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonFlesh());
                                    return true;
                                case "dragon_bone_lightning_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneSword());
                                    return true;
                                case "dragonsteel_lightning_ingot":
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
                                case "bauble_stone_poison":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPoisonStone());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPoisonStone());
                                    return true;
                                case "bauble_crown_ender_queens":
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
                                case "dragon_skull":
                                    Random r = new Random();
                                    String dragonType;
                                    double temp = r.nextDouble();
                                    if (temp <= plugin.getConfig().getDouble("dragons.fireDragonRate")) {
                                        dragonType = "Fire";
                                    }
                                    else if (temp > plugin.getConfig().getDouble("dragons.fireDragonRate") &&
                                            temp <= (plugin.getConfig().getDouble("dragons.fireDragonRate") + plugin.getConfig().getDouble("dragons.iceDragonRate"))) {
                                        dragonType = "Ice";
                                    }
                                    else {
                                        dragonType = "Lightning";
                                    }
                                    int stage = (int) Math.round(r.nextDouble() * 4) + 1;

                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, util.addDragonSkullLore(citem.getFireDragonSkull(), stage, dragonType));
                                            return true;
                                        }
                                    }

                                    if (dragonType.equals("Fire")) {
                                        player.getWorld().dropItemNaturally(player.getLocation(), util.addDragonSkullLore(citem.getFireDragonSkull(), stage, dragonType));
                                    }
                                    else if (dragonType.equals("Ice")) {
                                        player.getWorld().dropItemNaturally(player.getLocation(), util.addDragonSkullLore(citem.getIceDragonSkull(), stage, dragonType));
                                    }
                                    else {
                                        player.getWorld().dropItemNaturally(player.getLocation(), util.addDragonSkullLore(citem.getLightningDragonSkull(), stage, dragonType));
                                    }

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
                                case "bauble_shield_ankh":
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
                                case "bauble_dragon_scale_black":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getBlackDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getBlackDragonScale());
                                    return true;
                                case "bauble_shield_cobalt":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getCobaltShield());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getCobaltShield());
                                    return true;
                                case "bauble_dragon_scale_black_cracked":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getCrackedBlackDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getCrackedBlackDragonScale());
                                    return true;
                                case "bauble_dragon_scale_ender":
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
                                case "bauble_ring_iron":
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
                                case "bauble_mirror_magic":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getMagicMirror());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getMagicMirror());
                                    return true;
                                case "bauble_dragon_scale_mixed_color":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getMixedColorDragonScale());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getMixedColorDragonScale());
                                    return true;
                                case "bauble_shield_obsidian":
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
                                case "bauble_mirror_wormhole":
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
                                case "bauble_ring_scarlite":
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
                                case "bauble_pendant_wrath":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getWrathPendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getWrathPendant());
                                    return true;
                                case "bauble_pendant_pride":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getPridePendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getPridePendant());
                                    return true;
                                case "bauble_pendant_gluttony":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getGluttonyPendant());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getGluttonyPendant());
                                    return true;
                                case "bauble_pendant_sin":
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
                                case "bauble_amulet_phytoprostasia":
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
                                case "bauble_ring_emerald":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getEmeraldRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getEmeraldRing());
                                    return true;
                                case "bauble_amulet_emerald":
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
                                case "bauble_stone_polarized":
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
                                case "bauble_ring_wither":
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
                                case "bauble_ring_miners":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getMinersRing());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getMinersRing());
                                    return true;
                                case "warped_scroll":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getWarpedScroll());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getWarpedScroll());
                                    return true;
                                case "dragonsteel_fire_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelSword());
                                    return true;
                                case "dragonsteel_fire_pickaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelPickaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelPickaxe());
                                    return true;
                                case "dragonsteel_fire_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelAxe());
                                    return true;
                                case "dragonsteel_fire_shovel":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelShovel());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelShovel());
                                    return true;
                                case "dragonsteel_fire_hoe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelHoe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelHoe());
                                    return true;
                                case "dragonsteel_ice_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelSword());
                                    return true;
                                case "dragonsteel_ice_pickaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelPickaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelPickaxe());
                                    return true;
                                case "dragonsteel_ice_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelAxe());
                                    return true;
                                case "dragonsteel_ice_shovel":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelShovel());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelShovel());
                                    return true;
                                case "dragonsteel_ice_hoe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelHoe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelHoe());
                                    return true;
                                case "dragonsteel_lightning_sword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelSword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelSword());
                                    return true;
                                case "dragonsteel_lightning_pickaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelPickaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelPickaxe());
                                    return true;
                                case "dragonsteel_lightning_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelAxe());
                                    return true;
                                case "dragonsteel_lightning_shovel":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelShovel());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelShovel());
                                    return true;
                                case "dragonsteel_lightning_hoe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelHoe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelHoe());
                                    return true;
                                case "dragonsteel_fire_helmet":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelHelmet());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelHelmet());
                                    return true;
                                case "dragonsteel_fire_chestplate":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelChestplate());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelChestplate());
                                    return true;
                                case "dragonsteel_fire_leggings":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelLeggings());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelLeggings());
                                    return true;
                                case "dragonsteel_fire_boots":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelBoots());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelBoots());
                                    return true;
                                case "dragonsteel_ice_helmet":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelHelmet());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelHelmet());
                                    return true;
                                case "dragonsteel_ice_chestplate":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelChestplate());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelChestplate());
                                    return true;
                                case "dragonsteel_ice_leggings":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelLeggings());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelLeggings());
                                    return true;
                                case "dragonsteel_ice_boots":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelBoots());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelBoots());
                                    return true;
                                case "dragonsteel_lightning_helmet":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelHelmet());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelHelmet());
                                    return true;
                                case "dragonsteel_lightning_chestplate":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelChestplate());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelChestplate());
                                    return true;
                                case "dragonsteel_lightning_leggings":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelLeggings());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelLeggings());
                                    return true;
                                case "dragonsteel_lightning_boots":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelBoots());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelBoots());
                                    return true;
                                case "dragon_bone_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneRapier());
                                    return true;
                                case "dragon_bone_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneKatana());
                                    return true;
                                case "dragon_bone_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneGreatsword());
                                    return true;
                                case "dragon_bone_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneLongsword());
                                    return true;
                                case "dragon_bone_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneSpear());
                                    return true;
                                case "dragon_bone_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneSaber());
                                    return true;
                                case "dragon_bone_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneBoomerang());
                                    return true;
                                case "dragon_bone_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneDagger());
                                    return true;
                                case "dragon_bone_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneGlaive());
                                    return true;
                                case "dragon_bone_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneHalberd());
                                    return true;
                                case "dragon_bone_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneHammer());
                                    return true;
                                case "dragon_bone_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneJavelin());
                                    return true;
                                case "dragon_bone_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneLance());
                                    return true;
                                case "dragon_bone_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneMace());
                                    return true;
                                case "dragon_bone_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBonePike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBonePike());
                                    return true;
                                case "dragon_bone_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneQuarterstaff());
                                    return true;
                                case "dragon_bone_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneThrowingAxe());
                                    return true;
                                case "dragon_bone_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneThrowingKnife());
                                    return true;
                                case "dragon_bone_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneWarhammer());
                                    return true;
                                case "dragon_bone_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneBattleaxe());
                                    return true;
                                case "dragon_bone_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneLongbow());
                                    return true;
                                case "dragon_bone_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getDragonBoneCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getDragonBoneCrossbow());
                                    return true;
                                case "dragon_bone_flamed_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneRapier());
                                    return true;
                                case "dragon_bone_flamed_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneKatana());
                                    return true;
                                case "dragon_bone_flamed_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneGreatsword());
                                    return true;
                                case "dragon_bone_flamed_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneLongsword());
                                    return true;
                                case "dragon_bone_flamed_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneSpear());
                                    return true;
                                case "dragon_bone_flamed_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneSaber());
                                    return true;
                                case "dragon_bone_flamed_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneBoomerang());
                                    return true;
                                case "dragon_bone_flamed_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneDagger());
                                    return true;
                                case "dragon_bone_flamed_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneGlaive());
                                    return true;
                                case "dragon_bone_flamed_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneHalberd());
                                    return true;
                                case "dragon_bone_flamed_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneHammer());
                                    return true;
                                case "dragon_bone_flamed_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneJavelin());
                                    return true;
                                case "dragon_bone_flamed_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneLance());
                                    return true;
                                case "dragon_bone_flamed_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneMace());
                                    return true;
                                case "dragon_bone_flamed_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBonePike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBonePike());
                                    return true;
                                case "dragon_bone_flamed_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneQuarterstaff());
                                    return true;
                                case "dragon_bone_flamed_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneThrowingAxe());
                                    return true;
                                case "dragon_bone_flamed_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneThrowingKnife());
                                    return true;
                                case "dragon_bone_flamed_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneWarhammer());
                                    return true;
                                case "dragon_bone_flamed_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneBattleaxe());
                                    return true;
                                case "dragon_bone_flamed_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneLongbow());
                                    return true;
                                case "dragon_bone_flamed_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFlamedDragonBoneCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFlamedDragonBoneCrossbow());
                                    return true;
                                case "dragon_bone_iced_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneRapier());
                                    return true;
                                case "dragon_bone_iced_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneKatana());
                                    return true;
                                case "dragon_bone_iced_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneGreatsword());
                                    return true;
                                case "dragon_bone_iced_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneLongsword());
                                    return true;
                                case "dragon_bone_iced_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneSpear());
                                    return true;
                                case "dragon_bone_iced_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneSaber());
                                    return true;
                                case "dragon_bone_iced_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneBoomerang());
                                    return true;
                                case "dragon_bone_iced_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneDagger());
                                    return true;
                                case "dragon_bone_iced_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneGlaive());
                                    return true;
                                case "dragon_bone_iced_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneHalberd());
                                    return true;
                                case "dragon_bone_iced_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneHammer());
                                    return true;
                                case "dragon_bone_iced_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneJavelin());
                                    return true;
                                case "dragon_bone_iced_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneLance());
                                    return true;
                                case "dragon_bone_iced_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneMace());
                                    return true;
                                case "dragon_bone_iced_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBonePike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBonePike());
                                    return true;
                                case "dragon_bone_iced_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneQuarterstaff());
                                    return true;
                                case "dragon_bone_iced_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneThrowingAxe());
                                    return true;
                                case "dragon_bone_iced_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneThrowingKnife());
                                    return true;
                                case "dragon_bone_iced_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneWarhammer());
                                    return true;
                                case "dragon_bone_iced_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneBattleaxe());
                                    return true;
                                case "dragon_bone_iced_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneLongbow());
                                    return true;
                                case "dragon_bone_iced_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIcedDragonBoneCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIcedDragonBoneCrossbow());
                                    return true;
                                case "dragon_bone_lightning_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneRapier());
                                    return true;
                                case "dragon_bone_lightning_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneKatana());
                                    return true;
                                case "dragon_bone_lightning_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneGreatsword());
                                    return true;
                                case "dragon_bone_lightning_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneLongsword());
                                    return true;
                                case "dragon_bone_lightning_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneSpear());
                                    return true;
                                case "dragon_bone_lightning_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneSaber());
                                    return true;
                                case "dragon_bone_lightning_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneBoomerang());
                                    return true;
                                case "dragon_bone_lightning_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneDagger());
                                    return true;
                                case "dragon_bone_lightning_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneGlaive());
                                    return true;
                                case "dragon_bone_lightning_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneHalberd());
                                    return true;
                                case "dragon_bone_lightning_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneHammer());
                                    return true;
                                case "dragon_bone_lightning_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneJavelin());
                                    return true;
                                case "dragon_bone_lightning_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneLance());
                                    return true;
                                case "dragon_bone_lightning_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneMace());
                                    return true;
                                case "dragon_bone_lightning_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBonePike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBonePike());
                                    return true;
                                case "dragon_bone_lightning_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneQuarterstaff());
                                    return true;
                                case "dragon_bone_lightning_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneThrowingAxe());
                                    return true;
                                case "dragon_bone_lightning_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneThrowingKnife());
                                    return true;
                                case "dragon_bone_lightning_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneWarhammer());
                                    return true;
                                case "dragon_bone_lightning_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneBattleaxe());
                                    return true;
                                case "dragon_bone_lightning_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneLongbow());
                                    return true;
                                case "dragon_bone_lightning_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonBoneCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonBoneCrossbow());
                                    return true;
                                case "dragonsteel_fire_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelRapier());
                                    return true;
                                case "dragonsteel_fire_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelKatana());
                                    return true;
                                case "dragonsteel_fire_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelGreatsword());
                                    return true;
                                case "dragonsteel_fire_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelLongsword());
                                    return true;
                                case "dragonsteel_fire_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelSpear());
                                    return true;
                                case "dragonsteel_fire_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelSaber());
                                    return true;
                                case "dragonsteel_fire_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelBoomerang());
                                    return true;
                                case "dragonsteel_fire_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelDagger());
                                    return true;
                                case "dragonsteel_fire_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelGlaive());
                                    return true;
                                case "dragonsteel_fire_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelHalberd());
                                    return true;
                                case "dragonsteel_fire_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelHammer());
                                    return true;
                                case "dragonsteel_fire_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelJavelin());
                                    return true;
                                case "dragonsteel_fire_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelLance());
                                    return true;
                                case "dragonsteel_fire_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelMace());
                                    return true;
                                case "dragonsteel_fire_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelPike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelPike());
                                    return true;
                                case "dragonsteel_fire_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelQuarterstaff());
                                    return true;
                                case "dragonsteel_fire_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelThrowingAxe());
                                    return true;
                                case "dragonsteel_fire_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelThrowingKnife());
                                    return true;
                                case "dragonsteel_fire_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelWarhammer());
                                    return true;
                                case "dragonsteel_fire_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelBattleaxe());
                                    return true;
                                case "dragonsteel_fire_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelLongbow());
                                    return true;
                                case "dragonsteel_fire_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelCrossbow());
                                    return true;
                                case "dragonsteel_ice_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelRapier());
                                    return true;
                                case "dragonsteel_ice_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelKatana());
                                    return true;
                                case "dragonsteel_ice_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelGreatsword());
                                    return true;
                                case "dragonsteel_ice_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelLongsword());
                                    return true;
                                case "dragonsteel_ice_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelSpear());
                                    return true;
                                case "dragonsteel_ice_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelSaber());
                                    return true;
                                case "dragonsteel_ice_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelBoomerang());
                                    return true;
                                case "dragonsteel_ice_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelDagger());
                                    return true;
                                case "dragonsteel_ice_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelGlaive());
                                    return true;
                                case "dragonsteel_ice_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelHalberd());
                                    return true;
                                case "dragonsteel_ice_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelHammer());
                                    return true;
                                case "dragonsteel_ice_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelJavelin());
                                    return true;
                                case "dragonsteel_ice_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelLance());
                                    return true;
                                case "dragonsteel_ice_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelMace());
                                    return true;
                                case "dragonsteel_ice_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelPike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelPike());
                                    return true;
                                case "dragonsteel_ice_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelQuarterstaff());
                                    return true;
                                case "dragonsteel_ice_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelThrowingAxe());
                                    return true;
                                case "dragonsteel_ice_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelThrowingKnife());
                                    return true;
                                case "dragonsteel_ice_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelWarhammer());
                                    return true;
                                case "dragonsteel_ice_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelBattleaxe());
                                    return true;
                                case "dragonsteel_ice_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelLongbow());
                                    return true;
                                case "dragonsteel_ice_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelCrossbow());
                                    return true;
                                case "dragonsteel_lightning_rapier":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelRapier());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelRapier());
                                    return true;
                                case "dragonsteel_lightning_katana":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelKatana());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelKatana());
                                    return true;
                                case "dragonsteel_lightning_greatsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelGreatsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelGreatsword());
                                    return true;
                                case "dragonsteel_lightning_longsword":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelLongsword());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelLongsword());
                                    return true;
                                case "dragonsteel_lightning_spear":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelSpear());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelSpear());
                                    return true;
                                case "dragonsteel_lightning_saber":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelSaber());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelSaber());
                                    return true;
                                case "dragonsteel_lightning_boomerang":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelBoomerang());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelBoomerang());
                                    return true;
                                case "dragonsteel_lightning_dagger":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelDagger());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelDagger());
                                    return true;
                                case "dragonsteel_lightning_glaive":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelGlaive());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelGlaive());
                                    return true;
                                case "dragonsteel_lightning_halberd":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelHalberd());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelHalberd());
                                    return true;
                                case "dragonsteel_lightning_hammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelHammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelHammer());
                                    return true;
                                case "dragonsteel_lightning_javelin":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelJavelin());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelJavelin());
                                    return true;
                                case "dragonsteel_lightning_lance":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelLance());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelLance());
                                    return true;
                                case "dragonsteel_lightning_mace":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelMace());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelMace());
                                    return true;
                                case "dragonsteel_lightning_pike":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelPike());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelPike());
                                    return true;
                                case "dragonsteel_lightning_quarterstaff":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelQuarterstaff());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelQuarterstaff());
                                    return true;
                                case "dragonsteel_lightning_throwing_axe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelThrowingAxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelThrowingAxe());
                                    return true;
                                case "dragonsteel_lightning_throwing_knife":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelThrowingKnife());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelThrowingKnife());
                                    return true;
                                case "dragonsteel_lightning_warhammer":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelWarhammer());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelWarhammer());
                                    return true;
                                case "dragonsteel_lightning_battleaxe":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelBattleaxe());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelBattleaxe());
                                    return true;
                                case "dragonsteel_lightning_longbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelLongbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelLongbow());
                                    return true;
                                case "dragonsteel_lightning_crossbow":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelCrossbow());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelCrossbow());
                                    return true;
                                case "bauble_crown_golden":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getGoldenCrown());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getGoldenCrown());
                                    return true;
                                case "dragonsteel_fire_block":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getFireDragonsteelBlock());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getFireDragonsteelBlock());
                                    return true;
                                case "dragonsteel_ice_block":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getIceDragonsteelBlock());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getIceDragonsteelBlock());
                                    return true;
                                case "dragonsteel_lightning_block":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getLightningDragonsteelBlock());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getLightningDragonsteelBlock());
                                    return true;
                                case "bauble_sunglasses:":
                                    for (int i = 0; i < 36; i++) {
                                        if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                            player.getInventory().setItem(i, citem.getSunglasses());
                                            return true;
                                        }
                                    }
                                    player.getWorld().dropItemNaturally(player.getLocation(), citem.getSunglasses());
                                    return true;
                                default:
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("misspelledItemName")));
                                    return true;
                            }
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("noOnlinePlayer")));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("misspelledPlayer")));
                    return true;
                }
                else if (args[0].equalsIgnoreCase("reload")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        if (player.hasPermission("rlcraft.command.reload") || player.isOp()) {
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
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                return true;
            }
            return true;
        }

        return false;
        }
}
