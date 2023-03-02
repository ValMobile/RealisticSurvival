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
package me.val_mobile.spartanweaponry;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ReturnWeaponTask extends BukkitRunnable {

    private final double maxReturnDistance;
    private final String name;

    private final FileConfiguration config;
    private final ItemStack item;
    private final ArmorStand armorStand;
    private final LivingEntity entity;
    private final boolean rotateWeapon;

    public ReturnWeaponTask(RSVModule module, ItemStack item, ArmorStand armorStand, LivingEntity entity, boolean rotateWeapon) {
        this.item = item;
        this.armorStand = armorStand;
        this.entity = entity;
        this.config = module.getUserConfig().getConfig();
        this.name = RSVItem.getNameFromItem(item);
        this.maxReturnDistance = config.getDouble("Items." + name + ".ThrownAttributes.MaxReturnDistance");
        this.rotateWeapon = rotateWeapon;
    }

    @Override
    public void run() {
        Location asLocation = armorStand.getLocation();
        Vector asVector = asLocation.toVector();
        // if player is not online, drop the throwable immediately

        if (entity == null) {
            dropItem(asLocation);
            stop();
        }
        else {
            if (entity instanceof Player player && !player.isOnline()) {
                dropItem(asLocation);
                stop();
            }
            else {
                Location pLocation = entity.getLocation();
                Vector pVector = pLocation.toVector();

                armorStand.teleport(asLocation.subtract(asVector.subtract(pVector).normalize()).setDirection(pLocation.getDirection()));

                if (rotateWeapon) {
                    armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 45, 0, 0));
                }

                if (asLocation.getWorld().getName().equals(pLocation.getWorld().getName())) {
                    if (distanceBetween(asLocation, pLocation) > maxReturnDistance) {
                        Location dropLoc = dropItem(asLocation);

                        if (config.getBoolean("MaxReturnDistanceReached.Enabled")) {
                            String message = Utils.translateMsg(entity, config.getString("MaxReturnDistanceReached.Message"));
                            message = message.replaceAll("%MAX_DISTANCE%", String.valueOf(Math.round(maxReturnDistance)));
                            entity.sendMessage(message);
                        }

                        if (config.getBoolean("WeaponDropped.Enabled")) {
                            String message = Utils.translateMsg(entity, config.getString("WeaponDropped.Message"));
                            message = message.replaceAll("%X-COORD%", String.valueOf((int) dropLoc.getX()));
                            message = message.replaceAll("%Y-COORD%", String.valueOf((int) dropLoc.getY()));
                            message = message.replaceAll("%Z-COORD%", String.valueOf((int) dropLoc.getZ()));

                            entity.sendMessage(message);
                        }

                        stop();
                    }

                    if (distanceBetween(asLocation, pLocation) < 0.5) {
                        boolean isInvFull;

                        if (entity instanceof Player player) {
                            isInvFull = player.getInventory().firstEmpty() == -1;
                        }
                        else {
                            if (entity.getEquipment() == null) {
                                isInvFull = true;
                            }
                            else {
                                isInvFull = Utils.isItemReal(entity.getEquipment().getItemInMainHand());
                            }
                        }

                        if (config.getBoolean("Items." + name + ".ThrownAttributes.ReturnSound.Enabled")) {
                            String soundName = config.getString("Items." + name + ".ThrownAttributes.ReturnSound.Sound");
                            float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.ReturnSound.Volume");
                            float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.ReturnSound.Pitch");
                            Utils.playSound(entity.getLocation(), soundName, volume, pitch);
                        }
                        stop();

                        if (isInvFull) {
                            if (config.getBoolean("FullInventoryWeaponDropped.Enabled")) {
                                String message = Utils.translateMsg(entity, config.getString("FullInventoryWeaponDropped.Message"));
                                message = message.replaceAll("%X-COORD%", String.valueOf((int) pLocation.getX()));
                                message = message.replaceAll("%Y-COORD%", String.valueOf((int) pLocation.getY()));
                                message = message.replaceAll("%Z-COORD%", String.valueOf((int) pLocation.getZ()));
                                entity.sendMessage(message);
                            }
                            dropItem(pLocation);
                        }
                        else {
                            if (entity instanceof Player player) {
                                player.getInventory().addItem(item.clone());
                            }
                            else {
                                entity.getEquipment().setItemInMainHand(item.clone());
                            }
                        }
                        stop();
                    }
                }
                // distance can't be calculated across different worlds, therefore item must be dropped
                else {
                    dropItem(asLocation);
                    stop();
                }
            }
        }
    }

    public Location dropItem(Location location) { // drop the throwable weapon if player inventory is full
        Item droppedItem = entity.getWorld().dropItem(location, item.clone());
        droppedItem.setGlowing(true);

        return droppedItem.getLocation();
    }

    public double distanceBetween(Location asLoc, Location pLoc){
        return asLoc.distance(pLoc);
    }

    public void stop() { // stop the task once task has been completed
        armorStand.remove();

        this.cancel();
    }
}
