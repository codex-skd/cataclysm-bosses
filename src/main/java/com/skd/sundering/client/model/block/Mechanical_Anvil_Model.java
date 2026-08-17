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
package com.skd.sundering.client.model.block;

import com.skd.sundering.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Mechanical_Anvil_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox base;
    private final AdvancedModelBox gear;
    private final AdvancedModelBox sub_gear;
    private final AdvancedModelBox sub_gear2;

    public Mechanical_Anvil_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 12).addBox(-6.0f, -12.0f, -4.0f, 12.0f, 3.0f, 8.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-8.0f, -14.0f, -3.0f, 16.0f, 6.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(10, 58).addBox(2.5f, -14.0f, -3.0f, 6.0f, 6.0f, 6.0f, 0.2f, false);
        this.root.setTextureOffset(10, 58).addBox(-8.5f, -14.0f, -3.0f, 6.0f, 6.0f, 6.0f, 0.2f, true);
        this.root.setTextureOffset(0, 23).addBox(-7.0f, -13.0f, 4.0f, 14.0f, 5.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(4, 70).addBox(5.5f, -13.0f, 4.0f, 2.0f, 5.0f, 4.0f, 0.2f, false);
        this.root.setTextureOffset(4, 70).addBox(5.5f, -13.0f, -8.0f, 2.0f, 5.0f, 4.0f, 0.2f, false);
        this.root.setTextureOffset(4, 70).addBox(-7.5f, -13.0f, 4.0f, 2.0f, 5.0f, 4.0f, 0.2f, true);
        this.root.setTextureOffset(4, 70).addBox(-7.5f, -13.0f, -8.0f, 2.0f, 5.0f, 4.0f, 0.2f, true);
        this.root.setTextureOffset(0, 32).addBox(-7.0f, -13.0f, -8.0f, 14.0f, 5.0f, 4.0f, 0.0f, false);
        this.base = new AdvancedModelBox((AdvancedEntityModel)this);
        this.base.setRotationPoint(-2.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.base);
        this.base.setTextureOffset(38, 36).addBox(-5.0f, -3.0f, 2.0f, 10.0f, 3.0f, 3.0f, 0.0f, false);
        this.base.setTextureOffset(40, 18).addBox(-3.0f, -8.0f, 3.0f, 10.0f, 5.0f, 0.0f, 0.0f, false);
        this.base.setTextureOffset(20, 42).addBox(-3.0f, -8.0f, -3.0f, 10.0f, 5.0f, 0.0f, 0.0f, false);
        this.base.setTextureOffset(20, 47).addBox(-8.0f, -6.0f, 3.5f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.base.setTextureOffset(32, 50).addBox(-8.0f, -6.0f, -3.5f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.base.setTextureOffset(38, 23).addBox(5.0f, -3.0f, -5.0f, 3.0f, 3.0f, 10.0f, 0.0f, false);
        this.base.setTextureOffset(0, 51).addBox(6.0f, -2.0f, -6.0f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.base.setTextureOffset(12, 53).addBox(6.0f, -2.0f, 3.0f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.base.setTextureOffset(46, 0).addBox(6.0f, -5.0f, -2.0f, 3.0f, 5.0f, 4.0f, 0.0f, false);
        this.base.setTextureOffset(40, 12).addBox(-5.0f, -3.0f, -5.0f, 10.0f, 3.0f, 3.0f, 0.0f, false);
        this.gear = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gear.setRotationPoint(2.0f, -5.5f, 0.0f);
        this.base.addChild((BasicModelPart)this.gear);
        this.setRotationAngle(this.gear, 0.0f, 0.0f, 0.7854f);
        this.gear.setTextureOffset(40, 42).addBox(-3.0f, -3.0f, -1.0f, 6.0f, 6.0f, 2.0f, 0.0f, false);
        this.gear.setTextureOffset(0, 41).addBox(-5.0f, -5.0f, 0.0f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.gear.setTextureOffset(44, 50).addBox(-1.0f, -1.0f, -2.0f, 2.0f, 2.0f, 4.0f, 0.0f, false);
        this.sub_gear = new AdvancedModelBox((AdvancedEntityModel)this);
        this.sub_gear.setRotationPoint(9.0f, -8.0f, 0.0f);
        this.base.addChild((BasicModelPart)this.sub_gear);
        this.sub_gear.setTextureOffset(66, 0).addBox(-2.0f, -2.0f, -1.0f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.sub_gear.setTextureOffset(79, 7).addBox(-2.0f, -2.0f, -0.5f, 4.0f, 4.0f, 1.0f, 0.1f, false);
        this.sub_gear.setTextureOffset(66, 6).addBox(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.sub_gear.setTextureOffset(78, 0).addBox(-1.0f, -1.0f, -2.0f, 2.0f, 2.0f, 4.0f, 0.0f, false);
        this.sub_gear2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.sub_gear2.setRotationPoint(-5.0f, -8.0f, 0.0f);
        this.base.addChild((BasicModelPart)this.sub_gear2);
        this.sub_gear2.setTextureOffset(66, 0).addBox(-2.0f, -2.0f, -1.0f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.sub_gear2.setTextureOffset(79, 7).addBox(-2.0f, -2.0f, -0.5f, 4.0f, 4.0f, 1.0f, 0.1f, false);
        this.sub_gear2.setTextureOffset(66, 6).addBox(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.sub_gear2.setTextureOffset(78, 0).addBox(-1.0f, -1.0f, -2.0f, 2.0f, 2.0f, 4.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.base, (Object)this.gear, (Object)this.sub_gear, (Object)this.sub_gear2);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void animate(Mechanical_fusion_Anvil_Block_Entity beak, float partialTick) {
        this.resetToDefaultPose();
        float ageInTicks = (float)beak.tickCount + partialTick;
        this.gear.rotateAngleZ -= ageInTicks * 0.1f;
        this.sub_gear.rotateAngleZ += ageInTicks * 0.2f;
        this.sub_gear2.rotateAngleZ += ageInTicks * 0.2f;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

