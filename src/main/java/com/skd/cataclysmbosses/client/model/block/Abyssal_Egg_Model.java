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

import com.skd.cataclysmbosses.blockentities.Abyssal_Egg_Block_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Abyssal_Egg_Model
extends AdvancedEntityModel<Entity> {
    public final AdvancedModelBox root;
    public final AdvancedModelBox fetus;

    public Abyssal_Egg_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(0, 0).addBox(-7.0f, -17.25f, -7.0f, 14.0f, 17.0f, 14.0f, 0.0f, false);
        this.root.setTextureOffset(0, 32).addBox(-7.0f, -7.25f, -7.0f, 14.0f, 7.0f, 14.0f, 0.3f, false);
        this.fetus = new AdvancedModelBox((AdvancedEntityModel)this);
        this.fetus.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.fetus);
        this.fetus.setTextureOffset(43, 0).addBox(-6.0f, -6.0f, 0.0f, 12.0f, 12.0f, 0.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.fetus);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void animate(Abyssal_Egg_Block_Entity beak, float partialTick) {
        this.resetToDefaultPose();
        float ageInTicks = (float)beak.tickCount + partialTick;
        float spin = 0.01f;
        this.fetus.rotateAngleY -= ageInTicks * spin;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

