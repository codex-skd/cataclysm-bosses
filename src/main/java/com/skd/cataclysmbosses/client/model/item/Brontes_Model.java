/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 */
package com.skd.cataclysmbosses.client.model.item;

import com.skd.cataclysmbosses.entity.projectile.Brontes_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Brontes_Model
extends AdvancedEntityModel<Brontes_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox hammer_head;
    private final AdvancedModelBox back;
    private final AdvancedModelBox handle;
    private final AdvancedModelBox handle2;

    public Brontes_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.hammer_head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.hammer_head.setRotationPoint(0.0f, 20.0f, -1.0f);
        this.root.addChild((BasicModelPart)this.hammer_head);
        this.hammer_head.setTextureOffset(36, 0).addBox(-3.0f, -38.0f, -2.0f, 6.0f, 7.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(6, 51).addBox(3.25f, -33.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(56, 52).addBox(-3.25f, -33.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(52, 36).addBox(-3.25f, -37.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(56, 44).addBox(3.25f, -37.5f, -2.0f, 0.0f, 2.0f, 6.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(36, 13).addBox(-3.5f, -38.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(18, 51).addBox(-3.5f, -33.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(18, 56).addBox(0.5f, -38.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(42, 58).addBox(0.5f, -38.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(6, 59).addBox(0.5f, -33.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(60, 0).addBox(0.5f, -33.5f, 2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(56, 13).addBox(-3.5f, -33.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(46, 13).addBox(-3.5f, -38.5f, -2.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(0, 19).addBox(-4.0f, -39.0f, -10.0f, 8.0f, 9.0f, 8.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(28, 36).addBox(-4.5f, -39.5f, -11.0f, 9.0f, 10.0f, 3.0f, 0.0f, false);
        this.hammer_head.setTextureOffset(32, 19).addBox(-4.0f, -39.0f, -9.0f, 8.0f, 9.0f, 8.0f, 0.3f, false);
        this.back = new AdvancedModelBox((AdvancedEntityModel)this);
        this.back.setRotationPoint(0.0f, -35.0f, 9.0f);
        this.hammer_head.addChild((BasicModelPart)this.back);
        this.back.setTextureOffset(0, 36).addBox(-4.0f, -4.0f, -5.0f, 8.0f, 9.0f, 6.0f, 0.0f, false);
        this.back.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -5.0f, 8.0f, 9.0f, 10.0f, 0.3f, false);
        this.handle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle.setRotationPoint(0.0f, 12.0f, 0.5f);
        this.root.addChild((BasicModelPart)this.handle);
        this.handle.setTextureOffset(0, 51).addBox(-0.5f, -18.0f, -1.5f, 1.0f, 14.0f, 2.0f, 0.0f, false);
        this.handle.setTextureOffset(28, 49).addBox(0.0f, 0.0f, -4.0f, 0.0f, 8.0f, 7.0f, 0.0f, false);
        this.handle.setTextureOffset(60, 5).addBox(-0.5f, -4.0f, -1.5f, 1.0f, 4.0f, 2.0f, 0.2f, false);
        this.handle.setTextureOffset(52, 60).addBox(-0.5f, -17.0f, -1.5f, 1.0f, 1.0f, 2.0f, 0.2f, false);
        this.handle2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle2.setRotationPoint(0.0f, 7.0f, 0.5f);
        this.root.addChild((BasicModelPart)this.handle2);
        this.handle2.setTextureOffset(42, 49).addBox(-1.5f, -18.0f, -2.5f, 3.0f, 5.0f, 4.0f, 0.0f, false);
    }

    public void setupAnim(Brontes_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.hammer_head, (Object)this.back, (Object)this.handle, (Object)this.handle2);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

