/*
    Copyright (C) 2024  Val_Mobile

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

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.bukkit.craftbukkit.v1_19_R2.event.CraftEventFactory;

public class EndermanLeaveBlockGoal_v1_19_R4 extends Goal {
    private final EnderMan enderman;

    public EndermanLeaveBlockGoal_v1_19_R4(EnderMan enderman) {
        this.enderman = enderman;
    }

    public boolean canUse() {
        return this.enderman.getCarriedBlock() != null && (enderman.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && enderman.getRandom().nextInt(reducedTickDelay(2000)) == 0);
    }

    public void tick() {
        RandomSource randomsource = enderman.getRandom();
        Level world = enderman.level;
        int i = Mth.floor(enderman.getX() - 1.0 + randomsource.nextDouble() * 2.0);
        int j = Mth.floor(enderman.getY() + randomsource.nextDouble() * 2.0);
        int k = Mth.floor(enderman.getZ() - 1.0 + randomsource.nextDouble() * 2.0);
        BlockPos blockposition = new BlockPos(i, j, k);
        BlockState iblockdata = world.getBlockState(blockposition);
        BlockPos blockposition1 = blockposition.below();
        BlockState iblockdata1 = world.getBlockState(blockposition1);
        BlockState iblockdata2 = enderman.getCarriedBlock();
        if (iblockdata2 != null) {
            iblockdata2 = net.minecraft.world.level.block.Block.updateFromNeighbourShapes(iblockdata2, this.enderman.level, blockposition);
            if (canPlaceBlock(world, blockposition, iblockdata2, iblockdata, iblockdata1, blockposition1) && !CraftEventFactory.callEntityChangeBlockEvent(this.enderman, blockposition, iblockdata2).isCancelled()) {
                world.setBlock(blockposition, iblockdata2, 3);
                world.gameEvent(GameEvent.BLOCK_PLACE, blockposition, GameEvent.Context.of(enderman, iblockdata2));
                enderman.setCarriedBlock(null);
            }
        }

    }

    private boolean canPlaceBlock(Level world, BlockPos blockposition, BlockState iblockdata, BlockState iblockdata1, BlockState iblockdata2, BlockPos blockposition1) {
        return iblockdata1.isAir() && !iblockdata2.isAir() && !iblockdata2.is(Blocks.BEDROCK) && iblockdata2.isCollisionShapeFullBlock(world, blockposition1) && iblockdata.canSurvive(world, blockposition) && world.getEntities(enderman, AABB.unitCubeFromLowerCorner(Vec3.atLowerCornerOf(blockposition))).isEmpty();
    }
}
