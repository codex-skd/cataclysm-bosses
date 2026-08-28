/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.blaze3d.vertex.VertexFormatElement
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.Options.AfterImageParticleOptions;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.config.CMClientConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.util.function.Function;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class AfterImageParticle
extends SingleQuadParticle {
    private final int EntityId;
    private final boolean ghost;

    public AfterImageParticle(ClientLevel world, double x, double y, double z, int r, int g, int b, int entityId, boolean ghost, int lifetimes) {
        super(world, x, y, z, null);
        this.setSize(6.0f, 6.0f);
        this.x = x;
        this.y = y;
        this.z = z;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        this.EntityId = entityId;
        this.lifetime = lifetimes;
        this.ghost = ghost;
    }

    public AABB getRenderBoundingBox(float partialTicks) {
        return this.getBoundingBox().inflate(0.0);
    }

    public void tick() {
        Entity from;
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
        if ((from = this.getFromEntity()) == null) {
            this.remove();
        }
    }

    public Entity getFromEntity() {
        return this.EntityId == -1 ? null : this.level.getEntity(this.EntityId);
    }

    @Override
    public void extract(QuadParticleRenderState state, Camera camera, float tick) {
        // TODO: Implement afterimage rendering with new API
        // This particle renders a living entity as an afterimage - requires custom rendering pipeline
    }

    @Override
    public ParticleRenderType getGroup() {
        return ParticleRenderType.SINGLE_QUADS;
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<AfterImageParticleOptions> {
        @Override
        public Particle createParticle(AfterImageParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            AfterImageParticle particle = new AfterImageParticle(level, x, y, z, data.r(), data.g(), data.b(), data.entityid(), data.ghost(), data.lifeticks());
            return particle;
        }
    }
}