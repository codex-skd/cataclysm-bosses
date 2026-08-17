/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.player.AbstractClientPlayer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.resources.PlayerSkin$Model
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
package com.skd.sundering.client.render.item.CuriosRenderer;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.item.CuriosModel.Chitin_Claw_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
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

public class Chitin_Claw_Renderer
implements ICurioRenderer {
    private final Chitin_Claw_Model model = new Chitin_Claw_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CHITIN_CLAW_MODEL));
    private final Chitin_Claw_Model slimModel = new Chitin_Claw_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CHITIN_CLAW_SLIM_MODEL));
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/curiositem/chitin_claw.png");

    @Nullable
    public static Chitin_Claw_Renderer getGloveRenderer(ItemStack stack) {
        if (!stack.isEmpty()) {
            return CuriosRendererRegistry.getRenderer((Item)stack.getItem()).filter(Chitin_Claw_Renderer.class::isInstance).map(Chitin_Claw_Renderer.class::cast).orElse(null);
        }
        return null;
    }

    protected Chitin_Claw_Model getModel(boolean hasSlimArms) {
        return hasSlimArms ? this.slimModel : this.model;
    }

    protected static boolean hasSlimArms(Entity entity) {
        AbstractClientPlayer player;
        return entity instanceof AbstractClientPlayer && (player = (AbstractClientPlayer)entity).getSkin().model() == PlayerSkin.Model.SLIM;
    }

    public Identifier getCuriosTexture() {
        return TEXTURE;
    }

    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource multiBufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean hasSlimArms = Chitin_Claw_Renderer.hasSlimArms((Entity)slotContext.entity());
        Chitin_Claw_Model model = this.getModel(hasSlimArms);
        InteractionHand hand = slotContext.index() % 2 == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        HumanoidArm handSide = hand == InteractionHand.MAIN_HAND ? slotContext.entity().getMainArm() : slotContext.entity().getMainArm().getOpposite();
        model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        model.prepareMobModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);
        ICurioRenderer.followBodyRotations((LivingEntity)slotContext.entity(), (HumanoidModel[])new HumanoidModel[]{model});
        this.renderArm(model, poseStack, multiBufferSource, handSide, light, stack.hasFoil());
    }

    protected void renderArm(Chitin_Claw_Model model, PoseStack matrixStack, MultiBufferSource buffer, HumanoidArm handSide, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(this.getCuriosTexture());
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer((MultiBufferSource)buffer, (RenderType)renderType, (boolean)false, (boolean)hasFoil);
        model.renderArm(handSide, matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY);
    }

    public final void renderFirstPersonArm(PoseStack matrixStack, MultiBufferSource buffer, int light, AbstractClientPlayer player, HumanoidArm side, boolean hasFoil) {
        if (!player.isSpectator()) {
            boolean hasSlimArms = Chitin_Claw_Renderer.hasSlimArms((Entity)player);
            Chitin_Claw_Model model = this.getModel(hasSlimArms);
            ModelPart arm = side == HumanoidArm.LEFT ? model.leftArm : model.rightArm;
            model.setAllVisible(false);
            arm.visible = true;
            model.crouching = false;
            model.swimAmount = 0.0f;
            model.attackTime = 0.0f;
            model.setupAnim((LivingEntity)player, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            arm.xRot = 0.0f;
            this.renderFirstPersonArm(model, arm, matrixStack, buffer, light, hasFoil);
        }
    }

    protected void renderFirstPersonArm(Chitin_Claw_Model model, ModelPart arm, PoseStack matrixStack, MultiBufferSource buffer, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(this.getCuriosTexture());
        VertexConsumer builder = ItemRenderer.getFoilBuffer((MultiBufferSource)buffer, (RenderType)renderType, (boolean)false, (boolean)hasFoil);
        arm.render(matrixStack, builder, light, OverlayTexture.NO_OVERLAY);
    }
}

