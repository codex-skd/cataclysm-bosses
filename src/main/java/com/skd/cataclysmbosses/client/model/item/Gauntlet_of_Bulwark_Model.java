/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.world.entity.Entity
 */
package com.skd.cataclysmbosses.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Gauntlet_of_Bulwark_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox gauntlet_fist;
    private final AdvancedModelBox fist_guard;
    private final AdvancedModelBox void_stone_knuckle;
    private final AdvancedModelBox spike;
    private final AdvancedModelBox void_spike;
    private final AdvancedModelBox void_spike4;
    private final AdvancedModelBox void_spike2;
    private final AdvancedModelBox void_spike3;
    private final AdvancedModelBox thumb;
    private final AdvancedModelBox gauntlet_arm;
    private final AdvancedModelBox gauntlet_arm2;
    private final AdvancedModelBox gauntlet_shoulder;
    private final AdvancedModelBox big_void_stone;
    private final AdvancedModelBox flame_spike;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox flame_spike2;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox arm_pad;

    public Gauntlet_of_Bulwark_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.gauntlet_fist = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_fist.setRotationPoint(0.0f, 0.0f, -3.5f);
        this.root.addChild((BasicModelPart)this.gauntlet_fist);
        this.gauntlet_fist.setTextureOffset(40, 0).addBox(-4.0f, -4.0f, -8.0f, 8.0f, 8.0f, 8.0f, 0.25f, false);
        this.fist_guard = new AdvancedModelBox((AdvancedEntityModel)this);
        this.fist_guard.setRotationPoint(-2.0f, 0.5f, -6.5f);
        this.gauntlet_fist.addChild((BasicModelPart)this.fist_guard);
        this.setRotationAngle(this.fist_guard, 0.0f, -0.9163f, 0.0f);
        this.fist_guard.setTextureOffset(81, 0).addBox(-4.0f, -6.0f, -4.0f, 5.0f, 11.0f, 7.0f, 0.0f, false);
        this.fist_guard.setTextureOffset(82, 18).addBox(-4.0f, -6.0f, -4.5f, 5.0f, 11.0f, 7.0f, 0.3f, false);
        this.void_stone_knuckle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.void_stone_knuckle.setRotationPoint(-5.25f, -2.5f, -6.0f);
        this.gauntlet_fist.addChild((BasicModelPart)this.void_stone_knuckle);
        this.void_stone_knuckle.setTextureOffset(56, 56).addBox(0.0f, 0.5f, 0.0f, 1.0f, 4.0f, 4.0f, 0.0f, false);
        this.spike = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike.setRotationPoint(-4.0f, -1.5f, -8.0f);
        this.gauntlet_fist.addChild((BasicModelPart)this.spike);
        this.void_spike = new AdvancedModelBox((AdvancedEntityModel)this);
        this.void_spike.setRotationPoint(0.0f, 1.5f, -1.0f);
        this.spike.addChild((BasicModelPart)this.void_spike);
        this.setRotationAngle(this.void_spike, 0.0f, 0.0436f, 0.0f);
        this.void_spike.setTextureOffset(56, 38).addBox(-2.0f, 0.0f, -6.0f, 4.0f, 0.0f, 8.0f, 0.0f, false);
        this.void_spike4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.void_spike4.setRotationPoint(6.5f, -4.25f, 0.5f);
        this.spike.addChild((BasicModelPart)this.void_spike4);
        this.setRotationAngle(this.void_spike4, 0.0161f, 0.2628f, 1.5416f);
        this.void_spike4.setTextureOffset(56, 38).addBox(-2.0f, 0.0f, -6.0f, 4.0f, 0.0f, 8.0f, 0.0f, false);
        this.void_spike2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.void_spike2.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.spike.addChild((BasicModelPart)this.void_spike2);
        this.setRotationAngle(this.void_spike2, 0.1162f, 0.0468f, -0.0553f);
        this.void_spike2.setTextureOffset(56, 38).addBox(-2.0f, 0.0f, -6.0f, 4.0f, 0.0f, 8.0f, 0.0f, false);
        this.void_spike3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.void_spike3.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.spike.addChild((BasicModelPart)this.void_spike3);
        this.setRotationAngle(this.void_spike3, -0.1548f, 0.0493f, 0.0735f);
        this.void_spike3.setTextureOffset(56, 38).addBox(-2.0f, 0.0f, -6.0f, 4.0f, 0.0f, 8.0f, 0.0f, false);
        this.thumb = new AdvancedModelBox((AdvancedEntityModel)this);
        this.thumb.setRotationPoint(3.0f, -4.5f, -4.5f);
        this.gauntlet_fist.addChild((BasicModelPart)this.thumb);
        this.setRotationAngle(this.thumb, 0.2618f, 0.0f, 0.0f);
        this.thumb.setTextureOffset(101, 11).addBox(-3.0f, -3.0f, -6.0f, 5.0f, 4.0f, 7.0f, 0.0f, false);
        this.thumb.setTextureOffset(75, 37).addBox(-3.0f, -3.0f, -6.0f, 5.0f, 4.0f, 7.0f, 0.3f, false);
        this.gauntlet_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_arm.setRotationPoint(0.0f, 0.0f, 2.5f);
        this.root.addChild((BasicModelPart)this.gauntlet_arm);
        this.gauntlet_arm.setTextureOffset(0, 45).addBox(-4.0f, -4.0f, 0.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.gauntlet_arm2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_arm2.setRotationPoint(0.0f, 0.0f, -3.5f);
        this.root.addChild((BasicModelPart)this.gauntlet_arm2);
        this.gauntlet_arm2.setTextureOffset(56, 16).addBox(-4.0f, -4.0f, 0.0f, 6.0f, 8.0f, 6.0f, 0.0f, false);
        this.gauntlet_arm2.setTextureOffset(110, 0).addBox(-3.5f, -4.0f, 2.0f, 6.0f, 8.0f, 3.0f, 0.3f, false);
        this.gauntlet_shoulder = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_shoulder.setRotationPoint(2.0f, 0.0f, 9.0f);
        this.gauntlet_arm2.addChild((BasicModelPart)this.gauntlet_shoulder);
        this.setRotationAngle(this.gauntlet_shoulder, 0.0f, 0.6109f, 0.0f);
        this.gauntlet_shoulder.setTextureOffset(0, 0).addBox(-8.0f, -5.0f, -6.0f, 8.0f, 10.0f, 12.0f, 0.0f, false);
        this.gauntlet_shoulder.setTextureOffset(32, 45).addBox(-9.0f, -6.0f, -7.0f, 9.0f, 12.0f, 3.0f, 0.0f, false);
        this.gauntlet_shoulder.setTextureOffset(30, 22).addBox(-2.0f, -6.0f, -4.0f, 2.0f, 12.0f, 11.0f, 0.0f, false);
        this.gauntlet_shoulder.setTextureOffset(0, 69).addBox(-2.0f, -7.0f, -8.0f, 4.0f, 1.0f, 4.0f, 0.0f, false);
        this.gauntlet_shoulder.setTextureOffset(0, 69).addBox(-2.0f, 6.0f, -8.0f, 4.0f, 1.0f, 4.0f, 0.0f, false);
        this.big_void_stone = new AdvancedModelBox((AdvancedEntityModel)this);
        this.big_void_stone.setRotationPoint(-8.0f, 0.0f, -2.0f);
        this.gauntlet_shoulder.addChild((BasicModelPart)this.big_void_stone);
        this.setRotationAngle(this.big_void_stone, 0.0f, 0.6109f, 0.0f);
        this.big_void_stone.setTextureOffset(56, 30).addBox(-8.0f, -2.0f, 0.0f, 8.0f, 4.0f, 4.0f, 0.0f, false);
        this.big_void_stone.setTextureOffset(0, 61).addBox(-8.0f, -2.0f, 0.0f, 8.0f, 4.0f, 4.0f, 0.3f, false);
        this.flame_spike = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flame_spike.setRotationPoint(-6.682f, 0.0f, 3.182f);
        this.gauntlet_shoulder.addChild((BasicModelPart)this.flame_spike);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(0.182f, 0.0f, -0.182f);
        this.flame_spike.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -0.7854f, 0.0f);
        this.cube_r1.setTextureOffset(-9, 80).addBox(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 9.0f, 0.0f, false);
        this.flame_spike2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flame_spike2.setRotationPoint(-9.682f, 0.0f, -1.818f);
        this.gauntlet_shoulder.addChild((BasicModelPart)this.flame_spike2);
        this.setRotationAngle(this.flame_spike2, 0.0f, -0.7854f, 0.0f);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(1.182f, 0.0f, -2.182f);
        this.flame_spike2.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -0.7854f, 0.0f);
        this.cube_r2.setTextureOffset(-9, 80).addBox(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 9.0f, 0.0f, false);
        this.arm_pad = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arm_pad.setRotationPoint(-4.5f, 0.0f, 0.0f);
        this.gauntlet_arm2.addChild((BasicModelPart)this.arm_pad);
        this.setRotationAngle(this.arm_pad, 0.0f, -0.48f, 0.0f);
        this.arm_pad.setTextureOffset(0, 22).addBox(-1.5f, -5.0f, -2.0f, 5.0f, 10.0f, 10.0f, 0.0f, false);
        this.arm_pad.setTextureOffset(40, 16).addBox(-3.5f, -6.0f, -3.0f, 5.0f, 4.0f, 2.0f, 0.0f, false);
        this.arm_pad.setTextureOffset(56, 46).addBox(-3.5f, -4.0f, -1.0f, 5.0f, 8.0f, 2.0f, 0.0f, false);
        this.arm_pad.setTextureOffset(40, 16).addBox(-3.5f, 2.0f, -3.0f, 5.0f, 4.0f, 2.0f, 0.0f, false);
        this.arm_pad.setTextureOffset(32, 60).addBox(1.5f, -6.0f, -3.0f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.arm_pad.setTextureOffset(32, 60).addBox(1.5f, 4.0f, -3.0f, 3.0f, 2.0f, 3.0f, 0.0f, false);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.gauntlet_fist, (Object)this.fist_guard, (Object)this.void_stone_knuckle, (Object)this.spike, (Object)this.void_spike, (Object)this.void_spike4, (Object)this.void_spike2, (Object)this.void_spike3, (Object)this.thumb, (Object)this.gauntlet_arm, (Object)this.gauntlet_arm2, (Object[])new AdvancedModelBox[]{this.gauntlet_shoulder, this.big_void_stone, this.flame_spike, this.cube_r1, this.flame_spike2, this.cube_r2, this.arm_pad});
    }

    public BasicModelPart root() {
        return this.root;
    }
}

