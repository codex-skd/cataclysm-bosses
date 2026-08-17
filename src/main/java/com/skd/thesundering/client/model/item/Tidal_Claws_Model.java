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

public class Tidal_Claws_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox handguard;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox right_jaw;
    private final AdvancedModelBox left_jaw;
    private final AdvancedModelBox upper_fin;
    private final AdvancedModelBox lower_fin;

    public Tidal_Claws_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 21.0f, 0.0f);
        this.root.setTextureOffset(0, 9).addBox(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 3.0f, 0.01f, false);
        this.handguard = new AdvancedModelBox((AdvancedEntityModel)this);
        this.handguard.setRotationPoint(-3.0f, 0.0f, 1.5f);
        this.root.addChild((BasicModelPart)this.handguard);
        this.setRotationAngle(this.handguard, 0.0f, -0.1745f, 0.0f);
        this.handguard.setTextureOffset(13, 13).addBox(-1.0f, -2.0f, 0.0f, 2.0f, 4.0f, 6.0f, 0.0f, false);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.jaw);
        this.jaw.setTextureOffset(23, 0).addBox(-2.0f, -5.5f, -2.0f, 4.0f, 0.0f, 2.0f, 0.0f, false);
        this.jaw.setTextureOffset(23, 0).addBox(-2.0f, -0.5f, -2.0f, 4.0f, 0.0f, 2.0f, 0.0f, false);
        this.right_jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_jaw.setRotationPoint(-1.5f, -3.0f, 0.0f);
        this.jaw.addChild((BasicModelPart)this.right_jaw);
        this.setRotationAngle(this.right_jaw, 0.0f, 0.2618f, 0.0f);
        this.right_jaw.setTextureOffset(11, 24).addBox(-2.0f, -3.0f, -3.0f, 2.0f, 6.0f, 3.0f, 0.0f, false);
        this.right_jaw.setTextureOffset(30, 19).addBox(-2.0f, -2.0f, -4.0f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.right_jaw.setTextureOffset(24, 9).addBox(0.0f, -3.0f, -3.0f, 2.0f, 6.0f, 3.0f, 0.0f, false);
        this.right_jaw.setTextureOffset(0, 29).addBox(0.0f, -2.0f, -4.0f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.left_jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_jaw.setRotationPoint(1.95f, -3.0f, 0.4f);
        this.jaw.addChild((BasicModelPart)this.left_jaw);
        this.setRotationAngle(this.left_jaw, 0.0f, -0.3491f, 0.0f);
        this.left_jaw.setTextureOffset(22, 24).addBox(0.0f, -3.0f, -3.0f, 1.0f, 6.0f, 3.0f, 0.0f, false);
        this.left_jaw.setTextureOffset(31, 3).addBox(0.0f, -2.0f, -4.0f, 1.0f, 4.0f, 1.0f, 0.0f, false);
        this.left_jaw.setTextureOffset(0, 0).addBox(-2.0f, -2.0f, -4.0f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.left_jaw.setTextureOffset(0, 19).addBox(-2.0f, -3.0f, -3.0f, 2.0f, 6.0f, 3.0f, 0.0f, false);
        this.upper_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.upper_fin.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.upper_fin);
        this.setRotationAngle(this.upper_fin, 0.48f, -0.3054f, 0.0f);
        this.upper_fin.setTextureOffset(0, 0).addBox(-5.0f, 0.0f, 0.0f, 7.0f, 0.0f, 8.0f, 0.0f, false);
        this.lower_fin = new AdvancedModelBox((AdvancedEntityModel)this);
        this.lower_fin.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.lower_fin);
        this.setRotationAngle(this.lower_fin, -0.48f, -0.3054f, 0.0f);
        this.lower_fin.setTextureOffset(0, 0).addBox(-5.0f, -1.0f, 0.0f, 7.0f, 0.0f, 8.0f, 0.0f, false);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.handguard, (Object)this.jaw, (Object)this.right_jaw, (Object)this.left_jaw, (Object)this.upper_fin, (Object)this.lower_fin);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

