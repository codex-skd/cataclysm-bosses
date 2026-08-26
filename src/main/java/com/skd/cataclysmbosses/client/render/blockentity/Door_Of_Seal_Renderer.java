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
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blocks.Door_of_Seal_Block;
import com.skd.cataclysmbosses.client.model.block.Door_Of_Seal_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Door_Of_Seal_Renderer
implements BlockEntityRenderer<Door_Of_Seal_BlockEntity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/door_of_seal.png");
    private static final Door_Of_Seal_Model MODEL = new Door_Of_Seal_Model();

    public Door_Of_Seal_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public boolean shouldRenderOffScreen(Door_Of_Seal_BlockEntity p_112138_) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(Door_Of_Seal_BlockEntity entity, Vec3 p_173532_) {
        return Vec3.atCenterOf((Vec3i)entity.getBlockPos()).multiply(1.0, 0.0, 1.0).closerThan((Position)p_173532_.multiply(1.0, 0.0, 1.0), (double)this.getViewDistance());
    }

    public AABB getRenderBoundingBox(Door_Of_Seal_BlockEntity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX() + 3.0, (double)(pos.getY() + 8), (double)pos.getZ() + 3.0);
    }

    public void render(Door_Of_Seal_BlockEntity entity, float delta, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int overlay) {
        Door_of_Seal_Block.Door_Of_Seal_Part doubleblockhalf = (Door_of_Seal_Block.Door_Of_Seal_Part)((Object)entity.getBlockState().getValue(Door_of_Seal_Block.PART));
        int Y = (Integer)entity.getBlockState().getValue((Property)Door_of_Seal_Block.Y_OFFSET);
        if (doubleblockhalf == Door_of_Seal_Block.Door_Of_Seal_Part.CENTER && Y == 0) {
            poseStack.pushPose();
            Direction dir = (Direction)entity.getBlockState().getValue((Property)Door_of_Seal_Block.FACING);
            if (dir == Direction.NORTH) {
                poseStack.translate(0.5, (double)1.501f, 0.5);
            } else if (dir == Direction.EAST) {
                poseStack.translate(0.5f, 1.501f, 0.5f);
            } else if (dir == Direction.SOUTH) {
                poseStack.translate(0.5, (double)1.501f, 0.5);
            } else if (dir == Direction.WEST) {
                poseStack.translate(0.5f, 1.501f, 0.5f);
            }
            poseStack.mulPose(dir.getOpposite().getRotation());
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
            MODEL.animate(entity, delta);
            MODEL.renderToBuffer(poseStack, buffer.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)TEXTURE)), packedLight, overlay, -1);
            poseStack.popPose();
        }
    }
}

