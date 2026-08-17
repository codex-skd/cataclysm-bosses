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

import com.skd.sundering.client.model.entity.The_Baby_Leviathan_Model;
import com.skd.sundering.entity.Pet.The_Baby_Leviathan_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Baby_Leviathan_Renderer
extends MobRenderer<The_Baby_Leviathan_Entity, The_Baby_Leviathan_Model> {
    private static final Identifier BABY_LEVIATHAN_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/the_baby_leviathan.png");

    public The_Baby_Leviathan_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new The_Baby_Leviathan_Model(), 0.25f);
    }

    public Identifier getTextureLocation(The_Baby_Leviathan_Entity entity) {
        return BABY_LEVIATHAN_TEXTURES;
    }

    protected void scale(The_Baby_Leviathan_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

