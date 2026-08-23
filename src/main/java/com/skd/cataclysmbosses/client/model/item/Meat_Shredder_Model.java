/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.cataclysmbosses.client.model.item;

import com.skd.cataclysmbosses.client.render.CMItemstackRenderer;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class Meat_Shredder_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox gear1;
    private final AdvancedModelBox core;
    private final AdvancedModelBox core2;
    private final AdvancedModelBox saw;
    private final AdvancedModelBox gear2;
    private final AdvancedModelBox coreroot;
    private final AdvancedModelBox longthing;

    public Meat_Shredder_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(18, 0).addBox(-3.0f, -46.5646f, -1.0268f, 6.0f, 2.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(0, 55).addBox(1.5f, -43.0f, -2.0f, 1.0f, 8.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(6, 18).addBox(-2.5f, -35.0f, -2.0f, 5.0f, 2.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(52, 28).addBox(-2.5f, -43.0f, -2.0f, 1.0f, 8.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(48, 18).addBox(-2.5f, -48.0111f, -2.5268f, 1.0f, 5.0f, 5.0f, 0.0025f, false);
        this.root.setTextureOffset(16, 48).addBox(1.5f, -48.0111f, -2.5268f, 1.0f, 5.0f, 5.0f, 0.0025f, false);
        this.root.setTextureOffset(49, 0).addBox(1.5f, -48.0111f, -6.5268f, 1.0f, 3.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(33, 0).addBox(-2.0f, -31.0f, -2.0f, 4.0f, 7.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(0, 4).addBox(0.0f, -32.0f, 1.0f, 0.0f, 13.0f, 5.0f, 0.0f, false);
        this.root.setTextureOffset(0, 0).addBox(-3.0f, -33.5f, -3.0f, 6.0f, 3.0f, 6.0f, 0.0f, false);
        this.root.setTextureOffset(21, 6).addBox(-1.5f, -24.0f, -1.5f, 3.0f, 13.0f, 3.0f, 0.0f, false);
        this.root.setTextureOffset(0, 48).addBox(-2.0f, -17.0f, -2.0f, 4.0f, 3.0f, 4.0f, 0.0f, false);
        this.root.setTextureOffset(18, 58).addBox(0.3f, -23.0f, -2.0f, 2.0f, 6.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(31, 21).addBox(0.3f, -23.0f, -2.0f, 2.0f, 1.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(12, 48).addBox(-2.3f, -23.0f, -2.0f, 2.0f, 1.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(45, 19).addBox(-2.3f, -18.0f, -2.0f, 2.0f, 1.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(39, 21).addBox(0.3f, -18.0f, -2.0f, 2.0f, 1.0f, 2.0f, 0.2f, false);
        this.root.setTextureOffset(52, 40).addBox(-2.3f, -23.0f, -2.0f, 2.0f, 6.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(10, 56).addBox(-1.0f, -11.0f, -1.0f, 2.0f, 11.0f, 2.0f, 0.0f, false);
        this.root.setTextureOffset(10, 68).addBox(0.0f, -10.5f, 0.5f, 0.0f, 7.0f, 1.0f, 0.0f, false);
        this.root.setTextureOffset(10, 68).addBox(0.0f, -10.5f, -1.5f, 0.0f, 7.0f, 1.0f, 0.0f, false);
        this.root.setTextureOffset(16, 69).addBox(0.5f, -10.5f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(16, 69).addBox(-1.5f, -10.5f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, false);
        this.root.setTextureOffset(48, 28).addBox(-1.0f, -1.0f, -1.0f, 2.0f, 1.0f, 2.0f, 0.1f, false);
        this.gear1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gear1.setRotationPoint(2.0f, -45.5f, -6.5f);
        this.root.addChild((BasicModelPart)this.gear1);
        this.setRotationAngle(this.gear1, 0.7854f, 0.0f, 0.0f);
        this.gear1.setTextureOffset(10, 9).addBox(-0.5f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0025f, false);
        this.core = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core.setRotationPoint(0.0f, -27.5f, -3.5f);
        this.root.addChild((BasicModelPart)this.core);
        this.setRotationAngle(this.core, 0.0873f, 0.0f, 0.0f);
        this.core.setTextureOffset(58, 4).addBox(-1.0f, -3.5f, -2.5f, 2.0f, 2.0f, 3.0f, 0.0f, false);
        this.core.setTextureOffset(6, 55).addBox(-1.0f, -3.5f, -2.5f, 2.0f, 2.0f, 1.0f, 0.1f, false);
        this.core.setTextureOffset(4, 0).addBox(0.0f, -3.0f, -3.4f, 0.0f, 1.0f, 1.0f, 0.0f, false);
        this.core2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.core2.setRotationPoint(0.0f, -27.5f, -3.5f);
        this.root.addChild((BasicModelPart)this.core2);
        this.setRotationAngle(this.core2, 0.0873f, 0.0f, 0.0f);
        this.core2.setTextureOffset(45, 0).addBox(-1.0f, -0.3f, -2.0f, 2.0f, 2.0f, 2.0f, 0.0f, false);
        this.core2.setTextureOffset(55, 0).addBox(-1.0f, -0.3f, -2.1f, 2.0f, 2.0f, 1.0f, 0.1f, false);
        this.core2.setTextureOffset(4, 1).addBox(0.0f, 0.2f, -3.0f, 0.0f, 1.0f, 1.0f, 0.0f, false);
        this.saw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.saw.setRotationPoint(0.0f, -45.5f, 0.0f);
        this.root.addChild((BasicModelPart)this.saw);
        this.saw.setTextureOffset(32, 32).addBox(-1.0f, -8.0f, -8.0f, 2.0f, 16.0f, 16.0f, 0.0f, false);
        this.saw.setTextureOffset(0, 0).addBox(0.0f, -12.0f, -12.0f, 0.0f, 24.0f, 24.0f, 0.0f, false);
        this.gear2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.gear2.setRotationPoint(3.0f, -30.5f, 1.5f);
        this.root.addChild((BasicModelPart)this.gear2);
        this.setRotationAngle(this.gear2, -0.7854f, 0.0f, 0.0f);
        this.gear2.setTextureOffset(33, 11).addBox(-0.5f, -2.5f, -2.5f, 2.0f, 5.0f, 5.0f, 0.0f, false);
        this.gear2.setTextureOffset(56, 13).addBox(0.5f, -2.5f, -2.5f, 1.0f, 5.0f, 5.0f, 0.2f, false);
        this.coreroot = new AdvancedModelBox((AdvancedEntityModel)this);
        this.coreroot.setRotationPoint(0.0f, -27.5f, -3.5f);
        this.root.addChild((BasicModelPart)this.coreroot);
        this.setRotationAngle(this.coreroot, 0.0873f, 0.0f, 0.0f);
        this.coreroot.setTextureOffset(47, 8).addBox(-2.0f, -4.5f, 0.0f, 4.0f, 7.0f, 3.0f, 0.1f, false);
        this.longthing = new AdvancedModelBox((AdvancedEntityModel)this);
        this.longthing.setRotationPoint(2.0f, -33.0f, -3.0f);
        this.root.addChild((BasicModelPart)this.longthing);
        this.setRotationAngle(this.longthing, 0.3054f, 0.0f, 0.0f);
        this.longthing.setTextureOffset(0, 0).addBox(-0.5f, -4.3786f, 0.1595f, 1.0f, 5.0f, 1.0f, 0.0025f, false);
        this.longthing.setTextureOffset(28, 47).addBox(0.0f, -12.3786f, 0.1595f, 0.0f, 8.0f, 1.0f, 0.0025f, false);
        this.updateDefaultPose();
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.gear1, (Object)this.gear2, (Object)this.core, (Object)this.core2, (Object)this.saw, (Object)this.coreroot, (Object)this.longthing);
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void animateStack(ItemStack itemStackIn) {
        float tick;
        this.resetToDefaultPose();
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float f = tick = Minecraft.getInstance().player == null ? 0.0f : partialTick + (float)Minecraft.getInstance().player.tickCount;
        if (Minecraft.getInstance().isPaused()) {
            tick = CMItemstackRenderer.ticksExisted;
        }
        this.core.rotationPointZ += Mth.cos((float)tick) * 1.0f + 1.0f;
        this.core2.rotationPointZ += Mth.cos((float)(tick + (float)Math.PI)) * 1.0f + 1.0f;
        this.saw.rotateAngleX += tick * 0.75f;
    }
}

