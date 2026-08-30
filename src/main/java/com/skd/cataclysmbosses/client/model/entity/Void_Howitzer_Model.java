/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.projectile.Void_Howitzer_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Void_Howitzer_Model
extends AdvancedEntityModel<Void_Howitzer_Entity> {
    private final AdvancedModelBox root;

    public Void_Howitzer_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(0.0f, -8.0f, -8.0f, 0.0f, 16.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-8.0f, 0.0f, -8.0f, 16.0f, 0.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 32).addBox(-8.0f, -8.0f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(32, 16).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, 0.0f, false);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Void_Howitzer_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}

