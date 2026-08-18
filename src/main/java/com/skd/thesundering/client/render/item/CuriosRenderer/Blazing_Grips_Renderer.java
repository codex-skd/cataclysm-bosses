/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.player.AbstractClientPlayer
 *  net.minecraft.client.renderer.SubmitNodeCollector
 *  net.minecraft.client.renderer.entity.EntityRendererProvider
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.state.AvatarRenderState
 *  net.minecraft.client.renderer.entity.state.HumanoidRenderState
 *  net.minecraft.client.renderer.rendertype.RenderTypes
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  top.theillusivec4.curios.api.SlotContext
 *  top.theillusivec4.curios.api.client.CuriosRendererRegistry
 *  top.theillusivec4.curios.api.client.ICurioRenderer
 */
package com.skd.thesundering.client.render.item.CuriosRenderer;

import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.item.CuriosModel.Blazing_Grips_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class Blazing_Grips_Renderer
implements ICurioRenderer.HumanoidRender {
    private final Blazing_Grips_Model model = new Blazing_Grips_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BLAZING_GRIPS_MODEL));
    private final Blazing_Grips_Model slimModel = new Blazing_Grips_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BLAZING_GRIPS_SLIM_MODEL));
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/blazing_grips.png");
    private static final Identifier TEXTURE_LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/blazing_grips_layer.png");

    @Nullable
    public static Blazing_Grips_Renderer getGloveRenderer(ItemStack stack) {
        if (!stack.isEmpty()) {
            return CuriosRendererRegistry.getRenderer((Item)stack.getItem()).filter(Blazing_Grips_Renderer.class::isInstance).map(Blazing_Grips_Renderer.class::cast).orElse(null);
        }
        return null;
    }

    @Override
    public Blazing_Grips_Model getModel(ItemStack stack, SlotContext slotContext) {
        boolean hasSlimArms = hasSlimArms(slotContext.entity());
        return hasSlimArms ? this.slimModel : this.model;
    }

    @Override
    public Identifier getModelTexture(ItemStack stack, SlotContext slotContext) {
        return TEXTURE;
    }

    protected static boolean hasSlimArms(Entity entity) {
        if (entity instanceof AbstractClientPlayer player) {
            return player.getModelName().equals("slim");
        }
        return false;
    }

    @Override
    public void prepareModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, HumanoidRenderState renderState, RenderLayerParent<HumanoidRenderState, HumanoidModel<HumanoidRenderState>> renderLayerParent, EntityRendererProvider.Context context, float limbSwing, float ageInTicks) {
        Blazing_Grips_Model model = getModel(stack, slotContext);
        ICurioRenderer.setupHumanoidAnimations(model, renderState);
        
        InteractionHand hand = slotContext.index() % 2 == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        HumanoidArm handSide = hand == InteractionHand.MAIN_HAND ? slotContext.entity().getMainArm() : slotContext.entity().getMainArm().getOpposite();
        
        // Render main texture
        RenderType renderType = RenderTypes.armorCutoutNoCull(TEXTURE);
        submitNodeCollector.order(1).submitModel(model, renderState, poseStack, renderType, packedLight, OverlayTexture.NO_OVERLAY, null, -1, null);
    }

    @Override
    public void renderModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, HumanoidRenderState renderState, RenderLayerParent<HumanoidRenderState, HumanoidModel<HumanoidRenderState>> renderLayerParent, EntityRendererProvider.Context context, float limbSwing, float ageInTicks) {
        Blazing_Grips_Model model = getModel(stack, slotContext);
        
        // Render layer texture (eyes)
        RenderType renderType = RenderTypes.armorCutoutNoCull(TEXTURE_LAYER);
        submitNodeCollector.order(1).submitModel(model, renderState, poseStack, renderType, 0xF000F0, OverlayTexture.NO_OVERLAY, null, -1, null);
    }

    @Override
    public void renderFirstPersonHand(ItemStack stack, SlotContext slotContext, HumanoidArm side, PoseStack matrixStack, SubmitNodeCollector submitNodeCollector, AvatarRenderState avatarRenderState, AbstractClientPlayer player, int light) {
        if (!player.isSpectator()) {
            boolean hasSlimArms = hasSlimArms(player);
            Blazing_Grips_Model model = getModel(hasSlimArms);
            ModelPart arm = side == HumanoidArm.LEFT ? model.leftArm : model.rightArm;
            
            ICurioRenderer.setupHumanoidAnimations(model, avatarRenderState);
            model.resetPose();
            
            arm.xRot = 0.0f;
            
            RenderType renderType = RenderTypes.armorCutoutNoCull(TEXTURE);
            submitNodeCollector.order(1).submitModel(model, avatarRenderState, matrixStack, renderType, light, OverlayTexture.NO_OVERLAY, null, avatarRenderState.outlineColor, null);
            
            if (stack.hasFoil()) {
                RenderType glintType = RenderTypes.armorEntityGlint();
                submitNodeCollector.order(2).submitModel(model, avatarRenderState, matrixStack, glintType, light, OverlayTexture.NO_OVERLAY, null, avatarRenderState.outlineColor, null);
            }
            
            RenderType layerType = RenderTypes.armorCutoutNoCull(TEXTURE_LAYER);
            submitNodeCollector.order(1).submitModel(model, avatarRenderState, matrixStack, layerType, 0xF000F0, OverlayTexture.NO_OVERLAY, null, avatarRenderState.outlineColor, null);
        }
    }
}