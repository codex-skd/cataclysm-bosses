package com.skd.cataclysmbosses.client.render.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.AABB;

/**
 * PORT NOTE (26.2): compat bridge for the 33 MobRenderer-based bosses.
 * Extends the simple CmEntityRenderer bridge and adds the Mob/LivingEntity helpers
 * that old bodies called. All helpers are stubs returning safe defaults — enough for
 * compile and basic in-game rendering; proper animation via LivingEntityRenderState
 * is tracked for the follow-up model/animation cluster.
 */
public abstract class CmMobRenderer<T extends Mob>
extends CmEntityRenderer<T> {
    @SuppressWarnings("rawtypes")
    protected final java.util.List layersRaw = new java.util.ArrayList();
    protected float shadowRadius;

    protected CmMobRenderer(EntityRendererProvider.Context context, float shadowRadius) {
        super(context);
        this.shadowRadius = shadowRadius;
    }

    // Old MobRenderer ctor took (context, model, shadow) — keep compat overload
    protected CmMobRenderer(EntityRendererProvider.Context context, Object model, float shadowRadius) {
        this(context, shadowRadius);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected boolean addLayer(Object layer) {
        return this.layersRaw.add(layer);
    }

    // Stubs for old LivingEntityRenderer helpers called from Scylla_Renderer etc.
    protected float getAttackAnim(LivingEntity entity, float partialTicks) { return 0.0F; }
    protected float getBob(LivingEntity entity, float partialTicks) { return 0.0F; }
    protected void setupRotations(LivingEntity entity, PoseStack poseStack, float bob, float yBodyRot, float partialTicks, float scale) {}
    protected void scale(T entity, PoseStack poseStack, float partialTicks) {}
    protected boolean isBodyVisible(LivingEntity entity) { return true; }
    protected float getWhiteOverlayProgress(LivingEntity entity, float partialTicks) { return 0.0F; }
    protected net.minecraft.client.renderer.rendertype.RenderType getRenderType(LivingEntity entity, boolean bodyVisible, boolean translucent, boolean glowing) { return null; }
    protected float getFlipDegrees(T entity) { return 90.0F; }
    protected boolean isShaking(T entity) { return false; }
    protected boolean shouldShowName(Mob entity) { return false; }
    // getOverlayCoords — old LivingEntityRenderer static
    public static int getOverlayCoords(LivingEntity entity, float whiteOverlayProgress) {
        return net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;
    }
    protected boolean isEntityUpsideDown(LivingEntity entity) { return false; }
    protected AABB getBoundingBoxForCulling(T entity) { return entity.getBoundingBox(); }
    protected boolean affectedByCulling(T entity) { return true; }
    protected void renderNameTag(T entity, net.minecraft.network.chat.Component displayName, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight, float partialTicks) {}
}
