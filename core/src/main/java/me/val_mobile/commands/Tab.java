/*
    Copyright (C) 2023  Val_Mobile

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

import me.val_mobile.utils.RSVItem;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.*;

import static me.val_mobile.realisticsurvival.RealisticSurvivalPlugin.NAME;

/**
 * Tab is a class that creates a tab completer
 * when the user types appropriate commands
 * @author Val_Mobile
 * @version 1.2.5-DEV-1
 * @since 1.0
 */
public class Tab implements TabCompleter {
    // create lists to store strings that will appear in the tab completer
    private final Set<String> firstArgs = new HashSet<>();
    private final Set<String> mobs = new HashSet<>();

    private final Set<String> players = new HashSet<>();
    private final Set<String> items = RSVItem.getItemMap().keySet();
    private final Set<String> temperature = new HashSet<>(26);
    private final Set<String> thirst = new HashSet<>(21);
    private final Set<String> worlds = new HashSet<>();

    /**
     * Creates a tab completer depending on what the user types
     * @param sender The user who is typing a command
     * @param cmd The command typed
     * @param label The word directly after the forward slash
     * @param args An array holding every argument after the label
     * @return A list of strings holding the text in the tab completer
     * @see Commands
     */
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        // check if the user typed /realisticsurvival, case-insensitive
        if (label.equalsIgnoreCase(NAME) || label.equalsIgnoreCase("rsv")) {
            List<String> result = new ArrayList<>(); // create an empty string list which will store the tab completer texts

            if (firstArgs.isEmpty()) {
                firstArgs.add("reload");
                firstArgs.add("give");
                firstArgs.add("spawnitem");
                firstArgs.add("spawnmob");
                firstArgs.add("thirst");
                firstArgs.add("temperature");
                firstArgs.add("resetitem");
                firstArgs.add("updateitem");
                firstArgs.add("help");
                firstArgs.add("version");
            }

            if (mobs.isEmpty()) {
                mobs.add("fire_dragon");
                mobs.add("ice_dragon");
                mobs.add("lightning_dragon");
                mobs.add("sea_serpent");
                mobs.add("siren");
            }

            if (temperature.isEmpty()) {
                for (int i = 0; i < 26; i++) {
                    temperature.add(String.valueOf(i));
                }
            }

            if (thirst.isEmpty()) {
                for (int i = 0; i < 21; i++) {
                    thirst.add(String.valueOf(i));
                }
            }

            players.clear();
            worlds.clear();
            Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
            List<World> bukkitWorlds = Bukkit.getWorlds();

            /**
             * Add strings that correspond to the appropriate arguments.
             * Only an online player's name is an appropriate argument.
             *
             * Add every online player's name to the second list of arguments.
             */
            for (Player player : onlinePlayers) {
                players.add(player.getName());
            }

            for (World world : bukkitWorlds) {
                worlds.add(world.getName());
            }

            // if 1 argument was typed
            if (args.length == 1) {
                // add "reload" and "give" to the tab completer
                for (String a : firstArgs) {
                    if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                        result.add(a);
                }
                // return the tab completer
                return result;
            }
            // if 2 arguments were typed
            else if (args.length == 2) {

                // if the user is trying to use the give command
                if (args[0].equalsIgnoreCase("give") || args[0].equalsIgnoreCase("thirst") ||
                        args[0].equalsIgnoreCase("temperature")) {
                    // add all the names of the online players to the tab completer
                    for (String a : players) {
                        if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                            result.add(a);
                    }
                }

                else if (args[0].equalsIgnoreCase("spawnitem")) {
                    for (String a : items) {
                        if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                            result.add(a);
                    }
                }

                else if (args[0].equalsIgnoreCase("spawnmob")) {
                    for (String a : mobs) {
                        if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                            result.add(a);
                    }
                }
                // return the tab completer
                return result;
            }
            // if 3 arguments were typed
            else if (args.length == 3) {

                // if the user is trying to use the give command
                if (args[0].equalsIgnoreCase("give")) {
                    // add all the names of the custom items to the tab completer
                    for (String a : items) {
                        if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                            result.add(a);
                    }
                }
                // if the user is trying to use the temperature command
                else if (args[0].equalsIgnoreCase("temperature")) {
                    // add all the integers to the tab completer
                    for (String a : temperature) {
                        if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                            result.add(a);
                    }
                }
                // if the user is trying to use the thirst command
                else if (args[0].equalsIgnoreCase("thirst")) {
                    // add all the integers to the tab completer
                    for (String a : thirst) {
                        if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                            result.add(a);
                    }
                }

                // return the tab completer
                return result;
            }
            // if more than 3 arguments were typed
            else if (args.length > 3) {
                if (args.length == 6) {
                    if (args[0].equalsIgnoreCase("spawnitem") || args[0].equalsIgnoreCase("spawnmob")) {
                        for (String a : worlds) {
                            if (a.toLowerCase().startsWith(args[5].toLowerCase()))
                                result.add(a);
                        }
                    }
                }
                return result;
            }
            return null;
        }
        return null;
    }
}