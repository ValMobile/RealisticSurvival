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
package me.val_mobile.commands;

import me.val_mobile.data.RSVConfig;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.tan.TemperatureCalculateTask;
import me.val_mobile.tan.ThirstCalculateTask;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Collection;

/**
 * Commands is a class that allows users to
 * access the plugin's commands in-game
 * @author Val_Mobile
 * @version 1.2.3
 * @since 1.0
 */
public class Commands implements CommandExecutor {

    /**
     * Dependency injecting the main and custom config class for use
     * The custom config class must be injected because its non-static methods are needed
     */
    private final RealisticSurvivalPlugin plugin;

    // constructing the Commands class
    public Commands(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Performs various actions depending on what the player types as a command
     * @param sender The user who typed the command
     * @param cmd The command typed
     * @param label The word directly after the forward slash
     * @param args An array holding every argument after the label
     * @return A boolean showing if the user successfully executed the appropriate command
     * @see RSVItem
     */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // check if the user typed /realisticsurvival, case-insensitive
        if (label.equalsIgnoreCase("realisticsurvival") || label.equalsIgnoreCase("rsv")) {

            boolean isPlayer = false;

            if (sender instanceof Player) {
                isPlayer = true;
            }

            // check if the user only typed /realisticsurvival with no arguments
            if (args.length == 0) {
                // send the user a message explaining how to use the realisticsurvival command
                sendHelpMessage(sender);
                return true;
            }
            // if the first argument is just a space
            if (args[0].isEmpty()) {
                // send the user a message explaining how to use the realisticsurvival command
                sendHelpMessage(sender);
                return true;
            }
            switch ((args[0].toLowerCase())) {
                case "give" -> {
                    // check if the player has the permission to give himself/herself items
                    if (!(sender.hasPermission("realisticsurvival.command.give") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }
                    /**
                     * The user must be typing from the console if they didn't type in-game as a player.
                     * Check if the user typed more than 1 argument
                     */
                    if (args.length > 1) {
                        // if the second argument is just a space
                        if (args[1].isEmpty()) {
                            // send the user a message explaining how to use the realisticsurvival command
                            sendHelpMessage(sender);
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

                                    ItemStack customItem = RSVItem.getItem(args[2]); // get the item from its command name

                                    if (Utils.isItemReal(customItem)) {
                                        // amount specified
                                        if (args.length > 3) {
                                            // if the first argument is just a space
                                            if (args[3].isEmpty()) {
                                                // send the user a message explaining how to use the realisticsurvival command
                                                sendHelpMessage(sender);
                                                return true;
                                            }

                                            int amount = Integer.parseInt(args[3]);
                                            if (amount > 0) {
                                                customItem.setAmount(amount);
                                            }
                                        }
                                        player.getInventory().addItem(customItem);
                                        Utils.playSound(player.getLocation(), "ENTITY_ITEM_PICKUP", 1f, 1f);
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
                        return true;
                    }
                    return true;
                }
                case "reload" -> {
                    // check if the player has the permission to reload the plugin
                    if (!(sender.hasPermission("realisticsurvival.command.reload") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    /**
                     * The user must be typing from the console if they didn't type in-game as a player.
                     * Send the player a message showing successful reload of the plugin, and reload all configs.
                     */
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Reload")));

                    Collection<RSVConfig> configs = RSVConfig.getConfigList();

                    for (RSVConfig config : configs) {
                        config.reloadConfig();
                    }
                    plugin.reloadConfig();
                    return true;
                }
                case "spawnitem" -> {
                    // check if the player has the permission to give himself/herself items
                    if (!(sender.hasPermission("realisticsurvival.command.spawnitem") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    /**
                     * The user must be typing from the console if they didn't type in-game as a player.
                     * Check if the user typed more than 1 argument
                     */
                    if (args.length > 1) {
                        // if the second argument is just a space
                        if (args[1].isEmpty()) {
                            return true;
                        }
                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            ItemStack item = RSVItem.getItem(args[1]);

                            /**
                             * Check if the second argument is a custom item
                             * example: /realisticsurvival spawnitem ^~%1t --> invalid item name
                             *          /realisticsurvival spawnitem flint_hatchet --> valid item name
                             */
                            if (Utils.isItemReal(item)) {
                                if (args.length > 5) {
                                    if (!(args[2].isEmpty() || args[3].isEmpty() || args[4].isEmpty() || args[5].isEmpty())) {
                                        int amount = Integer.parseInt(args[2]);

                                        double x = Double.parseDouble(args[3]);
                                        double y = Double.parseDouble(args[4]);
                                        double z = Double.parseDouble(args[5]);

                                        item.setAmount(amount);

                                        if (args.length > 6) {
                                            if (!args[6].isEmpty()) {
                                                World world = Bukkit.getWorld(args[6]);
                                                Location loc = new Location(world, x, y, z);
                                                world.dropItemNaturally(loc, item);
                                                return true;
                                            }
                                            return true;
                                        }
                                        if (isPlayer) {
                                            Player player = (Player) sender;
                                            World world = player.getWorld();
                                            Location loc = new Location(world, x, y, z);
                                            world.dropItemNaturally(loc, item);
                                            return true;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return true;
                            }
                            // send the user a message showing how they misspelled the item name
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MisspelledItemName")));
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                case "spawnmob" -> {
                    // check if the player has the permission to summon mobs
                    if (!(sender.hasPermission("realisticsurvival.command.spawnmob") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    /**
                     * The user must be typing from the console if they didn't type in-game as a player.
                     * Check if the user typed more than 1 argument
                     */
                    if (args.length > 1) {
                        // if the second argument is just a space
                        if (args[1].isEmpty()) {
                            return true;
                        }
                        // check if the user typed more than 2 arguments
                        if (args.length > 2) {
                            /**
                             * Check if the second argument is the name of a custom mob
                             * example: /realisticsurvival spawnmob ^~%1t --> invalid item name
                             *          /realisticsurvival spawnmob fire_dragon --> valid item name
                             */
                            if (args.length > 4) {
                                if (!(args[2].isEmpty() || args[3].isEmpty() || args[4].isEmpty())) {

                                    double x = Double.parseDouble(args[2]);
                                    double y = Double.parseDouble(args[3]);
                                    double z = Double.parseDouble(args[4]);

                                    if (args.length > 5) {
                                        if (!args[5].isEmpty()) {
                                            World world = Bukkit.getWorld(args[5]);
                                            Location loc = new Location(world, x, y, z);
                                            switch (args[1].toLowerCase()) {
                                                case "fire_dragon" -> Utils.spawnFireDragon(loc, plugin);
                                                case "ice_dragon" -> Utils.spawnIceDragon(loc, plugin);
                                                case "lightning_dragon" -> Utils.spawnLightningDragon(loc, plugin);
                                                case "sea_serpent" -> Utils.spawnSeaSerpent(loc, plugin);
                                                case "siren" -> Utils.spawnSiren(loc, plugin);
                                                default -> {
                                                }
                                            }
                                        }
                                        return true;
                                    }

                                    if (isPlayer) {
                                        Player player = (Player) sender;
                                        World world = player.getWorld();
                                        Location loc = new Location(world, x, y, z);

                                        switch (args[5].toLowerCase()) {
                                            case "fire_dragon" -> Utils.spawnFireDragon(loc, plugin);
                                            case "ice_dragon" -> Utils.spawnIceDragon(loc, plugin);
                                            case "lightning_dragon" -> Utils.spawnLightningDragon(loc, plugin);
                                            case "sea_serpent" -> Utils.spawnSeaSerpent(loc, plugin);
                                            case "siren" -> Utils.spawnSiren(loc, plugin);
                                        }
                                    }
                                }
                                return true;
                            }
                            return true;
                            // send the user a message showing how they misspelled the item name
                        }
                        return true;
                    }
                    return true;
                }
                case "temperature" -> {
                    // check if the player has the permission to change temperature
                    if (!(sender.hasPermission("realisticsurvival.command.temperature") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    // check if the user typed more than 2 arguments
                    if (args.length > 2) {
                        /**
                         * Check if the second argument is a player's name
                         * example: /realisticsurvival ^~%1t --> invalid player name
                         *          /realisticsurvival Notch --> valid player name
                         */
                        if (Bukkit.getPlayer(args[1]) != null) {
                            // check if the player to change temperature to is online
                            if (Bukkit.getPlayer(args[1]).isOnline()) {
                                Player player = Bukkit.getPlayer(args[1]); // get the online player

                                int temperature;
                                try {
                                    temperature = Integer.parseInt(args[2]);
                                } catch (Exception e) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("InvalidArguments")));
                                    return true;
                                }

                                TemperatureCalculateTask task = TemperatureCalculateTask.getTasks().get(player.getUniqueId());

                                if (task != null) {
                                    task.setTemp(temperature);
                                }
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
                case "thirst" -> {
                    // check if the player has the permission to change thirst
                    if (!(sender.hasPermission("realisticsurvival.command.thirst") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
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
                                } catch (Exception e) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("InvalidArguments")));
                                    return true;
                                }

                                ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(player.getUniqueId());

                                if (task != null) {
                                    task.setThirstLvl(thirst);
                                }
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
                case "resetitem" -> {
                    // check if the player has the permission to change temperature

                    if (!(sender.hasPermission("realisticsurvival.command.resetitem") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }
                    if (sender instanceof Player) {
                        Player player = ((Player) sender).getPlayer();
                        PlayerInventory inv = player.getInventory();
                        ItemStack itemMainHand = inv.getItemInMainHand();

                        if (RSVItem.isRSVItem(itemMainHand)) {
                            inv.setItemInMainHand(RSVItem.convertItemStackToRSVItem(itemMainHand));
                            player.updateInventory();
                        }
                    }
                    return true;
                }
                case "help" -> {
                    // check if the player has the permission to change temperature

                    if (!(sender.hasPermission("realisticsurvival.command.help") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }
                    sendHelpMessage(sender);
                    return true;
                }
                case "version" -> {
                    // check if the player has the permission to change temperature
                    if (!(sender.hasPermission("realisticsurvival.command.version") || sender.hasPermission("realisticsurvival.command.*"))) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    String version = plugin.getConfig().getString("Version");
                    version = version.replaceAll("%PLUGIN_VERSION%", plugin.getDescription().getVersion());
                    version = version.replaceAll("%SERVER_VERSION%", Bukkit.getVersion());
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', version));
                    return true;
                }
                default -> {
                    return true;
                }
            }
        }
        return false;
    }

    private void sendHelpMessage(CommandSender sender) {
        // send the user a message explaining how to use the realisticsurvival command
        for (String s : plugin.getConfig().getStringList("Help")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
        }
    }

    private void sendNoPermissionMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
    }
}