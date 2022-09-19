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

            if (config.getBoolean("FlintKnapping.Enabled")) {
                if (Utils.isItemReal(item)) {
                    if (item.getType() == Material.FLINT && action == Action.LEFT_CLICK_BLOCK) {
                        Block block = event.getClickedBlock();
                        Material material = block.getType();

                        if (config.getConfigurationSection("FlintKnapping.BlockDrops").getKeys(false).contains(material.toString())) {
                            ItemStack flintShard = moduleItems.getItems().get("flint_shard");

                            Utils.harvestLooting(config.getConfigurationSection("FlintKnapping.BlockDrops." + material), flintShard, null, block.getLocation().add(0D, 0.15D, 0D));

                            if (config.getBoolean("FlintKnapping.BlockDrops." + material + ".Sound.Enabled")) {
                                Utils.playSound(player.getLocation(), config.getString("FlintKnapping.BlockDrops." + material + ".Sound.Sound"), (float) config.getDouble("FlintKnapping.BlockDrops." + material + ".Sound.Volume"),  (float) config.getDouble("FlintKnapping.BlockDrops." + material + ".Sound.Pitch"));
                            }
                        }
                    }
                }
            }
            if (config.getBoolean("RemoveVanillaPlankRecipes.Enabled")) {
                if (Utils.isItemReal(item)) {
                    if (Utils.isHoldingAxe(player) && action == Action.RIGHT_CLICK_BLOCK) {
                        Block block = event.getClickedBlock();
                        Material mat = block.getType();
                        if (Tag.LOGS.isTagged(mat)) {
                            Location blockLoc = block.getLocation();
                            Location pLoc = player.getLocation();
                            if (Utils.getBlockFace(player) == BlockFace.UP && Math.abs(pLoc.getY() - blockLoc.getY()) < 1D && pLoc.distance(blockLoc) < 1D) {
                                if (Math.random() <= config.getDouble("RemoveVanillaPlankRecipes.AxePlankChance")) {
                                    ItemStack drop = new ItemStack(Material.valueOf(mat.toString().replace("LOG", "PLANKS")));
                                    Utils.harvestFortune(config.getConfigurationSection("RemoveVanillaPlankRecipes.BlockDrops"), drop, event.getItem(), block.getLocation());
                                }
                            }
                        }
                    }
                }
            }
            if (config.getBoolean("RemoveVanillaCampfireRecipes.Enabled")) {
                if (RSVItem.isRSVItem(item) && action == Action.RIGHT_CLICK_BLOCK) {
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
                            Material material = item.getType();

                            Block block = event.getBlock();
                            Material blockMat = block.getType();

//                            if (!block.(item)) {
                                // TODO: Add mattock code from https://github.com/JEFF-Media-GbR/Spigot-BestTools/blob/a5c333622f727bc5d7839e1faec3c46e6793a1b4/src/main/java/de/jeff_media/BestTools/BestToolsHandler.java#L116
//                            }
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
                                default -> {
                                }
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
                                default -> {
                                }
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
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBucketFill(PlayerBucketFillEvent event) {
        Player p = event.getPlayer();

        if (shouldEventBeRan(p)) {
            ItemStack item = event.getItemStack();
            if (RSVItem.isRSVItem(item)) {
                if (RSVItem.getNameFromItem(item).equals("ceramic_bucket")) {
                    String bucketType = event.getBucket().toString().toLowerCase();
                    RSVItem.addNbtTag(item, "rsvitem", "ceramic_" + bucketType, PersistentDataType.STRING);
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
                        RSVItem.addNbtTag(item, "rsvitem", "ceramic_bucket", PersistentDataType.STRING);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCauldronFill(CauldronLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            ItemStack item = ((Player) event.getEntity()).getInventory().getItemInMainHand();

            if (RSVItem.isRSVItem(item)) {
                if (event.getReason() == CauldronLevelChangeEvent.ChangeReason.BUCKET_EMPTY) {
                    if (RSVItem.getNameFromItem(item).contains("ceramic_bucket_")) {
                        RSVItem.addNbtTag(item, "rsvitem", "ceramic_bucket", PersistentDataType.STRING);
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

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!event.isCancelled()) {
            Entity e = event.getEntity();
            if (e instanceof Player) {
                if (shouldEventBeRan(e)) {
                    Player p = (Player) e;
                    ItemStack item = event.getItem().getItemStack();

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
}