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
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderState;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Water_Spear_Renderer
extends CmEntityRenderer<Water_Spear_Entity> {
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[6];
    public Elemental_Spear_Model model;

    public Water_Spear_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new Elemental_Spear_Model(manager.bakeLayer(CMModelLayers.ELEMENTAL_SPEAR_MODEL));
        for (int i = 0; i < 6; ++i) {
            Water_Spear_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/sea/spear/water_spear_" + i + ".png"));
        }
    }

    protected void render(Water_Spear_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        CmEntityRenderState state = new CmEntityRenderState();
        state.entity = entity;
        state.partialTick = partialTicks;
        this.model.setupAnim(state);
        VertexConsumer vertexconsumer = buffer.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entity)));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
        poseStack.popPose();
    }

    public Identifier getTextureLocation(Water_Spear_Entity entity) {
        return this.getGrowingTexture((int)((float)entity.tickCount * 0.5f % 5.0f));
    }

    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)5)];
    }
}

