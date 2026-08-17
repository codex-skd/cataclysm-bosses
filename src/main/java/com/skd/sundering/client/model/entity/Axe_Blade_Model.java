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

import com.skd.sundering.entity.projectile.Axe_Blade_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Axe_Blade_Model
extends AdvancedEntityModel<Axe_Blade_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox blade;
    private final AdvancedModelBox vfx;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox cube_r2;

    public Axe_Blade_Model() {
        this.texWidth = 256;
        this.texHeight = 256;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this, "root");
        this.root.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.blade = new AdvancedModelBox((AdvancedEntityModel)this, "blade");
        this.blade.setRotationPoint(0.0f, -16.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.blade);
        this.blade.setTextureOffset(41, 39).addBox(-1.0f, -16.0f, -14.0f, 2.0f, 32.0f, 28.0f, 0.0f, false);
        this.vfx = new AdvancedModelBox((AdvancedEntityModel)this, "vfx");
        this.vfx.setRotationPoint(0.0f, 0.0f, -14.0f);
        this.blade.addChild((BasicModelPart)this.vfx);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this, "cube_r1");
        this.cube_r1.setRotationPoint(0.0f, 16.0f, 11.0f);
        this.vfx.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, -0.9599f);
        this.cube_r1.setTextureOffset(0, 70).addBox(-1.0f, -10.0f, -11.0f, 0.0f, 10.0f, 30.0f, 0.0f, false);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this, "cube_r2");
        this.cube_r2.setRotationPoint(0.0f, 16.0f, 11.0f);
        this.vfx.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.0f, 0.9599f);
        this.cube_r2.setTextureOffset(72, 70).addBox(1.0f, -10.0f, -11.0f, 0.0f, 10.0f, 30.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.blade, (Object)this.vfx, (Object)this.cube_r1, (Object)this.cube_r2);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Axe_Blade_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.root.rotateAngleY = netHeadYaw * ((float)Math.PI / 180);
        this.root.rotateAngleX = headPitch * ((float)Math.PI / 180);
        float randomValue = (float)((double)0.1f + Math.random() * (double)0.9f);
        this.vfx.rotationPointZ += randomValue * 2.0f;
        this.blade.rotationPointZ += randomValue * 6.0f;
        this.blade.setScale(1.0f, 1.0f, 1.0f + randomValue * 0.2f);
    }
}

