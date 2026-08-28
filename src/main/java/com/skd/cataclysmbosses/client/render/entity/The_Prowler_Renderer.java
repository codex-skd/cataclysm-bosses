/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.WalkAnimationState
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.The_Prowler_Model;
import com.skd.cataclysmbosses.client.render.layer.The_Prowler_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Prowler_Renderer
extends CmMobRenderer<The_Prowler_Entity> {
    private final RandomSource rnd = RandomSource.create();
    private static final Identifier PROWLER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/factory/the_prowler.png");
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[4];

    public The_Prowler_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new The_Prowler_Model(renderManagerIn.bakeLayer(CMModelLayers.PROWLER_MODEL)), 0.7f);
        this.addLayer(new The_Prowler_Layer(this));
        for (int i = 0; i < 4; ++i) {
            The_Prowler_Renderer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/factory/the_prowler_" + i + ".png"));
        }
    }

    protected float getFlipDegrees(The_Prowler_Entity entity) {
        return 0.0f;
    }

    public Identifier getTextureLocation(The_Prowler_Entity entity) {
        WalkAnimationState walkanimationstate = entity.walkAnimation;
        int f3 = (int)walkanimationstate.position((float)entity.tickCount);
        return this.getGrowingTexture(entity, (int)((float)f3 * 0.5f % 4.0f));
    }

    public Identifier getGrowingTexture(The_Prowler_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)4)];
    }

    public Vec3 getRenderOffset(The_Prowler_Entity entityIn, float partialTicks) {
        if (entityIn.getAttackState() == 1) {
            double d0 = 0.05;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0, this.rnd.nextGaussian() * d0);
        }
        return super.getRenderOffset((Entity)entityIn, partialTicks);
    }

    protected void scale(The_Prowler_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

