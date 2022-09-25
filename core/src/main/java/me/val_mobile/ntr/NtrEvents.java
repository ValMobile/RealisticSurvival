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
package me.val_mobile.ntr;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.ModuleItems;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.ToolHandler.Tool;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class NtrEvents extends ModuleEvents implements Listener {

    private final FileConfiguration config;
    private final ModuleItems moduleItems;
    private final NtrModule module;
    private final RealisticSurvivalPlugin plugin;

    public NtrEvents(NtrModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.module = module;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.moduleItems = module.getModuleItems();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                FileConfiguration config = module.getUserConfig().getConfig();
                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                Block block = event.getBlock();
                Material material = block.getBlockData().getMaterial();

                if (config.getBoolean("PreventPunchingWood.Enabled")) {
                    if (config.getStringList("PreventPunchingWood.WoodBlocks").contains(material.toString())) {
                        if (!Utils.isHoldingAxe(player)) {
                            event.setDropItems(false);
                        }
                    }
                }

                if (config.getBoolean("PlantFiberGathering.Enabled")) {
                    if (config.getStringList("PlantFiberGathering.Blocks").contains(material.toString())) {
                        if (RSVItem.isRSVItem(itemMainHand)) {
                            String name = RSVItem.getNameFromItem(itemMainHand);

                            if (name.contains("dagger") || name.contains("knife")) {
                                if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                    if (config.getConfigurationSection("PlantFiberGathering.BlockDrops").getKeys(false).contains(material.toString())) {
                                        ItemStack plantFiber = moduleItems.getItem("plant_fiber");

                                        Utils.harvestLooting(config.getConfigurationSection("PlantFiberGathering.BlockDrops." + material), plantFiber, null, block.getLocation());
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
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            FileConfiguration config = module.getUserConfig().getConfig();
            ItemStack item = event.getItem();
            Action action = event.getAction();
            UUID id = player.getUniqueId();
            Block block = event.getClickedBlock();

            if (action == Action.LEFT_CLICK_BLOCK) {
                Material blockMat = block.getType();
                if (config.getBoolean("FlintKnapping.Enabled")) {
                    if (Utils.isItemReal(item)) {
                        if (item.getType() == Material.FLINT) {
                            if (config.getConfigurationSection("FlintKnapping.BlockDrops").getKeys(false).contains(blockMat.toString())) {
                                ItemStack flintShard = moduleItems.getItems().get("flint_shard");

                                Utils.harvestLooting(config.getConfigurationSection("FlintKnapping.BlockDrops." + blockMat), flintShard, null, block.getLocation().add(0D, 0.15D, 0D));

                                if (config.getBoolean("FlintKnapping.BlockDrops." + blockMat + ".Sound.Enabled")) {
                                    Utils.playSound(player.getLocation(), config.getString("FlintKnapping.BlockDrops." + blockMat + ".Sound.Sound"), (float) config.getDouble("FlintKnapping.BlockDrops." + blockMat + ".Sound.Volume"),  (float) config.getDouble("FlintKnapping.BlockDrops." + blockMat + ".Sound.Pitch"));
                                }
                                block.setType(Material.AIR);
                            }
                        }
                    }
                }
            }
            else if (action == Action.RIGHT_CLICK_BLOCK) {
                Material blockMat = block.getType();
                if (config.getBoolean("RemoveVanillaPlankRecipes.Enabled")) {
                    if (Utils.isItemReal(item)) {
                        if (Utils.isHoldingAxe(player)) {
                            if (Tag.LOGS.isTagged(blockMat)) {
                                Location blockLoc = block.getLocation();
                                Location pLoc = player.getLocation();
                                if (Utils.getBlockFace(player) == BlockFace.UP && Math.abs(pLoc.getY() - blockLoc.getY()) < 1D && pLoc.distance(blockLoc) < 1D) {
                                    if (Math.random() <= config.getDouble("RemoveVanillaPlankRecipes.AxePlankChance")) {
                                        ItemStack drop = new ItemStack(Material.valueOf(blockMat.toString().replace("LOG", "PLANKS")));
                                        Utils.harvestFortune(config.getConfigurationSection("RemoveVanillaPlankRecipes.BlockDrops"), drop, event.getItem(), block.getLocation());
                                    }
                                }
                            }
                        }
                    }
                }
                if (config.getBoolean("RemoveVanillaCampfireRecipes.Enabled")) {
                    if (RSVItem.isRSVItem(item)) {
                        if (RSVItem.getNameFromItem(item).equals("fire_starter")) {
                            double maxDistance = config.getDouble("RemoveVanillaCampfireRecipes.MaxDistance");

                            boolean needsFuel = config.getBoolean("RemoveVanillaCampfireRecipes.Fuel.Required");
                            boolean needsKindling = config.getBoolean("RemoveVanillaCampfireRecipes.Kindling.Required");

                            int requiredFuel = needsFuel ? config.getInt("RemoveVanillaCampfireRecipes.Fuel.Amount") : 0;
                            int requiredKindling = needsKindling ? config.getInt("RemoveVanillaCampfireRecipes.Kindling.Amount") : 0;
                            int requiredSoulItems = config.getInt("RemoveVanillaCampfireRecipes.SoulItems.Amount");

                            int fuel = 0;
                            int kindling = 0;
                            int soul = 0;

                            List<String> fuelMats = config.getStringList("RemoveVanillaCampfireRecipes.Kindling.Required");
                            List<String> kindlingMats = config.getStringList("RemoveVanillaCampfireRecipes.Kindling.Required");
                            List<String> soulItems = config.getStringList("RemoveVanillaCampfireRecipes.SoulItems");

                            Location loc = event.getClickedBlock().getLocation();

                            Collection<Entity> entities = loc.getWorld().getNearbyEntities(loc, maxDistance, maxDistance, maxDistance);

                            Collection<Item> ingredients = new ArrayList<>();

                            if (entities.size() <= requiredFuel + requiredKindling + requiredSoulItems + 5) {
                                for (Entity e : entities) {
                                    if (e instanceof Item) {
                                        ItemStack drop = ((Item) e).getItemStack();

                                        if (needsFuel) {
                                            if (fuelMats.contains(drop.getType().toString())) {
                                                if (fuel < requiredFuel) {
                                                    fuel += drop.getAmount();
                                                }
                                                ingredients.add((Item) e);
                                            }
                                        }
                                        if (needsKindling) {
                                            if (kindlingMats.contains(drop.getType().toString())) {
                                                if (kindling < requiredKindling) {
                                                    kindling += drop.getAmount();
                                                }
                                                ingredients.add((Item) e);
                                            }
                                        }
                                        if (soulItems.contains(drop.getType().toString())) {
                                            soul += drop.getAmount();
                                        }
                                    }
                                }

                                if (fuel >= requiredFuel && kindling >= requiredKindling) {
                                    if (!FireStarterTask.hasTask(id)) {
                                        new FireStarterTask(plugin, module, player, loc.add(0D, 0.6D, 0D), ingredients, soul >= requiredSoulItems).start();
                                    }
                                }
                            }
                        }
                    }
                }

                if (RSVItem.isRSVItem(item)) {
                    switch (RSVItem.getNameFromItem(item)) {
                        case "copper-mattock", "iron_mattock", "golden_mattock", "diamond_mattock", "netherite_mattock" -> {
                            Block b = event.getClickedBlock();
                            Material blockMaterial = b.getType();
                            String matName = item.getType().toString();

                            boolean isNotHoe = !matName.contains("HOE");
                            boolean isNotShovel = !matName.contains("SHOVEL");
                            boolean isNotAxe = !matName.contains("AXE");

                            if (isNotHoe || isNotShovel) {
                                if (isNotHoe && isNotShovel) {
                                    switch (blockMaterial) {
                                        case GRASS_BLOCK, DIRT -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.GRASS_PATH);
                                            }
                                            else {
                                                b.setType(Material.FARMLAND);
                                            }
                                            Utils.changeDurability(item, -1);
                                        }
                                        case COARSE_DIRT, PODZOL, MYCELIUM -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.GRASS_PATH);
                                            }
                                            else {
                                                b.setType(Material.DIRT);
                                            }
                                            Utils.changeDurability(item, -1);
                                        }
                                        case GRASS_PATH -> {
                                            b.setType(Material.FARMLAND);
                                            Utils.changeDurability(item, -1);
                                        }
                                        default -> {}
                                    }
                                    // support for rooted dirt
                                    if (blockMaterial.toString().equals("ROOTED_DIRT")) {
                                        if (player.isSneaking()) {
                                            b.setType(Material.GRASS_PATH);
                                        }
                                        else {
                                            player.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.valueOf("HANGING_ROOTS")));
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1);
                                    }
                                }
                                // it is a shovel
                                else if (isNotHoe) {
                                    switch (blockMaterial) {
                                        case GRASS_BLOCK, DIRT -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.FARMLAND);
                                            }
                                            Utils.changeDurability(item, -1);
                                        }
                                        case COARSE_DIRT, PODZOL, MYCELIUM -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.DIRT);
                                            }
                                            Utils.changeDurability(item, -1);
                                        }
                                        default -> {}
                                    }
                                    // support for rooted dirt
                                    if (blockMaterial.toString().equals("ROOTED_DIRT")) {
                                        if (player.isSneaking()) {
                                            player.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.valueOf("HANGING_ROOTS")));
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1);
                                    }
                                }
                                // it is a hoe
                                else {
                                    switch (blockMaterial) {
                                        case GRASS_BLOCK, DIRT, COARSE_DIRT, PODZOL, MYCELIUM -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.GRASS_PATH);
                                            }
                                            Utils.changeDurability(item, -1);
                                        }
                                        default -> {}
                                    }
                                    // support for rooted dirt
                                    if (blockMaterial.toString().equals("ROOTED_DIRT")) {
                                        if (player.isSneaking()) {
                                            b.setType(Material.GRASS_PATH);
                                        }
                                        Utils.changeDurability(item, -1);
                                    }
                                }
                            }
                            else if (isNotAxe) {
                                if (Tag.LOGS.isTagged(blockMaterial) && !blockMaterial.toString().contains("STRIPPED")) {
                                    b.setType(Material.valueOf("STRIPPED_" + blockMaterial));
                                    Utils.changeDurability(item, -1);
                                }
                            }
                        }
                        default -> {}
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            if (shouldEventBeRan(player)) {
                ItemStack item = event.getItemInHand();

                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getModuleNameFromItem(item).equals(NtrModule.NAME)) {
                        if (RSVItem.getNameFromItem(item).contains("mattock")) {

                            Block block = event.getBlock();
                            Material blockMat = block.getType();

                            Tool tool = Utils.getBestTool(blockMat);

                            switch (tool) {
                                case NONE, SHEARS -> {}
                                default -> {
                                    String type = item.getType().toString();
                                    item.setType(Material.valueOf(type.substring(0, type.indexOf("_") + 1) + tool));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        if (shouldEventBeRan(event.getView().getPlayer())) {
            FileConfiguration config = module.getUserConfig().getConfig();

            Recipe recipe = event.getRecipe();

            if (recipe != null) {

                if (config.getBoolean("RemoveVanillaPlankRecipes.Enabled")) {
                    if (recipe instanceof ShapelessRecipe) {
                        NamespacedKey key = ((ShapelessRecipe) recipe).getKey();

                        if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                            switch (key.getKey()) {
                                case "acacia_planks", "birch_planks", "crimson_planks", "dark_oak_planks", "jungle_planks", "mangrove_planks", "oak_planks", "spruce_planks", "warped_planks" ->
                                        event.getInventory().setResult(null);
                                default -> {}
                            }
                        }
                    }
                }

                if (config.getBoolean("RemoveVanillaCampfireRecipes.Enabled")) {
                    if (recipe instanceof ShapedRecipe) {
                        NamespacedKey key = ((ShapedRecipe) recipe).getKey();

                        if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                            switch (key.getKey()) {
                                case "campfire", "soul_campfire" -> event.getInventory().setResult(null);
                                default -> {}
                            }
                        }
                    }
                }

                if (config.getBoolean("Pottery.RemoveFlowerPotRecipe")) {
                    if (recipe instanceof ShapedRecipe) {
                        NamespacedKey key = ((ShapedRecipe) recipe).getKey();

                        if (key.getNamespace().equals(NamespacedKey.MINECRAFT) && key.getKey().equals("flower_pot")) {
                            event.getInventory().setResult(null);
                        }
                    }
                }
            }

            if (config.getBoolean("Pottery.Enabled")) {
                ItemStack[] matrix = event.getInventory().getMatrix();
                ItemStack clayTool = matrix[0];
                ItemStack clay = matrix[1];

                if (RSVItem.isRSVItem(clayTool)) {
                    if (RSVItem.getNameFromItem(clayTool).equals("clay_tool")) {
                        if (Utils.isItemReal(clay)) {
                            if (clay.getType() == Material.CLAY_BALL) {
                                int clayAmount = clay.getAmount();

                                if (RSVItem.getCustomDurability(clayTool) - clayAmount <= 0) {
                                    int dif = clayAmount - RSVItem.getCustomDurability(clayTool);
                                    Utils.changeDurability(clayTool, -dif);
                                    event.getInventory().setResult(RSVItem.getItem("clay_brick").resize(dif));
                                    event.getInventory().setItem(0, null);
                                    event.getInventory().setItem(1, null);
                                }
                                else {
                                    Utils.changeDurability(clayTool, -clayAmount);
                                    event.getInventory().setResult(RSVItem.getItem("clay_brick").resize(clayAmount));
                                    event.getInventory().setItem(1, null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBucketFill(PlayerBucketFillEvent event) {
        Player p = event.getPlayer();
        if (!event.isCancelled()) {
            if (shouldEventBeRan(p)) {
                ItemStack item = event.getItemStack();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).equals("ceramic_bucket")) {
                        String bucketType = event.getBucket().toString().toLowerCase();
                        event.setItemStack(RSVItem.getItem("ceramic_" + bucketType));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (!event.isCancelled()) {
            Player p = event.getPlayer();

            if (shouldEventBeRan(p)) {
                ItemStack item = event.getItemStack();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).contains("ceramic_") && !RSVItem.getNameFromItem(item).equals("ceramic_bucket")) {
                        event.setItemStack(RSVItem.getItem("ceramic_bucket"));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCauldronFill(CauldronLevelChangeEvent event) {
        if (!event.isCancelled()) {
            Entity e = event.getEntity();
            if (shouldEventBeRan(e)) {
                if (e instanceof Player) {
                    Player player = (Player) e;
                    ItemStack item = player.getInventory().getItemInMainHand();

                    if (RSVItem.isRSVItem(item)) {
                        if (event.getReason() == CauldronLevelChangeEvent.ChangeReason.BUCKET_EMPTY) {
                            if (RSVItem.getNameFromItem(item).contains("ceramic_bucket_")) {
                                player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_bucket"));
                            }
                        }
                    }
                }
            }
        }
    }


    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemSwap(PlayerItemHeldEvent event) {
        if (!event.isCancelled()) {
            Player p = event.getPlayer();
            if (shouldEventBeRan(p)) {
                ItemStack item = p.getInventory().getItem(event.getNewSlot());

                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).equals("ceramic_lava_bucket")) {
                        if (!CeramicBucketMeltTask.hasTask(p.getUniqueId())) {
                            new CeramicBucketMeltTask(plugin, module, p).start();
                        }
                    }
                }
            }
        }
    }
}