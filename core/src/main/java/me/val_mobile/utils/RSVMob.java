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
package me.val_mobile.utils;

import me.val_mobile.data.RSVModule;
import org.apache.commons.lang.StringUtils;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RSVMob {

    List<String> getRequiredModules();

    String getParentModule();

    String name();

    static boolean isMob(Entity entity) {
        return Utils.hasNbtTag(entity, "rsvmob");
    }

    static String getMob(Entity entity) {
        return Utils.getNbtTag(entity, "rsvmob", PersistentDataType.STRING);
    }

    void addNbtData();

    Collection<ItemStack> getLoot(@Nullable ItemStack tool);

    @Nonnull
    default Collection<ItemStack> getConfigurableLoot(@Nullable ItemStack tool) {
        Collection<ItemStack> loot = new ArrayList<>();

        FileConfiguration config = RSVModule.getModule(getParentModule()).getUserConfig().getConfig();

        if (config.contains("MobDrops." + name())) {
            ConfigurationSection section = config.getConfigurationSection("MobDrops." + name());

            Set<String> itemKeys = section.getKeys(false);

            for (String itemKey : itemKeys) {
                if (RSVItem.isRSVItem(itemKey)) {
                    loot.add(Utils.getMobLoot(section.getConfigurationSection(itemKey), RSVItem.getItem(itemKey), tool, true));
                }
            }
        }

        return loot;
    }

    default void setup() {
        addNbtData();
        applyConfigOptions();
    }

    default void applyConfigOptions() {
        Entity entity = getEntity();

        String name = name();


        name = name.contains("_") ? StringUtils.capitalize(name.substring(0, name.indexOf("_"))) + StringUtils.capitalize(name.substring(name.indexOf("_") + 1)) : name;
        name = StringUtils.capitalize(name);

        ConfigurationSection section = RSVModule.getModule(getParentModule()).getUserConfig().getConfig().getConfigurationSection(name + ".Info");

        entity.setCustomName(Utils.translateMsg(section.getString("Name"), entity, null));
        entity.setCustomNameVisible(section.getBoolean("CustomNameVisible"));

        if (entity instanceof LivingEntity living) {
            double minHealth = section.getDouble("Health.Min");
            double maxHealth = section.getDouble("Health.Max");

            double health = Utils.getRandomNum(minHealth, maxHealth);

            if (health > living.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                living.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
            }

            living.setHealth(health);
        }
    }

    Entity getEntity();

    void addEntityToWorld(World world);
}
