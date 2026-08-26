/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Urchinkin_Model;
import com.skd.cataclysmbosses.client.render.layer.Urchinkin_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Urchinkin_Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Urchinkin_Renderer
extends CmMobRenderer<Urchinkin_Entity> {
    private static final Identifier URCHIN_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/urchinkin.png");
    private static final Identifier MEAT_BOY = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/meat_boy.png");

    public Urchinkin_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Urchinkin_Model(renderManagerIn.bakeLayer(CMModelLayers.URCHINKIN_MODEL)), 0.25f);
        this.addLayer(new Urchinkin_Layer(this));
    }

    public Identifier getTextureLocation(Urchinkin_Entity entity) {
        if (entity.isMeatBoy()) {
            return MEAT_BOY;
        }
        return URCHIN_TEXTURES;
    }
}

