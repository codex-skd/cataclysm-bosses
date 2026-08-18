/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.block.LiquidBlockRenderer
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions
 */
package com.skd.thesundering.client.render.etc;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.block.LiquidBlockRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

public class LavaVisionFluidRenderer
extends LiquidBlockRenderer {
    private static boolean isFaceOccludedByNeighbor(BlockGetter p_239283_0_, BlockPos p_239283_1_, Direction p_239283_2_, float p_239283_3_) {
        BlockPos blockpos = p_239283_1_.relative(p_239283_2_);
        BlockState blockstate = p_239283_0_.getBlockState(blockpos);
        return LavaVisionFluidRenderer.isFaceOccludedByState(p_239283_0_, p_239283_2_, p_239283_3_, blockpos, blockstate);
    }

    private static boolean isFaceOccludedByState(BlockGetter p_239284_0_, Direction p_239284_1_, float p_239284_2_, BlockPos p_239284_3_, BlockState p_239284_4_) {
        if (p_239284_4_.canOcclude()) {
            VoxelShape voxelshape = Shapes.box((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)p_239284_2_, (double)1.0);
            VoxelShape voxelshape1 = p_239284_4_.getOcclusionShape(p_239284_0_, p_239284_3_);
            return Shapes.joinIsNotEmpty((VoxelShape)voxelshape, (VoxelShape)voxelshape1, BooleanOp.AND);
        }
        return false;
    }

    private static boolean isAdjacentFluidSameAs(BlockGetter worldIn, BlockPos pos, Direction side, FluidState state) {
        BlockPos blockpos = pos.relative(side);
        FluidState fluidstate = worldIn.getFluidState(blockpos);
        return fluidstate.getType().isSame(state.getType());
    }

    @Override
    public void tesselate(BlockGetter lightReaderIn, BlockPos posIn, VertexConsumer vertexBuilderIn, BlockState blockstateIn, FluidState fluidStateIn) {
        try {
            if (fluidStateIn.is(FluidTags.LAVA)) {
                boolean flag = fluidStateIn.is(FluidTags.LAVA);
                TextureAtlasSprite[] atextureatlassprite = new TextureAtlasSprite[2];
                atextureatlassprite[0] = IClientFluidTypeExtensions.of(fluidStateIn.getType()).getStillTexture(fluidStateIn);
                atextureatlassprite[1] = IClientFluidTypeExtensions.of(fluidStateIn.getType()).getFlowingTexture(fluidStateIn);
                int i = IClientFluidTypeExtensions.of(fluidStateIn).getTintColor(fluidStateIn, lightReaderIn, posIn);
                float alpha = 0.5f;
                float f = (float)(i >> 16 & 0xFF) / 255.0f;
                float f1 = (float)(i >> 8 & 0xFF) / 255.0f;
                float f2 = (float)(i & 0xFF) / 255.0f;
                BlockState blockstate = lightReaderIn.getBlockState(posIn.relative(Direction.DOWN));
                FluidState fluidstate = blockstate.getFluidState();
                BlockState blockstate1 = lightReaderIn.getBlockState(posIn.relative(Direction.UP));
                FluidState fluidstate1 = blockstate1.getFluidState();
                BlockState blockstate2 = lightReaderIn.getBlockState(posIn.relative(Direction.NORTH));
                FluidState fluidstate2 = blockstate2.getFluidState();
                BlockState blockstate3 = lightReaderIn.getBlockState(posIn.relative(Direction.SOUTH));
                FluidState fluidstate3 = blockstate3.getFluidState();
                BlockState blockstate4 = lightReaderIn.getBlockState(posIn.relative(Direction.WEST));
                FluidState fluidstate4 = blockstate4.getFluidState();
                BlockState blockstate5 = lightReaderIn.getBlockState(posIn.relative(Direction.EAST));
                FluidState fluidstate5 = blockstate5.getFluidState();
                boolean flag1 = !LavaVisionFluidRenderer.isAdjacentFluidSameAs(lightReaderIn, posIn, Direction.UP, fluidStateIn);
                boolean flag2 = LavaVisionFluidRenderer.shouldRenderFace(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.DOWN, fluidstate) && !LavaVisionFluidRenderer.isFaceOccludedByNeighborVanilla(lightReaderIn, posIn, Direction.DOWN, 0.8888889f, blockstate);
                boolean flag3 = LavaVisionFluidRenderer.shouldRenderFace(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.NORTH, fluidstate2);
                boolean flag4 = LavaVisionFluidRenderer.shouldRenderFace(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.SOUTH, fluidstate3);
                boolean flag5 = LavaVisionFluidRenderer.shouldRenderFace(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.WEST, fluidstate4);
                boolean flag6 = LavaVisionFluidRenderer.shouldRenderFace(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.EAST, fluidstate5);
                if (!flag1 && !flag2 && !flag3 && !flag4 && !flag5 && !flag6) {
                    return;
                }
                // ... rest of tesselate method (simplified for now)
                // Call parent tesselate with BlockGetter instead of BlockAndTintGetter
                super.tesselate(lightReaderIn, posIn, vertexBuilderIn, blockstateIn, fluidStateIn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean shouldRenderFace(BlockGetter lightReaderIn, BlockPos posIn, FluidState fluidStateIn, BlockState blockstateIn, Direction direction, FluidState fluidStateNeighbor) {
        return !LavaVisionFluidRenderer.isAdjacentFluidSameAs(lightReaderIn, posIn, direction, fluidStateIn) && !LavaVisionFluidRenderer.isFaceOccludedByNeighbor(lightReaderIn, posIn, direction, 0.8888889f);
    }

    private static boolean isFaceOccludedByNeighborVanilla(BlockGetter blockGetter, BlockPos pos, Direction direction, float f, BlockState blockstate) {
        BlockPos neighborPos = pos.relative(direction);
        BlockState neighborState = blockGetter.getBlockState(neighborPos);
        return isFaceOccludedByState(blockGetter, direction, f, neighborPos, neighborState);
    }
}