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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
/**
 * CustomItems is a utility class creating and storing every custom item
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class CustomItems {

    private final FileConfiguration config = CustomConfig.getItemConfig();
    private final FileConfiguration noTreePunching = CustomConfig.getNtrConfig();
    private final FileConfiguration iceFire = CustomConfig.getIceFireGearConfig();
    private final FileConfiguration spartanWeaponry = CustomConfig.getSpartanWeaponryConfig();
    private final FileConfiguration toughasNails = CustomConfig.getTanConfig();

    private ItemStack flintAxe;
    private ItemStack flintKnife;
    private ItemStack flintPickaxe;
    private ItemStack flintShovel;
    private ItemStack flintHoe;
    private ItemStack plantFiber;
    private ItemStack plantString;
    private ItemStack flintShard;
    private ItemStack dragonBone;
    private ItemStack witherbone;
    private ItemStack blueDragonscales;
    private ItemStack bronzeDragonscales;
    private ItemStack grayDragonscales;
    private ItemStack greenDragonscales;
    private ItemStack redDragonscales;
    private ItemStack sapphireDragonscales;
    private ItemStack silverDragonscales;
    private ItemStack whiteDragonscales;
    private ItemStack amethystDragonscales;
    private ItemStack blackDragonscales;
    private ItemStack copperDragonscales;
    private ItemStack electricDragonscales;
    private ItemStack blueSeaSerpentScales;
    private ItemStack bronzeSeaSerpentScales;
    private ItemStack deepBlueSeaSerpentScales;
    private ItemStack greenSeaSerpentScales;
    private ItemStack purpleSeaSerpentScales;
    private ItemStack redSeaSerpentScales;
    private ItemStack tealSeaSerpentScales;
    private ItemStack shinyScales;
    private ItemStack fireDragonBlood;
    private ItemStack iceDragonBlood;
    private ItemStack lightningDragonBlood;
    private ItemStack fireDragonHeart;
    private ItemStack iceDragonHeart;
    private ItemStack lightningDragonHeart;
    private ItemStack fireDragonSkull;
    private ItemStack iceDragonSkull;
    private ItemStack lightningDragonSkull;
    private ItemStack fireDragonFlesh;
    private ItemStack iceDragonFlesh;
    private ItemStack lightningDragonFlesh;
    private ItemStack fireDragonsteelIngot;
    private ItemStack iceDragonsteelIngot;
    private ItemStack lightningDragonsteelIngot;
    private ItemStack blueDragonscaleHelmet;
    private ItemStack blueDragonscaleChestplate;
    private ItemStack blueDragonscaleLeggings;
    private ItemStack blueDragonscaleBoots;
    private ItemStack bronzeDragonscaleHelmet;
    private ItemStack bronzeDragonscaleChestplate;
    private ItemStack bronzeDragonscaleLeggings;
    private ItemStack bronzeDragonscaleBoots;
    private ItemStack grayDragonscaleHelmet;
    private ItemStack grayDragonscaleChestplate;
    private ItemStack grayDragonscaleLeggings;
    private ItemStack grayDragonscaleBoots;
    private ItemStack greenDragonscaleHelmet;
    private ItemStack greenDragonscaleChestplate;
    private ItemStack greenDragonscaleLeggings;
    private ItemStack greenDragonscaleBoots;
    private ItemStack redDragonscaleHelmet;
    private ItemStack redDragonscaleChestplate;
    private ItemStack redDragonscaleLeggings;
    private ItemStack redDragonscaleBoots;
    private ItemStack sapphireDragonscaleHelmet;
    private ItemStack sapphireDragonscaleChestplate;
    private ItemStack sapphireDragonscaleLeggings;
    private ItemStack sapphireDragonscaleBoots;
    private ItemStack silverDragonscaleHelmet;
    private ItemStack silverDragonscaleChestplate;
    private ItemStack silverDragonscaleLeggings;
    private ItemStack silverDragonscaleBoots;
    private ItemStack whiteDragonscaleHelmet;
    private ItemStack whiteDragonscaleChestplate;
    private ItemStack whiteDragonscaleLeggings;
    private ItemStack whiteDragonscaleBoots;
    private ItemStack amethystDragonscaleHelmet;
    private ItemStack amethystDragonscaleChestplate;
    private ItemStack amethystDragonscaleLeggings;
    private ItemStack amethystDragonscaleBoots;
    private ItemStack blackDragonscaleHelmet;
    private ItemStack blackDragonscaleChestplate;
    private ItemStack blackDragonscaleLeggings;
    private ItemStack blackDragonscaleBoots;
    private ItemStack copperDragonscaleHelmet;
    private ItemStack copperDragonscaleChestplate;
    private ItemStack copperDragonscaleLeggings;
    private ItemStack copperDragonscaleBoots;
    private ItemStack electricDragonscaleHelmet;
    private ItemStack electricDragonscaleChestplate;
    private ItemStack electricDragonscaleLeggings;
    private ItemStack electricDragonscaleBoots;
    private ItemStack blueTideGuardianHelmet;
    private ItemStack blueTideGuardianChestplate;
    private ItemStack blueTideGuardianLeggings;
    private ItemStack blueTideGuardianBoots;
    private ItemStack bronzeTideGuardianHelmet;
    private ItemStack bronzeTideGuardianChestplate;
    private ItemStack bronzeTideGuardianLeggings;
    private ItemStack bronzeTideGuardianBoots;
    private ItemStack deepBlueTideGuardianHelmet;
    private ItemStack deepBlueTideGuardianChestplate;
    private ItemStack deepBlueTideGuardianLeggings;
    private ItemStack deepBlueTideGuardianBoots;
    private ItemStack greenTideGuardianHelmet;
    private ItemStack greenTideGuardianChestplate;
    private ItemStack greenTideGuardianLeggings;
    private ItemStack greenTideGuardianBoots;
    private ItemStack purpleTideGuardianHelmet;
    private ItemStack purpleTideGuardianChestplate;
    private ItemStack purpleTideGuardianLeggings;
    private ItemStack purpleTideGuardianBoots;
    private ItemStack redTideGuardianHelmet;
    private ItemStack redTideGuardianChestplate;
    private ItemStack redTideGuardianLeggings;
    private ItemStack redTideGuardianBoots;
    private ItemStack tealTideGuardianHelmet;
    private ItemStack tealTideGuardianChestplate;
    private ItemStack tealTideGuardianLeggings;
    private ItemStack tealTideGuardianBoots;
    private ItemStack dragonBonePickaxe;
    private ItemStack dragonBoneAxe;
    private ItemStack dragonBoneShovel;
    private ItemStack dragonBoneHoe;
    private ItemStack dragonBoneSword;
    private ItemStack dragonBoneBow;
    private ItemStack flamedDragonboneSword;
    private ItemStack icedDragonboneSword;
    private ItemStack lightningDragonboneSword;
    private ItemStack dragonsEye;
    private ItemStack poisonStone;
    private ItemStack potionRingResistance;
    private ItemStack potionRingRegeneration;
    private ItemStack potionRingHaste;
    private ItemStack potionRingStrength;
    private ItemStack potionRingSpeed;
    private ItemStack potionRingJumpBoost;
    private ItemStack enderQueensCrown;
    private ItemStack sunglasses;
    private ItemStack balloon;
    private ItemStack cobaltShield;
    private ItemStack obsidianSkull;
    private ItemStack obsidianShield;
    private ItemStack forbiddenFruit;
    private ItemStack vitamins;
    private ItemStack ringOverclocking;
    private ItemStack shulkerHeart;
    private ItemStack ringFreeAction;
    private ItemStack bezoar;
    private ItemStack enderDragonscale;
    private ItemStack crackedBlackDragonscale;
    private ItemStack blackDragonscale;
    private ItemStack mixedColorDragonscale;
    private ItemStack ankhCharm;
    private ItemStack ankhShield;
    private ItemStack ironRing;
    private ItemStack magicMirror;
    private ItemStack recallPotion;
    private ItemStack wormholeMirror;
    private ItemStack wormholePotion;
    private ItemStack luckyHorseshoe;
    private ItemStack battleBurrito;
    private ItemStack scarliteRing;
    private ItemStack spectralSilt;
    private ItemStack disintegrationTablet;
    private ItemStack brokenHeart;
    private ItemStack crossNecklace;
    private ItemStack wrathPendant;
    private ItemStack pridePendant;
    private ItemStack goldenCrown;
    private ItemStack gluttonyPendant;
    private ItemStack sinPendant;
    private ItemStack flareGun;
    private ItemStack flare;
    private ItemStack phytoprotostasiaAmulet;
    private ItemStack potionRing;
    private ItemStack emeraldRing;
    private ItemStack emeraldAmulet;
    private ItemStack glowingIngot;
    private ItemStack glowingPowder;
    private ItemStack glowingGem;
    private ItemStack dwarfStout;
    private ItemStack fairyDew;
    private ItemStack stoneNegativeGravity;
    private ItemStack stoneInertiaNull;
    private ItemStack stoneGreaterInertia;
    private ItemStack ringEnchantedEyes;
    private ItemStack stoneSea;
    private ItemStack polarizedStone;
    private ItemStack ringFairies;
    private ItemStack ringDwarves;
    private ItemStack witherRing;
    private ItemStack shieldHonor;
    private ItemStack minersRing;
    private ItemStack warpedScroll;
    private ItemStack fireResistancePotion;
    private ItemStack fireDragonsteelSword;
    private ItemStack fireDragonsteelPickaxe;
    private ItemStack fireDragonsteelAxe;
    private ItemStack fireDragonsteelShovel;
    private ItemStack fireDragonsteelHoe;
    private ItemStack iceDragonsteelSword;
    private ItemStack iceDragonsteelPickaxe;
    private ItemStack iceDragonsteelAxe;
    private ItemStack iceDragonsteelShovel;
    private ItemStack iceDragonsteelHoe;
    private ItemStack lightningDragonsteelSword;
    private ItemStack lightningDragonsteelPickaxe;
    private ItemStack lightningDragonsteelAxe;
    private ItemStack lightningDragonsteelShovel;
    private ItemStack lightningDragonsteelHoe;
    private ItemStack fireDragonsteelHelmet;
    private ItemStack fireDragonsteelChestplate;
    private ItemStack fireDragonsteelLeggings;
    private ItemStack fireDragonsteelBoots;
    private ItemStack iceDragonsteelHelmet;
    private ItemStack iceDragonsteelChestplate;
    private ItemStack iceDragonsteelLeggings;
    private ItemStack iceDragonsteelBoots;
    private ItemStack lightningDragonsteelHelmet;
    private ItemStack lightningDragonsteelChestplate;
    private ItemStack lightningDragonsteelLeggings;
    private ItemStack lightningDragonsteelBoots;
    private ItemStack dragonBoneRapier;
    private ItemStack dragonBoneKatana;
    private ItemStack dragonBoneGreatsword;
    private ItemStack dragonBoneLongsword;
    private ItemStack dragonBoneSpear;
    private ItemStack dragonBoneSaber;
    private ItemStack dragonBoneBoomerang;
    private ItemStack dragonBoneDagger;
    private ItemStack dragonBoneGlaive;
    private ItemStack dragonBoneHalberd;
    private ItemStack dragonBoneHammer;
    private ItemStack dragonBoneJavelin;
    private ItemStack dragonBoneLance;
    private ItemStack dragonBoneMace;
    private ItemStack dragonBonePike;
    private ItemStack dragonBoneQuarterstaff;
    private ItemStack dragonBoneThrowingAxe;
    private ItemStack dragonBoneThrowingKnife;
    private ItemStack dragonBoneWarhammer;
    private ItemStack dragonBoneBattleaxe;
    private ItemStack dragonBoneLongbow;
    private ItemStack dragonBoneCrossbow;
    private ItemStack flamedDragonboneRapier;
    private ItemStack flamedDragonboneKatana;
    private ItemStack flamedDragonboneGreatsword;
    private ItemStack flamedDragonboneLongsword;
    private ItemStack flamedDragonboneSpear;
    private ItemStack flamedDragonboneSaber;
    private ItemStack flamedDragonboneBoomerang;
    private ItemStack flamedDragonboneDagger;
    private ItemStack flamedDragonboneGlaive;
    private ItemStack flamedDragonboneHalberd;
    private ItemStack flamedDragonboneHammer;
    private ItemStack flamedDragonboneJavelin;
    private ItemStack flamedDragonboneLance;
    private ItemStack flamedDragonboneMace;
    private ItemStack flamedDragonbonePike;
    private ItemStack flamedDragonboneQuarterstaff;
    private ItemStack flamedDragonboneThrowingAxe;
    private ItemStack flamedDragonboneThrowingKnife;
    private ItemStack flamedDragonboneWarhammer;
    private ItemStack flamedDragonboneBattleaxe;
    private ItemStack flamedDragonboneLongbow;
    private ItemStack flamedDragonboneCrossbow;
    private ItemStack icedDragonboneRapier;
    private ItemStack icedDragonboneKatana;
    private ItemStack icedDragonboneGreatsword;
    private ItemStack icedDragonboneLongsword;
    private ItemStack icedDragonboneSpear;
    private ItemStack icedDragonboneSaber;
    private ItemStack icedDragonboneBoomerang;
    private ItemStack icedDragonboneDagger;
    private ItemStack icedDragonboneGlaive;
    private ItemStack icedDragonboneHalberd;
    private ItemStack icedDragonboneHammer;
    private ItemStack icedDragonboneJavelin;
    private ItemStack icedDragonboneLance;
    private ItemStack icedDragonboneMace;
    private ItemStack icedDragonbonePike;
    private ItemStack icedDragonboneQuarterstaff;
    private ItemStack icedDragonboneThrowingAxe;
    private ItemStack icedDragonboneThrowingKnife;
    private ItemStack icedDragonboneWarhammer;
    private ItemStack icedDragonboneBattleaxe;
    private ItemStack icedDragonboneLongbow;
    private ItemStack icedDragonboneCrossbow;
    private ItemStack lightningDragonboneRapier;
    private ItemStack lightningDragonboneKatana;
    private ItemStack lightningDragonboneGreatsword;
    private ItemStack lightningDragonboneLongsword;
    private ItemStack lightningDragonboneSpear;
    private ItemStack lightningDragonboneSaber;
    private ItemStack lightningDragonboneBoomerang;
    private ItemStack lightningDragonboneDagger;
    private ItemStack lightningDragonboneGlaive;
    private ItemStack lightningDragonboneHalberd;
    private ItemStack lightningDragonboneHammer;
    private ItemStack lightningDragonboneJavelin;
    private ItemStack lightningDragonboneLance;
    private ItemStack lightningDragonboneMace;
    private ItemStack lightningDragonbonePike;
    private ItemStack lightningDragonboneQuarterstaff;
    private ItemStack lightningDragonboneThrowingAxe;
    private ItemStack lightningDragonboneThrowingKnife;
    private ItemStack lightningDragonboneWarhammer;
    private ItemStack lightningDragonboneBattleaxe;
    private ItemStack lightningDragonboneLongbow;
    private ItemStack lightningDragonboneCrossbow;
    private ItemStack fireDragonsteelRapier;
    private ItemStack fireDragonsteelKatana;
    private ItemStack fireDragonsteelGreatsword;
    private ItemStack fireDragonsteelLongsword;
    private ItemStack fireDragonsteelSpear;
    private ItemStack fireDragonsteelSaber;
    private ItemStack fireDragonsteelBoomerang;
    private ItemStack fireDragonsteelDagger;
    private ItemStack fireDragonsteelGlaive;
    private ItemStack fireDragonsteelHalberd;
    private ItemStack fireDragonsteelHammer;
    private ItemStack fireDragonsteelJavelin;
    private ItemStack fireDragonsteelLance;
    private ItemStack fireDragonsteelMace;
    private ItemStack fireDragonsteelPike;
    private ItemStack fireDragonsteelQuarterstaff;
    private ItemStack fireDragonsteelThrowingAxe;
    private ItemStack fireDragonsteelThrowingKnife;
    private ItemStack fireDragonsteelWarhammer;
    private ItemStack fireDragonsteelBattleaxe;
    private ItemStack fireDragonsteelLongbow;
    private ItemStack fireDragonsteelCrossbow;
    private ItemStack iceDragonsteelRapier;
    private ItemStack iceDragonsteelKatana;
    private ItemStack iceDragonsteelGreatsword;
    private ItemStack iceDragonsteelLongsword;
    private ItemStack iceDragonsteelSpear;
    private ItemStack iceDragonsteelSaber;
    private ItemStack iceDragonsteelBoomerang;
    private ItemStack iceDragonsteelDagger;
    private ItemStack iceDragonsteelGlaive;
    private ItemStack iceDragonsteelHalberd;
    private ItemStack iceDragonsteelHammer;
    private ItemStack iceDragonsteelJavelin;
    private ItemStack iceDragonsteelLance;
    private ItemStack iceDragonsteelMace;
    private ItemStack iceDragonsteelPike;
    private ItemStack iceDragonsteelQuarterstaff;
    private ItemStack iceDragonsteelThrowingAxe;
    private ItemStack iceDragonsteelThrowingKnife;
    private ItemStack iceDragonsteelWarhammer;
    private ItemStack iceDragonsteelBattleaxe;
    private ItemStack iceDragonsteelLongbow;
    private ItemStack iceDragonsteelCrossbow;
    private ItemStack lightningDragonsteelRapier;
    private ItemStack lightningDragonsteelKatana;
    private ItemStack lightningDragonsteelGreatsword;
    private ItemStack lightningDragonsteelLongsword;
    private ItemStack lightningDragonsteelSpear;
    private ItemStack lightningDragonsteelSaber;
    private ItemStack lightningDragonsteelBoomerang;
    private ItemStack lightningDragonsteelDagger;
    private ItemStack lightningDragonsteelGlaive;
    private ItemStack lightningDragonsteelHalberd;
    private ItemStack lightningDragonsteelHammer;
    private ItemStack lightningDragonsteelJavelin;
    private ItemStack lightningDragonsteelLance;
    private ItemStack lightningDragonsteelMace;
    private ItemStack lightningDragonsteelPike;
    private ItemStack lightningDragonsteelQuarterstaff;
    private ItemStack lightningDragonsteelThrowingAxe;
    private ItemStack lightningDragonsteelThrowingKnife;
    private ItemStack lightningDragonsteelWarhammer;
    private ItemStack lightningDragonsteelBattleaxe;
    private ItemStack lightningDragonsteelLongbow;
    private ItemStack lightningDragonsteelCrossbow;
    private ItemStack fireDragonsteelBlock;
    private ItemStack iceDragonsteelBlock;
    private ItemStack lightningDragonsteelBlock;
    private ItemStack boundScroll;
    private ItemStack returnScroll;
    private ItemStack handle;
    private ItemStack pole;
    private ItemStack witherboneHandle;
    private ItemStack witherbonePole;
    private ItemStack netheriteRapier;
    private ItemStack netheriteKatana;
    private ItemStack netheriteGreatsword;
    private ItemStack netheriteLongsword;
    private ItemStack netheriteSpear;
    private ItemStack netheriteSaber;
    private ItemStack netheriteBoomerang;
    private ItemStack netheriteDagger;
    private ItemStack netheriteGlaive;
    private ItemStack netheriteHalberd;
    private ItemStack netheriteHammer;
    private ItemStack netheriteJavelin;
    private ItemStack netheriteLance;
    private ItemStack netheriteMace;
    private ItemStack netheritePike;
    private ItemStack netheriteQuarterstaff;
    private ItemStack netheriteThrowingAxe;
    private ItemStack netheriteThrowingKnife;
    private ItemStack netheriteWarhammer;
    private ItemStack netheriteBattleaxe;
    private ItemStack netheriteLongbow;
    private ItemStack netheriteCrossbow;
    private ItemStack diamondRapier;
    private ItemStack diamondKatana;
    private ItemStack diamondGreatsword;
    private ItemStack diamondLongsword;
    private ItemStack diamondSpear;
    private ItemStack diamondSaber;
    private ItemStack diamondBoomerang;
    private ItemStack diamondDagger;
    private ItemStack diamondGlaive;
    private ItemStack diamondHalberd;
    private ItemStack diamondHammer;
    private ItemStack diamondJavelin;
    private ItemStack diamondLance;
    private ItemStack diamondMace;
    private ItemStack diamondPike;
    private ItemStack diamondQuarterstaff;
    private ItemStack diamondThrowingAxe;
    private ItemStack diamondThrowingKnife;
    private ItemStack diamondWarhammer;
    private ItemStack diamondBattleaxe;
    private ItemStack diamondLongbow;
    private ItemStack diamondCrossbow;
    private ItemStack ironRapier;
    private ItemStack ironKatana;
    private ItemStack ironGreatsword;
    private ItemStack ironLongsword;
    private ItemStack ironSpear;
    private ItemStack ironSaber;
    private ItemStack ironBoomerang;
    private ItemStack ironDagger;
    private ItemStack ironGlaive;
    private ItemStack ironHalberd;
    private ItemStack ironHammer;
    private ItemStack ironJavelin;
    private ItemStack ironLance;
    private ItemStack ironMace;
    private ItemStack ironPike;
    private ItemStack ironQuarterstaff;
    private ItemStack ironThrowingAxe;
    private ItemStack ironThrowingKnife;
    private ItemStack ironWarhammer;
    private ItemStack ironBattleaxe;
    private ItemStack ironLongbow;
    private ItemStack ironCrossbow;
    private ItemStack goldenRapier;
    private ItemStack goldenKatana;
    private ItemStack goldenGreatsword;
    private ItemStack goldenLongsword;
    private ItemStack goldenSpear;
    private ItemStack goldenSaber;
    private ItemStack goldenBoomerang;
    private ItemStack goldenDagger;
    private ItemStack goldenGlaive;
    private ItemStack goldenHalberd;
    private ItemStack goldenHammer;
    private ItemStack goldenJavelin;
    private ItemStack goldenLance;
    private ItemStack goldenMace;
    private ItemStack goldenPike;
    private ItemStack goldenQuarterstaff;
    private ItemStack goldenThrowingAxe;
    private ItemStack goldenThrowingKnife;
    private ItemStack goldenWarhammer;
    private ItemStack goldenBattleaxe;
    private ItemStack goldenLongbow;
    private ItemStack goldenCrossbow;
    private ItemStack stoneRapier;
    private ItemStack stoneKatana;
    private ItemStack stoneGreatsword;
    private ItemStack stoneLongsword;
    private ItemStack stoneSpear;
    private ItemStack stoneSaber;
    private ItemStack stoneBoomerang;
    private ItemStack stoneDagger;
    private ItemStack stoneGlaive;
    private ItemStack stoneHalberd;
    private ItemStack stoneHammer;
    private ItemStack stoneJavelin;
    private ItemStack stoneLance;
    private ItemStack stoneMace;
    private ItemStack stonePike;
    private ItemStack stoneQuarterstaff;
    private ItemStack stoneThrowingAxe;
    private ItemStack stoneThrowingKnife;
    private ItemStack stoneWarhammer;
    private ItemStack stoneBattleaxe;
    private ItemStack woodenRapier;
    private ItemStack woodenKatana;
    private ItemStack woodenGreatsword;
    private ItemStack woodenLongsword;
    private ItemStack woodenSpear;
    private ItemStack woodenSaber;
    private ItemStack woodenBoomerang;
    private ItemStack woodenDagger;
    private ItemStack woodenGlaive;
    private ItemStack woodenHalberd;
    private ItemStack woodenHammer;
    private ItemStack woodenJavelin;
    private ItemStack woodenLance;
    private ItemStack woodenMace;
    private ItemStack woodenPike;
    private ItemStack woodenQuarterstaff;
    private ItemStack woodenThrowingAxe;
    private ItemStack woodenThrowingKnife;
    private ItemStack woodenWarhammer;
    private ItemStack woodenBattleaxe;
    private ItemStack woodenLongbow;
    private ItemStack woodenCrossbow;
    private ItemStack woodenClub;
    private ItemStack leatherLongbow;
    private ItemStack leatherCrossbow;
    private ItemStack copperRapier;
    private ItemStack copperKatana;
    private ItemStack copperGreatsword;
    private ItemStack copperLongsword;
    private ItemStack copperSpear;
    private ItemStack copperSaber;
    private ItemStack copperBoomerang;
    private ItemStack copperDagger;
    private ItemStack copperGlaive;
    private ItemStack copperHalberd;
    private ItemStack copperHammer;
    private ItemStack copperJavelin;
    private ItemStack copperLance;
    private ItemStack copperMace;
    private ItemStack copperPike;
    private ItemStack copperQuarterstaff;
    private ItemStack copperThrowingAxe;
    private ItemStack copperThrowingKnife;
    private ItemStack copperWarhammer;
    private ItemStack copperBattleaxe;
    private ItemStack copperLongbow;
    private ItemStack copperCrossbow;
    private ItemStack studdedClub;
    private ItemStack appleJuice;
    private ItemStack beetrootJuice;
    private ItemStack cactusJuice;
    private ItemStack carrotJuice;
    private ItemStack chorusFruitJuice;
    private ItemStack glisteringMelonJuice;
    private ItemStack goldenAppleJuice;
    private ItemStack goldenCarrotJuice;
    private ItemStack melonJuice;
    private ItemStack pumpkinJuice;
    private ItemStack purifiedWaterBottle;
    private ItemStack waterBottle;
    private ItemStack charcoalFilter;
    private ItemStack iceCube;
    private ItemStack magmaShard;
    private ItemStack jelledSlime;
    private ItemStack thermometer;
    private ItemStack woolHood;
    private ItemStack woolJacket;
    private ItemStack woolPants;
    private ItemStack woolBoots;
    private ItemStack jelledSlimeHelmet;
    private ItemStack jelledSlimeChestplate;
    private ItemStack jelledSlimeLeggings;
    private ItemStack jelledSlimeBoots;

    public CustomItems(RealisticSurvivalPlugin instance) {

        flintAxe = new ItemBuilder(config, 0, noTreePunching, ItemBuilder.AXE, instance);
        flintKnife = new ItemBuilder(config, 1, noTreePunching, ItemBuilder.KNIFE, instance);
        flintPickaxe = new ItemBuilder(config, 2, noTreePunching, ItemBuilder.PICKAXE, instance);
        flintShovel = new ItemBuilder(config, 3, noTreePunching, ItemBuilder.SHOVEL, instance);
        flintHoe = new ItemBuilder(config, 4, noTreePunching, ItemBuilder.HOE, instance);
        plantFiber = new ItemBuilder(config, 5, instance);
        plantString = new ItemBuilder(config, 6, instance);
        flintShard = new ItemBuilder(config, 7, instance);
        dragonBone = new ItemBuilder(config, 8, instance);
        witherbone = new ItemBuilder(config, 9, instance);
        blueDragonscales = new ItemBuilder(config, 10, instance);
        bronzeDragonscales = new ItemBuilder(config, 11, instance);
        grayDragonscales = new ItemBuilder(config, 12, instance);
        greenDragonscales = new ItemBuilder(config, 13, instance);
        redDragonscales = new ItemBuilder(config, 14, instance);
        sapphireDragonscales = new ItemBuilder(config, 15, instance);
        silverDragonscales = new ItemBuilder(config, 16, instance);
        whiteDragonscales = new ItemBuilder(config, 17, instance);
        amethystDragonscales = new ItemBuilder(config, 18, instance);
        blackDragonscales = new ItemBuilder(config, 19, instance);
        copperDragonscales = new ItemBuilder(config, 20, instance);
        electricDragonscales = new ItemBuilder(config, 21, instance);
        blueSeaSerpentScales = new ItemBuilder(config, 22, instance);
        bronzeSeaSerpentScales = new ItemBuilder(config, 23, instance);
        deepBlueSeaSerpentScales = new ItemBuilder(config, 24, instance);
        greenSeaSerpentScales = new ItemBuilder(config, 25, instance);
        purpleSeaSerpentScales = new ItemBuilder(config, 26, instance);
        redSeaSerpentScales = new ItemBuilder(config, 27, instance);
        tealSeaSerpentScales = new ItemBuilder(config, 28, instance);
        shinyScales = new ItemBuilder(config, 29, instance);
        fireDragonBlood = new ItemBuilder(config, 30, instance);
        iceDragonBlood = new ItemBuilder(config, 31, instance);
        lightningDragonBlood = new ItemBuilder(config, 32, instance);
        fireDragonHeart = new ItemBuilder(config, 33, instance);
        iceDragonHeart = new ItemBuilder(config, 34, instance);
        lightningDragonHeart = new ItemBuilder(config, 35, instance);
        fireDragonSkull = new ItemBuilder(config, 36, instance);
        iceDragonSkull = new ItemBuilder(config, 37, instance);
        lightningDragonSkull = new ItemBuilder(config, 38, instance);
        fireDragonFlesh = new ItemBuilder(config, 39, instance);
        iceDragonFlesh = new ItemBuilder(config, 40, instance);
        lightningDragonFlesh = new ItemBuilder(config, 41, instance);
        fireDragonsteelIngot = new ItemBuilder(config, 42, instance);
        iceDragonsteelIngot = new ItemBuilder(config, 43, instance);
        lightningDragonsteelIngot = new ItemBuilder(config, 44, instance);
        blueDragonscaleHelmet = new ItemBuilder(config, 45, iceFire, ItemBuilder.HELMET, instance);
        blueDragonscaleChestplate = new ItemBuilder(config, 46, iceFire, ItemBuilder.CHESTPLATE, instance);
        blueDragonscaleLeggings = new ItemBuilder(config, 47, iceFire, ItemBuilder.LEGGINGS, instance);
        blueDragonscaleBoots = new ItemBuilder(config, 48, iceFire, ItemBuilder.BOOTS, instance);
        bronzeDragonscaleHelmet = new ItemBuilder(config, 49, iceFire, ItemBuilder.HELMET, instance);
        bronzeDragonscaleChestplate = new ItemBuilder(config, 50, iceFire, ItemBuilder.CHESTPLATE, instance);
        bronzeDragonscaleLeggings = new ItemBuilder(config, 51, iceFire, ItemBuilder.LEGGINGS, instance);
        bronzeDragonscaleBoots = new ItemBuilder(config, 52, iceFire, ItemBuilder.BOOTS, instance);
        grayDragonscaleHelmet = new ItemBuilder(config, 53, iceFire, ItemBuilder.HELMET, instance);
        grayDragonscaleChestplate = new ItemBuilder(config, 54, iceFire, ItemBuilder.CHESTPLATE, instance);
        grayDragonscaleLeggings = new ItemBuilder(config, 55, iceFire, ItemBuilder.LEGGINGS, instance);
        grayDragonscaleBoots = new ItemBuilder(config, 56, iceFire, ItemBuilder.BOOTS, instance);
        greenDragonscaleHelmet = new ItemBuilder(config, 57, iceFire, ItemBuilder.HELMET, instance);
        greenDragonscaleChestplate = new ItemBuilder(config, 58, iceFire, ItemBuilder.CHESTPLATE, instance);
        greenDragonscaleLeggings = new ItemBuilder(config, 59, iceFire, ItemBuilder.LEGGINGS, instance);
        greenDragonscaleBoots = new ItemBuilder(config, 60, iceFire, ItemBuilder.BOOTS, instance);
        redDragonscaleHelmet = new ItemBuilder(config, 61, iceFire, ItemBuilder.HELMET, instance);
        redDragonscaleChestplate = new ItemBuilder(config, 62, iceFire, ItemBuilder.CHESTPLATE, instance);
        redDragonscaleLeggings = new ItemBuilder(config, 63, iceFire, ItemBuilder.LEGGINGS, instance);
        redDragonscaleBoots = new ItemBuilder(config, 64, iceFire, ItemBuilder.BOOTS, instance);
        sapphireDragonscaleHelmet = new ItemBuilder(config, 65, iceFire, ItemBuilder.HELMET, instance);
        sapphireDragonscaleChestplate = new ItemBuilder(config, 66, iceFire, ItemBuilder.CHESTPLATE, instance);
        sapphireDragonscaleLeggings = new ItemBuilder(config, 67, iceFire, ItemBuilder.LEGGINGS, instance);
        sapphireDragonscaleBoots = new ItemBuilder(config, 68, iceFire, ItemBuilder.BOOTS, instance);
        silverDragonscaleHelmet = new ItemBuilder(config, 69, iceFire, ItemBuilder.HELMET, instance);
        silverDragonscaleChestplate = new ItemBuilder(config, 70, iceFire, ItemBuilder.CHESTPLATE, instance);
        silverDragonscaleLeggings = new ItemBuilder(config, 71, iceFire, ItemBuilder.LEGGINGS, instance);
        silverDragonscaleBoots = new ItemBuilder(config, 72, iceFire, ItemBuilder.BOOTS, instance);
        whiteDragonscaleHelmet = new ItemBuilder(config, 73, iceFire, ItemBuilder.HELMET, instance);
        whiteDragonscaleChestplate = new ItemBuilder(config, 74, iceFire, ItemBuilder.CHESTPLATE, instance);
        whiteDragonscaleLeggings = new ItemBuilder(config, 75, iceFire, ItemBuilder.LEGGINGS, instance);
        whiteDragonscaleBoots = new ItemBuilder(config, 76, iceFire, ItemBuilder.BOOTS, instance);
        amethystDragonscaleHelmet = new ItemBuilder(config, 77, iceFire, ItemBuilder.HELMET, instance);
        amethystDragonscaleChestplate = new ItemBuilder(config, 78, iceFire, ItemBuilder.CHESTPLATE, instance);
        amethystDragonscaleLeggings = new ItemBuilder(config, 79, iceFire, ItemBuilder.LEGGINGS, instance);
        amethystDragonscaleBoots = new ItemBuilder(config, 80, iceFire, ItemBuilder.BOOTS, instance);
        blackDragonscaleHelmet = new ItemBuilder(config, 81, iceFire, ItemBuilder.HELMET, instance);
        blackDragonscaleChestplate = new ItemBuilder(config, 82, iceFire, ItemBuilder.CHESTPLATE, instance);
        blackDragonscaleLeggings = new ItemBuilder(config, 83, iceFire, ItemBuilder.LEGGINGS, instance);
        blackDragonscaleBoots = new ItemBuilder(config, 84, iceFire, ItemBuilder.BOOTS, instance);
        copperDragonscaleHelmet = new ItemBuilder(config, 85, iceFire, ItemBuilder.HELMET, instance);
        copperDragonscaleChestplate = new ItemBuilder(config, 86, iceFire, ItemBuilder.CHESTPLATE, instance);
        copperDragonscaleLeggings = new ItemBuilder(config, 87, iceFire, ItemBuilder.LEGGINGS, instance);
        copperDragonscaleBoots = new ItemBuilder(config, 88, iceFire, ItemBuilder.BOOTS, instance);
        electricDragonscaleHelmet = new ItemBuilder(config, 89, iceFire, ItemBuilder.HELMET, instance);
        electricDragonscaleChestplate = new ItemBuilder(config, 90, iceFire, ItemBuilder.CHESTPLATE, instance);
        electricDragonscaleLeggings = new ItemBuilder(config, 91, iceFire, ItemBuilder.LEGGINGS, instance);
        electricDragonscaleBoots = new ItemBuilder(config, 92, iceFire, ItemBuilder.BOOTS, instance);
        blueTideGuardianHelmet = new ItemBuilder(config, 93, iceFire, ItemBuilder.HELMET, instance);
        blueTideGuardianChestplate = new ItemBuilder(config, 94, iceFire, ItemBuilder.CHESTPLATE, instance);
        blueTideGuardianLeggings = new ItemBuilder(config, 95, iceFire, ItemBuilder.LEGGINGS, instance);
        blueTideGuardianBoots = new ItemBuilder(config, 96, iceFire, ItemBuilder.BOOTS, instance);
        bronzeTideGuardianHelmet = new ItemBuilder(config, 97, iceFire, ItemBuilder.HELMET, instance);
        bronzeTideGuardianChestplate = new ItemBuilder(config, 98, iceFire, ItemBuilder.CHESTPLATE, instance);
        bronzeTideGuardianLeggings = new ItemBuilder(config, 99, iceFire, ItemBuilder.LEGGINGS, instance);
        bronzeTideGuardianBoots = new ItemBuilder(config, 100, iceFire, ItemBuilder.BOOTS, instance);
        deepBlueTideGuardianHelmet = new ItemBuilder(config, 101, iceFire, ItemBuilder.HELMET, instance);
        deepBlueTideGuardianChestplate = new ItemBuilder(config, 102, iceFire, ItemBuilder.CHESTPLATE, instance);
        deepBlueTideGuardianLeggings = new ItemBuilder(config, 103, iceFire, ItemBuilder.LEGGINGS, instance);
        deepBlueTideGuardianBoots = new ItemBuilder(config, 104, iceFire, ItemBuilder.BOOTS, instance);
        greenTideGuardianHelmet = new ItemBuilder(config, 105, iceFire, ItemBuilder.HELMET, instance);
        greenTideGuardianChestplate = new ItemBuilder(config, 106, iceFire, ItemBuilder.CHESTPLATE, instance);
        greenTideGuardianLeggings = new ItemBuilder(config, 107, iceFire, ItemBuilder.LEGGINGS, instance);
        greenTideGuardianBoots = new ItemBuilder(config, 108, iceFire, ItemBuilder.BOOTS, instance);
        purpleTideGuardianHelmet = new ItemBuilder(config, 109, iceFire, ItemBuilder.HELMET, instance);
        purpleTideGuardianChestplate = new ItemBuilder(config, 110, iceFire, ItemBuilder.CHESTPLATE, instance);
        purpleTideGuardianLeggings = new ItemBuilder(config, 111, iceFire, ItemBuilder.LEGGINGS, instance);
        purpleTideGuardianBoots = new ItemBuilder(config, 112, iceFire, ItemBuilder.BOOTS, instance);
        redTideGuardianHelmet = new ItemBuilder(config, 113, iceFire, ItemBuilder.HELMET, instance);
        redTideGuardianChestplate = new ItemBuilder(config, 114, iceFire, ItemBuilder.CHESTPLATE, instance);
        redTideGuardianLeggings = new ItemBuilder(config, 115, iceFire, ItemBuilder.LEGGINGS, instance);
        redTideGuardianBoots = new ItemBuilder(config, 116, iceFire, ItemBuilder.BOOTS, instance);
        tealTideGuardianHelmet = new ItemBuilder(config, 117, iceFire, ItemBuilder.HELMET, instance);
        tealTideGuardianChestplate = new ItemBuilder(config, 118, iceFire, ItemBuilder.CHESTPLATE, instance);
        tealTideGuardianLeggings = new ItemBuilder(config, 119, iceFire, ItemBuilder.LEGGINGS, instance);
        tealTideGuardianBoots = new ItemBuilder(config, 120, iceFire, ItemBuilder.BOOTS, instance);
        dragonBonePickaxe = new ItemBuilder(config, 121, iceFire, ItemBuilder.PICKAXE, instance);
        dragonBoneAxe = new ItemBuilder(config, 122, iceFire, ItemBuilder.AXE, instance);
        dragonBoneShovel = new ItemBuilder(config, 123, iceFire, ItemBuilder.SHOVEL, instance);
        dragonBoneHoe = new ItemBuilder(config, 124, iceFire, ItemBuilder.HOE, instance);
        dragonBoneSword = new ItemBuilder(config, 125, iceFire, ItemBuilder.SWORD, instance);
        dragonBoneBow = new ItemBuilder(config, 126, instance);
        flamedDragonboneSword = new ItemBuilder(config, 127, iceFire, ItemBuilder.SWORD, instance);
        icedDragonboneSword = new ItemBuilder(config, 128, iceFire, ItemBuilder.SWORD, instance);
        lightningDragonboneSword = new ItemBuilder(config, 129, iceFire, ItemBuilder.SWORD, instance);
        dragonsEye = new ItemBuilder(config, 130, instance);
        poisonStone = new ItemBuilder(config, 131, instance);
        potionRingResistance = new ItemBuilder(config, 132, instance);
        potionRingRegeneration = new ItemBuilder(config, 133, instance);
        potionRingHaste = new ItemBuilder(config, 134, instance);
        potionRingStrength = new ItemBuilder(config, 135, instance);
        potionRingSpeed = new ItemBuilder(config, 136, instance);
        potionRingJumpBoost = new ItemBuilder(config, 137, instance);
        enderQueensCrown = new ItemBuilder(config, 138, instance);
        sunglasses = new ItemBuilder(config, 139, instance);
        balloon = new ItemBuilder(config, 140, instance);
        cobaltShield = new ItemBuilder(config, 141, instance);
        obsidianSkull = new ItemBuilder(config, 142, instance);
        obsidianShield = new ItemBuilder(config, 143, instance);
        forbiddenFruit = new ItemBuilder(config, 144, instance);
        vitamins = new ItemBuilder(config, 145, instance);
        ringOverclocking = new ItemBuilder(config, 146, instance);
        shulkerHeart = new ItemBuilder(config, 147, instance);
        ringFreeAction = new ItemBuilder(config, 148, instance);
        bezoar = new ItemBuilder(config, 149, instance);
        enderDragonscale = new ItemBuilder(config, 150, instance);
        crackedBlackDragonscale = new ItemBuilder(config, 151, instance);
        blackDragonscale = new ItemBuilder(config, 152, instance);
        mixedColorDragonscale = new ItemBuilder(config, 153, instance);
        ankhCharm = new ItemBuilder(config, 154, instance);
        ankhShield = new ItemBuilder(config, 155, instance);
        ironRing = new ItemBuilder(config, 156, instance);
        magicMirror = new ItemBuilder(config, 157, instance);
        recallPotion = new ItemBuilder(config, 158, instance);
        wormholeMirror = new ItemBuilder(config, 159, instance);
        wormholePotion = new ItemBuilder(config, 160, instance);
        luckyHorseshoe = new ItemBuilder(config, 161, instance);
        battleBurrito = new ItemBuilder(config, 162, instance);
        scarliteRing = new ItemBuilder(config, 163, instance);
        spectralSilt = new ItemBuilder(config, 164, instance);
        disintegrationTablet = new ItemBuilder(config, 165, instance);
        brokenHeart = new ItemBuilder(config, 166, instance);
        crossNecklace = new ItemBuilder(config, 167, instance);
        wrathPendant = new ItemBuilder(config, 168, instance);
        pridePendant = new ItemBuilder(config, 169, instance);
        goldenCrown = new ItemBuilder(config, 170, instance);
        gluttonyPendant = new ItemBuilder(config, 171, instance);
        sinPendant = new ItemBuilder(config, 172, instance);
        flareGun = new ItemBuilder(config, 173, instance);
        flare = new ItemBuilder(config, 174, instance);
        phytoprotostasiaAmulet = new ItemBuilder(config, 175, instance);
        potionRing = new ItemBuilder(config, 176, instance);
        emeraldRing = new ItemBuilder(config, 177, instance);
        emeraldAmulet = new ItemBuilder(config, 178, instance);
        glowingIngot = new ItemBuilder(config, 179, instance);
        glowingPowder = new ItemBuilder(config, 180, instance);
        glowingGem = new ItemBuilder(config, 181, instance);
        dwarfStout = new ItemBuilder(config, 182, instance);
        fairyDew = new ItemBuilder(config, 183, instance);
        stoneNegativeGravity = new ItemBuilder(config, 184, instance);
        stoneInertiaNull = new ItemBuilder(config, 185, instance);
        stoneGreaterInertia = new ItemBuilder(config, 186, instance);
        ringEnchantedEyes = new ItemBuilder(config, 187, instance);
        stoneSea = new ItemBuilder(config, 188, instance);
        polarizedStone = new ItemBuilder(config, 189, instance);
        ringFairies = new ItemBuilder(config, 190, instance);
        ringDwarves = new ItemBuilder(config, 191, instance);
        witherRing = new ItemBuilder(config, 192, instance);
        shieldHonor = new ItemBuilder(config, 193, instance);
        minersRing = new ItemBuilder(config, 194, instance);
        warpedScroll = new ItemBuilder(config, 195, instance);
        fireResistancePotion = new ItemBuilder(config, 196, instance);
        fireDragonsteelSword = new ItemBuilder(config, 197, iceFire, ItemBuilder.SWORD, instance);
        fireDragonsteelPickaxe = new ItemBuilder(config, 198, iceFire, ItemBuilder.PICKAXE, instance);
        fireDragonsteelAxe = new ItemBuilder(config, 199, iceFire, ItemBuilder.AXE, instance);
        fireDragonsteelShovel = new ItemBuilder(config, 200, iceFire, ItemBuilder.SHOVEL, instance);
        fireDragonsteelHoe = new ItemBuilder(config, 201, iceFire, ItemBuilder.HOE, instance);
        iceDragonsteelSword = new ItemBuilder(config, 202, iceFire, ItemBuilder.SWORD, instance);
        iceDragonsteelPickaxe = new ItemBuilder(config, 203, iceFire, ItemBuilder.PICKAXE, instance);
        iceDragonsteelAxe = new ItemBuilder(config, 204, iceFire, ItemBuilder.AXE, instance);
        iceDragonsteelShovel = new ItemBuilder(config, 205, iceFire, ItemBuilder.SHOVEL, instance);
        iceDragonsteelHoe = new ItemBuilder(config, 206, iceFire, ItemBuilder.HOE, instance);
        lightningDragonsteelSword = new ItemBuilder(config, 207, iceFire, ItemBuilder.SWORD, instance);
        lightningDragonsteelPickaxe = new ItemBuilder(config, 208, iceFire, ItemBuilder.PICKAXE, instance);
        lightningDragonsteelAxe = new ItemBuilder(config, 209, iceFire, ItemBuilder.AXE, instance);
        lightningDragonsteelShovel = new ItemBuilder(config, 210, iceFire, ItemBuilder.SHOVEL, instance);
        lightningDragonsteelHoe = new ItemBuilder(config, 211, iceFire, ItemBuilder.HOE, instance);
        fireDragonsteelHelmet = new ItemBuilder(config, 212, iceFire, ItemBuilder.HELMET, instance);
        fireDragonsteelChestplate = new ItemBuilder(config, 213, iceFire, ItemBuilder.CHESTPLATE, instance);
        fireDragonsteelLeggings = new ItemBuilder(config, 214, iceFire, ItemBuilder.LEGGINGS, instance);
        fireDragonsteelBoots = new ItemBuilder(config, 215, iceFire, ItemBuilder.BOOTS, instance);
        iceDragonsteelHelmet = new ItemBuilder(config, 216, iceFire, ItemBuilder.HELMET, instance);
        iceDragonsteelChestplate = new ItemBuilder(config, 217, iceFire, ItemBuilder.CHESTPLATE, instance);
        iceDragonsteelLeggings = new ItemBuilder(config, 218, iceFire, ItemBuilder.LEGGINGS, instance);
        iceDragonsteelBoots = new ItemBuilder(config, 219, iceFire, ItemBuilder.BOOTS, instance);
        lightningDragonsteelHelmet = new ItemBuilder(config, 220, iceFire, ItemBuilder.HELMET, instance);
        lightningDragonsteelChestplate = new ItemBuilder(config, 221, iceFire, ItemBuilder.CHESTPLATE, instance);
        lightningDragonsteelLeggings = new ItemBuilder(config, 222, iceFire, ItemBuilder.LEGGINGS, instance);
        lightningDragonsteelBoots = new ItemBuilder(config, 223, iceFire, ItemBuilder.BOOTS, instance);
        dragonBoneRapier = new ItemBuilder(config, 224, spartanWeaponry, ItemBuilder.RAPIER, instance);
        dragonBoneKatana = new ItemBuilder(config, 225, spartanWeaponry, ItemBuilder.KATANA, instance);
        dragonBoneGreatsword = new ItemBuilder(config, 226, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        dragonBoneLongsword = new ItemBuilder(config, 227, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        dragonBoneSpear = new ItemBuilder(config, 228, spartanWeaponry, ItemBuilder.SPEAR, instance);
        dragonBoneSaber = new ItemBuilder(config, 229, spartanWeaponry, ItemBuilder.SABER, instance);
        dragonBoneBoomerang = new ItemBuilder(config, 230, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        dragonBoneDagger = new ItemBuilder(config, 231, spartanWeaponry, ItemBuilder.DAGGER, instance);
        dragonBoneGlaive = new ItemBuilder(config, 232, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        dragonBoneHalberd = new ItemBuilder(config, 233, spartanWeaponry, ItemBuilder.HALBERD, instance);
        dragonBoneHammer = new ItemBuilder(config, 234, spartanWeaponry, ItemBuilder.HAMMER, instance);
        dragonBoneJavelin = new ItemBuilder(config, 235, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        dragonBoneLance = new ItemBuilder(config, 236, spartanWeaponry, ItemBuilder.LANCE, instance);
        dragonBoneMace = new ItemBuilder(config, 237, spartanWeaponry, ItemBuilder.MACE, instance);
        dragonBonePike = new ItemBuilder(config, 238, spartanWeaponry, ItemBuilder.PIKE, instance);
        dragonBoneQuarterstaff = new ItemBuilder(config, 239, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        dragonBoneThrowingAxe = new ItemBuilder(config, 240, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        dragonBoneThrowingKnife = new ItemBuilder(config, 241, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        dragonBoneWarhammer = new ItemBuilder(config, 242, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        dragonBoneBattleaxe = new ItemBuilder(config, 243, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        dragonBoneLongbow = new ItemBuilder(config, 244, instance);
        dragonBoneCrossbow = new ItemBuilder(config, 245, instance);
        flamedDragonboneRapier = new ItemBuilder(config, 246, spartanWeaponry, ItemBuilder.RAPIER, instance);
        flamedDragonboneKatana = new ItemBuilder(config, 247, spartanWeaponry, ItemBuilder.KATANA, instance);
        flamedDragonboneGreatsword = new ItemBuilder(config, 248, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        flamedDragonboneLongsword = new ItemBuilder(config, 249, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        flamedDragonboneSpear = new ItemBuilder(config, 250, spartanWeaponry, ItemBuilder.SPEAR, instance);
        flamedDragonboneSaber = new ItemBuilder(config, 251, spartanWeaponry, ItemBuilder.SABER, instance);
        flamedDragonboneBoomerang = new ItemBuilder(config, 252, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        flamedDragonboneDagger = new ItemBuilder(config, 253, spartanWeaponry, ItemBuilder.DAGGER, instance);
        flamedDragonboneGlaive = new ItemBuilder(config, 254, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        flamedDragonboneHalberd = new ItemBuilder(config, 255, spartanWeaponry, ItemBuilder.HALBERD, instance);
        flamedDragonboneHammer = new ItemBuilder(config, 256, spartanWeaponry, ItemBuilder.HAMMER, instance);
        flamedDragonboneJavelin = new ItemBuilder(config, 257, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        flamedDragonboneLance = new ItemBuilder(config, 258, spartanWeaponry, ItemBuilder.LANCE, instance);
        flamedDragonboneMace = new ItemBuilder(config, 259, spartanWeaponry, ItemBuilder.MACE, instance);
        flamedDragonbonePike = new ItemBuilder(config, 260, spartanWeaponry, ItemBuilder.PIKE, instance);
        flamedDragonboneQuarterstaff = new ItemBuilder(config, 261, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        flamedDragonboneThrowingAxe = new ItemBuilder(config, 262, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        flamedDragonboneThrowingKnife = new ItemBuilder(config, 263, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        flamedDragonboneWarhammer = new ItemBuilder(config, 264, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        flamedDragonboneBattleaxe = new ItemBuilder(config, 265, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        flamedDragonboneLongbow = new ItemBuilder(config, 266, instance);
        flamedDragonboneCrossbow = new ItemBuilder(config, 267, instance);
        icedDragonboneRapier = new ItemBuilder(config, 268, spartanWeaponry, ItemBuilder.RAPIER, instance);
        icedDragonboneKatana = new ItemBuilder(config, 269, spartanWeaponry, ItemBuilder.KATANA, instance);
        icedDragonboneGreatsword = new ItemBuilder(config, 270, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        icedDragonboneLongsword = new ItemBuilder(config, 271, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        icedDragonboneSpear = new ItemBuilder(config, 272, spartanWeaponry, ItemBuilder.SPEAR, instance);
        icedDragonboneSaber = new ItemBuilder(config, 273, spartanWeaponry, ItemBuilder.SABER, instance);
        icedDragonboneBoomerang = new ItemBuilder(config, 274, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        icedDragonboneDagger = new ItemBuilder(config, 275, spartanWeaponry, ItemBuilder.DAGGER, instance);
        icedDragonboneGlaive = new ItemBuilder(config, 276, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        icedDragonboneHalberd = new ItemBuilder(config, 277, spartanWeaponry, ItemBuilder.HALBERD, instance);
        icedDragonboneHammer = new ItemBuilder(config, 278, spartanWeaponry, ItemBuilder.HAMMER, instance);
        icedDragonboneJavelin = new ItemBuilder(config, 279, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        icedDragonboneLance = new ItemBuilder(config, 280, spartanWeaponry, ItemBuilder.LANCE, instance);
        icedDragonboneMace = new ItemBuilder(config, 281, spartanWeaponry, ItemBuilder.MACE, instance);
        icedDragonbonePike = new ItemBuilder(config, 282, spartanWeaponry, ItemBuilder.PIKE, instance);
        icedDragonboneQuarterstaff = new ItemBuilder(config, 283, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        icedDragonboneThrowingAxe = new ItemBuilder(config, 284, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        icedDragonboneThrowingKnife = new ItemBuilder(config, 285, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        icedDragonboneWarhammer = new ItemBuilder(config, 286, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        icedDragonboneBattleaxe = new ItemBuilder(config, 287, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        icedDragonboneLongbow = new ItemBuilder(config, 288, instance);
        icedDragonboneCrossbow = new ItemBuilder(config, 289, instance);
        lightningDragonboneRapier = new ItemBuilder(config, 290, spartanWeaponry, ItemBuilder.RAPIER, instance);
        lightningDragonboneKatana = new ItemBuilder(config, 291, spartanWeaponry, ItemBuilder.KATANA, instance);
        lightningDragonboneGreatsword = new ItemBuilder(config, 292, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        lightningDragonboneLongsword = new ItemBuilder(config, 293, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        lightningDragonboneSpear = new ItemBuilder(config, 294, spartanWeaponry, ItemBuilder.SPEAR, instance);
        lightningDragonboneSaber = new ItemBuilder(config, 295, spartanWeaponry, ItemBuilder.SABER, instance);
        lightningDragonboneBoomerang = new ItemBuilder(config, 296, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        lightningDragonboneDagger = new ItemBuilder(config, 297, spartanWeaponry, ItemBuilder.DAGGER, instance);
        lightningDragonboneGlaive = new ItemBuilder(config, 298, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        lightningDragonboneHalberd = new ItemBuilder(config, 299, spartanWeaponry, ItemBuilder.HALBERD, instance);
        lightningDragonboneHammer = new ItemBuilder(config, 300, spartanWeaponry, ItemBuilder.HAMMER, instance);
        lightningDragonboneJavelin = new ItemBuilder(config, 301, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        lightningDragonboneLance = new ItemBuilder(config, 302, spartanWeaponry, ItemBuilder.LANCE, instance);
        lightningDragonboneMace = new ItemBuilder(config, 303, spartanWeaponry, ItemBuilder.MACE, instance);
        lightningDragonbonePike = new ItemBuilder(config, 304, spartanWeaponry, ItemBuilder.PIKE, instance);
        lightningDragonboneQuarterstaff = new ItemBuilder(config, 305, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        lightningDragonboneThrowingAxe = new ItemBuilder(config, 306, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        lightningDragonboneThrowingKnife = new ItemBuilder(config, 307, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        lightningDragonboneWarhammer = new ItemBuilder(config, 308, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        lightningDragonboneBattleaxe = new ItemBuilder(config, 309, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        lightningDragonboneLongbow = new ItemBuilder(config, 310, instance);
        lightningDragonboneCrossbow = new ItemBuilder(config, 311, instance);
        fireDragonsteelRapier = new ItemBuilder(config, 312, spartanWeaponry, ItemBuilder.RAPIER, instance);
        fireDragonsteelKatana = new ItemBuilder(config, 313, spartanWeaponry, ItemBuilder.KATANA, instance);
        fireDragonsteelGreatsword = new ItemBuilder(config, 314, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        fireDragonsteelLongsword = new ItemBuilder(config, 315, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        fireDragonsteelSpear = new ItemBuilder(config, 316, spartanWeaponry, ItemBuilder.SPEAR, instance);
        fireDragonsteelSaber = new ItemBuilder(config, 317, spartanWeaponry, ItemBuilder.SABER, instance);
        fireDragonsteelBoomerang = new ItemBuilder(config, 318, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        fireDragonsteelDagger = new ItemBuilder(config, 319, spartanWeaponry, ItemBuilder.DAGGER, instance);
        fireDragonsteelGlaive = new ItemBuilder(config, 320, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        fireDragonsteelHalberd = new ItemBuilder(config, 321, spartanWeaponry, ItemBuilder.HALBERD, instance);
        fireDragonsteelHammer = new ItemBuilder(config, 322, spartanWeaponry, ItemBuilder.HAMMER, instance);
        fireDragonsteelJavelin = new ItemBuilder(config, 323, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        fireDragonsteelLance = new ItemBuilder(config, 324, spartanWeaponry, ItemBuilder.LANCE, instance);
        fireDragonsteelMace = new ItemBuilder(config, 325, spartanWeaponry, ItemBuilder.MACE, instance);
        fireDragonsteelPike = new ItemBuilder(config, 326, spartanWeaponry, ItemBuilder.PIKE, instance);
        fireDragonsteelQuarterstaff = new ItemBuilder(config, 327, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        fireDragonsteelThrowingAxe = new ItemBuilder(config, 328, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        fireDragonsteelThrowingKnife = new ItemBuilder(config, 329, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        fireDragonsteelWarhammer = new ItemBuilder(config, 330, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        fireDragonsteelBattleaxe = new ItemBuilder(config, 331, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        fireDragonsteelLongbow = new ItemBuilder(config, 332, instance);
        fireDragonsteelCrossbow = new ItemBuilder(config, 333, instance);
        iceDragonsteelRapier = new ItemBuilder(config, 334, spartanWeaponry, ItemBuilder.RAPIER, instance);
        iceDragonsteelKatana = new ItemBuilder(config, 335, spartanWeaponry, ItemBuilder.KATANA, instance);
        iceDragonsteelGreatsword = new ItemBuilder(config, 336, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        iceDragonsteelLongsword = new ItemBuilder(config, 337, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        iceDragonsteelSpear = new ItemBuilder(config, 338, spartanWeaponry, ItemBuilder.SPEAR, instance);
        iceDragonsteelSaber = new ItemBuilder(config, 339, spartanWeaponry, ItemBuilder.SABER, instance);
        iceDragonsteelBoomerang = new ItemBuilder(config, 340, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        iceDragonsteelDagger = new ItemBuilder(config, 341, spartanWeaponry, ItemBuilder.DAGGER, instance);
        iceDragonsteelGlaive = new ItemBuilder(config, 342, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        iceDragonsteelHalberd = new ItemBuilder(config, 343, spartanWeaponry, ItemBuilder.HALBERD, instance);
        iceDragonsteelHammer = new ItemBuilder(config, 344, spartanWeaponry, ItemBuilder.HAMMER, instance);
        iceDragonsteelJavelin = new ItemBuilder(config, 345, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        iceDragonsteelLance = new ItemBuilder(config, 346, spartanWeaponry, ItemBuilder.LANCE, instance);
        iceDragonsteelMace = new ItemBuilder(config, 347, spartanWeaponry, ItemBuilder.MACE, instance);
        iceDragonsteelPike = new ItemBuilder(config, 348, spartanWeaponry, ItemBuilder.PIKE, instance);
        iceDragonsteelQuarterstaff = new ItemBuilder(config, 349, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        iceDragonsteelThrowingAxe = new ItemBuilder(config, 350, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        iceDragonsteelThrowingKnife = new ItemBuilder(config, 351, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        iceDragonsteelWarhammer = new ItemBuilder(config, 352, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        iceDragonsteelBattleaxe = new ItemBuilder(config, 353, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        iceDragonsteelLongbow = new ItemBuilder(config, 354, instance);
        iceDragonsteelCrossbow = new ItemBuilder(config, 355, instance);
        lightningDragonsteelRapier = new ItemBuilder(config, 356, spartanWeaponry, ItemBuilder.RAPIER, instance);
        lightningDragonsteelKatana = new ItemBuilder(config, 357, spartanWeaponry, ItemBuilder.KATANA, instance);
        lightningDragonsteelGreatsword = new ItemBuilder(config, 358, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        lightningDragonsteelLongsword = new ItemBuilder(config, 359, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        lightningDragonsteelSpear = new ItemBuilder(config, 360, spartanWeaponry, ItemBuilder.SPEAR, instance);
        lightningDragonsteelSaber = new ItemBuilder(config, 361, spartanWeaponry, ItemBuilder.SABER, instance);
        lightningDragonsteelBoomerang = new ItemBuilder(config, 362, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        lightningDragonsteelDagger = new ItemBuilder(config, 363, spartanWeaponry, ItemBuilder.DAGGER, instance);
        lightningDragonsteelGlaive = new ItemBuilder(config, 364, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        lightningDragonsteelHalberd = new ItemBuilder(config, 365, spartanWeaponry, ItemBuilder.HALBERD, instance);
        lightningDragonsteelHammer = new ItemBuilder(config, 366, spartanWeaponry, ItemBuilder.HAMMER, instance);
        lightningDragonsteelJavelin = new ItemBuilder(config, 367, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        lightningDragonsteelLance = new ItemBuilder(config, 368, spartanWeaponry, ItemBuilder.LANCE, instance);
        lightningDragonsteelMace = new ItemBuilder(config, 369, spartanWeaponry, ItemBuilder.MACE, instance);
        lightningDragonsteelPike = new ItemBuilder(config, 370, spartanWeaponry, ItemBuilder.PIKE, instance);
        lightningDragonsteelQuarterstaff = new ItemBuilder(config, 371, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        lightningDragonsteelThrowingAxe = new ItemBuilder(config, 372, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        lightningDragonsteelThrowingKnife = new ItemBuilder(config, 373, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        lightningDragonsteelWarhammer = new ItemBuilder(config, 374, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        lightningDragonsteelBattleaxe = new ItemBuilder(config, 375, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        lightningDragonsteelLongbow = new ItemBuilder(config, 376, instance);
        lightningDragonsteelCrossbow = new ItemBuilder(config, 377, instance);
        fireDragonsteelBlock = new ItemBuilder(config, 378, instance);
        iceDragonsteelBlock = new ItemBuilder(config, 379, instance);
        lightningDragonsteelBlock = new ItemBuilder(config, 380, instance);
        boundScroll = new ItemBuilder(config, 381, instance);
        returnScroll = new ItemBuilder(config, 382, instance);
        handle = new ItemBuilder(config, 383, instance);
        pole = new ItemBuilder(config, 384, instance);
        witherboneHandle = new ItemBuilder(config, 385, instance);
        witherbonePole = new ItemBuilder(config, 386, instance);
        netheriteRapier = new ItemBuilder(config, 387, spartanWeaponry, ItemBuilder.RAPIER, instance);
        netheriteKatana = new ItemBuilder(config, 388, spartanWeaponry, ItemBuilder.KATANA, instance);
        netheriteGreatsword = new ItemBuilder(config, 389, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        netheriteLongsword = new ItemBuilder(config, 390, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        netheriteSpear = new ItemBuilder(config, 391, spartanWeaponry, ItemBuilder.SPEAR, instance);
        netheriteSaber = new ItemBuilder(config, 392, spartanWeaponry, ItemBuilder.SABER, instance);
        netheriteBoomerang = new ItemBuilder(config, 393, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        netheriteDagger = new ItemBuilder(config, 394, spartanWeaponry, ItemBuilder.DAGGER, instance);
        netheriteGlaive = new ItemBuilder(config, 395, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        netheriteHalberd = new ItemBuilder(config, 396, spartanWeaponry, ItemBuilder.HALBERD, instance);
        netheriteHammer = new ItemBuilder(config, 397, spartanWeaponry, ItemBuilder.HAMMER, instance);
        netheriteJavelin = new ItemBuilder(config, 398, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        netheriteLance = new ItemBuilder(config, 399, spartanWeaponry, ItemBuilder.LANCE, instance);
        netheriteMace = new ItemBuilder(config, 400, spartanWeaponry, ItemBuilder.MACE, instance);
        netheritePike = new ItemBuilder(config, 401, spartanWeaponry, ItemBuilder.PIKE, instance);
        netheriteQuarterstaff = new ItemBuilder(config, 402, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        netheriteThrowingAxe = new ItemBuilder(config, 403, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        netheriteThrowingKnife = new ItemBuilder(config, 404, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        netheriteWarhammer = new ItemBuilder(config, 405, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        netheriteBattleaxe = new ItemBuilder(config, 406, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        netheriteLongbow = new ItemBuilder(config, 407, instance);
        netheriteCrossbow = new ItemBuilder(config, 408, instance);
        diamondRapier = new ItemBuilder(config, 409, spartanWeaponry, ItemBuilder.RAPIER, instance);
        diamondKatana = new ItemBuilder(config, 410, spartanWeaponry, ItemBuilder.KATANA, instance);
        diamondGreatsword = new ItemBuilder(config, 411, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        diamondLongsword = new ItemBuilder(config, 412, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        diamondSpear = new ItemBuilder(config, 413, spartanWeaponry, ItemBuilder.SPEAR, instance);
        diamondSaber = new ItemBuilder(config, 414, spartanWeaponry, ItemBuilder.SABER, instance);
        diamondBoomerang = new ItemBuilder(config, 415, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        diamondDagger = new ItemBuilder(config, 416, spartanWeaponry, ItemBuilder.DAGGER, instance);
        diamondGlaive = new ItemBuilder(config, 417, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        diamondHalberd = new ItemBuilder(config, 418, spartanWeaponry, ItemBuilder.HALBERD, instance);
        diamondHammer = new ItemBuilder(config, 419, spartanWeaponry, ItemBuilder.HAMMER, instance);
        diamondJavelin = new ItemBuilder(config, 420, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        diamondLance = new ItemBuilder(config, 421, spartanWeaponry, ItemBuilder.LANCE, instance);
        diamondMace = new ItemBuilder(config, 422, spartanWeaponry, ItemBuilder.MACE, instance);
        diamondPike = new ItemBuilder(config, 423, spartanWeaponry, ItemBuilder.PIKE, instance);
        diamondQuarterstaff = new ItemBuilder(config, 424, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        diamondThrowingAxe = new ItemBuilder(config, 425, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        diamondThrowingKnife = new ItemBuilder(config, 426, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        diamondWarhammer = new ItemBuilder(config, 427, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        diamondBattleaxe = new ItemBuilder(config, 428, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        diamondLongbow = new ItemBuilder(config, 429, instance);
        diamondCrossbow = new ItemBuilder(config, 430, instance);
        ironRapier = new ItemBuilder(config, 431, spartanWeaponry, ItemBuilder.RAPIER, instance);
        ironKatana = new ItemBuilder(config, 432, spartanWeaponry, ItemBuilder.KATANA, instance);
        ironGreatsword = new ItemBuilder(config, 433, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        ironLongsword = new ItemBuilder(config, 434, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        ironSpear = new ItemBuilder(config, 435, spartanWeaponry, ItemBuilder.SPEAR, instance);
        ironSaber = new ItemBuilder(config, 436, spartanWeaponry, ItemBuilder.SABER, instance);
        ironBoomerang = new ItemBuilder(config, 437, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        ironDagger = new ItemBuilder(config, 438, spartanWeaponry, ItemBuilder.DAGGER, instance);
        ironGlaive = new ItemBuilder(config, 439, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        ironHalberd = new ItemBuilder(config, 440, spartanWeaponry, ItemBuilder.HALBERD, instance);
        ironHammer = new ItemBuilder(config, 441, spartanWeaponry, ItemBuilder.HAMMER, instance);
        ironJavelin = new ItemBuilder(config, 442, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        ironLance = new ItemBuilder(config, 443, spartanWeaponry, ItemBuilder.LANCE, instance);
        ironMace = new ItemBuilder(config, 444, spartanWeaponry, ItemBuilder.MACE, instance);
        ironPike = new ItemBuilder(config, 445, spartanWeaponry, ItemBuilder.PIKE, instance);
        ironQuarterstaff = new ItemBuilder(config, 446, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        ironThrowingAxe = new ItemBuilder(config, 447, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        ironThrowingKnife = new ItemBuilder(config, 448, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        ironWarhammer = new ItemBuilder(config, 449, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        ironBattleaxe = new ItemBuilder(config, 450, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        ironLongbow = new ItemBuilder(config, 451, instance);
        ironCrossbow = new ItemBuilder(config, 452, instance);
        goldenRapier = new ItemBuilder(config, 453, spartanWeaponry, ItemBuilder.RAPIER, instance);
        goldenKatana = new ItemBuilder(config, 454, spartanWeaponry, ItemBuilder.KATANA, instance);
        goldenGreatsword = new ItemBuilder(config, 455, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        goldenLongsword = new ItemBuilder(config, 456, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        goldenSpear = new ItemBuilder(config, 457, spartanWeaponry, ItemBuilder.SPEAR, instance);
        goldenSaber = new ItemBuilder(config, 458, spartanWeaponry, ItemBuilder.SABER, instance);
        goldenBoomerang = new ItemBuilder(config, 459, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        goldenDagger = new ItemBuilder(config, 460, spartanWeaponry, ItemBuilder.DAGGER, instance);
        goldenGlaive = new ItemBuilder(config, 461, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        goldenHalberd = new ItemBuilder(config, 462, spartanWeaponry, ItemBuilder.HALBERD, instance);
        goldenHammer = new ItemBuilder(config, 463, spartanWeaponry, ItemBuilder.HAMMER, instance);
        goldenJavelin = new ItemBuilder(config, 464, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        goldenLance = new ItemBuilder(config, 465, spartanWeaponry, ItemBuilder.LANCE, instance);
        goldenMace = new ItemBuilder(config, 466, spartanWeaponry, ItemBuilder.MACE, instance);
        goldenPike = new ItemBuilder(config, 467, spartanWeaponry, ItemBuilder.PIKE, instance);
        goldenQuarterstaff = new ItemBuilder(config, 468, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        goldenThrowingAxe = new ItemBuilder(config, 469, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        goldenThrowingKnife = new ItemBuilder(config, 470, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        goldenWarhammer = new ItemBuilder(config, 471, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        goldenBattleaxe = new ItemBuilder(config, 472, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        goldenLongbow = new ItemBuilder(config, 473, instance);
        goldenCrossbow = new ItemBuilder(config, 474, instance);
        stoneRapier = new ItemBuilder(config, 475, spartanWeaponry, ItemBuilder.RAPIER, instance);
        stoneKatana = new ItemBuilder(config, 476, spartanWeaponry, ItemBuilder.KATANA, instance);
        stoneGreatsword = new ItemBuilder(config, 477, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        stoneLongsword = new ItemBuilder(config, 478, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        stoneSpear = new ItemBuilder(config, 479, spartanWeaponry, ItemBuilder.SPEAR, instance);
        stoneSaber = new ItemBuilder(config, 480, spartanWeaponry, ItemBuilder.SABER, instance);
        stoneBoomerang = new ItemBuilder(config, 481, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        stoneDagger = new ItemBuilder(config, 482, spartanWeaponry, ItemBuilder.DAGGER, instance);
        stoneGlaive = new ItemBuilder(config, 483, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        stoneHalberd = new ItemBuilder(config, 484, spartanWeaponry, ItemBuilder.HALBERD, instance);
        stoneHammer = new ItemBuilder(config, 485, spartanWeaponry, ItemBuilder.HAMMER, instance);
        stoneJavelin = new ItemBuilder(config, 486, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        stoneLance = new ItemBuilder(config, 487, spartanWeaponry, ItemBuilder.LANCE, instance);
        stoneMace = new ItemBuilder(config, 488, spartanWeaponry, ItemBuilder.MACE, instance);
        stonePike = new ItemBuilder(config, 489, spartanWeaponry, ItemBuilder.PIKE, instance);
        stoneQuarterstaff = new ItemBuilder(config, 490, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        stoneThrowingAxe = new ItemBuilder(config, 491, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        stoneThrowingKnife = new ItemBuilder(config, 492, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        stoneWarhammer = new ItemBuilder(config, 493, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        stoneBattleaxe = new ItemBuilder(config, 494, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        woodenRapier = new ItemBuilder(config, 495, spartanWeaponry, ItemBuilder.RAPIER, instance);
        woodenKatana = new ItemBuilder(config, 496, spartanWeaponry, ItemBuilder.KATANA, instance);
        woodenGreatsword = new ItemBuilder(config, 497, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        woodenLongsword = new ItemBuilder(config, 498, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        woodenSpear = new ItemBuilder(config, 499, spartanWeaponry, ItemBuilder.SPEAR, instance);
        woodenSaber = new ItemBuilder(config, 500, spartanWeaponry, ItemBuilder.SABER, instance);
        woodenBoomerang = new ItemBuilder(config, 501, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        woodenDagger = new ItemBuilder(config, 502, spartanWeaponry, ItemBuilder.DAGGER, instance);
        woodenGlaive = new ItemBuilder(config, 503, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        woodenHalberd = new ItemBuilder(config, 504, spartanWeaponry, ItemBuilder.HALBERD, instance);
        woodenHammer = new ItemBuilder(config, 505, spartanWeaponry, ItemBuilder.HAMMER, instance);
        woodenJavelin = new ItemBuilder(config, 506, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        woodenLance = new ItemBuilder(config, 507, spartanWeaponry, ItemBuilder.LANCE, instance);
        woodenMace = new ItemBuilder(config, 508, spartanWeaponry, ItemBuilder.MACE, instance);
        woodenPike = new ItemBuilder(config, 509, spartanWeaponry, ItemBuilder.PIKE, instance);
        woodenQuarterstaff = new ItemBuilder(config, 510, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        woodenThrowingAxe = new ItemBuilder(config, 511, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        woodenThrowingKnife = new ItemBuilder(config, 512, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        woodenWarhammer = new ItemBuilder(config, 513, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        woodenBattleaxe = new ItemBuilder(config, 514, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        woodenLongbow = new ItemBuilder(config, 515, instance);
        woodenCrossbow = new ItemBuilder(config, 516, instance);
        woodenClub = new ItemBuilder(config, 517, spartanWeaponry, ItemBuilder.CLUB, instance);
        leatherLongbow = new ItemBuilder(config, 518, instance);
        leatherCrossbow = new ItemBuilder(config, 519, instance);
        copperRapier = new ItemBuilder(config, 520, spartanWeaponry, ItemBuilder.RAPIER, instance);
        copperKatana = new ItemBuilder(config, 521, spartanWeaponry, ItemBuilder.KATANA, instance);
        copperGreatsword = new ItemBuilder(config, 522, spartanWeaponry, ItemBuilder.GREATSWORD, instance);
        copperLongsword = new ItemBuilder(config, 523, spartanWeaponry, ItemBuilder.LONGSWORD, instance);
        copperSpear = new ItemBuilder(config, 524, spartanWeaponry, ItemBuilder.SPEAR, instance);
        copperSaber = new ItemBuilder(config, 525, spartanWeaponry, ItemBuilder.SABER, instance);
        copperBoomerang = new ItemBuilder(config, 526, spartanWeaponry, ItemBuilder.BOOMERANG, instance);
        copperDagger = new ItemBuilder(config, 527, spartanWeaponry, ItemBuilder.DAGGER, instance);
        copperGlaive = new ItemBuilder(config, 528, spartanWeaponry, ItemBuilder.GLAIVE, instance);
        copperHalberd = new ItemBuilder(config, 529, spartanWeaponry, ItemBuilder.HALBERD, instance);
        copperHammer = new ItemBuilder(config, 530, spartanWeaponry, ItemBuilder.HAMMER, instance);
        copperJavelin = new ItemBuilder(config, 531, spartanWeaponry, ItemBuilder.JAVELIN, instance);
        copperLance = new ItemBuilder(config, 532, spartanWeaponry, ItemBuilder.LANCE, instance);
        copperMace = new ItemBuilder(config, 533, spartanWeaponry, ItemBuilder.MACE, instance);
        copperPike = new ItemBuilder(config, 534, spartanWeaponry, ItemBuilder.PIKE, instance);
        copperQuarterstaff = new ItemBuilder(config, 535, spartanWeaponry, ItemBuilder.QUARTERSTAFF, instance);
        copperThrowingAxe = new ItemBuilder(config, 536, spartanWeaponry, ItemBuilder.TOMAHAWK, instance);
        copperThrowingKnife = new ItemBuilder(config, 537, spartanWeaponry, ItemBuilder.THROWING_KNIFE, instance);
        copperWarhammer = new ItemBuilder(config, 538, spartanWeaponry, ItemBuilder.WARHAMMER, instance);
        copperBattleaxe = new ItemBuilder(config, 539, spartanWeaponry, ItemBuilder.BATTLEAXE, instance);
        copperLongbow = new ItemBuilder(config, 540, instance);
        copperCrossbow = new ItemBuilder(config, 541, instance);
        studdedClub = new ItemBuilder(config, 542, spartanWeaponry, ItemBuilder.CLUB, instance);
        appleJuice = new ItemBuilder(config, 543, instance);
        beetrootJuice = new ItemBuilder(config, 544, instance);
        cactusJuice = new ItemBuilder(config, 545, instance);
        carrotJuice = new ItemBuilder(config, 546, instance);
        chorusFruitJuice = new ItemBuilder(config, 547, instance);
        glisteringMelonJuice = new ItemBuilder(config, 548, instance);
        goldenAppleJuice = new ItemBuilder(config, 549, instance);
        goldenCarrotJuice = new ItemBuilder(config, 550, instance);
        melonJuice = new ItemBuilder(config, 551, instance);
        pumpkinJuice = new ItemBuilder(config, 552, instance);
        purifiedWaterBottle = new ItemBuilder(config, 553, instance);
        waterBottle = new ItemBuilder(config, 554, instance);
        charcoalFilter = new ItemBuilder(config, 555, instance);
        iceCube = new ItemBuilder(config, 556, instance);
        magmaShard = new ItemBuilder(config, 557, instance);
        jelledSlime = new ItemBuilder(config, 558, instance);
        thermometer = new ItemBuilder(config, 559, instance);
        woolHood = new ItemBuilder(config, 560, toughasNails, ItemBuilder.HELMET, instance);
        woolJacket = new ItemBuilder(config, 561, toughasNails, ItemBuilder.CHESTPLATE, instance);
        woolPants = new ItemBuilder(config, 562, toughasNails, ItemBuilder.LEGGINGS, instance);
        woolBoots = new ItemBuilder(config, 563, toughasNails, ItemBuilder.BOOTS, instance);
        jelledSlimeHelmet = new ItemBuilder(config, 564, toughasNails, ItemBuilder.HELMET, instance);
        jelledSlimeChestplate = new ItemBuilder(config, 565, toughasNails, ItemBuilder.CHESTPLATE, instance);
        jelledSlimeLeggings = new ItemBuilder(config, 566, toughasNails, ItemBuilder.LEGGINGS, instance);
        jelledSlimeBoots = new ItemBuilder(config, 567, toughasNails, ItemBuilder.BOOTS, instance);
    }

    /**
     * Accessor methods for getting each item.
     * Other than this method, no more will receive comments
     * for the sake of brevity and because there are over 300 accessor methods
     * that would receive comments that more or less resemble one another.
     */
    public ItemStack getFlintAxe() {
        return flintAxe;
    }

    public ItemStack getFlintKnife() {
        return flintKnife;
    }

    public ItemStack getFlintPickaxe() {
        return flintPickaxe;
    }

    public ItemStack getFlintShovel() {
        return flintShovel;
    }

    public ItemStack getFlintHoe() {
        return flintHoe;
    }

    public ItemStack getPlantFiber() {
        return plantFiber;
    }

    public ItemStack getPlantString() {
        return plantString;
    }

    public ItemStack getFlintShard() {
        return flintShard;
    }

    public ItemStack getDragonbone() {
        return dragonBone;
    }

    public ItemStack getWitherbone() {
        return witherbone;
    }

    public ItemStack getDragonscaleBlue() {
        return blueDragonscales;
    }

    public ItemStack getDragonscaleBronze() {
        return bronzeDragonscales;
    }

    public ItemStack getDragonscaleGray() {
        return grayDragonscales;
    }

    public ItemStack getDragonscaleGreen() {
        return greenDragonscales;
    }

    public ItemStack getDragonscaleRed() {
        return redDragonscales;
    }

    public ItemStack getDragonscaleSapphire() {
        return sapphireDragonscales;
    }

    public ItemStack getDragonscaleSilver() {
        return silverDragonscales;
    }

    public ItemStack getDragonscaleWhite() {
        return whiteDragonscales;
    }

    public ItemStack getDragonscaleAmethyst() {
        return amethystDragonscales;
    }

    public ItemStack getDragonscaleBlack() {
        return blackDragonscales;
    }

    public ItemStack getDragonscaleCopper() {
        return copperDragonscales;
    }

    public ItemStack getDragonscaleElectric() {
        return electricDragonscales;
    }

    public ItemStack getSeaSerpentScaleBlue() {
        return blueSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleBronze() {
        return bronzeSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleDeepblue() {
        return deepBlueSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleGreen() {
        return greenSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScalePurple() {
        return purpleSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleRed() {
        return redSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleTeal() {
        return tealSeaSerpentScales;
    }

    public ItemStack getShinyScale() {
        return shinyScales;
    }

    public ItemStack getFireDragonBlood() {
        return fireDragonBlood;
    }

    public ItemStack getIceDragonBlood() {
        return iceDragonBlood;
    }

    public ItemStack getLightningDragonBlood() {
        return lightningDragonBlood;
    }

    public ItemStack getFireDragonHeart() {
        return fireDragonHeart;
    }

    public ItemStack getIceDragonHeart() {
        return iceDragonHeart;
    }

    public ItemStack getLightningDragonHeart() {
        return lightningDragonHeart;
    }

    public ItemStack getFireDragonSkull() {
        return fireDragonSkull;
    }

    public ItemStack getIceDragonSkull() {
        return iceDragonSkull;
    }

    public ItemStack getLightningDragonSkull() {
        return lightningDragonSkull;
    }

    public ItemStack getFireDragonFlesh() {
        return fireDragonFlesh;
    }

    public ItemStack getIceDragonFlesh() {
        return iceDragonFlesh;
    }

    public ItemStack getLightningDragonFlesh() {
        return lightningDragonFlesh;
    }

    public ItemStack getFireDragonsteelIngot() {
        return fireDragonsteelIngot;
    }

    public ItemStack getIceDragonsteelIngot() {
        return iceDragonsteelIngot;
    }

    public ItemStack getLightningDragonsteelIngot() {
        return lightningDragonsteelIngot;
    }

    public ItemStack getDragonscaleHelmetBlue() {
        return blueDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateBlue() {
        return blueDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsBlue() {
        return blueDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsBlue() {
        return blueDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetBronze() {
        return bronzeDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateBronze() {
        return bronzeDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsBronze() {
        return bronzeDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsBronze() {
        return bronzeDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetGray() {
        return grayDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateGray() {
        return grayDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsGray() {
        return grayDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsGray() {
        return grayDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetGreen() {
        return greenDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateGreen() {
        return greenDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsGreen() {
        return greenDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsGreen() {
        return greenDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetRed() {
        return redDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateRed() {
        return redDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsRed() {
        return redDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsRed() {
        return redDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetSapphire() {
        return sapphireDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateSapphire() {
        return sapphireDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsSapphire() {
        return sapphireDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsSapphire() {
        return sapphireDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetSilver() {
        return silverDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateSilver() {
        return silverDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsSilver() {
        return silverDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsSilver() {
        return silverDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetWhite() {
        return whiteDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateWhite() {
        return whiteDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsWhite() {
        return whiteDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsWhite() {
        return whiteDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetAmethyst() {
        return amethystDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateAmethyst() {
        return amethystDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsAmethyst() {
        return amethystDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsAmethyst() {
        return amethystDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetBlack() {
        return blackDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateBlack() {
        return blackDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsBlack() {
        return blackDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsBlack() {
        return blackDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetCopper() {
        return copperDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateCopper() {
        return copperDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsCopper() {
        return copperDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsCopper() {
        return copperDragonscaleBoots;
    }

    public ItemStack getDragonscaleHelmetElectric() {
        return electricDragonscaleHelmet;
    }

    public ItemStack getDragonscaleChestplateElectric() {
        return electricDragonscaleChestplate;
    }

    public ItemStack getDragonscaleLeggingsElectric() {
        return electricDragonscaleLeggings;
    }

    public ItemStack getDragonscaleBootsElectric() {
        return electricDragonscaleBoots;
    }

    public ItemStack getTideGuardianHelmetBlue() {
        return blueTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateBlue() {
        return blueTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsBlue() {
        return blueTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsBlue() {
        return blueTideGuardianBoots;
    }

    public ItemStack getTideGuardianHelmetBronze() {
        return bronzeTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateBronze() {
        return bronzeTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsBronze() {
        return bronzeTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsBronze() {
        return bronzeTideGuardianBoots;
    }

    public ItemStack getTideGuardianHelmetDeepblue() {
        return deepBlueTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateDeepblue() {
        return deepBlueTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsDeepblue() {
        return deepBlueTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsDeepblue() {
        return deepBlueTideGuardianBoots;
    }

    public ItemStack getTideGuardianHelmetGreen() {
        return greenTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateGreen() {
        return greenTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsGreen() {
        return greenTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsGreen() {
        return greenTideGuardianBoots;
    }

    public ItemStack getTideGuardianHelmetPurple() {
        return purpleTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplatePurple() {
        return purpleTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsPurple() {
        return purpleTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsPurple() {
        return purpleTideGuardianBoots;
    }

    public ItemStack getTideGuardianHelmetRed() {
        return redTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateRed() {
        return redTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsRed() {
        return redTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsRed() {
        return redTideGuardianBoots;
    }

    public ItemStack getTideGuardianHelmetTeal() {
        return tealTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateTeal() {
        return tealTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsTeal() {
        return tealTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsTeal() {
        return tealTideGuardianBoots;
    }

    public ItemStack getDragonbonePickaxe() {
        return dragonBonePickaxe;
    }

    public ItemStack getDragonboneAxe() {
        return dragonBoneAxe;
    }

    public ItemStack getDragonboneShovel() {
        return dragonBoneShovel;
    }

    public ItemStack getDragonboneHoe() {
        return dragonBoneHoe;
    }

    public ItemStack getDragonboneSword() {
        return dragonBoneSword;
    }

    public ItemStack getDragonboneBow() {
        return dragonBoneBow;
    }

    public ItemStack getFlamedDragonboneSword() {
        return flamedDragonboneSword;
    }

    public ItemStack getIcedDragonboneSword() {
        return icedDragonboneSword;
    }

    public ItemStack getLightningDragonboneSword() {
        return lightningDragonboneSword;
    }

    public ItemStack getDragonsEye() {
        return dragonsEye;
    }

    public ItemStack getPoisonStone() {
        return poisonStone;
    }

    public ItemStack getPotionRingResistance() {
        return potionRingResistance;
    }

    public ItemStack getPotionRingRegeneration() {
        return potionRingRegeneration;
    }

    public ItemStack getPotionRingHaste() {
        return potionRingHaste;
    }

    public ItemStack getPotionRingStrength() {
        return potionRingStrength;
    }

    public ItemStack getPotionRingSpeed() {
        return potionRingSpeed;
    }

    public ItemStack getPotionRingJumpBoost() {
        return potionRingJumpBoost;
    }

    public ItemStack getEnderQueensCrown() {
        return enderQueensCrown;
    }

    public ItemStack getSunglasses() {
        return sunglasses;
    }

    public ItemStack getBalloon() {
        return balloon;
    }

    public ItemStack getCobaltShield() {
        return cobaltShield;
    }

    public ItemStack getObsidianSkull() {
        return obsidianSkull;
    }

    public ItemStack getObsidianShield() {
        return obsidianShield;
    }

    public ItemStack getForbiddenFruit() {
        return forbiddenFruit;
    }

    public ItemStack getVitamins() {
        return vitamins;
    }

    public ItemStack getRingofOverclocking() {
        return ringOverclocking;
    }

    public ItemStack getShulkerHeart() {
        return shulkerHeart;
    }

    public ItemStack getRingofFreeAction() {
        return ringFreeAction;
    }

    public ItemStack getBezoar() {
        return bezoar;
    }

    public ItemStack getEnderDragonscale() {
        return enderDragonscale;
    }

    public ItemStack getCrackedBlackDragonscale() {
        return crackedBlackDragonscale;
    }

    public ItemStack getBlackDragonscale() {
        return blackDragonscale;
    }

    public ItemStack getMixedColorDragonscale() {
        return mixedColorDragonscale;
    }

    public ItemStack getAnkhCharm() {
        return ankhCharm;
    }

    public ItemStack getAnkhShield() {
        return ankhShield;
    }

    public ItemStack getIronRing() {
        return ironRing;
    }

    public ItemStack getMagicMirror() {
        return magicMirror;
    }

    public ItemStack getRecallPotion() {
        return recallPotion;
    }

    public ItemStack getWormholeMirror() {
        return wormholeMirror;
    }

    public ItemStack getWormholePotion() {
        return wormholePotion;
    }

    public ItemStack getLuckyHorseshoe() {
        return luckyHorseshoe;
    }

    public ItemStack getBattleBurrito() {
        return battleBurrito;
    }

    public ItemStack getScarliteRing() {
        return scarliteRing;
    }

    public ItemStack getSpectralSilt() {
        return spectralSilt;
    }

    public ItemStack getDisintegrationTablet() {
        return disintegrationTablet;
    }

    public ItemStack getBrokenHeart() {
        return brokenHeart;
    }

    public ItemStack getCrossNecklace() {
        return crossNecklace;
    }

    public ItemStack getWrathPendant() {
        return wrathPendant;
    }

    public ItemStack getPridePendant() {
        return pridePendant;
    }

    public ItemStack getGoldenCrown() {
        return goldenCrown;
    }

    public ItemStack getGluttonyPendant() {
        return gluttonyPendant;
    }

    public ItemStack getSinPendant() {
        return sinPendant;
    }

    public ItemStack getFlareGun() {
        return flareGun;
    }

    public ItemStack getFlare() {
        return flare;
    }

    public ItemStack getPhytoprostasiaAmulet() {
        return phytoprotostasiaAmulet;
    }

    public ItemStack getPotionRing() {
        return potionRing;
    }

    public ItemStack getEmeraldRing() {
        return emeraldRing;
    }

    public ItemStack getEmeraldAmulet() {
        return emeraldAmulet;
    }

    public ItemStack getGlowingIngot() {
        return glowingIngot;
    }

    public ItemStack getGlowingPowder() {
        return glowingPowder;
    }

    public ItemStack getGlowingGem() {
        return glowingGem;
    }

    public ItemStack getDwarfStout() {
        return dwarfStout;
    }

    public ItemStack getFairyDew() {
        return fairyDew;
    }

    public ItemStack getStoneNegativeGravity() {
        return stoneNegativeGravity;
    }

    public ItemStack getStoneInertiaNull() {
        return stoneInertiaNull;
    }

    public ItemStack getStoneGreaterInertia() {
        return stoneGreaterInertia;
    }

    public ItemStack getRingEnchantedEyes() {
        return ringEnchantedEyes;
    }

    public ItemStack getStoneSea() {
        return stoneSea;
    }

    public ItemStack getPolarizedStone() {
        return polarizedStone;
    }

    public ItemStack getRingFairies() {
        return ringFairies;
    }

    public ItemStack getRingDwarves() {
        return ringDwarves;
    }

    public ItemStack getWitherRing() {
        return witherRing;
    }

    public ItemStack getShieldHonor() {
        return shieldHonor;
    }

    public ItemStack getMinersRing() {
        return minersRing;
    }

    public ItemStack getWarpedScroll() {
        return warpedScroll;
    }

    public ItemStack getFireResistancePotion() {
        return fireResistancePotion;
    }

    public ItemStack getFireDragonsteelSword() {
        return fireDragonsteelSword;
    }

    public ItemStack getFireDragonsteelPickaxe() {
        return fireDragonsteelPickaxe;
    }

    public ItemStack getFireDragonsteelAxe() {
        return fireDragonsteelAxe;
    }

    public ItemStack getFireDragonsteelShovel() {
        return fireDragonsteelShovel;
    }

    public ItemStack getFireDragonsteelHoe() {
        return fireDragonsteelHoe;
    }

    public ItemStack getIceDragonsteelSword() {
        return iceDragonsteelSword;
    }

    public ItemStack getIceDragonsteelPickaxe() {
        return iceDragonsteelPickaxe;
    }

    public ItemStack getIceDragonsteelAxe() {
        return iceDragonsteelAxe;
    }

    public ItemStack getIceDragonsteelShovel() {
        return iceDragonsteelShovel;
    }

    public ItemStack getIceDragonsteelHoe() {
        return iceDragonsteelHoe;
    }

    public ItemStack getLightningDragonsteelSword() {
        return lightningDragonsteelSword;
    }

    public ItemStack getLightningDragonsteelPickaxe() {
        return lightningDragonsteelPickaxe;
    }

    public ItemStack getLightningDragonsteelAxe() {
        return lightningDragonsteelAxe;
    }

    public ItemStack getLightningDragonsteelShovel() {
        return lightningDragonsteelShovel;
    }

    public ItemStack getLightningDragonsteelHoe() {
        return lightningDragonsteelHoe;
    }

    public ItemStack getFireDragonsteelHelmet() {
        return fireDragonsteelHelmet;
    }

    public ItemStack getFireDragonsteelChestplate() {
        return fireDragonsteelChestplate;
    }

    public ItemStack getFireDragonsteelLeggings() {
        return fireDragonsteelLeggings;
    }

    public ItemStack getFireDragonsteelBoots() {
        return fireDragonsteelBoots;
    }

    public ItemStack getIceDragonsteelHelmet() {
        return iceDragonsteelHelmet;
    }

    public ItemStack getIceDragonsteelChestplate() {
        return iceDragonsteelChestplate;
    }

    public ItemStack getIceDragonsteelLeggings() {
        return iceDragonsteelLeggings;
    }

    public ItemStack getIceDragonsteelBoots() {
        return iceDragonsteelBoots;
    }

    public ItemStack getLightningDragonsteelHelmet() {
        return lightningDragonsteelHelmet;
    }

    public ItemStack getLightningDragonsteelChestplate() {
        return lightningDragonsteelChestplate;
    }

    public ItemStack getLightningDragonsteelLeggings() {
        return lightningDragonsteelLeggings;
    }

    public ItemStack getLightningDragonsteelBoots() {
        return lightningDragonsteelBoots;
    }

    public ItemStack getDragonboneRapier() {
        return dragonBoneRapier;
    }

    public ItemStack getDragonboneKatana() {
        return dragonBoneKatana;
    }

    public ItemStack getDragonboneGreatsword() {
        return dragonBoneGreatsword;
    }

    public ItemStack getDragonboneLongsword() {
        return dragonBoneLongsword;
    }

    public ItemStack getDragonboneSpear() {
        return dragonBoneSpear;
    }

    public ItemStack getDragonboneSaber() {
        return dragonBoneSaber;
    }

    public ItemStack getDragonboneBoomerang() {
        return dragonBoneBoomerang;
    }

    public ItemStack getDragonboneDagger() {
        return dragonBoneDagger;
    }

    public ItemStack getDragonboneGlaive() {
        return dragonBoneGlaive;
    }

    public ItemStack getDragonboneHalberd() {
        return dragonBoneHalberd;
    }

    public ItemStack getDragonboneHammer() {
        return dragonBoneHammer;
    }

    public ItemStack getDragonboneJavelin() {
        return dragonBoneJavelin;
    }

    public ItemStack getDragonboneLance() {
        return dragonBoneLance;
    }

    public ItemStack getDragonboneMace() {
        return dragonBoneMace;
    }

    public ItemStack getDragonbonePike() {
        return dragonBonePike;
    }

    public ItemStack getDragonboneQuarterstaff() {
        return dragonBoneQuarterstaff;
    }

    public ItemStack getDragonboneThrowingAxe() {
        return dragonBoneThrowingAxe;
    }

    public ItemStack getDragonboneThrowingKnife() {
        return dragonBoneThrowingKnife;
    }

    public ItemStack getDragonboneWarhammer() {
        return dragonBoneWarhammer;
    }

    public ItemStack getDragonboneBattleaxe() {
        return dragonBoneBattleaxe;
    }

    public ItemStack getDragonboneLongbow() {
        return dragonBoneLongbow;
    }

    public ItemStack getDragonboneCrossbow() {
        return dragonBoneCrossbow;
    }

    public ItemStack getFlamedDragonboneRapier() {
        return flamedDragonboneRapier;
    }

    public ItemStack getFlamedDragonboneKatana() {
        return flamedDragonboneKatana;
    }

    public ItemStack getFlamedDragonboneGreatsword() {
        return flamedDragonboneGreatsword;
    }

    public ItemStack getFlamedDragonboneLongsword() {
        return flamedDragonboneLongsword;
    }

    public ItemStack getFlamedDragonboneSpear() {
        return flamedDragonboneSpear;
    }

    public ItemStack getFlamedDragonboneSaber() {
        return flamedDragonboneSaber;
    }

    public ItemStack getFlamedDragonboneBoomerang() {
        return flamedDragonboneBoomerang;
    }

    public ItemStack getFlamedDragonboneDagger() {
        return flamedDragonboneDagger;
    }

    public ItemStack getFlamedDragonboneGlaive() {
        return flamedDragonboneGlaive;
    }

    public ItemStack getFlamedDragonboneHalberd() {
        return flamedDragonboneHalberd;
    }

    public ItemStack getFlamedDragonboneHammer() {
        return flamedDragonboneHammer;
    }

    public ItemStack getFlamedDragonboneJavelin() {
        return flamedDragonboneJavelin;
    }

    public ItemStack getFlamedDragonboneLance() {
        return flamedDragonboneLance;
    }

    public ItemStack getFlamedDragonboneMace() {
        return flamedDragonboneMace;
    }

    public ItemStack getFlamedDragonbonePike() {
        return flamedDragonbonePike;
    }

    public ItemStack getFlamedDragonboneQuarterstaff() {
        return flamedDragonboneQuarterstaff;
    }

    public ItemStack getFlamedDragonboneThrowingAxe() {
        return flamedDragonboneThrowingAxe;
    }

    public ItemStack getFlamedDragonboneThrowingKnife() {
        return flamedDragonboneThrowingKnife;
    }

    public ItemStack getFlamedDragonboneWarhammer() {
        return flamedDragonboneWarhammer;
    }

    public ItemStack getFlamedDragonboneBattleaxe() {
        return flamedDragonboneBattleaxe;
    }

    public ItemStack getFlamedDragonboneLongbow() {
        return flamedDragonboneLongbow;
    }

    public ItemStack getFlamedDragonboneCrossbow() {
        return flamedDragonboneCrossbow;
    }

    public ItemStack getIcedDragonboneRapier() {
        return icedDragonboneRapier;
    }

    public ItemStack getIcedDragonboneKatana() {
        return icedDragonboneKatana;
    }

    public ItemStack getIcedDragonboneGreatsword() {
        return icedDragonboneGreatsword;
    }

    public ItemStack getIcedDragonboneLongsword() {
        return icedDragonboneLongsword;
    }

    public ItemStack getIcedDragonboneSpear() {
        return icedDragonboneSpear;
    }

    public ItemStack getIcedDragonboneSaber() {
        return icedDragonboneSaber;
    }

    public ItemStack getIcedDragonboneBoomerang() {
        return icedDragonboneBoomerang;
    }

    public ItemStack getIcedDragonboneDagger() {
        return icedDragonboneDagger;
    }

    public ItemStack getIcedDragonboneGlaive() {
        return icedDragonboneGlaive;
    }

    public ItemStack getIcedDragonboneHalberd() {
        return icedDragonboneHalberd;
    }

    public ItemStack getIcedDragonboneHammer() {
        return icedDragonboneHammer;
    }

    public ItemStack getIcedDragonboneJavelin() {
        return icedDragonboneJavelin;
    }

    public ItemStack getIcedDragonboneLance() {
        return icedDragonboneLance;
    }

    public ItemStack getIcedDragonboneMace() {
        return icedDragonboneMace;
    }

    public ItemStack getIcedDragonbonePike() {
        return icedDragonbonePike;
    }

    public ItemStack getIcedDragonboneQuarterstaff() {
        return icedDragonboneQuarterstaff;
    }

    public ItemStack getIcedDragonboneThrowingAxe() {
        return icedDragonboneThrowingAxe;
    }

    public ItemStack getIcedDragonboneThrowingKnife() {
        return icedDragonboneThrowingKnife;
    }

    public ItemStack getIcedDragonboneWarhammer() {
        return icedDragonboneWarhammer;
    }

    public ItemStack getIcedDragonboneBattleaxe() {
        return icedDragonboneBattleaxe;
    }

    public ItemStack getIcedDragonboneLongbow() {
        return icedDragonboneLongbow;
    }

    public ItemStack getIcedDragonboneCrossbow() {
        return icedDragonboneCrossbow;
    }

    public ItemStack getLightningDragonboneRapier() {
        return lightningDragonboneRapier;
    }

    public ItemStack getLightningDragonboneKatana() {
        return lightningDragonboneKatana;
    }

    public ItemStack getLightningDragonboneGreatsword() {
        return lightningDragonboneGreatsword;
    }

    public ItemStack getLightningDragonboneLongsword() {
        return lightningDragonboneLongsword;
    }

    public ItemStack getLightningDragonboneSpear() {
        return lightningDragonboneSpear;
    }

    public ItemStack getLightningDragonboneSaber() {
        return lightningDragonboneSaber;
    }

    public ItemStack getLightningDragonboneBoomerang() {
        return lightningDragonboneBoomerang;
    }

    public ItemStack getLightningDragonboneDagger() {
        return lightningDragonboneDagger;
    }

    public ItemStack getLightningDragonboneGlaive() {
        return lightningDragonboneGlaive;
    }

    public ItemStack getLightningDragonboneHalberd() {
        return lightningDragonboneHalberd;
    }

    public ItemStack getLightningDragonboneHammer() {
        return lightningDragonboneHammer;
    }

    public ItemStack getLightningDragonboneJavelin() {
        return lightningDragonboneJavelin;
    }

    public ItemStack getLightningDragonboneLance() {
        return lightningDragonboneLance;
    }

    public ItemStack getLightningDragonboneMace() {
        return lightningDragonboneMace;
    }

    public ItemStack getLightningDragonbonePike() {
        return lightningDragonbonePike;
    }

    public ItemStack getLightningDragonboneQuarterstaff() {
        return lightningDragonboneQuarterstaff;
    }

    public ItemStack getLightningDragonboneThrowingAxe() {
        return lightningDragonboneThrowingAxe;
    }

    public ItemStack getLightningDragonboneThrowingKnife() {
        return lightningDragonboneThrowingKnife;
    }

    public ItemStack getLightningDragonboneWarhammer() {
        return lightningDragonboneWarhammer;
    }

    public ItemStack getLightningDragonboneBattleaxe() {
        return lightningDragonboneBattleaxe;
    }

    public ItemStack getLightningDragonboneLongbow() {
        return lightningDragonboneLongbow;
    }

    public ItemStack getLightningDragonboneCrossbow() {
        return lightningDragonboneCrossbow;
    }

    public ItemStack getFireDragonsteelRapier() {
        return fireDragonsteelRapier;
    }

    public ItemStack getFireDragonsteelKatana() {
        return fireDragonsteelKatana;
    }

    public ItemStack getFireDragonsteelGreatsword() {
        return fireDragonsteelGreatsword;
    }

    public ItemStack getFireDragonsteelLongsword() {
        return fireDragonsteelLongsword;
    }

    public ItemStack getFireDragonsteelSpear() {
        return fireDragonsteelSpear;
    }

    public ItemStack getFireDragonsteelSaber() {
        return fireDragonsteelSaber;
    }

    public ItemStack getFireDragonsteelBoomerang() {
        return fireDragonsteelBoomerang;
    }

    public ItemStack getFireDragonsteelDagger() {
        return fireDragonsteelDagger;
    }

    public ItemStack getFireDragonsteelGlaive() {
        return fireDragonsteelGlaive;
    }

    public ItemStack getFireDragonsteelHalberd() {
        return fireDragonsteelHalberd;
    }

    public ItemStack getFireDragonsteelHammer() {
        return fireDragonsteelHammer;
    }

    public ItemStack getFireDragonsteelJavelin() {
        return fireDragonsteelJavelin;
    }

    public ItemStack getFireDragonsteelLance() {
        return fireDragonsteelLance;
    }

    public ItemStack getFireDragonsteelMace() {
        return fireDragonsteelMace;
    }

    public ItemStack getFireDragonsteelPike() {
        return fireDragonsteelPike;
    }

    public ItemStack getFireDragonsteelQuarterstaff() {
        return fireDragonsteelQuarterstaff;
    }

    public ItemStack getFireDragonsteelThrowingAxe() {
        return fireDragonsteelThrowingAxe;
    }

    public ItemStack getFireDragonsteelThrowingKnife() {
        return fireDragonsteelThrowingKnife;
    }

    public ItemStack getFireDragonsteelWarhammer() {
        return fireDragonsteelWarhammer;
    }

    public ItemStack getFireDragonsteelBattleaxe() {
        return fireDragonsteelBattleaxe;
    }

    public ItemStack getFireDragonsteelLongbow() {
        return fireDragonsteelLongbow;
    }

    public ItemStack getFireDragonsteelCrossbow() {
        return fireDragonsteelCrossbow;
    }

    public ItemStack getIceDragonsteelRapier() {
        return iceDragonsteelRapier;
    }

    public ItemStack getIceDragonsteelKatana() {
        return iceDragonsteelKatana;
    }

    public ItemStack getIceDragonsteelGreatsword() {
        return iceDragonsteelGreatsword;
    }

    public ItemStack getIceDragonsteelLongsword() {
        return iceDragonsteelLongsword;
    }

    public ItemStack getIceDragonsteelSpear() {
        return iceDragonsteelSpear;
    }

    public ItemStack getIceDragonsteelSaber() {
        return iceDragonsteelSaber;
    }

    public ItemStack getIceDragonsteelBoomerang() {
        return iceDragonsteelBoomerang;
    }

    public ItemStack getIceDragonsteelDagger() {
        return iceDragonsteelDagger;
    }

    public ItemStack getIceDragonsteelGlaive() {
        return iceDragonsteelGlaive;
    }

    public ItemStack getIceDragonsteelHalberd() {
        return iceDragonsteelHalberd;
    }

    public ItemStack getIceDragonsteelHammer() {
        return iceDragonsteelHammer;
    }

    public ItemStack getIceDragonsteelJavelin() {
        return iceDragonsteelJavelin;
    }

    public ItemStack getIceDragonsteelLance() {
        return iceDragonsteelLance;
    }

    public ItemStack getIceDragonsteelMace() {
        return iceDragonsteelMace;
    }

    public ItemStack getIceDragonsteelPike() {
        return iceDragonsteelPike;
    }

    public ItemStack getIceDragonsteelQuarterstaff() {
        return iceDragonsteelQuarterstaff;
    }

    public ItemStack getIceDragonsteelThrowingAxe() {
        return iceDragonsteelThrowingAxe;
    }

    public ItemStack getIceDragonsteelThrowingKnife() {
        return iceDragonsteelThrowingKnife;
    }

    public ItemStack getIceDragonsteelWarhammer() {
        return iceDragonsteelWarhammer;
    }

    public ItemStack getIceDragonsteelBattleaxe() {
        return iceDragonsteelBattleaxe;
    }

    public ItemStack getIceDragonsteelLongbow() {
        return iceDragonsteelLongbow;
    }

    public ItemStack getIceDragonsteelCrossbow() {
        return iceDragonsteelCrossbow;
    }

    public ItemStack getLightningDragonsteelRapier() {
        return lightningDragonsteelRapier;
    }

    public ItemStack getLightningDragonsteelKatana() {
        return lightningDragonsteelKatana;
    }

    public ItemStack getLightningDragonsteelGreatsword() {
        return lightningDragonsteelGreatsword;
    }

    public ItemStack getLightningDragonsteelLongsword() {
        return lightningDragonsteelLongsword;
    }

    public ItemStack getLightningDragonsteelSpear() {
        return lightningDragonsteelSpear;
    }

    public ItemStack getLightningDragonsteelSaber() {
        return lightningDragonsteelSaber;
    }

    public ItemStack getLightningDragonsteelBoomerang() {
        return lightningDragonsteelBoomerang;
    }

    public ItemStack getLightningDragonsteelDagger() {
        return lightningDragonsteelDagger;
    }

    public ItemStack getLightningDragonsteelGlaive() {
        return lightningDragonsteelGlaive;
    }

    public ItemStack getLightningDragonsteelHalberd() {
        return lightningDragonsteelHalberd;
    }

    public ItemStack getLightningDragonsteelHammer() {
        return lightningDragonsteelHammer;
    }

    public ItemStack getLightningDragonsteelJavelin() {
        return lightningDragonsteelJavelin;
    }

    public ItemStack getLightningDragonsteelLance() {
        return lightningDragonsteelLance;
    }

    public ItemStack getLightningDragonsteelMace() {
        return lightningDragonsteelMace;
    }

    public ItemStack getLightningDragonsteelPike() {
        return lightningDragonsteelPike;
    }

    public ItemStack getLightningDragonsteelQuarterstaff() {
        return lightningDragonsteelQuarterstaff;
    }

    public ItemStack getLightningDragonsteelThrowingAxe() {
        return lightningDragonsteelThrowingAxe;
    }

    public ItemStack getLightningDragonsteelThrowingKnife() {
        return lightningDragonsteelThrowingKnife;
    }

    public ItemStack getLightningDragonsteelWarhammer() {
        return lightningDragonsteelWarhammer;
    }

    public ItemStack getLightningDragonsteelBattleaxe() {
        return lightningDragonsteelBattleaxe;
    }

    public ItemStack getLightningDragonsteelLongbow() {
        return lightningDragonsteelLongbow;
    }

    public ItemStack getLightningDragonsteelCrossbow() {
        return lightningDragonsteelCrossbow;
    }

    public ItemStack getFireDragonsteelBlock() {
        return fireDragonsteelBlock;
    }

    public ItemStack getIceDragonsteelBlock() {
        return iceDragonsteelBlock;
    }

    public ItemStack getLightningDragonsteelBlock() {
        return lightningDragonsteelBlock;
    }

    public ItemStack getBoundScroll() {
        return boundScroll;
    }

    public ItemStack getReturnScroll() {
        return returnScroll;
    }

    public ItemStack getHandle() {
        return handle;
    }

    public ItemStack getPole() {
        return pole;
    }

    public ItemStack getWitherboneHandle() {
        return witherboneHandle;
    }

    public ItemStack getWitherbonePole() {
        return witherbonePole;
    }

    public ItemStack getNetheriteRapier() {
        return netheriteRapier;
    }

    public ItemStack getNetheriteKatana() {
        return netheriteKatana;
    }

    public ItemStack getNetheriteGreatsword() {
        return netheriteGreatsword;
    }

    public ItemStack getNetheriteLongsword() {
        return netheriteLongsword;
    }

    public ItemStack getNetheriteSpear() {
        return netheriteSpear;
    }

    public ItemStack getNetheriteSaber() {
        return netheriteSaber;
    }

    public ItemStack getNetheriteBoomerang() {
        return netheriteBoomerang;
    }

    public ItemStack getNetheriteDagger() {
        return netheriteDagger;
    }

    public ItemStack getNetheriteGlaive() {
        return netheriteGlaive;
    }

    public ItemStack getNetheriteHalberd() {
        return netheriteHalberd;
    }

    public ItemStack getNetheriteHammer() {
        return netheriteHammer;
    }

    public ItemStack getNetheriteJavelin() {
        return netheriteJavelin;
    }

    public ItemStack getNetheriteLance() {
        return netheriteLance;
    }

    public ItemStack getNetheriteMace() {
        return netheriteMace;
    }

    public ItemStack getNetheritePike() {
        return netheritePike;
    }

    public ItemStack getNetheriteQuarterstaff() {
        return netheriteQuarterstaff;
    }

    public ItemStack getNetheriteThrowingAxe() {
        return netheriteThrowingAxe;
    }

    public ItemStack getNetheriteThrowingKnife() {
        return netheriteThrowingKnife;
    }

    public ItemStack getNetheriteWarhammer() {
        return netheriteWarhammer;
    }

    public ItemStack getNetheriteBattleaxe() {
        return netheriteBattleaxe;
    }

    public ItemStack getNetheriteLongbow() {
        return netheriteLongbow;
    }

    public ItemStack getNetheriteCrossbow() {
        return netheriteCrossbow;
    }

    public ItemStack getDiamondRapier() {
        return diamondRapier;
    }

    public ItemStack getDiamondKatana() {
        return diamondKatana;
    }

    public ItemStack getDiamondGreatsword() {
        return diamondGreatsword;
    }

    public ItemStack getDiamondLongsword() {
        return diamondLongsword;
    }

    public ItemStack getDiamondSpear() {
        return diamondSpear;
    }

    public ItemStack getDiamondSaber() {
        return diamondSaber;
    }

    public ItemStack getDiamondBoomerang() {
        return diamondBoomerang;
    }

    public ItemStack getDiamondDagger() {
        return diamondDagger;
    }

    public ItemStack getDiamondGlaive() {
        return diamondGlaive;
    }

    public ItemStack getDiamondHalberd() {
        return diamondHalberd;
    }

    public ItemStack getDiamondHammer() {
        return diamondHammer;
    }

    public ItemStack getDiamondJavelin() {
        return diamondJavelin;
    }

    public ItemStack getDiamondLance() {
        return diamondLance;
    }

    public ItemStack getDiamondMace() {
        return diamondMace;
    }

    public ItemStack getDiamondPike() {
        return diamondPike;
    }

    public ItemStack getDiamondQuarterstaff() {
        return diamondQuarterstaff;
    }

    public ItemStack getDiamondThrowingAxe() {
        return diamondThrowingAxe;
    }

    public ItemStack getDiamondThrowingKnife() {
        return diamondThrowingKnife;
    }

    public ItemStack getDiamondWarhammer() {
        return diamondWarhammer;
    }

    public ItemStack getDiamondBattleaxe() {
        return diamondBattleaxe;
    }

    public ItemStack getDiamondLongbow() {
        return diamondLongbow;
    }

    public ItemStack getDiamondCrossbow() {
        return diamondCrossbow;
    }

    public ItemStack getIronRapier() {
        return ironRapier;
    }

    public ItemStack getIronKatana() {
        return ironKatana;
    }

    public ItemStack getIronGreatsword() {
        return ironGreatsword;
    }

    public ItemStack getIronLongsword() {
        return ironLongsword;
    }

    public ItemStack getIronSpear() {
        return ironSpear;
    }

    public ItemStack getIronSaber() {
        return ironSaber;
    }

    public ItemStack getIronBoomerang() {
        return ironBoomerang;
    }

    public ItemStack getIronDagger() {
        return ironDagger;
    }

    public ItemStack getIronGlaive() {
        return ironGlaive;
    }

    public ItemStack getIronHalberd() {
        return ironHalberd;
    }

    public ItemStack getIronHammer() {
        return ironHammer;
    }

    public ItemStack getIronJavelin() {
        return ironJavelin;
    }

    public ItemStack getIronLance() {
        return ironLance;
    }

    public ItemStack getIronMace() {
        return ironMace;
    }

    public ItemStack getIronPike() {
        return ironPike;
    }

    public ItemStack getIronQuarterstaff() {
        return ironQuarterstaff;
    }

    public ItemStack getIronThrowingAxe() {
        return ironThrowingAxe;
    }

    public ItemStack getIronThrowingKnife() {
        return ironThrowingKnife;
    }

    public ItemStack getIronWarhammer() {
        return ironWarhammer;
    }

    public ItemStack getIronBattleaxe() {
        return ironBattleaxe;
    }

    public ItemStack getIronLongbow() {
        return ironLongbow;
    }

    public ItemStack getIronCrossbow() {
        return ironCrossbow;
    }

    public ItemStack getGoldenRapier() {
        return goldenRapier;
    }

    public ItemStack getGoldenKatana() {
        return goldenKatana;
    }

    public ItemStack getGoldenGreatsword() {
        return goldenGreatsword;
    }

    public ItemStack getGoldenLongsword() {
        return goldenLongsword;
    }

    public ItemStack getGoldenSpear() {
        return goldenSpear;
    }

    public ItemStack getGoldenSaber() {
        return goldenSaber;
    }

    public ItemStack getGoldenBoomerang() {
        return goldenBoomerang;
    }

    public ItemStack getGoldenDagger() {
        return goldenDagger;
    }

    public ItemStack getGoldenGlaive() {
        return goldenGlaive;
    }

    public ItemStack getGoldenHalberd() {
        return goldenHalberd;
    }

    public ItemStack getGoldenHammer() {
        return goldenHammer;
    }

    public ItemStack getGoldenJavelin() {
        return goldenJavelin;
    }

    public ItemStack getGoldenLance() {
        return goldenLance;
    }

    public ItemStack getGoldenMace() {
        return goldenMace;
    }

    public ItemStack getGoldenPike() {
        return goldenPike;
    }

    public ItemStack getGoldenQuarterstaff() {
        return goldenQuarterstaff;
    }

    public ItemStack getGoldenThrowingAxe() {
        return goldenThrowingAxe;
    }

    public ItemStack getGoldenThrowingKnife() {
        return goldenThrowingKnife;
    }

    public ItemStack getGoldenWarhammer() {
        return goldenWarhammer;
    }

    public ItemStack getGoldenBattleaxe() {
        return goldenBattleaxe;
    }

    public ItemStack getGoldenLongbow() {
        return goldenLongbow;
    }

    public ItemStack getGoldenCrossbow() {
        return goldenCrossbow;
    }

    public ItemStack getStoneRapier() {
        return stoneRapier;
    }

    public ItemStack getStoneKatana() {
        return stoneKatana;
    }

    public ItemStack getStoneGreatsword() {
        return stoneGreatsword;
    }

    public ItemStack getStoneLongsword() {
        return stoneLongsword;
    }

    public ItemStack getStoneSpear() {
        return stoneSpear;
    }

    public ItemStack getStoneSaber() {
        return stoneSaber;
    }

    public ItemStack getStoneBoomerang() {
        return stoneBoomerang;
    }

    public ItemStack getStoneDagger() {
        return stoneDagger;
    }

    public ItemStack getStoneGlaive() {
        return stoneGlaive;
    }

    public ItemStack getStoneHalberd() {
        return stoneHalberd;
    }

    public ItemStack getStoneHammer() {
        return stoneHammer;
    }

    public ItemStack getStoneJavelin() {
        return stoneJavelin;
    }

    public ItemStack getStoneLance() {
        return stoneLance;
    }

    public ItemStack getStoneMace() {
        return stoneMace;
    }

    public ItemStack getStonePike() {
        return stonePike;
    }

    public ItemStack getStoneQuarterstaff() {
        return stoneQuarterstaff;
    }

    public ItemStack getStoneThrowingAxe() {
        return stoneThrowingAxe;
    }

    public ItemStack getStoneThrowingKnife() {
        return stoneThrowingKnife;
    }

    public ItemStack getStoneWarhammer() {
        return stoneWarhammer;
    }

    public ItemStack getStoneBattleaxe() {
        return stoneBattleaxe;
    }

    public ItemStack getWoodenRapier() {
        return woodenRapier;
    }

    public ItemStack getWoodenKatana() {
        return woodenKatana;
    }

    public ItemStack getWoodenGreatsword() {
        return woodenGreatsword;
    }

    public ItemStack getWoodenLongsword() {
        return woodenLongsword;
    }

    public ItemStack getWoodenSpear() {
        return woodenSpear;
    }

    public ItemStack getWoodenSaber() {
        return woodenSaber;
    }

    public ItemStack getWoodenBoomerang() {
        return woodenBoomerang;
    }

    public ItemStack getWoodenDagger() {
        return woodenDagger;
    }

    public ItemStack getWoodenGlaive() {
        return woodenGlaive;
    }

    public ItemStack getWoodenHalberd() {
        return woodenHalberd;
    }

    public ItemStack getWoodenHammer() {
        return woodenHammer;
    }

    public ItemStack getWoodenJavelin() {
        return woodenJavelin;
    }

    public ItemStack getWoodenLance() {
        return woodenLance;
    }

    public ItemStack getWoodenMace() {
        return woodenMace;
    }

    public ItemStack getWoodenPike() {
        return woodenPike;
    }

    public ItemStack getWoodenQuarterstaff() {
        return woodenQuarterstaff;
    }

    public ItemStack getWoodenThrowingAxe() {
        return woodenThrowingAxe;
    }

    public ItemStack getWoodenThrowingKnife() {
        return woodenThrowingKnife;
    }

    public ItemStack getWoodenWarhammer() {
        return woodenWarhammer;
    }

    public ItemStack getWoodenBattleaxe() {
        return woodenBattleaxe;
    }

    public ItemStack getWoodenLongbow() {
        return woodenLongbow;
    }

    public ItemStack getWoodenCrossbow() {
        return woodenCrossbow;
    }

    public ItemStack getWoodenClub() {
        return woodenClub;
    }

    public ItemStack getLeatherLongbow() {
        return leatherLongbow;
    }

    public ItemStack getLeatherCrossbow() {
        return leatherCrossbow;
    }

    public ItemStack getCopperRapier() {
        return copperRapier;
    }

    public ItemStack getCopperKatana() {
        return copperKatana;
    }

    public ItemStack getCopperGreatsword() {
        return copperGreatsword;
    }

    public ItemStack getCopperLongsword() {
        return copperLongsword;
    }

    public ItemStack getCopperSpear() {
        return copperSpear;
    }

    public ItemStack getCopperSaber() {
        return copperSaber;
    }

    public ItemStack getCopperBoomerang() {
        return copperBoomerang;
    }

    public ItemStack getCopperDagger() {
        return copperDagger;
    }

    public ItemStack getCopperGlaive() {
        return copperGlaive;
    }

    public ItemStack getCopperHalberd() {
        return copperHalberd;
    }

    public ItemStack getCopperHammer() {
        return copperHammer;
    }

    public ItemStack getCopperJavelin() {
        return copperJavelin;
    }

    public ItemStack getCopperLance() {
        return copperLance;
    }

    public ItemStack getCopperMace() {
        return copperMace;
    }

    public ItemStack getCopperPike() {
        return copperPike;
    }

    public ItemStack getCopperQuarterstaff() {
        return copperQuarterstaff;
    }

    public ItemStack getCopperThrowingAxe() {
        return copperThrowingAxe;
    }

    public ItemStack getCopperThrowingKnife() {
        return copperThrowingKnife;
    }

    public ItemStack getCopperWarhammer() {
        return copperWarhammer;
    }

    public ItemStack getCopperBattleaxe() {
        return copperBattleaxe;
    }

    public ItemStack getCopperLongbow() {
        return copperLongbow;
    }

    public ItemStack getCopperCrossbow() {
        return copperCrossbow;
    }

    public ItemStack getStuddedClub() {
        return studdedClub;
    }

    public ItemStack getAppleJuice() {
        return appleJuice;
    }

    public ItemStack getBeetrootJuice() {
        return beetrootJuice;
    }

    public ItemStack getCactusJuice() {
        return cactusJuice;
    }

    public ItemStack getCarrotJuice() {
        return carrotJuice;
    }

    public ItemStack getChorusFruitJuice() {
        return chorusFruitJuice;
    }

    public ItemStack getGlisteringMelonJuice() {
        return glisteringMelonJuice;
    }

    public ItemStack getGoldenAppleJuice() {
        return goldenAppleJuice;
    }

    public ItemStack getGoldenCarrotJuice() {
        return goldenCarrotJuice;
    }

    public ItemStack getMelonJuice() {
        return melonJuice;
    }

    public ItemStack getPumpkinJuice() {
        return pumpkinJuice;
    }

    public ItemStack getPurifiedWaterBottle() {
        return purifiedWaterBottle;
    }

    public ItemStack getWaterBottle() {
        return waterBottle;
    }

    public ItemStack getCharcoalFilter() {
        return charcoalFilter;
    }

    public ItemStack getIceCube() {
        return iceCube;
    }

    public ItemStack getMagmaShard() {
        return magmaShard;
    }

    public ItemStack getJelledSlime() {
        return jelledSlime;
    }

    public ItemStack getThermometer() {
        return thermometer;
    }

    public ItemStack getWoolHood() {
        return woolHood;
    }

    public ItemStack getWoolJacket() {
        return woolJacket;
    }

    public ItemStack getWoolPants() {
        return woolPants;
    }

    public ItemStack getWoolBoots() {
        return woolBoots;
    }

    public ItemStack getJelledSlimeHelmet() {
        return jelledSlimeHelmet;
    }

    public ItemStack getJelledSlimeChestplate() {
        return jelledSlimeChestplate;
    }

    public ItemStack getJelledSlimeLeggings() {
        return jelledSlimeLeggings;
    }

    public ItemStack getJelledSlimeBoots() {
        return jelledSlimeBoots;
    }


}