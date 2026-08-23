/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Amethyst_Cluster_Projectile_Model;
import com.skd.cataclysmbosses.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Amethyst_Cluster_Projectile_Renderer
extends EntityRenderer<Amethyst_Cluster_Projectile_Entity> {
    private static final Identifier WITHER_HOWITZER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/amethyst_cluster_projectile.png");
    private final Amethyst_Cluster_Projectile_Model model = new Amethyst_Cluster_Projectile_Model();

    public Amethyst_Cluster_Projectile_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Amethyst_Cluster_Projectile_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot()) - 90.0f));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot()) + 90.0f));
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(RenderType.entityTranslucent((Identifier)this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    protected int getBlockLightLevel(Amethyst_Cluster_Projectile_Entity entityIn, BlockPos pos) {
        return 15;
    }

    public Identifier getTextureLocation(Amethyst_Cluster_Projectile_Entity entity) {
        return WITHER_HOWITZER_TEXTURES;
    }
}

