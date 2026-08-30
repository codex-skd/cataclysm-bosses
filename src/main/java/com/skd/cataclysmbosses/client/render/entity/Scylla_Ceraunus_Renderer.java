/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Ceraunus_Model;
import com.skd.cataclysmbosses.client.model.entity.Scylla_Model;
import com.skd.cataclysmbosses.client.render.entity.Scylla_Renderer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Ceraunus_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Scylla_Ceraunus_Renderer
extends CmEntityRenderer<Scylla_Ceraunus_Entity> {
    private final Ceraunus_Model model;
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/ceraunus.png");
    private static final Identifier CHAIN_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/scylla_chain.png");

    public Scylla_Ceraunus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        this.model = new Ceraunus_Model(renderManagerIn.bakeLayer(CMModelLayers.CERAUNUS_MODEL));
    }

    protected void render(Scylla_Ceraunus_Entity entity, float tickDelta, PoseStack matrices, CmMultiBufferSource provider, int light) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public boolean shouldRender(Scylla_Ceraunus_Entity entity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(entity, camera, camX, camY, camZ)) {
            return true;
        }
        Entity weapon = entity.getController();
        if (weapon != null) {
            Vec3 vec3 = entity.position();
            Vec3 vec31 = weapon.position();
            return camera.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
        }
        return false;
    }

    private Vec3 getPositionOfPriorMob(Entity mob, float partialTicks) {
        double d4 = Mth.lerp((double)partialTicks, (double)mob.xo, (double)mob.getX());
        double d5 = Mth.lerp((double)partialTicks, (double)mob.yo, (double)mob.getY());
        double d6 = Mth.lerp((double)partialTicks, (double)mob.zo, (double)mob.getZ());
        // PORT TODO(26.2): anchored-hand offset relied on Scylla_Renderer.getModel() +
        // Scylla_Model.getHandPosition(Vec3); both dropped while Scylla rendering is stubbed.
        // Falls back to the mob's plain interpolated position.
        return new Vec3(d4, d5, d6);
    }

    public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
        double d = to.horizontalDistance();
        float rotY = (float)(Mth.atan2((double)to.x, (double)to.z) * 57.2957763671875);
        float rotX = (float)(-(Mth.atan2((double)to.y, (double)d) * 57.2957763671875)) - 90.0f;
        float chainWidth = 0.1875f;
        float chainOffset = chainWidth * -0.5f;
        float chainLength = (float)to.length() / 2.3f;
        poseStack.pushPose();
        poseStack.scale(2.3f, 2.3f, 2.3f);
        poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
        poseStack.translate(0.0f, -chainLength, 0.0f);
        PoseStack.Pose posestack$pose = poseStack.last();
        buffer.addVertex(posestack$pose, chainOffset, 0.0f, 0.0f).setColor(255, 255, 255, 255).setUv(0.0f, chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, chainWidth + chainOffset, 0.0f, 0.0f).setColor(255, 255, 255, 255).setUv(chainWidth, chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, chainWidth + chainOffset, chainLength, 0.0f).setColor(255, 255, 255, 255).setUv(chainWidth, 0.0f).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, chainOffset, chainLength, 0.0f).setColor(255, 255, 255, 255).setUv(0.0f, 0.0f).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        float pixelSkip = 0.25f;
        buffer.addVertex(posestack$pose, 0.0f, pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth, chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, 0.0f, pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth * 2.0f, chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, 0.0f, chainLength + pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth * 2.0f, pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, 0.0f, chainLength + pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth, pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        poseStack.popPose();
    }

    public Identifier getTextureLocation(Scylla_Ceraunus_Entity entity) {
        return TEXTURE;
    }
}

