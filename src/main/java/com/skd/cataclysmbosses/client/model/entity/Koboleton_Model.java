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
 *  net.minecraft.util.Mth
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.AnimationMonster.Koboleton_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class Koboleton_Model
extends AdvancedEntityModel<Koboleton_Entity> {
    public final AdvancedModelBox root;
    private final AdvancedModelBox legs;
    private final AdvancedModelBox right_leg;
    private final AdvancedModelBox right_fore_leg;
    private final AdvancedModelBox right_foot;
    private final AdvancedModelBox left_leg;
    private final AdvancedModelBox left_fore_leg;
    private final AdvancedModelBox left_foot;
    public final AdvancedModelBox pelvis;
    private final AdvancedModelBox pelvis_cube;
    public final AdvancedModelBox lower_body;
    public final AdvancedModelBox body;
    public final AdvancedModelBox right_arm;
    public final AdvancedModelBox right_weapon;
    public final AdvancedModelBox left_arm;
    public final AdvancedModelBox left_weapon;
    private final AdvancedModelBox neck;
    private final AdvancedModelBox head;
    private final AdvancedModelBox nose;
    private final AdvancedModelBox right_eyebrow;
    private final AdvancedModelBox left_eyebrow;
    private final AdvancedModelBox skull;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox tail1;
    private final AdvancedModelBox tail2;
    private ModelAnimator animator;

    public Koboleton_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.legs = new AdvancedModelBox((AdvancedEntityModel)this);
        this.legs.setRotationPoint(0.0f, -16.1231f, 2.3724f);
        this.root.addChild((BasicModelPart)this.legs);
        this.setRotationAngle(this.legs, -0.1745f, 0.0f, 0.0f);
        this.right_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_leg.setRotationPoint(-1.4f, 0.9227f, -1.2917f);
        this.legs.addChild((BasicModelPart)this.right_leg);
        this.setRotationAngle(this.right_leg, -0.7338f, 0.1309f, 0.0218f);
        this.right_leg.setTextureOffset(25, 28).addBox(-4.0f, -0.9024f, -1.4616f, 5.0f, 8.0f, 6.0f, 0.0f, false);
        this.right_fore_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_fore_leg.setRotationPoint(-1.5f, 4.0976f, 1.5384f);
        this.right_leg.addChild((BasicModelPart)this.right_fore_leg);
        this.setRotationAngle(this.right_fore_leg, 0.9425f, -1.0E-4f, 7.0E-4f);
        this.right_fore_leg.setTextureOffset(19, 52).addBox(-2.0027f, 2.8653f, -0.8643f, 4.0f, 8.0f, 3.0f, 0.0f, false);
        this.right_foot = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_foot.setRotationPoint(0.0f, 11.0f, -1.0f);
        this.right_fore_leg.addChild((BasicModelPart)this.right_foot);
        this.setRotationAngle(this.right_foot, -0.1745f, 0.0f, 0.0f);
        this.right_foot.setTextureOffset(0, 0).addBox(1.5005f, -2.398f, -3.6296f, 0.0f, 4.0f, 5.0f, 0.0f, false);
        this.right_foot.setTextureOffset(0, 0).addBox(-1.4995f, -2.398f, -3.6296f, 0.0f, 4.0f, 5.0f, 0.0f, false);
        this.right_foot.setTextureOffset(0, 0).addBox(5.0E-4f, -2.398f, -3.6296f, 0.0f, 4.0f, 5.0f, 0.0f, false);
        this.left_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_leg.setRotationPoint(1.4f, 0.9227f, -1.2917f);
        this.legs.addChild((BasicModelPart)this.left_leg);
        this.setRotationAngle(this.left_leg, -0.7338f, -0.1309f, -0.0218f);
        this.left_leg.setTextureOffset(25, 28).addBox(-1.0f, -0.9024f, -1.4616f, 5.0f, 8.0f, 6.0f, 0.0f, true);
        this.left_fore_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_fore_leg.setRotationPoint(1.5f, 4.0976f, 1.5384f);
        this.left_leg.addChild((BasicModelPart)this.left_fore_leg);
        this.setRotationAngle(this.left_fore_leg, 0.9425f, 1.0E-4f, -7.0E-4f);
        this.left_fore_leg.setTextureOffset(19, 52).addBox(-1.9973f, 2.8653f, -0.8643f, 4.0f, 8.0f, 3.0f, 0.0f, true);
        this.left_foot = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_foot.setRotationPoint(0.0f, 11.0f, -1.0f);
        this.left_fore_leg.addChild((BasicModelPart)this.left_foot);
        this.setRotationAngle(this.left_foot, -0.1745f, 0.0f, 0.0f);
        this.left_foot.setTextureOffset(0, 0).addBox(-1.5005f, -2.398f, -3.6296f, 0.0f, 4.0f, 5.0f, 0.0f, true);
        this.left_foot.setTextureOffset(0, 0).addBox(1.4995f, -2.398f, -3.6296f, 0.0f, 4.0f, 5.0f, 0.0f, true);
        this.left_foot.setTextureOffset(0, 0).addBox(-5.0E-4f, -2.398f, -3.6296f, 0.0f, 4.0f, 5.0f, 0.0f, true);
        this.pelvis = new AdvancedModelBox((AdvancedEntityModel)this);
        this.pelvis.setRotationPoint(0.0f, -18.1231f, -1.6276f);
        this.root.addChild((BasicModelPart)this.pelvis);
        this.setRotationAngle(this.pelvis, -0.1745f, 0.0f, 0.0f);
        this.pelvis_cube = new AdvancedModelBox((AdvancedEntityModel)this);
        this.pelvis_cube.setRotationPoint(-1.0f, 0.0f, 1.0f);
        this.pelvis.addChild((BasicModelPart)this.pelvis_cube);
        this.setRotationAngle(this.pelvis_cube, 0.0436f, 0.0f, 0.0f);
        this.pelvis_cube.setTextureOffset(21, 43).addBox(-3.0f, 0.6977f, -0.5221f, 8.0f, 4.0f, 4.0f, 0.0f, false);
        this.lower_body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.lower_body.setRotationPoint(0.0f, 0.9281f, 2.6476f);
        this.pelvis.addChild((BasicModelPart)this.lower_body);
        this.setRotationAngle(this.lower_body, 1.0036f, 0.0f, 0.0f);
        this.lower_body.setTextureOffset(0, 46).addBox(-3.0f, -4.9281f, -1.6476f, 6.0f, 7.0f, 3.0f, 0.0f, false);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0895f, -3.9281f, 1.7524f);
        this.lower_body.addChild((BasicModelPart)this.body);
        this.setRotationAngle(this.body, 0.2611f, 0.0f, 0.0f);
        this.body.setTextureOffset(0, 34).addBox(-3.5895f, -6.0f, -5.0f, 7.0f, 6.0f, 5.0f, 0.0f, false);
        this.right_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_arm.setRotationPoint(-5.2895f, -4.5769f, -0.7724f);
        this.body.addChild((BasicModelPart)this.right_arm);
        this.setRotationAngle(this.right_arm, 0.2618f, 0.0f, 0.3491f);
        this.right_arm.setTextureOffset(0, 0).addBox(-1.5f, -1.5f, -12.0f, 3.0f, 3.0f, 13.0f, 0.0f, false);
        this.right_arm.setTextureOffset(19, 21).addBox(-2.0f, -1.0f, -17.0f, 4.0f, 0.0f, 5.0f, 0.0f, false);
        this.right_arm.setTextureOffset(19, 21).addBox(-2.0f, 0.0f, -17.0f, 4.0f, 0.0f, 5.0f, 0.0f, false);
        this.right_arm.setTextureOffset(19, 21).addBox(-2.0f, 1.0f, -17.0f, 4.0f, 0.0f, 5.0f, 0.0f, false);
        this.right_weapon = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_weapon.setRotationPoint(0.0f, 0.0f, -14.5f);
        this.right_arm.addChild((BasicModelPart)this.right_weapon);
        this.left_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_arm.setRotationPoint(5.1105f, -4.5769f, -0.7724f);
        this.body.addChild((BasicModelPart)this.left_arm);
        this.setRotationAngle(this.left_arm, 0.2182f, 0.0f, -0.3491f);
        this.left_arm.setTextureOffset(0, 0).addBox(-1.5f, -1.5f, -12.0f, 3.0f, 3.0f, 13.0f, 0.0f, true);
        this.left_arm.setTextureOffset(19, 21).addBox(-2.0f, -1.0f, -17.0f, 4.0f, 0.0f, 5.0f, 0.0f, true);
        this.left_arm.setTextureOffset(19, 21).addBox(-2.0f, 0.0f, -17.0f, 4.0f, 0.0f, 5.0f, 0.0f, true);
        this.left_arm.setTextureOffset(19, 21).addBox(-2.0f, 1.0f, -17.0f, 4.0f, 0.0f, 5.0f, 0.0f, true);
        this.left_weapon = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_weapon.setRotationPoint(0.0f, 0.0f, -14.5f);
        this.left_arm.addChild((BasicModelPart)this.left_weapon);
        this.neck = new AdvancedModelBox((AdvancedEntityModel)this);
        this.neck.setRotationPoint(0.0f, -8.0f, -3.5f);
        this.body.addChild((BasicModelPart)this.neck);
        this.setRotationAngle(this.neck, -1.1345f, 0.0f, 0.0f);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.neck.addChild((BasicModelPart)this.head);
        this.nose = new AdvancedModelBox((AdvancedEntityModel)this);
        this.nose.setRotationPoint(-0.0895f, 7.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.nose);
        this.setRotationAngle(this.nose, 0.3491f, 0.0f, 0.0f);
        this.nose.setTextureOffset(46, 46).addBox(-2.0f, -11.0f, -5.0f, 4.0f, 4.0f, 5.0f, 0.0f, false);
        this.right_eyebrow = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_eyebrow.setRotationPoint(-1.5895f, -1.0f, -6.0f);
        this.head.addChild((BasicModelPart)this.right_eyebrow);
        this.setRotationAngle(this.right_eyebrow, 0.3386f, -0.283f, 0.0405f);
        this.right_eyebrow.setTextureOffset(38, 0).addBox(-0.8137f, -1.9404f, 0.0575f, 3.0f, 2.0f, 8.0f, 0.0f, false);
        this.left_eyebrow = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_eyebrow.setRotationPoint(1.4105f, -1.0f, -6.0f);
        this.head.addChild((BasicModelPart)this.left_eyebrow);
        this.setRotationAngle(this.left_eyebrow, 0.3386f, 0.283f, -0.0405f);
        this.left_eyebrow.setTextureOffset(38, 0).addBox(-2.1863f, -1.9404f, 0.0575f, 3.0f, 2.0f, 8.0f, 0.0f, true);
        this.skull = new AdvancedModelBox((AdvancedEntityModel)this);
        this.skull.setRotationPoint(-0.5895f, 7.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.skull);
        this.setRotationAngle(this.skull, 0.1745f, 0.0f, 0.0f);
        this.skull.setTextureOffset(42, 21).addBox(-2.0f, -10.9f, -3.0f, 5.0f, 4.0f, 6.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, 0.0f, -1.0f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.setRotationAngle(this.jaw, 0.3927f, 0.0f, 0.0f);
        this.jaw.setTextureOffset(42, 36).addBox(-1.5895f, -0.7753f, -6.2929f, 3.0f, 2.0f, 7.0f, 0.0f, false);
        this.tail1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail1.setRotationPoint(1.0f, 1.0f, 4.0f);
        this.pelvis.addChild((BasicModelPart)this.tail1);
        this.tail1.setTextureOffset(0, 17).addBox(-2.5f, -2.0f, 0.0f, 3.0f, 4.0f, 12.0f, 0.0f, false);
        this.tail2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail2.setRotationPoint(0.0f, -0.5f, 11.0f);
        this.tail1.addChild((BasicModelPart)this.tail2);
        this.setRotationAngle(this.tail2, 0.1745f, 0.0f, 0.0f);
        this.tail2.setTextureOffset(21, 5).addBox(-2.0f, -1.1888f, -1.1585f, 2.0f, 3.0f, 12.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(Koboleton_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Koboleton_Entity.COBOLETON_ATTACK);
        if (!entity.isAggressive()) {
            if (entity.isLeftHanded()) {
                this.animator.startKeyframe(8);
                this.animator.rotate(this.root, 0.0f, (float)Math.toRadians(-20.0), 0.0f);
                this.animator.rotate(this.left_leg, (float)Math.toRadians(10.0), (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
                this.animator.move(this.left_leg, 1.0f, -1.0f, 1.0f);
                this.animator.rotate(this.right_leg, 0.0f, (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
                this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(10.0), (float)Math.toRadians(10.0));
                this.animator.rotate(this.body, (float)Math.toRadians(10.0), (float)Math.toRadians(-2.5), (float)Math.toRadians(5.0));
                this.animator.rotate(this.left_arm, (float)Math.toRadians(115.0), (float)Math.toRadians(7.5), (float)Math.toRadians(-10.0));
                this.animator.rotate(this.right_arm, (float)Math.toRadians(20.0), (float)Math.toRadians(25.0), (float)Math.toRadians(12.5));
                this.animator.rotate(this.left_weapon, (float)Math.toRadians(90.0), (float)Math.toRadians(-2.5), (float)Math.toRadians(-90.0));
                this.animator.rotate(this.neck, 0.0f, (float)Math.toRadians(7.5), 0.0f);
                this.animator.rotate(this.jaw, (float)Math.toRadians(22.5), 0.0f, 0.0f);
                this.animator.rotate(this.tail1, (float)Math.toRadians(-2.5), (float)Math.toRadians(-17.5), 0.0f);
                this.animator.rotate(this.tail2, (float)Math.toRadians(17.5), (float)Math.toRadians(-7.5), (float)Math.toRadians(-2.5));
                this.animator.endKeyframe();
                this.animator.startKeyframe(4);
                this.animator.rotate(this.root, (float)Math.toRadians(22.5), (float)Math.toRadians(40.0), (float)Math.toRadians(20.0));
                this.animator.rotate(this.left_leg, (float)Math.toRadians(20.0), (float)Math.toRadians(-12.5), (float)Math.toRadians(-25.0));
                this.animator.move(this.left_leg, 1.0f, -2.0f, 1.0f);
                this.animator.rotate(this.right_leg, (float)Math.toRadians(-7.5), (float)Math.toRadians(12.5), 0.0f);
                this.animator.rotate(this.pelvis, 0.0f, (float)Math.toRadians(42.5), 0.0f);
                this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(17.5), (float)Math.toRadians(10.0));
                this.animator.rotate(this.body, (float)Math.toRadians(20.0), (float)Math.toRadians(35.0), (float)Math.toRadians(-7.5));
                this.animator.rotate(this.left_arm, (float)Math.toRadians(-5.0), (float)Math.toRadians(-35.0), (float)Math.toRadians(-90.0));
                this.animator.rotate(this.right_arm, (float)Math.toRadians(112.5), (float)Math.toRadians(12.5), (float)Math.toRadians(32.5));
                this.animator.rotate(this.left_weapon, (float)Math.toRadians(92.5), 0.0f, (float)Math.toRadians(-180.0));
                this.animator.rotate(this.neck, (float)Math.toRadians(-10.0), (float)Math.toRadians(5.0), (float)Math.toRadians(10.0));
                this.animator.rotate(this.jaw, (float)Math.toRadians(22.5), 0.0f, 0.0f);
                this.animator.rotate(this.tail1, (float)Math.toRadians(10.0), (float)Math.toRadians(30.0), (float)Math.toRadians(7.5));
                this.animator.rotate(this.tail2, (float)Math.toRadians(17.5), (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
                this.animator.endKeyframe();
                this.animator.resetKeyframe(7);
            } else {
                this.animator.startKeyframe(8);
                this.animator.rotate(this.root, 0.0f, (float)Math.toRadians(20.0), 0.0f);
                this.animator.rotate(this.right_leg, (float)Math.toRadians(10.0), (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
                this.animator.move(this.right_leg, -1.0f, -1.0f, 1.0f);
                this.animator.rotate(this.left_leg, 0.0f, (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
                this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(-10.0));
                this.animator.rotate(this.body, (float)Math.toRadians(10.0), (float)Math.toRadians(2.5), (float)Math.toRadians(-5.0));
                this.animator.rotate(this.right_arm, (float)Math.toRadians(115.0), (float)Math.toRadians(-7.5), (float)Math.toRadians(10.0));
                this.animator.rotate(this.right_weapon, (float)Math.toRadians(90.0), (float)Math.toRadians(2.5), (float)Math.toRadians(90.0));
                this.animator.rotate(this.left_arm, (float)Math.toRadians(20.0), (float)Math.toRadians(-25.0), (float)Math.toRadians(-12.5));
                this.animator.rotate(this.neck, 0.0f, (float)Math.toRadians(-7.5), 0.0f);
                this.animator.rotate(this.jaw, (float)Math.toRadians(22.5), 0.0f, 0.0f);
                this.animator.rotate(this.tail1, (float)Math.toRadians(-2.5), (float)Math.toRadians(17.5), 0.0f);
                this.animator.rotate(this.tail2, (float)Math.toRadians(17.5), (float)Math.toRadians(7.5), (float)Math.toRadians(2.5));
                this.animator.endKeyframe();
                this.animator.startKeyframe(4);
                this.animator.rotate(this.root, (float)Math.toRadians(22.5), (float)Math.toRadians(-40.0), (float)Math.toRadians(-20.0));
                this.animator.rotate(this.right_leg, (float)Math.toRadians(20.0), (float)Math.toRadians(12.5), (float)Math.toRadians(25.0));
                this.animator.move(this.right_leg, -1.0f, -2.0f, 1.0f);
                this.animator.rotate(this.left_leg, (float)Math.toRadians(-7.5), (float)Math.toRadians(-12.5), 0.0f);
                this.animator.rotate(this.pelvis, 0.0f, (float)Math.toRadians(-42.5), 0.0f);
                this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(-17.5), (float)Math.toRadians(-10.0));
                this.animator.rotate(this.body, (float)Math.toRadians(20.0), (float)Math.toRadians(-35.0), (float)Math.toRadians(7.5));
                this.animator.rotate(this.right_arm, (float)Math.toRadians(-5.0), (float)Math.toRadians(35.0), (float)Math.toRadians(90.0));
                this.animator.rotate(this.right_weapon, (float)Math.toRadians(92.5), 0.0f, (float)Math.toRadians(180.0));
                this.animator.rotate(this.left_arm, (float)Math.toRadians(112.5), (float)Math.toRadians(-12.5), (float)Math.toRadians(-32.5));
                this.animator.rotate(this.neck, (float)Math.toRadians(-10.0), (float)Math.toRadians(-5.0), (float)Math.toRadians(-10.0));
                this.animator.rotate(this.jaw, (float)Math.toRadians(22.5), 0.0f, 0.0f);
                this.animator.rotate(this.tail1, (float)Math.toRadians(10.0), (float)Math.toRadians(-30.0), (float)Math.toRadians(-7.5));
                this.animator.rotate(this.tail2, (float)Math.toRadians(17.5), (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
                this.animator.endKeyframe();
                this.animator.resetKeyframe(7);
            }
        } else if (entity.isLeftHanded()) {
            this.animator.startKeyframe(8);
            this.animator.rotate(this.root, 0.0f, (float)Math.toRadians(-20.0), 0.0f);
            this.animator.rotate(this.legs, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(10.0), (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
            this.animator.move(this.left_leg, 1.0f, -1.0f, 1.0f);
            this.animator.rotate(this.right_leg, 0.0f, (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
            this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(10.0), (float)Math.toRadians(10.0));
            this.animator.rotate(this.body, (float)Math.toRadians(10.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(5.0));
            this.animator.rotate(this.left_arm, (float)Math.toRadians(22.5), (float)Math.toRadians(2.5), (float)Math.toRadians(2.5));
            this.animator.rotate(this.left_weapon, (float)Math.toRadians(90.0), (float)Math.toRadians(-2.5), (float)Math.toRadians(-90.0));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-45.0), (float)Math.toRadians(25.0), (float)Math.toRadians(12.5));
            this.animator.rotate(this.neck, (float)Math.toRadians(-7.5), (float)Math.toRadians(7.5), 0.0f);
            this.animator.rotate(this.jaw, (float)Math.toRadians(15.0), 0.0f, 0.0f);
            this.animator.rotate(this.tail1, (float)Math.toRadians(-32.5), (float)Math.toRadians(-17.5), 0.0f);
            this.animator.rotate(this.tail2, (float)Math.toRadians(52.5), (float)Math.toRadians(-7.5), (float)Math.toRadians(-2.5));
            this.animator.endKeyframe();
            this.animator.startKeyframe(4);
            this.animator.rotate(this.root, (float)Math.toRadians(22.5), (float)Math.toRadians(40.0), (float)Math.toRadians(20.0));
            this.animator.rotate(this.legs, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(20.0), (float)Math.toRadians(-12.5), (float)Math.toRadians(-25.0));
            this.animator.move(this.left_leg, 1.0f, -2.0f, 1.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(-7.5), (float)Math.toRadians(12.5), 0.0f);
            this.animator.rotate(this.pelvis, 0.0f, (float)Math.toRadians(42.5), 0.0f);
            this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(17.5), (float)Math.toRadians(10.0));
            this.animator.rotate(this.body, (float)Math.toRadians(20.0), (float)Math.toRadians(27.5), (float)Math.toRadians(-7.5));
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-97.5), (float)Math.toRadians(-40.0), (float)Math.toRadians(-77.5));
            this.animator.rotate(this.left_weapon, (float)Math.toRadians(92.5), 0.0f, (float)Math.toRadians(-180.0));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(47.5), (float)Math.toRadians(12.5), (float)Math.toRadians(32.5));
            this.animator.rotate(this.neck, (float)Math.toRadians(-17.5), (float)Math.toRadians(5.0), (float)Math.toRadians(10.0));
            this.animator.rotate(this.jaw, (float)Math.toRadians(25.0), 0.0f, 0.0f);
            this.animator.rotate(this.tail1, (float)Math.toRadians(-20.0), (float)Math.toRadians(30.0), (float)Math.toRadians(7.5));
            this.animator.rotate(this.tail2, (float)Math.toRadians(52.5), (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
            this.animator.endKeyframe();
            this.animator.resetKeyframe(7);
        } else {
            this.animator.startKeyframe(8);
            this.animator.rotate(this.root, 0.0f, (float)Math.toRadians(20.0), 0.0f);
            this.animator.rotate(this.legs, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(10.0), (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
            this.animator.move(this.right_leg, -1.0f, -1.0f, 1.0f);
            this.animator.rotate(this.left_leg, 0.0f, (float)Math.toRadians(-7.5), (float)Math.toRadians(-5.0));
            this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(-10.0), (float)Math.toRadians(-10.0));
            this.animator.rotate(this.body, (float)Math.toRadians(10.0), (float)Math.toRadians(10.0), (float)Math.toRadians(-5.0));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(22.5), (float)Math.toRadians(-2.5), (float)Math.toRadians(-2.5));
            this.animator.rotate(this.right_weapon, (float)Math.toRadians(90.0), (float)Math.toRadians(2.5), (float)Math.toRadians(90.0));
            this.animator.rotate(this.left_arm, (float)Math.toRadians(-45.0), (float)Math.toRadians(-25.0), (float)Math.toRadians(-12.5));
            this.animator.rotate(this.neck, (float)Math.toRadians(-7.5), (float)Math.toRadians(-7.5), 0.0f);
            this.animator.rotate(this.jaw, (float)Math.toRadians(15.0), 0.0f, 0.0f);
            this.animator.rotate(this.tail1, (float)Math.toRadians(-32.5), (float)Math.toRadians(17.5), 0.0f);
            this.animator.rotate(this.tail2, (float)Math.toRadians(52.5), (float)Math.toRadians(7.5), (float)Math.toRadians(2.5));
            this.animator.endKeyframe();
            this.animator.startKeyframe(4);
            this.animator.rotate(this.root, (float)Math.toRadians(22.5), (float)Math.toRadians(-40.0), (float)Math.toRadians(-20.0));
            this.animator.rotate(this.legs, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
            this.animator.rotate(this.right_leg, (float)Math.toRadians(20.0), (float)Math.toRadians(12.5), (float)Math.toRadians(25.0));
            this.animator.move(this.right_leg, -1.0f, -2.0f, 1.0f);
            this.animator.rotate(this.left_leg, (float)Math.toRadians(-7.5), (float)Math.toRadians(-12.5), 0.0f);
            this.animator.rotate(this.pelvis, 0.0f, (float)Math.toRadians(-42.5), 0.0f);
            this.animator.rotate(this.lower_body, (float)Math.toRadians(-5.0), (float)Math.toRadians(-17.5), (float)Math.toRadians(-10.0));
            this.animator.rotate(this.body, (float)Math.toRadians(20.0), (float)Math.toRadians(-27.5), (float)Math.toRadians(7.5));
            this.animator.rotate(this.right_arm, (float)Math.toRadians(-97.5), (float)Math.toRadians(40.0), (float)Math.toRadians(77.5));
            this.animator.rotate(this.right_weapon, (float)Math.toRadians(92.5), 0.0f, (float)Math.toRadians(180.0));
            this.animator.rotate(this.left_arm, (float)Math.toRadians(47.5), (float)Math.toRadians(-12.5), (float)Math.toRadians(-32.5));
            this.animator.rotate(this.neck, (float)Math.toRadians(-17.5), (float)Math.toRadians(-5.0), (float)Math.toRadians(-10.0));
            this.animator.rotate(this.jaw, (float)Math.toRadians(25.0), 0.0f, 0.0f);
            this.animator.rotate(this.tail1, (float)Math.toRadians(-20.0), (float)Math.toRadians(-30.0), (float)Math.toRadians(-7.5));
            this.animator.rotate(this.tail2, (float)Math.toRadians(52.5), (float)Math.toRadians(7.5), (float)Math.toRadians(5.0));
            this.animator.endKeyframe();
            this.animator.resetKeyframe(7);
        }
    }

    public void setupAnim(Koboleton_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float walkSpeed = 0.5f;
        float runSpeed = 0.8f;
        float walkDegree = 0.5f;
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float angryProgress = entityIn.prevangryProgress + (entityIn.angryProgress - entityIn.prevangryProgress) * partialTick;
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        this.walk(this.lower_body, walkSpeed * 0.1f, walkDegree * 0.2f, false, 0.0f, walkDegree * 0.0625f, ageInTicks, 1.0f);
        this.walk(this.jaw, walkSpeed * 0.1f, walkDegree * 0.2f, false, 0.0f, walkDegree * 0.2f, ageInTicks, 1.0f);
        this.right_arm.rotationPointY -= Mth.cos((float)(ageInTicks * walkSpeed * 0.1f + 1.0f)) * 0.5f + 0.5f;
        this.left_arm.rotationPointY -= Mth.cos((float)(ageInTicks * walkSpeed * 0.1f + 1.0f)) * 0.5f + 0.5f;
        this.right_arm.rotationPointZ += Mth.cos((float)(ageInTicks * walkSpeed * 0.1f)) * 1.0f - 1.0f;
        this.left_arm.rotationPointZ += Mth.cos((float)(ageInTicks * walkSpeed * 0.1f)) * 1.0f - 1.0f;
        if (angryProgress <= 0.0f) {
            this.walk(this.left_leg, walkSpeed, walkDegree * 1.2f, true, 0.0f, -0.2f, limbSwing, limbSwingAmount);
            this.walk(this.left_arm, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.0f, limbSwing, limbSwingAmount);
            this.walk(this.left_fore_leg, walkSpeed, walkDegree * 0.5f, true, -1.0f, -0.2f, limbSwing, limbSwingAmount);
            this.walk(this.left_foot, walkSpeed, walkDegree * -1.0f, true, -1.5f, 0.0f, limbSwing, limbSwingAmount);
            this.left_foot.rotationPointY -= Math.abs((float)(Math.cos(limbSwing * walkSpeed - 1.5f) * (double)walkDegree * 1.5 * (double)limbSwingAmount));
            this.walk(this.right_leg, walkSpeed, walkDegree * 1.2f, false, 0.0f, 0.2f, limbSwing, limbSwingAmount);
            this.walk(this.right_arm, walkSpeed, walkDegree * 1.2f, true, 0.0f, 0.0f, limbSwing, limbSwingAmount);
            this.walk(this.right_fore_leg, walkSpeed, walkDegree * 0.5f, false, -1.0f, -0.2f, limbSwing, limbSwingAmount);
            this.walk(this.right_foot, walkSpeed, walkDegree * -1.0f, false, -1.5f, 0.0f, limbSwing, limbSwingAmount);
            this.right_foot.rotationPointY -= Math.abs((float)(Math.cos(limbSwing * walkSpeed - 1.5f) * (double)walkDegree * 1.5 * (double)limbSwingAmount));
            this.walk(this.tail1, walkSpeed * 0.1f, walkDegree * 0.8f, true, 0.0f, walkDegree * 0.35f, ageInTicks, 1.0f);
            this.walk(this.tail2, walkSpeed * 0.1f, walkDegree * 0.8f, false, 1.0f, 0.0f, ageInTicks, 1.0f);
        } else {
            this.walk(this.left_leg, runSpeed, walkDegree * 3.0f, true, 0.0f, -0.5f, limbSwing, limbSwingAmount);
            this.left_foot.rotationPointY -= Math.abs((float)(Math.cos(limbSwing * walkSpeed - 1.5f) * (double)walkDegree * 1.5 * (double)limbSwingAmount));
            this.walk(this.right_leg, runSpeed, walkDegree * 3.0f, false, 0.0f, 0.5f, limbSwing, limbSwingAmount);
            if (entityIn.isLeftHanded()) {
                this.walk(this.right_arm, runSpeed, walkDegree * 1.6f, false, 0.0f, -walkDegree * 1.6f, limbSwing, limbSwingAmount);
                this.walk(this.left_arm, runSpeed, walkDegree * 0.6f, true, 0.0f, -walkDegree * 0.6f, limbSwing, limbSwingAmount);
            } else {
                this.walk(this.left_arm, runSpeed, walkDegree * 1.6f, false, 0.0f, -walkDegree * 1.6f, limbSwing, limbSwingAmount);
                this.walk(this.right_arm, runSpeed, walkDegree * 0.6f, true, 0.0f, -walkDegree * 0.6f, limbSwing, limbSwingAmount);
            }
            this.right_foot.rotationPointY -= Math.abs((float)(Math.cos(limbSwing * walkSpeed - 1.5f) * (double)walkDegree * 1.5 * (double)limbSwingAmount));
            this.walk(this.tail1, runSpeed, walkDegree * 1.6f, true, 0.0f, walkDegree * 0.8f, limbSwing, limbSwingAmount);
            this.walk(this.tail2, runSpeed, walkDegree * 1.6f, false, 0.0f, walkDegree * 0.8f, limbSwing, limbSwingAmount);
            this.bob(this.root, -runSpeed, walkDegree * -6.0f, true, limbSwing, limbSwingAmount);
        }
        this.bob(this.pelvis, walkSpeed * 0.1f, walkDegree * 0.4f, false, ageInTicks, 1.0f);
        this.progressRotationPrev(this.legs, angryProgress, (float)Math.toRadians(7.5), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.body, angryProgress, 0.0f, (float)Math.toRadians(-7.5), 0.0f, 10.0f);
        if (entityIn.isLeftHanded()) {
            this.progressRotationPrev(this.left_arm, angryProgress, (float)Math.toRadians(92.5), (float)Math.toRadians(5.0), (float)Math.toRadians(-12.5), 10.0f);
            this.progressRotationPrev(this.right_arm, angryProgress, (float)Math.toRadians(65.0), 0.0f, 0.0f, 10.0f);
        } else {
            this.progressRotationPrev(this.right_arm, angryProgress, (float)Math.toRadians(92.5), (float)Math.toRadians(-5.0), (float)Math.toRadians(12.5), 10.0f);
            this.progressRotationPrev(this.left_arm, angryProgress, (float)Math.toRadians(65.0), 0.0f, 0.0f, 10.0f);
        }
        this.progressRotationPrev(this.neck, angryProgress, (float)Math.toRadians(7.5), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.jaw, angryProgress, (float)Math.toRadians(7.5), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.tail1, angryProgress, (float)Math.toRadians(30.0), 0.0f, 0.0f, 10.0f);
        this.progressRotationPrev(this.tail2, angryProgress, (float)Math.toRadians(-35.0), 0.0f, 0.0f, 10.0f);
    }

    private float walkValue(float limbSwing, float limbSwingAmount, float speed, float offset, float degree, boolean inverse) {
        return (float)(Math.cos(limbSwing * speed + offset) * (double)degree * (double)limbSwingAmount * (double)(inverse ? -1 : 1));
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.legs, this.right_leg, this.right_fore_leg, this.right_foot, this.left_leg, this.left_fore_leg, this.left_foot, this.pelvis, this.pelvis_cube, this.lower_body, this.body, (Object[])new AdvancedModelBox[]{this.right_arm, this.right_weapon, this.left_arm, this.left_weapon, this.head, this.nose, this.right_eyebrow, this.left_eyebrow, this.skull, this.jaw, this.neck, this.tail1, this.tail2});
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

