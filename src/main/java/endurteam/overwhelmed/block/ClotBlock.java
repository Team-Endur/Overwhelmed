package endurteam.overwhelmed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ClotBlock extends FallingBlock {

    public VoxelShape SHAPE = Block.createCuboidShape(6.0F, 0.0F, 6.0F, 10.0F, 2.0F, 10.0F);

    public ClotBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }

    public boolean canSurvive(BlockState state, BlockView world, BlockPos pos) {
        BlockPos belowPos = pos.down();
        BlockState blockBelow = world.getBlockState(belowPos);
        return blockBelow.isSolid();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

}