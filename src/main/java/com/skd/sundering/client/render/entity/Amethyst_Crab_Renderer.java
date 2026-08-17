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
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.entity.Amethyst_Crab_Model;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.Amethyst_Crab_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Amethyst_Crab_Renderer
extends MobRenderer<Amethyst_Crab_Entity, Amethyst_Crab_Model> {
    private static final Identifier TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/amethyst_crab.png");
    private static final Identifier KRABS_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/mr_amethyst_krabs.png");

    public Amethyst_Crab_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Amethyst_Crab_Model(), 1.5f);
    }

    public Identifier getTextureLocation(Amethyst_Crab_Entity entity) {
        return entity.isKrusty() ? KRABS_TEXTURES : TEXTURES;
    }

    protected void scale(Amethyst_Crab_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }

    protected float getFlipDegrees(Amethyst_Crab_Entity entity) {
        return 0.0f;
    }
}

