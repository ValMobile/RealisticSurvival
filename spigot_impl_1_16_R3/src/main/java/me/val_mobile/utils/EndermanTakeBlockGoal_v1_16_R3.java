package me.val_mobile.utils;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.craftbukkit.v1_16_R2.event.CraftEventFactory;

import java.util.Random;

public class EndermanTakeBlockGoal_v1_16_R3 extends PathfinderGoal {
    private final EntityEnderman enderman;

    public EndermanTakeBlockGoal_v1_16_R3(EntityEnderman enderman) {
        this.enderman = enderman;
    }

    public boolean a() {
        return enderman.getCarried() == null && (enderman.world.getGameRules().getBoolean(GameRules.MOB_GRIEFING) && enderman.getRandom().nextInt(20) == 0);
    }

    public void e() {
        Random random = enderman.getRandom();
        World world = enderman.world;
        int i = MathHelper.floor(enderman.locX() - 2.0 + random.nextDouble() * 4.0);
        int j = MathHelper.floor(enderman.locY() + random.nextDouble() * 3.0);
        int k = MathHelper.floor(enderman.locZ() - 2.0 + random.nextDouble() * 4.0);
        BlockPosition blockposition = new BlockPosition(i, j, k);
        IBlockData iblockdata = world.getType(blockposition);
        Block block = iblockdata.getBlock();
        Vec3D vec3d = new Vec3D((double) MathHelper.floor(enderman.locX()) + 0.5, (double) j + 0.5, (double) MathHelper.floor(enderman.locZ()) + 0.5);
        Vec3D vec3d1 = new Vec3D((double) i + 0.5, (double) j + 0.5, (double) k + 0.5);
        MovingObjectPositionBlock movingobjectpositionblock = world.rayTrace(new RayTrace(vec3d, vec3d1, RayTrace.BlockCollisionOption.OUTLINE, RayTrace.FluidCollisionOption.NONE, enderman));
        boolean flag = movingobjectpositionblock.getBlockPosition().equals(blockposition);
        if (block.a(TagsBlock.ENDERMAN_HOLDABLE) && flag && !CraftEventFactory.callEntityChangeBlockEvent(enderman, blockposition, Blocks.AIR.getBlockData()).isCancelled()) {
            world.a(blockposition, false);
            enderman.setCarried(iblockdata.getBlock().getBlockData());
        }

    }
}
