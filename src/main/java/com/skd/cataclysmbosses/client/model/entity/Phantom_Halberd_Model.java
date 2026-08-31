/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Phantom_Halberd_Animation;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Halberd_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Phantom_Halberd_Model
extends AdvancedEntityModel<Phantom_Halberd_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox mid_root;
    private final AdvancedModelBox halberd;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox halberd2;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox cube_r3;

    public Phantom_Halberd_Model() {
        this.texWidth = 256;
        this.texHeight = 256;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this, "root");
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.mid_root = new AdvancedModelBox((AdvancedEntityModel)this, "mid_root");
        this.mid_root.setRotationPoint(-5.0E-4f, 2.3477f, -0.2083f);
        this.root.addChild((BasicModelPart)this.mid_root);
        this.halberd = new AdvancedModelBox((AdvancedEntityModel)this, "halberd");
        this.halberd.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.mid_root.addChild((BasicModelPart)this.halberd);
        this.setRotationAngle(this.halberd, -1.5708f, 0.0f, 0.0f);
        this.halberd.setTextureOffset(0, 0).addBox(-0.9901f, -1.2083f, -53.9583f, 2.0f, 2.0f, 65.0f, 0.0f, false);
        this.halberd.setTextureOffset(0, 0).addBox(-0.4901f, -0.7083f, -58.9583f, 1.0f, 1.0f, 5.0f, 0.0f, false);
        this.halberd.setTextureOffset(26, 0).addBox(0.0099f, -2.7083f, -74.9583f, 0.0f, 5.0f, 17.0f, 0.0f, false);
        this.halberd.setTextureOffset(0, 41).addBox(-1.4901f, -1.7083f, -52.9583f, 3.0f, 3.0f, 12.0f, 0.0f, false);
        this.halberd.setTextureOffset(11, 7).addBox(2.0099f, -0.7083f, -38.4583f, 2.0f, 1.0f, 0.0f, 0.0f, false);
        this.halberd.setTextureOffset(11, 12).addBox(-0.4901f, -4.2083f, -38.4583f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.halberd.setTextureOffset(0, 7).addBox(-1.9901f, -2.2083f, -38.9583f, 4.0f, 4.0f, 1.0f, 0.0f, false);
        this.halberd.setTextureOffset(11, 9).addBox(-0.4901f, 1.7917f, -38.4583f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.halberd.setTextureOffset(11, 7).addBox(-4.1089f, -0.7083f, -38.4583f, 2.0f, 1.0f, 0.0f, 0.0f, true);
        this.halberd.setTextureOffset(0, 0).addBox(0.0099f, 1.2917f, -58.9583f, 0.0f, 15.0f, 25.0f, 0.0f, false);
        this.halberd.setTextureOffset(0, 68).addBox(0.0099f, -11.7083f, -54.9583f, 0.0f, 10.0f, 19.0f, 0.0f, false);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(0.0099f, -0.2083f, -64.4583f);
        this.halberd.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, -1.5708f);
        this.cube_r1.setTextureOffset(26, 0).addBox(0.0f, -2.5f, -8.5f, 0.0f, 5.0f, 17.0f, 0.0f, false);
        this.halberd2 = new AdvancedModelBox((AdvancedEntityModel)this, "halberd2");
        this.halberd2.setRotationPoint(-0.0139f, -0.2083f, -55.4583f);
        this.halberd.addChild((BasicModelPart)this.halberd2);
        this.setRotationAngle(this.halberd2, 0.0f, 0.0f, -0.7854f);
        this.halberd2.setTextureOffset(0, 0).addBox(1.5238f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, 0.0f, false);
        this.halberd2.setTextureOffset(8, 0).addBox(-1.4762f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, 0.0f, false);
        this.halberd2.setTextureOffset(0, 0).addBox(-3.595f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, 0.0f, true);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(0.0238f, 5.0f, 0.0f);
        this.halberd2.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.0f, -1.5708f);
        this.cube_r2.setTextureOffset(0, 2).addBox(1.5f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, 0.0f, false);
        this.cube_r3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r3.setRotationPoint(0.0238f, 0.0f, 0.0f);
        this.halberd2.addChild((BasicModelPart)this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, 0.0f, -1.5708f);
        this.cube_r3.setTextureOffset(0, 0).addBox(1.5f, -0.5f, 0.0f, 2.0f, 1.0f, 0.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.mid_root, this.halberd, this.halberd2, this.cube_r1, this.cube_r2, this.cube_r3);
    }

    public void setupAnim(Phantom_Halberd_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.root.showModel = entity.getState() != 0;
        this.animate(entity.getAnimationState("one"), Phantom_Halberd_Animation.ONE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("two"), Phantom_Halberd_Animation.TWO, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("three"), Phantom_Halberd_Animation.THREE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("four"), Phantom_Halberd_Animation.FOUR, ageInTicks, 1.0f);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

