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
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Portal_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Abyss_Portal_Renderer
extends EntityRenderer<Abyss_Portal_Entity> {
    private static final Identifier TEXTURE_0 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/portal/abyss_portal_idle_0.png");
    private static final Identifier TEXTURE_1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/portal/abyss_portal_idle_1.png");
    private static final Identifier TEXTURE_2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/portal/abyss_portal_idle_2.png");
    private static final Identifier TEXTURE_3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/portal/abyss_portal_idle_3.png");
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[8];
    private static final Identifier[] TEXTURE_IDLE = new Identifier[4];

    public Abyss_Portal_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        int i;
        for (i = 0; i < 8; ++i) {
            Abyss_Portal_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/leviathan/portal/abyss_portal_grow_" + i + ".png"));
        }
        for (i = 0; i < 4; ++i) {
            Abyss_Portal_Renderer.TEXTURE_IDLE[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/leviathan/portal/abyss_portal_idle_" + i + ".png"));
        }
    }

    public void render(Abyss_Portal_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0f, 0.01f, 0.0f);
        matrixStackIn.scale(4.0f, 4.0f, 4.0f);
        this.renderPortal(entityIn, matrixStackIn, bufferIn, false);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderPortal(Abyss_Portal_Entity entityIn, PoseStack matrixStackIn, MultiBufferSource bufferIn, boolean shattered) {
        Identifier tex = entityIn.getLifespan() < 20 ? this.getGrowingTexture((int)((float)entityIn.getLifespan() * 0.5f % 20.0f)) : (entityIn.tickCount < 20 ? this.getGrowingTexture((int)((float)entityIn.tickCount * 0.5f % 20.0f)) : this.getIdleTexture((int)((float)entityIn.tickCount * 0.35f % 3.0f)));
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getfullBright(tex));
        this.renderArc(matrixStackIn, ivertexbuilder);
    }

    private void renderArc(PoseStack matrixStackIn, VertexConsumer ivertexbuilder) {
        matrixStackIn.pushPose();
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
        matrixStackIn.popPose();
    }

    public Identifier getTextureLocation(Abyss_Portal_Entity entity) {
        return TEXTURE_0;
    }

    public void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_);
    }

    public Identifier getIdleTexture(int age) {
        return TEXTURE_IDLE[Mth.clamp((int)age, (int)0, (int)3)];
    }

    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)7)];
    }
}

