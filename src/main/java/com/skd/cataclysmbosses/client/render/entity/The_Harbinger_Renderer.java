/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4f
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.The_Harbinger_Model;
import com.skd.cataclysmbosses.client.render.layer.The_Harbinger_Item_Layer;
import com.skd.cataclysmbosses.client.render.layer.The_Harbinger_Jet_Layer;
import com.skd.cataclysmbosses.client.render.layer.The_Harbinger_Layer;
import com.skd.cataclysmbosses.client.render.layer.The_Harbinger_Shield_Layer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

@OnlyIn(value=Dist.CLIENT)
public class The_Harbinger_Renderer
extends CmMobRenderer<The_Harbinger_Entity> {
    private static final Identifier HARBINGER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/the_harbinger.png");
    private final RandomSource rnd = RandomSource.create();
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0) / 2.0);

    public The_Harbinger_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new The_Harbinger_Model(), 1.0f);
        this.addLayer(new The_Harbinger_Layer(this));
        this.addLayer(new The_Harbinger_Jet_Layer(this, renderManagerIn));
        this.addLayer(new The_Harbinger_Shield_Layer(this));
        this.addLayer(new The_Harbinger_Item_Layer(this, ((The_Harbinger_Model)this.getModel()).nether_star, Items.NETHER_STAR.getDefaultInstance(), ItemDisplayContext.GROUND));
    }

    public Identifier getTextureLocation(The_Harbinger_Entity entity) {
        return HARBINGER_TEXTURES;
    }

    public Vec3 getRenderOffset(The_Harbinger_Entity entityIn, float partialTicks) {
        if (entityIn.getAnimation() == The_Harbinger_Entity.DEATHLASER_ANIMATION && entityIn.getAnimationTick() >= 27 && entityIn.getAnimationTick() <= 48 || entityIn.getAnimation() == The_Harbinger_Entity.DEATH_ANIMATION || entityIn.getAnimation() == The_Harbinger_Entity.STUN_ANIAMATION && entityIn.getAnimationTick() <= 90) {
            double d0 = 0.05;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0, this.rnd.nextGaussian() * d0);
        }
        return super.getRenderOffset((Entity)entityIn, partialTicks);
    }

    protected void render(The_Harbinger_Entity entity, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        if (entity.deathTime > 0) {
            float f5 = ((float)entity.deathTime + partialTicks) / 144.0f;
            float f7 = Math.min(f5 > 0.8f ? (f5 - 0.8f) / 0.2f : 0.0f, 1.0f);
            RandomSource randomsource = RandomSource.create((long)432L);
            VertexConsumer vertexconsumer2 = bufferIn.getBuffer(RenderType.lightning());
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.0, 1.8, 0.0);
            int i = 0;
            while ((float)i < (f5 + f5 * f5) / 2.0f * 30.0f) {
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0f + f5 * 90.0f));
                float f3 = randomsource.nextFloat() * 5.0f + 5.0f + f7 * 10.0f;
                float f4 = randomsource.nextFloat() * 0.5f + 1.0f + f7 * 2.0f;
                Matrix4f matrix4f = matrixStackIn.last().pose();
                int j = (int)(255.0f * (1.0f - f7));
                The_Harbinger_Renderer.vertex01(vertexconsumer2, matrix4f, j);
                The_Harbinger_Renderer.vertex2(vertexconsumer2, matrix4f, f3, f4);
                The_Harbinger_Renderer.vertex3(vertexconsumer2, matrix4f, f3, f4);
                The_Harbinger_Renderer.vertex01(vertexconsumer2, matrix4f, j);
                The_Harbinger_Renderer.vertex3(vertexconsumer2, matrix4f, f3, f4);
                The_Harbinger_Renderer.vertex4(vertexconsumer2, matrix4f, f3, f4);
                The_Harbinger_Renderer.vertex01(vertexconsumer2, matrix4f, j);
                The_Harbinger_Renderer.vertex4(vertexconsumer2, matrix4f, f3, f4);
                The_Harbinger_Renderer.vertex2(vertexconsumer2, matrix4f, f3, f4);
                ++i;
            }
            matrixStackIn.popPose();
        }
        matrixStackIn.popPose();
    }

    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.addVertex(p_114221_, 0.0f, 0.0f, 0.0f).setColor(255, 51, 0, p_114222_);
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.addVertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5f * p_114218_).setColor(255, 51, 0, 0);
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.addVertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5f * p_114227_).setColor(255, 51, 0, 0);
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.addVertex(p_114230_, 0.0f, p_114231_, 1.0f * p_114232_).setColor(255, 51, 0, 0);
    }

    protected void scale(The_Harbinger_Entity entityIn, PoseStack p_116440_, float p_116441_) {
        float f = 2.0f;
        p_116440_.scale(f, f, f);
    }

    protected int getBlockLightLevel(The_Harbinger_Entity entityIn, BlockPos pos) {
        return 15;
    }

    protected float getFlipDegrees(The_Harbinger_Entity entity) {
        return 0.0f;
    }
}

