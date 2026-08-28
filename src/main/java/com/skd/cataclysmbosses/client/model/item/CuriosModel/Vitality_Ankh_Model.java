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

public class Vitality_Ankh_Model
extends HumanoidModel<HumanoidRenderState> {
    public Vitality_Ankh_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition body = partDefinition.getChild("body");
        PartDefinition ankh = body.addOrReplaceChild("ankh", CubeListBuilder.create().texOffs(63, 35).addBox(-1.0f, -1.0f, -2.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(63, 40).addBox(-0.5f, -0.5f, -2.25f, 1.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(63, 30).addBox(-3.0f, -0.5f, -1.0f, 6.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)1.5f, (float)-1.5f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of((Object)this.body);
    }
}

