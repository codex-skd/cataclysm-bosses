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
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.entity.Abyss_Blast_Portal_Model;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;

public class Abyss_Blast_Portal_Renderer
extends EntityRenderer<Abyss_Blast_Portal_Entity> {
    private static final Identifier PORTAL = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/portal/abyss_blast_portal.png");
    public Abyss_Blast_Portal_Model model = new Abyss_Blast_Portal_Model();

    public Abyss_Blast_Portal_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    protected int getBlockLightLevel(Abyss_Blast_Portal_Entity entity, BlockPos pos) {
        return 15;
    }

    public void render(Abyss_Blast_Portal_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        float activateProgress = entityIn.prevactivateProgress + (entityIn.activateProgress - entityIn.prevactivateProgress) * partialTicks;
        float d = activateProgress * 0.15f;
        matrixStackIn.scale(-d, -d, d);
        matrixStackIn.translate(0.0f, -1.5f, 0.0f);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f - entityIn.getYRot()));
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, 0.0f, 0.0f);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(Abyss_Blast_Portal_Entity entity) {
        return PORTAL;
    }
}

