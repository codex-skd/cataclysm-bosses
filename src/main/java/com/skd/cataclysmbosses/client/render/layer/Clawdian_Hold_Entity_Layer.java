/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.client.model.entity.Clawdian_Model;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Clawdian_Hold_Entity_Layer
extends RenderLayer<Clawdian_Entity, Clawdian_Model> {
    private final EntityRenderDispatcher entityRenderer;

    public Clawdian_Hold_Entity_Layer(RenderLayerParent<Clawdian_Entity, Clawdian_Model> renderer, EntityRenderDispatcher entityRenderer) {
        super(renderer);
        this.entityRenderer = entityRenderer;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Clawdian_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.isVehicle()) {
            for (Entity passenger : entity.getPassengers()) {
                if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) continue;
                this.renderEntityInClaw(partialTicks, matrixStackIn, bufferIn, packedLightIn, passenger, this.entityRenderer);
            }
        }
    }

    public void renderEntityInClaw(float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, Entity entity, EntityRenderDispatcher entityRenderer) {
        Cataclysm.PROXY.releaseRenderingEntity(entity.getUUID());
        poseStack.pushPose();
        ((Clawdian_Model)this.getParentModel()).translateToHand(poseStack);
        poseStack.translate(0.0f, -0.25f, 0.0f);
        poseStack.scale(1.0f, 1.0f, 1.0f);
        entityRenderer.render(entity, 0.0, 0.0, 0.0, 0.0f, partialTick, poseStack, buffer, packedLight);
        poseStack.popPose();
        Cataclysm.PROXY.blockRenderingEntity(entity.getUUID());
    }
}

