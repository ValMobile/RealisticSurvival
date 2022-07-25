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
package me.val_mobile.iceandfire;

import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.math.BlockVector3;
import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

import java.util.Random;

public class DragonWorldGenEvents extends ModuleEvents implements Listener {

    private static final int CHUNK_LENGTH = 16;

    private final RealisticSurvivalPlugin plugin;
    private final Utils util;

    public DragonWorldGenEvents(RSVModule module, RealisticSurvivalPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
        this.util = new Utils(plugin);
    }

    @EventHandler
    public void onChunkGenerate(ChunkPopulateEvent event) {
        if (shouldEventBeRan(event.getWorld())) {
            World world = event.getWorld();
            // check if the chunk was generated in the overworld
            if (world.getEnvironment().equals(World.Environment.NORMAL)) {
                Chunk chunk = event.getChunk(); // get chunk

                Block middleBlock = chunk.getBlock(CHUNK_LENGTH / 2, world.getHighestBlockYAt(chunk.getX() * CHUNK_LENGTH + CHUNK_LENGTH / 2, chunk.getZ() * CHUNK_LENGTH + CHUNK_LENGTH / 2), CHUNK_LENGTH / 2); // get the block in the middle of the chunk

                Location loc = middleBlock.getLocation();

                Biome biome = middleBlock.getBiome(); // get the biome of the block which is also the biome of the chunk

                Random r = new Random();

                switch (biome) {
                    // check if biome is a jungle, badlands, or savanna
                    case JUNGLE:
                    case JUNGLE_HILLS:
                    case JUNGLE_EDGE:
                    case BAMBOO_JUNGLE:
                    case BAMBOO_JUNGLE_HILLS:
                    case MODIFIED_JUNGLE:
                    case MODIFIED_JUNGLE_EDGE:
                    case BADLANDS:
                    case BADLANDS_PLATEAU:
                    case ERODED_BADLANDS:
                    case MODIFIED_BADLANDS_PLATEAU:
                    case SAVANNA:
                    case SAVANNA_PLATEAU:
                    case SHATTERED_SAVANNA:
                    case SHATTERED_SAVANNA_PLATEAU: {
                        // generate lightning dragon nest

                    }
                    case OCEAN:
                    case COLD_OCEAN:
                    case DEEP_COLD_OCEAN:
                    case DEEP_FROZEN_OCEAN:
                    case DEEP_LUKEWARM_OCEAN:
                    case DEEP_OCEAN:
                    case DEEP_WARM_OCEAN:
                    case FROZEN_OCEAN:
                    case LUKEWARM_OCEAN:
                    case WARM_OCEAN: {

                    }
                    default: {
                        double temperature = middleBlock.getTemperature(); // get temperature of chunk

                        // check if biome is warm
                        if (temperature > -0.5) {
                            // generate fire dragon nest

                            if (r.nextDouble() <= 0.1) {
                                RSVFiles.getFireDragonNest().paste(loc);
                                plugin.getLogger().info("X: " + loc.getX() + " Y: " + loc.getY() + " Z: " + loc.getZ());
//                                FireDragon dragon = new FireDragon(EntityTypes.v, location, 3, plugin);
//                                dragon.spawn();
                                loadAdjacentChunks(RSVFiles.getIceDragonNest().getSchematic(), loc);
                            }
                        }
                        // check if biome is cold
                        else if (temperature <= -0.5) {
                            // generate ice dragon nest
                            if (r.nextDouble() <= 0.1) {

                                RSVFiles.getIceDragonNest().paste(loc);
                                plugin.getLogger().info("X: " + loc.getX() + " Y: " + loc.getY() + " Z: " + loc.getZ());
//                                FireDragon dragon = new FireDragon(EntityTypes.v, location, 3, plugin);
//                                dragon.spawn();
                                loadAdjacentChunks(RSVFiles.getIceDragonNest().getSchematic(), loc);
                            }
                        }
                    }
                }
            }
        }
    }

    public void loadAdjacentChunks(Clipboard schematic, Location loc) {
        BlockVector3 vector = schematic.getDimensions();

        World world = loc.getWorld();

        int x = (int) Math.round(loc.getX());
        int z = (int) Math.round(loc.getZ());

        int xLength = vector.getX();
        int zLength = vector.getZ();

        for (int i = -xLength / 2; i < xLength / 2 + 1; i+=CHUNK_LENGTH) {
            for (int j = -zLength / 2; j < zLength / 2 + 1; j+=CHUNK_LENGTH) {
                Chunk adjacent = world.getChunkAt(x + i, z + j);
                if (!adjacent.isLoaded()) {
                    adjacent.load();
                }
            }
        }
    }
}