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
package com.skd.sundering.client.model.entity;

import com.skd.sundering.entity.Pet.Modern_Remnant_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Modern_Remnant_Model
extends AdvancedEntityModel<Modern_Remnant_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox body;
    private final AdvancedModelBox upper_body;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox right_hand;
    private final AdvancedModelBox left_arm;
    private final AdvancedModelBox left_hand;
    private final AdvancedModelBox neck;
    private final AdvancedModelBox bandage;
    private final AdvancedModelBox headjoint;
    private final AdvancedModelBox head;
    private final AdvancedModelBox helmet;
    private final AdvancedModelBox helmet2;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox tail;
    private final AdvancedModelBox tail2;
    private final AdvancedModelBox tail3;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox right_leg_armor;
    private final AdvancedModelBox right_leg2;
    private final AdvancedModelBox right_leg_armor2;
    private final AdvancedModelBox right_leg_armor3;
    private final AdvancedModelBox left_leg;
    private final AdvancedModelBox left_leg_armor;
    private final AdvancedModelBox left_leg2;
    private final AdvancedModelBox left_leg_armor2;
    private final AdvancedModelBox left_leg_armor3;
    private ModelAnimator animator;

    public Modern_Remnant_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -8.0f, -1.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(0, 0).addBox(-2.5f, -2.0f, -3.0f, 5.0f, 5.0f, 7.0f, 0.0f, false);
        this.body.setTextureOffset(14, 14).addBox(0.0f, -6.0f, -3.0f, 0.0f, 4.0f, 7.0f, 0.0f, false);
        this.upper_body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upper_body.setRotationPoint(0.0f, -1.9f, -2.4f);
        this.body.addChild((BasicModelPart)this.upper_body);
        this.setRotationAngle(this.upper_body, -0.1745f, 0.0f, 0.0f);
        this.upper_body.setTextureOffset(0, 30).addBox(-2.5f, 0.0f, -3.3f, 5.0f, 4.0f, 3.0f, 0.0f, false);
        this.upper_body.setTextureOffset(25, 0).addBox(-2.5f, 0.0f, -3.3f, 5.0f, 4.0f, 3.0f, 0.3f, false);
        this.upper_body.setTextureOffset(0, 0).addBox(0.0f, -3.0f, -3.3f, 0.0f, 3.0f, 3.0f, 0.0f, false);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm.setRotationPoint(-3.0f, 2.5f, -2.8f);
        this.upper_body.addChild((BasicModelPart)this.right_arm);
        this.setRotationAngle(this.right_arm, 0.1745f, 0.0f, 0.0f);
        this.right_arm.setTextureOffset(16, 13).addBox(-0.5f, -0.5f, -0.5f, 1.0f, 3.0f, 1.0f, 0.0f, false);
        this.right_hand = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_hand.setRotationPoint(0.0f, 2.0f, -0.5f);
        this.right_arm.addChild((BasicModelPart)this.right_hand);
        this.right_hand.setTextureOffset(18, 0).addBox(0.0f, -0.5f, -3.0f, 0.0f, 3.0f, 3.0f, 0.0f, false);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm.setRotationPoint(3.0f, 2.5f, -2.8f);
        this.upper_body.addChild((BasicModelPart)this.left_arm);
        this.setRotationAngle(this.left_arm, 0.1745f, 0.0f, 0.0f);
        this.left_arm.setTextureOffset(16, 13).addBox(-0.5f, -0.5f, -0.5f, 1.0f, 3.0f, 1.0f, 0.0f, true);
        this.left_hand = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_hand.setRotationPoint(0.0f, 2.0f, -0.5f);
        this.left_arm.addChild((BasicModelPart)this.left_hand);
        this.left_hand.setTextureOffset(18, 0).addBox(0.0f, -0.5f, -3.0f, 0.0f, 3.0f, 3.0f, 0.0f, true);
        this.neck = new AdvancedModelBox((AdvancedEntityModel)this);
        this.neck.setRotationPoint(0.0f, 0.0f, -3.3f);
        this.upper_body.addChild((BasicModelPart)this.neck);
        this.neck.setTextureOffset(22, 8).addBox(-1.5f, 0.0f, -5.0f, 3.0f, 3.0f, 5.0f, 0.0f, false);
        this.neck.setTextureOffset(48, 7).addBox(0.0f, -1.0f, -4.0f, 0.0f, 1.0f, 4.0f, 0.0f, false);
        this.bandage = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bandage.setRotationPoint(0.0f, 0.0f, -2.5f);
        this.neck.addChild((BasicModelPart)this.bandage);
        this.setRotationAngle(this.bandage, 0.1745f, 0.0f, 0.0f);
        this.bandage.setTextureOffset(30, 30).addBox(-1.5f, -1.1f, -1.0f, 3.0f, 8.0f, 2.0f, 0.2f, false);
        this.headjoint = new AdvancedModelBox((AdvancedEntityModel)this);
        this.headjoint.setRotationPoint(0.0f, 0.0f, -4.6f);
        this.neck.addChild((BasicModelPart)this.headjoint);
        this.setRotationAngle(this.headjoint, 0.1745f, 0.0f, 0.0f);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.headjoint.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(37, 37).addBox(-1.0f, -1.0f, -8.0f, 2.0f, 3.0f, 4.0f, 0.1f, false);
        this.head.setTextureOffset(50, 40).addBox(0.0f, -4.0f, -6.3f, 0.0f, 4.0f, 2.0f, 0.0f, false);
        this.head.setTextureOffset(15, 40).addBox(-1.0f, -1.0f, -6.0f, 2.0f, 8.0f, 2.0f, 0.2f, false);
        this.head.setTextureOffset(24, 41).addBox(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 4.0f, 0.1f, false);
        this.head.setTextureOffset(25, 22).addBox(-2.0f, -2.0f, -4.0f, 4.0f, 3.0f, 4.0f, 0.0f, false);
        this.helmet = new AdvancedModelBox((AdvancedEntityModel)this);
        this.helmet.setRotationPoint(0.0f, -2.0f, -2.0f);
        this.head.addChild((BasicModelPart)this.helmet);
        this.setRotationAngle(this.helmet, -0.1745f, 0.0f, 0.0f);
        this.helmet.setTextureOffset(0, 13).addBox(-2.5f, -1.4f, -2.5f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.helmet.setTextureOffset(0, 50).addBox(-4.0f, -1.4f, 0.5f, 2.0f, 7.0f, 0.0f, 0.0f, false);
        this.helmet.setTextureOffset(0, 50).addBox(2.0f, -1.4f, 0.5f, 2.0f, 7.0f, 0.0f, 0.0f, true);
        this.helmet2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.helmet2.setRotationPoint(0.0f, -1.3f, -2.7f);
        this.helmet.addChild((BasicModelPart)this.helmet2);
        this.setRotationAngle(this.helmet2, -0.2618f, 0.0f, 0.0f);
        this.helmet2.setTextureOffset(0, 13).addBox(-1.0f, 0.0f, 0.0f, 2.0f, 4.0f, 0.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, 1.0f, -1.5f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.jaw.setTextureOffset(0, 38).addBox(-2.0f, 0.0f, -2.5f, 4.0f, 1.0f, 3.0f, 0.0f, false);
        this.jaw.setTextureOffset(41, 26).addBox(-1.0f, 0.0f, -6.5f, 2.0f, 2.0f, 4.0f, 0.0f, false);
        this.jaw.setTextureOffset(38, 20).addBox(-1.0f, -1.0f, -6.5f, 2.0f, 1.0f, 4.0f, 0.0f, false);
        this.tail = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail.setRotationPoint(0.0f, 0.0f, 4.0f);
        this.body.addChild((BasicModelPart)this.tail);
        this.tail.setTextureOffset(0, 21).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 6.0f, 0.0f, false);
        this.tail.setTextureOffset(32, 45).addBox(0.0f, -2.0f, 1.0f, 0.0f, 1.0f, 5.0f, 0.0f, false);
        this.tail.setTextureOffset(45, 0).addBox(0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 5.0f, 0.0f, false);
        this.tail2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail2.setRotationPoint(0.0f, 0.5f, 6.0f);
        this.tail.addChild((BasicModelPart)this.tail2);
        this.tail2.setTextureOffset(34, 12).addBox(-0.5f, -1.0f, 0.0f, 1.0f, 2.0f, 5.0f, 0.0f, false);
        this.tail2.setTextureOffset(0, 43).addBox(0.0f, -2.0f, 0.0f, 0.0f, 1.0f, 5.0f, 0.0f, false);
        this.tail2.setTextureOffset(42, 10).addBox(0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 5.0f, 0.0f, false);
        this.tail3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail3.setRotationPoint(0.0f, 0.0f, 5.0f);
        this.tail2.addChild((BasicModelPart)this.tail3);
        this.tail3.setTextureOffset(37, 3).addBox(-0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 5.0f, 0.0f, false);
        this.tail3.setTextureOffset(47, 17).addBox(0.0f, -1.5f, 0.0f, 0.0f, 1.0f, 4.0f, 0.0f, false);
        this.tail3.setTextureOffset(7, 47).addBox(0.0f, 0.5f, 0.0f, 0.0f, 1.0f, 4.0f, 0.0f, false);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg.setRotationPoint(-3.5f, -8.0f, -1.0f);
        this.root.addChild((BasicModelPart)this.right_leg);
        this.right_leg.setTextureOffset(17, 30).addBox(-1.0f, -1.0f, -2.0f, 2.0f, 5.0f, 4.0f, 0.0f, false);
        this.right_leg_armor = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg_armor.setRotationPoint(0.0f, 2.5f, -1.0f);
        this.right_leg.addChild((BasicModelPart)this.right_leg_armor);
        this.setRotationAngle(this.right_leg_armor, 0.3054f, 0.0f, 0.0f);
        this.right_leg_armor.setTextureOffset(43, 45).addBox(-1.0f, -3.5f, -1.3f, 2.0f, 4.0f, 2.0f, 0.2f, true);
        this.right_leg2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg2.setRotationPoint(0.0f, 4.0f, 1.55f);
        this.right_leg.addChild((BasicModelPart)this.right_leg2);
        this.right_leg2.setTextureOffset(46, 33).addBox(-1.0f, 0.0f, -1.05f, 2.0f, 4.0f, 2.0f, 0.0f, false);
        this.right_leg2.setTextureOffset(22, 17).addBox(-1.0f, 3.0f, -2.05f, 2.0f, 1.0f, 1.0f, 0.0f, false);
        this.right_leg_armor2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg_armor2.setRotationPoint(0.0f, 1.5f, 0.95f);
        this.right_leg2.addChild((BasicModelPart)this.right_leg_armor2);
        this.setRotationAngle(this.right_leg_armor2, -0.48f, 0.0f, 0.0f);
        this.right_leg_armor2.setTextureOffset(24, 48).addBox(-0.5f, -2.5f, -1.0f, 1.0f, 3.0f, 2.0f, 0.0f, false);
        this.right_leg_armor3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg_armor3.setRotationPoint(0.0f, 2.0f, -1.15f);
        this.right_leg2.addChild((BasicModelPart)this.right_leg_armor3);
        this.setRotationAngle(this.right_leg_armor3, 0.4363f, 0.0f, 0.0f);
        this.right_leg_armor3.setTextureOffset(0, 21).addBox(-0.5f, -1.0f, -0.5f, 1.0f, 2.0f, 1.0f, 0.0f, false);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg.setRotationPoint(3.5f, -8.0f, -1.0f);
        this.root.addChild((BasicModelPart)this.left_leg);
        this.left_leg.setTextureOffset(17, 30).addBox(-1.0f, -1.0f, -2.0f, 2.0f, 5.0f, 4.0f, 0.0f, true);
        this.left_leg_armor = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg_armor.setRotationPoint(0.0f, 2.5f, -1.0f);
        this.left_leg.addChild((BasicModelPart)this.left_leg_armor);
        this.setRotationAngle(this.left_leg_armor, 0.3054f, 0.0f, 0.0f);
        this.left_leg_armor.setTextureOffset(43, 45).addBox(-1.0f, -3.5f, -1.3f, 2.0f, 4.0f, 2.0f, 0.2f, false);
        this.left_leg2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg2.setRotationPoint(0.0f, 4.0f, 1.55f);
        this.left_leg.addChild((BasicModelPart)this.left_leg2);
        this.left_leg2.setTextureOffset(46, 33).addBox(-1.0f, 0.0f, -1.05f, 2.0f, 4.0f, 2.0f, 0.0f, true);
        this.left_leg2.setTextureOffset(22, 17).addBox(-1.0f, 3.0f, -2.05f, 2.0f, 1.0f, 1.0f, 0.0f, true);
        this.left_leg_armor2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg_armor2.setRotationPoint(0.0f, 1.5f, 0.95f);
        this.left_leg2.addChild((BasicModelPart)this.left_leg_armor2);
        this.setRotationAngle(this.left_leg_armor2, -0.48f, 0.0f, 0.0f);
        this.left_leg_armor2.setTextureOffset(24, 48).addBox(-0.5f, -2.5f, -1.0f, 1.0f, 3.0f, 2.0f, 0.0f, true);
        this.left_leg_armor3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg_armor3.setRotationPoint(0.0f, 2.0f, -1.15f);
        this.left_leg2.addChild((BasicModelPart)this.left_leg_armor3);
        this.setRotationAngle(this.left_leg_armor3, 0.4363f, 0.0f, 0.0f);
        this.left_leg_armor3.setTextureOffset(0, 21).addBox(-0.5f, -1.0f, -0.5f, 1.0f, 2.0f, 1.0f, 0.0f, true);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(Modern_Remnant_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Modern_Remnant_Entity.MODERN_REMNANT_BITE);
        this.animator.startKeyframe(3);
        this.animator.rotate(this.root, 0.0f, (float)Math.toRadians(-12.5), 0.0f);
        this.animator.rotate(this.body, (float)Math.toRadians(-10.0), 0.0f, (float)Math.toRadians(7.5));
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-5.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-22.5), (float)Math.toRadians(5.0), (float)Math.toRadians(20.0));
        this.animator.rotate(this.right_hand, (float)Math.toRadians(30.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-25.0), (float)Math.toRadians(-5.0), (float)Math.toRadians(-20.0));
        this.animator.rotate(this.left_hand, (float)Math.toRadians(32.5), 0.0f, 0.0f);
        this.animator.rotate(this.neck, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.head, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(70.0), 0.0f, 0.0f);
        this.animator.rotate(this.tail, (float)Math.toRadians(-7.5), (float)Math.toRadians(-2.5), 0.0f);
        this.animator.rotate(this.tail2, 0.0f, (float)Math.toRadians(-12.5), 0.0f);
        this.animator.rotate(this.tail3, 0.0f, (float)Math.toRadians(-15.0), 0.0f);
        this.animator.move(this.left_leg, 0.0f, -1.5f, -1.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(3);
        this.animator.move(this.root, 0.0f, 0.2f, 0.0f);
        this.animator.rotate(this.root, 0.0f, (float)Math.toRadians(12.5), 0.0f);
        this.animator.rotate(this.body, 0.0f, (float)Math.toRadians(7.5), (float)Math.toRadians(-6.66f));
        this.animator.rotate(this.upper_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(10.0), (float)Math.toRadians(-2.5));
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-17.5), (float)Math.toRadians(5.0), (float)Math.toRadians(20.0));
        this.animator.rotate(this.right_hand, (float)Math.toRadians(22.5), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-15.0), (float)Math.toRadians(-5.0), (float)Math.toRadians(-20.0));
        this.animator.rotate(this.left_hand, (float)Math.toRadians(22.5), 0.0f, 0.0f);
        this.animator.rotate(this.neck, (float)Math.toRadians(27.5), (float)Math.toRadians(3.5), (float)Math.toRadians(10.0));
        this.animator.rotate(this.head, (float)Math.toRadians(-2.5), (float)Math.toRadians(50.0), (float)Math.toRadians(-5.0));
        this.animator.rotate(this.tail, (float)Math.toRadians(-20.0), (float)Math.toRadians(15.0), 0.0f);
        this.animator.rotate(this.tail2, 0.0f, (float)Math.toRadians(10.0), 0.0f);
        this.animator.rotate(this.tail3, 0.0f, (float)Math.toRadians(7.5), 0.0f);
        this.animator.rotate(this.right_leg, (float)Math.toRadians(5.0), 0.0f, 0.0f);
        this.animator.move(this.right_leg, 0.0f, 0.0f, 2.0f);
        this.animator.rotate(this.left_leg, 0.0f, (float)Math.toRadians(-22.5), 0.0f);
        this.animator.move(this.left_leg, 0.0f, 0.0f, -1.5f);
        this.animator.endKeyframe();
        this.animator.resetKeyframe(5);
    }

    public void setupAnim(Modern_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float walkSpeed = 0.8f;
        float walkDegree = 0.85f;
        float idleSpeed = 0.1f;
        float idleDegree = 0.4f;
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        AdvancedModelBox[] tailBoxes = new AdvancedModelBox[]{this.tail, this.tail2, this.tail3};
        this.walk(this.root, walkSpeed * 2.0f, walkDegree * 0.05f, false, -2.0f, 0.0f, limbSwing, limbSwingAmount);
        this.bob(this.root, -walkSpeed, walkDegree * -4.0f, true, limbSwing, limbSwingAmount);
        this.chainSwing(tailBoxes, idleSpeed, idleDegree * 0.3f, -2.0, ageInTicks, 1.0f);
        this.walk(this.left_leg, walkSpeed, walkDegree * 1.0f, true, 0.0f, 0.2f, limbSwing, limbSwingAmount);
        this.walk(this.left_leg2, walkSpeed, walkDegree * 0.5f, true, -1.0f, -0.2f, limbSwing, limbSwingAmount);
        this.swing(this.left_leg2, walkSpeed, walkDegree * -0.5f, true, -1.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_leg, walkSpeed, walkDegree * 1.0f, false, 0.0f, 0.2f, limbSwing, limbSwingAmount);
        this.walk(this.right_leg2, walkSpeed, walkDegree * 0.5f, false, -1.0f, -0.2f, limbSwing, limbSwingAmount);
        this.swing(this.right_leg2, walkSpeed, walkDegree * -0.5f, false, -1.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.neck, walkSpeed * 2.0f, walkDegree * 0.3f, false, -1.0f, -0.5f, limbSwing, limbSwingAmount);
        this.walk(this.head, walkSpeed * 2.0f, walkDegree * 0.3f, true, -1.0f, -0.5f, limbSwing, limbSwingAmount);
        this.walk(this.left_arm, walkSpeed * 2.0f, walkDegree * 0.3f, false, 1.0f, -0.1f, limbSwing, limbSwingAmount);
        this.walk(this.right_arm, walkSpeed * 2.0f, walkDegree * 0.3f, false, 1.0f, -0.1f, limbSwing, limbSwingAmount);
        this.walk(this.right_arm, 0.1f, 0.1f, false, 3.0f, 0.1f, ageInTicks, 1.0f);
        this.walk(this.left_arm, 0.1f, 0.1f, false, 3.0f, 0.1f, ageInTicks, 1.0f);
        this.swing(this.right_hand, 0.1f, 0.1f, true, 3.0f, 0.1f, ageInTicks, 1.0f);
        this.swing(this.left_hand, 0.1f, 0.1f, false, 3.0f, 0.1f, ageInTicks, 1.0f);
        this.walk(this.neck, 0.1f, 0.05f, false, 4.0f, 0.1f, ageInTicks, 1.0f);
        this.walk(this.head, 0.1f, 0.05f, true, 4.0f, 0.1f, ageInTicks, 1.0f);
        this.walk(this.jaw, 0.1f * idleSpeed, idleDegree * 0.25f, true, 0.2f, -idleDegree * 0.25f, ageInTicks, 1.0f);
        this.bob(this.body, 0.4f * idleSpeed, idleDegree * 2.0f, false, ageInTicks, 1.0f);
        float sitProgress = entityIn.prevSitProgress + (entityIn.sitProgress - entityIn.prevSitProgress) * partialTick;
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head, this.neck});
        this.progressPositionPrev(this.root, sitProgress, 0.0f, 5.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.neck, sitProgress, (float)Math.toRadians(30.0), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.head, sitProgress, (float)Math.toRadians(-25.0), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.tail, sitProgress, (float)Math.toRadians(-10.0), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.tail2, sitProgress, (float)Math.toRadians(2.5), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.tail3, sitProgress, (float)Math.toRadians(15.0), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.right_leg, sitProgress, (float)Math.toRadians(-90.0), (float)Math.toRadians(15.0), 0.0f, 10.0f);
        this.progressPositionPrev(this.right_leg, sitProgress, 0.0f, 1.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.left_leg, sitProgress, (float)Math.toRadians(-90.0), (float)Math.toRadians(-15.0), 0.0f, 10.0f);
        this.progressPositionPrev(this.left_leg, sitProgress, 0.0f, 1.0f, 0.0f, 10.0f);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.body, (Object)this.upper_body, (Object)this.right_arm, (Object)this.right_hand, (Object)this.left_arm, (Object)this.left_hand, (Object)this.neck, (Object)this.bandage, (Object)this.headjoint, (Object)this.head, (Object)this.helmet, (Object[])new AdvancedModelBox[]{this.helmet2, this.jaw, this.tail, this.tail2, this.tail3, this.right_leg, this.right_leg2, this.left_leg, this.left_leg2});
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

