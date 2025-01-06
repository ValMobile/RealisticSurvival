/*
    Copyright (C) 2025  Val_Mobile

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
import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.tan.*;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.val_mobile.rsv.RSVPlugin.NAME;

/**
 * Commands is a class that allows users to
 * access the plugin's commands in-game
 * @author Val_Mobile
 * @version 1.2.9-RELEASE
 * @since 1.0
 */
public class Commands implements CommandExecutor {

    /**
     * Dependency injecting the main and custom config class for use
     * The custom config class must be injected because its non-static methods are needed
     */
    private final RSVPlugin plugin;
    private final FileConfiguration config;

    // constructing the Commands class
    public Commands(RSVPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getCommandsConfig();
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
    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        // check if the user typed /realisticsurvival, case-insensitive
        if (label.equalsIgnoreCase(NAME) || label.equalsIgnoreCase("rsv")) {
            if (sender instanceof BlockCommandSender) {
                if (!config.getBoolean("EnableCommandBlockUsage")) {
                    sendNoPermissionMessage(sender);
                    return true;
                }
            }
            else if (sender instanceof CommandMinecart) {
                if (!config.getBoolean("EnableCommandBlockMinecartUsage")) {
                    sendNoPermissionMessage(sender);
                    return true;
                }
            }

            // check if the user only typed /realisticsurvival with no arguments
            if (args.length == 0) {
                // send the user a message explaining how to use the realisticsurvival command
                sendIncompleteCommandMsg(sender);
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "give" -> {
                    // check if the player has the permission to give himself/herself items
                    if (!sender.hasPermission("realisticsurvival.command.give")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    // check if the user typed more than 3 arguments
                    if (args.length < 3) {
                        sendIncompleteCommandMsg(sender);
                        return true;
                    }

                    RSVItem customItem = RSVItem.getItem(args[2]); // get the item from its command name

                    if (!Utils.isItemReal(customItem)) {
                        sender.sendMessage(Utils.translateMsg(config.getString("MisspelledItemName"), sender, Map.of("MISSPELLED_NAME", args[2])));
                        return true;
                    }

                    int amount = 1;

                    if (args.length > 3) {
                        try {
                            amount = Integer.parseInt(args[3]);
                        } catch (NumberFormatException e) {
                            sendInvalidArgumentMsg(sender);
                            return true;
                        }
                    }

                    if (amount < 1) {
                        if (config.getBoolean("Give.TooFewItems.Enabled"))
                            sender.sendMessage(Utils.translateMsg(config.getString("Give.TooFewItems.Message"), sender, null));
                        return true;
                    }

                    if (amount > config.getInt("Give.TooManyItems.MaxValue")) {
                        if (config.getBoolean("Give.TooManyItems.Enabled")) {
                            Map<String, Object> placeholders = Map.of("MAXIMUM_VALUE", config.getInt("Give.TooManyItems.MaxValue"));
                            sender.sendMessage(Utils.translateMsg(config.getString("Give.TooManyItems.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    List<Entity> targets = Bukkit.selectEntities(sender, args[1]);

                    if (targets.isEmpty()) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    List<Player> filteredTargets = new ArrayList<>();

                    for (Entity e : targets) {
                        if (e instanceof Player player && player.isOnline()) {
                            filteredTargets.add(player);
                        }
                    }

                    if (filteredTargets.isEmpty()) {
                        sendInvalidTargetMsg(sender);
                        return true;
                    }

                    for (Player player : filteredTargets) {
                        Utils.addItemToInventory(player.getInventory(), customItem, amount, player.getLocation());
                        playSound(player);
                    }

                    if (config.getBoolean("Give.CorrectExecution.Enabled")) {
                        if (filteredTargets.size() == 1) {
                            Map<String, Object> placeholders = Map.of("VALUE", amount, "DISPLAY_NAME", ChatColor.stripColor(customItem.getItemMeta().getDisplayName()), "PLAYER_NAME", filteredTargets.get(0).getDisplayName());
                            sender.sendMessage(Utils.translateMsg(config.getString("Give.CorrectExecution.SingleTargetMessage"), sender, placeholders));
                        }
                        else {
                            Map<String, Object> placeholders = Map.of("VALUE", amount, "DISPLAY_NAME", ChatColor.stripColor(customItem.getItemMeta().getDisplayName()));
                            sender.sendMessage(Utils.translateMsg(config.getString("Give.CorrectExecution.MultipleTargetMessage"), sender, placeholders));
                        }
                    }

                    return true;
                }
                case "reload" -> {
                    // check if the player has the permission to reload the plugin
                    if (!sender.hasPermission("realisticsurvival.command.reload")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    RSVConfig.getConfigList().forEach(config -> config.reloadConfig());

                    if (config.getBoolean("Reload.CorrectExecution.Enabled"))
                        sender.sendMessage(Utils.translateMsg(config.getString("Reload.CorrectExecution.Message"), sender, null));

                    return true;
                }
                case "spawnitem" -> {
                    // check if the player has the permission to give himself/herself items
                    if (!sender.hasPermission("realisticsurvival.command.spawnitem")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    if (args.length == 1) {
                        sendIncompleteCommandMsg(sender);
                        return true;
                    }

                    ItemStack item = RSVItem.getItem(args[1]);

                    /**
                     * Check if the second argument is a custom item
                     * example: /realisticsurvival spawnitem ^~%1t --> invalid item name
                     *          /realisticsurvival spawnitem flint_hatchet --> valid item name
                     */
                    if (!Utils.isItemReal(item)) {
                        sender.sendMessage(Utils.translateMsg(config.getString("MisspelledItemName"), sender, Map.of("MISSPELLED_NAME", args[1])));
                        return true;
                    }

                    int amount = 1;
                    World world;
                    double x, y, z;

                    if (sender instanceof Player player) {
                        if (args.length == 2) {
                            world = player.getWorld();
                            Location loc = player.getLocation();
                            x = loc.getX();
                            y = loc.getY();
                            z = loc.getZ();
                        }
                        else {
                            if (args.length < 6) {
                                sendIncompleteCommandMsg(player);
                                return true;
                            }

                            try {
                                amount = Integer.parseInt(args[2]);

                                x = Double.parseDouble(args[3]);
                                y = Double.parseDouble(args[4]);
                                z = Double.parseDouble(args[5]);
                            }
                            catch (NumberFormatException e) {
                                sendInvalidArgumentMsg(sender);
                                return true;
                            }


                            world = player.getWorld();

                            if (args.length == 7) {
                                world = Bukkit.getWorld(args[6]);
                            }
                        }
                    }
                    else {
                        if (args.length < 7) {
                            sendIncompleteCommandMsg(sender);
                            return true;
                        }

                        try {
                            amount = Integer.parseInt(args[2]);

                            x = Double.parseDouble(args[3]);
                            y = Double.parseDouble(args[4]);
                            z = Double.parseDouble(args[5]);
                            world = Bukkit.getWorld(args[6]);
                        }
                        catch (NumberFormatException e) {
                            sendInvalidArgumentMsg(sender);
                            return true;
                        }
                    }

                    if (world == null) {
                        sender.sendMessage(Utils.translateMsg(config.getString("MisspelledWorld"), sender, null));
                        return true;
                    }

                    if (amount < 1) {
                        if (config.getBoolean("SpawnItem.TooFewItems.Enabled"))
                            sender.sendMessage(Utils.translateMsg(config.getString("SpawnItem.TooFewItems.Message"), sender, null));
                        return true;
                    }

                    if (amount > item.getMaxStackSize()) {
                        if (config.getBoolean("SpawnItem.ExceedsStackSize.Enabled")) {
                            Map<String, Object> placeholders = Map.of("STACK_SIZE", item.getMaxStackSize());
                            sender.sendMessage(Utils.translateMsg(config.getString("SpawnItem.ExceedsStackSize.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    if (amount > config.getInt("SpawnItem.TooManyItems.MaxValue")) {
                        if (config.getBoolean("SpawnItem.TooManyItems.Enabled")) {
                            Map<String, Object> placeholders = Map.of("MAXIMUM_VALUE", config.getInt("SpawnItem.TooManyItems.MaxValue"));
                            sender.sendMessage(Utils.translateMsg(config.getString("SpawnItem.TooManyItems.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    if (amount <= item.getMaxStackSize() || !config.getBoolean("SpawnItem.CheckStackSize")) {
                        item.setAmount(amount);
                    }
                    else {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    world.dropItemNaturally(new Location(world, x, y, z), item);

                    if (config.getBoolean("SpawnItem.CorrectExecution.Enabled")) {
                        Map<String, Object> placeholders = Map.of("ITEM_NAME", item.hasItemMeta() ? item.getItemMeta().getDisplayName() : args[1], "X_COORD", x, "Y_COORD", y, "Z_COORD", z, "WORLD_NAME", world.getName());
                        sender.sendMessage(Utils.translateMsg(config.getString("SpawnItem.CorrectExecution.Message"), sender, placeholders));
                    }

                    return true;
                }
                case "summon" -> {
                    // check if the player has the permission to summon mobs
                    if (!sender.hasPermission("realisticsurvival.command.summon")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    if (args.length == 1) {
                        sendIncompleteCommandMsg(sender);
                        return true;
                    }

                    RSVMob mob;
                    World world;
                    double x, y, z;

                    if (sender instanceof Player player) {
                        if (args.length == 2) {
                            Location loc = player.getLocation();
                            world = loc.getWorld();
                            x = loc.getX();
                            y = loc.getY();
                            z = loc.getZ();
                        }
                        else {
                            if (args.length < 5) {
                                sendIncompleteCommandMsg(player);
                                return true;
                            }

                            try {
                                x = Double.parseDouble(args[2]);
                                y = Double.parseDouble(args[3]);
                                z = Double.parseDouble(args[4]);
                            }
                            catch (NumberFormatException e) {
                                sendInvalidArgumentMsg(sender);
                                return true;
                            }


                            world = player.getWorld();

                            if (args.length == 6) {
                                world = Bukkit.getWorld(args[6]);
                            }
                        }
                    }
                    else {
                        if (args.length < 6) {
                            sendIncompleteCommandMsg(sender);
                            return true;
                        }

                        try {
                            x = Double.parseDouble(args[2]);
                            y = Double.parseDouble(args[3]);
                            z = Double.parseDouble(args[4]);
                            world = Bukkit.getWorld(args[5]);
                        }
                        catch (NumberFormatException e) {
                            sendInvalidArgumentMsg(sender);
                            return true;
                        }
                    }

                    if (world == null) {
                        sender.sendMessage(Utils.translateMsg(config.getString("MisspelledWorld"), sender, null));
                        return true;
                    }

                    Location loc = new Location(world, x, y, z);
                    String mobName = args[1].toLowerCase();

                    switch (mobName) {
                        case "fire_dragon" -> mob = Utils.spawnFireDragon(loc);
                        case "ice_dragon" -> mob = Utils.spawnIceDragon(loc);
                        case "lightning_dragon" -> mob = Utils.spawnLightningDragon(loc);
                        case "sea_serpent" -> mob = Utils.spawnSeaSerpent(loc);
                        case "siren" -> mob = Utils.spawnSiren(loc);
                        default -> mob = null;
                    }

                    if (mob == null) {
                        if (config.getBoolean("Summon.MisspelledMob.Enabled"))
                            sender.sendMessage(Utils.translateMsg(config.getString("Summon.MisspelledMob.Message"), sender, Map.of("MISSPELLED_NAME", mobName)));
                        return true;
                    }

                    switch (mobName) {
                        case "fire_dragon", "ice_dragon", "lightning_dragon", "sea_serpent", "siren" -> {
                            if (!RSVModule.getModule(IceFireModule.NAME).isEnabled(world)) {
                                if (config.getBoolean("Summon.RequiredModulesDisabled.Enabled")) {
                                    Map<String, Object> placeholders = Map.of("REQUIRED_MODULES", String.join(", ", mob.getRequiredModules()));
                                    sender.sendMessage(Utils.translateMsg(config.getString("Summon.RequiredModulesDisabled.Message"), sender, placeholders));
                                }
                                return true;
                            }
                        }
                    }

                    mob.addEntityToWorld(world);

                    if (config.getBoolean("Summon.CorrectExecution.Enabled")) {
                        Map<String, Object> placeholders = Map.of("MOB_NAME", StringUtils.capitalize(mobName.replaceAll("_", "")), "X_COORD", x, "Y_COORD", y, "Z_COORD", z, "WORLD_NAME", world.getName());
                        sender.sendMessage(Utils.translateMsg(config.getString("Summon.CorrectExecution.Message"), sender, placeholders));
                    }
                    return true;
                }
                case "temperature" -> {
                    // check if the player has the permission to change temperature
                    if (!sender.hasPermission("realisticsurvival.command.temperature")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    if (args.length <= 2) {
                        sendIncompleteCommandMsg(sender);
                        return true;
                    }

                    TempManager manager = ((TanModule) RSVModule.getModule(TanModule.NAME)).getTempManager();

                    List<Entity> targets = Bukkit.selectEntities(sender, args[1]);

                    if (targets == null) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    if (!RSVModule.getModule(TanModule.NAME).isGloballyEnabled()) {
                        if (config.getBoolean("Temperature.TanModuleDisabled.Enabled"))
                            sender.sendMessage(Utils.translateMsg(config.getString("Temperature.TanModuleDisabled.Message"), sender, null));
                        return true;
                    }

                    List<Player> filteredTargets = new ArrayList<>();

                    for (Entity e : targets) {
                        if (e instanceof Player player && player.isOnline() && manager.isTempEnabled(player)) {
                            filteredTargets.add(player);
                        }
                    }

                    if (filteredTargets.isEmpty()) {
                        sendInvalidTargetMsg(sender);
                        return true;
                    }

                    double temperature = (TemperatureCalculateTask.MAXIMUM_TEMPERATURE + TemperatureCalculateTask.MINIMUM_TEMPERATURE) / 2;
                    double addition = 0;
                    boolean isRelative = false;

                    try {
                        if (args[2].startsWith("~")) {
                            isRelative = true;
                            addition = Double.parseDouble(args[2].substring(1));
                        }
                        else {
                            temperature = Double.parseDouble(args[2]);
                        }
                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    if (temperature < TemperatureCalculateTask.MINIMUM_TEMPERATURE) {
                        if (config.getBoolean("Temperature.BelowMinValue.Enabled")) {
                            Map<String, Object> placeholders = Map.of("MINIMUM_VALUE", TemperatureCalculateTask.MINIMUM_TEMPERATURE);
                            sender.sendMessage(Utils.translateMsg(config.getString("Temperature.BelowMinValue.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    if (temperature > TemperatureCalculateTask.MAXIMUM_TEMPERATURE) {
                        if (config.getBoolean("Temperature.AboveMaxValue.Enabled")) {
                            Map<String, Object> placeholders = Map.of("MAXIMUM_VALUE", TemperatureCalculateTask.MAXIMUM_TEMPERATURE);
                            sender.sendMessage(Utils.translateMsg(config.getString("Temperature.AboveMaxValue.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    double oldTemp = manager.getTemperature(filteredTargets.get(0));

                    if (isRelative) {
                        double finalAddition = addition;
                        filteredTargets.forEach(player -> manager.addTemperature(player, finalAddition));
                    }
                    else {
                        double finalTemperature = temperature;
                        filteredTargets.forEach(player -> manager.setTemperature(player, finalTemperature));
                    }

                    if (config.getBoolean("Temperature.CorrectExecution.Enabled")) {
                        if (filteredTargets.size() == 1) {
                            if (isRelative) {
                                Map<String, Object> placeholders = Map.of("PLAYER_NAME", filteredTargets.get(0).getDisplayName(), "OLD_TEMPERATURE", oldTemp, "NEW_TEMPERATURE", temperature, "CHANGE", addition);
                                sender.sendMessage(Utils.translateMsg(config.getString("Temperature.CorrectExecution.SingleTargetRelativeMessage"), sender, placeholders));
                            }
                            else {
                                Map<String, Object> placeholders = Map.of("PLAYER_NAME", filteredTargets.get(0).getDisplayName(), "OLD_TEMPERATURE", oldTemp, "NEW_TEMPERATURE", temperature);
                                sender.sendMessage(Utils.translateMsg(config.getString("Temperature.CorrectExecution.SingleTargetMessage"), sender, placeholders));
                            }

                        }
                        else {
                            if (isRelative) {
                                Map<String, Object> placeholders = Map.of("CHANGE", addition);
                                sender.sendMessage(Utils.translateMsg(config.getString("Temperature.CorrectExecution.MultipleTargetRelativeMessage"), sender, placeholders));
                            }
                            else {
                                Map<String, Object> placeholders = Map.of("NEW_TEMPERATURE", temperature);
                                sender.sendMessage(Utils.translateMsg(config.getString("Temperature.CorrectExecution.MultipleTargetMessage"), sender, placeholders));
                            }
                        }
                    }

                    return true;
                }
                case "thirst" -> {
                    // check if the player has the permission to change thirst
                    if (!sender.hasPermission("realisticsurvival.command.thirst")) {
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    if (args.length <= 2) {
                        sendIncompleteCommandMsg(sender);
                        return true;
                    }

                    ThirstManager manager = ((TanModule) RSVModule.getModule(TanModule.NAME)).getThirstManager();

                    List<Entity> targets = Bukkit.selectEntities(sender, args[1]);

                    if (targets.isEmpty()) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    if (!RSVModule.getModule(TanModule.NAME).isGloballyEnabled()) {
                        if (config.getBoolean("Thirst.TanModuleDisabled.Enabled"))
                            sender.sendMessage(Utils.translateMsg(config.getString("Thirst.TanModuleDisabled.Message"), sender, null));
                        return true;
                    }

                    List<Player> filteredTargets = new ArrayList<>();

                    for (Entity e : targets) {
                        if (e instanceof Player player && player.isOnline() && manager.isThirstEnabled(player)) {
                            filteredTargets.add(player);
                        }
                    }

                    if (filteredTargets.isEmpty()) {
                        sendInvalidTargetMsg(sender);
                        return true;
                    }

                    int thirst = (ThirstCalculateTask.MAXIMUM_THIRST + ThirstCalculateTask.MINIMUM_THIRST) / 2;
                    int addition = 0;
                    boolean isRelative = false;

                    try {
                        if (args[2].startsWith("~")) {
                            isRelative = true;
                            addition = Integer.parseInt(args[2].substring(1));
                        }
                        else {
                            thirst = Integer.parseInt(args[2]);
                        }
                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    if (thirst < ThirstCalculateTask.MINIMUM_THIRST) {
                        if (config.getBoolean("Thirst.BelowMinValue.Enabled")) {
                            Map<String, Object> placeholders = Map.of("MINIMUM_VALUE", ThirstCalculateTask.MINIMUM_THIRST);
                            sender.sendMessage(Utils.translateMsg(config.getString("Thirst.BelowMinValue.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    if (thirst > ThirstCalculateTask.MAXIMUM_THIRST) {
                        if (config.getBoolean("Thirst.AboveMaxValue.Enabled")) {
                            Map<String, Object> placeholders = Map.of("MAXIMUM_VALUE", ThirstCalculateTask.MAXIMUM_THIRST);
                            sender.sendMessage(Utils.translateMsg(config.getString("Thirst.AboveMaxValue.Message"), sender, placeholders));
                        }
                        return true;
                    }

                    int oldThirst = manager.getThirst(filteredTargets.get(0));

                    if (isRelative) {
                        int finalAddition = addition;
                        filteredTargets.forEach(player -> manager.addThirst(player, finalAddition));
                    }
                    else {
                        int finalThirst = thirst;
                        filteredTargets.forEach(player -> manager.setThirst(player, finalThirst));
                    }

                    if (config.getBoolean("Thirst.CorrectExecution.Enabled")) {
                        if (filteredTargets.size() == 1) {
                            if (isRelative) {
                                Map<String, Object> placeholders = Map.of("PLAYER_NAME", filteredTargets.get(0).getDisplayName(), "OLD_THIRST", oldThirst, "NEW_THIRST", thirst, "CHANGE", addition);
                                sender.sendMessage(Utils.translateMsg(config.getString("Thirst.CorrectExecution.SingleTargetRelativeMessage"), sender, placeholders));
                            }
                            else {
                                Map<String, Object> placeholders = Map.of("PLAYER_NAME", filteredTargets.get(0).getDisplayName(), "OLD_THIRST", oldThirst, "NEW_THIRST", thirst);
                                sender.sendMessage(Utils.translateMsg(config.getString("Thirst.CorrectExecution.SingleTargetMessage"), sender, placeholders));
                            }

                        }
                        else {
                            if (isRelative) {
                                Map<String, Object> placeholders = Map.of("CHANGE", addition);
                                sender.sendMessage(Utils.translateMsg(config.getString("Thirst.CorrectExecution.MultipleTargetRelativeMessage"), sender, placeholders));
                            }
                            else {
                                Map<String, Object> placeholders = Map.of("NEW_THIRST", thirst);
                                sender.sendMessage(Utils.translateMsg(config.getString("Thirst.CorrectExecution.MultipleTargetMessage"), sender, placeholders));
                            }
                        }
                    }
                    return true;
                }
                case "resetitem" -> {
                    if (!sender.hasPermission("realisticsurvival.command.resetitem")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    if (args.length == 1) {
                        if (sender instanceof Player player) {
                            PlayerInventory inv = player.getInventory();
                            ItemStack itemMainHand = inv.getItemInMainHand();

                            if (RSVItem.isRSVItem(itemMainHand)) {
                                inv.setItemInMainHand(RSVItem.convertItemStackToRSVItem(itemMainHand));
                                player.updateInventory();
                                if (config.getBoolean("ResetItem.CorrectExecution.Enabled")) {
                                    sender.sendMessage(Utils.translateMsg(config.getString("ResetItem.CorrectExecution.MainHand.SingleTargetMessage"), sender, null));
                                }
                            }
                            else {
                                if (config.getBoolean("ResetItem.NoValidItemsFound.Enabled")) {
                                    sender.sendMessage(Utils.translateMsg(config.getString("ResetItem.NoValidItemsFound.MainHand.SingleTargetMessage"), sender, null));
                                }
                            }
                            return true;
                        }
                        sendInvalidTargetMsg(sender);
                        return true;
                    }
                    List<Entity> targets = Bukkit.selectEntities(sender, args[1]);

                    if (targets.isEmpty()) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    List<Player> filteredTargets = new ArrayList<>();

                    for (Entity e : targets) {
                        if (e instanceof Player player && player.isOnline()) {
                            filteredTargets.add(player);
                        }
                    }

                    if (filteredTargets.isEmpty()) {
                        sendInvalidTargetMsg(sender);
                        return true;
                    }

                    boolean checkEntireInv = args.length >= 3 && args[2].equalsIgnoreCase("all");
                    boolean reset = false;
                    PlayerInventory inv;
                    ItemStack item;

                    for (Player player : filteredTargets) {
                        inv = player.getInventory();

                        if (checkEntireInv) {
                            for (int i = 0; i < inv.getSize(); i++) {
                                item = inv.getItem(i);
                                if (RSVItem.isRSVItem(item)) {
                                    inv.setItem(i, RSVItem.convertItemStackToRSVItem(item));
                                    reset = true;
                                }
                            }
                        }
                        else {
                            item = inv.getItemInMainHand();
                            if (RSVItem.isRSVItem(item)) {
                                inv.setItemInMainHand(RSVItem.convertItemStackToRSVItem(item));
                                reset = true;
                            }
                        }
                        player.updateInventory();
                    }

                    String execution = reset ? "CorrectExecution" : "NoValidItemsFound";
                    String single = filteredTargets.size() == 1 ? "SingleTargetMessage" : "MultipleTargetMessage";
                    String mainHand = checkEntireInv ? "Inventory" : "MainHand";

                    if (config.getBoolean("ResetItem." + execution + ".Enabled")) {
                        sender.sendMessage(Utils.translateMsg(config.getString("ResetItem." + execution + "." + mainHand + "." + single), sender, null));
                    }
                    return true;
                }
                case "updateitem" -> {
                    if (!sender.hasPermission("realisticsurvival.command.updateitem")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }

                    if (args.length == 1) {
                        if (sender instanceof Player player) {
                            PlayerInventory inv = player.getInventory();
                            ItemStack itemMainHand = inv.getItemInMainHand();

                            if (RSVItem.isRSVItem(itemMainHand)) {
                                Utils.updateItem(itemMainHand);
                                player.updateInventory();
                                if (config.getBoolean("UpdateItem.CorrectExecution.Enabled")) {
                                    sender.sendMessage(Utils.translateMsg(config.getString("UpdateItem.CorrectExecution.MainHand.SingleTargetMessage"), sender, null));
                                }
                            }
                            else {
                                if (config.getBoolean("UpdateItem.NoValidItemsFound.Enabled")) {
                                    sender.sendMessage(Utils.translateMsg(config.getString("UpdateItem.NoValidItemsFound.MainHand.SingleTargetMessage"), sender, null));
                                }
                            }
                            return true;
                        }
                        sendInvalidTargetMsg(sender);
                        return true;
                    }
                    List<Entity> targets = Bukkit.selectEntities(sender, args[1]);

                    if (targets.isEmpty()) {
                        sendInvalidArgumentMsg(sender);
                        return true;
                    }

                    List<Player> filteredTargets = new ArrayList<>();

                    for (Entity e : targets) {
                        if (e instanceof Player player && player.isOnline()) {
                            filteredTargets.add(player);
                        }
                    }

                    if (filteredTargets.isEmpty()) {
                        sendInvalidTargetMsg(sender);
                        return true;
                    }

                    boolean checkEntireInv = args.length >= 3 && args[2].equalsIgnoreCase("all");
                    boolean reset = false;
                    PlayerInventory inv;
                    ItemStack item;

                    for (Player player : filteredTargets) {
                        inv = player.getInventory();

                        if (checkEntireInv) {
                            for (int i = 0; i < inv.getSize(); i++) {
                                item = inv.getItem(i);
                                if (RSVItem.isRSVItem(item)) {
                                    Utils.updateItem(item);
                                    reset = true;
                                }
                            }
                        }
                        else {
                            item = inv.getItemInMainHand();
                            if (RSVItem.isRSVItem(item)) {
                                Utils.updateItem(item);
                                reset = true;
                            }
                        }
                        player.updateInventory();
                    }

                    String execution = reset ? "CorrectExecution" : "NoValidItemsFound";
                    String single = filteredTargets.size() == 1 ? "SingleTargetMessage" : "MultipleTargetMessage";
                    String mainHand = checkEntireInv ? "Inventory" : "MainHand";

                    if (config.getBoolean("UpdateItem." + execution + ".Enabled")) {
                        sender.sendMessage(Utils.translateMsg(config.getString("UpdateItem." + execution + "." + mainHand + "." + single), sender, null));
                    }
                    return true;
                }
                case "help" -> {
                    if (!sender.hasPermission("realisticsurvival.command.help")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }
                    config.getStringList("Help").forEach(msg -> sender.sendMessage(Utils.translateMsg(msg, sender, null)));
                    return true;
                }
                case "version" -> {
                    if (!sender.hasPermission("realisticsurvival.command.version")) {
                        // send the player a message explaining that he/she does not have permission to execute the command
                        sendNoPermissionMessage(sender);
                        return true;
                    }
                    Map<String, Object> placeholders = Map.of("PLUGIN_VERSION", plugin.getDescription().getVersion());
                    sender.sendMessage(Utils.translateMsg(config.getString("Version"), sender, placeholders));
                    Bukkit.getServer().dispatchCommand(sender, "version");
                    return true;
                }
                default -> {
                    return true;
                }
            }
        }
        return false;
    }

    private void sendInvalidTargetMsg(CommandSender sender) {
        sender.sendMessage(Utils.translateMsg(config.getString("InvalidTarget"), sender, null));
    }

    private void sendInvalidArgumentMsg(CommandSender sender) {
        sender.sendMessage(Utils.translateMsg(config.getString("InvalidArgument"), sender, null));
    }

    private void sendIncompleteCommandMsg(CommandSender sender) {
        sender.sendMessage(Utils.translateMsg(config.getString("IncompleteCommand"), sender, null));
    }

    private void sendNoPermissionMessage(CommandSender sender) {
        sender.sendMessage(Utils.translateMsg(config.getString("NoPermission"), sender, null));
    }

    private void playSound(Player player) {
        if (config.getBoolean("Give.CorrectExecution.Sound.Enabled"))
            Utils.playSound(player.getLocation(), config.getString("Give.CorrectExecution.Sound.Sound"), (float) config.getDouble("Give.CorrectExecution.Sound.Volume"), (float) config.getDouble("Give.CorrectExecution.Sound.Pitch"));
    }

}