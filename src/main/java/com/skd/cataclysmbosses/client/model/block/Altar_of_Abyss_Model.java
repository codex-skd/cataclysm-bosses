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

import com.skd.cataclysmbosses.blockentities.AltarOfAbyss_Block_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Altar_of_Abyss_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox tentacle;
    private final AdvancedModelBox skul;
    private final AdvancedModelBox maw;

    public Altar_of_Abyss_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 20).addBox(-8.0f, -3.0f, -8.0f, 16.0f, 3.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-8.0f, -11.0f, -8.0f, 16.0f, 3.0f, 16.0f, 0.0f, false);
        this.root.setTextureOffset(0, 40).addBox(-6.0f, -8.0f, -6.0f, 12.0f, 5.0f, 12.0f, 0.0f, false);
        this.root.setTextureOffset(73, 16).addBox(-9.0f, -2.0f, 5.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(59, 70).addBox(-9.0f, -2.0f, -9.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(42, 69).addBox(5.0f, -2.0f, -9.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(13, 58).addBox(5.0f, -2.0f, 5.0f, 4.0f, 2.0f, 4.0f, 0.0f, false);
        this.tentacle = new AdvancedModelBox((AdvancedEntityModel)this);
        this.tentacle.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.tentacle);
        this.tentacle.setTextureOffset(0, 75).addBox(0.0f, -4.0f, -10.0f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.tentacle.setTextureOffset(30, 74).addBox(-4.0f, -4.0f, 8.0f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.tentacle.setTextureOffset(17, 74).addBox(8.0f, -6.0f, 0.0f, 2.0f, 6.0f, 4.0f, 0.0f, false);
        this.tentacle.setTextureOffset(72, 73).addBox(-10.0f, -6.0f, -4.0f, 2.0f, 6.0f, 4.0f, 0.0f, false);
        this.tentacle.setTextureOffset(0, 58).addBox(8.0f, -14.0f, -4.0f, 2.0f, 8.0f, 8.0f, 0.0f, false);
        this.tentacle.setTextureOffset(41, 52).addBox(-10.0f, -14.0f, -4.0f, 2.0f, 8.0f, 8.0f, 0.0f, false);
        this.tentacle.setTextureOffset(65, 32).addBox(-4.0f, -12.0f, -10.0f, 8.0f, 8.0f, 2.0f, 0.0f, false);
        this.tentacle.setTextureOffset(62, 59).addBox(-4.0f, -12.0f, 8.0f, 8.0f, 8.0f, 2.0f, 0.0f, false);
        this.skul = new AdvancedModelBox((AdvancedEntityModel)this);
        this.skul.setRotationPoint(0.0f, -11.0f, 2.0f);
        this.root.addChild((BasicModelPart)this.skul);
        this.setRotationAngle(this.skul, -0.5236f, 0.0f, 0.0f);
        this.skul.setTextureOffset(49, 0).addBox(-6.0f, -9.0f, 0.0f, 12.0f, 9.0f, 6.0f, 0.0f, false);
        this.skul.setTextureOffset(0, 20).addBox(4.0f, -9.0f, -4.0f, 2.0f, 7.0f, 4.0f, 0.0f, false);
        this.skul.setTextureOffset(0, 0).addBox(-6.0f, -9.0f, -4.0f, 2.0f, 7.0f, 4.0f, 0.0f, false);
        this.skul.setTextureOffset(37, 40).addBox(-4.0f, -13.0f, -1.0f, 8.0f, 4.0f, 7.0f, 0.0f, false);
        this.skul.setTextureOffset(54, 52).addBox(-4.0f, -13.0f, -5.0f, 8.0f, 2.0f, 4.0f, 0.0f, false);
        this.maw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.maw.setRotationPoint(0.0f, -11.0f, -2.0f);
        this.root.addChild((BasicModelPart)this.maw);
        this.setRotationAngle(this.maw, 0.5236f, 0.0f, 0.0f);
        this.maw.setTextureOffset(49, 20).addBox(-5.0f, -8.0f, -3.0f, 10.0f, 8.0f, 3.0f, 0.0f, false);
        this.maw.setTextureOffset(43, 76).addBox(-5.0f, -8.0f, 0.0f, 1.0f, 6.0f, 3.0f, 0.0f, false);
        this.maw.setTextureOffset(0, 40).addBox(4.0f, -8.0f, 0.0f, 1.0f, 6.0f, 3.0f, 0.0f, false);
        this.maw.setTextureOffset(68, 43).addBox(-3.0f, -12.0f, -4.0f, 6.0f, 4.0f, 4.0f, 0.0f, false);
        this.maw.setTextureOffset(21, 65).addBox(-3.0f, -12.0f, 0.0f, 6.0f, 4.0f, 4.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.tentacle, (Object)this.skul, (Object)this.maw);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void animate(AltarOfAbyss_Block_Entity beak, float partialTick) {
        this.resetToDefaultPose();
        float amount = beak.getChompProgress(partialTick);
        this.progressRotationPrev(this.skul, amount, (float)Math.toRadians(30.0), 0.0f, 0.0f, 30.0f);
        this.progressRotationPrev(this.maw, amount, (float)Math.toRadians(-30.0), 0.0f, 0.0f, 30.0f);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

