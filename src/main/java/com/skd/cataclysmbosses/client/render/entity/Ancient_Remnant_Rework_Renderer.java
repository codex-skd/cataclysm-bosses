/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Ancient_Remnant_Rework_Model;
import com.skd.cataclysmbosses.client.render.layer.Ancient_Remnant_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ancient_Remnant_Rework_Renderer
extends CmMobRenderer<Ancient_Remnant_Entity> {
    private static final Identifier REMNANT_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ancient_remnant/ancient_remnant.png");
    private final RandomSource rnd = RandomSource.create();

    public Ancient_Remnant_Rework_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Ancient_Remnant_Rework_Model(renderManagerIn.bakeLayer(CMModelLayers.ANCIENT_REMNANT_MODEL)), 1.5f);
        this.addLayer(new Ancient_Remnant_Layer(this));
    }

    public Identifier getTextureLocation(Ancient_Remnant_Entity entity) {
        return REMNANT_TEXTURES;
    }

    protected float getFlipDegrees(Ancient_Remnant_Entity entity) {
        return 0.0f;
    }
}

