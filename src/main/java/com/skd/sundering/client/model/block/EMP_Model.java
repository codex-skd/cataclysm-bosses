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

import com.skd.sundering.blockentities.EMP_Block_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class EMP_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox down;
    private final AdvancedModelBox inner;
    private final AdvancedModelBox up;

    public EMP_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.down = new AdvancedModelBox((AdvancedEntityModel)this);
        this.down.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.down);
        this.down.setTextureOffset(0, 23).addBox(-8.0f, 0.0f, -8.0f, 16.0f, 7.0f, 16.0f, 0.0f, false);
        this.down.setTextureOffset(48, 23).addBox(-7.0f, -1.0f, -7.0f, 14.0f, 1.0f, 14.0f, 0.0f, false);
        this.inner = new AdvancedModelBox((AdvancedEntityModel)this);
        this.inner.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.inner);
        this.inner.setTextureOffset(0, 46).addBox(-6.0f, -14.0f, -6.0f, 12.0f, 14.0f, 12.0f, 0.0f, false);
        this.inner.setTextureOffset(0, 72).addBox(-6.0f, -8.0f, -6.0f, 12.0f, 3.0f, 12.0f, 0.3f, false);
        this.up = new AdvancedModelBox((AdvancedEntityModel)this);
        this.up.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.inner.addChild((BasicModelPart)this.up);
        this.up.setTextureOffset(0, 0).addBox(-8.0f, -7.0f, -8.0f, 16.0f, 7.0f, 16.0f, 0.0f, false);
        this.up.setTextureOffset(48, 0).addBox(-7.0f, 0.0f, -7.0f, 14.0f, 1.0f, 14.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.down, (Object)this.inner, (Object)this.up);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void animate(EMP_Block_Entity beak, float partialTick) {
        this.resetToDefaultPose();
        float amount = beak.getChompProgress(partialTick);
        this.progressPositionPrev(this.inner, amount, 0.0f, 5.0f, 0.0f, 15.0f);
        this.progressPositionPrev(this.up, amount, 0.0f, 5.5f, 0.0f, 15.0f);
    }
}

