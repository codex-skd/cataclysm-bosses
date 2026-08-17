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

public class Azure_Sea_Shield_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox plate;
    private final AdvancedModelBox handle;

    public Azure_Sea_Shield_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.plate = new AdvancedModelBox((AdvancedEntityModel)this);
        this.plate.setRotationPoint(0.0f, -24.0f, -0.5f);
        this.root.addChild((BasicModelPart)this.plate);
        this.plate.setTextureOffset(0, 0).addBox(-9.0f, -9.0f, -2.0f, 18.0f, 18.0f, 2.0f, 0.0f, false);
        this.plate.setTextureOffset(27, 29).addBox(-13.0f, 0.0f, -1.0f, 4.0f, 6.0f, 0.0f, 0.0f, false);
        this.plate.setTextureOffset(27, 29).addBox(9.0f, 0.0f, -1.0f, 4.0f, 6.0f, 0.0f, 0.0f, true);
        this.handle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle.setRotationPoint(0.0f, -24.0f, 0.5f);
        this.root.addChild((BasicModelPart)this.handle);
        this.handle.setTextureOffset(27, 21).addBox(-8.0f, -2.5f, -1.5f, 4.0f, 5.0f, 2.0f, 0.0f, false);
        this.handle.setTextureOffset(0, 21).addBox(-1.0f, -2.5f, -1.5f, 9.0f, 5.0f, 4.0f, 0.0f, false);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.plate, (Object)this.handle);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

