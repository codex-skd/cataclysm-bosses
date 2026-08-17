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

import com.skd.sundering.client.animation.Aptrgangr_Animation;
import com.skd.sundering.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
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

public class Aptrgangr_Model
extends HierarchicalModel<Aptrgangr_Entity> {
    private final ModelPart root;
    private final ModelPart roots;
    private final ModelPart l_leg;
    private final ModelPart l_leg_armor;
    private final ModelPart left_leg_r1;
    private final ModelPart left_leg_r2;
    private final ModelPart r_leg;
    private final ModelPart r_leg_armor;
    private final ModelPart right_leg_r1;
    private final ModelPart right_leg_r2;
    private final ModelPart body;
    private final ModelPart chest;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart helmet;
    private final ModelPart head_r1;
    private final ModelPart head_r2;
    private final ModelPart head_r3;
    private final ModelPart head_r4;
    private final ModelPart head_r5;
    private final ModelPart head_r6;
    private final ModelPart jaw;
    private final ModelPart head_r7;
    private final ModelPart chestplate;
    private final ModelPart body_r1;
    private final ModelPart body_r2;
    private final ModelPart body_r3;
    private final ModelPart body_r4;
    private final ModelPart body_r5;
    private final ModelPart body_r6;
    private final ModelPart body_r7;
    private final ModelPart l_arm;
    private final ModelPart l_arm_armor;
    private final ModelPart right_arm_r1;
    private final ModelPart right_arm_r2;
    private final ModelPart right_arm_r3;
    private final ModelPart right_arm_r4;
    private final ModelPart right_arm_r5;
    private final ModelPart right_arm_r6;
    private final ModelPart arrow;
    private final ModelPart arrow2;
    private final ModelPart left_arm2;
    private final ModelPart l_arm_cloth;
    private final ModelPart hold;
    private final ModelPart r_arm;
    private final ModelPart right_arm2;
    private final ModelPart r_arm_cloth;
    private final ModelPart axe;
    private final ModelPart cube_r1;
    private final ModelPart cube_r2;
    private final ModelPart axe_head;
    private final ModelPart cube_r3;
    private final ModelPart cube_r4;
    private final ModelPart cube_r5;
    private final ModelPart cube_r6;
    private final ModelPart cube_r7;
    private final ModelPart cube_r8;
    private final ModelPart emblem3;
    private final ModelPart right_arm_r7;
    private final ModelPart emblem4;
    private final ModelPart r_arm_armor;
    private final ModelPart left_arm_r1;
    private final ModelPart left_arm_r2;
    private final ModelPart left_arm_r3;
    private final ModelPart left_arm_r4;
    private final ModelPart left_arm_r5;
    private final ModelPart left_arm_r6;
    private final ModelPart belt;
    private final ModelPart body_r8;
    private final ModelPart emblem2;
    private final ModelPart emblem;
    private final ModelPart cloth2;
    private final ModelPart cloth;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Aptrgangr_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.roots = this.root.getChild("roots");
        this.l_leg = this.roots.getChild("l_leg");
        this.l_leg_armor = this.l_leg.getChild("l_leg_armor");
        this.left_leg_r1 = this.l_leg_armor.getChild("left_leg_r1");
        this.left_leg_r2 = this.l_leg_armor.getChild("left_leg_r2");
        this.r_leg = this.roots.getChild("r_leg");
        this.r_leg_armor = this.r_leg.getChild("r_leg_armor");
        this.right_leg_r1 = this.r_leg_armor.getChild("right_leg_r1");
        this.right_leg_r2 = this.r_leg_armor.getChild("right_leg_r2");
        this.body = this.roots.getChild("body");
        this.chest = this.body.getChild("chest");
        this.neck = this.chest.getChild("neck");
        this.head = this.neck.getChild("head");
        this.helmet = this.head.getChild("helmet");
        this.head_r1 = this.helmet.getChild("head_r1");
        this.head_r2 = this.helmet.getChild("head_r2");
        this.head_r3 = this.helmet.getChild("head_r3");
        this.head_r4 = this.helmet.getChild("head_r4");
        this.head_r5 = this.helmet.getChild("head_r5");
        this.head_r6 = this.helmet.getChild("head_r6");
        this.jaw = this.head.getChild("jaw");
        this.head_r7 = this.jaw.getChild("head_r7");
        this.chestplate = this.chest.getChild("chestplate");
        this.body_r1 = this.chestplate.getChild("body_r1");
        this.body_r2 = this.chestplate.getChild("body_r2");
        this.body_r3 = this.chestplate.getChild("body_r3");
        this.body_r4 = this.chestplate.getChild("body_r4");
        this.body_r5 = this.chestplate.getChild("body_r5");
        this.body_r6 = this.chestplate.getChild("body_r6");
        this.body_r7 = this.chestplate.getChild("body_r7");
        this.l_arm = this.chest.getChild("l_arm");
        this.l_arm_armor = this.l_arm.getChild("l_arm_armor");
        this.right_arm_r1 = this.l_arm_armor.getChild("right_arm_r1");
        this.right_arm_r2 = this.l_arm_armor.getChild("right_arm_r2");
        this.right_arm_r3 = this.l_arm_armor.getChild("right_arm_r3");
        this.right_arm_r4 = this.l_arm_armor.getChild("right_arm_r4");
        this.right_arm_r5 = this.l_arm_armor.getChild("right_arm_r5");
        this.right_arm_r6 = this.l_arm_armor.getChild("right_arm_r6");
        this.arrow = this.l_arm_armor.getChild("arrow");
        this.arrow2 = this.l_arm_armor.getChild("arrow2");
        this.left_arm2 = this.l_arm.getChild("left_arm2");
        this.l_arm_cloth = this.left_arm2.getChild("l_arm_cloth");
        this.hold = this.l_arm_cloth.getChild("hold");
        this.r_arm = this.chest.getChild("r_arm");
        this.right_arm2 = this.r_arm.getChild("right_arm2");
        this.r_arm_cloth = this.right_arm2.getChild("r_arm_cloth");
        this.axe = this.right_arm2.getChild("axe");
        this.cube_r1 = this.axe.getChild("cube_r1");
        this.cube_r2 = this.axe.getChild("cube_r2");
        this.axe_head = this.axe.getChild("axe_head");
        this.cube_r3 = this.axe_head.getChild("cube_r3");
        this.cube_r4 = this.axe_head.getChild("cube_r4");
        this.cube_r5 = this.axe_head.getChild("cube_r5");
        this.cube_r6 = this.axe_head.getChild("cube_r6");
        this.cube_r7 = this.axe_head.getChild("cube_r7");
        this.cube_r8 = this.axe_head.getChild("cube_r8");
        this.emblem3 = this.axe_head.getChild("emblem3");
        this.right_arm_r7 = this.emblem3.getChild("right_arm_r7");
        this.emblem4 = this.axe_head.getChild("emblem4");
        this.r_arm_armor = this.r_arm.getChild("r_arm_armor");
        this.left_arm_r1 = this.r_arm_armor.getChild("left_arm_r1");
        this.left_arm_r2 = this.r_arm_armor.getChild("left_arm_r2");
        this.left_arm_r3 = this.r_arm_armor.getChild("left_arm_r3");
        this.left_arm_r4 = this.r_arm_armor.getChild("left_arm_r4");
        this.left_arm_r5 = this.r_arm_armor.getChild("left_arm_r5");
        this.left_arm_r6 = this.r_arm_armor.getChild("left_arm_r6");
        this.belt = this.body.getChild("belt");
        this.body_r8 = this.belt.getChild("body_r8");
        this.emblem2 = this.belt.getChild("emblem2");
        this.emblem = this.belt.getChild("emblem");
        this.cloth2 = this.belt.getChild("cloth2");
        this.cloth = this.belt.getChild("cloth");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition l_leg = roots.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(0, 69).addBox(-3.5f, -3.0f, -3.0f, 6.0f, 16.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)6.0f, (float)-13.0f, (float)0.0f));
        PartDefinition l_leg_armor = l_leg.addOrReplaceChild("l_leg_armor", CubeListBuilder.create().texOffs(39, 91).addBox(-3.5f, -1.0f, -3.0f, 6.0f, 4.0f, 5.0f, new CubeDeformation(0.4f)).texOffs(0, 90).addBox(-3.5f, 7.0f, -3.0f, 6.0f, 4.0f, 5.0f, new CubeDeformation(0.4f)).texOffs(0, 109).addBox(-0.5f, 3.0f, -6.5f, 0.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 141).mirror().addBox(-4.5f, 11.0f, -4.0f, 8.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)-2.0f, (float)0.0f));
        PartDefinition left_leg_r1 = l_leg_armor.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(0, 105).addBox(-1.0f, -1.0f, -1.5f, 6.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 99).addBox(-2.0f, -2.0f, -1.9f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)6.0f, (float)-2.6f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition left_leg_r2 = l_leg_armor.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(0, 128).addBox(-0.5f, -0.5f, -3.0f, 1.0f, 7.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0f, (float)-1.5f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition r_leg = roots.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(22, 72).addBox(-3.5f, -3.0f, -3.0f, 6.0f, 16.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-5.0f, (float)-13.0f, (float)0.0f));
        PartDefinition r_leg_armor = r_leg.addOrReplaceChild("r_leg_armor", CubeListBuilder.create().texOffs(90, 71).addBox(-3.0f, -1.0f, 2.0f, 6.0f, 4.0f, 5.0f, new CubeDeformation(0.4f)).texOffs(88, 62).addBox(-3.0f, 7.0f, 2.0f, 6.0f, 4.0f, 5.0f, new CubeDeformation(0.4f)).texOffs(0, 141).addBox(-4.0f, 11.0f, 1.0f, 8.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 109).mirror().addBox(0.0f, 3.0f, -1.5f, 0.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-0.5f, (float)-2.0f, (float)-5.0f));
        PartDefinition right_leg_r1 = r_leg_armor.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(0, 105).mirror().addBox(-5.0f, -1.0f, -1.5f, 6.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 99).mirror().addBox(-2.0f, -2.0f, -1.9f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)6.0f, (float)2.4f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition right_leg_r2 = r_leg_armor.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(0, 128).mirror().addBox(-0.5f, -0.5f, -3.0f, 1.0f, 7.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-3.5f, (float)-1.5f, (float)4.5f, (float)0.0f, (float)0.0f, (float)0.0873f));
        PartDefinition body = roots.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 60).addBox(-5.5f, -6.0f, -3.0f, 11.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-16.0f, (float)0.0f));
        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0f, -14.0f, -6.0f, 18.0f, 14.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-6.0f, (float)0.0f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(80, 165).addBox(-2.5f, -4.0f, -2.55f, 5.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(80, 165).addBox(-2.5f, 0.0f, -2.55f, 5.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(100, 168).addBox(0.0f, -4.0f, 2.45f, 0.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-14.0f, (float)-2.45f, (float)0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 111).addBox(-4.0f, -7.0f, -5.5f, 8.0f, 9.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-4.0f, (float)-0.55f, (float)-0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(32, 113).addBox(-4.0f, -2.0f, -3.5f, 8.0f, 6.0f, 8.0f, new CubeDeformation(0.5f)).texOffs(102, 110).addBox(-1.5f, -2.8f, -4.3f, 3.0f, 8.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(64, 120).mirror().addBox(-5.5f, -2.0f, -1.5f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(116, 20).addBox(-10.5f, -3.5f, 0.5f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(64, 120).addBox(4.5f, -2.0f, -1.5f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(116, 0).addBox(4.5f, -9.5f, 0.5f, 6.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(88, 98).addBox(-5.0f, 3.2f, -4.3f, 10.0f, 2.0f, 10.0f, new CubeDeformation(0.001f)).texOffs(62, 91).addBox(-4.0f, 5.0f, -3.5f, 8.0f, 0.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-5.0f, (float)-2.0f));
        PartDefinition head_r1 = helmet.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(28, 104).mirror().addBox(-0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.4f, (float)3.5f, (float)-3.8f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition head_r2 = helmet.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(42, 111).mirror().addBox(-1.0f, -0.5f, -0.5f, 2.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(44, 106).mirror().addBox(0.0f, -1.5f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(43, 109).mirror().addBox(-1.0f, 0.5f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(29, 115).mirror().addBox(-2.0f, -1.5f, -0.5f, 4.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.4f, (float)3.5f, (float)-4.1f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        PartDefinition head_r3 = helmet.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(43, 108).addBox(-1.0f, -0.5f, -0.5f, 2.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(32, 104).addBox(-2.0f, -1.5f, -0.5f, 4.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.4f, (float)3.5f, (float)-4.1f, (float)0.0f, (float)0.0f, (float)0.2618f));
        PartDefinition head_r4 = helmet.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(25, 108).mirror().addBox(-0.5f, -1.5f, -0.5f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)4.8f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition head_r5 = helmet.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(31, 108).mirror().addBox(-0.5f, -1.5f, -0.5f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)6.2f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition head_r6 = helmet.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(30, 111).mirror().addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)1.7f, (float)-3.9f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(34, 26).addBox(-3.0f, 0.0f, -2.5f, 6.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(3.0f, 3.0f, 0.0f, 6.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(48, 5).addBox(3.0f, -2.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(48, 5).mirror().addBox(-5.0f, -2.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(48, 0).mirror().addBox(-9.0f, 3.0f, 0.0f, 6.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(84, 1).addBox(3.0f, 8.0f, -2.5f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(84, 1).mirror().addBox(-8.0f, 8.0f, -2.5f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(52, 33).addBox(-3.0f, 0.0f, 0.5f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-2.0f, (float)-3.0f));
        PartDefinition head_r7 = jaw.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(92, 12).addBox(-3.0f, 0.0f, 0.0f, 6.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)8.0f, (float)-2.5f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition chestplate = chest.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(0, 150).addBox(-6.0f, -3.0f, -9.0f, 12.0f, 7.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 159).addBox(-4.0f, 4.0f, -9.0f, 8.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 180).addBox(-9.0f, 3.0f, -7.0f, 18.0f, 2.0f, 12.0f, new CubeDeformation(0.2f)).texOffs(68, 174).addBox(-5.0f, -5.0f, -7.0f, 10.0f, 6.0f, 12.0f, new CubeDeformation(0.1f)).texOffs(0, 165).addBox(-6.0f, -3.0f, -9.0f, 12.0f, 7.0f, 2.0f, new CubeDeformation(-0.1f)).texOffs(0, 174).addBox(-4.0f, 4.0f, -9.0f, 8.0f, 4.0f, 2.0f, new CubeDeformation(-0.1f)), PartPose.offset((float)0.0f, (float)-9.0f, (float)1.0f));
        PartDefinition body_r1 = chestplate.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(48, 182).addBox(-4.0f, -4.0f, -1.0f, 8.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)6.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition body_r2 = chestplate.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(0, 188).addBox(-1.0f, -2.0f, 0.0f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)6.5f, (float)4.0f, (float)-7.3f, (float)0.0f, (float)0.2618f, (float)0.1309f));
        PartDefinition body_r3 = chestplate.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(0, 188).mirror().addBox(-1.0f, -2.0f, 0.0f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-6.5f, (float)4.0f, (float)-7.3f, (float)0.0f, (float)-0.2618f, (float)-0.1309f));
        PartDefinition body_r4 = chestplate.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(0, 188).mirror().addBox(-1.0f, -2.0f, 0.0f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-6.5f, (float)-3.0f, (float)-7.3f, (float)0.0f, (float)-0.2618f, (float)0.5236f));
        PartDefinition body_r5 = chestplate.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(0, 194).mirror().addBox(-0.5f, -1.0f, -6.0f, 9.0f, 2.0f, 12.0f, new CubeDeformation(0.1f)).mirror(false), PartPose.offsetAndRotation((float)-9.0f, (float)-4.5f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition body_r6 = chestplate.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(0, 188).addBox(-1.0f, -2.0f, 0.0f, 2.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)6.5f, (float)-3.0f, (float)-7.3f, (float)0.0f, (float)0.2618f, (float)-0.5236f));
        PartDefinition body_r7 = chestplate.addOrReplaceChild("body_r7", CubeListBuilder.create().texOffs(0, 194).addBox(-8.5f, -1.0f, -6.0f, 9.0f, 2.0f, 12.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)9.0f, (float)-4.5f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0f, -2.5f, -4.0f, 8.0f, 12.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)12.0f, (float)-12.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition l_arm_armor = l_arm.addOrReplaceChild("l_arm_armor", CubeListBuilder.create().texOffs(112, 56).mirror().addBox(-4.5086f, -5.3695f, -7.0f, 2.0f, 10.0f, 14.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(130, 66).mirror().addBox(-4.5086f, 4.6305f, -7.0f, 12.0f, 2.0f, 14.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 26).mirror().addBox(-4.5086f, -4.3695f, -6.0f, 11.0f, 11.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(138, 36).mirror().addBox(6.4914f, -3.3695f, -3.0f, 2.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(106, 36).mirror().addBox(-1.5086f, -4.3695f, -6.0f, 8.0f, 8.0f, 12.0f, new CubeDeformation(0.2f)).mirror(false).texOffs(154, 40).mirror().addBox(0.4914f, -3.3695f, -7.0f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(166, 38).mirror().addBox(2.4914f, -4.3695f, -11.0f, 0.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(162, 46).mirror().addBox(1.4914f, -1.3695f, -11.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(142, 55).mirror().addBox(8.4914f, -0.3695f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(146, 49).mirror().addBox(8.4914f, -4.3695f, 0.0f, 6.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition right_arm_r1 = l_arm_armor.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(168, 68).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 1.0f, new CubeDeformation(-0.1f)).mirror(false).texOffs(168, 74).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(182, 75).mirror().addBox(-6.5f, -0.5f, 0.5f, 7.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-3.0086f, (float)5.1305f, (float)-8.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition right_arm_r2 = l_arm_armor.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(130, 82).mirror().addBox(-6.0f, 0.0f, 0.0f, 12.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.4914f, (float)6.6305f, (float)6.0f, (float)0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm_r3 = l_arm_armor.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(130, 82).mirror().addBox(-6.0f, 0.0f, 0.0f, 12.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.4914f, (float)6.6305f, (float)-6.0f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm_r4 = l_arm_armor.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(154, 68).mirror().addBox(0.0f, 0.0f, -7.0f, 0.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)6.4914f, (float)6.6305f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition right_arm_r5 = l_arm_armor.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(162, 46).mirror().addBox(-1.0f, 0.0f, -2.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(166, 38).mirror().addBox(0.0f, -3.0f, -2.0f, 0.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.4914f, (float)-1.3695f, (float)9.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition right_arm_r6 = l_arm_armor.addOrReplaceChild("right_arm_r6", CubeListBuilder.create().texOffs(154, 40).mirror().addBox(-2.0f, -2.0f, -1.0f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.4914f, (float)-1.3695f, (float)6.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition arrow = l_arm_armor.addOrReplaceChild("arrow", CubeListBuilder.create().texOffs(128, 100).addBox(-8.0f, -2.5f, 0.0f, 16.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(128, 100).addBox(-7.0f, -2.5f, -2.5f, 0.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(123, 100).addBox(-8.0f, 0.0f, -2.5f, 16.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.5f, (float)-3.0f, (float)-5.0f, (float)0.0f, (float)-0.4363f, (float)1.7453f));
        PartDefinition arrow2 = l_arm_armor.addOrReplaceChild("arrow2", CubeListBuilder.create().texOffs(128, 100).addBox(-8.0f, -2.5f, 0.0f, 16.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(128, 100).addBox(-7.0f, -2.5f, -2.5f, 0.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(123, 100).addBox(-8.0f, 0.0f, -2.5f, 16.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.5f, (float)-6.0f, (float)1.0f, (float)0.0385f, (float)0.2148f, (float)1.924f));
        PartDefinition left_arm2 = l_arm.addOrReplaceChild("left_arm2", CubeListBuilder.create().texOffs(70, 75).addBox(-3.0f, 0.0f, -3.0f, 7.0f, 10.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(80, 49).addBox(-4.0f, 10.0f, -3.0f, 7.0f, 7.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)3.0f, (float)9.5f, (float)0.0f));
        PartDefinition l_arm_cloth = left_arm2.addOrReplaceChild("l_arm_cloth", CubeListBuilder.create().texOffs(88, 31).addBox(-3.5f, -4.25f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(0.5f)).texOffs(109, 129).mirror().addBox(-4.5f, 0.75f, -4.0f, 9.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.5f, (float)7.25f, (float)0.0f));
        PartDefinition hold = l_arm_cloth.addOrReplaceChild("hold", CubeListBuilder.create(), PartPose.offset((float)10.5f, (float)-2.0f, (float)2.0f));
        PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(60, 0).addBox(-5.0f, -2.5f, -4.0f, 8.0f, 12.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-12.0f, (float)-12.5f, (float)0.0f, (float)-1.044f, (float)0.2117f, (float)0.25f));
        PartDefinition right_arm2 = r_arm.addOrReplaceChild("right_arm2", CubeListBuilder.create().texOffs(44, 75).addBox(-4.0f, 0.0f, -3.0f, 7.0f, 10.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(68, 36).addBox(-3.0f, 10.0f, -3.0f, 7.0f, 7.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)9.5f, (float)0.0f, (float)-1.9635f, (float)0.0f, (float)0.0f));
        PartDefinition r_arm_cloth = right_arm2.addOrReplaceChild("r_arm_cloth", CubeListBuilder.create().texOffs(84, 20).addBox(-3.5f, -4.25f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(0.5f)).texOffs(109, 129).addBox(-4.5f, 0.75f, -4.0f, 9.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.5f, (float)7.25f, (float)0.0f));
        PartDefinition axe = right_arm2.addOrReplaceChild("axe", CubeListBuilder.create().texOffs(3, 205).addBox(-1.5f, -1.5f, -32.0f, 3.0f, 3.0f, 48.0f, new CubeDeformation(0.0f)).texOffs(56, 241).addBox(-3.5f, 0.0f, -31.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(3, 205).addBox(-1.5f, -1.5f, -32.0f, 3.0f, 3.0f, 48.0f, new CubeDeformation(0.0f)).texOffs(26, 241).addBox(-1.5f, -1.5f, -25.0f, 3.0f, 3.0f, 9.0f, new CubeDeformation(0.2f)).texOffs(26, 241).addBox(-1.5f, -1.5f, -4.0f, 3.0f, 3.0f, 9.0f, new CubeDeformation(0.2f)).texOffs(25, 245).addBox(-1.5f, -1.5f, -18.0f, 3.0f, 3.0f, 2.0f, new CubeDeformation(0.4f)).texOffs(25, 245).addBox(-1.5f, -1.5f, -5.0f, 3.0f, 3.0f, 2.0f, new CubeDeformation(0.4f)).texOffs(25, 245).addBox(-1.5f, -1.5f, 3.0f, 3.0f, 3.0f, 2.0f, new CubeDeformation(0.4f)).texOffs(57, 245).addBox(-2.5f, -2.5f, -28.0f, 5.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(57, 245).addBox(-2.5f, -2.5f, 15.0f, 5.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(60, 228).addBox(-3.5f, 0.0f, 17.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(64, 228).addBox(1.4f, 0.0f, 17.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(60, 231).addBox(-0.1f, 1.5f, 17.0f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(60, 233).addBox(-0.1f, -3.5f, 17.0f, 0.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(60, 241).addBox(1.5f, 0.0f, -31.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.5f, (float)13.5f, (float)0.0f));
        PartDefinition cube_r1 = axe.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 241).addBox(1.5f, 0.0f, -2.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(56, 241).addBox(-3.5f, 0.0f, -2.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-29.0f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition cube_r2 = axe.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 231).addBox(-1.5f, -1.5f, -2.0f, 3.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)20.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition axe_head = axe.addOrReplaceChild("axe_head", CubeListBuilder.create().texOffs(111, 249).addBox(-1.5f, -1.5f, -14.0f, 3.0f, 3.0f, 4.0f, new CubeDeformation(0.2f)).texOffs(68, 231).addBox(-1.5f, -1.5f, -13.8f, 3.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(122, 203).addBox(-0.5f, 7.4f, -8.8f, 1.0f, 10.0f, 9.0f, new CubeDeformation(-0.001f)).texOffs(0, 236).addBox(-1.5f, -5.5f, -5.8f, 3.0f, 11.0f, 6.0f, new CubeDeformation(0.3f)).texOffs(97, 232).addBox(-1.5f, -7.5f, -9.6f, 3.0f, 15.0f, 6.0f, new CubeDeformation(0.2f)).texOffs(73, 229).addBox(-1.5f, -7.5f, -8.8f, 3.0f, 15.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-32.2f));
        PartDefinition cube_r3 = axe_head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(81, 211).addBox(-0.5f, -3.5f, -5.5f, 1.0f, 9.0f, 9.0f, new CubeDeformation(0.01f)), PartPose.offsetAndRotation((float)0.0f, (float)-10.5f, (float)-4.3f, (float)0.48f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r4 = axe_head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(156, 198).addBox(0.5f, -18.5f, -7.0f, 0.0f, 33.0f, 14.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)-0.5f, (float)19.1267f, (float)-0.0182f, (float)-1.0036f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r5 = axe_head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(142, 206).addBox(-0.5f, -13.5f, -1.0f, 1.0f, 16.0f, 6.0f, new CubeDeformation(0.001f)).texOffs(104, 208).addBox(-0.5f, 2.5f, -9.0f, 1.0f, 6.0f, 14.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)14.0647f, (float)-3.2431f, (float)-1.0036f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r6 = axe_head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(109, 214).addBox(0.5f, 2.5f, -9.0f, 0.0f, 6.0f, 14.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)-0.5f, (float)17.2895f, (float)-8.3051f, (float)-1.0036f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r7 = axe_head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(64, 228).addBox(0.0f, -1.5f, -2.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-15.8f, (float)0.0f, (float)0.0f, (float)2.3562f));
        PartDefinition cube_r8 = axe_head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(64, 228).addBox(0.0f, -1.5f, -2.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-15.8f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition emblem3 = axe_head.addOrReplaceChild("emblem3", CubeListBuilder.create().texOffs(168, 74).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(168, 68).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(-0.1f)), PartPose.offsetAndRotation((float)-2.0f, (float)0.0f, (float)-5.3f, (float)1.5708f, (float)-0.7854f, (float)1.5708f));
        PartDefinition right_arm_r7 = emblem3.addOrReplaceChild("right_arm_r7", CubeListBuilder.create().texOffs(169, 204).mirror().addBox(-4.0f, -4.0f, 0.0f, 8.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.5f, (float)0.5f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)-1.5708f));
        PartDefinition emblem4 = axe_head.addOrReplaceChild("emblem4", CubeListBuilder.create().texOffs(168, 74).mirror().addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(169, 204).mirror().addBox(-4.5f, -3.5f, -0.5f, 8.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(168, 68).mirror().addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(-0.1f)).mirror(false), PartPose.offsetAndRotation((float)2.0f, (float)0.0f, (float)-5.3f, (float)1.5708f, (float)0.7854f, (float)-1.5708f));
        PartDefinition r_arm_armor = r_arm.addOrReplaceChild("r_arm_armor", CubeListBuilder.create().texOffs(112, 56).addBox(2.5086f, -5.3695f, -7.0f, 2.0f, 10.0f, 14.0f, new CubeDeformation(0.0f)).texOffs(130, 86).addBox(2.5086f, -3.3695f, -7.0f, 2.0f, 2.0f, 1.0f, new CubeDeformation(0.1f)).texOffs(130, 66).addBox(-7.4914f, 4.6305f, -7.0f, 12.0f, 2.0f, 14.0f, new CubeDeformation(0.0f)).texOffs(0, 26).addBox(-6.4914f, -4.3695f, -6.0f, 11.0f, 11.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(138, 36).addBox(-8.4914f, -3.3695f, -3.0f, 2.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(106, 36).addBox(-6.4914f, -4.3695f, -6.0f, 8.0f, 8.0f, 12.0f, new CubeDeformation(0.2f)).texOffs(154, 40).addBox(-4.4914f, -3.3695f, -7.0f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(166, 38).addBox(-2.4914f, -4.3695f, -11.0f, 0.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(162, 46).addBox(-3.4914f, -1.3695f, -11.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(142, 55).addBox(-14.4914f, -0.3695f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(146, 49).addBox(-14.4914f, -4.3695f, 0.0f, 6.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition left_arm_r1 = r_arm_armor.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(168, 68).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 1.0f, new CubeDeformation(-0.1f)).texOffs(168, 74).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(182, 75).addBox(-0.5f, -0.5f, 0.5f, 7.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0086f, (float)5.1305f, (float)-8.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition left_arm_r2 = r_arm_armor.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(130, 82).addBox(-6.0f, 0.0f, 0.0f, 12.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.4914f, (float)6.6305f, (float)6.0f, (float)0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm_r3 = r_arm_armor.addOrReplaceChild("left_arm_r3", CubeListBuilder.create().texOffs(130, 82).addBox(-6.0f, 0.0f, 0.0f, 12.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.4914f, (float)6.6305f, (float)-6.0f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm_r4 = r_arm_armor.addOrReplaceChild("left_arm_r4", CubeListBuilder.create().texOffs(154, 68).addBox(0.0f, 0.0f, -7.0f, 0.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-6.4914f, (float)6.6305f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition left_arm_r5 = r_arm_armor.addOrReplaceChild("left_arm_r5", CubeListBuilder.create().texOffs(162, 46).addBox(-1.0f, 0.0f, -2.0f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(166, 38).addBox(0.0f, -3.0f, -2.0f, 0.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.4914f, (float)-1.3695f, (float)9.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition left_arm_r6 = r_arm_armor.addOrReplaceChild("left_arm_r6", CubeListBuilder.create().texOffs(154, 40).addBox(-2.0f, -2.0f, -1.0f, 4.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.4914f, (float)-1.3695f, (float)6.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition belt = body.addOrReplaceChild("belt", CubeListBuilder.create().texOffs(95, 131).addBox(3.5f, -19.0f, -4.0f, 3.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(100, 144).addBox(6.5f, -17.0f, -2.0f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(100, 144).mirror().addBox(-9.5f, -17.0f, -2.0f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(95, 131).mirror().addBox(-6.5f, -19.0f, -4.0f, 3.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(60, 66).addBox(-5.5f, -17.0f, -3.0f, 11.0f, 3.0f, 6.0f, new CubeDeformation(0.5f)).texOffs(157, 86).addBox(-5.5f, -19.0f, -3.0f, 11.0f, 3.0f, 6.0f, new CubeDeformation(0.3f)), PartPose.offset((float)0.0f, (float)14.0f, (float)0.0f));
        PartDefinition body_r8 = belt.addOrReplaceChild("body_r8", CubeListBuilder.create().texOffs(100, 144).addBox(-1.5f, 0.0f, -1.5f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(100, 144).mirror().addBox(-17.5f, 0.0f, -1.5f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)8.0f, (float)-17.0f, (float)-0.5f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition emblem2 = belt.addOrReplaceChild("emblem2", CubeListBuilder.create().texOffs(168, 74).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(168, 68).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(-0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)-15.5f, (float)3.5f, (float)3.1416f, (float)0.0f, (float)2.3562f));
        PartDefinition emblem = belt.addOrReplaceChild("emblem", CubeListBuilder.create().texOffs(168, 74).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(168, 68).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, new CubeDeformation(-0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)-15.5f, (float)-3.5f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition cloth2 = belt.addOrReplaceChild("cloth2", CubeListBuilder.create().texOffs(46, 127).addBox(-4.5f, 0.0f, 0.0f, 9.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-13.5f, (float)3.5f));
        PartDefinition cloth = belt.addOrReplaceChild("cloth", CubeListBuilder.create().texOffs(46, 127).addBox(-4.5f, 0.0f, 0.0f, 9.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-13.5f, (float)-3.5f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        if (entity.getAttackState() != 4) {
            this.animateWalk(Aptrgangr_Animation.WALK, limbSwing, limbSwingAmount, 2.5f, 4.0f);
        }
        this.animate(entity.getAnimationState("idle"), Aptrgangr_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("swing_right"), Aptrgangr_Animation.SWING_RIGHT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("smash"), Aptrgangr_Animation.SMASH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("charge_start"), Aptrgangr_Animation.RUSH_START, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("charge"), Aptrgangr_Animation.RUSHING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("charge_end"), Aptrgangr_Animation.RUSH_END, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("charge_hit"), Aptrgangr_Animation.RUSH_HIT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Aptrgangr_Animation.DEATH, ageInTicks, 1.0f);
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

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot += xRot * ((float)Math.PI / 180);
        this.head.yRot += yRot * ((float)Math.PI / 180);
    }

    public void translateToHand(PoseStack matrixStack) {
        this.root.translateAndRotate(matrixStack);
        this.roots.translateAndRotate(matrixStack);
        this.body.translateAndRotate(matrixStack);
        this.chest.translateAndRotate(matrixStack);
        this.l_arm.translateAndRotate(matrixStack);
        this.left_arm2.translateAndRotate(matrixStack);
        this.l_arm_cloth.translateAndRotate(matrixStack);
        this.hold.translateAndRotate(matrixStack);
    }

    public ModelPart root() {
        return this.root;
    }
}

