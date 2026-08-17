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

import com.skd.sundering.client.model.entity.Lionfish_Model;
import com.skd.sundering.client.render.layer.LionFish_Layer;
import com.skd.sundering.entity.Deepling.Lionfish_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Lionfish_Renderer
extends MobRenderer<Lionfish_Entity, Lionfish_Model> {
    private static final Identifier LIONFISH_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/lionfish.png");

    public Lionfish_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Lionfish_Model(), 0.4f);
        this.addLayer(new LionFish_Layer(this));
    }

    public Identifier getTextureLocation(Lionfish_Entity entity) {
        return LIONFISH_TEXTURES;
    }

    protected void scale(Lionfish_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

