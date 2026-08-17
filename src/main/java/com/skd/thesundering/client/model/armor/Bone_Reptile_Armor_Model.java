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
package com.skd.thesundering.client.model.armor;

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
public class Bone_Reptile_Armor_Model
extends HumanoidModel {
    public Bone_Reptile_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0f, -1.5f, -4.0f, 4.0f, 3.0f, 4.0f, new CubeDeformation(1.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-6.4224f, (float)-5.7783f, (float)0.0873f, (float)0.0f, (float)0.0f));
        head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create().texOffs(20, 36).mirror().addBox(-3.9f, 1.0f, -6.2f, 3.0f, 4.0f, 5.0f, new CubeDeformation(1.0f)).mirror(false), PartPose.offsetAndRotation((float)4.9f, (float)-5.0f, (float)0.2f, (float)0.2618f, (float)-0.3054f, (float)0.0f));
        head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(20, 36).addBox(0.9f, 1.0f, -6.2f, 3.0f, 4.0f, 5.0f, new CubeDeformation(1.0f)), PartPose.offsetAndRotation((float)-4.9f, (float)-5.0f, (float)0.2f, (float)0.2618f, (float)0.3054f, (float)0.0f));
        head.addOrReplaceChild("Helmet_r4", CubeListBuilder.create().texOffs(0, 45).addBox(-4.5f, -2.4f, -4.0f, 9.0f, 2.0f, 8.0f, new CubeDeformation(1.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-7.0f, (float)0.0f, (float)0.3054f, (float)0.0f, (float)0.0f));
        head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-3.0f, -3.3f, -2.0f, 3.0f, 5.0f, 1.0f, new CubeDeformation(1.0f)).mirror(false).texOffs(8, 40).mirror().addBox(-3.0f, -3.3f, 1.0f, 3.0f, 2.0f, 3.0f, new CubeDeformation(1.0f)).mirror(false), PartPose.offset((float)-6.0f, (float)-8.0f, (float)5.0f));
        head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(0, 39).addBox(0.0f, -3.3f, -2.0f, 3.0f, 5.0f, 1.0f, new CubeDeformation(1.0f)).texOffs(8, 40).addBox(0.0f, -3.3f, 1.0f, 3.0f, 2.0f, 3.0f, new CubeDeformation(1.0f)), PartPose.offset((float)6.0f, (float)-8.0f, (float)5.0f));
        head.addOrReplaceChild("mid_horn", CubeListBuilder.create().texOffs(53, 111).addBox(-2.5f, -1.7f, -6.0f, 5.0f, 4.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-9.8f, (float)4.4f, (float)0.5236f, (float)0.0f, (float)0.0f));
        body.addOrReplaceChild("body_bone", CubeListBuilder.create().texOffs(0, 108).addBox(-6.0f, 0.0f, -1.85f, 10.0f, 14.0f, 6.0f, new CubeDeformation(0.45f)).texOffs(0, 87).addBox(-2.0f, 0.0f, 5.0f, 2.0f, 14.0f, 1.0f, new CubeDeformation(0.5f)).texOffs(32, 92).addBox(-1.0f, 0.0f, 6.5f, 0.0f, 14.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)1.0f, (float)-1.0f, (float)-1.0f));
        rightArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(0, 95).addBox(-8.0f, -4.0f, -4.0f, 9.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 78).addBox(-8.0f, -6.0f, -4.0f, 6.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.5f));
        rightArm.addOrReplaceChild("right_fist", CubeListBuilder.create().texOffs(44, 105).addBox(-5.5f, -2.0f, -3.0f, 3.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offset((float)3.0f, (float)6.0f, (float)-0.5f));
        leftArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(0, 95).mirror().addBox(-1.0f, -4.0f, -4.0f, 9.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 78).mirror().addBox(2.0f, -6.0f, -4.0f, 6.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.5f));
        leftArm.addOrReplaceChild("left_fist", CubeListBuilder.create().texOffs(44, 105).mirror().addBox(2.5f, -2.0f, -3.0f, 3.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-3.0f, (float)6.0f, (float)-0.5f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }
}

