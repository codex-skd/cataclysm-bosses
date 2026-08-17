/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.entity.Deepling_Brute_Model;
import com.skd.sundering.client.render.layer.AbstractDeepling_Layer;
import com.skd.sundering.client.render.layer.LayerDeeplingBruteItem;
import com.skd.sundering.entity.Deepling.Deepling_Brute_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Deepling_Brute_Renderer
extends MobRenderer<Deepling_Brute_Entity, Deepling_Brute_Model> {
    private static final Identifier SSAPBUG_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_brute.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_brute_layer.png");

    public Deepling_Brute_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Deepling_Brute_Model(), 0.7f);
        this.addLayer(new AbstractDeepling_Layer(this, DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeeplingBruteItem((RenderLayerParent)this, renderManagerIn.getItemInHandRenderer()));
    }

    public Identifier getTextureLocation(Deepling_Brute_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    protected void scale(Deepling_Brute_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.125f, 1.125f, 1.125f);
    }

    protected void setupRotations(Deepling_Brute_Entity p_115317_, PoseStack p_115318_, float p_115319_, float rotationYaw, float p_115321_, float p_320045_) {
        if (this.isShaking((LivingEntity)p_115317_)) {
            rotationYaw += (float)(Math.cos((double)p_115317_.tickCount * 3.25) * Math.PI * (double)0.4f);
        }
        if (!p_115317_.hasPose(Pose.SLEEPING)) {
            p_115318_.mulPose(Axis.YP.rotationDegrees(180.0f - rotationYaw));
        }
        if (p_115317_.deathTime > 0) {
            float f = ((float)p_115317_.deathTime + p_115321_ - 1.0f) / 20.0f * 1.6f;
            if ((f = Mth.sqrt((float)f)) > 1.0f) {
                f = 1.0f;
            }
            p_115318_.mulPose(Axis.ZP.rotationDegrees(f * this.getFlipDegrees((LivingEntity)p_115317_)));
        } else if (p_115317_.isAutoSpinAttack() || p_115317_.getSpinAttack()) {
            p_115318_.mulPose(Axis.XP.rotationDegrees(-90.0f - p_115317_.getXRot()));
            p_115318_.mulPose(Axis.YP.rotationDegrees(((float)p_115317_.tickCount + p_115321_) * -75.0f));
        } else if (p_115317_.hasPose(Pose.SLEEPING)) {
            Direction direction = p_115317_.getBedOrientation();
            float f1 = direction != null ? Deepling_Brute_Renderer.sleepDirectionToRotation(direction) : rotationYaw;
            p_115318_.mulPose(Axis.YP.rotationDegrees(f1));
            p_115318_.mulPose(Axis.ZP.rotationDegrees(this.getFlipDegrees((LivingEntity)p_115317_)));
            p_115318_.mulPose(Axis.YP.rotationDegrees(270.0f));
        } else if (Deepling_Brute_Renderer.isEntityUpsideDown((LivingEntity)p_115317_)) {
            p_115318_.translate(0.0f, p_115317_.getBbHeight() + 0.1f, 0.0f);
            p_115318_.mulPose(Axis.ZP.rotationDegrees(180.0f));
        }
    }

    private static float sleepDirectionToRotation(Direction p_115329_) {
        switch (p_115329_) {
            case SOUTH: {
                return 90.0f;
            }
            case WEST: {
                return 0.0f;
            }
            case NORTH: {
                return 270.0f;
            }
            case EAST: {
                return 180.0f;
            }
        }
        return 0.0f;
    }
}

