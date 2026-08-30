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
import com.skd.cataclysmbosses.client.model.entity.Symbiocto_Model;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Symbiocto_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Symbiocto_Renderer extends CmEntityRenderer<Symbiocto_Entity> {
    private static final Identifier SYMbiocto_OPEN = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/sea/symbiocto_open.png");
    private static final Identifier SYMbiocto_CLOSE = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/sea/symbiocto_close.png");

    public Symbiocto_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void render(Symbiocto_Entity entity, float f1, PoseStack posestack, CmMultiBufferSource multibuffersource, int i) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Symbiocto_Entity entity) {
        return entity.isCloseEye() ? SYMbiocto_CLOSE : SYMbiocto_OPEN;
    }
}

