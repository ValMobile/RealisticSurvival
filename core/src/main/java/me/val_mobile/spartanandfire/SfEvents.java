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
package me.val_mobile.spartanandfire;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanweaponry.SwModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SfEvents extends ModuleEvents implements Listener {

    private final RSVPlugin plugin;
    private final SfModule module;
    private final FileConfiguration config;

    public SfEvents(SfModule module, RSVPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
    }

    /**
     * Activates dragon weapon abilities if a player attacks with a dragon weapon
     * @param event The event called when an entity attacks another entity
     * @see Utils
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity(); // get the defender
        Entity attacker = event.getDamager(); // get the attacker

        if (!(shouldEventBeRan(attacker) && shouldEventBeRan(defender)))
            return;

        double damage = event.getDamage();

        if (Utils.hasNbtTag(attacker, "rsvbow")) {
            String name = Utils.getNbtTag(attacker, "rsvbow", PersistentDataType.STRING);

            IceFireModule.applyDragonItemEffect(defender, name, module);
            damage = IceFireModule.applyDragonItemBonusDamage(defender, name, damage, module);
        }
        else if (attacker instanceof LivingEntity living && living.getEquipment() != null) {
            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

            IceFireModule.applyDragonItemEffect(defender, itemMainHand, module);
            damage = IceFireModule.applyDragonItemBonusDamage(defender, itemMainHand, damage, module);
        }

        event.setDamage(damage);
    }
}
