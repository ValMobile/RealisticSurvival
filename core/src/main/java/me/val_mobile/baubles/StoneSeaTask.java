/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVTask;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StoneSeaTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, StoneSeaTask> tasks = new HashMap<>();
    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final RSVPlugin plugin;
    private final double baseSwimSpeed;
    private final double horizontalSpeedIncrement;
    private final double verticalSpeedIncrement;
    private final double maxHorizontalSpeed;
    private final double maxVerticalSpeed;

    private final FileConfiguration config;

    public StoneSeaTask(BaubleModule module, RSVPlayer rsvPlayer, RSVPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.allowedWorlds = module.getAllowedWorlds();
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.baseSwimSpeed = config.getDouble("Items.stone_sea.BaseSwimSpeed");
        this.horizontalSpeedIncrement = config.getDouble("Items.stone_sea.HorizontalSpeedIncrement");
        this.verticalSpeedIncrement = config.getDouble("Items.stone_sea.VerticalSpeedIncrement");
        this.maxHorizontalSpeed = config.getDouble("Items.stone_sea.MaxHorizontalSpeed");
        this.maxVerticalSpeed = config.getDouble("Items.stone_sea.MaxVerticalSpeed");
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (conditionsMet(player)) {
            Vector velocity = player.getVelocity().clone();
            double magnitude = velocity.length() * 43.17;

            if ((player.isSwimming() && magnitude > 1.5) || (player.isInWater() && magnitude > 0.5)) {
                double swimSpeed = baseSwimSpeed;
                int depthStrider = 0;
                boolean dolphinsGrace = player.hasPotionEffect(PotionEffectType.DOLPHINS_GRACE);
                Vector dir = player.getLocation().getDirection().clone();

                ItemStack boots = player.getInventory().getBoots();
                if (Utils.isItemReal(boots)) {
                    depthStrider = boots.getEnchantmentLevel(Enchantment.DEPTH_STRIDER);
                }

                swimSpeed += 8.93 * depthStrider;

                if (dolphinsGrace){
                    swimSpeed += 9.8;
                }

                if (magnitude < swimSpeed) {
                    velocity.add(dir.normalize().multiply(new Vector(horizontalSpeedIncrement, verticalSpeedIncrement, horizontalSpeedIncrement)));
                    double vx = velocity.getX();
                    double vy = velocity.getY();
                    double vz = velocity.getZ();

                    double horMag = Math.sqrt((vx * vx) + (vz * vz));

                    if (horMag > maxHorizontalSpeed) {
                        velocity.setX(horMag > Math.abs(vx) ? vx : maxHorizontalSpeed * (vx < 0 ? -1 : 1));
                        velocity.setZ(horMag > Math.abs(vz) ? vz : maxHorizontalSpeed * (vz < 0 ? -1 : 1));
                    }
                    if (Math.abs(vy) > maxVerticalSpeed) {
                        velocity.setY(maxVerticalSpeed * (vy < 0 ? -1 : 1));
                    }
                    player.setVelocity(velocity);
                }
            }
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName()) && rsvPlayer.getBaubleDataModule().hasBauble("stone_sea");
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Items.stone_sea.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }

    public static Map<UUID, StoneSeaTask> getTasks() {
        return tasks;
    }
}
