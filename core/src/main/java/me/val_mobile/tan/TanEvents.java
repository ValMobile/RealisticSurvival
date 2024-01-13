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

import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.baubles.StoneNegativeGravityTask;
import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.misc.PlayerItemAcquireEvent;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.DisplayTask;
import me.val_mobile.utils.PlayerJumpEvent;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.FurnaceBurnEvent;
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

import java.util.*;

public class TanEvents extends ModuleEvents implements Listener {

    private final RSVPlugin plugin;
    private final FileConfiguration config;
    private final boolean tempEnabled;
    private final TanModule module;
    private final boolean thirstEnabled;
    private final TempManager tempManager;
    private final ThirstManager thirstManager;


    public TanEvents(TanModule module, RSVPlugin plugin) {
        super(module, plugin);
        this.module = module;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.tempEnabled = module.isTempGloballyEnabled();
        this.thirstEnabled = module.isThirstGloballyEnabled();
        this.tempManager = module.getTempManager();
        this.thirstManager = module.getThirstManager();
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && (tempEnabled || thirstEnabled) && RSVPlayer.isValidPlayer(player)))
            return;

        RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(player.getUniqueId());

        if (tempEnabled) {
            if (!TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                new TemperatureCalculateTask(module, plugin, rsvplayer).start();
            }

            if (RSVItem.isHoldingItem("thermometer", player) && !ThermometerTask.hasTask(player.getUniqueId())) {
                new ThermometerTask(plugin, rsvplayer).start();
            }
        }
        if (thirstEnabled && !ThirstCalculateTask.hasTask(player.getUniqueId())) {
            new ThirstCalculateTask(module, plugin, rsvplayer).start();
        }
        if (!DisplayTask.hasTask(player.getUniqueId())) {
            new DisplayTask(plugin, rsvplayer).start();
        }
    }

    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();

        if (!(shouldEventBeRan(player) && thirstManager.isThirstEnabled(player)))
            return;

        // player is sprinting and jumping
        if (player.isSprinting())
            thirstManager.addExhaustion(player, config.getDouble("Thirst.ExhaustionLevelIncrease.JumpingWhileSprinting"));
        // player is only jumping
        else
            thirstManager.addExhaustion(player, config.getDouble("Thirst.ExhaustionLevelIncrease.Jumping"));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (!shouldEventBeRan(player))
            return;

        UUID id = player.getUniqueId();
        if (thirstEnabled) {
            thirstManager.setThirst(player, config.getInt("Thirst.DefaultThirst"));
            thirstManager.setSaturation(player, config.getInt("Thirst.DefaultSaturation"));

            if (module.getDehydrationDeath().contains(id)) {
                if (config.getBoolean("DehydrationDeath.Enabled")) {
                    List<String> deathMessages = config.getStringList("DehydrationDeath.Messages");

                    int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                    event.setDeathMessage(Utils.translateMsg(deathMessages.get(num), player, Map.of("PLAYER_NAME", player.getDisplayName())));
                }
                module.getDehydrationDeath().remove(id);
            }
            else if (module.getParasiteDeath().contains(id)) {
                if (config.getBoolean("ParasiteDeath.Enabled")) {
                    List<String> deathMessages = config.getStringList("ParasiteDeath.Messages");

                    int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                    event.setDeathMessage(Utils.translateMsg(deathMessages.get(num), player, Map.of("PLAYER_NAME", player.getDisplayName())));
                }
                module.getParasiteDeath().remove(id);
            }
        }

        if (tempEnabled) {
            tempManager.setTemperature(player, config.getDouble("Temperature.DefaultTemperature"));

            if (module.getHyperthermiaDeath().contains(id)) {
                if (config.getBoolean("HyperthermiaDeath.Enabled")) {
                    List<String> deathMessages = config.getStringList("HyperthermiaDeath.Messages");

                    int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                    event.setDeathMessage(Utils.translateMsg(deathMessages.get(num), player, Map.of("PLAYER_NAME", player.getDisplayName())));
                }
                module.getHyperthermiaDeath().remove(id);
            }
            else if (module.getHypothermiaDeath().contains(id)) {
                if (config.getBoolean("HypothermiaDeath.Enabled")) {
                    List<String> deathMessages = config.getStringList("HypothermiaDeath.Messages");

                    int num = Utils.getRandomNum(0, deathMessages.size() - 1);

                    event.setDeathMessage(Utils.translateMsg(deathMessages.get(num), player, Map.of("PLAYER_NAME", player.getDisplayName())));
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

    @EventHandler(priority = EventPriority.MONITOR)
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (!shouldEventBeRan(player))
            return;

        UUID id = player.getUniqueId();

        if (DisplayTask.hasTask(id))
            DisplayTask.getTasks().get(id).setParasitesActive(false);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode mode = event.getNewGameMode();

        if (!(shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player) && (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE) && (tempEnabled || thirstEnabled)))
            return;

        RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(player.getUniqueId());

        if (tempEnabled && !TemperatureCalculateTask.hasTask(player.getUniqueId())) {
            new TemperatureCalculateTask(module, plugin, rsvplayer).start();
        }
        if (thirstEnabled && !ThirstCalculateTask.hasTask(player.getUniqueId())) {
            new ThirstCalculateTask(module, plugin, rsvplayer).start();
        }
        if (!DisplayTask.hasTask(player.getUniqueId())) {
            new DisplayTask(plugin, rsvplayer).start();
        }
    }

    @EventHandler
    public void onDrink(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        GameMode mode = player.getGameMode();

        if (!(thirstManager.isThirstEnabled(player) && (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE)))
            return;

        Action action = event.getAction();

        boolean parasites = false;

        switch (action) {
            case RIGHT_CLICK_BLOCK, RIGHT_CLICK_AIR -> {
                Block block;
                Location playerLoc = player.getLocation();
                Location eye = player.getEyeLocation().add(player.getLocation().getDirection());

                if (config.getBoolean("Thirst.SaturationRestoration.Drinking.Enabled") && player.isSneaking()) {
                    double maxDistance = config.getDouble("Thirst.SaturationRestoration.Drinking.MaxDistance");

                    RayTraceResult result = player.getWorld().rayTraceBlocks(player.getEyeLocation(), eye.getDirection(), maxDistance, FluidCollisionMode.ALWAYS, true);

                    if (result != null && result.getHitBlock() != null) {
                        block = result.getHitBlock();

                        if (block.getType() == Material.WATER && Utils.isSourceLiquid(block)) {
                            int thirstPoints = config.getInt("Thirst.SaturationRestoration.Drinking.ThirstPoints");
                            int saturationPoints = config.getInt("Thirst.SaturationRestoration.Drinking.SaturationPoints");

                            thirstManager.addThirst(player, thirstPoints);
                            thirstManager.addSaturation(player, saturationPoints);

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
                if (config.getBoolean("Thirst.SaturationRestoration.Raining.Enabled") && player.getWorld().hasStorm() && Utils.canRain(player.getLocation()) && Utils.isExposedToSky(player) && Math.abs(player.getLocation().getPitch() + 90F) < 0.01) {
                    Location loc = player.getLocation();

                    int thirstPoints = config.getInt("Thirst.SaturationRestoration.Raining.ThirstPoints");
                    int saturationPoints = config.getInt("Thirst.SaturationRestoration.Raining.SaturationPoints");

                    thirstManager.addThirst(player, thirstPoints);
                    thirstManager.addSaturation(player, saturationPoints);

                    if (config.getBoolean("Thirst.SaturationRestoration.Raining.Sound.Enabled")) {
                        String soundName = config.getString("Thirst.SaturationRestoration.Raining.Sound.Sound");
                        float volume = (float) config.getDouble("Thirst.SaturationRestoration.Raining.Sound.Volume");
                        float pitch = (float) config.getDouble("Thirst.SaturationRestoration.Raining.Sound.Pitch");
                        Utils.playSound(loc, soundName, volume, pitch);
                    }

                    // regular water
                    if (config.getBoolean("Thirst.Parasites.Rain.Enabled") && Utils.roll(config.getDouble("Thirst.Parasites.Rain.Chance"))) {
                        parasites = true;
                    }
                }
            }
        }

        boolean hasStoneSea = false;

        // determine if player has stone of the sea bauble
        if (RSVPlayer.isValidPlayer(player)) {
            DataModule dataModule = RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule();
            RSVModule baubleModule = RSVModule.getModule(BaubleModule.NAME);
            hasStoneSea = baubleModule.isEnabled(player) && baubleModule.getUserConfig().getConfig().getBoolean("Items.stone_sea.ParasiteImmunity") && dataModule != null && dataModule.hasBauble("stone_sea");
        }

        if (parasites && !ParasiteTask.hasTask(player.getUniqueId()) && !hasStoneSea) {
            new ParasiteTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCampfireInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (!(tempManager.isTempEnabled(player) && event.useInteractedBlock() == Event.Result.ALLOW && event.getAction() == Action.RIGHT_CLICK_BLOCK && block != null && (block.getType() == Material.CAMPFIRE || block.getType() == Material.SOUL_CAMPFIRE)))
            return;

        ItemStack item = event.getItem();

        if (Utils.isItemReal(item) && (item.getType() == Material.WATER_BUCKET || item.getType().toString().contains("SHOVEL") || item.getType() == Material.FLINT_AND_STEEL)) {
            new TemperatureEnvironmentTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).runTaskLaterAsynchronously(plugin, 1L);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onSplashPotionLand(PotionSplashEvent event) {
        if (!shouldEventBeRan(event.getPotion()))
            return;

        Location loc = event.getPotion().getLocation();

        double rad = config.getDouble("Temperature.Environment.CubeLength");

        Collection<Entity> nearby = loc.getWorld().getNearbyEntities(loc, rad, rad, rad, entity -> entity instanceof Player);

        nearby.forEach(entity -> new TemperatureEnvironmentTask(module, plugin, RSVPlayer.getPlayers().get(entity.getUniqueId())).runTaskLaterAsynchronously(plugin, 1L));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFlamingProjectileLand(ProjectileHitEvent event) {
        if (!(shouldEventBeRan(event.getEntity()) && ((event.getEntity() instanceof Arrow arrow && arrow.getFireTicks() > 0) || event.getEntity() instanceof Fireball) && event.getHitBlock() != null && (event.getHitBlock().getType() == Material.CAMPFIRE || event.getHitBlock().getType() == Material.SOUL_CAMPFIRE)))
            return;

        Location loc = event.getEntity().getLocation();

        double rad = config.getDouble("Temperature.Environment.CubeLength");

        Collection<Entity> nearby = loc.getWorld().getNearbyEntities(loc, rad, rad, rad, entity -> entity instanceof Player player && RSVPlayer.isValidPlayer(player));
        nearby.forEach(entity -> new TemperatureEnvironmentTask(module, plugin, RSVPlayer.getPlayers().get(entity.getUniqueId())).runTaskLaterAsynchronously(plugin, 1L));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        GameMode mode = player.getGameMode();

        if (!(shouldEventBeRan(player) && (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE)))
            return;

        ItemStack item = event.getItem();

        String name = RSVItem.isRSVItem(item) ? RSVItem.getNameFromItem(item) : item.getType().toString();
        Set<String> keys = config.getConfigurationSection("Thirst.SaturationRestoration.Foods").getKeys(false);

        if (!(name != null && thirstManager.isThirstEnabled(player)))
            return;

        if (keys.contains(name)) {
            int thirstPoints = config.getInt("Thirst.SaturationRestoration.Foods." + name + ".ThirstPoints");;
            int saturationPoints = config.getInt("Thirst.SaturationRestoration.Foods." + name + ".SaturationPoints");

            thirstManager.addThirst(player, thirstPoints);
            thirstManager.addSaturation(player, saturationPoints);
            DataModule dataModule = RSVPlayer.getPlayers().get(player.getUniqueId()).getBaubleDataModule();

            if (name.equals(item.getType().toString()) && item.getType() == Material.POTION && ((PotionMeta) item.getItemMeta()).getBasePotionData().getType() == PotionType.WATER) {
                RSVModule baubleModule = RSVModule.getModule(BaubleModule.NAME);
                if (!(baubleModule.isGloballyEnabled() && baubleModule.getUserConfig().getConfig().getBoolean("Items.stone_sea.ParasiteImmunity") && dataModule != null && dataModule.hasBauble("stone_sea"))) {
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
                    int thirstPoints = config.getInt("Thirst.SaturationRestoration.Foods.POTION.ThirstPoints");
                    int saturationPoints = config.getInt("Thirst.SaturationRestoration.Foods.POTION.SaturationPoints");

                    // unpurified water
                    if (config.getBoolean("Thirst.Parasites.UnpurifiedWaterBottle.Enabled")) {
                        if (Utils.roll(config.getDouble("Thirst.Parasites.UnpurifiedWaterBottle.Chance"))) {
                            if (!ParasiteTask.hasTask(player.getUniqueId())) {
                                new ParasiteTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
                            }
                        }
                    }

                    thirstManager.addThirst(player, thirstPoints);
                    thirstManager.addSaturation(player, saturationPoints);
                }
                else {
                    String drink = canteenDrink.toLowerCase().replace(' ', '_');

                    int thirstPoints = config.getInt("Thirst.SaturationRestoration.Foods." + drink + ".ThirstPoints");
                    int saturationPoints = config.getInt("Thirst.SaturationRestoration.Foods." + drink + ".SaturationPoints");

                    thirstManager.addThirst(player, thirstPoints);
                    thirstManager.addSaturation(player, saturationPoints);
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

    @EventHandler (priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageEvent event) {
        Entity e = event.getEntity();

        if (!(shouldEventBeRan(e) && e instanceof Player player && (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE)))
            return;


        UUID id = player.getUniqueId();

        if (thirstEnabled) {
            if (event.isCancelled()) {
                module.getDehydrationDeath().remove(id);
                module.getParasiteDeath().remove(id);
            }
            else {
                if (thirstManager.isThirstEnabled(player)) {
                    if (event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                        if (config.getBoolean("Thirst.SaturationRestoration.Drowning.Enabled")) {
                            int thirstPoints = config.getInt("Thirst.SaturationRestoration.Drowning.ThirstPoints");
                            int saturationPoints = config.getInt("Thirst.SaturationRestoration.Drowning.SaturationPoints");

                            thirstManager.addThirst(player, thirstPoints);
                            thirstManager.addSaturation(player, saturationPoints);
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
                    thirstManager.setExhaustion(player, thirstManager.getExhaustion(player) + (config.getDouble("Thirst.ExhaustionLevelIncrease.TakingDamage") * parasiteExhaustionMultiplier));
                }
            }
            if (player.getHealth() - event.getFinalDamage() > 0D) {
                // player will not die
                module.getDehydrationDeath().remove(id);
                module.getParasiteDeath().remove(id);
            }
        }

        if (tempEnabled && (player.getHealth() - event.getFinalDamage() > 0D || event.isCancelled())) {
            // player will not die
            module.getHyperthermiaDeath().remove(id);
            module.getHypothermiaDeath().remove(id);
        }
    }

    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRegenerate(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player player && thirstManager.isThirstEnabled(player) && event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
            thirstManager.addExhaustion(player, config.getDouble("Thirst.ExhaustionLevelIncrease.RegeneratingHealth"));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockGrow(BlockGrowEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockExplode(BlockExplodeEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onSpongeAbsorb(SpongeAbsorbEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockFertilize(BlockFertilizeEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFluidLevelChange(FluidLevelChangeEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onLeafDecay(LeavesDecayEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCauldronLevel(CauldronLevelChangeEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockFade(BlockFadeEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBurn(BlockBurnEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockIgnite(BlockIgniteEvent event) {
        adjustEnvTemp(event);
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        String oldWorld = event.getFrom().toString();

        if (!(shouldEventBeRan(player) && RSVPlayer.isValidPlayer(player) && !module.getAllowedWorlds().contains(oldWorld) && (tempEnabled || thirstEnabled)))
            return;

        RSVPlayer rsvplayer = RSVPlayer.getPlayers().get(player.getUniqueId());

        if (tempEnabled) {
            if (!TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                new TemperatureCalculateTask(module, plugin, rsvplayer).start();
            }

            if (RSVItem.isHoldingItem("thermometer", player) && !ThermometerTask.hasTask(player.getUniqueId())) {
                new ThermometerTask(plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
            }
        }
        if (thirstEnabled && !ThirstCalculateTask.hasTask(player.getUniqueId())) {
            new ThirstCalculateTask(module, plugin, rsvplayer).start();
        }
        if (!DisplayTask.hasTask(player.getUniqueId())) {
            new DisplayTask(plugin, rsvplayer).start();
        }
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        if (!shouldEventBeRan(event.getView().getPlayer()))
            return;

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

    @EventHandler
    public void onItemAcquire(PlayerItemAcquireEvent event) {
        ItemStack item = event.getItem();
        EquipmentSlot loc = event.getLocation();

        if (!(RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).equals("thermometer") && (loc == EquipmentSlot.HAND || loc == EquipmentSlot.OFF_HAND)))
            return;

        Player player = event.getPlayer();

        if (RSVPlayer.isValidPlayer(player) && player.isOnline() && !ThermometerTask.hasTask(player.getUniqueId()))
            new ThermometerTask(plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).start();
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
        Utils.changeDurability(canteen, change, false, false, null);
        return canteen;
    }

    public void adjustEnvTemp(Cancellable blockEvent) {
        if (!blockEvent.isCancelled()) {
            Block block = null;
            BlockData data1 = null;
            BlockData data2 = null;
            World world = null;
            boolean singleBlock = true;

            if (blockEvent instanceof BlockPlaceEvent event) {
                block = event.getBlockPlaced();
                data2 = block.getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof BlockBreakEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                world = block.getWorld();
                thirstManager.addExhaustion(event.getPlayer(), config.getDouble("Thirst.ExhaustionLevelIncrease.BreakingBlock"));
            }
            else if (blockEvent instanceof FurnaceBurnEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                data2 = data1.clone();
                world = block.getWorld();
                ((Lightable) data1).setLit(false);
                ((Lightable) data2).setLit(true);
            }
            else if (blockEvent instanceof LeavesDecayEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof FluidLevelChangeEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                data2 = event.getNewData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof EntityChangeBlockEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                data2 = event.getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof BlockGrowEvent event) {
                block = event.getBlock();
                data2 = block.getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof CauldronLevelChangeEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                data2 = event.getNewState().getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof BlockFadeEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                data2 = event.getNewState().getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof BlockBurnEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof BlockIgniteEvent event) {
                block = event.getBlock();
                data1 = block.getBlockData();
                world = block.getWorld();
            }
            else if (blockEvent instanceof BlockExplodeEvent event) {
                block = event.getBlock();
                world = block.getWorld();
                singleBlock = false;
            }
            else if (blockEvent instanceof BlockFertilizeEvent event) {
                block = event.getBlock();
                world = block.getWorld();
                singleBlock = false;
            }
            else if (blockEvent instanceof SpongeAbsorbEvent event) {
                block = event.getBlock();
                world = block.getWorld();
                singleBlock = false;
            }

            if (shouldEventBeRan(world)) {
                ConfigurationSection section = config.getConfigurationSection("Temperature.Environment.Blocks");
                if (TemperatureEnvironmentTask.willAffectTemperature(data1, section) || TemperatureEnvironmentTask.willAffectTemperature(data2, section)) {
                    double rad = config.getDouble("Temperature.Environment.CubeLength");

                    Collection<Entity> nearby = world.getNearbyEntities(block.getLocation(), rad, rad, rad, entity -> entity instanceof Player);

                    for (Entity e : nearby) {
                        Player player = (Player) e;
                        TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(player.getUniqueId());

                        if (tempTask != null) {
                            if (singleBlock) {
                                double ogVal = TemperatureEnvironmentTask.getValue(data1, section);
                                double finalVal = TemperatureEnvironmentTask.getValue(data2, section);

                                double regulateEnv = tempTask.getRegulateEnv();
                                double changeEnv = tempTask.getChangeEnv();

                                if (TemperatureEnvironmentTask.isRegulatory(data1, section)) {
                                    regulateEnv -= ogVal;
                                }
                                else {
                                    changeEnv -= ogVal;
                                }

                                if (TemperatureEnvironmentTask.isRegulatory(data2, section)) {
                                    regulateEnv += finalVal;
                                }
                                else {
                                    changeEnv += finalVal;
                                }

                                tempTask.setRegulateEnv(regulateEnv);
                                tempTask.setChangeEnv(changeEnv);
                            }
                            else {
                                new TemperatureEnvironmentTask(module, plugin, RSVPlayer.getPlayers().get(player.getUniqueId())).runTaskLaterAsynchronously(plugin, 1L);
                            }
                        }
                    }
                }
            }
        }
    }
}
