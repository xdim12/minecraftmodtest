package net.xdim12.funmod.init.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class TouletBlock extends Block {
    public static final DirectionProperty FACING = Properties.HOPPER_FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public TouletBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, Boolean.valueOf(false)));
    }

    private static final VoxelShape Shape_W = Stream.of(
            Block.createCuboidShape(11.2, 6.4, 8.16, 12.8, 18.4, 9.76),
            Block.createCuboidShape(6.4, 6.4, 6.4, 11.2, 6.416, 9.6),
            Block.createCuboidShape(3.2, 0, 4, 14.4, 4.8, 12),
            Block.createCuboidShape(10.4, 4.8, 2.4, 16, 16, 13.6),
            Block.createCuboidShape(9.6, 16, 1.6, 16, 17.6, 14.4),
            Block.createCuboidShape(1.6, 4.8, 2.4, 10.4, 9.6, 4),
            Block.createCuboidShape(1.6, 4.8, 4, 3.2, 9.6, 12),
            Block.createCuboidShape(1.6, 4.8, 12, 10.4, 9.6, 13.6),
            Block.createCuboidShape(6.4, 4.8, 4, 11.2, 5.6, 6.4),
            Block.createCuboidShape(6.4, 4.8, 9.6, 11.2, 5.6, 12),
            Block.createCuboidShape(3.2, 4.8, 4, 11.2, 6.4, 12),
            Block.createCuboidShape(11.2, 6.4, 6.24, 12.8, 18.4, 7.84)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape Shape_E = Stream.of(
            Block.createCuboidShape(4.2, 6.4, 6.24, 5.8, 18.4, 7.84),
            Block.createCuboidShape(5.8, 6.4, 6.4, 10.6, 6.416, 9.6),
            Block.createCuboidShape(2.6, 0, 4, 13.8, 4.8, 12),
            Block.createCuboidShape(1, 4.8, 2.4, 6.6, 16, 13.6),
            Block.createCuboidShape(1, 16, 1.6, 7.4, 17.6, 14.4),
            Block.createCuboidShape(6.6, 4.8, 12, 15.4, 9.6, 13.6),
            Block.createCuboidShape(13.8, 4.8, 4, 15.4, 9.6, 12),
            Block.createCuboidShape(6.6, 4.8, 2.4, 15.4, 9.6, 4),
            Block.createCuboidShape(5.8, 4.8, 9.6, 10.6, 5.6, 12),
            Block.createCuboidShape(5.8, 4.8, 4, 10.6, 5.6, 6.4),
            Block.createCuboidShape(5.8, 4.8, 4, 13.8, 6.4, 12),
            Block.createCuboidShape(4.2, 6.4, 8.16, 5.8, 18.4, 9.76)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape Shape_N = Stream.of(
            Block.createCuboidShape(6.24, 6.4, 10.2, 7.84, 18.4, 11.8),
            Block.createCuboidShape(6.4, 6.4, 5.4, 9.6, 6.416, 10.2),
            Block.createCuboidShape(4, 0, 2., 12, 4.8, 13.4),
            Block.createCuboidShape(2, 4.8, 9.4, 13.6, 16, 15),
            Block.createCuboidShape(1.6, 16, 8.6, 14.4, 17.6, 15),
            Block.createCuboidShape(12, 4.8, 0.6, 13.6, 9.6, 9.4),
            Block.createCuboidShape(4, 4.8, 0.6, 12, 9.6, 2.2),
            Block.createCuboidShape(2.4, 4.8, 0.6, 4, 9.6, 9.4),
            Block.createCuboidShape(9.6, 4.8, 5.4, 12, 5.6, 10.2),
            Block.createCuboidShape(4, 4.8, 5.4, 6.4, 5.6, 10.2),
            Block.createCuboidShape(4, 4.8, 2.2, 12, 6.4, 10.2),
            Block.createCuboidShape(8.16, 6.4, 10.2, 9.76, 18.4, 11.8)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape Shape_S = Stream.of(
            Block.createCuboidShape(8.16, 6.4, 4, 9.76, 18.4, 5),
            Block.createCuboidShape(6.4, 6.4, 5, 9.6, 6.416, 10.6),
            Block.createCuboidShape(4, 0, 2, 12, 4.8, 13.8),
            Block.createCuboidShape(2.4, 4.8, 1, 13.6, 16, 6.6),
            Block.createCuboidShape(1.6, 16, 1, 14.4, 17.6, 7.4),
            Block.createCuboidShape(2.4, 4.8, 6.6, 4, 9.6, 15),
            Block.createCuboidShape(4, 4.8, 13.8, 12, 9.6, 15),
            Block.createCuboidShape(12, 4.8, 6.6, 13.6, 9.6, 15),
            Block.createCuboidShape(4, 4.8, 5, 6.4, 5.6, 10.6),
            Block.createCuboidShape(9.6, 4.8, 5, 12, 5.6, 10.6),
            Block.createCuboidShape(4, 4.8, 5, 12, 6.4, 13.8),
            Block.createCuboidShape(6.24, 6.4, 4, 7.84, 18.4, 5.)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)){
            case NORTH:
                return Shape_N;
            case WEST:
                return Shape_W;
            case SOUTH:
                return Shape_S;
            case EAST:
                return Shape_E;
            default:
                return Shape_W;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
}
