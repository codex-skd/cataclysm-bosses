/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.renderer.LightTexture
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  top.theillusivec4.curios.api.SlotContext
 *  top.theillusivec4.curios.api.client.ICurioRenderer
 */
package com.skd.sundering.client.render.item.CuriosRenderer;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.item.CuriosModel.Berserker_Soul_Amulet_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class Berserker_Soul_Amulet_Renderer
implements ICurioRenderer {
    private final Berserker_Soul_Amulet_Model model = new Berserker_Soul_Amulet_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BERSERKER_SOUL_AMULET_MODEL));
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/berserker_soul_amulet.png");
    private static final Identifier TEXTURE_LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/berserker_soul_amulet_layer.png");

    public Identifier getCuriosTexture() {
        return TEXTURE;
    }

    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.model.prepareMobModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);
        ICurioRenderer.followBodyRotations((LivingEntity)slotContext.entity(), (HumanoidModel[])new HumanoidModel[]{this.model});
        this.renderArm(this.model, poseStack, buffer, packedLight, stack.hasFoil());
    }

    protected void renderArm(Berserker_Soul_Amulet_Model model, PoseStack matrixStack, MultiBufferSource buffer, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(this.getCuriosTexture());
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer((MultiBufferSource)buffer, (RenderType)renderType, (boolean)false, (boolean)hasFoil);
        model.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY);
        VertexConsumer builder = ItemRenderer.getFoilBuffer((MultiBufferSource)buffer, (RenderType)CMRenderTypes.CMEyes(TEXTURE_LAYER), (boolean)false, (boolean)hasFoil);
        model.renderToBuffer(matrixStack, builder, LightTexture.pack((int)15, (int)15), OverlayTexture.NO_OVERLAY);
    }
}

