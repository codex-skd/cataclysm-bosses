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
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.entity.Ignited_Revenant_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.layer.Revenant_Layer;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ignited_Revenant_Renderer
extends MobRenderer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {
    private static final Identifier IGNITED_REVENANT_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/revenant_body.png");
    private static final Identifier IGNITED_REVENANT_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/revenant_layer.png");
    private final RandomSource rnd = RandomSource.create();

    public Ignited_Revenant_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Ignited_Revenant_Model(), 0.5f);
        this.addLayer(new Ignited_Revenant_GlowLayer(this));
        this.addLayer(new Revenant_Layer(this));
    }

    public Identifier getTextureLocation(Ignited_Revenant_Entity entity) {
        return IGNITED_REVENANT_TEXTURES;
    }

    protected void scale(Ignited_Revenant_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.1f, 1.1f, 1.1f);
    }

    public Vec3 getRenderOffset(Ignited_Revenant_Entity entityIn, float partialTicks) {
        if (entityIn.getAnimation() == Ignited_Revenant_Entity.ASH_BREATH_ATTACK && entityIn.getAnimationTick() >= 28 && entityIn.getAnimationTick() <= 43) {
            double d0 = 0.02;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0, this.rnd.nextGaussian() * d0);
        }
        return super.getRenderOffset((Entity)entityIn, partialTicks);
    }

    static class Ignited_Revenant_GlowLayer
    extends RenderLayer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {
        public Ignited_Revenant_GlowLayer(Ignited_Revenant_Renderer p_i50928_1_) {
            super((RenderLayerParent)p_i50928_1_);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Revenant_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getFlickering(IGNITED_REVENANT_LAYER_TEXTURES));
            float alpha = 0.5f + (Mth.cos((float)(ageInTicks * 0.2f)) + 1.0f) * 0.2f;
            int i = FastColor.ARGB32.color((int)Mth.floor((float)(alpha * 255.0f)), (int)255, (int)255, (int)255);
            ((Ignited_Revenant_Model)this.getParentModel()).renderToBuffer(matrixStackIn, ivertexbuilder, 240, LivingEntityRenderer.getOverlayCoords((LivingEntity)entitylivingbaseIn, (float)0.0f), i);
        }
    }
}

