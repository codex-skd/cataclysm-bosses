/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class Abyss_Blast_Portal_Model
extends AdvancedEntityModel<Abyss_Blast_Portal_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox portal;

    public Abyss_Blast_Portal_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.root.setTextureOffset(0, 49).addBox(-6.0f, -2.0f, 18.0f, 9.0f, 4.0f, 7.0f, 0.0f, false);
        this.root.setTextureOffset(1, 72).addBox(-3.0f, -1.0f, 16.0f, 7.0f, 2.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(1, 72).addBox(-21.0f, -1.0f, 5.0f, 7.0f, 2.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(1, 72).addBox(-20.0f, -1.0f, -9.0f, 7.0f, 2.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(1, 72).addBox(5.0f, -1.0f, 17.0f, 7.0f, 2.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(0, 49).addBox(17.0f, -2.0f, -9.0f, 9.0f, 4.0f, 7.0f, 0.0f, false);
        this.root.setTextureOffset(0, 49).addBox(-24.0f, -2.0f, -2.0f, 9.0f, 4.0f, 7.0f, 0.0f, false);
        this.root.setTextureOffset(1, 72).addBox(15.0f, -1.0f, -12.0f, 7.0f, 2.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(46, 55).addBox(13.0f, -1.0f, 15.0f, 3.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(46, 55).addBox(16.0f, -1.0f, -17.0f, 3.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(46, 49).addBox(15.0f, -1.0f, 11.0f, 4.0f, 2.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(46, 49).addBox(-15.0f, -1.0f, 13.0f, 4.0f, 2.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(46, 49).addBox(-21.0f, -1.0f, -13.0f, 4.0f, 2.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(46, 49).addBox(-16.0f, -1.0f, -15.0f, 4.0f, 2.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(46, 49).addBox(20.0f, -1.0f, -1.0f, 4.0f, 2.0f, 3.0f, 0.0f, false);
        this.portal = new AdvancedModelBox((AdvancedEntityModel)this);
        this.portal.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.portal);
        this.portal.setTextureOffset(-48, 0).addBox(-24.0f, 0.0f, -24.0f, 48.0f, 0.0f, 48.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.portal);
    }

    public void setupAnim(Abyss_Blast_Portal_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.portal.rotateAngleY -= ageInTicks * 0.1f;
    }

    public void setRotationAngle(AdvancedModelBox modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

