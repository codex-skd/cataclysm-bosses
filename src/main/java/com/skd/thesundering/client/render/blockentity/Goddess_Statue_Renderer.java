/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.client.render.blockentity;

import com.skd.thesundering.blockentities.Statue_Block_Entity;
import com.skd.thesundering.blocks.Statue_Block;
import com.skd.thesundering.client.model.block.Goddess_Statue_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Goddess_Statue_Renderer
implements BlockEntityRenderer<Statue_Block_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/goddess_statue.png");
    private static final Goddess_Statue_Model MODEL = new Goddess_Statue_Model();

    public Goddess_Statue_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public boolean shouldRenderOffScreen(Statue_Block_Entity p_112138_) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(Statue_Block_Entity p_173531_, Vec3 p_173532_) {
        return Vec3.atCenterOf((Vec3i)p_173531_.getBlockPos()).multiply(1.0, 0.0, 1.0).closerThan((Position)p_173532_.multiply(1.0, 0.0, 1.0), (double)this.getViewDistance());
    }

    public AABB getRenderBoundingBox(Statue_Block_Entity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX() + 1.0, (double)pos.getY() + 3.0, (double)pos.getZ() + 1.0);
    }

    public void render(Statue_Block_Entity entity, float delta, PoseStack matrixStackIn, MultiBufferSource buffer, int packedLight, int overlay) {
        DoubleBlockHalf doubleblockhalf = (DoubleBlockHalf)entity.getBlockState().getValue(Statue_Block.HALF);
        if (doubleblockhalf == DoubleBlockHalf.LOWER) {
            matrixStackIn.pushPose();
            float f = ((Direction)entity.getBlockState().getValue((Property)Statue_Block.FACING)).toYRot();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(-f + 180.0f));
            matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
            MODEL.renderToBuffer(matrixStackIn, buffer.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), packedLight, overlay);
            matrixStackIn.popPose();
        }
    }
}

