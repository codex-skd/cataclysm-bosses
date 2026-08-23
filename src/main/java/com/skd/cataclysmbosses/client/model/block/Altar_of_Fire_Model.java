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

import com.skd.cataclysmbosses.blockentities.AltarOfFire_Block_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Altar_of_Fire_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox pillar;
    private final AdvancedModelBox flag_ring;
    private final AdvancedModelBox flag1;
    private final AdvancedModelBox flag2;
    private final AdvancedModelBox flag3;
    private final AdvancedModelBox flag4;
    private final AdvancedModelBox edge;
    private final AdvancedModelBox under_edge;
    private final AdvancedModelBox fire;

    public Altar_of_Fire_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.pillar = new AdvancedModelBox((AdvancedEntityModel)this);
        this.pillar.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.pillar);
        this.pillar.setTextureOffset(0, 46).addBox(-8.0f, -12.0f, -8.0f, 16.0f, 4.0f, 16.0f, 0.0f, false);
        this.pillar.setTextureOffset(0, 25).addBox(-8.0f, -4.1f, -8.0f, 16.0f, 4.0f, 16.0f, 0.0f, false);
        this.pillar.setTextureOffset(0, 0).addBox(-8.0f, -20.75f, -8.0f, 16.0f, 8.0f, 16.0f, 0.5f, false);
        this.pillar.setTextureOffset(53, 13).addBox(-6.0f, -8.0f, -6.0f, 12.0f, 4.0f, 12.0f, 0.0f, false);
        this.flag_ring = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flag_ring.setRotationPoint(0.0f, -0.25f, 0.0f);
        this.pillar.addChild((BasicModelPart)this.flag_ring);
        this.flag1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flag1.setRotationPoint(0.0f, -12.0f, -8.75f);
        this.flag_ring.addChild((BasicModelPart)this.flag1);
        this.flag1.setTextureOffset(49, 0).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 11.0f, 0.0f, 0.0f, false);
        this.flag2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flag2.setRotationPoint(8.25f, -12.0f, 0.0f);
        this.flag_ring.addChild((BasicModelPart)this.flag2);
        this.flag2.setTextureOffset(66, 47).addBox(0.0f, 0.0f, -4.0f, 0.0f, 11.0f, 8.0f, 0.0f, false);
        this.flag3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flag3.setRotationPoint(0.0f, -12.0f, 8.25f);
        this.flag_ring.addChild((BasicModelPart)this.flag3);
        this.flag3.setTextureOffset(49, 0).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 11.0f, 0.0f, 0.0f, false);
        this.flag4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.flag4.setRotationPoint(-8.25f, -12.0f, 0.0f);
        this.flag_ring.addChild((BasicModelPart)this.flag4);
        this.flag4.setTextureOffset(66, 47).addBox(0.0f, 0.0f, -4.0f, 0.0f, 11.0f, 8.0f, 0.0f, false);
        this.edge = new AdvancedModelBox((AdvancedEntityModel)this);
        this.edge.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.pillar.addChild((BasicModelPart)this.edge);
        this.edge.setTextureOffset(66, 0).addBox(6.0f, -1.0f, 6.0f, 4.0f, 3.0f, 4.0f, 0.0f, false);
        this.edge.setTextureOffset(0, 67).addBox(6.0f, -1.0f, -10.0f, 4.0f, 3.0f, 4.0f, 0.0f, false);
        this.edge.setTextureOffset(0, 67).addBox(-10.0f, -1.0f, -10.0f, 4.0f, 3.0f, 4.0f, 0.0f, true);
        this.edge.setTextureOffset(66, 0).addBox(-10.0f, -1.0f, 6.0f, 4.0f, 3.0f, 4.0f, 0.0f, true);
        this.edge.setTextureOffset(0, 7).addBox(-9.0f, 3.0f, 6.0f, 3.0f, 3.0f, 3.0f, 0.0f, true);
        this.edge.setTextureOffset(0, 7).addBox(6.0f, 3.0f, 6.0f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.edge.setTextureOffset(0, 0).addBox(6.0f, 3.0f, -9.0f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.edge.setTextureOffset(0, 0).addBox(-9.0f, 3.0f, -9.0f, 3.0f, 3.0f, 3.0f, 0.0f, true);
        this.under_edge = new AdvancedModelBox((AdvancedEntityModel)this);
        this.under_edge.setRotationPoint(0.0f, 9.0f, 0.0f);
        this.pillar.addChild((BasicModelPart)this.under_edge);
        this.under_edge.setTextureOffset(0, 67).addBox(5.0f, -12.0f, -9.0f, 4.0f, 3.0f, 4.0f, 0.0f, false);
        this.under_edge.setTextureOffset(0, 67).addBox(-9.0f, -12.0f, -9.0f, 4.0f, 3.0f, 4.0f, 0.0f, true);
        this.under_edge.setTextureOffset(66, 0).addBox(-9.0f, -12.0f, 5.0f, 4.0f, 3.0f, 4.0f, 0.0f, true);
        this.under_edge.setTextureOffset(66, 0).addBox(5.0f, -12.0f, 5.0f, 4.0f, 3.0f, 4.0f, 0.0f, false);
        this.fire = new AdvancedModelBox((AdvancedEntityModel)this);
        this.fire.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.fire);
        this.setRotationAngle(this.fire, 0.0f, -0.7854f, 0.0f);
        this.fire.setTextureOffset(65, 30).addBox(-8.0f, -16.0f, 0.0f, 16.0f, 16.0f, 0.0f, 0.0f, false);
        this.fire.setTextureOffset(49, 51).addBox(0.0f, -16.0f, -8.0f, 0.0f, 16.0f, 16.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.pillar, (Object)this.flag_ring, (Object)this.edge, (Object)this.under_edge, (Object)this.fire, (Object)this.flag1, (Object)this.flag2, (Object)this.flag3, (Object)this.flag4);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void animate(AltarOfFire_Block_Entity beak, float partialTick) {
        this.resetToDefaultPose();
        float ageInTicks = (float)beak.tickCount + partialTick;
        this.walk(this.flag1, 0.1f, 0.05f, false, 0.0f, -0.05f, ageInTicks, 1.0f);
        this.flap(this.flag2, 0.1f, 0.05f, false, 0.0f, -0.05f, ageInTicks, 1.0f);
        this.walk(this.flag3, 0.1f, 0.05f, true, 0.0f, -0.05f, ageInTicks, 1.0f);
        this.flap(this.flag4, 0.1f, 0.05f, true, 0.0f, -0.05f, ageInTicks, 1.0f);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

