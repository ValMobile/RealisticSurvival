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
package me.val_mobile.data.iceandfire;

import me.val_mobile.data.RSVFiles;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class UserConfigValues {

    private double fireChance = 0.2;
    private double fireUnderChance = 0.5;
    private double fireMinTemp = -0.5;
    private double fireMaxTemp = 999.9;
    private HashSet<Biome> fireBiomes = new HashSet<>();
    private double iceChance = 0.2;
    private double iceUnderChance = 0.5;
    private double iceMinTemp = -999.9;
    private double iceMaxTemp = -0.5;
    private HashSet<Biome> iceBiomes = new HashSet<>();
    private double lightChance = 0.2;
    private double lightUnderChance = 0.5;
    private double lightMinTemp = 999.9;
    private double lightMaxTemp = 999.9;
    private HashSet<Biome> lightBiomes = new HashSet<>();

    private double fireBreathChance = 0.2;
    private Material fireLayerBlock = Material.FIRE;
    private Material fireBurnBlock = Material.BLACKSTONE;
    private Material fireCharredBlock = Material.SMOOTH_BASALT;
    private int fireVelConst = 30;
    private int fireMinRad = 2;
    private int fireDespawnTicks = 200;
    private HashMap<Material, Material> fireSpecialBlocks = new HashMap<>();
    private Collection<Material> fireImmuneBlocks = new ArrayList<>();
    private double iceBreathChance = 0.2;
    private Material iceLayerBlock = Material.SNOW;
    private Material iceFrozenBlock = Material.PACKED_ICE;
    private int iceVelConst = 30;
    private int iceMinRad = 2;
    private int iceDespawnTicks = 200;
    private HashMap<Material, Material> iceSpecialBlocks = new HashMap<>();
    private Collection<Material> iceImmuneBlocks = new ArrayList<>();
    private double lightBreathChance = 0.2;
    private Material lightLayerBlock = Material.FIRE;
    private Material lightCrackledBlock = Material.BLACKSTONE;
    private int lightVelConst = 30;
    private int lightMinRad = 2;
    private int lightDespawnTicks = 200;
    private HashMap<Material, Material> lightSpecialBlocks = new HashMap<>();
    private Collection<Material> lightImmuneBlocks = new ArrayList<>();

    private boolean dragonCheckStage = true;
    private boolean dragonCheckLooting = false;
    private int minDragonscales = 12;
    private int minDragonbones = 6;
    private int minDragonBlood = 1;
    private int minDragonFlesh = 3;
    private boolean serpentCheckLooting = false;
    private int minSerpentScales = 12;
    private boolean shinyCheckLooting = true;
    private int minShinyScales = 1;
    private boolean witherCheckLooting = false;
    private int minWitherbones = 20;

    private int flamedFireTicks = 200;
    private double flamedBonusDmg = 8.0;
    private int icedSlowAmp = 4;
    private int icedSlowDur = 30;
    private int icedFrozenDur = 10;
    private double icedBonusDmg = 8.0;
    private Material icedBlock = Material.ICE;
    private double lightBoneDmg = 0.2;
    private int lightBoneAmt = 10;
    private double lightBoneBonusDmg = 4.0;
    private int fireSteelTicks = 400;
    private int iceSteelSlowAmp = 4;
    private int iceSteelSlowDur = 60;
    private int iceSteelFrozenDur = 10;
    private Material iceSteelBlock = Material.PACKED_ICE;
    private double lightSteelDmg = 0.4;
    private int lightSteelAmt = 20;

    private double steelDmgReduce = 0.2;
    private double scaleDmgReduce = 0.1;
    private int tideBreathAmp = 0;
    private double tideBreathDur = 270;
    private int tideStrAmp = 0;
    private int tideStrDur = 270;
    private int tideTime = 20;

    private double bonePickDmg = 6.0;
    private double bonePickSpd = 1.2;
    private double fireSteelPickDmg = 26.0;
    private double fireSteelPickSpd = 1.2;
    private double iceSteelPickDmg = 26.0;
    private double iceSteelPickSpd = 1.2;
    private double lightSteelPickDmg = 26.0;
    private double lightSteelPickSpd = 1.2;
    private double boneAxeDmg = 10.0;
    private double boneAxeSpd = 1.0;
    private double fireSteelAxeDmg = 30.0;
    private double fireSteelAxeSpd = 1.0;
    private double iceSteelAxeDmg = 30.0;
    private double iceSteelAxeSpeed = 1.0;
    private double lightSteelAxeDmg = 30.0;
    private double lightSteelAxeSpd = 1.0;
    private double boneShovelDmg = 6.5;
    private double boneShovelSpeed = 1.0;
    private double fireSteelShovelDmg = 26.5;
    private double fireSteelShovelSpd = 1.0;
    private double iceSteelShovelDmg = 26.5;
    private double iceSteelShovelSpd = 1.0;
    private double lightSteelShovelDmg = 26.5;
    private double lightSteelShovelSpd = 1.0;
    private double boneHoeDmg = 1.0;
    private double boneHoeSpd = 1.0;
    private double fireSteelHoeDmg = 2.0;
    private double fireSteelHoeSpd = 1.0;
    private double iceSteelHoeDmg = 2.0;
    private double iceSteelHoeSpd = 1.0;
    private double lightSteelHoeDmg = 2.0;
    private double lightSteelHoeSpd = 1.0;
    private double boneSwordDmg = 8.0;
    private double boneSwordSpd = 1.6;
    private double flamedSwordDmg = 9.5;
    private double flamedSwordSpd = 1.6;
    private double icedSwordDmg = 9.5;
    private double icedSwordSpd = 1.6;
    private double lightSwordDmg = 9.5;
    private double lightSwordSpd = 1.6;
    private double fireSteelSwordDmg = 25.0;
    private double fireSteelSwordSpd = 1.6;
    private double iceSteelSwordDmg = 25.0;
    private double iceSteelSwordSpd = 1.6;
    private double lightSteelSwordDmg = 25.0;
    private double lightSteelSwordSpd = 1.6;
    private double boneDmgMult = 1.75;
    private double boneVelMult = 1.75;

    private double scaleHelmetArmor = 5.0;
    private double scaleHelmetToughness = 2.0;
    private double tideHelmetArmor = 4.0;
    private double tideHelmetToughness = 2.5;
    private double fireSteelHelmetArmor = 7.0;
    private double fireSteelHelmetToughness = 6.0;
    private double iceSteelHelmetArmor = 7.0;
    private double iceSteelHelmetToughness = 6.0;
    private double lightSteelHelmetArmor = 7.0;
    private double lightSteelHelmetToughness = 6.0;
    private double scaleChestplateArmor = 9.0;
    private double scaleChestplateToughness = 2.0;
    private double tideChestplateArmor = 7.0;
    private double tideChestplateToughness = 2.5;
    private double fireSteelChestplateArmor = 12.0;
    private double fireSteelChestplateToughness = 6.0;
    private double iceSteelChestplateArmor = 12.0;
    private double iceSteelChestplateToughness = 6.0;
    private double lightSteelChestplateArmor = 12.0;
    private double lightSteelChestplateToughness = 6.0;
    private double scaleLeggingsArmor = 7.0;
    private double scaleLeggingsToughness = 2.0;
    private double tideLeggingsArmor = 8.0;
    private double tideLeggingsToughness = 2.5;
    private double fireSteelLeggingsArmor = 9.0;
    private double fireSteelLeggingsToughness = 6.0;
    private double iceSteelLeggingsArmor = 9.0;
    private double iceSteelLeggingsToughness = 6.0;
    private double lightSteelLeggingsArmor = 9.0;
    private double lightSteelLeggingsToughness = 6.0;
    private double scaleBootsArmor = 5.0;
    private double scaleBootsToughness = 2.0;
    private double tideBootsArmor = 4.0;
    private double tideBootsToughness = 2.5;
    private double fireSteelBootsArmor = 6.0;
    private double fireSteelBootsToughness = 6.0;
    private double iceSteelBootsArmor = 6.0;
    private double iceSteelBootsToughness = 6.0;
    private double lightSteelBootsArmor = 6.0;
    private double lightSteelBootsToughness = 6.0;

    public UserConfigValues(String id) {
        FileConfiguration config = RSVFiles.getIfUserConfig();

        switch (id) {
            case "1.2.3": {
                fireChance = config.getDouble("Dragons.WorldGen.FireDragon.Chance");
                fireUnderChance = config.getDouble("Dragons.WorldGen.FireDragon.UndergroundChance");
                fireMinTemp = config.getDouble("Dragons.WorldGen.FireDragon.MinBiomeTemp");
                fireMaxTemp = config.getDouble("Dragons.WorldGen.FireDragon.MaxBiomeTemp");

                for (String s : config.getStringList("Dragons.WorldGen.FireDragon.Biomes")) {
                    fireBiomes.add(Biome.valueOf(s));
                }

                iceChance = config.getDouble("Dragons.WorldGen.IceDragon.Chance");
                iceUnderChance = config.getDouble("Dragons.WorldGen.IceDragon.UndergroundChance");
                iceMinTemp = config.getDouble("Dragons.WorldGen.IceDragon.MinBiomeTemp");
                iceMaxTemp = config.getDouble("Dragons.WorldGen.IceDragon.MaxBiomeTemp");

                for (String s : config.getStringList("Dragons.WorldGen.IceDragon.Biomes")) {
                    iceBiomes.add(Biome.valueOf(s));
                }

                lightChance = config.getDouble("Dragons.WorldGen.LightningDragon.Chance");
                lightUnderChance = config.getDouble("Dragons.WorldGen.LightningDragon.UndergroundChance");
                lightMinTemp = config.getDouble("Dragons.WorldGen.LightningDragon.MinBiomeTemp");
                lightMaxTemp = config.getDouble("Dragons.WorldGen.LightningDragon.MaxBiomeTemp");

                for (String s : config.getStringList("Dragons.WorldGen.LightningDragon.Biomes")) {
                    lightBiomes.add(Biome.valueOf(s));
                }

                fireBreathChance = config.getDouble("Dragons.Behavior.FireDragon.BreathAttack.Chance");
                fireLayerBlock = Material.valueOf(config.getString("Dragons.Behavior.FireDragon.BreathAttack.LayerBlock"));
                fireBurnBlock = Material.valueOf(config.getString("Dragons.Behavior.FireDragon.BreathAttack.BurntBlock"));
                fireCharredBlock = Material.valueOf(config.getString("Dragons.Behavior.FireDragon.BreathAttack.CharredBlock"));
                fireVelConst = config.getInt("Dragons.Behavior.FireDragon.BreathAttack.VelocityConstant");
                fireMinRad = config.getInt("Dragons.Behavior.FireDragon.BreathAttack.MinimumRadius");
                fireDespawnTicks = config.getInt("Dragons.Behavior.FireDragon.BreathAttack.DespawnTime");

                for (String s : config.getConfigurationSection("Dragons.Behavior.FireDragon.BreathAttack.SpecialBlocks").getKeys(true)) {
                    fireSpecialBlocks.put(Material.valueOf(s), Material.valueOf(config.getString("Dragons.Behavior.FireDragon.BreathAttack.SpecialBlocks." + s)));
                }

                for (String s : config.getStringList("Dragons.Behavior.FireDragon.BreathAttack.ImmuneBlocks")) {
                    fireImmuneBlocks.add(Material.valueOf(s));
                }

                iceBreathChance = config.getDouble("Dragons.Behavior.IceDragon.BreathAttack.Chance");
                iceLayerBlock = Material.valueOf(config.getString("Dragons.Behavior.IceDragon.BreathAttack.LayerBlock"));
                iceFrozenBlock = Material.valueOf(config.getString("Dragons.Behavior.IceDragon.BreathAttack.FrozenBlock"));
                iceVelConst = config.getInt("Dragons.Behavior.IceDragon.BreathAttack.VelocityConstant");
                iceMinRad = config.getInt("Dragons.Behavior.IceDragon.BreathAttack.MinimumRadius");
                iceDespawnTicks = config.getInt("Dragons.Behavior.IceDragon.BreathAttack.DespawnTime");

                for (String s : config.getConfigurationSection("Dragons.Behavior.IceDragon.BreathAttack.SpecialBlocks").getKeys(true)) {
                    iceSpecialBlocks.put(Material.valueOf(s), Material.valueOf(config.getString("Dragons.Behavior.IceDragon.BreathAttack.SpecialBlocks." + s)));
                }

                for (String s : config.getStringList("Dragons.Behavior.IceDragon.BreathAttack.ImmuneBlocks")) {
                    iceImmuneBlocks.add(Material.valueOf(s));
                }

                lightBreathChance = config.getDouble("Dragons.Behavior.LightningDragon.BreathAttack.Chance");
                lightLayerBlock = Material.valueOf(config.getString("Dragons.Behavior.LightningDragon.BreathAttack.LayerBlock"));
                lightCrackledBlock = Material.valueOf(config.getString("Dragons.Behavior.LightningDragon.BreathAttack.CrackledBlock"));
                lightVelConst = config.getInt("Dragons.Behavior.LightningDragon.BreathAttack.VelocityConstant");
                lightMinRad = config.getInt("Dragons.Behavior.LightningDragon.BreathAttack.MinimumRadius");
                lightDespawnTicks = config.getInt("Dragons.Behavior.LightningDragon.BreathAttack.DespawnTime");

                for (String s : config.getConfigurationSection("Dragons.Behavior.LightningDragon.BreathAttack.SpecialBlocks").getKeys(true)) {
                    lightSpecialBlocks.put(Material.valueOf(s), Material.valueOf(config.getString("Dragons.Behavior.LightningDragon.BreathAttack.SpecialBlocks." + s)));
                }

                for (String s : config.getStringList("Dragons.Behavior.LightningDragon.BreathAttack.ImmuneBlocks")) {
                    lightImmuneBlocks.add(Material.valueOf(s));
                }

                dragonCheckStage = config.getBoolean("Dragons.Drops.CheckStage");
                dragonCheckLooting = config.getBoolean("Dragons.Drops.CheckLooting");
                minDragonscales = config.getInt("Dragons.Drops.Scales.Min");
                minDragonbones = config.getInt("Dragons.Drops.Bones.Min");
                minDragonBlood = config.getInt("Dragons.Drops.Blood.Min");
                minDragonFlesh = config.getInt("Dragons.Drops.Flesh.Min");
                serpentCheckLooting = config.getBoolean("ElderGuardian.SerpentScales.CheckLooting");
                minSerpentScales = config.getInt("ElderGuardian.SerpentScales.Min");
                shinyCheckLooting = config.getBoolean("Guardian.ShinyScales.CheckLooting");
                minShinyScales = config.getInt("Guardian.ShinyScales.Min");
                witherCheckLooting = config.getBoolean("Wither.Witherbones.CheckLooting");
                minWitherbones = config.getInt("Wither.Witherbones.Min");

                flamedFireTicks = config.getInt("Abilities.FlamedDragonbone.FireTicks");
                flamedBonusDmg = config.getDouble("Abilities.FlamedDragonbone.BonusDamage");
                icedSlowAmp = config.getInt("Abilities.IcedDragonbone.Slowness.Amplifier");
                icedSlowDur = config.getInt("Abilities.IcedDragonbone.Slowness.Duration");
                icedFrozenDur = config.getInt("Abilities.IcedDragonbone.FrozenDuration");
                icedBonusDmg = config.getInt("Abilities.IcedDragonbone.BonusDamage");
                icedBlock = Material.valueOf(config.getString("Abilities.IcedDragonbone.Block"));
                lightBoneDmg = config.getDouble("Abilities.LightningDragonbone.ShockDamage");
                lightBoneAmt = config.getInt("Abilities.LightningDragonbone.ShockAmount");
                lightBoneBonusDmg = config.getDouble("Abilities.LightningDragonbone.BonusDamage");
                fireSteelTicks = config.getInt("Abilities.FireDragonsteel.FireTicks");
                icedSlowAmp = config.getInt("Abilities.IceDragonsteel.Slowness.Amplifier");
                icedSlowDur = config.getInt("Abilities.IceDragonsteel.Slowness.Duration");
                iceSteelFrozenDur = config.getInt("Abilities.IceDragonsteel.FrozenDuration");
                iceSteelBlock = Material.valueOf(config.getString("Abilities.IceDragonsteel.Block"));
                lightSteelDmg = config.getInt("Abilities.LightningDragonsteel.ShockDamage");
                lightSteelAmt = config.getInt("Abilities.LightningDragonsteel.ShockAmount");

                steelDmgReduce = config.getDouble("Abilities.Dragonsteel.DamageReduction");
                scaleDmgReduce = config.getDouble("Abilities.Dragonscale.DamageReduction");
                tideBreathAmp = config.getInt("Abilities.TideGuardian.WaterBreathing.Amplifier");
                tideBreathDur = config.getInt("Abilities.TideGuardian.WaterBreathing.Duration");
                tideStrAmp = config.getInt("Abilities.TideGuardian.Strength.AmplifierPerArmorPiece");
                tideStrDur = config.getInt("Abilities.TideGuardian.Strength.Duration");
                tideTime = config.getInt("Abilities.TideGuardian.TickTime");

                bonePickDmg = config.getDouble("Pickaxe.Dragonbone.AttackDamage");
                bonePickSpd = config.getDouble("Pickaxe.Dragonbone.AttackSpeed");
                fireSteelPickDmg = config.getDouble("Pickaxe.FireDragonsteel.AttackDamage");
                fireSteelPickSpd = config.getDouble("Pickaxe.FireDragonsteel.AttackSpeed");
                iceSteelPickDmg = config.getDouble("Pickaxe.IceDragonsteel.AttackDamage");
                iceSteelPickSpd = config.getDouble("Pickaxe.IceDragonsteel.AttackSpeed");
                lightSteelPickDmg = config.getDouble("Pickaxe.LightningDragonsteel.AttackDamage");
                lightSteelPickSpd = config.getDouble("Pickaxe.LightningDragonsteel.AttackSpeed");
                boneAxeDmg = config.getDouble("Axe.Dragonbone.AttackDamage");
                boneAxeSpd = config.getDouble("Axe.Dragonbone.AttackSpeed");
                fireSteelAxeDmg = config.getDouble("Axe.FireDragonsteel.AttackDamage");
                fireSteelAxeSpd = config.getDouble("Axe.FireDragonsteel.AttackSpeed");
                iceSteelAxeDmg = config.getDouble("Axe.IceDragonsteel.AttackDamage");
                iceSteelAxeSpeed = config.getDouble("Axe.IceDragonsteel.AttackSpeed");
                lightSteelAxeDmg = config.getDouble("Axe.LightningDragonsteel.AttackDamage");
                lightSteelAxeSpd = config.getDouble("Axe.LightningDragonsteel.AttackSpeed");
                boneHoeDmg = config.getDouble("Hoe.Dragonbone.AttackDamage");
                boneHoeSpd = config.getDouble("Hoe.Dragonbone.AttackSpeed");
                fireSteelHoeDmg = config.getDouble("Hoe.FireDragonsteel.AttackDamage");
                fireSteelHoeSpd = config.getDouble("Hoe.FireDragonsteel.AttackSpeed");
                iceSteelHoeDmg = config.getDouble("Hoe.IceDragonsteel.AttackDamage");
                iceSteelHoeSpd = config.getDouble("Hoe.IceDragonsteel.AttackSpeed");
                lightSteelHoeDmg = config.getDouble("Hoe.LightningDragonsteel.AttackDamage");
                lightSteelHoeSpd = config.getDouble("Hoe.LightningDragonsteel.AttackSpeed");
                boneSwordDmg = config.getDouble("Sword.Dragonbone.AttackDamage");
                boneSwordSpd = config.getDouble("Sword.Dragonbone.AttackSpeed");
                flamedSwordDmg = config.getDouble("Sword.FlamedDragonbone.AttackDamage");
                flamedSwordSpd = config.getDouble("Sword.FlamedDragonbone.AttackSpeed");
                icedSwordDmg = config.getDouble("Sword.IcedDragonbone.AttackDamage");
                icedSwordSpd = config.getDouble("Sword.IcedDragonbone.AttackSpeed");
                lightSwordDmg = config.getDouble("Sword.LightningDragonbone.AttackDamage");
                lightSwordSpd = config.getDouble("Sword.LightningDragonbone.AttackSpeed");
                fireSteelSwordDmg = config.getDouble("Sword.FireDragonsteel.AttackDamage");
                fireSteelSwordSpd = config.getDouble("Sword.FireDragonsteel.AttackSpeed");
                iceSteelSwordDmg = config.getDouble("Sword.IceDragonsteel.AttackDamage");
                iceSteelSwordSpd = config.getDouble("Sword.IceDragonsteel.AttackSpeed");
                lightSteelSwordDmg = config.getDouble("Sword.LightningDragonsteel.AttackDamage");
                lightSteelSwordSpd = config.getDouble("Sword.LightningDragonsteel.AttackSpeed");
                boneDmgMult = config.getDouble("Bow.Dragonbone.AttackDamageMultiplier");
                boneVelMult = config.getDouble("Bow.Dragonbone.ArrowVelocityMultiplier");

                scaleHelmetArmor = config.getDouble("Helmet.Dragonscale.Armor");
                scaleHelmetToughness = config.getDouble("Helmet.Dragonscale.Toughness");
                tideHelmetArmor = config.getDouble("Helmet.TideGuardian.Armor");
                tideHelmetToughness = config.getDouble("Helmet.TideGuardian.Toughness");
                fireSteelHelmetArmor = config.getDouble("Helmet.FireDragonsteel.Armor");
                fireSteelHelmetToughness = config.getDouble("Helmet.FireDragonsteel.Toughness");
                iceSteelHelmetArmor = config.getDouble("Helmet.IceDragonsteel.Armor");
                iceSteelHelmetToughness = config.getDouble("Helmet.IceDragonsteel.Toughness");
                lightSteelHelmetArmor = config.getDouble("Helmet.LightningDragonsteel.Armor");
                lightSteelHelmetToughness = config.getDouble("Helmet.LightningDragonsteel.Toughness");
                scaleChestplateArmor = config.getDouble("Chestplate.Dragonscale.Armor");
                scaleChestplateToughness = config.getDouble("Chestplate.Dragonscale.Toughness");
                tideChestplateArmor = config.getDouble("Chestplate.TideGuardian.Armor");
                tideChestplateToughness = config.getDouble("Chestplate.TideGuardian.Toughness");
                fireSteelChestplateArmor = config.getDouble("Chestplate.FireDragonsteel.Armor");
                fireSteelChestplateToughness = config.getDouble("Chestplate.FireDragonsteel.Toughness");
                iceSteelChestplateArmor = config.getDouble("Chestplate.IceDragonsteel.Armor");
                iceSteelChestplateToughness = config.getDouble("Chestplate.IceDragonsteel.Toughness");
                lightSteelChestplateArmor = config.getDouble("Chestplate.LightningDragonsteel.Armor");
                lightSteelChestplateToughness = config.getDouble("Chestplate.LightningDragonsteel.Toughness");
                scaleLeggingsArmor = config.getDouble("Leggings.Dragonscale.Armor");
                scaleLeggingsToughness = config.getDouble("Leggings.Dragonscale.Toughness");
                tideLeggingsArmor = config.getDouble("Leggings.TideGuardian.Armor");
                tideLeggingsToughness = config.getDouble("Leggings.TideGuardian.Toughness");
                fireSteelLeggingsArmor = config.getDouble("Leggings.FireDragonsteel.Armor");
                fireSteelLeggingsToughness = config.getDouble("Leggings.FireDragonsteel.Toughness");
                iceSteelLeggingsArmor = config.getDouble("Leggings.IceDragonsteel.Armor");
                iceSteelLeggingsToughness = config.getDouble("Leggings.IceDragonsteel.Toughness");
                lightSteelLeggingsArmor = config.getDouble("Leggings.LightningDragonsteel.Armor");
                lightSteelLeggingsToughness = config.getDouble("Leggings.LightningDragonsteel.Toughness");
                scaleBootsArmor = config.getDouble("Boots.Dragonscale.Armor");
                scaleBootsToughness = config.getDouble("Boots.Dragonscale.Toughness");
                tideBootsArmor = config.getDouble("Boots.TideGuardian.Armor");
                tideBootsToughness = config.getDouble("Boots.TideGuardian.Toughness");
                fireSteelBootsArmor = config.getDouble("Boots.FireDragonsteel.Armor");
                fireSteelBootsToughness = config.getDouble("Boots.FireDragonsteel.Toughness");
                iceSteelBootsArmor = config.getDouble("Boots.IceDragonsteel.Armor");
                iceSteelBootsToughness = config.getDouble("Boots.IceDragonsteel.Toughness");
                lightSteelBootsArmor = config.getDouble("Boots.LightningDragonsteel.Armor");
                lightSteelBootsToughness = config.getDouble("Boots.LightningDragonsteel.Toughness");
            }
            default: {

            }
        }
    }
}
