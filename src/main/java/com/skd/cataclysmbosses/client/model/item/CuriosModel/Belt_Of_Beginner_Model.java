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

public class Belt_Of_Beginner_Model
extends HumanoidModel<HumanoidRenderState> {
    public Belt_Of_Beginner_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshDefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(63, 0).addBox(-4.0f, -1.5f, -2.0f, 8.0f, 3.0f, 4.0f, new CubeDeformation(0.6f)), PartPose.offset((float)0.0f, (float)9.5f, (float)0.0f));
        PartDefinition cube_r1 = belt.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(63, 8).mirror().addBox(-1.5f, -3.0f, 0.0f, 3.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-4.0f, (float)0.25f, (float)-2.8f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition cube_r2 = belt.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(63, 8).addBox(-1.5f, -3.0f, 0.0f, 3.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.0f, (float)0.25f, (float)-2.8f, (float)0.0f, (float)0.0f, (float)0.1745f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body);
    }
}

