/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Cursium_Armor_Model
extends HumanoidModel {
    public Cursium_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        PartDefinition rightLeg = partdefinition.getChild("right_leg");
        PartDefinition leftLeg = partdefinition.getChild("left_leg");
        PartDefinition RightCustomArm = rightArm.addOrReplaceChild("RightCustomArm", CubeListBuilder.create().texOffs(22, 89).addBox(-3.0f, -2.0f, -2.0f, 4.0f, 5.0f, 4.0f, new CubeDeformation(0.525f)).texOffs(22, 105).addBox(-3.6f, 3.0f, -2.0f, 4.0f, 5.0f, 4.0f, new CubeDeformation(0.6f)), PartPose.offset((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition right_shoulder = RightCustomArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create(), PartPose.offset((float)-2.5f, (float)2.0f, (float)0.0f));
        PartDefinition rib = body.addOrReplaceChild("rib", CubeListBuilder.create().texOffs(100, 0).addBox(-4.0f, -2.0f, -3.0f, 8.0f, 12.0f, 6.0f, new CubeDeformation(0.6f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition chestplate_r1 = right_shoulder.addOrReplaceChild("chestplate_r1", CubeListBuilder.create().texOffs(0, 92).addBox(-2.5f, -6.0f, -2.5f, 5.0f, 12.0f, 5.0f, new CubeDeformation(0.55f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition LeftCustomArm = leftArm.addOrReplaceChild("LeftCustomArm", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-1.0f, -2.0f, -2.0f, 4.0f, 5.0f, 4.0f, new CubeDeformation(0.525f)).mirror(false).texOffs(22, 105).mirror().addBox(-0.4f, 3.0f, -2.0f, 4.0f, 5.0f, 4.0f, new CubeDeformation(0.6f)).mirror(false), PartPose.offset((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition left_shoulder = LeftCustomArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create(), PartPose.offset((float)2.5f, (float)2.0f, (float)0.0f));
        PartDefinition chestplate_r2 = left_shoulder.addOrReplaceChild("chestplate_r2", CubeListBuilder.create().texOffs(0, 92).mirror().addBox(-2.5f, -6.0f, -2.5f, 5.0f, 12.0f, 5.0f, new CubeDeformation(0.55f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition right_leggings_plate = rightLeg.addOrReplaceChild("right_leggings_plate", CubeListBuilder.create().texOffs(62, 108).addBox(-5.8f, -12.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.8f)), PartPose.offsetAndRotation((float)1.9f, (float)11.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0873f));
        PartDefinition right_boots_leggings = rightLeg.addOrReplaceChild("right_boots_leggings", CubeListBuilder.create().texOffs(80, 115).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.25f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leggings_plate = leftLeg.addOrReplaceChild("left_leggings_plate", CubeListBuilder.create().texOffs(62, 108).mirror().addBox(2.8f, -12.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.8f)).mirror(false), PartPose.offsetAndRotation((float)-1.9f, (float)11.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition left_boots_leggings = leftLeg.addOrReplaceChild("left_boots_leggings", CubeListBuilder.create().texOffs(80, 115).mirror().addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.25f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-6.2f, (float)-10.0f, (float)0.0f, (float)-0.2618f, (float)0.0f, (float)-0.6545f));
        PartDefinition cube_r1 = right_horn.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(97, 122).addBox(-5.811f, -19.4301f, 0.1321f, 12.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 118).addBox(-9.811f, -17.4301f, 0.1321f, 5.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(18, 115).addBox(-4.811f, -17.4301f, -1.8679f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)12.0f, (float)2.0f, (float)0.1309f, (float)0.0f, (float)-0.3054f));
        PartDefinition cube_r2 = right_horn.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 110).addBox(-0.811f, -17.4301f, -1.3679f, 7.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0196f, (float)12.0622f, (float)1.5043f, (float)0.1309f, (float)0.0f, (float)-0.3054f));
        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create(), PartPose.offsetAndRotation((float)6.2f, (float)-10.0f, (float)0.0f, (float)-0.2618f, (float)0.0f, (float)0.6545f));
        PartDefinition cube_r3 = left_horn.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(97, 122).mirror().addBox(-6.189f, -19.4301f, 0.1321f, 12.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 118).mirror().addBox(4.811f, -17.4301f, 0.1321f, 5.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(18, 115).mirror().addBox(0.811f, -17.4301f, -1.8679f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.0f, (float)12.0f, (float)2.0f, (float)0.1309f, (float)0.0f, (float)0.3054f));
        PartDefinition cube_r4 = left_horn.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 110).mirror().addBox(-6.189f, -17.4301f, -1.3679f, 7.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.0196f, (float)12.0622f, (float)1.5043f, (float)0.1309f, (float)0.0f, (float)0.3054f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }
}

