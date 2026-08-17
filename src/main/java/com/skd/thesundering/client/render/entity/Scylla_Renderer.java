/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.bus.api.Event
 *  net.neoforged.neoforge.client.event.RenderLivingEvent$Post
 *  net.neoforged.neoforge.client.event.RenderLivingEvent$Pre
 *  net.neoforged.neoforge.client.event.RenderNameTagEvent
 *  net.neoforged.neoforge.common.NeoForge
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.entity.Scylla_Model;
import com.skd.thesundering.client.render.layer.LayerGenericGlowing;
import com.skd.thesundering.client.render.layer.Scylla_Eye_Spark_Layer;
import com.skd.thesundering.client.render.layer.Scylla_Snake_Layer;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.NeoForge;

@OnlyIn(value=Dist.CLIENT)
public class Scylla_Renderer
extends MobRenderer<Scylla_Entity, Scylla_Model> {
    private static final Identifier SCYLLA_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/scylla_no_snake.png");
    private static final Identifier SCYLLA_EYE_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/scylla_eye.png");

    public Scylla_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Scylla_Model(renderManagerIn.bakeLayer(CMModelLayers.SCYLLA_MODEL)), 0.75f);
        this.addLayer(new Scylla_Snake_Layer(this));
        this.addLayer(new Scylla_Eye_Spark_Layer(this, renderManagerIn));
        this.addLayer(new LayerGenericGlowing(this, SCYLLA_EYE_TEXTURES));
    }

    public Identifier getTextureLocation(Scylla_Entity entity) {
        return SCYLLA_TEXTURES;
    }

    public void render(Scylla_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        Direction direction;
        Entity entity;
        boolean shouldSit;
        if (((RenderLivingEvent.Pre)NeoForge.EVENT_BUS.post((Event)new RenderLivingEvent.Pre((LivingEntity)entityIn, (LivingEntityRenderer)this, partialTicks, matrixStackIn, bufferIn, packedLightIn))).isCanceled()) {
            return;
        }
        matrixStackIn.pushPose();
        ((Scylla_Model)this.model).attackTime = this.getAttackAnim((LivingEntity)entityIn, partialTicks);
        ((Scylla_Model)this.model).riding = shouldSit = entityIn.isPassenger() && entityIn.getVehicle() != null && entityIn.getVehicle().shouldRiderSit();
        ((Scylla_Model)this.model).young = entityIn.isBaby();
        float f = Mth.rotLerp((float)partialTicks, (float)entityIn.yBodyRotO, (float)entityIn.yBodyRot);
        float f1 = Mth.rotLerp((float)partialTicks, (float)entityIn.yHeadRotO, (float)entityIn.yHeadRot);
        float f2 = f1 - f;
        if (shouldSit && (entity = entityIn.getVehicle()) instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entity;
            f = Mth.rotLerp((float)partialTicks, (float)livingentity.yBodyRotO, (float)livingentity.yBodyRot);
            f2 = f1 - f;
            float f7 = Mth.wrapDegrees((float)f2);
            if (f7 < -85.0f) {
                f7 = -85.0f;
            }
            if (f7 >= 85.0f) {
                f7 = 85.0f;
            }
            f = f1 - f7;
            if (f7 * f7 > 2500.0f) {
                f += f7 * 0.2f;
            }
            f2 = f1 - f;
        }
        float f6 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        if (Scylla_Renderer.isEntityUpsideDown((LivingEntity)entityIn)) {
            f6 *= -1.0f;
            f2 *= -1.0f;
        }
        f2 = Mth.wrapDegrees((float)f2);
        if (entityIn.hasPose(Pose.SLEEPING) && (direction = entityIn.getBedOrientation()) != null) {
            float f3 = entityIn.getEyeHeight(Pose.STANDING) - 0.1f;
            matrixStackIn.translate((float)(-direction.getStepX()) * f3, 0.0f, (float)(-direction.getStepZ()) * f3);
        }
        float f8 = entityIn.getScale();
        matrixStackIn.scale(f8, f8, f8);
        float f9 = this.getBob((LivingEntity)entityIn, partialTicks);
        this.setupRotations((LivingEntity)entityIn, matrixStackIn, f9, f, partialTicks, f8);
        matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
        this.scale(entityIn, matrixStackIn, partialTicks);
        matrixStackIn.translate(0.0f, -1.501f, 0.0f);
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (!shouldSit && entityIn.isAlive()) {
            f4 = entityIn.walkAnimation.speed(partialTicks);
            f5 = entityIn.walkAnimation.position(partialTicks);
            if (entityIn.isBaby()) {
                f5 *= 3.0f;
            }
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
        }
        ((Scylla_Model)this.model).prepareMobModel((Entity)entityIn, f5, f4, partialTicks);
        ((Scylla_Model)this.model).setupAnim(entityIn, f5, f4, f9, f2, f6);
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = entityIn.isDeadOrDying() ? false : this.isBodyVisible((LivingEntity)entityIn);
        boolean flag1 = !flag && !entityIn.isInvisibleTo((Player)minecraft.player);
        boolean flag2 = minecraft.shouldEntityAppearGlowing((Entity)entityIn);
        RenderType rendertype = this.getRenderType((LivingEntity)entityIn, flag, flag1, flag2);
        if (rendertype != null) {
            int i;
            VertexConsumer vertexconsumer = bufferIn.getBuffer(rendertype);
            int n = i = entityIn.isDeadOrDying() ? OverlayTexture.NO_OVERLAY : Scylla_Renderer.getOverlayCoords((LivingEntity)entityIn, (float)this.getWhiteOverlayProgress((LivingEntity)entityIn, partialTicks));
            int alpha = entityIn.getAttackState() != 12 ? 255 : (entityIn.attackTicks < 100 ? 255 : Math.max(35, 255 - (entityIn.deathTime - 100) * 255 / (entityIn.deathtimer() - 100)));
            int i1 = FastColor.ARGB32.color((int)alpha, (int)255, (int)255, (int)255);
            ((Scylla_Model)this.model).renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, i, flag1 ? i1 : -1);
        }
        if (!entityIn.isSpectator()) {
            for (RenderLayer renderlayer : this.layers) {
                renderlayer.render(matrixStackIn, bufferIn, packedLightIn, (Entity)entityIn, f5, f4, partialTicks, f9, f2, f6);
            }
        }
        matrixStackIn.popPose();
        this.renderetc(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        NeoForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post((LivingEntity)entityIn, (LivingEntityRenderer)this, partialTicks, matrixStackIn, bufferIn, packedLightIn));
        this.shadowRadius = entityIn.getAct() ? 0.75f : 0.0f;
    }

    private void renderetc(Scylla_Entity p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        RenderNameTagEvent event = new RenderNameTagEvent((Entity)p_entity, p_entity.getDisplayName(), (EntityRenderer)this, poseStack, bufferSource, packedLight, partialTick);
        NeoForge.EVENT_BUS.post((Event)event);
        if (event.canRender().isTrue() || event.canRender().isDefault() && this.shouldShowName((Mob)p_entity)) {
            this.renderNameTag((Entity)p_entity, event.getContent(), poseStack, bufferSource, packedLight, partialTick);
        }
    }

    public boolean shouldRender(Scylla_Entity livingentity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender((Entity)livingentity, camera, camX, camY, camZ)) {
            return true;
        }
        Entity weapon = livingentity.getAnchor();
        if (weapon != null) {
            Vec3 vec3 = livingentity.position();
            Vec3 vec31 = weapon.position();
            return camera.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
        }
        return false;
    }

    protected float getFlipDegrees(Scylla_Entity entity) {
        return 0.0f;
    }

    protected void scale(Scylla_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.15f, 1.15f, 1.15f);
    }
}

