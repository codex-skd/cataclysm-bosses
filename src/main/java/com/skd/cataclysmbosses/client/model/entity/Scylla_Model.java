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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Scylla_Lightning_Animation;
import com.skd.cataclysmbosses.client.animation.Scylla_Normal_Animation;
import com.skd.cataclysmbosses.client.animation.Scylla_Projectile_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
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
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

public class Scylla_Model
extends HierarchicalModel<Scylla_Entity> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart scylla;
    private final ModelPart r_leg;
    private final ModelPart r_leg_armor;
    private final ModelPart r_leg2;
    private final ModelPart body;
    private final ModelPart belt_sea_snake_mody;
    private final ModelPart belt_sea_snake;
    private final ModelPart belt_sea_snake2;
    private final ModelPart belt_sea_snake3;
    private final ModelPart belt_sea_snake_head;
    private final ModelPart belt_sea_snake_head2;
    private final ModelPart belt_sea_snake_tongue;
    private final ModelPart chest;
    private final ModelPart head;
    private final ModelPart l_eye;
    private final ModelPart r_eye;
    private final ModelPart hair;
    private final ModelPart hair2;
    private final ModelPart l_arm;
    private final ModelPart l_armor;
    private final ModelPart l_sea_snake;
    private final ModelPart l_sea_snake2;
    private final ModelPart l_sea_snake3;
    private final ModelPart l_sea_snake_head;
    private final ModelPart r_sea_snake_head3;
    private final ModelPart l_sea_snake_tongue;
    private final ModelPart l_arm2;
    private final ModelPart anchor;
    private final ModelPart trail2;
    private final ModelPart chain_main;
    private final ModelPart chain_4;
    private final ModelPart chain_3;
    private final ModelPart chain_2;
    private final ModelPart chain;
    private final ModelPart chain_anchor;
    private final ModelPart trail;
    private final ModelPart r_arm;
    private final ModelPart r_armor;
    private final ModelPart r_arm2;
    private final ModelPart r_sea_snake;
    private final ModelPart r_sea_snake2;
    private final ModelPart r_sea_snake3;
    private final ModelPart r_sea_snake_head;
    private final ModelPart r_sea_snake_tongue;
    private final ModelPart r_sea_snake_head2;
    private final ModelPart l_leg;
    private final ModelPart l_leg_armor;
    private final ModelPart l_leg2;
    private final ModelPart anchor2;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Scylla_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.anchor2 = this.root.getChild("anchor2");
        this.scylla = this.everything.getChild("scylla");
        this.r_leg = this.scylla.getChild("r_leg");
        this.r_leg_armor = this.r_leg.getChild("r_leg_armor");
        this.r_leg2 = this.r_leg.getChild("r_leg2");
        this.body = this.scylla.getChild("body");
        this.belt_sea_snake_mody = this.body.getChild("belt_sea_snake_mody");
        this.belt_sea_snake = this.belt_sea_snake_mody.getChild("belt_sea_snake");
        this.belt_sea_snake2 = this.belt_sea_snake.getChild("belt_sea_snake2");
        this.belt_sea_snake3 = this.belt_sea_snake2.getChild("belt_sea_snake3");
        this.belt_sea_snake_head = this.belt_sea_snake3.getChild("belt_sea_snake_head");
        this.belt_sea_snake_head2 = this.belt_sea_snake_head.getChild("belt_sea_snake_head2");
        this.belt_sea_snake_tongue = this.belt_sea_snake_head.getChild("belt_sea_snake_tongue");
        this.chest = this.body.getChild("chest");
        this.head = this.chest.getChild("head");
        this.l_eye = this.head.getChild("l_eye");
        this.r_eye = this.head.getChild("r_eye");
        this.hair = this.head.getChild("hair");
        this.hair2 = this.hair.getChild("hair2");
        this.l_arm = this.chest.getChild("l_arm");
        this.l_armor = this.l_arm.getChild("l_armor");
        this.l_sea_snake = this.l_armor.getChild("l_sea_snake");
        this.l_sea_snake2 = this.l_sea_snake.getChild("l_sea_snake2");
        this.l_sea_snake3 = this.l_sea_snake2.getChild("l_sea_snake3");
        this.l_sea_snake_head = this.l_sea_snake3.getChild("l_sea_snake_head");
        this.r_sea_snake_head3 = this.l_sea_snake_head.getChild("r_sea_snake_head3");
        this.l_sea_snake_tongue = this.l_sea_snake_head.getChild("l_sea_snake_tongue");
        this.l_arm2 = this.l_arm.getChild("l_arm2");
        this.anchor = this.l_arm2.getChild("anchor");
        this.trail2 = this.anchor.getChild("trail2");
        this.chain_main = this.l_arm2.getChild("chain_main");
        this.chain_4 = this.chain_main.getChild("chain_4");
        this.chain_3 = this.chain_4.getChild("chain_3");
        this.chain_2 = this.chain_3.getChild("chain_2");
        this.chain = this.chain_2.getChild("chain");
        this.chain_anchor = this.chain.getChild("chain_anchor");
        this.trail = this.chain_anchor.getChild("trail");
        this.r_arm = this.chest.getChild("r_arm");
        this.r_armor = this.r_arm.getChild("r_armor");
        this.r_arm2 = this.r_arm.getChild("r_arm2");
        this.r_sea_snake = this.r_arm.getChild("r_sea_snake");
        this.r_sea_snake2 = this.r_sea_snake.getChild("r_sea_snake2");
        this.r_sea_snake3 = this.r_sea_snake2.getChild("r_sea_snake3");
        this.r_sea_snake_head = this.r_sea_snake3.getChild("r_sea_snake_head");
        this.r_sea_snake_tongue = this.r_sea_snake_head.getChild("r_sea_snake_tongue");
        this.r_sea_snake_head2 = this.r_sea_snake_head.getChild("r_sea_snake_head2");
        this.l_leg = this.scylla.getChild("l_leg");
        this.l_leg_armor = this.l_leg.getChild("l_leg_armor");
        this.l_leg2 = this.l_leg.getChild("l_leg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition scylla = everything.addOrReplaceChild("scylla", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition r_leg = scylla.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(120, 66).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)0.0873f, (float)0.0436f));
        PartDefinition r_leg_armor = r_leg.addOrReplaceChild("r_leg_armor", CubeListBuilder.create().texOffs(90, 117).addBox(-0.4347f, 0.4957f, -2.5f, 3.0f, 8.0f, 5.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)-1.7f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition r_leg2 = r_leg.addOrReplaceChild("r_leg2", CubeListBuilder.create().texOffs(34, 115).addBox(-2.0f, 1.0f, -2.0f, 4.0f, 10.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(0, 115).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)9.0f, (float)0.0f));
        PartDefinition cube_r1 = r_leg2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(109, 52).addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition body = scylla.addOrReplaceChild("body", CubeListBuilder.create().texOffs(25, 107).addBox(-4.0f, -1.5f, -2.5f, 8.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(104, 23).addBox(-4.0f, -2.0f, -2.5f, 8.0f, 3.0f, 5.0f, new CubeDeformation(0.1f)).texOffs(109, 32).addBox(-3.5f, -6.0f, -2.0f, 7.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-20.0f, (float)0.0f));
        PartDefinition belt_sea_snake_mody = body.addOrReplaceChild("belt_sea_snake_mody", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-1.0f, (float)0.0f));
        PartDefinition cube_r2 = belt_sea_snake_mody.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(89, 62).addBox(-4.5f, -1.0f, -3.0f, 9.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f, (float)0.1745f));
        PartDefinition belt_sea_snake = belt_sea_snake_mody.addOrReplaceChild("belt_sea_snake", CubeListBuilder.create().texOffs(131, 23).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.0f, (float)-1.0f, (float)2.0f, (float)1.007f, (float)-0.4346f, (float)-1.0914f));
        PartDefinition belt_sea_snake2 = belt_sea_snake.addOrReplaceChild("belt_sea_snake2", CubeListBuilder.create().texOffs(131, 23).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)5.0f, (float)1.1709f, (float)-0.1796f, (float)-0.3999f));
        PartDefinition belt_sea_snake3 = belt_sea_snake2.addOrReplaceChild("belt_sea_snake3", CubeListBuilder.create().texOffs(131, 23).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)6.0f, (float)0.7135f, (float)0.3775f, (float)-0.3719f));
        PartDefinition belt_sea_snake_head = belt_sea_snake3.addOrReplaceChild("belt_sea_snake_head", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)6.0f, (float)0.4503f, (float)-0.1006f, (float)-0.6365f));
        PartDefinition belt_sea_snake_head2 = belt_sea_snake_head.addOrReplaceChild("belt_sea_snake_head2", CubeListBuilder.create().texOffs(92, 131).addBox(-1.5f, -1.0f, 0.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition belt_sea_snake_tongue = belt_sea_snake_head.addOrReplaceChild("belt_sea_snake_tongue", CubeListBuilder.create().texOffs(131, 7).addBox(-1.5f, 0.0f, 0.0f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.3f, (float)4.0f, (float)0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-5.0f, (float)0.0f));
        PartDefinition cube_r3 = chest.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 39).addBox(-4.0f, -2.0995f, -2.9822f, 8.0f, 5.0f, 7.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.7005f, (float)-2.1178f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r4 = chest.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 85).addBox(-4.0f, -2.0995f, -2.9822f, 8.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0481f, (float)-0.2347f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r5 = chest.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(90, 107).addBox(-4.0f, -2.5f, -2.0f, 8.0f, 5.0f, 4.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.6071f, (float)-3.0929f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r6 = chest.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(73, 25).addBox(-4.0f, -2.0995f, -2.9822f, 8.0f, 6.0f, 7.0f, new CubeDeformation(0.2f)).texOffs(73, 11).addBox(-4.0f, -2.0995f, -2.9822f, 8.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.9005f, (float)-1.0178f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 68).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.3f)).texOffs(23, 68).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(66, 123).addBox(-2.5f, -1.0f, -2.5f, 5.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-6.5f, (float)0.0f));
        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 130).mirror().addBox(-1.5f, -1.5f, -4.5f, 3.0f, 3.0f, 5.0f, new CubeDeformation(0.3f)).mirror(false), PartPose.offsetAndRotation((float)3.1736f, (float)-0.7152f, (float)0.0f, (float)0.1298f, (float)-0.0011f, (float)-0.1575f));
        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 130).addBox(-1.5f, -1.5f, -4.5f, 3.0f, 3.0f, 5.0f, new CubeDeformation(0.3f)), PartPose.offsetAndRotation((float)-3.1736f, (float)-0.7152f, (float)0.0f, (float)0.1298f, (float)0.0011f, (float)0.1575f));
        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(110, 0).mirror().addBox(0.0f, -5.0f, 0.0f, 10.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)4.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)-0.3054f, (float)0.0f));
        PartDefinition cube_r10 = head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(110, 0).addBox(-10.0f, -5.0f, 0.0f, 10.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)0.3054f, (float)0.0f));
        PartDefinition cube_r11 = head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(132, 32).addBox(-5.0f, 2.0f, -5.0f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0E-4f, (float)-5.5076f, (float)0.123f, (float)0.1742f, (float)-0.7816f, (float)-0.1231f));
        PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(125, 80).addBox(-5.0f, -3.0f, -5.0f, 4.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-6.5f, (float)0.0f, (float)0.1742f, (float)-0.7816f, (float)-0.1231f));
        PartDefinition l_eye = head.addOrReplaceChild("l_eye", CubeListBuilder.create().texOffs(23, 84).mirror().addBox(-1.0f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)2.0f, (float)-2.5f, (float)-4.1f));
        PartDefinition r_eye = head.addOrReplaceChild("r_eye", CubeListBuilder.create().texOffs(23, 84).addBox(-1.0f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-2.0f, (float)-2.5f, (float)-4.1f));
        PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(73, 0).addBox(-9.0f, 0.0f, 0.0f, 18.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-2.0f, (float)4.0f));
        PartDefinition hair2 = hair.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(0, 39).addBox(-12.0f, 0.0f, 0.0f, 24.0f, 13.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)10.0f, (float)0.0f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(129, 11).addBox(-2.0f, -2.0f, -2.0f, 3.0f, 7.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.5f, (float)-4.0f, (float)0.0f, (float)-0.5942f, (float)-0.2039f, (float)-0.0423f));
        PartDefinition cube_r13 = l_arm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(109, 57).addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)1.5f, (float)3.5f, (float)-3.1416f, (float)0.0f, (float)2.3562f));
        PartDefinition l_armor = l_arm.addOrReplaceChild("l_armor", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition cube_r14 = l_armor.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(98, 95).mirror().addBox(-1.5f, -2.5f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(-0.1f)).mirror(false).texOffs(89, 71).addBox(-1.5f, -2.5f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(131, 0).addBox(2.5f, 1.5f, -3.0f, 3.0f, 0.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(98, 83).mirror().addBox(-1.5f, -2.5f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition cube_r15 = l_armor.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(104, 11).addBox(-3.0f, -2.5f, -3.0f, 6.0f, 5.0f, 6.0f, new CubeDeformation(-0.2f)), PartPose.offsetAndRotation((float)2.1203f, (float)3.1021f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3054f));
        PartDefinition cube_r16 = l_armor.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(78, 62).addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)2.0f, (float)-3.5f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition l_sea_snake = l_armor.addOrReplaceChild("l_sea_snake", CubeListBuilder.create().texOffs(131, 23).mirror().addBox(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.5f, (float)-0.5f, (float)3.0f, (float)0.9878f, (float)0.0119f, (float)1.1603f));
        PartDefinition l_sea_snake2 = l_sea_snake.addOrReplaceChild("l_sea_snake2", CubeListBuilder.create().texOffs(131, 23).mirror().addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)5.0f, (float)1.0657f, (float)-0.5086f, (float)0.263f));
        PartDefinition l_sea_snake3 = l_sea_snake2.addOrReplaceChild("l_sea_snake3", CubeListBuilder.create().texOffs(131, 23).mirror().addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)6.0f, (float)0.5876f, (float)-0.6222f, (float)-0.0195f));
        PartDefinition l_sea_snake_head = l_sea_snake3.addOrReplaceChild("l_sea_snake_head", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)6.0f, (float)1.0908f, (float)0.0f, (float)0.0f));
        PartDefinition r_sea_snake_head3 = l_sea_snake_head.addOrReplaceChild("r_sea_snake_head3", CubeListBuilder.create().texOffs(92, 131).mirror().addBox(-1.5f, -1.0f, 0.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition l_sea_snake_tongue = l_sea_snake_head.addOrReplaceChild("l_sea_snake_tongue", CubeListBuilder.create().texOffs(131, 7).mirror().addBox(-1.5f, 0.0f, 0.0f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-0.3f, (float)4.0f, (float)0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition l_arm2 = l_arm.addOrReplaceChild("l_arm2", CubeListBuilder.create().texOffs(66, 131).addBox(-0.2389f, -0.9829f, -2.0f, 2.0f, 8.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(51, 123).addBox(-1.5f, 0.0f, -2.0f, 3.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)5.0f, (float)0.0f, (float)-1.6849f, (float)-0.1083f, (float)0.2301f));
        PartDefinition anchor = l_arm2.addOrReplaceChild("anchor", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0f, -3.0f, -23.0f, 4.0f, 6.0f, 32.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)-1.5f, (float)8.0f, (float)0.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r17 = anchor.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 85).addBox(-2.0f, -4.0f, -4.0f, 4.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)7.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r18 = anchor.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(49, 39).addBox(1.0f, -10.0f, -10.0f, 0.0f, 14.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)0.0f, (float)10.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r19 = anchor.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 102).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-26.3f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r20 = anchor.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(78, 52).addBox(-3.0f, 1.0f, -3.0f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.0f, (float)-30.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r21 = anchor.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(107, 121).addBox(-1.0f, -3.0f, -3.0f, 2.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-30.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r22 = anchor.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 53).addBox(0.0f, -7.0f, -3.0f, 0.0f, 18.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-30.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r23 = anchor.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(73, 104).addBox(-1.0f, -6.0f, -3.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)-15.6944f, (float)-21.2732f, (float)2.3998f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r24 = anchor.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(77, 85).addBox(-2.0f, -1.0f, -3.0f, 4.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)-26.0f, (float)3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r25 = anchor.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(73, 104).addBox(-1.0f, -6.0f, -3.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)15.6944f, (float)-21.2732f, (float)2.3998f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r26 = anchor.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(77, 85).addBox(-2.0f, -1.0f, -3.0f, 4.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-26.0f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r27 = anchor.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(125, 91).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.0963f, (float)-22.4693f, (float)2.7925f, (float)0.0f, (float)-3.1416f));
        PartDefinition cube_r28 = anchor.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(125, 91).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)3.0963f, (float)-22.4693f, (float)2.7925f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r29 = anchor.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(23, 53).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(0, 131).addBox(-1.0f, -1.0f, -11.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(25, 85).addBox(0.0f, -5.0f, -13.0f, 0.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-19.5093f, (float)-14.7353f, (float)3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r30 = anchor.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 131).addBox(-1.0f, -1.0f, -11.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)19.5093f, (float)-14.7353f, (float)-3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r31 = anchor.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(25, 85).addBox(0.0f, -5.0f, -5.0f, 0.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)18.4651f, (float)-6.8037f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r32 = anchor.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(23, 53).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)19.5093f, (float)-14.7353f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition trail2 = anchor.addOrReplaceChild("trail2", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)-29.0f));
        PartDefinition chain_main = l_arm2.addOrReplaceChild("chain_main", CubeListBuilder.create().texOffs(134, 13).addBox(-3.0f, 0.0f, -8.0f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)8.0f, (float)0.0f));
        PartDefinition chain_4 = chain_main.addOrReplaceChild("chain_4", CubeListBuilder.create().texOffs(149, 13).addBox(0.0f, -3.0f, -7.0f, 0.0f, 6.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-8.0f));
        PartDefinition chain_3 = chain_4.addOrReplaceChild("chain_3", CubeListBuilder.create().texOffs(134, 13).addBox(-3.0f, 0.0f, -7.8f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-6.2f));
        PartDefinition chain_2 = chain_3.addOrReplaceChild("chain_2", CubeListBuilder.create().texOffs(149, 13).addBox(0.0f, -3.0f, -8.0f, 0.0f, 6.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-6.8f));
        PartDefinition chain = chain_2.addOrReplaceChild("chain", CubeListBuilder.create().texOffs(134, 13).addBox(-3.0f, 0.0f, -8.0f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-7.0f));
        PartDefinition chain_anchor = chain.addOrReplaceChild("chain_anchor", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0f, -3.0f, -43.0f, 4.0f, 6.0f, 32.0f, new CubeDeformation(-0.01f)), PartPose.offset((float)0.0f, (float)0.0f, (float)-7.0f));
        PartDefinition cube_r33 = chain_anchor.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 102).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-46.3f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r34 = chain_anchor.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 85).addBox(-2.0f, -4.0f, -4.0f, 4.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-13.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r35 = chain_anchor.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(49, 39).addBox(1.0f, -10.0f, -10.0f, 0.0f, 14.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)0.0f, (float)-10.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r36 = chain_anchor.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(78, 52).addBox(-3.0f, 1.0f, -3.0f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.0f, (float)-50.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r37 = chain_anchor.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(107, 121).addBox(-1.0f, -3.0f, -3.0f, 2.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-50.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r38 = chain_anchor.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 53).addBox(0.0f, -7.0f, -3.0f, 0.0f, 18.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-50.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r39 = chain_anchor.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(73, 104).addBox(-1.0f, -6.0f, -3.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)-15.6944f, (float)-41.2732f, (float)2.3998f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r40 = chain_anchor.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(77, 85).addBox(-2.0f, -1.0f, -3.0f, 4.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)-46.0f, (float)3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r41 = chain_anchor.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(73, 104).addBox(-1.0f, -6.0f, -3.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)15.6944f, (float)-41.2732f, (float)2.3998f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r42 = chain_anchor.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(77, 85).addBox(-2.0f, -1.0f, -3.0f, 4.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-46.0f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r43 = chain_anchor.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(125, 91).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.0963f, (float)-42.4693f, (float)2.7925f, (float)0.0f, (float)-3.1416f));
        PartDefinition cube_r44 = chain_anchor.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(125, 91).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)3.0963f, (float)-42.4693f, (float)2.7925f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r45 = chain_anchor.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(23, 53).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(0, 131).addBox(-1.0f, -1.0f, -11.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(25, 85).addBox(0.0f, -5.0f, -13.0f, 0.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-19.5093f, (float)-34.7353f, (float)3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r46 = chain_anchor.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 131).addBox(-1.0f, -1.0f, -11.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)19.5093f, (float)-34.7353f, (float)-3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r47 = chain_anchor.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(25, 85).addBox(0.0f, -5.0f, -5.0f, 0.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)18.4651f, (float)-26.8037f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r48 = chain_anchor.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(23, 53).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)19.5093f, (float)-34.7353f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition trail = chain_anchor.addOrReplaceChild("trail", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)-49.0f));
        PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(17, 130).addBox(-1.0f, -2.0f, -2.0f, 3.0f, 7.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.5f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition r_armor = r_arm.addOrReplaceChild("r_armor", CubeListBuilder.create(), PartPose.offset((float)0.5f, (float)-0.5f, (float)0.0f));
        PartDefinition cube_r49 = r_armor.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(78, 62).mirror().addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-3.5f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition cube_r50 = r_armor.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(109, 57).mirror().addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)3.5f, (float)-3.1416f, (float)0.0f, (float)-2.3562f));
        PartDefinition cube_r51 = r_armor.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(46, 95).addBox(-5.5f, -2.5f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(131, 0).mirror().addBox(-5.5f, 1.5f, -3.0f, 3.0f, 0.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(98, 95).addBox(-5.5f, -2.5f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(-0.1f)).texOffs(98, 83).addBox(-5.5f, -2.5f, -3.0f, 7.0f, 5.0f, 6.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)-0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition cube_r52 = r_armor.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(104, 11).mirror().addBox(-3.0f, -2.5f, -3.0f, 6.0f, 5.0f, 6.0f, new CubeDeformation(-0.2f)).mirror(false), PartPose.offsetAndRotation((float)-2.6203f, (float)3.1021f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3054f));
        PartDefinition r_arm2 = r_arm.addOrReplaceChild("r_arm2", CubeListBuilder.create().texOffs(79, 131).addBox(-1.7611f, -0.9829f, -2.0f, 2.0f, 8.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(124, 121).addBox(-1.5f, 0.0f, -2.0f, 3.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition r_sea_snake = r_arm.addOrReplaceChild("r_sea_snake", CubeListBuilder.create().texOffs(131, 23).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.5f, (float)-1.0f, (float)3.0f, (float)0.8745f, (float)-0.039f, (float)-0.5504f));
        PartDefinition r_sea_snake2 = r_sea_snake.addOrReplaceChild("r_sea_snake2", CubeListBuilder.create().texOffs(131, 23).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)5.0f, (float)1.1345f, (float)0.0f, (float)0.0f));
        PartDefinition r_sea_snake3 = r_sea_snake2.addOrReplaceChild("r_sea_snake3", CubeListBuilder.create().texOffs(131, 23).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)6.0f, (float)0.829f, (float)0.0f, (float)0.0f));
        PartDefinition r_sea_snake_head = r_sea_snake3.addOrReplaceChild("r_sea_snake_head", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)6.0f, (float)0.7854f, (float)0.0f, (float)0.0f));
        PartDefinition r_sea_snake_tongue = r_sea_snake_head.addOrReplaceChild("r_sea_snake_tongue", CubeListBuilder.create().texOffs(131, 7).addBox(-1.5f, 0.0f, 0.0f, 3.0f, 0.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.3f, (float)4.0f, (float)0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition r_sea_snake_head2 = r_sea_snake_head.addOrReplaceChild("r_sea_snake_head2", CubeListBuilder.create().texOffs(92, 131).addBox(-1.5f, -1.0f, 0.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition l_leg = scylla.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(120, 52).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-20.0f, (float)0.0f, (float)0.0f, (float)-0.0436f, (float)-0.0436f));
        PartDefinition cube_r53 = l_leg.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(109, 43).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)0.0f, (float)-0.0869f, (float)0.7816f, (float)-0.3849f));
        PartDefinition l_leg_armor = l_leg.addOrReplaceChild("l_leg_armor", CubeListBuilder.create().texOffs(115, 107).addBox(-2.5653f, 0.4957f, -2.5f, 3.0f, 8.0f, 5.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)1.7f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition cube_r54 = l_leg_armor.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(109, 43).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.7f, (float)7.0f, (float)0.0f, (float)-0.2618f, (float)0.3927f, (float)-0.2182f));
        PartDefinition l_leg2 = l_leg.addOrReplaceChild("l_leg2", CubeListBuilder.create().texOffs(17, 115).addBox(-2.0f, 1.0f, -2.0f, 4.0f, 10.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(52, 107).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)9.0f, (float)0.0f));
        PartDefinition cube_r55 = l_leg2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(109, 43).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)5.0f, (float)0.0f, (float)0.2109f, (float)0.1038f, (float)0.2387f));
        PartDefinition cube_r56 = l_leg2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(78, 62).addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition anchor2 = partdefinition.addOrReplaceChild("anchor2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0f, -3.0f, -23.0f, 4.0f, 6.0f, 32.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)4.0f, (float)8.0f, (float)0.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r57 = anchor2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 85).addBox(-2.0f, -4.0f, -4.0f, 4.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)7.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r58 = anchor2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(49, 39).addBox(1.0f, -10.0f, -10.0f, 0.0f, 14.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)0.0f, (float)10.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r59 = anchor2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(0, 102).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-26.3f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r60 = anchor2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(78, 52).addBox(-3.0f, 1.0f, -3.0f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)1.0f, (float)-30.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r61 = anchor2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(107, 121).addBox(-1.0f, -3.0f, -3.0f, 2.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-30.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r62 = anchor2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 53).addBox(0.0f, -7.0f, -3.0f, 0.0f, 18.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-30.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r63 = anchor2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(73, 104).addBox(-1.0f, -6.0f, -3.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)-15.6944f, (float)-21.2732f, (float)2.3998f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r64 = anchor2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(77, 85).addBox(-2.0f, -1.0f, -3.0f, 4.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)-26.0f, (float)3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r65 = anchor2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(73, 104).addBox(-1.0f, -6.0f, -3.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)15.6944f, (float)-21.2732f, (float)2.3998f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r66 = anchor2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(77, 85).addBox(-2.0f, -1.0f, -3.0f, 4.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.0f, (float)-26.0f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r67 = anchor2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(125, 91).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.0963f, (float)-22.4693f, (float)2.7925f, (float)0.0f, (float)-3.1416f));
        PartDefinition cube_r68 = anchor2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(125, 91).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)3.0963f, (float)-22.4693f, (float)2.7925f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r69 = anchor2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(23, 53).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(0, 131).addBox(-1.0f, -1.0f, -11.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(25, 85).addBox(0.0f, -5.0f, -13.0f, 0.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-19.5093f, (float)-14.7353f, (float)3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r70 = anchor2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 131).addBox(-1.0f, -1.0f, -11.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)19.5093f, (float)-14.7353f, (float)-3.0107f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r71 = anchor2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(25, 85).addBox(0.0f, -5.0f, -5.0f, 0.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)18.4651f, (float)-6.8037f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition cube_r72 = anchor2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(23, 53).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)19.5093f, (float)-14.7353f, (float)3.0107f, (float)0.0f, (float)3.1416f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
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

    public void setupAnim(Scylla_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        if (entity.getAttackState() != 7) {
            this.animateWalk(Scylla_Normal_Animation.WALK, limbSwing, limbSwingAmount, 1.5f, 4.0f);
        }
        this.l_eye.visible = entity.getEye();
        this.r_eye.visible = entity.getEye();
        this.chain_main.visible = entity.getChainAnchor();
        this.anchor2.visible = entity.isSleep();
        this.animate(entity.getAnimationState("idle"), Scylla_Normal_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("cross_swing"), Scylla_Normal_Animation.CROSS_SWING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("cross_swing2"), Scylla_Normal_Animation.CROSS_SWING2, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("double_swing"), Scylla_Normal_Animation.DOUBLE_CROSS_SWING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("swing_smash"), Scylla_Normal_Animation.SWING_SMASH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("smash"), Scylla_Normal_Animation.SMASH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("back_step"), Scylla_Normal_Animation.BACKSTEP, ageInTicks, 1.2f);
        this.animate(entity.getAnimationState("spin"), Scylla_Normal_Animation.ANCHOR_SPIN_ATTACK, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("wave"), Scylla_Projectile_Animation.WAVE_SHOOT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("lightning_explosion"), Scylla_Lightning_Animation.LIGHTNING_EXPLOSION, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("lightning_spear_throw"), Scylla_Lightning_Animation.LIGHTNING_SPEAR_THROW, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("water_spear_throw"), Scylla_Projectile_Animation.WATER_SPEAR_THROW, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("anchor_shot"), Scylla_Projectile_Animation.ANCHOR_THROW, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("anchor_shot_pull"), Scylla_Projectile_Animation.ANCHOR_THROW_PULL, ageInTicks, 1.1f);
        this.animate(entity.getAnimationState("chain_jump_1"), Scylla_Projectile_Animation.CHAIN_JUMP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("chain_jump_2"), Scylla_Projectile_Animation.LANDING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("chain_jump_3"), Scylla_Projectile_Animation.SUPER_HERO_LANDING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("anchor_explosion"), Scylla_Lightning_Animation.ANCHOR_EXPLOSION, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("parry"), Scylla_Projectile_Animation.PARRY, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("electric_whip"), Scylla_Lightning_Animation.ELECTRIC_WHIP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("whip_and_spear"), Scylla_Projectile_Animation.WHIP_AND_SPEAR, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Scylla_Lightning_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("enchant_1"), Scylla_Lightning_Animation.WEAPON_ENCHANT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("enchant_2"), Scylla_Lightning_Animation.WEAPON_ENCHANT2, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spawn"), Scylla_Lightning_Animation.SPAWN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spawn_idle"), Scylla_Lightning_Animation.SPAWN_IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("summon_snake"), Scylla_Lightning_Animation.SUMMON_SNAKE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("grab_smash"), Scylla_Normal_Animation.GRAB_SMASH, ageInTicks, 1.0f);
    }

    public void translateToEye(PoseStack matrixStack, boolean right) {
        this.root.translateAndRotate(matrixStack);
        this.everything.translateAndRotate(matrixStack);
        this.scylla.translateAndRotate(matrixStack);
        this.body.translateAndRotate(matrixStack);
        this.chest.translateAndRotate(matrixStack);
        this.head.translateAndRotate(matrixStack);
        if (right) {
            this.r_eye.translateAndRotate(matrixStack);
        } else {
            this.l_eye.translateAndRotate(matrixStack);
        }
    }

    public Vec3 getChainPosition(Vec3 offsetIn) {
        PoseStack armStack = new PoseStack();
        armStack.pushPose();
        this.root.translateAndRotate(armStack);
        this.everything.translateAndRotate(armStack);
        this.scylla.translateAndRotate(armStack);
        this.body.translateAndRotate(armStack);
        this.chest.translateAndRotate(armStack);
        this.l_arm.translateAndRotate(armStack);
        this.l_arm2.translateAndRotate(armStack);
        Vector4f armOffsetVec = new Vector4f((float)offsetIn.x, (float)offsetIn.y, (float)offsetIn.z, 1.0f);
        armOffsetVec.mul((Matrix4fc)armStack.last().pose());
        Vec3 vec3 = new Vec3((double)armOffsetVec.x(), (double)armOffsetVec.y(), (double)armOffsetVec.z());
        armStack.popPose();
        return vec3.add(0.0, 0.0, 0.0);
    }

    public void translateChainAnchor(PoseStack matrixStack) {
        this.root.translateAndRotate(matrixStack);
        this.everything.translateAndRotate(matrixStack);
        this.scylla.translateAndRotate(matrixStack);
        this.body.translateAndRotate(matrixStack);
        this.chest.translateAndRotate(matrixStack);
        this.l_arm.translateAndRotate(matrixStack);
        this.l_arm2.translateAndRotate(matrixStack);
        this.chain_main.translateAndRotate(matrixStack);
        this.chain_4.translateAndRotate(matrixStack);
        this.chain_3.translateAndRotate(matrixStack);
        this.chain_2.translateAndRotate(matrixStack);
        this.chain.translateAndRotate(matrixStack);
        this.chain_anchor.translateAndRotate(matrixStack);
        this.trail.translateAndRotate(matrixStack);
    }

    public void translateHand(PoseStack matrixStack) {
        this.root.translateAndRotate(matrixStack);
        this.everything.translateAndRotate(matrixStack);
        this.scylla.translateAndRotate(matrixStack);
        this.body.translateAndRotate(matrixStack);
        this.chest.translateAndRotate(matrixStack);
        this.l_arm.translateAndRotate(matrixStack);
        this.l_arm2.translateAndRotate(matrixStack);
        this.anchor.translateAndRotate(matrixStack);
    }

    public Vec3 getHandPosition(Vec3 offsetIn) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        this.translateHand(translationStack);
        Vector4f armOffsetVec = new Vector4f((float)offsetIn.x, (float)offsetIn.y, (float)offsetIn.z, 1.0f);
        armOffsetVec.mul((Matrix4fc)translationStack.last().pose());
        Vec3 vec3 = new Vec3((double)(-armOffsetVec.x()), (double)(-armOffsetVec.y()), (double)armOffsetVec.z());
        translationStack.popPose();
        return vec3.add(0.0, 1.5, 0.0);
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot = xRot * ((float)Math.PI / 180);
        this.head.yRot = yRot * ((float)Math.PI / 180);
        float f = xRot * ((float)Math.PI / 180);
        float f1 = 0.5f;
        this.hair.xRot = Mth.cos((float)f) * f1;
    }

    public ModelPart root() {
        return this.root;
    }
}

