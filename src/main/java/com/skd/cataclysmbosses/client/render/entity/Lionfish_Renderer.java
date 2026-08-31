package com.skd.cataclysmbosses.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/*
 * PORT NOTE (26.2): placeholder renderer (model port pending; Lionfish_Entity class
 * itself is still missing from this port and tracked in PORT_STATUS).
 */
@OnlyIn(Dist.CLIENT)
public class Lionfish_Renderer
extends EntityRenderer<Entity, EntityRenderState> {
    public Lionfish_Renderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    public Identifier getTextureLocation(Entity entity) {
        return Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/lionfish.png");
    }
}
