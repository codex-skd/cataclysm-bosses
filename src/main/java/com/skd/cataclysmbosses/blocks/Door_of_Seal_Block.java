/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Holder
 *  net.minecraft.util.StringRepresentable
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.RenderShape
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
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.Nullable
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Door_of_Seal_Block
extends BaseEntityBlock {
    public static final MapCodec<Door_of_Seal_Block> CODEC = Door_of_Seal_Block.simpleCodec(Door_of_Seal_Block::new);
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final EnumProperty<Door_Of_Seal_Part> PART = EnumProperty.create((String)"door_part", Door_Of_Seal_Part.class);
    public static final IntegerProperty Y_OFFSET = IntegerProperty.create((String)"y_offset", (int)0, (int)7);
    private static final VoxelShape CLOSED_SHAPE = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);

    public MapCodec<Door_of_Seal_Block> codec() {
        return CODEC;
    }

    public Door_of_Seal_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)LIT, (Comparable)Boolean.valueOf(false))).setValue((Property)OPEN, (Comparable)Boolean.valueOf(false))).setValue(PART, (Comparable)((Object)Door_Of_Seal_Part.CENTER))).setValue((Property)Y_OFFSET, (Comparable)Integer.valueOf(0)));
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue((Property)FACING, (Comparable)rotation.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue((Property)FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49751_) {
        p_49751_.add(new Property[]{FACING, OPEN, LIT, PART, Y_OFFSET});
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Door_Of_Seal_BlockEntity(pos, state);
    }

    // protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    //     BlockPos basePos = this.getBasePos(state, pos);
    //     BlockState baseState = level.getBlockState(basePos);
    //     if (player.getItemInHand(hand).is((Item)ModItems.STRANGE_KEY.get())) {
    //         return this.onHit(level, baseState, new BlockHitResult(hit.getLocation().add((double)(basePos.getX() - pos.getX()), (double)(basePos.getY() - pos.getY()), (double)(basePos.getZ() - pos.getZ())), hit.getDirection(), basePos, hit.isInside()), player, hand, true) ? ItemInteractionResult.sidedSuccess((boolean)level.isClientSide()) : ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    //     }
    //     return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    // }

    public boolean onHit(Level p_49702_, BlockState blockState, BlockHitResult p_49704_, Player p_49705_, InteractionHand p_49726_, boolean p_49706_) {
        BlockPos blockpos = p_49704_.getBlockPos();
        if (p_49706_) {
            this.attemptToRing(p_49705_, p_49702_, p_49726_, blockState, blockpos);
            return true;
        }
        return false;
    }

    public boolean attemptToRing(Player p_152189_, Level p_152190_, InteractionHand p_49726_, BlockState blockState, BlockPos p_152191_) {
        BlockEntity blockentity = p_152190_.getBlockEntity(p_152191_);
        if (!p_152190_.isClientSide() && blockentity instanceof Door_Of_Seal_BlockEntity && !((Boolean)blockState.getValue((Property)LIT)).booleanValue()) {
            ((Door_Of_Seal_BlockEntity)blockentity).onHit(p_152190_);
            p_152190_.setBlock(p_152191_, (BlockState)blockState.setValue((Property)LIT, (Comparable)Boolean.valueOf(true)), 3);
            p_152190_.gameEvent((Entity)p_152189_, (Holder)GameEvent.BLOCK_CHANGE, p_152191_);
            return true;
        }
        return false;
    }

    private BlockPos getBasePos(BlockState state, BlockPos pos) {
        BlockPos toReturn = pos.below(((Integer)state.getValue((Property)Y_OFFSET)).intValue());
        if (state.getValue(PART) == Door_Of_Seal_Part.SIDE_LEFT) {
            toReturn = toReturn.relative(((Direction)state.getValue((Property)FACING)).getCounterClockWise());
        } else if (state.getValue(PART) == Door_Of_Seal_Part.SIDE_RIGHT) {
            toReturn = toReturn.relative(((Direction)state.getValue((Property)FACING)).getClockWise());
        }
        if (state.getValue(PART) == Door_Of_Seal_Part.END_LEFT) {
            toReturn = toReturn.relative(((Direction)state.getValue((Property)FACING)).getCounterClockWise(), 2);
        } else if (state.getValue(PART) == Door_Of_Seal_Part.END_RIGHT) {
            toReturn = toReturn.relative(((Direction)state.getValue((Property)FACING)).getClockWise(), 2);
        }
        return toReturn;
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152194_, BlockState p_152195_, BlockEntityType<T> p_152196_) {
        return Door_of_Seal_Block.createTickerHelper(p_152196_, (BlockEntityType)((BlockEntityType)ModTileentites.DOOR_OF_SEAL.get()), Door_Of_Seal_BlockEntity::tick);
    }

    public VoxelShape getShape(BlockState p_49755_, BlockGetter p_49756_, BlockPos p_49757_, CollisionContext p_49758_) {
        return CLOSED_SHAPE;
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    public VoxelShape getVisualShape(BlockState p_48735_, BlockGetter p_48736_, BlockPos p_48737_, CollisionContext p_48738_) {
        return Shapes.empty();
    }

    public VoxelShape getBlockSupportShape(BlockState p_253862_, BlockGetter p_254569_, BlockPos p_254197_) {
        if (((Boolean)p_253862_.getValue((Property)OPEN)).booleanValue()) {
            return Shapes.empty();
        }
        return CLOSED_SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState p_53396_, BlockGetter p_53397_, BlockPos p_53398_, CollisionContext p_53399_) {
        if (((Boolean)p_53396_.getValue((Property)OPEN)).booleanValue()) {
            return Shapes.empty();
        }
        return CLOSED_SHAPE;
    }

    public VoxelShape getOcclusionShape(BlockState p_53401_, BlockGetter p_53402_, BlockPos p_53403_) {
        return Shapes.empty();
    }

    protected boolean isPathfindable(BlockState p_51023_, PathComputationType p_51026_) {
        return false;
    }

    private boolean doesGongFitInDirection(BlockPos pos, Direction direction, Level level) {
        for (int i = 0; i <= 7; ++i) {
            BlockPos[] toBreakPoses;
            BlockPos abovePos = pos.above(i);
            BlockPos blockpos1 = abovePos.relative(direction.getClockWise());
            BlockPos blockpos2 = abovePos;
            BlockPos blockpos3 = abovePos.relative(direction.getCounterClockWise());
            BlockPos blockpos4 = abovePos.relative(direction.getClockWise(), 2);
            BlockPos blockpos5 = abovePos.relative(direction.getCounterClockWise(), 2);
            for (BlockPos toBreakPos : toBreakPoses = new BlockPos[]{blockpos1, blockpos2, blockpos3, blockpos4, blockpos5}) {
                BlockState blockstate = level.getBlockState(toBreakPos);
                if (blockstate.canBeReplaced()) continue;
                return false;
            }
        }
        return true;
    }

    @javax.annotation.Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockPos blockpos = context.getClickedPos();
        Direction.Axis direction$axis = direction.getAxis();
        if (direction$axis == Direction.Axis.Y) {
            Direction dir = context.getHorizontalDirection();
            BlockState blockstate = (BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)dir);
            if (blockstate.canSurvive((LevelReader)context.getLevel(), blockpos) && this.doesGongFitInDirection(blockpos, dir, context.getLevel())) {
                return blockstate;
            }
        } else {
            Direction dir = direction.getOpposite();
            BlockState blockstate1 = (BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)dir);
            if (blockstate1.canSurvive((LevelReader)context.getLevel(), context.getClickedPos()) && this.doesGongFitInDirection(context.getClickedPos(), dir, context.getLevel())) {
                return blockstate1;
            }
        }
        return null;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @javax.annotation.Nullable LivingEntity entity, ItemStack itemStack) {
        super.setPlacedBy(level, pos, state, entity, itemStack);
        if (!level.isClientSide()) {
            for (int i = 0; i < 8; ++i) {
                BlockPos abovePos = pos.above(i);
                BlockPos blockpos1 = abovePos.relative(((Direction)state.getValue((Property)FACING)).getClockWise());
                BlockPos blockpos2 = abovePos;
                BlockPos blockpos3 = abovePos.relative(((Direction)state.getValue((Property)FACING)).getCounterClockWise());
                BlockPos blockpos4 = abovePos.relative(((Direction)state.getValue((Property)FACING)).getClockWise(), 2);
                BlockPos blockpos5 = abovePos.relative(((Direction)state.getValue((Property)FACING)).getCounterClockWise(), 2);
                BlockState defaultGongPart = ((Block)ModBlocks.DOOR_OF_SEAL.get()).defaultBlockState();
                level.setBlock(blockpos1, (BlockState)((BlockState)((BlockState)defaultGongPart.setValue((Property)FACING, (Comparable)((Direction)state.getValue((Property)FACING)))).setValue(PART, (Comparable)((Object)Door_Of_Seal_Part.SIDE_LEFT))).setValue((Property)Y_OFFSET, (Comparable)Integer.valueOf(i)), 3);
                level.setBlock(blockpos3, (BlockState)((BlockState)((BlockState)defaultGongPart.setValue((Property)FACING, (Comparable)((Direction)state.getValue((Property)FACING)))).setValue(PART, (Comparable)((Object)Door_Of_Seal_Part.SIDE_RIGHT))).setValue((Property)Y_OFFSET, (Comparable)Integer.valueOf(i)), 3);
                level.setBlock(blockpos4, (BlockState)((BlockState)((BlockState)defaultGongPart.setValue((Property)FACING, (Comparable)((Direction)state.getValue((Property)FACING)))).setValue(PART, (Comparable)((Object)Door_Of_Seal_Part.END_LEFT))).setValue((Property)Y_OFFSET, (Comparable)Integer.valueOf(i)), 3);
                level.setBlock(blockpos5, (BlockState)((BlockState)((BlockState)defaultGongPart.setValue((Property)FACING, (Comparable)((Direction)state.getValue((Property)FACING)))).setValue(PART, (Comparable)((Object)Door_Of_Seal_Part.END_RIGHT))).setValue((Property)Y_OFFSET, (Comparable)Integer.valueOf(i)), 3);
                if (blockpos2 != pos) {
                    level.setBlock(blockpos2, (BlockState)((BlockState)((BlockState)defaultGongPart.setValue((Property)FACING, (Comparable)((Direction)state.getValue((Property)FACING)))).setValue(PART, (Comparable)((Object)Door_Of_Seal_Part.CENTER))).setValue((Property)Y_OFFSET, (Comparable)Integer.valueOf(i)), 3);
                }
                level.blockUpdated(abovePos, Blocks.AIR);
                state.updateNeighbourShapes((LevelAccessor)level, abovePos, 3);
            }
        }
    }

    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockPos basePos;
        BlockState baseState;
        if (!level.isClientSide() && player.isCreative() && (baseState = level.getBlockState(basePos = this.getBasePos(state, pos))).is((Block)ModBlocks.DOOR_OF_SEAL.get())) {
            for (int i = 0; i <= 7; ++i) {
                BlockPos[] toBreakPoses;
                BlockPos abovePos = basePos.above(i);
                BlockPos blockpos1 = abovePos.relative(((Direction)baseState.getValue((Property)FACING)).getClockWise());
                BlockPos blockpos2 = abovePos;
                BlockPos blockpos3 = abovePos.relative(((Direction)baseState.getValue((Property)FACING)).getCounterClockWise());
                BlockPos blockpos4 = abovePos.relative(((Direction)baseState.getValue((Property)FACING)).getClockWise(), 2);
                BlockPos blockpos5 = abovePos.relative(((Direction)baseState.getValue((Property)FACING)).getCounterClockWise(), 2);
                for (BlockPos toBreakPos : toBreakPoses = new BlockPos[]{blockpos1, blockpos2, blockpos3, blockpos4, blockpos5}) {
                    BlockState blockstate = level.getBlockState(toBreakPos);
                    if (!blockstate.is((Block)ModBlocks.DOOR_OF_SEAL.get())) continue;
                    level.setBlock(toBreakPos, Blocks.AIR.defaultBlockState(), 35);
                    level.levelEvent(player, 2001, toBreakPos, Block.getId((BlockState)blockstate));
                }
            }
            level.setBlock(basePos, Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, basePos, Block.getId((BlockState)baseState));
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    public static enum Door_Of_Seal_Part implements StringRepresentable
    {
        SIDE_LEFT("side_left"),
        SIDE_RIGHT("side_right"),
        END_LEFT("end_left"),
        END_RIGHT("end_right"),
        CENTER("center");

        private final String name;

        private Door_Of_Seal_Part(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}

