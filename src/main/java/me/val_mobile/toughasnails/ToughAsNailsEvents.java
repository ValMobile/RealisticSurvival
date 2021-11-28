package me.val_mobile.toughasnails;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static me.val_mobile.toughasnails.ToughAsNailsRunnables.LOWEST_THIRST;

public class ToughAsNailsEvents implements Listener {

    private final ToughAsNailsRunnables toughAsNailsRunnables;
    private final RLCraftPlugin plugin;

    public ToughAsNailsEvents(RLCraftPlugin instance) {
        toughAsNailsRunnables = new ToughAsNailsRunnables(instance);
        plugin = instance;
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

    @EventHandler
    public void onDrink(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        GameMode mode = player.getGameMode();
        if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (player.isSneaking()) {
                    Location playerLoc = player.getLocation();

                    Block block = event.getClickedBlock();
                    Location loc = block.getLocation();

                    Location aboveLoc = loc.clone();
                    aboveLoc.setY(loc.getY() + 1D);
                    Block aboveBlock = aboveLoc.getBlock();

                    Block waterSource = null;

                    if (block.getType() == Material.WATER)
                        if (Utils.isSourceLiquid(block))
                            waterSource = event.getClickedBlock();
                    else if (aboveBlock.getType() == Material.WATER)
                        if (Utils.isSourceLiquid(aboveBlock))
                            waterSource = aboveBlock;

                    if (waterSource != null) {
                        Double maxDistance = CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.MaxDistance");

                        if (playerLoc.distance(waterSource.getLocation()) < maxDistance) {
                            double current = PlayerRunnable.getThirst().get(player.getName());
                            double difference = LOWEST_THIRST - current;

                            if (Math.abs(difference) >= 0.01) {

                                if (difference > CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.Amount")) {
                                    Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Drinking"));
                                }
                                else {
                                    Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                                }

                                Sound sound = Sound.valueOf(CustomConfig.getToughasNailsConfig().getString("Thirst.Supplements.Drinking.Sound"));
                                float volume = (float) CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.Volume");
                                float pitch = (float) CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.Pitch");

                                if (volume != -1.0) {
                                    player.playSound(playerLoc, sound, volume, pitch);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        GameMode mode = player.getGameMode();

        if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
            if (event.getItem().getType() == Material.POTION) {
                double current = PlayerRunnable.getThirst().get(player.getName());
                double difference = LOWEST_THIRST - current;

                if (Math.abs(difference) >= 0.01) {
                    if (difference > CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.WaterBottle")) {
                        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.WaterBottle"));
                    } else {
                        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                    }
                }
            }
        }
    }

}
