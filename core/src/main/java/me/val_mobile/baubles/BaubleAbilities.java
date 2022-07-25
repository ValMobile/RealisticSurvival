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

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Set;

/**
 * BaubleAbilities is a utility class containing methods that
 * execute various abilities of the bauble items
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class BaubleAbilities {

    /**
     * Effects the entity with poison
     * @param entity The target entity
     * @see me.val_mobile.baubles.BaubleEvents
     * @see me.val_mobile.utils.Utils
     */
    public static void PoisonStoneAbility(LivingEntity entity) {
        FileConfiguration config = me.val_mobile.data.RSVFiles.getBaubleUserConfig();
        ConfigurationSection section = config.getConfigurationSection("Items.poison_stone.Effects");
        Set<String> keys = section.getKeys(false);

        for (String key : keys) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.getByName(key), section.getInt(key + ".Duration"),  section.getInt(key + ".Amplifier")));
        }
    }

    public static BukkitRunnable freezeEntity(LivingEntity entity) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                entity.setVelocity(new Vector());
            }
        };
    }
}
