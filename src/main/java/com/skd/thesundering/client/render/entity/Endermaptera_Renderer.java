/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.ChatFormatting
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.entity.Endermaptera_Model;
import com.skd.thesundering.client.render.layer.LayerGenericGlowing;
import com.skd.thesundering.entity.AnimationMonster.Endermaptera_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Endermaptera_Renderer
extends MobRenderer<Endermaptera_Entity, Endermaptera_Model> {
    private static final Identifier SSAPBUG_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ender_ssap_bug.png");
    private static final Identifier SSAPBUG_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ender_ssap_bug_layer.png");

    public Endermaptera_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Endermaptera_Model(), 0.7f);
        this.addLayer(new LayerGenericGlowing(this, SSAPBUG_LAYER_TEXTURES));
    }

    public Identifier getTextureLocation(Endermaptera_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    protected void scale(Endermaptera_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }

    protected void setupRotations(Endermaptera_Entity entityLiving, PoseStack matrixStackIn, float p_115319_, float rotationYaw, float p_115321_, float p_320045_) {
        String s;
        if (this.isShaking((LivingEntity)entityLiving)) {
            rotationYaw += (float)(Math.cos((double)entityLiving.tickCount * 3.25) * Math.PI * (double)0.4f);
        }
        float trans = 0.5f;
        Pose pose = entityLiving.getPose();
        if (pose != Pose.SLEEPING) {
            float progresso = 1.0f - (entityLiving.prevAttachChangeProgress + (entityLiving.attachChangeProgress - entityLiving.prevAttachChangeProgress) * p_115321_);
            if (entityLiving.getAttachmentFacing() == Direction.DOWN) {
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0f - rotationYaw));
                matrixStackIn.translate(0.0, (double)trans, 0.0);
                if (entityLiving.yo < entityLiving.getY()) {
                    matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f * (1.0f - progresso)));
                } else {
                    matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90.0f * (1.0f - progresso)));
                }
                matrixStackIn.translate(0.0, (double)(-trans), 0.0);
            } else if (entityLiving.getAttachmentFacing() == Direction.UP) {
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0f - rotationYaw));
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(180.0f));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0f));
                matrixStackIn.translate(0.0, (double)(-trans), 0.0);
            } else {
                matrixStackIn.translate(0.0, (double)trans, 0.0);
                switch (entityLiving.getAttachmentFacing()) {
                    case NORTH: {
                        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f * progresso));
                        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(0.0f));
                        break;
                    }
                    case SOUTH: {
                        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0f));
                        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f * progresso));
                        break;
                    }
                    case WEST: {
                        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f));
                        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f - 90.0f * progresso));
                        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(-90.0f));
                        break;
                    }
                    case EAST: {
                        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f));
                        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f * progresso - 90.0f));
                        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(90.0f));
                    }
                }
                if (entityLiving.getDeltaMovement().y <= (double)-0.001f) {
                    matrixStackIn.mulPose(Axis.YP.rotationDegrees(-180.0f));
                }
                matrixStackIn.translate(0.0, (double)(-trans), 0.0);
            }
        }
        if (entityLiving.deathTime > 0) {
            float f = ((float)entityLiving.deathTime + p_115321_ - 1.0f) / 20.0f * 1.6f;
            if ((f = Mth.sqrt((float)f)) > 1.0f) {
                f = 1.0f;
            }
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f * this.getFlipDegrees((LivingEntity)entityLiving)));
        } else if (entityLiving.isAutoSpinAttack()) {
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90.0f - entityLiving.getXRot()));
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(((float)entityLiving.tickCount + p_115321_) * -75.0f));
        } else if (pose != Pose.SLEEPING && entityLiving.hasCustomName() && ("Dinnerbone".equals(s = ChatFormatting.stripFormatting((String)entityLiving.getName().getString())) || "Grumm".equals(s))) {
            matrixStackIn.translate(0.0, (double)(entityLiving.getBbHeight() + 0.1f), 0.0);
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(180.0f));
        }
    }
}

