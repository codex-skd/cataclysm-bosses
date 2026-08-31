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
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Unbreakable_Skull_Model
extends HumanoidModel<HumanoidRenderState> {
    public Unbreakable_Skull_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create(), PartPose.offset((float)4.0f, (float)12.0f, (float)0.0f));
        PartDefinition metal_plated_skull = belt.addOrReplaceChild("metal_plated_skull", CubeListBuilder.create().texOffs(63, 24).addBox(-1.0f, -3.0f, -3.0f, 4.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(63, 32).addBox(3.0f, -1.0f, -3.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(76, 36).addBox(-1.0f, -3.5f, -3.2f, 4.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(76, 36).addBox(-1.0f, -3.5f, 1.2f, 4.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(68, 39).addBox(0.75f, -2.0f, 1.05f, 1.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(68, 39).addBox(0.75f, -2.0f, -3.05f, 1.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition jaw = metal_plated_skull.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(63, 17).addBox(-1.0f, -1.0f, -2.0f, 6.0f, 2.0f, 4.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)-0.25f, (float)-0.25f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)0.2618f));
        PartDefinition tilt = metal_plated_skull.addOrReplaceChild("tilt", CubeListBuilder.create().texOffs(76, 32).addBox(-2.0f, -0.5f, -1.0f, 4.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)-3.5f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition horns = metal_plated_skull.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-0.5f, (float)-3.25f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        PartDefinition left_horn = horns.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(80, 24).addBox(-0.5f, -2.0f, 0.0f, 2.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(63, 38).addBox(-1.5f, -2.0f, 0.0f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)2.1f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_horn = horns.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(80, 24).addBox(-0.5f, -2.0f, -1.0f, 2.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(63, 38).addBox(-1.5f, -2.0f, -1.0f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-2.1f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body);
    }
}

