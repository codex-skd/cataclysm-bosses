/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.Util
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.stats.Stats
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.AttachFace
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  net.neoforged.neoforge.registries.DeferredBlock
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blocks.Mural_Block;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.registries.DeferredBlock;

public class Ink_Mural_Block
extends Mural_Block {
    // PORT(26.2): was Util.make(..., list -> list.add(ModBlocks.X.get())) — eager .get() in <clinit>
    // crashed ("unbound value") because this class inits mid block-registration. Hold the deferred
    // holders instead and resolve lazily at use (all use sites are currently commented out anyway).
    private static final List<DeferredBlock<Block>> RANDOM_INK = List.of(
        ModBlocks.AZURE_SEASTONE_MURAL_URCHINKIN,
        ModBlocks.AZURE_SEASTONE_MURAL_CINDARIA,
        ModBlocks.AZURE_SEASTONE_MURAL_HIPPOCAMTUS,
        ModBlocks.AZURE_SEASTONE_MURAL_CLAWDIAN,
        ModBlocks.AZURE_SEASTONE_MURAL_THUNDER,
        ModBlocks.AZURE_SEASTONE_MURAL_SEA,
        ModBlocks.AZURE_SEASTONE_MURAL_UNDERWORLD,
        ModBlocks.AZURE_SEASTONE_MURAL_HARVEST,
        ModBlocks.AZURE_SEASTONE_MURAL_WISDOM,
        ModBlocks.AZURE_SEASTONE_MURAL_SMITHING);

    public Ink_Mural_Block(BlockBehaviour.Properties properties) {
        super(properties);
    }

    // protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
//         if (!stack.is(Items.INK_SAC) && !stack.is(Items.WET_SPONGE)) {
//             return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
//         }
//         if (level.isClientSide()) {
//             return ItemInteractionResult.sidedSuccess((boolean)level.isClientSide());
//         }
//         Item item = stack.getItem();
//         boolean water = (Boolean)state.getValue((Property)WATERLOGGED);
//         AttachFace face = (AttachFace)state.getValue((Property)FACE);
//         Direction facing = (Direction)state.getValue((Property)FACING);
//         if (stack.is(Items.INK_SAC)) {
//             stack.consume(1, (LivingEntity)player);
//             BlockState mural = (BlockState)((BlockState)((BlockState)((Block)((DeferredBlock)Util.getRandom(RANDOM_INK, (RandomSource)level.getRandom())).get()).defaultBlockState().setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(water))).setValue((Property)FACE, (Comparable)face)).setValue((Property)FACING, (Comparable)facing);
//             level.setBlockAndUpdate(pos, mural);
//         }
//         if (level.getBlockState(pos).getBlock() != ModBlocks.AZURE_SEASTONE_MURAL_EMPTY.get() && stack.is(Items.WET_SPONGE)) {
//             level.setBlockAndUpdate(pos, (BlockState)((BlockState)((BlockState)((Block)ModBlocks.AZURE_SEASTONE_MURAL_EMPTY.get()).defaultBlockState().setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(water))).setValue((Property)FACE, (Comparable)face)).setValue((Property)FACING, (Comparable)facing));
//         }
//         player.awardStat(Stats.ITEM_USED.get((Object)item));
//         return ItemInteractionResult.sidedSuccess((boolean)level.isClientSide());
//     }
// }
}

