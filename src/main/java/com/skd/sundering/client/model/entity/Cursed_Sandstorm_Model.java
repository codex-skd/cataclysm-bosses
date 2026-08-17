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

import com.skd.sundering.client.animation.Sandstorm_Animation;
import com.skd.sundering.entity.projectile.Cursed_Sandstorm_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Cursed_Sandstorm_Model
extends AdvancedEntityModel<Cursed_Sandstorm_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox storm;
    private final AdvancedModelBox storm2;
    private final AdvancedModelBox storm3;
    private final AdvancedModelBox storm4;

    public Cursed_Sandstorm_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this, "root");
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.storm = new AdvancedModelBox((AdvancedEntityModel)this, "storm");
        this.storm.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.storm);
        this.storm.setTextureOffset(65, 72).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.storm2 = new AdvancedModelBox((AdvancedEntityModel)this, "storm2");
        this.storm2.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.storm.addChild((BasicModelPart)this.storm2);
        this.storm2.setTextureOffset(0, 72).addBox(-8.0f, -4.0f, -8.0f, 16.0f, 8.0f, 16.0f, 0.0f, false);
        this.storm3 = new AdvancedModelBox((AdvancedEntityModel)this, "storm3");
        this.storm3.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.storm2.addChild((BasicModelPart)this.storm3);
        this.storm3.setTextureOffset(0, 39).addBox(-12.0f, -4.0f, -12.0f, 24.0f, 8.0f, 24.0f, 0.0f, false);
        this.storm4 = new AdvancedModelBox((AdvancedEntityModel)this, "storm4");
        this.storm4.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.storm3.addChild((BasicModelPart)this.storm4);
        this.storm4.setTextureOffset(0, 0).addBox(-15.0f, -4.0f, -15.0f, 30.0f, 8.0f, 30.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.storm, (Object)this.storm2, (Object)this.storm3, (Object)this.storm4);
    }

    public void setupAnim(Cursed_Sandstorm_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        AdvancedModelBox[] stormBoxes = new AdvancedModelBox[]{this.storm, this.storm2, this.storm3, this.storm4};
        float walkSpeed = 0.25f;
        float walkDegree = 1.0f;
        this.chainFlap(stormBoxes, walkSpeed, walkDegree * 0.1f, -2.0, ageInTicks, 1.0f);
        this.storm.rotateAngleY += ageInTicks * 1.0f;
        AdvancedModelBox advancedModelBox = this.storm2;
        advancedModelBox.rotateAngleY = advancedModelBox.rotateAngleY + (-this.storm.rotateAngleY + ageInTicks * 0.5f);
        advancedModelBox = this.storm3;
        advancedModelBox.rotateAngleY = advancedModelBox.rotateAngleY + (-this.storm.rotateAngleY - this.storm2.rotateAngleY + ageInTicks * 0.3f);
        advancedModelBox = this.storm4;
        advancedModelBox.rotateAngleY = advancedModelBox.rotateAngleY + (-this.storm.rotateAngleY - this.storm2.rotateAngleY - this.storm3.rotateAngleY + ageInTicks * 0.6f);
        this.animate(entity.getAnimationState("spawn"), Sandstorm_Animation.SPAWN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("despawn"), Sandstorm_Animation.DESPAWN, ageInTicks, 1.0f);
    }

    public void setRotationAngle(AdvancedModelBox modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

