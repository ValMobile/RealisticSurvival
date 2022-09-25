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
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class TwoHandedTask extends BukkitRunnable {

    private static HashMap<UUID, TwoHandedTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final PotionEffect effect;
    private final UUID id;
    private final String itemName;


    public TwoHandedTask(RSVModule module, RealisticSurvivalPlugin plugin, Player player, String itemName) {
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.id = player.getUniqueId();
        this.itemName = itemName;
        this.effect = new PotionEffect(PotionEffectType.SLOW_DIGGING, config.getInt("Items." + itemName + ".MiningFatigue.Duration"), config.getInt("Items." + itemName + ".MiningFatigue.Amplifier"));
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = Bukkit.getPlayer(id);
        ItemStack itemMainhand = player.getInventory().getItemInMainHand();

        if (RSVItem.isRSVItem(itemMainhand) && Utils.isItemReal(player.getInventory().getItemInOffHand())) {
            if (RSVItem.getNameFromItem(itemMainhand).equals(itemName)) {
                player.addPotionEffect(effect);
            }
            else {
                tasks.remove(id);
                cancel();
            }
        }
        else {
            tasks.remove(id);
            cancel();
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Items." + itemName + ".MiningFatigue.TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static HashMap<UUID, TwoHandedTask> getTasks() {
        return tasks;
    }
}
