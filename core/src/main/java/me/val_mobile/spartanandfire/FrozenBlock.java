package me.val_mobile.spartanandfire;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;

public class FrozenBlock {

    private FallingBlock block;

    public FrozenBlock(Location loc, Material material) {
        this.block = loc.getWorld().spawnFallingBlock(loc, material.createBlockData());

        // make the ice block purely cosmetic and have no effect on entities
        block.setDropItem(false);
        block.setHurtEntities(false);
        block.setGravity(false);
    }

    public FallingBlock getBlock() {
        return block;
    }
}
