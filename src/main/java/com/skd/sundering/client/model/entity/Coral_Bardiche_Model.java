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

public class Coral_Bardiche_Model
extends AdvancedEntityModel<ThrownCoral_Spear_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox spear_head;
    private final AdvancedModelBox blade;

    public Coral_Bardiche_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.spear_head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spear_head.setRotationPoint(0.0f, -19.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.spear_head);
        this.spear_head.setTextureOffset(0, 0).addBox(-1.0f, -17.0f, -1.0f, 2.0f, 42.0f, 2.0f, 0.0f, false);
        this.spear_head.setTextureOffset(9, 24).addBox(-1.0f, -17.0f, -1.0f, 2.0f, 3.0f, 2.0f, 0.25f, false);
        this.spear_head.setTextureOffset(9, 24).addBox(-1.0f, -9.0f, -1.0f, 2.0f, 3.0f, 2.0f, 0.25f, false);
        this.spear_head.setTextureOffset(23, 24).addBox(-1.0f, 22.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.25f, false);
        this.blade = new AdvancedModelBox((AdvancedEntityModel)this);
        this.blade.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.spear_head.addChild((BasicModelPart)this.blade);
        this.blade.setTextureOffset(22, 0).addBox(-5.0f, -17.0f, -0.5f, 3.0f, 12.0f, 1.0f, 0.0f, false);
        this.blade.setTextureOffset(9, 0).addBox(-7.0f, -23.0f, 0.0f, 6.0f, 23.0f, 0.0f, 0.0f, false);
        this.blade.setTextureOffset(22, 14).addBox(-2.0f, -17.0f, 0.0f, 1.0f, 11.0f, 0.0f, 0.0f, false);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.spear_head, (Object)this.blade);
    }

    public void setupAnim(ThrownCoral_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

