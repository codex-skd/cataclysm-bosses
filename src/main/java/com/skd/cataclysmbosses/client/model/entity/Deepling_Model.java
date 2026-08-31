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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.Deepling.Deepling_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Deepling_Model
extends AdvancedEntityModel<Deepling_Entity> {
    public final AdvancedModelBox root;
    public final AdvancedModelBox left_leg;
    public final AdvancedModelBox right_leg;
    public final AdvancedModelBox body;
    public final AdvancedModelBox headwear;
    public final AdvancedModelBox head;
    public final AdvancedModelBox head2;
    public final AdvancedModelBox r_fin;
    public final AdvancedModelBox l_fin;
    public final AdvancedModelBox right_arm;
    public final AdvancedModelBox left_arm;
    private ModelAnimator animator;
    public boolean riding;

    public Deepling_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg.setRotationPoint(2.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.left_leg);
        this.left_leg.setTextureOffset(40, 0).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 20.0f, 2.0f, 0.0f, false);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg.setRotationPoint(-2.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.right_leg);
        this.right_leg.setTextureOffset(44, 22).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 20.0f, 2.0f, 0.0f, false);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(0, 32).addBox(-5.0f, -11.0f, -2.0f, 10.0f, 11.0f, 4.0f, 0.0f, false);
        this.body.setTextureOffset(52, 29).addBox(0.0f, -11.0f, 2.0f, 0.0f, 11.0f, 4.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -11.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.head);
        this.head2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head2.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.head2);
        this.head2.setTextureOffset(0, 16).addBox(-6.0f, -4.0f, -4.0f, 12.0f, 8.0f, 8.0f, 0.0f, false);
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
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm.setRotationPoint(-6.0f, -10.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.right_arm);
        this.right_arm.setTextureOffset(36, 32).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 24.0f, 2.0f, 0.0f, false);
        this.right_arm.setTextureOffset(12, 47).addBox(-4.0f, 1.0f, 0.0f, 3.0f, 12.0f, 0.0f, 0.0f, false);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm.setRotationPoint(6.0f, -10.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.left_arm);
        this.left_arm.setTextureOffset(28, 32).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 24.0f, 2.0f, 0.0f, false);
        this.left_arm.setTextureOffset(18, 47).addBox(1.0f, 1.0f, 0.0f, 3.0f, 12.0f, 0.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.left_leg, this.right_leg, this.body, this.headwear, this.head, this.head2, this.r_fin, this.l_fin, this.right_arm, this.left_arm);
    }

    public void animate(Deepling_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Deepling_Entity.DEEPLING_TRIDENT_THROW);
        if (entity.isLeftHanded()) {
            this.animator.startKeyframe(10);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-55.0), (float)Math.toRadians(10.0), (float)Math.toRadians(7.5));
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-200.0), (float)Math.toRadians(-15.0), (float)Math.toRadians(35.0));
            this.animator.rotate(this.head, (float)Math.toRadians(-7.5), (float)Math.toRadians(10.5), (float)Math.toRadians(7.5));
            this.animator.rotate(this.body, (float)Math.toRadians(-10.0), (float)Math.toRadians(-15.0), (float)Math.toRadians(-7.5));
            this.animator.endKeyframe();
            this.animator.startKeyframe(2);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-55.5), (float)Math.toRadians(5.0), (float)Math.toRadians(50.0));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-7.5), (float)Math.toRadians(12.5), (float)Math.toRadians(22.5));
            this.animator.rotate(this.head, (float)Math.toRadians(5.0), (float)Math.toRadians(10.0), (float)Math.toRadians(5.0));
            this.animator.rotate(this.body, (float)Math.toRadians(22.5), (float)Math.toRadians(30.0), (float)Math.toRadians(-7.5));
            this.animator.endKeyframe();
            this.animator.resetKeyframe(28);
        } else {
            this.animator.startKeyframe(10);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-55.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(-7.5));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-200.0), (float)Math.toRadians(15.0), (float)Math.toRadians(-35.0));
            this.animator.rotate(this.head, (float)Math.toRadians(-7.5), (float)Math.toRadians(-10.5), (float)Math.toRadians(-7.5));
            this.animator.rotate(this.body, (float)Math.toRadians(-10.0), (float)Math.toRadians(15.0), (float)Math.toRadians(7.5));
            this.animator.endKeyframe();
            this.animator.startKeyframe(2);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-7.5), (float)Math.toRadians(-12.5), (float)Math.toRadians(-22.5));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-55.5), (float)Math.toRadians(-5.0), (float)Math.toRadians(-50.0));
            this.animator.rotate(this.head, (float)Math.toRadians(5.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(-5.0));
            this.animator.rotate(this.body, (float)Math.toRadians(22.5), (float)Math.toRadians(-30.0), (float)Math.toRadians(7.5));
            this.animator.endKeyframe();
            this.animator.resetKeyframe(28);
        }
        this.animator.setAnimation(Deepling_Entity.DEEPLING_MELEE);
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
    }

    public void setupAnim(Deepling_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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

