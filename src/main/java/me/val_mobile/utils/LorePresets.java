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

import me.val_mobile.enums.Dragon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LorePresets {

    public static void addDragonSkullLore(ItemStack item, int stage, Dragon.Breed breed) {

        ItemMeta meta = item.getItemMeta();
        if (!(meta.getLore() == null || meta.getLore().isEmpty())) {
            List<String> lore = meta.getLore();

            lore.add(ChatColor.translateAlternateColorCodes('&',""));

            if (breed.equals(Dragon.Breed.FIRE)) {
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Fire"));
            }
            else if (breed.equals(Dragon.Breed.ICE)) {
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Ice"));
            }
            else {
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Lightning"));
            }

            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Stage " + stage));

            meta.setLore(lore);
            item.setItemMeta(meta);

        }
        else {
            List<String> lore = new ArrayList<>();

            lore.add(ChatColor.translateAlternateColorCodes('&',""));

            if (breed.equals(Dragon.Breed.FIRE)) {
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Fire"));
            }
            else if (breed.equals(Dragon.Breed.ICE)) {
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Ice"));
            }
            else {
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Lightning"));
            }

            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Stage " + stage));

            meta.setLore(lore);
            item.setItemMeta(meta);
        }
    }

    public static void addRapierLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Damage Absorption"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &725.0% of damage taken dealt"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7in durability from this weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Unarmoured Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+200% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Armor"));

    }

    public static void addSaberLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Damage Absorption"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &725.0% of damage taken dealt"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7in durability from this weapon"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Chest Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Chest Armor"));

    }

    public static void addBattleaxeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Versatile"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Can be used as an axe"));

    }

    public static void addBoomerangLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));

    }

    public static void addCrossbowLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&7High damage & Long-ranged. Requires loading before firing. Uses Bolts."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Quick shots after firing will affect accuracy."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Hold the aim for a pinpoint shot."));

    }

    public static void addDaggerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));

    }

    public static void addGlaiveLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 50.0% of standard damage"));

    }

    public static void addGreatswordLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 100.0% of standard damage"));

    }

    public static void addHalberdLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Shield Breach"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Chance to breach a foe's shield"));
    }

    public static void addHammerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Enhanced Knockback"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Foes get knocked back further away"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Nauseous Blow"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Inflicts Nausea II (5.0s) on hit,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7unless the foe is wearing a Helmet"));

    }

    public static void addJavelinLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+200% damage when the weapon is thrown"));

    }

    public static void addKatanaLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Chest Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7when the foe has no Chest Armor"));

    }

    public static void addLanceLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Riding Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% base weapon damage"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7while riding a mount or vehicle"));

    }

    public static void addLongbowLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Long-range version of the standard bow"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Takes longer to draw fully"));

    }

    public static void addLongswordLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));

    }

    public static void addMaceLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Undead Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+50% base weapon damage against Undead foes"));

    }

    public static void addPikeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach II"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));

    }

    public static void addSpearLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Reach I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Increased melee damage range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Higher reach levels have more range"));

    }

    public static void addQuarterstaffLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Wide Attack I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7All targets in sweep range"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7take 50.0% of standard damage"));

    }

    public static void addThrowingAxeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% damage when the weapon is thrown"));

    }

    public static void addThrowingKnifeLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwable"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7This weapon can be thrown at foes"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Throwing Damage Bonus"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7+100% damage when the weapon is thrown"));

    }

    public static void addWarhammerLore(List<String> lore) {

        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two-Handed I"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7Any item in the opposite hand slot"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &7slows down attack speed"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Armor Piercing"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " &750.0% of damage inflicted ignores armor"));

    }

    public static void addFlamedDragonBoneLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Ignites and knocks back targets, deals extra damage to ice dragons"));
    }

    public static void addIcedDragonBoneLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Slows and knocks back targets, deals extra damage to fire dragons"));
    }

    public static void addLightningDragonBoneLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strikes targets with lightning, deals extra damage to fire and ice dragons"));
    }

    public static void addFireDragonsteelLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Ignites and knocks back targets"));
    }

    public static void addIceDragonsteelLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Slows and knocks back targets"));
    }

    public static void addLightningDragonsteelLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strikes targets with lightning"));
    }

    public static void addBlueDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bBlue"));
    }

    public static void addBronzeDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bronze"));
    }

    public static void addGrayDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Gray"));
    }

    public static void addGreenDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2Emerald"));
    }

    public static void addRedDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&4Red"));
    }

    public static void addSapphireDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Sapphire"));
    }

    public static void addSilverDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&8Silver"));
    }

    public static void addWhiteDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&fWhite"));
    }

    public static void addAmethystDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dAmethyst"));
    }

    public static void addBlackDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&8Black"));
    }

    public static void addCopperDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Copper"));
    }

    public static void addElectricDragonScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&1Electric Blue"));
    }

    public static void addBlueSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Blue"));
    }

    public static void addBronzeSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6Bronze"));
    }

    public static void addDeepBlueSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&1Deep Blue"));
    }

    public static void addGreenSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2Green"));
    }

    public static void addPurpleSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&5Purple"));
    }

    public static void addRedSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&4Red"));
    }

    public static void addTealSeaSerpentScaleLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bTeal"));
    }

    public static void addDragonProtectionLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Increased protection from dragon breath attacks"));
    }

    public static void addTideGuardianBreathingLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Water Breathing"));
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7Provides Strength when wet, increasing levels"));
    }

    public static void addLegendaryWeaponLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&6Legendary Weapon"));
    }

    public static void addFlamedExtraDamageLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Ice Dragons"));
    }

    public static void addFireDragonAbilityLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&4Ignites and knocks back targets"));
    }

    public static void addIceDragonAbilityLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&bFreezes targets"));
    }

    public static void addLightningDragonAbilityLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&5Strikes targets with lightning"));
    }

    public static void addIcedExtraDamageLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+8 damage against Fire Dragons"));
    }

    public static void addLightningExtraDamageLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&a+4 damage against Fire Dragons and Ice Dragons"));
    }

    public static void addWeaponLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
    }

    public static void addHelmetLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
    }

    public static void addChestplateLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
    }

    public static void addLeggingsLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
    }

    public static void addBootsLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
    }

    public static void addThrowableLore(List<String> lore) {
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7When thrown:"));
    }

    public static void addThrowableStatsLore(List<String> lore, Double damage) {
        if (Math.floor(damage) == damage) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage.intValue() + " Attack Damage"));
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + damage + " Attack Damage"));
        }
    }

    public static void addGearLore(List<String> lore, Material material) {
        lore.add("");
        if (Utils.isArmor(material)) {
            if (Utils.isHelmet(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Head:"));
            }
            else if (Utils.isChestplate(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Body:"));
            }
            else if (Utils.isLeggings(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Legs:"));
            }
            else if (Utils.isBoots(material)) {
                lore.add(ChatColor.translateAlternateColorCodes('&',"&7When on Feet:"));
            }
        }
        else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
        }
    }

    public static void addGearStats(List<String> lore, Attribute atr, Double value) {
        switch (atr) {
            case GENERIC_ATTACK_DAMAGE:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value.intValue() + " Attack Damage"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value + " Attack Damage"));
                }
                break;
            case GENERIC_ATTACK_SPEED:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value.intValue() + " Attack Speed"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value + " Attack Speed"));
                }
                break;
            case GENERIC_ARMOR:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value.intValue() + " Armor"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value + " Armor"));
                }
                break;
            case GENERIC_ARMOR_TOUGHNESS:
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value.intValue() + " Armor Toughness"));
                }
                else {
                    lore.add(ChatColor.translateAlternateColorCodes('&',"&9+" + value + " Armor Toughness"));
                }
                break;
        }
    }

    public static void useLorePreset(List<String> lore, String weaponType) {
        switch (weaponType) {
            case "RAPIER":
                addRapierLore(lore);
                break;
            case "SABER":
                addSaberLore(lore);
                break;
            case "KATANA":
                addKatanaLore(lore);
                break;
            case "GREATSWORD":
                addGreatswordLore(lore);
                break;
            case "LONGSWORD":
                addLongswordLore(lore);
                break;
            case "SPEAR":
                addSpearLore(lore);
                break;
            case "GLAIVE":
                addGlaiveLore(lore);
                break;
            case "BOOMERANG":
                addBoomerangLore(lore);
                break;
            case "DAGGER":
                addDaggerLore(lore);
                break;
            case "HALBERD":
                addHalberdLore(lore);
                break;
            case "HAMMER":
                addHammerLore(lore);
                break;
            case "JAVELIN":
                addJavelinLore(lore);
                break;
            case "LANCE":
                addLanceLore(lore);
                break;
            case "MACE":
                addMaceLore(lore);
                break;
            case "PIKE":
                addPikeLore(lore);
                break;
            case "QUARTERSTAFF":
                addQuarterstaffLore(lore);
                break;
            case "TOMAHAWK":
                addThrowingAxeLore(lore);
                break;
            case "THROWING_KNIFE":
                addThrowingKnifeLore(lore);
                break;
            case "WARHAMMER":
                addWarhammerLore(lore);
                break;
            case "BATTLEAXE":
                addBattleaxeLore(lore);
                break;
            case "LONGBOW":
                addLongbowLore(lore);
                break;
            case "CROSSBOW":
                addCrossbowLore(lore);
                break;
            case "FLAMED_DRAGONBONE":
                addFlamedDragonBoneLore(lore);
                break;
            case "ICED_DRAGONBONE":
                addIcedDragonBoneLore(lore);
                break;
            case "LIGHTNING_DRAGONBONE":
                addLightningDragonBoneLore(lore);
                break;
            case "FIRE_DRAGONSTEEL":
                addFireDragonsteelLore(lore);
                break;
            case "ICE_DRAGONSTEEL":
                addIceDragonsteelLore(lore);
                break;
            case "LIGHTNING_DRAGONSTEEL":
                addLightningDragonsteelLore(lore);
                break;
            case "BLUE_DRAGON_SCALE":
                addBlueDragonScaleLore(lore);
                break;
            case "BRONZE_DRAGON_SCALE":
                addBronzeDragonScaleLore(lore);
                break;
            case "GRAY_DRAGON_SCALE":
                addGrayDragonScaleLore(lore);
                break;
            case "GREEN_DRAGON_SCALE":
                addGreenDragonScaleLore(lore);
                break;
            case "RED_DRAGON_SCALE":
                addRedDragonScaleLore(lore);
                break;
            case "SAPPHIRE_DRAGON_SCALE":
                addSapphireDragonScaleLore(lore);
                break;
            case "SILVER_DRAGON_SCALE":
                addSilverDragonScaleLore(lore);
                break;
            case "WHITE_DRAGON_SCALE":
                addWhiteDragonScaleLore(lore);
                break;
            case "AMETHYST_DRAGON_SCALE":
                addAmethystDragonScaleLore(lore);
                break;
            case "BLACK_DRAGON_SCALE":
                addBlackDragonScaleLore(lore);
                break;
            case "COPPER_DRAGON_SCALE":
                addCopperDragonScaleLore(lore);
                break;
            case "ELECTRIC_DRAGON_SCALE":
                addElectricDragonScaleLore(lore);
                break;
            case "BLUE_SEA_SERPENT_SCALE":
                addBlueSeaSerpentScaleLore(lore);
                break;
            case "BRONZE_SEA_SERPENT_SCALE":
                addBronzeSeaSerpentScaleLore(lore);
                break;
            case "DEEPBLUE_SEA_SERPENT_SCALE":
                addDeepBlueSeaSerpentScaleLore(lore);
                break;
            case "GREEN_SEA_SERPENT_SCALE":
                addGreenSeaSerpentScaleLore(lore);
                break;
            case "PURPLE_SEA_SERPENT_SCALE":
                addPurpleSeaSerpentScaleLore(lore);
                break;
            case "RED_SEA_SERPENT_SCALE":
                addRedSeaSerpentScaleLore(lore);
                break;
            case "TEAL_SEA_SERPENT_SCALE":
                addTealSeaSerpentScaleLore(lore);
                break;
            case "DRAGON_PROTECTION":
                addDragonProtectionLore(lore);
                break;
            case "TIDE_GUARDIAN_BREATHING":
                addTideGuardianBreathingLore(lore);
                break;
            case "LEGENDARY_WEAPON":
                addLegendaryWeaponLore(lore);
                break;
            case "FLAMED_EXTRA_DAMAGE":
                addFlamedExtraDamageLore(lore);
                break;
            case "ICED_EXTRA_DAMAGE":
                addIcedExtraDamageLore(lore);
                break;
            case "LIGHTNING_EXTRA_DAMAGE":
                addLightningExtraDamageLore(lore);
                break;
            case "FIRE_DRAGON_ABILITY":
                addFireDragonAbilityLore(lore);
                break;
            case "ICE_DRAGON_ABILITY":
                addIceDragonAbilityLore(lore);
                break;
            case "LIGHTNING_DRAGON_ABILITY":
                addLightningDragonAbilityLore(lore);
                break;
        }
    }
}