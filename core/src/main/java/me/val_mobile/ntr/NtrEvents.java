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
import me.val_mobile.utils.Utils.Hand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
import org.bukkit.block.data.Levelled;
import org.bukkit.configuration.ConfigurationSection;
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
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.scheduler.BukkitRunnable;

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
                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                Block block = event.getBlock();
                Material material = block.getType();

                switch (material.toString()) {
                    case "STONE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.Stone.DisableCobblestoneDrop")) {
                                    if (!block.getDrops(itemMainHand).isEmpty()) {
                                        ConfigurationSection section = config.getConfigurationSection("RockMining.Stone.BlockDrops");
                                        Utils.harvestFortune(section, RSVItem.getItem("stone_rock"), itemMainHand, block.getLocation());
                                    }
                                    event.setDropItems(false);
                                }
                            }
                        }
                        else {
                            event.setDropItems(false);
                        }
                    }
                    case "GRANITE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.Granite.DisableGraniteDrop")) {
                                    if (!block.getDrops(itemMainHand).isEmpty()) {
                                        ConfigurationSection section = config.getConfigurationSection("RockMining.Granite.BlockDrops");
                                        Utils.harvestFortune(section, RSVItem.getItem("granite_rock"), itemMainHand, block.getLocation());
                                    }
                                    event.setDropItems(false);
                                }
                            }
                        }
                        else {
                            event.setDropItems(false);
                        }
                    }
                    case "DIORITE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.Diorite.DisableDioriteDrop")) {
                                    if (!block.getDrops(itemMainHand).isEmpty()) {
                                        ConfigurationSection section = config.getConfigurationSection("RockMining.Diorite.BlockDrops");
                                        Utils.harvestFortune(section, RSVItem.getItem("diorite_rock"), itemMainHand, block.getLocation());
                                    }
                                    event.setDropItems(false);
                                }
                            }
                        }
                        else {
                            event.setDropItems(false);
                        }
                    }
                    case "ANDESITE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.Andesite.DisableAndesiteDrop")) {
                                    if (!block.getDrops(itemMainHand).isEmpty()) {
                                        ConfigurationSection section = config.getConfigurationSection("RockMining.Andesite.BlockDrops");
                                        Utils.harvestFortune(section, RSVItem.getItem("andesite_rock"), itemMainHand, block.getLocation());
                                    }
                                    event.setDropItems(false);
                                }
                            }
                        }
                        else {
                            event.setDropItems(false);
                        }
                    }
                    case "SANDSTONE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.Sandstone.DisableSandstoneDrop")) {
                                    if (!block.getDrops(itemMainHand).isEmpty()) {
                                        ConfigurationSection section = config.getConfigurationSection("RockMining.Sandstone.BlockDrops");
                                        Utils.harvestFortune(section, RSVItem.getItem("sandstone_rock"), itemMainHand, block.getLocation());
                                    }
                                    event.setDropItems(false);
                                }
                            }
                        }
                        else {
                            event.setDropItems(false);
                        }
                    }
                    case "RED_SANDSTONE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.RedSandstone.DisableRedSandstoneDrop")) {
                                    if (!block.getDrops(itemMainHand).isEmpty()) {
                                        ConfigurationSection section = config.getConfigurationSection("RockMining.RedSandstone.BlockDrops");
                                        Utils.harvestFortune(section, RSVItem.getItem("red_sandstone_rock"), itemMainHand, block.getLocation());
                                    }
                                    event.setDropItems(false);
                                }
                            }
                        }
                        else {
                            event.setDropItems(false);
                        }
                    }
                    case "DEEPSLATE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.DisableCobbledDeepslateDrop")) {
                                    event.setDropItems(false);
                                }
                            }
                        }
                    }
                    case "BASALT" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.DisableBasaltDrop")) {
                                    event.setDropItems(false);
                                }
                            }
                        }
                    }
                    case "BLACKSTONE" -> {
                        if (Utils.isItemReal(itemMainHand)) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getBoolean("RockMining.DisableBlackstoneDrop")) {
                                    event.setDropItems(false);
                                }
                            }
                        }
                    }
                }

                if (config.getBoolean("PreventPunchingWood.Enabled")) {
                    if (config.getStringList("PreventPunchingWood.WoodBlocks").contains(material.toString())) {
                        if (!Utils.isHoldingAxe(player)) {
                            event.setDropItems(false);
                        }
                    }
                }

                if (config.getBoolean("PlantFiberGathering.Enabled")) {
                    if (RSVItem.isRSVItem(itemMainHand)) {
                        String name = RSVItem.getNameFromItem(itemMainHand);

                        if (name.contains("dagger") || name.contains("knife")) {
                            if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                                if (config.getConfigurationSection("PlantFiberGathering.BlockDrops").getKeys(false).contains(material.toString())) {
                                    ItemStack plantFiber = RSVItem.getItem("plant_fiber");
                                    Utils.harvestLooting(config.getConfigurationSection("PlantFiberGathering.BlockDrops." + material), plantFiber, itemMainHand, block.getLocation());
                                    Utils.changeDurability(itemMainHand, -1, true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            ItemStack item = event.getItem();
            Action action = event.getAction();
            UUID id = player.getUniqueId();
            Block block = event.getClickedBlock();

            if (action == Action.LEFT_CLICK_BLOCK) {
                Material blockMat = block.getType();
                if (config.getBoolean("FlintKnapping.Enabled")) {
                    if (Utils.isItemReal(item)) {
                        if (item.getType() == Material.FLINT && !RSVItem.isRSVItem(item)) {
                            if (config.getConfigurationSection("FlintKnapping.BlockDrops").getKeys(false).contains(blockMat.toString())) {
                                ItemStack flintShard = moduleItems.getItems().get("flint_shard");

                                if (config.getBoolean("FlintKnapping.BlockDrops." + blockMat + ".Sound.Enabled")) {
                                    Utils.playSound(player.getLocation(), config.getString("FlintKnapping.BlockDrops." + blockMat + ".Sound.Sound"), (float) config.getDouble("FlintKnapping.BlockDrops." + blockMat + ".Sound.Volume"),  (float) config.getDouble("FlintKnapping.BlockDrops." + blockMat + ".Sound.Pitch"));
                                }

                                if (Utils.harvestLooting(config.getConfigurationSection("FlintKnapping.BlockDrops." + blockMat), flintShard, null, block.getLocation().add(0D, 0.15D, 0D))) {
                                    if (item.getAmount() > 0) {
                                        item.setAmount(item.getAmount() - 1);
                                    }
                                    else {
                                        item.setType(Material.AIR);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if (action == Action.RIGHT_CLICK_BLOCK) {
                Material blockMat = block.getType();

                if (Utils.isItemReal(item)) {
                    if (Utils.isHoldingAxe(player)) {
                        if (Tag.LOGS.isTagged(blockMat)) {
                            if (RSVItem.isRSVItem(item)) {
                                if (RSVItem.getNameFromItem(item).contains("mattock")) {
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
                            Location blockLoc = block.getLocation();
                            Location pLoc = player.getLocation();
                            if (Utils.getBlockFace(player) == BlockFace.UP && pLoc.distance(blockLoc) < 1.5D) {
                                if (Math.random() <= config.getDouble("Lumberjack.PlankDrops.Chance")) {

                                    ItemStack drop = new ItemStack(Utils.getRespectivePlank(blockMat));
                                    Utils.harvestFortune(config.getConfigurationSection("Lumberjack.PlankDrops"), drop, event.getItem(), block.getLocation());
                                    block.setType(Material.AIR);
                                    event.setCancelled(true);
                                }
                            }
                        }
                        else if (Tag.PLANKS.isTagged(blockMat)) {
                            if (RSVItem.isRSVItem(item)) {
                                if (RSVItem.getNameFromItem(item).contains("mattock")) {
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
                            Location blockLoc = block.getLocation();
                            Location pLoc = player.getLocation();
                            if (Utils.getBlockFace(player) == BlockFace.UP && pLoc.distance(blockLoc) < 1.5D) {
                                if (Math.random() <= config.getDouble("Lumberjack.StickDrops.Chance")) {

                                    ItemStack drop = new ItemStack(Utils.getRespectivePlank(blockMat));
                                    Utils.harvestFortune(config.getConfigurationSection("Lumberjack.StickDrops"), drop, new ItemStack(Material.STICK), block.getLocation());
                                    block.setType(Material.AIR);
                                    event.setCancelled(true);
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
                        case "copper_mattock", "iron_mattock", "golden_mattock", "diamond_mattock", "netherite_mattock" -> {
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
                                            Utils.changeDurability(item, -1, true);
                                        }
                                        case COARSE_DIRT, PODZOL, MYCELIUM -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.GRASS_PATH);
                                            }
                                            else {
                                                b.setType(Material.DIRT);
                                            }
                                            Utils.changeDurability(item, -1, true);
                                        }
                                        case GRASS_PATH -> {
                                            b.setType(Material.FARMLAND);
                                            Utils.changeDurability(item, -1, true);
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
                                        Utils.changeDurability(item, -1, true);
                                    }
                                }
                                // it is a shovel
                                else if (isNotHoe) {
                                    switch (blockMaterial) {
                                        case GRASS_BLOCK, DIRT -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.FARMLAND);
                                            }
                                            Utils.changeDurability(item, -1, true);
                                        }
                                        case COARSE_DIRT, PODZOL, MYCELIUM -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.DIRT);
                                            }
                                            Utils.changeDurability(item, -1, true);
                                        }
                                        default -> {}
                                    }
                                    // support for rooted dirt
                                    if (blockMaterial.toString().equals("ROOTED_DIRT")) {
                                        if (player.isSneaking()) {
                                            player.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.valueOf("HANGING_ROOTS")));
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1, true);
                                    }
                                }
                                // it is a hoe
                                else {
                                    switch (blockMaterial) {
                                        case GRASS_BLOCK, DIRT, COARSE_DIRT, PODZOL, MYCELIUM -> {
                                            if (player.isSneaking()) {
                                                b.setType(Material.GRASS_PATH);
                                            }
                                            Utils.changeDurability(item, -1, true);
                                        }
                                        default -> {}
                                    }
                                    // support for rooted dirt
                                    if (blockMaterial.toString().equals("ROOTED_DIRT")) {
                                        if (player.isSneaking()) {
                                            b.setType(Material.GRASS_PATH);
                                        }
                                        Utils.changeDurability(item, -1, true);
                                    }
                                }
                            }
                            else if (isNotAxe) {
                                if (Tag.LOGS.isTagged(blockMaterial) && !blockMaterial.toString().contains("STRIPPED")) {
                                    b.setType(Material.valueOf("STRIPPED_" + blockMaterial));
                                    Utils.changeDurability(item, -1, true);
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
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        if (shouldEventBeRan(event.getView().getPlayer())) {
            Recipe recipe = event.getRecipe();

            if (recipe != null) {
                if (recipe instanceof ShapelessRecipe shapeless) {
                    NamespacedKey key = shapeless.getKey();

                    if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                        switch (key.getKey()) {
                            case "acacia_planks", "birch_planks", "crimson_planks", "dark_oak_planks", "jungle_planks", "mangrove_planks", "oak_planks", "spruce_planks", "warped_planks" -> {
                                if (config.getBoolean("Lumberjack.DisablePlankRecipes"))
                                    event.getInventory().setResult(null);
                            }
                            default -> {}
                        }
                    }
                }
                else if (recipe instanceof ShapedRecipe shaped) {
                    NamespacedKey key = shaped.getKey();

                    if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                        switch (key.getKey()) {
                            case "stick" -> {
                                if (config.getBoolean("Lumberjack.DisableStickRecipes"))
                                    event.getInventory().setResult(null);
                            }
                            case "campfire", "soul_campfire" -> {
                                if (config.getBoolean("RemoveVanillaCampfireRecipes.Enabled"))
                                    event.getInventory().setResult(null);
                            }
                            case "flower_pot" -> {
                                if (config.getBoolean("Pottery.RemoveFlowerPotRecipe"))
                                    event.getInventory().setResult(null);
                            }
                            default -> {}
                        }
                    }
                }
            }

            ItemStack[] matrix = event.getInventory().getMatrix();
            int clayToolIndex = -1;
            int clayIndex = -1;
            int sawIndex = -1;
            int woodIndex = -1;
            int planksIndex = -1;

            ItemStack item;
            Material mat;

            for (int i = 0; i < matrix.length; i++) {
                item = matrix[i];
                if (Utils.isItemReal(item)) {
                    mat = item.getType();
                    if (mat == Material.CLAY_BALL) {
                        // -2 means there are more than 1 of each item
                        clayIndex = clayIndex == -1 ? i : -2;
                    }
                    else if (Tag.LOGS.isTagged(mat)) {
                        woodIndex = woodIndex == -1 ? i : -2;
                    }
                    else if (Tag.PLANKS.isTagged(mat)) {
                        planksIndex = planksIndex == -1 ? i : -2;
                    }
                    else if (RSVItem.isRSVItem(item)) {
                        if (RSVItem.getNameFromItem(item).equals("clay_tool")) {
                            clayToolIndex = clayToolIndex == -1 ? i : -2;
                        }
                        if (RSVItem.getNameFromItem(item).contains("saw")) {
                            sawIndex = sawIndex == -1 ? i : -2;
                        }
                    }
                }
            }

            if (config.getBoolean("Pottery.RemoveFlowerPotRecipe") && clayToolIndex > -1 && clayIndex > -1) {
                ItemStack clayTool = matrix[clayToolIndex];
                ItemStack clay = matrix[clayIndex];

                int clayAmount = clay.getAmount();
                int durability = RSVItem.getCustomDurability(clayTool);

                if (durability - clayAmount <= 0) {
                    int dif = clayAmount - RSVItem.getCustomDurability(clayTool);
                    event.getInventory().setResult(RSVItem.getItem("clay_brick").resize(dif));
                }
                else {
                    event.getInventory().setResult(RSVItem.getItem("clay_brick").resize(clayAmount));
                }
            }

            if (config.getBoolean("Lumberjack.EnableSawPlankRecipes") && sawIndex > -1 && woodIndex > -1) {
                ItemStack saw = matrix[sawIndex];
                ItemStack wood = matrix[woodIndex];

                int woodAmount = wood.getAmount();
                int durability = RSVItem.getCustomDurability(saw);

                if (durability - woodAmount <= 0) {
                    int dif = woodAmount - RSVItem.getCustomDurability(saw);
                    event.getInventory().setResult(new ItemStack(Utils.getRespectivePlank(wood.getType()), dif * 4));
                }
                else {
                    event.getInventory().setResult(new ItemStack(Utils.getRespectivePlank(wood.getType()), woodAmount * 4));
                }
            }

            if (config.getBoolean("Lumberjack.EnableSawStickRecipes") && sawIndex > -1 && planksIndex > -1) {
                ItemStack saw = matrix[sawIndex];
                ItemStack planks = matrix[planksIndex];

                int planksAmount = planks.getAmount();
                int durability = RSVItem.getCustomDurability(saw);

                if (durability - planksAmount <= 0) {
                    int dif = planksAmount - RSVItem.getCustomDurability(saw);
                    event.getInventory().setResult(new ItemStack(Material.STICK, dif * 4));
                }
                else {
                    event.getInventory().setResult(new ItemStack(Material.STICK, planksAmount * 4));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBucketFill(PlayerBucketFillEvent event) {
        Player player = event.getPlayer();
        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).equals("ceramic_bucket")) {
                        String bucketType = event.getItemStack().getType().toString().toLowerCase();
                        event.setItemStack(RSVItem.getItem("ceramic_" + bucketType));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!event.isCancelled()) {
            if (shouldEventBeRan(player)) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).equals("ceramic_bucket")) {
                        String entityName = event.getRightClicked().getName();
                        String bucketType;
                        plugin.getLogger().info("Entity Name: " + entityName);
                        switch (entityName) {
                            case "Pufferfish", "Salmon", "Cod", "Tropical Fish", "Axolotl", "Tadpole" -> {
                                bucketType = entityName.toLowerCase() + "_bucket";
                                if (Utils.isItemReal(RSVItem.getItem("ceramic_" + bucketType))) {
                                    player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_" + bucketType));
                                }
                                event.setCancelled(true);
                            }
                            case "Cow" -> {
                                bucketType = "milk_bucket";
                                if (Utils.isItemReal(RSVItem.getItem("ceramic_" + bucketType))) {
                                    player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_" + bucketType));
                                }
                                event.setCancelled(true);
                            }
                        }

                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            if (shouldEventBeRan(player)) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (RSVItem.isRSVItem(item)) {
                    if (RSVItem.getNameFromItem(item).contains("ceramic_")) {
                        event.setItemStack(RSVItem.getItem("ceramic_bucket"));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block block = event.getClickedBlock();

                if (block != null) {
                    ItemStack item = event.getItem();
                    String mat = block.getType().toString();
                    if (RSVItem.isRSVItem(item)) {
                        String rsvName = RSVItem.getNameFromItem(item);
                        switch (mat) {
                            case "CAULDRON" -> {
                                // check for 1.16
                                if (RealisticSurvivalPlugin.getUtil().getMinecraftVersion().contains("1.16")) {
                                    int level = ((Levelled) block.getBlockData()).getLevel();
                                    if (rsvName.equals("ceramic_bucket")) {
                                        if (level >= 3) {
                                            // turn into water ceramic bucket

                                            Hand hand = getHand(player, rsvName);
                                            if (hand != null) {
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        if (hand == Hand.MAIN_HAND)
                                                            player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_water_bucket"));
                                                        else
                                                            player.getInventory().setItemInOffHand(RSVItem.getItem("ceramic_water_bucket"));
                                                    }
                                                }.runTaskLater(plugin, 1L);
                                            }
                                        }
                                    } else if (rsvName.equals("ceramic_water_bucket")) {
                                        if (level <= 0) {
                                            // turn into empty ceramic bucket
                                            Hand hand = getHand(player, rsvName);
                                            if (hand != null) {
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        if (hand == Hand.MAIN_HAND)
                                                            player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_bucket"));
                                                        else
                                                            player.getInventory().setItemInOffHand(RSVItem.getItem("ceramic_bucket"));
                                                    }
                                                }.runTaskLater(plugin, 1L);
                                            }
                                        }
                                    }
                                } else {
                                    if (rsvName.equals("ceramic_water_bucket") || rsvName.equals("ceramic_lava_bucket")) {
                                        // turn into empty ceramic bucket
                                        Hand hand = getHand(player, rsvName);
                                        if (hand != null) {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    if (hand == Hand.MAIN_HAND)
                                                        player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_bucket"));
                                                    else
                                                        player.getInventory().setItemInOffHand(RSVItem.getItem("ceramic_bucket"));
                                                }
                                            }.runTaskLater(plugin, 1L);
                                        }
                                    }
                                }
                            }
                            case "LAVA_CAULDRON" -> {
                                if (rsvName.equals("ceramic_bucket")) {
                                    // turn into lava ceramic bucket
                                    Hand hand = getHand(player, rsvName);
                                    if (hand != null) {
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                if (hand == Hand.MAIN_HAND) {
                                                    player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_lava_bucket"));
                                                    checkAndRunTask(player, player.getInventory().getItemInMainHand());
                                                }
                                                else
                                                    player.getInventory().setItemInOffHand(RSVItem.getItem("ceramic_lava_bucket"));
                                            }
                                        }.runTaskLater(plugin, 1L);
                                    }
                                }
                            }
                            case "WATER_CAULDRON" -> {
                                if (rsvName.equals("ceramic_bucket")) {
                                    // turn into lava ceramic bucket
                                    Hand hand = getHand(player, rsvName);
                                    if (hand != null) {
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                if (hand == Hand.MAIN_HAND)
                                                    player.getInventory().setItemInMainHand(RSVItem.getItem("ceramic_water_bucket"));
                                                else
                                                    player.getInventory().setItemInOffHand(RSVItem.getItem("ceramic_water_bucket"));
                                                plugin.getLogger().info("3");
                                            }
                                        }.runTaskLater(plugin, 1L);
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
    public void onItemHeld(PlayerItemHeldEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            if (shouldEventBeRan(player)) {
                ItemStack item = player.getInventory().getItem(event.getNewSlot());
                checkAndRunTask(player, item);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!event.isCancelled()) {
            if (event.getEntity() instanceof Player player) {
                if (shouldEventBeRan(player)) {
                    ItemStack item = event.getItem().getItemStack();
                    checkAndRunTask(player, item);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        if (!event.isCancelled()) {
            Player player = (Player) event.getWhoClicked();
            if (shouldEventBeRan(player)) {
                ItemStack cursor = event.getCursor();
                InventoryView view = event.getView();
                Inventory top = view.getTopInventory();
                InventoryType type = top.getType();

                int heldSlot = player.getInventory().getHeldItemSlot();
                int slot = event.getSlot();

                if (slot == heldSlot) {
                    checkAndRunTask(player, cursor);
                }

                if (event.isShiftClick()) {
                    if (event.getView().getTopInventory().getType() != InventoryType.PLAYER) {
                        checkAndRunTask(player, event.getCurrentItem());
                    }
                }

                if (type == InventoryType.CRAFTING || type == InventoryType.WORKBENCH) {
                    if (top instanceof CraftingInventory craftInv) {
                        if (event.getRawSlot() == 0) {
                            ItemStack temp = null;
                            ItemStack tool = null;

                            ItemStack[] matrix = craftInv.getMatrix();
                            ItemStack result = craftInv.getResult();

                            boolean hasSaw = false;

                            ItemStack copy = null;

                            if (result != null) {
                                if (Tag.PLANKS.isTagged(result.getType())) {
                                    boolean hasLogs = false;
                                    for (ItemStack itemStack : matrix) {
                                        if (itemStack != null) {
                                            if (Tag.LOGS.isTagged(itemStack.getType())) {
                                                temp = itemStack;
                                                hasLogs = true;
                                            }
                                            if (RSVItem.isRSVItem(itemStack)) {
                                                if (RSVItem.getNameFromItem(itemStack).contains("saw")) {
                                                    tool = itemStack;
                                                    hasSaw = true;
                                                }
                                            }
                                            if (hasSaw && hasLogs) {
                                                int planksAmount = result.getAmount();
                                                int durability = RSVItem.getCustomDurability(tool);

                                                if (durability - planksAmount <= 0) {
                                                    int dif = planksAmount - RSVItem.getCustomDurability(tool);
                                                    Utils.changeDurability(tool, -dif, true);
                                                    temp.setAmount(temp.getAmount() - dif);

                                                    copy = temp;
                                                } else {
                                                    Utils.changeDurability(tool, -temp.getAmount(), true);
                                                    temp.setAmount(0);

                                                    copy = tool;
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                                else if (result.getType() == Material.STICK) {
                                    boolean hasPlanks = false;
                                    for (ItemStack itemStack : matrix) {
                                        if (itemStack != null) {
                                            if (Tag.PLANKS.isTagged(itemStack.getType())) {
                                                temp = itemStack;
                                                hasPlanks = true;
                                            }
                                            if (RSVItem.isRSVItem(itemStack)) {
                                                if (RSVItem.getNameFromItem(itemStack).contains("saw")) {
                                                    tool = itemStack;
                                                    hasSaw = true;
                                                }
                                            }
                                            if (hasSaw && hasPlanks) {
                                                int sticksAmount = result.getAmount();
                                                int durability = RSVItem.getCustomDurability(tool);

                                                if (durability - sticksAmount <= 0) {
                                                    int dif = sticksAmount - RSVItem.getCustomDurability(tool);
                                                    Utils.changeDurability(tool, -dif, true);
                                                    temp.setAmount(temp.getAmount() - dif);

                                                    copy = temp;
                                                } else {
                                                    Utils.changeDurability(tool, -temp.getAmount(), true);
                                                    temp.setAmount(0);

                                                    copy = tool;
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                                else if (RSVItem.isRSVItem(result)) {
                                    if (RSVItem.getNameFromItem(result).equals("clay_brick")) {
                                        boolean hasClayTool = false;
                                        boolean hasClay = false;
                                        for (ItemStack itemStack : matrix) {
                                            if (itemStack != null) {
                                                if (itemStack.getType() == Material.CLAY_BALL) {
                                                    temp = itemStack;
                                                    hasClay = true;
                                                }
                                                if (RSVItem.isRSVItem(itemStack)) {
                                                    if (RSVItem.getNameFromItem(itemStack).equals("clay_tool")) {
                                                        tool = itemStack;
                                                        hasClayTool = true;
                                                    }
                                                }
                                                if (hasClayTool && hasClay) {
                                                    int clayBrickAmount = result.getAmount();
                                                    int durability = RSVItem.hasCustomDurability(tool) ? RSVItem.getCustomDurability(tool) : tool.getType().getMaxDurability() - ((Damageable) tool.getItemMeta()).getDamage();

                                                    if (durability - clayBrickAmount <= 0) {
                                                        int dif = clayBrickAmount - RSVItem.getCustomDurability(tool);
                                                        Utils.changeDurability(tool, -dif, true);
                                                        temp.setAmount(temp.getAmount() - dif);

                                                        copy = temp;
                                                    } else {
                                                        Utils.changeDurability(tool, -temp.getAmount(), true);
                                                        temp.setAmount(0);

                                                        copy = tool;
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if (!(copy == null)) {
                                ItemStack[] contents = player.getInventory().getContents();
                                boolean full = true;
                                for (ItemStack i : contents) {
                                    if (!Utils.isItemReal(i)) {
                                        player.getInventory().addItem(copy);
                                        full = false;
                                        break;
                                    }
                                }

                                if (full) {
                                    player.getWorld().dropItemNaturally(player.getLocation(), copy);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBurn(FurnaceBurnEvent event) {
        if (shouldEventBeRan(event.getBlock().getWorld())) {
            FurnaceInventory inv = ((Furnace) event.getBlock().getState()).getSnapshotInventory();
            ItemStack smeltedItem = inv.getSmelting();

            if (Utils.isItemReal(smeltedItem)) {
                if (smeltedItem.getType() == Material.CLAY_BALL) {
                    if (config.getBoolean("Pottery.RemoveBrickSmeltingRecipe")) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSmelt(FurnaceSmeltEvent event) {
        if (shouldEventBeRan(event.getBlock().getWorld())) {
            if (event.getResult().getType() == Material.BRICK && event.getSource().getType() == Material.CLAY_BALL) {
                if (config.getBoolean("Pottery.RemoveBrickSmeltingRecipe")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemSwap(PlayerSwapHandItemsEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            if (shouldEventBeRan(player)) {
                ItemStack item = event.getOffHandItem();
                checkAndRunTask(player, item);
            }
        }
    }

    private void checkAndRunTask(Player player, ItemStack item) {
        if (RSVItem.isRSVItem(item)) {
            if (RSVItem.getNameFromItem(item).equals("ceramic_lava_bucket")) {
                UUID id = player.getUniqueId();
                if (!CeramicBucketMeltTask.hasTask(id)) {
                    new CeramicBucketMeltTask(plugin, module, player).start();
                }
            }
        }
    }

    private Hand getHand(Player player, String rsvName) {
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack offHand = player.getInventory().getItemInOffHand();

        if (RSVItem.isRSVItem(mainHand)) {
            if (RSVItem.getNameFromItem(mainHand).equals(rsvName)) {
                return Utils.Hand.MAIN_HAND;
            }
        }
        if (RSVItem.isRSVItem(offHand)) {
            if (RSVItem.getNameFromItem(offHand).equals(rsvName)) {
                return Utils.Hand.OFF_HAND;
            }
        }
        return null;
    }
}