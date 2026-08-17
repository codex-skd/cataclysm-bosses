/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
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
package com.skd.sundering.client.model.entity;

import com.skd.sundering.client.animation.Maledictus_Animation;
import com.skd.sundering.client.animation.Maledictus_Attack_Animation;
import com.skd.sundering.client.animation.Maledictus_Grab_Attack_Animation;
import com.skd.sundering.client.animation.Maledictus_Halberd_Animation;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
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

public class Maledictus_Model
extends HierarchicalModel<Maledictus_Entity> {
    private final ModelPart root;
    private final ModelPart roots;
    private final ModelPart berserker;
    private final ModelPart legs;
    private final ModelPart right_leg;
    private final ModelPart cube_r1;
    private final ModelPart right_front_leg;
    private final ModelPart cube_r2;
    private final ModelPart left_leg;
    private final ModelPart cube_r3;
    private final ModelPart left_front_leg;
    private final ModelPart cube_r4;
    private final ModelPart pelvis;
    private final ModelPart front_cloth1;
    private final ModelPart front_cloth2;
    private final ModelPart body;
    private final ModelPart right_shoulder;
    private final ModelPart cube_r5;
    private final ModelPart cube_r6;
    private final ModelPart right_arm;
    private final ModelPart right_front_arm;
    private final ModelPart bow;
    private final ModelPart cube_r7;
    private final ModelPart cube_r8;
    private final ModelPart cube_r9;
    private final ModelPart bow_string;
    private final ModelPart string1;
    private final ModelPart string2;
    private final ModelPart right_mace;
    private final ModelPart cube_r10;
    private final ModelPart cube_r11;
    private final ModelPart cube_r12;
    private final ModelPart halberd;
    private final ModelPart cube_r13;
    private final ModelPart halberd2;
    private final ModelPart cube_r14;
    private final ModelPart cube_r15;
    private final ModelPart bone;
    private final ModelPart right_particle;
    private final ModelPart left_shoulder;
    private final ModelPart cube_r16;
    private final ModelPart cube_r17;
    private final ModelPart left_arm;
    private final ModelPart left_front_arm;
    private final ModelPart left_mace;
    private final ModelPart cube_r18;
    private final ModelPart cube_r19;
    private final ModelPart cube_r20;
    private final ModelPart left_particle;
    private final ModelPart head;
    private final ModelPart right_horn;
    private final ModelPart cube_r21;
    private final ModelPart left_horn;
    private final ModelPart cube_r22;
    private final ModelPart left_wing;
    private final ModelPart left_wing2;
    private final ModelPart right_wing;
    private final ModelPart right_wing2;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Maledictus_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.roots = this.root.getChild("roots");
        this.berserker = this.roots.getChild("berserker");
        this.legs = this.berserker.getChild("legs");
        this.right_leg = this.legs.getChild("right_leg");
        this.cube_r1 = this.right_leg.getChild("cube_r1");
        this.right_front_leg = this.right_leg.getChild("right_front_leg");
        this.cube_r2 = this.right_front_leg.getChild("cube_r2");
        this.left_leg = this.legs.getChild("left_leg");
        this.cube_r3 = this.left_leg.getChild("cube_r3");
        this.left_front_leg = this.left_leg.getChild("left_front_leg");
        this.cube_r4 = this.left_front_leg.getChild("cube_r4");
        this.pelvis = this.berserker.getChild("pelvis");
        this.front_cloth1 = this.pelvis.getChild("front_cloth1");
        this.front_cloth2 = this.front_cloth1.getChild("front_cloth2");
        this.body = this.pelvis.getChild("body");
        this.right_shoulder = this.body.getChild("right_shoulder");
        this.cube_r5 = this.right_shoulder.getChild("cube_r5");
        this.cube_r6 = this.right_shoulder.getChild("cube_r6");
        this.right_arm = this.right_shoulder.getChild("right_arm");
        this.right_front_arm = this.right_arm.getChild("right_front_arm");
        this.bow = this.right_front_arm.getChild("bow");
        this.cube_r7 = this.bow.getChild("cube_r7");
        this.cube_r8 = this.bow.getChild("cube_r8");
        this.cube_r9 = this.bow.getChild("cube_r9");
        this.bow_string = this.bow.getChild("bow_string");
        this.string1 = this.bow_string.getChild("string1");
        this.string2 = this.bow_string.getChild("string2");
        this.right_mace = this.right_front_arm.getChild("right_mace");
        this.cube_r10 = this.right_mace.getChild("cube_r10");
        this.cube_r11 = this.right_mace.getChild("cube_r11");
        this.cube_r12 = this.right_mace.getChild("cube_r12");
        this.halberd = this.right_front_arm.getChild("halberd");
        this.cube_r13 = this.halberd.getChild("cube_r13");
        this.halberd2 = this.halberd.getChild("halberd2");
        this.cube_r14 = this.halberd2.getChild("cube_r14");
        this.cube_r15 = this.halberd2.getChild("cube_r15");
        this.bone = this.halberd.getChild("bone");
        this.right_particle = this.right_front_arm.getChild("right_particle");
        this.left_shoulder = this.body.getChild("left_shoulder");
        this.cube_r16 = this.left_shoulder.getChild("cube_r16");
        this.cube_r17 = this.left_shoulder.getChild("cube_r17");
        this.left_arm = this.left_shoulder.getChild("left_arm");
        this.left_front_arm = this.left_arm.getChild("left_front_arm");
        this.left_mace = this.left_front_arm.getChild("left_mace");
        this.cube_r18 = this.left_mace.getChild("cube_r18");
        this.cube_r19 = this.left_mace.getChild("cube_r19");
        this.cube_r20 = this.left_mace.getChild("cube_r20");
        this.left_particle = this.left_front_arm.getChild("left_particle");
        this.head = this.body.getChild("head");
        this.right_horn = this.head.getChild("right_horn");
        this.cube_r21 = this.right_horn.getChild("cube_r21");
        this.left_horn = this.head.getChild("left_horn");
        this.cube_r22 = this.left_horn.getChild("cube_r22");
        this.left_wing = this.body.getChild("left_wing");
        this.left_wing2 = this.left_wing.getChild("left_wing2");
        this.right_wing = this.body.getChild("right_wing");
        this.right_wing2 = this.right_wing.getChild("right_wing2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition berserker = roots.addOrReplaceChild("berserker", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-24.0f, (float)-3.0f));
        PartDefinition legs = berserker.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)1.0f, (float)0.0f));
        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(95, 68).addBox(-4.0f, -0.0428f, -1.3474f, 6.0f, 12.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0097f, (float)0.218f, (float)0.0447f));
        PartDefinition cube_r1 = right_leg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(74, 148).addBox(-8.0f, -16.0f, -1.5f, 6.0f, 11.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5557f, (float)14.9936f, (float)-0.8474f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition right_front_leg = right_leg.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(95, 97).addBox(-4.1f, 0.9829f, -1.2611f, 5.0f, 12.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)9.9572f, (float)0.6526f));
        PartDefinition cube_r2 = right_front_leg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(101, 155).addBox(-5.0f, 1.0f, -3.0f, 6.0f, 9.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.0171f, (float)-2.2611f, (float)0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(41, 41).addBox(-2.0f, -0.0428f, -1.3474f, 6.0f, 12.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)0.0f, (float)0.0f, (float)0.0097f, (float)-0.218f, (float)-0.0447f));
        PartDefinition cube_r3 = left_leg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 147).addBox(2.0f, -16.0f, -1.5f, 6.0f, 11.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5557f, (float)14.9936f, (float)-0.8474f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition left_front_leg = left_leg.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 41).addBox(-0.9f, 0.9829f, -1.2611f, 5.0f, 12.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)9.9572f, (float)0.6526f));
        PartDefinition cube_r4 = left_front_leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(100, 126).addBox(-1.0f, 1.0f, -3.0f, 6.0f, 9.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.0171f, (float)-2.2611f, (float)0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition pelvis = berserker.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(146, 34).addBox(-6.0f, -3.0f, -2.0f, 12.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition front_cloth1 = pelvis.addOrReplaceChild("front_cloth1", CubeListBuilder.create().texOffs(119, 68).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 9.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)-1.6f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition front_cloth2 = front_cloth1.addOrReplaceChild("front_cloth2", CubeListBuilder.create().texOffs(22, 127).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)9.0f, (float)0.0f, (float)0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition body = pelvis.addOrReplaceChild("body", CubeListBuilder.create().texOffs(119, 139).addBox(-5.5f, -15.6f, -6.6743f, 11.0f, 13.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)1.6f, (float)3.6f));
        PartDefinition right_shoulder = body.addOrReplaceChild("right_shoulder", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-6.7084f, (float)-16.0f, (float)-1.0743f, (float)0.132f, (float)0.1298f, (float)0.1917f));
        PartDefinition cube_r5 = right_shoulder.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(143, 86).addBox(-8.0f, -15.0f, 0.0f, 11.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.7209f, (float)5.9143f, (float)-4.5994f, (float)0.0f, (float)0.0f, (float)-1.2217f));
        PartDefinition cube_r6 = right_shoulder.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(148, 63).addBox(-16.0f, -12.0f, 0.0f, 10.0f, 4.0f, 6.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)7.7209f, (float)10.9143f, (float)-4.5994f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition right_arm = right_shoulder.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(22, 163).addBox(-3.0f, -3.0f, -2.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-2.3791f, (float)1.9143f, (float)-1.5994f));
        PartDefinition right_front_arm = right_arm.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(162, 99).addBox(-3.0f, 0.0f, -3.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(52, 154).addBox(-4.0f, -3.0f, -3.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.1f)).texOffs(151, 155).mirror().addBox(-3.0f, 0.0f, -3.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-0.025f, (float)7.0f, (float)1.0f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition bow = right_front_arm.addOrReplaceChild("bow", CubeListBuilder.create().texOffs(119, 37).addBox(-1.0f, -1.0f, -11.945f, 2.0f, 3.0f, 22.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(0.0f, 2.0f, -6.945f, 0.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.9401f, (float)9.0f, (float)0.0f));
        PartDefinition cube_r7 = bow.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(119, 63).addBox(-2.5f, 6.0f, -25.0f, 5.0f, 4.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.0f, (float)5.0065f, (float)-0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r8 = bow.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(95, 97).addBox(0.5f, 3.0f, -29.9f, 0.0f, 5.0f, 23.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)0.7688f, (float)2.6724f, (float)-0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r9 = bow.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(95, 68).addBox(0.0f, 4.0f, 9.0f, 0.0f, 5.0f, 23.0f, new CubeDeformation(0.0f)).texOffs(124, 116).addBox(-1.5f, 6.0f, 7.0f, 3.0f, 4.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.0f, (float)-6.945f, (float)0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition bow_string = bow.addOrReplaceChild("bow_string", CubeListBuilder.create(), PartPose.offset((float)0.5f, (float)-9.5f, (float)0.0f));
        PartDefinition string1 = bow_string.addOrReplaceChild("string1", CubeListBuilder.create().texOffs(22, 128).addBox(-1.001f, -0.1325f, -0.0242f, 1.0f, 0.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-1.0f));
        PartDefinition string2 = bow_string.addOrReplaceChild("string2", CubeListBuilder.create().texOffs(0, 127).addBox(-0.001f, -0.1325f, -18.9758f, 1.0f, 0.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-1.0f, (float)0.0f, (float)-1.0485f));
        PartDefinition right_mace = right_front_arm.addOrReplaceChild("right_mace", CubeListBuilder.create().texOffs(76, 126).mirror().addBox(-1.0f, -1.0f, -13.0f, 2.0f, 2.0f, 19.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(26, 0).mirror().addBox(-1.5f, -1.5f, -27.0f, 3.0f, 3.0f, 16.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 41).mirror().addBox(0.5188f, 0.001f, -35.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 41).mirror().addBox(0.5188f, 0.001f, -35.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-1.0f, (float)8.0f, (float)-1.0f));
        PartDefinition cube_r10 = right_mace.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(0.525f, 0.0f, -15.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-0.0062f, (float)0.001f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition cube_r11 = right_mace.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(0.525f, 0.0f, -15.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-0.0062f, (float)0.001f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r12 = right_mace.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(0.525f, 0.0f, -15.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-0.0062f, (float)0.001f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition halberd = right_front_arm.addOrReplaceChild("halberd", CubeListBuilder.create().texOffs(0, 0).addBox(-0.9901f, -1.2083f, -32.3333f, 2.0f, 2.0f, 65.0f, new CubeDeformation(0.0f)).texOffs(26, 0).addBox(-0.4901f, -0.7083f, -37.3333f, 1.0f, 1.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(46, 131).addBox(0.0099f, -2.7083f, -53.3333f, 0.0f, 5.0f, 17.0f, new CubeDeformation(0.0f)).texOffs(64, 127).addBox(-1.4901f, -1.7083f, -31.3333f, 3.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(10, 21).addBox(2.0099f, -0.7083f, -16.8333f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(18, 21).addBox(-0.4901f, -4.2083f, -16.8333f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(13, 0).addBox(-1.9901f, -2.2083f, -17.3333f, 4.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(15, 21).addBox(-0.4901f, 1.7917f, -16.8333f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(10, 21).mirror().addBox(-4.1089f, -0.7083f, -16.8333f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 0).addBox(0.0099f, 1.2917f, -37.3333f, 0.0f, 15.0f, 25.0f, new CubeDeformation(0.0f)).texOffs(123, 86).addBox(0.0099f, -11.7083f, -33.3333f, 0.0f, 10.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.3911f, (float)8.2083f, (float)-0.6667f));
        PartDefinition cube_r13 = halberd.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(46, 131).addBox(0.0f, -2.5f, -8.5f, 0.0f, 5.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0099f, (float)-0.2083f, (float)-42.8333f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition halberd2 = halberd.addOrReplaceChild("halberd2", CubeListBuilder.create().texOffs(0, 21).addBox(1.5238f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(13, 6).addBox(-1.4762f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(0, 21).mirror().addBox(-3.595f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-0.0139f, (float)-0.2083f, (float)-33.8333f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition cube_r14 = halberd2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(5, 21).addBox(1.5f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0238f, (float)5.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition cube_r15 = halberd2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 21).addBox(1.5f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0238f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone = halberd.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-0.0139f, (float)-0.2083f, (float)-16.8333f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition right_particle = right_front_arm.addOrReplaceChild("right_particle", CubeListBuilder.create(), PartPose.offset((float)-0.828f, (float)5.3443f, (float)-1.302f));
        PartDefinition left_shoulder = body.addOrReplaceChild("left_shoulder", CubeListBuilder.create(), PartPose.offsetAndRotation((float)6.7084f, (float)-16.0f, (float)-2.0743f, (float)0.132f, (float)-0.1298f, (float)-0.1917f));
        PartDefinition cube_r16 = left_shoulder.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(143, 86).mirror().addBox(-3.0f, -15.0f, 0.0f, 11.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-7.7209f, (float)5.9143f, (float)-3.5994f, (float)0.0f, (float)0.0f, (float)1.2217f));
        PartDefinition cube_r17 = left_shoulder.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(146, 44).addBox(6.0f, -12.0f, 0.0f, 10.0f, 4.0f, 6.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)-7.7209f, (float)10.9143f, (float)-3.5994f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition left_arm = left_shoulder.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(124, 160).addBox(-2.0f, -3.0f, -2.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)2.3791f, (float)1.9143f, (float)-0.5994f));
        PartDefinition left_front_arm = left_arm.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(151, 155).addBox(-2.0f, 0.0f, -3.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(52, 154).mirror().addBox(-1.0f, -3.0f, -3.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.1f)).mirror(false), PartPose.offsetAndRotation((float)0.025f, (float)7.0f, (float)1.0f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition left_mace = left_front_arm.addOrReplaceChild("left_mace", CubeListBuilder.create().texOffs(76, 126).addBox(-1.0f, -1.0f, -13.0f, 2.0f, 2.0f, 19.0f, new CubeDeformation(0.0f)).texOffs(26, 0).addBox(-1.5f, -1.5f, -27.0f, 3.0f, 3.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(0, 41).addBox(-9.5188f, 0.001f, -35.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)).texOffs(0, 41).addBox(-9.5188f, 0.001f, -35.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.offset((float)1.0f, (float)8.0f, (float)-1.0f));
        PartDefinition cube_r18 = left_mace.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 41).addBox(-9.525f, 0.0f, -15.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0062f, (float)0.001f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition cube_r19 = left_mace.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 41).addBox(-9.525f, 0.0f, -15.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0062f, (float)0.001f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)-3.1416f));
        PartDefinition cube_r20 = left_mace.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 41).addBox(-9.525f, 0.0f, -15.0f, 9.0f, 0.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0062f, (float)0.001f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition left_particle = left_front_arm.addOrReplaceChild("left_particle", CubeListBuilder.create(), PartPose.offset((float)0.4468f, (float)5.3443f, (float)-1.302f));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(141, 17).addBox(-4.0f, -8.0f, -3.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(141, 0).addBox(-4.0f, -8.0f, -3.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.5f)).texOffs(149, 116).addBox(-6.5f, -5.5f, -4.0f, 4.0f, 6.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(27, 148).addBox(2.5f, -5.5f, -4.0f, 4.0f, 6.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-16.6f, (float)-4.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-6.2f, (float)-10.0f, (float)0.0f, (float)-0.2618f, (float)0.0f, (float)-0.6545f));
        PartDefinition cube_r21 = right_horn.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(148, 74).addBox(-7.811f, -23.4301f, 0.1321f, 12.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-9.811f, -17.4301f, 0.1321f, 5.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(156, 139).addBox(-4.811f, -21.4301f, -1.3679f, 11.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(0, 127).addBox(-4.811f, -17.4301f, -1.8679f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)12.0f, (float)2.0f, (float)0.1309f, (float)0.0f, (float)-0.3054f));
        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create(), PartPose.offsetAndRotation((float)6.2f, (float)-10.0f, (float)0.0f, (float)-0.2618f, (float)0.0f, (float)0.6545f));
        PartDefinition cube_r22 = left_horn.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(148, 74).mirror().addBox(-4.189f, -23.4301f, 0.1321f, 12.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 0).mirror().addBox(4.811f, -17.4301f, 0.1321f, 5.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(156, 139).mirror().addBox(-6.189f, -21.4301f, -1.3679f, 11.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 127).mirror().addBox(0.811f, -17.4301f, -1.8679f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.0f, (float)12.0f, (float)2.0f, (float)0.1309f, (float)0.0f, (float)0.3054f));
        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(70, 0).addBox(-35.0f, -30.0f, 0.0f, 35.0f, 58.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)-10.0f, (float)1.0f, (float)-0.0181f, (float)0.3923f, (float)-0.0472f));
        PartDefinition left_wing2 = left_wing.addOrReplaceChild("left_wing2", CubeListBuilder.create().texOffs(0, 68).addBox(-47.0f, -38.0f, 0.0f, 47.0f, 58.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-35.0f, (float)8.0f, (float)0.0f));
        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(70, 0).mirror().addBox(0.0f, -38.0f, 0.0f, 35.0f, 58.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)3.0f, (float)-2.0f, (float)1.0f, (float)-0.0181f, (float)-0.3923f, (float)0.0472f));
        PartDefinition right_wing2 = right_wing.addOrReplaceChild("right_wing2", CubeListBuilder.create().texOffs(0, 68).mirror().addBox(0.0f, -38.0f, 0.0f, 47.0f, 58.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)35.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animate(entity.getAnimationState("idle"), Maledictus_Animation.IDLE, ageInTicks, 0.75f);
        this.animate(entity.getAnimationState("swing"), Maledictus_Animation.SWING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("shoot"), Maledictus_Animation.SHOOT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("flying_shoot"), Maledictus_Animation.FLYING_SHOOT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("fall_loop"), Maledictus_Animation.FALL_LOOP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("fall_end"), Maledictus_Animation.FALL_END, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("mass_effect"), Maledictus_Animation.MASS_EFFECT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("flying_smash_1"), Maledictus_Animation.FLYING_SMASH_1, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("flying_smash_2"), Maledictus_Animation.FLYING_SMASH_2, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("flying_halberd_smash_1"), Maledictus_Halberd_Animation.FLYING_HALBERD_SMASH_1, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("flying_halberd_smash_2"), Maledictus_Halberd_Animation.FLYING_HALBERD_SMASH_2, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Maledictus_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("back_step"), Maledictus_Animation.CHARGE_BACKSTEP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("back_step_dash"), Maledictus_Halberd_Animation.DASH1, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("radagon"), Maledictus_Halberd_Animation.RADAGON, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("halberd_swing"), Maledictus_Halberd_Animation.HALBERD_SLASH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("dash"), Maledictus_Halberd_Animation.DASH1, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("back_step_dash_no_back_step"), Maledictus_Halberd_Animation.DASH1_NO_BACK_STEP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("dash_no_back_step"), Maledictus_Halberd_Animation.DASH1_NO_BACK_STEP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("dash2"), Maledictus_Halberd_Animation.DASH2, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("dash2_no_back_step"), Maledictus_Halberd_Animation.DASH2_NO_BACK_STEP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("dash3"), Maledictus_Halberd_Animation.DASH3, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spin_slashes"), Maledictus_Attack_Animation.SPIN_SLASHES, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("combo_first"), Maledictus_Attack_Animation.COMBO_FIRST, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("combo_first_end"), Maledictus_Attack_Animation.COMBO_FIRST_END, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("combo_second"), Maledictus_Attack_Animation.COMBO_SECOND, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("uppercut_right"), Maledictus_Attack_Animation.UPPERCUT_RIGHT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("uppercut_left"), Maledictus_Attack_Animation.UPPERCUT_LEFT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_start"), Maledictus_Grab_Attack_Animation.GRAB_START, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_loop"), Maledictus_Grab_Attack_Animation.GRAB_LOOP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_fail"), Maledictus_Grab_Attack_Animation.GRAB_FAIL, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_success"), Maledictus_Grab_Attack_Animation.GRAB_SUCCESS_FLY, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_success_loop"), Maledictus_Grab_Attack_Animation.GRAB_DIVE_LOOP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_success_end"), Maledictus_Grab_Attack_Animation.GRAB_LAND, ageInTicks, 1.0f);
        if (entity.getAttackState() != 10 && entity.getAttackState() != 11 && entity.getAttackState() != 12 && entity.getAttackState() != 13 && entity.getAttackState() != 14 && entity.getAttackState() != 18 && entity.getAttackState() != 29 && entity.getAttackState() != 33 && entity.getAttackState() != 32 && entity.getAttackState() != 31) {
            this.animateWalk(Maledictus_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 4.0f);
        }
        this.right_mace.visible = entity.getWeapon() == 0;
        this.left_mace.visible = entity.getWeapon() == 0;
        this.bow.visible = entity.getWeapon() == 1;
        this.halberd.visible = entity.getWeapon() == 2;
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot += xRot * ((float)Math.PI / 180);
        this.head.yRot += yRot * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
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

    public void translateToHand(PoseStack matrixStack, boolean right) {
        this.root.translateAndRotate(matrixStack);
        this.roots.translateAndRotate(matrixStack);
        this.berserker.translateAndRotate(matrixStack);
        this.pelvis.translateAndRotate(matrixStack);
        this.body.translateAndRotate(matrixStack);
        if (right) {
            this.right_shoulder.translateAndRotate(matrixStack);
            this.right_arm.translateAndRotate(matrixStack);
            this.right_front_arm.translateAndRotate(matrixStack);
            this.right_particle.translateAndRotate(matrixStack);
        } else {
            this.left_shoulder.translateAndRotate(matrixStack);
            this.left_arm.translateAndRotate(matrixStack);
            this.left_front_arm.translateAndRotate(matrixStack);
            this.left_particle.translateAndRotate(matrixStack);
        }
    }
}

