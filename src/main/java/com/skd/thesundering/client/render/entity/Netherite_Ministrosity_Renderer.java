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
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.entity.Netherite_Ministrosity_Model;
import com.skd.thesundering.client.render.layer.Netherite_Ministrosity_Layer;
import com.skd.thesundering.entity.Pet.Netherite_Ministrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Netherite_Ministrosity_Renderer
extends MobRenderer<Netherite_Ministrosity_Entity, Netherite_Ministrosity_Model> {
    private static final Identifier NETHER_MONSTROSITY_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/netherite_ministrosity.png");

    public Netherite_Ministrosity_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Netherite_Ministrosity_Model(renderManagerIn.bakeLayer(CMModelLayers.NETHERITE_MINISTROSITY_MODEL)), 0.5f);
        this.addLayer(new Netherite_Ministrosity_Layer(this));
    }

    public Identifier getTextureLocation(Netherite_Ministrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }

    protected void scale(Netherite_Ministrosity_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

