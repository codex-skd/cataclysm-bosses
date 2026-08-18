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
package com.skd.thesundering.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HumanoidRenderState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;

public class Sticky_Gloves_Model
extends HumanoidModel<HumanoidRenderState> {
    public Sticky_Gloves_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer(boolean slim, CubeDeformation deformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition rightArm = partDefinition.getChild("right_arm");
        PartDefinition leftArm = partDefinition.getChild("left_arm");
        float slimornot = slim ? 1.0f : 0.0f;
        rightArm.addOrReplaceChild("right_glove", CubeListBuilder.create().texOffs(63, 11).addBox(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(75, 23).addBox(-3.0f, 7.0f, -2.0f, 4.0f, 3.0f, 4.0f, new CubeDeformation(0.2f)), PartPose.offset((float)slimornot, (float)0.0f, (float)0.0f));
        leftArm.addOrReplaceChild("left_glove", CubeListBuilder.create().texOffs(63, 11).mirror().addBox(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(75, 23).mirror().addBox(-1.0f, 7.0f, -2.0f, 4.0f, 3.0f, 4.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offset((float)(-slimornot), (float)0.0f, (float)0.0f));
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

