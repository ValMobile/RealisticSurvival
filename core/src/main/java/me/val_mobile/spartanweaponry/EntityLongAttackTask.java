/*
    Copyright (C) 2024  Val_Mobile

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
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public class EntityLongAttackTask extends BukkitRunnable {

    private final LivingEntity attacker;
    private final RSVPlugin plugin;
    private final double chance;
    private final double reach;
    private final List<String> blacklistedMobs;
    private final List<String> blacklistedItems;
    private final Entity target;
    private static final Map<UUID, EntityLongAttackTask> tasks = new HashMap<>();

    public EntityLongAttackTask(RSVModule module, RSVPlugin plugin, LivingEntity attacker, ItemStack item, Entity target) {
        FileConfiguration config = module.getUserConfig().getConfig();
        FileConfiguration swConfig = RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig();

        String name = RSVItem.getNameFromItem(item);
        this.plugin = plugin;
        this.attacker = attacker;
        this.chance = swConfig.getDouble("MobAbilities.UseLongReachWeapons.Chance");

        this.reach = config.getDouble("Items." + name + ".Reach");
        this.blacklistedMobs = swConfig.getStringList("MobAbilities.UseLongReachWeapons.MobBlacklist");
        this.blacklistedItems = swConfig.getStringList("MobAbilities.UseLongReachWeapons.WeaponBlacklist");
        this.target = target;
        tasks.put(attacker.getUniqueId(), this);
    }

    @Override
    public void run() {
        if (attacker == null) {
            stop();
        }
        else {
            if (blacklistedMobs.contains(attacker.getType().toString()) || attacker.getEquipment() == null || attacker.isDead()) {
                stop();
            }
            else {
                ItemStack itemMainHand = attacker.getEquipment().getItemInMainHand();

                if (isItemValid(itemMainHand)) {
                    if (Utils.roll(chance)) {
                        Location eye = attacker.getEyeLocation().add(attacker.getLocation().getDirection());
                        Predicate<Entity> filter = entity -> !entity.getUniqueId().equals(attacker.getUniqueId());
                        RayTraceResult result = attacker.getWorld().rayTrace(attacker.getEyeLocation(), eye.getDirection(), reach, FluidCollisionMode.NEVER, false, 0, filter);

                        if (result != null) {
                            Entity defender = result.getHitEntity();

                            if (defender != null) {
                                if (target == null) {
                                    Utils.attack(attacker, defender);
                                }
                                else if (target.getUniqueId().equals(defender.getUniqueId())) {
                                    Utils.attack(attacker, target);
                                }
                            }
                        }
                    }
                }
                else {
                    stop();
                }
            }
        }
    }

    public void start() {
        FileConfiguration swConfig = RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig();

        runTaskTimer(plugin, 0, swConfig.getInt("MobAbilities.UseLongReachWeapons.TickPeriod"));
    }

    public void stop() {
        tasks.remove(attacker.getUniqueId());
        cancel();
    }

    public boolean isItemValid(@Nullable ItemStack item) {
        if (Utils.isItemReal(item)) {
            if (RSVItem.isRSVItem(item)) {
                String name = RSVItem.getNameFromItem(item);

                if (!blacklistedItems.contains(name)) {
                    if (name.contains("_")) {
                        String type = name.substring(name.lastIndexOf("_") + 1);

                        switch (type) {
                            case "greatsword", "spear", "halberd", "pike", "lance" -> {
                                return true;
                            }
                            default -> {}
                        }
                    }
                }
            }
        }
        return false;
    }


    public LivingEntity getAttacker() {
        return attacker;
    }

    public static Map<UUID, EntityLongAttackTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
