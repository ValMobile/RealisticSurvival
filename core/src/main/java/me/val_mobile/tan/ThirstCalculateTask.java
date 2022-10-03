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
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class ThirstCalculateTask extends BukkitRunnable {

    private final static HashMap<UUID, ThirstCalculateTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private double thirstLvl;
    private double saturationLvl;
    private int tickTimer;
    private double exhaustionLvl;
    private final int tickSpeed;
    private boolean isJumping = false;
    private boolean parasitesActive = false;
    private final double peMultiplier;

    public static final double DEFAULT_SATURATION = 5.0;
    public static final double MAXIMUM_THIRST = 20.0;
    public static final double MINIMUM_THIRST = 0.0;

    public ThirstCalculateTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.thirstLvl = player.getTanDataModule().getThirst();
        this.tickTimer = player.getTanDataModule().getThirstTickTimer();
        this.saturationLvl = player.getTanDataModule().getThirstSaturation();
        this.exhaustionLvl = player.getTanDataModule().getThirstExhaustion();
        this.peMultiplier = config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value");
        this.tickSpeed = config.getInt("Thirst.CalculateTickSpeed"); // get the tick speed
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        if (player == null) {
            tasks.remove(id);
            cancel();
        }
        // if the player is in creative or spectator
        else {
            Difficulty difficulty = player.getPlayer().getWorld().getDifficulty();
            GameMode mode = player.getGameMode(); // get the gamemode
            double currentLvl = thirstLvl;

            if ((mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                if (isJumping && player.isSprinting()) {
                    exhaustionLvl = parasitesActive ? config.getDouble("Thirst.ExhaustionLevelIncrease.JumpingWhileSprinting") * peMultiplier : config.getDouble("Thirst.ExhaustionLevelIncrease.JumpingWhileSprinting");
                }
                else if (isJumping) {
                    exhaustionLvl = parasitesActive ? config.getDouble("Thirst.ExhaustionLevelIncrease.Jumping") * peMultiplier : config.getDouble("Thirst.ExhaustionLevelIncrease.Jumping");
                }
                else if (player.isSprinting()) {
                    exhaustionLvl = parasitesActive ? config.getDouble("Thirst.ExhaustionLevelIncrease.Sprinting") * peMultiplier : config.getDouble("Thirst.ExhaustionLevelIncrease.Sprinting");
                }

                if (player.isSwimming()) {
                    exhaustionLvl = parasitesActive ? config.getDouble("Thirst.ExhaustionLevelIncrease.Swimming") * peMultiplier : config.getDouble("Thirst.ExhaustionLevelIncrease.Swimming");
                }

                if (exhaustionLvl >= 4) {
                    exhaustionLvl -= 4;
                    if (saturationLvl > 0) {
                        saturationLvl = Math.min(thirstLvl, saturationLvl - 1);
                    }
                    else {
                        thirstLvl--;
                    }
                }

                tickTimer += tickSpeed;

                if (difficulty == Difficulty.PEACEFUL) {
                    thirstLvl = Math.min(MAXIMUM_THIRST, thirstLvl + 1D);
                }

                if (thirstLvl <= config.getDouble("Thirst.Dehydration.Thirst")) {
                    if (!DehydrationTask.hasTask(id)) {
                        new DehydrationTask(plugin, this.player).start();
                    }
                }

                if (currentLvl != thirstLvl) {
                    Bukkit.getServer().getPluginManager().callEvent(new ThirstChangeEvent(player, currentLvl, thirstLvl));
                }

                isJumping = false;
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirst(thirstLvl);
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirstExhaustion(exhaustionLvl);
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirstSaturation(saturationLvl);
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirstTickTimer(tickTimer);
                RSVPlayer.getPlayers().get(id).getTanDataModule().saveData();
            }
            else {
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirst(thirstLvl);
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirstExhaustion(exhaustionLvl);
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirstSaturation(saturationLvl);
                RSVPlayer.getPlayers().get(id).getTanDataModule().setThirstTickTimer(tickTimer);
                RSVPlayer.getPlayers().get(id).getTanDataModule().saveData();
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public void setParasitesActive(boolean parasitesActive) {
        this.parasitesActive = parasitesActive;
    }

    public double getSaturationLvl() {
        return saturationLvl;
    }

    public double getExhaustionLvl() {
        return exhaustionLvl;
    }

    public int getTickTimer() {
        return tickTimer;
    }

    public double getThirstLvl() {
        return thirstLvl;
    }

    public void setExhaustionLvl(double exhaustionLvl) {
        this.exhaustionLvl = exhaustionLvl;
    }

    public void setThirstLvl(double thirstLvl) {
        this.thirstLvl = thirstLvl;
    }

    public void setSaturationLvl(double saturationLvl) {
        this.saturationLvl = saturationLvl;
    }

    public void setTickTimer(int tickTimer) {
        this.tickTimer = tickTimer;
    }

    public void start() {
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static HashMap<UUID, ThirstCalculateTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
