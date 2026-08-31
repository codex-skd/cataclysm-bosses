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

public class Gauntlet_of_Maelstrom_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox gauntlet_fist;
    private final AdvancedModelBox gauntlet_fist_r1;
    private final AdvancedModelBox gauntlet_fist_r2;
    private final AdvancedModelBox void_stone_knuckle;
    private final AdvancedModelBox gauntlet_arm;
    private final AdvancedModelBox gauntlet_arm2;
    private final AdvancedModelBox gauntlet_shoulder;
    private final AdvancedModelBox big_void_stone;

    public Gauntlet_of_Maelstrom_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.gauntlet_fist = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_fist.setRotationPoint(0.0f, 0.0f, -3.5f);
        this.root.addChild((BasicModelPart)this.gauntlet_fist);
        this.gauntlet_fist.setTextureOffset(24, 30).addBox(-4.0f, -4.0f, -8.0f, 8.0f, 8.0f, 8.0f, 0.25f, false);
        this.gauntlet_fist.setTextureOffset(34, 64).addBox(-5.0f, -4.5f, -10.0f, 5.0f, 9.0f, 11.0f, 0.0f, false);
        this.gauntlet_fist.setTextureOffset(37, 68).addBox(-5.0f, -8.5f, -10.0f, 1.0f, 4.0f, 3.0f, 0.0f, false);
        this.gauntlet_fist.setTextureOffset(29, 68).addBox(-5.0f, 4.5f, -10.0f, 1.0f, 4.0f, 3.0f, 0.0f, false);
        this.gauntlet_fist.setTextureOffset(23, 69).addBox(-5.0f, 4.5f, -6.0f, 1.0f, 3.0f, 2.0f, 0.0f, false);
        this.gauntlet_fist.setTextureOffset(23, 74).addBox(-5.0f, -7.5f, -6.0f, 1.0f, 3.0f, 2.0f, 0.0f, false);
        this.gauntlet_fist_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_fist_r1.setRotationPoint(-2.0f, 0.0f, -8.5f);
        this.gauntlet_fist.addChild((BasicModelPart)this.gauntlet_fist_r1);
        this.setRotationAngle(this.gauntlet_fist_r1, 0.0f, 0.2618f, 0.0f);
        this.gauntlet_fist_r1.setTextureOffset(64, 46).addBox(-2.0f, -5.0f, -7.5f, 4.0f, 10.0f, 8.0f, 0.0f, false);
        this.gauntlet_fist_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_fist_r2.setRotationPoint(3.0f, 0.0f, -6.0f);
        this.gauntlet_fist.addChild((BasicModelPart)this.gauntlet_fist_r2);
        this.setRotationAngle(this.gauntlet_fist_r2, 0.0f, -0.48f, 0.0f);
        this.gauntlet_fist_r2.setTextureOffset(72, 29).addBox(-1.5f, -4.5f, -7.0f, 3.0f, 9.0f, 8.0f, 0.25f, false);
        this.void_stone_knuckle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.void_stone_knuckle.setRotationPoint(-5.25f, -2.5f, -6.0f);
        this.gauntlet_fist.addChild((BasicModelPart)this.void_stone_knuckle);
        this.void_stone_knuckle.setTextureOffset(0, 0).addBox(0.0f, 0.5f, 0.0f, 1.0f, 4.0f, 4.0f, 0.0f, false);
        this.gauntlet_arm = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_arm.setRotationPoint(0.0f, 0.0f, 2.5f);
        this.root.addChild((BasicModelPart)this.gauntlet_arm);
        this.gauntlet_arm.setTextureOffset(0, 22).addBox(-4.0f, -4.0f, 0.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.gauntlet_arm.setTextureOffset(0, 38).addBox(-2.5f, -4.5f, -1.0f, 7.0f, 9.0f, 2.0f, 0.0f, false);
        this.gauntlet_arm2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_arm2.setRotationPoint(0.0f, 0.0f, -3.5f);
        this.root.addChild((BasicModelPart)this.gauntlet_arm2);
        this.gauntlet_arm2.setTextureOffset(34, 16).addBox(-4.0f, -4.0f, 0.0f, 6.0f, 8.0f, 6.0f, 0.0f, false);
        this.gauntlet_arm2.setTextureOffset(73, 2).addBox(-4.0f, -4.0f, 0.0f, 6.0f, 8.0f, 6.0f, -0.1f, false);
        this.gauntlet_arm2.setTextureOffset(81, 16).addBox(-3.5f, -3.5f, 0.0f, 5.0f, 7.0f, 6.0f, 0.0f, false);
        this.gauntlet_shoulder = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gauntlet_shoulder.setRotationPoint(2.0f, 0.0f, 9.0f);
        this.gauntlet_arm2.addChild((BasicModelPart)this.gauntlet_shoulder);
        this.setRotationAngle(this.gauntlet_shoulder, 0.0f, 0.6109f, 0.0f);
        this.gauntlet_shoulder.setTextureOffset(0, 0).addBox(-8.0f, -5.0f, -6.0f, 8.0f, 10.0f, 12.0f, 0.0f, false);
        this.gauntlet_shoulder.setTextureOffset(38, 84).addBox(-8.0f, -5.0f, -6.0f, 8.0f, 10.0f, 12.0f, 0.3f, false);
        this.big_void_stone = new AdvancedModelBox((AdvancedEntityModel)this);
        this.big_void_stone.setRotationPoint(-8.0f, 0.0f, -2.0f);
        this.gauntlet_shoulder.addChild((BasicModelPart)this.big_void_stone);
        this.setRotationAngle(this.big_void_stone, 0.0f, 0.6109f, 0.0f);
        this.big_void_stone.setTextureOffset(28, 0).addBox(-8.0f, -2.0f, 0.0f, 8.0f, 4.0f, 4.0f, 0.0f, false);
        this.big_void_stone.setTextureOffset(30, 52).addBox(-10.0f, -3.0f, -1.0f, 11.0f, 6.0f, 6.0f, 0.0f, false);
        this.big_void_stone.setTextureOffset(0, 49).addBox(-3.0f, -3.0f, -1.0f, 2.0f, 6.0f, 6.0f, 0.2f, false);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.gauntlet_fist, this.gauntlet_fist_r1, this.gauntlet_fist_r2, this.void_stone_knuckle, this.gauntlet_arm, this.gauntlet_arm2, this.gauntlet_shoulder, this.big_void_stone);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

