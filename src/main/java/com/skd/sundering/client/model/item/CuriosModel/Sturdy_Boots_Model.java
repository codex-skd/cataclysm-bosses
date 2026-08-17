/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.sundering.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class Sturdy_Boots_Model
extends HumanoidModel<LivingEntity> {
    public Sturdy_Boots_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition right_leg = partdefinition.getChild("right_leg");
        PartDefinition left_leg = partdefinition.getChild("left_leg");
        PartDefinition right_boot = right_leg.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(63, 35).addBox(-2.0f, -3.25f, -2.0f, 4.0f, 3.0f, 4.0f, deformation.extend(0.27f)).texOffs(89, 41).addBox(-1.5f, -3.75f, -2.35f, 3.0f, 2.0f, 0.0f, deformation.extend(0.0f)).texOffs(63, 48).addBox(-2.0f, -1.75f, -4.5f, 4.0f, 2.0f, 2.0f, deformation.extend(0.27f)).texOffs(75, 32).addBox(-2.5f, -5.5f, -2.5f, 5.0f, 2.0f, 5.0f, deformation.extend(0.0f)).texOffs(75, 53).addBox(-2.5f, -6.0f, -2.5f, 5.0f, 2.0f, 5.0f, deformation.extend(0.1f)).texOffs(63, 42).addBox(-2.0f, -1.75f, -1.5f, 4.0f, 2.0f, 4.0f, deformation.extend(0.3f)), PartPose.offset((float)0.0f, (float)12.0f, (float)0.0f));
        PartDefinition left_boot = left_leg.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(63, 35).mirror().addBox(-2.0f, -3.25f, -2.0f, 4.0f, 3.0f, 4.0f, deformation.extend(0.27f)).mirror(false).texOffs(89, 41).mirror().addBox(-1.5f, -3.75f, -2.35f, 3.0f, 2.0f, 0.0f, deformation.extend(0.0f)).mirror(false).texOffs(63, 48).mirror().addBox(-2.0f, -1.75f, -4.5f, 4.0f, 2.0f, 2.0f, deformation.extend(0.27f)).mirror(false).texOffs(75, 32).mirror().addBox(-2.5f, -5.5f, -2.5f, 5.0f, 2.0f, 5.0f, deformation.extend(0.0f)).mirror(false).texOffs(75, 53).mirror().addBox(-2.5f, -6.0f, -2.5f, 5.0f, 2.0f, 5.0f, deformation.extend(0.1f)).mirror(false).texOffs(63, 42).mirror().addBox(-2.0f, -1.75f, -1.5f, 4.0f, 2.0f, 4.0f, deformation.extend(0.3f)).mirror(false), PartPose.offset((float)0.0f, (float)12.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of((Object)this.leftLeg, (Object)this.rightLeg);
    }
}

