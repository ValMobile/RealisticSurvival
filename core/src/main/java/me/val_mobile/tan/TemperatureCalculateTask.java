/*
    Copyright (C) 2024  Val_Mobile

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

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.integrations.CompatiblePlugin;
import me.val_mobile.integrations.RealisticSeasons;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVEnchants;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVTask;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TemperatureCalculateTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, TemperatureCalculateTask> tasks = new HashMap<>();
    private final RealisticSeasons rs;
    private final TanModule module;
    private final TempManager manager;
    private final FileConfiguration config;
    private final RSVPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private double equilibriumTemp;
    private double regulate = 0D;
    private double change = 0D;
    private double regulateEnv = 0D;
    private double changeEnv = 0D;
    private final double seasonsDefaultTemp;
    private final double seasonsColdMultiplier;
    private final double seasonsHotMultiplier;
    private final double distSqr;
    private double temp;
    private Location currentLoc;
    public static final double MINIMUM_TEMPERATURE = 0.0;
    public static final double MAXIMUM_TEMPERATURE = 25.0;

    public static final double NEUTRAL_TEMPERATURE = 12.5;

    public TemperatureCalculateTask(TanModule module, RSVPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.manager = module.getTempManager();
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.temp = player.getTanDataModule().getTemperature();
        this.allowedWorlds = module.getAllowedWorlds();
        this.currentLoc = player.getPlayer().getLocation();
        this.distSqr = config.getDouble("Temperature.Environment.CubeLength") * config.getDouble("Temperature.Environment.CubeLength");
        this.rs = (RealisticSeasons) CompatiblePlugin.getPlugin(RealisticSeasons.NAME);

        this.seasonsDefaultTemp = rs.getDefaultTemperature();
        this.seasonsColdMultiplier = rs.getColdMultiplier();
        this.seasonsHotMultiplier = rs.getHotMultiplier();
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();

        if (conditionsMet(player)) {
            double oldTemp = temp;

            if (rs.isIntegrated() && rs.hasTemperatureEnabled(player)) {
                int seasonsTemp = rs.getTemperature(player);
                temp = (seasonsTemp - seasonsDefaultTemp) * (seasonsTemp > seasonsDefaultTemp ? seasonsHotMultiplier : seasonsColdMultiplier) + MAXIMUM_TEMPERATURE / 2;
            }
            else {
                double tempMaxChange = config.getDouble("Temperature.MaxChange");

                regulate = 0D;
                change = 0D;
                World pWorld = player.getWorld();
                Location pLoc = player.getLocation();
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

                change += changeEnv;
                regulate += regulateEnv;

                if (pLoc.getWorld().getName().equals(currentLoc.getWorld().getName())) {
                    if (pLoc.distanceSquared(currentLoc) > distSqr) {
                        currentLoc = pLoc;
                        new TemperatureEnvironmentTask(module, plugin, this.player).start();
                    }
                }
                else {
                    currentLoc = pLoc;
                    new TemperatureEnvironmentTask(module, plugin, this.player).start();
                }


                if (player.isInWater()) {
                    add("Temperature.Environment.SubmergedWater");
                }

                if (Utils.isInLava(player)) {
                    add("Temperature.Environment.SubmergedLava");
                }

                if (Utils.isExposedToSky(player)) {
                    if (pWorld.hasStorm()) {
                        add("Temperature.Environment.Storming");
                    }
                }
                else {
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

//                        if (meta.hasEnchant(RSVEnchants.COOLING)) {
//                            add("Temperature.Enchantments.Cooling");
//                        }
//
//                        if (meta.hasEnchant(RSVEnchants.WARMING)) {
//                            add("Temperature.Enchantments.Warming");
//                        }
//
//                        if (meta.hasEnchant(RSVEnchants.OZZY_LINER)) {
//                            add("Temperature.Enchantments.OzzyLiner");
//                        }
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
            }

            if (temp != NEUTRAL_TEMPERATURE) {
                if (temp < NEUTRAL_TEMPERATURE && hasColdImmunity(player)) {
                    temp = NEUTRAL_TEMPERATURE;
                }
                if (temp > NEUTRAL_TEMPERATURE && hasHotImmunity(player)) {
                    temp = NEUTRAL_TEMPERATURE;
                }
            }

            if (!hasColdImmunity(player)) {
                if (!rs.disableHypothermiaCompletely()) {
                    if (config.getBoolean("Temperature.Hypothermia.Enabled")) {
                        if (temp <= config.getDouble("Temperature.Hypothermia.Temperature")) {
                            if (!HypothermiaTask.hasTask(id)) {
                                new HypothermiaTask(module, plugin, this.player).start();
                            }
                        }
                    }
                }

                if (!rs.disableColdBreath()) {
                    if (!player.hasPermission("realisticsurvival.toughasnails.resistance.cold.breath")) {
                        if (config.getBoolean("Temperature.ColdBreath.Enabled")) {
                            if (temp <= config.getDouble("Temperature.ColdBreath.MaximumTemperature")) {
                                if (!ColdBreathTask.hasTask(id)) {
                                    new ColdBreathTask(module, plugin, this.player).start();
                                }
                            }
                        }
                    }
                }
            }

            if (!hasHotImmunity(player)) {
                if (!rs.disableHyperthermiaCompletely()) {
                    if (config.getBoolean("Temperature.Hyperthermia.Enabled")) {
                        if (temp >= config.getDouble("Temperature.Hyperthermia.Temperature")) {
                            if (!HyperthermiaTask.hasTask(id)) {
                                new HyperthermiaTask(module, plugin, this.player).start();
                            }
                        }
                    }
                }

                if (!rs.disableSweating()) {
                    if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hot.sweat")) {
                        if (config.getBoolean("Temperature.Sweating.Enabled")) {
                            if (temp >= config.getDouble("Temperature.Sweating.MinimumTemperature")) {
                                if (!SweatTask.hasTask(id)) {
                                    new SweatTask(module, plugin, this.player).start();
                                }
                            }
                        }
                    }
                }
            }

            if (!Utils.doublesEquals(temp, oldTemp)) {
                Bukkit.getServer().getPluginManager().callEvent(new TemperatureChangeEvent(player, oldTemp, temp));
            }
            manager.setTemperature(player, temp);
        }
        else {
            stop();
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

    private boolean hasHotImmunity(@Nonnull Player player) {
        return player.hasPermission("realisticsurvival.toughasnails.resistance.hot.*");
    }

    private boolean hasColdImmunity(@Nonnull Player player) {
        return player.hasPermission("realisticsurvival.toughasnails.resistance.cold.*");
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName());
    }

    @Override
    public void start() {
        new TemperatureEnvironmentTask(module, plugin, player).start();
        int tickPeriod = config.getInt("Temperature.CalculateTickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        manager.setTemperature(player.getPlayer(), temp);
        tasks.remove(id);
        cancel();
    }

    private void saveData() {
        RSVPlayer.getPlayers().get(id).getTanDataModule().saveData();
    }

    public static boolean hasTask(UUID id) {
        return tasks.containsKey(id) && tasks.get(id) != null;
    }

    public static Map<UUID, TemperatureCalculateTask> getTasks() {
        return tasks;
    }

    public double getEquilibriumTemp() {
        return equilibriumTemp;
    }

    public double getTemp() {
        return temp;
    }

    public double getChangeEnv() {
        return changeEnv;
    }

    public double getRegulateEnv() {
        return regulateEnv;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setChangeEnv(double changeEnv) {
        this.changeEnv = changeEnv;
    }

    public void setRegulateEnv(double regulateEnv) {
        this.regulateEnv = regulateEnv;
    }
}
