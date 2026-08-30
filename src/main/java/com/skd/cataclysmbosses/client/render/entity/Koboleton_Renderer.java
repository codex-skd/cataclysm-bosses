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
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;

import com.skd.cataclysmbosses.client.model.entity.Koboleton_Model;
import com.skd.cataclysmbosses.client.render.layer.LayerGenericGlowing;
import com.skd.cataclysmbosses.client.render.layer.LayerKoboletonItem;
import com.skd.cataclysmbosses.entity.AnimationMonster.Koboleton_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Koboleton_Renderer
extends CmMobRenderer<Koboleton_Entity> {
    private static final Identifier KOBOLETON_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/koboleton/koboleton.png");
    private static final Identifier KOBOLETON_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/koboleton/koboleton_layer.png");

    public Koboleton_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Koboleton_Model(), 0.5f);
        this.addLayer(new LayerKoboletonItem((RenderLayerParent)this, net.minecraft.client.Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer()));
        this.addLayer(new LayerGenericGlowing(this, KOBOLETON_LAYER_TEXTURES));
    }

    @Override
    protected void render(Koboleton_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Koboleton_Entity entity) {
        return KOBOLETON_TEXTURES;
    }

    protected void scale(Koboleton_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

