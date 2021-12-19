package me.val_mobile.misc;

import me.val_mobile.baubles.BaubleRunnables;
import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.sea_serpents.SeaSerpentGearRunnables;
import me.val_mobile.tan.TanRunnables;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomRecipes;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;

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
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
                }
            }
        }

        if (config.getBoolean("Dragons")) {
            if (config.getBoolean("UnlockRecipes")) {
                // give the player every dragon gear recipe
                for (Recipe r : CustomRecipes.getDragonRecipes()) {
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
                }
            }

        }

        if (config.getBoolean("SeaSerpents")) {
            seaSerpentGearRunnables.updateTideGuardianArmor(player);
            seaSerpentGearRunnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, CustomConfig.getIceFireGearConfig().getInt("Abilities.TideGuardian.TickTime"));

            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getSeaSerpentRecipes()) {
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
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
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
                }
            }

        }

        if (config.getBoolean("SpartanWeaponry")) {
            if (config.getBoolean("UnlockRecipes")) {
                // give the player every spartan weaponry recipe
                for (Recipe r : CustomRecipes.getSpartanWeaponryRecipes()) {
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
                }
            }

        }

        if (config.getBoolean("Waystones")) {
            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getWaystoneRecipes()) {
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
                }
            }
        }

        if (config.getBoolean("ToughAsNails")) {
            if (config.getBoolean("UnlockRecipes")) {
                for (Recipe r : CustomRecipes.getTanRecipes()) {
                    // if the recipe has a pre-defined shape
                    if (r instanceof ShapedRecipe) {
                        // cast the recipe to a ShapedRecipe and let the player discover it
                        player.discoverRecipe(((ShapedRecipe) r).getKey());
                    }
                    // if the recipe has no shape
                    else if (r instanceof ShapelessRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((ShapelessRecipe) r).getKey());
                    }
                    // if the recipe is in a smithing table
                    else if (r instanceof SmithingRecipe) {
                        // cast the recipe to a ShapelessRecipe and let the player discover it
                        player.discoverRecipe(((SmithingRecipe) r).getKey());
                    }
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
