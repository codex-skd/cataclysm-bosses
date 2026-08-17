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
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.entity.Symbiocto_Model;
import com.skd.sundering.entity.InternalAnimationMonster.AcropolisMonsters.Symbiocto_Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Symbiocto_Renderer
extends MobRenderer<Symbiocto_Entity, Symbiocto_Model> {
    private static final Identifier OPEN = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/symbiocto_open.png");
    private static final Identifier CLOSE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/symbiocto_close.png");

    public Symbiocto_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Symbiocto_Model(renderManagerIn.bakeLayer(CMModelLayers.OCTOSITE_MODEL)), 0.25f);
    }

    public Identifier getTextureLocation(Symbiocto_Entity entity) {
        if (entity.isCloseEye()) {
            return CLOSE;
        }
        return OPEN;
    }
}

