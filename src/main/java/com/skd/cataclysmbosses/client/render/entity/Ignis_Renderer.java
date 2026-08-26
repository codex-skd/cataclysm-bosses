/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Ignis_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.client.render.RenderUtils;
import com.skd.cataclysmbosses.client.render.layer.Ignis_Armor_Crack_Layer;
import com.skd.cataclysmbosses.client.render.layer.Ignis_Shield_Layer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ignis_Renderer
extends CmMobRenderer<Ignis_Entity> {
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[8];
    private static final Identifier[] TEXTURE_SOUL_PROGRESS = new Identifier[8];

    public Ignis_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Ignis_Model(), 1.0f);
        this.addLayer(new Ignis_Armor_Crack_Layer(this));
        this.addLayer(new Ignis_Shield_Layer(this));
        for (int i = 0; i < 8; ++i) {
            Ignis_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/ignis/ignis_idle_" + i + ".png"));
            Ignis_Renderer.TEXTURE_SOUL_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/ignis/ignis_soul_idle_" + i + ".png"));
        }
    }

    public Identifier getTextureLocation(Ignis_Entity entity) {
        return this.getGrowingTexture(entity, (int)((float)entity.tickCount * 0.5f % 8.0f));
    }

    public Identifier getGrowingTexture(Ignis_Entity entity, int age) {
        return entity.getBossPhase() > 0 ? TEXTURE_SOUL_PROGRESS[Mth.clamp((int)age, (int)0, (int)7)] : TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)7)];
    }

    protected void render(Ignis_Entity entity, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        if (entity.getAnimation() == Ignis_Entity.HORIZONTAL_SWING_ATTACK || entity.getAnimation() == Ignis_Entity.SWING_ATTACK || entity.getAnimation() == Ignis_Entity.HORIZONTAL_SWING_ATTACK_SOUL || entity.getAnimation() == Ignis_Entity.SWING_ATTACK_SOUL || entity.getAnimation() == Ignis_Entity.SWING_ATTACK_BERSERK || entity.getAnimation() == Ignis_Entity.REINFORCED_SMASH_IN_AIR || entity.getAnimation() == Ignis_Entity.REINFORCED_SMASH_IN_AIR_SOUL || entity.getAnimation() == Ignis_Entity.PHASE_3 || entity.getAnimation() == Ignis_Entity.SPIN_ATTACK || entity.getAnimation() == Ignis_Entity.ULTIMATE_ATTACK || entity.getAnimation() == Ignis_Entity.STRIKE || entity.getAnimation() == Ignis_Entity.COMBO1 || entity.getAnimation() == Ignis_Entity.COMBO2 || entity.getAnimation() == Ignis_Entity.SHIELD_BREAK_STRIKE || entity.getAnimation() == Ignis_Entity.HORIZONTAL_SMALL_SWING_ATTACK || entity.getAnimation() == Ignis_Entity.HORIZONTAL_SMALL_SWING_ALT_ATTACK2 || entity.getAnimation() == Ignis_Entity.SWING_UPPERSLASH) {
            Vec3 bladePos = RenderUtils.matrixStackFromCitadelModel((Entity)entity, entityYaw, ((Ignis_Model)this.model).blade2);
            entity.setSocketPosArray(0, bladePos);
        }
        matrixStackIn.pushPose();
        Vec3 endBeam = entity.ClientTargetPosition(partialTicks);
        Vec3 startBeam = this.getPosition((LivingEntity)entity, 0.03, partialTicks);
        if (endBeam != null) {
            float beamVecX = (float)(endBeam.x - startBeam.x);
            float beamVecZ = (float)(endBeam.z - startBeam.z);
            this.renderBeams(entity, beamVecX, 0.0f, beamVecZ, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        }
        matrixStackIn.popPose();
    }

    private Vec3 getPosition(LivingEntity livingEntity, double yOffset, float partialTick) {
        double d0 = Mth.lerp((double)partialTick, (double)livingEntity.xOld, (double)livingEntity.getX());
        double d1 = Mth.lerp((double)partialTick, (double)livingEntity.yOld, (double)livingEntity.getY()) + yOffset;
        double d2 = Mth.lerp((double)partialTick, (double)livingEntity.zOld, (double)livingEntity.getZ());
        return new Vec3(d0, d1, d2);
    }

    private void renderBeams(Ignis_Entity entity, float x, float y, float z, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        float f = Mth.sqrt((float)(x * x + z * z));
        float f1 = Mth.sqrt((float)(x * x + y * y + z * z));
        if (f1 < 0.01f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.15f, 0.0f);
        poseStack.mulPose(Axis.YP.rotation((float)(-Math.atan2(z, x)) - 1.5707964f));
        poseStack.mulPose(Axis.XP.rotation((float)(-Math.atan2(f, y)) - 1.5707964f));
        VertexConsumer vertexconsumer = bufferSource.getBuffer(CMRenderTypes.CMLightning());
        PoseStack.Pose posestack$pose = poseStack.last();
        int alpha = 255;
        float beamLength = f1;
        float beamWidth = 0.7f;
        float widthHalf = beamWidth / 2.0f;
        float ax = -widthHalf;
        float ay = 0.0f;
        float az = 0.0f;
        float bx = widthHalf;
        float by = 0.0f;
        float bz = 0.0f;
        float cx = -widthHalf;
        float cy = 0.0f;
        float cz = beamLength;
        float dx = widthHalf;
        float dy = 0.0f;
        float dz = beamLength;
        int r = entity.getBossPhase() > 0 ? 2 : 255;
        int g = entity.getBossPhase() > 0 ? 199 : 215;
        int b = entity.getBossPhase() > 0 ? 203 : 63;
        vertexconsumer.addVertex(posestack$pose, ax, ay, az).setColor(r, g, b, alpha).setLight(packedLight);
        vertexconsumer.addVertex(posestack$pose, bx, by, bz).setColor(r, g, b, alpha).setLight(packedLight);
        vertexconsumer.addVertex(posestack$pose, dx, dy, dz).setColor(0, 0, 0, alpha).setLight(packedLight);
        vertexconsumer.addVertex(posestack$pose, cx, cy, cz).setColor(0, 0, 0, alpha).setLight(packedLight);
        poseStack.popPose();
    }

    protected int getBlockLightLevel(Ignis_Entity entityIn, BlockPos pos) {
        return 15;
    }

    protected float getFlipDegrees(Ignis_Entity entity) {
        return 0.0f;
    }
}

