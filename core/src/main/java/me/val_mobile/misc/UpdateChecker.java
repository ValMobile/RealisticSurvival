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
package me.val_mobile.misc;

import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class UpdateChecker {

    private final JavaPlugin plugin;
    private final int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getLogger().info(ChatColor.translateAlternateColorCodes('&',"&cCannot look for updates: " + exception.getMessage()));
            }
        });
    }

    public void checkUpdate() {
        Logger logger = plugin.getLogger();

        getVersion(latestVersion -> {
            double currentVersion = Utils.getNumberFromUpdate(plugin.getDescription().getVersion());

            double spigotVersion = Utils.getNumberFromUpdate((latestVersion));

            List<String> messages;

            if (Math.abs(currentVersion - spigotVersion) <= 0.01)
                messages = plugin.getConfig().getStringList("CorrectVersion");
            else if (currentVersion > spigotVersion)
                messages = plugin.getConfig().getStringList("DeveloperBuildVersion");
            else
                messages = plugin.getConfig().getStringList("OutdatedVersion");

            for (String message : messages) {
                logger.info(ChatColor.translateAlternateColorCodes('&', message));
            }
        });
    }
}