/*
    Copyright (C) 2023  Val_Mobile

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
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVTask;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ThirstCalculateTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, ThirstCalculateTask> tasks = new HashMap<>();
    private final TanModule module;
    private final TempManager tempManager;
    private final ThirstManager thirstManager;
    private final FileConfiguration config;
    private final RSVPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private int thirstLvl;
    private int saturationLvl;
    private int tickTimer;
    private double exhaustionLvl;
    private final int tickPeriod;
    private boolean parasitesActive = false;
    private final double peMultiplier;
    private final double sprintingIncrease;
    private final double swimmingIncrease;
    private final double passiveIncrease;
    private final double hyperthermiaMinTemp;
    private final double hyperthermiaIncrease;

    public static final int MAXIMUM_THIRST = 20;
    public static final int MINIMUM_THIRST = 0;

    public ThirstCalculateTask(TanModule module, RSVPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.tempManager = module.getTempManager();
        this.thirstManager = module.getThirstManager();
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.thirstLvl = player.getTanDataModule().getThirst();
        this.saturationLvl = player.getTanDataModule().getThirstSaturation();
        this.exhaustionLvl = player.getTanDataModule().getThirstExhaustion();
        this.tickTimer = player.getTanDataModule().getThirstTickTimer();
        this.allowedWorlds = module.getAllowedWorlds();
        this.peMultiplier = config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value");
        this.sprintingIncrease = config.getDouble("Thirst.ExhaustionLevelIncrease.Sprinting");
        this.swimmingIncrease = config.getDouble("Thirst.ExhaustionLevelIncrease.Swimming");
        this.passiveIncrease = config.getDouble("Thirst.ExhaustionLevelIncrease.PassiveDecay");
        this.hyperthermiaMinTemp = config.getDouble("Thirst.ExhaustionLevelIncrease.Hyperthermia.MinTemperature");
        this.hyperthermiaIncrease = config.getDouble("Thirst.ExhaustionLevelIncrease.Hyperthermia.MaxValue");

        this.tickPeriod = config.getInt("Thirst.CalculateTickPeriod"); // get the tick period
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();

        if (conditionsMet(player)) {
            tickTimer += tickPeriod;

            double currentLvl = thirstLvl;

            double addition = 0;

            if (player.isSprinting()) {
                addition += sprintingIncrease;
            }

            if (player.isSwimming()) {
                addition += swimmingIncrease;
            }

            if (tempManager.isTempEnabled(player)) {
                double pTemp = tempManager.getTemperature(player);
                if (pTemp >= hyperthermiaMinTemp) {
                    addition += hyperthermiaIncrease * pTemp / TemperatureCalculateTask.MAXIMUM_TEMPERATURE;
                }
            }

            addition += passiveIncrease;
            addition *= tickPeriod * (parasitesActive ? peMultiplier : 1);

            exhaustionLvl = Utils.clamp(exhaustionLvl + addition, 0, 4);

            if (Utils.doublesEquals(exhaustionLvl, 4) && tickTimer >= 80) {
                exhaustionLvl = 0;
                tickTimer = 0;
                if (saturationLvl > 0) {
                    saturationLvl = Utils.clamp(saturationLvl - 1, 0, thirstLvl);
                }
                else {
                    thirstLvl--;
                    saturationLvl = Utils.clamp(saturationLvl, 0, thirstLvl);
                }
            }

            if (player.getWorld().getDifficulty() == Difficulty.PEACEFUL) {
                thirstLvl = Utils.clamp(thirstLvl + 1, MINIMUM_THIRST, MAXIMUM_THIRST);
            }

            if (player.hasPermission("realisticsurvival.toughasnails.resistance.thirst.*")) {
                thirstLvl = Math.max(MAXIMUM_THIRST, thirstLvl);
            }
            else {
                if (config.getBoolean("Thirst.Dehydration.Enabled")) {
                    if (thirstLvl <= config.getDouble("Thirst.Dehydration.Thirst")) {
                        if (!DehydrationTask.hasTask(id)) {
                            new DehydrationTask(module, plugin, this.player).start();
                        }
                    }
                }
            }

            if (!Utils.doublesEquals(currentLvl, thirstLvl)) {
                Bukkit.getServer().getPluginManager().callEvent(new ThirstChangeEvent(player, currentLvl, thirstLvl));
            }

            thirstManager.setThirst(player, thirstLvl);
            thirstManager.setExhaustion(player, exhaustionLvl);
            thirstManager.setSaturation(player, saturationLvl);
            thirstManager.setTickTimer(player, tickTimer);
        }
        else {
            stop();
        }
    }

    public void setParasitesActive(boolean parasitesActive) {
        this.parasitesActive = parasitesActive;
    }

    public boolean isParasitesActive() {
        return parasitesActive;
    }

    public int getSaturationLvl() {
        return saturationLvl;
    }

    public double getExhaustionLvl() {
        return exhaustionLvl;
    }

    public int getTickTimer() {
        return tickTimer;
    }

    public int getThirstLvl() {
        return thirstLvl;
    }

    public void setExhaustionLvl(double exhaustionLvl) {
        this.exhaustionLvl = exhaustionLvl;
    }

    public void setThirstLvl(int thirstLvl) {
        this.thirstLvl = thirstLvl;
    }

    public void setSaturationLvl(int saturationLvl) {
        this.saturationLvl = saturationLvl;
    }

    public void setTickTimer(int tickTimer) {
        this.tickTimer = tickTimer;
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && allowedWorlds.contains(player.getWorld().getName());
    }

    @Override
    public void start() {
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        thirstManager.setThirst(player.getPlayer(), thirstLvl);
        thirstManager.setExhaustion(player.getPlayer(), exhaustionLvl);
        thirstManager.setSaturation(player.getPlayer(), saturationLvl);
        thirstManager.setTickTimer(player.getPlayer(), tickTimer);

        tasks.remove(id);
        cancel();
    }

    private void saveData() {
        RSVPlayer.getPlayers().get(id).getTanDataModule().saveData();
    }

    public static Map<UUID, ThirstCalculateTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
