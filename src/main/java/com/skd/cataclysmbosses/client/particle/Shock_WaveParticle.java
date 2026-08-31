/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class Shock_WaveParticle
extends SingleQuadParticle {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/em_pulse.png");
    private float size;
    private float prevSize;
    private float prevAlpha;
    private float alphaDecrease;

    private Shock_WaveParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, (TextureAtlasSprite) null);
        this.setSize(1.0f, 0.1f);
        this.alpha = 1.0f;
        this.gravity = 0.0f;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
        this.lifetime = 40;
        this.alphaDecrease = 1.0f / Math.max((float)this.lifetime, 1.0f);
        this.size = 0.1f;
    }

    public void tick() {
        super.tick();
        this.prevSize = this.size;
        this.prevAlpha = this.alpha;
        this.size += 0.4f;
        this.xd *= 0.1;
        this.yd *= 0.8;
        this.zd *= 0.1;
        if (this.alpha > 0.0f) {
            this.alpha = Math.max(this.alpha - this.alphaDecrease, 0.0f);
        }
        this.setSize(1.0f + this.size, 0.1f);
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Factory
    implements ParticleProvider<SimpleParticleType> { // PORT(26.2): was .Sprite; registerSpecial needs a plain ParticleProvider
        public SingleQuadParticle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new Shock_WaveParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}

