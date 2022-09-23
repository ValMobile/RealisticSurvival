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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Objects;

public class LightningBreath extends Breath {

    public LightningBreath(LightningDragon dragon, Location target, RealisticSurvivalPlugin plugin) {
        super(dragon, target, plugin);
    }

    @Override
    public void grief(Location center, int radius) {
        World world = center.getWorld();

        Location loc;
        Location secondLoc;
        Block block;
        Material blockMaterial;
        Material electrified;

        Block secondBlock;

        for (int x = -radius; x < radius; x++) {
            for (int y = -radius; y < radius; y++) {
                for (int z = -radius; z < radius; z++) {
                    // if the location is within the specified radius
                    if (!(Math.hypot(Math.hypot(x, y), z) > radius)) {

                        // store the upper and lower block info
                        loc = center.clone().add(x, y, z);
                        secondLoc = center.clone().add(x, y - 1, z);
                        block = loc.getBlock();
                        blockMaterial = block.getType();
                        secondBlock = secondLoc.getBlock();

                        // if the upper block is air or translucent like grass
                        if (block.isEmpty() || !blockMaterial.isOccluding()) {
                            if (!config.getStringList("Dragons.LightningDragon.BreathAttack.ImmuneBlocks").contains(blockMaterial.toString())) {
                                if (!secondBlock.isEmpty()) {
                                    electrified = Objects.requireNonNull(config.getConfigurationSection("Dragons.LightningDragon.BreathAttack.SpecialBlocks")).getKeys(false).contains(blockMaterial.toString())
                                            ? Material.valueOf(config.getString("Dragons.LightningDragon.BreathAttack.SpecialBlocks." + blockMaterial))
                                            : Material.valueOf(config.getString("Dragons.LightningDragon.BreathAttack.LayerBlock"));
                                    world.getBlockAt(loc).setType(electrified);
                                }
                            }
                        }
                        // if the upper block is solid
                        else {
                            // check if the upper block is immune to fire breath attacks
                            if (!config.getStringList("Dragons.LightningDragon.BreathAttack.ImmuneBlocks").contains(blockMaterial.toString())) {
                                if (!secondBlock.isEmpty()) {
                                    electrified = Objects.requireNonNull(config.getConfigurationSection("Dragons.LightningDragon.BreathAttack.SpecialBlocks")).getKeys(false).contains(blockMaterial.toString())
                                            ? Material.valueOf(config.getString("Dragons.LightningDragon.BreathAttack.SpecialBlocks." + blockMaterial))
                                            : Material.valueOf(config.getString("Dragons.LightningDragon.BreathAttack.FrozenBlock"));
                                    world.getBlockAt(loc).setType(electrified);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}