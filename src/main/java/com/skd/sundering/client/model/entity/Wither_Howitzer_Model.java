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

import com.skd.sundering.entity.projectile.Wither_Howitzer_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Wither_Howitzer_Model
extends AdvancedEntityModel<Wither_Howitzer_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox warhead;

    public Wither_Howitzer_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.setTextureOffset(22, 20).addBox(-3.0f, -3.0f, 2.5f, 6.0f, 6.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(28, 0).addBox(-3.0f, -3.0f, 4.5f, 6.0f, 6.0f, 2.0f, 0.3f, false);
        this.root.setTextureOffset(0, 20).addBox(-4.0f, -4.0f, 6.5f, 8.0f, 8.0f, 3.0f, 0.0f, false);
        this.warhead = new AdvancedModelBox((AdvancedEntityModel)this);
        this.warhead.setRotationPoint(3.0f, 4.0f, -8.5f);
        this.root.addChild((BasicModelPart)this.warhead);
        this.warhead.setTextureOffset(0, 0).addBox(-7.0f, -8.0f, -1.0f, 8.0f, 8.0f, 12.0f, 0.0f, false);
        this.warhead.setTextureOffset(0, 31).addBox(-7.0f, -8.0f, 7.75f, 8.0f, 8.0f, 3.0f, 0.5f, false);
        this.warhead.setTextureOffset(0, 31).addBox(-7.0f, -8.0f, 1.25f, 8.0f, 8.0f, 3.0f, 0.5f, false);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.warhead);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Wither_Howitzer_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}

