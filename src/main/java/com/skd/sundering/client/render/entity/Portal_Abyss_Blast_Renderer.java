/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.CameraType
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.player.Player
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

@OnlyIn(value=Dist.CLIENT)
public class Portal_Abyss_Blast_Renderer
extends EntityRenderer<Portal_Abyss_Blast_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/abyss_laser_beam.png");
    private static final float TEXTURE_WIDTH = 256.0f;
    private static final float TEXTURE_HEIGHT = 32.0f;
    private static final float START_RADIUS = 2.0f;
    private static final float END_RADIUS = 2.0f;
    private static final float BEAM_RADIUS = 2.0f;
    private boolean clearerView = false;

    public Portal_Abyss_Blast_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    public Identifier getTextureLocation(Portal_Abyss_Blast_Entity entity) {
        return TEXTURE;
    }

    public boolean shouldRender(Portal_Abyss_Blast_Entity solarBeam, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    public void render(Portal_Abyss_Blast_Entity solarBeam, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        this.clearerView = solarBeam.caster instanceof Player && Minecraft.getInstance().player == solarBeam.caster && Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON;
        double collidePosX = solarBeam.prevCollidePosX + (solarBeam.collidePosX - solarBeam.prevCollidePosX) * (double)delta;
        double collidePosY = solarBeam.prevCollidePosY + (solarBeam.collidePosY - solarBeam.prevCollidePosY) * (double)delta;
        double collidePosZ = solarBeam.prevCollidePosZ + (solarBeam.collidePosZ - solarBeam.prevCollidePosZ) * (double)delta;
        double posX = solarBeam.xo + (solarBeam.getX() - solarBeam.xo) * (double)delta;
        double posY = solarBeam.yo + (solarBeam.getY() - solarBeam.yo) * (double)delta;
        double posZ = solarBeam.zo + (solarBeam.getZ() - solarBeam.zo) * (double)delta;
        float yaw = solarBeam.prevYaw + (solarBeam.renderYaw - solarBeam.prevYaw) * delta;
        float pitch = solarBeam.prevPitch + (solarBeam.renderPitch - solarBeam.prevPitch) * delta;
        float length = (float)Math.sqrt(Math.pow(collidePosX - posX, 2.0) + Math.pow(collidePosY - posY, 2.0) + Math.pow(collidePosZ - posZ, 2.0));
        int frame = Mth.floor((float)(((float)(solarBeam.appear.getTimer() - 1) + delta) * 2.0f));
        if (frame < 0) {
            frame = 6;
        }
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(this.getTextureLocation(solarBeam)));
        this.renderBeam(length, 57.295776f * yaw, 57.295776f * pitch, frame, matrixStackIn, ivertexbuilder, packedLightIn);
        matrixStackIn.pushPose();
        matrixStackIn.translate(collidePosX - posX, collidePosY - posY, collidePosZ - posZ);
        this.renderEnd(frame, solarBeam.blockSide, matrixStackIn, ivertexbuilder, packedLightIn);
        matrixStackIn.popPose();
    }

    private void renderFlatQuad(int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0.0f + 0.0625f * (float)frame;
        float minV = 0.0f;
        float maxU = minU + 0.0625f;
        float maxV = minV + 0.5f;
        PoseStack.Pose matrixstack$entry = matrixStackIn.last();
        this.drawVertex(matrixstack$entry, builder, -2.0f, -2.0f, 0.0f, minU, minV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, -2.0f, 2.0f, 0.0f, minU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 2.0f, 2.0f, 0.0f, maxU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 2.0f, -2.0f, 0.0f, maxU, minV, 1.0f, packedLightIn);
    }

    private void renderEnd(int frame, Direction side, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.pushPose();
        Quaternionf quat = this.entityRenderDispatcher.cameraOrientation();
        matrixStackIn.mulPose(quat);
        this.renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
        if (side == null) {
            return;
        }
        matrixStackIn.pushPose();
        Quaternionf sideQuat = side.getRotation();
        sideQuat.mul((Quaternionfc)new Quaternionf().rotationX(1.5707964f));
        matrixStackIn.mulPose(sideQuat);
        matrixStackIn.translate(0.0f, 0.0f, -0.01f);
        this.renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
    }

    private void drawBeam(float length, int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0.0f;
        float minV = 0.5f + 0.03125f * (float)frame;
        float maxU = minU + 0.078125f;
        float maxV = minV + 0.03125f;
        PoseStack.Pose matrixstack$entry = matrixStackIn.last();
        float offset = this.clearerView ? -1.0f : 0.0f;
        this.drawVertex(matrixstack$entry, builder, -2.0f, offset, 0.0f, minU, minV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, -2.0f, length, 0.0f, minU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 2.0f, length, 0.0f, maxU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 2.0f, offset, 0.0f, maxU, minV, 1.0f, packedLightIn);
    }

    private void renderBeam(float length, float yaw, float pitch, int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(new Quaternionf().rotationX(1.5707964f));
        matrixStackIn.mulPose(new Quaternionf().rotationZ((yaw - 90.0f) * ((float)Math.PI / 180)));
        matrixStackIn.mulPose(new Quaternionf().rotationX(-pitch * ((float)Math.PI / 180)));
        matrixStackIn.pushPose();
        if (!this.clearerView) {
            matrixStackIn.mulPose(new Quaternionf().rotationY(Minecraft.getInstance().gameRenderer.getMainCamera().getXRot() + 90.0f));
        }
        this.drawBeam(length, frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
        if (!this.clearerView) {
            matrixStackIn.pushPose();
            matrixStackIn.mulPose(new Quaternionf().rotationY((-Minecraft.getInstance().gameRenderer.getMainCamera().getXRot() - 90.0f) * ((float)Math.PI / 180)));
            this.drawBeam(length, frame, matrixStackIn, builder, packedLightIn);
            matrixStackIn.popPose();
        }
        matrixStackIn.popPose();
    }

    public void drawVertex(PoseStack.Pose normals, VertexConsumer vertexBuilder, float offsetX, float offsetY, float offsetZ, float textureX, float textureY, float alpha, int packedLightIn) {
        vertexBuilder.addVertex(normals, offsetX, offsetY, offsetZ).setColor(1.0f, 1.0f, 1.0f, 1.0f * alpha).setUv(textureX, textureY).setOverlay(OverlayTexture.NO_OVERLAY).setLight(packedLightIn).setNormal(normals, 0.0f, 1.0f, 0.0f);
    }
}

