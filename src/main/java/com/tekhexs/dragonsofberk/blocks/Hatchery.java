package com.tekhexs.dragonsofberk.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class Hatchery extends Block implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public Hatchery(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    // TODO: Need to fix this later on but for now I'm removing it
    /*private static final Optional<VoxelShape> SHAPE =
            Stream.of(
                    Block.box(0.7507050000000017, 5.265, 0.31977522475543907, 15.310705, 11.7, 10.42727522475544),
                    Block.box(6.97808103226583, 5.2975, -3.1043892061717777, 13.47808103226583, 11.635, 0.14561079382822228),
                    Block.box(5.333205000000001, 5.265, -4.295224775244559, 10.728205, 11.6675, 0.5147752247554394),
                    Block.box(2.5743356814505027, 5.2975, -3.1261009198881133, 9.074335681450503, 11.635, 0.12389908011188666),
                    Block.box(9.520877504436328, 7.68686, -3.274985678342272, 12.690277504436327, 10.63403, -3.274985678342272),
                    Block.box(3.3621392092800075, 7.68686, -3.296697392058608, 6.531539209280007, 10.63403, -3.296697392058608),
                    Block.box(11.312255700930104, 3.899999999999999, 7.168972991843429, 13.132255700930104, 5.297499999999999, 12.10897299184343),
                    Block.box(2.9268170201156565, 3.899999999999999, 7.1572226970526565, 4.746817020115657, 5.297499999999999, 12.097222697052658),
                    Block.box(1.0432049999999986, 3.8025, 9.67977522475544, 15.050705, 5.33, 10.39477522475544),
                    Block.box(2.6682050000000004, 3.835, 1.6847752247554375, 13.393205000000002, 5.33, 10.394775224755438),
                    Block.box(4.553205000000002, 3.8675, -2.897724775244562, 11.540705, 5.33, 1.6847752247554393),
                    Block.box(1.3668170201156595, 3.899999999999999, -0.8702773029473434, 3.186817020115658, 5.297499999999999, 4.069722697052658),
                    Block.box(12.872255700930104, 3.899999999999999, -0.858527008156571, 14.692255700930104, 5.297499999999999, 4.08147299184343),
                    Block.box(2.2067049999999995, 5.944869781220332, 9.461443732302873, 13.822205, 12.139369781220331, 15.987443732302872),
                    Block.box(2.1742050000000006, 2.418, 13.63177522475544, 13.854705000000001, 8.1575, 16.225275224755435)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE.orElse(Shapes.block());
    }*/

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        boolean flag = pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER;;
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, flag);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }


    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}
