package me.val_mobile.rlcraft;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
/**
 * CustomItems is a utility class creating and storing every custom item
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class CustomItems {

    /**
     * Creating all custom items using the Item class,
     * which reads information from the "items.yml" file.
     *
     * If part of the item's attributes are stored in another config file,
     * a different constructor is used. This second constructor takes in the second config
     * and gear type in addition to the "items.yml" config and index.
     * @see Item
     */
    private static ItemStack flintAxe = new Item(CustomConfig.getItemConfig(), 0, CustomConfig.getNoTreePunchingConfig(), Item.AXE).getNmsItem();
    private static ItemStack flintKnife = new Item(CustomConfig.getItemConfig(), 1, CustomConfig.getNoTreePunchingConfig(), Item.KNIFE).getNmsItem();
    private static ItemStack flintPickaxe = new Item(CustomConfig.getItemConfig(), 2, CustomConfig.getNoTreePunchingConfig(), Item.PICKAXE).getNmsItem();
    private static ItemStack flintShovel = new Item(CustomConfig.getItemConfig(), 3, CustomConfig.getNoTreePunchingConfig(), Item.SHOVEL).getNmsItem();
    private static ItemStack flintHoe = new Item(CustomConfig.getItemConfig(), 4, CustomConfig.getNoTreePunchingConfig(), Item.HOE).getNmsItem();
    private static ItemStack plantFiber = new Item(CustomConfig.getItemConfig(), 5).getNmsItem();
    private static ItemStack plantString = new Item(CustomConfig.getItemConfig(), 6).getNmsItem();
    private static ItemStack flintShard = new Item(CustomConfig.getItemConfig(), 7).getNmsItem();
    private static ItemStack dragonBone = new Item(CustomConfig.getItemConfig(), 8).getNmsItem();
    private static ItemStack witherbone = new Item(CustomConfig.getItemConfig(), 9).getNmsItem();
    private static ItemStack blueDragonScales = new Item(CustomConfig.getItemConfig(), 10).getNmsItem();
    private static ItemStack bronzeDragonScales = new Item(CustomConfig.getItemConfig(), 11).getNmsItem();
    private static ItemStack grayDragonScales = new Item(CustomConfig.getItemConfig(), 12).getNmsItem();
    private static ItemStack greenDragonScales = new Item(CustomConfig.getItemConfig(), 13).getNmsItem();
    private static ItemStack redDragonScales = new Item(CustomConfig.getItemConfig(), 14).getNmsItem();
    private static ItemStack sapphireDragonScales = new Item(CustomConfig.getItemConfig(), 15).getNmsItem();
    private static ItemStack silverDragonScales = new Item(CustomConfig.getItemConfig(), 16).getNmsItem();
    private static ItemStack whiteDragonScales = new Item(CustomConfig.getItemConfig(), 17).getNmsItem();
    private static ItemStack amethystDragonScales = new Item(CustomConfig.getItemConfig(), 18).getNmsItem();
    private static ItemStack blackDragonScales = new Item(CustomConfig.getItemConfig(), 19).getNmsItem();
    private static ItemStack copperDragonScales = new Item(CustomConfig.getItemConfig(), 20).getNmsItem();
    private static ItemStack electricDragonScales = new Item(CustomConfig.getItemConfig(), 21).getNmsItem();
    private static ItemStack blueSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 22).getNmsItem();
    private static ItemStack bronzeSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 23).getNmsItem();
    private static ItemStack deepBlueSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 24).getNmsItem();
    private static ItemStack greenSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 25).getNmsItem();
    private static ItemStack purpleSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 26).getNmsItem();
    private static ItemStack redSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 27).getNmsItem();
    private static ItemStack tealSeaSerpentScales = new Item(CustomConfig.getItemConfig(), 28).getNmsItem();
    private static ItemStack shinyScales = new Item(CustomConfig.getItemConfig(), 29).getNmsItem();
    private static ItemStack fireDragonBlood = new Item(CustomConfig.getItemConfig(), 30).getNmsItem();
    private static ItemStack iceDragonBlood = new Item(CustomConfig.getItemConfig(), 31).getNmsItem();
    private static ItemStack lightningDragonBlood = new Item(CustomConfig.getItemConfig(), 32).getNmsItem();
    private static ItemStack fireDragonHeart = new Item(CustomConfig.getItemConfig(), 33).getNmsItem();
    private static ItemStack iceDragonHeart = new Item(CustomConfig.getItemConfig(), 34).getNmsItem();
    private static ItemStack lightningDragonHeart = new Item(CustomConfig.getItemConfig(), 35).getNmsItem();
    private static ItemStack fireDragonSkull = new Item(CustomConfig.getItemConfig(), 36).getNmsItem();
    private static ItemStack iceDragonSkull = new Item(CustomConfig.getItemConfig(), 37).getNmsItem();
    private static ItemStack lightningDragonSkull = new Item(CustomConfig.getItemConfig(), 38).getNmsItem();
    private static ItemStack fireDragonFlesh = new Item(CustomConfig.getItemConfig(), 39).getNmsItem();
    private static ItemStack iceDragonFlesh = new Item(CustomConfig.getItemConfig(), 40).getNmsItem();
    private static ItemStack lightningDragonFlesh = new Item(CustomConfig.getItemConfig(), 41).getNmsItem();
    private static ItemStack fireDragonsteelIngot = new Item(CustomConfig.getItemConfig(), 42).getNmsItem();
    private static ItemStack iceDragonsteelIngot = new Item(CustomConfig.getItemConfig(), 43).getNmsItem();
    private static ItemStack lightningDragonsteelIngot = new Item(CustomConfig.getItemConfig(), 44).getNmsItem();
    private static ItemStack blueDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 45, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack blueDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 46, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack blueDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 47, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack blueDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 48, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack bronzeDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 49, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack bronzeDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 50, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack bronzeDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 51, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack bronzeDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 52, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack grayDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 53, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack grayDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 54, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack grayDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 55, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack grayDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 56, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack greenDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 57, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack greenDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 58, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack greenDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 59, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack greenDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 60, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack redDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 61, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack redDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 62, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack redDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 63, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack redDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 64, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack sapphireDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 65, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack sapphireDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 66, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack sapphireDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 67, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack sapphireDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 68, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack silverDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 69, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack silverDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 70, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack silverDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 71, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack silverDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 72, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack whiteDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 73, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack whiteDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 74, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack whiteDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 75, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack whiteDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 76, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack amethystDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 77, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack amethystDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 78, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack amethystDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 79, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack amethystDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 80, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack blackDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 81, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack blackDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 82, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack blackDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 83, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack blackDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 84, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack copperDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 85, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack copperDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 86, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack copperDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 87, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack copperDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 88, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack electricDragonScaleHelmet = new Item(CustomConfig.getItemConfig(), 89, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack electricDragonScaleChestplate = new Item(CustomConfig.getItemConfig(), 90, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack electricDragonScaleLeggings = new Item(CustomConfig.getItemConfig(), 91, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack electricDragonScaleBoots = new Item(CustomConfig.getItemConfig(), 92, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack blueTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 93, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack blueTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 94, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack blueTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 95, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack blueTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 96, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack bronzeTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 97, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack bronzeTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 98, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack bronzeTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 99, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack bronzeTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 100, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack deepBlueTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 101, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack deepBlueTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 102, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack deepBlueTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 103, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack deepBlueTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 104, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack greenTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 105, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack greenTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 106, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack greenTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 107, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack greenTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 108, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack purpleTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 109, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack purpleTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 110, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack purpleTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 111, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack purpleTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 112, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack redTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 113, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack redTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 114, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack redTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 115, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack redTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 116, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack tealTideGuardianHelmet = new Item(CustomConfig.getItemConfig(), 117, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack tealTideGuardianChestplate = new Item(CustomConfig.getItemConfig(), 118, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack tealTideGuardianLeggings = new Item(CustomConfig.getItemConfig(), 119, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack tealTideGuardianBoots = new Item(CustomConfig.getItemConfig(), 120, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack dragonBonePickaxe = new Item(CustomConfig.getItemConfig(), 121, CustomConfig.getIceFireGearConfig(), Item.PICKAXE).getNmsItem();
    private static ItemStack dragonBoneAxe = new Item(CustomConfig.getItemConfig(), 122, CustomConfig.getIceFireGearConfig(), Item.AXE).getNmsItem();
    private static ItemStack dragonBoneShovel = new Item(CustomConfig.getItemConfig(), 123, CustomConfig.getIceFireGearConfig(), Item.SHOVEL).getNmsItem();
    private static ItemStack dragonBoneHoe = new Item(CustomConfig.getItemConfig(), 124, CustomConfig.getIceFireGearConfig(), Item.HOE).getNmsItem();
    private static ItemStack dragonBoneSword = new Item(CustomConfig.getItemConfig(), 125, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack dragonBoneBow = new Item(CustomConfig.getItemConfig(), 126).getNmsItem();
    private static ItemStack flamedDragonBoneSword = new Item(CustomConfig.getItemConfig(), 127, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack icedDragonBoneSword = new Item(CustomConfig.getItemConfig(), 128, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack lightningDragonBoneSword = new Item(CustomConfig.getItemConfig(), 129, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack dragonsEye = new Item(CustomConfig.getItemConfig(), 130).getNmsItem();
    private static ItemStack poisonStone = new Item(CustomConfig.getItemConfig(), 131).getNmsItem();
    private static ItemStack potionRingResistance = new Item(CustomConfig.getItemConfig(), 132).getNmsItem();
    private static ItemStack potionRingRegeneration = new Item(CustomConfig.getItemConfig(), 133).getNmsItem();
    private static ItemStack potionRingHaste = new Item(CustomConfig.getItemConfig(), 134).getNmsItem();
    private static ItemStack potionRingStrength = new Item(CustomConfig.getItemConfig(), 135).getNmsItem();
    private static ItemStack potionRingSpeed = new Item(CustomConfig.getItemConfig(), 136).getNmsItem();
    private static ItemStack potionRingJumpBoost = new Item(CustomConfig.getItemConfig(), 137).getNmsItem();
    private static ItemStack enderQueensCrown = new Item(CustomConfig.getItemConfig(), 138).getNmsItem();
    private static ItemStack sunglasses = new Item(CustomConfig.getItemConfig(), 139).getNmsItem();
    private static ItemStack balloon = new Item(CustomConfig.getItemConfig(), 140).getNmsItem();
    private static ItemStack cobaltShield = new Item(CustomConfig.getItemConfig(), 141).getNmsItem();
    private static ItemStack obsidianSkull = new Item(CustomConfig.getItemConfig(), 142).getNmsItem();
    private static ItemStack obsidianShield = new Item(CustomConfig.getItemConfig(), 143).getNmsItem();
    private static ItemStack forbiddenFruit = new Item(CustomConfig.getItemConfig(), 144).getNmsItem();
    private static ItemStack vitamins = new Item(CustomConfig.getItemConfig(), 145).getNmsItem();
    private static ItemStack ringOverclocking = new Item(CustomConfig.getItemConfig(), 146).getNmsItem();
    private static ItemStack shulkerHeart = new Item(CustomConfig.getItemConfig(), 147).getNmsItem();
    private static ItemStack ringFreeAction = new Item(CustomConfig.getItemConfig(), 148).getNmsItem();
    private static ItemStack bezoar = new Item(CustomConfig.getItemConfig(), 149).getNmsItem();
    private static ItemStack enderDragonScale = new Item(CustomConfig.getItemConfig(), 150).getNmsItem();
    private static ItemStack crackedBlackDragonScale = new Item(CustomConfig.getItemConfig(), 151).getNmsItem();
    private static ItemStack blackDragonScale = new Item(CustomConfig.getItemConfig(), 152).getNmsItem();
    private static ItemStack mixedColorDragonScale = new Item(CustomConfig.getItemConfig(), 153).getNmsItem();
    private static ItemStack ankhCharm = new Item(CustomConfig.getItemConfig(), 154).getNmsItem();
    private static ItemStack ankhShield = new Item(CustomConfig.getItemConfig(), 155).getNmsItem();
    private static ItemStack ironRing = new Item(CustomConfig.getItemConfig(), 156).getNmsItem();
    private static ItemStack magicMirror = new Item(CustomConfig.getItemConfig(), 157).getNmsItem();
    private static ItemStack recallPotion = new Item(CustomConfig.getItemConfig(), 158).getNmsItem();
    private static ItemStack wormholeMirror = new Item(CustomConfig.getItemConfig(), 159).getNmsItem();
    private static ItemStack wormholePotion = new Item(CustomConfig.getItemConfig(), 160).getNmsItem();
    private static ItemStack luckyHorseshoe = new Item(CustomConfig.getItemConfig(), 161).getNmsItem();
    private static ItemStack battleBurrito = new Item(CustomConfig.getItemConfig(), 162).getNmsItem();
    private static ItemStack scarliteRing = new Item(CustomConfig.getItemConfig(), 163).getNmsItem();
    private static ItemStack spectralSilt = new Item(CustomConfig.getItemConfig(), 164).getNmsItem();
    private static ItemStack disintegrationTablet = new Item(CustomConfig.getItemConfig(), 165).getNmsItem();
    private static ItemStack brokenHeart = new Item(CustomConfig.getItemConfig(), 166).getNmsItem();
    private static ItemStack crossNecklace = new Item(CustomConfig.getItemConfig(), 167).getNmsItem();
    private static ItemStack wrathPendant = new Item(CustomConfig.getItemConfig(), 168).getNmsItem();
    private static ItemStack pridePendant = new Item(CustomConfig.getItemConfig(), 169).getNmsItem();
    private static ItemStack goldenCrown = new Item(CustomConfig.getItemConfig(), 170).getNmsItem();
    private static ItemStack gluttonyPendant = new Item(CustomConfig.getItemConfig(), 171).getNmsItem();
    private static ItemStack sinPendant = new Item(CustomConfig.getItemConfig(), 172).getNmsItem();
    private static ItemStack flareGun = new Item(CustomConfig.getItemConfig(), 173).getNmsItem();
    private static ItemStack flare = new Item(CustomConfig.getItemConfig(), 174).getNmsItem();
    private static ItemStack phytoprotostasiaAmulet = new Item(CustomConfig.getItemConfig(), 175).getNmsItem();
    private static ItemStack potionRing = new Item(CustomConfig.getItemConfig(), 176).getNmsItem();
    private static ItemStack emeraldRing = new Item(CustomConfig.getItemConfig(), 177).getNmsItem();
    private static ItemStack emeraldAmulet = new Item(CustomConfig.getItemConfig(), 178).getNmsItem();
    private static ItemStack glowingIngot = new Item(CustomConfig.getItemConfig(), 179).getNmsItem();
    private static ItemStack glowingPowder = new Item(CustomConfig.getItemConfig(), 180).getNmsItem();
    private static ItemStack glowingGem = new Item(CustomConfig.getItemConfig(), 181).getNmsItem();
    private static ItemStack dwarfStout = new Item(CustomConfig.getItemConfig(), 182).getNmsItem();
    private static ItemStack fairyDew = new Item(CustomConfig.getItemConfig(), 183).getNmsItem();
    private static ItemStack stoneNegativeGravity = new Item(CustomConfig.getItemConfig(), 184).getNmsItem();
    private static ItemStack stoneInertiaNull = new Item(CustomConfig.getItemConfig(), 185).getNmsItem();
    private static ItemStack stoneGreaterInertia = new Item(CustomConfig.getItemConfig(), 186).getNmsItem();
    private static ItemStack ringEnchantedEyes = new Item(CustomConfig.getItemConfig(), 187).getNmsItem();
    private static ItemStack stoneSea = new Item(CustomConfig.getItemConfig(), 188).getNmsItem();
    private static ItemStack polarizedStone = new Item(CustomConfig.getItemConfig(), 189).getNmsItem();
    private static ItemStack ringFairies = new Item(CustomConfig.getItemConfig(), 190).getNmsItem();
    private static ItemStack ringDwarves = new Item(CustomConfig.getItemConfig(), 191).getNmsItem();
    private static ItemStack witherRing = new Item(CustomConfig.getItemConfig(), 192).getNmsItem();
    private static ItemStack shieldHonor = new Item(CustomConfig.getItemConfig(), 193).getNmsItem();
    private static ItemStack minersRing = new Item(CustomConfig.getItemConfig(), 194).getNmsItem();
    private static ItemStack warpedScroll = new Item(CustomConfig.getItemConfig(), 195).getNmsItem();
    private static ItemStack fireResistancePotion = new Item(CustomConfig.getItemConfig(), 196).getNmsItem();
    private static ItemStack fireDragonsteelSword = new Item(CustomConfig.getItemConfig(), 197, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack fireDragonsteelPickaxe = new Item(CustomConfig.getItemConfig(), 198, CustomConfig.getIceFireGearConfig(), Item.PICKAXE).getNmsItem();
    private static ItemStack fireDragonsteelAxe = new Item(CustomConfig.getItemConfig(), 199, CustomConfig.getIceFireGearConfig(), Item.AXE).getNmsItem();
    private static ItemStack fireDragonsteelShovel = new Item(CustomConfig.getItemConfig(), 200, CustomConfig.getIceFireGearConfig(), Item.SHOVEL).getNmsItem();
    private static ItemStack fireDragonsteelHoe = new Item(CustomConfig.getItemConfig(), 201, CustomConfig.getIceFireGearConfig(), Item.HOE).getNmsItem();
    private static ItemStack iceDragonsteelSword = new Item(CustomConfig.getItemConfig(), 202, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack iceDragonsteelPickaxe = new Item(CustomConfig.getItemConfig(), 203, CustomConfig.getIceFireGearConfig(), Item.PICKAXE).getNmsItem();
    private static ItemStack iceDragonsteelAxe = new Item(CustomConfig.getItemConfig(), 204, CustomConfig.getIceFireGearConfig(), Item.AXE).getNmsItem();
    private static ItemStack iceDragonsteelShovel = new Item(CustomConfig.getItemConfig(), 205, CustomConfig.getIceFireGearConfig(), Item.SHOVEL).getNmsItem();
    private static ItemStack iceDragonsteelHoe = new Item(CustomConfig.getItemConfig(), 206, CustomConfig.getIceFireGearConfig(), Item.HOE).getNmsItem();
    private static ItemStack lightningDragonsteelSword = new Item(CustomConfig.getItemConfig(), 207, CustomConfig.getIceFireGearConfig(), Item.SWORD).getNmsItem();
    private static ItemStack lightningDragonsteelPickaxe = new Item(CustomConfig.getItemConfig(), 208, CustomConfig.getIceFireGearConfig(), Item.PICKAXE).getNmsItem();
    private static ItemStack lightningDragonsteelAxe = new Item(CustomConfig.getItemConfig(), 209, CustomConfig.getIceFireGearConfig(), Item.AXE).getNmsItem();
    private static ItemStack lightningDragonsteelShovel = new Item(CustomConfig.getItemConfig(), 210, CustomConfig.getIceFireGearConfig(), Item.SHOVEL).getNmsItem();
    private static ItemStack lightningDragonsteelHoe = new Item(CustomConfig.getItemConfig(), 211, CustomConfig.getIceFireGearConfig(), Item.HOE).getNmsItem();
    private static ItemStack fireDragonsteelHelmet = new Item(CustomConfig.getItemConfig(), 212, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack fireDragonsteelChestplate = new Item(CustomConfig.getItemConfig(), 213, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack fireDragonsteelLeggings = new Item(CustomConfig.getItemConfig(), 214, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack fireDragonsteelBoots = new Item(CustomConfig.getItemConfig(), 215, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack iceDragonsteelHelmet = new Item(CustomConfig.getItemConfig(), 216, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack iceDragonsteelChestplate = new Item(CustomConfig.getItemConfig(), 217, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack iceDragonsteelLeggings = new Item(CustomConfig.getItemConfig(), 218, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack iceDragonsteelBoots = new Item(CustomConfig.getItemConfig(), 219, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack lightningDragonsteelHelmet = new Item(CustomConfig.getItemConfig(), 220, CustomConfig.getIceFireGearConfig(), Item.HELMET).getNmsItem();
    private static ItemStack lightningDragonsteelChestplate = new Item(CustomConfig.getItemConfig(), 221, CustomConfig.getIceFireGearConfig(), Item.CHESTPLATE).getNmsItem();
    private static ItemStack lightningDragonsteelLeggings = new Item(CustomConfig.getItemConfig(), 222, CustomConfig.getIceFireGearConfig(), Item.LEGGINGS).getNmsItem();
    private static ItemStack lightningDragonsteelBoots = new Item(CustomConfig.getItemConfig(), 223, CustomConfig.getIceFireGearConfig(), Item.BOOTS).getNmsItem();
    private static ItemStack dragonBoneRapier = new Item(CustomConfig.getItemConfig(), 224, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack dragonBoneKatana = new Item(CustomConfig.getItemConfig(), 225, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack dragonBoneGreatsword = new Item(CustomConfig.getItemConfig(), 226, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack dragonBoneLongsword = new Item(CustomConfig.getItemConfig(), 227, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack dragonBoneSpear = new Item(CustomConfig.getItemConfig(), 228, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack dragonBoneSaber = new Item(CustomConfig.getItemConfig(), 229, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack dragonBoneBoomerang = new Item(CustomConfig.getItemConfig(), 230, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack dragonBoneDagger = new Item(CustomConfig.getItemConfig(), 231, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack dragonBoneGlaive = new Item(CustomConfig.getItemConfig(), 232, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack dragonBoneHalberd = new Item(CustomConfig.getItemConfig(), 233, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack dragonBoneHammer = new Item(CustomConfig.getItemConfig(), 234, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack dragonBoneJavelin = new Item(CustomConfig.getItemConfig(), 235, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack dragonBoneLance = new Item(CustomConfig.getItemConfig(), 236, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack dragonBoneMace = new Item(CustomConfig.getItemConfig(), 237, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack dragonBonePike = new Item(CustomConfig.getItemConfig(), 238, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack dragonBoneQuarterstaff = new Item(CustomConfig.getItemConfig(), 239, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack dragonBoneThrowingAxe = new Item(CustomConfig.getItemConfig(), 240, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack dragonBoneThrowingKnife = new Item(CustomConfig.getItemConfig(), 241, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack dragonBoneWarhammer = new Item(CustomConfig.getItemConfig(), 242, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack dragonBoneBattleaxe = new Item(CustomConfig.getItemConfig(), 243, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack dragonBoneLongbow = new Item(CustomConfig.getItemConfig(), 244).getNmsItem();
    private static ItemStack dragonBoneCrossbow = new Item(CustomConfig.getItemConfig(), 245).getNmsItem();
    private static ItemStack flamedDragonBoneRapier = new Item(CustomConfig.getItemConfig(), 246, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack flamedDragonBoneKatana = new Item(CustomConfig.getItemConfig(), 247, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack flamedDragonBoneGreatsword = new Item(CustomConfig.getItemConfig(), 248, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack flamedDragonBoneLongsword = new Item(CustomConfig.getItemConfig(), 249, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack flamedDragonBoneSpear = new Item(CustomConfig.getItemConfig(), 250, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack flamedDragonBoneSaber = new Item(CustomConfig.getItemConfig(), 251, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack flamedDragonBoneBoomerang = new Item(CustomConfig.getItemConfig(), 252, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack flamedDragonBoneDagger = new Item(CustomConfig.getItemConfig(), 253, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack flamedDragonBoneGlaive = new Item(CustomConfig.getItemConfig(), 254, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack flamedDragonBoneHalberd = new Item(CustomConfig.getItemConfig(), 255, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack flamedDragonBoneHammer = new Item(CustomConfig.getItemConfig(), 256, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack flamedDragonBoneJavelin = new Item(CustomConfig.getItemConfig(), 257, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack flamedDragonBoneLance = new Item(CustomConfig.getItemConfig(), 258, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack flamedDragonBoneMace = new Item(CustomConfig.getItemConfig(), 259, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack flamedDragonBonePike = new Item(CustomConfig.getItemConfig(), 260, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack flamedDragonBoneQuarterstaff = new Item(CustomConfig.getItemConfig(), 261, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack flamedDragonBoneThrowingAxe = new Item(CustomConfig.getItemConfig(), 262, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack flamedDragonBoneThrowingKnife = new Item(CustomConfig.getItemConfig(), 263, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack flamedDragonBoneWarhammer = new Item(CustomConfig.getItemConfig(), 264, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack flamedDragonBoneBattleaxe = new Item(CustomConfig.getItemConfig(), 265, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack flamedDragonBoneLongbow = new Item(CustomConfig.getItemConfig(), 266).getNmsItem();
    private static ItemStack flamedDragonBoneCrossbow = new Item(CustomConfig.getItemConfig(), 267).getNmsItem();
    private static ItemStack icedDragonBoneRapier = new Item(CustomConfig.getItemConfig(), 268, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack icedDragonBoneKatana = new Item(CustomConfig.getItemConfig(), 269, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack icedDragonBoneGreatsword = new Item(CustomConfig.getItemConfig(), 270, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack icedDragonBoneLongsword = new Item(CustomConfig.getItemConfig(), 271, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack icedDragonBoneSpear = new Item(CustomConfig.getItemConfig(), 272, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack icedDragonBoneSaber = new Item(CustomConfig.getItemConfig(), 273, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack icedDragonBoneBoomerang = new Item(CustomConfig.getItemConfig(), 274, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack icedDragonBoneDagger = new Item(CustomConfig.getItemConfig(), 275, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack icedDragonBoneGlaive = new Item(CustomConfig.getItemConfig(), 276, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack icedDragonBoneHalberd = new Item(CustomConfig.getItemConfig(), 277, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack icedDragonBoneHammer = new Item(CustomConfig.getItemConfig(), 278, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack icedDragonBoneJavelin = new Item(CustomConfig.getItemConfig(), 279, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack icedDragonBoneLance = new Item(CustomConfig.getItemConfig(), 280, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack icedDragonBoneMace = new Item(CustomConfig.getItemConfig(), 281, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack icedDragonBonePike = new Item(CustomConfig.getItemConfig(), 282, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack icedDragonBoneQuarterstaff = new Item(CustomConfig.getItemConfig(), 283, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack icedDragonBoneThrowingAxe = new Item(CustomConfig.getItemConfig(), 284, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack icedDragonBoneThrowingKnife = new Item(CustomConfig.getItemConfig(), 285, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack icedDragonBoneWarhammer = new Item(CustomConfig.getItemConfig(), 286, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack icedDragonBoneBattleaxe = new Item(CustomConfig.getItemConfig(), 287, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack icedDragonBoneLongbow = new Item(CustomConfig.getItemConfig(), 288).getNmsItem();
    private static ItemStack icedDragonBoneCrossbow = new Item(CustomConfig.getItemConfig(), 289).getNmsItem();
    private static ItemStack lightningDragonBoneRapier = new Item(CustomConfig.getItemConfig(), 290, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack lightningDragonBoneKatana = new Item(CustomConfig.getItemConfig(), 291, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack lightningDragonBoneGreatsword = new Item(CustomConfig.getItemConfig(), 292, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack lightningDragonBoneLongsword = new Item(CustomConfig.getItemConfig(), 293, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack lightningDragonBoneSpear = new Item(CustomConfig.getItemConfig(), 294, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack lightningDragonBoneSaber = new Item(CustomConfig.getItemConfig(), 295, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack lightningDragonBoneBoomerang = new Item(CustomConfig.getItemConfig(), 296, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack lightningDragonBoneDagger = new Item(CustomConfig.getItemConfig(), 297, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack lightningDragonBoneGlaive = new Item(CustomConfig.getItemConfig(), 298, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack lightningDragonBoneHalberd = new Item(CustomConfig.getItemConfig(), 299, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack lightningDragonBoneHammer = new Item(CustomConfig.getItemConfig(), 300, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack lightningDragonBoneJavelin = new Item(CustomConfig.getItemConfig(), 301, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack lightningDragonBoneLance = new Item(CustomConfig.getItemConfig(), 302, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack lightningDragonBoneMace = new Item(CustomConfig.getItemConfig(), 303, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack lightningDragonBonePike = new Item(CustomConfig.getItemConfig(), 304, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack lightningDragonBoneQuarterstaff = new Item(CustomConfig.getItemConfig(), 305, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack lightningDragonBoneThrowingAxe = new Item(CustomConfig.getItemConfig(), 306, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack lightningDragonBoneThrowingKnife = new Item(CustomConfig.getItemConfig(), 307, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack lightningDragonBoneWarhammer = new Item(CustomConfig.getItemConfig(), 308, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack lightningDragonBoneBattleaxe = new Item(CustomConfig.getItemConfig(), 309, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack lightningDragonBoneLongbow = new Item(CustomConfig.getItemConfig(), 310).getNmsItem();
    private static ItemStack lightningDragonBoneCrossbow = new Item(CustomConfig.getItemConfig(), 311).getNmsItem();
    private static ItemStack fireDragonsteelRapier = new Item(CustomConfig.getItemConfig(), 312, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack fireDragonsteelKatana = new Item(CustomConfig.getItemConfig(), 313, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack fireDragonsteelGreatsword = new Item(CustomConfig.getItemConfig(), 314, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack fireDragonsteelLongsword = new Item(CustomConfig.getItemConfig(), 315, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack fireDragonsteelSpear = new Item(CustomConfig.getItemConfig(), 316, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack fireDragonsteelSaber = new Item(CustomConfig.getItemConfig(), 317, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack fireDragonsteelBoomerang = new Item(CustomConfig.getItemConfig(), 318, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack fireDragonsteelDagger = new Item(CustomConfig.getItemConfig(), 319, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack fireDragonsteelGlaive = new Item(CustomConfig.getItemConfig(), 320, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack fireDragonsteelHalberd = new Item(CustomConfig.getItemConfig(), 321, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack fireDragonsteelHammer = new Item(CustomConfig.getItemConfig(), 322, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack fireDragonsteelJavelin = new Item(CustomConfig.getItemConfig(), 323, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack fireDragonsteelLance = new Item(CustomConfig.getItemConfig(), 324, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack fireDragonsteelMace = new Item(CustomConfig.getItemConfig(), 325, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack fireDragonsteelPike = new Item(CustomConfig.getItemConfig(), 326, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack fireDragonsteelQuarterstaff = new Item(CustomConfig.getItemConfig(), 327, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack fireDragonsteelThrowingAxe = new Item(CustomConfig.getItemConfig(), 328, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack fireDragonsteelThrowingKnife = new Item(CustomConfig.getItemConfig(), 329, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack fireDragonsteelWarhammer = new Item(CustomConfig.getItemConfig(), 330, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack fireDragonsteelBattleaxe = new Item(CustomConfig.getItemConfig(), 331, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack fireDragonsteelLongbow = new Item(CustomConfig.getItemConfig(), 332).getNmsItem();
    private static ItemStack fireDragonsteelCrossbow = new Item(CustomConfig.getItemConfig(), 333).getNmsItem();
    private static ItemStack iceDragonsteelRapier = new Item(CustomConfig.getItemConfig(), 334, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack iceDragonsteelKatana = new Item(CustomConfig.getItemConfig(), 335, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack iceDragonsteelGreatsword = new Item(CustomConfig.getItemConfig(), 336, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack iceDragonsteelLongsword = new Item(CustomConfig.getItemConfig(), 337, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack iceDragonsteelSpear = new Item(CustomConfig.getItemConfig(), 338, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack iceDragonsteelSaber = new Item(CustomConfig.getItemConfig(), 339, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack iceDragonsteelBoomerang = new Item(CustomConfig.getItemConfig(), 340, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack iceDragonsteelDagger = new Item(CustomConfig.getItemConfig(), 341, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack iceDragonsteelGlaive = new Item(CustomConfig.getItemConfig(), 342, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack iceDragonsteelHalberd = new Item(CustomConfig.getItemConfig(), 343, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack iceDragonsteelHammer = new Item(CustomConfig.getItemConfig(), 344, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack iceDragonsteelJavelin = new Item(CustomConfig.getItemConfig(), 345, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack iceDragonsteelLance = new Item(CustomConfig.getItemConfig(), 346, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack iceDragonsteelMace = new Item(CustomConfig.getItemConfig(), 347, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack iceDragonsteelPike = new Item(CustomConfig.getItemConfig(), 348, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack iceDragonsteelQuarterstaff = new Item(CustomConfig.getItemConfig(), 349, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack iceDragonsteelThrowingAxe = new Item(CustomConfig.getItemConfig(), 350, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack iceDragonsteelThrowingKnife = new Item(CustomConfig.getItemConfig(), 351, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack iceDragonsteelWarhammer = new Item(CustomConfig.getItemConfig(), 352, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack iceDragonsteelBattleaxe = new Item(CustomConfig.getItemConfig(), 353, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack iceDragonsteelLongbow = new Item(CustomConfig.getItemConfig(), 354).getNmsItem();
    private static ItemStack iceDragonsteelCrossbow = new Item(CustomConfig.getItemConfig(), 355).getNmsItem();
    private static ItemStack lightningDragonsteelRapier = new Item(CustomConfig.getItemConfig(), 356, CustomConfig.getSpartanWeaponryConfig(), Item.RAPIER).getNmsItem();
    private static ItemStack lightningDragonsteelKatana = new Item(CustomConfig.getItemConfig(), 357, CustomConfig.getSpartanWeaponryConfig(), Item.KATANA).getNmsItem();
    private static ItemStack lightningDragonsteelGreatsword = new Item(CustomConfig.getItemConfig(), 358, CustomConfig.getSpartanWeaponryConfig(), Item.GREATSWORD).getNmsItem();
    private static ItemStack lightningDragonsteelLongsword = new Item(CustomConfig.getItemConfig(), 359, CustomConfig.getSpartanWeaponryConfig(), Item.LONGSWORD).getNmsItem();
    private static ItemStack lightningDragonsteelSpear = new Item(CustomConfig.getItemConfig(), 360, CustomConfig.getSpartanWeaponryConfig(), Item.SPEAR).getNmsItem();
    private static ItemStack lightningDragonsteelSaber = new Item(CustomConfig.getItemConfig(), 361, CustomConfig.getSpartanWeaponryConfig(), Item.SABER).getNmsItem();
    private static ItemStack lightningDragonsteelBoomerang = new Item(CustomConfig.getItemConfig(), 362, CustomConfig.getSpartanWeaponryConfig(), Item.BOOMERANG).getNmsItem();
    private static ItemStack lightningDragonsteelDagger = new Item(CustomConfig.getItemConfig(), 363, CustomConfig.getSpartanWeaponryConfig(), Item.DAGGER).getNmsItem();
    private static ItemStack lightningDragonsteelGlaive = new Item(CustomConfig.getItemConfig(), 364, CustomConfig.getSpartanWeaponryConfig(), Item.GLAIVE).getNmsItem();
    private static ItemStack lightningDragonsteelHalberd = new Item(CustomConfig.getItemConfig(), 365, CustomConfig.getSpartanWeaponryConfig(), Item.HALBERD).getNmsItem();
    private static ItemStack lightningDragonsteelHammer = new Item(CustomConfig.getItemConfig(), 366, CustomConfig.getSpartanWeaponryConfig(), Item.HAMMER).getNmsItem();
    private static ItemStack lightningDragonsteelJavelin = new Item(CustomConfig.getItemConfig(), 367, CustomConfig.getSpartanWeaponryConfig(), Item.JAVELIN).getNmsItem();
    private static ItemStack lightningDragonsteelLance = new Item(CustomConfig.getItemConfig(), 368, CustomConfig.getSpartanWeaponryConfig(), Item.LANCE).getNmsItem();
    private static ItemStack lightningDragonsteelMace = new Item(CustomConfig.getItemConfig(), 369, CustomConfig.getSpartanWeaponryConfig(), Item.MACE).getNmsItem();
    private static ItemStack lightningDragonsteelPike = new Item(CustomConfig.getItemConfig(), 370, CustomConfig.getSpartanWeaponryConfig(), Item.PIKE).getNmsItem();
    private static ItemStack lightningDragonsteelQuarterstaff = new Item(CustomConfig.getItemConfig(), 371, CustomConfig.getSpartanWeaponryConfig(), Item.QUARTERSTAFF).getNmsItem();
    private static ItemStack lightningDragonsteelThrowingAxe = new Item(CustomConfig.getItemConfig(), 372, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_AXE).getNmsItem();
    private static ItemStack lightningDragonsteelThrowingKnife = new Item(CustomConfig.getItemConfig(), 373, CustomConfig.getSpartanWeaponryConfig(), Item.THROWING_KNIFE).getNmsItem();
    private static ItemStack lightningDragonsteelWarhammer = new Item(CustomConfig.getItemConfig(), 374, CustomConfig.getSpartanWeaponryConfig(), Item.WARHAMMER).getNmsItem();
    private static ItemStack lightningDragonsteelBattleaxe = new Item(CustomConfig.getItemConfig(), 375, CustomConfig.getSpartanWeaponryConfig(), Item.BATTLEAXE).getNmsItem();
    private static ItemStack lightningDragonsteelLongbow = new Item(CustomConfig.getItemConfig(), 376).getNmsItem();
    private static ItemStack lightningDragonsteelCrossbow = new Item(CustomConfig.getItemConfig(), 377).getNmsItem();
    private static ItemStack fireDragonsteelBlock = new Item(CustomConfig.getItemConfig(), 378).getNmsItem();
    private static ItemStack iceDragonsteelBlock = new Item(CustomConfig.getItemConfig(), 379).getNmsItem();
    private static ItemStack lightningDragonsteelBlock = new Item(CustomConfig.getItemConfig(), 380).getNmsItem();

    /**
     * Accessor methods for getting each item.
     * Other than this method, no more will receive comments
     * for the sake of brevity and because there are over 300 accessor methods
     * that would receive comments that more or less resemble one another.
     */
    public static ItemStack getFlintAxe() {
        return flintAxe;
    }

    public static ItemStack getFlintKnife() {
        return flintKnife;
    }

    public static ItemStack getFlintPickaxe() {
        return flintPickaxe;
    }

    public static ItemStack getFlintShovel() {
        return flintShovel;
    }

    public static ItemStack getFlintHoe() {
        return flintHoe;
    }

    public static ItemStack getCobblestone() {
        return new ItemStack(Material.COBBLESTONE);
    }

    public static ItemStack getPlantFiber() {
        return plantFiber;
    }

    public static ItemStack getPlantString() {
        return plantString;
    }

    public static ItemStack getString() {
        return new ItemStack(Material.STRING);
    }

    public static ItemStack getFlintShard() {
        return flintShard;
    }

    public static ItemStack getDragonBone() {
        return dragonBone;
    }

    public static ItemStack getWitherbone() {
        return witherbone;
    }

    public static ItemStack getDragonScaleBlue() {
        return blueDragonScales;
    }

    public static ItemStack getDragonScaleBronze() {
        return bronzeDragonScales;
    }

    public static ItemStack getDragonScaleGray() {
        return grayDragonScales;
    }

    public static ItemStack getDragonScaleGreen() {
        return greenDragonScales;
    }

    public static ItemStack getDragonScaleRed() {
        return redDragonScales;
    }

    public static ItemStack getDragonScaleSapphire() {
        return sapphireDragonScales;
    }

    public static ItemStack getDragonScaleSilver() {
        return silverDragonScales;
    }

    public static ItemStack getDragonScaleWhite() {
        return whiteDragonScales;
    }

    public static ItemStack getDragonScaleAmethyst() {
        return amethystDragonScales;
    }

    public static ItemStack getDragonScaleBlack() {
        return blackDragonScales;
    }

    public static ItemStack getDragonScaleCopper() {
        return copperDragonScales;
    }

    public static ItemStack getDragonScaleElectric() {
        return electricDragonScales;
    }

    public static ItemStack getSeaSerpentScaleBlue() {
        return blueSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleBronze() {
        return bronzeSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleDeepBlue() {
        return deepBlueSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleGreen() {
        return greenSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScalePurple() {
        return purpleSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleRed() {
        return redSeaSerpentScales;
    }

    public static ItemStack getSeaSerpentScaleTeal() {
        return tealSeaSerpentScales;
    }

    public static ItemStack getShinyScale() {
        return shinyScales;
    }

    public static ItemStack getFireDragonBlood() {
        return fireDragonBlood;
    }

    public static ItemStack getIceDragonBlood() {
        return iceDragonBlood;
    }

    public static ItemStack getLightningDragonBlood() {
        return lightningDragonBlood;
    }

    public static ItemStack getFireDragonHeart() {
        return fireDragonHeart;
    }

    public static ItemStack getIceDragonHeart() {
        return iceDragonHeart;
    }

    public static ItemStack getLightningDragonHeart() {
        return lightningDragonHeart;
    }

    public static ItemStack getFireDragonSkull() {
        return fireDragonSkull;
    }

    public static ItemStack getIceDragonSkull() {
        return iceDragonSkull;
    }

    public static ItemStack getLightningDragonSkull() {
        return lightningDragonSkull;
    }

    public static ItemStack getFireDragonFlesh() {
        return fireDragonFlesh;
    }

    public static ItemStack getIceDragonFlesh() {
        return iceDragonFlesh;
    }

    public static ItemStack getLightningDragonFlesh() {
        return lightningDragonFlesh;
    }

    public static ItemStack getFireDragonsteelIngot() {
        return fireDragonsteelIngot;
    }

    public static ItemStack getIceDragonsteelIngot() {
        return iceDragonsteelIngot;
    }

    public static ItemStack getLightningDragonsteelIngot() {
        return lightningDragonsteelIngot;
    }

    public static ItemStack getDragonScaleHelmetBlue() {
        return blueDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateBlue() {
        return blueDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsBlue() {
        return blueDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsBlue() {
        return blueDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetBronze() {
        return bronzeDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateBronze() {
        return bronzeDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsBronze() {
        return bronzeDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsBronze() {
        return bronzeDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetGray() {
        return grayDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateGray() {
        return grayDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsGray() {
        return grayDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsGray() {
        return grayDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetGreen() {
        return greenDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateGreen() {
        return greenDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsGreen() {
        return greenDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsGreen() {
        return greenDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetRed() {
        return redDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateRed() {
        return redDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsRed() {
        return redDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsRed() {
        return redDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetSapphire() {
        return sapphireDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateSapphire() {
        return sapphireDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsSapphire() {
        return sapphireDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsSapphire() {
        return sapphireDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetSilver() {
        return silverDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateSilver() {
        return silverDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsSilver() {
        return silverDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsSilver() {
        return silverDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetWhite() {
        return whiteDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateWhite() {
        return whiteDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsWhite() {
        return whiteDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsWhite() {
        return whiteDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetAmethyst() {
        return amethystDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateAmethyst() {
        return amethystDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsAmethyst() {
        return amethystDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsAmethyst() {
        return amethystDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetBlack() {
        return blackDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateBlack() {
        return blackDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsBlack() {
        return blackDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsBlack() {
        return blackDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetCopper() {
        return copperDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateCopper() {
        return copperDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsCopper() {
        return copperDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsCopper() {
        return copperDragonScaleBoots;
    }

    public static ItemStack getDragonScaleHelmetElectric() {
        return electricDragonScaleHelmet;
    }

    public static ItemStack getDragonScaleChestplateElectric() {
        return electricDragonScaleChestplate;
    }

    public static ItemStack getDragonScaleLeggingsElectric() {
        return electricDragonScaleLeggings;
    }

    public static ItemStack getDragonScaleBootsElectric() {
        return electricDragonScaleBoots;
    }

    public static ItemStack getTideGuardianHelmetBlue() {
        return blueTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplateBlue() {
        return blueTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsBlue() {
        return blueTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsBlue() {
        return blueTideGuardianBoots;
    }

    public static ItemStack getTideGuardianHelmetBronze() {
        return bronzeTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplateBronze() {
        return bronzeTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsBronze() {
        return bronzeTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsBronze() {
        return bronzeTideGuardianBoots;
    }

    public static ItemStack getTideGuardianHelmetDeepBlue() {
        return deepBlueTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplateDeepBlue() {
        return deepBlueTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsDeepBlue() {
        return deepBlueTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsDeepBlue() {
        return deepBlueTideGuardianBoots;
    }

    public static ItemStack getTideGuardianHelmetGreen() {
        return greenTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplateGreen() {
        return greenTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsGreen() {
        return greenTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsGreen() {
        return greenTideGuardianBoots;
    }

    public static ItemStack getTideGuardianHelmetPurple() {
        return purpleTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplatePurple() {
        return purpleTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsPurple() {
        return purpleTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsPurple() {
        return purpleTideGuardianBoots;
    }

    public static ItemStack getTideGuardianHelmetRed() {
        return redTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplateRed() {
        return redTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsRed() {
        return redTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsRed() {
        return redTideGuardianBoots;
    }

    public static ItemStack getTideGuardianHelmetTeal() {
        return tealTideGuardianHelmet;
    }

    public static ItemStack getTideGuardianChestplateTeal() {
        return tealTideGuardianChestplate;
    }

    public static ItemStack getTideGuardianLeggingsTeal() {
        return tealTideGuardianLeggings;
    }

    public static ItemStack getTideGuardianBootsTeal() {
        return tealTideGuardianBoots;
    }

    public static ItemStack getDragonBonePickaxe() {
        return dragonBonePickaxe;
    }

    public static ItemStack getDragonBoneAxe() {
        return dragonBoneAxe;
    }

    public static ItemStack getDragonBoneShovel() {
        return dragonBoneShovel;
    }

    public static ItemStack getDragonBoneHoe() {
        return dragonBoneHoe;
    }

    public static ItemStack getDragonBoneSword() {
        return dragonBoneSword;
    }

    public static ItemStack getDragonBoneBow() {
        return dragonBoneBow;
    }

    public static ItemStack getFlamedDragonBoneSword() {
        return flamedDragonBoneSword;
    }

    public static ItemStack getIcedDragonBoneSword() {
        return icedDragonBoneSword;
    }

    public static ItemStack getLightningDragonBoneSword() {
        return lightningDragonBoneSword;
    }

    public static ItemStack getDragonsEye() {
        return dragonsEye;
    }

    public static ItemStack getPoisonStone() {
        return poisonStone;
    }

    public static ItemStack getPotionRingResistance() {
        return potionRingResistance;
    }

    public static ItemStack getPotionRingRegeneration() {
        return potionRingRegeneration;
    }

    public static ItemStack getPotionRingHaste() {
        return potionRingHaste;
    }

    public static ItemStack getPotionRingStrength() {
        return potionRingStrength;
    }

    public static ItemStack getPotionRingSpeed() {
        return potionRingSpeed;
    }

    public static ItemStack getPotionRingJumpBoost() {
        return potionRingJumpBoost;
    }

    public static ItemStack getEnderQueensCrown() {
        return enderQueensCrown;
    }

    public static ItemStack getSunglasses() {
        return sunglasses;
    }

    public static ItemStack getBalloon() {
        return balloon;
    }

    public static ItemStack getCobaltShield() {
        return cobaltShield;
    }

    public static ItemStack getObsidianSkull() {
        return obsidianSkull;
    }

    public static ItemStack getObsidianShield() {
        return obsidianShield;
    }

    public static ItemStack getForbiddenFruit() {
        return forbiddenFruit;
    }

    public static ItemStack getVitamins() {
        return vitamins;
    }

    public static ItemStack getRingofOverclocking() {
        return ringOverclocking;
    }

    public static ItemStack getShulkerHeart() {
        return shulkerHeart;
    }

    public static ItemStack getRingofFreeAction() {
        return ringFreeAction;
    }

    public static ItemStack getBezoar() {
        return bezoar;
    }

    public static ItemStack getEnderDragonScale() {
        return enderDragonScale;
    }

    public static ItemStack getCrackedBlackDragonScale() {
        return crackedBlackDragonScale;
    }

    public static ItemStack getBlackDragonScale() {
        return blackDragonScale;
    }

    public static ItemStack getMixedColorDragonScale() {
        return mixedColorDragonScale;
    }

    public static ItemStack getAnkhCharm() {
        return ankhCharm;
    }

    public static ItemStack getAnkhShield() {
        return ankhShield;
    }

    public static ItemStack getIronRing() {
        return ironRing;
    }

    public static ItemStack getMagicMirror() {
        return magicMirror;
    }

    public static ItemStack getRecallPotion() {
        return recallPotion;
    }

    public static ItemStack getWormholeMirror() {
        return wormholeMirror;
    }

    public static ItemStack getWormholePotion() {
        return wormholePotion;
    }

    public static ItemStack getLuckyHorseshoe() {
        return luckyHorseshoe;
    }

    public static ItemStack getBattleBurrito() {
        return battleBurrito;
    }

    public static ItemStack getScarliteRing() {
        return scarliteRing;
    }

    public static ItemStack getSpectralSilt() {
        return spectralSilt;
    }

    public static ItemStack getDisintegrationTablet() {
        return disintegrationTablet;
    }

    public static ItemStack getBrokenHeart() {
        return brokenHeart;
    }

    public static ItemStack getCrossNecklace() {
        return crossNecklace;
    }

    public static ItemStack getWrathPendant() {
        return wrathPendant;
    }

    public static ItemStack getPridePendant() {
        return pridePendant;
    }

    public static ItemStack getGoldenCrown() {
        return goldenCrown;
    }

    public static ItemStack getGluttonyPendant() {
        return gluttonyPendant;
    }

    public static ItemStack getSinPendant() {
        return sinPendant;
    }

    public static ItemStack getFlareGun() {
        return flareGun;
    }

    public static ItemStack getFlare() {
        return flare;
    }

    public static ItemStack getPhytoprostasiaAmulet() {
        return phytoprotostasiaAmulet;
    }

    public static ItemStack getPotionRing() {
        return potionRing;
    }

    public static ItemStack getEmeraldRing() {
        return emeraldRing;
    }

    public static ItemStack getEmeraldAmulet() {
        return emeraldAmulet;
    }

    public static ItemStack getGlowingIngot() {
        return glowingIngot;
    }

    public static ItemStack getGlowingPowder() {
        return glowingPowder;
    }

    public static ItemStack getGlowingGem() {
        return glowingGem;
    }

    public static ItemStack getDwarfStout() {
        return dwarfStout;
    }

    public static ItemStack getFairyDew() {
        return fairyDew;
    }

    public static ItemStack getStoneNegativeGravity() {
        return stoneNegativeGravity;
    }

    public static ItemStack getStoneInertiaNull() {
        return stoneInertiaNull;
    }

    public static ItemStack getStoneGreaterInertia() {
        return stoneGreaterInertia;
    }

    public static ItemStack getRingEnchantedEyes() {
        return ringEnchantedEyes;
    }

    public static ItemStack getStoneSea() {
        return stoneSea;
    }

    public static ItemStack getPolarizedStone() {
        return polarizedStone;
    }

    public static ItemStack getRingFairies() {
        return ringFairies;
    }

    public static ItemStack getRingDwarves() {
        return ringDwarves;
    }

    public static ItemStack getWitherRing() {
        return witherRing;
    }

    public static ItemStack getShieldHonor() {
        return shieldHonor;
    }

    public static ItemStack getMinersRing() {
        return minersRing;
    }

    public static ItemStack getWarpedScroll() {
        return warpedScroll;
    }

    public static ItemStack getFireResistancePotion() {
        return fireResistancePotion;
    }

    public static ItemStack getFireDragonsteelSword() {
        return fireDragonsteelSword;
    }

    public static ItemStack getFireDragonsteelPickaxe() {
        return fireDragonsteelPickaxe;
    }

    public static ItemStack getFireDragonsteelAxe() {
        return fireDragonsteelAxe;
    }

    public static ItemStack getFireDragonsteelShovel() {
        return fireDragonsteelShovel;
    }

    public static ItemStack getFireDragonsteelHoe() {
        return fireDragonsteelHoe;
    }

    public static ItemStack getIceDragonsteelSword() {
        return iceDragonsteelSword;
    }

    public static ItemStack getIceDragonsteelPickaxe() {
        return iceDragonsteelPickaxe;
    }

    public static ItemStack getIceDragonsteelAxe() {
        return iceDragonsteelAxe;
    }

    public static ItemStack getIceDragonsteelShovel() {
        return iceDragonsteelShovel;
    }

    public static ItemStack getIceDragonsteelHoe() {
        return iceDragonsteelHoe;
    }

    public static ItemStack getLightningDragonsteelSword() {
        return lightningDragonsteelSword;
    }

    public static ItemStack getLightningDragonsteelPickaxe() {
        return lightningDragonsteelPickaxe;
    }

    public static ItemStack getLightningDragonsteelAxe() {
        return lightningDragonsteelAxe;
    }

    public static ItemStack getLightningDragonsteelShovel() {
        return lightningDragonsteelShovel;
    }

    public static ItemStack getLightningDragonsteelHoe() {
        return lightningDragonsteelHoe;
    }

    public static ItemStack getFireDragonsteelHelmet() {
        return fireDragonsteelHelmet;
    }

    public static ItemStack getFireDragonsteelChestplate() {
        return fireDragonsteelChestplate;
    }

    public static ItemStack getFireDragonsteelLeggings() {
        return fireDragonsteelLeggings;
    }

    public static ItemStack getFireDragonsteelBoots() {
        return fireDragonsteelBoots;
    }

    public static ItemStack getIceDragonsteelHelmet() {
        return iceDragonsteelHelmet;
    }

    public static ItemStack getIceDragonsteelChestplate() {
        return iceDragonsteelChestplate;
    }

    public static ItemStack getIceDragonsteelLeggings() {
        return iceDragonsteelLeggings;
    }

    public static ItemStack getIceDragonsteelBoots() {
        return iceDragonsteelBoots;
    }

    public static ItemStack getLightningDragonsteelHelmet() {
        return lightningDragonsteelHelmet;
    }

    public static ItemStack getLightningDragonsteelChestplate() {
        return lightningDragonsteelChestplate;
    }

    public static ItemStack getLightningDragonsteelLeggings() {
        return lightningDragonsteelLeggings;
    }

    public static ItemStack getLightningDragonsteelBoots() {
        return lightningDragonsteelBoots;
    }

    public static ItemStack getDragonBoneRapier() {
        return dragonBoneRapier;
    }

    public static ItemStack getDragonBoneKatana() {
        return dragonBoneKatana;
    }

    public static ItemStack getDragonBoneGreatsword() {
        return dragonBoneGreatsword;
    }

    public static ItemStack getDragonBoneLongsword() {
        return dragonBoneLongsword;
    }

    public static ItemStack getDragonBoneSpear() {
        return dragonBoneSpear;
    }

    public static ItemStack getDragonBoneSaber() {
        return dragonBoneSaber;
    }

    public static ItemStack getDragonBoneBoomerang() {
        return dragonBoneBoomerang;
    }

    public static ItemStack getDragonBoneDagger() {
        return dragonBoneDagger;
    }

    public static ItemStack getDragonBoneGlaive() {
        return dragonBoneGlaive;
    }

    public static ItemStack getDragonBoneHalberd() {
        return dragonBoneHalberd;
    }

    public static ItemStack getDragonBoneHammer() {
        return dragonBoneHammer;
    }

    public static ItemStack getDragonBoneJavelin() {
        return dragonBoneJavelin;
    }

    public static ItemStack getDragonBoneLance() {
        return dragonBoneLance;
    }

    public static ItemStack getDragonBoneMace() {
        return dragonBoneMace;
    }

    public static ItemStack getDragonBonePike() {
        return dragonBonePike;
    }

    public static ItemStack getDragonBoneQuarterstaff() {
        return dragonBoneQuarterstaff;
    }

    public static ItemStack getDragonBoneThrowingAxe() {
        return dragonBoneThrowingAxe;
    }

    public static ItemStack getDragonBoneThrowingKnife() {
        return dragonBoneThrowingKnife;
    }

    public static ItemStack getDragonBoneWarhammer() {
        return dragonBoneWarhammer;
    }

    public static ItemStack getDragonBoneBattleaxe() {
        return dragonBoneBattleaxe;
    }

    public static ItemStack getDragonBoneLongbow() {
        return dragonBoneLongbow;
    }

    public static ItemStack getDragonBoneCrossbow() {
        return dragonBoneCrossbow;
    }

    public static ItemStack getFlamedDragonBoneRapier() {
        return flamedDragonBoneRapier;
    }

    public static ItemStack getFlamedDragonBoneKatana() {
        return flamedDragonBoneKatana;
    }

    public static ItemStack getFlamedDragonBoneGreatsword() {
        return flamedDragonBoneGreatsword;
    }

    public static ItemStack getFlamedDragonBoneLongsword() {
        return flamedDragonBoneLongsword;
    }

    public static ItemStack getFlamedDragonBoneSpear() {
        return flamedDragonBoneSpear;
    }

    public static ItemStack getFlamedDragonBoneSaber() {
        return flamedDragonBoneSaber;
    }

    public static ItemStack getFlamedDragonBoneBoomerang() {
        return flamedDragonBoneBoomerang;
    }

    public static ItemStack getFlamedDragonBoneDagger() {
        return flamedDragonBoneDagger;
    }

    public static ItemStack getFlamedDragonBoneGlaive() {
        return flamedDragonBoneGlaive;
    }

    public static ItemStack getFlamedDragonBoneHalberd() {
        return flamedDragonBoneHalberd;
    }

    public static ItemStack getFlamedDragonBoneHammer() {
        return flamedDragonBoneHammer;
    }

    public static ItemStack getFlamedDragonBoneJavelin() {
        return flamedDragonBoneJavelin;
    }

    public static ItemStack getFlamedDragonBoneLance() {
        return flamedDragonBoneLance;
    }

    public static ItemStack getFlamedDragonBoneMace() {
        return flamedDragonBoneMace;
    }

    public static ItemStack getFlamedDragonBonePike() {
        return flamedDragonBonePike;
    }

    public static ItemStack getFlamedDragonBoneQuarterstaff() {
        return flamedDragonBoneQuarterstaff;
    }

    public static ItemStack getFlamedDragonBoneThrowingAxe() {
        return flamedDragonBoneThrowingAxe;
    }

    public static ItemStack getFlamedDragonBoneThrowingKnife() {
        return flamedDragonBoneThrowingKnife;
    }

    public static ItemStack getFlamedDragonBoneWarhammer() {
        return flamedDragonBoneWarhammer;
    }

    public static ItemStack getFlamedDragonBoneBattleaxe() {
        return flamedDragonBoneBattleaxe;
    }

    public static ItemStack getFlamedDragonBoneLongbow() {
        return flamedDragonBoneLongbow;
    }

    public static ItemStack getFlamedDragonBoneCrossbow() {
        return flamedDragonBoneCrossbow;
    }

    public static ItemStack getIcedDragonBoneRapier() {
        return icedDragonBoneRapier;
    }

    public static ItemStack getIcedDragonBoneKatana() {
        return icedDragonBoneKatana;
    }

    public static ItemStack getIcedDragonBoneGreatsword() {
        return icedDragonBoneGreatsword;
    }

    public static ItemStack getIcedDragonBoneLongsword() {
        return icedDragonBoneLongsword;
    }

    public static ItemStack getIcedDragonBoneSpear() {
        return icedDragonBoneSpear;
    }

    public static ItemStack getIcedDragonBoneSaber() {
        return icedDragonBoneSaber;
    }

    public static ItemStack getIcedDragonBoneBoomerang() {
        return icedDragonBoneBoomerang;
    }

    public static ItemStack getIcedDragonBoneDagger() {
        return icedDragonBoneDagger;
    }

    public static ItemStack getIcedDragonBoneGlaive() {
        return icedDragonBoneGlaive;
    }

    public static ItemStack getIcedDragonBoneHalberd() {
        return icedDragonBoneHalberd;
    }

    public static ItemStack getIcedDragonBoneHammer() {
        return icedDragonBoneHammer;
    }

    public static ItemStack getIcedDragonBoneJavelin() {
        return icedDragonBoneJavelin;
    }

    public static ItemStack getIcedDragonBoneLance() {
        return icedDragonBoneLance;
    }

    public static ItemStack getIcedDragonBoneMace() {
        return icedDragonBoneMace;
    }

    public static ItemStack getIcedDragonBonePike() {
        return icedDragonBonePike;
    }

    public static ItemStack getIcedDragonBoneQuarterstaff() {
        return icedDragonBoneQuarterstaff;
    }

    public static ItemStack getIcedDragonBoneThrowingAxe() {
        return icedDragonBoneThrowingAxe;
    }

    public static ItemStack getIcedDragonBoneThrowingKnife() {
        return icedDragonBoneThrowingKnife;
    }

    public static ItemStack getIcedDragonBoneWarhammer() {
        return icedDragonBoneWarhammer;
    }

    public static ItemStack getIcedDragonBoneBattleaxe() {
        return icedDragonBoneBattleaxe;
    }

    public static ItemStack getIcedDragonBoneLongbow() {
        return icedDragonBoneLongbow;
    }

    public static ItemStack getIcedDragonBoneCrossbow() {
        return icedDragonBoneCrossbow;
    }

    public static ItemStack getLightningDragonBoneRapier() {
        return lightningDragonBoneRapier;
    }

    public static ItemStack getLightningDragonBoneKatana() {
        return lightningDragonBoneKatana;
    }

    public static ItemStack getLightningDragonBoneGreatsword() {
        return lightningDragonBoneGreatsword;
    }

    public static ItemStack getLightningDragonBoneLongsword() {
        return lightningDragonBoneLongsword;
    }

    public static ItemStack getLightningDragonBoneSpear() {
        return lightningDragonBoneSpear;
    }

    public static ItemStack getLightningDragonBoneSaber() {
        return lightningDragonBoneSaber;
    }

    public static ItemStack getLightningDragonBoneBoomerang() {
        return lightningDragonBoneBoomerang;
    }

    public static ItemStack getLightningDragonBoneDagger() {
        return lightningDragonBoneDagger;
    }

    public static ItemStack getLightningDragonBoneGlaive() {
        return lightningDragonBoneGlaive;
    }

    public static ItemStack getLightningDragonBoneHalberd() {
        return lightningDragonBoneHalberd;
    }

    public static ItemStack getLightningDragonBoneHammer() {
        return lightningDragonBoneHammer;
    }

    public static ItemStack getLightningDragonBoneJavelin() {
        return lightningDragonBoneJavelin;
    }

    public static ItemStack getLightningDragonBoneLance() {
        return lightningDragonBoneLance;
    }

    public static ItemStack getLightningDragonBoneMace() {
        return lightningDragonBoneMace;
    }

    public static ItemStack getLightningDragonBonePike() {
        return lightningDragonBonePike;
    }

    public static ItemStack getLightningDragonBoneQuarterstaff() {
        return lightningDragonBoneQuarterstaff;
    }

    public static ItemStack getLightningDragonBoneThrowingAxe() {
        return lightningDragonBoneThrowingAxe;
    }

    public static ItemStack getLightningDragonBoneThrowingKnife() {
        return lightningDragonBoneThrowingKnife;
    }

    public static ItemStack getLightningDragonBoneWarhammer() {
        return lightningDragonBoneWarhammer;
    }

    public static ItemStack getLightningDragonBoneBattleaxe() {
        return lightningDragonBoneBattleaxe;
    }

    public static ItemStack getLightningDragonBoneLongbow() {
        return lightningDragonBoneLongbow;
    }

    public static ItemStack getLightningDragonBoneCrossbow() {
        return lightningDragonBoneCrossbow;
    }

    public static ItemStack getFireDragonsteelRapier() {
        return fireDragonsteelRapier;
    }

    public static ItemStack getFireDragonsteelKatana() {
        return fireDragonsteelKatana;
    }

    public static ItemStack getFireDragonsteelGreatsword() {
        return fireDragonsteelGreatsword;
    }

    public static ItemStack getFireDragonsteelLongsword() {
        return fireDragonsteelLongsword;
    }

    public static ItemStack getFireDragonsteelSpear() {
        return fireDragonsteelSpear;
    }

    public static ItemStack getFireDragonsteelSaber() {
        return fireDragonsteelSaber;
    }

    public static ItemStack getFireDragonsteelBoomerang() {
        return fireDragonsteelBoomerang;
    }

    public static ItemStack getFireDragonsteelDagger() {
        return fireDragonsteelDagger;
    }

    public static ItemStack getFireDragonsteelGlaive() {
        return fireDragonsteelGlaive;
    }

    public static ItemStack getFireDragonsteelHalberd() {
        return fireDragonsteelHalberd;
    }

    public static ItemStack getFireDragonsteelHammer() {
        return fireDragonsteelHammer;
    }

    public static ItemStack getFireDragonsteelJavelin() {
        return fireDragonsteelJavelin;
    }

    public static ItemStack getFireDragonsteelLance() {
        return fireDragonsteelLance;
    }

    public static ItemStack getFireDragonsteelMace() {
        return fireDragonsteelMace;
    }

    public static ItemStack getFireDragonsteelPike() {
        return fireDragonsteelPike;
    }

    public static ItemStack getFireDragonsteelQuarterstaff() {
        return fireDragonsteelQuarterstaff;
    }

    public static ItemStack getFireDragonsteelThrowingAxe() {
        return fireDragonsteelThrowingAxe;
    }

    public static ItemStack getFireDragonsteelThrowingKnife() {
        return fireDragonsteelThrowingKnife;
    }

    public static ItemStack getFireDragonsteelWarhammer() {
        return fireDragonsteelWarhammer;
    }

    public static ItemStack getFireDragonsteelBattleaxe() {
        return fireDragonsteelBattleaxe;
    }

    public static ItemStack getFireDragonsteelLongbow() {
        return fireDragonsteelLongbow;
    }

    public static ItemStack getFireDragonsteelCrossbow() {
        return fireDragonsteelCrossbow;
    }

    public static ItemStack getIceDragonsteelRapier() {
        return iceDragonsteelRapier;
    }

    public static ItemStack getIceDragonsteelKatana() {
        return iceDragonsteelKatana;
    }

    public static ItemStack getIceDragonsteelGreatsword() {
        return iceDragonsteelGreatsword;
    }

    public static ItemStack getIceDragonsteelLongsword() {
        return iceDragonsteelLongsword;
    }

    public static ItemStack getIceDragonsteelSpear() {
        return iceDragonsteelSpear;
    }

    public static ItemStack getIceDragonsteelSaber() {
        return iceDragonsteelSaber;
    }

    public static ItemStack getIceDragonsteelBoomerang() {
        return iceDragonsteelBoomerang;
    }

    public static ItemStack getIceDragonsteelDagger() {
        return iceDragonsteelDagger;
    }

    public static ItemStack getIceDragonsteelGlaive() {
        return iceDragonsteelGlaive;
    }

    public static ItemStack getIceDragonsteelHalberd() {
        return iceDragonsteelHalberd;
    }

    public static ItemStack getIceDragonsteelHammer() {
        return iceDragonsteelHammer;
    }

    public static ItemStack getIceDragonsteelJavelin() {
        return iceDragonsteelJavelin;
    }

    public static ItemStack getIceDragonsteelLance() {
        return iceDragonsteelLance;
    }

    public static ItemStack getIceDragonsteelMace() {
        return iceDragonsteelMace;
    }

    public static ItemStack getIceDragonsteelPike() {
        return iceDragonsteelPike;
    }

    public static ItemStack getIceDragonsteelQuarterstaff() {
        return iceDragonsteelQuarterstaff;
    }

    public static ItemStack getIceDragonsteelThrowingAxe() {
        return iceDragonsteelThrowingAxe;
    }

    public static ItemStack getIceDragonsteelThrowingKnife() {
        return iceDragonsteelThrowingKnife;
    }

    public static ItemStack getIceDragonsteelWarhammer() {
        return iceDragonsteelWarhammer;
    }

    public static ItemStack getIceDragonsteelBattleaxe() {
        return iceDragonsteelBattleaxe;
    }

    public static ItemStack getIceDragonsteelLongbow() {
        return iceDragonsteelLongbow;
    }

    public static ItemStack getIceDragonsteelCrossbow() {
        return iceDragonsteelCrossbow;
    }

    public static ItemStack getLightningDragonsteelRapier() {
        return lightningDragonsteelRapier;
    }

    public static ItemStack getLightningDragonsteelKatana() {
        return lightningDragonsteelKatana;
    }

    public static ItemStack getLightningDragonsteelGreatsword() {
        return lightningDragonsteelGreatsword;
    }

    public static ItemStack getLightningDragonsteelLongsword() {
        return lightningDragonsteelLongsword;
    }

    public static ItemStack getLightningDragonsteelSpear() {
        return lightningDragonsteelSpear;
    }

    public static ItemStack getLightningDragonsteelSaber() {
        return lightningDragonsteelSaber;
    }

    public static ItemStack getLightningDragonsteelBoomerang() {
        return lightningDragonsteelBoomerang;
    }

    public static ItemStack getLightningDragonsteelDagger() {
        return lightningDragonsteelDagger;
    }

    public static ItemStack getLightningDragonsteelGlaive() {
        return lightningDragonsteelGlaive;
    }

    public static ItemStack getLightningDragonsteelHalberd() {
        return lightningDragonsteelHalberd;
    }

    public static ItemStack getLightningDragonsteelHammer() {
        return lightningDragonsteelHammer;
    }

    public static ItemStack getLightningDragonsteelJavelin() {
        return lightningDragonsteelJavelin;
    }

    public static ItemStack getLightningDragonsteelLance() {
        return lightningDragonsteelLance;
    }

    public static ItemStack getLightningDragonsteelMace() {
        return lightningDragonsteelMace;
    }

    public static ItemStack getLightningDragonsteelPike() {
        return lightningDragonsteelPike;
    }

    public static ItemStack getLightningDragonsteelQuarterstaff() {
        return lightningDragonsteelQuarterstaff;
    }

    public static ItemStack getLightningDragonsteelThrowingAxe() {
        return lightningDragonsteelThrowingAxe;
    }

    public static ItemStack getLightningDragonsteelThrowingKnife() {
        return lightningDragonsteelThrowingKnife;
    }

    public static ItemStack getLightningDragonsteelWarhammer() {
        return lightningDragonsteelWarhammer;
    }

    public static ItemStack getLightningDragonsteelBattleaxe() {
        return lightningDragonsteelBattleaxe;
    }

    public static ItemStack getLightningDragonsteelLongbow() {
        return lightningDragonsteelLongbow;
    }

    public static ItemStack getLightningDragonsteelCrossbow() {
        return lightningDragonsteelCrossbow;
    }

    public static ItemStack getFireDragonsteelBlock() {
        return fireDragonsteelBlock;
    }

    public static ItemStack getIceDragonsteelBlock() {
        return iceDragonsteelBlock;
    }

    public static ItemStack getLightningDragonsteelBlock() {
        return lightningDragonsteelBlock;
    }
}