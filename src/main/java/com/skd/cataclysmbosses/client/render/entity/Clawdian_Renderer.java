/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Clawdian_Model;
import com.skd.cataclysmbosses.client.render.layer.Clawdian_Hold_Block_Layer;
import com.skd.cataclysmbosses.client.render.layer.Clawdian_Hold_Entity_Layer;
import com.skd.cataclysmbosses.client.render.layer.LayerGenericGlowing;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Clawdian_Renderer
extends CmMobRenderer<Clawdian_Entity> {
    private static final Identifier KOBOLEDIATOR_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/shrimp.png");
    private static final Identifier LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/shrimp_glow.png");

    public Clawdian_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Clawdian_Model(renderManagerIn.bakeLayer(CMModelLayers.CLAWDIAN_MODEL)), 1.8f);
        this.addLayer(new LayerGenericGlowing(this, LAYER));
        this.addLayer(new Clawdian_Hold_Block_Layer((RenderLayerParent<Clawdian_Entity, Clawdian_Model>)this, renderManagerIn.getBlockRenderDispatcher()));
        this.addLayer(new Clawdian_Hold_Entity_Layer((RenderLayerParent<Clawdian_Entity, Clawdian_Model>)this, renderManagerIn.getEntityRenderDispatcher()));
    }

    public Identifier getTextureLocation(Clawdian_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    protected float getFlipDegrees(Clawdian_Entity entity) {
        return 0.0f;
    }

    protected void scale(Clawdian_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.1f, 1.1f, 1.1f);
    }
}

