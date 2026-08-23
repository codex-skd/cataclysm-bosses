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

import com.skd.cataclysmbosses.entity.projectile.Ancient_Desert_Stele_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Ancient_Desert_Stele_Model
extends AdvancedEntityModel<Ancient_Desert_Stele_Entity> {
    private final AdvancedModelBox root;

    public Ancient_Desert_Stele_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-7.0f, -22.0f, -7.0f, 14.0f, 20.0f, 14.0f, 0.0f, false);
        this.root.setTextureOffset(0, 34).addBox(-8.0f, -2.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setupAnim(Ancient_Desert_Stele_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root);
    }
}

