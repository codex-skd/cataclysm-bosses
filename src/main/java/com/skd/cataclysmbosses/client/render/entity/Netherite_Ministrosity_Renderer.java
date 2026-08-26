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
import com.skd.cataclysmbosses.client.model.entity.Netherite_Ministrosity_Model;
import com.skd.cataclysmbosses.client.render.layer.Netherite_Ministrosity_Layer;
import com.skd.cataclysmbosses.entity.Pet.Netherite_Ministrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Netherite_Ministrosity_Renderer extends CmEntityRenderer<Netherite_Ministrosity_Entity> {
    private static final Identifier NETHER_MINISTROSITY_TEXTURES = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/monstrosity/netherite_ministrosity.png");

    public Netherite_Ministrosity_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void render(Netherite_Ministrosity_Entity entity, float f1, PoseStack posestack, CmMultiBufferSource multibuffersource, int i) {
        posestack.pushPose();
        posestack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(f, entity.yRotO, entity.getYRot()) - 90.0f));
        posestack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(f, entity.xRotO, entity.getXRot())));
        Netherite_Ministrosity_Model model = new Netherite_Ministrosity_Model(entity);
        int j = LivingEntity.getLightBrightness(entity.level(), entity.blockPosition());
        this.getRenderLayer().getRenderer().render(entity, model, posestack, multibuffersource.getBuffer(this.getRenderType(entity.getTextureLocation(entity))), j, LivingEntity.getLightBrightnessColor(entity.level(), entity.blockPosition()));
        posestack.popPose();
    }

    @Override
    public Identifier getTextureLocation(Netherite_Ministrosity_Entity entity) {
        return NETHER_MINISTROSITY_TEXTURES;
    }
}

