/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.resources.sounds.TickableSoundInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.block.entity.BlockEntity
 */
package com.skd.cataclysmbosses;

import com.skd.cataclysmbosses.ServerProxy;
import com.skd.cataclysmbosses.client.sound.MeatShredderSound;
import com.skd.cataclysmbosses.client.sound.SandstormSound;
import com.skd.cataclysmbosses.entity.effect.Sandstorm_Entity;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ClientProxy
extends ServerProxy {
    public static final Int2ObjectMap<AbstractTickableSoundInstance> ENTITY_SOUND_INSTANCE_MAP = new Int2ObjectOpenHashMap();
    public static final Map<BlockEntity, AbstractTickableSoundInstance> BLOCK_ENTITY_SOUND_INSTANCE_MAP = new HashMap<BlockEntity, AbstractTickableSoundInstance>();
    public static List<UUID> blockedEntityRenders = new ArrayList<UUID>();
    public static Map<UUID, BossBarData> bossBarRenderTypes = new HashMap<UUID, BossBarData>();

    @Override
    public boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals((Object)Minecraft.getInstance().getCameraEntity()) && Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }

    @Override
    public void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }

    @Override
    public void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

    @Override
    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
    }

    @Override
    public float getPartialTicks() {
        return Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false);
    }

    @Override
    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
        if (soundEmitter instanceof Entity) {
            Entity entity = (Entity)soundEmitter;
            if (!entity.level().isClientSide()) {
                return;
            }
        }
        switch (type) {
            case 1: {
                MeatShredderSound sound;
                MeatShredderSound shredderSound;
                if (!(soundEmitter instanceof LivingEntity)) break;
                LivingEntity livingEntity = (LivingEntity)soundEmitter;
                AbstractTickableSoundInstance old = (AbstractTickableSoundInstance)ENTITY_SOUND_INSTANCE_MAP.get(livingEntity.getId());
                if (old == null || !(old instanceof MeatShredderSound) || !(shredderSound = (MeatShredderSound)old).isSameEntity(livingEntity)) {
                    sound = new MeatShredderSound(livingEntity);
                    ENTITY_SOUND_INSTANCE_MAP.put(livingEntity.getId(), sound);
                } else {
                    sound = (MeatShredderSound)old;
                }
                if (Minecraft.getInstance().getSoundManager().isActive((SoundInstance)sound) || !sound.canPlaySound()) break;
                Minecraft.getInstance().getSoundManager().queueTickingSound((TickableSoundInstance)sound);
                break;
            }
            case 2: {
                SandstormSound sound;
                SandstormSound sandstomSound;
                if (!(soundEmitter instanceof Sandstorm_Entity)) break;
                Sandstorm_Entity sandstom = (Sandstorm_Entity)((Object)soundEmitter);
                AbstractTickableSoundInstance old = (AbstractTickableSoundInstance)ENTITY_SOUND_INSTANCE_MAP.get(sandstom.getId());
                if (old == null || !(old instanceof SandstormSound) || !(sandstomSound = (SandstormSound)old).isSameEntity(sandstom)) {
                    sound = new SandstormSound(sandstom);
                    ENTITY_SOUND_INSTANCE_MAP.put(sandstom.getId(), sound);
                } else {
                    sound = (SandstormSound)old;
                }
                if (Minecraft.getInstance().getSoundManager().isActive((SoundInstance)sound) || !sound.canPlaySound()) break;
                Minecraft.getInstance().getSoundManager().queueTickingSound((TickableSoundInstance)sound);
            }
        }
    }

    @Override
    public void clearSoundCacheFor(Entity entity) {
        ENTITY_SOUND_INSTANCE_MAP.remove(entity.getId());
    }

    @Override
    public void clearSoundCacheFor(BlockEntity entity) {
        BLOCK_ENTITY_SOUND_INSTANCE_MAP.remove(entity);
    }

    @Override
    public void openMinistrosityInventory(com.skd.cataclysmbosses.message.MessageOpenInventory packet) {
        net.minecraft.world.entity.Entity entity;
        net.minecraft.client.player.LocalPlayer player = Minecraft.getInstance().player;
        if (player != null && (entity = player.level().getEntity(packet.entityId())) instanceof com.skd.cataclysmbosses.entity.Pet.Netherite_Ministrosity_Entity guard) {
            int i = guard.getInventoryColumns();
            com.skd.cataclysmbosses.inventory.MinistrostiyMenu container = new com.skd.cataclysmbosses.inventory.MinistrostiyMenu(packet.id(), player.getInventory(), (net.minecraft.world.Container)guard.miniInventory, guard);
            player.containerMenu = container;
            Minecraft.getInstance().setScreenAndShow((net.minecraft.client.gui.screens.Screen)new com.skd.cataclysmbosses.client.gui.MinistrosityInventoryScreen(container, player.getInventory(), guard, i));
        }
    }

    public record BossBarData(int renderType, int remainLife) {
    }
}

