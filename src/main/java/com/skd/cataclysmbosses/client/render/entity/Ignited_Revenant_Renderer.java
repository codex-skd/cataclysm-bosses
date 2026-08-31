/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Ignited_Revenant_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.client.render.layer.Revenant_Layer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderState;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ignited_Revenant_Renderer
extends CmMobRenderer<Ignited_Revenant_Entity> {
    private static final Identifier IGNITED_REVENANT_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/revenant_body.png");
    private static final Identifier IGNITED_REVENANT_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/revenant_layer.png");
    private final RandomSource rnd = RandomSource.create();

    public Ignited_Revenant_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ignited_Revenant_Model(), 0.5f);
        this.addLayer(new Ignited_Revenant_GlowLayer(this));
        this.addLayer(new Revenant_Layer(this));
    }

    @Override
    protected void render(Ignited_Revenant_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Ignited_Revenant_Entity entity) {
        return IGNITED_REVENANT_TEXTURES;
    }

    protected void scale(Ignited_Revenant_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.1f, 1.1f, 1.1f);
    }

    public Vec3 getRenderOffset(CmEntityRenderState state) {
        Ignited_Revenant_Entity entityIn = (Ignited_Revenant_Entity) state.entity;
        if (entityIn.getAnimation() == Ignited_Revenant_Entity.ASH_BREATH_ATTACK && entityIn.getAnimationTick() >= 28 && entityIn.getAnimationTick() <= 43) {
            double d0 = 0.02;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0, this.rnd.nextGaussian() * d0);
        }
        return super.getRenderOffset(state);
    }

    // PORT NOTE (26.2): stubbed for compile — original RenderLayer used old
    // MultiBufferSource/Entity API. Proper port needs RenderLayer<LivingEntityRenderState, EntityModel>
    // with SubmitNodeCollector. Tracked separately.
    static class Ignited_Revenant_GlowLayer {
        public Ignited_Revenant_GlowLayer(Object... args) {}
        public void render(PoseStack poseStack, Object buffer, int packedLight, Object entity, float a, float b, float c, float d, float e, float f) {}
    }
}

