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

public class Wither_Assault_SHoulder_Weapon_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox handle2;
    private final AdvancedModelBox handle;
    private final AdvancedModelBox trigger;
    private final AdvancedModelBox cube1;
    private final AdvancedModelBox cube2;
    private final AdvancedModelBox cube3;
    private final AdvancedModelBox cube4;
    private final AdvancedModelBox cap;
    private final AdvancedModelBox cap2;
    private final AdvancedModelBox cap3;

    public Wither_Assault_SHoulder_Weapon_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 23.75f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-4.0f, -16.0f, -22.0f, 8.0f, 8.0f, 39.0f, 0.0f, false);
        this.root.setTextureOffset(0, 31).addBox(-3.0f, -7.0f, 18.0f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(18, 30).addBox(-3.0f, -7.0f, -21.0f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(0, 12).addBox(-4.0f, -16.0f, -16.0f, 8.0f, 8.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(0, 22).addBox(-4.0f, -16.0f, -13.0f, 8.0f, 8.0f, 1.0f, 0.2f, false);
        this.handle2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle2.setRotationPoint(0.0f, 0.0f, 13.0f);
        this.root.addChild((BasicModelPart)this.handle2);
        this.handle2.setTextureOffset(21, 9).addBox(-1.0f, -7.0f, -29.0f, 2.0f, 7.0f, 3.0f, 0.0f, false);
        this.handle2.setTextureOffset(30, 30).addBox(-1.0f, -8.0f, -29.0f, 2.0f, 1.0f, 2.0f, 0.0f, false);
        this.handle2.setTextureOffset(0, 0).addBox(-1.0f, 0.0f, -31.0f, 1.0f, 0.0f, 2.0f, 0.0f, false);
        this.handle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle.setRotationPoint(0.0f, 0.0f, -7.0f);
        this.root.addChild((BasicModelPart)this.handle);
        this.handle.setTextureOffset(24, 0).addBox(-1.0f, -5.75f, -1.0f, 2.0f, 6.0f, 3.0f, 0.0f, false);
        this.handle.setTextureOffset(27, 33).addBox(-1.0f, -8.0f, -1.0f, 2.0f, 2.0f, 3.0f, 0.3f, false);
        this.trigger = new AdvancedModelBox((AdvancedEntityModel)this);
        this.trigger.setRotationPoint(-0.5f, -6.75f, -1.25f);
        this.handle.addChild((BasicModelPart)this.trigger);
        this.setRotationAngle(this.trigger, -0.48f, 0.0f, 0.0f);
        this.trigger.setTextureOffset(31, 0).addBox(0.0f, -1.0f, -0.5f, 1.0f, 2.0f, 1.0f, 0.0f, false);
        this.cube1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube1.setRotationPoint(0.0f, 0.0f, -18.5f);
        this.root.addChild((BasicModelPart)this.cube1);
        this.cube1.setTextureOffset(28, 9).addBox(-1.0f, -17.0f, -3.0f, 2.0f, 1.0f, 2.0f, 0.0f, false);
        this.cube2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube2.setRotationPoint(0.0f, -17.0f, -3.0f);
        this.cube1.addChild((BasicModelPart)this.cube2);
        this.setRotationAngle(this.cube2, -0.3491f, 0.0f, 0.0f);
        this.cube2.setTextureOffset(18, 0).addBox(-1.0f, 0.0f, -2.0f, 2.0f, 0.0f, 2.0f, 0.0f, false);
        this.cube3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube3.setRotationPoint(0.0f, 0.0f, 13.5f);
        this.root.addChild((BasicModelPart)this.cube3);
        this.cube3.setTextureOffset(29, 17).addBox(-1.0f, -17.0f, 1.0f, 2.0f, 1.0f, 2.0f, 0.0f, false);
        this.cube4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube4.setRotationPoint(0.0f, -17.0f, 3.0f);
        this.cube3.addChild((BasicModelPart)this.cube4);
        this.setRotationAngle(this.cube4, 0.3491f, 0.0f, 0.0f);
        this.cube4.setTextureOffset(18, 2).addBox(-1.0f, 0.0f, 0.0f, 2.0f, 0.0f, 2.0f, 0.0f, false);
        this.cap = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cap.setRotationPoint(0.0f, 0.0f, 3.0f);
        this.root.addChild((BasicModelPart)this.cap);
        this.cap.setTextureOffset(0, 0).addBox(-4.0f, -8.0f, -25.0f, 8.0f, 8.0f, 4.0f, 0.0f, false);
        this.cap2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cap2.setRotationPoint(0.0f, -8.0f, 17.0f);
        this.root.addChild((BasicModelPart)this.cap2);
        this.setRotationAngle(this.cap2, 3.1416f, 0.0f, 0.0f);
        this.cap3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cap3.setRotationPoint(0.0f, -4.0f, -1.0f);
        this.cap2.addChild((BasicModelPart)this.cap3);
        this.setRotationAngle(this.cap3, 0.0f, 0.0f, -3.1416f);
        this.cap3.setTextureOffset(18, 20).addBox(-4.0f, -4.0f, -1.0f, 8.0f, 8.0f, 2.0f, 0.0f, false);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.handle, (Object)this.handle2, (Object)this.trigger, (Object)this.cube1, (Object)this.cube2, (Object)this.cube3, (Object)this.cube4, (Object)this.cap, (Object)this.cap2, (Object)this.cap3);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

