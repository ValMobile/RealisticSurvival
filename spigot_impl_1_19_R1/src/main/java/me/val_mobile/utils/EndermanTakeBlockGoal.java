package me.val_mobile.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.bukkit.craftbukkit.v1_19_R1.event.CraftEventFactory;

public class EndermanTakeBlockGoal extends Goal {
    private final EnderMan enderman;

    public EndermanTakeBlockGoal(EnderMan enderman) {
        this.enderman = enderman;
    }

    public boolean canUse() {
        return this.enderman.getCarriedBlock() == null && (enderman.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && enderman.getRandom().nextInt(reducedTickDelay(20)) == 0);
    }

    public void tick() {
        RandomSource randomsource = enderman.getRandom();
        Level world = enderman.level;
        int i = Mth.floor(enderman.getX() - 2.0 + randomsource.nextDouble() * 4.0);
        int j = Mth.floor(enderman.getY() + randomsource.nextDouble() * 3.0);
        int k = Mth.floor(enderman.getZ() - 2.0 + randomsource.nextDouble() * 4.0);
        BlockPos blockposition = new BlockPos(i, j, k);
        BlockState iblockdata = world.getBlockState(blockposition);
        Vec3 vec3d = new Vec3((double)enderman.getBlockX() + 0.5, (double)j + 0.5, (double)enderman.getBlockZ() + 0.5);
        Vec3 vec3d1 = new Vec3((double)i + 0.5, (double)j + 0.5, (double)k + 0.5);
        BlockHitResult movingobjectpositionblock = world.clip(new ClipContext(vec3d, vec3d1, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, enderman));
        boolean flag = movingobjectpositionblock.getBlockPos().equals(blockposition);
        if (iblockdata.is(BlockTags.ENDERMAN_HOLDABLE) && flag && !CraftEventFactory.callEntityChangeBlockEvent(enderman, blockposition, Blocks.AIR.defaultBlockState()).isCancelled()) {
            world.removeBlock(blockposition, false);
            world.gameEvent(GameEvent.BLOCK_DESTROY, blockposition, GameEvent.Context.of(enderman, iblockdata));
            enderman.setCarriedBlock(iblockdata.getBlock().defaultBlockState());
        }

    }
}
