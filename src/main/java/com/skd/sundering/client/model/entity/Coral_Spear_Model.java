/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 */
package com.skd.sundering.client.model.entity;

import com.skd.sundering.entity.projectile.ThrownCoral_Spear_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Coral_Spear_Model
extends AdvancedEntityModel<ThrownCoral_Spear_Entity> {
    private final AdvancedModelBox coral_spear;
    private final AdvancedModelBox coral;
    private final AdvancedModelBox coral2;
    private final AdvancedModelBox head;
    private final AdvancedModelBox head2;

    public Coral_Spear_Model() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.coral_spear = new AdvancedModelBox((AdvancedEntityModel)this);
        this.coral_spear.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.coral_spear.setTextureOffset(0, 0).addBox(-0.5f, -23.0f, -0.5f, 1.0f, 23.0f, 1.0f, 0.0f, false);
        this.coral = new AdvancedModelBox((AdvancedEntityModel)this);
        this.coral.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.coral_spear.addChild((BasicModelPart)this.coral);
        this.setRotationAngle(this.coral, 0.0f, 0.7854f, 0.0f);
        this.coral.setTextureOffset(4, 13).addBox(0.0f, -13.0f, -6.0f, 0.0f, 5.0f, 6.0f, 0.0f, false);
        this.coral2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.coral2.setRotationPoint(4.0f, -5.0f, 4.0f);
        this.coral_spear.addChild((BasicModelPart)this.coral2);
        this.setRotationAngle(this.coral2, 0.0f, 0.7854f, 0.0f);
        this.coral2.setTextureOffset(4, 8).addBox(0.0f, -13.0f, -6.0f, 0.0f, 5.0f, 6.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -29.0f, 0.0f);
        this.coral_spear.addChild((BasicModelPart)this.head);
        this.setRotationAngle(this.head, 0.0f, 0.7854f, 0.0f);
        this.head.setTextureOffset(16, 10).addBox(-3.0f, -2.0f, 0.0f, 6.0f, 10.0f, 0.0f, 0.0f, false);
        this.head2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head2.setRotationPoint(0.0f, -29.0f, 0.0f);
        this.coral_spear.addChild((BasicModelPart)this.head2);
        this.setRotationAngle(this.head2, 0.0f, -0.7854f, 0.0f);
        this.head2.setTextureOffset(16, 0).addBox(-3.0f, -2.0f, 0.0f, 6.0f, 10.0f, 0.0f, 0.0f, false);
    }

    public BasicModelPart root() {
        return this.coral_spear;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.coral_spear, (Object)this.head, (Object)this.head2, (Object)this.coral, (Object)this.coral2);
    }

    public void setupAnim(ThrownCoral_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

