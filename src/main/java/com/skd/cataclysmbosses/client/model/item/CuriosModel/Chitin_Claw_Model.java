/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.HumanoidRenderState
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.HumanoidArm
 */
package com.skd.cataclysmbosses.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;

public class Chitin_Claw_Model
extends HumanoidModel<HumanoidRenderState> {
    public Chitin_Claw_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(boolean slim, CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition rightArm = partDefinition.getChild("right_arm");
        PartDefinition leftArm = partDefinition.getChild("left_arm");
        float slimornot = slim ? 0.0f : 1.0f;
        PartDefinition right_gauntlet = rightArm.addOrReplaceChild("right_gauntlet", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition gauntlet3_r1 = right_gauntlet.addOrReplaceChild("gauntlet3_r1", CubeListBuilder.create().texOffs(79, 18).addBox(-1.6f, -4.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.55f)), PartPose.offsetAndRotation((float)(-0.428f - slimornot), (float)7.0523f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0087f));
        PartDefinition gauntlet2_r1 = right_gauntlet.addOrReplaceChild("gauntlet2_r1", CubeListBuilder.create().texOffs(63, 18).addBox(-2.0f, -4.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.55f)), PartPose.offsetAndRotation((float)(-slimornot), (float)6.1f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition gauntlet1_r1 = right_gauntlet.addOrReplaceChild("gauntlet1_r1", CubeListBuilder.create().texOffs(63, 6).mirror().addBox(-2.0f, -3.5f, -2.0f, 4.0f, 7.0f, 4.0f, new CubeDeformation(0.4f)).mirror(false), PartPose.offsetAndRotation((float)(-slimornot), (float)6.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition left_gauntlet = leftArm.addOrReplaceChild("left_gauntlet", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition gauntlet4_r1 = left_gauntlet.addOrReplaceChild("gauntlet4_r1", CubeListBuilder.create().texOffs(79, 18).mirror().addBox(-2.4f, -4.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.55f)).mirror(false), PartPose.offsetAndRotation((float)(0.428f + slimornot), (float)7.0523f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0087f));
        PartDefinition gauntlet3_r2 = left_gauntlet.addOrReplaceChild("gauntlet3_r2", CubeListBuilder.create().texOffs(63, 18).mirror().addBox(-2.0f, -4.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.55f)).mirror(false), PartPose.offsetAndRotation((float)slimornot, (float)6.1f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition gauntlet2_r2 = left_gauntlet.addOrReplaceChild("gauntlet2_r2", CubeListBuilder.create().texOffs(63, 6).addBox(-2.0f, -3.5f, -2.0f, 4.0f, 7.0f, 4.0f, new CubeDeformation(0.4f)), PartPose.offsetAndRotation((float)slimornot, (float)6.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        return LayerDefinition.create((MeshDefinition)meshDefinition, (int)128, (int)128);
    }

    public void renderArm(HumanoidArm handSide, PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay) {
        this.getArm((HumanoidArm)handSide).visible = true;
        this.getArm((HumanoidArm)handSide.getOpposite()).visible = false;
        this.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay, -1);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.leftArm, this.rightArm);
    }
}

