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
public class Ignitium_Armor_Model
extends HumanoidModel {
    public Ignitium_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        head.addOrReplaceChild("right_helmet", CubeListBuilder.create().texOffs(0, 35).addBox(0.0f, -1.5f, -4.0f, 0.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.75f, (float)0.3f, (float)-4.75f, (float)0.0f, (float)-0.829f, (float)0.0f));
        head.addOrReplaceChild("left_helmet", CubeListBuilder.create().texOffs(0, 35).addBox(0.0f, -1.5f, -4.0f, 0.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)4.75f, (float)0.3f, (float)-4.75f, (float)0.0f, (float)0.829f, (float)0.0f));
        head.addOrReplaceChild("headplate", CubeListBuilder.create().texOffs(48, 34).addBox(-1.5f, -1.5f, -1.0f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-5.5f, (float)-4.25f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(54, 43).addBox(-1.0f, -5.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-3.6f, (float)-6.5f, (float)-3.6f, (float)0.3927f, (float)0.2182f, (float)-0.1309f));
        PartDefinition right_horn2 = right_horn.addOrReplaceChild("right_horn2", CubeListBuilder.create().texOffs(13, 41).addBox(-0.5f, -7.0f, 0.0f, 1.0f, 7.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-5.0f, (float)-1.0f, (float)-1.3526f, (float)0.0f, (float)0.0f));
        right_horn2.addOrReplaceChild("right_horn3", CubeListBuilder.create().texOffs(53, 37).addBox(-0.5f, 0.0f, -4.0f, 1.0f, 1.0f, 4.0f, new CubeDeformation(-0.01f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-7.0f, (float)2.0f, (float)-0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(54, 43).addBox(-1.0f, -5.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.6f, (float)-6.5f, (float)-3.6f, (float)0.3927f, (float)-0.2182f, (float)0.1309f));
        PartDefinition left_horn2 = left_horn.addOrReplaceChild("left_horn2", CubeListBuilder.create().texOffs(13, 41).addBox(-0.5f, -7.0f, 0.0f, 1.0f, 7.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-5.0f, (float)-1.0f, (float)-1.3526f, (float)0.0f, (float)0.0f));
        left_horn2.addOrReplaceChild("left_horn3", CubeListBuilder.create().texOffs(53, 37).addBox(-0.5f, 0.0f, -4.0f, 1.0f, 1.0f, 4.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)0.0f, (float)-7.0f, (float)2.0f, (float)-0.5236f, (float)0.0f, (float)0.0f));
        body.addOrReplaceChild("outer_body", CubeListBuilder.create().texOffs(30, 47).addBox(-4.5f, 1.0f, -2.5f, 9.0f, 12.0f, 5.0f, new CubeDeformation(0.4f)), PartPose.offset((float)0.0f, (float)-1.0f, (float)0.0f));
        body.addOrReplaceChild("inner_body", CubeListBuilder.create().texOffs(0, 51).addBox(-4.0f, -6.0f, -2.0f, 8.0f, 9.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offset((float)0.0f, (float)11.0f, (float)0.0f));
        PartDefinition left_shoulderpad = leftArm.addOrReplaceChild("left_shoulderpad", CubeListBuilder.create().texOffs(30, 33).addBox(-6.0f, -7.0f, -3.0f, 5.0f, 7.0f, 6.0f, new CubeDeformation(0.3f)), PartPose.offset((float)5.0f, (float)4.0f, (float)0.0f));
        PartDefinition left_spike = left_shoulderpad.addOrReplaceChild("left_spike", CubeListBuilder.create().texOffs(21, 43).addBox(-1.0f, -3.5f, 0.0f, 4.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-8.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.6109f));
        left_spike.addOrReplaceChild("left_side_spike", CubeListBuilder.create().texOffs(30, 47).addBox(0.5f, -3.5f, -0.5f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.5f, (float)3.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)0.829f));
        PartDefinition right_shoulderpad = rightArm.addOrReplaceChild("right_shoulderpad", CubeListBuilder.create().texOffs(30, 33).mirror().addBox(0.0f, -7.0f, -3.0f, 5.0f, 7.0f, 6.0f, new CubeDeformation(0.3f)).mirror(false), PartPose.offset((float)-4.0f, (float)4.0f, (float)0.0f));
        PartDefinition right_spike = right_shoulderpad.addOrReplaceChild("right_spike", CubeListBuilder.create().texOffs(21, 43).mirror().addBox(-3.0f, -3.5f, 0.0f, 4.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-8.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.6109f));
        right_spike.addOrReplaceChild("right_side_spike", CubeListBuilder.create().texOffs(30, 47).mirror().addBox(-2.5f, -3.5f, -0.5f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-2.5f, (float)3.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)-0.829f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
    }
}

