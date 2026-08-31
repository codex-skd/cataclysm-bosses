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

public class Incinerator_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox blade;
    private final AdvancedModelBox blade2;
    private final AdvancedModelBox blade_mid;
    private final AdvancedModelBox handle_core;
    private final AdvancedModelBox core;
    private final AdvancedModelBox upper_guard;
    private final AdvancedModelBox lower_guard;

    public Incinerator_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 54).addBox(-1.5f, -23.0f, -1.5f, 3.0f, 12.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(49, 53).addBox(-2.5f, -11.0f, -2.5f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(0.0f, -66.0f, -6.5f, 0.0f, 40.0f, 13.0f, 0.0f, false);
        this.root.setTextureOffset(27, 0).addBox(-0.5f, -66.0f, -3.5f, 1.0f, 40.0f, 7.0f, 0.0f, false);
        this.blade = new AdvancedModelBox((AdvancedEntityModel)this);
        this.blade.setRotationPoint(0.0f, -66.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.blade);
        this.setRotationAngle(this.blade, -0.7854f, 0.0f, 0.0f);
        this.blade.setTextureOffset(0, 0).addBox(-0.5f, -2.5f, -2.5f, 1.0f, 5.0f, 5.0f, -0.01f, false);
        this.blade2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.blade2.setRotationPoint(0.0f, -66.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.blade2);
        this.setRotationAngle(this.blade2, -0.7854f, 0.0f, 0.0f);
        this.blade2.setTextureOffset(35, 39).addBox(0.0f, -4.5f, -4.5f, 0.0f, 9.0f, 9.0f, 0.0f, false);
        this.blade_mid = new AdvancedModelBox((AdvancedEntityModel)this);
        this.blade_mid.setRotationPoint(0.0f, -25.8f, 0.0f);
        this.root.addChild((BasicModelPart)this.blade_mid);
        this.setRotationAngle(this.blade_mid, 0.7854f, 0.0f, 0.0f);
        this.blade_mid.setTextureOffset(22, 53).addBox(-1.5f, -2.5f, -2.5f, 3.0f, 5.0f, 5.0f, 0.5f, false);
        this.blade_mid.setTextureOffset(54, 48).addBox(-1.0f, -0.5f, -5.5f, 2.0f, 1.0f, 3.0f, 0.0f, false);
        this.blade_mid.setTextureOffset(27, 48).addBox(-1.0f, 2.5f, -0.5f, 2.0f, 3.0f, 1.0f, 0.0f, false);
        this.handle_core = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle_core.setRotationPoint(0.0f, -4.5f, 0.0f);
        this.root.addChild((BasicModelPart)this.handle_core);
        this.setRotationAngle(this.handle_core, -0.7854f, 0.0f, 0.0f);
        this.handle_core.setTextureOffset(45, 35).addBox(-2.5f, -2.5f, -2.5f, 5.0f, 5.0f, 5.0f, 0.7f, false);
        this.core = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core.setRotationPoint(0.0f, -4.5f, 0.0f);
        this.root.addChild((BasicModelPart)this.core);
        this.core.setTextureOffset(44, 24).addBox(-2.5f, -2.5f, -2.5f, 5.0f, 5.0f, 5.0f, 0.0f, false);
        this.upper_guard = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upper_guard.setRotationPoint(0.0f, -25.5f, 0.9f);
        this.root.addChild((BasicModelPart)this.upper_guard);
        this.setRotationAngle(this.upper_guard, -0.1745f, 0.0f, 0.0f);
        this.upper_guard.setTextureOffset(44, 12).addBox(-1.0f, -3.0f, 4.0f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(37, 0).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 4.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(42, 58).addBox(-0.5f, -1.0f, 4.0f, 1.0f, 1.0f, 4.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(60, 40).addBox(-0.5f, -2.0f, 3.0f, 1.0f, 1.0f, 6.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(56, 12).addBox(-0.5f, -3.0f, 3.0f, 1.0f, 1.0f, 7.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(60, 21).addBox(-0.5f, -6.0f, 6.0f, 1.0f, 1.0f, 6.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(13, 54).addBox(-0.5f, -7.0f, 10.0f, 1.0f, 1.0f, 2.0f, 0.0f, false);
        this.upper_guard.setTextureOffset(44, 12).addBox(-0.5f, -5.0f, 3.0f, 1.0f, 2.0f, 9.0f, 0.0f, false);
        this.lower_guard = new AdvancedModelBox((AdvancedEntityModel)this);
        this.lower_guard.setRotationPoint(0.0f, -25.5f, -1.9f);
        this.root.addChild((BasicModelPart)this.lower_guard);
        this.setRotationAngle(this.lower_guard, 0.1745f, 0.0f, 0.0f);
        this.lower_guard.setTextureOffset(27, 0).addBox(-1.0f, -3.0f, -4.0f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(14, 0).addBox(-1.0f, -1.0f, -3.0f, 2.0f, 2.0f, 4.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(14, 7).addBox(-0.5f, -1.0f, -6.0f, 1.0f, 1.0f, 4.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(33, 58).addBox(-0.5f, -2.0f, -8.0f, 1.0f, 1.0f, 6.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(56, 0).addBox(-0.5f, -3.0f, -9.0f, 1.0f, 1.0f, 7.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(13, 58).addBox(-0.5f, -6.0f, -11.0f, 1.0f, 1.0f, 6.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(46, 0).addBox(-0.5f, -7.0f, -11.0f, 1.0f, 1.0f, 2.0f, 0.0f, false);
        this.lower_guard.setTextureOffset(44, 0).addBox(-0.5f, -5.0f, -11.0f, 1.0f, 2.0f, 9.0f, 0.0f, false);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.blade, this.blade2, this.blade_mid, this.handle_core, this.core, this.upper_guard, this.lower_guard);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

