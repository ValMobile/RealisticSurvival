package me.val_mobile.rlcraft;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class Recipes {

    private final RLCraft plugin;
    private final Items citem;
    private final Utils util;
    public Recipes(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        citem = new Items(instance);
    }

    public ShapedRecipe getFlintAxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_axe");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFlintAxe());

        recipe.shape("TF", "S ");

        recipe.setIngredient('T', Material.STRING);
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintKnifeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_knife");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFlintKnife());

        recipe.shape(" F", " S");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintPickaxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFlintPickaxe());

        recipe.shape("FFF", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintShovelRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_shovel");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFlintShovel());

        recipe.shape(" F ", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintHoeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_hoe");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFlintHoe());

        recipe.shape("FF ", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getCobblestoneRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "cobblestone");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getCobblestone());

        recipe.shape("BB", "BB");

        recipe.setIngredient('B', Material.STONE_BUTTON);

        return recipe;
    }

    public ShapedRecipe getPlantStringRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "plant_string");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getPlantString());

        recipe.shape("FF", "F ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getPlantFiber()));

        return recipe;
    }

    public ShapelessRecipe getFireDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "fire_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, citem.getFireDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(citem.getFireDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapelessRecipe getIceDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ice_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, citem.getIceDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(citem.getIceDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapelessRecipe getLightningDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "lightning_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, citem.getLightningDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(citem.getLightningDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetBlue());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateBlue());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsBlue());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsBlue());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetBronze());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateBronze());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsBronze());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsBronze());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetGray());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateGray());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsGray());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsGray());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetGreen());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateGreen());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsGreen());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsGreen());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetRed());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateRed());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsRed());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsRed());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetSapphire());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateSapphire());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsSapphire());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsSapphire());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetSilver());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateSilver());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsSilver());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsSilver());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_white");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetWhite());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_white");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateWhite());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_white");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsWhite());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_white");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsWhite());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetAmethyst());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateAmethyst());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsAmethyst());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsAmethyst());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_black");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetBlack());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_black");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateBlack());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_black");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsBlack());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_black");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsBlack());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetCopper());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateCopper());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsCopper());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsCopper());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleHelmetElectric());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleChestplateElectric());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleLeggingsElectric());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonScaleBootsElectric());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetBlue());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplateBlue());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsBlue());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsBlue());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetBronze());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplateBronze());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsBronze());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsBronze());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetDeepBlue());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplateDeepBlue());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsDeepBlue());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsDeepBlue());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetGreen());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplateGreen());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsGreen());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getideGuardianBootsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_green");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsGreen());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetPurple());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplatePurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplatePurple());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsPurple());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsPurple());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetRed());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplateRed());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsRed());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_red");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsRed());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianHelmetTeal());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianChestplateTeal());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianLeggingsTeal());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getTideGuardianBootsTeal());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(citem.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getDragonBonePickaxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonBonePickaxe());

        recipe.shape("BBB", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(citem.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneAxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_axe");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonBoneAxe());

        recipe.shape("BB ", "BW ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(citem.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneShovelRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_shovel");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonBoneShovel());

        recipe.shape(" B ", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(citem.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneHoeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_hoe");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonBoneHoe());

        recipe.shape("BB ", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(citem.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonBoneSword());

        recipe.shape(" B ", " B ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(citem.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneBowRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_bow");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getDragonBoneBow());

        recipe.shape(" BS", "W S", " BS");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(citem.getWitherbone()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getString()));

        return recipe;
    }

    public ShapedRecipe getFlamedDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flamed_dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFlamedDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getFireDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getIceDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ice_dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getIcedDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getIceDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getLightningDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "lightning_dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getLightningDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(citem.getLightningDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getBalloonRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_balloon");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getBalloon());

        recipe.shape("SWS", "WSW", "SWS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSpectralSilt()));
        recipe.setIngredient('W', Material.WHITE_WOOL);

        return recipe;
    }

    public ShapedRecipe getCobaltShieldRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_cobalt_shield");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getCobaltShield());

        recipe.shape("SSS", "SHS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSpectralSilt()));
        recipe.setIngredient('H', Material.SHIELD);

        return recipe;
    }

    public ShapedRecipe getObsidianSkullRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_obsidian_skull");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getObsidianSkull());

        recipe.shape("OBO", "PWP", "OBO");

        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('B', Material.BLAZE_POWDER);
        recipe.setIngredient('P', new RecipeChoice.ExactChoice(citem.getFireResistancePotion()));
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        return recipe;
    }

    public ShapedRecipe getSunglassesRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_sunglasses");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getSunglasses());

        recipe.shape("S S", "GTG", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSpectralSilt()));
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('T', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getCrackedBlackDragonScaleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_cracked_black_dragon_scale");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getCrackedBlackDragonScale());

        recipe.shape("SSS", "SES", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSpectralSilt()));
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(citem.getEnderDragonScale()));

        return recipe;
    }

    public ShapedRecipe getBlackDragonScaleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_black_dragon_scale");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getBlackDragonScale());

        recipe.shape("   ", "NEC", "   ");

        recipe.setIngredient('N', Material.NETHER_STAR);
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(citem.getEnderDragonScale()));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(citem.getCrackedBlackDragonScale()));

        return recipe;
    }

    public ShapedRecipe getAnkhCharmRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_ankh_charm");

        ShapedRecipe recipe = new ShapedRecipe(key, citem.getAnkhCharm());

        recipe.shape("GSG", "RMF", "GVG");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(citem.getSunglasses()));
        recipe.setIngredient('R', new RecipeChoice.ExactChoice(citem.getRingofFreeAction()));
        recipe.setIngredient('M', new RecipeChoice.ExactChoice(citem.getMixedColorDragonScale()));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(citem.getForbiddenFruit()));
        recipe.setIngredient('V', new RecipeChoice.ExactChoice(citem.getVitamins()));

        return recipe;
    }

    public ShapedRecipe getWarpedScrollRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "warped_scroll");

        ShapedRecipe recipe = new ShapedRecipe(key, util.resizeItem(citem.getWarpedScroll(), 3));

        recipe.shape("EDE", "PPP", "GDG");

        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('D', Material.PURPLE_DYE);
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('G', Material.GOLD_NUGGET);

        return recipe;
    }

//    public ShapedRecipe getFireDragonsteelSwordRecipe() {
//
//        NamespacedKey key = new NamespacedKey(plugin, "dragonsteel_fire_sword");
//
//        ShapedRecipe recipe = new ShapedRecipe(key, citem.getFireDragonsteelSword());
//
//        recipe.shape("EDE", "PPP", "GDG");
//
//        recipe.setIngredient('E', Material.ENDER_PEARL);
//        recipe.setIngredient('D', Material.PURPLE_DYE);
//        recipe.setIngredient('P', Material.PAPER);
//        recipe.setIngredient('G', Material.GOLD_NUGGET);
//
//        return recipe;
//    }




}
