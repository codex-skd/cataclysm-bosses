/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.joml.Matrix4f
 */
package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blocks.Cursed_Tombstone_Block;
import com.skd.cataclysmbosses.client.model.block.Cursed_Tombstone_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.properties.Property;
import org.joml.Matrix4f;

public class Cursed_Tombstone_Renderer
implements BlockEntityRenderer<Cursed_tombstone_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/cursed_tombstone_off.png");
    private static final Identifier TEXTURE2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/cursed_tombstone_on.png");
    private static final Cursed_Tombstone_Model MODEL = new Cursed_Tombstone_Model();
    private final RandomSource rnd = RandomSource.create();
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0) / 2.0);

    public Cursed_Tombstone_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public void render(Cursed_tombstone_Entity entity, float delta, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int overlay) {
        poseStack.pushPose();
        Direction dir = (Direction)entity.getBlockState().getValue((Property)Cursed_Tombstone_Block.FACING);
        poseStack.translate(0.5f, 1.5f, 0.5f);
        poseStack.mulPose(dir.getRotation());
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        MODEL.renderToBuffer(poseStack, (Boolean)entity.getBlockState().getValue((Property)Cursed_Tombstone_Block.POWERED) != false ? buffer.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE2)) : buffer.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), packedLight, overlay);
        if (entity.tickCount > 0) {
            float f5 = ((float)entity.tickCount + delta) / 63.0f;
            float f7 = Math.min(f5 > 0.8f ? (f5 - 0.8f) / 0.2f : 0.0f, 1.0f);
            RandomSource randomsource = RandomSource.create((long)432L);
            VertexConsumer vertexconsumer2 = buffer.getBuffer(RenderType.lightning());
            poseStack.pushPose();
            poseStack.translate(0.0, 0.0, 0.0);
            int i = 0;
            while ((float)i < (f5 + f5 * f5) / 2.0f * 30.0f) {
                poseStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                poseStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                poseStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                poseStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                poseStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                poseStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0f + f5 * 90.0f));
                float f3 = randomsource.nextFloat() * 5.0f + 5.0f + f7 * 5.0f;
                float f4 = randomsource.nextFloat() * 0.5f + 1.0f + f7 * 2.0f;
                Matrix4f matrix4f = poseStack.last().pose();
                int j = (int)(255.0f * (1.0f - f7));
                Cursed_Tombstone_Renderer.vertex01(vertexconsumer2, matrix4f, j);
                Cursed_Tombstone_Renderer.vertex2(vertexconsumer2, matrix4f, f3, f4);
                Cursed_Tombstone_Renderer.vertex3(vertexconsumer2, matrix4f, f3, f4);
                Cursed_Tombstone_Renderer.vertex01(vertexconsumer2, matrix4f, j);
                Cursed_Tombstone_Renderer.vertex3(vertexconsumer2, matrix4f, f3, f4);
                Cursed_Tombstone_Renderer.vertex4(vertexconsumer2, matrix4f, f3, f4);
                Cursed_Tombstone_Renderer.vertex01(vertexconsumer2, matrix4f, j);
                Cursed_Tombstone_Renderer.vertex4(vertexconsumer2, matrix4f, f3, f4);
                Cursed_Tombstone_Renderer.vertex2(vertexconsumer2, matrix4f, f3, f4);
                ++i;
            }
            poseStack.popPose();
        }
        poseStack.popPose();
    }

    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.addVertex(p_114221_, 0.0f, 0.0f, 0.0f).setColor(57, 210, 178, p_114222_);
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.addVertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5f * p_114218_).setColor(57, 210, 178, 0);
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.addVertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5f * p_114227_).setColor(57, 210, 178, 0);
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.addVertex(p_114230_, 0.0f, p_114231_, 1.0f * p_114232_).setColor(57, 210, 178, 0);
    }
}

