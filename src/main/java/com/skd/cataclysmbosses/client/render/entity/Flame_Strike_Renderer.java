/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
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
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.entity.effect.Flame_Strike_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Flame_Strike_Renderer
extends EntityRenderer<Flame_Strike_Entity, EntityRenderState> {
    public static final Identifier FLAME_STRIKE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/flame_strike_sigil.png");
    public static final Identifier SOUL_FLAME_STRIKE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/soul_flame_strike_sigil.png");

    public Flame_Strike_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    public Identifier getTextureLocation(Flame_Strike_Entity entity) {
        return entity.isSoul() ? SOUL_FLAME_STRIKE : FLAME_STRIKE;
    }

    public void render(Flame_Strike_Entity flameStrike, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        float f2 = (float)flameStrike.tickCount + delta;
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderTypes.entityTranslucentEmissive((Identifier)this.getTextureLocation(flameStrike)));
        matrixStackIn.scale(flameStrike.getRadius(), flameStrike.getRadius(), flameStrike.getRadius());
        matrixStackIn.translate(0.0, 0.001, 0.0);
        if (flameStrike.isSoul()) {
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(f2));
        } else {
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f - flameStrike.getYRot() + f2));
        }
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        if (flameStrike.isSee()) {
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
        }
        matrixStackIn.popPose();
        super.render((Entity)flameStrike, entityYaw, delta, matrixStackIn, bufferIn, packedLightIn);
    }

    public void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_);
    }
}

