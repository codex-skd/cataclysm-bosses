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

import com.skd.thesundering.client.model.entity.Coralssus_Model;
import com.skd.thesundering.entity.InternalAnimationMonster.Coralssus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Coralssus_Renderer
extends MobRenderer<Coralssus_Entity, Coralssus_Model> {
    private static final Identifier FIRE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/coralssus_fire.png");
    private static final Identifier HORN_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/coralssus_horn.png");
    private static final Identifier TUBE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/coralssus_tube.png");
    private static final Identifier SPONGE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/coralssus_sponge_horn.png");

    public Coralssus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Coralssus_Model(), 1.7f);
    }

    public Identifier getTextureLocation(Coralssus_Entity entity) {
        if (entity.isSponge()) {
            return SPONGE_TEXTURE;
        }
        return switch (entity.getVariant()) {
            case Coralssus_Entity.Variant.FIRE -> FIRE_TEXTURE;
            case Coralssus_Entity.Variant.HORN -> HORN_TEXTURE;
            case Coralssus_Entity.Variant.TUBE -> TUBE_TEXTURE;
            default -> throw new IncompatibleClassChangeError();
        };
    }

    protected float getFlipDegrees(Coralssus_Entity entity) {
        return 0.0f;
    }

    protected void scale(Coralssus_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.35f, 1.35f, 1.35f);
    }
}

