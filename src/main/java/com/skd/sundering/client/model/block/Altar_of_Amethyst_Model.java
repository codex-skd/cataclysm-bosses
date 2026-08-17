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

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Altar_of_Amethyst_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox crystal;

    public Altar_of_Amethyst_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(48, 16).addBox(-8.0f, -3.0f, -8.0f, 16.0f, 3.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 32).addBox(-8.0f, -16.0f, -8.0f, 16.0f, 3.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 51).addBox(-6.0f, -13.0f, -6.0f, 12.0f, 10.0f, 12.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.3f, false);
        this.crystal = new AdvancedModelBox((AdvancedEntityModel)this);
        this.crystal.setRotationPoint(-2.0f, 0.0f, 2.0f);
        this.root.addChild((BasicModelPart)this.crystal);
        this.crystal.setTextureOffset(0, 0).addBox(-7.0f, -24.0f, 3.0f, 4.0f, 10.0f, 4.0f, 0.0f, false);
        this.crystal.setTextureOffset(0, 39).addBox(-8.0f, -19.0f, 2.0f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.crystal.setTextureOffset(0, 32).addBox(8.0f, -19.0f, -11.0f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.crystal);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

