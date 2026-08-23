/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.HumanoidRenderState
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.cataclysmbosses.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HumanoidRenderState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Belt_Of_Monstrosity_Model
extends HumanoidModel<HumanoidRenderState> {
    public Belt_Of_Monstrosity_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(63, 0).addBox(-4.0f, -1.5f, -2.0f, 8.0f, 3.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(63, 15).addBox(0.5f, 0.25f, -1.5f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(63, 22).addBox(1.75f, -2.25f, -0.5f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(63, 22).mirror().addBox(-4.75f, -2.25f, -0.5f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(63, 15).mirror().addBox(-4.5f, 0.25f, -1.5f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)9.5f, (float)0.0f));
        PartDefinition cube_r1 = belt.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(63, 8).mirror().addBox(-1.5f, -3.0f, 0.0f, 3.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-4.0f, (float)1.25f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition cube_r2 = belt.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(63, 8).addBox(-1.5f, -3.0f, 0.0f, 3.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.0f, (float)1.25f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition left_side = belt.addOrReplaceChild("left_side", CubeListBuilder.create(), PartPose.offset((float)0.125f, (float)0.0f, (float)0.125f));
        PartDefinition scale = left_side.addOrReplaceChild("scale", CubeListBuilder.create(), PartPose.offsetAndRotation((float)4.375f, (float)-1.25f, (float)1.125f, (float)-0.3065f, (float)-0.0832f, (float)0.0263f));
        PartDefinition scale2 = left_side.addOrReplaceChild("scale2", CubeListBuilder.create(), PartPose.offsetAndRotation((float)4.625f, (float)1.25f, (float)0.875f, (float)-0.3155f, (float)-0.2494f, (float)0.0804f));
        PartDefinition right_side = belt.addOrReplaceChild("right_side", CubeListBuilder.create(), PartPose.offset((float)-0.125f, (float)0.0f, (float)0.125f));
        PartDefinition scale5 = right_side.addOrReplaceChild("scale5", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-4.375f, (float)-1.25f, (float)1.125f, (float)-0.3065f, (float)0.0832f, (float)-0.0263f));
        PartDefinition scale6 = right_side.addOrReplaceChild("scale6", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-4.625f, (float)1.25f, (float)0.875f, (float)-0.3155f, (float)0.2494f, (float)-0.0804f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of((Object)this.body);
    }
}

