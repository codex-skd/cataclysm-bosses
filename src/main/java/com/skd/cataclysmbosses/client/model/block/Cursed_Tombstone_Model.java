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
package com.skd.cataclysmbosses.client.model.block;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Cursed_Tombstone_Model
extends AdvancedEntityModel<Entity> {
    public final AdvancedModelBox root;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox head;
    private final AdvancedModelBox maw;

    public Cursed_Tombstone_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-7.0f, -24.0f, -2.0f, 14.0f, 22.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(36, 0).addBox(-1.5f, -22.0f, -3.0f, 3.0f, 5.0f, 1.0f, 0.0f, false);
        this.root.setTextureOffset(0, 26).addBox(-8.0f, -2.0f, -3.0f, 16.0f, 2.0f, 6.0f, 0.0f, false);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(-7.0f, -21.5f, 0.0f);
        this.root.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.2618f, 0.2182f);
        this.cube_r1.setTextureOffset(0, 34).addBox(-1.5f, -2.5f, -2.5f, 3.0f, 5.0f, 5.0f, 0.2f, true);
        this.cube_r1.setTextureOffset(16, 34).addBox(-1.5f, -2.5f, -2.5f, 3.0f, 5.0f, 5.0f, 0.1f, true);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(7.0f, -21.5f, 0.0f);
        this.root.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -0.2618f, -0.2182f);
        this.cube_r2.setTextureOffset(16, 34).addBox(-1.5f, -2.5f, -2.5f, 3.0f, 5.0f, 5.0f, 0.1f, false);
        this.cube_r2.setTextureOffset(0, 34).addBox(-1.5f, -2.5f, -2.5f, 3.0f, 5.0f, 5.0f, 0.2f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -24.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(0, 63).addBox(-4.0f, -7.0f, -5.0f, 8.0f, 7.0f, 8.0f, -0.1f, false);
        this.head.setTextureOffset(0, 48).addBox(-4.0f, -7.0f, -5.0f, 8.0f, 7.0f, 8.0f, 0.0f, false);
        this.maw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.maw.setRotationPoint(0.0f, -3.5f, -2.0f);
        this.head.addChild((BasicModelPart)this.maw);
        this.setRotationAngle(this.maw, 0.0f, 0.0f, 0.0f);
        this.maw.setTextureOffset(43, 55).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 5.0f, 4.0f, 0.0f, false);
        this.maw.setTextureOffset(43, 64).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 5.0f, 4.0f, -0.1f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.cube_r1, (Object)this.cube_r2, (Object)this.head, (Object)this.maw);
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

