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

import com.skd.cataclysmbosses.entity.Deepling.Coral_Golem_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Coral_Golem_Model
extends AdvancedEntityModel<Coral_Golem_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox lower_body;
    private final AdvancedModelBox upper_body;
    private final AdvancedModelBox helmet;
    private final AdvancedModelBox chest;
    private final AdvancedModelBox table_coral;
    private final AdvancedModelBox blue_table_coral;
    private final AdvancedModelBox red_table_coral;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox right_fist;
    private final AdvancedModelBox right_coral;
    private final AdvancedModelBox left_arm;
    private final AdvancedModelBox left_fist;
    private final AdvancedModelBox left_coral;
    private final AdvancedModelBox coral_shoulder;
    private final AdvancedModelBox head;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox left_leg;
    private ModelAnimator animator;

    public Coral_Golem_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.lower_body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.lower_body.setRotationPoint(0.0f, -6.3f, -1.8f);
        this.root.addChild((BasicModelPart)this.lower_body);
        this.setRotationAngle(this.lower_body, 0.1745f, 0.0f, 0.0f);
        this.lower_body.setTextureOffset(0, 21).addBox(-6.0f, -8.0f, -4.0f, 12.0f, 8.0f, 8.0f, 0.0f, false);
        this.upper_body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upper_body.setRotationPoint(0.0f, -6.2f, 2.8f);
        this.lower_body.addChild((BasicModelPart)this.upper_body);
        this.setRotationAngle(this.upper_body, 0.6981f, 0.0f, 0.0f);
        this.helmet = new AdvancedModelBox((AdvancedEntityModel)this);
        this.helmet.setRotationPoint(-0.5f, -11.0f, -6.5f);
        this.upper_body.addChild((BasicModelPart)this.helmet);
        this.setRotationAngle(this.helmet, -0.6109f, 0.0f, 0.0f);
        this.helmet.setTextureOffset(54, 59).addBox(-3.5f, -7.5f, -3.5f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.helmet.setTextureOffset(89, 31).addBox(4.5f, -6.5f, -2.5f, 1.0f, 6.0f, 6.0f, 0.0f, false);
        this.helmet.setTextureOffset(87, 66).addBox(-4.5f, -6.5f, -2.5f, 1.0f, 6.0f, 6.0f, 0.0f, false);
        this.helmet.setTextureOffset(35, 32).addBox(-6.5f, -0.5f, -2.5f, 14.0f, 7.0f, 6.0f, 0.0f, false);
        this.helmet.setTextureOffset(21, 78).addBox(5.5f, -1.5f, -3.5f, 2.0f, 5.0f, 8.0f, 0.0f, false);
        this.helmet.setTextureOffset(65, 76).addBox(-6.5f, -1.5f, -3.5f, 2.0f, 5.0f, 8.0f, 0.0f, false);
        this.helmet.setTextureOffset(47, 0).addBox(-1.5f, -8.5f, -1.5f, 4.0f, 1.0f, 4.0f, 0.0f, false);
        this.helmet.setTextureOffset(86, 0).addBox(0.5f, -14.25f, 0.5f, 9.0f, 9.0f, 0.0f, 0.0f, false);
        this.chest = new AdvancedModelBox((AdvancedEntityModel)this);
        this.chest.setRotationPoint(0.0f, -3.5f, -3.0f);
        this.upper_body.addChild((BasicModelPart)this.chest);
        this.chest.setTextureOffset(0, 0).addBox(-9.0f, -6.5f, -4.75f, 18.0f, 10.0f, 10.0f, 0.0f, false);
        this.table_coral = new AdvancedModelBox((AdvancedEntityModel)this);
        this.table_coral.setRotationPoint(8.0f, -2.0f, 5.0f);
        this.chest.addChild((BasicModelPart)this.table_coral);
        this.table_coral.setTextureOffset(46, 24).addBox(-1.0f, -2.0f, -2.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.table_coral.setTextureOffset(59, 23).addBox(-1.0f, 1.0f, -2.0f, 3.0f, 1.0f, 3.0f, 0.0f, false);
        this.blue_table_coral = new AdvancedModelBox((AdvancedEntityModel)this);
        this.blue_table_coral.setRotationPoint(-5.0f, -3.0f, 0.0f);
        this.table_coral.addChild((BasicModelPart)this.blue_table_coral);
        this.blue_table_coral.setTextureOffset(44, 76).addBox(0.0f, -5.5f, -1.75f, 0.0f, 10.0f, 10.0f, 0.0f, false);
        this.red_table_coral = new AdvancedModelBox((AdvancedEntityModel)this);
        this.red_table_coral.setRotationPoint(-3.0f, -3.0f, 0.0f);
        this.table_coral.addChild((BasicModelPart)this.red_table_coral);
        this.red_table_coral.setTextureOffset(78, 82).addBox(0.0f, -4.5f, 0.25f, 0.0f, 8.0f, 8.0f, 0.0f, false);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm.setRotationPoint(-9.0f, -6.7f, -1.7f);
        this.chest.addChild((BasicModelPart)this.right_arm);
        this.setRotationAngle(this.right_arm, -0.6109f, 0.0f, 0.0f);
        this.right_arm.setTextureOffset(57, 0).addBox(-6.0f, -4.0f, -4.0f, 6.0f, 14.0f, 8.0f, 0.0f, false);
        this.right_arm.setTextureOffset(29, 46).addBox(-7.1f, 2.0f, -5.0f, 9.0f, 2.0f, 10.0f, 0.0f, false);
        this.right_arm.setTextureOffset(76, 13).addBox(-0.1f, -5.0f, -5.0f, 2.0f, 7.0f, 10.0f, 0.0f, false);
        this.right_fist = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_fist.setRotationPoint(-3.0f, 6.6f, -2.0f);
        this.right_arm.addChild((BasicModelPart)this.right_fist);
        this.setRotationAngle(this.right_fist, -0.2618f, 0.0f, 0.0f);
        this.right_fist.setTextureOffset(21, 59).addBox(-4.0f, 0.0f, -4.0f, 8.0f, 9.0f, 8.0f, 0.0f, false);
        this.right_coral = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_coral.setRotationPoint(-4.0f, 6.0f, 0.0f);
        this.right_fist.addChild((BasicModelPart)this.right_coral);
        this.right_coral.setTextureOffset(0, 86).addBox(-8.0f, -8.0f, 0.0f, 8.0f, 11.0f, 0.0f, 0.0f, false);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm.setRotationPoint(9.0f, -6.7f, -1.7f);
        this.chest.addChild((BasicModelPart)this.left_arm);
        this.setRotationAngle(this.left_arm, -0.6109f, 0.0f, 0.0f);
        this.left_arm.setTextureOffset(0, 0).addBox(-1.0f, 8.0f, -4.0f, 2.0f, 2.0f, 2.0f, 0.0f, true);
        this.left_arm.setTextureOffset(0, 38).addBox(0.0f, -4.0f, -4.0f, 6.0f, 14.0f, 8.0f, 0.0f, false);
        this.left_arm.setTextureOffset(33, 21).addBox(3.0f, -1.0f, -5.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.left_arm.setTextureOffset(21, 38).addBox(5.0f, 2.0f, -5.0f, 3.0f, 1.0f, 3.0f, 0.0f, false);
        this.left_fist = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_fist.setRotationPoint(3.0f, 6.6f, -2.0f);
        this.left_arm.addChild((BasicModelPart)this.left_fist);
        this.setRotationAngle(this.left_fist, -0.2618f, 0.0f, 0.0f);
        this.left_fist.setTextureOffset(21, 59).addBox(-4.0f, 0.0f, -4.0f, 8.0f, 9.0f, 8.0f, 0.0f, true);
        this.left_coral = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_coral.setRotationPoint(4.0f, 6.0f, 0.0f);
        this.left_fist.addChild((BasicModelPart)this.left_coral);
        this.left_coral.setTextureOffset(0, 86).addBox(0.0f, -8.0f, 0.0f, 8.0f, 11.0f, 0.0f, 0.0f, true);
        this.coral_shoulder = new AdvancedModelBox((AdvancedEntityModel)this);
        this.coral_shoulder.setRotationPoint(-1.0f, -1.0f, 0.0f);
        this.left_arm.addChild((BasicModelPart)this.coral_shoulder);
        this.coral_shoulder.setTextureOffset(79, 55).addBox(4.0f, -10.0f, -1.0f, 9.0f, 10.0f, 0.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, 2.5f, 1.0f);
        this.upper_body.addChild((BasicModelPart)this.head);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg.setRotationPoint(-6.0f, -8.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.right_leg);
        this.right_leg.setTextureOffset(0, 69).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 8.0f, 8.0f, 0.0f, false);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg.setRotationPoint(6.0f, -8.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.left_leg);
        this.left_leg.setTextureOffset(68, 38).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 8.0f, 8.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(Coral_Golem_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_LEAP);
        this.animator.setStaticKeyframe(5);
        this.animator.startKeyframe(15);
        this.animator.move(this.lower_body, 0.0f, 2.0f, 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.rotate(this.helmet, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-65.0), (float)Math.toRadians(5.0), (float)Math.toRadians(2.5));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(12.5), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-65.0), (float)Math.toRadians(-5.0), (float)Math.toRadians(-2.0));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(15.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, 3.0f);
        this.animator.move(this.left_leg, 0.0f, 0.0f, -3.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(10);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-52.5), 0.0f, 0.0f);
        this.animator.rotate(this.helmet, (float)Math.toRadians(45.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-187.5), (float)Math.toRadians(-2.5), (float)Math.toRadians(-5.0));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(12.5), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-185.0), (float)Math.toRadians(5.0), (float)Math.toRadians(5.0));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(15.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, 1.0f);
        this.animator.move(this.left_leg, 0.0f, -2.0f, -5.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(60);
        this.animator.resetKeyframe(10);
        this.animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_SMASH);
        this.animator.startKeyframe(0);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-52.5), 0.0f, 0.0f);
        this.animator.rotate(this.helmet, (float)Math.toRadians(45.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-187.5), (float)Math.toRadians(-2.5), (float)Math.toRadians(-5.0));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(12.5), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-185.0), (float)Math.toRadians(5.0), (float)Math.toRadians(5.0));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(15.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, 1.0f);
        this.animator.move(this.left_leg, 0.0f, -2.0f, -5.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(3);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.rotate(this.helmet, (float)Math.toRadians(27.5), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-55.0), (float)Math.toRadians(-7.5), 0.0f);
        this.animator.rotate(this.right_fist, (float)Math.toRadians(12.5), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-55.0), 0.0f, (float)Math.toRadians(7.5));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(15.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, -4.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(10);
        this.animator.resetKeyframe(10);
        this.animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_LEFT_SMASH);
        this.animator.startKeyframe(10);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-17.5), (float)Math.toRadians(-10.0), (float)Math.toRadians(-5.0));
        this.animator.rotate(this.helmet, (float)Math.toRadians(12.5), (float)Math.toRadians(5.0), (float)Math.toRadians(-2.5));
        this.animator.move(this.right_arm, -1.0f, 3.0f, -2.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(10.0), (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.move(this.left_arm, -1.0f, 0.0f, 3.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-142.5), (float)Math.toRadians(-5.0), (float)Math.toRadians(5.0));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, -4.0f);
        this.animator.move(this.left_leg, 0.0f, 0.0f, 1.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.startKeyframe(1);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(5.0), (float)Math.toRadians(5.0), 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-15.0), (float)Math.toRadians(10.0), (float)Math.toRadians(2.5));
        this.animator.rotate(this.helmet, (float)Math.toRadians(2.5), (float)Math.toRadians(5.0), (float)Math.toRadians(-2.5));
        this.animator.move(this.right_arm, 0.0f, 3.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(25.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(-2.5));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.move(this.left_arm, -2.0f, 2.0f, -1.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-10.0), (float)Math.toRadians(2.5), (float)Math.toRadians(12.5));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
        this.animator.move(this.left_leg, 0.0f, 0.0f, -3.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(10);
        this.animator.resetKeyframe(10);
        this.animator.setAnimation(Coral_Golem_Entity.CORAL_GOLEM_RIGHT_SMASH);
        this.animator.startKeyframe(10);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-17.5), (float)Math.toRadians(10.0), (float)Math.toRadians(5.0));
        this.animator.rotate(this.helmet, (float)Math.toRadians(12.5), (float)Math.toRadians(-5.0), (float)Math.toRadians(2.5));
        this.animator.move(this.left_arm, 0.0f, 3.0f, -2.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(10.0), (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.move(this.right_arm, 1.0f, 0.0f, 3.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-142.5), (float)Math.toRadians(5.0), (float)Math.toRadians(-5.0));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
        this.animator.move(this.left_leg, 0.0f, 0.0f, -4.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, 1.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.startKeyframe(1);
        this.animator.rotate(this.lower_body, (float)Math.toRadians(5.0), (float)Math.toRadians(-5.0), 0.0f);
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-15.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(-2.5));
        this.animator.rotate(this.helmet, (float)Math.toRadians(2.5), (float)Math.toRadians(-5.0), (float)Math.toRadians(2.5));
        this.animator.move(this.left_arm, 0.0f, 3.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(25.0), (float)Math.toRadians(10.0), (float)Math.toRadians(2.5));
        this.animator.rotate(this.left_fist, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.move(this.right_arm, 2.0f, 2.0f, -1.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-10.0), (float)Math.toRadians(-2.5), (float)Math.toRadians(-12.5));
        this.animator.rotate(this.right_fist, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, -3.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(10);
        this.animator.resetKeyframe(10);
    }

    public void setupAnim(Coral_Golem_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float walkSpeed = 0.5f;
        float walkDegree = 0.5f;
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float swim = entityIn.getSwimAmount(partialTick);
        float swimSpeed = 0.25f;
        float swimDegree = 0.5f;
        float swimAmount = limbSwingAmount * swim;
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        this.walk(this.left_leg, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.flap(this.root, walkSpeed, walkDegree * 0.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_leg, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.left_arm, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_arm, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.progressRotationPrev(this.root, swim, 0.0f, 0.0f, (float)Math.toRadians(-10.0), 1.0f);
        this.progressRotationPrev(this.lower_body, swim, (float)Math.toRadians(17.5), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.head, swim, (float)Math.toRadians(-22.5), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.right_arm, swim, (float)Math.toRadians(35.0), 0.0f, (float)Math.toRadians(50.0), 1.0f);
        this.progressRotationPrev(this.left_arm, swim, (float)Math.toRadians(35.0), 0.0f, (float)Math.toRadians(-50.0), 1.0f);
        this.progressRotationPrev(this.right_leg, swim, (float)Math.toRadians(90.0), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.left_leg, swim, (float)Math.toRadians(117.5), 0.0f, 0.0f, 1.0f);
        this.flap(this.root, swimSpeed, swimDegree * 1.0f, true, 0.0f, 0.0f, limbSwing, swimAmount);
        this.flap(this.left_arm, swimSpeed, swimDegree * 2.75f, true, -0.5f, 1.5f, limbSwing, swimAmount);
        this.flap(this.right_arm, swimSpeed, swimDegree * 2.75f, false, -0.5f, 1.5f, limbSwing, swimAmount);
        this.walk(this.right_leg, swimSpeed * 1.5f, swimDegree * 1.0f, true, 2.0f, 0.0f, limbSwing, swimAmount);
        this.walk(this.left_leg, swimSpeed * 1.5f, swimDegree * 1.0f, false, 2.0f, 0.0f, limbSwing, swimAmount);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.lower_body, this.upper_body, this.helmet, this.chest, this.table_coral, this.blue_table_coral, this.red_table_coral, this.right_arm, this.right_fist, this.right_coral, this.left_arm, this.left_fist, this.left_coral, this.coral_shoulder, this.head, this.right_leg, this.left_leg);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

