package me.val_mobile.utils;

import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;
import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.HashMap;

public class v1_17_R1 extends InternalsProvider {

    @Override
    public void spawnEndermanAlly(Location loc) {

    }

    @Override
    public void spawnEntity(Object entity) {
        net.minecraft.world.entity.Entity e = (Entity) entity;
        org.bukkit.World world = e.getWorld().getWorld();
        ((CraftWorld)world).getHandle().addEntity(e, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public WorldServer getWorld(World world) {
        return ((CraftWorld)world).getHandle();
    }

    @Override
    public HashMap<String, Tag> getTags() {
        HashMap<String, Tag> tags = new HashMap<>();

        tags.put("PLANKS", Tag.PLANKS);
        tags.put("WOOL", Tag.WOOL);
        tags.put("LOGS", Tag.LOGS);
        tags.put("CANDLES", Tag.CANDLES);
        tags.put("CANDLE_CAKES", Tag.CANDLE_CAKES);
        tags.put("FIRE", Tag.FIRE);
        tags.put("SNOW", Tag.SNOW);
        tags.put("FLUIDS_LAVA", Tag.FLUIDS_LAVA);
        tags.put("FLUIDS_WATER", Tag.FLUIDS_WATER);

        return tags;
    }

}
