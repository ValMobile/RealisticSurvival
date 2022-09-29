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
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ThrowWeaponTask extends BukkitRunnable {

    private final double maxDistanceSquared;
    private final FileConfiguration config;
    private final String name;
    private final ArmorStand armorStand;
    private final Player player;
    private final ItemStack itemStack;
    private final boolean rotateWeapon;
    private final boolean piercing;
    private final boolean returnWeapon;
    private final RSVModule module;
    private final RealisticSurvivalPlugin plugin;
    private final Location started;

    private final Vector vector;
    private static final HashMap<UUID, ThrowWeaponTask> tasks = new HashMap<>();

    public ThrowWeaponTask(RSVModule module, RealisticSurvivalPlugin plugin, Player player, ItemStack itemStack, double maxDistance, boolean rotateWeapon, boolean piercing, boolean returnWeapon, Vector velocity) {
        this.config = module.getUserConfig().getConfig();
        this.module = module;
        this.name = RSVItem.getNameFromItem(itemStack);
        this.maxDistanceSquared = Math.pow(maxDistance, 2);
        this.plugin = plugin;
        this.player = player;
        this.itemStack = itemStack;
        this.rotateWeapon = rotateWeapon;
        this.piercing = piercing;
        this.returnWeapon = returnWeapon;
        this.vector = velocity.multiply(1/20D);
        this.started = player.getLocation().add(0, 0.9, 0);
        this.armorStand = spawnArmorstand(player, itemStack);
        tasks.put(player.getUniqueId(), this);
    }

    public ArmorStand spawnArmorstand(Player thrower, ItemStack itemStack) {
        return thrower.getWorld().spawn(started.clone(), ArmorStand.class, armorStand -> {
            armorStand.setArms(true);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            armorStand.setSmall(true);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            armorStand.setPersistent(false);

            if (config.getBoolean("Items." + name + ".ThrownAttributes.ThrownSound.Enabled")) {
                String soundName = config.getString("Items." + name + ".ThrownAttributes.ThrownSound.Sound");
                float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.ThrownSound.Volume");
                float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.ThrownSound.Pitch");
                Utils.playSound(thrower.getLocation(), soundName, volume, pitch);
            }

            // sets armor stand arm item and body angle
            armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 270, 0, 0));

            Objects.requireNonNull(armorStand.getEquipment()).setItemInMainHand(itemStack.clone());
        });
    }

    @Override
    public void run() {
        Location loc = armorStand.getLocation().add(vector);
        armorStand.teleport(loc);

        // rotate floating item by 45 degrees per tick
        if (rotateWeapon) {
            armorStand.setRightArmPose(Utils.setRightArmAngle(armorStand, 45, 0, 0));
        }

        RayTraceResult result = armorStand.rayTraceBlocks(0.109);
        List<Entity> entityList = armorStand.getNearbyEntities(0.3, 0.3, 0.3);

        // check if the raytrace result has a block within the max distance
        // if it hits a block, the weapon is either returned or dropped
        if (result != null && Objects.requireNonNull(result.getHitBlock()).getType() != Material.GRASS && !Tag.FLOWERS.isTagged(result.getHitBlock().getType())) {
            if (returnWeapon) {
                returnWeapon();
            }
            else {
                dropWeaponTask(armorStand, player, itemStack.clone());
            }

            if (config.getBoolean("Items." + name + ".ThrownAttributes.HitGroundSound.Enabled")) {
                String soundName = config.getString("Items." + name + ".ThrownAttributes.HitGroundSound.Sound");
                float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitGroundSound.Volume");
                float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitGroundSound.Pitch");
                Utils.playSound(armorStand.getLocation(), soundName, volume, pitch);
            }
            tasks.remove(player.getUniqueId());
            cancel();
        }

        // check if there are nearby entities around the given bounding box
        // piercing can hit through multiple entities without returning
        if (!entityList.isEmpty() && !entityList.contains(player)) {
            double attackDamage = config.getDouble("Items." + name + ".ThrownAttributes.AttackDamage");

            for (Entity e : entityList) {
                if (e instanceof Damageable && e.getUniqueId() != player.getUniqueId()) {
                    ((Damageable) e).damage(attackDamage);
                }
            }

            if (config.getBoolean("Items." + name + ".ThrownAttributes.HitMobSound.Enabled")) {
                String soundName = config.getString("Items." + name + ".ThrownAttributes.HitMobSound.Sound");
                float volume = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitMobSound.Volume");
                float pitch = (float) config.getDouble("Items." + name + ".ThrownAttributes.HitMobSound.Pitch");
                Utils.playSound(armorStand.getLocation(), soundName, volume, pitch);
            }

            if (returnWeapon && !piercing) {
                returnWeapon();
                tasks.remove(player.getUniqueId());
                cancel();
            }

            if (!piercing) {
                dropWeaponTask(armorStand, player, itemStack.clone());
                tasks.remove(player.getUniqueId());
                cancel();
            }
        }


        // drop the weapon if the distance is greater 60 blocks
        if (armorStand.getLocation().distanceSquared(started) > maxDistanceSquared) {
            if (config.getBoolean("MaxDistanceReached.Enabled")) {
                String message = ChatColor.translateAlternateColorCodes('&', config.getString("MaxDistanceReached.Message"));
                message = message.replaceAll("%MAX_DISTANCE%", String.valueOf(Math.round(Math.sqrt(maxDistanceSquared))));
                player.sendMessage(message);
            }
            dropWeaponTask(armorStand, player, itemStack.clone());
        }
    }

    public void dropWeaponTask(ArmorStand as, Player player, ItemStack itemStack) {
        Item droppedItem = as.getWorld().dropItem(as.getLocation(), itemStack.clone());
        Location loc = droppedItem.getLocation();

        droppedItem.setGlowing(true);

        as.remove();

        if (config.getBoolean("WeaponDropped.Enabled")) {
            String message = ChatColor.translateAlternateColorCodes('&', config.getString("WeaponDropped.Message"));
            message = message.replaceAll("%X-COORD%", String.valueOf((int) loc.getX()));
            message = message.replaceAll("%Y-COORD%", String.valueOf((int) loc.getY()));
            message = message.replaceAll("%Z-COORD%", String.valueOf((int) loc.getZ()));

            player.sendMessage(message);
        }

        tasks.remove(player.getUniqueId());
        cancel();
    }

    public void returnWeapon() {
        cancel();

        new ReturnWeaponTask(module, itemStack, armorStand, player).runTaskTimer(plugin, 4L, 1L);
    }

    public void start() {
        runTaskTimer(plugin, 0, 1);
    }

    public void centeredThrow(){
        armorStand.teleport(player.getLocation().add(0,0.9, 0));
    }

    public void resetArmorstandArmPos(){
        armorStand.setRightArmPose(new EulerAngle(0, 0, 0));
    }

    public Player getPlayer() {
        return player;
    }

    public static HashMap<UUID, ThrowWeaponTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
