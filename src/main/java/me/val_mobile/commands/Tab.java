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

import me.val_mobile.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
/**
 * Tab is a class that creates a tab completer
 * when the user types appropriate commands
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class Tab implements org.bukkit.command.TabCompleter {
    // create lists to store strings that will appear in the tab completer
    List<String> firstArgs = new ArrayList<String>();
    List<String> secondArgs = new ArrayList<String>();
    List<String> thirdArgs = new ArrayList<String>();

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
        // check if the user typed /rlcraft, case-insensitive
        if (label.equalsIgnoreCase("rlcraft")) {

            // if the first list of arguments is empty
            if (firstArgs.isEmpty()) {
                /**
                 * Add strings that correspond to the appropriate arguments.
                 * Only reload and give are appropriate arguments.
                 */
                // add the appropriate strings
                firstArgs.add("reload");
                firstArgs.add("give");
            }

            // if the second list of arguments is empty
            if (secondArgs.isEmpty()) {
                /**
                 * Add strings that correspond to the appropriate arguments.
                 * Only an online player's name is an appropriate argument.
                 *
                 * Add every online player's name to the second list of arguments.
                 */
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    secondArgs.add(player.getName());
                }
            }

            // if the third list of arguments is empty
            if (thirdArgs.isEmpty()) {
                /**
                 * Add strings that correspond to the appropriate arguments.
                 * Only the command name is an appropriate argument.
                 *
                 * Add every command name to the third list of arguments.
                 */
                for (String tabName : Item.getCommandNames()) {
                    thirdArgs.add(tabName);
                }
            }

            List<String> result = new ArrayList<String>(); // create an empty string list which will store the tab completer texts

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
                if (args[0].equalsIgnoreCase("give")) {
                    // add all the names of the online players to the tab completer
                    for (String a : secondArgs) {
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
                    for (String a : thirdArgs) {
                        if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                            result.add(a);
                    }
                }
                // return the tab completer
                return result;
            }
            // if more than 3 arguments were typed
            else if (args.length > 3) {
                // return an empty tab completer
                return result;
            }
            return null;
        }
        return null;
    }
}