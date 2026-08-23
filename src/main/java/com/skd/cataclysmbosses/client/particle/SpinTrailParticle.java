/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.AbstractTrailParticle;
import com.skd.cataclysmbosses.client.particle.Options.SpinTrailParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class SpinTrailParticle
extends AbstractTrailParticle {
    private static final Identifier PROTON_TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/gathering_lightning.png");
    protected double orbitX;
    protected double orbitY;
    protected double orbitZ;
    protected double orbitDistance;
    protected Vec3 orbitOffset;
    protected boolean reverseOrbit;
    protected int orbitAxis;
    protected float orbitSpeed = 1.0f;

    public SpinTrailParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd, float r, float g, float b) {
        super(world, x, y, z, 0.0, 0.0, 0.0, r, g, b);
        this.trailA = 0.8f;
        this.lifetime = 50 + this.random.nextInt(30);
        this.gravity = 0.0f;
        this.orbitX = xd;
        this.orbitY = yd;
        this.orbitZ = zd;
        this.orbitDistance = 4.0;
        this.orbitOffset = new Vec3(0.0, 0.0, 0.0);
        this.reverseOrbit = this.random.nextBoolean();
        this.orbitAxis = this.random.nextInt(2);
        this.orbitSpeed = 10.0f;
    }

    public Vec3 getOrbitPosition(float angle) {
        Vec3 center = new Vec3(this.orbitX, this.orbitY, this.orbitZ);
        float f = this.reverseOrbit ? -1.0f : 1.0f;
        Vec3 add = Vec3.ZERO;
        float rot = angle * 3.0f * this.orbitSpeed * ((float)Math.PI / 180);
        switch (this.orbitAxis) {
            case 0: {
                add = new Vec3(0.0, this.orbitDistance * 0.5, this.orbitDistance * 0.5).xRot(rot * f);
                break;
            }
            case 1: {
                add = new Vec3(this.orbitDistance * 0.5, 0.0, this.orbitDistance * 0.5).yRot(rot * f);
                break;
            }
            case 2: {
                add = new Vec3(this.orbitDistance * 0.5, this.orbitDistance * 0.5, 0.0).zRot(rot * f);
            }
        }
        return center.add(add);
    }

    @Override
    public void tick() {
        Vec3 vec3 = this.getOrbitPosition(this.age);
        Vec3 movement = vec3.subtract(this.x, this.y, this.z).normalize().scale((double)(this.orbitSpeed * 0.01f));
        this.xd += movement.x;
        this.yd += movement.y;
        this.zd += movement.z;
        float fade = 1.0f - (float)this.age / (float)this.lifetime;
        this.trailA = 0.8f * fade;
        super.tick();
    }

    public int getLightColor(float f) {
        return 240;
    }

    @Override
    public float getTrailHeight() {
        return 0.2f;
    }

    @Override
    public Identifier getTrailTexture() {
        return PROTON_TRAIL_TEXTURE;
    }

    @Override
    public int sampleCount() {
        return Math.min(10, this.lifetime - this.age);
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<SpinTrailParticleOptions> {
        public Particle createParticle(SpinTrailParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SpinTrailParticle particle = new SpinTrailParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.r(), data.g(), data.b());
            return particle;
        }
    }
}

