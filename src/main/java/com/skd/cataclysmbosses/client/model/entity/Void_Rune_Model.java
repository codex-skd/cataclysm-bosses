/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.Minecraft
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.projectile.Void_Rune_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;

public class Void_Rune_Model
extends AdvancedEntityModel<Void_Rune_Entity> {
    private final AdvancedModelBox root;

    public Void_Rune_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 41.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-3.0f, -16.0f, -3.0f, 6.0f, 16.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(20, 18).addBox(-5.0f, -11.0f, -2.0f, 2.0f, 11.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(18, 0).addBox(3.0f, -3.0f, -1.0f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setupAnim(Void_Rune_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float activateProgress = entityIn.prevactivateProgress + (entityIn.activateProgress - entityIn.prevactivateProgress) * partialTick;
        this.progressPositionPrev(this.root, activateProgress, 0.0f, -17.0f, 0.0f, 10.0f);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root);
    }
}

