package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.blocks.Cataclysm_Skull_Block;
import com.skd.cataclysmbosses.blocks.Cataclysm_Wall_Skull_Block;
import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.block.AptrgangrHeadModel;
import com.skd.cataclysmbosses.client.model.block.DraugrHeadModel;
import com.skd.cataclysmbosses.client.model.block.KobolediatorHeadModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import net.minecraft.util.Util;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.blockentity.state.SkullBlockRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jspecify.annotations.Nullable;

/**
 * PORT NOTE (26.2): ported to the SubmitNodeCollector/RenderState BER pipeline.
 */
@OnlyIn(Dist.CLIENT)
public class Cataclysm_Skull_Block_Renderer
implements BlockEntityRenderer<Cataclysm_Skull_BlockEntity, SkullBlockRenderState> {
    private final Map<SkullBlock.Type, SkullModelBase> modelByType;
    public static final Map<SkullBlock.Type, Identifier> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), p_261388_ -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/draugar/draugr.png"));
    });

    public static Map<SkullBlock.Type, SkullModelBase> createSkullRenderers(EntityModelSet p_173662_) {
        ImmutableMap.Builder<SkullBlock.Type, SkullModelBase> builder = ImmutableMap.builder();
        builder.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new KobolediatorHeadModel(p_173662_.bakeLayer(CMModelLayers.KOBOLEDIATOR_HEAD_MODEL)));
        builder.put(Cataclysm_Skull_Block.Types.APTRGANGR, new AptrgangrHeadModel(p_173662_.bakeLayer(CMModelLayers.APTRGANGR_HEAD_MODEL)));
        builder.put(Cataclysm_Skull_Block.Types.DRAUGR, new DraugrHeadModel(p_173662_.bakeLayer(CMModelLayers.DRAUGR_HEAD_MODEL)));
        return builder.build();
    }

    public Cataclysm_Skull_Block_Renderer(BlockEntityRendererProvider.Context p_173660_) {
        this.modelByType = Cataclysm_Skull_Block_Renderer.createSkullRenderers(p_173660_.entityModelSet());
    }

    @Override
    public SkullBlockRenderState createRenderState() {
        return new SkullBlockRenderState();
    }

    @Override
    public void extractRenderState(
        Cataclysm_Skull_BlockEntity blockEntity,
        SkullBlockRenderState state,
        float partialTicks,
        @Nullable Vec3 cameraPosition,
        ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress
    ) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.animationProgress = blockEntity.getAnimation(partialTicks);
        BlockState blockState = blockEntity.getBlockState();
        if (blockState.getBlock() instanceof Cataclysm_Wall_Skull_Block) {
            Direction facing = blockState.getValue(Cataclysm_Wall_Skull_Block.FACING);
            state.transformation = SkullBlockRenderer.TRANSFORMATIONS.wallTransformation(facing);
        } else {
            state.transformation = SkullBlockRenderer.TRANSFORMATIONS.freeTransformations(blockState.getValue(Cataclysm_Skull_Block.ROTATION));
        }
        state.skullType = ((Cataclysm_Skull_Block)blockState.getBlock()).getType();
        state.renderType = Cataclysm_Skull_Block_Renderer.getRenderType(state.skullType);
    }

    @Override
    public void submit(SkullBlockRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, net.minecraft.client.renderer.state.level.CameraRenderState camera) {
        SkullModelBase model = this.modelByType.get(state.skullType);
        poseStack.pushPose();
        poseStack.mulPose(state.transformation);
        SkullBlockRenderer.submitSkull(state.animationProgress, poseStack, submitNodeCollector, state.lightCoords, model, state.renderType, 0, state.breakProgress);
        poseStack.popPose();
    }

    public static RenderType getRenderType(SkullBlock.Type type) {
        Identifier resourcelocation = SKIN_BY_TYPE.get(type);
        return net.minecraft.client.renderer.rendertype.RenderTypes.entityCutoutZOffset(resourcelocation);
    }

    /*
     * PORT NOTE (26.2): submit-based variant used by CMItemstackRenderer for skull items.
     */
    public static void renderItemSkull(PoseStack poseStack, SubmitNodeCollector collector, int[] order, int lightCoords, SkullModelBase model, RenderType renderType) {
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.0f, 0.5f);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180.0f));
        SkullModelBase.State modelState = new SkullModelBase.State();
        int o = order[0]++;
        collector.order(o).submitModel(model, modelState, poseStack, renderType, lightCoords, OverlayTexture.NO_OVERLAY, -1, null);
        poseStack.popPose();
    }
}
