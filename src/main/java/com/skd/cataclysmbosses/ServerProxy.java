/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.block.entity.BlockEntity
 */
package com.skd.cataclysmbosses;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ServerProxy {
    public void init() {
    }

    // Client-only: open the Ministrosity pet inventory screen. No-op on the server;
    // ClientProxy overrides it. Keeps MessageOpenInventory free of client-class references.
    public void openMinistrosityInventory(com.skd.cataclysmbosses.message.MessageOpenInventory packet) {
    }

    public boolean isFirstPersonPlayer(Entity entity) {
        return false;
    }

    public Player getClientSidePlayer() {
        return null;
    }

    public void blockRenderingEntity(UUID id) {
    }

    public void releaseRenderingEntity(UUID id) {
    }

    public void clearSoundCacheFor(Entity entity) {
    }

    public float getPartialTicks() {
        return 1.0f;
    }

    public void clearSoundCacheFor(BlockEntity entity) {
    }

    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
    }
}

