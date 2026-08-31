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

public class Bulwark_of_the_flame_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox shield;
    private final AdvancedModelBox left_side;
    private final AdvancedModelBox right_side;
    private final AdvancedModelBox handle;

    public Bulwark_of_the_flame_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, -0.5f);
        this.shield = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shield.setRotationPoint(0.0f, -14.0f, -2.0f);
        this.root.addChild((BasicModelPart)this.shield);
        this.shield.setTextureOffset(0, 0).addBox(-3.0f, -11.0f, -1.5f, 6.0f, 22.0f, 1.0f, 0.0f, false);
        this.shield.setTextureOffset(0, 28).addBox(-3.5f, 9.0f, -2.0f, 7.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield.setTextureOffset(15, 19).addBox(-3.5f, -14.0f, -2.0f, 7.0f, 6.0f, 2.0f, 0.0f, false);
        this.shield.setTextureOffset(34, 18).addBox(-2.0f, -2.0f, -2.25f, 4.0f, 4.0f, 1.0f, 0.0f, false);
        this.left_side = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_side.setRotationPoint(5.33f, -12.8316f, -2.1f);
        this.root.addChild((BasicModelPart)this.left_side);
        this.setRotationAngle(this.left_side, 0.0f, -0.2182f, 0.0436f);
        this.left_side.setTextureOffset(15, 0).addBox(-3.0f, -9.1667f, -0.5f, 5.0f, 17.0f, 1.0f, 0.0f, false);
        this.left_side.setTextureOffset(28, 11).addBox(-3.5f, 7.8333f, -1.0f, 6.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_side.setTextureOffset(19, 28).addBox(-3.5f, -13.1667f, -1.0f, 6.0f, 4.0f, 2.0f, 0.0f, false);
        this.right_side = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_side.setRotationPoint(-5.33f, -12.8316f, -2.1f);
        this.root.addChild((BasicModelPart)this.right_side);
        this.setRotationAngle(this.right_side, 0.0f, 0.2182f, -0.0436f);
        this.right_side.setTextureOffset(15, 0).addBox(-2.0f, -9.1667f, -0.5f, 5.0f, 17.0f, 1.0f, 0.0f, true);
        this.right_side.setTextureOffset(28, 11).addBox(-2.5f, 7.8333f, -1.0f, 6.0f, 4.0f, 2.0f, 0.0f, true);
        this.right_side.setTextureOffset(19, 28).addBox(-2.5f, -13.1667f, -1.0f, 6.0f, 4.0f, 2.0f, 0.0f, true);
        this.handle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle.setRotationPoint(6.0f, -8.0f, -8.0f);
        this.root.addChild((BasicModelPart)this.handle);
        this.handle.setTextureOffset(28, 0).addBox(-7.0f, -8.5f, 5.5f, 2.0f, 6.0f, 6.0f, 0.0f, false);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.shield, this.root, this.left_side, this.right_side, this.handle);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

