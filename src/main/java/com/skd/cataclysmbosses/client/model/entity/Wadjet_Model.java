/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.skd.nautilusapi.client.model.tools.DynamicChain
 *  com.google.common.collect.ImmutableList
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Minecraft
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Wadjet_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Wadjet_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.client.model.tools.DynamicChain;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;

public class Wadjet_Model
extends AdvancedEntityModel<Wadjet_Entity> {
    private final AdvancedModelBox everything;
    private final AdvancedModelBox mid_root;
    private final AdvancedModelBox upper_body1;
    private final AdvancedModelBox pelvis;
    private final AdvancedModelBox upper_body2;
    private final AdvancedModelBox body;
    private final AdvancedModelBox neck1;
    private final AdvancedModelBox neck2;
    private final AdvancedModelBox face;
    private final AdvancedModelBox head;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox cube_r3;
    private final AdvancedModelBox cube_r4;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox right_fore_arm;
    private final AdvancedModelBox right_finger3;
    private final AdvancedModelBox right_finger2;
    private final AdvancedModelBox right_finger1;
    private final AdvancedModelBox right_finger4;
    private final AdvancedModelBox wand;
    private final AdvancedModelBox cube_r5;
    private final AdvancedModelBox left_arm;
    private final AdvancedModelBox left_fore_arm;
    private final AdvancedModelBox left_finger3;
    private final AdvancedModelBox left_finger2;
    private final AdvancedModelBox left_finger1;
    private final AdvancedModelBox left_finger4;
    private final AdvancedModelBox tail1;
    private final AdvancedModelBox tail2;
    private final AdvancedModelBox tail3;
    private final AdvancedModelBox tail4;
    private final AdvancedModelBox tail5;
    private final AdvancedModelBox tailend;
    private DynamicChain tail;
    public AdvancedModelBox[] tailOriginal;
    public AdvancedModelBox[] tailDynamic;

    public Wadjet_Model() {
        this.texWidth = 256;
        this.texHeight = 256;
        this.everything = new AdvancedModelBox((AdvancedEntityModel)this, "everything");
        this.everything.setRotationPoint(0.0f, 18.1769f, -2.6276f);
        this.mid_root = new AdvancedModelBox((AdvancedEntityModel)this, "mid_root");
        this.mid_root.setRotationPoint(0.0f, 5.8231f, 2.6276f);
        this.everything.addChild((BasicModelPart)this.mid_root);
        this.upper_body1 = new AdvancedModelBox((AdvancedEntityModel)this, "upper_body1");
        this.upper_body1.setRotationPoint(0.0f, -4.8231f, -0.6276f);
        this.mid_root.addChild((BasicModelPart)this.upper_body1);
        this.setRotationAngle(this.upper_body1, -0.2618f, 0.0f, 0.0f);
        this.upper_body1.setTextureOffset(0, 63).addBox(-5.5f, -17.8375f, -3.68f, 11.0f, 20.0f, 6.0f, 0.0f, false);
        this.pelvis = new AdvancedModelBox((AdvancedEntityModel)this, "pelvis");
        this.pelvis.setRotationPoint(-0.0798f, -17.8375f, 2.02f);
        this.upper_body1.addChild((BasicModelPart)this.pelvis);
        this.setRotationAngle(this.pelvis, 0.5716f, 0.0f, 0.0f);
        this.pelvis.setTextureOffset(0, 47).addBox(-4.5076f, -3.0225f, -5.0839f, 9.0f, 4.0f, 6.0f, 0.0f, false);
        this.upper_body2 = new AdvancedModelBox((AdvancedEntityModel)this, "upper_body2");
        this.upper_body2.setRotationPoint(-0.0076f, -2.9878f, 0.5324f);
        this.pelvis.addChild((BasicModelPart)this.upper_body2);
        this.setRotationAngle(this.upper_body2, -0.1814f, 0.0f, 0.0f);
        this.upper_body2.setTextureOffset(79, 63).addBox(-8.5403f, -15.7808f, -5.6395f, 17.0f, 7.2f, 8.0f, 0.0f, false);
        this.upper_body2.setTextureOffset(37, 0).addBox(-3.5403f, -13.7808f, -3.6395f, 7.0f, 14.2f, 4.0f, 0.0f, false);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this, "body");
        this.body.setRotationPoint(0.0492f, -6.6808f, 0.7605f);
        this.upper_body2.addChild((BasicModelPart)this.body);
        this.setRotationAngle(this.body, 0.0429f, 0.0f, 0.0f);
        this.neck1 = new AdvancedModelBox((AdvancedEntityModel)this, "neck1");
        this.neck1.setRotationPoint(0.0f, -8.5f, 0.0f);
        this.body.addChild((BasicModelPart)this.neck1);
        this.setRotationAngle(this.neck1, -0.2593f, 0.0f, 0.0f);
        this.neck1.setTextureOffset(112, 79).addBox(-4.3316f, -7.2976f, 0.0584f, 9.0f, 8.0f, 0.0f, 0.0f, false);
        this.neck1.setTextureOffset(0, 0).addBox(-2.3316f, -7.3252f, -3.9267f, 5.0f, 8.0f, 4.0f, 0.0f, false);
        this.neck2 = new AdvancedModelBox((AdvancedEntityModel)this, "neck2");
        this.neck2.setRotationPoint(0.3579f, -7.4995f, 1.0809f);
        this.neck1.addChild((BasicModelPart)this.neck2);
        this.setRotationAngle(this.neck2, 0.7854f, 0.0f, 0.0f);
        this.neck2.setTextureOffset(38, 63).addBox(-2.1895f, -8.4892f, -4.7357f, 4.0f, 8.0f, 4.0f, -0.1f, false);
        this.neck2.setTextureOffset(31, 26).addBox(-7.1895f, -7.5444f, -0.8563f, 14.0f, 9.0f, 0.0f, 0.0f, false);
        this.face = new AdvancedModelBox((AdvancedEntityModel)this, "face");
        this.face.setRotationPoint(-0.0895f, -6.8719f, -1.2524f);
        this.neck2.addChild((BasicModelPart)this.face);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this, "head");
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.face.addChild((BasicModelPart)this.head);
        this.setRotationAngle(this.head, -0.4363f, 0.0f, 0.0f);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(-1.6f, 8.0116f, -1.3235f);
        this.head.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.1745f, 0.0f, 0.0f);
        this.cube_r1.setTextureOffset(103, 0).addBox(-1.0f, -9.9f, -3.0f, 5.0f, 3.0f, 6.0f, 0.0f, false);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(1.4f, 1.0116f, -6.3235f);
        this.head.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.7195f, 0.4166f, 0.2315f);
        this.cube_r2.setTextureOffset(31, 47).addBox(-2.2863f, -1.9404f, -0.9425f, 3.0f, 3.0f, 8.0f, 0.0f, false);
        this.cube_r3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r3.setRotationPoint(-1.6f, 1.0116f, -6.3235f);
        this.head.addChild((BasicModelPart)this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.7195f, -0.4166f, -0.2315f);
        this.cube_r3.setTextureOffset(99, 99).addBox(-0.7137f, -1.9404f, -0.9425f, 3.0f, 3.0f, 8.0f, 0.0f, false);
        this.cube_r4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r4.setRotationPoint(-1.1f, 8.0116f, -1.3235f);
        this.head.addChild((BasicModelPart)this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.3491f, 0.0f, 0.0f);
        this.cube_r4.setTextureOffset(103, 20).addBox(-1.0f, -10.0f, -4.8f, 4.0f, 3.0f, 5.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this, "jaw");
        this.jaw.setRotationPoint(0.5895f, 0.9632f, -2.4564f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.setRotationAngle(this.jaw, 0.3927f, 0.0f, 0.0f);
        this.jaw.setTextureOffset(103, 10).addBox(-2.1895f, -1.0797f, -6.0886f, 3.0f, 2.0f, 7.0f, 0.0f, false);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this, "right_arm");
        this.right_arm.setRotationPoint(-5.3f, -5.8f, -2.4f);
        this.body.addChild((BasicModelPart)this.right_arm);
        this.setRotationAngle(this.right_arm, 0.0f, 0.5672f, -1.2654f);
        this.right_arm.setTextureOffset(65, 25).addBox(-9.9464f, -0.9857f, -1.7571f, 11.0f, 4.0f, 4.0f, 0.0f, false);
        this.right_fore_arm = new AdvancedModelBox((AdvancedEntityModel)this, "right_fore_arm");
        this.right_fore_arm.setRotationPoint(-9.9464f, -0.5213f, 0.1616f);
        this.right_arm.addChild((BasicModelPart)this.right_fore_arm);
        this.setRotationAngle(this.right_fore_arm, 0.0f, -0.6545f, 0.0f);
        this.right_fore_arm.setTextureOffset(0, 90).addBox(-11.0f, -0.4395f, -1.9186f, 11.0f, 3.0f, 4.0f, 0.0f, false);
        this.right_fore_arm.setTextureOffset(65, 0).addBox(-12.0f, -0.9395f, -2.4186f, 11.0f, 2.0f, 5.0f, 0.0f, false);
        this.right_finger3 = new AdvancedModelBox((AdvancedEntityModel)this, "right_finger3");
        this.right_finger3.setRotationPoint(-11.0f, 1.1f, -2.3f);
        this.right_fore_arm.addChild((BasicModelPart)this.right_finger3);
        this.right_finger3.setTextureOffset(0, 35).addBox(-6.0211f, -0.936f, 0.3767f, 6.0f, 2.0f, 0.0f, 0.0f, false);
        this.right_finger2 = new AdvancedModelBox((AdvancedEntityModel)this, "right_finger2");
        this.right_finger2.setRotationPoint(-11.0f, 1.1f, -0.3f);
        this.right_fore_arm.addChild((BasicModelPart)this.right_finger2);
        this.right_finger2.setTextureOffset(31, 36).addBox(-6.0211f, -0.936f, 0.3767f, 6.0f, 2.0f, 0.0f, 0.0f, false);
        this.right_finger1 = new AdvancedModelBox((AdvancedEntityModel)this, "right_finger1");
        this.right_finger1.setRotationPoint(-11.0f, 1.1f, 1.7f);
        this.right_fore_arm.addChild((BasicModelPart)this.right_finger1);
        this.right_finger1.setTextureOffset(0, 38).addBox(-6.0211f, -0.936f, 0.3767f, 6.0f, 2.0f, 0.0f, 0.0f, false);
        this.right_finger4 = new AdvancedModelBox((AdvancedEntityModel)this, "right_finger4");
        this.right_finger4.setRotationPoint(-10.0f, 2.5f, -2.7f);
        this.right_fore_arm.addChild((BasicModelPart)this.right_finger4);
        this.right_finger4.setTextureOffset(0, 16).addBox(-5.0211f, 0.164f, -0.7233f, 6.0f, 0.0f, 2.0f, 0.0f, false);
        this.wand = new AdvancedModelBox((AdvancedEntityModel)this, "wand");
        this.wand.setRotationPoint(-13.0f, 1.0f, 0.0f);
        this.right_fore_arm.addChild((BasicModelPart)this.wand);
        this.wand.setTextureOffset(0, 0).addBox(-1.0f, 0.0f, -25.0f, 2.0f, 2.0f, 60.0f, 0.0f, false);
        this.wand.setTextureOffset(65, 0).addBox(0.0f, -7.0f, -45.0f, 0.0f, 16.0f, 37.0f, 0.0f, false);
        this.cube_r5 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r5.setRotationPoint(13.0f, -1.0f, 0.0f);
        this.wand.addChild((BasicModelPart)this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, 0.0f, -1.5708f);
        this.cube_r5.setTextureOffset(0, 63).addBox(-2.0f, -20.0f, -45.0f, 0.0f, 16.0f, 37.0f, 0.0f, false);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this, "left_arm");
        this.left_arm.setRotationPoint(5.121f, -5.8f, -2.4f);
        this.body.addChild((BasicModelPart)this.left_arm);
        this.setRotationAngle(this.left_arm, 0.0f, -0.2618f, 1.2654f);
        this.left_arm.setTextureOffset(65, 16).addBox(-1.0905f, -0.9857f, -1.8408f, 11.0f, 4.0f, 4.0f, 0.0f, false);
        this.left_fore_arm = new AdvancedModelBox((AdvancedEntityModel)this, "left_fore_arm");
        this.left_fore_arm.setRotationPoint(9.9095f, -0.5213f, 0.0778f);
        this.left_arm.addChild((BasicModelPart)this.left_fore_arm);
        this.setRotationAngle(this.left_fore_arm, 0.0f, 0.6545f, 0.0f);
        this.left_fore_arm.setTextureOffset(38, 90).addBox(0.0f, -0.4395f, -1.9186f, 11.0f, 3.0f, 4.0f, 0.0f, false);
        this.left_fore_arm.setTextureOffset(65, 8).addBox(1.0f, -0.9395f, -2.4186f, 11.0f, 2.0f, 5.0f, 0.0f, false);
        this.left_finger3 = new AdvancedModelBox((AdvancedEntityModel)this, "left_finger3");
        this.left_finger3.setRotationPoint(11.0f, 1.1f, -2.3f);
        this.left_fore_arm.addChild((BasicModelPart)this.left_finger3);
        this.left_finger3.setTextureOffset(0, 32).addBox(0.0211f, -0.936f, 0.3767f, 6.0f, 2.0f, 0.0f, 0.0f, false);
        this.left_finger2 = new AdvancedModelBox((AdvancedEntityModel)this, "left_finger2");
        this.left_finger2.setRotationPoint(11.0f, 1.1f, -0.3f);
        this.left_fore_arm.addChild((BasicModelPart)this.left_finger2);
        this.left_finger2.setTextureOffset(0, 29).addBox(0.0211f, -0.936f, 0.3767f, 6.0f, 2.0f, 0.0f, 0.0f, false);
        this.left_finger1 = new AdvancedModelBox((AdvancedEntityModel)this, "left_finger1");
        this.left_finger1.setRotationPoint(11.0f, 1.1f, 1.7f);
        this.left_fore_arm.addChild((BasicModelPart)this.left_finger1);
        this.left_finger1.setTextureOffset(0, 26).addBox(0.0211f, -0.936f, 0.3767f, 6.0f, 2.0f, 0.0f, 0.0f, false);
        this.left_finger4 = new AdvancedModelBox((AdvancedEntityModel)this, "left_finger4");
        this.left_finger4.setRotationPoint(10.0f, 2.5f, -2.7f);
        this.left_fore_arm.addChild((BasicModelPart)this.left_finger4);
        this.left_finger4.setTextureOffset(0, 13).addBox(-0.9789f, 0.164f, -0.7233f, 6.0f, 0.0f, 2.0f, 0.0f, false);
        this.tail1 = new AdvancedModelBox((AdvancedEntityModel)this, "tail1");
        this.tail1.setRotationPoint(0.0f, -3.0f, -2.0f);
        this.mid_root.addChild((BasicModelPart)this.tail1);
        this.tail1.setTextureOffset(38, 63).addBox(-5.0f, -3.0f, 0.0f, 10.0f, 6.0f, 20.0f, 0.0f, false);
        this.tail2 = new AdvancedModelBox((AdvancedEntityModel)this, "tail2");
        this.tail2.setRotationPoint(0.0f, 0.5f, 18.0f);
        this.tail1.addChild((BasicModelPart)this.tail2);
        this.tail2.setTextureOffset(0, 0).addBox(-4.0f, -2.5f, 0.0f, 8.0f, 5.0f, 20.0f, 0.0f, false);
        this.tail3 = new AdvancedModelBox((AdvancedEntityModel)this, "tail3");
        this.tail3.setRotationPoint(0.0f, 0.5f, 18.0f);
        this.tail2.addChild((BasicModelPart)this.tail3);
        this.tail3.setTextureOffset(0, 26).addBox(-3.5f, -2.0f, 0.0f, 7.0f, 4.0f, 16.0f, 0.0f, false);
        this.tail4 = new AdvancedModelBox((AdvancedEntityModel)this, "tail4");
        this.tail4.setRotationPoint(-0.5f, 1.0f, 15.0f);
        this.tail3.addChild((BasicModelPart)this.tail4);
        this.tail4.setTextureOffset(83, 79).addBox(-2.5f, -2.0f, 0.0f, 6.0f, 3.0f, 16.0f, 0.0f, false);
        this.tail5 = new AdvancedModelBox((AdvancedEntityModel)this, "tail5");
        this.tail5.setRotationPoint(0.5f, 0.0f, 15.0f);
        this.tail4.addChild((BasicModelPart)this.tail5);
        this.tail5.setTextureOffset(75, 99).addBox(-2.0f, -1.0f, 0.0f, 4.0f, 2.0f, 15.0f, 0.0f, false);
        this.tailend = new AdvancedModelBox((AdvancedEntityModel)this, "tailend");
        this.tailend.setRotationPoint(0.0f, 0.0f, 15.0f);
        this.tail5.addChild((BasicModelPart)this.tailend);
        this.updateDefaultPose();
        this.tailOriginal = new AdvancedModelBox[]{this.tail1, this.tail2, this.tail3, this.tail4, this.tail5, this.tailend};
        this.tailDynamic = new AdvancedModelBox[this.tailOriginal.length];
    }

    public void animate(Wadjet_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.tail = entity.dc;
        this.resetToDefaultPose();
    }

    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, int alpha) {
        this.everything.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, alpha);
        if (this.tail != null) {
            this.tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, alpha, this.tailDynamic);
        }
        for (AdvancedModelBox AdvancedModelBox2 : this.tailOriginal) {
            AdvancedModelBox2.showModel = false;
        }
    }

    public void setupAnim(Wadjet_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float swimSpeed = 0.1f;
        float swimDegree = 0.5f;
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float attackProgress = entity.getAttackProgress(partialTick);
        float attackAmount = attackProgress * limbSwingAmount * 1.5f;
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(Wadjet_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.progressRotationPrev(this.upper_body1, attackAmount, (float)Math.toRadians(23.1591f), 0.0f, 0.0f, 10.0f);
        this.animate(entity.getAnimationState("idle"), Wadjet_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("sleep"), Wadjet_Animation.SLEEP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("awake"), Wadjet_Animation.AWAKE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("charge"), Wadjet_Animation.SPEAR_CHARGE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("magic"), Wadjet_Animation.MAGIC, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Wadjet_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("doubleswing"), Wadjet_Animation.DOUBLE_SWING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("stabnswing"), Wadjet_Animation.STAB_N_SWING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("block"), Wadjet_Animation.BLOCK, ageInTicks, 1.0f);
        this.chainSwing(this.tailOriginal, swimSpeed * 4.0f, swimDegree * 1.0f, -3.0, limbSwing, limbSwingAmount);
        this.chainSwing(this.tailOriginal, swimSpeed * 0.6f, swimDegree * 0.15f, -3.0, ageInTicks, 1.0f);
        entity.dc.updateChain(Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true), this.tailOriginal, this.tailDynamic, 0.4f, 1.5f, 1.8f, 0.87f, 20, true);
        if (!entity.getAwaken()) {
            this.applyStatic(Wadjet_Animation.SLEEP);
        }
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        float yawAmount = yRot / 57.295776f;
        float pitchAmount = xRot / 57.295776f;
        this.neck2.rotateAngleX += pitchAmount * 0.5f;
        this.neck2.rotateAngleY += yawAmount * 0.5f;
        this.face.rotateAngleX += pitchAmount * 0.5f;
        this.face.rotateAngleY += yawAmount * 0.5f;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public BasicModelPart root() {
        return this.everything;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.everything, (Object)this.upper_body1, (Object)this.mid_root, (Object)this.pelvis, (Object)this.upper_body2, (Object)this.body, (Object)this.neck1, (Object)this.neck2, (Object)this.face, (Object)this.head, (Object)this.cube_r1, (Object)this.cube_r2, (Object[])new AdvancedModelBox[]{this.cube_r3, this.cube_r4, this.jaw, this.right_arm, this.right_fore_arm, this.right_finger3, this.right_finger2, this.right_finger1, this.right_finger4, this.wand, this.cube_r5, this.left_arm, this.left_fore_arm, this.left_finger3, this.left_finger2, this.left_finger1, this.left_finger4, this.tail1, this.tail2, this.tail3, this.tail4, this.tail5, this.tailend});
    }
}

