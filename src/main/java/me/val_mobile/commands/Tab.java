package me.val_mobile.commands;

import me.val_mobile.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Tab implements org.bukkit.command.TabCompleter {
    List<String> firstArgs = new ArrayList<String>();
    List<String> secondArgs = new ArrayList<String>();
    List<String> thirdArgs = new ArrayList<String>();

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("rlcraft")) {
            if (firstArgs.isEmpty()) {
                firstArgs.add("reload");
                firstArgs.add("give");
            }
            if (secondArgs.isEmpty()) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    secondArgs.add(player.getName());
                }
            }

            if (thirdArgs.isEmpty()) {
                for (String tabName : Item.getCommandNames()) {
                    thirdArgs.add(tabName);
                }
            }

            List<String> result = new ArrayList<String>();
            if (args.length == 1) {
                for (String a : firstArgs) {
                    if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                        result.add(a);
                }
                return result;
            }
            else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("give")) {
                    for (String a : secondArgs) {
                        if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                            result.add(a);
                    }
                }
                return result;
            }
            else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("give")) {
                    for (String a : thirdArgs) {
                        if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                            result.add(a);
                    }
                }
                return result;
            }
            else if (args.length > 3) {
                return result;
            }
            return null;
        }
        return null;
    }
}
