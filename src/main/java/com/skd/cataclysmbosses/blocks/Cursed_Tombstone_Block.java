/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Cursed_Tombstone_Block
extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private static final VoxelShape X_BASE = Block.box((double)5.0, (double)0.0, (double)0.0, (double)11.0, (double)2.0, (double)16.0);
    private static final VoxelShape Z_BASE = Block.box((double)0.0, (double)0.0, (double)5.0, (double)16.0, (double)2.0, (double)11.0);
    private static final VoxelShape X_MID = Block.box((double)6.0, (double)2.0, (double)1.0, (double)10.0, (double)24.0, (double)15.0);
    private static final VoxelShape Z_MID = Block.box((double)1.0, (double)2.0, (double)6.0, (double)15.0, (double)24.0, (double)10.0);
    private static final VoxelShape X_AXIS_AABB = Shapes.or((VoxelShape)X_BASE, (VoxelShape)X_MID);
    private static final VoxelShape Z_AXIS_AABB = Shapes.or((VoxelShape)Z_BASE, (VoxelShape)Z_MID);

    public static final MapCodec<Cursed_Tombstone_Block> CODEC = simpleCodec(Cursed_Tombstone_Block::new);

    public MapCodec<Cursed_Tombstone_Block> codec() {
        return CODEC;
    }

    public Cursed_Tombstone_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)LIT, (Comparable)Boolean.valueOf(false))).setValue((Property)POWERED, (Comparable)Boolean.valueOf(false)));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return (BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)p_48689_.getHorizontalDirection().getOpposite());
    }

    // public BlockState rotate(BlockState state, Rotation rot) {
//         return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
//     }

//     public BlockState mirror(BlockState state, Mirror mirrorIn) {
//         return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
//     }

//     protected ItemInteractionResult useItemOn(ItemStack p_316383_, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand p_316216_, BlockHitResult p_316827_) {
//         if (((Boolean)state.getValue((Property)POWERED)).booleanValue()) {
//             if (!((Boolean)state.getValue((Property)LIT)).booleanValue()) {
//                 state = (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(true));
//                 worldIn.setBlock(pos, state, 10);
//                 return ItemInteractionResult.SUCCESS;
//             }
//         } else {
//             player.displayClientMessage((Component)Component.translatable((String)"block.cataclysm.cursed_tombstone.message"), true);
//             return ItemInteractionResult.FAIL;
//         }
//         return ItemInteractionResult.FAIL;
//     }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING, LIT, POWERED);
    }

//     public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
//         Direction direction = (Direction)p_48816_.getValue((Property)FACING);
//         return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
//     }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Cursed_tombstone_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return Cursed_Tombstone_Block.createTickerHelper(p_152182_, (BlockEntityType)((BlockEntityType)ModTileentites.CURSED_TOMBSTONE.get()), Cursed_tombstone_Entity::commonTick);
    }
}

