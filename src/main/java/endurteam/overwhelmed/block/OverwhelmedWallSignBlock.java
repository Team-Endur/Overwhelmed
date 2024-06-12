package endurteam.overwhelmed.block;

import endurteam.overwhelmed.entity.OverwhelmedSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class OverwhelmedWallSignBlock extends WallSignBlock {


    public OverwhelmedWallSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OverwhelmedSignBlockEntity(pos, state);
    }

}
