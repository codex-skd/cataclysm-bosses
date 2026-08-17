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

public class The_Annihilator_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;

    public The_Annihilator_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 42).addBox(-1.0f, -19.0f, -1.0f, 2.0f, 19.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(39, 23).addBox(-1.5f, -33.0f, -1.5f, 3.0f, 16.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(0.0f, -41.0f, -9.5f, 0.0f, 22.0f, 19.0f, 0.0f, false);
        this.root.setTextureOffset(39, 0).addBox(-9.5f, -41.0f, 0.0f, 19.0f, 22.0f, 0.0f, 0.0f, false);
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
        return ImmutableList.of((Object)this.root);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

