package me.val_mobile.toughasnails;

import me.val_mobile.rlcraft.RLCraftPlugin;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ToughAsNailsEvents implements Listener {

    private final ToughAsNailsRunnables toughAsNailsRunnables;

    public ToughAsNailsEvents(RLCraftPlugin instance) {
        toughAsNailsRunnables = new ToughAsNailsRunnables(instance);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        if (!event.isCancelled()) {
            GameMode mode = event.getNewGameMode();
            if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                Player player = event.getPlayer();

                toughAsNailsRunnables.updateTemperatureThirstValues(player);
                toughAsNailsRunnables.startTemperatureThirstRunnable(player);
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        toughAsNailsRunnables.resetTemperatureThirstMaps(event.getPlayer());
    }
}
