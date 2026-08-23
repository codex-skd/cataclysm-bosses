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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Abyss_Mine_Model
extends AdvancedEntityModel<Entity> {
    public final AdvancedModelBox root;
    public final AdvancedModelBox glass;
    public final AdvancedModelBox glass2;

    public Abyss_Mine_Model() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.5f, false);
        this.glass = new AdvancedModelBox((AdvancedEntityModel)this);
        this.glass.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.5f, false);
        this.glass2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.glass2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.glass2.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.5f, false);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.glass, (Object)this.glass2);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.rotateAngleY = netHeadYaw * ((float)Math.PI / 180);
        this.root.rotateAngleX = headPitch * ((float)Math.PI / 180);
    }
}

