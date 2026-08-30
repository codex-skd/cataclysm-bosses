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

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Ender_Golem_Model
extends AdvancedEntityModel<Ender_Golem_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox lowerbody;
    private final AdvancedModelBox upperbody;
    private final AdvancedModelBox voidstone;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox right_arm2;
    private final AdvancedModelBox right_finger;
    private final AdvancedModelBox left_arm;
    private final AdvancedModelBox left_arm2;
    private final AdvancedModelBox left_finger;
    private final AdvancedModelBox head;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox left_leg;
    private ModelAnimator animator;

    public Ender_Golem_Model() {
        this.texWidth = 256;
        this.texHeight = 256;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.lowerbody = new AdvancedModelBox((AdvancedEntityModel)this);
        this.lowerbody.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.lowerbody);
        this.lowerbody.setTextureOffset(64, 52).addBox(-11.0f, -8.0f, -7.0f, 22.0f, 8.0f, 14.0f, 0.0f, false);
        this.upperbody = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upperbody.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.lowerbody.addChild((BasicModelPart)this.upperbody);
        this.upperbody.setTextureOffset(0, 0).addBox(-20.0f, -32.0f, -10.0f, 40.0f, 32.0f, 20.0f, 0.0f, false);
        this.voidstone = new AdvancedModelBox((AdvancedEntityModel)this);
        this.voidstone.setRotationPoint(0.0f, -12.0f, 9.0f);
        this.upperbody.addChild((BasicModelPart)this.voidstone);
        this.voidstone.setTextureOffset(0, 52).addBox(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f, false);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm.setRotationPoint(-20.0f, -25.0f, 0.0f);
        this.upperbody.addChild((BasicModelPart)this.right_arm);
        this.right_arm.setTextureOffset(52, 74).addBox(-14.0f, -6.0f, -6.0f, 14.0f, 24.0f, 12.0f, 0.0f, false);
        this.right_arm2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm2.setRotationPoint(-10.5f, 18.0f, 0.0f);
        this.right_arm.addChild((BasicModelPart)this.right_arm2);
        this.right_arm2.setTextureOffset(92, 98).addBox(-5.5f, 0.0f, -6.0f, 11.0f, 22.0f, 12.0f, 0.0f, false);
        this.right_arm2.setTextureOffset(0, 52).addBox(1.5f, 22.0f, -3.0f, 3.0f, 7.0f, 5.0f, 0.0f, false);
        this.right_finger = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_finger.setRotationPoint(-3.5f, 22.0f, 0.0f);
        this.right_arm2.addChild((BasicModelPart)this.right_finger);
        this.right_finger.setTextureOffset(0, 0).addBox(-1.0f, 0.0f, -5.5f, 3.0f, 8.0f, 5.0f, 0.0f, false);
        this.right_finger.setTextureOffset(0, 0).addBox(-1.0f, 0.0f, 0.5f, 3.0f, 8.0f, 5.0f, 0.0f, false);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm.setRotationPoint(20.0f, -25.0f, 0.0f);
        this.upperbody.addChild((BasicModelPart)this.left_arm);
        this.left_arm.setTextureOffset(52, 74).addBox(0.0f, -6.0f, -6.0f, 14.0f, 24.0f, 12.0f, 0.0f, true);
        this.left_arm2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm2.setRotationPoint(10.5f, 18.0f, 0.0f);
        this.left_arm.addChild((BasicModelPart)this.left_arm2);
        this.left_arm2.setTextureOffset(92, 98).addBox(-5.5f, 0.0f, -6.0f, 11.0f, 22.0f, 12.0f, 0.0f, true);
        this.left_arm2.setTextureOffset(0, 52).addBox(-4.5f, 22.0f, -3.0f, 3.0f, 7.0f, 5.0f, 0.0f, true);
        this.left_finger = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_finger.setRotationPoint(3.5f, 22.0f, 0.0f);
        this.left_arm2.addChild((BasicModelPart)this.left_finger);
        this.left_finger.setTextureOffset(0, 0).addBox(-2.0f, 0.0f, -5.5f, 3.0f, 8.0f, 5.0f, 0.0f, true);
        this.left_finger.setTextureOffset(0, 0).addBox(-2.0f, 0.0f, 0.5f, 3.0f, 8.0f, 5.0f, 0.0f, true);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -25.0f, -10.0f);
        this.upperbody.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(0, 98).addBox(-8.0f, -8.0f, -12.0f, 16.0f, 16.0f, 12.0f, 0.0f, false);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg.setRotationPoint(-11.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.right_leg);
        this.right_leg.setTextureOffset(44, 114).addBox(-8.0f, 0.0f, -6.0f, 12.0f, 20.0f, 12.0f, 0.0f, false);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg.setRotationPoint(11.0f, -20.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.left_leg);
        this.left_leg.setTextureOffset(44, 114).addBox(-4.0f, 0.0f, -6.0f, 12.0f, 20.0f, 12.0f, 0.0f, true);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(Ender_Golem_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Ender_Golem_Entity.ANIMATION_ATTACK1);
        this.animator.startKeyframe(10);
        this.animator.rotate(this.upperbody, 0.0f, (float)Math.toRadians(50.0), 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(40.0), (float)Math.toRadians(20.0), 0.0f);
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-80.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(20.0), 0.0f, (float)Math.toRadians(-10.0));
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.rotate(this.lowerbody, 0.0f, (float)Math.toRadians(-20.0), 0.0f);
        this.animator.rotate(this.upperbody, 0.0f, (float)Math.toRadians(-40.0), 0.0f);
        this.animator.rotate(this.head, 0.0f, (float)Math.toRadians(30.0), 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-20.0), (float)Math.toRadians(20.0), (float)Math.toRadians(20.0));
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-20.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-40.0));
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-40.0), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.resetKeyframe(5);
        this.animator.setAnimation(Ender_Golem_Entity.ANIMATION_ATTACK2);
        this.animator.startKeyframe(10);
        this.animator.rotate(this.upperbody, 0.0f, (float)Math.toRadians(-50.0), 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(40.0), (float)Math.toRadians(-20.0), 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-80.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(20.0), 0.0f, (float)Math.toRadians(10.0));
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.rotate(this.lowerbody, 0.0f, (float)Math.toRadians(20.0), 0.0f);
        this.animator.rotate(this.upperbody, 0.0f, (float)Math.toRadians(40.0), 0.0f);
        this.animator.rotate(this.head, 0.0f, (float)Math.toRadians(-30.0), 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-20.0), (float)Math.toRadians(-20.0), (float)Math.toRadians(-20.0));
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-20.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(40.0));
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-40.0), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.resetKeyframe(5);
        this.animator.setAnimation(Ender_Golem_Entity.ANIMATION_EARTHQUAKE);
        this.animator.startKeyframe(10);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.lowerbody, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-160.0), (float)Math.toRadians(20.0), (float)Math.toRadians(-10.0));
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-160.0), (float)Math.toRadians(-20.0), (float)Math.toRadians(10.0));
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-20.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-20.0), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.startKeyframe(5);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(30.0), 0.0f, 0.0f);
        this.animator.rotate(this.lowerbody, (float)Math.toRadians(40.0), 0.0f, 0.0f);
        this.animator.rotate(this.head, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-100.0), (float)Math.toRadians(20.0), (float)Math.toRadians(-10.0));
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-100.0), (float)Math.toRadians(-20.0), (float)Math.toRadians(10.0));
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(40.0));
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-40.0));
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.resetKeyframe(10);
        this.animator.setAnimation(Ender_Golem_Entity.VOID_RUNE_ATTACK);
        this.animator.startKeyframe(13);
        this.animator.rotate(this.lowerbody, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-170.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-180.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-17.5));
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(17.5));
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.startKeyframe(5);
        this.animator.rotate(this.lowerbody, (float)Math.toRadians(45.0), 0.0f, 0.0f);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-50.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-50.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-17.5));
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(17.5));
        this.animator.endKeyframe();
        this.animator.startKeyframe(15);
        this.animator.rotate(this.lowerbody, (float)Math.toRadians(45.0), 0.0f, 0.0f);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.move(this.voidstone, 0.0f, 0.0f, 8.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-50.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-50.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-17.5));
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(17.5));
        this.animator.endKeyframe();
        this.animator.startKeyframe(10);
        this.animator.rotate(this.lowerbody, (float)Math.toRadians(45.0), 0.0f, 0.0f);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.move(this.voidstone, 0.0f, 0.0f, -1.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-50.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-50.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-17.5));
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(17.5));
        this.animator.endKeyframe();
        this.animator.startKeyframe(10);
        this.animator.rotate(this.upperbody, (float)Math.toRadians(-2.5), 0.0f, 0.0f);
        this.animator.move(this.voidstone, 0.0f, 0.0f, -1.0f);
        this.animator.rotate(this.right_arm, (float)Math.toRadians(-62.5), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm, (float)Math.toRadians(-62.5), 0.0f, 0.0f);
        this.animator.rotate(this.right_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.left_arm2, (float)Math.toRadians(-60.0), 0.0f, 0.0f);
        this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(-17.5));
        this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(-17.5));
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(10);
        this.animator.resetKeyframe(15);
        this.animator.setAnimation(Ender_Golem_Entity.ENDER_GOLEM_DEATH);
        if (entity.getIsAwaken()) {
            this.animator.startKeyframe(10);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm2, (float)Math.toRadians(55.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm2, (float)Math.toRadians(55.0), 0.0f, 0.0f);
            this.animator.move(this.lowerbody, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.right_leg, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.left_leg, 0.0f, 14.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(5);
            this.animator.startKeyframe(20);
            this.animator.rotate(this.upperbody, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(15.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(15.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm2, (float)Math.toRadians(55.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm2, (float)Math.toRadians(55.0), 0.0f, 0.0f);
            this.animator.move(this.lowerbody, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.right_leg, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.left_leg, 0.0f, 14.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(5);
            this.animator.startKeyframe(5);
            this.animator.rotate(this.lowerbody, (float)Math.toRadians(62.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm2, (float)Math.toRadians(10.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm2, (float)Math.toRadians(10.0), 0.0f, 0.0f);
            this.animator.move(this.lowerbody, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.right_leg, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.left_leg, 0.0f, 14.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(50);
        } else {
            this.animator.startKeyframe(10);
            this.animator.rotate(this.lowerbody, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
            this.animator.rotate(this.upperbody, (float)Math.toRadians(-17.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm2, (float)Math.toRadians(85.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm2, (float)Math.toRadians(85.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(35.0));
            this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(35.0));
            this.animator.rotate(this.head, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
            this.animator.move(this.lowerbody, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.right_leg, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.left_leg, 0.0f, 14.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(5);
            this.animator.startKeyframe(20);
            this.animator.rotate(this.lowerbody, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
            this.animator.rotate(this.upperbody, (float)Math.toRadians(-30.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(62.5), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(62.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm2, (float)Math.toRadians(85.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm2, (float)Math.toRadians(85.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(35.0));
            this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(35.0));
            this.animator.rotate(this.head, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
            this.animator.move(this.lowerbody, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.right_leg, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.left_leg, 0.0f, 14.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(5);
            this.animator.startKeyframe(5);
            this.animator.rotate(this.lowerbody, (float)Math.toRadians(32.5), 0.0f, 0.0f);
            this.animator.rotate(this.upperbody, (float)Math.toRadians(-17.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(90.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_arm2, (float)Math.toRadians(40.0), 0.0f, 0.0f);
            this.animator.rotate(this.left_arm2, (float)Math.toRadians(40.0), 0.0f, 0.0f);
            this.animator.rotate(this.right_finger, 0.0f, 0.0f, (float)Math.toRadians(35.0));
            this.animator.rotate(this.left_finger, 0.0f, 0.0f, (float)Math.toRadians(35.0));
            this.animator.rotate(this.head, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
            this.animator.move(this.lowerbody, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.right_leg, 0.0f, 14.0f, 0.0f);
            this.animator.move(this.left_leg, 0.0f, 14.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(50);
        }
    }

    public void setupAnim(Ender_Golem_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float walkSpeed = 0.5f;
        float walkDegree = 0.5f;
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        this.walk(this.left_leg, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.flap(this.root, walkSpeed, walkDegree * 0.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_leg, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.left_arm, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        this.walk(this.right_arm, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float deactivateProgress = entityIn.prevdeactivateProgress + (entityIn.deactivateProgress - entityIn.prevdeactivateProgress) * partialTick;
        this.progressRotationPrev(this.lowerbody, deactivateProgress, (float)Math.toRadians(30.0), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.upperbody, deactivateProgress, (float)Math.toRadians(17.5), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.right_arm, deactivateProgress, (float)Math.toRadians(-47.5), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.left_arm, deactivateProgress, (float)Math.toRadians(-47.5), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.right_arm2, deactivateProgress, (float)Math.toRadians(-30.0), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.left_arm2, deactivateProgress, (float)Math.toRadians(-30.0), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.right_finger, deactivateProgress, 0.0f, 0.0f, (float)Math.toRadians(-35.0), 30.0f);
        this.progressRotationPrev(this.left_finger, deactivateProgress, 0.0f, 0.0f, (float)Math.toRadians(35.0), 30.0f);
        this.progressRotationPrev(this.head, deactivateProgress, (float)Math.toRadians(15.0), 0.0f, 0.0f, 30.0f);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.left_arm, this.right_arm, this.left_arm2, this.right_arm2, this.left_finger, this.right_finger, this.left_leg, this.right_leg, this.head, this.lowerbody, this.upperbody, (Object[])new AdvancedModelBox[]{this.voidstone});
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

