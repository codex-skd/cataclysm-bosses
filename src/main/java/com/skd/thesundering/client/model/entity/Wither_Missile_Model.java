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
package com.skd.thesundering.client.model.entity;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Wither_Missile_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox head;
    private final AdvancedModelBox jaw;

    public Wither_Missile_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.root.setTextureOffset(22, 24).addBox(-3.0f, -2.0f, 0.0f, 6.0f, 6.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(24, 0).addBox(-3.0f, -2.0f, 2.0f, 6.0f, 6.0f, 2.0f, 0.3f, false);
        this.root.setTextureOffset(0, 24).addBox(-4.0f, -3.0f, 4.0f, 8.0f, 8.0f, 3.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -0.25f, -6.25f);
        this.root.addChild((BasicModelPart)this.head);
        this.setRotationAngle(this.head, -0.2182f, 0.0f, 0.0f);
        this.head.setTextureOffset(36, 30).addBox(0.0f, -10.75f, -7.0f, 0.0f, 12.0f, 14.0f, 0.0f, false);
        this.head.setTextureOffset(0, 49).addBox(-4.0f, -4.25f, -1.0f, 8.0f, 7.0f, 8.0f, 0.25f, false);
        this.head.setTextureOffset(0, 0).addBox(-4.0f, -4.75f, -1.0f, 8.0f, 6.0f, 8.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, 4.0f, 1.0f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.setRotationAngle(this.jaw, 0.5236f, 0.0f, 0.0f);
        this.jaw.setTextureOffset(0, 14).addBox(-4.0f, 0.25f, -1.0f, 8.0f, 2.0f, 8.0f, 0.0f, false);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.jaw, (Object)this.head);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.rotateAngleY = netHeadYaw * ((float)Math.PI / 180);
        this.root.rotateAngleX = headPitch * ((float)Math.PI / 180);
    }
}

