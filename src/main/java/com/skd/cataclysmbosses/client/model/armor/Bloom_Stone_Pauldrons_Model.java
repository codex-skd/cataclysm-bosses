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
package com.skd.cataclysmbosses.client.model.armor;

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
public class Bloom_Stone_Pauldrons_Model
extends HumanoidModel {
    public Bloom_Stone_Pauldrons_Model(ModelPart p_170677_) {
        super(p_170677_);
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        rightArm.addOrReplaceChild("RightShoulder", CubeListBuilder.create().texOffs(52, 76).addBox(-5.5f, 0.5f, -2.5f, 5.0f, 5.0f, 5.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)0.75f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition LeftShoulder = leftArm.addOrReplaceChild("LeftShoulder", CubeListBuilder.create().texOffs(65, 25).addBox(0.5f, 0.5f, -3.5f, 6.0f, 5.0f, 7.0f, new CubeDeformation(0.5f)).texOffs(28, 65).addBox(6.5f, 0.5f, 0.0f, 4.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(63, 87).addBox(1.5f, -4.5f, -1.5f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-3.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        LeftShoulder.addOrReplaceChild("Amethyst", CubeListBuilder.create().texOffs(22, 79).addBox(-1.0f, -3.0f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3054f));
        LeftShoulder.addOrReplaceChild("Amethyst2", CubeListBuilder.create().texOffs(12, 83).addBox(-1.1f, 0.0f, -2.5f, 2.0f, 4.0f, 5.0f, new CubeDeformation(0.5f)).texOffs(0, 65).addBox(1.3f, 0.7f, 0.0f, 3.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.3f, (float)5.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition Chest = body.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(65, 38).addBox(-5.0f, -3.0f, -2.0f, 10.0f, 6.0f, 4.0f, new CubeDeformation(0.5f)).texOffs(60, 60).addBox(-6.0f, -4.0f, -2.0f, 12.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(73, 76).addBox(-2.0f, -3.0f, 2.5f, 4.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(0, 79).addBox(-2.0f, -3.0f, 2.5f, 4.0f, 4.0f, 4.0f, new CubeDeformation(0.2f)).texOffs(48, 87).addBox(-1.5f, 2.0f, 2.5f, 3.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)4.0f, (float)0.1745f, (float)0.0f, (float)0.0f));
        Chest.addOrReplaceChild("Chest_lush", CubeListBuilder.create().texOffs(31, 76).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 7.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0f, (float)-3.8f, (float)-6.4f, (float)0.1309f, (float)0.0f, (float)0.0f));
        Chest.addOrReplaceChild("Chest2", CubeListBuilder.create().texOffs(0, 65).addBox(-5.0f, 0.5f, -8.0f, 10.0f, 6.0f, 7.0f, new CubeDeformation(0.6f)).texOffs(65, 49).addBox(-5.0f, 7.1f, -8.0f, 10.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(65, 0).addBox(-4.0f, -3.9f, -6.0f, 8.0f, 4.0f, 8.0f, new CubeDeformation(0.6f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.9f, (float)-1.4f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition Waist = body.addOrReplaceChild("Waist", CubeListBuilder.create().texOffs(35, 65).addBox(-4.0f, -0.3f, 0.0f, 8.0f, 6.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)0.0f, (float)5.0f, (float)2.3f, (float)-0.1745f, (float)0.0f, (float)0.0f));
        Waist.addOrReplaceChild("Waist_Lush", CubeListBuilder.create().texOffs(65, 13).addBox(-5.0f, 0.0f, 0.0f, 10.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.2618f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }
}

