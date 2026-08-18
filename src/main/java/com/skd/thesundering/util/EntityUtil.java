/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  org.jetbrains.annotations.Nullable
 *  top.theillusivec4.curios.api.CuriosApi
 */
package com.skd.thesundering.util;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;

public class EntityUtil {
    public static void sendPlayerVelocityPacket(Entity entity) {
        if (entity instanceof ServerPlayer) {
            ServerPlayer severplayer = (ServerPlayer)entity;
            severplayer.connection.send((Packet)new ClientboundSetEntityMotionPacket(entity));
        }
    }

    public static void disableShield(Player player, int ticks) {
        if (!player.level().isClientSide() && player.isBlocking()) {
            player.getCooldowns().addCooldown(player.getUseItem(), ticks);
            player.stopUsingItem();
            player.level().broadcastEntityEvent((Entity)player, (byte)30);
        }
    }

    public static boolean OverDistanceAndHeight(LivingEntity entity, LivingEntity target, float dis, float height) {
        double y = target.getY(0.5) - entity.getY(0.5);
        boolean yDistant = Math.abs(y) > (double)height;
        return entity.distanceToSqr((Entity)target) > (double)(dis * dis) || yDistant;
    }

    public static boolean UnderDistanceAndHeight(LivingEntity entity, LivingEntity target, float dis, float height) {
        double y = target.getY(0.5) - entity.getY(0.5);
        boolean yDistant = Math.abs(y) < (double)height;
        return entity.distanceToSqr((Entity)target) < (double)(dis * dis) && yDistant;
    }

    public static boolean OverHorizontalDistance(LivingEntity entity, LivingEntity target, float dis) {
        double dz;
        double dx = target.getX() - entity.getX();
        double distSqr = dx * dx + (dz = target.getZ() - entity.getZ()) * dz;
        return distSqr > (double)(dis * dis);
    }

    public static boolean UnderHorizontalDistance(LivingEntity entity, LivingEntity target, float dis) {
        double dz;
        double dx = target.getX() - entity.getX();
        double distSqr = dx * dx + (dz = target.getZ() - entity.getZ()) * dz;
        return distSqr < (double)(dis * dis);
    }

    // TODO(Curios): CuriosApi is not on the compile classpath yet -- deferred per
    // FASE1_PLAN_CATACLYSM.md until Curios is wired into build.gradle (batches 4-5 area).
    // Do not attempt to fix this call site until then.
    public static boolean isEquipped(Item item, @Nullable LivingEntity entity) {
        return entity != null && CuriosApi.getCuriosInventory((LivingEntity)entity).map(inv -> inv.findFirstCurio(item).isPresent()).orElse(false) != false;
    }
}

