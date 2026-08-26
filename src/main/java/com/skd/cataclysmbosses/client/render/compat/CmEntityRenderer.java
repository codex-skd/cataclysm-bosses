package com.skd.cataclysmbosses.client.render.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.entity.Entity;

/**
 * PORT NOTE (26.2): adapter base that preserves the removed immediate-mode
 * {@code render(Entity, float, float, PoseStack, MultiBufferSource, int)} contract on top
 * of the RenderState/SubmitNodeCollector pipeline. Legacy bodies keep reading the entity
 * directly and draw via {@link CmMultiBufferSource#getBuffer}; draws are deferred and
 * replayed as ordered submitCustomGeometry calls.
 */
public abstract class CmEntityRenderer<T extends Entity>
extends EntityRenderer<T, CmEntityRenderState> {
    protected CmEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public CmEntityRenderState createRenderState() {
        return new CmEntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, CmEntityRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.entity = entity;
        state.partialTick = partialTicks;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void submit(CmEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if (state.entity != null) {
            CmMultiBufferSource buffer = new CmMultiBufferSource();
            this.render((T) state.entity, state.partialTick, poseStack, buffer, state.lightCoords);
            buffer.flush(poseStack, submitNodeCollector);
        }
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    protected abstract void render(T entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight);
}
