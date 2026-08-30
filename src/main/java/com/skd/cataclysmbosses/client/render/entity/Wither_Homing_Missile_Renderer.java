/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4f
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Wither_Homing_Missile_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Wither_Homing_Missile_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Wither_Homing_Missile_Renderer
extends CmEntityRenderer<Wither_Homing_Missile_Entity> {
    private static final Identifier WITHER_MISSILE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/wither_homing_missile.png");
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/amogus.png");
    protected final EntityRenderDispatcher entityRenderDispatcher;
    public Wither_Homing_Missile_Model model = new Wither_Homing_Missile_Model();

    public Wither_Homing_Missile_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.entityRenderDispatcher = manager.getEntityRenderDispatcher();
    }

    protected int getBlockLightLevel(Wither_Homing_Missile_Entity entity, BlockPos pos) {
        return 15;
    }

    protected void render(Wither_Homing_Missile_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.5f, -1.5f, 1.5f);
        matrixStackIn.translate(0.0f, 0.04f, 0.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RenderTypes.entityCutout(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, 0.0f, f, f1);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        matrixStackIn.popPose();
        if (entityIn.hasTrail()) {
            double x = Mth.lerp((double)partialTicks, (double)entityIn.xOld, (double)entityIn.getX());
            double y = Mth.lerp((double)partialTicks, (double)entityIn.yOld, (double)entityIn.getY());
            double z = Mth.lerp((double)partialTicks, (double)entityIn.zOld, (double)entityIn.getZ());
            float r = 0.9843137f;
            float g = 0.41960785f;
            float b = 0.11372549f;
            matrixStackIn.pushPose();
            matrixStackIn.translate(-x, -y, -z);
            this.renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0f, packedLightIn);
            matrixStackIn.popPose();
        }
    }

    private void renderTrail(Wither_Homing_Missile_Entity entityIn, float partialTicks, PoseStack poseStack, CmMultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        int sampleSize = 10;
        float trailWidth = 0.2f;
        PoseStack.Pose lastPose = poseStack.last();
        Matrix4f matrix = lastPose.pose();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getLightTrailEffect(TRAIL_TEXTURE));
        Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);
        Vec3 cameraPos = this.entityRenderDispatcher.camera.position();
        for (int i = 0; i < sampleSize; ++i) {
            Vec3 sample = entityIn.getTrailPosition(i + 1, partialTicks);
            float u1 = (float)i / (float)sampleSize;
            float u2 = u1 + 1.0f / (float)sampleSize;
            Vec3 forward = sample.subtract(drawFrom);
            if (forward.lengthSqr() == 0.0) continue;
            Vec3 toCamera = cameraPos.subtract(drawFrom);
            Vec3 side = forward.cross(toCamera).normalize();
            Vec3 offset = side.scale((double)(trailWidth / 2.0f));
            this.addVertex(vertexconsumer, matrix, drawFrom.add(offset), trailR, trailG, trailB, u1, 0.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, drawFrom.add(offset.scale(-1.0)), trailR, trailG, trailB, u1, 1.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, sample.add(offset.scale(-1.0)), trailR, trailG, trailB, u2, 1.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, sample.add(offset), trailR, trailG, trailB, u2, 0.0f, packedLightIn);
            drawFrom = sample;
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, float r, float g, float b, float u, float v, int light) {
        consumer.addVertex(matrix, (float)pos.x, (float)pos.y, (float)pos.z).setColor(r, g, b, 1.0f).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
    }

    public Identifier getTextureLocation(Wither_Homing_Missile_Entity entity) {
        return WITHER_MISSILE;
    }
}

