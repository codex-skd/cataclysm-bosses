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
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.entity.Void_Rune_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.entity.projectile.Void_Rune_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.Random;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Void_Rune_Renderer
extends EntityRenderer<Void_Rune_Entity> {
    private static final Identifier VOID_RUNE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/void_rune.png");
    private final Void_Rune_Model model = new Void_Rune_Model();
    private final Random rnd = new Random();

    public Void_Rune_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Void_Rune_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f - entityIn.getYRot()));
        matrixStackIn.translate(0.0, 3.0, 0.0);
        matrixStackIn.scale(-2.0f, -2.0f, 2.0f);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getBright(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, 0.0f, 0.0f);
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Vec3 getRenderOffset(Void_Rune_Entity entityIn, float partialTicks) {
        if (entityIn.activateProgress == 10.0f) {
            return super.getRenderOffset((Entity)entityIn, partialTicks);
        }
        double d0 = 0.02;
        return new Vec3(this.rnd.nextGaussian() * d0, 0.0, this.rnd.nextGaussian() * d0);
    }

    protected int getBlockLightLevel(Void_Rune_Entity entityIn, BlockPos pos) {
        return 15;
    }

    public Identifier getTextureLocation(Void_Rune_Entity entity) {
        return VOID_RUNE;
    }
}

