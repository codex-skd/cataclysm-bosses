/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 */
package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jspecify.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class Cataclysm_Skull_Block_Renderer
implements BlockEntityRenderer<Cataclysm_Skull_BlockEntity, BlockEntityRenderState> {
    
    public Cataclysm_Skull_Block_Renderer(BlockEntityRendererProvider.Context context) {
        // Constructor - store any needed references
    }

    @Override
    public BlockEntityRenderState createRenderState() {
        return new BlockEntityRenderState();
    }

    @Override
    public void extractRenderState(Cataclysm_Skull_BlockEntity blockEntity, BlockEntityRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderState.extractBase(blockEntity, state, breakProgress);
        // TODO: Extract block entity data to render state
    }

    @Override
    public void submit(BlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        // TODO: Implement rendering with new API
    }

    // PORT TODO(26.2): custom-skull rendering (block-entity AND item) is not wired to the
    // SubmitNodeCollector pipeline yet. These two helpers keep CMItemstackRenderer compiling;
    // createSkullRenderers returns an empty map so skullModels.get(type) is null and
    // renderItemSkull is a no-op. Re-implement with SkullBlockRenderer.submitSkull once the
    // block-entity submit() above is done.
    public static java.util.Map<net.minecraft.world.level.block.SkullBlock.Type, net.minecraft.client.model.object.skull.SkullModelBase> createSkullRenderers(net.minecraft.client.model.geom.EntityModelSet models) {
        return new java.util.HashMap<>();
    }

    public static void renderItemSkull(PoseStack poseStack, SubmitNodeCollector collector, int[] order, int packedLight, net.minecraft.client.model.object.skull.SkullModelBase model, net.minecraft.client.renderer.rendertype.RenderType renderType) {
        // no-op until the skull submit pipeline is ported
    }
}
