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

public class Astrape_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;

    public Astrape_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(38, 0).addBox(-1.0f, -40.0f, -1.0f, 2.0f, 40.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(56, 48).addBox(0.0f, -40.0f, 1.0f, 0.0f, 12.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(46, 35).addBox(-1.0f, -43.0f, -1.0f, 2.0f, 3.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(52, 23).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 1.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(52, 26).addBox(-1.0f, -5.0f, -1.0f, 2.0f, 1.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(4, 54).addBox(-0.5f, -47.0f, -0.5f, 1.0f, 4.0f, 1.0f, 0.0f, false);
        this.root.setTextureOffset(46, 0).addBox(-0.5f, -51.0f, -3.5f, 1.0f, 4.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(38, 42).addBox(0.0f, 0.0f, -4.5f, 0.0f, 10.0f, 9.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(0.0f, -70.0f, -9.5f, 0.0f, 35.0f, 19.0f, 0.0f, false);
        this.root.setTextureOffset(52, 8).addBox(-0.5f, -57.0f, -1.5f, 1.0f, 6.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(52, 16).addBox(-0.5f, -63.0f, -0.5f, 1.0f, 6.0f, 1.0f, 0.0f, false);
        this.root.setTextureOffset(46, 29).addBox(-0.5f, -50.0f, 0.5f, 1.0f, 3.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(46, 40).addBox(-0.5f, -43.0f, 2.5f, 1.0f, 1.0f, 1.0f, 0.0f, false);
        this.root.setTextureOffset(46, 19).addBox(-0.5f, -50.0f, 3.5f, 1.0f, 8.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(46, 8).addBox(-0.5f, -51.0f, -5.5f, 1.0f, 9.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(0, 54).addBox(-0.5f, -42.0f, -4.5f, 1.0f, 5.0f, 1.0f, 0.0f, false);
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

