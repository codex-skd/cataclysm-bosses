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

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Maledictus_Model;
import com.skd.cataclysmbosses.client.render.layer.MaledictusRiderLayer;
import com.skd.cataclysmbosses.client.render.layer.Maledictus_Cicle_Layer;
import com.skd.cataclysmbosses.client.render.layer.Maledictus_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Maledictus_Renderer extends EntityRenderer<Maledictus_Entity, EntityRenderState> {
    private static final Identifier MALEDICTUS_TEXTURES = new ResourceLocation("cataclysm_bosses", "textures/entity/maledictus/maledictus.png");

    public Maledictus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Maledictus_Entity entity, float f, float f1, PoseStack posestack, MultiBufferSource multibuffersource, int i) {
        posestack.pushPose();
        posestack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(f, entity.yRotO, entity.getYRot()) - 90.0f));
        posestack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(f, entity.xRotO, entity.getXRot())));
        Maledictus_Model maledictus_model = new Maledictus_Model(entity);
        int j = LivingEntity.getLightBrightness(entity.level(), entity.blockPosition());
        this.getRenderLayer().getRenderer().render(entity, maledictus_model, posestack, multibuffersource.getBuffer(this.getRenderType(entity.getTextureLocation(entity))), j, LivingEntity.getLightBrightnessColor(entity.level(), entity.blockPosition()));
        posestack.popPose();
    }

    @Override
    public Identifier getTextureLocation(Maledictus_Entity entity) {
        return MALEDICTUS_TEXTURES;
    }
}

