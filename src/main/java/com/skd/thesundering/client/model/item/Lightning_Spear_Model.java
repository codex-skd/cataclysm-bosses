/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.thesundering.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class Lightning_Spear_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox rot;
    private final AdvancedModelBox root_r1;

    public Lightning_Spear_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.rot = new AdvancedModelBox((AdvancedEntityModel)this);
        this.rot.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.rot);
        this.rot.setTextureOffset(0, -64).addBox(0.0f, -7.5f, -23.0f, 0.0f, 15.0f, 64.0f, 0.0f, false);
        this.root_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root_r1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.rot.addChild((BasicModelPart)this.root_r1);
        this.setRotationAngle(this.root_r1, 0.0f, 0.0f, 1.5708f);
        this.root_r1.setTextureOffset(0, -64).addBox(0.0f, -7.5f, -23.0f, 0.0f, 15.0f, 64.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void animateStack(ItemStack itemStackIn) {
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.rot, (Object)this.root_r1);
    }

    public BasicModelPart root() {
        return this.root;
    }
}

