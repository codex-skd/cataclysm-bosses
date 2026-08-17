/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
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
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.effect.Void_Vortex_Entity;
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
public class Void_Vortex_Renderer
extends EntityRenderer<Void_Vortex_Entity> {
    private static final Identifier TEXTURE_1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/void_vortex/void_vortex_idle1.png");
    private static final Identifier TEXTURE_2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/void_vortex/void_vortex_idle2.png");
    private static final Identifier TEXTURE_3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/void_vortex/void_vortex_idle3.png");
    private static final Identifier TEXTURE_4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/void_vortex/void_vortex_idle4.png");
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[4];

    public Void_Vortex_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
        for (int i = 0; i < 4; ++i) {
            Void_Vortex_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/void_vortex/void_vortex_grow_" + i + ".png"));
        }
    }

    public void render(Void_Vortex_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0, 0.001, 0.0);
        Identifier tex = entityIn.getLifespan() < 16 ? this.getGrowingTexture((int)((float)entityIn.getLifespan() * 0.5f % 20.0f)) : (entityIn.tickCount < 16 ? this.getGrowingTexture((int)((float)entityIn.tickCount * 0.5f % 20.0f)) : this.getIdleTexture(entityIn.tickCount % 9));
        matrixStackIn.scale(3.0f, 3.0f, 3.0f);
        this.renderArc(matrixStackIn, bufferIn, tex);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderArc(PoseStack matrixStackIn, MultiBufferSource bufferIn, Identifier res) {
        matrixStackIn.pushPose();
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getfullBright(res));
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
        matrixStackIn.popPose();
    }

    public Identifier getTextureLocation(Void_Vortex_Entity entity) {
        return TEXTURE_1;
    }

    public void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_);
    }

    public Identifier getIdleTexture(int age) {
        if (age < 3) {
            return TEXTURE_1;
        }
        if (age < 6) {
            return TEXTURE_2;
        }
        if (age < 10) {
            return TEXTURE_3;
        }
        return TEXTURE_4;
    }

    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)(age / 2), (int)0, (int)3)];
    }
}

