/*
    Copyright (C) 2022  Val_Mobile

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
package me.val_mobile.tan;

import me.val_mobile.data.RSVFiles;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.WordUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.SplittableRandom;

public class TanRunnables {

    public static final double NEUTRAL_TEMPERATURE = 13.0;
    public static final double HIGHEST_TEMPERATURE = 25.0;
    public static final double LOWEST_TEMPERATURE = 0.0;

    public static final double LOWEST_THIRST = 20.0;
    public static final double HIGHEST_THIRST = 0.0;

    private final RealisticSurvivalPlugin plugin;
    private final Utils util;

    public TanRunnables(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        util = new Utils(plugin);
    }

    public BukkitRunnable getVisualRunnable(Player player) {
        return new PlayerRunnable(player, "") {
            @Override
            public void run() {
                HashMap<String, Double> tempMap = PlayerRunnable.getTemperature();
                HashMap<String, Boolean> tempRunMap = PlayerRunnable.getTemperatureRunnables();
                HashMap<String, Double> thirstMap = PlayerRunnable.getThirst();
                HashMap<String, Boolean> thirstRunMap = PlayerRunnable.getThirstRunnables();

                FileConfiguration tanConfig = RSVFiles.getTanUserConfig();

                GameMode mode = player.getGameMode(); // get the player's name
                String name = player.getName(); // get the player's name
                if ((mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) && util.shouldEventBeRan(player, "ToughAsNails")) {
                    int temperature = (int) Math.round(tempMap.get(name));
                    int thirst = (int) Math.round(thirstMap.get(name));
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

                    if (!(player.hasPermission("realisticsurvival.toughasnails.resistance.*"))) {
                        String text = "";

                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.coldvisual")) {
                            if (temperature < 4.0) {
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
                                }
                            }
                        }

                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotvisual")) {
                            if (temperature > 19.0) {
                                switch (temperature) {
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
                            }
                        }

                        if (!text.equals("")) {
                            player.sendTitle(text, "", 0, 70, 0);
                        }

                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.thirstdamage")) {
                            if (thirst <= tanConfig.getDouble("Thirst.Dehydration.Limit"))
                                player.damage(tanConfig.getDouble("Thirst.Dehydration.Damage"));
                        }

                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.colddamage")) {
                            // if the player's temperature is too low
                            if (temperature <= tanConfig.getDouble("Temperature.Hypothermia.Limit"))
                                player.damage(tanConfig.getDouble("Temperature.Hypothermia.Damage"));
                        }

                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotdamage")) {
                            // if the player's temperature is too high
                            if (temperature >= tanConfig.getDouble("Temperature.Hyperthermia.Limit"))
                                player.damage(tanConfig.getDouble("Temperature.Hyperthermia.Damage"));
                        }

                    }

                }
                // if the player is in creative or spectator
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(tempRunMap, name, false);
                    Utils.setOrReplaceEntry(thirstRunMap, name, false);
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

                HashMap<String, Boolean> tempRunMap = PlayerRunnable.getTemperatureRunnables();
                HashMap<String, Boolean> thirstRunMap = PlayerRunnable.getThirstRunnables();

                if ((mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) && util.shouldEventBeRan(player, "ToughAsNails")) {
                    updateTemperatureThirstValues(player);
                }
                // if the player is in creative or spectator
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(tempRunMap, name, false);
                    Utils.setOrReplaceEntry(thirstRunMap, name, false);
                    cancel();
                }
            }
        };
    }

    public void updateTemperatureThirstValues(Player player) {
        String name = player.getName(); // get the player's name

        FileConfiguration config = RSVFiles.getTanUserConfig();
        HashMap<String, Double> tempMap = PlayerRunnable.getTemperature();
        HashMap<String, Double> thirstMap = PlayerRunnable.getThirst();

        World pWorld = player.getWorld();
        Location pLoc = player.getLocation();
        double px = pLoc.getX();
        double py = pLoc.getY();
        double pz = pLoc.getZ();

        double temp = tempMap.get(player.getName()); // create a variable to store the temperature
        double thirst = thirstMap.get(player.getName()); // create a variable to store the thirst
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

        double thirstChance = config.getDouble("Thirst.Decrement.Chance");
        double thirstAmount = config.getDouble("Thirst.Decrement.Amount");

        double tempMaxChange = config.getDouble("Temperature.MaxChange");
        double tempSubmergedWater = config.getDouble("Temperature.SubmergedWater");
        double tempSubmergedLava = config.getDouble("Temperature.SubmergedLava");
        double tempStorming = config.getDouble("Temperature.Storming");
        double tempBurning = config.getDouble("Temperature.Burning");
        double tempCoolingEnch = config.getDouble("Temperature.Cooling");
        double tempWarmingEnch = config.getDouble("Temperature.Warming");
        double tempHoused = config.getDouble("Temperature.Housed");


        SplittableRandom r = new SplittableRandom();

        if (thirst >= 0.6) {
            if (r.nextDouble() <= thirstChance) {
                thirst -= thirstAmount;
            }
        }

        for (int x = -3; x < 4; x++) {
            for (int y = -3; y < 4; y++) {
                for (int z = -3; z < 4; z++) {
                    Location loc = new Location(player.getWorld(), px + x, py + y, pz + z);
                    Block block = loc.getBlock();

                    if (block != null) {
                        String path = "Temperature.Blocks";
                        ConfigurationSection section = config.getConfigurationSection(path);

                        String material = block.getBlockData().getMaterial().toString();
                        if (section.getKeys(true).contains(material)) {
                            environment += config.getDouble(path + "." + material);
                        }
                    }
                }
            }
        }

        if (player.isInWater()) {
            environment += tempSubmergedWater;
        }
        if (pLoc.getBlock() != null) {
            if (pLoc.getBlock().getBlockData().getMaterial() == Material.LAVA) {
                environment += tempSubmergedLava;
            }
        }

        if (!pWorld.isClearWeather()) {
            if (Utils.isExposedToSky(player)) {
                environment += tempStorming;
            }
        }

        if (player.getFireTicks() > 0) {
            environment += tempBurning;
        }

        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (Utils.isItemReal(item)) {
                ItemMeta meta = item.getItemMeta();

                Material mat = item.getType();
                String s = mat.toString();

                if (util.hasNbtTag(item, "tan_materials")) {
                    if (util.getNbtTag(item, "tan_materials").equals("Wool")) {
                        environment += config.getDouble("Temperature.WoolArmor." + WordUtils.capitalizeFully(s.substring(s.indexOf('_') + 1)));
                    }
                    else if (util.getNbtTag(item, "tan_materials").equals("Jelled Slime")) {
                        environment += config.getDouble("Temperature.JelledSlimeArmor." + WordUtils.capitalizeFully(s.substring(s.indexOf('_') + 1)));
                    }
                }

                if (meta.hasEnchant(TanEnchants.COOLING)) {
                    environment += tempCoolingEnch;
                }
                if (meta.hasEnchant(TanEnchants.WARMING)) {
                    environment += tempWarmingEnch;
                }
            }
        }

        double change = normalTemp + environment - temp;

        int sign = temp + change > NEUTRAL_TEMPERATURE ? -1 : 1;

        if (temp != NEUTRAL_TEMPERATURE) {
            if (!Utils.isExposedToSky(player)) {
                regulation += tempHoused * sign;
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
                                regulation += config.getDouble("Temperature.Regulation." + WordUtils.capitalizeFully(s.substring(0, s.indexOf('_'))) + "Armor." + WordUtils.capitalizeFully(s.substring(s.indexOf('_') + 1))) * sign;

                                if (item.getItemMeta().hasEnchant(TanEnchants.OZZY_LINER)) {
                                    regulation += config.getDouble("Temperature.Regulation.OzzyLiner") * sign;
                                }
                            }
                    }
                }
            }

            // negative regulation
            if (sign == -1) {
                if (sign * regulation < tempMaxChange) {
                    if (temp + regulation <= NEUTRAL_TEMPERATURE) {
                        temp = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temp += regulation;
                    }
                }
                else {
                    if (temp + tempMaxChange <= NEUTRAL_TEMPERATURE) {
                        temp = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temp += tempMaxChange;
                    }
                }
            }
            // positive regulation
            else {
                if (sign * regulation < tempMaxChange) {
                    if (temp + regulation >= NEUTRAL_TEMPERATURE) {
                        temp = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temp += regulation;
                    }
                }
                else {
                    if (temp + sign * tempMaxChange >= NEUTRAL_TEMPERATURE) {
                        temp = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temp += tempMaxChange;
                    }
                }
            }

        }

        change += regulation;

        if (Math.abs(change) < tempMaxChange) {
            temp += change;
        }
        else {
            temp += tempMaxChange * ((change > 0) ? 1 : -1);
        }

        if (temp != NEUTRAL_TEMPERATURE) {
            if (temp < NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.cold")) {
                temp = NEUTRAL_TEMPERATURE;
            }
            if (temp > NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.hot")) {
                temp = NEUTRAL_TEMPERATURE;
            }
        }

        if (thirst < LOWEST_THIRST) {
            if (player.hasPermission("realisticsurvival.toughasnails.resistance.thirst")) {
                thirst = LOWEST_THIRST;
            }
        }

        // update hashmap values
        Utils.setOrReplaceEntry(tempMap, name, temp);
        Utils.setOrReplaceEntry(thirstMap, name, thirst);
    }

    public void resetTemperatureThirstMaps(Player player) {
        String name = player.getName(); // get the player's name

        HashMap<String, Double> tempMap = PlayerRunnable.getTemperature();
        HashMap<String, Boolean> tempRunMap = PlayerRunnable.getTemperatureRunnables();
        HashMap<String, Double> thirstMap = PlayerRunnable.getThirst();
        HashMap<String, Boolean> thirstRunMap = PlayerRunnable.getThirstRunnables();

        // reset bauble values
        Utils.setOrReplaceEntry(tempMap, name, NEUTRAL_TEMPERATURE);
        Utils.setOrReplaceEntry(thirstMap, name, LOWEST_THIRST);

        // set the runnable values to false since there will be no active temperature or thirst runnables on the player
        Utils.setOrReplaceEntry(tempRunMap, name, false);
        Utils.setOrReplaceEntry(thirstRunMap, name, false);
    }

    public void startTemperatureThirstRunnable(Player player) {
        String name = player.getName(); // get the player's name

        FileConfiguration config = RSVFiles.getTanUserConfig();
        HashMap<String, Boolean> tempRunMap = PlayerRunnable.getTemperatureRunnables();
        HashMap<String, Boolean> thirstRunMap = PlayerRunnable.getThirstRunnables();

        int visualTickTime = config.getInt("VisualTickTime"); // get the tick speed
        int checkTickTime = config.getInt("CheckTickTime"); // get the tick speed

        // start the runnable
        getVisualRunnable(player).runTaskTimer(plugin, 0, visualTickTime);
        getCheckerRunnable(player).runTaskTimer(plugin, 0, checkTickTime);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(tempRunMap, name, true);
        Utils.setOrReplaceEntry(thirstRunMap, name, true);
    }
}
