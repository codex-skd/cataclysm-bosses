/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Elemental_Spear_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Water_Spear_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Water_Spear_Renderer
extends EntityRenderer<Water_Spear_Entity> {
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[6];
    public Elemental_Spear_Model model;

    public Water_Spear_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new Elemental_Spear_Model(manager.bakeLayer(CMModelLayers.ELEMENTAL_SPEAR_MODEL));
        for (int i = 0; i < 6; ++i) {
            Water_Spear_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/sea/spear/water_spear_" + i + ".png"));
        }
    }

    public void render(Water_Spear_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entity.xRotO, (float)entity.getXRot());
        this.model.setupAnim(entity, 0.0f, 0.0f, (float)entity.tickCount + partialTicks, f, f1);
        VertexConsumer vertexconsumer = buffer.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entity)));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render((Entity)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    public Identifier getTextureLocation(Water_Spear_Entity entity) {
        return this.getGrowingTexture((int)((float)entity.tickCount * 0.5f % 5.0f));
    }

    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)5)];
    }
}

