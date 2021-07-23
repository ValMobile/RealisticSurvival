package me.val_mobile.misc;

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

    private JavaPlugin plugin;
    private int resourceId;

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
            String currentVersion = plugin.getDescription().getVersion();

            if (currentVersion.equalsIgnoreCase(latestVersion)) {
                List<String> messages = plugin.getConfig().getStringList("CorrectVersion");

                for (String message : messages) {
                    logger.info(ChatColor.translateAlternateColorCodes('&', message));
                }
            }
            else {
                List<String> messages = plugin.getConfig().getStringList("OutdatedVersion");

                for (String message : messages) {
                    logger.info(ChatColor.translateAlternateColorCodes('&', message));
                }
            }
        });
    }
}
