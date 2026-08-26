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
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.client.render.etc.LightningBoltData;
import com.skd.cataclysmbosses.client.render.etc.LightningRender;
import com.skd.cataclysmbosses.entity.projectile.Death_Laser_Beam_Entity;
import com.skd.cataclysmbosses.util.CMMathUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector4f;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Death_Laser_beam_Renderer
extends EntityRenderer<Death_Laser_Beam_Entity, EntityRenderState> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/death_laser_beam.png");
    private static final float TEXTURE_WIDTH = 256.0f;
    private static final float TEXTURE_HEIGHT = 32.0f;
    private static final float START_RADIUS = 0.75f;
    private static final float BEAM_RADIUS = 0.75f;
    private boolean clearerView = false;
    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<UUID, LightningRender>();

    public Death_Laser_beam_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    public Identifier getTextureLocation(Death_Laser_Beam_Entity entity) {
        return TEXTURE;
    }

    public void render(Death_Laser_Beam_Entity solarBeam, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
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
        this.renderLighting(delta, matrixStackIn, solarBeam, bufferIn);
    }

    private void renderFlatQuad(int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0.0f + 0.0625f * (float)frame;
        float minV = 0.0f;
        float maxU = minU + 0.0625f;
        float maxV = minV + 0.5f;
        PoseStack.Pose matrixstack$entry = matrixStackIn.last();
        this.drawVertex(matrixstack$entry, builder, -0.75f, -0.75f, 0.0f, minU, minV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, -0.75f, 0.75f, 0.0f, minU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 0.75f, 0.75f, 0.0f, maxU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 0.75f, -0.75f, 0.0f, maxU, minV, 1.0f, packedLightIn);
    }

    private void renderLighting(float frame, PoseStack poseStack, Death_Laser_Beam_Entity entity, MultiBufferSource buffer) {
        double x = Mth.lerp((double)frame, (double)entity.xOld, (double)entity.getX());
        double y = Mth.lerp((double)frame, (double)entity.yOld, (double)entity.getY());
        double z = Mth.lerp((double)frame, (double)entity.zOld, (double)entity.getZ());
        double x2 = Mth.lerp((double)frame, (double)entity.prevCollidePosX, (double)entity.collidePosX);
        double y2 = Mth.lerp((double)frame, (double)entity.prevCollidePosY, (double)entity.collidePosY);
        double z2 = Mth.lerp((double)frame, (double)entity.prevCollidePosZ, (double)entity.collidePosZ);
        float f1 = 0.0f;
        if (entity.tickCount > 20) {
            poseStack.pushPose();
            poseStack.translate(-x, -y, -z);
            LightningBoltData.BoltRenderInfo RedboltData = new LightningBoltData.BoltRenderInfo(0.5f, 0.15f, 0.25f, 0.25f, new Vector4f(1.0f, 0.101960786f, 0.0f, 0.9f), 0.86f);
            LightningBoltData bolt1 = new LightningBoltData(RedboltData, new Vec3(x, y, z), new Vec3(x2, y2, z2), 5).size(0.1f).lifespan(1).spawn(LightningBoltData.SpawnFunction.NO_DELAY).fade(LightningBoltData.FadeFunction.NONE);
            LightningBoltData.BoltRenderInfo YellowboltData = new LightningBoltData.BoltRenderInfo(0.5f, 0.1f, 0.25f, 0.15f, new Vector4f(0.9764706f, 0.7607843f, 0.16862746f, 0.7f), 0.86f);
            LightningBoltData bolt2 = new LightningBoltData(YellowboltData, new Vec3(x, y, z), new Vec3(x2, y2, z2), 5).size(0.07f).lifespan(1).spawn(LightningBoltData.SpawnFunction.NO_DELAY).fade(LightningBoltData.FadeFunction.NONE);
            LightningRender lightningRender = this.getLightingRender(entity.getUUID());
            if (!Minecraft.getInstance().isPaused()) {
                lightningRender.update((Object)entity, bolt1, frame);
                lightningRender.update((Object)entity, bolt2, frame);
            }
            lightningRender.render(frame, poseStack, buffer);
            poseStack.popPose();
        }
        if (entity.isRemoved() && this.lightningRenderMap.containsKey(entity.getUUID())) {
            this.lightningRenderMap.remove(entity.getUUID());
        }
    }

    private LightningRender getLightingRender(UUID uuid) {
        if (this.lightningRenderMap.get(uuid) == null) {
            this.lightningRenderMap.put(uuid, new LightningRender());
        }
        return this.lightningRenderMap.get(uuid);
    }

    private void renderStart(int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        if (this.clearerView) {
            return;
        }
        matrixStackIn.pushPose();
        Quaternionf quat = this.entityRenderDispatcher.cameraOrientation();
        matrixStackIn.mulPose(quat);
        this.renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
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
        sideQuat.mul((Quaternionfc)CMMathUtil.quatFromRotationXYZ(90.0f, 0.0f, 0.0f, true));
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
        this.drawVertex(matrixstack$entry, builder, -0.75f, offset, 0.0f, minU, minV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, -0.75f, length, 0.0f, minU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 0.75f, length, 0.0f, maxU, maxV, 1.0f, packedLightIn);
        this.drawVertex(matrixstack$entry, builder, 0.75f, offset, 0.0f, maxU, minV, 1.0f, packedLightIn);
    }

    private void renderBeam(float length, float yaw, float pitch, int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(CMMathUtil.quatFromRotationXYZ(90.0f, 0.0f, 0.0f, true));
        matrixStackIn.mulPose(CMMathUtil.quatFromRotationXYZ(0.0f, 0.0f, yaw - 90.0f, true));
        matrixStackIn.mulPose(CMMathUtil.quatFromRotationXYZ(-pitch, 0.0f, 0.0f, true));
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

