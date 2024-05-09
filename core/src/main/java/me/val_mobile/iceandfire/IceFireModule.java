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
package me.val_mobile.iceandfire;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.ModuleRecipes;
import me.val_mobile.data.RSVConfig;
import me.val_mobile.data.RSVModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import me.val_mobile.spartanandfire.FreezeTask;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public class IceFireModule extends RSVModule {

    private final RSVPlugin plugin;

    public static final String NAME = "IceandFire";
    private IceFireEvents events;


    public IceFireModule(RSVPlugin plugin) {
        super(NAME, plugin, Map.of(), Map.of());
        this.plugin = plugin;
    }

    @Override
    public void initialize() {
        setUserConfig(new RSVConfig(plugin, "iceandfire.yml"));
        setItemConfig(new RSVConfig(plugin, "resources/iceandfire/items.yml"));
        setRecipeConfig(new RSVConfig(plugin, "resources/iceandfire/items.yml"));
        setModuleItems(new ModuleItems(this));
        setModuleRecipes(new ModuleRecipes(this, plugin));

        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Initialize.Enabled")) {
            String message = Utils.translateMsg(config.getString("Initialize.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }

        events = new IceFireEvents(this, plugin);

        getModuleItems().initialize();
        getModuleRecipes().initialize();
        events.initialize();
    }

    @Override
    public void shutdown() {
        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Shutdown.Enabled")) {
            String message = Utils.translateMsg(config.getString("Shutdown.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }
    }

    public IceFireEvents getEvents() {
        return events;
    }

    public static double applyDragonItemBonusDamage(@Nullable Entity defender, @Nullable ItemStack item, double origDamage, @Nonnull RSVModule compare) {
        if (!(RSVItem.isRSVItem(item) && RSVItem.getModuleNameFromItem(item).equals(compare.getName())))
            return origDamage;

        return applyDragonItemBonusDamage(defender, RSVItem.getNameFromItem(item), origDamage, compare);
    }

    public static double applyDragonItemBonusDamage(@Nullable Entity defender, @Nullable String name, double origDamage, @Nonnull RSVModule compare) {
        if (compare.getUserConfig() == null || defender == null || name == null || name.isEmpty() || name.startsWith("_") || name.endsWith("_"))
            return origDamage;

        if (!(RSVItem.isRSVItem(name) && compare.getName().equals(RSVItem.getModuleNameFromItem(RSVItem.getItem(name)))))
            return origDamage;

        FileConfiguration config = compare.getUserConfig().getConfig();

        String type = name.substring(0, name.lastIndexOf("_"));
        String weaponType = name.substring(name.lastIndexOf("_") + 1);

        if (weaponType.equals("longbow") || weaponType.equals("crossbow")) {
            origDamage *= config.getDouble("Items." + name + ".AttackDamageMultiplier");
        }

        String prefix = switch (type) {
            case "dragonbone_flamed" -> "fire";
            case "dragonbone_iced" -> "ice";
            case "dragonbone_lightning" -> "lightning";
            default -> null;
        };

        if (prefix == null)
            return origDamage;

        if (Utils.hasNbtTag(defender, "rsvmob") && !Utils.getNbtTag(defender, "rsvmob", PersistentDataType.STRING).equals(prefix + "_dragon")) {
            origDamage += config.getDouble("Items." + name + ".DragonBonusDamage");
        }

        return origDamage;
    }

    public static void applyDragonItemEffect(@Nullable Entity defender, @Nullable ItemStack item, @Nonnull RSVModule compare) {
        if (!(RSVItem.isRSVItem(item) && RSVItem.getModuleNameFromItem(item).equals(compare.getName())))
            return;

        applyDragonItemEffect(defender, RSVItem.getNameFromItem(item), compare);
    }

    public static void applyDragonItemEffect(@Nullable Entity defender, @Nullable String name, @Nonnull RSVModule compare) {
        if (compare.getUserConfig() == null || defender == null || name == null || name.isEmpty() || name.startsWith("_") || name.endsWith("_"))
            return;

        if (!(RSVItem.isRSVItem(name) && compare.getName().equals(RSVItem.getModuleNameFromItem(RSVItem.getItem(name)))))
            return;

        FileConfiguration config = compare.getUserConfig().getConfig();
        RSVPlugin plugin = RSVPlugin.getPlugin();

        String type = name.substring(0, name.lastIndexOf("_"));

        switch (type) {
            case "dragonbone_flamed", "dragonsteel_fire" -> {
                if (!BurnTask.hasTask(defender.getUniqueId())) {
                    int fireTicks = config.getInt("Items." + name + ".InfernoAbility.FireTicks");
                    int tickPeriod = config.getInt("Items." + name + ".InfernoAbility.TickPeriod");

                    new BurnTask(plugin, defender, fireTicks, tickPeriod).start();
                }
            }
            case "dragonbone_iced", "dragonsteel_ice" -> {
                if (!FreezeTask.hasTask(defender.getUniqueId())) {
                    new FreezeTask(plugin, compare, name, defender).start();
                }
            }
            case "dragonbone_lightning", "dragonsteel_lightning" -> {
                if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Enabled")) {
                    Location loc = defender.getLocation();
                    if (config.getBoolean("Items." + name + ".ElectrocuteAbility.SummonLightning.Cosmetic")) {
                        loc.getWorld().strikeLightningEffect(loc);
                    } else {
                        loc.getWorld().strikeLightning(loc);
                    }
                }

                if (defender instanceof Damageable damageable && !ElectrocuteTask.hasTask(defender.getUniqueId())) {
                    new ElectrocuteTask(plugin, compare, name, damageable).start();
                }
            }
            default -> {}
        }
    }
}
