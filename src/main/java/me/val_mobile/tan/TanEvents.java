package me.val_mobile.tan;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
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
import org.bukkit.inventory.ItemStack;

import java.util.Random;

import static me.val_mobile.tan.TanRunnables.LOWEST_THIRST;

public class TanEvents implements Listener {

    private final TanRunnables tanRunnables;
    private final RLCraftPlugin plugin;
    private final Utils util;

    public TanEvents(RLCraftPlugin instance) {
        tanRunnables = new TanRunnables(instance);
        plugin = instance;
        util = new Utils(instance);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        if (!event.isCancelled()) {
            GameMode mode = event.getNewGameMode();
            if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                Player player = event.getPlayer();

                tanRunnables.updateTemperatureThirstValues(player);
                tanRunnables.startTemperatureThirstRunnable(player);
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        tanRunnables.resetTemperatureThirstMaps(event.getPlayer());
    }

    @EventHandler
    public void onDrink(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        GameMode mode = player.getGameMode();
        Action action = event.getAction();
        if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
            if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (player.isSneaking()) {
                    Location playerLoc = player.getLocation();

                    Block block = event.getClickedBlock();
                    Location loc = block.getLocation();

                    Location aboveLoc = loc.clone();
                    aboveLoc.setY(aboveLoc.getY() + 1D);
                    Block aboveBlock = aboveLoc.getBlock();

                    Block waterSource = null;

                    if (block.getBlockData().getMaterial() == Material.WATER) {
                        if (Utils.isSourceLiquid(block)) {
                            waterSource = block;
                        }
                    }

                    if (aboveBlock.getBlockData().getMaterial() == Material.WATER) {
                        if (Utils.isSourceLiquid(aboveBlock)) {
                            waterSource = aboveBlock;
                        }
                    }

                    if (waterSource != null) {
                        double maxDistance = CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.MaxDistance");

                        if (playerLoc.distance(waterSource.getLocation()) < maxDistance) {
                            double current = PlayerRunnable.getThirst().get(player.getName());
                            double difference = LOWEST_THIRST - current;

                            if (CustomConfig.getToughasNailsConfig().getBoolean("Thirst.Supplements.Drinking.OverrideLimit")) {
                                Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.Amount"));
                            }
                            else {
                                if (Math.abs(difference) >= 0.01) {

                                    if (difference > CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.Amount")) {
                                        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Drinking.Amount"));
                                    }
                                    else {
                                        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                                    }
                                }
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
            else if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_AIR)) {
                if (!player.getWorld().isClearWeather()) {
                    if (player.isSneaking()) {
                        if (Utils.isExposedToSky(player)) {
                            Location loc = player.getLocation();
                            if (Math.abs(loc.getPitch() + 90F) < 0.01) {
                                double current = PlayerRunnable.getThirst().get(player.getName());
                                double difference = LOWEST_THIRST - current;

                                if (CustomConfig.getToughasNailsConfig().getBoolean("Thirst.Supplements.Raining.OverrideLimit")) {
                                    Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Raining.Amount"));
                                }
                                else {
                                    if (Math.abs(difference) >= 0.01) {
                                        if (difference > CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Raining.Amount")) {
                                            Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Raining.Amount"));
                                        } else {
                                            Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                                        }
                                    }
                                }
                                Sound sound = Sound.valueOf(CustomConfig.getToughasNailsConfig().getString("Thirst.Supplements.Raining.Sound"));
                                float volume = (float) CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Raining.Volume");
                                float pitch = (float) CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.Raining.Pitch");

                                if (volume != -1.0) {
                                    player.playSound(loc, sound, volume, pitch);
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
            ItemStack item = event.getItem();

            if (item.getType() == Material.POTION) {
                double current = PlayerRunnable.getThirst().get(player.getName());
                double difference = LOWEST_THIRST - current;

                String drink;

                if (util.hasNbtTag(item, "tan_drinks")) {
                    drink = util.getNbtTag(item, "tan_drinks");
                }
                else {
                    drink = "WaterBottle";
                }


                if (CustomConfig.getToughasNailsConfig().getBoolean("Thirst.Supplements." + drink + ".OverrideLimit")) {
                    Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements." + drink + ".Amount"));
                }
                else {
                    if (Math.abs(difference) >= 0.01) {
                        if (difference > CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements." + drink + ".Amount")) {
                            Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements." + drink + ".Amount"));
                        } else {
                            Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                        }
                    }
                }

                if (drink.equals("ChorusFruitJuice")) {
                    if (CustomConfig.getToughasNailsConfig().getBoolean("Thirst.Supplements.ChorusFruitJuice.Teleport.Enabled")) {
                        Random r = new Random();
                        Location loc = player.getLocation();
                        final double RADIUS = CustomConfig.getToughasNailsConfig().getDouble("Thirst.Supplements.ChorusFruitJuice.Teleport.MaxRadius");
                        double x = loc.getX() + r.nextDouble() * RADIUS;
                        double z = loc.getZ() + r.nextDouble() * RADIUS;

                        Location newLoc = new Location(loc.getWorld(), x, loc.getWorld().getHighestBlockYAt((int) Math.round(x), (int) Math.round(z)), z, loc.getYaw(), loc.getPitch());
                        player.teleport(newLoc);
                    }
                }
            }
        }
    }

}
