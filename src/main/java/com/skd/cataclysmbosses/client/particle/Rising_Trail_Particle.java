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
import com.skd.cataclysmbosses.client.particle.Options.Rising_Trail_Options;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Rising_Trail_Particle
extends AbstractTrailParticle {
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/amogus.png");
    private float width;
    private float indewidth;
    private final float initialYRot;
    private final float rotateByAge;

    public Rising_Trail_Particle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b, float width, float indewidth) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed, r, g, b);
        this.gravity = 0.0f;
        this.lifetime = 20 + this.random.nextInt(20);
        this.initialYRot = this.random.nextFloat() * 360.0f;
        this.rotateByAge = (10.0f + this.random.nextFloat() * 10.0f) * (this.random.nextBoolean() ? -1.0f : 1.0f);
        this.width = width;
        this.indewidth = indewidth;
        Vec3 vec3 = this.getOrbitPosition();
        this.x = this.xo = vec3.x;
        this.y = this.yo = vec3.y;
        this.z = this.zo = vec3.z;
    }

    public Vec3 getOrbitPosition() {
        Vec3 dinoPos = new Vec3(this.x, this.y, this.z);
        Vec3 vec3 = new Vec3(0.0, 0.0, (double)this.width).yRot((float)Math.toRadians(this.initialYRot + this.rotateByAge * (float)this.age));
        return dinoPos.add(vec3);
    }

    @Override
    public void tick() {
        super.tick();
        float fade = 1.0f - (float)this.age / (float)this.lifetime;
        this.trailA = 1.0f * fade;
        this.width -= this.indewidth;
        Vec3 vec3 = new Vec3(this.x, this.y, this.z).add(new Vec3(0.0, 0.0, (double)this.width).yRot((float)Math.toRadians(this.initialYRot + this.rotateByAge * (float)this.age)));
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
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

    public int getLightCoords(float f) {
        return 240;
    }

    @Override
    public Identifier getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<Rising_Trail_Options> {
        public Particle createParticle(Rising_Trail_Options data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            Rising_Trail_Particle particle = new Rising_Trail_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.r(), data.g(), data.b(), data.width(), data.indewidth());
            return particle;
        }
    }
}

