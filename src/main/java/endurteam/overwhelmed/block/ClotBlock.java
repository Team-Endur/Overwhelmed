package endurteam.overwhelmed.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.NotNull;

public class ClotBlock extends Block {

    public ClotBlock(Settings settings) {
        super(settings);
    }

    public boolean canSurvive(BlockState state, BlockView world, BlockPos pos) {
        BlockPos belowPos = pos.down();
        BlockState blockBelow = world.getBlockState(belowPos);
        return blockBelow.isSolid();
    }

    public @NotNull VoxelShape getShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createCuboidShape(6.0, 0.0, 6.0, 10.0, 2.0, 10.0);
    }

}