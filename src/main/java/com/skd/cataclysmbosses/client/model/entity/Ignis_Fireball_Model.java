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

public class Ignis_Fireball_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox core;
    private final AdvancedModelBox out_line;

    public Ignis_Fireball_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.core = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.core);
        this.core.setTextureOffset(20, 37).addBox(-4.0f, -4.0f, -1.0f, 8.0f, 8.0f, 2.0f, 0.0f, false);
        this.core.setTextureOffset(0, 31).addBox(-1.0f, -4.0f, -4.0f, 2.0f, 8.0f, 8.0f, 0.0f, false);
        this.core.setTextureOffset(0, 21).addBox(-4.0f, -1.0f, -4.0f, 8.0f, 2.0f, 8.0f, 0.0f, false);
        this.out_line = new AdvancedModelBox((AdvancedEntityModel)this);
        this.out_line.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.out_line);
        this.out_line.setTextureOffset(0, 0).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, 0.0f, false);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.core, this.out_line);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.rotateAngleY = netHeadYaw * ((float)Math.PI / 180);
        this.root.rotateAngleX = headPitch * ((float)Math.PI / 180);
    }
}

