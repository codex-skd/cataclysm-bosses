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

import com.skd.cataclysmbosses.client.model.entity.Ender_Guardian_Model;
import com.skd.cataclysmbosses.client.render.layer.Ender_Guardian_Layer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ender_Guardian_Renderer
extends CmMobRenderer<Ender_Guardian_Entity> {
    private static final Identifier ENDER_GUARDIAN_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ender_guardian.png");

    public Ender_Guardian_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Ender_Guardian_Model(), 1.5f);
        this.addLayer(new Ender_Guardian_Layer(this));
    }

    public Identifier getTextureLocation(Ender_Guardian_Entity entity) {
        return ENDER_GUARDIAN_TEXTURES;
    }

    protected void scale(Ender_Guardian_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }

    protected float getFlipDegrees(Ender_Guardian_Entity entity) {
        return 0.0f;
    }
}

