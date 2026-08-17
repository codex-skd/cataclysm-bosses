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
package com.skd.thesundering.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Soul_render_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox halberd;
    private final AdvancedModelBox halberd2;

    public Soul_render_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.halberd = new AdvancedModelBox((AdvancedEntityModel)this);
        this.halberd.setRotationPoint(0.0f, -37.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.halberd);
        this.halberd.setTextureOffset(0, 0).addBox(-0.9406f, -28.0f, -0.75f, 2.0f, 65.0f, 2.0f, 0.0f, false);
        this.halberd.setTextureOffset(9, 5).addBox(-0.4406f, -33.0f, -0.25f, 1.0f, 5.0f, 1.0f, 0.0f, false);
        this.halberd.setTextureOffset(40, 0).addBox(0.0594f, -49.0f, -2.25f, 0.0f, 17.0f, 5.0f, 0.0f, false);
        this.halberd.setTextureOffset(41, 23).addBox(-1.4406f, -27.0f, -1.25f, 3.0f, 12.0f, 3.0f, 0.0f, false);
        this.halberd.setTextureOffset(25, 6).addBox(2.0594f, -12.5f, -0.25f, 2.0f, 0.0f, 1.0f, 0.0f, false);
        this.halberd.setTextureOffset(14, 11).addBox(-0.4406f, -12.5f, 2.25f, 1.0f, 0.0f, 2.0f, 0.0f, false);
        this.halberd.setTextureOffset(50, 35).addBox(-1.9406f, -13.0f, -1.75f, 4.0f, 1.0f, 4.0f, 0.0f, false);
        this.halberd.setTextureOffset(14, 8).addBox(-0.4406f, -12.5f, -3.75f, 1.0f, 0.0f, 2.0f, 0.0f, false);
        this.halberd.setTextureOffset(25, 4).addBox(-4.0594f, -12.5f, -0.25f, 2.0f, 0.0f, 1.0f, 0.0f, false);
        this.halberd.setTextureOffset(9, 0).addBox(0.0594f, -33.0f, -16.25f, 0.0f, 25.0f, 15.0f, 0.0f, false);
        this.halberd.setTextureOffset(30, 31).addBox(0.0594f, -29.0f, 1.75f, 0.0f, 19.0f, 10.0f, 0.0f, false);
        this.halberd.setTextureOffset(9, 41).addBox(-2.4406f, -47.0f, 0.25f, 5.0f, 17.0f, 0.0f, 0.0f, false);
        this.halberd2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.halberd2.setRotationPoint(0.0594f, -29.412f, 0.25f);
        this.halberd.addChild((BasicModelPart)this.halberd2);
        this.setRotationAngle(this.halberd2, 0.0f, -0.7854f, 0.0f);
        this.halberd2.setTextureOffset(25, 2).addBox(1.4937f, -0.088f, -0.5f, 2.0f, 0.0f, 1.0f, 0.0f, false);
        this.halberd2.setTextureOffset(9, 0).addBox(-1.5f, -0.588f, -1.5f, 3.0f, 1.0f, 3.0f, 0.0f, false);
        this.halberd2.setTextureOffset(25, 0).addBox(-3.5063f, -0.088f, -0.5f, 2.0f, 0.0f, 1.0f, 0.0f, false);
        this.halberd2.setTextureOffset(14, 5).addBox(-0.5f, -0.088f, -3.4857f, 1.0f, 0.0f, 2.0f, 0.0f, false);
        this.halberd2.setTextureOffset(9, 12).addBox(-0.5f, -0.088f, 1.5143f, 1.0f, 0.0f, 2.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.halberd, (Object)this.halberd2);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

