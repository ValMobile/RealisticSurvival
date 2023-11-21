/*
    Copyright (C) 2023  Val_Mobile

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
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LorePresets {

    private static final FileConfiguration CONFIG = RSVPlugin.getLorePresetConfig();

    public static void addRapierLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double percentAbsorbed = section.getDouble("Protection.PercentAbsorbed");
        int durabilityTaken = section.getInt("Protection.DamageDurability");
        double damageBonus = section.getDouble("UnarmoredDamageMultiplier") - 1D;

        List<String> lines = CONFIG.getStringList("Rapier");

        Map<String, Object> placeholders = Map.of("DAMAGE_ABSORBED", dfpercent.format(percentAbsorbed), "DURABILITY_TAKEN", df.format(durabilityTaken), "DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addKatanaLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("ChestDamageMultiplier") - 1D;

        List<String> lines = CONFIG.getStringList("Katana");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addGreatswordLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("SweepingDamageMultiplier");

        List<String> lines = CONFIG.getStringList("Greatsword");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addLongswordLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("SweepingDamageMultiplier");

        List<String> lines = CONFIG.getStringList("Longsword");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addSpearLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Spear");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addSaberLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double percentAbsorbed = section.getDouble("Protection.PercentAbsorbed");
        int durabilityTaken = section.getInt("Protection.DamageDurability");
        double damageBonus = section.getDouble("ChestDamageMultiplier") - 1D;

        List<String> lines = CONFIG.getStringList("Saber");

        Map<String, Object> placeholders = Map.of("DAMAGE_ABSORBED", dfpercent.format(percentAbsorbed), "DURABILITY_TAKEN", df.format(durabilityTaken), "DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addBoomerangLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Boomerang");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addDaggerLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("BackstabDamageMultiplier") - 1D;

        List<String> lines = CONFIG.getStringList("Dagger");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addGlaiveLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("SweepingDamageMultiplier");

        List<String> lines = CONFIG.getStringList("Glaive");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addHalberdLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("ShieldBreachChance") - 1D;

        List<String> lines = CONFIG.getStringList("Halberd");

        Map<String, Object> placeholders = Map.of("SHIELD_BREACH", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addHammerLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        int amplifier = section.getInt("Nausea.Amplifier") + 1;
        int duration = section.getInt("Nausea.Duration");

        List<String> lines = CONFIG.getStringList("Hammer");

        Map<String, Object> placeholders = Map.of("NAUSEA_AMPLIFIER", Utils.toRomanNumeral(amplifier), "NAUSEA_DURATION", df.format(duration / 20D));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addJavelinLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = (section.getDouble("ThrownAttributes.AttackDamage") / section.getDouble("Attributes.AttackDamage")) - 1D;

        List<String> lines = CONFIG.getStringList("Javelin");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addLanceLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("RidingDamageBonus") - 1D;

        List<String> lines = CONFIG.getStringList("Lance");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addMaceLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("UndeadDamageMultiplier") - 1D;

        List<String> lines = CONFIG.getStringList("Mace");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addPikeLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Pike");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addQuarterstaffLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = section.getDouble("SweepingDamageMultiplier");

        List<String> lines = CONFIG.getStringList("Quarterstaff");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addTomahawkLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = (section.getDouble("ThrownAttributes.AttackDamage") / section.getDouble("Attributes.AttackDamage")) - 1D;

        List<String> lines = CONFIG.getStringList("Tomahawk");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addThrowingKnifeLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double damageBonus = (section.getDouble("ThrownAttributes.AttackDamage") / section.getDouble("Attributes.AttackDamage")) - 1D;

        List<String> lines = CONFIG.getStringList("ThrowingKnife");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", dfpercent.format(damageBonus));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addWarhammerLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat dfpercent = new DecimalFormat("0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double percentAbsorbed = section.getDouble("ArmorPiercing");

        List<String> lines = CONFIG.getStringList("Warhammer");

        Map<String, Object> placeholders = Map.of("ARMOR_PIERCING", dfpercent.format(percentAbsorbed));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addBattleaxeLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Battleaxe");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addClubLore(List<String> lore, ConfigurationSection section) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        int amplifier = section.getInt("Nausea.Amplifier") + 1;
        int duration = section.getInt("Nausea.Duration");

        List<String> lines = CONFIG.getStringList("Club");

        Map<String, Object> placeholders = Map.of("NAUSEA_AMPLIFIER", Utils.toRomanNumeral(amplifier), "NAUSEA_DURATION", df.format(duration / 20D));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addCestusLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Cestus");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addCrossbowLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Crossbow");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addLongbowLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Longbow");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addFlamedDragonboneLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("FlamedDragonbone");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addIcedDragonboneLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("IcedDragonbone");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addLightningDragonboneLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("LightningDragonbone");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addFireDragonsteelLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("FireDragonsteel");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addIceDragonsteelLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("IceDragonsteel");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addLightningDragonsteelLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("LightningDragonsteel");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addDragonSkullLore(ItemStack item, int stage, String breed) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = (!(meta.getLore() == null || meta.getLore().isEmpty())) ? meta.getLore() : new ArrayList<>();

        List<String> lines = CONFIG.getStringList("DragonSkull");

        Map<String, Object> placeholders = Map.of("BREED", StringUtils.capitalize(breed.toLowerCase()), "STAGE", String.valueOf(stage));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));

        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public static void addBlueDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("BlueDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addBronzeDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("BronzeDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addGrayDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("GrayDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addGreenDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("GreenDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addRedDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("RedDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addSapphireDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("SapphireDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addSilverDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("SilverDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addWhiteDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("WhiteDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addAmethystDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("AmethystDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addBlackDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("BlackDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addCopperDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("CopperDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addElectricDragonscaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("ElectricDragonscale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addBlueSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("BlueSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addBronzeSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("BronzeSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addDeepblueSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("DeepBlueSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addGreenSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("GreenSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addPurpleSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("PurpleSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addRedSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("RedSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addTealSeaSerpentScaleLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("TealSeaSerpentScale");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addDragonProtectionLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("DragonProtection");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addTideGuardianBreathingLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("TideGuardianBreathing");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addLegendaryWeaponLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("LegendaryWeapon");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addFlamedExtraDamageLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("FlamedExtraDamage");

        double bonusDamage = section.getDouble("DragonBonusDamage");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", String.valueOf((int) Math.round(bonusDamage)));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addIcedExtraDamageLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("IcedExtraDamage");

        double bonusDamage = section.getDouble("DragonBonusDamage");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", String.valueOf((int) Math.round(bonusDamage)));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addLightningExtraDamageLore(List<String> lore, ConfigurationSection section) {
        List<String> lines = CONFIG.getStringList("LightningExtraDamage");

        double bonusDamage = section.getDouble("DragonBonusDamage");

        Map<String, Object> placeholders = Map.of("DAMAGE_BONUS", String.valueOf((int) Math.round(bonusDamage)));

        lore.addAll(Utils.translateMsgs(lines, null, placeholders));
    }

    public static void addWeaponLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Weapon");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addHelmetLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Helmet");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addChestplateLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Chestplate");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addLeggingsLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Leggings");

        lore.addAll(Utils.translateMsgs(lines, null, null));
    }

    public static void addBootsLore(List<String> lore) {
        List<String> lines = CONFIG.getStringList("Boots");

        lore.addAll(Utils.translateMsgs(lines, null, null));
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

    public static void addGearStats(List<String> lore, Attribute atr, double value) {
        DecimalFormat df = new DecimalFormat("0.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        if (!Utils.doublesEquals(value, 0D)) {
            switch (atr) {
                case GENERIC_ATTACK_DAMAGE -> lore.add(Utils.translateMsg("&2 " + df.format(value) + " Attack Damage", null, null));
                case GENERIC_ATTACK_SPEED -> lore.add(Utils.translateMsg("&2 " + df.format(value) + " Attack Speed", null, null));
                case GENERIC_ARMOR -> lore.add(Utils.translateMsg("&9+" + df.format(value) + " Armor", null, null));
                case GENERIC_ARMOR_TOUGHNESS -> lore.add(Utils.translateMsg("&9+" + df.format(value) + " Armor Toughness", null, null));
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
            case "SPEAR" -> addSpearLore(lore);
            case "GLAIVE" -> addGlaiveLore(lore, section);
            case "BOOMERANG" -> addBoomerangLore(lore);
            case "DAGGER" -> addDaggerLore(lore, section);
            case "HALBERD" -> addHalberdLore(lore, section);
            case "HAMMER" -> addHammerLore(lore, section);
            case "JAVELIN" -> addJavelinLore(lore, section);
            case "LANCE" -> addLanceLore(lore, section);
            case "MACE" -> addMaceLore(lore, section);
            case "PIKE" -> addPikeLore(lore);
            case "QUARTERSTAFF" -> addQuarterstaffLore(lore, section);
            case "TOMAHAWK" -> addTomahawkLore(lore, section);
            case "THROWING_KNIFE" -> addThrowingKnifeLore(lore, section);
            case "WARHAMMER" -> addWarhammerLore(lore, section);
            case "BATTLEAXE" -> addBattleaxeLore(lore);
            case "CLUB" -> addClubLore(lore, section);
            case "CESTUS" -> addCestusLore(lore);
            case "LONGBOW" -> addLongbowLore(lore);
            case "CROSSBOW" -> addCrossbowLore(lore);
            case "FLAMED_DRAGONBONE" -> addFlamedDragonboneLore(lore);
            case "ICED_DRAGONBONE" -> addIcedDragonboneLore(lore);
            case "LIGHTNING_DRAGONBONE" -> addLightningDragonboneLore(lore);
            case "FIRE_DRAGONSTEEL" -> addFireDragonsteelLore(lore);
            case "ICE_DRAGONSTEEL" -> addIceDragonsteelLore(lore);
            case "LIGHTNING_DRAGONSTEEL" -> addLightningDragonsteelLore(lore);
            case "BLUE_DRAGON_SCALE" -> addBlueDragonscaleLore(lore);
            case "BRONZE_DRAGON_SCALE" -> addBronzeDragonscaleLore(lore);
            case "GRAY_DRAGON_SCALE" -> addGrayDragonscaleLore(lore);
            case "GREEN_DRAGON_SCALE" -> addGreenDragonscaleLore(lore);
            case "RED_DRAGON_SCALE" -> addRedDragonscaleLore(lore);
            case "SAPPHIRE_DRAGON_SCALE" -> addSapphireDragonscaleLore(lore);
            case "SILVER_DRAGON_SCALE" -> addSilverDragonscaleLore(lore);
            case "WHITE_DRAGON_SCALE" -> addWhiteDragonscaleLore(lore);
            case "AMETHYST_DRAGON_SCALE" -> addAmethystDragonscaleLore(lore);
            case "BLACK_DRAGON_SCALE" -> addBlackDragonscaleLore(lore);
            case "COPPER_DRAGON_SCALE" -> addCopperDragonscaleLore(lore);
            case "ELECTRIC_DRAGON_SCALE" -> addElectricDragonscaleLore(lore);
            case "BLUE_SEA_SERPENT_SCALE" -> addBlueSeaSerpentScaleLore(lore);
            case "BRONZE_SEA_SERPENT_SCALE" -> addBronzeSeaSerpentScaleLore(lore);
            case "DEEPBLUE_SEA_SERPENT_SCALE" -> addDeepblueSeaSerpentScaleLore(lore);
            case "GREEN_SEA_SERPENT_SCALE" -> addGreenSeaSerpentScaleLore(lore);
            case "PURPLE_SEA_SERPENT_SCALE" -> addPurpleSeaSerpentScaleLore(lore);
            case "RED_SEA_SERPENT_SCALE" -> addRedSeaSerpentScaleLore(lore);
            case "TEAL_SEA_SERPENT_SCALE" -> addTealSeaSerpentScaleLore(lore);
            case "DRAGON_PROTECTION" -> addDragonProtectionLore(lore);
            case "TIDE_GUARDIAN_BREATHING" -> addTideGuardianBreathingLore(lore);
            case "LEGENDARY_WEAPON" -> addLegendaryWeaponLore(lore);
            case "FLAMED_EXTRA_DAMAGE" -> addFlamedExtraDamageLore(lore, section);
            case "ICED_EXTRA_DAMAGE" -> addIcedExtraDamageLore(lore, section);
            case "LIGHTNING_EXTRA_DAMAGE" -> addLightningExtraDamageLore(lore, section);
        }
    }
}