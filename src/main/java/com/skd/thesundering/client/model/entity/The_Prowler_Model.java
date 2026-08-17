/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.client.animation.Prowler_Animation;
import com.skd.thesundering.entity.InternalAnimationMonster.The_Prowler_Entity;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class The_Prowler_Model
extends HierarchicalModel<The_Prowler_Entity> {
    private final ModelPart root;
    private final ModelPart roots;
    private final ModelPart upperbody;
    private final ModelPart chestplate;
    private final ModelPart eye_blow;
    private final ModelPart chestplate2;
    private final ModelPart rocket_luncher;
    private final ModelPart missile;
    private final ModelPart missile2;
    private final ModelPart missile3;
    private final ModelPart right_arm;
    private final ModelPart right_arm_joint;
    private final ModelPart sholder_pad;
    private final ModelPart sholder_pad2;
    private final ModelPart right_arm2;
    private final ModelPart right_joint;
    private final ModelPart chainsaw;
    private final ModelPart saw;
    private final ModelPart blade5;
    private final ModelPart blade6;
    private final ModelPart blade7;
    private final ModelPart blade8;
    private final ModelPart blade;
    private final ModelPart blade2;
    private final ModelPart blade3;
    private final ModelPart blade4;
    private final ModelPart pelvis;
    private final ModelPart catapiller;
    private final ModelPart catapiller2;
    private final ModelPart pipe2;
    private final ModelPart pipe;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public The_Prowler_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.roots = this.root.getChild("roots");
        this.upperbody = this.roots.getChild("upperbody");
        this.chestplate = this.upperbody.getChild("chestplate");
        this.eye_blow = this.chestplate.getChild("eye_blow");
        this.chestplate2 = this.chestplate.getChild("chestplate2");
        this.rocket_luncher = this.upperbody.getChild("rocket_luncher");
        this.missile = this.rocket_luncher.getChild("missile");
        this.missile2 = this.rocket_luncher.getChild("missile2");
        this.missile3 = this.rocket_luncher.getChild("missile3");
        this.right_arm = this.upperbody.getChild("right_arm");
        this.right_arm_joint = this.right_arm.getChild("right_arm_joint");
        this.sholder_pad = this.right_arm_joint.getChild("sholder_pad");
        this.sholder_pad2 = this.sholder_pad.getChild("sholder_pad2");
        this.right_arm2 = this.right_arm_joint.getChild("right_arm2");
        this.right_joint = this.right_arm2.getChild("right_joint");
        this.chainsaw = this.right_joint.getChild("chainsaw");
        this.saw = this.chainsaw.getChild("saw");
        this.blade5 = this.saw.getChild("blade5");
        this.blade6 = this.saw.getChild("blade6");
        this.blade7 = this.saw.getChild("blade7");
        this.blade8 = this.saw.getChild("blade8");
        this.blade = this.saw.getChild("blade");
        this.blade2 = this.saw.getChild("blade2");
        this.blade3 = this.saw.getChild("blade3");
        this.blade4 = this.saw.getChild("blade4");
        this.pelvis = this.roots.getChild("pelvis");
        this.catapiller = this.pelvis.getChild("catapiller");
        this.catapiller2 = this.pelvis.getChild("catapiller2");
        this.pipe2 = this.pelvis.getChild("pipe2");
        this.pipe = this.pelvis.getChild("pipe");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition upperbody = roots.addOrReplaceChild("upperbody", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-23.5f, (float)0.0f));
        PartDefinition chestplate = upperbody.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0f, -13.0f, -3.0f, 14.0f, 13.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.5f, (float)-7.0f));
        PartDefinition eye_blow = chestplate.addOrReplaceChild("eye_blow", CubeListBuilder.create().texOffs(2, 172).addBox(-4.0f, -2.0f, 0.0f, 8.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-9.0f, (float)-3.25f));
        PartDefinition chestplate2 = chestplate.addOrReplaceChild("chestplate2", CubeListBuilder.create().texOffs(114, 110).addBox(-10.0f, -40.0f, 0.0f, 6.0f, 13.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-3.0f, (float)25.0f, (float)0.0f));
        PartDefinition rocket_luncher = upperbody.addOrReplaceChild("rocket_luncher", CubeListBuilder.create().texOffs(48, 45).addBox(6.0f, -17.0f, -11.0f, 6.0f, 20.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(0, 61).addBox(6.0f, -17.0f, -12.0f, 6.0f, 13.0f, 17.0f, new CubeDeformation(0.3f)).texOffs(37, 41).addBox(0.0f, -2.0f, 5.0f, 10.0f, 0.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 34).addBox(9.0f, -13.0f, 5.0f, 0.0f, 12.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(14, 50).addBox(8.0f, -3.0f, 5.0f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(14, 47).addBox(2.0f, -3.0f, 7.0f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(14, 44).addBox(8.0f, -13.0f, 5.0f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(0, 118).addBox(0.0f, -8.0f, -8.0f, 6.0f, 13.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offset((float)7.0f, (float)-6.5f, (float)1.0f));
        PartDefinition missile = rocket_luncher.addOrReplaceChild("missile", CubeListBuilder.create().texOffs(76, 2).addBox(-1.0f, -1.0f, -5.9f, 2.0f, 2.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(44, 30).addBox(0.0f, -3.0f, -0.9f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 2).addBox(0.0f, 1.0f, -0.9f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(14, 41).addBox(-1.0f, -1.0f, -3.9f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)).texOffs(7, 16).addBox(-1.0f, -1.0f, 2.1f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)), PartPose.offset((float)9.0f, (float)-14.0f, (float)-7.6f));
        PartDefinition missile2 = rocket_luncher.addOrReplaceChild("missile2", CubeListBuilder.create().texOffs(76, 2).addBox(-1.0f, -1.0f, -5.9f, 2.0f, 2.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(44, 30).addBox(0.0f, -3.0f, -0.9f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 2).addBox(0.0f, 1.0f, -0.9f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(14, 41).addBox(-1.0f, -1.0f, -3.9f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)).texOffs(7, 16).addBox(-1.0f, -1.0f, 2.1f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)), PartPose.offset((float)9.0f, (float)-7.0f, (float)-7.6f));
        PartDefinition missile3 = rocket_luncher.addOrReplaceChild("missile3", CubeListBuilder.create().texOffs(76, 2).addBox(-1.0f, -1.0f, -5.9f, 2.0f, 2.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(44, 30).addBox(0.0f, -3.0f, -0.9f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 2).addBox(0.0f, 1.0f, -0.9f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(14, 41).addBox(-1.0f, -1.0f, -3.9f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)).texOffs(7, 16).addBox(-1.0f, -1.0f, 2.1f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)), PartPose.offset((float)9.0f, (float)0.0f, (float)-7.6f));
        PartDefinition right_arm = upperbody.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset((float)-13.0f, (float)-13.5f, (float)1.0f));
        PartDefinition right_arm_joint = right_arm.addOrReplaceChild("right_arm_joint", CubeListBuilder.create().texOffs(67, 125).addBox(-11.0f, -6.0f, -5.0f, 11.0f, 16.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(44, 48).addBox(-5.0f, 5.0f, -7.0f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-5.0f, 5.0f, 5.0f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition sholder_pad = right_arm_joint.addOrReplaceChild("sholder_pad", CubeListBuilder.create().texOffs(0, 151).addBox(-4.0f, -2.5f, -6.0f, 8.0f, 5.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-9.0f, (float)4.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3054f));
        PartDefinition sholder_pad2 = sholder_pad.addOrReplaceChild("sholder_pad2", CubeListBuilder.create().texOffs(0, 151).addBox(-4.0f, -2.5f, -6.0f, 8.0f, 5.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offset((float)1.0f, (float)5.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm_joint.addOrReplaceChild("right_arm2", CubeListBuilder.create().texOffs(96, 63).addBox(-3.0f, -8.0f, -3.0f, 6.0f, 16.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 91).addBox(-3.0f, -8.0f, 1.0f, 6.0f, 16.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-5.0f, (float)7.0f, (float)0.0f));
        PartDefinition right_joint = right_arm2.addOrReplaceChild("right_joint", CubeListBuilder.create().texOffs(76, 41).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(0, 70).addBox(-4.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(62, 104).addBox(-2.0f, -3.0f, -3.0f, 4.0f, 6.0f, 6.0f, new CubeDeformation(0.3f)).texOffs(49, 0).addBox(3.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)11.0f, (float)0.0f));
        PartDefinition chainsaw = right_joint.addOrReplaceChild("chainsaw", CubeListBuilder.create().texOffs(93, 78).addBox(-3.0f, -3.0f, -21.0f, 2.0f, 6.0f, 21.0f, new CubeDeformation(0.0f)).texOffs(0, 91).addBox(1.0f, -3.0f, -21.0f, 2.0f, 6.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-3.0f));
        PartDefinition saw = chainsaw.addOrReplaceChild("saw", CubeListBuilder.create().texOffs(74, 63).addBox(-1.0714f, -9.0f, -9.0f, 2.0f, 18.0f, 18.0f, new CubeDeformation(0.0f)).texOffs(0, 25).addBox(-0.0714f, -16.0f, -4.5f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-0.0714f, 9.0f, -4.5f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(0, 54).addBox(-0.0714f, -4.5f, -16.0f, 0.0f, 9.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(49, 4).addBox(-0.0714f, -4.5f, 9.0f, 0.0f, 9.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(64, 41).addBox(-4.0714f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(44, 36).addBox(1.9286f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0714f, (float)0.0f, (float)-18.0f));
        PartDefinition blade5 = saw.addOrReplaceChild("blade5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8214f, 8.0f, -9.0f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition blade6 = saw.addOrReplaceChild("blade6", CubeListBuilder.create().texOffs(0, 0).addBox(0.6786f, 8.0f, 0.0f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.0f, (float)0.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition blade7 = saw.addOrReplaceChild("blade7", CubeListBuilder.create().texOffs(49, 4).addBox(-0.8214f, 0.0f, 8.0f, 0.0f, 9.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition blade8 = saw.addOrReplaceChild("blade8", CubeListBuilder.create().texOffs(49, 4).addBox(0.6786f, -9.0f, 8.0f, 0.0f, 9.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)1.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition blade = saw.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(0, 25).addBox(-0.8214f, -15.0f, 0.0f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition blade2 = saw.addOrReplaceChild("blade2", CubeListBuilder.create().texOffs(0, 25).addBox(0.6786f, -15.0f, -9.0f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.0f, (float)0.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition blade3 = saw.addOrReplaceChild("blade3", CubeListBuilder.create().texOffs(0, 54).addBox(-0.8214f, -9.0f, -15.0f, 0.0f, 9.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition blade4 = saw.addOrReplaceChild("blade4", CubeListBuilder.create().texOffs(0, 54).addBox(0.6786f, 0.0f, -15.0f, 0.0f, 9.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-1.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition pelvis = roots.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 34).addBox(-6.0f, 12.0f, -11.0f, 12.0f, 7.0f, 20.0f, new CubeDeformation(0.0f)).texOffs(34, 138).addBox(-3.0f, -4.0f, -4.0f, 6.0f, 16.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(49, 0).addBox(-4.0f, 7.0f, -5.0f, 8.0f, 1.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(98, 0).addBox(-5.0f, -1.0f, -7.0f, 2.0f, 13.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(66, 81).addBox(3.0f, -1.0f, -7.0f, 2.0f, 13.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(37, 61).addBox(2.0f, -1.0f, 4.0f, 2.0f, 13.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(29, 61).addBox(-4.0f, -1.0f, 4.0f, 2.0f, 13.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(54, 18).addBox(-6.0f, 2.0f, -9.0f, 12.0f, 7.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-23.0f, (float)1.0f));
        PartDefinition catapiller = pelvis.addOrReplaceChild("catapiller", CubeListBuilder.create().texOffs(31, 104).addBox(-9.0f, -4.0f, -14.5f, 8.0f, 12.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(92, 41).addBox(-10.0f, -5.0f, -15.5f, 10.0f, 5.0f, 17.0f, new CubeDeformation(0.0f)).texOffs(129, 35).addBox(-9.0f, 0.0f, 0.5f, 8.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(118, 63).addBox(-10.0f, -1.0f, -1.5f, 10.0f, 4.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-6.0f, (float)15.0f, (float)-0.5f));
        PartDefinition catapiller2 = pelvis.addOrReplaceChild("catapiller2", CubeListBuilder.create().texOffs(94, 0).addBox(1.0f, -4.0f, -14.5f, 8.0f, 12.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(29, 82).addBox(0.0f, -5.0f, -15.5f, 10.0f, 5.0f, 17.0f, new CubeDeformation(0.0f)).texOffs(77, 105).addBox(0.0f, -1.0f, -2.5f, 10.0f, 4.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(128, 15).addBox(1.0f, 0.0f, 0.5f, 8.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offset((float)6.0f, (float)15.0f, (float)-0.5f));
        PartDefinition pipe2 = pelvis.addOrReplaceChild("pipe2", CubeListBuilder.create().texOffs(56, 48).addBox(-1.0f, -3.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(8, 2).addBox(-1.0f, -3.0f, 1.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 16).addBox(-1.0f, -3.0f, 2.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.3f)), PartPose.offsetAndRotation((float)5.0f, (float)11.0f, (float)8.0f, (float)-0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition pipe = pelvis.addOrReplaceChild("pipe", CubeListBuilder.create().texOffs(75, 0).addBox(-1.0f, -3.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(63, 11).addBox(-1.0f, -3.0f, 1.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(10, 16).addBox(-1.0f, -3.0f, 2.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.3f)), PartPose.offsetAndRotation((float)-5.0f, (float)11.0f, (float)8.0f, (float)-0.1745f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(The_Prowler_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.upperbody.yRot += netHeadYaw * 0.6f * ((float)Math.PI / 180);
        float sawspeed = entity.getAttackState() == 3 ? 0.0f : 0.5f;
        this.animate(entity.getAnimationState("death"), Prowler_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("idle"), Prowler_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spin"), Prowler_Animation.SPIN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("melee"), Prowler_Animation.MELEE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("strong_attack"), Prowler_Animation.STRONG_ATTACK, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("stun"), Prowler_Animation.STUN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("laser"), Prowler_Animation.LASER, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("pierce"), Prowler_Animation.PIERCE, ageInTicks, 1.0f);
        this.saw.xRot -= ageInTicks * sawspeed;
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.children.entrySet()) {
            String partName = (String)entry.getKey();
            ModelPart childPart = (ModelPart)entry.getValue();
            this.partCache.putIfAbsent(partName, childPart);
            this.optionalPartCache.putIfAbsent(partName, Optional.of(childPart));
            if (childPart.children.isEmpty()) continue;
            this.buildPartCache(childPart);
        }
    }

    @NotNull
    public Optional<ModelPart> getAnyDescendantWithName(String name) {
        if ("root".equals(name)) {
            return Optional.of(this.root);
        }
        return this.optionalPartCache.getOrDefault(name, Optional.empty());
    }

    public ModelPart root() {
        return this.root;
    }
}

