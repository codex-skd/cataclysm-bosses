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
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.AnimationMonster.Endermaptera_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;

public class Endermaptera_Model
extends AdvancedEntityModel<Endermaptera_Entity> {
    public final AdvancedModelBox root;
    public final AdvancedModelBox body;
    public final AdvancedModelBox abdomen;
    public final AdvancedModelBox head;
    public final AdvancedModelBox head_left;
    public final AdvancedModelBox head_right;
    public final AdvancedModelBox head_top;
    public final AdvancedModelBox left_antenna;
    public final AdvancedModelBox right_antenna;
    public final AdvancedModelBox right_jaw;
    public final AdvancedModelBox left_jaw;
    public final AdvancedModelBox right_leg_front;
    public final AdvancedModelBox left_leg_front;
    public final AdvancedModelBox right_leg_mid;
    public final AdvancedModelBox left_leg_mid;
    public final AdvancedModelBox right_leg_back;
    public final AdvancedModelBox left_leg_back;
    private ModelAnimator animator;

    public Endermaptera_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(22, 15).addBox(-3.0f, -4.0f, -2.0f, 6.0f, 4.0f, 4.0f, 0.0f, false);
        this.body.setTextureOffset(0, 0).addBox(0.0f, -7.0f, -2.0f, 0.0f, 3.0f, 4.0f, 0.0f, false);
        this.abdomen = new AdvancedModelBox((AdvancedEntityModel)this);
        this.abdomen.setRotationPoint(0.0f, -2.0f, 1.0f);
        this.body.addChild((BasicModelPart)this.abdomen);
        this.setRotationAngle(this.abdomen, 0.2618f, 0.0f, 0.0f);
        this.abdomen.setTextureOffset(0, 15).addBox(-3.0f, -2.5f, 0.5f, 6.0f, 5.0f, 9.0f, 0.5f, false);
        this.abdomen.setTextureOffset(0, 0).addBox(-3.0f, -2.5f, 0.5f, 6.0f, 5.0f, 9.0f, 0.25f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -0.85f, -4.5f);
        this.body.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(29, 34).addBox(-1.5f, -2.15f, -0.5f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.head_left = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head_left.setRotationPoint(2.0f, -0.15f, 1.0f);
        this.head.addChild((BasicModelPart)this.head_left);
        this.setRotationAngle(this.head_left, 0.2618f, 0.2618f, 0.2618f);
        this.head_left.setTextureOffset(0, 37).addBox(-1.5f, -1.0f, -1.5f, 2.0f, 2.0f, 3.0f, 0.25f, false);
        this.head_right = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head_right.setRotationPoint(-2.0f, -0.15f, 1.0f);
        this.head.addChild((BasicModelPart)this.head_right);
        this.setRotationAngle(this.head_right, 0.2618f, -0.2618f, -0.2618f);
        this.head_right.setTextureOffset(0, 37).addBox(-0.5f, -1.0f, -1.5f, 2.0f, 2.0f, 3.0f, 0.25f, true);
        this.head_top = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head_top.setRotationPoint(0.0f, -3.95f, 1.0f);
        this.head.addChild((BasicModelPart)this.head_top);
        this.setRotationAngle(this.head_top, 0.5236f, 0.0f, 0.0f);
        this.head_top.setTextureOffset(0, 30).addBox(-2.0f, 0.8f, -3.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.left_antenna = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_antenna.setRotationPoint(-1.0f, -1.15f, -0.5f);
        this.head.addChild((BasicModelPart)this.left_antenna);
        this.setRotationAngle(this.left_antenna, 0.0f, 0.48f, 0.0f);
        this.left_antenna.setTextureOffset(24, 24).addBox(-1.0f, -2.0f, -6.0f, 1.0f, 2.0f, 7.0f, 0.0f, false);
        this.right_antenna = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_antenna.setRotationPoint(1.0f, -1.15f, -0.5f);
        this.head.addChild((BasicModelPart)this.right_antenna);
        this.setRotationAngle(this.right_antenna, 0.0f, -0.48f, 0.0f);
        this.right_antenna.setTextureOffset(24, 24).addBox(0.0f, -2.0f, -6.0f, 1.0f, 2.0f, 7.0f, 0.0f, true);
        this.right_jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_jaw.setRotationPoint(-1.5f, 0.65f, 1.5f);
        this.head.addChild((BasicModelPart)this.right_jaw);
        this.right_jaw.setTextureOffset(12, 32).addBox(-2.0f, 0.0f, -5.0f, 3.0f, 0.0f, 5.0f, 0.0f, false);
        this.left_jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_jaw.setRotationPoint(1.5f, 0.65f, 1.5f);
        this.head.addChild((BasicModelPart)this.left_jaw);
        this.left_jaw.setTextureOffset(31, 9).addBox(-1.0f, 0.0f, -5.0f, 3.0f, 0.0f, 5.0f, 0.0f, false);
        this.right_leg_front = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg_front.setRotationPoint(-3.0f, -1.0f, -1.0f);
        this.body.addChild((BasicModelPart)this.right_leg_front);
        this.setRotationAngle(this.right_leg_front, 0.0f, -0.5672f, 0.0f);
        this.right_leg_front.setTextureOffset(34, 24).addBox(-7.0f, -4.0f, 0.0f, 7.0f, 6.0f, 0.0f, 0.0f, true);
        this.left_leg_front = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg_front.setRotationPoint(3.0f, -1.0f, -1.0f);
        this.body.addChild((BasicModelPart)this.left_leg_front);
        this.setRotationAngle(this.left_leg_front, 0.0f, 0.5672f, 0.0f);
        this.left_leg_front.setTextureOffset(34, 24).addBox(0.0f, -4.0f, 0.0f, 7.0f, 6.0f, 0.0f, 0.0f, false);
        this.right_leg_mid = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg_mid.setRotationPoint(-3.0f, -1.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.right_leg_mid);
        this.right_leg_mid.setTextureOffset(34, 24).addBox(-7.0f, -4.0f, 0.0f, 7.0f, 6.0f, 0.0f, 0.0f, true);
        this.left_leg_mid = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg_mid.setRotationPoint(3.0f, -1.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.left_leg_mid);
        this.left_leg_mid.setTextureOffset(34, 24).addBox(0.0f, -4.0f, 0.0f, 7.0f, 6.0f, 0.0f, 0.0f, false);
        this.right_leg_back = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg_back.setRotationPoint(-3.0f, -1.0f, 1.0f);
        this.body.addChild((BasicModelPart)this.right_leg_back);
        this.setRotationAngle(this.right_leg_back, 0.0f, 0.5672f, 0.0f);
        this.right_leg_back.setTextureOffset(22, 0).addBox(-10.0f, -6.0f, 0.0f, 10.0f, 8.0f, 0.0f, 0.0f, true);
        this.left_leg_back = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg_back.setRotationPoint(3.0f, -1.0f, 1.0f);
        this.body.addChild((BasicModelPart)this.left_leg_back);
        this.setRotationAngle(this.left_leg_back, 0.0f, -0.5672f, 0.0f);
        this.left_leg_back.setTextureOffset(22, 0).addBox(0.0f, -6.0f, 0.0f, 10.0f, 8.0f, 0.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update(entity);
        this.animator.setAnimation(Endermaptera_Entity.JAW_ATTACK);
        this.animator.startKeyframe(5);
        this.animator.rotate(this.right_jaw, 0.0f, (float)Math.toRadians(30.0), 0.0f);
        this.animator.rotate(this.left_jaw, 0.0f, (float)Math.toRadians(-30.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.resetKeyframe(3);
        this.animator.setAnimation(Endermaptera_Entity.HEADBUTT_ATTACK);
        this.animator.startKeyframe(5);
        this.animator.move(this.body, 0.0f, 0.0f, -5.0f);
        this.animator.rotate(this.head, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
        this.animator.rotate(this.abdomen, (float)Math.toRadians(25.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_antenna, (float)Math.toRadians(-25.0), (float)Math.toRadians(-25.0), 0.0f);
        this.animator.rotate(this.right_antenna, (float)Math.toRadians(-25.0), (float)Math.toRadians(25.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.move(this.body, 0.0f, 0.0f, 2.0f);
        this.animator.rotate(this.head, (float)Math.toRadians(25.0), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.resetKeyframe(3);
    }

    public void setupAnim(Endermaptera_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float idleSpeed = 0.25f;
        float idleDegree = 0.25f;
        float walkSpeed = 1.0f;
        float walkDegree = 1.0f;
        float offsetleft = 2.0f;
        this.swing(this.left_antenna, idleSpeed, idleDegree, true, 1.0f, 0.1f, ageInTicks, 1.0f);
        this.swing(this.right_antenna, idleSpeed, idleDegree, false, 1.0f, 0.1f, ageInTicks, 1.0f);
        this.walk(this.left_antenna, idleSpeed, idleDegree * 0.25f, false, -1.0f, -0.05f, ageInTicks, 1.0f);
        this.walk(this.right_antenna, idleSpeed, idleDegree * 0.25f, false, -1.0f, -0.05f, ageInTicks, 1.0f);
        this.swing(this.left_leg_back, walkSpeed, walkDegree, false, 0.0f, -0.5f, limbSwing, limbSwingAmount);
        this.swing(this.right_leg_front, walkSpeed, walkDegree, false, 0.0f, -0.3f, limbSwing, limbSwingAmount);
        this.flap(this.right_leg_front, walkSpeed, walkDegree * 0.8f, false, -1.5f, 0.4f, limbSwing, limbSwingAmount);
        this.swing(this.left_leg_mid, walkSpeed, walkDegree, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.flap(this.left_leg_mid, walkSpeed, walkDegree * 0.8f, false, -1.5f, -0.4f, limbSwing, limbSwingAmount);
        this.swing(this.right_leg_back, walkSpeed, -walkDegree, false, offsetleft, 0.5f, limbSwing, limbSwingAmount);
        this.swing(this.left_leg_front, walkSpeed, -walkDegree, false, offsetleft, 0.3f, limbSwing, limbSwingAmount);
        this.flap(this.left_leg_front, walkSpeed, walkDegree * 0.8f, false, offsetleft + 1.5f, -0.4f, limbSwing, limbSwingAmount);
        this.swing(this.right_leg_mid, walkSpeed, -walkDegree, false, offsetleft, 0.0f, limbSwing, limbSwingAmount);
        this.flap(this.right_leg_mid, walkSpeed, walkDegree * 0.8f, false, offsetleft - 1.5f, 0.4f, limbSwing, limbSwingAmount);
        this.swing(this.abdomen, walkSpeed, walkDegree * 0.2f, false, 3.0f, 0.0f, limbSwing, limbSwingAmount);
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        this.right_jaw.showModel = entity.getHasJaws();
        this.left_jaw.showModel = entity.getHasJaws();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.head, (Object)this.body, (Object)this.abdomen, (Object)this.left_antenna, (Object)this.right_antenna, (Object)this.left_jaw, (Object)this.right_jaw, (Object)this.left_leg_front, (Object)this.right_leg_front, (Object)this.left_leg_mid, (Object)this.right_leg_mid, (Object[])new AdvancedModelBox[]{this.left_leg_back, this.right_leg_back});
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

