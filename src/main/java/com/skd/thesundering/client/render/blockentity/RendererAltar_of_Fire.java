/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.resources.model.BakedModel
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.thesundering.client.render.blockentity;

import com.skd.thesundering.blockentities.AltarOfFire_Block_Entity;
import com.skd.thesundering.client.model.block.Altar_of_Fire_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class RendererAltar_of_Fire<T extends AltarOfFire_Block_Entity>
implements BlockEntityRenderer<T> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_fire/altar_of_fire.png");
    private static final Identifier[] TEXTURE_FIRE_PROGRESS = new Identifier[8];
    public static final Identifier FLAME_STRIKE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/flame_strike_sigil.png");
    private static final Altar_of_Fire_Model MODEL = new Altar_of_Fire_Model();

    public RendererAltar_of_Fire(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        for (int i = 0; i < 8; ++i) {
            RendererAltar_of_Fire.TEXTURE_FIRE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/block/altar_of_fire/altar_fire_" + i + ".png"));
        }
    }

    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float f2 = (float)((AltarOfFire_Block_Entity)((Object)tileEntityIn)).tickCount + partialTicks;
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        matrixStackIn.scale(1.0f, -1.0f, -1.0f);
        MODEL.animate((AltarOfFire_Block_Entity)((Object)tileEntityIn), partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), combinedLightIn, combinedOverlayIn);
        this.renderFlamePart(f2, matrixStackIn, bufferIn, 15);
        matrixStackIn.popPose();
        this.renderItem(tileEntityIn, partialTicks, matrixStackIn, bufferIn, combinedLightIn);
        this.renderSigil(tileEntityIn, partialTicks, matrixStackIn, bufferIn);
    }

    private Identifier getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[Mth.clamp((int)age, (int)0, (int)7)];
    }

    public void renderItem(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn) {
        ItemStack stack = ((AltarOfFire_Block_Entity)((Object)tileEntityIn)).getItem(0);
        float f2 = (float)((AltarOfFire_Block_Entity)((Object)tileEntityIn)).tickCount + partialTicks;
        if (!stack.isEmpty()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.0f, 0.5f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(f2));
            BakedModel ibakedmodel = Minecraft.getInstance().getItemRenderer().getModel(stack, tileEntityIn.getLevel(), (LivingEntity)null, 0);
            boolean flag = ibakedmodel.isGui3d();
            if (!flag) {
                matrixStackIn.translate(0.0f, 0.0f, 0.0f);
            }
            Minecraft.getInstance().getItemRenderer().render(stack, ItemDisplayContext.GROUND, false, matrixStackIn, bufferIn, combinedLightIn, OverlayTexture.NO_OVERLAY, ibakedmodel);
            matrixStackIn.popPose();
        }
    }

    public void renderSigil(T tileEntityIn, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn) {
        if (((AltarOfFire_Block_Entity)((Object)tileEntityIn)).summoningthis) {
            float f2 = (float)((AltarOfFire_Block_Entity)((Object)tileEntityIn)).tickCount + delta;
            float f3 = Mth.clamp((int)((AltarOfFire_Block_Entity)((Object)tileEntityIn)).summoningticks, (int)0, (int)25);
            matrixStackIn.pushPose();
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucentEmissive((Identifier)FLAME_STRIKE));
            matrixStackIn.translate(0.5, 0.001, 0.5);
            matrixStackIn.scale(f3 * 0.1f, f3 * 0.1f, f3 * 0.1f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f + f2));
            PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }
    }

    private void renderFlamePart(float f2, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        VertexConsumer builder = bufferSource.getBuffer(RenderType.beaconBeam((Identifier)this.getIdleTexture((int)(f2 * 0.5f % 7.0f)), (boolean)true));
        poseStack.pushPose();
        poseStack.translate(0.0, 0.75, 0.0);
        poseStack.scale(1.0f, -1.0f, -1.0f);
        poseStack.mulPose(Axis.YP.rotationDegrees(45.0f));
        for (int i = 0; i < 4; ++i) {
            this.renderQuad(poseStack, builder, 0.5f, 0.0f, 1.0f, packedLight);
            poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
        }
        poseStack.popPose();
    }

    private void renderQuad(PoseStack poseStack, VertexConsumer builder, float size, float yMin, float yMax, int light) {
        PoseStack.Pose lastPose = poseStack.last();
        float u0 = 0.0f;
        float u1 = 1.0f;
        float v0 = 0.0f;
        float v1 = 1.0f;
        this.vertex(builder, lastPose, -size, yMin, 0.0f, u0, v1, light);
        this.vertex(builder, lastPose, size, yMin, 0.0f, u1, v1, light);
        this.vertex(builder, lastPose, size, yMax, 0.0f, u1, v0, light);
        this.vertex(builder, lastPose, -size, yMax, 0.0f, u0, v0, light);
    }

    private void vertex(VertexConsumer builder, PoseStack.Pose pose, float x, float y, float z, float u, float v, int light) {
        builder.addVertex(pose, x, y, z).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(pose, 0.0f, 1.0f, 0.0f);
    }

    public void drawVertex(PoseStack.Pose p_324380_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.addVertex(p_324380_, (float)p_254058_, (float)p_254338_, (float)p_254196_).setColor(255, 255, 255, 255).setUv(p_254003_, p_254165_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_254271_).setNormal(p_324380_, (float)p_253982_, (float)p_254038_, (float)p_254037_);
    }
}

