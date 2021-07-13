package me.val_mobile.rlcraft;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    private final RLCraft plugin;

    private static List<Recipe> ntrRecipes = new ArrayList<>();
    private static List<Recipe> baubleRecipes = new ArrayList<>();
    private static List<Recipe> dragonRecipes = new ArrayList<>();
    private static List<Recipe> seaSerpentRecipes = new ArrayList<>();
    private static List<Recipe> spartanWeaponryRecipes = new ArrayList<>();
    private static List<Recipe> waystoneRecipes = new ArrayList<>();

    public static List<Recipe> getNtrRecipes() {
        return ntrRecipes;
    }
    public static List<Recipe> getBaubleRecipes() {
        return baubleRecipes;
    }
    public static List<Recipe> getDragonRecipes() {
        return dragonRecipes;
    }
    public static List<Recipe> getSeaSerpentRecipes() {
        return seaSerpentRecipes;
    }
    public static List<Recipe> getSpartanWeaponryRecipes() {
        return spartanWeaponryRecipes;
    }
    public static List<Recipe> getWaystoneRecipes() {
        return spartanWeaponryRecipes;
    }

    public Recipes(RLCraft instance) {
        plugin = instance;
    }

    public void populateNtrRecipes() {
        ntrRecipes.add(getFlintAxeRecipe());
        ntrRecipes.add(getFlintKnifeRecipe());
        ntrRecipes.add(getFlintHoeRecipe());
        ntrRecipes.add(getFlintPickaxeRecipe());
        ntrRecipes.add(getFlintShovelRecipe());
        ntrRecipes.add(getCobblestoneRecipe());
        ntrRecipes.add(getPlantStringRecipe());
    }

    public void populateBaubleRecipes() {
        baubleRecipes.add(getBalloonRecipe());
        baubleRecipes.add(getCobaltShieldRecipe());
        baubleRecipes.add(getObsidianSkullRecipe());
        baubleRecipes.add(getSunglassesRecipe());
        baubleRecipes.add(getCrackedBlackDragonScaleRecipe());
        baubleRecipes.add(getBlackDragonScaleRecipe());
        baubleRecipes.add(getAnkhCharmRecipe());
    }

    public void populateDragonRecipes() {
        dragonRecipes.add(getFireDragonsteelIngotRecipe());
        dragonRecipes.add(getIceDragonsteelIngotRecipe());
        dragonRecipes.add(getLightningDragonsteelIngotRecipe());

        dragonRecipes.add(getDragonScaleHelmetBlueRecipe());
        dragonRecipes.add(getDragonScaleChestplateBlueRecipe());
        dragonRecipes.add(getDragonScaleLeggingsBlueRecipe());
        dragonRecipes.add(getDragonScaleBootsBlueRecipe());

        dragonRecipes.add(getDragonScaleHelmetBronzeRecipe());
        dragonRecipes.add(getDragonScaleChestplateBronzeRecipe());
        dragonRecipes.add(getDragonScaleLeggingsBronzeRecipe());
        dragonRecipes.add(getDragonScaleBootsBronzeRecipe());

        dragonRecipes.add(getDragonScaleHelmetGrayRecipe());
        dragonRecipes.add(getDragonScaleChestplateGrayRecipe());
        dragonRecipes.add(getDragonScaleLeggingsGrayRecipe());
        dragonRecipes.add(getDragonScaleBootsGrayRecipe());

        dragonRecipes.add(getDragonScaleHelmetGreenRecipe());
        dragonRecipes.add(getDragonScaleChestplateGreenRecipe());
        dragonRecipes.add(getDragonScaleLeggingsGreenRecipe());
        dragonRecipes.add(getDragonScaleBootsGreenRecipe());

        dragonRecipes.add(getDragonScaleHelmetRedRecipe());
        dragonRecipes.add(getDragonScaleChestplateRedRecipe());
        dragonRecipes.add(getDragonScaleLeggingsRedRecipe());
        dragonRecipes.add(getDragonScaleBootsRedRecipe());

        dragonRecipes.add(getDragonScaleHelmetSapphireRecipe());
        dragonRecipes.add(getDragonScaleChestplateSapphireRecipe());
        dragonRecipes.add(getDragonScaleLeggingsSapphireRecipe());
        dragonRecipes.add(getDragonScaleBootsSapphireRecipe());

        dragonRecipes.add(getDragonScaleHelmetSilverRecipe());
        dragonRecipes.add(getDragonScaleChestplateSilverRecipe());
        dragonRecipes.add(getDragonScaleLeggingsSilverRecipe());
        dragonRecipes.add(getDragonScaleBootsSilverRecipe());

        dragonRecipes.add(getDragonScaleHelmetWhiteRecipe());
        dragonRecipes.add(getDragonScaleChestplateWhiteRecipe());
        dragonRecipes.add(getDragonScaleLeggingsWhiteRecipe());
        dragonRecipes.add(getDragonScaleBootsWhiteRecipe());

        dragonRecipes.add(getDragonScaleHelmetAmethystRecipe());
        dragonRecipes.add(getDragonScaleChestplateAmethystRecipe());
        dragonRecipes.add(getDragonScaleLeggingsAmethystRecipe());
        dragonRecipes.add(getDragonScaleBootsAmethystRecipe());

        dragonRecipes.add(getDragonScaleHelmetBlackRecipe());
        dragonRecipes.add(getDragonScaleChestplateBlackRecipe());
        dragonRecipes.add(getDragonScaleLeggingsBlackRecipe());
        dragonRecipes.add(getDragonScaleBootsBlackRecipe());

        dragonRecipes.add(getDragonScaleHelmetCopperRecipe());
        dragonRecipes.add(getDragonScaleChestplateCopperRecipe());
        dragonRecipes.add(getDragonScaleLeggingsCopperRecipe());
        dragonRecipes.add(getDragonScaleBootsCopperRecipe());

        dragonRecipes.add(getDragonScaleHelmetElectricRecipe());
        dragonRecipes.add(getDragonScaleChestplateElectricRecipe());
        dragonRecipes.add(getDragonScaleLeggingsElectricRecipe());
        dragonRecipes.add(getDragonScaleBootsElectricRecipe());

        dragonRecipes.add(getDragonBonePickaxeRecipe());
        dragonRecipes.add(getDragonBoneShovelRecipe());
        dragonRecipes.add(getDragonBoneHoeRecipe());
        dragonRecipes.add(getDragonBoneSwordRecipe());
        dragonRecipes.add(getDragonBoneBowRecipe());
        dragonRecipes.add(getFlamedDragonBoneSwordRecipe());
        dragonRecipes.add(getIceDragonBoneSwordRecipe());
        dragonRecipes.add(getLightningDragonBoneSwordRecipe());
    }

    public void populateSeaSerpentRecipes() {
        seaSerpentRecipes.add(getTideGuardianHelmetBlueRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplateBlueRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsBlueRecipe());
        seaSerpentRecipes.add(getTideGuardianBootsBlueRecipe());

        seaSerpentRecipes.add(getTideGuardianHelmetBronzeRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplateBronzeRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsBronzeRecipe());
        seaSerpentRecipes.add(getTideGuardianBootsBronzeRecipe());

        seaSerpentRecipes.add(getTideGuardianHelmetDeepBlueRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplateDeepBlueRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsDeepBlueRecipe());
        seaSerpentRecipes.add(getTideGuardianBootsDeepBlueRecipe());

        seaSerpentRecipes.add(getTideGuardianHelmetGreenRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplateGreenRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsGreenRecipe());
        seaSerpentRecipes.add(getideGuardianBootsGreenRecipe());

        seaSerpentRecipes.add(getTideGuardianHelmetPurpleRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplatePurpleRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsPurpleRecipe());
        seaSerpentRecipes.add(getTideGuardianBootsPurpleRecipe());

        seaSerpentRecipes.add(getTideGuardianHelmetRedRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplateRedRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsRedRecipe());
        seaSerpentRecipes.add(getTideGuardianBootsRedRecipe());

        seaSerpentRecipes.add(getTideGuardianHelmetTealRecipe());
        seaSerpentRecipes.add(getTideGuardianChestplateTealRecipe());
        seaSerpentRecipes.add(getTideGuardianLeggingsTealRecipe());
        seaSerpentRecipes.add(getTideGuardianBootsTealRecipe());
    }

    public void populateSpartanWeaponryRecipes() {

    }

    public void populateWaystoneRecipes() {
        waystoneRecipes.add(getWarpedScrollRecipe());
    }

    public ShapedRecipe getFlintAxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_axe");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getFlintAxe());

        recipe.shape("TF", "S ");

        recipe.setIngredient('T', Material.STRING);
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintKnifeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_knife");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getFlintKnife());

        recipe.shape(" F", " S");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintPickaxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getFlintPickaxe());

        recipe.shape("FFF", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintShovelRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_shovel");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getFlintShovel());

        recipe.shape(" F ", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintHoeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_hoe");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getFlintHoe());

        recipe.shape("FF ", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getCobblestoneRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "cobblestone");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getCobblestone());

        recipe.shape("BB", "BB");

        recipe.setIngredient('B', Material.STONE_BUTTON);

        return recipe;
    }

    public ShapedRecipe getPlantStringRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "plant_string");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getPlantString());

        recipe.shape("FF", "F ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getPlantFiber()));

        return recipe;
    }

    public ShapelessRecipe getFireDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "fire_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, CustomItems.getFireDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(CustomItems.getFireDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapelessRecipe getIceDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ice_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, CustomItems.getIceDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(CustomItems.getIceDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapelessRecipe getLightningDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "lightning_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, CustomItems.getLightningDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(CustomItems.getLightningDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetBlue());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateBlue());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsBlue());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsBlue());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetBronze());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateBronze());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsBronze());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsBronze());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetGray());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateGray());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsGray());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsGray());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetGreen());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateGreen());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsGreen());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsGreen());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetRed());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateRed());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsRed());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsRed());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetSapphire());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateSapphire());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsSapphire());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsSapphire());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetSilver());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateSilver());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsSilver());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsSilver());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_white");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetWhite());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_white");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateWhite());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_white");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsWhite());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_white");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsWhite());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetAmethyst());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateAmethyst());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsAmethyst());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsAmethyst());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_black");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetBlack());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_black");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateBlack());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_black");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsBlack());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_black");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsBlack());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetCopper());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateCopper());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsCopper());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsCopper());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_helmet_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleHelmetElectric());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_chestplate_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleChestplateElectric());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_leggings_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleLeggingsElectric());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_scale_boots_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonScaleBootsElectric());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetBlue());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplateBlue());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsBlue());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsBlue());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetBronze());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplateBronze());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsBronze());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsBronze());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetDeepBlue());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplateDeepBlue());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsDeepBlue());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsDeepBlue());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetGreen());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplateGreen());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsGreen());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getideGuardianBootsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_green");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsGreen());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetPurple());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplatePurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplatePurple());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsPurple());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsPurple());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetRed());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplateRed());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsRed());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_red");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsRed());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianHelmetTeal());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianChestplateTeal());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianLeggingsTeal());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getTideGuardianBootsTeal());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(CustomItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getDragonBonePickaxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonBonePickaxe());

        recipe.shape("BBB", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneAxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_axe");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonBoneAxe());

        recipe.shape("BB ", "BW ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneShovelRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_shovel");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonBoneShovel());

        recipe.shape(" B ", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneHoeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_hoe");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonBoneHoe());

        recipe.shape("BB ", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonBoneSword());

        recipe.shape(" B ", " B ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneBowRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragon_bone_bow");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getDragonBoneBow());

        recipe.shape(" BS", "W S", " BS");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(CustomItems.getWitherbone()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getString()));

        return recipe;
    }

    public ShapedRecipe getFlamedDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flamed_dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getFlamedDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getFireDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getIceDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ice_dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getIcedDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getIceDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getLightningDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "lightning_dragon_bone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getLightningDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(CustomItems.getLightningDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getBalloonRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_balloon");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getBalloon());

        recipe.shape("SWS", "WSW", "SWS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSpectralSilt()));
        recipe.setIngredient('W', Material.WHITE_WOOL);

        return recipe;
    }

    public ShapedRecipe getCobaltShieldRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_cobalt_shield");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getCobaltShield());

        recipe.shape("SSS", "SHS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSpectralSilt()));
        recipe.setIngredient('H', Material.SHIELD);

        return recipe;
    }

    public ShapedRecipe getObsidianSkullRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_obsidian_skull");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getObsidianSkull());

        recipe.shape("OBO", "PWP", "OBO");

        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('B', Material.BLAZE_POWDER);
        recipe.setIngredient('P', new RecipeChoice.ExactChoice(CustomItems.getFireResistancePotion()));
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        return recipe;
    }

    public ShapedRecipe getSunglassesRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_sunglasses");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getSunglasses());

        recipe.shape("S S", "GTG", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSpectralSilt()));
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('T', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getCrackedBlackDragonScaleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_cracked_black_dragon_scale");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getCrackedBlackDragonScale());

        recipe.shape("SSS", "SES", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSpectralSilt()));
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(CustomItems.getEnderDragonScale()));

        return recipe;
    }

    public ShapedRecipe getBlackDragonScaleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_black_dragon_scale");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getBlackDragonScale());

        recipe.shape("   ", "NEC", "   ");

        recipe.setIngredient('N', Material.NETHER_STAR);
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(CustomItems.getEnderDragonScale()));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(CustomItems.getCrackedBlackDragonScale()));

        return recipe;
    }

    public ShapedRecipe getAnkhCharmRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "bauble_ankh_charm");

        ShapedRecipe recipe = new ShapedRecipe(key, CustomItems.getAnkhCharm());

        recipe.shape("GSG", "RMF", "GVG");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.getSunglasses()));
        recipe.setIngredient('R', new RecipeChoice.ExactChoice(CustomItems.getRingofFreeAction()));
        recipe.setIngredient('M', new RecipeChoice.ExactChoice(CustomItems.getMixedColorDragonScale()));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(CustomItems.getForbiddenFruit()));
        recipe.setIngredient('V', new RecipeChoice.ExactChoice(CustomItems.getVitamins()));

        return recipe;
    }

    public ShapedRecipe getWarpedScrollRecipe() {

        ItemStack warpedScroll = CustomItems.getWarpedScroll();
        Utils.resizeItem(warpedScroll, 3);

        NamespacedKey key = new NamespacedKey(plugin, "warped_scroll");

        ShapedRecipe recipe = new ShapedRecipe(key, warpedScroll);

        recipe.shape("EDE", "PPP", "GDG");

        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('D', Material.PURPLE_DYE);
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('G', Material.GOLD_NUGGET);

        return recipe;
    }

}
