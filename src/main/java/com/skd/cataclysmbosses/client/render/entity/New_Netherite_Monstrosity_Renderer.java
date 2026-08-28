/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Netherite_Monstrosity_Model;
import com.skd.cataclysmbosses.client.render.layer.Netherite_Monstrosity_Flare;
import com.skd.cataclysmbosses.client.render.layer.Netherite_Monstrosity_Layer;
import com.skd.cataclysmbosses.client.render.layer.Netherite_Monstrosity_Layer2;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class New_Netherite_Monstrosity_Renderer extends CmEntityRenderer<Netherite_Monstrosity_Entity> {
    private static final Identifier NETHER_MONSTROSITY_TEXTURES = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/monstrosity/netherite_monstrosity.png");

    public New_Netherite_Monstrosity_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void render(Netherite_Monstrosity_Entity entity, float f1, PoseStack posestack, CmMultiBufferSource multibuffersource, int i) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    @Override
    public Identifier getTextureLocation(Netherite_Monstrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }
}

