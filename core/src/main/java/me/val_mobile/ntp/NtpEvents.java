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
package me.val_mobile.ntp;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.ModuleItems;
import me.val_mobile.misc.PlayerItemAcquireEvent;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.ToolHandler.Tool;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
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
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class NtpEvents extends ModuleEvents implements Listener {

    private final FileConfiguration config;
    private final ModuleItems moduleItems;
    private final NtpModule module;
    private final RSVPlugin plugin;

    public NtpEvents(NtpModule module, RSVPlugin plugin) {
        super(module, plugin);
        this.module = module;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.moduleItems = module.getModuleItems();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!shouldEventBeRan(player))
            return;

        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        Block block = event.getBlock();
        Material material = block.getType();

        if (config.getBoolean("PreventPunchingWood.Enabled") && Utils.matchMaterial(material, config.getStringList("PreventPunchingWood.WoodBlocks"), false) && !Utils.isHoldingAxe(player)) {
            event.setDropItems(false);
        }

        if (config.getBoolean("PlantFiberGathering.Enabled") && RSVItem.isRSVItem(itemMainHand)) {
            String name = RSVItem.getNameFromItem(itemMainHand);

            if (name.contains("dagger") || name.contains("knife")) {
                if (!itemMainHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                    if (Utils.matchMaterial(material, config.getConfigurationSection("PlantFiberGathering.BlockDrops").getKeys(false), true)) {
                        ItemStack plantFiber = RSVItem.getItem("plant_fiber");
                        Utils.changeDurability(itemMainHand, -1, true, true, player); // required since instant-mineable blocks do not decrease durability
                        Utils.dropLooting(config.getConfigurationSection("PlantFiberGathering.BlockDrops." + material), plantFiber, itemMainHand, block.getLocation(), true);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!shouldEventBeRan(player))
            return;

        ItemStack item = event.getItem();
        Action action = event.getAction();
        UUID id = player.getUniqueId();
        Block block = event.getClickedBlock();

        if (action == Action.LEFT_CLICK_BLOCK) {
            Material blockMat = block.getType();
            if (config.getBoolean("FlintKnapping.Enabled") && Utils.isItemReal(item) && item.getType() == Material.FLINT && !RSVItem.isRSVItem(item) && config.getConfigurationSection("FlintKnapping.BlockDrops").getKeys(false).contains(blockMat.toString())) {
                ItemStack flintShard = moduleItems.getItems().get("flint_shard");

                if (config.getBoolean("FlintKnapping.BlockDrops." + blockMat + ".Sound.Enabled")) {
                    Utils.playSound(player.getLocation(), config.getString("FlintKnapping.BlockDrops." + blockMat + ".Sound.Sound"), (float) config.getDouble("FlintKnapping.BlockDrops." + blockMat + ".Sound.Volume"),  (float) config.getDouble("FlintKnapping.BlockDrops." + blockMat + ".Sound.Pitch"));
                }

                if (Utils.dropLooting(config.getConfigurationSection("FlintKnapping.BlockDrops." + blockMat), flintShard, null, block.getLocation().add(0D, 0.15D, 0D), true)) {
                    if (item.getAmount() > 0) {
                        item.setAmount(item.getAmount() - 1);
                    }
                    else {
                        item.setType(Material.AIR);
                    }
                }
            }
        }
        else if (action == Action.RIGHT_CLICK_BLOCK) {
            Material blockMat = block.getType();

            if (Utils.isItemReal(item) && Utils.isHoldingAxe(player)) {
                if (Tag.LOGS.isTagged(blockMat) || (blockMat.toString().equals("BAMBOO_BLOCK") || blockMat.toString().equals("STRIPPED_BAMBOO_BLOCK"))) {
                    if (RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).contains("mattock")) {
                        Tool tool = Utils.getBestTool(blockMat);

                        switch (tool) {
                            case NONE, SHEARS -> {}
                            default -> {
                                String type = item.getType().toString();
                                item.setType(Material.valueOf(type.substring(0, type.indexOf("_") + 1) + tool));
                            }
                        }
                    }
                    Location blockLoc = block.getLocation();
                    Location pLoc = player.getLocation();
                    if (Utils.getBlockFace(player) == BlockFace.UP && pLoc.distanceSquared(blockLoc) < 2.25D && Utils.roll(config.getDouble("Lumberjack.PlankDrops.Chance"))) {
                        ItemStack drop = new ItemStack(Utils.getRespectivePlank(blockMat));
                        Utils.dropFortune(config.getConfigurationSection("Lumberjack.PlankDrops"), drop, event.getItem(), block.getLocation());
                        block.setType(Material.AIR);
                        event.setCancelled(true);
                    }
                }
                else if (Tag.PLANKS.isTagged(blockMat)) {
                    if (RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).contains("mattock")) {
                        Tool tool = Utils.getBestTool(blockMat);

                        switch (tool) {
                            case NONE, SHEARS -> {}
                            default -> {
                                String type = item.getType().toString();
                                item.setType(Material.valueOf(type.substring(0, type.indexOf("_") + 1) + tool));
                            }
                        }
                    }
                    Location blockLoc = block.getLocation();
                    Location pLoc = player.getLocation();
                    if (Utils.getBlockFace(player) == BlockFace.UP && pLoc.distanceSquared(blockLoc) < 2.25D && Utils.roll(config.getDouble("Lumberjack.StickDrops.Chance"))) {
                        Utils.dropFortune(config.getConfigurationSection("Lumberjack.StickDrops"), new ItemStack(Material.STICK), item, block.getLocation());
                        block.setType(Material.AIR);
                        event.setCancelled(true);
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

                        if (Tag.LOGS.isTagged(blockMaterial) && !blockMaterial.toString().contains("STRIPPED") && isNotAxe) {
                            Utils.playSound(player.getLocation(), Sound.ITEM_AXE_STRIP.toString(), 1.0f, 1.0f);
                            b.setType(Material.valueOf("STRIPPED_" + blockMaterial));
                            Utils.changeDurability(item, -1, true, true, player);
                        }
                        else if (isNotHoe || isNotShovel) {
                            if (isNotHoe && isNotShovel) {
                                switch (blockMaterial) {
                                    case GRASS_BLOCK, DIRT -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_SHOVEL_FLATTEN.toString(), 1.0f, 1.0f);
                                            b.setType(Material.DIRT_PATH);
                                        }
                                        else {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_HOE_TILL.toString(), 1.0f, 1.0f);
                                            b.setType(Material.FARMLAND);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    case COARSE_DIRT, PODZOL, MYCELIUM -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_SHOVEL_FLATTEN.toString(), 1.0f, 1.0f);
                                            b.setType(Material.DIRT_PATH);
                                        }
                                        else {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_HOE_TILL.toString(), 1.0f, 1.0f);
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    case DIRT_PATH -> {
                                        Utils.playSound(player.getLocation(), Sound.ITEM_HOE_TILL.toString(), 1.0f, 1.0f);
                                        b.setType(Material.FARMLAND);
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    case ROOTED_DIRT -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_SHOVEL_FLATTEN.toString(), 1.0f, 1.0f);
                                            b.setType(Material.DIRT_PATH);
                                        }
                                        else {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_HOE_TILL.toString(), 1.0f, 1.0f);
                                            player.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.HANGING_ROOTS));
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    default -> {}
                                }
                            }
                            // it is a shovel
                            else if (isNotHoe) {
                                switch (blockMaterial) {
                                    case GRASS_BLOCK, DIRT -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_HOE_TILL.toString(), 1.0f, 1.0f);
                                            b.setType(Material.FARMLAND);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    case COARSE_DIRT, PODZOL, MYCELIUM -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_SHOVEL_FLATTEN.toString(), 1.0f, 1.0f);
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    case ROOTED_DIRT -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_HOE_TILL.toString(), 1.0f, 1.0f);
                                            player.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.HANGING_ROOTS));
                                            b.setType(Material.DIRT);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    default -> {}
                                }
                            }
                            // it is a hoe
                            else {
                                switch (blockMaterial) {
                                    case GRASS_BLOCK, DIRT, COARSE_DIRT, PODZOL, MYCELIUM, ROOTED_DIRT -> {
                                        if (player.isSneaking()) {
                                            Utils.playSound(player.getLocation(), Sound.ITEM_SHOVEL_FLATTEN.toString(), 1.0f, 1.0f);
                                            b.setType(Material.DIRT_PATH);
                                        }
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                    default -> {}
                                }
                            }
                        }

                    }
                    case "fire_starter" -> {
                        if (config.getBoolean("FireStarter.Enabled") && player.isSneaking()) {
                            double maxDistance = config.getDouble("FireStarter.MaxDistance");

                            boolean needsFuel = config.getBoolean("FireStarter.Fuel.Required");
                            boolean needsKindling = config.getBoolean("FireStarter.Kindling.Required");

                            int requiredFuel = needsFuel ? config.getInt("FireStarter.Fuel.Amount") : 0;
                            int requiredKindling = needsKindling ? config.getInt("FireStarter.Kindling.Amount") : 0;
                            int requiredSoulItems = config.getInt("FireStarter.SoulItems.Amount");

                            int fuel = 0;
                            int kindling = 0;
                            int soul = 0;

                            List<Material> fuelMats = Utils.getMaterialsFromList(config.getStringList("FireStarter.Fuel.Materials"));
                            List<Material> kindlingMats = Utils.getMaterialsFromList(config.getStringList("FireStarter.Kindling.Materials"));
                            List<Material> soulMats = Utils.getMaterialsFromList(config.getStringList("FireStarter.SoulItems.Materials"));

                            Location loc = block.getLocation();
                            if (!block.isPassable()) {
                                loc.setY(loc.getY() + 1);
                            }

                            Predicate<Entity> filter = entity -> entity instanceof Item;
                            Collection<Entity> entities = loc.getWorld().getNearbyEntities(loc, maxDistance, maxDistance, maxDistance, filter);

                            Collection<Item> ingredients = new ArrayList<>();

                            if (entities.size() <= config.getInt("FireStarter.MaxItems")) {
                                for (Entity e : entities) {
                                    Item i = (Item) e;
                                    ItemStack drop = i.getItemStack();
                                    Material mat = drop.getType();

                                    if (needsFuel) {
                                        if (fuelMats.contains(mat)) {
                                            fuel += drop.getAmount();
                                            ingredients.add(i);
                                        }
                                    }
                                    if (needsKindling) {
                                        if (kindlingMats.contains(mat)) {
                                            kindling += drop.getAmount();
                                            ingredients.add(i);
                                        }
                                    }

                                    if (soulMats.contains(mat)) {
                                        soul += drop.getAmount();
                                        ingredients.add(i);
                                    }
                                }

                                if (fuel >= requiredFuel && kindling >= requiredKindling) {
                                    if (!FireStarterTask.hasTask(id)) {
                                        new FireStarterTask(plugin, module, player, loc.add(0D, 0.6D, 0D), ingredients, soul >= requiredSoulItems).start();
                                        Utils.changeDurability(item, -1, true, true, player);
                                    }
                                }
                            }
                        }
                    }
                    default -> {}
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockDamage(BlockDamageEvent event) {
        Player player = event.getPlayer();

        if (!shouldEventBeRan(player))
            return;

        ItemStack item = event.getItemInHand();

        if (!(RSVItem.isRSVItem(item) && RSVItem.getModuleNameFromItem(item).equals(NtpModule.NAME) && RSVItem.getNameFromItem(item).contains("mattock")))
            return;

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

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        Recipe recipe = event.getRecipe();

        if (!shouldEventBeRan(event.getView().getPlayer()))
            return;

        if (recipe != null) {
            if (recipe instanceof ShapelessRecipe shapeless) {
                NamespacedKey key = shapeless.getKey();

                if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                    switch (key.getKey()) {
                        case "acacia_planks", "birch_planks", "crimson_planks", "dark_oak_planks", "jungle_planks", "mangrove_planks", "oak_planks", "spruce_planks", "warped_planks", "cherry_planks", "bamboo_planks" -> {
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
                            if (config.getBoolean("FireStarter.DisableVanillaCampfireRecipes"))
                                event.getInventory().setResult(null);
                        }
                        case "flower_pot" -> {
                            if (config.getBoolean("Pottery.DisableFlowerPotRecipe"))
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

        if (config.getBoolean("Pottery.DisableFlowerPotRecipe") && clayToolIndex > -1 && clayIndex > -1) {
            ItemStack clayTool = matrix[clayToolIndex];
            ItemStack clay = matrix[clayIndex];

            int clayAmount = clay.getAmount();
            int durability = Utils.getCustomDurability(clayTool);

            ItemStack clayBrick = RSVItem.getItem("clay_brick");

            clayBrick.setAmount(durability - clayAmount < 0 ? durability : clayAmount);

            event.getInventory().setResult(clayBrick);
        }

        if (config.getBoolean("Lumberjack.EnableSawPlankRecipes") && sawIndex > -1 && woodIndex > -1) {
            ItemStack saw = matrix[sawIndex];
            ItemStack wood = matrix[woodIndex];

            int woodAmount = wood.getAmount();
            int durability = Utils.getCustomDurability(saw);

            if (durability - woodAmount < 0) {
                event.getInventory().setResult(new ItemStack(Utils.getRespectivePlank(wood.getType()), durability * 4));
            }
            else {
                event.getInventory().setResult(new ItemStack(Utils.getRespectivePlank(wood.getType()), woodAmount * 4));
            }
        }

        if (config.getBoolean("Lumberjack.EnableSawStickRecipes") && sawIndex > -1 && planksIndex > -1) {
            ItemStack saw = matrix[sawIndex];
            ItemStack planks = matrix[planksIndex];

            int planksAmount = planks.getAmount();
            int durability = Utils.getCustomDurability(saw);

            if (durability - planksAmount < 0) {
                event.getInventory().setResult(new ItemStack(Material.STICK, durability * 4));
            }
            else {
                event.getInventory().setResult(new ItemStack(Material.STICK, planksAmount * 4));
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        InventoryView view = event.getView();
        Inventory top = view.getTopInventory();
        InventoryType type = top.getType();

        if (!(shouldEventBeRan(player) && (type == InventoryType.CRAFTING || type == InventoryType.WORKBENCH) && top instanceof CraftingInventory craftInv && event.getRawSlot() == 0))
            return;

        ItemStack temp = null;
        ItemStack tool = null;

        ItemStack[] matrix = craftInv.getMatrix();
        ItemStack result = craftInv.getResult();

        boolean hasSaw = false;

        ItemStack copy = null;

        if (Utils.isItemReal(result)) {
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
                            int durability = Utils.getCustomDurability(tool);

                            if (durability - temp.getAmount() < 0) {
                                Utils.changeDurability(tool, -durability, true, true, player);
                                temp.setAmount(temp.getAmount() - durability);

                            } else {
                                Utils.changeDurability(tool, -temp.getAmount(), true, true, player);
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
                    if (!Utils.isItemReal(itemStack))
                        continue;

                    if (Tag.PLANKS.isTagged(itemStack.getType())) {
                        temp = itemStack;
                        hasPlanks = true;
                    }
                    if (RSVItem.isRSVItem(itemStack) && RSVItem.getNameFromItem(itemStack).contains("saw")) {
                        tool = itemStack;
                        hasSaw = true;
                    }
                    if (hasSaw && hasPlanks) {
                        int durability = Utils.getCustomDurability(tool);

                        if (durability - temp.getAmount() < 0) {
                            Utils.changeDurability(tool, -durability, true, true, player);
                            temp.setAmount(temp.getAmount() - durability);

                        } else {
                            Utils.changeDurability(tool, -temp.getAmount(), true, true, player);
                            temp.setAmount(0);

                            copy = tool;
                        }
                        break;
                    }
                }
            }
            else if (RSVItem.isRSVItem(result) && RSVItem.getNameFromItem(result).equals("clay_brick")) {
                boolean hasClayTool = false;
                boolean hasClay = false;
                for (ItemStack itemStack : matrix) {
                    if (!Utils.isItemReal(itemStack))
                        continue;

                    if (itemStack.getType() == Material.CLAY_BALL) {
                        temp = itemStack;
                        hasClay = true;
                    }
                    if (RSVItem.isRSVItem(itemStack) && RSVItem.getNameFromItem(itemStack).equals("clay_tool")) {
                        tool = itemStack;
                        hasClayTool = true;
                    }
                    if (hasClayTool && hasClay) {
                        int durability = Utils.hasCustomDurability(tool) ? Utils.getCustomDurability(tool) : tool.getType().getMaxDurability() - ((Damageable) tool.getItemMeta()).getDamage();

                        if (durability - temp.getAmount() < 0) {
                            Utils.changeDurability(tool, -durability, true, true, player);
                            temp.setAmount(temp.getAmount() - durability);

                        } else {
                            Utils.changeDurability(tool, -temp.getAmount(), true, true, player);
                            temp.setAmount(0);

                            copy = tool;
                        }
                        break;
                    }
                }
            }
        }

        if (Utils.isItemReal(copy)) {
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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBurn(FurnaceBurnEvent event) {
        if (!shouldEventBeRan(event.getBlock().getWorld()))
            return;

        FurnaceInventory inv = ((Furnace) event.getBlock().getState()).getSnapshotInventory();
        ItemStack smeltedItem = inv.getSmelting();

        if (Utils.isItemReal(smeltedItem) && smeltedItem.getType() == Material.CLAY_BALL && config.getBoolean("Pottery.DisableBrickSmeltingRecipe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSmelt(FurnaceSmeltEvent event) {
        if (!(shouldEventBeRan(event.getBlock().getWorld())))
            return;

        if (event.getResult().getType() == Material.BRICK && event.getSource().getType() == Material.CLAY_BALL && config.getBoolean("Pottery.DisableBrickSmeltingRecipe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucketInteract(PlayerItemAcquireEvent event) {
        ItemStack origItem = event.getOriginalItem();

        if (!(RSVItem.isRSVItem(origItem) && RSVItem.getNameFromItem(origItem).contains("ceramic_")))
            return;

        switch (event.getCause()) {
            case BUCKET_EMPTY, BUCKET_FILL_LIQUID, BUCKET_FILL_MOB, FOOD_CONSUME -> {}
            default -> {
                return;
            }
        }

        Player player = event.getPlayer();
        ItemStack result = event.getItem();

        String realResultName = "ceramic_" + result.getType().toString().toLowerCase();

        ItemStack realResult = RSVItem.getItem(realResultName);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (event.getLocation() == EquipmentSlot.HAND)
                    player.getInventory().setItemInMainHand(realResult);
                else if (event.getLocation() == EquipmentSlot.OFF_HAND)
                    player.getInventory().setItemInOffHand(realResult);

                if (realResultName.equals("ceramic_lava_bucket") && !CeramicBucketMeltTask.hasTask(player.getUniqueId())) {
                    new CeramicBucketMeltTask(plugin, module, player).start();
                }
            }
        }.runTaskLater(plugin, 1L);
    }

    @EventHandler
    public void onBucketClick(PlayerItemAcquireEvent event) {
        ItemStack item = event.getItem();

        if (!(RSVItem.isRSVItem(item) && RSVItem.getNameFromItem(item).equals("ceramic_lava_bucket")))
            return;

        if (!(event.getLocation() == EquipmentSlot.HAND || event.getLocation() == EquipmentSlot.OFF_HAND)) {
            return;
        }

        new CeramicBucketMeltTask(plugin, module, event.getPlayer()).start();
    }
}