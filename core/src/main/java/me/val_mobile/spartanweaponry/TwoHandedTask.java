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
package me.val_mobile.spartanweaponry;

import me.val_mobile.data.RSVModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TwoHandedTask extends BukkitRunnable {

    private static final Map<UUID, TwoHandedTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RSVPlugin plugin;
    private final UUID id;
    private final String itemName;


    public TwoHandedTask(RSVModule module, RSVPlugin plugin, LivingEntity entity, String itemName) {
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.id = entity.getUniqueId();
        this.itemName = itemName;
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Entity entity = Bukkit.getEntity(id);

        if (entity == null) {
            tasks.remove(id);
            cancel();
        }
        else {
            if (entity instanceof LivingEntity living) {
                if (living.getEquipment() != null) {
                    ItemStack itemMainhand = living.getEquipment().getItemInMainHand();

                    if (RSVItem.isRSVItem(itemMainhand) && Utils.isItemReal(living.getEquipment().getItemInOffHand())) {
                        FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainhand)).getUserConfig().getConfig();
                        String name = RSVItem.getNameFromItem(itemMainhand);
                        String type = name.substring(name.lastIndexOf("_") + 1);

                        switch (type) {
                            case "longsword", "katana", "greatsword", "warhammer", "halberd", "pike", "battleaxe", "glaive" ->
                                    living.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, config.getInt("Items." + name + ".MiningFatigue.Duration"), config.getInt("Items." + name + ".MiningFatigue.Amplifier")));
                            default -> {
                                tasks.remove(id);
                                cancel();
                            }
                        }
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
            else {
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void start() {
        int tickPeriod = config.getInt("Items." + itemName + ".MiningFatigue.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 1L, tickPeriod);
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }

    public static Map<UUID, TwoHandedTask> getTasks() {
        return tasks;
    }
}
