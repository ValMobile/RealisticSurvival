/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.utils;

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.ToolHandler.Tool;
import org.bukkit.Material;
import org.bukkit.Tag;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ToolUtils {

    final String[] wood = {"BIRCH", "ACACIA", "OAK", "DARK_OAK", "SPRUCE", "JUNGLE"}; // Crimson and Warped stems are not needed, this is only for old versions
    final String[] weapons = {"BOW", "CROSSBOW", "TRIDENT", "NETHERITE_SWORD", "DIAMOND_SWORD", "GOLDEN_SWORD", "IRON_SWORD", "STONE_SWORD", "WOODEN_SWORD"};
    final String[] instaBreakableByHand = {"COMPARATOR", "REPEATER", "REDSTONE_WIRE", "REDSTONE_TORCH", "REDSTONE_WALL_TORCH", "TORCH", "SOUL_TORCH", "WALL_TORCH", "SOUL_WALL_TORCH",
            "SCAFFOLDING", "SLIME_BLOCK", "HONEY_BLOCK", "TNT", "TRIPWIRE", "TRIPWIRE_HOOK", "GRASS", "TALL_GRASS", "HANGING_ROOTS", "KELP", "NETHER_SPROUTS", "PINK_PETALS", "SPORE_BLOSSOM", "SWEET_BERRY_BUSH`", "PITCHER_PLANT", "PITCHER_POD", "SUGAR_CANE", "LILY_PAD",
            "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING", "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "MANGROVE_PROPAGULE", "CHERRY_SAPLING", "PALE_OAK_SAPLING",
            "BROWN_MUSHROOM", "RED_MUSHROOM", "CRIMSON_FUNGUS", "WARPED_FUNGUS", "CRIMSON_ROOTS", "WARPED_ROOTS", "WEEPING VINES", "TWISTING_VINES",
            "DEAD_BUSH", "WHEAT", "CARROTS", "POTATOES", "BEETROOTS", "PUMPKIN_STEM", "MELON_STEM", "NETHER_WART", "FERN", "LARGE_FERN", "FLOWER_POT", "DECORATED_POT", "FROGSPAWN",
            "AZALEA", "DANDELION", "POPPY", "BLUE_ORCHID", "ALLIUM", "AZURE_BLUET", "RED_TULIP", "ORANGE_TULIP", "WHITE_TULIP", "PINK_TULIP", "OXEYE_DAISY", "CORNFLOWER", "LILY_OF_THE_VALLEY", "WITHER_ROSE", "SUNFLOWER", "LILAC", "ROSE_BUSH", "PEONY",
            "POTTED_DANDELION", "POTTED_POPPY", "POTTED_BLUE_ORCHID", "POTTED_ALLIUM", "POTTED_AZURE_BLUET", "POTTED_RED_TULIP", "POTTED_ORANGE_TULIP", "POTTED_WHITE_TULIP", "POTTED_PINK_TULIP", "POTTED_OXEYE_DAISY", "POTTED_CORNFLOWER", "POTTED_LILY_OF_THE_VALLEY", "POTTED_WITHER_ROSE", "POTTED_SUNFLOWER", "POTTED_LILAC", "POTTED_ROSE_BUSH", "POTTED_PEONY", "POTTED_FERN",
            "TUBE_CORAL", "BRAIN_CORAL", "BUBBLE_CORAL", "FIRE_CORAL", "HORN_CORAL", "DEAD_TUBE_CORAL", "DEAD_BRAIN_CORAL", "DEAD_BUBBLE_CORAL", "DEAD_FIRE_CORAL", "DEAD_HORN_CORAL", "FIRE", "SOUL_FIRE"};

    final String[] hoes = {"NETHERITE_HOE", "DIAMOND_HOE", "GOLDEN_HOE", "IRON_HOE", "STONE_HOE", "WOODEN_HOE"};
    final String[] pickaxes = {"NETHERITE_PICKAXE", "DIAMOND_PICKAXE", "GOLDEN_PICKAXE", "IRON_PICKAXE", "STONE_PICKAXE", "WOODEN_PICKAXE"};
    final String[] axes = {"NETHERITE_AXE", "DIAMOND_AXE", "GOLDEN_AXE", "IRON_AXE", "STONE_AXE", "WOODEN_AXE"};
    final String[] shovels = {"NETHERITE_SHOVEL", "DIAMOND_SHOVEL", "GOLDEN_SHOVEL", "IRON_SHOVEL", "STONE_SHOVEL", "WOODEN_SHOVEL"};
    final String[] swords = {"NETHERITE_SWORD", "DIAMOND_SWORD", "GOLDEN_SWORD", "IRON_SWORD", "STONE_SWORD", "WOODEN_SWORD"};
    final Material[] defaultMats = {
            Material.DIAMOND_PICKAXE,
            Material.DIAMOND_AXE,
            Material.DIAMOND_HOE,
            Material.DIAMOND_SHOVEL,

            Material.GOLDEN_PICKAXE,
            Material.GOLDEN_AXE,
            Material.GOLDEN_HOE,
            Material.GOLDEN_SHOVEL,

            Material.IRON_PICKAXE,
            Material.IRON_AXE,
            Material.IRON_HOE,
            Material.IRON_SHOVEL,

            Material.STONE_PICKAXE,
            Material.STONE_AXE,
            Material.STONE_HOE,
            Material.STONE_SHOVEL,

            Material.WOODEN_PICKAXE,
            Material.WOODEN_AXE,
            Material.WOODEN_HOE,
            Material.WOODEN_SHOVEL,

            Material.SHEARS
    };
    final String[] netheriteTools = {
            "NETHERITE_PICKAXE",
            "NETHERITE_AXE",
            "NETHERITE_HOE",
            "NETHERITE_SHOVEL"
    };

    private final RSVPlugin plugin;
    //final Map<Material,Tool> uToolMap;


    // This is called AFTER BestToolsHandler, so the Utils can affect the Handler
    public ToolUtils(RSVPlugin plugin) {
        this.plugin = Objects.requireNonNull(plugin, "Main must not be null");
        Objects.requireNonNull(plugin.getToolHandler(), "ToolsHandler must be instantiated before ToolUtils!");

        final ToolHandler handler = plugin.getToolHandler();

        // Register valid weapons
        for (String weapon : weapons) {
            if (Material.getMaterial(weapon) != null) {
                handler.weapons.add(Material.getMaterial(weapon));
            }
        }

        // Register all InstaBreaksByHand
        for (String s : instaBreakableByHand) {
            addToMap(s, handler.instaBreakableByHand);
        }

        // Hoes
        for (String s : hoes) {
            addToMap(s, handler.hoes);
        }

        // Pickaxes
        for (String s : pickaxes) {
            addToMap(s, handler.pickaxes);
        }

        // Axes
        for (String s : axes) {
            addToMap(s, handler.axes);
        }

        // Shovels
        for (String s : shovels) {
            addToMap(s, handler.shovels);
        }

        // Swords
        for (String s : swords) {
            addToMap(s, handler.swords);
        }


        handler.allTools.addAll(Arrays.asList(defaultMats));
        for (String s : netheriteTools) {
            if (Material.getMaterial(s) != null) {
                handler.allTools.add(Material.getMaterial(s));
            }
        }

        // 1.17+
        try {
            for (Material mat : v1_17.getPickaxeMaterials()) {
                addToMap(mat, ToolHandler.Tool.PICKAXE);
            }
        } catch (Throwable t) {
            // 1.17+
        }

        //uToolMap = Map.copyOf(main.toolHandler.toolMap); // Java 10+ only
    }

    private void addToMap(String name, List<Material> list) {
        Material mat = Material.getMaterial(name);
        if (mat != null) {
            list.add(mat);
        }
    }

    private void tagToMap(Tag<Material> tag, ToolHandler.Tool tool) {
        tagToMap(Objects.requireNonNull(tag, "Tag must not be null"),
                Objects.requireNonNull(tool, "Tool must not be null"),
                null);
    }

    private void tagToMap(Tag<Material> tag, ToolHandler.Tool tool, String match) {
        Objects.requireNonNull(tag, "Tag must not be null");
        Objects.requireNonNull(tool, "Tool must not be null");
        for (Material mat : tag.getValues()) {
            if (match == null) {
                addToMap(mat, tool);
            } else {
                if (mat.name().contains(match)) {
                    addToMap(mat, tool);
                }
            }
        }
        //usedTags.add(tag);
    }

    private void addToMap(String matName, ToolHandler.Tool tool) {
        Material mat = Material.getMaterial(matName);
        if (mat == null) {
            return;
        }
        addToMap(mat, tool);
    }

    private void addToMap(Material mat, ToolHandler.Tool tool) {
        Objects.requireNonNull(Objects.requireNonNull(plugin.getToolHandler(), "ToolHandler must not be null").
                        toolMap, "ToolMap must not be null")
                .put(Objects.requireNonNull(mat, "Material must not be null"),
                        Objects.requireNonNull(tool, "Tool must not be null"));
    }

    public void initMap() {
        initFallbackMaterials();

        // Tags for 1.13+
        tagToMap(Tag.ANVIL, ToolHandler.Tool.PICKAXE);

        tagToMap(Tag.ICE, ToolHandler.Tool.PICKAXE);
        tagToMap(Tag.LEAVES, ToolHandler.Tool.SHEARS);
        tagToMap(Tag.LOGS, Tool.AXE);
        tagToMap(Tag.PLANKS, Tool.AXE);
        tagToMap(Tag.RAILS, Tool.PICKAXE);
        tagToMap(Tag.WOOL, Tool.SHEARS);

        // WATCH OUT FOR ORDER - START //
        tagToMap(Tag.BUTTONS, Tool.AXE);
        tagToMap(Tag.BUTTONS, Tool.PICKAXE, "STONE");

        tagToMap(Tag.DOORS, Tool.AXE);
        tagToMap(Tag.DOORS, Tool.PICKAXE, "IRON");

        tagToMap(Tag.TRAPDOORS, Tool.AXE);
        tagToMap(Tag.TRAPDOORS, Tool.PICKAXE, "IRON");

        tagToMap(Tag.SLABS, Tool.PICKAXE);
        tagToMap(Tag.WOODEN_SLABS, Tool.AXE);

        tagToMap(Tag.STAIRS, Tool.PICKAXE);
        tagToMap(Tag.WOODEN_STAIRS, Tool.PICKAXE);

        tagToMap(Tag.SAND, Tool.SHOVEL);
        tagToMap(Tag.STONE_BRICKS, Tool.PICKAXE);

        addToMap(Material.SEAGRASS,Tool.SHEARS);
        addToMap(Material.TALL_SEAGRASS,Tool.SHEARS);

        // Tags for 1.14+

        tagToMap(Tag.BAMBOO_PLANTABLE_ON, Tool.SHOVEL);
        tagToMap(Tag.SIGNS, Tool.AXE);
        tagToMap(Tag.WALLS, Tool.PICKAXE);

        tagToMap(Tag.FENCES, Tool.AXE);
        tagToMap(Tag.FENCES, Tool.PICKAXE, "NETHER");
        tagToMap(Tag.FENCES, Tool.PICKAXE, "BRICK");

        for (Material mat : Tag.BAMBOO_PLANTABLE_ON.getValues()) {
            addToMap(mat, Tool.SHOVEL);
        }

        // Tags for 1.15+

        tagToMap(Tag.BEEHIVES, Tool.AXE);
        tagToMap(Tag.SHULKER_BOXES, Tool.PICKAXE);

        // The following kind of unneccessary anyway
        tagToMap(Tag.CROPS, Tool.NONE);
        tagToMap(Tag.FLOWERS, Tool.NONE);

        // Tags for 1.16+

        tagToMap(Tag.CRIMSON_STEMS, Tool.AXE);
        tagToMap(Tag.FENCE_GATES, Tool.AXE);
        tagToMap(Tag.NYLIUM, Tool.PICKAXE);
        // Important order START //
        tagToMap(Tag.PRESSURE_PLATES, Tool.PICKAXE);
        tagToMap(Tag.WOODEN_PRESSURE_PLATES, Tool.AXE);
        // Important order STOP //

        // Stairs in 1.16+
        addToMap(Material.WARPED_STAIRS,Tool.AXE);
        addToMap(Material.CRIMSON_STAIRS,Tool.AXE);

        // Some of the following definitions are redundant because of the tags above
        // However I don't want to miss something, so they are still defined here
        // Shouldn't harm because building the map takes only take 2 ms when the
        // plugin is enabled

        addToMap(Material.BONE_BLOCK, Tool.PICKAXE);

        // Issue #1
        addToMap(Material.BASALT, Tool.PICKAXE);
        addToMap(Material.POLISHED_BASALT, Tool.PICKAXE);
        addToMap(Material.GLOWSTONE, Tool.PICKAXE);
        addToMap(Material.NETHER_GOLD_ORE, Tool.PICKAXE);
        // Issue #1 End

        // Issue #2
        addToMap(Material.SPONGE, Tool.HOE);
        addToMap(Material.WET_SPONGE, Tool.HOE);
        addToMap(Material.PISTON, Tool.PICKAXE);
        addToMap(Material.STICKY_PISTON, Tool.PICKAXE);
        addToMap(Material.PISTON_HEAD, Tool.PICKAXE);
        addToMap(Material.MOVING_PISTON, Tool.PICKAXE);
        addToMap(Material.CHORUS_PLANT, Tool.AXE);
        addToMap(Material.CHORUS_FLOWER, Tool.AXE);
        addToMap(Material.CARVED_PUMPKIN, Tool.AXE);
        addToMap(Material.HAY_BLOCK, Tool.HOE);
        addToMap(Material.OBSERVER, Tool.PICKAXE);
        addToMap(Material.NETHER_WART_BLOCK, Tool.HOE);
        addToMap(Material.WARPED_WART_BLOCK, Tool.HOE);
        addToMap(Material.MAGMA_BLOCK, Tool.PICKAXE);
        // Issue #2 End

        // Issue #3
        addToMap(Material.TARGET, Tool.HOE);
        addToMap(Material.SHROOMLIGHT, Tool.HOE);
        addToMap(Material.BELL, Tool.PICKAXE);
        addToMap(Material.STONECUTTER, Tool.PICKAXE);
        addToMap(Material.SMITHING_TABLE, Tool.AXE);
        addToMap(Material.LECTERN, Tool.AXE);
        addToMap(Material.GRINDSTONE, Tool.PICKAXE);
        addToMap(Material.FLETCHING_TABLE, Tool.AXE);
        addToMap(Material.CARTOGRAPHY_TABLE, Tool.AXE);
        addToMap(Material.BLAST_FURNACE, Tool.PICKAXE);
        addToMap(Material.SMOKER, Tool.PICKAXE);
        addToMap(Material.BARREL, Tool.AXE);
        addToMap(Material.COMPOSTER, Tool.AXE);
        addToMap(Material.LOOM, Tool.AXE);
        addToMap(Material.DRIED_KELP_BLOCK, Tool.HOE);
        // Issue #3 End

        addToMap(Material.ACACIA_BUTTON, Tool.AXE);
        addToMap(Material.ACACIA_FENCE, Tool.AXE);
        addToMap(Material.ACACIA_FENCE_GATE, Tool.AXE);
        addToMap(Material.ACACIA_LEAVES, Tool.SHEARS);
        addToMap(Material.ACACIA_PRESSURE_PLATE, Tool.AXE);
        addToMap(Material.ACACIA_SLAB, Tool.AXE);
        addToMap(Material.ACACIA_STAIRS, Tool.AXE);
        addToMap(Material.ANCIENT_DEBRIS, Tool.PICKAXE);
        addToMap(Material.ANDESITE, Tool.PICKAXE);
        addToMap(Material.BASALT, Tool.PICKAXE);
        addToMap(Material.BIRCH_BUTTON, Tool.AXE);
        addToMap(Material.BIRCH_FENCE, Tool.AXE);
        addToMap(Material.BIRCH_FENCE_GATE, Tool.AXE);
        addToMap(Material.BIRCH_LEAVES, Tool.SHEARS);
        addToMap(Material.BIRCH_PRESSURE_PLATE, Tool.AXE);
        addToMap(Material.BIRCH_SLAB, Tool.AXE);
        addToMap(Material.BIRCH_STAIRS, Tool.AXE);
        addToMap(Material.BLACKSTONE, Tool.PICKAXE);
        addToMap(Material.BLACKSTONE_SLAB, Tool.PICKAXE);
        addToMap(Material.BLACKSTONE_STAIRS, Tool.PICKAXE);
        addToMap(Material.BLACK_CONCRETE, Tool.PICKAXE);
        addToMap(Material.BLACK_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.BLUE_CONCRETE, Tool.PICKAXE);
        addToMap(Material.BLUE_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.BOOKSHELF, Tool.AXE);
        addToMap(Material.BREWING_STAND, Tool.PICKAXE);
        addToMap(Material.BRICKS, Tool.PICKAXE);
        addToMap(Material.BRICK_SLAB, Tool.PICKAXE);
        addToMap(Material.BRICK_STAIRS, Tool.PICKAXE);
        addToMap(Material.BROWN_CONCRETE, Tool.PICKAXE);
        addToMap(Material.BROWN_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.BROWN_MUSHROOM_BLOCK, Tool.AXE);
        addToMap(Material.CAMPFIRE, Tool.AXE);
        addToMap(Material.CAULDRON, Tool.PICKAXE);
        addToMap(Material.CHAIN, Tool.PICKAXE);
        addToMap(Material.CHEST, Tool.AXE);
        addToMap(Material.CHISELED_RED_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.CHISELED_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.CHISELED_STONE_BRICKS, Tool.PICKAXE);
        addToMap(Material.CLAY, Tool.SHOVEL);
        addToMap(Material.COAL_BLOCK, Tool.PICKAXE);
        addToMap(Material.COAL_ORE, Tool.PICKAXE);
        addToMap(Material.COARSE_DIRT, Tool.SHOVEL);
        addToMap(Material.COBBLESTONE, Tool.PICKAXE);
        addToMap(Material.COBBLESTONE_SLAB, Tool.PICKAXE);
        addToMap(Material.COBBLESTONE_STAIRS, Tool.PICKAXE);
        addToMap(Material.COBWEB, Tool.SHEARS);
        addToMap(Material.COCOA, Tool.AXE);
        addToMap(Material.CRACKED_STONE_BRICKS, Tool.PICKAXE);
        addToMap(Material.CRAFTING_TABLE, Tool.AXE);
        addToMap(Material.CRYING_OBSIDIAN, Tool.PICKAXE);
        addToMap(Material.CUT_RED_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.CUT_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.CYAN_CONCRETE, Tool.PICKAXE);
        addToMap(Material.CYAN_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.DARK_OAK_BUTTON, Tool.AXE);
        addToMap(Material.DARK_OAK_FENCE, Tool.AXE);
        addToMap(Material.DARK_OAK_FENCE_GATE, Tool.AXE);
        addToMap(Material.DARK_OAK_LEAVES, Tool.SHEARS);
        addToMap(Material.DARK_OAK_PRESSURE_PLATE, Tool.AXE);
        addToMap(Material.DARK_OAK_SLAB, Tool.AXE);
        addToMap(Material.DARK_OAK_STAIRS, Tool.AXE);
        addToMap(Material.DARK_PRISMARINE, Tool.PICKAXE);
        addToMap(Material.DARK_PRISMARINE_SLAB, Tool.PICKAXE);
        addToMap(Material.DARK_PRISMARINE_STAIRS, Tool.PICKAXE);
        addToMap(Material.DAYLIGHT_DETECTOR, Tool.AXE);
        addToMap(Material.DIAMOND_BLOCK, Tool.PICKAXE);
        addToMap(Material.DIAMOND_ORE, Tool.PICKAXE);
        addToMap(Material.DIORITE, Tool.PICKAXE);
        addToMap(Material.DIRT, Tool.SHOVEL);
        addToMap(Material.DISPENSER, Tool.PICKAXE);
        addToMap(Material.DROPPER, Tool.PICKAXE);
        addToMap(Material.EMERALD_BLOCK, Tool.PICKAXE);
        addToMap(Material.EMERALD_ORE, Tool.PICKAXE);
        addToMap(Material.ENCHANTING_TABLE, Tool.PICKAXE);
        addToMap(Material.ENDER_CHEST, Tool.PICKAXE);
        addToMap(Material.END_STONE, Tool.PICKAXE);
        addToMap(Material.FARMLAND, Tool.SHOVEL);
        addToMap(Material.FURNACE, Tool.PICKAXE);
        addToMap(Material.GILDED_BLACKSTONE, Tool.PICKAXE);
        addToMap(Material.GOLD_BLOCK, Tool.PICKAXE);
        addToMap(Material.GOLD_ORE, Tool.PICKAXE);
        addToMap(Material.GRANITE, Tool.PICKAXE);
        addToMap(Material.GRASS_BLOCK, Tool.SHOVEL);
        addToMap(Material.DIRT_PATH, Tool.SHOVEL);
        addToMap(Material.GRAVEL, Tool.SHOVEL);
        addToMap(Material.GRAY_CONCRETE, Tool.PICKAXE);
        addToMap(Material.GRAY_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.GREEN_CONCRETE, Tool.PICKAXE);
        addToMap(Material.GREEN_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, Tool.PICKAXE);
        addToMap(Material.HOPPER, Tool.PICKAXE);
        addToMap(Material.IRON_BARS, Tool.PICKAXE);
        addToMap(Material.IRON_BLOCK, Tool.PICKAXE);
        addToMap(Material.IRON_DOOR, Tool.PICKAXE);
        addToMap(Material.IRON_ORE, Tool.PICKAXE);
        addToMap(Material.IRON_TRAPDOOR, Tool.PICKAXE);
        addToMap(Material.JACK_O_LANTERN, Tool.AXE);
        addToMap(Material.JUKEBOX, Tool.AXE);
        addToMap(Material.JUNGLE_BUTTON, Tool.AXE);
        addToMap(Material.JUNGLE_FENCE, Tool.AXE);
        addToMap(Material.JUNGLE_FENCE_GATE, Tool.AXE);
        addToMap(Material.JUNGLE_LEAVES, Tool.SHEARS);
        addToMap(Material.JUNGLE_PRESSURE_PLATE, Tool.AXE);
        addToMap(Material.JUNGLE_SLAB, Tool.AXE);
        addToMap(Material.JUNGLE_STAIRS, Tool.AXE);
        addToMap(Material.LADDER, Tool.AXE);
        addToMap(Material.LANTERN, Tool.PICKAXE);
        addToMap(Material.LAPIS_BLOCK, Tool.PICKAXE);
        addToMap(Material.LAPIS_ORE, Tool.PICKAXE);
        addToMap(Material.LIGHT_BLUE_CONCRETE, Tool.PICKAXE);
        addToMap(Material.LIGHT_BLUE_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.LIGHT_GRAY_CONCRETE, Tool.PICKAXE);
        addToMap(Material.LIGHT_GRAY_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.LIGHT_WEIGHTED_PRESSURE_PLATE, Tool.PICKAXE);
        addToMap(Material.LIME_CONCRETE, Tool.PICKAXE);
        addToMap(Material.LIME_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.LODESTONE, Tool.PICKAXE);
        addToMap(Material.MAGENTA_CONCRETE, Tool.PICKAXE);
        addToMap(Material.MAGENTA_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.MELON, Tool.AXE);
        addToMap(Material.MOSSY_COBBLESTONE, Tool.PICKAXE);
        addToMap(Material.MOSSY_STONE_BRICKS, Tool.PICKAXE);
        addToMap(Material.MUSHROOM_STEM, Tool.AXE);
        addToMap(Material.MYCELIUM, Tool.SHOVEL);
        addToMap(Material.NETHERITE_BLOCK, Tool.PICKAXE);
        addToMap(Material.NETHERRACK, Tool.PICKAXE);
        addToMap(Material.NETHER_BRICK, Tool.PICKAXE);
        addToMap(Material.NETHER_BRICK_FENCE, Tool.PICKAXE);
        addToMap(Material.NETHER_BRICK_SLAB, Tool.PICKAXE);
        addToMap(Material.NETHER_BRICK_STAIRS, Tool.PICKAXE);
        addToMap(Material.NETHER_QUARTZ_ORE, Tool.PICKAXE);
        addToMap(Material.NOTE_BLOCK, Tool.AXE);
        addToMap(Material.OAK_BUTTON, Tool.AXE);
        addToMap(Material.OAK_FENCE, Tool.AXE);
        addToMap(Material.OAK_FENCE_GATE, Tool.AXE);
        addToMap(Material.OAK_LEAVES, Tool.SHEARS);
        addToMap(Material.OAK_PRESSURE_PLATE, Tool.AXE);
        addToMap(Material.OAK_SLAB, Tool.AXE);
        addToMap(Material.OAK_STAIRS, Tool.AXE);
        addToMap(Material.OBSIDIAN, Tool.PICKAXE);
        addToMap(Material.ORANGE_CONCRETE, Tool.PICKAXE);
        addToMap(Material.ORANGE_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.PINK_CONCRETE, Tool.PICKAXE);
        addToMap(Material.PINK_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.PODZOL, Tool.SHOVEL);
        addToMap(Material.POLISHED_ANDESITE, Tool.PICKAXE);
        addToMap(Material.POLISHED_DIORITE, Tool.PICKAXE);
        addToMap(Material.POLISHED_GRANITE, Tool.PICKAXE);
        addToMap(Material.PUMPKIN, Tool.AXE);
        addToMap(Material.PURPLE_CONCRETE, Tool.PICKAXE);
        addToMap(Material.PURPLE_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.QUARTZ_BLOCK, Tool.PICKAXE);
        addToMap(Material.QUARTZ_BRICKS, Tool.PICKAXE);
        addToMap(Material.REDSTONE_BLOCK, Tool.PICKAXE);
        addToMap(Material.REDSTONE_ORE, Tool.PICKAXE);
        addToMap(Material.RED_CONCRETE, Tool.PICKAXE);
        addToMap(Material.RED_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.RED_MUSHROOM_BLOCK, Tool.AXE);
        addToMap(Material.RED_NETHER_BRICKS, Tool.PICKAXE);
        addToMap(Material.RED_NETHER_BRICK_SLAB, Tool.PICKAXE);
        addToMap(Material.RED_NETHER_BRICK_STAIRS, Tool.PICKAXE);
        addToMap(Material.RED_SAND, Tool.SHOVEL);
        addToMap(Material.RED_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.RED_SANDSTONE_SLAB, Tool.PICKAXE);
        addToMap(Material.RED_SANDSTONE_STAIRS, Tool.PICKAXE);
        addToMap(Material.RESPAWN_ANCHOR, Tool.PICKAXE);
        addToMap(Material.SAND, Tool.SHOVEL);
        addToMap(Material.SANDSTONE, Tool.PICKAXE);
        addToMap(Material.SANDSTONE_SLAB, Tool.PICKAXE);
        addToMap(Material.SANDSTONE_STAIRS, Tool.PICKAXE);
        addToMap(Material.SEA_LANTERN, Tool.PICKAXE);
        addToMap(Material.SMOOTH_QUARTZ, Tool.PICKAXE);
        addToMap(Material.SMOOTH_RED_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.SMOOTH_SANDSTONE, Tool.PICKAXE);
        addToMap(Material.SMOOTH_STONE, Tool.PICKAXE);
        addToMap(Material.SNOW, Tool.SHOVEL);
        addToMap(Material.SNOW_BLOCK, Tool.SHOVEL);
        addToMap(Material.SOUL_CAMPFIRE, Tool.AXE);
        addToMap(Material.SOUL_LANTERN, Tool.PICKAXE);
        addToMap(Material.SOUL_SAND, Tool.SHOVEL);
        addToMap(Material.SOUL_SOIL, Tool.SHOVEL);
        addToMap(Material.SPAWNER, Tool.PICKAXE);
        addToMap(Material.SPRUCE_BUTTON, Tool.AXE);
        addToMap(Material.SPRUCE_FENCE, Tool.AXE);
        addToMap(Material.SPRUCE_FENCE_GATE, Tool.AXE);
        addToMap(Material.SPRUCE_LEAVES, Tool.SHEARS);
        addToMap(Material.SPRUCE_PRESSURE_PLATE, Tool.AXE);
        addToMap(Material.SPRUCE_STAIRS, Tool.AXE);
        addToMap(Material.STONE, Tool.PICKAXE);
        addToMap(Material.STONE_BRICKS, Tool.PICKAXE);
        addToMap(Material.STONE_BRICK_SLAB, Tool.PICKAXE);
        addToMap(Material.STONE_BRICK_STAIRS, Tool.PICKAXE);
        addToMap(Material.STONE_BUTTON, Tool.PICKAXE);
        addToMap(Material.STONE_PRESSURE_PLATE, Tool.PICKAXE);
        addToMap(Material.STONE_SLAB, Tool.PICKAXE);
        addToMap(Material.TERRACOTTA, Tool.PICKAXE);
        addToMap(Material.TRAPPED_CHEST, Tool.AXE);
        addToMap(Material.VINE, Tool.SHEARS);
        addToMap(Material.WHITE_CONCRETE, Tool.PICKAXE);
        addToMap(Material.WHITE_CONCRETE_POWDER, Tool.SHOVEL);
        addToMap(Material.YELLOW_CONCRETE, Tool.PICKAXE);
        addToMap(Material.YELLOW_CONCRETE_POWDER, Tool.SHOVEL);

        try {
            for (Material mat : Material.values()) {
                String n = mat.name();
                if (n.contains("AMETHYST")) {
                    addToMap(n, Tool.PICKAXE);
                }
                if (n.endsWith("_ORE")) {
                    addToMap(n, Tool.PICKAXE);
                }
                if (n.contains("BASALT")) {
                    addToMap(n, Tool.PICKAXE);
                }
                if (n.contains("DEEPSLATE")) {
                    addToMap(n, Tool.PICKAXE);
                }
                if (n.contains("SCULK")) {
                    addToMap(n, Tool.HOE);
                }
                if (n.contains("BAMBOO")){
                    addToMap(n, Tool.AXE);
                }
            }
            addToMap(Material.GLOW_LICHEN, Tool.SHEARS);
            addToMap(Material.CALCITE, Tool.PICKAXE);
            addToMap(Material.ROOTED_DIRT, Tool.SHOVEL);
            addToMap("MANGROVE_ROOTS", Tool.AXE);
            addToMap("MUDDY_MANGROVE_ROOTS", Tool.SHOVEL);
            addToMap("MUD", Tool.SHOVEL);
            addToMap("PACKED_MUD", Tool.PICKAXE);
            addToMap("CHISELED_BOOKSHELF", Tool.AXE);

        } catch (Throwable ignored) {}


    }

    // Spigot API is not "forward compatible" with new Material enums
    private void initFallbackMaterials() {

        for (Material mat : Material.values()) {

            if (!mat.isBlock()) {
                continue;
            }

            String n = mat.name();

            if (n.contains("GLASS")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }

            // Fallback for all wooden things
            for (String woodType : wood) {
                if (n.contains(woodType)) {
                    if (n.contains("STAIRS") || n.contains("LOG") || n.contains("PLANK")) {
                        addToMap(mat, Tool.AXE);
                        continue;
                    }
                }
            }

            // Fallback for Tag.WALLS
            if (n.contains("STONE") || n.contains("BRICK")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            // End Tag.WALLS

            // Issue #1
            if (n.contains("BLACKSTONE")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("NETHER_BRICK")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            // Issue #1 End

            // Issue #2
            if (n.contains("TERRACOTTA")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("PURPUR")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("INFESTED")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("ENDSTONE_BRICK")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("QUARTZ")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("CORAL_BLOCK")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            if (n.contains("PRISMARINE")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            // Issue #2 End

            // Tags only in 1.16+ START
            if (n.contains("FENCE_GATE")) {
                addToMap(mat, Tool.AXE);
                continue;
            }
            if (n.contains("PRESSURE_PLATE")) {
                if (n.contains("STONE") || n.contains("IRON") || n.contains("GOLD")) {
                    addToMap(mat, ToolHandler.Tool.PICKAXE);
                    continue;
                }
                addToMap(mat, Tool.AXE);
                continue;
            }
            // Tags only in 1.16+ END

            // Tags only in 1.15+ START
            if (n.contains("SHULKER_BOX")) {
                addToMap(mat, ToolHandler.Tool.PICKAXE);
                continue;
            }
            // Tags only in 1.15+ END

            // Tags only in 1.14+ START
            if (n.contains("FENCE")) {
                if (n.contains("NETHER") || n.contains("BRICK")) {
                    addToMap(mat, ToolHandler.Tool.PICKAXE);
                    continue;
                }
                addToMap(mat, ToolHandler.Tool.AXE);
                continue;
            }
            if (n.contains("SIGN")) {
                addToMap(mat, ToolHandler.Tool.AXE);
                continue;
            }
            // Tags only in 1.14+ END

            // Different item names < 1.13
            if (n.equals("LEAVES") || n.equals("WOOL")) {
                addToMap(mat, ToolHandler.Tool.SHEARS);
                continue;
            }
            if (n.equals("WORKBENCH")) {
                addToMap(mat, ToolHandler.Tool.AXE);
            }
        }

    }
}
