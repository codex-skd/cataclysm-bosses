/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.Animations.ModelAnimator
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.Minecraft
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.entity.Deepling.Deepling_Angler_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Deepling_Angler_Model
extends AdvancedEntityModel<Deepling_Angler_Entity> {
    public final AdvancedModelBox root;
    public final AdvancedModelBox left_leg;
    public final AdvancedModelBox right_leg;
    public final AdvancedModelBox body;
    private final AdvancedModelBox thorns;
    private final AdvancedModelBox thorns2;
    private final AdvancedModelBox thorns3;
    private final AdvancedModelBox thorns4;
    public final AdvancedModelBox head;
    public final AdvancedModelBox head2;
    public final AdvancedModelBox r_fin;
    public final AdvancedModelBox l_fin;
    public final AdvancedModelBox headwear;
    public final AdvancedModelBox right_arm;
    public final AdvancedModelBox left_arm;
    public ModelAnimator animator;

    public Deepling_Angler_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg.setRotationPoint(2.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.left_leg);
        this.left_leg.setTextureOffset(40, 0).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 20.0f, 2.0f, 0.0f, false);
        this.left_leg.setTextureOffset(44, 58).addBox(0.0f, 1.0f, -2.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.left_leg.setTextureOffset(44, 58).addBox(0.0f, 0.0f, 1.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg.setRotationPoint(-2.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.right_leg);
        this.right_leg.setTextureOffset(44, 22).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 20.0f, 2.0f, 0.0f, false);
        this.right_leg.setTextureOffset(44, 58).addBox(0.0f, 1.0f, -2.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.right_leg.setTextureOffset(44, 58).addBox(0.0f, 0.0f, 1.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(0, 32).addBox(-5.0f, -11.0f, -2.0f, 10.0f, 11.0f, 4.0f, 0.0f, false);
        this.body.setTextureOffset(52, 25).addBox(0.0f, -11.0f, 2.0f, 0.0f, 11.0f, 8.0f, 0.0f, false);
        this.thorns = new AdvancedModelBox((AdvancedEntityModel)this);
        this.thorns.setRotationPoint(-3.0f, -5.5f, 2.0f);
        this.body.addChild((BasicModelPart)this.thorns);
        this.setRotationAngle(this.thorns, 0.0f, -0.6545f, 0.0f);
        this.thorns.setTextureOffset(52, 37).addBox(0.0f, -5.5f, 0.0f, 0.0f, 11.0f, 8.0f, 0.0f, false);
        this.thorns2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.thorns2.setRotationPoint(3.0f, -5.5f, 2.0f);
        this.body.addChild((BasicModelPart)this.thorns2);
        this.setRotationAngle(this.thorns2, 0.0f, 0.6545f, 0.0f);
        this.thorns2.setTextureOffset(52, 37).addBox(0.0f, -5.5f, 0.0f, 0.0f, 11.0f, 8.0f, 0.0f, false);
        this.thorns3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.thorns3.setRotationPoint(-5.0f, -4.5f, -2.0f);
        this.body.addChild((BasicModelPart)this.thorns3);
        this.setRotationAngle(this.thorns3, 0.0f, -0.9599f, 0.0f);
        this.thorns3.setTextureOffset(18, 57).addBox(0.0f, -5.5f, -4.0f, 0.0f, 11.0f, 4.0f, 0.0f, false);
        this.thorns4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.thorns4.setRotationPoint(5.0f, -4.5f, -2.0f);
        this.body.addChild((BasicModelPart)this.thorns4);
        this.setRotationAngle(this.thorns4, 0.0f, 0.9599f, 0.0f);
        this.thorns4.setTextureOffset(18, 57).addBox(0.0f, -5.5f, -4.0f, 0.0f, 11.0f, 4.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -11.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.head);
        this.head2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head2.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.head2);
        this.head2.setTextureOffset(25, 94).addBox(-6.0f, -4.0f, -4.0f, 12.0f, 8.0f, 8.0f, -0.2f, false);
        this.head2.setTextureOffset(0, 16).addBox(-6.0f, -4.0f, -4.0f, 12.0f, 8.0f, 8.0f, 0.0f, false);
        this.head2.setTextureOffset(37, 74).addBox(-6.0f, -8.0f, -4.0f, 2.0f, 4.0f, 0.0f, 0.0f, false);
        this.head2.setTextureOffset(37, 74).addBox(4.0f, -8.0f, -4.0f, 2.0f, 4.0f, 0.0f, 0.0f, true);
        this.r_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.r_fin.setRotationPoint(-6.0f, 0.0f, 0.0f);
        this.head2.addChild((BasicModelPart)this.r_fin);
        this.r_fin.setTextureOffset(44, 44).addBox(-6.0f, -7.0f, 0.0f, 6.0f, 8.0f, 0.0f, 0.0f, false);
        this.l_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.l_fin.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.head2.addChild((BasicModelPart)this.l_fin);
        this.l_fin.setTextureOffset(0, 47).addBox(0.0f, -7.0f, 0.0f, 6.0f, 8.0f, 0.0f, 0.0f, false);
        this.headwear = new AdvancedModelBox((AdvancedEntityModel)this);
        this.headwear.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.headwear);
        this.headwear.setTextureOffset(0, 0).addBox(-6.0f, -7.0f, -4.0f, 12.0f, 8.0f, 8.0f, -0.5f, false);
        this.headwear.setTextureOffset(17, 78).addBox(-6.0f, -7.0f, -4.0f, 12.0f, 8.0f, 8.0f, -0.7f, false);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm.setRotationPoint(-6.0f, -10.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.right_arm);
        this.right_arm.setTextureOffset(36, 32).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 24.0f, 2.0f, 0.0f, false);
        this.right_arm.setTextureOffset(52, 24).addBox(-0.5f, 23.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, false);
        this.right_arm.setTextureOffset(44, 58).addBox(0.0f, 1.0f, -2.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.right_arm.setTextureOffset(44, 58).addBox(0.0f, 1.0f, 1.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.right_arm.setTextureOffset(36, 58).addBox(0.0f, 20.0f, 1.0f, 0.0f, 2.0f, 2.0f, 0.0f, false);
        this.right_arm.setTextureOffset(36, 56).addBox(0.0f, 20.0f, -3.0f, 0.0f, 2.0f, 2.0f, 0.0f, false);
        this.right_arm.setTextureOffset(38, 64).addBox(-3.0f, 20.0f, 0.0f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.right_arm.setTextureOffset(38, 62).addBox(1.0f, 20.0f, 0.0f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.right_arm.setTextureOffset(28, 58).addBox(-5.0f, 13.0f, 0.0f, 4.0f, 7.0f, 0.0f, 0.0f, true);
        this.right_arm.setTextureOffset(18, 47).addBox(-6.0f, -1.0f, 0.0f, 5.0f, 14.0f, 0.0f, 0.0f, true);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm.setRotationPoint(6.0f, -10.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.left_arm);
        this.left_arm.setTextureOffset(28, 32).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 24.0f, 2.0f, 0.0f, false);
        this.left_arm.setTextureOffset(52, 24).addBox(-0.5f, 23.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, false);
        this.left_arm.setTextureOffset(44, 58).addBox(0.0f, 1.0f, 1.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.left_arm.setTextureOffset(44, 58).addBox(0.0f, 1.0f, -2.0f, 0.0f, 17.0f, 1.0f, 0.0f, false);
        this.left_arm.setTextureOffset(36, 56).addBox(0.0f, 20.0f, -3.0f, 0.0f, 2.0f, 2.0f, 0.0f, false);
        this.left_arm.setTextureOffset(38, 62).addBox(1.0f, 20.0f, 0.0f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.left_arm.setTextureOffset(38, 64).addBox(-3.0f, 20.0f, 0.0f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.left_arm.setTextureOffset(36, 58).addBox(0.0f, 20.0f, 1.0f, 0.0f, 2.0f, 2.0f, 0.0f, false);
        this.left_arm.setTextureOffset(18, 47).addBox(1.0f, -1.0f, 0.0f, 5.0f, 14.0f, 0.0f, 0.0f, false);
        this.left_arm.setTextureOffset(28, 58).addBox(1.0f, 13.0f, 0.0f, 4.0f, 7.0f, 0.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.left_leg, (Object)this.right_leg, (Object)this.body, (Object)this.headwear, (Object)this.head, (Object)this.head2, (Object)this.r_fin, (Object)this.l_fin, (Object)this.right_arm, (Object)this.left_arm, (Object)this.thorns, (Object[])new AdvancedModelBox[]{this.thorns2, this.thorns3, this.thorns4});
    }

    public void animate(Deepling_Angler_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Deepling_Angler_Entity.DEEPLING_MELEE);
        if (entity.isLeftHanded()) {
            this.animator.startKeyframe(4);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(12.5), 0.0f, (float)Math.toRadians(10.0));
            this.animator.rotate(this.left_arm, 0.0f, 0.0f, (float)Math.toRadians(-75.0));
            this.animator.rotate(this.body, (float)Math.toRadians(-12.5), (float)Math.toRadians(-10.0), (float)Math.toRadians(12.5));
            this.animator.endKeyframe();
            this.animator.startKeyframe(2);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(15.0), 0.0f, (float)Math.toRadians(10.0));
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-107.5), (float)Math.toRadians(12.5), (float)Math.toRadians(-77.5));
            this.animator.rotate(this.body, (float)Math.toRadians(30.0), (float)Math.toRadians(30.0), (float)Math.toRadians(7.5));
            this.animator.endKeyframe();
            this.animator.resetKeyframe(14);
        } else {
            this.animator.startKeyframe(4);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(12.5), 0.0f, (float)Math.toRadians(-10.0));
            this.animator.rotate(this.right_arm, 0.0f, 0.0f, (float)Math.toRadians(75.0));
            this.animator.rotate(this.body, (float)Math.toRadians(-12.5), (float)Math.toRadians(10.0), (float)Math.toRadians(-12.5));
            this.animator.endKeyframe();
            this.animator.startKeyframe(2);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(15.0), 0.0f, (float)Math.toRadians(-10.0));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-107.5), (float)Math.toRadians(-12.5), (float)Math.toRadians(77.5));
            this.animator.rotate(this.body, (float)Math.toRadians(30.0), (float)Math.toRadians(-30.0), (float)Math.toRadians(-7.5));
            this.animator.endKeyframe();
            this.animator.resetKeyframe(14);
        }
        this.animator.setAnimation(Deepling_Angler_Entity.DEEPLING_HUG);
        this.animator.startKeyframe(5);
        this.animator.rotate(this.body, (float)Math.toRadians(-17.5), 0.0f, 0.0f);
        this.animator.rotate(this.head, (float)Math.toRadians(32.5), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-37.5), 0.0f, (float)Math.toRadians(55.0));
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-37.5), 0.0f, (float)Math.toRadians(-55.0));
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.rotate(this.body, (float)Math.toRadians(40.0), 0.0f, 0.0f);
        this.animator.rotate(this.head, (float)Math.toRadians(82.5), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-130.0), (float)Math.toRadians(-37.5), (float)Math.toRadians(80.0));
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-130.0), (float)Math.toRadians(37.5), (float)Math.toRadians(-80.0));
        this.animator.endKeyframe();
        this.animator.resetKeyframe(10);
    }

    public void setupAnim(Deepling_Angler_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float swim = entity.getSwimAmount(partialTick);
        float walkSpeed = 1.0f;
        float walkDegree = 1.0f;
        float swimSpeed = 0.25f;
        float swimDegree = 0.5f;
        float swimAmount = limbSwingAmount * swim;
        this.walk(this.left_leg, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_leg, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.left_arm, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_arm, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.progressRotationPrev(this.left_arm, swim, 0.0f, 0.0f, (float)Math.toRadians(-37.5), 10.0f);
        this.progressRotationPrev(this.right_arm, swim, 0.0f, 0.0f, (float)Math.toRadians(37.5), 10.0f);
        this.progressRotationPrev(this.root, swim, (float)Math.toRadians(80.0), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.head, swim, (float)Math.toRadians(-70.0), 0.0f, 0.0f, 1.0f);
        this.progressPositionPrev(this.root, swim, 0.0f, -5.0f, 18.0f, 1.0f);
        this.flap(this.root, swimSpeed, swimDegree * 1.0f, true, 0.0f, 0.0f, limbSwing, swimAmount);
        this.swing(this.head, swimSpeed, swimDegree * 1.0f, false, 0.5f, 0.0f, limbSwing, swimAmount);
        this.flap(this.left_arm, swimSpeed, swimDegree * 2.75f, true, -0.5f, 1.5f, limbSwing, swimAmount);
        this.swing(this.left_arm, swimSpeed, swimDegree, true, -1.5f, 0.0f, limbSwing, swimAmount);
        this.walk(this.left_arm, swimSpeed, swimDegree, true, -2.0f, -0.2f, limbSwing, swimAmount);
        this.flap(this.right_arm, swimSpeed, swimDegree * 2.75f, false, -0.5f, 1.5f, limbSwing, swimAmount);
        this.swing(this.right_arm, swimSpeed, swimDegree, false, -1.5f, 0.0f, limbSwing, swimAmount);
        this.walk(this.right_arm, swimSpeed, swimDegree, false, -4.5f, -0.2f, limbSwing, swimAmount);
        this.walk(this.right_leg, swimSpeed * 1.5f, swimDegree * 1.0f, true, 2.0f, 0.0f, limbSwing, swimAmount);
        this.walk(this.left_leg, swimSpeed * 1.5f, swimDegree * 1.0f, false, 2.0f, 0.0f, limbSwing, swimAmount);
        if (this.riding) {
            this.root.rotationPointY += 13.0f;
            this.right_arm.rotateAngleX += -0.62831855f;
            this.left_arm.rotateAngleX += -0.62831855f;
            this.right_leg.rotateAngleX = -1.4137167f;
            this.right_leg.rotateAngleY = 0.31415927f;
            this.right_leg.rotateAngleZ = 0.07853982f;
            this.left_leg.rotateAngleX = -1.4137167f;
            this.left_leg.rotateAngleY = -0.31415927f;
            this.left_leg.rotateAngleZ = -0.07853982f;
        }
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

