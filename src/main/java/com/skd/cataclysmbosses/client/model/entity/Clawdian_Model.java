/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.LegSolverQuadruped
 *  com.mojang.blaze3d.vertex.PoseStack
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
 *  net.minecraft.client.Minecraft
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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Clawdian_Animation;
import com.skd.cataclysmbosses.client.animation.Clawdian_Skill_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.skd.nautilusapi.server.animation.LegSolverQuadruped;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import com.skd.cataclysmbosses.client.model.compat.CmHierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class Clawdian_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart mid_root;
    private final ModelPart lower_body;
    private final ModelPart pelvis;
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart right_down_antenna;
    private final ModelPart left_down_antenna;
    private final ModelPart head_tail;
    private final ModelPart left_arm;
    private final ModelPart left_front_arm_rotator;
    private final ModelPart left_front_arm;
    private final ModelPart left_claw;
    private final ModelPart block;
    private final ModelPart right_arm;
    private final ModelPart right_front_arm_rotator;
    private final ModelPart right_front_arm;
    private final ModelPart right_claw;
    private final ModelPart right_hammer;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart legs;
    private final ModelPart left_f_leg_joint;
    private final ModelPart left_f_leg;
    private final ModelPart left_f_leg_solver;
    private final ModelPart left_f_fore_leg;
    private final ModelPart left_f_fore_leg_solver;
    private final ModelPart right_f_leg_joint;
    private final ModelPart right_f_leg;
    private final ModelPart right_f_leg_solver;
    private final ModelPart right_f_fore_leg;
    private final ModelPart right_f_fore_leg_solver;
    private final ModelPart right_b_leg_joint;
    private final ModelPart right_b_leg;
    private final ModelPart right_b_leg_solver;
    private final ModelPart right_b_fore_leg;
    private final ModelPart right_b_fore_leg_solver;
    private final ModelPart left_b_leg_joint;
    private final ModelPart left_b_leg;
    private final ModelPart left_b_leg_solver;
    private final ModelPart left_b_fore_leg;
    private final ModelPart left_b_fore_leg_solver;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Clawdian_Model(ModelPart root) {
        super(root);
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.mid_root = this.everything.getChild("mid_root");
        this.lower_body = this.mid_root.getChild("lower_body");
        this.pelvis = this.lower_body.getChild("pelvis");
        this.body = this.pelvis.getChild("body");
        this.neck = this.body.getChild("neck");
        this.head = this.neck.getChild("head");
        this.right_down_antenna = this.head.getChild("right_down_antenna");
        this.left_down_antenna = this.head.getChild("left_down_antenna");
        this.head_tail = this.head.getChild("head_tail");
        this.left_arm = this.body.getChild("left_arm");
        this.left_front_arm_rotator = this.left_arm.getChild("left_front_arm_rotator");
        this.left_front_arm = this.left_front_arm_rotator.getChild("left_front_arm");
        this.left_claw = this.left_front_arm.getChild("left_claw");
        this.block = this.left_front_arm.getChild("block");
        this.right_arm = this.body.getChild("right_arm");
        this.right_front_arm_rotator = this.right_arm.getChild("right_front_arm_rotator");
        this.right_front_arm = this.right_front_arm_rotator.getChild("right_front_arm");
        this.right_claw = this.right_front_arm.getChild("right_claw");
        this.right_hammer = this.right_front_arm.getChild("right_hammer");
        this.tail1 = this.lower_body.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.legs = this.lower_body.getChild("legs");
        this.left_f_leg_joint = this.legs.getChild("left_f_leg_joint");
        this.left_f_leg = this.left_f_leg_joint.getChild("left_f_leg");
        this.left_f_leg_solver = this.left_f_leg.getChild("left_f_leg_solver");
        this.left_f_fore_leg = this.left_f_leg_solver.getChild("left_f_fore_leg");
        this.left_f_fore_leg_solver = this.left_f_fore_leg.getChild("left_f_fore_leg_solver");
        this.right_f_leg_joint = this.legs.getChild("right_f_leg_joint");
        this.right_f_leg = this.right_f_leg_joint.getChild("right_f_leg");
        this.right_f_leg_solver = this.right_f_leg.getChild("right_f_leg_solver");
        this.right_f_fore_leg = this.right_f_leg_solver.getChild("right_f_fore_leg");
        this.right_f_fore_leg_solver = this.right_f_fore_leg.getChild("right_f_fore_leg_solver");
        this.right_b_leg_joint = this.legs.getChild("right_b_leg_joint");
        this.right_b_leg = this.right_b_leg_joint.getChild("right_b_leg");
        this.right_b_leg_solver = this.right_b_leg.getChild("right_b_leg_solver");
        this.right_b_fore_leg = this.right_b_leg_solver.getChild("right_b_fore_leg");
        this.right_b_fore_leg_solver = this.right_b_fore_leg.getChild("right_b_fore_leg_solver");
        this.left_b_leg_joint = this.legs.getChild("left_b_leg_joint");
        this.left_b_leg = this.left_b_leg_joint.getChild("left_b_leg");
        this.left_b_leg_solver = this.left_b_leg.getChild("left_b_leg_solver");
        this.left_b_fore_leg = this.left_b_leg_solver.getChild("left_b_fore_leg");
        this.left_b_fore_leg_solver = this.left_b_fore_leg.getChild("left_b_fore_leg_solver");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-26.4f, (float)0.0f, (float)0.0f, (float)-0.5236f, (float)0.0f));
        PartDefinition lower_body = mid_root.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(83, 122).addBox(-8.0f, -7.1839f, -9.7571f, 16.0f, 10.0f, 24.0f, new CubeDeformation(0.0f)).texOffs(171, 0).addBox(-8.5f, -7.6839f, -4.7571f, 17.0f, 8.0f, 17.0f, new CubeDeformation(0.25f)).texOffs(51, 157).addBox(-8.0f, 2.8161f, -9.7571f, 16.0f, 4.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.4161f, (float)-0.2429f, (float)-0.1745f, (float)0.6545f, (float)0.0f));
        PartDefinition pelvis = lower_body.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(197, 149).addBox(-6.5f, -19.6954f, -4.5741f, 13.0f, 21.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(197, 180).addBox(-6.5f, -18.6954f, -4.5741f, 13.0f, 21.0f, 9.0f, new CubeDeformation(0.25f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.4885f, (float)-8.1831f, (float)-0.1294f, (float)-0.1289f, (float)-0.0229f));
        PartDefinition body = pelvis.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-15.3925f, (float)-1.078f, (float)0.0025f, (float)-0.1248f, (float)-0.0396f));
        PartDefinition armor_r1 = body.addOrReplaceChild("armor_r1", CubeListBuilder.create().texOffs(168, 86).addBox(-5.5f, -13.2f, -19.5f, 20.0f, 15.0f, 14.0f, new CubeDeformation(0.25f)).texOffs(171, 55).addBox(-4.7f, -13.0f, -19.0f, 19.0f, 15.0f, 13.0f, new CubeDeformation(0.25f)).texOffs(171, 26).addBox(-4.7f, -13.0f, -19.0f, 19.0f, 15.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.8f, (float)-7.3029f, (float)12.504f, (float)0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(213, 236).addBox(-3.2494f, -8.0043f, -4.0847f, 6.0f, 14.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.2494f, (float)-15.2986f, (float)-0.4113f, (float)0.1755f, (float)-0.0034f, (float)0.0186f));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-4.1053f, (float)-2.8262f, (float)0.5659f, (float)0.0836f, (float)-0.0147f));
        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(132, 155).addBox(1.0f, -34.0f, -36.0f, 0.0f, 11.0f, 32.0f, new CubeDeformation(0.0f)).texOffs(236, 66).addBox(-1.0f, -29.0f, -29.0f, 4.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.2494f, (float)25.101f, (float)3.7415f, (float)-0.2269f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(51, 205).addBox(-5.0f, -4.0f, -12.0f, 7.0f, 7.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.2506f, (float)-2.899f, (float)2.7415f, (float)-0.2269f, (float)0.0f, (float)0.0f));
        PartDefinition right_down_antenna = head.addOrReplaceChild("right_down_antenna", CubeListBuilder.create().texOffs(0, 86).addBox(0.7506f, -25.1128f, -21.7043f, 0.0f, 26.0f, 41.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)-3.7862f, (float)-12.5542f, (float)-0.1018f, (float)0.2523f, (float)-0.8635f));
        PartDefinition left_down_antenna = head.addOrReplaceChild("left_down_antenna", CubeListBuilder.create().texOffs(0, 86).mirror().addBox(-0.7506f, -25.1128f, -21.7043f, 0.0f, 26.0f, 41.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.5013f, (float)-3.7862f, (float)-12.5542f, (float)-0.1018f, (float)-0.2523f, (float)0.8635f));
        PartDefinition head_tail = head.addOrReplaceChild("head_tail", CubeListBuilder.create().texOffs(236, 50).addBox(-2.5192f, -2.0716f, -1.1109f, 5.0f, 5.0f, 10.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)-0.2763f, (float)-2.8274f, (float)5.8524f, (float)-0.8286f, (float)0.0102f, (float)-0.0072f));
        PartDefinition cube_r3 = head_tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(238, 236).addBox(31.0f, -3.0f, -2.0f, 8.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-35.0787f, (float)2.9284f, (float)7.8891f, (float)-0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 218).addBox(-1.2027f, -3.0687f, -3.1026f, 6.0f, 22.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(188, 211).addBox(-3.2027f, -4.0687f, -5.1026f, 11.0f, 12.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)8.2027f, (float)-13.2342f, (float)0.6065f, (float)0.1706f, (float)-0.5977f, (float)-0.5657f));
        PartDefinition left_front_arm_rotator = left_arm.addOrReplaceChild("left_front_arm_rotator", CubeListBuilder.create(), PartPose.offsetAndRotation((float)1.95f, (float)15.3903f, (float)0.4874f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition left_front_arm = left_front_arm_rotator.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(112, 201).addBox(-6.1527f, -2.459f, -6.59f, 8.0f, 19.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(58, 228).addBox(-5.1527f, 16.541f, -6.59f, 6.0f, 15.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)2.0f, (float)1.0f, (float)-0.2967f, (float)0.0f, (float)0.0f));
        PartDefinition left_claw = left_front_arm.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(236, 26).addBox(-2.8527f, -2.559f, -4.89f, 6.0f, 17.0f, 6.0f, new CubeDeformation(-0.1f)), PartPose.offsetAndRotation((float)-2.3f, (float)15.1f, (float)4.3f, (float)0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition block = left_front_arm.addOrReplaceChild("block", CubeListBuilder.create(), PartPose.offset((float)-2.3f, (float)23.1f, (float)1.3f));
        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(87, 228).addBox(-4.7973f, -3.0687f, -3.1026f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-8.2027f, (float)-13.2342f, (float)0.6065f, (float)-0.4334f, (float)0.9184f, (float)0.2283f));
        PartDefinition right_front_arm_rotator = right_arm.addOrReplaceChild("right_front_arm_rotator", CubeListBuilder.create(), PartPose.offset((float)-1.95f, (float)15.3903f, (float)0.5874f));
        PartDefinition right_front_arm = right_front_arm_rotator.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(25, 228).addBox(-3.8473f, -0.459f, -4.59f, 8.0f, 12.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(146, 157).addBox(-3.8473f, 11.541f, -3.59f, 5.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-1.525f, (float)-0.3051f, (float)-0.0138f));
        PartDefinition right_claw = right_front_arm.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(125, 157).addBox(-0.1473f, 0.441f, -4.89f, 4.0f, 12.0f, 6.0f, new CubeDeformation(-0.1f)), PartPose.offsetAndRotation((float)0.3f, (float)10.1f, (float)1.3f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition right_hammer = right_front_arm.addOrReplaceChild("right_hammer", CubeListBuilder.create().texOffs(153, 201).addBox(-5.8473f, -10.459f, -57.59f, 7.0f, 25.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(0, 154).addBox(-2.3473f, -19.459f, -62.59f, 0.0f, 38.0f, 25.0f, new CubeDeformation(0.0f)).texOffs(112, 186).addBox(-4.3473f, -2.959f, 15.51f, 4.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0368f, (float)19.2741f, (float)-0.4526f, (float)-0.5296f, (float)0.3024f, (float)0.3881f));
        PartDefinition cube_r4 = right_hammer.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(112, 186).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.3473f, (float)-0.959f, (float)-60.69f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r5 = right_hammer.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5f, -1.5f, -41.0f, 3.0f, 3.0f, 82.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.3473f, (float)-0.959f, (float)-21.59f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition tail1 = lower_body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(83, 86).addBox(-7.0f, -4.4682f, -4.9412f, 14.0f, 7.0f, 28.0f, new CubeDeformation(0.0f)).texOffs(164, 122).addBox(-7.0f, 2.5318f, -2.9412f, 14.0f, 3.0f, 23.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.2843f, (float)14.1841f, (float)-0.044f, (float)0.1308f, (float)-0.0057f));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(51, 186).addBox(-9.0f, -2.6682f, -0.9412f, 18.0f, 6.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.2f, (float)21.0f, (float)-0.1286f, (float)0.3641f, (float)0.1243f));
        PartDefinition legs = lower_body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_f_leg_joint = legs.addOrReplaceChild("left_f_leg_joint", CubeListBuilder.create(), PartPose.offset((float)8.0981f, (float)2.9884f, (float)-10.2377f));
        PartDefinition left_f_leg = left_f_leg_joint.addOrReplaceChild("left_f_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1759f, (float)0.7161f, (float)-0.6623f));
        PartDefinition left_f_leg_solver = left_f_leg.addOrReplaceChild("left_f_leg_solver", CubeListBuilder.create().texOffs(231, 211).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.3756f, (float)-2.8562f, (float)1.8591f));
        PartDefinition left_f_fore_leg = left_f_leg_solver.addOrReplaceChild("left_f_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)1.4148f, (float)16.6562f, (float)-1.2591f, (float)-0.1396f, (float)0.0f, (float)1.0472f));
        PartDefinition left_f_fore_leg_solver = left_f_fore_leg.addOrReplaceChild("left_f_fore_leg_solver", CubeListBuilder.create().texOffs(148, 237).addBox(-2.3683f, -4.4072f, -0.648f, 4.0f, 19.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(137, 233).addBox(-1.3683f, -12.4072f, 1.352f, 5.0f, 30.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_f_leg_joint = legs.addOrReplaceChild("right_f_leg_joint", CubeListBuilder.create(), PartPose.offset((float)-7.2371f, (float)2.7935f, (float)-9.1327f));
        PartDefinition right_f_leg = right_f_leg_joint.addOrReplaceChild("right_f_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1759f, (float)-0.7161f, (float)0.6623f));
        PartDefinition right_f_leg_solver = right_f_leg.addOrReplaceChild("right_f_leg_solver", CubeListBuilder.create().texOffs(112, 233).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.902f, (float)-2.1723f, (float)0.4805f));
        PartDefinition right_f_fore_leg = right_f_leg_solver.addOrReplaceChild("right_f_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-0.1373f, (float)15.9723f, (float)0.1195f, (float)-0.1396f, (float)0.0f, (float)-1.0472f));
        PartDefinition right_f_fore_leg_solver = right_f_fore_leg.addOrReplaceChild("right_f_fore_leg_solver", CubeListBuilder.create().texOffs(165, 237).addBox(-2.8627f, -4.9723f, -2.1194f, 4.0f, 19.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(237, 81).addBox(-4.8627f, -12.9723f, -0.1194f, 5.0f, 30.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_b_leg_joint = legs.addOrReplaceChild("right_b_leg_joint", CubeListBuilder.create(), PartPose.offset((float)-7.746f, (float)0.3722f, (float)5.0641f));
        PartDefinition right_b_leg = right_b_leg_joint.addOrReplaceChild("right_b_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.5717f, (float)0.4999f, (float)0.953f));
        PartDefinition right_b_leg_solver = right_b_leg.addOrReplaceChild("right_b_leg_solver", CubeListBuilder.create().texOffs(188, 234).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.254f, (float)-2.5409f, (float)-0.9948f));
        PartDefinition right_b_fore_leg = right_b_leg_solver.addOrReplaceChild("right_b_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-0.7853f, (float)16.3409f, (float)0.3948f, (float)0.1384f, (float)0.0182f, (float)-1.1768f));
        PartDefinition right_b_fore_leg_solver = right_b_fore_leg.addOrReplaceChild("right_b_fore_leg_solver", CubeListBuilder.create().texOffs(165, 237).addBox(-2.2147f, -3.3409f, -2.3949f, 4.0f, 19.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(237, 81).addBox(-4.2147f, -11.3409f, -0.3949f, 5.0f, 30.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_b_leg_joint = legs.addOrReplaceChild("left_b_leg_joint", CubeListBuilder.create(), PartPose.offset((float)7.746f, (float)0.3722f, (float)5.0641f));
        PartDefinition left_b_leg = left_b_leg_joint.addOrReplaceChild("left_b_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.5717f, (float)-0.4999f, (float)-0.953f));
        PartDefinition left_b_leg_solver = left_b_leg.addOrReplaceChild("left_b_leg_solver", CubeListBuilder.create().texOffs(188, 234).mirror().addBox(-3.0f, -1.0f, -3.0f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.254f, (float)-2.5409f, (float)-0.9948f));
        PartDefinition left_b_fore_leg = left_b_leg_solver.addOrReplaceChild("left_b_fore_leg", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.7853f, (float)16.3409f, (float)0.3948f, (float)0.1384f, (float)-0.0182f, (float)1.1768f));
        PartDefinition left_b_fore_leg_solver = left_b_fore_leg.addOrReplaceChild("left_b_fore_leg_solver", CubeListBuilder.create().texOffs(165, 237).mirror().addBox(-1.7853f, -3.3409f, -2.3949f, 4.0f, 19.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(237, 81).mirror().addBox(-0.7853f, -11.3409f, -0.3949f, 5.0f, 30.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.getAllParts().entrySet()) {
            String partName = (String)entry.getKey();
            ModelPart childPart = (ModelPart)entry.getValue();
            this.partCache.putIfAbsent(partName, childPart);
            this.optionalPartCache.putIfAbsent(partName, Optional.of(childPart));
            if (getChildrenMap(childPart).isEmpty()) continue;
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

        @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
    }
}
