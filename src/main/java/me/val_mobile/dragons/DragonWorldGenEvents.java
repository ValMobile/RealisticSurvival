package me.val_mobile.dragons;

import me.val_mobile.utils.Schematics;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import java.io.IOException;
import java.util.Random;

public class DragonWorldGenEvents implements Listener {

    @EventHandler
    public void onChunkGenerate(ChunkLoadEvent event) throws IOException {
        // check if chunk was newly generated
        if (event.isNewChunk()) {
            // check if the chunk was generated in the overworld
            if (event.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
                Chunk chunk = event.getChunk(); // get chunk
                Block middleBlock = chunk.getBlock(8, 0, 8); // get the block in the middle of the chunk
                Biome biome = middleBlock.getBiome(); // get the biome of the block which is also the biome of the chunk

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
                    default:
                        Double temperature = middleBlock.getTemperature(); // get temperature of chunk

                        // check if biome is warm
                        if (temperature > -0.5) {
                            // generate fire dragon nest
                            Random r = new Random();

                            if (r.nextDouble() <= 0.2) {

                                Location location = middleBlock.getLocation().clone();
                                location.setY(60);
                                int iteration = 0;

                                Block block = location.getBlock();
                                Material material = block.getType();

                                while (!(block == null || material.equals(Material.AIR)) || material.isFlammable()) {
                                    if (iteration > 40) {
                                        return;
                                    }
                                    iteration++;
                                    location.setY(location.getY() + 1.0);
                                }

                                location.setY(location.getY() - 1.0);

                                Schematics.pasteSchematic(Schematics.getFireDragonNest(), location, true);
                            }
                        }
                        // check if biome is cold
                        else if (temperature <= -0.5) {
                            // generate ice dragon nest
                        }
                }
            }
        }
    }
}
