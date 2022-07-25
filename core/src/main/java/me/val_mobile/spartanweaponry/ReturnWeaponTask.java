package me.val_mobile.spartanweaponry;

import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ReturnWeaponTask extends BukkitRunnable {
    
    private final ItemStack itemStack;
    private final ArmorStand armorStand;
    private final Player player;

    public ReturnWeaponTask(ItemStack itemStack, ArmorStand armorStand, Player player){
        this.itemStack = itemStack;
        this.armorStand = armorStand;
        this.player = player;
    }

    @Override
    public void run() {
        Location asLocation = armorStand.getLocation();
        Vector asVector = asLocation.toVector();
        Location pLocation = player.getLocation();
        Vector pVector = pLocation.toVector();

        armorStand.teleport(asLocation.subtract(asVector.subtract(pVector).normalize()).setDirection(pLocation.getDirection()));

        // if player is not online, drop the throwable immediately
        if(!player.isOnline()){
            dropItem(asLocation);
            stopTask();
        }

        // drop the item if the distance between player and throwable is square root of 150 blocks away
        if(distanceBetween(asLocation, pLocation) > 150){
            Location dropLoc = dropItem(asLocation);
            player.sendMessage(Utils.colorTranslator("&cWeapon has not been returned because you're too far!"));
            player.sendMessage(Utils.colorTranslator("&cit was dropped at: &e" +
                    "x: " + (int) dropLoc.getX() + ", " +
                    "y: " + (int) dropLoc.getY() + ", " +
                    "z: " + (int) dropLoc.getZ()));

            stopTask();
        }

        if(distanceBetween(asLocation, pLocation) < 0.5){
            if(player.getInventory().firstEmpty() == -1){
                player.sendMessage(Utils.colorTranslator("&eInventory full! dropped the item instead"));
                dropItem(pLocation);
            } else {
                player.getInventory().addItem(itemStack.clone());
            }
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
            stopTask();
        }
    }

    public Location dropItem(Location location){ // drop the throwable weapon if player inventory is full
        Item droppedItem = player.getWorld().dropItem(location, itemStack.clone());
        droppedItem.setOwner(player.getUniqueId());
        droppedItem.setGlowing(true);

        return droppedItem.getLocation();
    }

    // get the distance between two locations and return the square root of the distance
    public double distanceBetween(Location asLoc, Location pLoc){
        return asLoc.distance(pLoc);
    }

    public void stopTask(){ // stop the task once task has been completed
        armorStand.remove();

        this.cancel();
    }
}
