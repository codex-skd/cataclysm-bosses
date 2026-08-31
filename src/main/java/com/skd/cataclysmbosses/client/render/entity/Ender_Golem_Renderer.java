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
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;

import com.skd.cataclysmbosses.client.model.entity.Ender_Golem_Model;
import com.skd.cataclysmbosses.client.render.layer.Ender_Golem_Layer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ender_Golem_Renderer
extends CmMobRenderer<Ender_Golem_Entity> {
    private static final Identifier ENDER_GOLEM_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ender_golem.png");

    public Ender_Golem_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ender_Golem_Model(), 1.5f);
        this.addLayer(new Ender_Golem_Layer(this));
    }

    @Override
    protected void render(Ender_Golem_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Ender_Golem_Entity entity) {
        return ENDER_GOLEM_TEXTURES;
    }

    protected void scale(Ender_Golem_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }

    protected float getFlipDegrees(Ender_Golem_Entity entity) {
        return 0.0f;
    }
}

