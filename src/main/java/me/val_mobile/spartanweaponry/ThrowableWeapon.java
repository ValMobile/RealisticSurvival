package me.val_mobile.spartanweaponry;

import lombok.Getter;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Objects;

@Getter
public class ThrowableWeapon {

    public ThrowableWeapon(){}

    public ArmorStand spawnArmorstand(Player player, ItemStack itemStack, boolean isTriSword){
        return player.getWorld().spawn(player.getLocation().add(0, 0.9, 0), ArmorStand.class, armorStand ->{
            armorStand.setArms(true);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            armorStand.setSmall(true);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            armorStand.setPersistent(false);
            if(!isTriSword) {
                armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 270, 0, 0));
                Objects.requireNonNull(armorStand.getEquipment()).setItemInMainHand(itemStack.clone());
            } else{
                armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 0, 0, 0));
                Objects.requireNonNull(armorStand.getEquipment()).setItemInMainHand(itemStack.clone());
                Objects.requireNonNull(armorStand.getEquipment()).setItemInOffHand(itemStack.clone());
                Objects.requireNonNull(armorStand.getEquipment()).setHelmet(itemStack.clone());
            }
        });
    }

    public void throwWeapon(Player player, ArmorStand as, ItemStack itemStack, boolean rotateWeapon, boolean cutThrough, boolean isTriWeapon, boolean returnWeapon){
        Vector vector = player.getLocation().add(player.getLocation().getDirection().multiply(9).normalize())
                .subtract(player.getLocation().toVector()).toVector();

        player.playSound(player.getLocation(), Sound.ENTITY_WITCH_THROW, 1.0F, 1.0F);
        Bukkit.getScheduler().runTaskLater(RealisticSurvivalPlugin.getInstance(), () -> {
            as.teleport(player.getLocation().add(0,0.9, 0));

            if(isTriWeapon){
                as.setRightArmPose(Utils.setRightArmAngle(as, 0, 348, 0));
                as.setLeftArmPose(Utils.setLeftArmAngle(as, 0, 12, 0));
                as.setHeadPose(Utils.setHeadAngle(as, 98, 32, 97));
            }

            new ThrowWeaponTask(as, player, itemStack, rotateWeapon, cutThrough, isTriWeapon, returnWeapon, vector)
                    .runTaskTimer(RealisticSurvivalPlugin.getInstance(), 0L, 1L);
        }, 1L);
    }
}
