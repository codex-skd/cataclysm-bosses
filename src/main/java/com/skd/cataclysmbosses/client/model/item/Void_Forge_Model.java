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

public class Void_Forge_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox hammer_head;
    private final AdvancedModelBox back;
    private final AdvancedModelBox handle;
    private final AdvancedModelBox handle2;
    private final AdvancedModelBox crystal;
    private final AdvancedModelBox crystal2;
    private final AdvancedModelBox crystal3;

    public Void_Forge_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.hammer_head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.hammer_head.setRotationPoint(0.0f, 20.0f, -1.0f);
        this.root.addChild((BasicModelPart)this.hammer_head);
        this.hammer_head.setTextureOffset(33, 15).addBox(-3.0f, -38.0f, -2.0f, 6.0f, 7.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(7, 46).addBox(3.25f, -33.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(51, 53).addBox(-3.25f, -33.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(38, 53).addBox(-3.25f, -37.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(38, 53).addBox(3.25f, -37.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(7, 55).addBox(-3.5f, -38.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(58, 15).addBox(-3.5f, -33.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(58, 27).addBox(0.5f, -38.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(58, 33).addBox(0.5f, -38.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(60, 0).addBox(0.5f, -33.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(60, 6).addBox(0.5f, -33.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(58, 21).addBox(-3.5f, -33.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(18, 56).addBox(-3.5f, -38.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(0, 0).addBox(-4.0f, -39.0f, -10.0f, 8.0f, 9.0f, 8.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(33, 29).addBox(-4.5f, -39.5f, -11.0f, 9.0f, 10.0f, 3.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(0, 18).addBox(-4.0f, -39.0f, -9.0f, 8.0f, 9.0f, 8.0f, 0.3f, false);
        this.back = new AdvancedModelBox((AdvancedEntityModel)this);
        this.back.setRotationPoint(0.0f, -35.0f, 9.0f);
        this.hammer_head.addChild((BasicModelPart)this.back);
        this.back.setTextureOffset(33, 0).addBox(-4.0f, -4.0f, -5.0f, 8.0f, 9.0f, 5.0f, 0.0f, false);
        this.back.setTextureOffset(0, 36).addBox(-4.0f, -4.0f, 0.0f, 8.0f, 5.0f, 4.0f, 0.0f, false);
        this.crystal = new AdvancedModelBox((AdvancedEntityModel)this);
        this.crystal.setRotationPoint(0.0f, -35.0f, 12.0f);
        this.hammer_head.addChild((BasicModelPart)this.crystal);
        this.crystal.setTextureOffset(0, 63).addBox(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 9.0f, 0.0f, false);
        this.crystal.setTextureOffset(0, 77).addBox(-3.0f, -1.0f, -3.0f, 4.0f, 4.0f, 5.0f, 0.0f, false);
        this.crystal2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.crystal2.setRotationPoint(0.0f, -39.75f, 9.75f);
        this.hammer_head.addChild((BasicModelPart)this.crystal2);
        this.setRotationAngle(this.crystal2, 0.7854f, 0.0f, 0.0f);
        this.crystal2.setTextureOffset(0, 63).addBox(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 9.0f, 0.0f, false);
        this.crystal2.setTextureOffset(0, 77).addBox(-3.0f, -1.0f, -3.0f, 4.0f, 4.0f, 5.0f, 0.0f, false);
        this.crystal3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.crystal3.setRotationPoint(0.0f, -30.25f, 9.75f);
        this.hammer_head.addChild((BasicModelPart)this.crystal3);
        this.setRotationAngle(this.crystal3, -0.7854f, 0.0f, 0.0f);
        this.crystal3.setTextureOffset(0, 63).addBox(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 9.0f, 0.0f, false);
        this.crystal3.setTextureOffset(0, 77).addBox(-3.0f, -1.0f, -3.0f, 4.0f, 4.0f, 5.0f, 0.0f, false);
        this.handle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle.setRotationPoint(0.0f, 12.0f, 0.5f);
        this.root.addChild((BasicModelPart)this.handle);
        this.handle.setTextureOffset(0, 46).addBox(-0.5f, -18.0f, -1.5f, 1.0f, 14.0f, 2.0f, 0.0f, false);
        this.handle.setTextureOffset(19, 43).addBox(0.0f, -2.0f, -3.5f, 0.0f, 6.0f, 6.0f, 0.0f, false);
        this.handle.setTextureOffset(25, 36).addBox(-0.5f, -4.0f, -1.5f, 1.0f, 4.0f, 2.0f, 0.2f, false);
        this.handle2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle2.setRotationPoint(0.0f, 7.0f, 0.5f);
        this.root.addChild((BasicModelPart)this.handle2);
        this.handle2.setTextureOffset(38, 43).addBox(-1.5f, -18.0f, -2.5f, 3.0f, 5.0f, 4.0f, 0.0f, false);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.hammer_head, this.back, this.handle, this.handle2, this.crystal, this.crystal2, this.crystal3);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

