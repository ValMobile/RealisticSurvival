package me.val_mobile.utils;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.craftbukkit.v1_16_R2.event.CraftEventFactory;

import java.util.Random;

public class EndermanLeaveBlockGoal_v1_16_R3 extends PathfinderGoal {
    private final EntityEnderman enderman;

    public EndermanLeaveBlockGoal_v1_16_R3(EntityEnderman enderman) {
        this.enderman = enderman;
    }

    public boolean a() {
        return enderman.getCarried() != null && (enderman.world.getGameRules().getBoolean(GameRules.MOB_GRIEFING) && enderman.getRandom().nextInt(2000) == 0);
    }

    public void e() {
        Random random = enderman.getRandom();
        World world = enderman.world;
        int i = MathHelper.floor(enderman.locX() - 1.0 + random.nextDouble() * 2.0);
        int j = MathHelper.floor(enderman.locY() + random.nextDouble() * 2.0);
        int k = MathHelper.floor(enderman.locZ() - 1.0 + random.nextDouble() * 2.0);
        BlockPosition blockposition = new BlockPosition(i, j, k);
        IBlockData iblockdata = world.getType(blockposition);
        BlockPosition blockposition1 = blockposition.down();
        IBlockData iblockdata1 = world.getType(blockposition1);
        IBlockData iblockdata2 = enderman.getCarried();
        if (iblockdata2 != null) {
            iblockdata2 = Block.b(iblockdata2, enderman.world, blockposition);
            if (this.a(world, blockposition, iblockdata2, iblockdata, iblockdata1, blockposition1) && !CraftEventFactory.callEntityChangeBlockEvent(enderman, blockposition, iblockdata2).isCancelled()) {
                world.setTypeAndData(blockposition, iblockdata2, 3);
                enderman.setCarried(null);
            }
        }

    }

    private boolean a(World world, BlockPosition blockposition, IBlockData iblockdata, IBlockData iblockdata1, IBlockData iblockdata2, BlockPosition blockposition1) {
        return iblockdata1.isAir() && !iblockdata2.isAir() && !iblockdata2.a(Blocks.BEDROCK) && iblockdata2.r(world, blockposition1) && iblockdata.canPlace(world, blockposition) && world.getEntities(enderman, AxisAlignedBB.a(Vec3D.b(blockposition))).isEmpty();
    }
}
