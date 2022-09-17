package me.val_mobile.spartanweaponry;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ReturnWeaponTask extends BukkitRunnable {

    private final double maxReturnDistance;
    private final String name;

    private final FileConfiguration config;
    private final ItemStack itemStack;
    private final ArmorStand armorStand;
    private final Player player;

    public ReturnWeaponTask(RSVModule module, RealisticSurvivalPlugin plugin, ItemStack itemStack, ArmorStand armorStand, Player player){
        this.itemStack = itemStack;
        this.armorStand = armorStand;
        this.player = player;
        this.config = module.getUserConfig().getConfig();
        this.name = RSVItem.getNameFromItem(itemStack);
        this.maxReturnDistance = config.getDouble("Items." + name + ".ThrownAttributes.MaxReturnDistance");
    }

    @Override
    public void run() {
        Location asLocation = armorStand.getLocation();
        Vector asVector = asLocation.toVector();
        Location pLocation = player.getLocation();
        Vector pVector = pLocation.toVector();

        armorStand.teleport(asLocation.subtract(asVector.subtract(pVector).normalize()).setDirection(pLocation.getDirection()));

        // if player is not online, drop the throwable immediately
        if (!player.isOnline()) {
            dropItem(asLocation);
            stopTask();
        }

        // drop the item if the distance between player and throwable is square root of 150 blocks away
        if (distanceBetween(asLocation, pLocation) > maxReturnDistance) {
            Location dropLoc = dropItem(asLocation);

            if (config.getBoolean("MaxReturnDistanceReached.Enabled")) {
                String message = ChatColor.translateAlternateColorCodes('&', "MaxReturnDistanceReached.Message");
                message = message.replaceAll("%MAX_DISTANCE%", String.valueOf(Math.round(maxReturnDistance)));
                player.sendMessage(message);
            }

            if (config.getBoolean("WeaponDropped.Enabled")) {
                String message = ChatColor.translateAlternateColorCodes('&', config.getString("WeaponDropped.Message"));
                message = message.replaceAll("%X-COORD%", String.valueOf((int) dropLoc.getX()));
                message = message.replaceAll("%Y-COORD%", String.valueOf((int) dropLoc.getY()));
                message = message.replaceAll("%Z-COORD%", String.valueOf((int) dropLoc.getZ()));

                player.sendMessage(message);
            }

            stopTask();
        }

        if (distanceBetween(asLocation, pLocation) < 0.5) {
            if (player.getInventory().firstEmpty() == -1) {

                if (config.getBoolean("FullInventoryWeaponDropped.Enabled")) {
                    String message = ChatColor.translateAlternateColorCodes('&', config.getString("FullInventoryWeaponDropped.Message"));
                    message = message.replaceAll("%X-COORD%", String.valueOf((int) pLocation.getX()));
                    message = message.replaceAll("%Y-COORD%", String.valueOf((int) pLocation.getY()));
                    message = message.replaceAll("%Z-COORD%", String.valueOf((int) pLocation.getZ()));
                    player.sendMessage(message);
                }
                dropItem(pLocation);
            }
            else {
                player.getInventory().addItem(itemStack.clone());
            }
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
            stopTask();
        }
    }

    public Location dropItem(Location location) { // drop the throwable weapon if player inventory is full
        Item droppedItem = player.getWorld().dropItem(location, itemStack.clone());
        droppedItem.setGlowing(true);

        return droppedItem.getLocation();
    }

    // get the distance between two locations and return the square root of the distance
    public double distanceBetween(Location asLoc, Location pLoc){
        return asLoc.distance(pLoc);
    }

    public void stopTask() { // stop the task once task has been completed
        armorStand.remove();

        this.cancel();
    }
}
