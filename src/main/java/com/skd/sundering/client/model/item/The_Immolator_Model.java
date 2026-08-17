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
package com.skd.sundering.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class The_Immolator_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox cube_r1;

    public The_Immolator_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 42).addBox(-1.0f, -19.0f, -1.0f, 2.0f, 19.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(42, 42).addBox(-1.5f, -1.5f, -1.5f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(54, 42).addBox(-1.5f, -3.0f, -1.5f, 3.0f, 2.0f, 3.0f, -0.2f, false);
        this.root.setTextureOffset(42, 47).addBox(-1.0f, 2.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(39, 23).addBox(-1.5f, -33.0f, -1.5f, 3.0f, 16.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-1.5f, -20.0f, -1.5f, 3.0f, 4.0f, 3.0f, 0.3f, false);
        this.root.setTextureOffset(0, 5).addBox(0.0f, -20.0f, 1.8f, 0.0f, 5.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(4, 5).addBox(0.0f, -20.0f, -3.8f, 0.0f, 5.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(4, 12).addBox(-3.8f, -20.0f, 0.2f, 2.0f, 5.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(0, 12).addBox(1.8f, -20.0f, 0.2f, 2.0f, 5.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(0.0f, -41.0f, -9.5f, 0.0f, 22.0f, 19.0f, 0.0f, false);
        this.root.setTextureOffset(39, 0).addBox(-9.5f, -41.0f, 0.0f, 19.0f, 22.0f, 0.0f, 0.0f, false);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, -0.7854f);
        this.cube_r1.setTextureOffset(42, 51).addBox(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f, 0.0f, false);
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
        return ImmutableList.of((Object)this.root, (Object)this.cube_r1);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

