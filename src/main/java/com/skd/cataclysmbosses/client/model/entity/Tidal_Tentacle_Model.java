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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Tidal_Tentacle_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox tonguePivot;
    private final AdvancedModelBox tongue;
    private float stretch;
    public static boolean HIDE = false;

    public Tidal_Tentacle_Model() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.tonguePivot = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tonguePivot.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.tonguePivot);
        this.tongue = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tongue.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tonguePivot.addChild((BasicModelPart)this.tongue);
        this.tongue.setTextureOffset(0, 0).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 16.0f, 2.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.tonguePivot, this.tongue);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setAttributes(float f, float rotX, float rotY, float additionalYaw) {
        this.resetToDefaultPose();
        this.stretch = f;
        float f1 = 1.0f;
        this.tongue.setScale(f1, this.stretch, f1);
        this.tonguePivot.rotateAngleX = (float)Math.toRadians(rotX);
        this.tonguePivot.rotateAngleY = (float)Math.toRadians(rotY);
        this.tongue.rotateAngleY = (float)Math.toRadians(-additionalYaw);
        this.tonguePivot.showModel = !HIDE;
        this.root.showModel = !HIDE;
        this.tongue.showModel = !HIDE;
    }
}

