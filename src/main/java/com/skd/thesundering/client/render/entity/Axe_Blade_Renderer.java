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
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.entity.Axe_Blade_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.projectile.Axe_Blade_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Axe_Blade_Renderer
extends EntityRenderer<Axe_Blade_Entity> {
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[5];
    public Axe_Blade_Model model = new Axe_Blade_Model();

    public Axe_Blade_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
        for (int i = 0; i < 5; ++i) {
            Axe_Blade_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/draugar/axe_blade_" + i + ".png"));
        }
    }

    protected int getBlockLightLevel(Axe_Blade_Entity entity, BlockPos pos) {
        return 15;
    }

    public void render(Axe_Blade_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
        matrixStackIn.translate(0.0f, 0.0f, 0.0f);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(entityIn.getYRot() + 180.0f));
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, 0.0f, 0.0f);
        float hide = (float)entityIn.getTransparency() / 80.0f;
        float alpha = 1.0f - hide;
        int i = FastColor.ARGB32.color((int)Mth.floor((float)(alpha * 255.0f)), (int)-1);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(Axe_Blade_Entity entity) {
        return this.getGrowingTexture(entity, (int)((float)entity.tickCount * 0.5f % 4.0f));
    }

    public Identifier getGrowingTexture(Axe_Blade_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)4)];
    }
}

