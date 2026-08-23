/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 */
package com.skd.cataclysmbosses.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Laser_Gatling_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox core_root;
    private final AdvancedModelBox core;
    private final AdvancedModelBox core2;
    private final AdvancedModelBox handle;
    private final AdvancedModelBox gatling;

    public Laser_Gatling_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-2.5f, -9.0f, 6.0f, 5.0f, 9.0f, 5.0f, 0.0f, false);
        this.root.setTextureOffset(41, 30).addBox(-1.0f, -12.0f, 11.0f, 2.0f, 9.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(62, 0).addBox(-2.5f, -4.0f, -2.0f, 5.0f, 4.0f, 8.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-4.0f, -6.0f, -17.0f, 8.0f, 4.0f, 25.0f, 0.1f, false);
        this.root.setTextureOffset(0, 30).addBox(-4.0f, -10.2f, -17.0f, 8.0f, 4.0f, 24.0f, 0.1f, false);
        this.core_root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core_root.setRotationPoint(-1.5f, 0.0f, 4.0f);
        this.root.addChild((BasicModelPart)this.core_root);
        this.setRotationAngle(this.core_root, 0.0f, 0.0f, 0.7418f);
        this.core_root.setTextureOffset(0, 41).addBox(-4.0f, -10.0f, -1.0f, 5.0f, 5.0f, 5.0f, 0.0f, false);
        this.core = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core.setRotationPoint(-1.0f, -10.0f, 2.0f);
        this.core_root.addChild((BasicModelPart)this.core);
        this.core.setTextureOffset(16, 0).addBox(-1.0f, -2.0f, -1.5f, 2.0f, 2.0f, 2.0f, 0.0f, false);
        this.core.setTextureOffset(0, 21).addBox(-1.0f, -2.0f, -1.5f, 2.0f, 1.0f, 2.0f, 0.1f, false);
        this.core2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core2.setRotationPoint(-4.0f, -8.0f, -8.0f);
        this.core_root.addChild((BasicModelPart)this.core2);
        this.core2.setTextureOffset(16, 15).addBox(-1.0f, -4.0f, 8.5f, 2.0f, 1.0f, 2.0f, 0.1f, false);
        this.core2.setTextureOffset(42, 0).addBox(-1.0f, -4.0f, 8.5f, 2.0f, 5.0f, 2.0f, 0.0f, false);
        this.handle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handle.setRotationPoint(1.5f, 0.0f, -4.0f);
        this.root.addChild((BasicModelPart)this.handle);
        this.setRotationAngle(this.handle, 0.0f, 0.0f, -0.7418f);
        this.handle.setTextureOffset(0, 30).addBox(-1.0f, -10.0f, 7.0f, 5.0f, 5.0f, 5.0f, 0.0f, false);
        this.handle.setTextureOffset(10, 16).addBox(1.5f, -13.0f, 7.0f, 0.0f, 3.0f, 5.0f, 0.0f, false);
        this.handle.setTextureOffset(0, 15).addBox(-0.5f, -13.0f, 7.0f, 2.0f, 0.0f, 5.0f, 0.0f, false);
        this.gatling = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gatling.setRotationPoint(0.0f, -6.0f, 6.0f);
        this.root.addChild((BasicModelPart)this.gatling);
        this.gatling.setTextureOffset(0, 59).addBox(-2.0f, -2.0f, -9.0f, 4.0f, 4.0f, 9.0f, 0.0f, false);
        this.gatling.setTextureOffset(48, 49).addBox(-0.5f, -4.0f, -22.0f, 1.0f, 3.0f, 17.0f, 0.0f, false);
        this.gatling.setTextureOffset(42, 0).addBox(-0.5f, 1.0f, -22.0f, 1.0f, 3.0f, 17.0f, 0.0f, false);
        this.gatling.setTextureOffset(41, 30).addBox(1.0f, -0.5f, -22.0f, 3.0f, 1.0f, 17.0f, 0.0f, false);
        this.gatling.setTextureOffset(41, 30).addBox(-4.0f, -0.5f, -22.0f, 3.0f, 1.0f, 17.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setupAnim(Entity entity, float openAmount, float switchProgress, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.core.rotationPointY += Mth.cos((float)ageInTicks) * 1.0f + 1.0f;
        this.core2.rotationPointY += Mth.cos((float)(ageInTicks + (float)Math.PI)) * 1.0f + 1.0f;
        this.gatling.rotateAngleZ -= openAmount * 0.75f;
        this.root.rotationPointZ += Mth.cos((float)(openAmount * 2.0f)) * 1.0f + 1.0f;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.core_root, (Object)this.handle, (Object)this.core, (Object)this.core2, (Object)this.gatling);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

