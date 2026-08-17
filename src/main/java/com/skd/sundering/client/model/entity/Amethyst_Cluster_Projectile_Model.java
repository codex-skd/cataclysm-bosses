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

import com.skd.sundering.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Amethyst_Cluster_Projectile_Model
extends AdvancedEntityModel<Amethyst_Cluster_Projectile_Entity> {
    private final AdvancedModelBox roots;
    private final AdvancedModelBox bone;
    private final AdvancedModelBox bone2;
    private final AdvancedModelBox bone4;
    private final AdvancedModelBox bone3;

    public Amethyst_Cluster_Projectile_Model() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.roots = new AdvancedModelBox((AdvancedEntityModel)this);
        this.roots.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.roots.setTextureOffset(0, 0).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f, 0.0f, false);
        this.roots.setTextureOffset(8, 19).addBox(-2.0f, -12.0f, 0.0f, 4.0f, 10.0f, 0.0f, 0.0f, false);
        this.roots.setTextureOffset(18, 17).addBox(-1.0f, -10.0f, -1.0f, 2.0f, 4.0f, 2.0f, 0.0f, false);
        this.roots.setTextureOffset(0, 8).addBox(0.0f, -11.0f, -2.0f, 0.0f, 9.0f, 4.0f, 0.0f, false);
        this.roots.setTextureOffset(16, 0).addBox(-1.5f, -6.0f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.bone = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bone.setRotationPoint(3.0f, 0.875f, -3.0f);
        this.roots.addChild((BasicModelPart)this.bone);
        this.setRotationAngle(this.bone, 0.3054f, -0.7418f, 0.0f);
        this.bone.setTextureOffset(16, 4).addBox(0.0f, -3.875f, -1.5f, 0.0f, 5.0f, 3.0f, 0.0f, false);
        this.bone.setTextureOffset(0, 21).addBox(-1.5f, -3.875f, 0.0f, 3.0f, 5.0f, 0.0f, 0.0f, false);
        this.bone.setTextureOffset(20, 10).addBox(-1.0f, -1.875f, -1.0f, 2.0f, 3.0f, 2.0f, 0.0f, false);
        this.bone.setTextureOffset(8, 12).addBox(-1.5f, 1.125f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.bone2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bone2.setRotationPoint(3.0f, 0.875f, 3.0f);
        this.roots.addChild((BasicModelPart)this.bone2);
        this.setRotationAngle(this.bone2, -0.3054f, 0.7418f, 0.0f);
        this.bone2.setTextureOffset(16, 4).addBox(0.0f, -3.875f, -1.5f, 0.0f, 5.0f, 3.0f, 0.0f, false);
        this.bone2.setTextureOffset(0, 21).addBox(-1.5f, -3.875f, 0.0f, 3.0f, 5.0f, 0.0f, 0.0f, false);
        this.bone2.setTextureOffset(20, 10).addBox(-1.0f, -1.875f, -1.0f, 2.0f, 3.0f, 2.0f, 0.0f, false);
        this.bone2.setTextureOffset(8, 12).addBox(-1.5f, 1.125f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.bone4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bone4.setRotationPoint(-3.0f, 0.875f, 3.0f);
        this.roots.addChild((BasicModelPart)this.bone4);
        this.setRotationAngle(this.bone4, -0.3054f, -0.7418f, 0.0f);
        this.bone4.setTextureOffset(16, 4).addBox(0.0f, -3.875f, -1.5f, 0.0f, 5.0f, 3.0f, 0.0f, true);
        this.bone4.setTextureOffset(0, 21).addBox(-1.5f, -3.875f, 0.0f, 3.0f, 5.0f, 0.0f, 0.0f, true);
        this.bone4.setTextureOffset(20, 10).addBox(-1.0f, -1.875f, -1.0f, 2.0f, 3.0f, 2.0f, 0.0f, true);
        this.bone4.setTextureOffset(8, 12).addBox(-1.5f, 1.125f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, true);
        this.bone3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bone3.setRotationPoint(-3.0f, 0.875f, -3.0f);
        this.roots.addChild((BasicModelPart)this.bone3);
        this.setRotationAngle(this.bone3, 0.3054f, 0.7418f, 0.0f);
        this.bone3.setTextureOffset(16, 4).addBox(0.0f, -3.875f, -1.5f, 0.0f, 5.0f, 3.0f, 0.0f, true);
        this.bone3.setTextureOffset(0, 21).addBox(-1.5f, -3.875f, 0.0f, 3.0f, 5.0f, 0.0f, 0.0f, true);
        this.bone3.setTextureOffset(20, 10).addBox(-1.0f, -1.875f, -1.0f, 2.0f, 3.0f, 2.0f, 0.0f, true);
        this.bone3.setTextureOffset(8, 12).addBox(-1.5f, 1.125f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, true);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.roots, (Object)this.bone, (Object)this.bone2, (Object)this.bone3, (Object)this.bone4);
    }

    public BasicModelPart root() {
        return this.roots;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Amethyst_Cluster_Projectile_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}

