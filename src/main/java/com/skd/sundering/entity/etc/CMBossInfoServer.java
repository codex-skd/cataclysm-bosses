/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerBossEvent
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.BossEvent$BossBarColor
 *  net.minecraft.world.BossEvent$BossBarOverlay
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.sundering.entity.etc;

import com.skd.sundering.message.MessageBossBar;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class CMBossInfoServer
extends ServerBossEvent {
    private int renderType;
    private int remainlife;

    public CMBossInfoServer(Component component, BossEvent.BossBarColor bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, BossEvent.BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.renderType = renderType;
    }

    public CMBossInfoServer(Component component, BossEvent.BossBarColor bossBarColor, boolean dark, boolean fog, int renderType) {
        super(component, bossBarColor, BossEvent.BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.setCreateWorldFog(fog);
        this.renderType = renderType;
    }

    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
            PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageBossBar.Display(this.getId(), renderType, this.remainlife), (CustomPacketPayload[])new CustomPacketPayload[0]);
        }
    }

    public int getRenderType() {
        return this.renderType;
    }

    public void setLife(int life) {
        if (life != this.remainlife) {
            this.remainlife = life;
            PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageBossBar.Display(this.getId(), this.renderType, life), (CustomPacketPayload[])new CustomPacketPayload[0]);
        }
    }

    public int getLife() {
        return this.remainlife;
    }

    public void addPlayer(ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer((ServerPlayer)serverPlayer, (CustomPacketPayload)new MessageBossBar.Display(this.getId(), this.renderType, this.remainlife), (CustomPacketPayload[])new CustomPacketPayload[0]);
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer((ServerPlayer)serverPlayer, (CustomPacketPayload)new MessageBossBar.Remove(this.getId(), this.renderType, this.remainlife), (CustomPacketPayload[])new CustomPacketPayload[0]);
        super.removePlayer(serverPlayer);
    }
}

