/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.client.render.etc.LightningBoltData;
import com.skd.cataclysmbosses.client.render.etc.LightningRender;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

public class LightningParticle
extends Particle {
    private double toX;
    private double toY;
    private double toZ;
    private LightningRender lightningRender = new LightningRender();
    private float rCol;
    private float gCol;
    private float bCol;

    public LightningParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int r, int g, int b) {
        super(world, x, y, z);
        this.setSize(1.0f, 1.0f);
        this.gravity = 0.0f;
        this.lifetime = 5 + new Random().nextInt(3);
        this.toX = xSpeed;
        this.toY = ySpeed;
        this.toZ = zSpeed;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
    }

    @Override
    public ParticleRenderType getGroup() {
        return ParticleRenderType.SINGLE_QUADS;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<LightningParticleOptions> {
        public Particle createParticle(LightningParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            LightningParticle particle = new LightningParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.r(), data.g(), data.b());
            return particle;
        }
    }
}

