package me.val_mobile.spartanweaponry;

import lombok.Getter;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class ThrowWeaponTask extends BukkitRunnable {

    @Getter
    private final ArmorStand armorStand;
    @Getter
    private final Player player;
    @Getter
    private final ItemStack itemStack;
    @Getter
    private final boolean rotateWeapon;
    @Getter
    private final boolean isCutThrough;
    @Getter
    private final boolean isTriWeapon;
    @Getter
    private final boolean returnWeapon;
    @Getter
    private final Vector vector;

    private final ReturnWeaponTask returnWeaponTask;

    public ThrowWeaponTask(ArmorStand armorStand, Player player, ItemStack itemStack, boolean rotateWeapon, boolean isCutThrough, boolean isTriWeapon, boolean returnWeapon, Vector vector){
        this.armorStand = armorStand;
        this.player = player;
        this.itemStack = itemStack;
        this.rotateWeapon = rotateWeapon;
        this.isCutThrough = isCutThrough;
        this.isTriWeapon = isTriWeapon;
        this.returnWeapon = returnWeapon;
        this.vector = vector;
        this.returnWeaponTask = new ReturnWeaponTask(itemStack, armorStand, player);
    }

    @Override
    public void run() {
        getArmorStand().teleport(getArmorStand().getLocation().add(getVector()));

        // rotate weapon by 45 degrees each tick
        if(isRotateWeapon()) {
            getArmorStand().setRightArmPose(Utils.setRightArmAngle(getArmorStand(), 45, 0, 0));
        }

        RayTraceResult result = getArmorStand().rayTraceBlocks(0.107);
        List<Entity> entityList = getArmorStand().getNearbyEntities(0.3, 0.3, 0.3);

        // check if the raytrace result has a block within the max distance
        if(result != null && Objects.requireNonNull(result.getHitBlock()).getType() != Material.GRASS &&
                !Tag.FLOWERS.isTagged(result.getHitBlock().getType())){
            if(isReturnWeapon()) {
                returnWeapon();
                return;
            }

            getPlayer().sendMessage(weaponTask(getArmorStand(), getPlayer(), getItemStack().clone()));
            return;
        }

        // check if there are nearby entities around the given bounding box
        if(!entityList.isEmpty() && !entityList.contains(getPlayer())){
            for(int i = 0; i < entityList.size(); i++){
                if(entityList.get(i) instanceof Damageable && entityList.get(i).getUniqueId() != getPlayer().getUniqueId()){
                    ((Damageable) entityList.get(i)).damage(ThreadLocalRandom.current().nextInt(100) < 35 ? 10 : 6, getPlayer());
                }
            }

            if(isReturnWeapon() && !isTriWeapon()) {
                returnWeapon();
                return;
            }

            if(!isTriWeapon()) {
                weaponTask(getArmorStand(), getPlayer(), getItemStack().clone());
                return;
            }
        }

        // drop the weapon if the distance is greater 60 blocks
        if(getArmorStand().getLocation().distanceSquared(player.getLocation()) > 3600){
            getPlayer().sendMessage(ChatColor.YELLOW + "Your weapon has reached the max distance, " + weaponTask(getArmorStand(), getPlayer(), getItemStack().clone()));
        }
    }

    public String weaponTask(ArmorStand as, Player player, ItemStack itemStack){
        Item droppedItem = as.getWorld().dropItem(as.getLocation(), itemStack.clone());
        Location locInfo = droppedItem.getLocation();
        droppedItem.setOwner(player.getUniqueId());
        droppedItem.setGlowing(true);
        as.remove();
        this.cancel();

        return ChatColor.DARK_RED + "Weapon dropped near at " +
                "x: " + (int) locInfo.getX() + ", " +
                "y: " + (int) locInfo.getY() + ", " +
                "z: " + (int) locInfo.getZ()
                ;
    }

    public void returnWeapon(){
        this.cancel();
        returnWeaponTask.runTaskTimer(RealisticSurvivalPlugin.getInstance(), 4L, 1L);
    }
}
