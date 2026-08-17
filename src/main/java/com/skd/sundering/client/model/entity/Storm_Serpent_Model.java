/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 */
package com.skd.sundering.client.model.entity;

import com.skd.sundering.client.animation.Storm_Serpent_Animation;
import com.skd.sundering.entity.projectile.Storm_Serpent_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Storm_Serpent_Model
extends HierarchicalModel<Storm_Serpent_Entity> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart seg6;
    private final ModelPart seg5;
    private final ModelPart seg4;
    private final ModelPart seg3;
    private final ModelPart seg2;
    private final ModelPart seg1;
    private final ModelPart head;
    private final ModelPart upper;
    private final ModelPart teeth;
    private final ModelPart lower;
    private final ModelPart teeth2;

    public Storm_Serpent_Model(ModelPart root) {
        this.root = root;
        this.everything = this.root.getChild("everything");
        this.seg6 = this.everything.getChild("seg6");
        this.seg5 = this.seg6.getChild("seg5");
        this.seg4 = this.seg5.getChild("seg4");
        this.seg3 = this.seg4.getChild("seg3");
        this.seg2 = this.seg3.getChild("seg2");
        this.seg1 = this.seg2.getChild("seg1");
        this.head = this.seg1.getChild("head");
        this.upper = this.head.getChild("upper");
        this.teeth = this.upper.getChild("teeth");
        this.lower = this.head.getChild("lower");
        this.teeth2 = this.lower.getChild("teeth2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition seg6 = everything.addOrReplaceChild("seg6", CubeListBuilder.create().texOffs(46, 70).addBox(-6.0f, -24.0f, -6.0f, 12.0f, 24.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.5f));
        PartDefinition seg5 = seg6.addOrReplaceChild("seg5", CubeListBuilder.create().texOffs(0, 70).addBox(-6.0f, -24.0f, -6.0f, 12.0f, 24.0f, 11.0f, new CubeDeformation(0.01f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition seg4 = seg5.addOrReplaceChild("seg4", CubeListBuilder.create().texOffs(46, 35).addBox(-6.0f, -24.0f, -6.0f, 12.0f, 24.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition seg3 = seg4.addOrReplaceChild("seg3", CubeListBuilder.create().texOffs(46, 0).addBox(-6.0f, -24.0f, -6.0f, 12.0f, 24.0f, 11.0f, new CubeDeformation(0.01f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition seg2 = seg3.addOrReplaceChild("seg2", CubeListBuilder.create().texOffs(0, 35).addBox(-6.0f, -24.0f, -6.0f, 12.0f, 24.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition seg1 = seg2.addOrReplaceChild("seg1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0f, -24.0f, -6.0f, 12.0f, 24.0f, 11.0f, new CubeDeformation(0.01f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition head = seg1.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition upper = head.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(92, 0).addBox(-5.0f, -23.7383f, -0.0057f, 10.0f, 24.0f, 7.0f, new CubeDeformation(0.02f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-1.0f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition r_1 = upper.addOrReplaceChild("r_1", CubeListBuilder.create().texOffs(92, 31).addBox(-7.0f, 0.0f, -7.0f, 14.0f, 12.0f, 7.0f, new CubeDeformation(0.02f)), PartPose.offsetAndRotation((float)0.0f, (float)-11.7383f, (float)6.9943f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition teeth = upper.addOrReplaceChild("teeth", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-22.7383f, (float)-0.0057f, (float)1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r1 = teeth.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(127, 0).addBox(0.0f, 0.0f, -6.0f, 0.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.042f, (float)-0.0397f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition cube_r2 = teeth.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(127, -6).addBox(0.0f, 0.0f, -6.0f, 0.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.042f, (float)-0.0397f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition lower = head.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(92, 50).addBox(-5.0f, -20.7819f, -4.9952f, 10.0f, 21.0f, 5.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-1.0f, (float)-0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition teeth2 = lower.addOrReplaceChild("teeth2", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-23.7819f, (float)1.0048f));
        PartDefinition r_2 = teeth2.addOrReplaceChild("r_2", CubeListBuilder.create().texOffs(128, 12).addBox(0.0f, 0.0f, -1.0f, 0.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.0f, (float)4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition r_3 = teeth2.addOrReplaceChild("r_3", CubeListBuilder.create().texOffs(128, 7).addBox(0.0f, 0.0f, -1.0f, 0.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.0f, (float)4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Storm_Serpent_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.root.visible = entity.getState() != 0;
        this.animate(entity.getAnimationState("spawn"), Storm_Serpent_Animation.STORM_SERPENT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spawn2"), Storm_Serpent_Animation.STORM_SERPENT2, ageInTicks, 1.0f);
        this.root.yRot = netHeadYaw * ((float)Math.PI / 180);
        this.root.xRot = headPitch * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }
}

