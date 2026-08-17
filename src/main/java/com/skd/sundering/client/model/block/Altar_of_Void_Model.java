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
package com.skd.sundering.client.model.block;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Altar_of_Void_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox edge1;
    private final AdvancedModelBox edge2;
    private final AdvancedModelBox edge3;
    private final AdvancedModelBox edge4;

    public Altar_of_Void_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 21).addBox(-7.0f, -4.0f, -7.0f, 14.0f, 4.0f, 14.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-8.0f, -14.0f, -8.0f, 16.0f, 4.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 40).addBox(-6.0f, -10.0f, -6.0f, 12.0f, 6.0f, 12.0f, 0.0f, false);
        this.root.setTextureOffset(0, 67).addBox(-3.0f, -3.0f, 7.0f, 6.0f, 3.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(49, 10).addBox(-3.0f, -3.0f, -9.0f, 6.0f, 3.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(36, 66).addBox(-9.0f, -3.0f, -3.0f, 2.0f, 3.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(65, 43).addBox(7.0f, -3.0f, -3.0f, 2.0f, 3.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false);
        this.edge1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.edge1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.edge1);
        this.edge1.setTextureOffset(65, 4).addBox(-9.0f, -12.0f, -9.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge1.setTextureOffset(60, 61).addBox(-9.0f, -18.0f, -9.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge1.setTextureOffset(49, 49).addBox(-9.0f, -16.0f, -9.0f, 5.0f, 3.0f, 5.0f, 0.0f, false);
        this.edge2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.edge2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.edge2);
        this.edge2.setTextureOffset(60, 16).addBox(-9.0f, -12.0f, 4.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge2.setTextureOffset(49, 0).addBox(-9.0f, -16.0f, 4.0f, 5.0f, 3.0f, 5.0f, 0.0f, false);
        this.edge2.setTextureOffset(59, 25).addBox(-9.0f, -18.0f, 4.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.edge3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.edge3);
        this.edge3.setTextureOffset(21, 59).addBox(4.0f, -12.0f, -9.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge3.setTextureOffset(43, 21).addBox(4.0f, -16.0f, -9.0f, 5.0f, 3.0f, 5.0f, 0.0f, false);
        this.edge3.setTextureOffset(0, 59).addBox(4.0f, -18.0f, -9.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.edge4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.edge4);
        this.edge4.setTextureOffset(44, 58).addBox(4.0f, -12.0f, 4.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.edge4.setTextureOffset(37, 40).addBox(4.0f, -16.0f, 4.0f, 5.0f, 3.0f, 5.0f, 0.0f, false);
        this.edge4.setTextureOffset(53, 35).addBox(4.0f, -18.0f, 4.0f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.edge1, (Object)this.edge2, (Object)this.edge3, (Object)this.edge4);
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

