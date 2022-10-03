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
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class EnderCrownTask extends BukkitRunnable {

    private static final HashMap<UUID, EnderCrownTask> tasks = new HashMap<>();

    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final double actRange;
    private final double chance;
    private final Collection<String> allowedWorlds;
    private final double maxHealthPercent;
    private final double waterDamage;

    private boolean hasSummoned = false;
    private long start;

    public EnderCrownTask(BaubleModule module, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.config = module.getUserConfig().getConfig();
        this.allowedWorlds = module.getAllowedWorlds();
        this.plugin = plugin;
        this.actRange = config.getDouble("Items.ender_queens_crown.ActivationRange");
        this.chance = config.getDouble("Items.ender_queens_crown.SummonEndermanAlly.Chance");
        this.maxHealthPercent = config.getDouble("Items.ender_queens_crown.SummonEndermanAlly.MaxHealthPercent");
        this.waterDamage = config.getDouble("Items.ender_queens_crown.WaterContactDamage");
        start = System.currentTimeMillis();
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
                boolean hasBauble = rsvPlayer.getBaubleDataModule().hasBauble("ender_queens_crown");

                if (hasBauble) {
                    // effect the player with resistance
                    Player p = rsvPlayer.getPlayer();
                    Location loc = p.getLocation();
                    for (Entity e : p.getNearbyEntities(actRange, actRange, actRange)) {
                        if (e instanceof Enderman) {
                            // transfrom enderman into ally
                            if (!Objects.equals(RealisticSurvivalPlugin.getUtil().getNbtTag(e, "rsvmob", PersistentDataType.STRING), "enderman_ally")) {
                                Utils.spawnEndermanAlly(p, loc);
                                e.remove();
                            }
                        }
                    }

                    if (loc.getBlock().getType() == Material.WATER) {
                        p.damage(waterDamage);
                    }

                    if ((System.currentTimeMillis() - start) % 30000 == 0) {
                        hasSummoned = false;
                    }

                    if (p.getHealth() / p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() <= maxHealthPercent) {
                        if (!hasSummoned) {
                            hasSummoned = true;
                            int numAllies = (int) (Math.random() * 3) + 1;
                            int x;
                            int y;
                            int z;

                            for (int i = 0; i < numAllies; i++) {
                                x = (int) (Math.random() * 21) - 10;
                                z = (int) (Math.random() * 21) - 10;
                                y = p.getWorld().getHighestBlockYAt(x, z);
                                Utils.spawnEndermanAlly(p, new Location(p.getWorld(), x, y, z));
                            }
                        }
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
        int tickSpeed = config.getInt("Items.ender_queens_crown.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static HashMap<UUID, EnderCrownTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
