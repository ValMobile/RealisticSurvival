package me.val_mobile.rlcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
/**
 * Commands is a class that allows users to
 * access the plugin's commands in-game
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class Commands implements CommandExecutor {

    /**
     * Dependency injecting the main and custom config class for use
     * The custom config class must be injected because its non-static methods are needed
     */
    private final RLCraft plugin;
    private final CustomConfig customConfig;

    // constructing the Commands class
    public Commands(RLCraft instance) {
        plugin = instance;
        customConfig = new CustomConfig(instance);
    }

    /**
     * Performs various actions depending on what the player types as a command
     * @param sender The user who typed the command
     * @param cmd The command typed
     * @param label The word directly after the forward slash
     * @param args An array holding every argument after the label
     * @return A boolean showing if the user successfully executed the appropriate command
     * @see Item
     * @see CustomConfig
     */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // check if the user typed /rlcraft, case-insensitive
        if (label.equalsIgnoreCase("rlcraft")) {
            // check if the user only typed /rlcraft with no arguments
            if (args.length == 0) {
                // send the user a message explaining how to use the rlcraft command
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                return true;
            }
            // check if the user typed at least 1 argument
            else if (args.length > 0) {
                // if the first argument is just a space
                if (args[0].isEmpty()) {
                    // send the user a message explaining how to use the rlcraft command
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                    return true;
                }
                // if the user typed /rlcraft give, case-insensitive
                if (args[0].equalsIgnoreCase("give")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        // check if the player has the permission to give himself/herself items
                        if (! (sender.hasPermission("rlcraft.command.give") || sender.isOp())) {
                            // send the player a message explaining that he/she does not have permission to execute the command
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }
                    }
                    /**
                     * The user must be typing from the console if they didn't type in-game as a player.
                     * Check if the user typed more than 1 argument
                     */
                    if (args.length > 1) {
                        // if the second argument is just a space
                        if (args[1].isEmpty()) {
                            // send the user a message explaining how to use the rlcraft command
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                            return true;
                        }
                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            /**
                             * Check if the second argument is a player's name
                             * example: /rlcraft ^~%1t --> invalid player name
                             *          /rlcraft Notch --> valid player name
                             */
                            if (!(Bukkit.getPlayer(args[1]) == null)) {
                                // check if the player to give items to is online
                                if (Bukkit.getPlayer(args[1]).isOnline()) {
                                    Player player = Bukkit.getPlayer(args[1]); // get the online player

                                    // check if the third argument is the command name of an item
                                    if (Item.getCommandNames().contains(args[2])) {
                                        ItemStack customItem = Item.getItem(Item.getItemMap().get(args[2])); // get the item from its command name

                                        // iterate over the player's inventory
                                        for (int i = 0; i < 36; i++) {
                                            // if there is an empty slot in the player's inventory
                                            if (player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) {
                                                // give the player that item
                                                player.getInventory().setItem(i, customItem);
                                                return true;
                                            }
                                        }
                                        // drop the item at the player's location if his/her inventory is full
                                        player.getWorld().dropItemNaturally(player.getLocation(), customItem);
                                    }
                                    // send the user a message showing how they misspelled the item name
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MisspelledItemName")));
                                    return true;
                                }
                                // send the user a message showing how that the specified player is offline
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoOnlinePlayer")));
                                return true;
                            }
                            // send the user a message showing how they misspelled the specified player's name
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MisspelledPlayer")));
                            return true;
                        }
                        // send the user a message explaining how to use the rlcraft command
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                        return true;
                    }
                    // send the user a message explaining how to use the rlcraft command
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Usage")));
                    return true;
                }
                // if the user typed /rlcraft reload, case-insensitive
                else if (args[0].equalsIgnoreCase("reload")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        Player player = (Player) sender; // get the player

                        // check if the player has the permission to reload the plugin
                        if (! (sender.hasPermission("rlcraft.command.reload") || sender.isOp())) {
                            // send the player a message explaining that he/she does not have permission to execute the command
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }

                        /**
                         * The user must be typing from the console if they didn't type in-game as a player.
                         * Send the player a message showing successful reload of the plugin, and reload all configs.
                         */
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Reload")));
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

                    /**
                     * The user must be typing from the console if they didn't type in-game as a player.
                     * Send the player a message showing successful reload of the plugin, and reload all configs.
                     */
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
                // send the user a message explaining how to use the rlcraft command
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("usage")));
                return true;
            }
            return true;
        }
        return false;
    }
}
