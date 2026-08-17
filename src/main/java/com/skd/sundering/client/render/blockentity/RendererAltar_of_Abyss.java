/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.resources.model.BakedModel
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.sundering.client.render.blockentity;

import com.skd.sundering.blockentities.AltarOfAbyss_Block_Entity;
import com.skd.sundering.blocks.Altar_Of_Abyss_Block;
import com.skd.sundering.client.model.block.Altar_of_Abyss_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.Property;

public class RendererAltar_of_Abyss<T extends AltarOfAbyss_Block_Entity>
implements BlockEntityRenderer<T> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_abyss.png");
    private static final Altar_of_Abyss_Model MODEL = new Altar_of_Abyss_Model();

    public RendererAltar_of_Abyss(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        Direction dir = (Direction)tileEntityIn.getBlockState().getValue((Property)Altar_Of_Abyss_Block.FACING);
        if (dir == Direction.NORTH) {
            matrixStackIn.translate(0.5, 1.5, 0.5);
        } else if (dir == Direction.EAST) {
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        } else if (dir == Direction.SOUTH) {
            matrixStackIn.translate(0.5, 1.5, 0.5);
        } else if (dir == Direction.WEST) {
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        }
        matrixStackIn.mulPose(dir.getOpposite().getRotation());
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f));
        matrixStackIn.pushPose();
        MODEL.animate((AltarOfAbyss_Block_Entity)((Object)tileEntityIn), partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
        matrixStackIn.popPose();
        this.renderItem(tileEntityIn, partialTicks, matrixStackIn, bufferIn, combinedLightIn);
    }

    public void renderItem(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn) {
        ItemStack stack = ((AltarOfAbyss_Block_Entity)((Object)tileEntityIn)).getItem(0);
        float f2 = (float)((AltarOfAbyss_Block_Entity)((Object)tileEntityIn)).tickCount + partialTicks;
        if (!stack.isEmpty()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.9f, 0.5f);
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
}

