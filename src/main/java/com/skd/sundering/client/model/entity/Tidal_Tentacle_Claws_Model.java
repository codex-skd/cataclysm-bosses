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
package com.skd.sundering.client.model.entity;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Tidal_Tentacle_Claws_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox claw1;
    private final AdvancedModelBox claw2;
    private final AdvancedModelBox claw3;
    private final AdvancedModelBox claw4;

    public Tidal_Tentacle_Claws_Model() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.claw1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw1.setRotationPoint(0.0f, 0.0f, 0.7f);
        this.root.addChild((BasicModelPart)this.claw1);
        this.setRotationAngle(this.claw1, 0.48f, 0.0f, 0.0f);
        this.claw1.setTextureOffset(9, 10).addBox(-1.0f, -6.0f, -1.0f, 2.0f, 6.0f, 2.0f, 0.0f, false);
        this.claw2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw2.setRotationPoint(0.0f, 2.0f, 0.7f);
        this.root.addChild((BasicModelPart)this.claw2);
        this.setRotationAngle(this.claw2, -0.48f, 0.0f, 0.0f);
        this.claw2.setTextureOffset(0, 10).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 6.0f, 2.0f, 0.0f, false);
        this.claw3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw3.setRotationPoint(1.0f, 1.0f, 0.7f);
        this.root.addChild((BasicModelPart)this.claw3);
        this.setRotationAngle(this.claw3, 0.0f, 0.48f, 0.0f);
        this.claw3.setTextureOffset(0, 5).addBox(0.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false);
        this.claw4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw4.setRotationPoint(-1.0f, 1.0f, 0.7f);
        this.root.addChild((BasicModelPart)this.claw4);
        this.setRotationAngle(this.claw4, 0.0f, -0.48f, 0.0f);
        this.claw4.setTextureOffset(0, 0).addBox(-6.0f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.claw1, (Object)this.claw2, (Object)this.claw3, (Object)this.claw4);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void setAttributes(float rotX, float rotY) {
        this.resetToDefaultPose();
        this.resetToDefaultPose();
        this.root.rotateAngleX = (float)Math.toRadians(rotX);
        this.root.rotateAngleY = (float)Math.toRadians(rotY);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

