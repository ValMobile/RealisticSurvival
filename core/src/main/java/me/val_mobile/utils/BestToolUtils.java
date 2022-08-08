package me.val_mobile.utils;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Material;
import org.bukkit.Tag;

import java.util.Objects;

public class BestToolUtils {

    final String[] wood = {"BIRCH", "ACACIA", "OAK", "DARK_OAK", "SPRUCE", "JUNGLE"}; // Crimson and Warped stems are not needed, this is only for old versions
    final String[] weapons = {"BOW", "CROSSBOW", "TRIDENT", "NETHERITE_SWORD", "DIAMOND_SWORD", "GOLDEN_SWORD", "IRON_SWORD", "STONE_SWORD", "WOODEN_SWORD"};
    final String[] instaBreakableByHand = {"COMPARATOR", "REPEATER", "REDSTONE_WIRE", "REDSTONE_TORCH", "REDSTONE_WALL_TORCH", "TORCH", "SOUL_TORCH", "WALL_TORCH", "SOUL_WALL_TORCH",
            "SCAFFOLDING", "SLIME_BLOCK", "HONEY_BLOCK", "TNT", "TRIPWIRE", "TRIPWIRE_HOOK", "GRASS", "SUGAR_CANE", "LILY_PAD",
            "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING", "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING",
            "BROWN_MUSHROOM", "RED_MUSHROOM", "CRIMSON_FUNGUS", "WARPED_FUNGUS", "CRIMSON_ROOTS", "WARPED_ROOTS", "WEEPING VINES", "TWISTING_VINES",
            "DEAD_BUSH", "WHEAT", "CARROTS", "POTATOES", "BEETROOTS", "PUMPKIN_STEM", "MELON_STEM", "NETHER_WART", "FLOWER_POT",
            "DANDELION", "POPPY", "BLUE_ORCHID", "ALLIUM", "AZURE_BLUET", "RED_TULIP", "ORANGE_TULIP", "WHITE_TULIP", "PINK_TULIP", "OXEYE_DAISY", "CORNFLOWER", "LILY_OF_THE_VALLEY", "WITHER_ROSE", "SUNFLOWER", "LILAC", "ROSE_BUSH", "PEONY",
            "POTTED_DANDELION", "POTTED_POPPY", "POTTED_BLUE_ORCHID", "POTTED_ALLIUM", "POTTED_AZURE_BLUET", "POTTED_RED_TULIP", "POTTED_ORANGE_TULIP", "POTTED_WHITE_TULIP", "POTTED_PINK_TULIP", "POTTED_OXEYE_DAISY", "POTTED_CORNFLOWER", "POTTED_LILY_OF_THE_VALLEY", "POTTED_WITHER_ROSE", "POTTED_SUNFLOWER", "POTTED_LILAC", "POTTED_ROSE_BUSH", "POTTED_PEONY",
            "TUBE_CORAL", "BRAIN_CORAL", "BUBBLE_CORAL", "FIRE_CORAL", "HORN_CORAL", "DEAD_TUBE_CORAL", "DEAD_BRAIN_CORAL", "DEAD_BUBBLE_CORAL", "DEAD_FIRE_CORAL", "DEAD_HORN_CORAL"};
    // TODO: Add grass only in 1.13+ instead of always
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

    final RealisticSurvivalPlugin main;
    //final Map<Material,Tool> uToolMap;


    // This is called AFTER BestToolsHandler, so the Utils can affect the Handler
    public BestToolsUtils(RealisticSurvivalPlugin main) {

        this.main = Objects.requireNonNull(main, "Main must not be null");
        Objects.requireNonNull(main.toolHandler, "BestToolsHandler must be instantiated before BestToolUtils!");

        // Register valid weapons
        for (String weapon : weapons) {
            if (Material.getMaterial(weapon) != null) {
                main.toolHandler.weapons.add(Material.getMaterial(weapon));
            }
        }

        // Register all InstaBreaksByHand
        for (String s : instaBreakableByHand) {
            addToMap(s, main.toolHandler.instaBreakableByHand);
        }

        // Hoes
        for (String s : hoes) {
            addToMap(s, main.toolHandler.hoes);
        }

        // Pickaxes
        for (String s : pickaxes) {
            addToMap(s, main.toolHandler.pickaxes);
        }

        // Axes
        for (String s : axes) {
            addToMap(s, main.toolHandler.axes);
        }

        // Shovels
        for (String s : shovels) {
            addToMap(s, main.toolHandler.shovels);
        }

        // Swords
        for (String s : swords) {
            addToMap(s, main.toolHandler.swords);
        }


        main.toolHandler.allTools.addAll(Arrays.asList(defaultMats));
        for (String s : netheriteTools) {
            if (Material.getMaterial(s) != null) {
                main.toolHandler.allTools.add(Material.getMaterial(s));
            }
        }

        // 1.17+
        try {
            for (Material mat : v1_17.getPickaxeMaterials()) {
                addToMap(mat, Tool.PICKAXE);
            }
        } catch (Throwable t) {
            // 1.17+
        }

        //uToolMap = Map.copyOf(main.toolHandler.toolMap); // Java 10+ only
    }

    private void addToMap(String name, ArrayList<Material> list) {
        Material mat = Material.getMaterial(name);
        if (mat != null) {
            list.add(mat);
        } else {
            main.debug("Skipping unknown Material " + name);
        }
    }

    private void tagToMap(@NotNull Tag<Material> tag, @NotNull Tool tool) {
        tagToMap(Objects.requireNonNull(tag, "Tag must not be null"),
                Objects.requireNonNull(tool, "Tool must not be null"),
                null);
    }

    private void tagToMap(@NotNull Tag<Material> tag, @NotNull Tool tool, @Nullable String match) {
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

    private void printMap(HashMap<Material, Tool> toolMap) {
        toolMap.forEach((mat, tool) -> System.out.println(String.format("%0$30s -> %s", mat.name(), tool.name())));
    }

    private void addToMap(@NotNull String matName, @NotNull Tool tool) {
        Material mat = Material.getMaterial(matName);
        if (mat == null) {
            main.debug("Skipping unknown fallback Material " + matName);
            return;
        }
        addToMap(mat, tool);
    }

    private void addToMap(@NotNull Material mat, @NotNull Tool tool) {
        Objects.requireNonNull(Objects.requireNonNull(main.toolHandler, "ToolHandler must not be null").
                        toolMap, "ToolMap must not be null")
                .put(Objects.requireNonNull(mat, "Material must not be null"),
                        Objects.requireNonNull(tool, "Tool must not be null"));
    }

    void initMap() {
        long startTime = System.nanoTime();

        initFallbackMaterials();


        // Versions before 1.13 do not support Tags at all
        try {
            tagToMap(Tag.ANVIL, Tool.PICKAXE);

            tagToMap(Tag.ICE, Tool.PICKAXE);
            tagToMap(Tag.LEAVES, Tool.SHEARS);
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

            // WATCH OUT FOR ORDER - END //

            tagToMap(Tag.SAND, Tool.SHOVEL);
            tagToMap(Tag.STONE_BRICKS, Tool.PICKAXE);

            addToMap("SEAGRASS",Tool.SHEARS);
            addToMap("TALL_SEAGRASS",Tool.SHEARS);


        } catch (NoClassDefFoundError ignored) {
            // GRASS_BLOCK prior to 1.13 is called GRASS
            addToMap("GRASS", Tool.SHOVEL);
        }

        // Tags for 1.14+
        try {
            tagToMap(Tag.BAMBOO_PLANTABLE_ON, Tool.SHOVEL);
            tagToMap(Tag.SIGNS, Tool.AXE);
            tagToMap(Tag.WALLS, Tool.PICKAXE);

            // Order important START
            tagToMap(Tag.FENCES, Tool.AXE);
            tagToMap(Tag.FENCES, Tool.PICKAXE, "NETHER");
            tagToMap(Tag.FENCES, Tool.PICKAXE, "BRICK");
            // Order important END
        } catch (NoSuchFieldError | NoClassDefFoundError ignored) {
            String[] bamboo_plantable_on = {"GRASS_BLOCK", "DIRT", "COARSE_DIRT", "GRAVEL", "MYCELIUM", "PODZOL", "SAND", "RED_SAND"};
            for (String s : bamboo_plantable_on) {
                addToMap(s, Tool.SHOVEL);
            }
        }

        // Tags for 1.15+
        try {
            tagToMap(Tag.BEEHIVES, Tool.AXE);
            tagToMap(Tag.SHULKER_BOXES, Tool.PICKAXE);

            // The following kind of unneccessary anyway
            tagToMap(Tag.CROPS, Tool.NONE);
            tagToMap(Tag.FLOWERS, Tool.NONE);

        } catch (NoSuchFieldError | NoClassDefFoundError ignored) {
        }

        // Tags for 1.16+
        try {
            tagToMap(Tag.CRIMSON_STEMS, Tool.AXE);
            tagToMap(Tag.FENCE_GATES, Tool.AXE);
            tagToMap(Tag.NYLIUM, Tool.PICKAXE);
            // Important order START //
            tagToMap(Tag.PRESSURE_PLATES, Tool.PICKAXE);
            tagToMap(Tag.WOODEN_PRESSURE_PLATES, Tool.AXE);
            // Important order STOP //

        } catch (NoSuchFieldError | NoClassDefFoundError ignored) {
        }

        // Stairs in 1.16+
        addToMap("WARPED_STAIRS",Tool.AXE);
        addToMap("CRIMSON_STAIRS",Tool.AXE);

        // Some of the following definitions are redundant because of the tags above
        // However I don't want to miss something, so they are still defined here
        // Shouldn't harm because building the map takes only take 2 ms when the
        // plugin is enabled

        addToMap("BONE_BLOCK", Tool.PICKAXE);

        // Issue #1
        addToMap("BASALT", Tool.PICKAXE);
        addToMap("POLISHED_BASALT", Tool.PICKAXE);
        addToMap("GLOWSTONE", Tool.PICKAXE); // TODO: Prefer SilkTouch
        addToMap("NETHER_GOLD_ORE", Tool.PICKAXE);
        // Issue #1 End

        // Issue #2
        addToMap("SPONGE", Tool.HOE);
        addToMap("WET_SPONGE", Tool.HOE);
        addToMap("PISTON", Tool.PICKAXE);
        addToMap("STICKY_PISTON", Tool.PICKAXE);
        addToMap("PISTON_HEAD", Tool.PICKAXE);
        addToMap("MOVING_PISTON", Tool.PICKAXE);
        addToMap("CHORUS_PLANT", Tool.AXE);
        addToMap("CHORUS_FLOWER", Tool.AXE);
        addToMap("CARVED_PUMPKIN", Tool.AXE);
        addToMap("HAY_BLOCK", Tool.HOE);
        addToMap("OBSERVER", Tool.PICKAXE);
        addToMap("NETHER_WART_BLOCK", Tool.HOE);
        addToMap("WARPED_WART_BLOCK", Tool.HOE);
        addToMap("MAGMA_BLOCK", Tool.PICKAXE);
        // Issue #2 End

        // Issue #3
        addToMap("TARGET", Tool.HOE);
        addToMap("SHROOMLIGHT", Tool.HOE);
        addToMap("BELL", Tool.PICKAXE);
        addToMap("STONECUTTER", Tool.PICKAXE);
        addToMap("SMITHING_TABLE", Tool.AXE);
        addToMap("LECTERN", Tool.AXE);
        addToMap("GRINDSTONE", Tool.PICKAXE);
        addToMap("FLETCHING_TABLE", Tool.AXE);
        addToMap("CARTOGRAPHY_TABLE", Tool.AXE);
        addToMap("BLAST_FURNACE", Tool.PICKAXE);
        addToMap("SMOKER", Tool.PICKAXE);
        addToMap("BARREL", Tool.AXE);
        addToMap("COMPOSTER", Tool.AXE);
        addToMap("LOOM", Tool.AXE);
        addToMap("DRIED_KELP_BLOCK", Tool.HOE);
        // Issue #3 End

        addToMap("ACACIA_BUTTON", Tool.AXE);
        addToMap("ACACIA_FENCE", Tool.AXE);
        addToMap("ACACIA_FENCE_GATE", Tool.AXE);
        addToMap("ACACIA_LEAVES", Tool.SHEARS);
        addToMap("ACACIA_PRESSURE_PLATE", Tool.AXE);
        addToMap("ACACIA_SLAB", Tool.AXE);
        addToMap("ACACIA_STAIRS", Tool.AXE);
        addToMap("ANCIENT_DEBRIS", Tool.PICKAXE);
        addToMap("ANDESITE", Tool.PICKAXE);
        addToMap("BAMBOO", Tool.AXE);
        addToMap("BAMBOO_SAPLING", Tool.AXE);
        addToMap("BASALT", Tool.PICKAXE);
        addToMap("BIRCH_BUTTON", Tool.AXE);
        addToMap("BIRCH_FENCE", Tool.AXE);
        addToMap("BIRCH_FENCE_GATE", Tool.AXE);
        addToMap("BIRCH_LEAVES", Tool.SHEARS);
        addToMap("BIRCH_PRESSURE_PLATE", Tool.AXE);
        addToMap("BIRCH_SLAB", Tool.AXE);
        addToMap("BIRCH_STAIRS", Tool.AXE);
        addToMap("BLACKSTONE", Tool.PICKAXE);
        addToMap("BLACKSTONE_SLAB", Tool.PICKAXE);
        addToMap("BLACKSTONE_STAIRS", Tool.PICKAXE);
        addToMap("BLACK_CONCRETE", Tool.PICKAXE);
        addToMap("BLACK_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("BLUE_CONCRETE", Tool.PICKAXE);
        addToMap("BLUE_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("BOOKSHELF", Tool.AXE);
        addToMap("BREWING_STAND", Tool.PICKAXE);
        addToMap("BRICKS", Tool.PICKAXE);
        addToMap("BRICK_SLAB", Tool.PICKAXE);
        addToMap("BRICK_STAIRS", Tool.PICKAXE);
        addToMap("BROWN_CONCRETE", Tool.PICKAXE);
        addToMap("BROWN_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("BROWN_MUSHROOM_BLOCK", Tool.AXE);
        addToMap("CAMPFIRE", Tool.AXE);
        addToMap("CAULDRON", Tool.PICKAXE);
        addToMap("CHAIN", Tool.PICKAXE);
        addToMap("CHEST", Tool.AXE);
        addToMap("CHISELED_RED_SANDSTONE", Tool.PICKAXE);
        addToMap("CHISELED_SANDSTONE", Tool.PICKAXE);
        addToMap("CHISELED_STONE_BRICKS", Tool.PICKAXE);
        addToMap("CLAY", Tool.SHOVEL);
        addToMap("COAL_BLOCK", Tool.PICKAXE);
        addToMap("COAL_ORE", Tool.PICKAXE);
        addToMap("COARSE_DIRT", Tool.SHOVEL);
        addToMap("COBBLESTONE", Tool.PICKAXE);
        addToMap("COBBLESTONE_SLAB", Tool.PICKAXE);
        addToMap("COBBLESTONE_STAIRS", Tool.PICKAXE);
        addToMap("COBWEB", Tool.SHEARS);
        addToMap("COCOA", Tool.AXE);
        addToMap("CRACKED_STONE_BRICKS", Tool.PICKAXE);
        addToMap("CRAFTING_TABLE", Tool.AXE);
        addToMap("CRYING_OBSIDIAN", Tool.PICKAXE);
        addToMap("CUT_RED_SANDSTONE", Tool.PICKAXE);
        addToMap("CUT_SANDSTONE", Tool.PICKAXE);
        addToMap("CYAN_CONCRETE", Tool.PICKAXE);
        addToMap("CYAN_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("DARK_OAK_BUTTON", Tool.AXE);
        addToMap("DARK_OAK_FENCE", Tool.AXE);
        addToMap("DARK_OAK_FENCE_GATE", Tool.AXE);
        addToMap("DARK_OAK_LEAVES", Tool.SHEARS);
        addToMap("DARK_OAK_PRESSURE_PLATE", Tool.AXE);
        addToMap("DARK_OAK_SLAB", Tool.AXE);
        addToMap("DARK_OAK_STAIRS", Tool.AXE);
        addToMap("DARK_PRISMARINE", Tool.PICKAXE);
        addToMap("DARK_PRISMARINE_SLAB", Tool.PICKAXE);
        addToMap("DARK_PRISMARINE_STAIRS", Tool.PICKAXE);
        addToMap("DAYLIGHT_DETECTOR", Tool.AXE);
        addToMap("DIAMOND_BLOCK", Tool.PICKAXE);
        addToMap("DIAMOND_ORE", Tool.PICKAXE);
        addToMap("DIORITE", Tool.PICKAXE);
        addToMap("DIRT", Tool.SHOVEL);
        addToMap("DISPENSER", Tool.PICKAXE);
        addToMap("DROPPER", Tool.PICKAXE);
        addToMap("EMERALD_BLOCK", Tool.PICKAXE);
        addToMap("EMERALD_ORE", Tool.PICKAXE);
        addToMap("ENCHANTING_TABLE", Tool.PICKAXE);
        addToMap("ENDER_CHEST", Tool.PICKAXE);
        addToMap("END_STONE", Tool.PICKAXE);
        addToMap("FARMLAND", Tool.SHOVEL);
        addToMap("FURNACE", Tool.PICKAXE);
        addToMap("GILDED_BLACKSTONE", Tool.PICKAXE);
        addToMap("GOLD_BLOCK", Tool.PICKAXE);
        addToMap("GOLD_ORE", Tool.PICKAXE);
        addToMap("GRANITE", Tool.PICKAXE);
        addToMap("GRASS_BLOCK", Tool.SHOVEL);
        addToMap("GRASS_PATH", Tool.SHOVEL);
        addToMap("DIRT_PATH", Tool.SHOVEL);
        addToMap("GRAVEL", Tool.SHOVEL);
        addToMap("GRAY_CONCRETE", Tool.PICKAXE);
        addToMap("GRAY_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("GREEN_CONCRETE", Tool.PICKAXE);
        addToMap("GREEN_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("HEAVY_WEIGHTED_PRESSURE_PLATE", Tool.PICKAXE);
        addToMap("HOPPER", Tool.PICKAXE);
        addToMap("IRON_BARS", Tool.PICKAXE);
        addToMap("IRON_BLOCK", Tool.PICKAXE);
        addToMap("IRON_DOOR", Tool.PICKAXE);
        addToMap("IRON_ORE", Tool.PICKAXE);
        addToMap("IRON_TRAPDOOR", Tool.PICKAXE);
        addToMap("JACK_O_LANTERN", Tool.AXE);
        addToMap("JUKEBOX", Tool.AXE);
        addToMap("JUNGLE_BUTTON", Tool.AXE);
        addToMap("JUNGLE_FENCE", Tool.AXE);
        addToMap("JUNGLE_FENCE_GATE", Tool.AXE);
        addToMap("JUNGLE_LEAVES", Tool.SHEARS);
        addToMap("JUNGLE_PRESSURE_PLATE", Tool.AXE);
        addToMap("JUNGLE_SLAB", Tool.AXE);
        addToMap("JUNGLE_STAIRS", Tool.AXE);
        addToMap("LADDER", Tool.AXE);
        addToMap("LANTERN", Tool.PICKAXE);
        addToMap("LAPIS_BLOCK", Tool.PICKAXE);
        addToMap("LAPIS_ORE", Tool.PICKAXE);
        addToMap("LIGHT_BLUE_CONCRETE", Tool.PICKAXE);
        addToMap("LIGHT_BLUE_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("LIGHT_GRAY_CONCRETE", Tool.PICKAXE);
        addToMap("LIGHT_GRAY_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("LIGHT_WEIGHTED_PRESSURE_PLATE", Tool.PICKAXE);
        addToMap("LIME_CONCRETE", Tool.PICKAXE);
        addToMap("LIME_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("LODESTONE", Tool.PICKAXE);
        addToMap("MAGENTA_CONCRETE", Tool.PICKAXE);
        addToMap("MAGENTA_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("MELON", Tool.AXE);
        addToMap("MOSSY_COBBLESTONE", Tool.PICKAXE);
        addToMap("MOSSY_STONE_BRICKS", Tool.PICKAXE);
        addToMap("MUSHROOM_STEM", Tool.AXE);
        addToMap("MYCELIUM", Tool.SHOVEL);
        addToMap("NETHERITE_BLOCK", Tool.PICKAXE);
        addToMap("NETHERRACK", Tool.PICKAXE);
        addToMap("NETHER_BRICK", Tool.PICKAXE);
        addToMap("NETHER_BRICK_FENCE", Tool.PICKAXE);
        addToMap("NETHER_BRICK_SLAB", Tool.PICKAXE);
        addToMap("NETHER_BRICK_STAIRS", Tool.PICKAXE);
        addToMap("NETHER_QUARTZ_ORE", Tool.PICKAXE);
        addToMap("NOTE_BLOCK", Tool.AXE);
        addToMap("OAK_BUTTON", Tool.AXE);
        addToMap("OAK_FENCE", Tool.AXE);
        addToMap("OAK_FENCE_GATE", Tool.AXE);
        addToMap("OAK_LEAVES", Tool.SHEARS);
        addToMap("OAK_PRESSURE_PLATE", Tool.AXE);
        addToMap("OAK_SLAB", Tool.AXE);
        addToMap("OAK_STAIRS", Tool.AXE);
        addToMap("OBSIDIAN", Tool.PICKAXE);
        addToMap("ORANGE_CONCRETE", Tool.PICKAXE);
        addToMap("ORANGE_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("PINK_CONCRETE", Tool.PICKAXE);
        addToMap("PINK_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("PODZOL", Tool.SHOVEL);
        addToMap("POLISHED_ANDESITE", Tool.PICKAXE);
        addToMap("POLISHED_DIORITE", Tool.PICKAXE);
        addToMap("POLISHED_GRANITE", Tool.PICKAXE);
        addToMap("PUMPKIN", Tool.AXE);
        addToMap("PURPLE_CONCRETE", Tool.PICKAXE);
        addToMap("PURPLE_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("QUARTZ_BLOCK", Tool.PICKAXE);
        addToMap("QUARTZ_BRICKS", Tool.PICKAXE);
        addToMap("REDSTONE_BLOCK", Tool.PICKAXE);
        addToMap("REDSTONE_ORE", Tool.PICKAXE);
        addToMap("RED_CONCRETE", Tool.PICKAXE);
        addToMap("RED_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("RED_MUSHROOM_BLOCK", Tool.AXE);
        addToMap("RED_NETHER_BRICKS", Tool.PICKAXE);
        addToMap("RED_NETHER_BRICK_SLAB", Tool.PICKAXE);
        addToMap("RED_NETHER_BRICK_STAIRS", Tool.PICKAXE);
        addToMap("RED_SAND", Tool.SHOVEL);
        addToMap("RED_SANDSTONE", Tool.PICKAXE);
        addToMap("RED_SANDSTONE_SLAB", Tool.PICKAXE);
        addToMap("RED_SANDSTONE_STAIRS", Tool.PICKAXE);
        addToMap("RESPAWN_ANCHOR", Tool.PICKAXE);
        addToMap("SAND", Tool.SHOVEL);
        addToMap("SANDSTONE", Tool.PICKAXE);
        addToMap("SANDSTONE_SLAB", Tool.PICKAXE);
        addToMap("SANDSTONE_STAIRS", Tool.PICKAXE);
        addToMap("SEA_LANTERN", Tool.PICKAXE);
        addToMap("SMOOTH_QUARTZ", Tool.PICKAXE);
        addToMap("SMOOTH_RED_SANDSTONE", Tool.PICKAXE);
        addToMap("SMOOTH_SANDSTONE", Tool.PICKAXE);
        addToMap("SMOOTH_STONE", Tool.PICKAXE);
        addToMap("SNOW", Tool.SHOVEL);
        addToMap("SNOW_BLOCK", Tool.SHOVEL);
        addToMap("SOUL_CAMPFIRE", Tool.AXE);
        addToMap("SOUL_LANTERN", Tool.PICKAXE);
        addToMap("SOUL_SAND", Tool.SHOVEL);
        addToMap("SOUL_SOIL", Tool.SHOVEL);
        addToMap("SPAWNER", Tool.PICKAXE);
        addToMap("SPRUCE_BUTTON", Tool.AXE);
        addToMap("SPRUCE_FENCE", Tool.AXE);
        addToMap("SPRUCE_FENCE_GATE", Tool.AXE);
        addToMap("SPRUCE_LEAVES", Tool.SHEARS);
        addToMap("SPRUCE_PRESSURE_PLATE", Tool.AXE);
        addToMap("SPRUCE_STAIRS", Tool.AXE);
        addToMap("STONE", Tool.PICKAXE);
        addToMap("STONE_BRICKS", Tool.PICKAXE);
        addToMap("STONE_BRICK_SLAB", Tool.PICKAXE);
        addToMap("STONE_BRICK_STAIRS", Tool.PICKAXE);
        addToMap("STONE_BUTTON", Tool.PICKAXE);
        addToMap("STONE_PRESSURE_PLATE", Tool.PICKAXE);
        addToMap("STONE_SLAB", Tool.PICKAXE);
        addToMap("TERRACOTTA", Tool.PICKAXE);
        addToMap("TRAPPED_CHEST", Tool.AXE);
        addToMap("VINE", Tool.SHEARS);
        addToMap("WHITE_CONCRETE", Tool.PICKAXE);
        addToMap("WHITE_CONCRETE_POWDER", Tool.SHOVEL);
        addToMap("YELLOW_CONCRETE", Tool.PICKAXE);
        addToMap("YELLOW_CONCRETE_POWDER", Tool.SHOVEL);

        // 1.17
        try {
            for (Material mat : Material.values()) {

                if (mat.name().contains("AMETHYST")) {
                    addToMap(mat.name(), Tool.PICKAXE);
                }
                if(mat.name().endsWith("_ORE")) {
                    addToMap(mat.name(), Tool.PICKAXE);
                }
                if(mat.name().contains("BASALT")) {
                    addToMap(mat.name(), Tool.PICKAXE);
                }
                if(mat.name().contains("DEEPSLATE")) {
                    addToMap(mat.name(), Tool.PICKAXE);
                }
            }
            addToMap(Material.GLOW_LICHEN, Tool.SHEARS);
            addToMap(Material.CALCITE, Tool.PICKAXE);
        } catch (Throwable ignored) {

        }


        long endTime = System.nanoTime();
        //printMap();
        if (main.verbose) {
            main.getLogger().info(String.format("Building the <Block,Tool> map took %d ms", (endTime - startTime) / 1000000));
        }
    }

    // F****** Spigot API is not "forward compatible" with new Material enums
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
                    addToMap(mat, Tool.PICKAXE);
                    continue;
                }
                addToMap(mat, Tool.AXE);
                continue;
            }
            // Tags only in 1.16+ END

            // Tags only in 1.15+ START
            if (n.contains("SHULKER_BOX")) {
                addToMap(mat, Tool.PICKAXE);
                continue;
            }
            // Tags only in 1.15+ END

            // Tags only in 1.14+ START
            if (n.contains("FENCE")) {
                if (n.contains("NETHER") || n.contains("BRICK")) {
                    addToMap(mat, Tool.PICKAXE);
                    continue;
                }
                addToMap(mat, Tool.AXE);
                continue;
            }
            if (n.contains("SIGN")) {
                addToMap(mat, Tool.AXE);
                continue;
            }
            // Tags only in 1.14+ END

            // Different item names < 1.13
            if (n.equals("LEAVES") || n.equals("WOOL")) {
                addToMap(mat, Tool.SHEARS);
                continue;
            }
            if (n.equals("WORKBENCH")) {
                addToMap(mat, Tool.AXE);
                continue;
            }

        }

    }
}
