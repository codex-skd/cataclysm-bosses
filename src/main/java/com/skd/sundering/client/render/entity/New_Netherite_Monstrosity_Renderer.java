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
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.entity.Netherite_Monstrosity_Model;
import com.skd.sundering.client.render.layer.Netherite_Monstrosity_Flare;
import com.skd.sundering.client.render.layer.Netherite_Monstrosity_Layer;
import com.skd.sundering.client.render.layer.Netherite_Monstrosity_Layer2;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class New_Netherite_Monstrosity_Renderer
extends MobRenderer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {
    private static final Identifier NETHER_MONSTROSITY_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/netherite_monstrosity.png");

    public New_Netherite_Monstrosity_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Netherite_Monstrosity_Model(renderManagerIn.bakeLayer(CMModelLayers.NETHERITE_MONSTROSITY_MODEL)), 2.5f);
        this.addLayer(new Netherite_Monstrosity_Layer(this));
        this.addLayer(new Netherite_Monstrosity_Layer2(this));
        this.addLayer(new Netherite_Monstrosity_Flare(this));
    }

    public Identifier getTextureLocation(Netherite_Monstrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }

    public boolean shouldRender(Netherite_Monstrosity_Entity livingEntityIn, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender((Entity)livingEntityIn, camera, camX, camY, camZ)) {
            return true;
        }
        for (Netherite_Monstrosity_Part part : livingEntityIn.monstrosityParts) {
            if (!camera.isVisible(part.getBoundingBox())) continue;
            return true;
        }
        return false;
    }

    protected void scale(Netherite_Monstrosity_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }

    protected float getFlipDegrees(Netherite_Monstrosity_Entity entity) {
        return 0.0f;
    }
}

