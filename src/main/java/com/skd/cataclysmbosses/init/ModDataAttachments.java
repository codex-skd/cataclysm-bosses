/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.resources.ResourceKey
 *  net.neoforged.neoforge.attachment.AttachmentType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.Attachment.ChargeAttachment;
import com.skd.cataclysmbosses.Attachment.ParryAttachment;
import com.skd.cataclysmbosses.Attachment.RenderRushAttachment;
import com.skd.cataclysmbosses.Attachment.TidalTentacleAttachment;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create((ResourceKey)NeoForgeRegistries.Keys.ATTACHMENT_TYPES, (String)"cataclysm");
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> HOOK_FALLING = ATTACHMENT_TYPES.register("hook_falling", () -> AttachmentType.builder(() -> false).serialize((Codec)Codec.BOOL).build());
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<ChargeAttachment>> CHARGE_ATTACHMENT = ATTACHMENT_TYPES.register("charge_attachment", () -> AttachmentType.builder(ChargeAttachment::new).build());
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<RenderRushAttachment>> RENDER_RUSH_ATTACHMENT = ATTACHMENT_TYPES.register("render_rush_attachment", () -> AttachmentType.builder(RenderRushAttachment::new).build());
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<TidalTentacleAttachment>> TIDAL_TENTACLE_ATTACHMENT = ATTACHMENT_TYPES.register("tidal_tentacle_attachment", () -> AttachmentType.builder(TidalTentacleAttachment::new).build());
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<ParryAttachment>> PARRY_ATTACHMENT = ATTACHMENT_TYPES.register("parry_attachment", () -> AttachmentType.builder(ParryAttachment::new).build());
}

