/*
 * Decompiled with CFR 0.152.
 */
package com.skd.cataclysmbosses.client.render.etc;
import net.minecraft.resources.Identifier;

import com.skd.cataclysmbosses.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SkullBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

@OnlyIn(value=Dist.CLIENT)
public class CurioHeadRenderer
implements ICurioRenderer.ModelRender<HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
    private final Map<SkullBlock.Type, SkullModelBase> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

    @Override
    public HumanoidModel<HumanoidRenderState> getModel(ItemStack stack, SlotContext slotContext) {
        return null;
    }

    @Override
    public Identifier getModelTexture(ItemStack stack, SlotContext slotContext) {
        return null; // not used for skulls
    }

    @Override
    public void prepareModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, HumanoidRenderState renderState, RenderLayerParent<HumanoidRenderState, HumanoidModel<HumanoidRenderState>> renderLayerParent, net.minecraft.client.renderer.entity.EntityRendererProvider.Context context, float limbSwing, float ageInTicks) {
        // PORT TODO(26.2): worn custom-skull rendering on the head slot is disabled. It relied on
        // slotContext.entity().getRenderState().getModel() (removed), HumanoidRenderState.walkAnimation
        // (removed) and Cataclysm_Skull_Block_Renderer.getRenderType/renderSkull (that BER is fully
        // stubbed for now). Re-implement together with the skull SubmitNodeCollector pipeline:
        // take renderLayerParent.getModel().getHead() for the head bone, pick this.skullModels.get(type),
        // and submit via SkullBlockRenderer.submitSkull.
    }
}
