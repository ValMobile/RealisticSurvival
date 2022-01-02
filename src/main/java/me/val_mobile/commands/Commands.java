/*
    Copyright (C) 2021  Val_Mobile

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
package me.val_mobile.commands;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.ItemBuilder;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
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
    private final RealisticSurvivalPlugin plugin;
    private final CustomConfig customConfig;

    // constructing the Commands class
    public Commands(RealisticSurvivalPlugin instance) {
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
     * @see ItemBuilder
     * @see CustomConfig
     */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // check if the user typed /realisticsurvival, case-insensitive
        if (label.equalsIgnoreCase("realisticsurvival") || label.equalsIgnoreCase("rsv")) {
            // check if the user only typed /realisticsurvival with no arguments
            if (args.length == 0) {
                // send the user a message explaining how to use the realisticsurvival command
                for (String s : plugin.getConfig().getStringList("Help")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                }
                return true;
            }
            // check if the user typed at least 1 argument
            else if (args.length > 0) {
                // if the first argument is just a space
                if (args[0].isEmpty()) {
                    // send the user a message explaining how to use the realisticsurvival command
                    for (String s : plugin.getConfig().getStringList("Help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                    }
                    return true;
                }
                // if the user typed /realisticsurvival give, case-insensitive
                if (args[0].equalsIgnoreCase("give")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        // check if the player has the permission to give himself/herself items
                        if (! (sender.hasPermission("realisticsurvival.command.give") || sender.hasPermission("realisticsurvival.command.*"))) {
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
                            // send the user a message explaining how to use the realisticsurvival command
                            for (String s : plugin.getConfig().getStringList("Help")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                            }
                            return true;
                        }
                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            /**
                             * Check if the second argument is a player's name
                             * example: /realisticsurvival give ^~%1t --> invalid player name
                             *          /realisticsurvival give Notch --> valid player name
                             */
                            if (!(Bukkit.getPlayer(args[1]) == null)) {
                                // check if the player to give items to is online
                                if (Bukkit.getPlayer(args[1]).isOnline()) {
                                    Player player = Bukkit.getPlayer(args[1]); // get the online player

                                    // check if the third argument is the command name of an item
                                    if (ItemBuilder.getCommandNames().contains(args[2])) {
                                        ItemStack customItem = ItemBuilder.getItem(ItemBuilder.getItemMap().get(args[2])); // get the item from its command name

                                        // amount specified
                                        if (args.length > 3) {
                                            // if the first argument is just a space
                                            if (args[3].isEmpty()) {
                                                // send the user a message explaining how to use the realisticsurvival command
                                                for (String s : plugin.getConfig().getStringList("Help")) {
                                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                                                }
                                                return true;
                                            }

                                            int amount = Integer.parseInt(args[3]);
                                            if (amount > 0) {
                                                customItem.setAmount(amount);
                                            }
                                        }
                                        player.getInventory().addItem(customItem);
                                        return true;
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
                        // send the user a message explaining how to use the realisticsurvival command
                        for (String s : plugin.getConfig().getStringList("Help")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                        }
                        return true;
                    }
                    // send the user a message explaining how to use the realisticsurvival command
                    for (String s : plugin.getConfig().getStringList("Help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                    }
                    return true;
                }
                else if (args[0].equalsIgnoreCase("spawnitem")) {
                    boolean isPlayer = sender instanceof Player;

                    // check if the user is a player
                    if (isPlayer) {
                        // check if the player has the permission to give himself/herself items
                        if (! (sender.hasPermission("realisticsurvival.command.spawnitem") || sender.hasPermission("realisticsurvival.command.*"))) {
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
                            // send the user a message explaining how to use the realisticsurvival command
                            for (String s : plugin.getConfig().getStringList("Help")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                            }
                            return true;
                        }
                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            /**
                             * Check if the second argument is a custom item
                             * example: /realisticsurvival spawnitem ^~%1t --> invalid item name
                             *          /realisticsurvival spawnitem flint_axe --> valid item name
                             */
                            if (ItemBuilder.getCommandNames().contains(args[1])) {
                                ItemStack item = ItemBuilder.getItem(ItemBuilder.getItemMap().get(args[1]));

                                if (isPlayer) {
                                    if (args.length > 4) {
                                        if (!(args[2].isEmpty() || args[3].isEmpty() || args[4].isEmpty())) {
                                            double x = Double.parseDouble(args[2]);
                                            double y = Double.parseDouble(args[3]);
                                            double z = Double.parseDouble(args[4]);

                                            if (args.length > 5) {
                                                if (!args[5].isEmpty()) {
                                                    World world = Bukkit.getWorld(args[5]);
                                                    Location loc = new Location(world, x, y, z);
                                                    world.dropItemNaturally(loc, item);
                                                    return true;
                                                }
                                                // send the user a message explaining how to use the realisticsurvival command
                                                for (String s : plugin.getConfig().getStringList("Help")) {
                                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                                                }
                                                return true;
                                            }
                                            Player player = (Player) sender;
                                            World world = player.getWorld();
                                            Location loc = new Location(world, x, y, z);
                                            world.dropItemNaturally(loc, item);
                                            return true;
                                        }
                                    }
                                }
                                if (args.length > 5) {

                                }
                                // send the user a message explaining how to use the realisticsurvival command
                                for (String s : plugin.getConfig().getStringList("Help")) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                                }
                                return true;
                            }
                            // send the user a message showing how they misspelled the item name
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MisspelledItemName")));
                            return true;
                        }
                        // send the user a message explaining how to use the realisticsurvival command
                        for (String s : plugin.getConfig().getStringList("Help")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                        }
                        return true;
                    }
                    // send the user a message explaining how to use the realisticsurvival command
                    for (String s : plugin.getConfig().getStringList("Help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                    }
                    return true;
                }
//                else if (args[0].equalsIgnoreCase("spawnmob")) {
//                    Player player = (Player) sender;
//                    FireDragon dragon = new FireDragon(EntityTypes.v, player.getLocation(), 5, plugin);
//
//                    dragon.spawn();
//                }
                // if the user typed /realisticsurvival reload, case-insensitive
                else if (args[0].equalsIgnoreCase("reload")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        Player player = (Player) sender; // get the player

                        // check if the player has the permission to reload the plugin
                        if (! (sender.hasPermission("realisticsurvival.command.reload") || sender.hasPermission("realisticsurvival.command.*"))) {
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
                        customConfig.reloadNtrConfig();
                        customConfig.reloadLycanitesMobsConfig();
                        customConfig.reloadItemConfig();
                        customConfig.reloadRecipeConfig();
                        customConfig.reloadTanConfig();
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
                    customConfig.reloadNtrConfig();
                    customConfig.reloadLycanitesMobsConfig();
                    customConfig.reloadItemConfig();
                    customConfig.reloadRecipeConfig();
                    customConfig.reloadTanConfig();
                    return true;
                }
                // if the user typed /realisticsurvival thirst, case-insensitive
                else if (args[0].equalsIgnoreCase("thirst")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        // check if the player has the permission to change thirst
                        if (! (sender.hasPermission("realisticsurvival.command.thirst") || sender.hasPermission("realisticsurvival.command.*"))) {
                            // send the player a message explaining that he/she does not have permission to execute the command
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }

                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            /**
                             * Check if the second argument is a player's name
                             * example: /realisticsurvival ^~%1t --> invalid player name
                             *          /realisticsurvival Notch --> valid player name
                             */
                            if (!(Bukkit.getPlayer(args[1]) == null)) {
                                // check if the player to change thirst to is online
                                if (Bukkit.getPlayer(args[1]).isOnline()) {
                                    Player player = Bukkit.getPlayer(args[1]); // get the online player

                                    int thirst;
                                    try {
                                        thirst = Integer.parseInt(args[2]);
                                    }
                                    catch (Exception e) {
                                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("InvalidArguments")));
                                        return true;
                                    }

                                    Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), (double) thirst);
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
                        return true;
                    }
                    return true;
                }
                // if the user typed /realisticsurvival temperature, case-insensitive
                else if (args[0].equalsIgnoreCase("temperature")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        // check if the player has the permission to change temperature
                        if (! (sender.hasPermission("realisticsurvival.command.temperature") || sender.hasPermission("realisticsurvival.command.*"))) {
                            // send the player a message explaining that he/she does not have permission to execute the command
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }

                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            /**
                             * Check if the second argument is a player's name
                             * example: /realisticsurvival ^~%1t --> invalid player name
                             *          /realisticsurvival Notch --> valid player name
                             */
                            if (!(Bukkit.getPlayer(args[1]) == null)) {
                                // check if the player to change temperature to is online
                                if (Bukkit.getPlayer(args[1]).isOnline()) {
                                    Player player = Bukkit.getPlayer(args[1]); // get the online player

                                    int temperature;
                                    try {
                                        temperature = Integer.parseInt(args[2]);
                                    }
                                    catch (Exception e) {
                                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("InvalidArguments")));
                                        return true;
                                    }

                                    Utils.setOrReplaceEntry(PlayerRunnable.getTemperature(), player.getName(), (double) temperature);
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
                        return true;
                    }
                    return true;
                }
                else if (args[0].equalsIgnoreCase("help")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        // check if the player has the permission to change temperature
                        if (!(sender.hasPermission("realisticsurvival.command.help") || sender.hasPermission("realisticsurvival.command.*"))) {
                            // send the player a message explaining that he/she does not have permission to execute the command
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }
                    }

                    for (String s : plugin.getConfig().getStringList("Help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                    }
                    return true;
                }
                else if (args[0].equalsIgnoreCase("version")) {
                    // check if the user is a player
                    if (sender instanceof Player) {
                        // check if the player has the permission to change temperature
                        if (!(sender.hasPermission("realisticsurvival.command.version") || sender.hasPermission("realisticsurvival.command.*"))) {
                            // send the player a message explaining that he/she does not have permission to execute the command
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
                            return true;
                        }
                    }

                    String version = plugin.getConfig().getString("Version");
                    version = version.replaceAll("%version%", plugin.getDescription().getVersion());

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', version));
                    return true;
                }
                for (String s : plugin.getConfig().getStringList("Help")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
                }
                return true;
            }
            return true;
        }
        return false;
    }
}