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

import com.skd.cataclysmbosses.entity.Deepling.Spike_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;

public class Spike_Model
extends AdvancedEntityModel<Spike_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox body;
    private final AdvancedModelBox r_fin;
    private final AdvancedModelBox right_long_fin;
    private final AdvancedModelBox left_long_fin;
    private final AdvancedModelBox l_fin;
    private final AdvancedModelBox tail;
    private final AdvancedModelBox tail2;
    private final AdvancedModelBox head;
    private final AdvancedModelBox upper_jaw;
    private final AdvancedModelBox jaw;
    private ModelAnimator animator;

    public Spike_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(0, 0).addBox(-2.0f, -6.0f, -6.0f, 4.0f, 8.0f, 11.0f, 0.0f, false);
        this.body.setTextureOffset(0, 20).addBox(0.0f, 2.0f, -5.0f, 0.0f, 6.0f, 11.0f, 0.0f, false);
        this.body.setTextureOffset(12, 31).addBox(0.0f, -12.0f, -5.0f, 0.0f, 6.0f, 11.0f, 0.0f, false);
        this.r_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.r_fin.setRotationPoint(-2.0f, -1.0f, -4.0f);
        this.body.addChild((BasicModelPart)this.r_fin);
        this.setRotationAngle(this.r_fin, 0.0f, 0.4363f, 0.0f);
        this.r_fin.setTextureOffset(24, 31).addBox(-10.0f, -5.0f, 0.0f, 10.0f, 8.0f, 0.0f, 0.0f, true);
        this.right_long_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_long_fin.setRotationPoint(-2.0f, 2.0f, -5.0f);
        this.body.addChild((BasicModelPart)this.right_long_fin);
        this.setRotationAngle(this.right_long_fin, 0.0f, 0.0f, 0.0873f);
        this.right_long_fin.setTextureOffset(19, 8).addBox(0.0f, 0.0f, -1.0f, 0.0f, 10.0f, 12.0f, 0.0f, true);
        this.left_long_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_long_fin.setRotationPoint(2.0f, 2.0f, -5.0f);
        this.body.addChild((BasicModelPart)this.left_long_fin);
        this.setRotationAngle(this.left_long_fin, 0.0f, 0.0f, -0.0873f);
        this.left_long_fin.setTextureOffset(19, 8).addBox(0.0f, 0.0f, -1.0f, 0.0f, 10.0f, 12.0f, 0.0f, false);
        this.l_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.l_fin.setRotationPoint(2.0f, -1.0f, -4.0f);
        this.body.addChild((BasicModelPart)this.l_fin);
        this.setRotationAngle(this.l_fin, 0.0f, -0.4363f, 0.0f);
        this.l_fin.setTextureOffset(24, 31).addBox(0.0f, -5.0f, 0.0f, 10.0f, 8.0f, 0.0f, 0.0f, false);
        this.tail = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail.setRotationPoint(0.0f, -3.0f, 5.0f);
        this.body.addChild((BasicModelPart)this.tail);
        this.tail.setTextureOffset(0, 20).addBox(0.0f, 2.0f, 0.0f, 0.0f, 2.0f, 4.0f, 0.0f, false);
        this.tail.setTextureOffset(35, 40).addBox(-1.5f, -2.0f, 0.0f, 3.0f, 4.0f, 5.0f, 0.0f, false);
        this.tail.setTextureOffset(0, 0).addBox(0.0f, -5.0f, 0.0f, 0.0f, 3.0f, 4.0f, 0.0f, false);
        this.tail2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tail2.setRotationPoint(0.0f, 0.0f, 5.0f);
        this.tail.addChild((BasicModelPart)this.tail2);
        this.tail2.setTextureOffset(32, 0).addBox(0.0f, -5.0f, 0.0f, 0.0f, 9.0f, 7.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -1.0f, -6.0f);
        this.body.addChild((BasicModelPart)this.head);
        this.upper_jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upper_jaw.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.upper_jaw);
        this.upper_jaw.setTextureOffset(44, 13).addBox(-1.5f, -2.0f, -4.0f, 3.0f, 4.0f, 4.0f, 0.0f, false);
        this.upper_jaw.setTextureOffset(40, 0).addBox(-1.5f, 1.0f, -4.0f, 3.0f, 0.0f, 4.0f, 0.0f, false);
        this.upper_jaw.setTextureOffset(0, 38).addBox(0.0f, -4.0f, -4.0f, 0.0f, 2.0f, 4.0f, 0.0f, false);
        this.upper_jaw.setTextureOffset(12, 20).addBox(0.0f, -4.0f, -6.0f, 0.0f, 5.0f, 2.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, 0.7f, -1.0f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.jaw.setTextureOffset(44, 22).addBox(-1.5f, -0.5f, -3.5f, 3.0f, 3.0f, 4.0f, 0.025f, false);
        this.jaw.setTextureOffset(20, 0).addBox(-1.5f, 2.5f, -3.5f, 3.0f, 0.0f, 4.0f, 0.0f, false);
        this.jaw.setTextureOffset(20, 5).addBox(-1.5f, -0.5f, 0.5f, 3.0f, 3.0f, 0.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(Spike_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Spike_Entity.LIONFISH_BITE);
        this.animator.startKeyframe(5);
        this.animator.rotate(this.root, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
        this.animator.rotate(this.r_fin, 0.0f, (float)Math.toRadians(-22.5), 0.0f);
        this.animator.rotate(this.l_fin, 0.0f, (float)Math.toRadians(22.5), 0.0f);
        this.animator.rotate(this.tail, (float)Math.toRadians(-2.5), 0.0f, 0.0f);
        this.animator.rotate(this.upper_jaw, (float)Math.toRadians(-27.5), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(45.0), 0.0f, 0.0f);
        this.animator.rotate(this.tail2, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.startKeyframe(2);
        this.animator.rotate(this.root, (float)Math.toRadians(7.5), 0.0f, 0.0f);
        this.animator.rotate(this.r_fin, 0.0f, (float)Math.toRadians(35.0), 0.0f);
        this.animator.rotate(this.body, (float)Math.toRadians(20.0), 0.0f, 0.0f);
        this.animator.rotate(this.l_fin, 0.0f, (float)Math.toRadians(-35.0), 0.0f);
        this.animator.rotate(this.tail, (float)Math.toRadians(20.0), 0.0f, 0.0f);
        this.animator.rotate(this.upper_jaw, (float)Math.toRadians(-7.5), 0.0f, 0.0f);
        this.animator.rotate(this.jaw, (float)Math.toRadians(-35.0), 0.0f, 0.0f);
        this.animator.rotate(this.tail2, (float)Math.toRadians(17.5), 0.0f, 0.0f);
        this.animator.endKeyframe();
        this.animator.resetKeyframe(2);
        this.animator.setStaticKeyframe(10);
    }

    public void setupAnim(Spike_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float idleSpeed = 0.2f;
        float idleDegree = 0.3f;
        float swimSpeed = 0.55f;
        float swimDegree = 0.7f;
        AdvancedModelBox[] tailBoxes = new AdvancedModelBox[]{this.tail, this.tail2};
        float partialTick = ageInTicks - (float)entityIn.tickCount;
        float landProgress = entityIn.prevOnLandProgress + (entityIn.onLandProgress - entityIn.prevOnLandProgress) * partialTick;
        this.progressRotationPrev(this.body, landProgress, 0.0f, 0.0f, (float)Math.toRadians(-90.0), 5.0f);
        this.chainSwing(tailBoxes, idleSpeed, idleDegree * 0.1f, 3.0, ageInTicks, 1.0f);
        this.swing(this.r_fin, idleSpeed * 0.5f, idleDegree * 0.4f, true, 0.0f, -0.12f, ageInTicks, 1.0f);
        this.swing(this.l_fin, idleSpeed * 0.5f, idleDegree * 0.4f, false, 0.0f, -0.12f, ageInTicks, 1.0f);
        this.walk(this.right_long_fin, idleSpeed * 0.5f, idleDegree * 0.2f, true, 0.0f, -0.06f, ageInTicks, 1.0f);
        this.walk(this.left_long_fin, idleSpeed * 0.5f, idleDegree * 0.2f, true, 0.0f, -0.06f, ageInTicks, 1.0f);
        this.swing(this.r_fin, swimSpeed * 0.5f, swimDegree * 0.4f, true, 0.0f, -0.28f, limbSwing, limbSwingAmount);
        this.swing(this.l_fin, swimSpeed * 0.5f, swimDegree * 0.4f, false, 0.0f, -0.28f, limbSwing, limbSwingAmount);
        this.walk(this.right_long_fin, swimSpeed * 0.5f, swimDegree * 0.2f, true, 0.0f, -0.14f, limbSwing, limbSwingAmount);
        this.walk(this.left_long_fin, swimSpeed * 0.5f, swimDegree * 0.2f, true, 0.0f, -0.14f, limbSwing, limbSwingAmount);
        this.chainSwing(tailBoxes, swimSpeed, swimDegree, -2.0, limbSwing, limbSwingAmount);
        this.body.rotateAngleX += headPitch * ((float)Math.PI / 180);
        this.head.rotateAngleX -= headPitch * 0.5f * ((float)Math.PI / 180);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.body, (Object)this.tail, (Object)this.tail2, (Object)this.l_fin, (Object)this.left_long_fin, (Object)this.right_long_fin, (Object)this.upper_jaw, (Object)this.jaw, (Object)this.head, (Object)this.r_fin);
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

