/*
    Copyright (C) 2021  Val_Mobile

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

import me.val_mobile.rlcraft.RLCraftPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.ArrayList;
import java.util.Collection;

public class Recipes {

    private final RLCraftPlugin plugin;
    private final CustomItems customItems;

    private static Collection<Recipe> ntrRecipes = new ArrayList<>();
    private static Collection<Recipe> baubleRecipes = new ArrayList<>();
    private static Collection<Recipe> dragonRecipes = new ArrayList<>();
    private static Collection<Recipe> seaSerpentRecipes = new ArrayList<>();
    private static Collection<Recipe> spartanWeaponryRecipes = new ArrayList<>();
    private static Collection<Recipe> waystoneRecipes = new ArrayList<>();

    public static Collection<Recipe> getNtrRecipes() {
        return ntrRecipes;
    }
    public static Collection<Recipe> getBaubleRecipes() {
        return baubleRecipes;
    }
    public static Collection<Recipe> getDragonRecipes() {
        return dragonRecipes;
    }
    public static Collection<Recipe> getSeaSerpentRecipes() {
        return seaSerpentRecipes;
    }
    public static Collection<Recipe> getSpartanWeaponryRecipes() {
        return spartanWeaponryRecipes;
    }
    public static Collection<Recipe> getWaystoneRecipes() {
        return spartanWeaponryRecipes;
    }

    public Recipes(RLCraftPlugin instance) {
        plugin = instance;
        customItems = new CustomItems(instance);
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

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getFlintAxe());

        recipe.shape("TF", "S ");

        recipe.setIngredient('T', Material.STRING);
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintKnifeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_knife");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getFlintKnife());

        recipe.shape(" F", " S");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintPickaxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getFlintPickaxe());

        recipe.shape("FFF", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintShovelRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_shovel");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getFlintShovel());

        recipe.shape(" F ", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getFlintHoeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flint_hoe");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getFlintHoe());

        recipe.shape("FF ", " S ", " S ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getFlintShard()));
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getCobblestoneRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "cobblestone");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getCobblestone());

        recipe.shape("BB", "BB");

        recipe.setIngredient('B', Material.STONE_BUTTON);

        return recipe;
    }

    public ShapedRecipe getPlantStringRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "plant_string");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getPlantString());

        recipe.shape("FF", "F ");

        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getPlantFiber()));

        return recipe;
    }

    public ShapelessRecipe getFireDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "fire_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, customItems.getFireDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(customItems.getFireDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapelessRecipe getIceDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ice_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, customItems.getIceDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(customItems.getIceDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapelessRecipe getLightningDragonsteelIngotRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "lightning_dragonsteel_ingot");

        ShapelessRecipe recipe = new ShapelessRecipe(key, customItems.getLightningDragonsteelIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(customItems.getLightningDragonBlood()));
        recipe.addIngredient(Material.IRON_INGOT);
        recipe.addIngredient(Material.NETHERITE_INGOT);

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetBlue());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateBlue());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsBlue());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsBlue());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetBronze());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateBronze());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsBronze());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsBronze());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetGray());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateGray());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsGray());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsGrayRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_gray");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsGray());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGray()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetGreen());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateGreen());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsGreen());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsGreen());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetRed());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateRed());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsRed());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsRed());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleRed()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetSapphire());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateSapphire());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsSapphire());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsSapphireRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_sapphire");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsSapphire());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSapphire()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetSilver());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateSilver());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsSilver());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsSilverRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_silver");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsSilver());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleSilver()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_white");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetWhite());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_white");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateWhite());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_white");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsWhite());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsWhiteRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_white");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsWhite());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleWhite()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetAmethyst());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateAmethyst());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsAmethyst());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsAmethystRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_amethyst");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsAmethyst());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleAmethyst()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_black");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetBlack());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_black");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateBlack());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_black");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsBlack());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsBlackRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_black");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsBlack());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleBlack()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetCopper());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateCopper());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsCopper());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsCopperRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_copper");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsCopper());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleCopper()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleHelmetElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_helmet_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleHelmetElectric());

        recipe.shape("SSS", "S S", "   ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleChestplateElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_chestplate_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleChestplateElectric());

        recipe.shape("S S", "SSS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleLeggingsElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_leggings_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleLeggingsElectric());

        recipe.shape("SSS", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getDragonScaleBootsElectricRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonscale_boots_electric");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonScaleBootsElectric());

        recipe.shape("   ", "S S", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonScaleElectric()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetBlue());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplateBlue());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsBlue());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_blue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsBlue());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetBronze());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplateBronze());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsBronze());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsBronzeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_bronze");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsBronze());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleBronze()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetDeepBlue());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplateDeepBlue());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsDeepBlue());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsDeepBlueRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_deepblue");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsDeepBlue());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleDeepBlue()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetGreen());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplateGreen());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsGreen());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getideGuardianBootsGreenRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_green");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsGreen());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleGreen()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetPurple());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplatePurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplatePurple());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsPurple());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsPurpleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_purple");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsPurple());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScalePurple()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetRed());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplateRed());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsRed());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsRedRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_red");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsRed());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleRed()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianHelmetTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_helmet_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianHelmetTeal());

        recipe.shape("T T", "SSS", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianChestplateTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_chestplate_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianChestplateTeal());

        recipe.shape("S S", "SSS", "TST");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianLeggingsTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_leggings_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianLeggingsTeal());

        recipe.shape("SSS", "S S", "T T");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getTideGuardianBootsTealRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "tide_guardian_boots_teal");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getTideGuardianBootsTeal());

        recipe.shape("T T", "S S", "S S");

        recipe.setIngredient('T', new RecipeChoice.ExactChoice(customItems.getShinyScale()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSeaSerpentScaleTeal()));

        return recipe;
    }

    public ShapedRecipe getDragonBonePickaxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonbone_pickaxe");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonBonePickaxe());

        recipe.shape("BBB", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(customItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneAxeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonbone_axe");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonBoneAxe());

        recipe.shape("BB ", "BW ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(customItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneShovelRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonbone_shovel");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonBoneShovel());

        recipe.shape(" B ", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(customItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneHoeRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonbone_hoe");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonBoneHoe());

        recipe.shape("BB ", " W ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(customItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonbone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonBoneSword());

        recipe.shape(" B ", " B ", " W ");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(customItems.getWitherbone()));

        return recipe;
    }

    public ShapedRecipe getDragonBoneBowRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "dragonbone_bow");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getDragonBoneBow());

        recipe.shape(" BS", "W S", " BS");

        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getDragonBone()));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(customItems.getWitherbone()));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getString()));

        return recipe;
    }

    public ShapedRecipe getFlamedDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "flamed_dragonbone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getFlamedDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getFireDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getIceDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ice_dragonbone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getIcedDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getIceDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getLightningDragonBoneSwordRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "lightning_dragonbone_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getLightningDragonBoneSword());

        recipe.shape("SB", "  ");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getDragonBoneSword()));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(customItems.getLightningDragonBlood()));

        return recipe;
    }

    public ShapedRecipe getBalloonRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "balloon");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getBalloon());

        recipe.shape("SWS", "WSW", "SWS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSpectralSilt()));
        recipe.setIngredient('W', Material.WHITE_WOOL);

        return recipe;
    }

    public ShapedRecipe getCobaltShieldRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "cobalt_shield");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getCobaltShield());

        recipe.shape("SSS", "SHS", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSpectralSilt()));
        recipe.setIngredient('H', Material.SHIELD);

        return recipe;
    }

    public ShapedRecipe getObsidianSkullRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "obsidian_skull");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getObsidianSkull());

        recipe.shape("OBO", "PWP", "OBO");

        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('B', Material.BLAZE_POWDER);
        recipe.setIngredient('P', new RecipeChoice.ExactChoice(customItems.getFireResistancePotion()));
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        return recipe;
    }

    public ShapedRecipe getSunglassesRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "sunglasses");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getSunglasses());

        recipe.shape("S S", "GTG", "S S");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSpectralSilt()));
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('T', Material.STICK);

        return recipe;
    }

    public ShapedRecipe getCrackedBlackDragonScaleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "cracked_black_dragonscale");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getCrackedBlackDragonScale());

        recipe.shape("SSS", "SES", "SSS");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSpectralSilt()));
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(customItems.getEnderDragonScale()));

        return recipe;
    }

    public ShapedRecipe getBlackDragonScaleRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "black_dragonscale");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getBlackDragonScale());

        recipe.shape("   ", "NEC", "   ");

        recipe.setIngredient('N', Material.NETHER_STAR);
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(customItems.getEnderDragonScale()));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(customItems.getCrackedBlackDragonScale()));

        return recipe;
    }

    public ShapedRecipe getAnkhCharmRecipe() {

        NamespacedKey key = new NamespacedKey(plugin, "ankh_charm");

        ShapedRecipe recipe = new ShapedRecipe(key, customItems.getAnkhCharm());

        recipe.shape("GSG", "RMF", "GVG");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(customItems.getSunglasses()));
        recipe.setIngredient('R', new RecipeChoice.ExactChoice(customItems.getRingofFreeAction()));
        recipe.setIngredient('M', new RecipeChoice.ExactChoice(customItems.getMixedColorDragonScale()));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(customItems.getForbiddenFruit()));
        recipe.setIngredient('V', new RecipeChoice.ExactChoice(customItems.getVitamins()));

        return recipe;
    }

    public ShapedRecipe getWarpedScrollRecipe() {

        ItemStack warpedScroll = customItems.getWarpedScroll();
        warpedScroll.setAmount(3);

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