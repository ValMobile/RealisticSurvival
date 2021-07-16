package me.val_mobile.rlcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                return true;
            }
            else if (args.length > 0) {
                if (args[0].isEmpty()) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                    return true;
                }
                if (args[0].equalsIgnoreCase("give")) {
                    if (sender instanceof Player) {
                        if (! (sender.hasPermission("rlcraft.command.give") || sender.isOp())) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }
                    }
                    if (args.length > 1) {
                        if (args[1].isEmpty()) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                            return true;
                        }
                        if (args.length > 2) {
                            if (!(Bukkit.getPlayer(args[1]) == null)) {
                                if (Bukkit.getPlayer(args[1]).isOnline()) {
                                    Player player = Bukkit.getPlayer(args[1]);
                                    if (Item.getCommandNames().contains(args[2])) {
                                        for (int i = 0; i < 36; i++) {
                                            if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                ItemStack customItem = Item.getItem(Item.getItemMap().get(args[2]));
                                                player.getInventory().setItem(i, customItem);
                                                return true;
                                            }
                                        }
                                    }
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MisspelledItemName")));
                                    return true;
                                }
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoOnlinePlayer")));
                                return true;
                            }
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MisspelledPlayer")));
                            return true;
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                    return true;
                }
                else if (args[0].equalsIgnoreCase("reload")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        if (player.hasPermission("rlcraft.command.reload") || player.isOp()) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Reload")));
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
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Reload")));
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
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                return true;
            }
            return true;
        }

        return false;
        }
}
