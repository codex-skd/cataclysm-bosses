/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Aptrgangr_Model;
import com.skd.cataclysmbosses.client.render.layer.AptrgangrRiderLayer;
import com.skd.cataclysmbosses.client.render.layer.Aptrgangr_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Aptrgangr_Renderer
extends MobRenderer<Aptrgangr_Entity, Aptrgangr_Model> {
    private final RandomSource rnd = RandomSource.create();
    private static final Identifier APTRGANGR_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/aptrgangr.png");

    public Aptrgangr_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Aptrgangr_Model(renderManagerIn.bakeLayer(CMModelLayers.APTRGANGR_MODEL)), 1.25f);
        this.addLayer(new AptrgangrRiderLayer(this));
        this.addLayer(new Aptrgangr_Layer(this));
    }

    public Vec3 getRenderOffset(Aptrgangr_Entity entityIn, float partialTicks) {
        if (entityIn.getAttackState() == 4) {
            double d0 = 0.01;
            return new Vec3(this.rnd.nextGaussian() * d0, this.rnd.nextGaussian() * d0, this.rnd.nextGaussian() * d0);
        }
        return super.getRenderOffset((Entity)entityIn, partialTicks);
    }

    public Identifier getTextureLocation(Aptrgangr_Entity entity) {
        return APTRGANGR_TEXTURES;
    }

    protected float getFlipDegrees(Aptrgangr_Entity entity) {
        return 0.0f;
    }

    protected void scale(Aptrgangr_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.35f, 1.35f, 1.35f);
    }
}

