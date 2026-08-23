package com.skd.cataclysmbosses.util.CustomExplosion;

import com.skd.cataclysmbosses.init.ModParticle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerExplosion;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

// In 26.2, net.minecraft.world.level.Explosion became a thin data interface -- all of vanilla's
// block-destruction / entity-damage / fire-spread logic now lives in the (non-final) concrete
// class ServerExplosion. This extends ServerExplosion to reuse that logic via explode() as-is,
// and only adds the Ignis-specific sound + colored-particle finalize step, which vanilla no
// longer performs as part of explode() at all (that used to be this class's own reimplementation
// of the pre-26.2 abstract Explosion algorithm; that duplication is gone now).
public class IgnisExplosion extends ServerExplosion {
    private final ServerLevel level;
    private final Vec3 center;
    private final float radius;
    private final RandomSource random = RandomSource.create();

    public IgnisExplosion(Level level, @Nullable Entity source, @Nullable DamageSource damageSource, @Nullable ExplosionDamageCalculator damageCalculator, double x, double y, double z, float radius, boolean fire, Explosion.BlockInteraction blockInteraction) {
        super((ServerLevel)level, source, damageSource, damageCalculator, new Vec3(x, y, z), radius, fire, blockInteraction);
        this.level = (ServerLevel)level;
        this.center = new Vec3(x, y, z);
        this.radius = radius;
    }

    public void finalizeExplosion(int color, double size) {
        this.level.playSound(null, this.center.x, this.center.y, this.center.z, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0f, (1.0f + (this.level.getRandom().nextFloat() - this.level.getRandom().nextFloat()) * 0.2f) * 0.7f);
        if (color != 0) {
            int count = 0;
            while ((float)count < 5.0f + this.radius * 5.0f) {
                float particleX = (this.random.nextFloat() - 0.5f) * this.radius * 1.5f;
                float particleY = (this.random.nextFloat() - 0.5f) * this.radius * 1.5f;
                float particleZ = (this.random.nextFloat() - 0.5f) * this.radius * 1.5f;
                this.level.sendParticles(
                        color == 1 ? (SimpleParticleType)ModParticle.IGNIS_EXPLODE.get()
                                : color == 2 ? (SimpleParticleType)ModParticle.IGNIS_SOUL_EXPLODE.get()
                                : color == 3 ? (SimpleParticleType)ModParticle.IGNIS_ABYSS_EXPLODE.get()
                                : ParticleTypes.EXPLOSION,
                        this.center.x + (double)particleX, this.center.y + (double)particleY, this.center.z + (double)particleZ,
                        1, 1.0, 0.0, 0.0, size);
                ++count;
            }
        }
    }
}
