package me.val_mobile.toughasnails;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class ToughAsNailsRunnables {

    public static final double NEUTRAL_TEMPERATURE = 13.0;
    public static final double HIGHEST_TEMPERATURE = 25.0;
    public static final double LOWEST_TEMPERATURE = 0.0;

    public static final double LOWEST_THIRST = 20.0;
    public static final double HIGHEST_THIRST = 0.0;

    private final RLCraftPlugin plugin;

    public ToughAsNailsRunnables(RLCraftPlugin instance) {
        plugin = instance;
    }

    public BukkitRunnable getVisualRunnable(Player player) {
        return new PlayerRunnable(player, "") {
            @Override
            public void run() {
                GameMode mode = player.getGameMode(); // get the player's name
                String name = player.getName(); // get the player's name
                if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                    int temperature = (int) Math.round(PlayerRunnable.getTemperature().get(name));
                    int thirst = (int) Math.round(PlayerRunnable.getThirst().get(name));
                    int isHoldingBreath = player.getRemainingAir() < 300 ? 1 : 0;

                    TemperatureThirstValues val = TemperatureThirstValues.valueOf("TEMP" + temperature + "_THIRST" + thirst + "_BREATH" + isHoldingBreath);

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(val.getActionbarText()));

                    // if the player's temperature reaches a certain low or high point
                    if (temperature < 4.0 || temperature > 19.0) {
                        String text = "";
                        switch (temperature) {
                            case 0:
                                text = "\uE835";
                                break;
                            case 1:
                                text = "\uE834";
                                break;
                            case 2:
                                text = "\uE833";
                                break;
                            case 3:
                                text = "\uE832";
                                break;
                            case 20:
                                text = "\uE821";
                                break;
                            case 21:
                                text = "\uE822";
                                break;
                            case 22:
                                text = "\uE823";
                                break;
                            case 23:
                                text = "\uE824";
                                break;
                            case 24:
                            case 25:
                                text = "\uE825";
                                break;
                        }

                        if (!text.equals(""))
                            player.sendTitle(text, "", 0, 70, 0);
                    }

                    // if the player's temperature reaches a certain low or high point
                    if (thirst <= CustomConfig.getToughasNailsConfig().getDouble("Thirst.Dehydration.Limit"))
                        player.damage(CustomConfig.getToughasNailsConfig().getDouble("Thirst.Dehydration.Damage"));

                    // if the player's temperature is too low
                    if (temperature <= CustomConfig.getToughasNailsConfig().getDouble("Temperature.Hypothermia.Limit"))
                        player.damage(CustomConfig.getToughasNailsConfig().getDouble("Temperature.Hypothermia.Damage"));

                    // if the player's temperature is too high
                    if (temperature >= CustomConfig.getToughasNailsConfig().getDouble("Temperature.Hyperthermia.Limit"))
                        player.damage(CustomConfig.getToughasNailsConfig().getDouble("Temperature.Hyperthermia.Damage"));

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

    public BukkitRunnable getCheckerRunnable(Player player) {
        return new PlayerRunnable(player, "") {
            @Override
            public void run() {
                GameMode mode = player.getGameMode(); // get the player's name
                String name = player.getName(); // get the player's name
                if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                    updateTemperatureThirstValues(player);
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

        World pWorld = player.getWorld();
        Location pLoc = player.getLocation();
        double px = pLoc.getX();
        double py = pLoc.getY();
        double pz = pLoc.getZ();

        double temp = PlayerRunnable.getTemperature().get(player.getName()); // create a variable to store the temperature
        double thirst = PlayerRunnable.getThirst().get(player.getName()); // create a variable to store the thirst

        double biomeTemp = pWorld.getTemperature((int) px, (int) py, (int) pz); // create a variable to store the temperature

        double normalTemp = NEUTRAL_TEMPERATURE + biomeTemp * 5.0 * Utils.getDayMultiplier(pWorld, biomeTemp);

        double environment = 0;

        Random r = new Random();

        if (thirst >= 0.6) {
            if (r.nextDouble() <= 0.1) {
                thirst -= 1.0;
            }
        }

        for (int x = -5; x < 6; x++) {
            for (int y = -1; y < 6; y++) {
                for (int z = -5; z < 6; z++) {
                    Location loc = new Location(player.getWorld(), px + x, py + y, pz + z);
                    Block block = loc.getBlock();

                    if (block != null) {
                        String path = "Temperature.Blocks";
                        ConfigurationSection section = CustomConfig.getToughasNailsConfig().getConfigurationSection(path);

                        String material = block.getType().toString();
                        if (section.getKeys(false).contains(material)) {
                            environment += CustomConfig.getToughasNailsConfig().getDouble(path + "." + material);
                        }
                    }
                }
            }
        }

        if (player.isInWater()) {
            environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.SubmergedWater");
        }
        if (player.getLocation().getBlock() != null) {
            if (player.getLocation().getBlock().getType() == Material.LAVA) {
                environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.SubmergedLava");
            }
        }

        // if not equal
        if (Math.abs(temp - (normalTemp + environment)) > 0.01) {
            if (temp > normalTemp + environment) {
                if (temp - CustomConfig.getToughasNailsConfig().getDouble("Temperature.MaxChange") >= LOWEST_TEMPERATURE) {
                    temp -= CustomConfig.getToughasNailsConfig().getDouble("Temperature.MaxChange");
                }
            }
            // less
            else {
                if (temp + CustomConfig.getToughasNailsConfig().getDouble("Temperature.MaxChange") >= LOWEST_TEMPERATURE) {
                    temp += CustomConfig.getToughasNailsConfig().getDouble("Temperature.MaxChange");
                }
            }
        }

        if (temp < LOWEST_TEMPERATURE) {
            temp = LOWEST_TEMPERATURE;
        }
        else if (temp > HIGHEST_TEMPERATURE) {
            temp = HIGHEST_TEMPERATURE;
        }

        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperature(), name, temp);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), name, thirst);
    }

    public void resetTemperatureThirstMaps(Player player) {
        String name = player.getName(); // get the player's name

        // reset bauble values
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperature(), name, NEUTRAL_TEMPERATURE);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), name, LOWEST_THIRST);

        // set the runnable values to false since there will be no active temperature or thirst runnables on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperatureRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirstRunnables(), name, false);
    }

    public void startTemperatureThirstRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int visualTickTime = CustomConfig.getToughasNailsConfig().getInt("VisualTickTime"); // get the tick speed
        int checkTickTime = CustomConfig.getToughasNailsConfig().getInt("CheckTickTime"); // get the tick speed

        // start the runnable
        getVisualRunnable(player).runTaskTimer(plugin, 0, visualTickTime);
        getCheckerRunnable(player).runTaskTimer(plugin, 0, checkTickTime);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getTemperatureRunnables(), name, true);
        Utils.setOrReplaceEntry(PlayerRunnable.getThirstRunnables(), name, true);
    }
}
