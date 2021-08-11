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
import org.bukkit.inventory.ItemStack;
/**
 * CustomItems is a utility class creating and storing every custom item
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class CustomItems {

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
    private ItemStack blueDragonScales;
    private ItemStack bronzeDragonScales;
    private ItemStack grayDragonScales;
    private ItemStack greenDragonScales;
    private ItemStack redDragonScales;
    private ItemStack sapphireDragonScales;
    private ItemStack silverDragonScales;
    private ItemStack whiteDragonScales;
    private ItemStack amethystDragonScales;
    private ItemStack blackDragonScales;
    private ItemStack copperDragonScales;
    private ItemStack electricDragonScales;
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
    private ItemStack blueDragonScaleHelmet;
    private ItemStack blueDragonScaleChestplate;
    private ItemStack blueDragonScaleLeggings;
    private ItemStack blueDragonScaleBoots;
    private ItemStack bronzeDragonScaleHelmet;
    private ItemStack bronzeDragonScaleChestplate;
    private ItemStack bronzeDragonScaleLeggings;
    private ItemStack bronzeDragonScaleBoots;
    private ItemStack grayDragonScaleHelmet;
    private ItemStack grayDragonScaleChestplate;
    private ItemStack grayDragonScaleLeggings;
    private ItemStack grayDragonScaleBoots;
    private ItemStack greenDragonScaleHelmet;
    private ItemStack greenDragonScaleChestplate;
    private ItemStack greenDragonScaleLeggings;
    private ItemStack greenDragonScaleBoots;
    private ItemStack redDragonScaleHelmet;
    private ItemStack redDragonScaleChestplate;
    private ItemStack redDragonScaleLeggings;
    private ItemStack redDragonScaleBoots;
    private ItemStack sapphireDragonScaleHelmet;
    private ItemStack sapphireDragonScaleChestplate;
    private ItemStack sapphireDragonScaleLeggings;
    private ItemStack sapphireDragonScaleBoots;
    private ItemStack silverDragonScaleHelmet;
    private ItemStack silverDragonScaleChestplate;
    private ItemStack silverDragonScaleLeggings;
    private ItemStack silverDragonScaleBoots;
    private ItemStack whiteDragonScaleHelmet;
    private ItemStack whiteDragonScaleChestplate;
    private ItemStack whiteDragonScaleLeggings;
    private ItemStack whiteDragonScaleBoots;
    private ItemStack amethystDragonScaleHelmet;
    private ItemStack amethystDragonScaleChestplate;
    private ItemStack amethystDragonScaleLeggings;
    private ItemStack amethystDragonScaleBoots;
    private ItemStack blackDragonScaleHelmet;
    private ItemStack blackDragonScaleChestplate;
    private ItemStack blackDragonScaleLeggings;
    private ItemStack blackDragonScaleBoots;
    private ItemStack copperDragonScaleHelmet;
    private ItemStack copperDragonScaleChestplate;
    private ItemStack copperDragonScaleLeggings;
    private ItemStack copperDragonScaleBoots;
    private ItemStack electricDragonScaleHelmet;
    private ItemStack electricDragonScaleChestplate;
    private ItemStack electricDragonScaleLeggings;
    private ItemStack electricDragonScaleBoots;
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
    private ItemStack flamedDragonBoneSword;
    private ItemStack icedDragonBoneSword;
    private ItemStack lightningDragonBoneSword;
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
    private ItemStack enderDragonScale;
    private ItemStack crackedBlackDragonScale;
    private ItemStack blackDragonScale;
    private ItemStack mixedColorDragonScale;
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
    private ItemStack flamedDragonBoneRapier;
    private ItemStack flamedDragonBoneKatana;
    private ItemStack flamedDragonBoneGreatsword;
    private ItemStack flamedDragonBoneLongsword;
    private ItemStack flamedDragonBoneSpear;
    private ItemStack flamedDragonBoneSaber;
    private ItemStack flamedDragonBoneBoomerang;
    private ItemStack flamedDragonBoneDagger;
    private ItemStack flamedDragonBoneGlaive;
    private ItemStack flamedDragonBoneHalberd;
    private ItemStack flamedDragonBoneHammer;
    private ItemStack flamedDragonBoneJavelin;
    private ItemStack flamedDragonBoneLance;
    private ItemStack flamedDragonBoneMace;
    private ItemStack flamedDragonBonePike;
    private ItemStack flamedDragonBoneQuarterstaff;
    private ItemStack flamedDragonBoneThrowingAxe;
    private ItemStack flamedDragonBoneThrowingKnife;
    private ItemStack flamedDragonBoneWarhammer;
    private ItemStack flamedDragonBoneBattleaxe;
    private ItemStack flamedDragonBoneLongbow;
    private ItemStack flamedDragonBoneCrossbow;
    private ItemStack icedDragonBoneRapier;
    private ItemStack icedDragonBoneKatana;
    private ItemStack icedDragonBoneGreatsword;
    private ItemStack icedDragonBoneLongsword;
    private ItemStack icedDragonBoneSpear;
    private ItemStack icedDragonBoneSaber;
    private ItemStack icedDragonBoneBoomerang;
    private ItemStack icedDragonBoneDagger;
    private ItemStack icedDragonBoneGlaive;
    private ItemStack icedDragonBoneHalberd;
    private ItemStack icedDragonBoneHammer;
    private ItemStack icedDragonBoneJavelin;
    private ItemStack icedDragonBoneLance;
    private ItemStack icedDragonBoneMace;
    private ItemStack icedDragonBonePike;
    private ItemStack icedDragonBoneQuarterstaff;
    private ItemStack icedDragonBoneThrowingAxe;
    private ItemStack icedDragonBoneThrowingKnife;
    private ItemStack icedDragonBoneWarhammer;
    private ItemStack icedDragonBoneBattleaxe;
    private ItemStack icedDragonBoneLongbow;
    private ItemStack icedDragonBoneCrossbow;
    private ItemStack lightningDragonBoneRapier;
    private ItemStack lightningDragonBoneKatana;
    private ItemStack lightningDragonBoneGreatsword;
    private ItemStack lightningDragonBoneLongsword;
    private ItemStack lightningDragonBoneSpear;
    private ItemStack lightningDragonBoneSaber;
    private ItemStack lightningDragonBoneBoomerang;
    private ItemStack lightningDragonBoneDagger;
    private ItemStack lightningDragonBoneGlaive;
    private ItemStack lightningDragonBoneHalberd;
    private ItemStack lightningDragonBoneHammer;
    private ItemStack lightningDragonBoneJavelin;
    private ItemStack lightningDragonBoneLance;
    private ItemStack lightningDragonBoneMace;
    private ItemStack lightningDragonBonePike;
    private ItemStack lightningDragonBoneQuarterstaff;
    private ItemStack lightningDragonBoneThrowingAxe;
    private ItemStack lightningDragonBoneThrowingKnife;
    private ItemStack lightningDragonBoneWarhammer;
    private ItemStack lightningDragonBoneBattleaxe;
    private ItemStack lightningDragonBoneLongbow;
    private ItemStack lightningDragonBoneCrossbow;
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

    public CustomItems(RLCraftPlugin instance) {

        flintAxe = new ItemBuilder(CustomConfig.getItemConfig(), 0, CustomConfig.getNoTreePunchingConfig(), ItemBuilder.AXE, instance);
        flintKnife = new ItemBuilder(CustomConfig.getItemConfig(), 1, CustomConfig.getNoTreePunchingConfig(), ItemBuilder.KNIFE, instance);
        flintPickaxe = new ItemBuilder(CustomConfig.getItemConfig(), 2, CustomConfig.getNoTreePunchingConfig(), ItemBuilder.PICKAXE, instance);
        flintShovel = new ItemBuilder(CustomConfig.getItemConfig(), 3, CustomConfig.getNoTreePunchingConfig(), ItemBuilder.SHOVEL, instance);
        flintHoe = new ItemBuilder(CustomConfig.getItemConfig(), 4, CustomConfig.getNoTreePunchingConfig(), ItemBuilder.HOE, instance);
        plantFiber = new ItemBuilder(CustomConfig.getItemConfig(), 5, instance);
        plantString = new ItemBuilder(CustomConfig.getItemConfig(), 6, instance);
        flintShard = new ItemBuilder(CustomConfig.getItemConfig(), 7, instance);
        dragonBone = new ItemBuilder(CustomConfig.getItemConfig(), 8, instance);
        witherbone = new ItemBuilder(CustomConfig.getItemConfig(), 9, instance);
        blueDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 10, instance);
        bronzeDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 11, instance);
        grayDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 12, instance);
        greenDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 13, instance);
        redDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 14, instance);
        sapphireDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 15, instance);
        silverDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 16, instance);
        whiteDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 17, instance);
        amethystDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 18, instance);
        blackDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 19, instance);
        copperDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 20, instance);
        electricDragonScales = new ItemBuilder(CustomConfig.getItemConfig(), 21, instance);
        blueSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 22, instance);
        bronzeSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 23, instance);
        deepBlueSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 24, instance);
        greenSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 25, instance);
        purpleSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 26, instance);
        redSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 27, instance);
        tealSeaSerpentScales = new ItemBuilder(CustomConfig.getItemConfig(), 28, instance);
        shinyScales = new ItemBuilder(CustomConfig.getItemConfig(), 29, instance);
        fireDragonBlood = new ItemBuilder(CustomConfig.getItemConfig(), 30, instance);
        iceDragonBlood = new ItemBuilder(CustomConfig.getItemConfig(), 31, instance);
        lightningDragonBlood = new ItemBuilder(CustomConfig.getItemConfig(), 32, instance);
        fireDragonHeart = new ItemBuilder(CustomConfig.getItemConfig(), 33, instance);
        iceDragonHeart = new ItemBuilder(CustomConfig.getItemConfig(), 34, instance);
        lightningDragonHeart = new ItemBuilder(CustomConfig.getItemConfig(), 35, instance);
        fireDragonSkull = new ItemBuilder(CustomConfig.getItemConfig(), 36, instance);
        iceDragonSkull = new ItemBuilder(CustomConfig.getItemConfig(), 37, instance);
        lightningDragonSkull = new ItemBuilder(CustomConfig.getItemConfig(), 38, instance);
        fireDragonFlesh = new ItemBuilder(CustomConfig.getItemConfig(), 39, instance);
        iceDragonFlesh = new ItemBuilder(CustomConfig.getItemConfig(), 40, instance);
        lightningDragonFlesh = new ItemBuilder(CustomConfig.getItemConfig(), 41, instance);
        fireDragonsteelIngot = new ItemBuilder(CustomConfig.getItemConfig(), 42, instance);
        iceDragonsteelIngot = new ItemBuilder(CustomConfig.getItemConfig(), 43, instance);
        lightningDragonsteelIngot = new ItemBuilder(CustomConfig.getItemConfig(), 44, instance);
        blueDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 45, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        blueDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 46, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        blueDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 47, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        blueDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 48, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        bronzeDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 49, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        bronzeDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 50, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        bronzeDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 51, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        bronzeDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 52, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        grayDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 53, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        grayDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 54, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        grayDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 55, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        grayDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 56, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        greenDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 57, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        greenDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 58, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        greenDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 59, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        greenDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 60, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        redDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 61, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        redDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 62, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        redDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 63, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        redDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 64, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        sapphireDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 65, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        sapphireDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 66, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        sapphireDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 67, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        sapphireDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 68, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        silverDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 69, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        silverDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 70, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        silverDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 71, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        silverDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 72, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        whiteDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 73, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        whiteDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 74, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        whiteDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 75, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        whiteDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 76, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        amethystDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 77, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        amethystDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 78, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        amethystDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 79, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        amethystDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 80, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        blackDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 81, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        blackDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 82, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        blackDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 83, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        blackDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 84, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        copperDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 85, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        copperDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 86, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        copperDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 87, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        copperDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 88, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        electricDragonScaleHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 89, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        electricDragonScaleChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 90, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        electricDragonScaleLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 91, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        electricDragonScaleBoots = new ItemBuilder(CustomConfig.getItemConfig(), 92, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        blueTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 93, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        blueTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 94, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        blueTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 95, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        blueTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 96, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        bronzeTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 97, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        bronzeTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 98, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        bronzeTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 99, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        bronzeTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 100, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        deepBlueTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 101, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        deepBlueTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 102, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        deepBlueTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 103, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        deepBlueTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 104, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        greenTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 105, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        greenTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 106, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        greenTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 107, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        greenTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 108, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        purpleTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 109, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        purpleTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 110, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        purpleTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 111, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        purpleTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 112, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        redTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 113, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        redTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 114, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        redTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 115, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        redTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 116, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        tealTideGuardianHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 117, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        tealTideGuardianChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 118, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        tealTideGuardianLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 119, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        tealTideGuardianBoots = new ItemBuilder(CustomConfig.getItemConfig(), 120, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        dragonBonePickaxe = new ItemBuilder(CustomConfig.getItemConfig(), 121, CustomConfig.getIceFireGearConfig(), ItemBuilder.PICKAXE, instance);
        dragonBoneAxe = new ItemBuilder(CustomConfig.getItemConfig(), 122, CustomConfig.getIceFireGearConfig(), ItemBuilder.AXE, instance);
        dragonBoneShovel = new ItemBuilder(CustomConfig.getItemConfig(), 123, CustomConfig.getIceFireGearConfig(), ItemBuilder.SHOVEL, instance);
        dragonBoneHoe = new ItemBuilder(CustomConfig.getItemConfig(), 124, CustomConfig.getIceFireGearConfig(), ItemBuilder.HOE, instance);
        dragonBoneSword = new ItemBuilder(CustomConfig.getItemConfig(), 125, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        dragonBoneBow = new ItemBuilder(CustomConfig.getItemConfig(), 126, instance);
        flamedDragonBoneSword = new ItemBuilder(CustomConfig.getItemConfig(), 127, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        icedDragonBoneSword = new ItemBuilder(CustomConfig.getItemConfig(), 128, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        lightningDragonBoneSword = new ItemBuilder(CustomConfig.getItemConfig(), 129, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        dragonsEye = new ItemBuilder(CustomConfig.getItemConfig(), 130, instance);
        poisonStone = new ItemBuilder(CustomConfig.getItemConfig(), 131, instance);
        potionRingResistance = new ItemBuilder(CustomConfig.getItemConfig(), 132, instance);
        potionRingRegeneration = new ItemBuilder(CustomConfig.getItemConfig(), 133, instance);
        potionRingHaste = new ItemBuilder(CustomConfig.getItemConfig(), 134, instance);
        potionRingStrength = new ItemBuilder(CustomConfig.getItemConfig(), 135, instance);
        potionRingSpeed = new ItemBuilder(CustomConfig.getItemConfig(), 136, instance);
        potionRingJumpBoost = new ItemBuilder(CustomConfig.getItemConfig(), 137, instance);
        enderQueensCrown = new ItemBuilder(CustomConfig.getItemConfig(), 138, instance);
        sunglasses = new ItemBuilder(CustomConfig.getItemConfig(), 139, instance);
        balloon = new ItemBuilder(CustomConfig.getItemConfig(), 140, instance);
        cobaltShield = new ItemBuilder(CustomConfig.getItemConfig(), 141, instance);
        obsidianSkull = new ItemBuilder(CustomConfig.getItemConfig(), 142, instance);
        obsidianShield = new ItemBuilder(CustomConfig.getItemConfig(), 143, instance);
        forbiddenFruit = new ItemBuilder(CustomConfig.getItemConfig(), 144, instance);
        vitamins = new ItemBuilder(CustomConfig.getItemConfig(), 145, instance);
        ringOverclocking = new ItemBuilder(CustomConfig.getItemConfig(), 146, instance);
        shulkerHeart = new ItemBuilder(CustomConfig.getItemConfig(), 147, instance);
        ringFreeAction = new ItemBuilder(CustomConfig.getItemConfig(), 148, instance);
        bezoar = new ItemBuilder(CustomConfig.getItemConfig(), 149, instance);
        enderDragonScale = new ItemBuilder(CustomConfig.getItemConfig(), 150, instance);
        crackedBlackDragonScale = new ItemBuilder(CustomConfig.getItemConfig(), 151, instance);
        blackDragonScale = new ItemBuilder(CustomConfig.getItemConfig(), 152, instance);
        mixedColorDragonScale = new ItemBuilder(CustomConfig.getItemConfig(), 153, instance);
        ankhCharm = new ItemBuilder(CustomConfig.getItemConfig(), 154, instance);
        ankhShield = new ItemBuilder(CustomConfig.getItemConfig(), 155, instance);
        ironRing = new ItemBuilder(CustomConfig.getItemConfig(), 156, instance);
        magicMirror = new ItemBuilder(CustomConfig.getItemConfig(), 157, instance);
        recallPotion = new ItemBuilder(CustomConfig.getItemConfig(), 158, instance);
        wormholeMirror = new ItemBuilder(CustomConfig.getItemConfig(), 159, instance);
        wormholePotion = new ItemBuilder(CustomConfig.getItemConfig(), 160, instance);
        luckyHorseshoe = new ItemBuilder(CustomConfig.getItemConfig(), 161, instance);
        battleBurrito = new ItemBuilder(CustomConfig.getItemConfig(), 162, instance);
        scarliteRing = new ItemBuilder(CustomConfig.getItemConfig(), 163, instance);
        spectralSilt = new ItemBuilder(CustomConfig.getItemConfig(), 164, instance);
        disintegrationTablet = new ItemBuilder(CustomConfig.getItemConfig(), 165, instance);
        brokenHeart = new ItemBuilder(CustomConfig.getItemConfig(), 166, instance);
        crossNecklace = new ItemBuilder(CustomConfig.getItemConfig(), 167, instance);
        wrathPendant = new ItemBuilder(CustomConfig.getItemConfig(), 168, instance);
        pridePendant = new ItemBuilder(CustomConfig.getItemConfig(), 169, instance);
        goldenCrown = new ItemBuilder(CustomConfig.getItemConfig(), 170, instance);
        gluttonyPendant = new ItemBuilder(CustomConfig.getItemConfig(), 171, instance);
        sinPendant = new ItemBuilder(CustomConfig.getItemConfig(), 172, instance);
        flareGun = new ItemBuilder(CustomConfig.getItemConfig(), 173, instance);
        flare = new ItemBuilder(CustomConfig.getItemConfig(), 174, instance);
        phytoprotostasiaAmulet = new ItemBuilder(CustomConfig.getItemConfig(), 175, instance);
        potionRing = new ItemBuilder(CustomConfig.getItemConfig(), 176, instance);
        emeraldRing = new ItemBuilder(CustomConfig.getItemConfig(), 177, instance);
        emeraldAmulet = new ItemBuilder(CustomConfig.getItemConfig(), 178, instance);
        glowingIngot = new ItemBuilder(CustomConfig.getItemConfig(), 179, instance);
        glowingPowder = new ItemBuilder(CustomConfig.getItemConfig(), 180, instance);
        glowingGem = new ItemBuilder(CustomConfig.getItemConfig(), 181, instance);
        dwarfStout = new ItemBuilder(CustomConfig.getItemConfig(), 182, instance);
        fairyDew = new ItemBuilder(CustomConfig.getItemConfig(), 183, instance);
        stoneNegativeGravity = new ItemBuilder(CustomConfig.getItemConfig(), 184, instance);
        stoneInertiaNull = new ItemBuilder(CustomConfig.getItemConfig(), 185, instance);
        stoneGreaterInertia = new ItemBuilder(CustomConfig.getItemConfig(), 186, instance);
        ringEnchantedEyes = new ItemBuilder(CustomConfig.getItemConfig(), 187, instance);
        stoneSea = new ItemBuilder(CustomConfig.getItemConfig(), 188, instance);
        polarizedStone = new ItemBuilder(CustomConfig.getItemConfig(), 189, instance);
        ringFairies = new ItemBuilder(CustomConfig.getItemConfig(), 190, instance);
        ringDwarves = new ItemBuilder(CustomConfig.getItemConfig(), 191, instance);
        witherRing = new ItemBuilder(CustomConfig.getItemConfig(), 192, instance);
        shieldHonor = new ItemBuilder(CustomConfig.getItemConfig(), 193, instance);
        minersRing = new ItemBuilder(CustomConfig.getItemConfig(), 194, instance);
        warpedScroll = new ItemBuilder(CustomConfig.getItemConfig(), 195, instance);
        fireResistancePotion = new ItemBuilder(CustomConfig.getItemConfig(), 196, instance);
        fireDragonsteelSword = new ItemBuilder(CustomConfig.getItemConfig(), 197, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        fireDragonsteelPickaxe = new ItemBuilder(CustomConfig.getItemConfig(), 198, CustomConfig.getIceFireGearConfig(), ItemBuilder.PICKAXE, instance);
        fireDragonsteelAxe = new ItemBuilder(CustomConfig.getItemConfig(), 199, CustomConfig.getIceFireGearConfig(), ItemBuilder.AXE, instance);
        fireDragonsteelShovel = new ItemBuilder(CustomConfig.getItemConfig(), 200, CustomConfig.getIceFireGearConfig(), ItemBuilder.SHOVEL, instance);
        fireDragonsteelHoe = new ItemBuilder(CustomConfig.getItemConfig(), 201, CustomConfig.getIceFireGearConfig(), ItemBuilder.HOE, instance);
        iceDragonsteelSword = new ItemBuilder(CustomConfig.getItemConfig(), 202, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        iceDragonsteelPickaxe = new ItemBuilder(CustomConfig.getItemConfig(), 203, CustomConfig.getIceFireGearConfig(), ItemBuilder.PICKAXE, instance);
        iceDragonsteelAxe = new ItemBuilder(CustomConfig.getItemConfig(), 204, CustomConfig.getIceFireGearConfig(), ItemBuilder.AXE, instance);
        iceDragonsteelShovel = new ItemBuilder(CustomConfig.getItemConfig(), 205, CustomConfig.getIceFireGearConfig(), ItemBuilder.SHOVEL, instance);
        iceDragonsteelHoe = new ItemBuilder(CustomConfig.getItemConfig(), 206, CustomConfig.getIceFireGearConfig(), ItemBuilder.HOE, instance);
        lightningDragonsteelSword = new ItemBuilder(CustomConfig.getItemConfig(), 207, CustomConfig.getIceFireGearConfig(), ItemBuilder.SWORD, instance);
        lightningDragonsteelPickaxe = new ItemBuilder(CustomConfig.getItemConfig(), 208, CustomConfig.getIceFireGearConfig(), ItemBuilder.PICKAXE, instance);
        lightningDragonsteelAxe = new ItemBuilder(CustomConfig.getItemConfig(), 209, CustomConfig.getIceFireGearConfig(), ItemBuilder.AXE, instance);
        lightningDragonsteelShovel = new ItemBuilder(CustomConfig.getItemConfig(), 210, CustomConfig.getIceFireGearConfig(), ItemBuilder.SHOVEL, instance);
        lightningDragonsteelHoe = new ItemBuilder(CustomConfig.getItemConfig(), 211, CustomConfig.getIceFireGearConfig(), ItemBuilder.HOE, instance);
        fireDragonsteelHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 212, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        fireDragonsteelChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 213, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        fireDragonsteelLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 214, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        fireDragonsteelBoots = new ItemBuilder(CustomConfig.getItemConfig(), 215, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        iceDragonsteelHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 216, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        iceDragonsteelChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 217, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        iceDragonsteelLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 218, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        iceDragonsteelBoots = new ItemBuilder(CustomConfig.getItemConfig(), 219, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        lightningDragonsteelHelmet = new ItemBuilder(CustomConfig.getItemConfig(), 220, CustomConfig.getIceFireGearConfig(), ItemBuilder.HELMET, instance);
        lightningDragonsteelChestplate = new ItemBuilder(CustomConfig.getItemConfig(), 221, CustomConfig.getIceFireGearConfig(), ItemBuilder.CHESTPLATE, instance);
        lightningDragonsteelLeggings = new ItemBuilder(CustomConfig.getItemConfig(), 222, CustomConfig.getIceFireGearConfig(), ItemBuilder.LEGGINGS, instance);
        lightningDragonsteelBoots = new ItemBuilder(CustomConfig.getItemConfig(), 223, CustomConfig.getIceFireGearConfig(), ItemBuilder.BOOTS, instance);
        dragonBoneRapier = new ItemBuilder(CustomConfig.getItemConfig(), 224, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        dragonBoneKatana = new ItemBuilder(CustomConfig.getItemConfig(), 225, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        dragonBoneGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 226, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        dragonBoneLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 227, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        dragonBoneSpear = new ItemBuilder(CustomConfig.getItemConfig(), 228, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        dragonBoneSaber = new ItemBuilder(CustomConfig.getItemConfig(), 229, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        dragonBoneBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 230, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        dragonBoneDagger = new ItemBuilder(CustomConfig.getItemConfig(), 231, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        dragonBoneGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 232, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        dragonBoneHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 233, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        dragonBoneHammer = new ItemBuilder(CustomConfig.getItemConfig(), 234, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        dragonBoneJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 235, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        dragonBoneLance = new ItemBuilder(CustomConfig.getItemConfig(), 236, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        dragonBoneMace = new ItemBuilder(CustomConfig.getItemConfig(), 237, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        dragonBonePike = new ItemBuilder(CustomConfig.getItemConfig(), 238, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        dragonBoneQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 239, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        dragonBoneThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 240, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        dragonBoneThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 241, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        dragonBoneWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 242, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        dragonBoneBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 243, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        dragonBoneLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 244, instance);
        dragonBoneCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 245, instance);
        flamedDragonBoneRapier = new ItemBuilder(CustomConfig.getItemConfig(), 246, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        flamedDragonBoneKatana = new ItemBuilder(CustomConfig.getItemConfig(), 247, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        flamedDragonBoneGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 248, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        flamedDragonBoneLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 249, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        flamedDragonBoneSpear = new ItemBuilder(CustomConfig.getItemConfig(), 250, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        flamedDragonBoneSaber = new ItemBuilder(CustomConfig.getItemConfig(), 251, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        flamedDragonBoneBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 252, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        flamedDragonBoneDagger = new ItemBuilder(CustomConfig.getItemConfig(), 253, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        flamedDragonBoneGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 254, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        flamedDragonBoneHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 255, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        flamedDragonBoneHammer = new ItemBuilder(CustomConfig.getItemConfig(), 256, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        flamedDragonBoneJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 257, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        flamedDragonBoneLance = new ItemBuilder(CustomConfig.getItemConfig(), 258, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        flamedDragonBoneMace = new ItemBuilder(CustomConfig.getItemConfig(), 259, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        flamedDragonBonePike = new ItemBuilder(CustomConfig.getItemConfig(), 260, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        flamedDragonBoneQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 261, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        flamedDragonBoneThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 262, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        flamedDragonBoneThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 263, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        flamedDragonBoneWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 264, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        flamedDragonBoneBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 265, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        flamedDragonBoneLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 266, instance);
        flamedDragonBoneCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 267, instance);
        icedDragonBoneRapier = new ItemBuilder(CustomConfig.getItemConfig(), 268, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        icedDragonBoneKatana = new ItemBuilder(CustomConfig.getItemConfig(), 269, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        icedDragonBoneGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 270, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        icedDragonBoneLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 271, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        icedDragonBoneSpear = new ItemBuilder(CustomConfig.getItemConfig(), 272, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        icedDragonBoneSaber = new ItemBuilder(CustomConfig.getItemConfig(), 273, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        icedDragonBoneBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 274, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        icedDragonBoneDagger = new ItemBuilder(CustomConfig.getItemConfig(), 275, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        icedDragonBoneGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 276, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        icedDragonBoneHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 277, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        icedDragonBoneHammer = new ItemBuilder(CustomConfig.getItemConfig(), 278, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        icedDragonBoneJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 279, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        icedDragonBoneLance = new ItemBuilder(CustomConfig.getItemConfig(), 280, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        icedDragonBoneMace = new ItemBuilder(CustomConfig.getItemConfig(), 281, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        icedDragonBonePike = new ItemBuilder(CustomConfig.getItemConfig(), 282, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        icedDragonBoneQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 283, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        icedDragonBoneThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 284, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        icedDragonBoneThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 285, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        icedDragonBoneWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 286, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        icedDragonBoneBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 287, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        icedDragonBoneLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 288, instance);
        icedDragonBoneCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 289, instance);
        lightningDragonBoneRapier = new ItemBuilder(CustomConfig.getItemConfig(), 290, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        lightningDragonBoneKatana = new ItemBuilder(CustomConfig.getItemConfig(), 291, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        lightningDragonBoneGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 292, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        lightningDragonBoneLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 293, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        lightningDragonBoneSpear = new ItemBuilder(CustomConfig.getItemConfig(), 294, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        lightningDragonBoneSaber = new ItemBuilder(CustomConfig.getItemConfig(), 295, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        lightningDragonBoneBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 296, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        lightningDragonBoneDagger = new ItemBuilder(CustomConfig.getItemConfig(), 297, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        lightningDragonBoneGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 298, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        lightningDragonBoneHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 299, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        lightningDragonBoneHammer = new ItemBuilder(CustomConfig.getItemConfig(), 300, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        lightningDragonBoneJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 301, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        lightningDragonBoneLance = new ItemBuilder(CustomConfig.getItemConfig(), 302, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        lightningDragonBoneMace = new ItemBuilder(CustomConfig.getItemConfig(), 303, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        lightningDragonBonePike = new ItemBuilder(CustomConfig.getItemConfig(), 304, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        lightningDragonBoneQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 305, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        lightningDragonBoneThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 306, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        lightningDragonBoneThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 307, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        lightningDragonBoneWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 308, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        lightningDragonBoneBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 309, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        lightningDragonBoneLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 310, instance);
        lightningDragonBoneCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 311, instance);
        fireDragonsteelRapier = new ItemBuilder(CustomConfig.getItemConfig(), 312, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        fireDragonsteelKatana = new ItemBuilder(CustomConfig.getItemConfig(), 313, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        fireDragonsteelGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 314, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        fireDragonsteelLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 315, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        fireDragonsteelSpear = new ItemBuilder(CustomConfig.getItemConfig(), 316, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        fireDragonsteelSaber = new ItemBuilder(CustomConfig.getItemConfig(), 317, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        fireDragonsteelBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 318, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        fireDragonsteelDagger = new ItemBuilder(CustomConfig.getItemConfig(), 319, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        fireDragonsteelGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 320, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        fireDragonsteelHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 321, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        fireDragonsteelHammer = new ItemBuilder(CustomConfig.getItemConfig(), 322, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        fireDragonsteelJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 323, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        fireDragonsteelLance = new ItemBuilder(CustomConfig.getItemConfig(), 324, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        fireDragonsteelMace = new ItemBuilder(CustomConfig.getItemConfig(), 325, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        fireDragonsteelPike = new ItemBuilder(CustomConfig.getItemConfig(), 326, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        fireDragonsteelQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 327, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        fireDragonsteelThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 328, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        fireDragonsteelThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 329, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        fireDragonsteelWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 330, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        fireDragonsteelBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 331, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        fireDragonsteelLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 332, instance);
        fireDragonsteelCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 333, instance);
        iceDragonsteelRapier = new ItemBuilder(CustomConfig.getItemConfig(), 334, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        iceDragonsteelKatana = new ItemBuilder(CustomConfig.getItemConfig(), 335, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        iceDragonsteelGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 336, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        iceDragonsteelLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 337, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        iceDragonsteelSpear = new ItemBuilder(CustomConfig.getItemConfig(), 338, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        iceDragonsteelSaber = new ItemBuilder(CustomConfig.getItemConfig(), 339, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        iceDragonsteelBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 340, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        iceDragonsteelDagger = new ItemBuilder(CustomConfig.getItemConfig(), 341, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        iceDragonsteelGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 342, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        iceDragonsteelHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 343, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        iceDragonsteelHammer = new ItemBuilder(CustomConfig.getItemConfig(), 344, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        iceDragonsteelJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 345, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        iceDragonsteelLance = new ItemBuilder(CustomConfig.getItemConfig(), 346, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        iceDragonsteelMace = new ItemBuilder(CustomConfig.getItemConfig(), 347, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        iceDragonsteelPike = new ItemBuilder(CustomConfig.getItemConfig(), 348, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        iceDragonsteelQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 349, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        iceDragonsteelThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 350, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        iceDragonsteelThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 351, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        iceDragonsteelWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 352, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        iceDragonsteelBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 353, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        iceDragonsteelLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 354, instance);
        iceDragonsteelCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 355, instance);
        lightningDragonsteelRapier = new ItemBuilder(CustomConfig.getItemConfig(), 356, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        lightningDragonsteelKatana = new ItemBuilder(CustomConfig.getItemConfig(), 357, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        lightningDragonsteelGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 358, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        lightningDragonsteelLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 359, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        lightningDragonsteelSpear = new ItemBuilder(CustomConfig.getItemConfig(), 360, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        lightningDragonsteelSaber = new ItemBuilder(CustomConfig.getItemConfig(), 361, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        lightningDragonsteelBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 362, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        lightningDragonsteelDagger = new ItemBuilder(CustomConfig.getItemConfig(), 363, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        lightningDragonsteelGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 364, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        lightningDragonsteelHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 365, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        lightningDragonsteelHammer = new ItemBuilder(CustomConfig.getItemConfig(), 366, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        lightningDragonsteelJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 367, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        lightningDragonsteelLance = new ItemBuilder(CustomConfig.getItemConfig(), 368, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        lightningDragonsteelMace = new ItemBuilder(CustomConfig.getItemConfig(), 369, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        lightningDragonsteelPike = new ItemBuilder(CustomConfig.getItemConfig(), 370, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        lightningDragonsteelQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 371, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        lightningDragonsteelThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 372, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        lightningDragonsteelThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 373, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        lightningDragonsteelWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 374, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        lightningDragonsteelBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 375, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        lightningDragonsteelLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 376, instance);
        lightningDragonsteelCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 377, instance);
        fireDragonsteelBlock = new ItemBuilder(CustomConfig.getItemConfig(), 378, instance);
        iceDragonsteelBlock = new ItemBuilder(CustomConfig.getItemConfig(), 379, instance);
        lightningDragonsteelBlock = new ItemBuilder(CustomConfig.getItemConfig(), 380, instance);
        boundScroll = new ItemBuilder(CustomConfig.getItemConfig(), 381, instance);
        returnScroll = new ItemBuilder(CustomConfig.getItemConfig(), 382, instance);
        handle = new ItemBuilder(CustomConfig.getItemConfig(), 383, instance);
        pole = new ItemBuilder(CustomConfig.getItemConfig(), 384, instance);
        witherboneHandle = new ItemBuilder(CustomConfig.getItemConfig(), 385, instance);
        witherbonePole = new ItemBuilder(CustomConfig.getItemConfig(), 386, instance);
        netheriteRapier = new ItemBuilder(CustomConfig.getItemConfig(), 387, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        netheriteKatana = new ItemBuilder(CustomConfig.getItemConfig(), 388, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        netheriteGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 389, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        netheriteLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 390, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        netheriteSpear = new ItemBuilder(CustomConfig.getItemConfig(), 391, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        netheriteSaber = new ItemBuilder(CustomConfig.getItemConfig(), 392, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        netheriteBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 393, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        netheriteDagger = new ItemBuilder(CustomConfig.getItemConfig(), 394, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        netheriteGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 395, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        netheriteHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 396, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        netheriteHammer = new ItemBuilder(CustomConfig.getItemConfig(), 397, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        netheriteJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 398, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        netheriteLance = new ItemBuilder(CustomConfig.getItemConfig(), 399, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        netheriteMace = new ItemBuilder(CustomConfig.getItemConfig(), 400, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        netheritePike = new ItemBuilder(CustomConfig.getItemConfig(), 401, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        netheriteQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 402, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        netheriteThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 403, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        netheriteThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 404, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        netheriteWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 405, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        netheriteBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 406, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        netheriteLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 407, instance);
        netheriteCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 408, instance);
        diamondRapier = new ItemBuilder(CustomConfig.getItemConfig(), 409, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        diamondKatana = new ItemBuilder(CustomConfig.getItemConfig(), 410, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        diamondGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 411, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        diamondLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 412, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        diamondSpear = new ItemBuilder(CustomConfig.getItemConfig(), 413, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        diamondSaber = new ItemBuilder(CustomConfig.getItemConfig(), 414, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        diamondBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 415, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        diamondDagger = new ItemBuilder(CustomConfig.getItemConfig(), 416, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        diamondGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 417, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        diamondHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 418, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        diamondHammer = new ItemBuilder(CustomConfig.getItemConfig(), 419, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        diamondJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 420, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        diamondLance = new ItemBuilder(CustomConfig.getItemConfig(), 421, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        diamondMace = new ItemBuilder(CustomConfig.getItemConfig(), 422, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        diamondPike = new ItemBuilder(CustomConfig.getItemConfig(), 423, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        diamondQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 424, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        diamondThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 425, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        diamondThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 426, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        diamondWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 427, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        diamondBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 428, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        diamondLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 429, instance);
        diamondCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 430, instance);
        ironRapier = new ItemBuilder(CustomConfig.getItemConfig(), 431, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        ironKatana = new ItemBuilder(CustomConfig.getItemConfig(), 432, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        ironGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 433, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        ironLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 434, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        ironSpear = new ItemBuilder(CustomConfig.getItemConfig(), 435, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        ironSaber = new ItemBuilder(CustomConfig.getItemConfig(), 436, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        ironBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 437, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        ironDagger = new ItemBuilder(CustomConfig.getItemConfig(), 438, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        ironGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 439, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        ironHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 440, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        ironHammer = new ItemBuilder(CustomConfig.getItemConfig(), 441, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        ironJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 442, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        ironLance = new ItemBuilder(CustomConfig.getItemConfig(), 443, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        ironMace = new ItemBuilder(CustomConfig.getItemConfig(), 444, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        ironPike = new ItemBuilder(CustomConfig.getItemConfig(), 445, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        ironQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 446, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        ironThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 447, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        ironThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 448, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        ironWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 449, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        ironBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 450, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        ironLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 451, instance);
        ironCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 452, instance);
        goldenRapier = new ItemBuilder(CustomConfig.getItemConfig(), 453, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        goldenKatana = new ItemBuilder(CustomConfig.getItemConfig(), 454, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        goldenGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 455, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        goldenLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 456, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        goldenSpear = new ItemBuilder(CustomConfig.getItemConfig(), 457, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        goldenSaber = new ItemBuilder(CustomConfig.getItemConfig(), 458, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        goldenBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 459, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        goldenDagger = new ItemBuilder(CustomConfig.getItemConfig(), 460, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        goldenGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 461, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        goldenHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 462, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        goldenHammer = new ItemBuilder(CustomConfig.getItemConfig(), 463, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        goldenJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 464, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        goldenLance = new ItemBuilder(CustomConfig.getItemConfig(), 465, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        goldenMace = new ItemBuilder(CustomConfig.getItemConfig(), 466, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        goldenPike = new ItemBuilder(CustomConfig.getItemConfig(), 467, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        goldenQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 468, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        goldenThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 469, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        goldenThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 470, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        goldenWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 471, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        goldenBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 472, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        goldenLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 473, instance);
        goldenCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 474, instance);
        stoneRapier = new ItemBuilder(CustomConfig.getItemConfig(), 475, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        stoneKatana = new ItemBuilder(CustomConfig.getItemConfig(), 476, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        stoneGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 477, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        stoneLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 478, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        stoneSpear = new ItemBuilder(CustomConfig.getItemConfig(), 479, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        stoneSaber = new ItemBuilder(CustomConfig.getItemConfig(), 480, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        stoneBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 481, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        stoneDagger = new ItemBuilder(CustomConfig.getItemConfig(), 482, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        stoneGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 483, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        stoneHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 484, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        stoneHammer = new ItemBuilder(CustomConfig.getItemConfig(), 485, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        stoneJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 486, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        stoneLance = new ItemBuilder(CustomConfig.getItemConfig(), 487, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        stoneMace = new ItemBuilder(CustomConfig.getItemConfig(), 488, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        stonePike = new ItemBuilder(CustomConfig.getItemConfig(), 489, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        stoneQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 490, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        stoneThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 491, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        stoneThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 492, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        stoneWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 493, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        stoneBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 494, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        woodenRapier = new ItemBuilder(CustomConfig.getItemConfig(), 495, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        woodenKatana = new ItemBuilder(CustomConfig.getItemConfig(), 496, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        woodenGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 497, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        woodenLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 498, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        woodenSpear = new ItemBuilder(CustomConfig.getItemConfig(), 499, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        woodenSaber = new ItemBuilder(CustomConfig.getItemConfig(), 500, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        woodenBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 501, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        woodenDagger = new ItemBuilder(CustomConfig.getItemConfig(), 502, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        woodenGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 503, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        woodenHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 504, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        woodenHammer = new ItemBuilder(CustomConfig.getItemConfig(), 505, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        woodenJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 506, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        woodenLance = new ItemBuilder(CustomConfig.getItemConfig(), 507, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        woodenMace = new ItemBuilder(CustomConfig.getItemConfig(), 508, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        woodenPike = new ItemBuilder(CustomConfig.getItemConfig(), 509, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        woodenQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 510, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        woodenThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 511, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        woodenThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 512, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        woodenWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 513, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        woodenBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 514, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        woodenLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 515, instance);
        woodenCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 516, instance);
        woodenClub = new ItemBuilder(CustomConfig.getItemConfig(), 517, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.CLUB, instance);
        leatherLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 518, instance);
        leatherCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 519, instance);
        copperRapier = new ItemBuilder(CustomConfig.getItemConfig(), 520, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.RAPIER, instance);
        copperKatana = new ItemBuilder(CustomConfig.getItemConfig(), 521, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.KATANA, instance);
        copperGreatsword = new ItemBuilder(CustomConfig.getItemConfig(), 522, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GREATSWORD, instance);
        copperLongsword = new ItemBuilder(CustomConfig.getItemConfig(), 523, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LONGSWORD, instance);
        copperSpear = new ItemBuilder(CustomConfig.getItemConfig(), 524, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SPEAR, instance);
        copperSaber = new ItemBuilder(CustomConfig.getItemConfig(), 525, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.SABER, instance);
        copperBoomerang = new ItemBuilder(CustomConfig.getItemConfig(), 526, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BOOMERANG, instance);
        copperDagger = new ItemBuilder(CustomConfig.getItemConfig(), 527, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.DAGGER, instance);
        copperGlaive = new ItemBuilder(CustomConfig.getItemConfig(), 528, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.GLAIVE, instance);
        copperHalberd = new ItemBuilder(CustomConfig.getItemConfig(), 529, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HALBERD, instance);
        copperHammer = new ItemBuilder(CustomConfig.getItemConfig(), 530, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.HAMMER, instance);
        copperJavelin = new ItemBuilder(CustomConfig.getItemConfig(), 531, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.JAVELIN, instance);
        copperLance = new ItemBuilder(CustomConfig.getItemConfig(), 532, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.LANCE, instance);
        copperMace = new ItemBuilder(CustomConfig.getItemConfig(), 533, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.MACE, instance);
        copperPike = new ItemBuilder(CustomConfig.getItemConfig(), 534, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.PIKE, instance);
        copperQuarterstaff = new ItemBuilder(CustomConfig.getItemConfig(), 535, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.QUARTERSTAFF, instance);
        copperThrowingAxe = new ItemBuilder(CustomConfig.getItemConfig(), 536, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.TOMAHAWK, instance);
        copperThrowingKnife = new ItemBuilder(CustomConfig.getItemConfig(), 537, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.THROWING_KNIFE, instance);
        copperWarhammer = new ItemBuilder(CustomConfig.getItemConfig(), 538, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.WARHAMMER, instance);
        copperBattleaxe = new ItemBuilder(CustomConfig.getItemConfig(), 539, CustomConfig.getSpartanWeaponryConfig(), ItemBuilder.BATTLEAXE, instance);
        copperLongbow = new ItemBuilder(CustomConfig.getItemConfig(), 540, instance);
        copperCrossbow = new ItemBuilder(CustomConfig.getItemConfig(), 541, instance);
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

    public ItemStack getCobblestone() {
        return new ItemStack(Material.COBBLESTONE);
    }

    public ItemStack getPlantFiber() {
        return plantFiber;
    }

    public ItemStack getPlantString() {
        return plantString;
    }

    public ItemStack getString() {
        return new ItemStack(Material.STRING);
    }

    public ItemStack getFlintShard() {
        return flintShard;
    }

    public ItemStack getDragonBone() {
        return dragonBone;
    }

    public ItemStack getWitherbone() {
        return witherbone;
    }

    public ItemStack getDragonScaleBlue() {
        return blueDragonScales;
    }

    public ItemStack getDragonScaleBronze() {
        return bronzeDragonScales;
    }

    public ItemStack getDragonScaleGray() {
        return grayDragonScales;
    }

    public ItemStack getDragonScaleGreen() {
        return greenDragonScales;
    }

    public ItemStack getDragonScaleRed() {
        return redDragonScales;
    }

    public ItemStack getDragonScaleSapphire() {
        return sapphireDragonScales;
    }

    public ItemStack getDragonScaleSilver() {
        return silverDragonScales;
    }

    public ItemStack getDragonScaleWhite() {
        return whiteDragonScales;
    }

    public ItemStack getDragonScaleAmethyst() {
        return amethystDragonScales;
    }

    public ItemStack getDragonScaleBlack() {
        return blackDragonScales;
    }

    public ItemStack getDragonScaleCopper() {
        return copperDragonScales;
    }

    public ItemStack getDragonScaleElectric() {
        return electricDragonScales;
    }

    public ItemStack getSeaSerpentScaleBlue() {
        return blueSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleBronze() {
        return bronzeSeaSerpentScales;
    }

    public ItemStack getSeaSerpentScaleDeepBlue() {
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

    public ItemStack getDragonScaleHelmetBlue() {
        return blueDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateBlue() {
        return blueDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsBlue() {
        return blueDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsBlue() {
        return blueDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetBronze() {
        return bronzeDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateBronze() {
        return bronzeDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsBronze() {
        return bronzeDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsBronze() {
        return bronzeDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetGray() {
        return grayDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateGray() {
        return grayDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsGray() {
        return grayDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsGray() {
        return grayDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetGreen() {
        return greenDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateGreen() {
        return greenDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsGreen() {
        return greenDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsGreen() {
        return greenDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetRed() {
        return redDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateRed() {
        return redDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsRed() {
        return redDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsRed() {
        return redDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetSapphire() {
        return sapphireDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateSapphire() {
        return sapphireDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsSapphire() {
        return sapphireDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsSapphire() {
        return sapphireDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetSilver() {
        return silverDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateSilver() {
        return silverDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsSilver() {
        return silverDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsSilver() {
        return silverDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetWhite() {
        return whiteDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateWhite() {
        return whiteDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsWhite() {
        return whiteDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsWhite() {
        return whiteDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetAmethyst() {
        return amethystDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateAmethyst() {
        return amethystDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsAmethyst() {
        return amethystDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsAmethyst() {
        return amethystDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetBlack() {
        return blackDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateBlack() {
        return blackDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsBlack() {
        return blackDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsBlack() {
        return blackDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetCopper() {
        return copperDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateCopper() {
        return copperDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsCopper() {
        return copperDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsCopper() {
        return copperDragonScaleBoots;
    }

    public ItemStack getDragonScaleHelmetElectric() {
        return electricDragonScaleHelmet;
    }

    public ItemStack getDragonScaleChestplateElectric() {
        return electricDragonScaleChestplate;
    }

    public ItemStack getDragonScaleLeggingsElectric() {
        return electricDragonScaleLeggings;
    }

    public ItemStack getDragonScaleBootsElectric() {
        return electricDragonScaleBoots;
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

    public ItemStack getTideGuardianHelmetDeepBlue() {
        return deepBlueTideGuardianHelmet;
    }

    public ItemStack getTideGuardianChestplateDeepBlue() {
        return deepBlueTideGuardianChestplate;
    }

    public ItemStack getTideGuardianLeggingsDeepBlue() {
        return deepBlueTideGuardianLeggings;
    }

    public ItemStack getTideGuardianBootsDeepBlue() {
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

    public ItemStack getDragonBonePickaxe() {
        return dragonBonePickaxe;
    }

    public ItemStack getDragonBoneAxe() {
        return dragonBoneAxe;
    }

    public ItemStack getDragonBoneShovel() {
        return dragonBoneShovel;
    }

    public ItemStack getDragonBoneHoe() {
        return dragonBoneHoe;
    }

    public ItemStack getDragonBoneSword() {
        return dragonBoneSword;
    }

    public ItemStack getDragonBoneBow() {
        return dragonBoneBow;
    }

    public ItemStack getFlamedDragonBoneSword() {
        return flamedDragonBoneSword;
    }

    public ItemStack getIcedDragonBoneSword() {
        return icedDragonBoneSword;
    }

    public ItemStack getLightningDragonBoneSword() {
        return lightningDragonBoneSword;
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

    public ItemStack getEnderDragonScale() {
        return enderDragonScale;
    }

    public ItemStack getCrackedBlackDragonScale() {
        return crackedBlackDragonScale;
    }

    public ItemStack getBlackDragonScale() {
        return blackDragonScale;
    }

    public ItemStack getMixedColorDragonScale() {
        return mixedColorDragonScale;
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

    public ItemStack getDragonBoneRapier() {
        return dragonBoneRapier;
    }

    public ItemStack getDragonBoneKatana() {
        return dragonBoneKatana;
    }

    public ItemStack getDragonBoneGreatsword() {
        return dragonBoneGreatsword;
    }

    public ItemStack getDragonBoneLongsword() {
        return dragonBoneLongsword;
    }

    public ItemStack getDragonBoneSpear() {
        return dragonBoneSpear;
    }

    public ItemStack getDragonBoneSaber() {
        return dragonBoneSaber;
    }

    public ItemStack getDragonBoneBoomerang() {
        return dragonBoneBoomerang;
    }

    public ItemStack getDragonBoneDagger() {
        return dragonBoneDagger;
    }

    public ItemStack getDragonBoneGlaive() {
        return dragonBoneGlaive;
    }

    public ItemStack getDragonBoneHalberd() {
        return dragonBoneHalberd;
    }

    public ItemStack getDragonBoneHammer() {
        return dragonBoneHammer;
    }

    public ItemStack getDragonBoneJavelin() {
        return dragonBoneJavelin;
    }

    public ItemStack getDragonBoneLance() {
        return dragonBoneLance;
    }

    public ItemStack getDragonBoneMace() {
        return dragonBoneMace;
    }

    public ItemStack getDragonBonePike() {
        return dragonBonePike;
    }

    public ItemStack getDragonBoneQuarterstaff() {
        return dragonBoneQuarterstaff;
    }

    public ItemStack getDragonBoneThrowingAxe() {
        return dragonBoneThrowingAxe;
    }

    public ItemStack getDragonBoneThrowingKnife() {
        return dragonBoneThrowingKnife;
    }

    public ItemStack getDragonBoneWarhammer() {
        return dragonBoneWarhammer;
    }

    public ItemStack getDragonBoneBattleaxe() {
        return dragonBoneBattleaxe;
    }

    public ItemStack getDragonBoneLongbow() {
        return dragonBoneLongbow;
    }

    public ItemStack getDragonBoneCrossbow() {
        return dragonBoneCrossbow;
    }

    public ItemStack getFlamedDragonBoneRapier() {
        return flamedDragonBoneRapier;
    }

    public ItemStack getFlamedDragonBoneKatana() {
        return flamedDragonBoneKatana;
    }

    public ItemStack getFlamedDragonBoneGreatsword() {
        return flamedDragonBoneGreatsword;
    }

    public ItemStack getFlamedDragonBoneLongsword() {
        return flamedDragonBoneLongsword;
    }

    public ItemStack getFlamedDragonBoneSpear() {
        return flamedDragonBoneSpear;
    }

    public ItemStack getFlamedDragonBoneSaber() {
        return flamedDragonBoneSaber;
    }

    public ItemStack getFlamedDragonBoneBoomerang() {
        return flamedDragonBoneBoomerang;
    }

    public ItemStack getFlamedDragonBoneDagger() {
        return flamedDragonBoneDagger;
    }

    public ItemStack getFlamedDragonBoneGlaive() {
        return flamedDragonBoneGlaive;
    }

    public ItemStack getFlamedDragonBoneHalberd() {
        return flamedDragonBoneHalberd;
    }

    public ItemStack getFlamedDragonBoneHammer() {
        return flamedDragonBoneHammer;
    }

    public ItemStack getFlamedDragonBoneJavelin() {
        return flamedDragonBoneJavelin;
    }

    public ItemStack getFlamedDragonBoneLance() {
        return flamedDragonBoneLance;
    }

    public ItemStack getFlamedDragonBoneMace() {
        return flamedDragonBoneMace;
    }

    public ItemStack getFlamedDragonBonePike() {
        return flamedDragonBonePike;
    }

    public ItemStack getFlamedDragonBoneQuarterstaff() {
        return flamedDragonBoneQuarterstaff;
    }

    public ItemStack getFlamedDragonBoneThrowingAxe() {
        return flamedDragonBoneThrowingAxe;
    }

    public ItemStack getFlamedDragonBoneThrowingKnife() {
        return flamedDragonBoneThrowingKnife;
    }

    public ItemStack getFlamedDragonBoneWarhammer() {
        return flamedDragonBoneWarhammer;
    }

    public ItemStack getFlamedDragonBoneBattleaxe() {
        return flamedDragonBoneBattleaxe;
    }

    public ItemStack getFlamedDragonBoneLongbow() {
        return flamedDragonBoneLongbow;
    }

    public ItemStack getFlamedDragonBoneCrossbow() {
        return flamedDragonBoneCrossbow;
    }

    public ItemStack getIcedDragonBoneRapier() {
        return icedDragonBoneRapier;
    }

    public ItemStack getIcedDragonBoneKatana() {
        return icedDragonBoneKatana;
    }

    public ItemStack getIcedDragonBoneGreatsword() {
        return icedDragonBoneGreatsword;
    }

    public ItemStack getIcedDragonBoneLongsword() {
        return icedDragonBoneLongsword;
    }

    public ItemStack getIcedDragonBoneSpear() {
        return icedDragonBoneSpear;
    }

    public ItemStack getIcedDragonBoneSaber() {
        return icedDragonBoneSaber;
    }

    public ItemStack getIcedDragonBoneBoomerang() {
        return icedDragonBoneBoomerang;
    }

    public ItemStack getIcedDragonBoneDagger() {
        return icedDragonBoneDagger;
    }

    public ItemStack getIcedDragonBoneGlaive() {
        return icedDragonBoneGlaive;
    }

    public ItemStack getIcedDragonBoneHalberd() {
        return icedDragonBoneHalberd;
    }

    public ItemStack getIcedDragonBoneHammer() {
        return icedDragonBoneHammer;
    }

    public ItemStack getIcedDragonBoneJavelin() {
        return icedDragonBoneJavelin;
    }

    public ItemStack getIcedDragonBoneLance() {
        return icedDragonBoneLance;
    }

    public ItemStack getIcedDragonBoneMace() {
        return icedDragonBoneMace;
    }

    public ItemStack getIcedDragonBonePike() {
        return icedDragonBonePike;
    }

    public ItemStack getIcedDragonBoneQuarterstaff() {
        return icedDragonBoneQuarterstaff;
    }

    public ItemStack getIcedDragonBoneThrowingAxe() {
        return icedDragonBoneThrowingAxe;
    }

    public ItemStack getIcedDragonBoneThrowingKnife() {
        return icedDragonBoneThrowingKnife;
    }

    public ItemStack getIcedDragonBoneWarhammer() {
        return icedDragonBoneWarhammer;
    }

    public ItemStack getIcedDragonBoneBattleaxe() {
        return icedDragonBoneBattleaxe;
    }

    public ItemStack getIcedDragonBoneLongbow() {
        return icedDragonBoneLongbow;
    }

    public ItemStack getIcedDragonBoneCrossbow() {
        return icedDragonBoneCrossbow;
    }

    public ItemStack getLightningDragonBoneRapier() {
        return lightningDragonBoneRapier;
    }

    public ItemStack getLightningDragonBoneKatana() {
        return lightningDragonBoneKatana;
    }

    public ItemStack getLightningDragonBoneGreatsword() {
        return lightningDragonBoneGreatsword;
    }

    public ItemStack getLightningDragonBoneLongsword() {
        return lightningDragonBoneLongsword;
    }

    public ItemStack getLightningDragonBoneSpear() {
        return lightningDragonBoneSpear;
    }

    public ItemStack getLightningDragonBoneSaber() {
        return lightningDragonBoneSaber;
    }

    public ItemStack getLightningDragonBoneBoomerang() {
        return lightningDragonBoneBoomerang;
    }

    public ItemStack getLightningDragonBoneDagger() {
        return lightningDragonBoneDagger;
    }

    public ItemStack getLightningDragonBoneGlaive() {
        return lightningDragonBoneGlaive;
    }

    public ItemStack getLightningDragonBoneHalberd() {
        return lightningDragonBoneHalberd;
    }

    public ItemStack getLightningDragonBoneHammer() {
        return lightningDragonBoneHammer;
    }

    public ItemStack getLightningDragonBoneJavelin() {
        return lightningDragonBoneJavelin;
    }

    public ItemStack getLightningDragonBoneLance() {
        return lightningDragonBoneLance;
    }

    public ItemStack getLightningDragonBoneMace() {
        return lightningDragonBoneMace;
    }

    public ItemStack getLightningDragonBonePike() {
        return lightningDragonBonePike;
    }

    public ItemStack getLightningDragonBoneQuarterstaff() {
        return lightningDragonBoneQuarterstaff;
    }

    public ItemStack getLightningDragonBoneThrowingAxe() {
        return lightningDragonBoneThrowingAxe;
    }

    public ItemStack getLightningDragonBoneThrowingKnife() {
        return lightningDragonBoneThrowingKnife;
    }

    public ItemStack getLightningDragonBoneWarhammer() {
        return lightningDragonBoneWarhammer;
    }

    public ItemStack getLightningDragonBoneBattleaxe() {
        return lightningDragonBoneBattleaxe;
    }

    public ItemStack getLightningDragonBoneLongbow() {
        return lightningDragonBoneLongbow;
    }

    public ItemStack getLightningDragonBoneCrossbow() {
        return lightningDragonBoneCrossbow;
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
}