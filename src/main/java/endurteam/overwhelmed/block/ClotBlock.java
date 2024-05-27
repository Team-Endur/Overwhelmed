package endurteam.overwhelmed.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ClotBlock extends Block {

    public ClotBlock(Settings settings) {
        super(settings);
    }

    public boolean canSurvive(BlockState state, BlockView world, BlockPos pos) {
        BlockPos belowPos = pos.down();
        BlockState blockBelow = world.getBlockState(belowPos);
        return blockBelow.isSolid();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(6.0F, 0.0F, 6.0F, 10.0F, 2.0F, 10.0F);
    }

}