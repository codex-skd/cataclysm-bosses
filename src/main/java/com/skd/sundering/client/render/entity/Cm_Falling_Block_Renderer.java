/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.block.BlockRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.client.resources.model.BakedModel
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.client.RenderTypeHelper
 *  net.neoforged.neoforge.client.model.data.ModelData
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.entity.effect.Cm_Falling_Block_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.RenderTypeHelper;
import net.neoforged.neoforge.client.model.data.ModelData;

@OnlyIn(value=Dist.CLIENT)
public class Cm_Falling_Block_Renderer
extends EntityRenderer<Cm_Falling_Block_Entity> {
    private final BlockRenderDispatcher dispatcher;

    public Cm_Falling_Block_Renderer(EntityRendererProvider.Context p_174112_) {
        super(p_174112_);
        this.dispatcher = p_174112_.getBlockRenderDispatcher();
    }

    public void render(Cm_Falling_Block_Entity p_114634_, float p_114635_, float p_114636_, PoseStack p_114637_, MultiBufferSource p_114638_, int p_114639_) {
        Level level;
        BlockState blockstate = p_114634_.getBlockState();
        if (blockstate.getRenderShape() == RenderShape.MODEL && blockstate != (level = p_114634_.level()).getBlockState(p_114634_.blockPosition()) && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            p_114637_.pushPose();
            BlockPos blockpos = BlockPos.containing((double)p_114634_.getX(), (double)p_114634_.getBoundingBox().maxY, (double)p_114634_.getZ());
            p_114637_.translate(-0.5, 0.0, -0.5);
            BakedModel model = this.dispatcher.getBlockModel(blockstate);
            for (RenderType renderType : model.getRenderTypes(blockstate, RandomSource.create((long)blockstate.getSeed(p_114634_.getStartPos())), ModelData.EMPTY)) {
                this.dispatcher.getModelRenderer().tesselateBlock((BlockAndTintGetter)level, this.dispatcher.getBlockModel(blockstate), blockstate, blockpos, p_114637_, p_114638_.getBuffer(RenderTypeHelper.getMovingBlockRenderType((RenderType)renderType)), false, RandomSource.create(), blockstate.getSeed(p_114634_.getStartPos()), OverlayTexture.NO_OVERLAY, ModelData.EMPTY, renderType);
            }
            p_114637_.popPose();
            super.render((Entity)p_114634_, p_114635_, p_114636_, p_114637_, p_114638_, p_114639_);
        }
    }

    public Identifier getTextureLocation(Cm_Falling_Block_Entity p_114632_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

