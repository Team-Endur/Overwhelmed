package endurteam.overwhelmed.block;

import endurteam.overwhelmed.block.entity.OverwhelmedSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class OverwhelmedSignBlock extends SignBlock {

    public OverwhelmedSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OverwhelmedSignBlockEntity(pos, state);
    }

}
