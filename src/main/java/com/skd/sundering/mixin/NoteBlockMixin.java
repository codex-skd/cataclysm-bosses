/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.NoteBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.skd.sundering.mixin;

import com.skd.sundering.blockentities.Cataclysm_Skull_BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={NoteBlock.class})
public abstract class NoteBlockMixin
extends Block {
    public NoteBlockMixin(BlockBehaviour.Properties p_49795_) {
        super(p_49795_);
    }

    @Inject(method={"getCustomSoundId"}, at={@At(value="HEAD")}, cancellable=true)
    public void getMobHeadCustomSoundId(Level level, BlockPos pos, CallbackInfoReturnable<Identifier> cir) {
        BlockEntity blockentity = level.getBlockEntity(pos.above());
        if (blockentity instanceof Cataclysm_Skull_BlockEntity) {
            Cataclysm_Skull_BlockEntity cataclysmSkullBlock = (Cataclysm_Skull_BlockEntity)blockentity;
            cir.setReturnValue((Object)cataclysmSkullBlock.getNoteBlockSound());
        }
    }
}

