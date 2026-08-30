/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.entity.AbstractZombieRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.monster.Zombie
 */
package com.skd.cataclysmbosses.client.render.entity;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Drowned_Host_Model;
import com.skd.cataclysmbosses.client.render.layer.Drowned_Host_Outer_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Drowned_Host_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.zombie.Zombie;

public class Drowned_Host_Renderer
extends CmMobRenderer<Drowned_Host_Entity> {
    private static final Identifier DROWNED_LOCATION = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/drowned_host.png");

    public Drowned_Host_Renderer(EntityRendererProvider.Context p_173964_) {
        super(p_173964_, new Drowned_Host_Model(p_173964_.bakeLayer(CMModelLayers.DROWNED_HOST)), 0.5f);
        this.addLayer(new Drowned_Host_Outer_Layer(this, p_173964_.getModelSet()));
    }

    public Identifier getTextureLocation(Zombie entity) {
        return DROWNED_LOCATION;
    }

    protected void setupRotations(Drowned_Host_Entity entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations((LivingEntity)entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = entity.getSwimAmount(partialTick);
        if (f > 0.0f) {
            float f1 = -10.0f - entity.getXRot();
            float f2 = Mth.lerp((float)f, (float)0.0f, (float)f1);
            poseStack.rotateAround(Axis.XP.rotationDegrees(f2), 0.0f, entity.getBbHeight() / 2.0f / scale, 0.0f);
        }
    }
}

