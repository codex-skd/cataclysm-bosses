/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.Minecraft
 */
package com.skd.sundering.client.model.entity;

import com.skd.sundering.client.animation.Coralssus_Animation;
import com.skd.sundering.entity.InternalAnimationMonster.Coralssus_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Coralssus_Model
extends AdvancedEntityModel<Coralssus_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox body;
    private final AdvancedModelBox chest;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox neck;
    private final AdvancedModelBox head;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox cube_r3;
    private final AdvancedModelBox cube_r4;
    private final AdvancedModelBox eye;
    private final AdvancedModelBox right_arm_joint;
    private final AdvancedModelBox right_arm;
    private final AdvancedModelBox cube_r5;
    private final AdvancedModelBox cube_r6;
    private final AdvancedModelBox right_arm2;
    private final AdvancedModelBox left_arm_joint;
    private final AdvancedModelBox left_arm;
    private final AdvancedModelBox cube_r7;
    private final AdvancedModelBox left_arm_coral;
    private final AdvancedModelBox left_arm2;
    private final AdvancedModelBox coral;
    private final AdvancedModelBox cube_r8;
    private final AdvancedModelBox coral2;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox left_leg;

    public Coralssus_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this, "root");
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this, "body");
        this.body.setRotationPoint(0.0f, -13.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(72, 0).addBox(-7.0f, -5.0f, -4.0f, 14.0f, 8.0f, 8.0f, 0.0f, false);
        this.chest = new AdvancedModelBox((AdvancedEntityModel)this, "chest");
        this.chest.setRotationPoint(0.0f, -3.0186f, -0.0484f);
        this.body.addChild((BasicModelPart)this.chest);
        this.setRotationAngle(this.chest, 0.829f, 0.0f, 0.0f);
        this.chest.setTextureOffset(0, 0).addBox(-14.0f, -19.9814f, -8.9516f, 28.0f, 20.0f, 16.0f, 0.0f, false);
        this.chest.setTextureOffset(108, 3).addBox(-11.0f, -17.9814f, -10.9516f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.chest.setTextureOffset(108, 3).addBox(-12.0f, -12.9814f, -10.5516f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.chest.setTextureOffset(111, 16).addBox(-7.0f, -13.9814f, -9.8516f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.chest.setTextureOffset(116, 8).addBox(-11.0f, -17.9814f, -10.9516f, 3.0f, 3.0f, 2.0f, 0.2f, false);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(11.0f, -16.9814f, 16.0484f);
        this.chest.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, -0.7777f, 0.1231f, 0.124f);
        this.cube_r1.setTextureOffset(37, 115).addBox(-8.0f, -6.0f, -8.0f, 16.0f, 13.0f, 0.0f, 0.0f, false);
        this.neck = new AdvancedModelBox((AdvancedEntityModel)this, "neck");
        this.neck.setRotationPoint(0.0f, -19.8814f, -3.3516f);
        this.chest.addChild((BasicModelPart)this.neck);
        this.setRotationAngle(this.neck, -0.829f, 0.0f, 0.0f);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this, "head");
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.neck.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(78, 52).addBox(-5.0f, -5.0f, -8.0f, 10.0f, 10.0f, 10.0f, 0.0f, false);
        this.head.setTextureOffset(88, 20).addBox(5.0f, -4.0f, -7.0f, 2.0f, 3.0f, 3.0f, 0.0f, false);
        this.head.setTextureOffset(88, 16).addBox(5.0f, 0.0f, -7.0f, 1.0f, 2.0f, 2.0f, 0.0f, false);
        this.head.setTextureOffset(98, 20).addBox(5.0f, -4.0f, -7.0f, 2.0f, 3.0f, 3.0f, 0.2f, false);
        this.head.setTextureOffset(100, 74).addBox(-4.0f, -11.0f, -6.0f, 4.0f, 6.0f, 4.0f, 0.0f, false);
        this.head.setTextureOffset(110, 84).addBox(1.0f, -7.0f, -7.0f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.head.setTextureOffset(96, 114).addBox(-5.0f, 5.0f, -8.0f, 10.0f, 8.0f, 6.0f, 0.0f, false);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(-2.0f, -14.0f, -4.0f);
        this.head.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -0.7854f, 0.0f);
        this.cube_r2.setTextureOffset(116, 78).addBox(-0.5f, -3.0f, 0.0f, 2.0f, 6.0f, 0.0f, 0.0f, false);
        this.cube_r3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r3.setRotationPoint(2.5f, -8.5f, -5.5f);
        this.head.addChild((BasicModelPart)this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, -0.7854f, 0.0f);
        this.cube_r3.setTextureOffset(120, 78).addBox(0.0f, -1.5f, -1.5f, 0.0f, 3.0f, 2.0f, 0.0f, false);
        this.cube_r4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r4.setRotationPoint(2.0f, -5.0f, -3.0f);
        this.head.addChild((BasicModelPart)this.cube_r4);
        this.setRotationAngle(this.cube_r4, -0.3927f, 0.6545f, 0.0f);
        this.cube_r4.setTextureOffset(0, 112).addBox(-8.0f, -16.0f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, false);
        this.eye = new AdvancedModelBox((AdvancedEntityModel)this, "eye");
        this.eye.setRotationPoint(2.0f, -0.5f, -8.1f);
        this.head.addChild((BasicModelPart)this.eye);
        this.eye.setTextureOffset(110, 99).addBox(-0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, false);
        this.right_arm_joint = new AdvancedModelBox((AdvancedEntityModel)this, "right_arm_joint");
        this.right_arm_joint.setRotationPoint(-13.3f, -11.7814f, -1.9516f);
        this.chest.addChild((BasicModelPart)this.right_arm_joint);
        this.setRotationAngle(this.right_arm_joint, -0.829f, 0.0f, 0.0f);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this, "right_arm");
        this.right_arm.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.right_arm_joint.addChild((BasicModelPart)this.right_arm);
        this.setRotationAngle(this.right_arm, 0.0f, 0.0f, 0.3927f);
        this.right_arm.setTextureOffset(74, 74).addBox(-8.0f, -3.0f, -5.0f, 8.0f, 16.0f, 10.0f, 0.0f, false);
        this.cube_r5 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r5.setRotationPoint(-6.9021f, 3.8612f, 0.0f);
        this.right_arm.addChild((BasicModelPart)this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, 0.0f, 0.0436f);
        this.cube_r5.setTextureOffset(36, 84).addBox(-3.0f, -2.0f, -5.5f, 8.0f, 8.0f, 11.0f, 0.0f, false);
        this.cube_r6 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r6.setRotationPoint(-6.0f, 1.0f, 0.0f);
        this.right_arm.addChild((BasicModelPart)this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0f, 0.0f, 0.3054f);
        this.cube_r6.setTextureOffset(0, 62).addBox(-5.0f, -6.0f, -6.0f, 10.0f, 8.0f, 12.0f, 0.0f, false);
        this.right_arm2 = new AdvancedModelBox((AdvancedEntityModel)this, "right_arm2");
        this.right_arm2.setRotationPoint(-4.0f, 11.0f, 0.0f);
        this.right_arm.addChild((BasicModelPart)this.right_arm2);
        this.setRotationAngle(this.right_arm2, 0.0f, 0.0f, -0.3927f);
        this.right_arm2.setTextureOffset(0, 36).addBox(-5.0f, 0.0f, -6.0f, 10.0f, 14.0f, 12.0f, 0.0f, false);
        this.right_arm2.setTextureOffset(76, 114).addBox(-15.0f, -4.0f, 0.0f, 10.0f, 14.0f, 0.0f, 0.0f, true);
        this.left_arm_joint = new AdvancedModelBox((AdvancedEntityModel)this, "left_arm_joint");
        this.left_arm_joint.setRotationPoint(-13.3f, -11.7814f, -1.9516f);
        this.chest.addChild((BasicModelPart)this.left_arm_joint);
        this.setRotationAngle(this.left_arm_joint, -0.829f, 0.0f, 0.0f);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this, "left_arm");
        this.left_arm.setRotationPoint(26.6f, 0.0f, 0.0f);
        this.left_arm_joint.addChild((BasicModelPart)this.left_arm);
        this.setRotationAngle(this.left_arm, 0.0f, 0.0f, -0.3927f);
        this.left_arm.setTextureOffset(0, 82).addBox(0.0f, -3.0f, -5.0f, 8.0f, 16.0f, 10.0f, 0.0f, false);
        this.left_arm.setTextureOffset(37, 103).addBox(2.0f, 1.0f, -7.0f, 8.0f, 2.0f, 8.0f, 0.0f, false);
        this.left_arm.setTextureOffset(37, 103).addBox(4.0f, 5.0f, -9.0f, 8.0f, 2.0f, 8.0f, 0.0f, false);
        this.cube_r7 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r7.setRotationPoint(6.4663f, 5.5491f, -0.0767f);
        this.left_arm.addChild((BasicModelPart)this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0f, 0.0f, 0.9599f);
        this.cube_r7.setTextureOffset(0, 112).addBox(-12.7f, -20.8f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, false);
        this.left_arm_coral = new AdvancedModelBox((AdvancedEntityModel)this, "left_arm_coral");
        this.left_arm_coral.setRotationPoint(1.0f, 12.8f, 20.0f);
        this.left_arm.addChild((BasicModelPart)this.left_arm_coral);
        this.left_arm2 = new AdvancedModelBox((AdvancedEntityModel)this, "left_arm2");
        this.left_arm2.setRotationPoint(4.0f, 11.0f, 0.0f);
        this.left_arm.addChild((BasicModelPart)this.left_arm2);
        this.setRotationAngle(this.left_arm2, 0.0f, 0.0f, 0.3927f);
        this.left_arm2.setTextureOffset(44, 36).addBox(-5.0f, 0.0f, -6.0f, 10.0f, 14.0f, 12.0f, 0.0f, false);
        this.left_arm2.setTextureOffset(76, 114).addBox(5.0f, -4.0f, 0.0f, 10.0f, 14.0f, 0.0f, 0.0f, false);
        this.coral = new AdvancedModelBox((AdvancedEntityModel)this, "coral");
        this.coral.setRotationPoint(-9.9f, -19.0f, 4.7f);
        this.chest.addChild((BasicModelPart)this.coral);
        this.setRotationAngle(this.coral, -0.9579f, -0.3942f, 0.0159f);
        this.cube_r8 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r8.setRotationPoint(0.0f, 0.3459f, 0.0319f);
        this.coral.addChild((BasicModelPart)this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0872f, -0.0038f, 0.0435f);
        this.cube_r8.setTextureOffset(0, 112).addBox(-8.0f, -16.0f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, false);
        this.coral2 = new AdvancedModelBox((AdvancedEntityModel)this, "coral2");
        this.coral2.setRotationPoint(-6.0f, -7.3f, 7.0f);
        this.chest.addChild((BasicModelPart)this.coral2);
        this.setRotationAngle(this.coral2, 0.6262f, -0.0765f, -0.3687f);
        this.coral2.setTextureOffset(-16, 112).addBox(-7.9236f, 0.0929f, 0.3748f, 16.0f, 0.0f, 16.0f, 0.0f, false);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this, "right_leg");
        this.right_leg.setRotationPoint(-9.0f, -9.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.right_leg);
        this.right_leg.setTextureOffset(44, 62).addBox(-5.0f, -3.0f, -5.0f, 10.0f, 12.0f, 10.0f, 0.0f, false);
        this.right_leg.setTextureOffset(60, 100).addBox(-7.0f, 9.0f, -7.0f, 14.0f, 0.0f, 14.0f, 0.0f, true);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this, "left_leg");
        this.left_leg.setRotationPoint(9.0f, -9.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.left_leg);
        this.left_leg.setTextureOffset(78, 26).addBox(-5.0f, -3.0f, -5.0f, 10.0f, 12.0f, 10.0f, 0.0f, false);
        this.left_leg.setTextureOffset(60, 100).addBox(-7.0f, 9.0f, -7.0f, 14.0f, 0.0f, 14.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setupAnim(Coralssus_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float swim = entity.getSwimAmount(partialTick);
        float swimAmount = limbSwingAmount * swim;
        if (entity.getAttackState() != 6 && entity.getAttackState() != 2 && entity.getAttackState() != 7) {
            if (entity.getSwim()) {
                this.animateWalk(Coralssus_Animation.SWIM, limbSwing, swimAmount, 1.0f, 2.0f);
            } else {
                this.animateWalk(Coralssus_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            }
        }
        this.progressRotationPrev(this.head, swim, (float)Math.toRadians(-22.5), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.body, swim, (float)Math.toRadians(50.0), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.chest, swim, (float)Math.toRadians(-20.0), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.right_arm, swim, (float)Math.toRadians(-115.0), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.left_arm, swim, (float)Math.toRadians(-115.0), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.right_leg, swim, (float)Math.toRadians(57.5), 0.0f, 0.0f, 1.0f);
        this.progressRotationPrev(this.left_leg, swim, (float)Math.toRadians(57.5), 0.0f, 0.0f, 1.0f);
        this.animate(entity.getAnimationState("idle"), Coralssus_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Coralssus_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("angry"), Coralssus_Animation.ANGRY, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("nanta"), Coralssus_Animation.NANTA, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("right_fist"), Coralssus_Animation.RIGHT_FIST, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("left_fist"), Coralssus_Animation.LEFT_FIST, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("jumping_prepare"), Coralssus_Animation.JUMPING_READY, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("jumping"), Coralssus_Animation.JUMPING_LOOP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("jumping_end"), Coralssus_Animation.JUMPING_FISH, ageInTicks, 1.0f);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.body, (Object)this.chest, (Object)this.cube_r1, (Object)this.neck, (Object)this.head, (Object)this.cube_r2, (Object)this.cube_r3, (Object)this.cube_r4, (Object)this.eye, (Object)this.right_arm_joint, (Object)this.right_arm, (Object[])new AdvancedModelBox[]{this.cube_r5, this.cube_r6, this.right_arm2, this.left_arm_joint, this.left_arm, this.cube_r7, this.left_arm_coral, this.left_arm2, this.coral, this.cube_r8, this.coral2, this.right_leg, this.left_leg});
    }
}

