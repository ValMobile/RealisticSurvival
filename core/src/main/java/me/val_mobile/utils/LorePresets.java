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
package me.val_mobile.utils;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LorePresets {

    private static final FileConfiguration CONFIG = RealisticSurvivalPlugin.getLorePresetConfig();

    public static void addRapierLore(List<String> lore, ConfigurationSection section) {
        double percentAbsorbed = section.getDouble("Protection.PercentAbsorbed") * 100D;
        int durabilityTaken = section.getInt("Protection.DamageDurability");
        int damageBonus = (int) (section.getDouble("UnarmoredDamageMultiplier") * 100D) - 100;

        List<String> lines = CONFIG.getStringList("Rapier");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_ABSORBED%", new DecimalFormat("##.#").format(percentAbsorbed));
            line = line.replaceAll("%DURABILITY_TAKEN%", String.valueOf(durabilityTaken));
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addKatanaLore(List<String> lore, ConfigurationSection section) {
        int damageBonus = (int) (section.getDouble("ChestDamageMultiplier") * 100D) - 100;

        List<String> lines = CONFIG.getStringList("Katana");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addGreatswordLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = section.getDouble("SweepingDamageMultiplier") * 100D;

        List<String> lines = CONFIG.getStringList("Greatsword");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("###.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLongswordLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = section.getDouble("SweepingDamageMultiplier") * 100D;

        List<String> lines = CONFIG.getStringList("Longsword");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("###.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addSpearLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Spear");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addSaberLore(List<String> lore, ConfigurationSection section) {
        double percentAbsorbed = section.getDouble("Protection.PercentAbsorbed") * 100D;
        int durabilityTaken = section.getInt("Protection.DamageDurability");
        int damageBonus = (int) (section.getDouble("ChestDamageMultiplier") * 100D) - 100;

        List<String> lines = CONFIG.getStringList("Saber");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_ABSORBED%", new DecimalFormat("##.#").format(percentAbsorbed));
            line = line.replaceAll("%DURABILITY_TAKEN%", String.valueOf(durabilityTaken));
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBoomerangLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Boomerang");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addDaggerLore(List<String> lore, ConfigurationSection section) {
        int damageBonus = (int) (section.getDouble("BackstabDamageMultiplier") * 100D) - 100;

        List<String> lines = CONFIG.getStringList("Dagger");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addGlaiveLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = section.getDouble("SweepingDamageMultiplier") * 100D;

        List<String> lines = CONFIG.getStringList("Glaive");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("###.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addHalberdLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = section.getDouble("ShieldBreachChance") * 100D - 100D;

        List<String> lines = CONFIG.getStringList("Halberd");

        for (String line : lines) {
            line = line.replaceAll("%SHIELD_BREACH%", new DecimalFormat("##.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addHammerLore(List<String> lore, ConfigurationSection section) {
        int amplifier = section.getInt("Nausea.Amplifier") + 1;
        int duration = section.getInt("Nausea.Duration");

        List<String> lines = CONFIG.getStringList("Hammer");

        for (String line : lines) {
            line = line.replaceAll("%NAUSEA_AMPLIFIER%", Utils.toRomanNumeral(amplifier));
            line = line.replaceAll("%NAUSEA_DURATION%", new DecimalFormat("##.#").format(duration / 20D));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addJavelinLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = (section.getDouble("ThrownAttributes.AttackDamage") / section.getDouble("Attributes.AttackDamage")) * 100D - 100D;

        List<String> lines = CONFIG.getStringList("Javelin");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("###.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLanceLore(List<String> lore, ConfigurationSection section) {
        int damageBonus = (int) (section.getDouble("RidingDamageBonus") * 100D) - 100;

        List<String> lines = CONFIG.getStringList("Lance");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addMaceLore(List<String> lore, ConfigurationSection section) {
        int damageBonus = (int) (section.getDouble("UndeadDamageMultiplier") * 100D) - 100;

        List<String> lines = CONFIG.getStringList("Mace");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addPikeLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Pike");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addQuarterstaffLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = section.getDouble("SweepingDamageMultiplier") * 100D;

        List<String> lines = CONFIG.getStringList("Quarterstaff");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("##.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addTomahawkLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = (section.getDouble("ThrownAttributes.AttackDamage") / section.getDouble("Attributes.AttackDamage")) * 100D - 100D;

        List<String> lines = CONFIG.getStringList("Tomahawk");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("###.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addThrowingKnifeLore(List<String> lore, ConfigurationSection section) {
        double damageBonus = (section.getDouble("ThrownAttributes.AttackDamage") / section.getDouble("Attributes.AttackDamage")) * 100D - 100D;

        List<String> lines = CONFIG.getStringList("ThrowingKnife");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", new DecimalFormat("###.#").format(damageBonus));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addWarhammerLore(List<String> lore, ConfigurationSection section) {
        double percentAbsorbed = section.getDouble("ArmorPiercing") * 100D;

        List<String> lines = CONFIG.getStringList("Warhammer");

        for (String line : lines) {
            line = line.replaceAll("%ARMOR_PIERCING%", new DecimalFormat("##.#").format(percentAbsorbed));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBattleaxeLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Battleaxe");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addClubLore(List<String> lore, ConfigurationSection section) {
        int amplifier = section.getInt("Nausea.Amplifier") + 1;
        int duration = section.getInt("Nausea.Duration");

        List<String> lines = CONFIG.getStringList("Club");

        for (String line : lines) {
            line = line.replaceAll("%NAUSEA_AMPLIFIER%", Utils.toRomanNumeral(amplifier));
            line = line.replaceAll("%NAUSEA_DURATION%", new DecimalFormat("##.#").format(duration / 20D));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addCestusLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Cestus");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addCrossbowLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Crossbow");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLongbowLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("Longbow");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addFlamedDragonboneLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("FlamedDragonbone");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addIcedDragonboneLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("IcedDragonbone");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLightningDragonboneLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("LightningDragonbone");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addFireDragonsteelLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("FireDragonsteel");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addIceDragonsteelLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("IceDragonsteel");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLightningDragonsteelLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("LightningDragonsteel");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addDragonSkullLore(ItemStack item, int stage, String breed) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = (!(meta.getLore() == null || meta.getLore().isEmpty())) ? meta.getLore() : new ArrayList<>();

        List<String> lines = CONFIG.getStringList("DragonSkull");

        for (String line : lines) {
            line = line.replaceAll("%BREED%", StringUtils.capitalize(breed.toLowerCase()));
            line = line.replaceAll("%STAGE%", String.valueOf(stage));

            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public static void addBlueDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("BlueDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBronzeDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("BronzeDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addGrayDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("GrayDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addGreenDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("GreenDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addRedDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("RedDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addSapphireDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("SapphireDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addSilverDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("SilverDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addWhiteDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("WhiteDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addAmethystDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("AmethystDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBlackDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("BlackDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addCopperDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("CopperDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        };
    }

    public static void addElectricDragonscaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("ElectricDragonscale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBlueSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("BlueSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBronzeSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("BronzeSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addDeepblueSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("DeepBlueSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addGreenSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("GreenSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addPurpleSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("PurpleSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addRedSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("RedSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addTealSeaSerpentScaleLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("TealSeaSerpentScale");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addDragonProtectionLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("DragonProtection");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addTideGuardianBreathingLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("TideGuardianBreathing");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLegendaryWeaponLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("LegendaryWeapon");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addFlamedExtraDamageLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("FlamedExtraDamage");

        double bonusDamage = section.getDouble("DragonBonusDamage");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf((int) Math.round(bonusDamage)));
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addIcedExtraDamageLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("IcedExtraDamage");

        double bonusDamage = section.getDouble("DragonBonusDamage");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf((int) Math.round(bonusDamage)));
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLightningExtraDamageLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("LightningExtraDamage");

        double bonusDamage = section.getDouble("DragonBonusDamage");

        for (String line : lines) {
            line = line.replaceAll("%DAMAGE_BONUS%", String.valueOf((int) Math.round(bonusDamage)));
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addWeaponLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Weapon");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addHelmetLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Helmet");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addChestplateLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Chestplate");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addLeggingsLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Leggings");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addBootsLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Boots");

        for (String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    public static void addGearLore(List<String> lore, Material material) {
        lore.add("");
        if (Utils.isArmor(material)) {
            if (Utils.isHelmet(material)) {
                addHelmetLore(lore);
            }
            else if (Utils.isChestplate(material)) {
                addChestplateLore(lore);
            }
            else if (Utils.isLeggings(material)) {
                addLeggingsLore(lore);
            }
            else if (Utils.isBoots(material)) {
                addBootsLore(lore);
            }
        }
        else {
            addWeaponLore(lore);
        }
    }

    public static void addGearStats(List<String> lore, Attribute atr, Double value) {
        switch (atr) {
            case GENERIC_ATTACK_DAMAGE -> {
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value.intValue() + " Attack Damage"));
                } else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value + " Attack Damage"));
                }
            }
            case GENERIC_ATTACK_SPEED -> {
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value.intValue() + " Attack Speed"));
                } else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&2 " + value + " Attack Speed"));
                }
            }
            case GENERIC_ARMOR -> {
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9+" + value.intValue() + " Armor"));
                } else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9+" + value + " Armor"));
                }
            }
            case GENERIC_ARMOR_TOUGHNESS -> {
                if (Math.floor(value) == value) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9+" + value.intValue() + " Armor Toughness"));
                } else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9+" + value + " Armor Toughness"));
                }
            }
        }
    }

    public static void useLorePreset(List<String> lore, String weaponType, ConfigurationSection section) {
        switch (weaponType) {
            case "RAPIER" -> addRapierLore(lore, section);
            case "SABER" -> addSaberLore(lore, section);
            case "KATANA" -> addKatanaLore(lore, section);
            case "GREATSWORD" -> addGreatswordLore(lore, section);
            case "LONGSWORD" -> addLongswordLore(lore, section);
            case "SPEAR" -> addSpearLore(lore, section);
            case "GLAIVE" -> addGlaiveLore(lore, section);
            case "BOOMERANG" -> addBoomerangLore(lore, section);
            case "DAGGER" -> addDaggerLore(lore, section);
            case "HALBERD" -> addHalberdLore(lore, section);
            case "HAMMER" -> addHammerLore(lore, section);
            case "JAVELIN" -> addJavelinLore(lore, section);
            case "LANCE" -> addLanceLore(lore, section);
            case "MACE" -> addMaceLore(lore, section);
            case "PIKE" -> addPikeLore(lore, section);
            case "QUARTERSTAFF" -> addQuarterstaffLore(lore, section);
            case "TOMAHAWK" -> addTomahawkLore(lore, section);
            case "THROWING_KNIFE" -> addThrowingKnifeLore(lore, section);
            case "WARHAMMER" -> addWarhammerLore(lore, section);
            case "BATTLEAXE" -> addBattleaxeLore(lore, section);
            case "CLUB" -> addClubLore(lore, section);
            case "CESTUS" -> addCestusLore(lore, section);
            case "LONGBOW" -> addLongbowLore(lore, section);
            case "CROSSBOW" -> addCrossbowLore(lore, section);
            case "FLAMED_DRAGONBONE" -> addFlamedDragonboneLore(lore, section);
            case "ICED_DRAGONBONE" -> addIcedDragonboneLore(lore, section);
            case "LIGHTNING_DRAGONBONE" -> addLightningDragonboneLore(lore, section);
            case "FIRE_DRAGONSTEEL" -> addFireDragonsteelLore(lore, section);
            case "ICE_DRAGONSTEEL" -> addIceDragonsteelLore(lore, section);
            case "LIGHTNING_DRAGONSTEEL" -> addLightningDragonsteelLore(lore, section);
            case "BLUE_DRAGON_SCALE" -> addBlueDragonscaleLore(lore, section);
            case "BRONZE_DRAGON_SCALE" -> addBronzeDragonscaleLore(lore, section);
            case "GRAY_DRAGON_SCALE" -> addGrayDragonscaleLore(lore, section);
            case "GREEN_DRAGON_SCALE" -> addGreenDragonscaleLore(lore, section);
            case "RED_DRAGON_SCALE" -> addRedDragonscaleLore(lore, section);
            case "SAPPHIRE_DRAGON_SCALE" -> addSapphireDragonscaleLore(lore, section);
            case "SILVER_DRAGON_SCALE" -> addSilverDragonscaleLore(lore, section);
            case "WHITE_DRAGON_SCALE" -> addWhiteDragonscaleLore(lore, section);
            case "AMETHYST_DRAGON_SCALE" -> addAmethystDragonscaleLore(lore, section);
            case "BLACK_DRAGON_SCALE" -> addBlackDragonscaleLore(lore, section);
            case "COPPER_DRAGON_SCALE" -> addCopperDragonscaleLore(lore, section);
            case "ELECTRIC_DRAGON_SCALE" -> addElectricDragonscaleLore(lore, section);
            case "BLUE_SEA_SERPENT_SCALE" -> addBlueSeaSerpentScaleLore(lore, section);
            case "BRONZE_SEA_SERPENT_SCALE" -> addBronzeSeaSerpentScaleLore(lore, section);
            case "DEEPBLUE_SEA_SERPENT_SCALE" -> addDeepblueSeaSerpentScaleLore(lore, section);
            case "GREEN_SEA_SERPENT_SCALE" -> addGreenSeaSerpentScaleLore(lore, section);
            case "PURPLE_SEA_SERPENT_SCALE" -> addPurpleSeaSerpentScaleLore(lore, section);
            case "RED_SEA_SERPENT_SCALE" -> addRedSeaSerpentScaleLore(lore, section);
            case "TEAL_SEA_SERPENT_SCALE" -> addTealSeaSerpentScaleLore(lore, section);
            case "DRAGON_PROTECTION" -> addDragonProtectionLore(lore, section);
            case "TIDE_GUARDIAN_BREATHING" -> addTideGuardianBreathingLore(lore, section);
            case "LEGENDARY_WEAPON" -> addLegendaryWeaponLore(lore, section);
            case "FLAMED_EXTRA_DAMAGE" -> addFlamedExtraDamageLore(lore, section);
            case "ICED_EXTRA_DAMAGE" -> addIcedExtraDamageLore(lore, section);
            case "LIGHTNING_EXTRA_DAMAGE" -> addLightningExtraDamageLore(lore, section);
        }
    }
}