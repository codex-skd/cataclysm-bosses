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
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.SimpleMenuProvider
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.ContainerLevelAccess
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.skd.cataclysmbosses.inventory.WeaponfusionMenu;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mechanical_fusion_Anvil
extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final MapCodec<Mechanical_fusion_Anvil> CODEC = Mechanical_fusion_Anvil.simpleCodec(Mechanical_fusion_Anvil::new);
    private static final Component CONTAINER_TITLE = Component.translatable((String)"cataclysm.container.weapon_fusion");
    // public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape X_BASE = Block.box((double)1.0, (double)0.0, (double)3.0, (double)15.0, (double)3.0, (double)13.0);
    private static final VoxelShape Z_BASE = Block.box((double)3.0, (double)0.0, (double)1.0, (double)13.0, (double)3.0, (double)15.0);
    private static final VoxelShape X_LEG1 = Block.box((double)3.0, (double)3.0, (double)5.0, (double)13.0, (double)8.0, (double)11.0);
    private static final VoxelShape X_TOP = Block.box((double)1.0, (double)8.0, (double)0.0, (double)15.0, (double)13.0, (double)16.0);
    private static final VoxelShape Z_LEG1 = Block.box((double)5.0, (double)3.0, (double)3.0, (double)11.0, (double)8.0, (double)13.0);
    private static final VoxelShape Z_TOP = Block.box((double)0.0, (double)8.0, (double)1.0, (double)16.0, (double)13.0, (double)15.0);
    private static final VoxelShape X_AXIS_AABB = Shapes.or((VoxelShape)X_BASE, (VoxelShape[])new VoxelShape[]{X_LEG1, X_TOP});
    private static final VoxelShape Z_AXIS_AABB = Shapes.or((VoxelShape)Z_BASE, (VoxelShape[])new VoxelShape[]{Z_LEG1, Z_TOP});

    public MapCodec<Mechanical_fusion_Anvil> codec() {
        return CODEC;
    }

    public Mechanical_fusion_Anvil(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48781_) {
        return (BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)p_48781_.getHorizontalDirection().getClockWise());
    }

    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
        pPlayer.awardStat(Stats.INTERACT_WITH_SMITHING_TABLE);
        return InteractionResult.CONSUME;
    }

    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inv, player) -> new WeaponfusionMenu(i, inv, ContainerLevelAccess.create((Level)level, (BlockPos)pos)), CONTAINER_TITLE);
    }

    public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
        Direction direction = (Direction)p_48816_.getValue((Property)FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    public BlockState rotate(BlockState p_48811_, Rotation p_48812_) {
        return (BlockState)p_48811_.setValue((Property)FACING, (Comparable)p_48812_.rotate((Direction)p_48811_.getValue((Property)FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(new Property[]{FACING});
    }

    protected boolean isPathfindable(BlockState p_51023_, PathComputationType p_51026_) {
        return false;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Mechanical_fusion_Anvil_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return Mechanical_fusion_Anvil.createTickerHelper(p_152182_, (BlockEntityType)((BlockEntityType)ModTileentites.MECHANICAL_FUSION_ANVIL.get()), Mechanical_fusion_Anvil_Block_Entity::commonTick);
    }
}