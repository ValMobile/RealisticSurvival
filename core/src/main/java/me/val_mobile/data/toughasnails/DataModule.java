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
package me.val_mobile.data.toughasnails;

import me.val_mobile.data.PlayerDataConfig;
import me.val_mobile.data.RSVConfig;
import me.val_mobile.data.RSVDataModule;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.tan.TanEnchants;
import me.val_mobile.tan.TanModule;
import me.val_mobile.tan.TanRunnables;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.net.SecureCacheResponse;
import java.util.Random;

import static me.val_mobile.tan.TanRunnables.LOWEST_THIRST;
import static me.val_mobile.tan.TanRunnables.NEUTRAL_TEMPERATURE;

public class DataModule implements RSVDataModule {

    private Player player;
    private final FileConfiguration config;
    private final RealisticSurvivalPlugin plugin;
    private final TanRunnables tanRunnables;
    private double temperature;
    private double thirst;

    public DataModule(RealisticSurvivalPlugin plugin, Player player) {
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.plugin = plugin;
        this.tanRunnables = new TanRunnables(plugin);
        this.player = player;

        retrieveData();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getThirst() {
        return thirst;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setThirst(double thirst) {
        this.thirst = thirst;
    }

    @Override
    public void retrieveData() {
        String p = player.getUniqueId().toString();

        String tanPath = p + TanModule.NAME;
        String tempPath = tanPath + ".Temperature";
        String thirstPath = tanPath + ".Thirst";

        if (!config.getConfigurationSection("").contains(p)) {
            config.createSection(p);
            config.createSection(tanPath);
            config.createSection(tempPath);
            config.createSection(thirstPath);
            config.set(tempPath, NEUTRAL_TEMPERATURE);
            config.set(thirstPath, LOWEST_THIRST);
        }
        this.temperature = config.getDouble(tempPath);
        this.thirst = config.getDouble(thirstPath);
    }

    @Override
    public void updateData() {
        World pWorld = player.getWorld();
        Location pLoc = player.getLocation();
        double px = pLoc.getX();
        double py = pLoc.getY();
        double pz = pLoc.getZ();

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


        Random r = new Random();

        if (thirst >= 0.6) {
            if (Math.random() <= thirstChance) {
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
                        if (section.getKeys(false).contains(material)) {
                            if (section.getString(material + ".Type").equals("Change")) {
                                environment+=section.getDouble(material + ".Value");
                            }
                            else {
                                regulation+=section.getDouble(material + ".Value");
                            }
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

        double change = normalTemp + environment - temperature;

        int sign = temperature + change > NEUTRAL_TEMPERATURE ? -1 : 1;

        if (temperature != NEUTRAL_TEMPERATURE) {
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
                    if (temperature + regulation <= NEUTRAL_TEMPERATURE) {
                        temperature = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temperature += regulation;
                    }
                }
                else {
                    if (temperature + tempMaxChange <= NEUTRAL_TEMPERATURE) {
                        temperature = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temperature += tempMaxChange;
                    }
                }
            }
            // positive regulation
            else {
                if (sign * regulation < tempMaxChange) {
                    if (temperature + regulation >= NEUTRAL_TEMPERATURE) {
                        temperature = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temperature += regulation;
                    }
                }
                else {
                    if (temperature + sign * tempMaxChange >= NEUTRAL_TEMPERATURE) {
                        temperature = NEUTRAL_TEMPERATURE;
                    }
                    else {
                        temperature += tempMaxChange;
                    }
                }
            }

        }

        change += regulation;

        if (Math.abs(change) < tempMaxChange) {
            temperature += change;
        }
        else {
            temperature += tempMaxChange * ((change > 0) ? 1 : -1);
        }

        if (temperature != NEUTRAL_TEMPERATURE) {
            if (temperature < NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.cold")) {
                temperature = NEUTRAL_TEMPERATURE;
            }
            if (temperature > NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.hot")) {
                temperature = NEUTRAL_TEMPERATURE;
            }
        }

        if (thirst < LOWEST_THIRST) {
            if (player.hasPermission("realisticsurvival.toughasnails.resistance.thirst")) {
                thirst = LOWEST_THIRST;
            }
        }
    }

    @Override
    public void saveData() {

    }


}
