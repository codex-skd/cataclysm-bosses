/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Modern_Remnant_Model;
import com.skd.cataclysmbosses.entity.Pet.Modern_Remnant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Modern_Remnant_Renderer extends EntityRenderer<Modern_Remnant_Entity, EntityRenderState> {
    private static final Identifier MODERN_REMNANT_TEXTURES = new ResourceLocation("cataclysm_bosses", "textures/entity/ancient_remnant/modern_remnant.png");

    public Modern_Remnant_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Modern_Remnant_Entity entity, float f, float f1, PoseStack posestack, MultiBufferSource multibuffersource, int i) {
        posestack.pushPose();
        posestack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(f, entity.yRotO, entity.getYRot()) - 90.0f));
        posestack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(f, entity.xRotO, entity.getXRot())));
        Modern_Remnant_Model model = new Modern_Remnant_Model(entity);
        int j = LivingEntity.getLightBrightness(entity.level(), entity.blockPosition());
        this.getRenderLayer().getRenderer().render(entity, model, posestack, multibuffersource.getBuffer(this.getRenderType(entity.getTextureLocation(entity))), j, LivingEntity.getLightBrightnessColor(entity.level(), entity.blockPosition()));
        posestack.popPose();
    }

    @Override
    public Identifier getTextureLocation(Modern_Remnant_Entity entity) {
        return MODERN_REMNANT_TEXTURES;
    }
}

