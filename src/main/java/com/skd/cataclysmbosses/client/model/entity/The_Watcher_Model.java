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

import com.skd.cataclysmbosses.entity.AnimationMonster.The_Watcher_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;

public class The_Watcher_Model
extends AdvancedEntityModel<The_Watcher_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox pivot;
    private final AdvancedModelBox head;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox cannon;
    private final AdvancedModelBox bone;
    private final AdvancedModelBox headgear;
    private final AdvancedModelBox right_wing;
    private final AdvancedModelBox sail;
    private final AdvancedModelBox left_wing;
    private final AdvancedModelBox sail2;
    private final AdvancedModelBox booster;
    private final AdvancedModelBox upper_sub_booster;
    private final AdvancedModelBox lower_sub_booster;
    private ModelAnimator animator;

    public The_Watcher_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.pivot = new AdvancedModelBox((AdvancedEntityModel)this);
        this.pivot.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.pivot);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.pivot.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(32, 32).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.head.setTextureOffset(0, 8).addBox(-2.0f, -6.0f, -4.0f, 4.0f, 4.0f, 8.0f, 0.0f, false);
        this.head.setTextureOffset(0, 0).addBox(-4.0f, -3.0f, -4.0f, 8.0f, 0.0f, 8.0f, 0.0f, false);
        this.head.setTextureOffset(0, 20).addBox(-3.0f, -3.0f, -3.5f, 6.0f, 2.0f, 1.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, -1.0f, 2.5f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.setRotationAngle(this.jaw, 0.3054f, 0.0f, 0.0f);
        this.jaw.setTextureOffset(37, 17).addBox(-4.0f, -1.0f, -6.0f, 8.0f, 3.0f, 8.0f, 0.0f, false);
        this.jaw.setTextureOffset(0, 0).addBox(-4.0f, 1.0f, -6.0f, 8.0f, 0.0f, 8.0f, 0.0f, false);
        this.cannon = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cannon.setRotationPoint(0.0f, -5.0f, 3.0f);
        this.head.addChild((BasicModelPart)this.cannon);
        this.cannon.setTextureOffset(56, 28).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.cannon.setTextureOffset(56, 34).addBox(-1.5f, -1.5f, -5.0f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.bone = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bone.setRotationPoint(0.0f, 0.0f, -3.0f);
        this.cannon.addChild((BasicModelPart)this.bone);
        this.bone.setTextureOffset(13, 54).addBox(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 3.0f, 0.0f, false);
        this.headgear = new AdvancedModelBox((AdvancedEntityModel)this);
        this.headgear.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.headgear);
        this.headgear.setTextureOffset(0, 25).addBox(0.0f, -15.0f, -10.0f, 0.0f, 9.0f, 15.0f, 0.0f, false);
        this.headgear.setTextureOffset(45, 10).addBox(-3.0f, -7.0f, -7.0f, 6.0f, 3.0f, 3.0f, 0.0f, false);
        this.headgear.setTextureOffset(0, 25).addBox(-5.0f, -9.0f, -5.0f, 10.0f, 5.0f, 10.0f, 0.0f, false);
        this.right_wing = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_wing.setRotationPoint(0.0f, -4.0f, 4.0f);
        this.headgear.addChild((BasicModelPart)this.right_wing);
        this.right_wing.setTextureOffset(14, 20).addBox(-6.0f, -1.0f, -5.0f, 3.0f, 2.0f, 2.0f, 0.0f, false);
        this.sail = new AdvancedModelBox((AdvancedEntityModel)this);
        this.sail.setRotationPoint(-5.0f, 0.0f, -4.0f);
        this.right_wing.addChild((BasicModelPart)this.sail);
        this.setRotationAngle(this.sail, 0.0f, 0.3491f, -0.4363f);
        this.sail.setTextureOffset(0, 0).addBox(-7.0f, 0.0f, -15.0f, 10.0f, 0.0f, 25.0f, 0.0f, false);
        this.left_wing = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_wing.setRotationPoint(0.0f, -4.0f, 4.0f);
        this.headgear.addChild((BasicModelPart)this.left_wing);
        this.left_wing.setTextureOffset(14, 20).addBox(3.0f, -1.0f, -5.0f, 3.0f, 2.0f, 2.0f, 0.0f, true);
        this.sail2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.sail2.setRotationPoint(5.0f, 0.0f, -4.0f);
        this.left_wing.addChild((BasicModelPart)this.sail2);
        this.setRotationAngle(this.sail2, 0.0f, -0.3491f, 0.4363f);
        this.sail2.setTextureOffset(0, 0).addBox(-3.0f, 0.0f, -15.0f, 10.0f, 0.0f, 25.0f, 0.0f, true);
        this.booster = new AdvancedModelBox((AdvancedEntityModel)this);
        this.booster.setRotationPoint(0.0f, -4.0f, 4.0f);
        this.pivot.addChild((BasicModelPart)this.booster);
        this.booster.setTextureOffset(43, 56).addBox(-2.0f, -2.0f, 0.0f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.booster.setTextureOffset(27, 48).addBox(-3.0f, -3.0f, 2.0f, 6.0f, 6.0f, 3.0f, 0.0f, false);
        this.booster.setTextureOffset(45, 0).addBox(-3.0f, -3.0f, 2.75f, 6.0f, 6.0f, 4.0f, 0.3f, false);
        this.booster.setTextureOffset(0, 0).addBox(0.0f, -6.0f, 1.0f, 0.0f, 12.0f, 4.0f, 0.0f, false);
        this.upper_sub_booster = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upper_sub_booster.setRotationPoint(0.0f, -5.0f, 3.0f);
        this.booster.addChild((BasicModelPart)this.upper_sub_booster);
        this.setRotationAngle(this.upper_sub_booster, 0.3054f, 0.0f, 0.0f);
        this.upper_sub_booster.setTextureOffset(0, 49).addBox(-1.5f, -2.0f, 0.0f, 3.0f, 3.0f, 5.0f, 0.0f, false);
        this.lower_sub_booster = new AdvancedModelBox((AdvancedEntityModel)this);
        this.lower_sub_booster.setRotationPoint(0.0f, 5.0f, 3.0f);
        this.booster.addChild((BasicModelPart)this.lower_sub_booster);
        this.setRotationAngle(this.lower_sub_booster, -0.3054f, 0.0f, 0.0f);
        this.lower_sub_booster.setTextureOffset(45, 48).addBox(-1.5f, -1.0f, 0.0f, 3.0f, 3.0f, 5.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(The_Watcher_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(The_Watcher_Entity.WATCHER_BITE);
        this.animator.startKeyframe(5);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-5.0), 0.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(-5.0), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, -1.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(5.0), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, -1.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.move(this.pivot, 0.0f, 0.0f, 3.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(5.0), 0.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(30.0), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, 3.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-30.0), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, 3.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.move(this.pivot, 0.0f, 0.0f, 3.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(5.0), 0.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(20.0), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, 2.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-20.0), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, 2.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.move(this.pivot, 0.0f, 0.0f, -2.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-20.0), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.sail, (float)Math.toRadians(7.5), (float)Math.toRadians(-30.0), 0.0f);
        this.animator.rotate(this.sail2, (float)Math.toRadians(7.5), (float)Math.toRadians(30.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.resetKeyframe(5);
        this.animator.setStaticKeyframe(3);
        this.animator.setAnimation(The_Watcher_Entity.WATCHER_EXTRA_SHOT);
        this.animator.startKeyframe(0);
        this.animator.move(this.bone, 0.0f, 0.0f, -1.5f);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.move(this.pivot, 0.0f, -4.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, 0.5f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 3.5f, -1.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(5.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(5);
        this.animator.startKeyframe(2);
        this.animator.move(this.bone, 0.0f, 0.0f, 0.5f);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.move(this.pivot, 0.0f, -4.0f, 3.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, 0.5f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 3.5f, -1.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(12.5), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, 1.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-7.5), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, 1.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.move(this.bone, 0.0f, 0.0f, -1.5f);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.move(this.pivot, 0.0f, -4.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, 0.5f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 3.5f, -1.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(5.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(3);
        this.animator.resetKeyframe(5);
        this.animator.setAnimation(The_Watcher_Entity.WATCHER_SHOT);
        this.animator.startKeyframe(7);
        this.animator.rotate(this.pivot, (float)Math.toRadians(32.5), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(10);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-372.5), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(10.0), 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-10.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(0);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(10.0), 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-10.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(15.0), 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-15.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(3);
        this.animator.startKeyframe(2);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(10.0), 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-10.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(30.0), 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-32.5), 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(5);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 4.0f, 0.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(35.0), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, 2.5f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-33.3f), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, 2.5f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 5.0f, -2.0f);
        this.animator.move(this.bone, 0.0f, 0.0f, -2.0f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(37.5), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, 4.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-35.0), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, 4.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 3.5f, -1.0f);
        this.animator.move(this.bone, 0.0f, 0.0f, -1.5f);
        this.animator.rotate(this.sail, 0.0f, (float)Math.toRadians(37.5), 0.0f);
        this.animator.move(this.sail, 0.0f, 0.0f, -2.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(-35.0), 0.0f);
        this.animator.move(this.sail2, 0.0f, 0.0f, -2.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.move(this.bone, 0.0f, 0.0f, -1.5f);
        this.animator.rotate(this.pivot, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
        this.animator.move(this.pivot, 0.0f, -4.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.move(this.jaw, 0.0f, 0.5f, 0.0f);
        this.animator.move(this.cannon, 0.0f, 3.5f, -1.0f);
        this.animator.rotate(this.cannon, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.rotate(this.sail2, 0.0f, (float)Math.toRadians(5.0), 0.0f);
        this.animator.endKeyframe();
        this.animator.setStaticKeyframe(10);
        this.animator.resetKeyframe(5);
    }

    public void setupAnim(The_Watcher_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.pivot});
        float globalSpeed = 0.15f;
        float globalDegree = 0.5f;
        this.bob(this.pivot, globalSpeed, globalDegree * 5.0f, false, ageInTicks, 1.0f);
        this.bob(this.pivot, globalSpeed, globalDegree * 5.0f, false, limbSwing, limbSwingAmount);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.pivot, this.head, this.jaw, this.cannon, this.bone, this.headgear, this.right_wing, this.sail, this.head, this.left_wing, this.sail2, this.booster, this.upper_sub_booster, this.lower_sub_booster);
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

