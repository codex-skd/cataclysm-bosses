/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.AbstractTrailParticle;
import com.skd.cataclysmbosses.client.particle.Options.LightTrailParticleOptions;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class LightTrailParticle
extends AbstractTrailParticle {
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/storm.png");
    private final int EntityId;
    private final float width;
    private final float height;
    private final float initialYRot;
    private final float rotateByAge;

    public LightTrailParticle(ClientLevel world, double x, double y, double z, float r, float g, float b, float width, float height, int EntityId) {
        super(world, x, y, z, 0.0, 0.0, 0.0, r, g, b);
        this.EntityId = EntityId;
        this.gravity = 0.0f;
        this.lifetime = 20 + this.random.nextInt(20);
        this.initialYRot = this.random.nextFloat() * 360.0f;
        this.rotateByAge = (10.0f + this.random.nextFloat() * 10.0f) * (this.random.nextBoolean() ? -1.0f : 1.0f);
        this.width = width;
        this.height = height;
        Vec3 vec3 = this.getOrbitPosition();
        this.x = this.xo = vec3.x;
        this.y = this.yo = vec3.y;
        this.z = this.zo = vec3.z;
        this.xd = 0.0;
        this.yd = 0.0;
        this.zd = 0.0;
    }

    public Vec3 getEntityPosition() {
        Entity from = this.getFromEntity();
        if (from != null) {
            return from.position();
        }
        return new Vec3(this.x, this.y, this.z);
    }

    public Entity getFromEntity() {
        return this.EntityId == -1 ? null : this.level.getEntity(this.EntityId);
    }

    public Vec3 getOrbitPosition() {
        Vec3 dinoPos = this.getEntityPosition();
        Vec3 vec3 = new Vec3(0.0, (double)this.height, (double)this.width).yRot((float)Math.toRadians(this.initialYRot + this.rotateByAge * (float)this.age));
        return dinoPos.add(vec3);
    }

    @Override
    public void tick() {
        super.tick();
        float fade = 1.0f - (float)this.age / (float)this.lifetime;
        this.trailA = 1.0f * fade;
        Vec3 vec3 = this.getOrbitPosition();
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
        Entity from = this.getFromEntity();
        if (from == null) {
            this.remove();
        }
    }

    @Override
    protected VertexConsumer getVetrexConsumer(MultiBufferSource.BufferSource multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.getLightTrailEffect(this.getTrailTexture()));
    }

    @Override
    public int sampleCount() {
        return 4;
    }

    @Override
    public int sampleStep() {
        return 1;
    }

    @Override
    public float getTrailHeight() {
        return 0.5f;
    }

    public int getLightColor(float f) {
        return 240;
    }

    @Override
    public Identifier getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<LightTrailParticleOptions> {
        public Particle createParticle(LightTrailParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightTrailParticle particle = new LightTrailParticle(level, x, y, z, data.r(), data.g(), data.b(), data.width(), data.height(), data.entityid());
            return particle;
        }
    }
}

