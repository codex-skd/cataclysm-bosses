/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.SkullModelBase
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
package com.skd.sundering.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SkullModelBase;
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
public class KobolediatorHeadModel
extends SkullModelBase {
    private final ModelPart head;
    private final ModelPart jaw;

    public KobolediatorHeadModel(ModelPart p_171097_) {
        this.head = p_171097_.getChild("head");
        this.jaw = this.head.getChild("jaw");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 119).addBox(-5.0f, -9.0f, -6.0513f, 10.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)8.0f, (float)0.0f));
        PartDefinition head_cube1 = head.addOrReplaceChild("head_cube1", CubeListBuilder.create().texOffs(36, 100).addBox(0.8f, -5.0f, -8.0f, 6.0f, 6.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.7831f, (float)-8.0f, (float)1.9487f, (float)0.1616f, (float)0.1866f, (float)-0.0568f));
        PartDefinition head_cube2 = head.addOrReplaceChild("head_cube2", CubeListBuilder.create().texOffs(62, 38).addBox(1.0f, -6.0f, -12.0f, 6.0f, 6.0f, 28.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.0f, (float)-9.0f, (float)1.9487f, (float)0.48f, (float)0.0f, (float)0.0f));
        PartDefinition head_cube3 = head.addOrReplaceChild("head_cube3", CubeListBuilder.create().texOffs(125, 113).addBox(-6.8f, -5.0f, -8.0f, 6.0f, 6.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.7832f, (float)-8.0f, (float)1.9487f, (float)0.1616f, (float)-0.1866f, (float)0.0568f));
        PartDefinition head_cube4 = head.addOrReplaceChild("head_cube4", CubeListBuilder.create().texOffs(102, 49).addBox(-3.0f, -34.0f, -23.0f, 9.0f, 7.0f, 10.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)-1.5f, (float)24.0f, (float)8.9487f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(148, 105).addBox(-9.2168f, -9.0f, 4.0513f, 5.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(148, 40).addBox(-9.2168f, -9.0f, -1.9487f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(129, 0).addBox(-9.2168f, -3.0f, -1.9487f, 12.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-2.7832f, (float)-11.0f, (float)0.9487f));
        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(148, 52).addBox(4.2168f, -9.0f, 4.0513f, 5.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(96, 146).addBox(3.2168f, -9.0f, -1.9487f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(123, 93).addBox(-2.7832f, -3.0f, -1.9487f, 12.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)2.7831f, (float)-11.0f, (float)0.9487f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(102, 29).addBox(-2.7168f, -4.0f, -12.0f, 7.0f, 4.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.7832f, (float)0.0f, (float)-2.0513f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(float p_104188_, float p_104189_, float p_104190_) {
        this.jaw.xRot = (float)(Math.sin(p_104188_ * (float)Math.PI * 0.2f) + 1.0) * 0.2f;
        this.head.yRot = p_104189_ * ((float)Math.PI / 180);
        this.head.xRot = p_104190_ * ((float)Math.PI / 180);
    }

    public void renderToBuffer(PoseStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, int p_350947_) {
        p_104192_.pushPose();
        p_104192_.translate(0.0f, -0.374375f, 0.0f);
        p_104192_.scale(0.75f, 0.75f, 0.75f);
        this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_350947_);
        p_104192_.popPose();
    }
}

