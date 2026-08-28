/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.The_Leviathan_Model;
import com.skd.cataclysmbosses.client.model.entity.The_Leviathan_Tongue_End_Model;
import com.skd.cataclysmbosses.client.model.entity.The_Leviathan_Tongue_Model;
import com.skd.cataclysmbosses.client.render.RenderUtils;
import com.skd.cataclysmbosses.client.render.layer.LayerBasicGlow;
import com.skd.cataclysmbosses.client.render.layer.The_Leviathan_Layer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Part;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.LevelRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
// import net.minecraft.world.level.BlockAndTintGetter; // Removed in 26.2
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Leviathan_Renderer
extends CmMobRenderer<The_Leviathan_Entity> {
    private static final Identifier LEVIATHAN_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/the_leviathan.png");
    private static final Identifier BURNING_LEVIATHAN_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/the_burning_leviathan.png");
    private static final Identifier LEVIATHAN_TEXTURE_EYES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/the_leviathan_eye.png");
    private final RandomSource rnd = RandomSource.create();
    private static final The_Leviathan_Tongue_Model TONGUE_MODEL = new The_Leviathan_Tongue_Model();
    private static final The_Leviathan_Tongue_End_Model TONGUE_END_MODEL = new The_Leviathan_Tongue_End_Model();

    public The_Leviathan_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new The_Leviathan_Model(), 1.5f);
        this.addLayer(new The_Leviathan_Layer(this));
        this.addLayer(new LayerBasicGlow(this, LEVIATHAN_TEXTURE_EYES));
    }

    public Identifier getTextureLocation(The_Leviathan_Entity entity) {
        return entity.getMeltDown() ? BURNING_LEVIATHAN_TEXTURES : LEVIATHAN_TEXTURES;
    }

    public boolean shouldRender(The_Leviathan_Entity livingentity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender((Entity)livingentity, camera, camX, camY, camZ)) {
            return true;
        }
        for (The_Leviathan_Part part : livingentity.leviathanParts) {
            if (!camera.isVisible(part.getBoundingBox())) continue;
            return true;
        }
        Entity weapon = livingentity.getTongue();
        if (weapon != null) {
            Vec3 vec3 = livingentity.position();
            Vec3 vec31 = weapon.position();
            return camera.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
        }
        return false;
    }

    public Vec3 getRenderOffset(The_Leviathan_Entity entity, float partialTicks) {
        if (entity.getAnimation() == The_Leviathan_Entity.LEVIATHAN_ABYSS_BLAST && entity.getAnimationTick() <= 66) {
            double d0 = 0.01;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0, this.rnd.nextGaussian() * d0);
        }
        return super.getRenderOffset((Entity)entity, partialTicks);
    }

    protected void render(The_Leviathan_Entity entity, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        if (entity.getAnimation() == The_Leviathan_Entity.LEVIATHAN_TAIL_WHIPS) {
            Vec3 bladePos = RenderUtils.matrixStackFromCitadelModel((Entity)entity, entityYaw, ((The_Leviathan_Model)this.model).Tail_Particle);
            entity.setSocketPosArray(0, bladePos);
        }
        double x = Mth.lerp((double)partialTicks, (double)entity.xOld, (double)entity.getX());
        double y = Mth.lerp((double)partialTicks, (double)entity.yOld, (double)entity.getY());
        double z = Mth.lerp((double)partialTicks, (double)entity.zOld, (double)entity.getZ());
        float yaw = entity.yBodyRotO + (entity.yBodyRot - entity.yBodyRotO) * partialTicks;
        Entity weapon = entity.getTongue();
        if (weapon != null && entity.isAlive() && weapon.isAlive()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(-x, -y, -z);
            Vec3 headModelPos = ((The_Leviathan_Model)this.getModel()).translateToTongue(new Vec3(0.0, 0.0, 0.0), yaw).scale(0.2);
            Vec3 fromVec = entity.getTonguePosition().add(headModelPos);
            Vec3 toVec = weapon.getPosition(partialTicks);
            Vec3 currentNeckButt = fromVec;
            VertexConsumer neckConsumer = bufferIn.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)LEVIATHAN_TEXTURES));
            double remainingDistance = toVec.distanceTo(fromVec);
            for (int segmentCount = 0; segmentCount < 128 && remainingDistance > 0.0; ++segmentCount) {
                Vec3 powVec;
                remainingDistance = Math.min(fromVec.distanceTo(toVec), 0.5);
                Vec3 linearVec = toVec.subtract(currentNeckButt);
                Vec3 smoothedVec = powVec = new Vec3(this.modifyVecAngle(linearVec.x), this.modifyVecAngle(linearVec.y), this.modifyVecAngle(linearVec.z));
                Vec3 next = smoothedVec.normalize().scale(remainingDistance).add(currentNeckButt);
                int neckLight = this.getLightColor((Entity)entity, toVec.add(currentNeckButt).add(x, y, z));
                The_Leviathan_Renderer.renderNeckCube(currentNeckButt, next, matrixStackIn, neckConsumer, neckLight, OverlayTexture.NO_OVERLAY, 0.0f);
                currentNeckButt = next;
            }
            VertexConsumer clawConsumer = bufferIn.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)LEVIATHAN_TEXTURES));
            matrixStackIn.pushPose();
            matrixStackIn.translate(toVec.x, toVec.y, toVec.z);
            matrixStackIn.translate(0.0f, -0.5f, 0.0f);
            float rotY = (float)(Mth.atan2((double)toVec.x, (double)toVec.z) * 57.2957763671875);
            float rotX = (float)(-(Mth.atan2((double)toVec.y, (double)toVec.horizontalDistance()) * 57.2957763671875));
            TONGUE_END_MODEL.setAttributes(rotX, rotY);
            TONGUE_END_MODEL.renderToBuffer(matrixStackIn, clawConsumer, this.getLightColor((Entity)entity, toVec.add(x, y, z)), OverlayTexture.NO_OVERLAY, -1);
            matrixStackIn.popPose();
            matrixStackIn.popPose();
        }
    }

    private double modifyVecAngle(double dimension) {
        float abs = (float)Math.abs(dimension);
        return Math.signum(dimension) * Mth.clamp((double)Math.pow(abs, 0.7), (double)(0.005 * (double)abs), (double)abs);
    }

    public static void renderNeckCube(Vec3 from, Vec3 to, PoseStack matrixStackIn, VertexConsumer buffer, int packedLightIn, int overlayCoords, float additionalYaw) {
        Vec3 sub = from.subtract(to);
        double d = sub.horizontalDistance();
        float rotY = (float)(Mth.atan2((double)sub.x, (double)sub.z) * 57.2957763671875);
        float rotX = (float)(-(Mth.atan2((double)sub.y, (double)d) * 57.2957763671875)) - 90.0f;
        matrixStackIn.pushPose();
        matrixStackIn.translate(from.x, from.y, from.z);
        matrixStackIn.translate(0.0f, -0.5f, 0.0f);
        TONGUE_MODEL.setAttributes((float)sub.length(), rotX, rotY, additionalYaw);
        TONGUE_MODEL.renderToBuffer(matrixStackIn, buffer, packedLightIn, overlayCoords, -1);
        matrixStackIn.popPose();
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

    protected void scale(The_Leviathan_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.75f, 1.75f, 1.75f);
    }

    protected float getFlipDegrees(The_Leviathan_Entity entity) {
        return 0.0f;
    }
}

