/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.entity.effect.Abyss_Mark_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Abyss_Mark_Renderer
extends EntityRenderer<Abyss_Mark_Entity> {
    public static final Identifier ABYSS_MARK1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_warlock_mark1.png");
    public static final Identifier ABYSS_MARK2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_warlock_mark2.png");

    public Abyss_Mark_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    public Identifier getTextureLocation(Abyss_Mark_Entity entity) {
        float f = entity.getLifespan();
        return f > -1.0f && f / 5.0f % 2.0f == 0.0f ? ABYSS_MARK2 : ABYSS_MARK1;
    }

    public void render(Abyss_Mark_Entity flameStrike, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucentEmissive((Identifier)this.getTextureLocation(flameStrike)));
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
        matrixStackIn.translate(0.0, 0.001, 0.0);
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
        matrixStackIn.popPose();
        super.render((Entity)flameStrike, entityYaw, delta, matrixStackIn, bufferIn, packedLightIn);
    }

    public void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_);
    }
}

