package me.val_mobile.toughasnails;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ToughAsNailsRunnables {

    private final RLCraftPlugin plugin;

    public ToughAsNailsRunnables(RLCraftPlugin instance) {
        plugin = instance;
    }

    public BukkitRunnable getTemperatureThirstRunnable(Player player) {
        return new PlayerRunnable(player, "") {
            @Override
            public void run() {
                GameMode mode = player.getGameMode(); // get the player's name
                String name = player.getName(); // get the player's name
                if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                    int temperature = PlayerRunnable.getTemperature().get(name);
                    int thirst = PlayerRunnable.getThirst().get(name);
                    int isHoldingBreath = player.getRemainingAir() < 300 ? 1 : 0;

                    TemperatureThirstValues val = TemperatureThirstValues.valueOf("TEMP" + temperature + "_THIRST" + thirst + "_BREATH" + isHoldingBreath);

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(val.getActionbarText()));

                    // if the player's temperature reaches a certain low or high point
                    if (temperature > 0) {
                        // any screen or damage effects
                    }

                    // if the player's temperature reaches a certain low or high point
                    if (thirst > 0) {
                        // any screen or damage effects
                    }
                }
                // if the player is in creative or spectator
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getTemperatureRunnables(), name, false);
                    cancel();
                }
            }
        };
    }

    public void updateTemperatureThirstValues(Player player) {
        String name = player.getName(); // get the player's name
        int temperature = 13; // create a variable to store the temperature
        int thirst = 20; // create a variable to store the thirst

        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperature(), name, temperature);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), name, thirst);
    }

    public void resetTemperatureThirstMaps(Player player) {
        String name = player.getName(); // get the player's name

        // reset bauble values
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperature(), name, 13);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), name, 20);

        // set the runnable values to false since there will be no active temperature or thirst runnables on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperatureRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirstRunnables(), name, false);
    }

    public void startTemperatureThirstRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getToughasNailsConfig().getInt("TickTime"); // get the tick speed

        // start the runnable
        getTemperatureThirstRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperatureRunnables(), name, true);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirstRunnables(), name, true);
    }
}
