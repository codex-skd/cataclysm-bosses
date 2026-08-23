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
 *  net.minecraft.util.Mth
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.model.block;

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
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class AptrgangrHeadModel
extends SkullModelBase {
    private final ModelPart head;
    private final ModelPart helmet;
    private final ModelPart jaw;

    public AptrgangrHeadModel(ModelPart root) {
        this.head = root.getChild("head");
        this.helmet = this.head.getChild("helmet");
        this.jaw = this.head.getChild("jaw");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 111).addBox(-4.0f, -9.0f, -4.0f, 8.0f, 9.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)4.0f, (float)0.0f));
        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(32, 113).addBox(-4.0f, -2.0f, -3.5f, 8.0f, 6.0f, 8.0f, new CubeDeformation(0.5f)).texOffs(102, 110).addBox(-1.5f, -2.8f, -4.3f, 3.0f, 8.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(64, 120).mirror().addBox(-5.5f, -2.0f, -1.5f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(116, 20).addBox(-10.5f, -3.5f, 0.5f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(64, 120).addBox(4.5f, -2.0f, -1.5f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(116, 0).addBox(4.5f, -9.5f, 0.5f, 6.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(88, 98).addBox(-5.0f, 3.2f, -4.3f, 10.0f, 2.0f, 10.0f, new CubeDeformation(0.001f)).texOffs(62, 91).addBox(-4.0f, 5.0f, -3.5f, 8.0f, 0.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-7.0f, (float)-0.5f));
        PartDefinition head_r1 = helmet.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(28, 104).mirror().addBox(-0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.4f, (float)3.5f, (float)-3.8f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition head_r2 = helmet.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(42, 111).mirror().addBox(-1.0f, -0.5f, -0.5f, 2.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(44, 106).mirror().addBox(0.0f, -1.5f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(43, 109).mirror().addBox(-1.0f, 0.5f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(29, 115).mirror().addBox(-2.0f, -1.5f, -0.5f, 4.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.4f, (float)3.5f, (float)-4.1f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        PartDefinition head_r3 = helmet.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(43, 108).addBox(-1.0f, -0.5f, -0.5f, 2.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(32, 104).addBox(-2.0f, -1.5f, -0.5f, 4.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.4f, (float)3.5f, (float)-4.1f, (float)0.0f, (float)0.0f, (float)0.2618f));
        PartDefinition head_r4 = helmet.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(25, 108).mirror().addBox(-0.5f, -1.5f, -0.5f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)4.8f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition head_r5 = helmet.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(31, 108).mirror().addBox(-0.5f, -1.5f, -0.5f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)6.2f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition head_r6 = helmet.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(30, 111).mirror().addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)1.7f, (float)-3.9f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(34, 26).addBox(-3.0f, 0.0f, -2.5f, 6.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(3.0f, 3.0f, 0.0f, 6.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(48, 5).addBox(3.0f, -2.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(48, 5).mirror().addBox(-5.0f, -2.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(48, 0).mirror().addBox(-9.0f, 3.0f, 0.0f, 6.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(84, 1).addBox(3.0f, 8.0f, -2.5f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(84, 1).mirror().addBox(-8.0f, 8.0f, -2.5f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(52, 33).addBox(-3.0f, 0.0f, 0.5f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-5.0f, (float)-1.5f));
        PartDefinition head_r7 = jaw.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(92, 12).addBox(-3.0f, 0.0f, 0.0f, 6.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)8.0f, (float)-2.5f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(float p_104188_, float p_104189_, float p_104190_) {
        this.jaw.y = -3.0f + Mth.sin((float)(p_104188_ * 0.5f - 2.0f)) * 2.0f;
        this.head.yRot = p_104189_ * ((float)Math.PI / 180);
        this.head.xRot = p_104190_ * ((float)Math.PI / 180);
    }

    public void renderToBuffer(PoseStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, int p_350947_) {
        p_104192_.pushPose();
        p_104192_.translate(0.0f, -0.49916f, 0.0f);
        p_104192_.scale(1.0f, 1.0f, 1.0f);
        this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_350947_);
        p_104192_.popPose();
    }
}

