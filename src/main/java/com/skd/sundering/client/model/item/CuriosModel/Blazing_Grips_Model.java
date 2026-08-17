/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.sundering.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;

public class Blazing_Grips_Model
extends HumanoidModel<LivingEntity> {
    public Blazing_Grips_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(boolean slim, CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition rightArm = partDefinition.getChild("right_arm");
        PartDefinition leftArm = partDefinition.getChild("left_arm");
        float slimornot = slim ? 0.0f : 1.0f;
        rightArm.addOrReplaceChild("right_gauntlet", CubeListBuilder.create().texOffs(63, 6).addBox(-2.0f, 1.0f, -2.0f, 4.0f, 7.0f, 4.0f, new CubeDeformation(0.4f)).texOffs(63, 18).addBox(-2.0f, 0.1f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.55f)), PartPose.offset((float)(-slimornot), (float)3.0f, (float)0.0f));
        leftArm.addOrReplaceChild("left_gauntlet", CubeListBuilder.create().texOffs(63, 6).mirror().addBox(-2.0f, 1.0f, -2.0f, 4.0f, 7.0f, 4.0f, new CubeDeformation(0.4f)).mirror(false).texOffs(63, 18).mirror().addBox(-2.0f, 0.1f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.55f)).mirror(false), PartPose.offset((float)slimornot, (float)3.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    public void renderArm(HumanoidArm handSide, PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay) {
        this.getArm((HumanoidArm)handSide).visible = true;
        this.getArm((HumanoidArm)handSide.getOpposite()).visible = false;
        this.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of((Object)this.leftArm, (Object)this.rightArm);
    }
}

