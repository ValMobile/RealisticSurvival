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
package me.val_mobile.misc;

import me.val_mobile.baubles.BaubleRunnables;
import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.sea_serpents.SeaSerpentGearRunnables;
import me.val_mobile.tan.TanRunnables;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomRecipes;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Recipe;

public class PlayerInitializer implements Listener {

    private final RLCraftPlugin plugin;
    private final SeaSerpentGearRunnables seaSerpentGearRunnables;
    private final BaubleRunnables baubleRunnables;
    private final TanRunnables tanRunnables;

    public PlayerInitializer(RLCraftPlugin instance) {
        plugin = instance;
        seaSerpentGearRunnables = new SeaSerpentGearRunnables(instance);
        baubleRunnables = new BaubleRunnables(instance);
        tanRunnables = new TanRunnables(instance);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("NoTreePunching")) {
            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getNtrRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }
        }

        if (config.getBoolean("Dragons")) {
            if (config.getBoolean("UnlockRecipes")) {
                // give the player every dragon gear recipe
                for (Recipe r : CustomRecipes.getDragonRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }

        }

        if (config.getBoolean("SeaSerpents")) {
            seaSerpentGearRunnables.updateTideGuardianArmor(player);
            seaSerpentGearRunnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.TickTime"));

            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getSeaSerpentRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }
        }

        if (config.getBoolean("Baubles")) {
            // create new values in the static hashmaps
            baubleRunnables.resetBaubleMaps(player);
            baubleRunnables.updateBaubleValues(player);

            // start every bauble runnable
            baubleRunnables.startPrResRunnable(player);
            baubleRunnables.startPrStrengthRunnable(player);
            baubleRunnables.startPrSpeedRunnable(player);
            baubleRunnables.startPrJumpRunnable(player);
            baubleRunnables.startPrHasteRunnable(player);
            baubleRunnables.startPrRegenRunnable(player);

            baubleRunnables.startScarliteRingRunnable(player);
            baubleRunnables.startDragonsEyeRunnable(player);
            baubleRunnables.startMinersRingRunnable(player);
            baubleRunnables.startShieldHonorRunnable(player);

            if (config.getBoolean("UnlockRecipes")) {
                // give the player every bauble recipe
                for (Recipe r : CustomRecipes.getBaubleRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }

        }

        if (config.getBoolean("SpartanWeaponry")) {
            if (config.getBoolean("UnlockRecipes")) {
                // give the player every spartan weaponry recipe
                for (Recipe r : CustomRecipes.getSpartanWeaponryRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }

        }

        if (config.getBoolean("Waystones")) {
            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getWaystoneRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }
        }

        if (config.getBoolean("ToughAsNails")) {
            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getTanRecipes()) {
                    Utils.discoverRecipe(player, r);
                }
            }
            // create new values in the static hashmaps
            tanRunnables.resetTemperatureThirstMaps(player);

            // start every bauble runnable
            tanRunnables.startTemperatureThirstRunnable(player);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        // set all the bauble values of the target player to 0

        FileConfiguration config = plugin.getConfig();
        Player player = event.getEntity();

        if (config.getBoolean("Baubles"))
            baubleRunnables.resetBaubleMaps(player);

        if (config.getBoolean("SeaSerpents"))
            seaSerpentGearRunnables.resetArmorMaps(player);

        if (config.getBoolean("ToughAsNails"))
            tanRunnables.resetTemperatureThirstMaps(player);
    }

}
