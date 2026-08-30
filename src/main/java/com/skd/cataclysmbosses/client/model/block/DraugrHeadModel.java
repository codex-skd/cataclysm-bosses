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
package com.skd.cataclysmbosses.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.object.skull.SkullModelBase;
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
public class DraugrHeadModel
extends SkullModelBase {
    private final ModelPart head;
    private final ModelPart maw;

    public DraugrHeadModel(ModelPart p_171097_) {
        super(p_171097_);
        this.head = p_171097_.getChild("head");
        this.maw = this.head.getChild("maw");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(92, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.2f)).texOffs(0, 32).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.5f)).texOffs(58, 36).addBox(0.0f, -16.0f, 0.0f, 10.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 55).mirror().addBox(-10.0f, -13.0f, 0.0f, 6.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-2.5f, (float)-1.0f, (float)-0.0873f, (float)0.0f, (float)0.2182f));
        PartDefinition body_r1 = maw.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 6).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 5.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)64);
    }

    @Override
    public void setupAnim(SkullModelBase.State state) {
        super.setupAnim(state);
        this.head.yRot = state.yRot * ((float)Math.PI / 180);
        this.head.xRot = state.xRot * ((float)Math.PI / 180);
    }

// PORT TODO(26.2): Model#renderToBuffer is final now. Original custom transform was
    // translate(0, -0.374375, 0) + scale(1,1,1) on the 'head' part. Re-apply in
    // Cataclysm_Skull_Block_Renderer#submit when that renderer is implemented.
}

