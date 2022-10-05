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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class StoneSeaTask extends BukkitRunnable {

    private static final HashMap<UUID, StoneSeaTask> tasks = new HashMap<>();

    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final Collection<String> allowedWorlds;

    public StoneSeaTask(BaubleModule module, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.plugin = plugin;
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.rsvPlayer.getPlayer();

        if (player == null) {
            tasks.remove(id);
            cancel();
        }
        else {
            if (player.isOnline() && !player.isDead() && allowedWorlds.contains(player.getWorld().getName())) {
                boolean hasBauble = rsvPlayer.getBaubleDataModule().hasBauble("stone_sea");

                if (hasBauble) {
                    if (player.isSwimming()) {
                        double magnitude = config.getDouble("Items.stone_sea.BaseSwimSpeed");
                        double depthStrider = 0;
                        boolean dolphinsGrace = player.hasPotionEffect(PotionEffectType.DOLPHINS_GRACE);

                        ItemStack boots = player.getInventory().getBoots();
                        if (boots != null) {
                            if (boots.getItemMeta().hasEnchant(Enchantment.DEPTH_STRIDER)) {
                                depthStrider = boots.getItemMeta().getEnchantLevel(Enchantment.DEPTH_STRIDER);
                            }
                        }

                        if (depthStrider > 0 && dolphinsGrace) {
                            magnitude += 9.8 + 8.983 * depthStrider;
                        }
                        else {
                            if (depthStrider > 0) {
                                magnitude += depthStrider / 3 * 4.317;
                            }
                            else {
                                magnitude += 9.8;
                            }
                        }

                        player.setVelocity(player.getLocation().getDirection().multiply(magnitude));
                    }
                }
                // if the player doesn't have rings of res in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    tasks.remove(id);
                    cancel();
                }
            }
            else {
                tasks.remove(id);
                cancel();
            }
        }

    }

    public void start() {
        int tickSpeed = config.getInt("Items.stone_sea.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static HashMap<UUID, StoneSeaTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
