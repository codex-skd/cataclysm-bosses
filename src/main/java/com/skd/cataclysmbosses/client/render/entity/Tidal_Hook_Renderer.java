/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Tidal_Hook_Model;
import com.skd.cataclysmbosses.entity.projectile.Tidal_Hook_Entity;
import com.skd.cataclysmbosses.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
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
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Tidal_Hook_Renderer
extends CmEntityRenderer<Tidal_Hook_Entity> {
    private final Tidal_Hook_Model model = new Tidal_Hook_Model();
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/tidal_hook.png");
    private static final Identifier CHAIN_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/tidal_hook_chain.png");
    private static final RenderType CHAIN_LAYER = RenderType.entitySmoothCutout((Identifier)CHAIN_TEXTURE);

    public Tidal_Hook_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    protected void render(Tidal_Hook_Entity entity, float tickDelta, PoseStack matrices, CmMultiBufferSource provider, int light) {
        matrices.pushPose();
        float yRot = Mth.lerp((float)tickDelta, (float)entity.yRotO, (float)entity.getYRot());
        float xRot = Mth.lerp((float)tickDelta, (float)entity.xRotO, (float)entity.getXRot());
        matrices.mulPose(Axis.YP.rotationDegrees(yRot - 90.0f));
        matrices.mulPose(Axis.ZP.rotationDegrees(xRot + 90.0f));
        VertexConsumer vertexConsumer = provider.getBuffer(RenderTypes.entityCutout(this.getTextureLocation(entity)));
        this.model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY, -1);
        matrices.popPose();
        Entity fromEntity = entity.getOwner();
        if (fromEntity != null) {
            Vec3 entityPos = entity.getPosition(tickDelta);
            PoseStack poseForModel = new PoseStack();
            poseForModel.mulPose(Axis.YP.rotationDegrees(yRot - 90.0f));
            poseForModel.mulPose(Axis.ZP.rotationDegrees(xRot + 90.0f));
            Vec3 modelOffset = this.model.getChainPosition(new Vec3(0.0, 0.0, 0.0), poseForModel);
            Vec3 fromPos = this.getPositionOfPriorMob(fromEntity, tickDelta);
            Vec3 chainTo = fromPos.subtract(entityPos);
            Vec3 chainBase = modelOffset;
            matrices.pushPose();
            matrices.translate(chainBase.x, chainBase.y, chainBase.z);
            VertexConsumer chainBuffer = provider.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)CHAIN_TEXTURE));
            Tidal_Hook_Renderer.renderChainCube(chainTo.subtract(chainBase), matrices, chainBuffer, light, OverlayTexture.NO_OVERLAY);
            matrices.popPose();
        }
    }

    public boolean shouldRender(Tidal_Hook_Entity entity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender((Entity)entity, camera, camX, camY, camZ)) {
            return true;
        }
        Entity weapon = entity.getOwner();
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
        float f3 = 0.0f;
        if (mob instanceof Player) {
            Player player = (Player)mob;
            float f = player.getAttackAnim(partialTicks);
            float f1 = Mth.sin((float)(Mth.sqrt((float)f) * (float)Math.PI));
            float f2 = Mth.lerp((float)partialTicks, (float)player.yBodyRotO, (float)player.yBodyRot) * ((float)Math.PI / 180);
            int i = player.getMainArm() == HumanoidArm.RIGHT ? 1 : -1;
            ItemStack itemstack = player.getMainHandItem();
            if (!itemstack.is((Item)ModItems.TIDAL_CLAWS.get())) {
                i = -i;
            }
            double d0 = Mth.sin((float)f2);
            double d1 = Mth.cos((float)f2);
            double d2 = (double)i * 0.35;
            if ((this.entityRenderDispatcher.options == null || this.entityRenderDispatcher.options.getCameraType().isFirstPerson()) && player == Minecraft.getInstance().player) {
                double d7 = 960.0 / (double)((Integer)this.entityRenderDispatcher.options.fov().get()).intValue();
                Vec3 vec3 = this.entityRenderDispatcher.camera.getNearPlane().getPointOnPlane((float)i * 0.6f, -1.0f);
                vec3 = vec3.scale(d7);
                vec3 = vec3.yRot(f1 * 0.25f);
                vec3 = vec3.xRot(-f1 * 0.35f);
                d4 = Mth.lerp((double)partialTicks, (double)player.xo, (double)player.getX()) + vec3.x;
                d5 = Mth.lerp((double)partialTicks, (double)player.yo, (double)player.getY()) + vec3.y;
                d6 = Mth.lerp((double)partialTicks, (double)player.zo, (double)player.getZ()) + vec3.z;
                f3 = player.getEyeHeight() * 0.5f;
            } else {
                d4 = Mth.lerp((double)partialTicks, (double)player.xo, (double)player.getX()) - d1 * d2 - d0 * 0.2;
                d5 = player.yo + (double)player.getEyeHeight() + (player.getY() - player.yo) * (double)partialTicks - 0.45;
                d6 = Mth.lerp((double)partialTicks, (double)player.zo, (double)player.getZ()) - d0 * d2 + d1 * 0.2;
                f3 = player.isCrouching() ? -0.1875f : 0.0f;
            }
        }
        return new Vec3(d4, d5 + (double)f3, d6);
    }

    public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
        double d = to.horizontalDistance();
        float rotY = (float)(Mth.atan2((double)to.x, (double)to.z) * 57.2957763671875);
        float rotX = (float)(-(Mth.atan2((double)to.y, (double)d) * 57.2957763671875)) - 90.0f;
        float chainWidth = 0.09375f;
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
        float pixelSkip = 0.125f;
        buffer.addVertex(posestack$pose, 0.0f, pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth, chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, 0.0f, pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth * 2.0f, chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, 0.0f, chainLength + pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth * 2.0f, pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        buffer.addVertex(posestack$pose, 0.0f, chainLength + pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv(chainWidth, pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0f, 1.0f, 0.0f);
        poseStack.popPose();
    }

    public Identifier getTextureLocation(Tidal_Hook_Entity entity) {
        return TEXTURE;
    }
}

