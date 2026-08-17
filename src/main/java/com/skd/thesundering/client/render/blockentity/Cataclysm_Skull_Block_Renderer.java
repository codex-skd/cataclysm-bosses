/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.common.collect.Maps
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  javax.annotation.Nullable
 *  net.minecraft.Util
 *  net.minecraft.client.model.SkullModelBase
 *  net.minecraft.client.model.geom.EntityModelSet
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.RotationSegment
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.blockentity;

import com.skd.thesundering.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.thesundering.blocks.Cataclysm_Skull_Block;
import com.skd.thesundering.blocks.Cataclysm_Wall_Skull_Block;
import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.block.AptrgangrHeadModel;
import com.skd.thesundering.client.model.block.DraugrHeadModel;
import com.skd.thesundering.client.model.block.KobolediatorHeadModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Cataclysm_Skull_Block_Renderer
implements BlockEntityRenderer<Cataclysm_Skull_BlockEntity> {
    private final Map<SkullBlock.Type, SkullModelBase> modelByType;
    public static final Map<SkullBlock.Type, Identifier> SKIN_BY_TYPE = (Map)Util.make((Object)Maps.newHashMap(), p_261388_ -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/draugr.png"));
    });

    public static Map<SkullBlock.Type, SkullModelBase> createSkullRenderers(EntityModelSet p_173662_) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        builder.put((Object)Cataclysm_Skull_Block.Types.KOBOLEDIATOR, (Object)new KobolediatorHeadModel(p_173662_.bakeLayer(CMModelLayers.KOBOLEDIATOR_HEAD_MODEL)));
        builder.put((Object)Cataclysm_Skull_Block.Types.APTRGANGR, (Object)new AptrgangrHeadModel(p_173662_.bakeLayer(CMModelLayers.APTRGANGR_HEAD_MODEL)));
        builder.put((Object)Cataclysm_Skull_Block.Types.DRAUGR, (Object)new DraugrHeadModel(p_173662_.bakeLayer(CMModelLayers.DRAUGR_HEAD_MODEL)));
        return builder.build();
    }

    public Cataclysm_Skull_Block_Renderer(BlockEntityRendererProvider.Context p_173660_) {
        this.modelByType = Cataclysm_Skull_Block_Renderer.createSkullRenderers(p_173660_.getModelSet());
    }

    public void render(Cataclysm_Skull_BlockEntity p_112534_, float p_112535_, PoseStack p_112536_, MultiBufferSource p_112537_, int p_112538_, int p_112539_) {
        float f = p_112534_.getAnimation(p_112535_);
        BlockState blockstate = p_112534_.getBlockState();
        boolean flag = blockstate.getBlock() instanceof Cataclysm_Wall_Skull_Block;
        Direction direction = flag ? (Direction)blockstate.getValue((Property)Cataclysm_Wall_Skull_Block.FACING) : null;
        int i = flag ? RotationSegment.convertToSegment((Direction)direction.getOpposite()) : (Integer)blockstate.getValue((Property)Cataclysm_Skull_Block.ROTATION);
        float f1 = RotationSegment.convertToDegrees((int)i);
        SkullBlock.Type Cataclysm_Skull_Block$type = ((Cataclysm_Skull_Block)blockstate.getBlock()).getType();
        SkullModelBase Cataclysm_Skull_Model_Base = this.modelByType.get(Cataclysm_Skull_Block$type);
        RenderType rendertype = Cataclysm_Skull_Block_Renderer.getRenderType(Cataclysm_Skull_Block$type);
        Cataclysm_Skull_Block_Renderer.renderSkull(direction, f1, f, p_112536_, p_112537_, p_112538_, Cataclysm_Skull_Model_Base, rendertype, Cataclysm_Skull_Block$type, false);
    }

    public static void renderSkull(@Nullable Direction p_173664_, float p_173665_, float p_173666_, PoseStack p_173667_, MultiBufferSource p_173668_, int p_173669_, SkullModelBase p_173670_, RenderType p_173671_, SkullBlock.Type type, boolean isLayer) {
        p_173667_.pushPose();
        if (p_173664_ == null) {
            p_173667_.translate(0.5f, 0.0f, 0.5f);
        } else {
            float f = 0.25f;
            p_173667_.translate(0.5f - (float)p_173664_.getStepX() * 0.25f, 0.25f, 0.5f - (float)p_173664_.getStepZ() * 0.25f);
        }
        p_173667_.scale(-1.0f, -1.0f, 1.0f);
        if (isLayer) {
            if (type == Cataclysm_Skull_Block.Types.KOBOLEDIATOR) {
                p_173667_.translate(0.0f, 0.1f, 0.0f);
            }
            if (type == Cataclysm_Skull_Block.Types.APTRGANGR) {
                p_173667_.translate(0.0f, 0.2f, 0.0f);
            }
            if (type == Cataclysm_Skull_Block.Types.DRAUGR) {
                p_173667_.translate(0.0f, 0.075f, 0.0f);
            }
        }
        VertexConsumer vertexconsumer = p_173668_.getBuffer(p_173671_);
        p_173670_.setupAnim(p_173666_, p_173665_, 0.0f);
        p_173670_.renderToBuffer(p_173667_, vertexconsumer, p_173669_, OverlayTexture.NO_OVERLAY);
        p_173667_.popPose();
    }

    public static RenderType getRenderType(SkullBlock.Type type) {
        Identifier resourcelocation = SKIN_BY_TYPE.get(type);
        return RenderType.entityCutoutNoCullZOffset((Identifier)resourcelocation);
    }
}

