package me.val_mobile.spartanweaponry;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ReturnWeaponTask extends BukkitRunnable {

    @Getter
    private final ItemStack itemStack;
    @Getter
    private final ArmorStand armorStand;
    @Getter
    private final Player player;

    public ReturnWeaponTask(ItemStack itemStack, ArmorStand armorStand, Player player){
        this.itemStack = itemStack;
        this.armorStand = armorStand;
        this.player = player;
    }

    @Override
    public void run() {
        Location asLocation = getArmorStand().getLocation();
        Vector asVector = asLocation.toVector();
        Location pLocation = getPlayer().getLocation();
        Vector pVector = pLocation.toVector();

        getArmorStand().teleport(asLocation.subtract(asVector.subtract(pVector).normalize()).setDirection(pLocation.getDirection()));

        // if player is not online, drop the throwable immediately
        if(!getPlayer().isOnline()){
            dropItem(asLocation);
            stopTask();
        }

        // drop the item if the distance between player and throwable is square root of 150 blocks away
        if(distanceBetween(asLocation, pLocation) > 150){
            Location dropLoc = dropItem(asLocation);
            getPlayer().sendMessage(ChatColor.RED + "Weapon has not been returned because you're too far!");
            getPlayer().sendMessage(ChatColor.RED + "it was dropped at:" + ChatColor.YELLOW +
                    "x: " + (int) dropLoc.getX() + ", " +
                    "y: " + (int) dropLoc.getY() + ", " +
                    "z: " + (int) dropLoc.getZ());

            stopTask();
        }

        if(distanceBetween(asLocation, pLocation) < 0.5){
            if(getPlayer().getInventory().firstEmpty() == -1){
                getPlayer().sendMessage(ChatColor.RED + "Inventory full! dropped the item instead");
                dropItem(pLocation);
            } else {
                getPlayer().getInventory().addItem(getItemStack().clone());
            }
            getPlayer().playSound(getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
            stopTask();
        }
    }

    public Location dropItem(Location location){ // drop the throwable weapon if player inventory is full
        Item droppedItem = getPlayer().getWorld().dropItem(location, getItemStack().clone());
        droppedItem.setOwner(getPlayer().getUniqueId());
        droppedItem.setGlowing(true);

        return droppedItem.getLocation();
    }

    // get the distance between two locations and return the square root of the distance
    public double distanceBetween(Location asLoc, Location pLoc){
        return asLoc.distance(pLoc);
    }

    public void stopTask(){ // stop the task once task has been completed
        getArmorStand().remove();
        this.cancel();
    }
}
