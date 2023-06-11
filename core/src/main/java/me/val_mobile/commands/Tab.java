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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static me.val_mobile.realisticsurvival.RealisticSurvivalPlugin.NAME;

/**
 * Tab is a class that creates a tab completer
 * when the user types appropriate commands
 * @author Val_Mobile
 * @version 1.2.5-RELEASE
 * @since 1.0
 */
public class Tab implements TabCompleter {
    // create lists to store strings that will appear in the tab completer
    private final Set<String> firstArgs = new HashSet<>();
    private final Set<String> mobs = new HashSet<>();
    private final Set<String> items = RSVItem.getItemMap().keySet();
    private final Set<String> temperature = new HashSet<>(26);
    private final Set<String> thirst = new HashSet<>(21);
    private final Set<String> worlds = new HashSet<>();

    private final FileConfiguration config;

    public Tab(RealisticSurvivalPlugin plugin) {
        this.config = plugin.getCommandsConfig();
    }

    /**
     * Creates a tab completer depending on what the user types
     * @param sender The user who is typing a command
     * @param cmd The command typed
     * @param label The word directly after the forward slash
     * @param args An array holding every argument after the label
     * @return A list of strings holding the text in the tab completer
     * @see Commands
     */
    @Override
    public List<String> onTabComplete(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        // check if the user typed /realisticsurvival, case-insensitive
        if (label.equalsIgnoreCase(NAME) || label.equalsIgnoreCase("rsv")) {
            List<String> result = new ArrayList<>(); // create an empty string list which will store the tab completer texts

            if (firstArgs.isEmpty()) {
                firstArgs.addAll(Set.of("reload", "give", "spawnitem", "summon", "thirst", "temperature", "resetitem", "updateitem", "help", "version"));
            }

            if (mobs.isEmpty()) {
                mobs.addAll(Set.of("fire_dragon", "ice_dragon", "lightning_dragon", "sea_serpent", "siren"));
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

            worlds.clear();

            Bukkit.getWorlds().forEach(world -> worlds.add(world.getName()));

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
                switch (args[0].toLowerCase()) {
                    case "give", "thirst", "temperature", "resetitem", "updateitem" -> {
                        if (sender instanceof Player player) {
                            result.add(player.getName());
                        }
                    }
                    case "spawnitem" -> {
                        for (String item : items) {
                            if (item.toLowerCase().startsWith(args[1].toLowerCase()))
                                result.add(item);
                        }
                    }
                    case "summon" -> {
                        for (String mob : mobs) {
                            if (mob.toLowerCase().startsWith(args[1].toLowerCase()))
                                result.add(mob);
                        }
                    }
                }

                return result;
            }
            // if 3 arguments were typed
            else if (args.length == 3) {
                switch (args[0].toLowerCase()) {
                    case "give" -> RSVItem.getItemMap().keySet().stream().filter(item -> item.toLowerCase().startsWith(args[2].toLowerCase())).forEach(result::add);
                    case "temperature" -> temperature.stream().filter(temp -> temp.toLowerCase().startsWith(args[2].toLowerCase())).forEach(result::add);
                    case "thirst" -> thirst.stream().filter(th -> th.toLowerCase().startsWith(args[2].toLowerCase())).forEach(result::add);
                    case "spawnitem" -> result.add(Utils.translateMsg(config.getString("Count"), sender, null));
                    case "resetitem", "updateitem" -> result.add("all");
                }

                return result;
            }
            // if more than 3 arguments were typed
            else if (args.length > 3) {
                if (args.length == 6) {
                    if (args[0].equalsIgnoreCase("spawnitem") || args[0].equalsIgnoreCase("summon")) {
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