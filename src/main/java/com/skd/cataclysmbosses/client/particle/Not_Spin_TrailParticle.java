/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.AbstractTrailParticle;
import com.skd.cataclysmbosses.client.particle.Options.NotSpinTrailParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

public class Not_Spin_TrailParticle
extends AbstractTrailParticle {
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/gathering_lightning.png");
    private boolean arrive = false;
    private final double xTarget;
    private final double yTarget;
    private final double zTarget;
    private final float reduction;
    private final float acceleration;
    private final double direction;

    protected Not_Spin_TrailParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b, float gravity, float reduction, float acceleration, double direction, int life) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed, r, g, b);
        this.alpha = 1.0f;
        this.hasPhysics = false;
        this.gravity = gravity;
        this.xd = 0.0;
        this.yd = 0.0;
        this.zd = 0.0;
        this.xTarget = xSpeed;
        this.yTarget = ySpeed;
        this.zTarget = zSpeed;
        this.reduction = reduction;
        this.acceleration = acceleration;
        this.direction = direction;
        this.lifetime = life;
    }

    public int getLightCoords(float partialTicks) {
        return 240;
    }

    public float getAlpha() {
        return Mth.clamp((float)(1.0f - (float)this.age / (float)this.lifetime), (float)0.0f, (float)1.0f);
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 travelVec = new Vec3(this.xTarget - this.x, this.yTarget - this.y, this.zTarget - this.z);
        if (!this.arrive) {
            if (travelVec.length() > 1.0) {
                travelVec = travelVec.normalize();
                this.xd = this.xd * (double)this.reduction + travelVec.x * (double)this.acceleration + this.direction;
                this.yd = this.yd * (double)this.reduction + travelVec.y * (double)this.acceleration + this.direction;
                this.zd = this.zd * (double)this.reduction + travelVec.z * (double)this.acceleration + this.direction;
            } else {
                this.arrive = true;
            }
        } else {
            this.age = Math.min(this.age + 3, this.lifetime);
            this.yd -= (double)this.gravity;
        }
        float fadeIn = Mth.clamp((float)((float)this.age / (float)this.lifetime * 32.0f), (float)0.0f, (float)1.0f);
        float fadeOut = Mth.clamp((float)(1.0f - (float)this.age / (float)this.lifetime), (float)0.0f, (float)1.0f);
        this.trailA = fadeIn * fadeOut;
    }

    @Override
    public float getTrailHeight() {
        return 0.4f;
    }

    @Override
    public Identifier getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @Override
    public int sampleCount() {
        return Math.min(10, this.lifetime - this.age);
    }

    public static class Factory
    implements ParticleProvider<NotSpinTrailParticleOptions> {
        public Particle createParticle(NotSpinTrailParticleOptions data, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            Not_Spin_TrailParticle particle = new Not_Spin_TrailParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, data.r(), data.g(), data.b(), data.gravity(), data.reduction(), data.acceleration(), data.direction(), data.life());
            return particle;
        }
    }
}

