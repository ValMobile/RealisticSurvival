/*
    Copyright (C) 2021  Val_Mobile

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
/*
    Copyright (C) 2021  Val_Mobile

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
package me.val_mobile.dragons;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEnderDragon;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

/**
 * DragonFightEvents is a class containing listener methods
 * that activate special dragon attacks based on each dragon's breed
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonFightEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;
    private final Utils util;
    public DragonFightEvents(RealisticSurvivalPlugin instance) {
        plugin = instance;
        util = new Utils(instance);
    }

    /**
     * Drops Ice and Fire loot upon dragon, elder guardian, and wither death
     * @param event The event called when an entity dies
     * @see Dragon
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (util.shouldEventBeRan(entity, "Dragons")) {
            // if the entity that died was a dragon
            if (entity instanceof EnderDragon) {
                if (((CraftEnderDragon) entity).getHandle() instanceof Dragon) {
                    Dragon dragon = (Dragon) ((CraftEnderDragon) entity).getHandle();
                    Location loc = dragon.getBukkitEntity().getLocation();
                    World world = dragon.getBukkitEntity().getWorld();

                    dragon.generateLoot();

                    for (ItemStack loot: dragon.getLoot()) {
                        world.dropItemNaturally(loc, loot);
                    }
                }
            }
        }
    }
}