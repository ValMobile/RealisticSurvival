package me.val_mobile.tan;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.toughasnails.DataModule;
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

    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final static HashMap<UUID, ThirstCalculateTask> tasks = new HashMap<>();
    private final static HashMap<UUID, Boolean> players = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private double thirstLvl;
    private double saturationLvl;
    private int tickTimer;
    private double exhaustionLvl;

    private final int tickSpeed;
    private final DataModule module;
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
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.module = ((DataModule) this.player.getDataModuleFromName(TanModule.NAME));
        this.thirstLvl = module.getThirst();
        this.tickTimer = module.getThirstTickTimer();
        this.saturationLvl = module.getThirstSaturation();
        this.exhaustionLvl = module.getThirstExhaustion();
        this.peMultiplier = config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value");
        this.tickSpeed = config.getInt("Thirst.CalculateTickSpeed"); // get the tick speed
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        Difficulty difficulty = player.getPlayer().getWorld().getDifficulty();
        GameMode mode = player.getGameMode(); // get the gamemode
        double currentLvl = thirstLvl;

        if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE || !player.isOnline() && allowedWorlds.contains(player.getWorld().toString())) {
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
                saturationLvl = saturationLvl <= 0 ? 0 : saturationLvl - 1;
            }

            tickTimer += tickSpeed;

            if (difficulty == Difficulty.PEACEFUL) {
                thirstLvl = Math.min(MAXIMUM_THIRST, thirstLvl + 1D);
            }

            if (thirstLvl <= config.getDouble("Thirst.Dehydration.Thirst")) {
                HashMap<UUID, Boolean> dehyTasks = DehydrationTask.getPlayers();

                if (dehyTasks.containsKey(player.getUniqueId())) {
                    if (!dehyTasks.get(player.getUniqueId())) {
                        new DehydrationTask(plugin, this.player).startRunnable();
                    }
                }
                else {
                    new DehydrationTask(plugin, this.player).startRunnable();
                }
            }

            if (currentLvl != thirstLvl) {
                Bukkit.getServer().getPluginManager().callEvent(new ThirstChangeEvent(player, currentLvl, thirstLvl));
            }

            isJumping = false;
            module.setThirstTickTimer(tickTimer);
            module.setThirstExhaustion(exhaustionLvl);
            module.setThirstSaturation(saturationLvl);
            module.setThirst(thirstLvl);
        }
        // if the player is in creative or spectator
        else {
            // update static hashmap values and cancel the runnable
            players.put(player.getUniqueId(), false);
            tasks.remove(player.getUniqueId());
            cancel();
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

    public static HashMap<UUID, ThirstCalculateTask> getTasks() {
        return tasks;
    }

    public static HashMap<UUID, Boolean> getPlayers() {
        return players;
    }

    public void start() {
        this.runTaskTimer(plugin, 0L, tickSpeed);
        players.put(player.getPlayer().getUniqueId(), true);
        tasks.put(player.getPlayer().getUniqueId(), this);
    }
}
