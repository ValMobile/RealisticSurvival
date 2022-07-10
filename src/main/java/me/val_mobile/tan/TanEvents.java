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
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.SplittableRandom;

import static me.val_mobile.tan.TanRunnables.LOWEST_THIRST;

public class TanEvents implements Listener {

    private final TanRunnables tanRunnables;
    private final RealisticSurvivalPlugin plugin;
    private final Utils util;
    private final CustomItems customItems;

    public TanEvents(RealisticSurvivalPlugin plugin) {
        tanRunnables = new TanRunnables(plugin);
        this.plugin = plugin;
        util = new Utils(plugin);
        customItems = new CustomItems(plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails")) {
            if (!event.isCancelled()) {
                GameMode mode = event.getNewGameMode();
                if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {

                    tanRunnables.updateTemperatureThirstValues(player);
                    tanRunnables.startTemperatureThirstRunnable(player);
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails"))
            tanRunnables.resetTemperatureThirstMaps(event.getPlayer());
    }

    @EventHandler
    public void onDrink(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails")) {
            GameMode mode = player.getGameMode();
            Action action = event.getAction();
            if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (player.isSneaking()) {
                        Location playerLoc = player.getLocation();

                        Block block = event.getClickedBlock();
                        Location loc = block.getLocation();

                        Location aboveLoc = loc.clone();
                        aboveLoc.setY(aboveLoc.getY() + 1D);
                        Block aboveBlock = aboveLoc.getBlock();

                        Block waterSource = null;

                        if (block.getBlockData().getMaterial() == Material.WATER) {
                            if (Utils.isSourceLiquid(block)) {
                                waterSource = block;
                            }
                        }

                        if (aboveBlock.getBlockData().getMaterial() == Material.WATER) {
                            if (Utils.isSourceLiquid(aboveBlock)) {
                                waterSource = aboveBlock;
                            }
                        }

                        if (waterSource != null) {
                            double maxDistance = RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Drinking.MaxDistance");

                            if (playerLoc.distance(waterSource.getLocation()) < maxDistance) {
                                double current = PlayerRunnable.getThirst().get(player.getName());
                                double difference = LOWEST_THIRST - current;

                                if (RSVFiles.getTanUserConfig().getBoolean("Thirst.Supplements.Drinking.OverrideLimit")) {
                                    Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Drinking.Amount"));
                                }
                                else {
                                    if (Math.abs(difference) >= 0.01) {

                                        if (difference > RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Drinking.Amount")) {
                                            Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Drinking.Amount"));
                                        }
                                        else {
                                            Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                                        }
                                    }
                                }
                                Sound sound = Sound.valueOf(RSVFiles.getTanUserConfig().getString("Thirst.Supplements.Drinking.Sound"));
                                float volume = (float) RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Drinking.Volume");
                                float pitch = (float) RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Drinking.Pitch");

                                if (volume != -1.0) {
                                    player.playSound(playerLoc, sound, volume, pitch);
                                }
                            }
                        }
                    }
                }
                else if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_AIR)) {
                    if (!player.getWorld().isClearWeather()) {
                        if (player.isSneaking()) {
                            if (Utils.isExposedToSky(player)) {
                                Location loc = player.getLocation();
                                if (Math.abs(loc.getPitch() + 90F) < 0.01) {
                                    double current = PlayerRunnable.getThirst().get(player.getName());
                                    double difference = LOWEST_THIRST - current;

                                    if (RSVFiles.getTanUserConfig().getBoolean("Thirst.Supplements.Raining.OverrideLimit")) {
                                        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Raining.Amount"));
                                    }
                                    else {
                                        if (Math.abs(difference) >= 0.01) {
                                            if (difference > RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Raining.Amount")) {
                                                Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Raining.Amount"));
                                            } else {
                                                Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                                            }
                                        }
                                    }
                                    Sound sound = Sound.valueOf(RSVFiles.getTanUserConfig().getString("Thirst.Supplements.Raining.Sound"));
                                    float volume = (float) RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Raining.Volume");
                                    float pitch = (float) RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.Raining.Pitch");

                                    if (volume != -1.0) {
                                        player.playSound(loc, sound, volume, pitch);
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
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails")) {
            GameMode mode = player.getGameMode();

            if (mode.equals(GameMode.SURVIVAL) || mode.equals(GameMode.ADVENTURE)) {
                ItemStack item = event.getItem();

                if (item.getType() == Material.POTION) {
                    double current = PlayerRunnable.getThirst().get(player.getName());
                    double difference = LOWEST_THIRST - current;

                    String drink;

                    if (util.hasNbtTag(item, "tan_drinks")) {
                        drink = util.getNbtTag(item, "tan_drinks");
                    }
                    else {
                        drink = "WaterBottle";
                    }


                    if (RSVFiles.getTanUserConfig().getBoolean("Thirst.Supplements." + drink + ".OverrideLimit")) {
                        Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements." + drink + ".Amount"));
                    }
                    else {
                        if (Math.abs(difference) >= 0.01) {
                            if (difference > RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements." + drink + ".Amount")) {
                                Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements." + drink + ".Amount"));
                            } else {
                                Utils.setOrReplaceEntry(PlayerRunnable.getThirst(), player.getName(), current + difference);
                            }
                        }
                    }

                    if (drink.equals("ChorusFruitJuice")) {
                        if (RSVFiles.getTanUserConfig().getBoolean("Thirst.Supplements.ChorusFruitJuice.Teleport.Enabled")) {
                            Location loc = player.getLocation();

                            SplittableRandom r = new SplittableRandom();
                            final double RADIUS = RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.ChorusFruitJuice.Teleport.MaxRadius");
                            double x = loc.getX() + r.nextDouble() * RADIUS;
                            double z = loc.getZ() + r.nextDouble() * RADIUS;

                            Location newLoc = new Location(loc.getWorld(), x, loc.getWorld().getHighestBlockYAt((int) Math.round(x), (int) Math.round(z)), z, loc.getYaw(), loc.getPitch());

                            player.teleport(newLoc);

                            Sound sound = Sound.valueOf(RSVFiles.getTanUserConfig().getString("Thirst.Supplements.ChorusFruitJuice.Teleport.Sound"));
                            float volume = (float) RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.ChorusFruitJuice.Teleport.Volume");
                            float pitch = (float) RSVFiles.getTanUserConfig().getDouble("Thirst.Supplements.ChorusFruitJuice.Teleport.Pitch");

                            if (volume != -1.0) {
                                player.playSound(loc, sound, volume, pitch);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails")) {
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            Block block = event.getBlock();
            Material material = block.getBlockData().getMaterial();

            if (RSVFiles.getTanUserConfig().getStringList("IceCube.Blocks").contains(material.toString())) {
                if (Utils.isHoldingPickaxe(player)) {
                    if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                        double chance = RSVFiles.getTanUserConfig().getDouble("IceCube.DropChance");
                        Utils.harvestFortune(chance, customItems.getIceCube(), itemMainHand, block.getLocation());

                        if (Utils.decrementDurability(itemMainHand))
                            player.getInventory().setItemInMainHand(null);
                    }
                }
            }
            if (RSVFiles.getTanUserConfig().getStringList("MagmaShard.Blocks").contains(material.toString())) {
                if (Utils.isHoldingPickaxe(player)) {
                    if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                        event.setDropItems(false);

                        double chance = RSVFiles.getTanUserConfig().getDouble("MagmaShard.DropChance");
                        Utils.harvestFortune(chance, customItems.getMagmaShard(), itemMainHand, block.getLocation());
                        if (Utils.decrementDurability(itemMainHand))
                            player.getInventory().setItemInMainHand(null);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {

        Player player = event.getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails")) {
            String name = player.getName();

            HashMap<String, Boolean> tempRunMap = PlayerRunnable.getTemperatureRunnables();
            HashMap<String, Boolean> thirstRunMap = PlayerRunnable.getThirstRunnables();

            if (tempRunMap.containsKey(name) && thirstRunMap.containsKey(name)) {
                if (!(tempRunMap.get(name) || thirstRunMap.get(name))) {
                    // start every bauble runnable
                    tanRunnables.startTemperatureThirstRunnable(player);

                    Utils.setOrReplaceEntry(tempRunMap, name, true);
                    Utils.setOrReplaceEntry(thirstRunMap, name, true);
                }
            }
        }
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        Player player = (Player) event.getView().getPlayer();

        if (util.shouldEventBeRan(player, "ToughAsNails")) {
            if (event.getRecipe() != null) {
                if (event.getRecipe().getResult().isSimilar(new ItemStack(Material.PRISMARINE))) {
                    for (ItemStack i : event.getInventory().getContents()) {
                        ItemMeta meta = i.getItemMeta();

                        if (meta.hasCustomModelData()) {
                            if (meta.getCustomModelData() >= 83650 && meta.getCustomModelData() <= 84000) {
                                event.getInventory().setResult(null);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}
