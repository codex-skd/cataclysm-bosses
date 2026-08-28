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
public class Maledictus_Renderer extends CmEntityRenderer<Maledictus_Entity> {
    private static final Identifier MALEDICTUS_TEXTURES = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/maledictus/maledictus.png");

    public Maledictus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void render(Maledictus_Entity entity, float f1, PoseStack posestack, CmMultiBufferSource multibuffersource, int i) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    @Override
    public Identifier getTextureLocation(Maledictus_Entity entity) {
        return MALEDICTUS_TEXTURES;
    }
}

