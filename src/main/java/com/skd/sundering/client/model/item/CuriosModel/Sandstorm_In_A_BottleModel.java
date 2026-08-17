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

public class Sandstorm_In_A_BottleModel
extends HumanoidModel<LivingEntity> {
    public Sandstorm_In_A_BottleModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition body = partDefinition.getChild("body");
        PartDefinition root = body.addOrReplaceChild("root", CubeListBuilder.create().texOffs(65, 10).addBox(-4.0f, -1.0f, -2.0f, 8.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(63, 16).addBox(-1.0f, 1.0f, -2.0f, 2.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)9.0f, (float)0.0f));
        root.addOrReplaceChild("bottle", CubeListBuilder.create().texOffs(75, 24).mirror().addBox(-1.5f, -0.5f, -1.45f, 3.0f, 1.0f, 3.0f, new CubeDeformation(0.1f)).mirror(false).texOffs(63, 24).mirror().addBox(-1.5f, -1.0f, -1.45f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(71, 33).mirror().addBox(-1.5f, 4.0f, -1.45f, 3.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(63, 35).mirror().addBox(-1.0f, 0.7f, -1.05f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.2f)).mirror(false).texOffs(63, 32).mirror().addBox(-1.0f, -2.0f, -1.05f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-3.5f, (float)0.0f, (float)3.55f, (float)0.0f, (float)0.0f, (float)0.0436f));
        root.addOrReplaceChild("bottle2", CubeListBuilder.create().texOffs(75, 24).addBox(-1.5f, -0.5f, -1.45f, 3.0f, 1.0f, 3.0f, new CubeDeformation(0.1f)).texOffs(63, 24).addBox(-1.5f, -1.0f, -1.45f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(63, 35).addBox(-1.0f, 0.7f, -1.05f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.2f)).texOffs(63, 32).addBox(-1.0f, -2.0f, -1.05f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(83, 33).addBox(-1.5f, 4.0f, -1.45f, 3.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.5f, (float)0.0f, (float)3.55f, (float)0.0f, (float)0.0f, (float)-0.0436f));
        root.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(63, 19).addBox(-0.9412f, -2.0f, -0.1341f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)0.0f, (float)-2.0f, (float)0.0f, (float)-0.2618f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of((Object)this.body);
    }
}

