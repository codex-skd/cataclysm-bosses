/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.client.player.AbstractClientPlayer
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.client.model.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class Ignitium_Elytra_chestplate_Model<T extends LivingEntity>
extends HumanoidModel<T> {
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public Ignitium_Elytra_chestplate_Model(ModelPart part) {
        super(part);
        this.leftWing = part.getChild("body").getChild("left_wing");
        this.rightWing = part.getChild("body").getChild("right_wing");
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = meshdefinition.getRoot().getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 65).mirror().addBox(-11.0f, 0.0f, 1.5f, 11.0f, 23.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)6.0f, (float)0.0f, (float)1.5f, (float)0.2617994f, (float)0.0f, (float)-0.2617994f));
        body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 65).addBox(0.0f, 0.0f, 1.5f, 11.0f, 23.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.0f, (float)0.0f, (float)1.5f, (float)0.2617994f, (float)0.0f, (float)0.2617994f));
        body.addOrReplaceChild("outer_body", CubeListBuilder.create().texOffs(30, 47).addBox(-4.5f, 1.0f, -2.5f, 9.0f, 12.0f, 5.0f, new CubeDeformation(0.4f)), PartPose.offset((float)0.0f, (float)-1.0f, (float)0.0f));
        body.addOrReplaceChild("inner_body", CubeListBuilder.create().texOffs(0, 51).addBox(-4.0f, -6.0f, -2.0f, 8.0f, 9.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offset((float)0.0f, (float)11.0f, (float)0.0f));
        PartDefinition left_shoulderpad = leftArm.addOrReplaceChild("left_shoulderpad", CubeListBuilder.create().texOffs(30, 33).addBox(-6.0f, -7.0f, -3.0f, 5.0f, 7.0f, 6.0f, new CubeDeformation(0.3f)), PartPose.offset((float)5.0f, (float)4.0f, (float)0.0f));
        PartDefinition left_spike = left_shoulderpad.addOrReplaceChild("left_spike", CubeListBuilder.create().texOffs(21, 43).addBox(-1.0f, -3.5f, 0.0f, 4.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-8.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.6109f));
        left_spike.addOrReplaceChild("left_side_spike", CubeListBuilder.create().texOffs(30, 47).addBox(0.5f, -3.5f, -0.5f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.5f, (float)3.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)0.829f));
        PartDefinition right_shoulderpad = rightArm.addOrReplaceChild("right_shoulderpad", CubeListBuilder.create().texOffs(30, 33).mirror().addBox(0.0f, -7.0f, -3.0f, 5.0f, 7.0f, 6.0f, new CubeDeformation(0.3f)).mirror(false), PartPose.offset((float)-4.0f, (float)4.0f, (float)0.0f));
        PartDefinition right_spike = right_shoulderpad.addOrReplaceChild("right_spike", CubeListBuilder.create().texOffs(21, 43).mirror().addBox(-3.0f, -3.5f, 0.0f, 4.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-8.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.6109f));
        right_spike.addOrReplaceChild("right_side_spike", CubeListBuilder.create().texOffs(30, 47).mirror().addBox(-2.5f, -3.5f, -0.5f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-2.5f, (float)3.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)-0.829f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public Ignitium_Elytra_chestplate_Model withAnimations(LivingEntity entity) {
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float limbSwingAmount = entity.walkAnimation.speed(partialTick);
        float limbSwing = entity.walkAnimation.position() + partialTick;
        this.setupAnim(entity, limbSwing, limbSwingAmount, (float)entity.tickCount + partialTick, 0.0f, 0.0f);
        return this;
    }

    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 0.2617994f;
        float f1 = -0.2617994f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (entity.isFallFlying()) {
            float f4 = 1.0f;
            Vec3 vec3 = entity.getDeltaMovement();
            if (vec3.y < 0.0) {
                Vec3 vec31 = vec3.normalize();
                f4 = 1.0f - (float)Math.pow(-vec31.y, 1.5);
            }
            f = f4 * 0.34906584f + (1.0f - f4) * f;
            f1 = f4 * -1.5707964f + (1.0f - f4) * f1;
        } else if (entity.isCrouching()) {
            f = 0.6981317f;
            f1 = -0.7853982f;
            f2 = 3.0f;
            f3 = 0.08726646f;
        }
        this.leftWing.y = f2;
        if (entity instanceof AbstractClientPlayer) {
            AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
            abstractclientplayer.elytraRotX += (f - abstractclientplayer.elytraRotX) * 0.1f;
            abstractclientplayer.elytraRotY += (f3 - abstractclientplayer.elytraRotY) * 0.1f;
            abstractclientplayer.elytraRotZ += (f1 - abstractclientplayer.elytraRotZ) * 0.1f;
            this.leftWing.xRot = abstractclientplayer.elytraRotX;
            this.leftWing.yRot = abstractclientplayer.elytraRotY;
            this.leftWing.zRot = abstractclientplayer.elytraRotZ;
        } else {
            this.leftWing.xRot = f;
            this.leftWing.zRot = f1;
            this.leftWing.yRot = f3;
        }
        this.rightWing.yRot = -this.leftWing.yRot;
        this.rightWing.y = this.leftWing.y;
        this.rightWing.xRot = this.leftWing.xRot;
        this.rightWing.zRot = -this.leftWing.zRot;
    }
}

