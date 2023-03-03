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

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.DisplayTask;
import me.val_mobile.utils.PlayerJumpEvent;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static me.val_mobile.tan.ThirstCalculateTask.MAXIMUM_THIRST;

public class TanEvents extends ModuleEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config;
    private final boolean tempEnabled;
    private final TanModule module;
    private final boolean thirstEnabled;

    public TanEvents(TanModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.module = module;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.tempEnabled = config.getBoolean("Temperature.Enabled");
        this.thirstEnabled = config.getBoolean("Thirst.Enabled");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            if (tempEnabled || thirstEnabled) {
                RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                if (tempEnabled) {
                    if (!TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                        new TemperatureCalculateTask(module, plugin, rsvplayer).start();
                    }

                    if (ThermometerTask.isHoldingThermometer(player)) {
                        if (!ThermometerTask.hasTask(player.getUniqueId())) {
                            new ThermometerTask(plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                        }
                    }
                }
                if (thirstEnabled) {
                    if (!ThirstCalculateTask.hasTask(player.getUniqueId())) {
                        new ThirstCalculateTask(module, plugin, rsvplayer).start();
                    }
                }
                if (!DisplayTask.hasTask(player.getUniqueId())) {
                    new DisplayTask(plugin, rsvplayer).start();
                }
            }
        }
    }

    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer(); // get the player

        if (shouldEventBeRan(player)) {
            ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(player.getUniqueId());

            if (task != null) {
                task.setJumping(true);
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (shouldEventBeRan(player)) {
            UUID id = player.getUniqueId();
            if (thirstEnabled) {
                ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(id);

                if (task != null) {
                    task.setThirstLvl(config.getDouble("Thirst.DefaultThirst"));
                    task.setSaturationLvl(config.getDouble("Thirst.DefaultSaturation"));
                }

                if (module.getDehydrationDeath().contains(id)) {
                    if (config.getBoolean("DehydrationDeath.Enabled")) {
                        List<String> deathMessages = config.getStringList("DehydrationDeath.Messages");

                        int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                        event.setDeathMessage(Utils.translateMsg(player, deathMessages.get(num).replaceAll("%PLAYER_NAME%", player.getDisplayName())));
                    }
                    module.getDehydrationDeath().remove(id);
                }
                else if (module.getParasiteDeath().contains(id)) {
                    if (config.getBoolean("ParasiteDeath.Enabled")) {
                        List<String> deathMessages = config.getStringList("ParasiteDeath.Messages");

                        int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                        event.setDeathMessage(Utils.translateMsg(player, deathMessages.get(num).replaceAll("%PLAYER_NAME%", player.getDisplayName())));
                    }
                    module.getParasiteDeath().remove(id);
                }
            }

            if (tempEnabled) {
                TemperatureCalculateTask task = TemperatureCalculateTask.getTasks().get(id);
                if (task != null) {
                    task.setTemp(config.getDouble("Temperature.DefaultTemperature"));
                }

                if (module.getHyperthermiaDeath().contains(id)) {
                    if (config.getBoolean("HyperthermiaDeath.Enabled")) {
                        List<String> deathMessages = config.getStringList("HyperthermiaDeath.Messages");

                        int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                        event.setDeathMessage(Utils.translateMsg(player, deathMessages.get(num).replaceAll("%PLAYER_NAME%", player.getDisplayName())));
                    }
                    module.getHyperthermiaDeath().remove(id);
                }
                else if (module.getHypothermiaDeath().contains(id)) {
                    if (config.getBoolean("HypothermiaDeath.Enabled")) {
                        List<String> deathMessages = config.getStringList("HypothermiaDeath.Messages");

                        int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                        event.setDeathMessage(Utils.translateMsg(player, deathMessages.get(num).replaceAll("%PLAYER_NAME%", player.getDisplayName())));
                    }
                    module.getHypothermiaDeath().remove(id);
                }
            }

            if (HypothermiaTask.hasTask(id)) {
                HypothermiaTask.getTasks().get(id).cancel();
                HypothermiaTask.getTasks().remove(id);
            }

            if (HyperthermiaTask.hasTask(id)) {
                HyperthermiaTask.getTasks().get(id).cancel();
                HyperthermiaTask.getTasks().remove(id);
            }

            if (DehydrationTask.hasTask(id)) {
                DehydrationTask.getTasks().get(id).cancel();
                DehydrationTask.getTasks().remove(id);
            }

            if (ParasiteTask.hasTask(id)) {
                ParasiteTask.getTasks().get(id).cancel();
                ParasiteTask.getTasks().remove(id);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (shouldEventBeRan(player)) {
            UUID id = player.getUniqueId();

            if (DisplayTask.hasTask(id)) {
                DisplayTask.getTasks().get(id).setParasitesActive(false);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                GameMode mode = event.getNewGameMode();
                if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) {
                    if (tempEnabled || thirstEnabled) {
                        if (RSVPlayer.getPlayers().containsKey(player.getUniqueId())) {
                            RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                            if (tempEnabled) {
                                if (!TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                                    new TemperatureCalculateTask(module, plugin, rsvplayer).start();
                                }
                            }
                            if (thirstEnabled) {
                                if (!ThirstCalculateTask.hasTask(player.getUniqueId())) {
                                    new ThirstCalculateTask(module, plugin, rsvplayer).start();
                                }
                            }
                            if (!DisplayTask.hasTask(player.getUniqueId())) {
                                new DisplayTask(plugin, rsvplayer).start();
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDrink(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            GameMode mode = player.getGameMode();
            Action action = event.getAction();
            if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) {
                boolean parasites = false;

                switch (action) {
                    case RIGHT_CLICK_BLOCK, RIGHT_CLICK_AIR -> {
                        Block block;
                        Location playerLoc = player.getLocation();
                        Location eye = player.getEyeLocation().add(player.getLocation().getDirection());

                        if (config.getBoolean("Thirst.SaturationRestoration.Drinking.Enabled")) {
                            if (player.isSneaking()) {
                                double maxDistance = config.getDouble("Thirst.SaturationRestoration.Drinking.MaxDistance");

                                RayTraceResult result = player.getWorld().rayTraceBlocks(player.getEyeLocation(), eye.getDirection(), maxDistance, FluidCollisionMode.ALWAYS, true);

                                if (result != null) {
                                    block = result.getHitBlock();
                                    if (block != null) {
                                        if (block.getType() == Material.WATER && Utils.isSourceLiquid(block)) {
                                            ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(player.getUniqueId());

                                            if (task != null) {
                                                double thirstPoints = config.getDouble("Thirst.SaturationRestoration.Drinking.ThirstPoints");
                                                double saturationPoints = config.getDouble("Thirst.SaturationRestoration.Drinking.SaturationPoints");

                                                task.setThirstLvl(Math.min(task.getThirstLvl() + thirstPoints, MAXIMUM_THIRST));
                                                task.setSaturationLvl(Math.min(task.getSaturationLvl() + saturationPoints, task.getThirstLvl()));

                                                if (config.getBoolean("Thirst.SaturationRestoration.Drinking.Sound.Enabled")) {
                                                    String soundName = config.getString("Thirst.SaturationRestoration.Drinking.Sound.Sound");
                                                    float volume = (float) config.getDouble("Thirst.SaturationRestoration.Drinking.Sound.Volume");
                                                    float pitch = (float) config.getDouble("Thirst.SaturationRestoration.Drinking.Sound.Pitch");

                                                    Utils.playSound(playerLoc, soundName, volume, pitch);
                                                }


                                                // Parasites code

                                                Location waterSourceLoc = block.getLocation();
                                                World world = waterSourceLoc.getWorld();
                                                Block air;

                                                int airAmount = 0;
                                                int caveAirAmount = 0;

                                                for (int x = -3; x < 2; x++) {
                                                    for (int y = -3; y < 2; y++) {
                                                        for (int z = -3; z < 2; z++) {
                                                            air = world.getBlockAt(x + (int) waterSourceLoc.getX(), y + (int) waterSourceLoc.getY(), z + (int) waterSourceLoc.getZ());
                                                            if (air.getType() == Material.AIR) {
                                                                airAmount++;
                                                            }
                                                            else if (air.getType() == Material.CAVE_AIR) {
                                                                caveAirAmount++;
                                                            }
                                                        }
                                                    }
                                                }

                                                if (caveAirAmount > airAmount) {
                                                    // cave water
                                                    if (config.getBoolean("Thirst.Parasites.CaveWater.Enabled")) {
                                                        if (Utils.roll(config.getDouble("Thirst.Parasites.CaveWater.Chance"))) {
                                                            parasites = true;
                                                        }
                                                    }
                                                }
                                                else {
                                                    Biome biome = block.getBiome();
                                                    switch (biome) {
                                                        case RIVER, FROZEN_RIVER -> {
                                                            // river water
                                                            if (config.getBoolean("Thirst.Parasites.RiverWater.Enabled")) {
                                                                if (Utils.roll(config.getDouble("Thirst.Parasites.RiverWater.Chance"))) {
                                                                    parasites = true;
                                                                }
                                                            }
                                                        }
                                                        case OCEAN, COLD_OCEAN, DEEP_LUKEWARM_OCEAN, LUKEWARM_OCEAN, DEEP_OCEAN, DEEP_COLD_OCEAN, DEEP_FROZEN_OCEAN, FROZEN_OCEAN, DEEP_WARM_OCEAN, WARM_OCEAN -> {
                                                            // ocean water
                                                            if (config.getBoolean("Thirst.Parasites.SeaWater.Enabled")) {
                                                                if (Utils.roll(config.getDouble("Thirst.Parasites.SeaWater.Chance"))) {
                                                                    parasites = true;
                                                                }
                                                            }
                                                        }
                                                        default -> {
                                                            // regular water
                                                            if (config.getBoolean("Thirst.Parasites.RegularWater.Enabled")) {
                                                                if (Utils.roll(config.getDouble("Thirst.Parasites.RegularWater.Chance"))) {
                                                                    parasites = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        RayTraceResult test = player.getWorld().rayTraceBlocks(player.getEyeLocation(), eye.getDirection(), 5, FluidCollisionMode.ALWAYS, true);

                        if (test != null) {
                            block = test.getHitBlock();
                            if (block != null) {
                                ItemStack item = event.getItem();

                                if (RSVItem.isRSVItem(item)) {
                                    String name = RSVItem.getNameFromItem(item);
                                    if (name.equals("canteen_empty") || name.equals("canteen_filled")) {
                                        if (block.getType() == Material.WATER && Utils.isSourceLiquid(block)) {
                                            if (canFill(item, "Unpurified Water")) {
                                                EquipmentSlot hand = Utils.getSlotContainingRsvItem(player, name);

                                                if (hand != null) {
                                                    if (hand == EquipmentSlot.HAND) {
                                                        player.getInventory().setItemInMainHand(fillCanteen(item, "Unpurified Water", 1));
                                                    }
                                                    else
                                                        player.getInventory().setItemInOffHand(fillCanteen(item, "Unpurified Water", 1));
                                                }
                                            }
                                            event.setCancelled(true);
                                        }
                                        else if (block.getType() == Material.CAULDRON || block.getType().toString().equals("WATER_CAULDRON")) {
                                            event.setCancelled(true);
                                        }
                                    }
                                }


                            }
                        }
                    }
                    case LEFT_CLICK_AIR -> {
                        if (config.getBoolean("Thirst.SaturationRestoration.Raining.Enabled") && player.getWorld().hasStorm() && Utils.canRain(player.getLocation()) && Utils.isExposedToSky(player)) {
                            Location loc = player.getLocation();
                            if (Math.abs(loc.getPitch() + 90F) < 0.01) {
                                ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(player.getUniqueId());

                                if (task != null) {
                                    double thirstPoints = config.getDouble("Thirst.SaturationRestoration.Raining.ThirstPoints");
                                    double saturationPoints = config.getDouble("Thirst.SaturationRestoration.Raining.SaturationPoints");

                                    task.setThirstLvl(Math.min(task.getThirstLvl() + thirstPoints, MAXIMUM_THIRST));
                                    task.setSaturationLvl(Math.min(task.getSaturationLvl() + saturationPoints, task.getThirstLvl()));

                                    if (config.getBoolean("Thirst.SaturationRestoration.Raining.Sound.Enabled")) {
                                        String soundName = config.getString("Thirst.SaturationRestoration.Raining.Sound.Sound");
                                        float volume = (float) config.getDouble("Thirst.SaturationRestoration.Raining.Sound.Volume");
                                        float pitch = (float) config.getDouble("Thirst.SaturationRestoration.Raining.Sound.Pitch");
                                        Utils.playSound(loc, soundName, volume, pitch);
                                    }

                                    // regular water
                                    if (config.getBoolean("Thirst.Parasites.Rain.Enabled")) {
                                        if (Utils.roll(config.getDouble("Thirst.Parasites.Rain.Chance"))) {
                                            parasites = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (parasites) {
                    if (!ParasiteTask.hasTask(player.getUniqueId())) {
                        new ParasiteTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            GameMode mode = player.getGameMode();

            if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) {
                ItemStack item = event.getItem();

                String name = RSVItem.isRSVItem(item) ? RSVItem.getNameFromItem(item) : item.getType().toString();
                Set<String> keys = config.getConfigurationSection("Thirst.SaturationRestoration.Foods").getKeys(false);

                if (name != null) {
                    ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(player.getUniqueId());
                    if (task != null) {
                        if (keys.contains(name)) {

                            double thirstPoints;
                            double saturationPoints;

                            thirstPoints = config.getDouble("Thirst.SaturationRestoration.Foods." + name + ".ThirstPoints");
                            saturationPoints = config.getDouble("Thirst.SaturationRestoration.Foods." + name + ".SaturationPoints");

                            task.setThirstLvl(Math.min(task.getThirstLvl() + thirstPoints, MAXIMUM_THIRST));
                            task.setSaturationLvl(Math.min(task.getSaturationLvl() + saturationPoints, task.getThirstLvl()));

                            if (name.equals(item.getType().toString()) && item.getType() == Material.POTION) {
                                if (((PotionMeta) item.getItemMeta()).getBasePotionData().getType() == PotionType.WATER) {
                                    // unpurified water
                                    if (config.getBoolean("Thirst.Parasites.UnpurifiedWaterBottle.Enabled")) {
                                        if (Utils.roll(config.getDouble("Thirst.Parasites.UnpurifiedWaterBottle.Chance"))) {
                                            if (!ParasiteTask.hasTask(player.getUniqueId())) {
                                                new ParasiteTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                                            }
                                        }
                                    }
                                }
                            }

                            if (name.equals("juice_chorus_fruit")) {
                                if (config.getBoolean("Items.juice_chorus_fruit.Teleport.Enabled")) {
                                    Location loc = player.getLocation();

                                    Utils.randomTpSafely(player, config.getDouble("Items.juice_chorus_fruit.Teleport.MaxRadius"));

                                    if (config.getBoolean("Items.juice_chorus_fruit.Teleport.Sound.Enabled")) {
                                        String soundName = config.getString("Items.juice_chorus_fruit.Teleport.Sound.Sound");
                                        float volume = (float) config.getDouble("Items.juice_chorus_fruit.Teleport.Sound.Volume");
                                        float pitch = (float) config.getDouble("Items.juice_chorus_fruit.Teleport.Sound.Pitch");
                                        Utils.playSound(loc, soundName, volume, pitch);
                                    }
                                }
                            }
                        }
                        else {
                            if (name.equals("canteen_filled")) {
                                final String canteenDrink = Utils.getNbtTag(item, "rsvdrink", PersistentDataType.STRING);
                                if (canteenDrink.equals("Unpurified Water")) {
                                    double thirstPoints = config.getDouble("Thirst.SaturationRestoration.Foods.POTION.ThirstPoints");
                                    double saturationPoints = config.getDouble("Thirst.SaturationRestoration.Foods.POTION.SaturationPoints");

                                    // unpurified water
                                    if (config.getBoolean("Thirst.Parasites.UnpurifiedWaterBottle.Enabled")) {
                                        if (Utils.roll(config.getDouble("Thirst.Parasites.UnpurifiedWaterBottle.Chance"))) {
                                            if (!ParasiteTask.hasTask(player.getUniqueId())) {
                                                new ParasiteTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                                            }
                                        }
                                    }

                                    task.setThirstLvl(Math.min(task.getThirstLvl() + thirstPoints, MAXIMUM_THIRST));
                                    task.setSaturationLvl(Math.min(task.getSaturationLvl() + saturationPoints, task.getThirstLvl()));
                                }
                                else {
                                    String drink = canteenDrink.toLowerCase().replace(' ', '_');

                                    double thirstPoints = config.getDouble("Thirst.SaturationRestoration.Foods." + drink + ".ThirstPoints");
                                    double saturationPoints = config.getDouble("Thirst.SaturationRestoration.Foods." + drink + ".SaturationPoints");

                                    task.setThirstLvl(Math.min(task.getThirstLvl() + thirstPoints, MAXIMUM_THIRST));
                                    task.setSaturationLvl(Math.min(task.getSaturationLvl() + saturationPoints, task.getThirstLvl()));
                                }
                                EquipmentSlot hand = Utils.getSlotContainingRsvItem(player, name);

                                if (hand != null) {
                                    if (hand == EquipmentSlot.HAND)
                                        player.getInventory().setItemInMainHand(fillCanteen(item, canteenDrink, -1));
                                    else
                                        player.getInventory().setItemInOffHand(fillCanteen(item, canteenDrink, -1));
                                }

                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageEvent event) {
        Entity e = event.getEntity();

        if (shouldEventBeRan(e)) {
            if (e instanceof Player player) {
                GameMode mode = player.getGameMode();

                if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                    UUID id = player.getUniqueId();

                    if (thirstEnabled) {
                        if (event.isCancelled()) {
                            module.getDehydrationDeath().remove(id);
                            module.getParasiteDeath().remove(id);
                        }
                        else {
                            ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(id);

                            if (task != null) {
                                if (event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                                    if (config.getBoolean("Thirst.SaturationRestoration.Drowning.Enabled")) {
                                        double thirstPoints = config.getDouble("Thirst.SaturationRestoration.Drowning.ThirstPoints");
                                        double saturationPoints = config.getDouble("Thirst.SaturationRestoration.Drowning.SaturationPoints");

                                        task.setThirstLvl(Math.min(task.getThirstLvl() + thirstPoints, MAXIMUM_THIRST));
                                        task.setSaturationLvl(Math.min(task.getThirstLvl() + saturationPoints, task.getThirstLvl()));
                                    }

                                    if (config.getBoolean("Thirst.Parasites.Drowning.Enabled")) {
                                        if (Utils.roll(config.getDouble("Thirst.Parasites.Drowning.Chance"))) {
                                            if (!ParasiteTask.hasTask(player.getUniqueId())) {
                                                new ParasiteTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                                            }
                                        }
                                    }
                                }
                                double parasiteExhaustionMultiplier = config.getBoolean("Thirst.Parasites.MultiplyExhaustionRates.Enabled") ? config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value") : 1D;
                                task.setExhaustionLvl(task.getExhaustionLvl() + (config.getDouble("Thirst.ExhaustionLevelIncrease.TakingDamage") * parasiteExhaustionMultiplier));
                            }
                        }
                        if (player.getHealth() - event.getFinalDamage() > 0D) {
                            // player will not die
                            module.getDehydrationDeath().remove(id);
                            module.getParasiteDeath().remove(id);
                        }
                    }

                    if (tempEnabled) {
                        if (player.getHealth() - event.getFinalDamage() > 0D || event.isCancelled()) {
                            // player will not die
                            module.getHyperthermiaDeath().remove(id);
                            module.getHypothermiaDeath().remove(id);
                        }
                    }
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onRegenerate(EntityRegainHealthEvent event) {
        if (!event.isCancelled()) {
            Entity e = event.getEntity();
            if (e instanceof Player) {
                if (shouldEventBeRan(e)) {
                    ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(e.getUniqueId());

                    if (task != null) {
                        double parasiteExhaustionMultiplier = config.getBoolean("Thirst.ExhaustionLevelIncrease.MultiplyExhaustionRates.Enabled") ? config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value") : 1D;
                        task.setExhaustionLvl(task.getExhaustionLvl() + (config.getDouble("Thirst.ExhaustionLevelIncrease.RegeneratingHealth") * parasiteExhaustionMultiplier));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockGrow(BlockGrowEvent event) {
        if (!event.isCancelled()) {
            Block block = event.getBlock();
            World world = block.getWorld();
            if (shouldEventBeRan(world)) {
                double rad = config.getDouble("Temperature.Environment.CubeLength");

                Collection<Entity> nearby = world.getNearbyEntities(block.getLocation(), rad, rad, rad);
                ConfigurationSection section = config.getConfigurationSection("Temperature.Environment.Blocks");

                if (!nearby.isEmpty()) {
                    for (Entity e : nearby) {
                        if (e instanceof Player player) {
                            TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(player.getUniqueId());

                            if (tempTask != null) {
                                if (block.getLocation().distanceSquared(player.getLocation()) < config.getDouble("Temperature.Environment.CubeLength") * config.getDouble("Temperature.Environment.CubeLength")) {

                                    if (TemperatureEnvironmentTask.willAffectTemperature(block, section)) {
                                        double val = TemperatureEnvironmentTask.getValue(block, section);

                                        if (TemperatureEnvironmentTask.isRegulatory(block, section)) {
                                            tempTask.setRegulateEnv(tempTask.getRegulateEnv() + val);
                                        }
                                        else {
                                            tempTask.setChangeEnv(tempTask.getChangeEnv() + val);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            if (shouldEventBeRan(player)) {
                TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(player.getUniqueId());
                Block block = event.getBlock();

                if (tempTask != null) {
                    if (block.getLocation().distanceSquared(player.getLocation()) < config.getDouble("Temperature.Environment.CubeLength") * config.getDouble("Temperature.Environment.CubeLength")) {
                        ConfigurationSection section = config.getConfigurationSection("Temperature.Environment.Blocks");

                        if (TemperatureEnvironmentTask.willAffectTemperature(block, section)) {
                            double val = TemperatureEnvironmentTask.getValue(block, section);

                            if (TemperatureEnvironmentTask.isRegulatory(block, section)) {
                                tempTask.setRegulateEnv(tempTask.getRegulateEnv() + val);
                            }
                            else {
                                tempTask.setChangeEnv(tempTask.getChangeEnv() + val);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(player.getUniqueId());
                ThirstCalculateTask thirstTask = ThirstCalculateTask.getTasks().get(player.getUniqueId());

                if (tempTask != null) {
                    Block block = event.getBlock();
                    if (block.getLocation().distanceSquared(player.getLocation()) < config.getDouble("Temperature.Environment.CubeLength") * config.getDouble("Temperature.Environment.CubeLength")) {
                        ConfigurationSection section = config.getConfigurationSection("Temperature.Environment.Blocks");
                        if (TemperatureEnvironmentTask.willAffectTemperature(block, section)) {
                            double val = TemperatureEnvironmentTask.getValue(block, section);

                            if (TemperatureEnvironmentTask.isRegulatory(block, section)) {
                                tempTask.setRegulateEnv(tempTask.getRegulateEnv() - val);
                            }
                            else {
                                tempTask.setChangeEnv(tempTask.getChangeEnv() - val);
                            }
                        }
                    }
                }

                if (thirstTask != null) {
                    double parasiteExhaustionMultiplier = config.getBoolean("Thirst.Parasites.MultiplyExhaustionRates.Enabled") ? config.getDouble("Thirst.Parasites.MultiplyExhaustionRates.Value") : 1D;
                    thirstTask.setExhaustionLvl(thirstTask.getExhaustionLvl() + (config.getDouble("Thirst.ExhaustionLevelIncrease.BreakingBlock") * parasiteExhaustionMultiplier));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockExplode(BlockExplodeEvent event) {
        if (!event.isCancelled()) {
            Block block = event.getBlock();
            World world = block.getWorld();
            if (shouldEventBeRan(world)) {
                double rad = config.getDouble("Temperature.Environment.CubeLength");

                Collection<Entity> nearby = world.getNearbyEntities(block.getLocation(), rad, rad, rad);
                ConfigurationSection section = config.getConfigurationSection("Temperature.Environment.Blocks");

                if (!nearby.isEmpty()) {
                    for (Entity e : nearby) {
                        if (e instanceof Player player) {
                            TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(player.getUniqueId());

                            if (tempTask != null) {
                                if (block.getLocation().distanceSquared(player.getLocation()) < config.getDouble("Temperature.Environment.CubeLength") * config.getDouble("Temperature.Environment.CubeLength")) {

                                    if (TemperatureEnvironmentTask.willAffectTemperature(block, section)) {
                                        double val = TemperatureEnvironmentTask.getValue(block, section);

                                        if (TemperatureEnvironmentTask.isRegulatory(block, section)) {
                                            tempTask.setRegulateEnv(tempTask.getRegulateEnv() - val);
                                        }
                                        else {
                                            tempTask.setChangeEnv(tempTask.getChangeEnv() - val);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBurn(BlockBurnEvent event) {
        if (!event.isCancelled()) {
            Block block = event.getBlock();
            World world = block.getWorld();
            if (shouldEventBeRan(world)) {
                double rad = config.getDouble("Temperature.Environment.CubeLength");

                Collection<Entity> nearby = world.getNearbyEntities(block.getLocation(), rad, rad, rad);
                ConfigurationSection section = config.getConfigurationSection("Temperature.Environment.Blocks");

                if (!nearby.isEmpty()) {
                    for (Entity e : nearby) {
                        if (e instanceof Player player) {
                            TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(player.getUniqueId());

                            if (tempTask != null) {
                                if (block.getLocation().distanceSquared(player.getLocation()) < config.getDouble("Temperature.Environment.CubeLength") * config.getDouble("Temperature.Environment.CubeLength")) {

                                    if (TemperatureEnvironmentTask.willAffectTemperature(block, section)) {
                                        double val = TemperatureEnvironmentTask.getValue(block, section);

                                        if (TemperatureEnvironmentTask.isRegulatory(block, section)) {
                                            tempTask.setRegulateEnv(tempTask.getRegulateEnv() - val);
                                        }
                                        else {
                                            tempTask.setChangeEnv(tempTask.getChangeEnv() - val);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            String oldWorld = event.getFrom().toString();

            if (!module.getAllowedWorlds().contains(oldWorld)) {
                if (tempEnabled || thirstEnabled) {
                    RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(player.getUniqueId());
                    if (tempEnabled) {
                        if (!TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                            new TemperatureCalculateTask(module, plugin, rsvplayer).start();
                        }

                        if (ThermometerTask.isHoldingThermometer(player)) {
                            if (!ThermometerTask.hasTask(player.getUniqueId())) {
                                new ThermometerTask(plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                            }
                        }
                    }
                    if (thirstEnabled) {
                        if (!ThirstCalculateTask.hasTask(player.getUniqueId())) {
                            new ThirstCalculateTask(module, plugin, rsvplayer).start();
                        }
                    }
                    if (!DisplayTask.hasTask(player.getUniqueId())) {
                        new DisplayTask(plugin, rsvplayer).start();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        if (shouldEventBeRan(event.getView().getPlayer())) {
            ItemStack[] matrix = event.getInventory().getMatrix();
            int canteenIndex = -1;
            int juiceIndex = -1;

            ItemStack item;

            for (int i = 0; i < matrix.length; i++) {
                item = matrix[i];
                if (RSVItem.isRSVItem(item)) {
                    String name = RSVItem.getNameFromItem(item);
                    if (name.equals("canteen_empty") || name.equals("canteen_filled")) {
                        canteenIndex = canteenIndex == -1 ? i : -2;
                    }
                    else if (name.contains("juice") || name.equals("purified_water_bottle")) {
                        juiceIndex = juiceIndex == -1 ? i : -2;
                    }
                }
                else if (Utils.isItemReal(item)) {
                    if (item.getType() == Material.POTION) {
                        juiceIndex = juiceIndex == -1 ? i : -2;
                    }
                }
            }

            if (canteenIndex > -1 && juiceIndex > -1) {
                ItemStack canteen = matrix[canteenIndex];
                ItemStack juice = matrix[juiceIndex];

                if (canteen.getAmount() == 1 && juice.getAmount() == 1) {
                    String drinkName = RSVItem.isRSVItem(juice) ? RSVItem.getNameFromItem(juice) : "Unpurified Water";

                    if (canFill(canteen, drinkName)) {
                        ItemStack copy = canteen.clone();
                        event.getInventory().setResult(fillCanteen(copy, drinkName, 1));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemHeld(PlayerItemHeldEvent event) {
        if (tempEnabled) {
            if (!event.isCancelled()) {
                Player player = event.getPlayer();
                if (shouldEventBeRan(player)) {
                    ItemStack item = player.getInventory().getItem(event.getNewSlot());

                    checkAndRunTask(player, item);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (tempEnabled) {
            if (!event.isCancelled()) {
                Entity entity = event.getEntity();
                if (entity instanceof Player player) {
                    if (shouldEventBeRan(player)) {
                        ItemStack item = event.getItem().getItemStack();
                        checkAndRunTask(player, item);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        if (tempEnabled) {
            if (!event.isCancelled()) {
                Player player = (Player) event.getWhoClicked();
                if (shouldEventBeRan(player)) {
                    ItemStack cursor = event.getCursor();

                    int heldSlot = player.getInventory().getHeldItemSlot();
                    int slot = event.getSlot();

                    if (slot == heldSlot || event.getRawSlot() == 45) {
                        checkAndRunTask(player, cursor);
                    }

                    if (event.isShiftClick()) {
                        if (event.getView().getTopInventory().getType() != InventoryType.PLAYER) {
                            checkAndRunTask(player, event.getCurrentItem());
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemSwap(PlayerSwapHandItemsEvent event) {
        if (tempEnabled) {
            if (!event.isCancelled()) {
                Player player = event.getPlayer();

                if (shouldEventBeRan(player)) {
                    ItemStack item = event.getMainHandItem();
                    checkAndRunTask(player, item);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            String message = event.getMessage();

            if (message.length() > 1) {
                String[] args = message.substring(1).split(" ");

                if (args[0].equalsIgnoreCase("rsv") || args[0].equalsIgnoreCase("realisticsurvival")) {
                    if (args.length > 3) {
                        if (args[1].equalsIgnoreCase("give")) {
                            if (RSVItem.isRSVItem(args[3]) && args[3].equalsIgnoreCase("thermometer")) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        checkAndRunTask(player, player.getInventory().getItemInMainHand());
                                    }
                                }.runTaskLater(plugin, 1L);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onServerCommand(ServerCommandEvent event) {
        if (!event.isCancelled()) {
            String message = event.getCommand();

            if (message.length() > 1) {
                String[] args = message.substring(1).split(" ");
                if (args[0].equalsIgnoreCase("rsv") || args[0].equalsIgnoreCase("realisticsurvival")) {
                    if (args.length > 3) {
                        if (args[1].equalsIgnoreCase("give")) {
                            Player player = Bukkit.getPlayer(args[2]);
                            if (player != null && RSVItem.isRSVItem(args[3]) && args[3].equalsIgnoreCase("thermometer")) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        checkAndRunTask(player, player.getInventory().getItemInMainHand());
                                    }
                                }.runTaskLater(plugin, 1L);
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkAndRunTask(Player player, ItemStack item) {
        if (tempEnabled) {
            if (RSVItem.isRSVItem(item)) {
                if (RSVItem.getNameFromItem(item).equals("thermometer")) {
                    if (player != null) {
                        if (!ThermometerTask.hasTask(player.getUniqueId())) {
                            new ThermometerTask(plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                        }
                    }
                }
            }
        }
    }

    private boolean canFill(ItemStack canteen, String newDrink) {
        String originalDrink = Utils.getNbtTag(canteen, "rsvdrink", PersistentDataType.STRING);
        if (Utils.getCustomDurability(canteen) >= Utils.getMaxCustomDurability(canteen)) {
            return false;
        }

        if (!originalDrink.equals("None")) {
            return originalDrink.equals(newDrink);
        }
        return true;
    }

    private ItemStack fillCanteen(ItemStack canteen, String drink, int change) {
        int durability = Utils.getCustomDurability(canteen);

        int sum = durability + change;

        ItemMeta meta = canteen.getItemMeta();
        if (sum < 1) {
            if (meta.getDisplayName().equals(RSVItem.getItem("canteen_filled").getItemMeta().getDisplayName())) {
                meta.setDisplayName(RSVItem.getItem("canteen_empty").getItemMeta().getDisplayName());
            }
            int modelData = RSVItem.getItem("canteen_empty").getItemMeta().getCustomModelData();
            if (!meta.hasCustomModelData()) {
                meta.setCustomModelData(modelData);
                canteen.setItemMeta(meta);
            }
            else {
                if (meta.getCustomModelData() != modelData) {
                    meta.setCustomModelData(modelData);
                    canteen.setItemMeta(meta);
                }
            }

            Utils.addNbtTag(canteen, "rsvitem", "canteen_empty", PersistentDataType.STRING);
            Utils.addNbtTag(canteen, "rsvdrink", "None", PersistentDataType.STRING);

            canteen.setType(Material.GLASS_BOTTLE);
        }
        else {
            if (meta.getDisplayName().equals(RSVItem.getItem("canteen_empty").getItemMeta().getDisplayName())) {
                meta.setDisplayName(RSVItem.getItem("canteen_filled").getItemMeta().getDisplayName());
            }

            int modelData = RSVItem.getItem("canteen_filled").getItemMeta().getCustomModelData();
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            if (!meta.hasCustomModelData()) {
                meta.setCustomModelData(modelData);
                canteen.setItemMeta(meta);
            }
            else {
                if (meta.getCustomModelData() != modelData) {
                    meta.setCustomModelData(modelData);
                    canteen.setItemMeta(meta);
                }
            }

            Utils.addNbtTag(canteen, "rsvitem", "canteen_filled", PersistentDataType.STRING);
            Utils.addNbtTag(canteen, "rsvdrink", drink, PersistentDataType.STRING);
            canteen.setType(Material.POTION);
        }
        Utils.changeDurability(canteen, change, false);
        return canteen;
    }
}
