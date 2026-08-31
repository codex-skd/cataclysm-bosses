/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Wave_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.effect.Wave_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderState;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Wave_Renderer
extends CmEntityRenderer<Wave_Entity> {
    private static final Identifier WAVE_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/wave.png");
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[5];
    public Wave_Model model;

    public Wave_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new Wave_Model(manager.bakeLayer(CMModelLayers.WAVE_MODEL));
        for (int i = 0; i < 5; ++i) {
            Wave_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/sea/wave/wave_" + i + ".png"));
        }
    }

    protected void render(Wave_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotationDegrees(Mth.lerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot()) + 180.0f));
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        CmEntityRenderState state = new CmEntityRenderState();
        state.entity = entity;
        state.partialTick = partialTicks;
        this.model.setupAnim(state);
        VertexConsumer vertexconsumer = buffer.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entity)));
        float alpha = 0.7f;
        int i1 = ARGB.color((int)((int)(alpha * 255.0f)), (int)255, (int)255, (int)255);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, i1);
        poseStack.popPose();
    }

    public Identifier getTextureLocation(Wave_Entity entity) {
        return this.getGrowingTexture((int)((float)entity.tickCount * 1.5f % 5.0f));
    }

    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)5)];
    }
}

