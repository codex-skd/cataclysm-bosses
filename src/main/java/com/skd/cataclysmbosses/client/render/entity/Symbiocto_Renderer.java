/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Symbiocto_Model;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Symbiocto_Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Symbiocto_Renderer extends EntityRenderer<Symbiocto_Entity, EntityRenderState> {
    private static final Identifier SYMbiocto_OPEN = new ResourceLocation("cataclysm_bosses", "textures/entity/sea/symbiocto_open.png");
    private static final Identifier SYMbiocto_CLOSE = new ResourceLocation("cataclysm_bosses", "textures/entity/sea/symbiocto_close.png");

    public Symbiocto_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Symbiocto_Entity entity, float f, float f1, PoseStack posestack, MultiBufferSource multibuffersource, int i) {
        posestack.pushPose();
        posestack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(f, entity.yRotO, entity.getYRot()) - 90.0f));
        posestack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(f, entity.xRotO, entity.getXRot())));
        Symbiocto_Model model = new Symbiocto_Model(entity);
        int j = LivingEntity.getLightBrightness(entity.level(), entity.blockPosition());
        this.getRenderLayer().getRenderer().render(entity, model, posestack, multibuffersource.getBuffer(this.getRenderType(entity.isCloseEye() ? SYMbiocto_CLOSE : SYMbiocto_OPEN)), j, LivingEntity.getLightBrightnessColor(entity.level(), entity.blockPosition()));
        posestack.popPose();
    }

    @Override
    public Identifier getTextureLocation(Symbiocto_Entity entity) {
        return entity.isCloseEye() ? SYMbiocto_CLOSE : SYMbiocto_OPEN;
    }
}

