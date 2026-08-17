/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.AbstractIterator
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Cursor3D
 *  net.minecraft.core.SectionPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.CollisionGetter
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.EntityCollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.thesundering.entity.etc;

import com.skd.thesundering.entity.etc.ICustomCollisions;
import com.google.common.collect.AbstractIterator;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Cursor3D;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomCollisionsBlockCollisions
extends AbstractIterator<VoxelShape> {
    private final AABB box;
    private final CollisionContext context;
    private final Cursor3D cursor;
    private final BlockPos.MutableBlockPos pos;
    private final VoxelShape entityShape;
    private final CollisionGetter collisionGetter;
    private final boolean onlySuffocatingBlocks;
    @Nullable
    private BlockGetter cachedBlockGetter;
    private long cachedBlockGetterPos;

    public CustomCollisionsBlockCollisions(CollisionGetter p_186402_, @Nullable Entity p_186403_, AABB p_186404_) {
        this(p_186402_, p_186403_, p_186404_, false);
    }

    public CustomCollisionsBlockCollisions(CollisionGetter p_186406_, @Nullable Entity p_186407_, AABB p_186408_, boolean p_186409_) {
        this.context = p_186407_ == null ? CollisionContext.empty() : CollisionContext.of((Entity)p_186407_);
        this.pos = new BlockPos.MutableBlockPos();
        this.entityShape = Shapes.create((AABB)p_186408_);
        this.collisionGetter = p_186406_;
        this.box = p_186408_;
        this.onlySuffocatingBlocks = p_186409_;
        int i = Mth.floor((double)(p_186408_.minX - 1.0E-7)) - 1;
        int j = Mth.floor((double)(p_186408_.maxX + 1.0E-7)) + 1;
        int k = Mth.floor((double)(p_186408_.minY - 1.0E-7)) - 1;
        int l = Mth.floor((double)(p_186408_.maxY + 1.0E-7)) + 1;
        int i1 = Mth.floor((double)(p_186408_.minZ - 1.0E-7)) - 1;
        int j1 = Mth.floor((double)(p_186408_.maxZ + 1.0E-7)) + 1;
        this.cursor = new Cursor3D(i, k, i1, j, l, j1);
    }

    @Nullable
    private BlockGetter getChunk(int p_186412_, int p_186413_) {
        BlockGetter blockgetter;
        int i = SectionPos.blockToSectionCoord((int)p_186412_);
        int j = SectionPos.blockToSectionCoord((int)p_186413_);
        long k = ChunkPos.asLong((int)i, (int)j);
        if (this.cachedBlockGetter != null && this.cachedBlockGetterPos == k) {
            return this.cachedBlockGetter;
        }
        this.cachedBlockGetter = blockgetter = this.collisionGetter.getChunkForCollisions(i, j);
        this.cachedBlockGetterPos = k;
        return blockgetter;
    }

    protected VoxelShape computeNext() {
        while (this.cursor.advance()) {
            Entity entity;
            BlockGetter blockgetter;
            int i = this.cursor.nextX();
            int j = this.cursor.nextY();
            int k = this.cursor.nextZ();
            int l = this.cursor.getNextType();
            if (l == 3 || (blockgetter = this.getChunk(i, k)) == null) continue;
            this.pos.set(i, j, k);
            BlockState blockstate = blockgetter.getBlockState((BlockPos)this.pos);
            if (this.onlySuffocatingBlocks && !blockstate.isSuffocating(blockgetter, (BlockPos)this.pos) || l == 1 && !blockstate.hasLargeCollisionShape() || l == 2 && !blockstate.is(Blocks.MOVING_PISTON)) continue;
            VoxelShape voxelshape = blockstate.getCollisionShape((BlockGetter)this.collisionGetter, (BlockPos)this.pos, this.context);
            if (this.context instanceof EntityCollisionContext && (entity = ((EntityCollisionContext)this.context).getEntity()) instanceof ICustomCollisions && ((ICustomCollisions)entity).canPassThrough((BlockPos)this.pos, blockstate, voxelshape)) continue;
            if (voxelshape == Shapes.block()) {
                if (!this.box.intersects((double)i, (double)j, (double)k, (double)i + 1.0, (double)j + 1.0, (double)k + 1.0)) continue;
                return voxelshape.move((double)i, (double)j, (double)k);
            }
            VoxelShape voxelshape1 = voxelshape.move((double)i, (double)j, (double)k);
            if (!Shapes.joinIsNotEmpty((VoxelShape)voxelshape1, (VoxelShape)this.entityShape, (BooleanOp)BooleanOp.AND)) continue;
            return voxelshape1;
        }
        return (VoxelShape)this.endOfData();
    }
}

