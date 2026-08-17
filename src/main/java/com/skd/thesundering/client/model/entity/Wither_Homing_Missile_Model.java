/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.entity.projectile.Wither_Homing_Missile_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Wither_Homing_Missile_Model
extends AdvancedEntityModel<Wither_Homing_Missile_Entity> {
    private final AdvancedModelBox root;

    public Wither_Homing_Missile_Model() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, -4.5f, 2.0f, 2.0f, 9.0f, 0.0f, false);
        this.root.setTextureOffset(0, 2).addBox(0.0f, -3.0f, 0.5f, 0.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(0.0f, 1.0f, 0.5f, 0.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, -2.5f, 2.0f, 2.0f, 1.0f, 0.1f, false);
        this.root.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, 3.5f, 2.0f, 2.0f, 1.0f, 0.1f, false);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Wither_Homing_Missile_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.rotateAngleY = netHeadYaw * ((float)Math.PI / 180);
        this.root.rotateAngleX = headPitch * ((float)Math.PI / 180);
    }
}

