/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.HeadedModel
 *  net.minecraft.client.model.SkullModelBase
 *  net.minecraft.client.renderer.SubmitNodeCollector
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.state.HumanoidRenderState
 *  net.minecraft.client.renderer.entity.state.LivingEntityRenderState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.WalkAnimationState
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  top.theillusivec4.curios.api.SlotContext
 *  top.theillusivec4.curios.api.client.ICurioRenderer
 */
package com.skd.cataclysmbosses.client.render.etc;

import com.skd.cataclysmbosses.blocks.Cataclysm_Skull_Block;
import com.skd.cataclysmbosses.blocks.Cataclysm_Wall_Skull_Block;
import com.skd.cataclysmbosses.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CurioHeadRenderer
implements ICurioRenderer.ModelRender<HumanoidRenderState, HeadedModel> {
    private Map<SkullBlock.Type, SkullModelBase> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

    @Override
    public HeadedModel getModel(ItemStack stack, SlotContext slotContext) {
        EntityModel entityModel = slotContext.entity().getRenderState().getModel();
        if (entityModel instanceof HeadedModel) {
            return (HeadedModel) entityModel;
        }
        return null;
    }

    @Override
    public Identifier getModelTexture(ItemStack stack, SlotContext slotContext) {
        return null; // Not used for skulls
    }

    @Override
    public void prepareModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, HumanoidRenderState renderState, RenderLayerParent<HumanoidRenderState, HeadedModel> renderLayerParent, EntityRendererProvider.Context context, float limbSwing, float ageInTicks) {
        if (!stack.isEmpty()) {
            Item item = stack.getItem();
            if (item instanceof BlockItem) {
                Block block = ((BlockItem) item).getBlock();
                if (block instanceof Cataclysm_Skull_Block || block instanceof Cataclysm_Wall_Skull_Block) {
                    HeadedModel headModel = getModel(stack, slotContext);
                    if (headModel != null) {
                        poseStack.pushPose();
                        headModel.getHead().translateAndRotate(poseStack);
                        poseStack.scale(1.1875f, -1.1875f, -1.1875f);
                        poseStack.translate(-0.5, 0.0, -0.5);
                        
                        SkullBlock.Type type = block instanceof Cataclysm_Skull_Block 
                            ? ((Cataclysm_Skull_Block) block).getType() 
                            : ((Cataclysm_Wall_Skull_Block) block).getType();
                        SkullModelBase skullModel = this.skullModels.get(type);
                        RenderType renderType = Cataclysm_Skull_Block_Renderer.getRenderType(type);
                        
                        Entity entity = slotContext.entity().getVehicle();
                        WalkAnimationState walkAnimationState;
                        if (entity instanceof LivingEntity) {
                            walkAnimationState = ((LivingEntity) entity).walkAnimation;
                        } else {
                            walkAnimationState = renderState.walkAnimation;
                        }
                        float f3 = walkAnimationState.position(0.0f); // partialTicks not available here
                        
                        Cataclysm_Skull_Block_Renderer.renderSkull(null, 180.0f, f3, poseStack, submitNodeCollector, packedLight, skullModel, renderType, type, true);
                        poseStack.popPose();
                    }
                }
            }
        }
    }
}