/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.renderer.SubmitNodeCollector
 *  net.minecraft.client.renderer.entity.EntityRendererProvider
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.state.HumanoidRenderState
 *  net.minecraft.client.renderer.rendertype.RenderTypes
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  top.theillusivec4.curios.api.SlotContext
 *  top.theillusivec4.curios.api.client.ICurioRenderer
 */
package com.skd.cataclysmbosses.client.render.item.CuriosRenderer;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Berserker_Soul_Amulet_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class Berserker_Soul_Amulet_Renderer
implements ICurioRenderer.HumanoidRender {
    private final Berserker_Soul_Amulet_Model model = new Berserker_Soul_Amulet_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BERSERKER_SOUL_AMULET_MODEL));
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/berserker_soul_amulet.png");
    private static final Identifier TEXTURE_LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/berserker_soul_amulet_layer.png");

    @Override
    public Berserker_Soul_Amulet_Model getModel(ItemStack stack, SlotContext slotContext) {
        return this.model;
    }

    @Override
    public Identifier getModelTexture(ItemStack stack, SlotContext slotContext) {
        return TEXTURE;
    }

    @Override
    public void prepareModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, HumanoidRenderState renderState, RenderLayerParent<HumanoidRenderState, HumanoidModel<HumanoidRenderState>> renderLayerParent, EntityRendererProvider.Context context, float limbSwing, float ageInTicks) {
        ICurioRenderer.setupHumanoidAnimations(this.model, renderState);
        
        // Render main texture
        RenderType renderType = RenderTypes.armorCutoutNoCull(TEXTURE);
        submitNodeCollector.order(1).submitModel(this.model, renderState, poseStack, renderType, packedLight, OverlayTexture.NO_OVERLAY, null, -1, null);
    }

    @Override
    public void renderModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, HumanoidRenderState renderState, RenderLayerParent<HumanoidRenderState, HumanoidModel<HumanoidRenderState>> renderLayerParent, EntityRendererProvider.Context context, float limbSwing, float ageInTicks) {
        // Render layer texture (eyes)
        RenderType renderType = RenderTypes.armorCutoutNoCull(TEXTURE_LAYER);
        submitNodeCollector.order(1).submitModel(this.model, renderState, poseStack, renderType, 0xF000F0, OverlayTexture.NO_OVERLAY, null, -1, null);
    }
}