/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Tidal_Tentacle_Claws_Model;
import com.skd.cataclysmbosses.client.model.entity.Tidal_Tentacle_Model;
import com.skd.cataclysmbosses.entity.projectile.Tidal_Tentacle_Entity;
import com.skd.cataclysmbosses.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Tidal_Tentacle_Renderer
extends EntityRenderer<Tidal_Tentacle_Entity, EntityRenderState> {
    private static final Identifier CLAW_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/tidal_tentacle_claws.png");
    private static final Identifier TENTACLE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/tidal_tentacle.png");
    private static final Tidal_Tentacle_Claws_Model CLAW_MODEL = new Tidal_Tentacle_Claws_Model();
    private static final Tidal_Tentacle_Model TONGUE_MODEL = new Tidal_Tentacle_Model();
    public static final int MAX_NECK_SEGMENTS = 128;

    public Tidal_Tentacle_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public boolean shouldRender(Tidal_Tentacle_Entity entity, Frustum frustum, double x, double y, double z) {
        Entity next = entity.getFromEntity();
        return next != null && frustum.isVisible(entity.getBoundingBox().minmax(next.getBoundingBox())) || super.shouldRender((Entity)entity, frustum, x, y, z);
    }

    public void render(Tidal_Tentacle_Entity entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light) {
        super.render((Entity)entity, yaw, partialTicks, poseStack, buffer, light);
        poseStack.pushPose();
        Entity fromEntity = entity.getFromEntity();
        float x = (float)Mth.lerp((double)partialTicks, (double)entity.xo, (double)entity.getX());
        float y = (float)Mth.lerp((double)partialTicks, (double)entity.yo, (double)entity.getY());
        float z = (float)Mth.lerp((double)partialTicks, (double)entity.zo, (double)entity.getZ());
        if (fromEntity != null) {
            float progress = (entity.prevProgress + (entity.getProgress() - entity.prevProgress) * partialTicks) / 5.0f;
            Vec3 distVec = this.getPositionOfPriorMob(entity, fromEntity, partialTicks).subtract((double)x, (double)y, (double)z);
            Vec3 to = distVec.scale((double)(1.0f - progress));
            Vec3 from = distVec;
            Vec3 currentNeckButt = from;
            VertexConsumer neckConsumer = buffer.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)TENTACLE_TEXTURE));
            double remainingDistance = to.distanceTo(from);
            for (int segmentCount = 0; segmentCount < 128 && remainingDistance > 0.0; ++segmentCount) {
                Vec3 powVec;
                remainingDistance = Math.min(from.distanceTo(to), 0.5);
                Vec3 linearVec = to.subtract(currentNeckButt);
                Vec3 smoothedVec = powVec = new Vec3(this.modifyVecAngle(linearVec.x), this.modifyVecAngle(linearVec.y), this.modifyVecAngle(linearVec.z));
                Vec3 next = smoothedVec.normalize().scale(remainingDistance).add(currentNeckButt);
                int neckLight = this.getLightColor(entity, to.add(currentNeckButt).add((double)x, (double)y, (double)z));
                Tidal_Tentacle_Renderer.renderNeckCube(currentNeckButt, next, poseStack, neckConsumer, neckLight, OverlayTexture.NO_OVERLAY, 0.0f);
                currentNeckButt = next;
            }
            VertexConsumer clawConsumer = buffer.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)CLAW_TEXTURE));
            if (entity.hasClaw() || entity.isRetracting()) {
                poseStack.pushPose();
                poseStack.translate(to.x, to.y, to.z);
                float rotY = (float)(Mth.atan2((double)to.x, (double)to.z) * 57.2957763671875);
                float rotX = (float)(-(Mth.atan2((double)to.y, (double)to.horizontalDistance()) * 57.2957763671875));
                CLAW_MODEL.setAttributes(rotX, rotY);
                CLAW_MODEL.renderToBuffer(poseStack, clawConsumer, this.getLightColor(entity, to.add((double)x, (double)y, (double)z)), OverlayTexture.NO_OVERLAY, -1);
                poseStack.popPose();
            }
        }
        poseStack.popPose();
    }

    public static void renderNeckCube(Vec3 from, Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int overlayCoords, float additionalYaw) {
        Vec3 sub = from.subtract(to);
        double d = sub.horizontalDistance();
        float rotY = (float)(Mth.atan2((double)sub.x, (double)sub.z) * 57.2957763671875);
        float rotX = (float)(-(Mth.atan2((double)sub.y, (double)d) * 57.2957763671875)) - 90.0f;
        poseStack.pushPose();
        poseStack.translate(from.x, from.y, from.z);
        TONGUE_MODEL.setAttributes((float)sub.length(), rotX, rotY, additionalYaw);
        TONGUE_MODEL.renderToBuffer(poseStack, buffer, packedLightIn, overlayCoords, -1);
        poseStack.popPose();
    }

    private Vec3 getPositionOfPriorMob(Tidal_Tentacle_Entity segment, Entity mob, float partialTicks) {
        double d4 = Mth.lerp((double)partialTicks, (double)mob.xo, (double)mob.getX());
        double d5 = Mth.lerp((double)partialTicks, (double)mob.yo, (double)mob.getY());
        double d6 = Mth.lerp((double)partialTicks, (double)mob.zo, (double)mob.getZ());
        float f3 = 0.0f;
        if (mob instanceof Player && segment.isCreator(mob)) {
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
                d5 = player.yo + (double)player.getEyeHeight() + (player.getY() - player.yo) * (double)partialTicks - 1.0;
                d6 = Mth.lerp((double)partialTicks, (double)player.zo, (double)player.getZ()) - d0 * d2 + d1 * 0.2;
                f3 = (player.isCrouching() ? -0.1875f : 0.0f) - player.getEyeHeight() * 0.4f;
            }
        }
        return new Vec3(d4, d5 + (double)f3, d6);
    }

    private double modifyVecAngle(double dimension) {
        float abs = (float)Math.abs(dimension);
        return Math.signum(dimension) * Mth.clamp((double)Math.pow(abs, 0.1), (double)(0.05 * (double)abs), (double)abs);
    }

    private int getLightColor(Entity head, Vec3 vec3) {
        BlockPos blockpos = BlockPos.containing((Position)vec3);
        if (head.level().hasChunkAt(blockpos)) {
            int i = LevelRenderer.getLightColor((BlockAndTintGetter)head.level(), (BlockPos)blockpos);
            int j = LevelRenderer.getLightColor((BlockAndTintGetter)head.level(), (BlockPos)blockpos.above());
            int k = i & 0xFF;
            int l = j & 0xFF;
            int i1 = i >> 16 & 0xFF;
            int j1 = j >> 16 & 0xFF;
            return (k > l ? k : l) | (i1 > j1 ? i1 : j1) << 16;
        }
        return 0;
    }

    public Identifier getTextureLocation(Tidal_Tentacle_Entity entity) {
        return CLAW_TEXTURE;
    }
}

