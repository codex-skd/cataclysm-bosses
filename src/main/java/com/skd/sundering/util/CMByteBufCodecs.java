/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.util;

import com.skd.sundering.util.CMMathUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.phys.Vec3;

public interface CMByteBufCodecs {
    public static final StreamCodec<ByteBuf, Vec3> VEC3 = new StreamCodec<ByteBuf, Vec3>(){

        public Vec3 decode(ByteBuf p_319897_) {
            return CMMathUtil.readVec3(p_319897_);
        }

        public void encode(ByteBuf p_320441_, Vec3 p_340932_) {
            CMMathUtil.writeVec3(p_320441_, p_340932_);
        }
    };
}

