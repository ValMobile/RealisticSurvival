package me.val_mobile.tan;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.WordUtils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class TanRunnables {

    public static final double NEUTRAL_TEMPERATURE = 13.0;
    public static final double HIGHEST_TEMPERATURE = 25.0;
    public static final double LOWEST_TEMPERATURE = 0.0;

    public static final double LOWEST_THIRST = 20.0;
    public static final double HIGHEST_THIRST = 0.0;

    private final RLCraftPlugin plugin;
    private final Utils util;

    public TanRunnables(RLCraftPlugin instance) {
        plugin = instance;
        util = new Utils(instance);
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

                    if (temperature > 25)
                        temperature = 20;
                    if (temperature < 0)
                        temperature = 0;
                    if (thirst > 20)
                        thirst = 20;
                    if (thirst < 0)
                        thirst = 0;

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

        if (biomeTemp <= 0.30) {
            if (biomeTemp < -0.01) {
                biomeTemp *= 30;
            }
            else if (biomeTemp > 0.01) {
                biomeTemp *= -20;
            }
            else {
                biomeTemp -= 0.1;
                biomeTemp *= 20;
            }
        }

        double normalTemp = NEUTRAL_TEMPERATURE + 3 * (biomeTemp + Utils.getDayMultiplier(pWorld));

        double environment = 0;
        double regulation = 0;

        Random r = new Random();

        if (thirst >= 0.6) {
            if (r.nextDouble() <= 0.1) {
                thirst -= 1.0;
            }
        }

        for (int x = -3; x < 4; x++) {
            for (int y = -3; y < 4; y++) {
                for (int z = -3; z < 4; z++) {
                    Location loc = new Location(player.getWorld(), px + x, py + y, pz + z);
                    Block block = loc.getBlock();

                    if (block != null) {
                        String path = "Temperature.Blocks";
                        ConfigurationSection section = CustomConfig.getToughasNailsConfig().getConfigurationSection(path);

                        String material = block.getBlockData().getMaterial().toString();
                        if (section.getKeys(true).contains(material)) {
                            environment += CustomConfig.getToughasNailsConfig().getDouble(path + "." + material);
                        }
                    }
                }
            }
        }

        if (player.isInWater()) {
            environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.SubmergedWater");
        }
        if (pLoc.getBlock() != null) {
            if (pLoc.getBlock().getBlockData().getMaterial() == Material.LAVA) {
                environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.SubmergedLava");
            }
        }

        if (!pWorld.isClearWeather()) {
            if (Utils.isExposedToSky(player)) {
                environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.Storming");
            }
        }

        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (Utils.isItemReal(item)) {
                ItemMeta meta = item.getItemMeta();

                Material mat = item.getType();
                String s = mat.toString();

                if (util.hasNbtTag(item, "tan_materials")) {
                    if (util.getNbtTag(item, "tan_materials").equals("Wool")) {
                        environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.WoolArmor." + WordUtils.capitalizeFully(s.substring(s.indexOf('_') + 1)));
                    }
                    else if (util.getNbtTag(item, "tan_materials").equals("Jelled Slime")) {
                        environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.JelledSlimeArmor." + WordUtils.capitalizeFully(s.substring(s.indexOf('_') + 1)));
                    }
                }

                if (meta.hasEnchant(TanEnchants.COOLING)) {
                    environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.Cooling");
                }
                if (meta.hasEnchant(TanEnchants.WARMING)) {
                    environment += CustomConfig.getToughasNailsConfig().getDouble("Temperature.Warming");
                }
            }
        }

        double dif = Math.abs(temp - (normalTemp + environment));

        // if not equal
        if (dif > 0.01) {
            int sign = (temp > normalTemp + environment) ? -1 : 1;

            if (dif < CustomConfig.getToughasNailsConfig().getDouble("Temperature.MaxChange")) {
                temp += dif * sign;
            }
            else {
                temp += CustomConfig.getToughasNailsConfig().getDouble("Temperature.MaxChange") * sign;
            }
        }

        if (temp != NEUTRAL_TEMPERATURE) {
            int sign = (temp > NEUTRAL_TEMPERATURE) ? -1 : 1;

            if (!Utils.isExposedToSky(player)) {
                regulation += CustomConfig.getToughasNailsConfig().getDouble("Temperature.Housed") * sign;
            }

            for (ItemStack item : player.getInventory().getArmorContents()) {
                if (Utils.isItemReal(item)) {
                    Material mat = item.getType();
                    String s = mat.toString();

                    switch (mat) {
                        case LEATHER_HELMET:
                        case LEATHER_CHESTPLATE:
                        case LEATHER_LEGGINGS:
                        case LEATHER_BOOTS:
                        case GOLDEN_HELMET:
                        case GOLDEN_CHESTPLATE:
                        case GOLDEN_LEGGINGS:
                        case GOLDEN_BOOTS:
                        case IRON_HELMET:
                        case IRON_CHESTPLATE:
                        case IRON_LEGGINGS:
                        case IRON_BOOTS:
                        case DIAMOND_HELMET:
                        case DIAMOND_CHESTPLATE:
                        case DIAMOND_LEGGINGS:
                        case DIAMOND_BOOTS:
                        case CHAINMAIL_HELMET:
                        case CHAINMAIL_CHESTPLATE:
                        case CHAINMAIL_LEGGINGS:
                        case CHAINMAIL_BOOTS:
                        case NETHERITE_HELMET:
                        case NETHERITE_CHESTPLATE:
                        case NETHERITE_LEGGINGS:
                        case NETHERITE_BOOTS:
                        case TURTLE_HELMET:
                            if (!util.hasNbtTag(item, "tan_materials")) {
                                regulation += CustomConfig.getToughasNailsConfig().getDouble("Temperature.Regulation." + WordUtils.capitalizeFully(s.substring(0, s.indexOf('_'))) + "Armor." + WordUtils.capitalizeFully(s.substring(s.indexOf('_') + 1))) * sign;

                                if (item.getItemMeta().hasEnchant(TanEnchants.OZZY_LINER)) {
                                    regulation += CustomConfig.getToughasNailsConfig().getDouble("Temperature.Regulation.OzzyLiner") * sign;
                                }
                            }
                    }
                }
            }

            // negative regulation
            if (sign == -1) {
                if (temp + regulation * sign <= NEUTRAL_TEMPERATURE) {
                    temp = NEUTRAL_TEMPERATURE;
                }
                else {
                    temp += regulation * sign;
                }
            }
            // positive regulation
            else {
                if (temp + regulation * sign >= NEUTRAL_TEMPERATURE) {
                    temp = NEUTRAL_TEMPERATURE;
                }
                else {
                    temp += regulation * sign;
                }
            }

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
