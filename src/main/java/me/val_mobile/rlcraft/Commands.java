package me.val_mobile.rlcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Commands implements CommandExecutor {

    private final RLCraft plugin;
    private final CustomConfig customConfig;
    public Commands(RLCraft instance) {
        plugin = instance;
        customConfig = new CustomConfig(instance);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("rlcraft")) {
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
                    if (args.length > 1) {
                        if (args[1].isEmpty()) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                            return true;
                        }
                        if (args.length > 2) {
                            if (!(Bukkit.getPlayer(args[1]) == null)) {
                                if (Bukkit.getPlayer(args[1]).isOnline()) {
                                    Player player = Bukkit.getPlayer(args[1]);
                                    switch (args[2].toLowerCase()) {
                                        case "dragon_scale_amethyst":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleAmethyst());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleAmethyst());
                                            return true;
                                        case "dragon_scale_boots_amethyst":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsAmethyst());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsAmethyst());
                                            return true;
                                        case "dragon_scale_chestplate_amethyst":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateAmethyst());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateAmethyst());
                                            return true;
                                        case "dragon_scale_helmet_amethyst":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetAmethyst());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetAmethyst());
                                            return true;
                                        case "dragon_scale_leggings_amethyst":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsAmethyst());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsAmethyst());
                                            return true;
                                        case "dragon_scale_black":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBlack());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBlack());
                                            return true;
                                        case "dragon_scale_boots_black":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsBlack());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsBlack());
                                            return true;
                                        case "dragon_scale_chestplate_black":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateBlack());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateBlack());
                                            return true;
                                        case "dragon_scale_helmet_black":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetBlack());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetBlack());
                                            return true;
                                        case "dragon_scale_leggings_black":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsBlack());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsBlack());
                                            return true;
                                        case "dragon_scale_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBlue());
                                            return true;
                                        case "dragon_scale_boots_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsBlue());
                                            return true;
                                        case "dragon_scale_chestplate_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateBlue());
                                            return true;
                                        case "dragon_scale_helmet_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetBlue());
                                            return true;
                                        case "dragon_scale_leggings_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsBlue());
                                            return true;
                                        case "sea_serpent_scale_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScaleBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScaleBlue());
                                            return true;
                                        case "tide_guardian_boots_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsBlue());
                                            return true;
                                        case "tide_guardian_chestplate_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplateBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplateBlue());
                                            return true;
                                        case "tide_guardian_helmet_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetBlue());
                                            return true;
                                        case "tide_guardian_leggings_blue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsBlue());
                                            return true;
                                        case "dragon_scale_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBronze());
                                            return true;
                                        case "dragon_scale_boots_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsBronze());
                                            return true;
                                        case "dragon_scale_chestplate_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateBronze());
                                            return true;
                                        case "dragon_scale_helmet_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetBronze());
                                            return true;
                                        case "dragon_scale_leggings_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsBronze());
                                            return true;
                                        case "sea_serpent_scale_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScaleBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScaleBronze());
                                            return true;
                                        case "tide_guardian_boots_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsBronze());
                                            return true;
                                        case "tide_guardian_chestplate_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplateBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplateBronze());
                                            return true;
                                        case "tide_guardian_helmet_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetBronze());
                                            return true;
                                        case "tide_guardian_leggings_bronze":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsBronze());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsBronze());
                                            return true;
                                        case "dragon_scale_copper":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleCopper());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleCopper());
                                            return true;
                                        case "dragon_scale_boots_copper":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsCopper());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsCopper());
                                            return true;
                                        case "dragon_scale_chestplate_copper":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateCopper());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateCopper());
                                            return true;
                                        case "dragon_scale_helmet_copper":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetCopper());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetCopper());
                                            return true;
                                        case "dragon_scale_leggings_copper":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsCopper());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsCopper());
                                            return true;
                                        case "sea_serpent_scale_deepblue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScaleDeepBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScaleDeepBlue());
                                            return true;
                                        case "tide_guardian_boots_deepblue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsDeepBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsDeepBlue());
                                            return true;
                                        case "tide_guardian_chestplate_deepblue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplateDeepBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplateDeepBlue());
                                            return true;
                                        case "tide_guardian_helmet_deepblue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetDeepBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetDeepBlue());
                                            return true;
                                        case "tide_guardian_leggings_deepblue":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsDeepBlue());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsDeepBlue());
                                            return true;
                                        case "dragon_bone":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBone());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBone());
                                            return true;
                                        case "dragon_bone_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneAxe());
                                            return true;
                                        case "dragon_bone_bow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneBow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneBow());
                                            return true;
                                        case "dragon_bone_hoe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneHoe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneHoe());
                                            return true;
                                        case "dragon_bone_pickaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBonePickaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBonePickaxe());
                                            return true;
                                        case "dragon_bone_shovel":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneShovel());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneShovel());
                                            return true;
                                        case "dragon_bone_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneSword());
                                            return true;
                                        case "dragon_scale_electric":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleElectric());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleElectric());
                                            return true;
                                        case "dragon_scale_boots_electric":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsElectric());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsElectric());
                                            return true;
                                        case "dragon_scale_chestplate_electric":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateElectric());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateElectric());
                                            return true;
                                        case "dragon_scale_helmet_electric":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetElectric());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetElectric());
                                            return true;
                                        case "dragon_scale_leggings_electric":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsElectric());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsElectric());
                                            return true;
                                        case "dragon_blood_fire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonBlood());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonBlood());
                                            return true;
                                        case "dragon_heart_fire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonHeart());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonHeart());
                                            return true;
                                        case "dragon_flesh_fire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonFlesh());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonFlesh());
                                            return true;
                                        case "dragonsteel_fire_ingot":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelIngot());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelIngot());
                                            return true;
                                        case "dragon_bone_flamed_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneSword());
                                            return true;
                                        case "dragon_scale_gray":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleGray());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleGray());
                                            return true;
                                        case "dragon_scale_boots_gray":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsGray());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsGray());
                                            return true;
                                        case "dragon_scale_chestplate_gray":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateGray());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateGray());
                                            return true;
                                        case "dragon_scale_helmet_gray":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetGray());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetElectric());
                                            return true;
                                        case "dragon_scale_leggings_gray":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsGray());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsGray());
                                            return true;
                                        case "dragon_scale_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleGreen());
                                            return true;
                                        case "dragon_scale_boots_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsGreen());
                                            return true;
                                        case "dragon_scale_chestplate_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateGreen());
                                            return true;
                                        case "dragon_scale_helmet_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetElectric());
                                            return true;
                                        case "dragon_scale_leggings_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsGreen());
                                            return true;
                                        case "sea_serpent_scale_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScaleGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScaleGreen());
                                            return true;
                                        case "tide_guardian_boots_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsGreen());
                                            return true;
                                        case "tide_guardian_chestplate_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplateGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplateGreen());
                                            return true;
                                        case "tide_guardian_helmet_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetGreen());
                                            return true;
                                        case "tide_guardian_leggings_green":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsGreen());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsGreen());
                                            return true;
                                        case "dragon_blood_ice":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonBlood());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonBlood());
                                            return true;
                                        case "dragon_heart_ice":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonHeart());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonHeart());
                                            return true;
                                        case "dragon_flesh_ice":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonFlesh());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonFlesh());
                                            return true;
                                        case "dragon_bone_iced_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneSword());
                                            return true;
                                        case "dragonsteel_ice_ingot":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelIngot());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelIngot());
                                            return true;
                                        case "dragon_blood_lightning":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBlood());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBlood());
                                            return true;
                                        case "dragon_heart_lightning":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonHeart());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonHeart());
                                            return true;
                                        case "dragon_flesh_lightning":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonFlesh());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonFlesh());
                                            return true;
                                        case "dragon_bone_lightning_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneSword());
                                            return true;
                                        case "dragonsteel_lightning_ingot":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelIngot());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelIngot());
                                            return true;
                                        case "sea_serpent_scale_purple":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScalePurple());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScalePurple());
                                            return true;
                                        case "tide_guardian_boots_purple":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsPurple());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsPurple());
                                            return true;
                                        case "tide_guardian_chestplate_purple":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplatePurple());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplatePurple());
                                            return true;
                                        case "tide_guardian_helmet_purple":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetPurple());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetPurple());
                                            return true;
                                        case "tide_guardian_leggings_purple":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsPurple());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsPurple());
                                            return true;
                                        case "dragon_scale_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleRed());
                                            return true;
                                        case "dragon_scale_boots_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsRed());
                                            return true;
                                        case "dragon_scale_chestplate_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateRed());
                                            return true;
                                        case "dragon_scale_helmet_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetRed());
                                            return true;
                                        case "dragon_scale_leggings_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsRed());
                                            return true;
                                        case "sea_serpent_scale_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScaleRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScaleRed());
                                            return true;
                                        case "tide_guardian_boots_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsRed());
                                            return true;
                                        case "tide_guardian_chestplate_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplateRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplateRed());
                                            return true;
                                        case "tide_guardian_helmet_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetRed());
                                            return true;
                                        case "tide_guardian_leggings_red":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsRed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsRed());
                                            return true;
                                        case "dragon_scale_sapphire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleSapphire());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleSapphire());
                                            return true;
                                        case "dragon_scale_boots_sapphire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsSapphire());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsSapphire());
                                            return true;
                                        case "dragon_scale_chestplate_sapphire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateSapphire());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateSapphire());
                                            return true;
                                        case "dragon_scale_helmet_sapphire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetSapphire());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetSapphire());
                                            return true;
                                        case "dragon_scale_leggings_sapphire":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsSapphire());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsSapphire());
                                            return true;
                                        case "shiny_scale":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getShinyScale());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getShinyScale());
                                            return true;
                                        case "dragon_scale_silver":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleSilver());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleSilver());
                                            return true;
                                        case "dragon_scale_boots_silver":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsSilver());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsSilver());
                                            return true;
                                        case "dragon_scale_chestplate_silver":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateSilver());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateSilver());
                                            return true;
                                        case "dragon_scale_helmet_silver":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetSilver());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetSilver());
                                            return true;
                                        case "dragon_scale_leggings_silver":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsSilver());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsSilver());
                                            return true;
                                        case "sea_serpent_scale_teal":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSeaSerpentScaleTeal());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSeaSerpentScaleTeal());
                                            return true;
                                        case "tide_guardian_boots_teal":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianBootsTeal());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianBootsTeal());
                                            return true;
                                        case "tide_guardian_chestplate_teal":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianChestplateTeal());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianChestplateTeal());
                                            return true;
                                        case "tide_guardian_helmet_teal":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianHelmetTeal());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianHelmetTeal());
                                            return true;
                                        case "tide_guardian_leggings_teal":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getTideGuardianLeggingsTeal());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getTideGuardianLeggingsTeal());
                                            return true;
                                        case "dragon_scale_white":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleWhite());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleWhite());
                                            return true;
                                        case "dragon_scale_boots_white":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleBootsWhite());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleBootsWhite());
                                            return true;
                                        case "dragon_scale_chestplate_white":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleChestplateWhite());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleChestplateWhite());
                                            return true;
                                        case "dragon_scale_helmet_white":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleHelmetWhite());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleHelmetWhite());
                                            return true;
                                        case "dragon_scale_leggings_white":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonScaleLeggingsWhite());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonScaleLeggingsWhite());
                                            return true;
                                        case "witherbone":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getWitherbone());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getWitherbone());
                                            return true;
                                        case "bauble_potion_ring_resistance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRingResistance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRingResistance());
                                            return true;
                                        case "bauble_potion_ring_regeneration":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRingRegeneration());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRingRegeneration());
                                            return true;
                                        case "bauble_potion_ring_strength":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRingStrength());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRingStrength());
                                            return true;
                                        case "bauble_potion_ring_speed":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRingSpeed());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRingSpeed());
                                            return true;
                                        case "bauble_potion_ring_haste":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRingHaste());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRingHaste());
                                            return true;
                                        case "bauble_potion_ring_jump_boost":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRingJumpBoost());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRingJumpBoost());
                                            return true;
                                        case "bauble_stone_poison":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPoisonStone());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPoisonStone());
                                            return true;
                                        case "bauble_crown_ender_queens":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getEnderQueensCrown());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getEnderQueensCrown());
                                            return true;
                                        case "bauble_dragons_eye":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonsEye());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonsEye());
                                            return true;
                                        case "dragon_skull":
                                            Random r = new Random();
                                            String dragonType;
                                            ItemStack skull;
                                            double value = r.nextDouble();
                                            int stage = (int) Math.round(r.nextDouble() * 4) + 1;

                                            if (value <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.Chance")) {
                                                dragonType = "Fire";
                                                skull = CustomItems.getFireDragonSkull();
                                            }
                                            else if (value > CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.Chance") &&
                                                    value <= (CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.Chance"))) {
                                                dragonType = "Ice";
                                                skull = CustomItems.getIceDragonSkull();

                                            }
                                            else {
                                                dragonType = "Lightning";
                                                skull = CustomItems.getLightningDragonSkull();
                                            }
                                            Utils.addDragonSkullLore(skull, stage, dragonType);

                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, skull);
                                                    return true;
                                                }
                                            }

                                            player.getWorld().dropItemNaturally(player.getLocation(), skull);

                                            return true;
                                        case "battle_burrito":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getBattleBurrito());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getBattleBurrito());
                                            return true;
                                        case "bauble_ankh_charm":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getAnkhCharm());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getAnkhCharm());
                                            return true;
                                        case "bauble_shield_ankh":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getAnkhShield());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getAnkhShield());
                                            return true;
                                        case "bauble_balloon":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getBalloon());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getBalloon());
                                            return true;
                                        case "bauble_bezoar":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getBezoar());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getBezoar());
                                            return true;
                                        case "bauble_dragon_scale_black":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getBlackDragonScale());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getBlackDragonScale());
                                            return true;
                                        case "bauble_shield_cobalt":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getCobaltShield());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getCobaltShield());
                                            return true;
                                        case "bauble_dragon_scale_black_cracked":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getCrackedBlackDragonScale());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getCrackedBlackDragonScale());
                                            return true;
                                        case "bauble_dragon_scale_ender":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getEnderDragonScale());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getEnderDragonScale());
                                            return true;
                                        case "bauble_forbidden_fruit":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getForbiddenFruit());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getForbiddenFruit());
                                            return true;
                                        case "bauble_ring_iron":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIronRing());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIronRing());
                                            return true;
                                        case "bauble_lucky_horseshoe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLuckyHorseshoe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLuckyHorseshoe());
                                            return true;
                                        case "bauble_mirror_magic":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getMagicMirror());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getMagicMirror());
                                            return true;
                                        case "bauble_dragon_scale_mixed_color":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getMixedColorDragonScale());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getMixedColorDragonScale());
                                            return true;
                                        case "bauble_shield_obsidian":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getObsidianShield());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getObsidianShield());
                                            return true;
                                        case "bauble_obsidian_skull":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getObsidianSkull());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getObsidianSkull());
                                            return true;
                                        case "bauble_ring_free_action":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getRingofFreeAction());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getRingofFreeAction());
                                            return true;
                                        case "bauble_ring_overclocking":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getRingofOverclocking());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getRingofOverclocking());
                                            return true;
                                        case "bauble_shulker_heart":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getShulkerHeart());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getShulkerHeart());
                                            return true;
                                        case "bauble_vitamins":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getVitamins());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getVitamins());
                                            return true;
                                        case "bauble_mirror_wormhole":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getWormholeMirror());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getWormholeMirror());
                                            return true;
                                        case "flint_shard":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlintShard());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlintShard());
                                            return true;
                                        case "flint_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlintAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlintAxe());
                                            return true;
                                        case "flint_pickaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlintPickaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlintPickaxe());
                                            return true;
                                        case "flint_shovel":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlintShovel());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlintShovel());
                                            return true;
                                        case "flint_hoe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlintHoe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlintHoe());
                                            return true;
                                        case "flint_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlintKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlintKnife());
                                            return true;
                                        case "plant_fiber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPlantFiber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPlantFiber());
                                            return true;
                                        case "plant_string":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPlantString());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPlantString());
                                            return true;
                                        case "bauble_ring_scarlite":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getScarliteRing());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getScarliteRing());
                                            return true;
                                        case "bauble_spectral_silt":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSpectralSilt());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSpectralSilt());
                                            return true;
                                        case "bauble_disintegration_tablet":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDisintegrationTablet());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDisintegrationTablet());
                                            return true;
                                        case "bauble_cross_necklace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getCrossNecklace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getCrossNecklace());
                                            return true;
                                        case "bauble_pendant_wrath":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getWrathPendant());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getWrathPendant());
                                            return true;
                                        case "bauble_pendant_pride":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPridePendant());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPridePendant());
                                            return true;
                                        case "bauble_pendant_gluttony":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getGluttonyPendant());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getGluttonyPendant());
                                            return true;
                                        case "bauble_pendant_sin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSinPendant());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSinPendant());
                                            return true;
                                        case "bauble_flare_gun":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlareGun());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlareGun());
                                            return true;
                                        case "bauble_flare":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlare());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlare());
                                            return true;
                                        case "bauble_amulet_phytoprostasia":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPhytoprostasiaAmulet());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPhytoprostasiaAmulet());
                                            return true;
                                        case "bauble_potion_ring":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPotionRing());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPotionRing());
                                            return true;
                                        case "bauble_ring_emerald":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getEmeraldRing());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getEmeraldRing());
                                            return true;
                                        case "bauble_amulet_emerald":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getEmeraldAmulet());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getEmeraldAmulet());
                                            return true;
                                        case "bauble_glowing_ingot":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getGlowingIngot());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getGlowingIngot());
                                            return true;
                                        case "bauble_glowing_powder":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getGlowingPowder());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getGlowingPowder());
                                            return true;
                                        case "bauble_glowing_gem":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getGlowingGem());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getGlowingGem());
                                            return true;
                                        case "bauble_dwarf_stout":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDwarfStout());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDwarfStout());
                                            return true;
                                        case "bauble_fairy_dew":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFairyDew());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFairyDew());
                                            return true;
                                        case "bauble_stone_negative_gravity":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getStoneNegativeGravity());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getStoneNegativeGravity());
                                            return true;
                                        case "bauble_stone_inertia_null":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getStoneInertiaNull());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getStoneInertiaNull());
                                            return true;
                                        case "bauble_stone_greater_inertia":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getStoneGreaterInertia());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getStoneGreaterInertia());
                                            return true;
                                        case "bauble_ring_enchanted_eyes":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getRingEnchantedEyes());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getRingEnchantedEyes());
                                            return true;
                                        case "bauble_stone_sea":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getStoneSea());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getStoneSea());
                                            return true;
                                        case "bauble_stone_polarized":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getPolarizedStone());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getPolarizedStone());
                                            return true;
                                        case "bauble_ring_fairies":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getRingFairies());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getRingFairies());
                                            return true;
                                        case "bauble_ring_dwarves":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getRingDwarves());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getRingDwarves());
                                            return true;
                                        case "bauble_ring_wither":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getWitherRing());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getWitherRing());
                                            return true;
                                        case "bauble_shield_honor":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getShieldHonor());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getShieldHonor());
                                            return true;
                                        case "bauble_ring_miners":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getMinersRing());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getMinersRing());
                                            return true;
                                        case "warped_scroll":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getWarpedScroll());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getWarpedScroll());
                                            return true;
                                        case "dragonsteel_fire_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelSword());
                                            return true;
                                        case "dragonsteel_fire_pickaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelPickaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelPickaxe());
                                            return true;
                                        case "dragonsteel_fire_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelAxe());
                                            return true;
                                        case "dragonsteel_fire_shovel":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelShovel());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelShovel());
                                            return true;
                                        case "dragonsteel_fire_hoe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelHoe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelHoe());
                                            return true;
                                        case "dragonsteel_ice_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelSword());
                                            return true;
                                        case "dragonsteel_ice_pickaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelPickaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelPickaxe());
                                            return true;
                                        case "dragonsteel_ice_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelAxe());
                                            return true;
                                        case "dragonsteel_ice_shovel":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelShovel());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelShovel());
                                            return true;
                                        case "dragonsteel_ice_hoe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelHoe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelHoe());
                                            return true;
                                        case "dragonsteel_lightning_sword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelSword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelSword());
                                            return true;
                                        case "dragonsteel_lightning_pickaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelPickaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelPickaxe());
                                            return true;
                                        case "dragonsteel_lightning_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelAxe());
                                            return true;
                                        case "dragonsteel_lightning_shovel":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelShovel());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelShovel());
                                            return true;
                                        case "dragonsteel_lightning_hoe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelHoe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelHoe());
                                            return true;
                                        case "dragonsteel_fire_helmet":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelHelmet());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelHelmet());
                                            return true;
                                        case "dragonsteel_fire_chestplate":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelChestplate());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelChestplate());
                                            return true;
                                        case "dragonsteel_fire_leggings":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelLeggings());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelLeggings());
                                            return true;
                                        case "dragonsteel_fire_boots":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelBoots());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelBoots());
                                            return true;
                                        case "dragonsteel_ice_helmet":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelHelmet());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelHelmet());
                                            return true;
                                        case "dragonsteel_ice_chestplate":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelChestplate());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelChestplate());
                                            return true;
                                        case "dragonsteel_ice_leggings":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelLeggings());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelLeggings());
                                            return true;
                                        case "dragonsteel_ice_boots":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelBoots());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelBoots());
                                            return true;
                                        case "dragonsteel_lightning_helmet":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelHelmet());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelHelmet());
                                            return true;
                                        case "dragonsteel_lightning_chestplate":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelChestplate());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelChestplate());
                                            return true;
                                        case "dragonsteel_lightning_leggings":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelLeggings());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelLeggings());
                                            return true;
                                        case "dragonsteel_lightning_boots":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelBoots());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelBoots());
                                            return true;
                                        case "dragon_bone_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneRapier());
                                            return true;
                                        case "dragon_bone_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneKatana());
                                            return true;
                                        case "dragon_bone_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneGreatsword());
                                            return true;
                                        case "dragon_bone_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneLongsword());
                                            return true;
                                        case "dragon_bone_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneSpear());
                                            return true;
                                        case "dragon_bone_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneSaber());
                                            return true;
                                        case "dragon_bone_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneBoomerang());
                                            return true;
                                        case "dragon_bone_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneDagger());
                                            return true;
                                        case "dragon_bone_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneGlaive());
                                            return true;
                                        case "dragon_bone_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneHalberd());
                                            return true;
                                        case "dragon_bone_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneHammer());
                                            return true;
                                        case "dragon_bone_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneJavelin());
                                            return true;
                                        case "dragon_bone_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneLance());
                                            return true;
                                        case "dragon_bone_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneMace());
                                            return true;
                                        case "dragon_bone_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBonePike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBonePike());
                                            return true;
                                        case "dragon_bone_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneQuarterstaff());
                                            return true;
                                        case "dragon_bone_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneThrowingAxe());
                                            return true;
                                        case "dragon_bone_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneThrowingKnife());
                                            return true;
                                        case "dragon_bone_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneWarhammer());
                                            return true;
                                        case "dragon_bone_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneBattleaxe());
                                            return true;
                                        case "dragon_bone_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneLongbow());
                                            return true;
                                        case "dragon_bone_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getDragonBoneCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getDragonBoneCrossbow());
                                            return true;
                                        case "dragon_bone_flamed_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneRapier());
                                            return true;
                                        case "dragon_bone_flamed_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneKatana());
                                            return true;
                                        case "dragon_bone_flamed_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneGreatsword());
                                            return true;
                                        case "dragon_bone_flamed_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneLongsword());
                                            return true;
                                        case "dragon_bone_flamed_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneSpear());
                                            return true;
                                        case "dragon_bone_flamed_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneSaber());
                                            return true;
                                        case "dragon_bone_flamed_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneBoomerang());
                                            return true;
                                        case "dragon_bone_flamed_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneDagger());
                                            return true;
                                        case "dragon_bone_flamed_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneGlaive());
                                            return true;
                                        case "dragon_bone_flamed_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneHalberd());
                                            return true;
                                        case "dragon_bone_flamed_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneHammer());
                                            return true;
                                        case "dragon_bone_flamed_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneJavelin());
                                            return true;
                                        case "dragon_bone_flamed_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneLance());
                                            return true;
                                        case "dragon_bone_flamed_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneMace());
                                            return true;
                                        case "dragon_bone_flamed_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBonePike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBonePike());
                                            return true;
                                        case "dragon_bone_flamed_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneQuarterstaff());
                                            return true;
                                        case "dragon_bone_flamed_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneThrowingAxe());
                                            return true;
                                        case "dragon_bone_flamed_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneThrowingKnife());
                                            return true;
                                        case "dragon_bone_flamed_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneWarhammer());
                                            return true;
                                        case "dragon_bone_flamed_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneBattleaxe());
                                            return true;
                                        case "dragon_bone_flamed_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneLongbow());
                                            return true;
                                        case "dragon_bone_flamed_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFlamedDragonBoneCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFlamedDragonBoneCrossbow());
                                            return true;
                                        case "dragon_bone_iced_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneRapier());
                                            return true;
                                        case "dragon_bone_iced_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneKatana());
                                            return true;
                                        case "dragon_bone_iced_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneGreatsword());
                                            return true;
                                        case "dragon_bone_iced_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneLongsword());
                                            return true;
                                        case "dragon_bone_iced_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneSpear());
                                            return true;
                                        case "dragon_bone_iced_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneSaber());
                                            return true;
                                        case "dragon_bone_iced_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneBoomerang());
                                            return true;
                                        case "dragon_bone_iced_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneDagger());
                                            return true;
                                        case "dragon_bone_iced_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneGlaive());
                                            return true;
                                        case "dragon_bone_iced_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneHalberd());
                                            return true;
                                        case "dragon_bone_iced_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneHammer());
                                            return true;
                                        case "dragon_bone_iced_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneJavelin());
                                            return true;
                                        case "dragon_bone_iced_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneLance());
                                            return true;
                                        case "dragon_bone_iced_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneMace());
                                            return true;
                                        case "dragon_bone_iced_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBonePike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBonePike());
                                            return true;
                                        case "dragon_bone_iced_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneQuarterstaff());
                                            return true;
                                        case "dragon_bone_iced_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneThrowingAxe());
                                            return true;
                                        case "dragon_bone_iced_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneThrowingKnife());
                                            return true;
                                        case "dragon_bone_iced_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneWarhammer());
                                            return true;
                                        case "dragon_bone_iced_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneBattleaxe());
                                            return true;
                                        case "dragon_bone_iced_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneLongbow());
                                            return true;
                                        case "dragon_bone_iced_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIcedDragonBoneCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIcedDragonBoneCrossbow());
                                            return true;
                                        case "dragon_bone_lightning_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneRapier());
                                            return true;
                                        case "dragon_bone_lightning_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneKatana());
                                            return true;
                                        case "dragon_bone_lightning_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneGreatsword());
                                            return true;
                                        case "dragon_bone_lightning_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneLongsword());
                                            return true;
                                        case "dragon_bone_lightning_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneSpear());
                                            return true;
                                        case "dragon_bone_lightning_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneSaber());
                                            return true;
                                        case "dragon_bone_lightning_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneBoomerang());
                                            return true;
                                        case "dragon_bone_lightning_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneDagger());
                                            return true;
                                        case "dragon_bone_lightning_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneGlaive());
                                            return true;
                                        case "dragon_bone_lightning_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneHalberd());
                                            return true;
                                        case "dragon_bone_lightning_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneHammer());
                                            return true;
                                        case "dragon_bone_lightning_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneJavelin());
                                            return true;
                                        case "dragon_bone_lightning_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneLance());
                                            return true;
                                        case "dragon_bone_lightning_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneMace());
                                            return true;
                                        case "dragon_bone_lightning_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBonePike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBonePike());
                                            return true;
                                        case "dragon_bone_lightning_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneQuarterstaff());
                                            return true;
                                        case "dragon_bone_lightning_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneThrowingAxe());
                                            return true;
                                        case "dragon_bone_lightning_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneThrowingKnife());
                                            return true;
                                        case "dragon_bone_lightning_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneWarhammer());
                                            return true;
                                        case "dragon_bone_lightning_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneBattleaxe());
                                            return true;
                                        case "dragon_bone_lightning_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneLongbow());
                                            return true;
                                        case "dragon_bone_lightning_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonBoneCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonBoneCrossbow());
                                            return true;
                                        case "dragonsteel_fire_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelRapier());
                                            return true;
                                        case "dragonsteel_fire_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelKatana());
                                            return true;
                                        case "dragonsteel_fire_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelGreatsword());
                                            return true;
                                        case "dragonsteel_fire_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelLongsword());
                                            return true;
                                        case "dragonsteel_fire_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelSpear());
                                            return true;
                                        case "dragonsteel_fire_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelSaber());
                                            return true;
                                        case "dragonsteel_fire_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelBoomerang());
                                            return true;
                                        case "dragonsteel_fire_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelDagger());
                                            return true;
                                        case "dragonsteel_fire_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelGlaive());
                                            return true;
                                        case "dragonsteel_fire_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelHalberd());
                                            return true;
                                        case "dragonsteel_fire_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelHammer());
                                            return true;
                                        case "dragonsteel_fire_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelJavelin());
                                            return true;
                                        case "dragonsteel_fire_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelLance());
                                            return true;
                                        case "dragonsteel_fire_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelMace());
                                            return true;
                                        case "dragonsteel_fire_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelPike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelPike());
                                            return true;
                                        case "dragonsteel_fire_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelQuarterstaff());
                                            return true;
                                        case "dragonsteel_fire_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelThrowingAxe());
                                            return true;
                                        case "dragonsteel_fire_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelThrowingKnife());
                                            return true;
                                        case "dragonsteel_fire_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelWarhammer());
                                            return true;
                                        case "dragonsteel_fire_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelBattleaxe());
                                            return true;
                                        case "dragonsteel_fire_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelLongbow());
                                            return true;
                                        case "dragonsteel_fire_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelCrossbow());
                                            return true;
                                        case "dragonsteel_ice_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelRapier());
                                            return true;
                                        case "dragonsteel_ice_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelKatana());
                                            return true;
                                        case "dragonsteel_ice_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelGreatsword());
                                            return true;
                                        case "dragonsteel_ice_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelLongsword());
                                            return true;
                                        case "dragonsteel_ice_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelSpear());
                                            return true;
                                        case "dragonsteel_ice_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelSaber());
                                            return true;
                                        case "dragonsteel_ice_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelBoomerang());
                                            return true;
                                        case "dragonsteel_ice_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelDagger());
                                            return true;
                                        case "dragonsteel_ice_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelGlaive());
                                            return true;
                                        case "dragonsteel_ice_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelHalberd());
                                            return true;
                                        case "dragonsteel_ice_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelHammer());
                                            return true;
                                        case "dragonsteel_ice_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelJavelin());
                                            return true;
                                        case "dragonsteel_ice_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelLance());
                                            return true;
                                        case "dragonsteel_ice_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelMace());
                                            return true;
                                        case "dragonsteel_ice_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelPike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelPike());
                                            return true;
                                        case "dragonsteel_ice_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelQuarterstaff());
                                            return true;
                                        case "dragonsteel_ice_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelThrowingAxe());
                                            return true;
                                        case "dragonsteel_ice_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelThrowingKnife());
                                            return true;
                                        case "dragonsteel_ice_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelWarhammer());
                                            return true;
                                        case "dragonsteel_ice_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelBattleaxe());
                                            return true;
                                        case "dragonsteel_ice_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelLongbow());
                                            return true;
                                        case "dragonsteel_ice_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelCrossbow());
                                            return true;
                                        case "dragonsteel_lightning_rapier":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelRapier());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelRapier());
                                            return true;
                                        case "dragonsteel_lightning_katana":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelKatana());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelKatana());
                                            return true;
                                        case "dragonsteel_lightning_greatsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelGreatsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelGreatsword());
                                            return true;
                                        case "dragonsteel_lightning_longsword":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelLongsword());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelLongsword());
                                            return true;
                                        case "dragonsteel_lightning_spear":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelSpear());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelSpear());
                                            return true;
                                        case "dragonsteel_lightning_saber":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelSaber());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelSaber());
                                            return true;
                                        case "dragonsteel_lightning_boomerang":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelBoomerang());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelBoomerang());
                                            return true;
                                        case "dragonsteel_lightning_dagger":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelDagger());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelDagger());
                                            return true;
                                        case "dragonsteel_lightning_glaive":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelGlaive());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelGlaive());
                                            return true;
                                        case "dragonsteel_lightning_halberd":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelHalberd());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelHalberd());
                                            return true;
                                        case "dragonsteel_lightning_hammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelHammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelHammer());
                                            return true;
                                        case "dragonsteel_lightning_javelin":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelJavelin());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelJavelin());
                                            return true;
                                        case "dragonsteel_lightning_lance":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelLance());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelLance());
                                            return true;
                                        case "dragonsteel_lightning_mace":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelMace());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelMace());
                                            return true;
                                        case "dragonsteel_lightning_pike":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelPike());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelPike());
                                            return true;
                                        case "dragonsteel_lightning_quarterstaff":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelQuarterstaff());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelQuarterstaff());
                                            return true;
                                        case "dragonsteel_lightning_throwing_axe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelThrowingAxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelThrowingAxe());
                                            return true;
                                        case "dragonsteel_lightning_throwing_knife":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelThrowingKnife());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelThrowingKnife());
                                            return true;
                                        case "dragonsteel_lightning_warhammer":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelWarhammer());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelWarhammer());
                                            return true;
                                        case "dragonsteel_lightning_battleaxe":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelBattleaxe());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelBattleaxe());
                                            return true;
                                        case "dragonsteel_lightning_longbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelLongbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelLongbow());
                                            return true;
                                        case "dragonsteel_lightning_crossbow":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelCrossbow());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelCrossbow());
                                            return true;
                                        case "bauble_crown_golden":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getGoldenCrown());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getGoldenCrown());
                                            return true;
                                        case "dragonsteel_fire_block":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getFireDragonsteelBlock());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getFireDragonsteelBlock());
                                            return true;
                                        case "dragonsteel_ice_block":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getIceDragonsteelBlock());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getIceDragonsteelBlock());
                                            return true;
                                        case "dragonsteel_lightning_block":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getLightningDragonsteelBlock());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getLightningDragonsteelBlock());
                                            return true;
                                        case "bauble_sunglasses:":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getSunglasses());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getSunglasses());
                                            return true;
                                        case "bauble_broken_heart":
                                            for (int i = 0; i < 36; i++) {
                                                if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                    player.getInventory().setItem(i, CustomItems.getBrokenHeart());
                                                    return true;
                                                }
                                            }
                                            player.getWorld().dropItemNaturally(player.getLocation(), CustomItems.getBrokenHeart());
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
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                    return true;
                }
                else if (args[0].equalsIgnoreCase("reload")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        if (player.hasPermission("rlcraft.command.reload") || player.isOp()) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("reload")));
                            plugin.reloadConfig();
                            customConfig.reloadBaubleConfig();
                            customConfig.reloadSpartanWeaponryConfig();
                            customConfig.reloadIceFireGearConfig();
                            customConfig.reloadMobConfig();
                            customConfig.reloadNoTreePunchingConfig();
                            customConfig.reloadLycanitesMobsConfig();
                            customConfig.reloadItemsConfig();
                            return true;
                        }
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nopermission")));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("reload")));
                    plugin.reloadConfig();
                    return true;
                }
                else if (args[0].equalsIgnoreCase("test")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage("Shield of Honor Amount: " + PlayerRunnable.getShieldHonor().get(player.getName()));
                        player.sendMessage("Runnable activated: " + PlayerRunnable.getShieldHonorRunnables().get(player.getName()));

                    }
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                return true;
            }
            return true;
        }

        return false;
        }
}
