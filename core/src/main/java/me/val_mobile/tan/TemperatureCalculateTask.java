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

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVEnchants;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class TemperatureCalculateTask extends BukkitRunnable {

    private final static HashMap<UUID, TemperatureCalculateTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private double equilibriumTemp;
    private double regulate = 0D;
    private double change = 0D;
    private double temp;
    public static final double MINIMUM_TEMPERATURE = 0.0;
    public static final double MAXIMUM_TEMPERATURE = 25.0;

    public static final double NEUTRAL_TEMPERATURE = 12.5;

    public TemperatureCalculateTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.temp = player.getTanDataModule().getTemperature();
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        if (player == null) {
            // update static hashmap values and cancel the runnable
            tasks.remove(id);
            cancel();
        }
        // if the player is in creative or spectator
        else {
            GameMode mode = player.getGameMode(); // get the gamemode

            if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                double tempMaxChange = config.getDouble("Temperature.MaxChange");

                double oldTemp = temp;
                regulate = 0D;
                change = 0D;
                World pWorld = player.getWorld();
                Location pLoc = player.getLocation();
                Block pBlock = pLoc.getBlock();
                double px = pLoc.getX();
                double py = pLoc.getY();
                double pz = pLoc.getZ();

                double biomeTemp = pWorld.getTemperature((int) px, (int) py, (int) pz); // create a variable to store the temperature

                if (biomeTemp > config.getDouble("Temperature.Environment.BiomeTemperature.HotCutoff")) {
                    biomeTemp *= config.getDouble("Temperature.Environment.BiomeTemperature.HotMultiplier");
                }
                else {
                    // less than hot cutoff
                    if (biomeTemp >= config.getDouble("Temperature.Environment.BiomeTemperature.WarmCutoff")) {
                        biomeTemp *= config.getDouble("Temperature.Environment.BiomeTemperature.WarmMultiplier");
                    }
                    // less than warm cutoff
                    else if (biomeTemp >= config.getDouble("Temperature.Environment.BiomeTemperature.ModerateCutoff")) {
                        biomeTemp *= config.getDouble("Temperature.Environment.BiomeTemperature.ModerateMultiplier");
                    }
                    // less than moderate cutoff
                    else if (biomeTemp >= config.getDouble("Temperature.Environment.BiomeTemperature.CoolCutoff")) {
                        biomeTemp *= config.getDouble("Temperature.Environment.BiomeTemperature.CoolMultiplier");
                    }
                    // less than cool cutoff
                    else if (biomeTemp >= config.getDouble("Temperature.Environment.BiomeTemperature.ColdCutoff")) {
                        biomeTemp *= config.getDouble("Temperature.Environment.BiomeTemperature.ColdMultiplier");
                    }
                    else {
                        biomeTemp *= config.getDouble("Temperature.Environment.BiomeTemperature.FrigidMultiplier");
                    }
                }

                double daylightChange = pWorld.getEnvironment() == World.Environment.NORMAL ? Math.sin(2 * Math.PI / 24000 * pWorld.getTime() - 3500) * config.getDouble("Temperature.Environment.DaylightCycleMultiplier") : 0D;
                double worldChange = biomeTemp + daylightChange;
                change += worldChange;

                int cubeLength = config.getInt("Temperature.Environment.CubeLength");

                for (int x = -(cubeLength - 1); x < cubeLength; x++) {
                    for (int y = -(cubeLength - 1); y < cubeLength; y++) {
                        for (int z = -(cubeLength - 1); z < cubeLength; z++) {
                            Location loc = new Location(player.getWorld(), px + x, py + y, pz + z);
                            Block block = loc.getBlock();

                            if (!block.isEmpty()) {
                                String path = "Temperature.Environment.Blocks";
                                ConfigurationSection section = config.getConfigurationSection(path);

                                String material = block.getBlockData().getMaterial().toString();
                                if (section.getKeys(false).contains(material)) {
                                    add(path + "." + material);
                                }
                            }
                        }
                    }
                }

                if (pBlock.isLiquid()) {
                    if (pBlock.getType() == Material.LAVA) {
                        add("Temperature.Environment.SubmergedLava");
                    }
                    else {
                        add("Temperature.Environment.SubmergedWater");
                    }
                }

                if (Utils.isExposedToSky(player)) {
                    if (pWorld.hasStorm()) {
                        add("Temperature.Environment.Storming");
                    }
                    add("Temperature.Environment.Housed");

                }

                if (player.getFireTicks() > 0) {
                    add("Temperature.Environment.Burning");
                }

                for (ItemStack item : player.getInventory().getArmorContents()) {
                    if (Utils.isItemReal(item)) {
                        ItemMeta meta = item.getItemMeta();

                        if (RSVItem.isRSVItem(item)) {
                            String itemName = RSVItem.getNameFromItem(item);

                            switch (itemName) {
                                case "wool_hood", "wool_boots", "wool_pants", "wool_jacket", "jelled_slime_helmet", "jelled_slime_chestplate", "jelled_slime_leggings", "jelled_slime_boots" ->
                                        add("Temperature.Armor." + itemName);
                                default -> {}
                            }
                        }
                        else {
                            Material mat = item.getType();
                            if (Utils.isArmor(mat)) {
                                add("Temperature.Armor." + mat);
                            }
                        }

                        if (meta.hasEnchant(RSVEnchants.COOLING)) {
                            add("Temperature.Enchantments.Cooling");
                        }

                        if (meta.hasEnchant(RSVEnchants.WARMING)) {
                            add("Temperature.Enchantments.Warming");
                        }

                        if (meta.hasEnchant(RSVEnchants.OZZY_LINER)) {
                            add("Temperature.Enchantments.OzzyLiner");
                        }
                    }
                }

                double normalTemp = NEUTRAL_TEMPERATURE + change;
                double regulatedTemp = temp;

                if (normalTemp != NEUTRAL_TEMPERATURE) {
                    if (normalTemp > NEUTRAL_TEMPERATURE) {
                        regulatedTemp = Math.max(normalTemp - regulate, NEUTRAL_TEMPERATURE);

                    }
                    else {
                        regulatedTemp = Math.min(normalTemp + regulate, NEUTRAL_TEMPERATURE);
                    }
                }

                equilibriumTemp = regulatedTemp;

                if (Math.abs(temp - regulatedTemp) < tempMaxChange) {
                    temp = regulatedTemp;
                }
                else {
                    temp = regulatedTemp > temp ? temp + tempMaxChange : temp - tempMaxChange;
                }

                if (temp != NEUTRAL_TEMPERATURE) {
                    if (temp < NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.cold")) {
                        temp = NEUTRAL_TEMPERATURE;
                    }
                    if (temp > NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.hot")) {
                        temp = NEUTRAL_TEMPERATURE;
                    }
                }

                if (temp <= config.getDouble("Temperature.Hypothermia.Temperature")) {
                    if (!HypothermiaTask.hasTask(id)) {
                        new HypothermiaTask(plugin, this.player).start();
                    }
                }

                if (temp >= config.getDouble("Temperature.Hyperthermia.Temperature")) {
                    if (!HyperthermiaTask.hasTask(id)) {
                        new HyperthermiaTask(plugin, this.player).start();
                    }
                }

                if (temp != oldTemp) {
                    Bukkit.getServer().getPluginManager().callEvent(new TemperatureChangeEvent(player, oldTemp, temp));
                }
                RSVPlayer.getPlayers().get(id).getTanDataModule().setTemperature(temp);
                RSVPlayer.getPlayers().get(id).getTanDataModule().saveData();
            }
            else {
                RSVPlayer.getPlayers().get(id).getTanDataModule().setTemperature(temp);
                RSVPlayer.getPlayers().get(id).getTanDataModule().saveData();
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void add(String configPath) {
        double amount = config.getDouble(configPath + ".Value");

        if (config.contains(configPath + ".Enabled")) {
            if (config.getBoolean(configPath + ".Enabled")) {
                if (config.getBoolean(configPath + ".IsRegulatory")) {
                    regulate += amount;
                }
                else {
                    change += amount;
                }
            }
        }
        else {
            if (config.getBoolean(configPath + ".IsRegulatory")) {
                regulate += amount;
            }
            else {
                change += amount;
            }
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Temperature.CalculateTickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static HashMap<UUID, TemperatureCalculateTask> getTasks() {
        return tasks;
    }

    public double getEquilibriumTemp() {
        return equilibriumTemp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
