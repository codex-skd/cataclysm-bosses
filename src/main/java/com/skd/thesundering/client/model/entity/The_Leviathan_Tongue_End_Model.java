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
package com.skd.thesundering.client.model.entity;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class The_Leviathan_Tongue_End_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox tongue;

    public The_Leviathan_Tongue_End_Model() {
        this.texWidth = 256;
        this.texHeight = 256;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.tongue = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tongue.setRotationPoint(0.0f, 70.0f, -4.2f);
        this.root.addChild((BasicModelPart)this.tongue);
        this.tongue.setTextureOffset(74, 93).addBox(-3.0f, -73.0f, -0.3f, 6.0f, 6.0f, 9.0f, 0.0f, false);
        this.tongue.setTextureOffset(190, 106).addBox(0.0f, -76.0f, 0.7f, 0.0f, 12.0f, 7.0f, 0.0f, false);
        this.tongue.setTextureOffset(139, 9).addBox(-6.0f, -70.0f, 0.7f, 12.0f, 0.0f, 7.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.tongue);
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

